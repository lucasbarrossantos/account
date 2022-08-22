package br.com.prismo.account.service;

import br.com.prismo.account.domain.Account;
import br.com.prismo.account.domain.dto.AccountDTO;
import br.com.prismo.account.repository.AccountRepository;
import br.com.prismo.account.service.exception.DocumentDuplicatedException;
import br.com.prismo.account.utils.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Slf4j
@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private MapperUtil mapperUtil;

    @Autowired
    private MessageSource messageSource;

    public AccountDTO save(AccountDTO accountDTO) {
        validateAccount(accountDTO);
        var account = accountRepository.save(mapperUtil.convertTo(accountDTO, Account.class));
        return mapperUtil.convertTo(account, AccountDTO.class);
    }

    public AccountDTO findById(Long accountId) {
        Account account = searchOrFail(accountId);
        return mapperUtil.convertTo(account, AccountDTO.class);
    }

    public Account searchOrFail(Long accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new EntityNotFoundException(
                        messageSource
                                .getMessage("error.entity-not-found",
                                        new Object[]{accountId}, LocaleContextHolder.getLocale())
                ));
    }

    private void validateAccount(AccountDTO accountDTO) {
        var accountByDocument = accountRepository.findByDocumentNumber(accountDTO.getDocumentNumber());

        if (accountByDocument.isPresent())
            throw new DocumentDuplicatedException(messageSource
                    .getMessage("validation.document-duplicated",
                    new Object[]{accountDTO.getDocumentNumber()}, LocaleContextHolder.getLocale()));
    }
}
