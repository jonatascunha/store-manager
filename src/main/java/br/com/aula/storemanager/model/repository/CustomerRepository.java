package br.com.aula.storemanager.model.repository;

import br.com.aula.storemanager.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository <Customer, Long> {
}
