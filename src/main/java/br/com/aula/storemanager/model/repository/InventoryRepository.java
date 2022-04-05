package br.com.aula.storemanager.model.repository;

import br.com.aula.storemanager.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository <Inventory, Long> {
}
