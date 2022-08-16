package br.com.prismo.account.service;

import br.com.prismo.account.domain.dto.TransactionDTO;
import br.com.prismo.account.repository.OperationsTypeRepository;
import br.com.prismo.account.repository.TransactionRepository;
import br.com.prismo.account.utils.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
public class TransactionService {

    private final List<Long> COMPRA_SAQUE = Arrays.asList(1L, 2L, 3L);
    @Autowired
    private TransactionRepository repository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private OperationsTypeRepository operationsTypeRepository;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private MapperUtil mapperUtil;

    public TransactionDTO createNewTransaction(TransactionDTO transactionDTO) {
        validateTransaction(transactionDTO);
        checkOperationType(transactionDTO);
        var transaction = repository.save(mapperUtil.toEntity(transactionDTO));
        return mapperUtil.toDTO(transaction);
    }

    private void checkOperationType(TransactionDTO transactionDTO) {
        if (COMPRA_SAQUE.contains(transactionDTO.getOperationTypeId())) { // Operações de compra e saque
            transactionDTO.setAmount(transactionDTO.getAmount().multiply(new BigDecimal(-1)));
        }
    }

    private void validateTransaction(TransactionDTO transactionDTO) {
        accountService.searchOrFail(transactionDTO.getAccountId());
        searchOrFailOperationType(transactionDTO.getOperationTypeId());
    }

    private void searchOrFailOperationType(Long operationTypeId) {
        operationsTypeRepository.findById(operationTypeId)
                .orElseThrow(() -> new EntityNotFoundException(
                        messageSource
                                .getMessage("error.operation-type-not-found",
                                        new Object[]{operationTypeId}, LocaleContextHolder.getLocale())
                ));
    }
}
