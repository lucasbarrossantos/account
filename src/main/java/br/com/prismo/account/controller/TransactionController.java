package br.com.prismo.account.controller;

import br.com.prismo.account.controller.spec.TransactionControllerSpec;
import br.com.prismo.account.domain.dto.TransactionDTO;
import br.com.prismo.account.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/transactions")
public class TransactionController implements TransactionControllerSpec {

    @Autowired
    private TransactionService transactionService;

    @Override
    @PostMapping
    public ResponseEntity<TransactionDTO> createNewTransaction(@RequestBody TransactionDTO transactionDTO) {
        return ResponseEntity.ok(transactionService.createNewTransaction(transactionDTO));
    }

}
