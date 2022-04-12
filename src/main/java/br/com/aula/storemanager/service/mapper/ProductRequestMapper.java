package br.com.youtube.customer.service.mapper;

import br.com.youtube.customer.model.request.ProductRequestDTO;
import br.com.youtube.customer.persistence.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductRequestMapper implements Mapper<ProductRequestDTO, Product> {

    @Override
    public Product map(ProductRequestDTO input) {
        if(input == null) {
            return null;
        }
        Product product = new Product();
        product.setName(input.getName());
        product.setProductType(input.getProductType());
        product.setQuantityProduct(input.getQuantityProduct());
        product.setBrand(input.getBrand());
        product.setId(input.getId());
        product.setCostPrice(input.getCostPrice());
        product.setSalesPrice(input.getSalesPrice());
        product.setVendorDescription(input.getVendorDescription());
        product.setDescription(input.getDescription());

        return product;
    }
}

