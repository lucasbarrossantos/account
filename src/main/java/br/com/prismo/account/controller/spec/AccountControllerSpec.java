package br.com.prismo.account.controller.spec;

import br.com.prismo.account.domain.Account;
import br.com.prismo.account.domain.dto.AccountDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

import javax.persistence.EntityNotFoundException;

@Api(value = "Account Spec", tags = "Account")
public interface AccountControllerSpec {


    @ApiOperation(value = "Create a new account", nickname = "create")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Unexpected Error"),
            @ApiResponse(code = 200, message = "Ok", response = AccountDTO.class)
    })
    ResponseEntity<AccountDTO> createNewAccount(AccountDTO accountDTO);

    @ApiOperation(value = "Find account by id", nickname = "getById")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Unexpected Error"),
            @ApiResponse(code = 200, message = "Ok", response = Account.class),
            @ApiResponse(code = 404, message = "Conta não encontrada ou não cadastrada", response = EntityNotFoundException.class)
    })
    ResponseEntity<AccountDTO> getById(Long accountId);

}
