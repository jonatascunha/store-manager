package br.com.youtube.customer.service.mapper;

import br.com.youtube.customer.model.response.ProductResponseDTO;
import br.com.youtube.customer.persistence.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductResponseMapper implements Mapper<Product, ProductResponseDTO>{

    @Override
    public ProductResponseDTO map(Product input) {
        if (input == null) {
            return null;
        }
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setName(input.getName());
        productResponseDTO.setProductType(input.getProductType());
        productResponseDTO.setQuantityProduct(input.getQuantityProduct());
        productResponseDTO.setBrand(input.getBrand());
        productResponseDTO.setId(input.getId());
        productResponseDTO.setCostPrice(input.getCostPrice());
        productResponseDTO.setSalesPrice(input.getSalesPrice());
        productResponseDTO.setVendorDescription(input.getVendorDescription());
        productResponseDTO.setDescription(input.getDescription());
        return productResponseDTO;
    }

}