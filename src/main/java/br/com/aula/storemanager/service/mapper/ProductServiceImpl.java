package br.com.aula.storemanager.service.mapper;

import br.com.aula.storemanager.model.request.ProductRequestDTO;
import br.com.aula.storemanager.model.response.ProductResponseDTO;
import br.com.aula.storemanager.persistence.entity.Product;
import br.com.aula.storemanager.persistence.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.util.Assert.notNull;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private Mapper<ProductRequestDTO, Product> requestMapper;

    @Autowired
    private Mapper<Product, ProductResponseDTO> responseMapper;

    @Override
    public ProductResponseDTO create(ProductRequestDTO productRequestDTO) {
        LOGGER.info("Criando um registro do cliente");
        notNull(productRequestDTO, "Request Inválida");
        Product product = this.requestMapper.map(productRequestDTO);
        return productRepository.saveAndFlush(product).map((Product input) -> this.responseMapper.map(input));
    }

    @Override
    public Page<ProductResponseDTO> getAll(Pageable pageable) {
        LOGGER.info("Buscando todos os registros");
        notNull(pageable, "Página inválida");
        return productRepository.findAll(pageable).map(product -> this.responseMapper.map(product));
    }

    @Override
    public Optional<ProductResponseDTO> update(Long id, ProductRequestDTO productRequest) {
        LOGGER.info("Atualizando o registro");
        notNull(id, "ID Inválido");

        Product productUpdate = this.requestMapper.map(productRequest);

        return productRepository.findById(id)
                .map(product -> {
                    product.setName(productUpdate.getName());
                    product.setProductType(productUpdate.getProductType());
                    product.setQuantityProduct(productUpdate.getQuantityProduct());
                    product.setId(productUpdate.getId());
                    product.setBrand(productUpdate.getBrand());
                    product.setCostPrice(productUpdate.getCostPrice());
                    product.setDescription(productUpdate.getDescription());
                    product.setSalesPrice(productUpdate.getSalesPrice());
                    product.setVendorDescription(productUpdate.getVendorDescription());
                    return this.responseMapper.map(productRepository.saveAndFlush(product));
                });
    }

    @Override
    public Optional<ProductResponseDTO> get(Long id) {
        LOGGER.info("Buscando registro");
        notNull(id, "ID Inválido");
        return productRepository.findById(id).map(this.responseMapper::map);
    }

    @Override
    public boolean delete(Long id) {
        LOGGER.info("Removendo registro");
        notNull(id, "ID inválido");

        try{
            productRepository.deleteById(id);
            return true;
        }catch (Exception e){
            LOGGER.warn("Erro ao remover o registro {}", id);
        }

        return false;
    }

}