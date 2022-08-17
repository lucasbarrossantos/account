package br.com.prismo.account.br.com.prismo.account.model;

import br.com.prismo.account.domain.Account;
import br.com.prismo.account.domain.dto.AccountDTO;

public class DataMock {

    public AccountDTO getAccountDTO() {
        return new AccountDTO("12345678910");
    }

    public Account getAccount() {
        return new Account(1L, "12345678910");
    }
}
