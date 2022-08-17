package br.com.prismo.account.br.com.prismo.account.service;

import br.com.prismo.account.br.com.prismo.account.model.DataMock;
import br.com.prismo.account.domain.Account;
import br.com.prismo.account.domain.dto.AccountDTO;
import br.com.prismo.account.repository.AccountRepository;
import br.com.prismo.account.service.AccountService;
import br.com.prismo.account.utils.MapperUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

    @InjectMocks
    private AccountService accountService;
    @Mock
    private AccountRepository accountRepository;
    @Mock
    private MapperUtil mapperUtil;
    @Mock
    private MessageSource messageSource;

    private final DataMock mock = new DataMock();

    @DisplayName("Must save an account successfully")
    @Test
    void MustSaveAnAccountSuccessfully() {
        var accountDTO = mock.getAccountDTO();
        var account = mock.getAccount();

        Mockito.when(accountRepository.save(any(Account.class)))
                .thenReturn(account);

        Mockito.when(mapperUtil.convertTo(accountDTO, Account.class))
                .thenReturn(account);

        Mockito.when(mapperUtil.convertTo(account, AccountDTO.class))
                .thenReturn(accountDTO);

        AccountDTO result = accountService.save(accountDTO);

        assertNotNull(result);
        assertEquals(accountDTO.getDocumentNumber(), account.getDocumentNumber());
        Mockito.verify(accountRepository, Mockito.atLeastOnce()).save(account);
    }

    @DisplayName("Must find an account successfully")
    @Test
    void MustFindAnAccountSuccessfully() {
        var accountId = 1L;

        var accountDTO = mock.getAccountDTO();
        var account = mock.getAccount();

        Mockito.when(accountRepository.findById(accountId))
                .thenReturn(Optional.of(account));

        Mockito.when(mapperUtil.convertTo(account, AccountDTO.class))
                .thenReturn(accountDTO);

        AccountDTO result = accountService.findById(accountId);

        assertNotNull(result);
        assertEquals(accountDTO.getDocumentNumber(), account.getDocumentNumber());
        Mockito.verify(accountRepository, Mockito.atLeastOnce()).findById(accountId);
    }

    @DisplayName("Should throw exception EntityNotFoundException when trying to search for person that doesn't exist")
    @Test
    void shouldThrowEntityNotFoundException() {
        var accountId = 1L;
        Throwable exception = assertThrows(EntityNotFoundException.class, () -> {
            Mockito.when(accountRepository.findById(accountId)).thenReturn(Optional.empty());
            Mockito.when(messageSource.getMessage("error.entity-not-found",
                                            new Object[]{accountId}, LocaleContextHolder.getLocale()))
                    .thenReturn(String.format("Conta %s não encontrada ou não cadastrada", accountId));

            accountService.findById(accountId);
        });

        assertEquals(String.format("Conta %s não encontrada ou não cadastrada", accountId), exception.getMessage());
    }

}
