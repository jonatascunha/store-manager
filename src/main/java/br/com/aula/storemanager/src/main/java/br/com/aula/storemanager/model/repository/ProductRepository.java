package br.com.aula.storemanager.model.repository;

import br.com.aula.storemanager.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <Product, Long> {
}
