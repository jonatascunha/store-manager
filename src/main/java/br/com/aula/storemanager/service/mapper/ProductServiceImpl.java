package br.com.aula.storemanager.service.mapper;

import br.com.aula.storemanager.model.request.ProductRequestDTO;
import br.com.aula.storemanager.model.response.ProductResponseDTO;
import br.com.aula.storemanager.persistence.entity.Product;
import br.com.aula.storemanager.persistence.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.util.Assert.notNull;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductResponseDTO create(ProductRequestDTO productRequestDTO) {
        LOGGER.info("Criando um registro do cliente");
        notNull(productRequestDTO, "Request Inválida");
        Product product = modelMapper.map(productRequestDTO, Product.class);
        product = productRepository.saveAndFlush(product);
        return modelMapper.map(product, ProductResponseDTO.class);
    }


    @Override
    public Page<ProductResponseDTO> getAll(Pageable pageable) {
        return productRepository.findAll(pageable)
                .map(product -> modelMapper.map(product, ProductResponseDTO.class));
    }

    @Override
    public Optional<ProductResponseDTO> update(Long id, ProductRequestDTO productRequest) {
        LOGGER.info("Atualizando o registro");
        notNull(id, "ID Inválido");
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            product.get().setCostPrice(productRequest.getCostPrice());
            product.get().setSalesPrice(productRequest.getSalesPrice());
            product.get().setDescription(productRequest.getDescription());
            product.get().setVendorDescription(productRequest.getVendorDescription());

            Product updateProduct = productRepository.saveAndFlush(product.get());
            return Optional.of(modelMapper.map(updateProduct, ProductResponseDTO.class));
        }
        return Optional.empty();
    }

    @Override
    public Optional<ProductResponseDTO> getByid(Long id) {
        LOGGER.info("Buscando registro");
        notNull(id, "ID Inválido");
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            ProductResponseDTO dto = modelMapper.map(product, ProductResponseDTO.class);
            return Optional.of(dto);
        }
        return Optional.empty();
    }

    @Override
    public List<ProductResponseDTO> getByPriceLessThan(double price) {
        return productRepository.findAllBySalesPrice(price)
                .stream()
                .map(p -> modelMapper.map(p, ProductResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public boolean delete(Long id) {
        LOGGER.info("Removendo registro");
        notNull(id, "ID inválido");

        try {
            productRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            LOGGER.warn("Erro ao remover o registro {}", id);
        }

        return false;
    }

}