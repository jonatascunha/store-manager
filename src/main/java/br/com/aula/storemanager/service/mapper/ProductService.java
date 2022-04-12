package br.com.youtube.customer.service;

import br.com.youtube.customer.model.request.ProductRequestDTO;
import br.com.youtube.customer.model.response.ProductResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProductService {

    ProductResponseDTO create(ProductRequestDTO productRequestDTO);

    Page<ProductResponseDTO> getAll(Pageable pageable);

    Optional<ProductResponseDTO> update(Long id, ProductRequestDTO productRequestDTO);

    Optional<ProductResponseDTO> get(Long id);

    boolean delete(Long id);
}

