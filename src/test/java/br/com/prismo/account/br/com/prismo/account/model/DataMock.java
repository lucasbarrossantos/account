package br.com.prismo.account.br.com.prismo.account.model;

import br.com.prismo.account.domain.Account;
import br.com.prismo.account.domain.OperationsType;
import br.com.prismo.account.domain.Transaction;
import br.com.prismo.account.domain.dto.AccountDTO;
import br.com.prismo.account.domain.dto.TransactionDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DataMock {

    public AccountDTO getAccountDTO() {
        return new AccountDTO("12345678910", new BigDecimal("5000"));
    }

    public Account getAccount() {
        return new Account(1L, "12345678910", new BigDecimal("5000"));
    }

    public TransactionDTO getTransactionDTO() {
        return new TransactionDTO(1L, 1L, BigDecimal.TEN);
    }

    public OperationsType getOperationsType() {
        return new OperationsType(1L, "COMPRA A VISTA");
    }

    public Transaction getTransaction() {
        return new Transaction(1L, getAccount(), getOperationsType(), BigDecimal.TEN, LocalDateTime.now());
    }
}
