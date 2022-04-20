package br.com.aula.storemanager.service.mapper;


import br.com.aula.storemanager.model.request.ProductRequestDTO;
import br.com.aula.storemanager.model.response.ProductResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    ProductResponseDTO create(ProductRequestDTO productRequestDTO);

    Page<ProductResponseDTO> getAll(Pageable pageable);

    Optional<ProductResponseDTO> update(Long id, ProductRequestDTO productRequestDTO);

    Optional<ProductResponseDTO> getByid(Long id);

    List<ProductResponseDTO> getByPriceLessThan(double price);

    boolean delete(Long id);
}

