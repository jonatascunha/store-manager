package br.com.aula.storemanager.model.repository;

import br.com.aula.storemanager.model.Finance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinanceRepository extends JpaRepository <Finance, Long> {
}
