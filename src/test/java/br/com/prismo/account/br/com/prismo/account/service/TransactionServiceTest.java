package br.com.prismo.account.br.com.prismo.account.service;

import br.com.prismo.account.br.com.prismo.account.model.DataMock;
import br.com.prismo.account.domain.Transaction;
import br.com.prismo.account.repository.OperationsTypeRepository;
import br.com.prismo.account.repository.TransactionRepository;
import br.com.prismo.account.service.AccountService;
import br.com.prismo.account.service.TransactionService;
import br.com.prismo.account.utils.MapperUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.MessageSource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {

    @InjectMocks
    private TransactionService transactionService;

    @Mock
    private TransactionRepository repository;

    @Mock
    private AccountService accountService;

    @Mock
    private OperationsTypeRepository operationsTypeRepository;

    @Mock
    private MessageSource messageSource;

    @Mock
    private MapperUtil mapperUtil;

    private final DataMock mock = new DataMock();

    @DisplayName("Deve criar uma transação com sucesso")
    @Test
    void criarTransacaoComSucesso() {
        var transactionDTO = mock.getTransactionDTO();
        var transaction = mock.getTransaction();
        var account = mock.getAccount();
        var operationType = mock.getOperationsType();

        Mockito.when(accountService.searchOrFail(transactionDTO.getAccountId()))
                .thenReturn(account);

        Mockito.when(operationsTypeRepository.findById(anyLong()))
                .thenReturn(Optional.of(operationType));

        Mockito.when(repository.save(any(Transaction.class)))
                        .thenReturn(transaction);

        Mockito.when(mapperUtil.toEntity(transactionDTO))
                .thenReturn(transaction);

        Mockito.when(mapperUtil.toDTO(transaction))
                .thenReturn(transactionDTO);

        var result = transactionService.createNewTransaction(transactionDTO);

        assertNotNull(result);
        assertEquals(transactionDTO.getAmount(), result.getAmount());
        Mockito.verify(repository, Mockito.atLeastOnce()).save(transaction);
    }

}
