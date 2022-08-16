package br.com.prismo.account.utils;

import br.com.prismo.account.domain.Account;
import br.com.prismo.account.domain.OperationsType;
import br.com.prismo.account.domain.Transaction;
import br.com.prismo.account.domain.dto.TransactionDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MapperUtil {

    private MapperUtil() {}

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public <D> D convertTo(Object bean, Class<D> target) {
        return objectMapper.convertValue(bean, target);
    }

    public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> convertTo(element, targetClass))
                .collect(Collectors.toList());
    }

    public void copyProperties(Object bean, Object target, String... ignoreProperties) {
        BeanUtils.copyProperties(bean, target, ignoreProperties);
    }

    public Transaction toEntity(final TransactionDTO transactionDTO) {
       var transaction = new Transaction();
       var account = new Account();
       var operationType = new OperationsType();

       account.setAccountId(transactionDTO.getAccountId());
       transaction.setAccount(account);

       operationType.setOperationTypeId(transactionDTO.getOperationTypeId());
       transaction.setOperationType(operationType);

       transaction.setAmount(transactionDTO.getAmount());
       return transaction;
    }

    public TransactionDTO toDTO(final Transaction transaction) {
        var transactionDTO = new TransactionDTO();
        transactionDTO.setAmount(transaction.getAmount());
        transactionDTO.setOperationTypeId(transaction.getOperationType().getOperationTypeId());
        transactionDTO.setAccountId(transaction.getAccount().getAccountId());
        return transactionDTO;
    }

}