package br.com.prismo.account.repository;

import br.com.prismo.account.domain.OperationsType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationsTypeRepository extends JpaRepository<OperationsType, Long> {

}
