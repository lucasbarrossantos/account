package br.com.prismo.account.controller.spec;

import br.com.prismo.account.domain.dto.TransactionDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

import javax.persistence.EntityNotFoundException;

@Api(value = "Transactions Spec", tags = "Transactions")
public interface TransactionControllerSpec {

    @ApiOperation(value = "Create a new transaction", nickname = "createNewTransaction")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Unexpected Error"),
            @ApiResponse(code = 200, message = "Ok", response = TransactionDTO.class),
            @ApiResponse(code = 404, message = "Conta/Operação não encontrada ou não cadastrada", response = EntityNotFoundException.class)
    })
    ResponseEntity<TransactionDTO> createNewTransaction(TransactionDTO transactionDTO);

}
