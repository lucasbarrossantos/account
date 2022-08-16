package br.com.prismo.account.controller;

import br.com.prismo.account.domain.dto.AccountDTO;
import br.com.prismo.account.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountDTO> createNewAccount(@RequestBody @Valid AccountDTO accountDTO) {
        return ResponseEntity.ok(accountService.save(accountDTO));
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<AccountDTO> getById(@PathVariable Long accountId) {
        return ResponseEntity.ok(accountService.findById(accountId));
    }

}
