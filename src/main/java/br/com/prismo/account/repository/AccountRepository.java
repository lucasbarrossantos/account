package br.com.prismo.account.repository;

import br.com.prismo.account.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository  extends JpaRepository<Account, Long> {

    Optional<Account> findByDocumentNumber(String aLong);

}
