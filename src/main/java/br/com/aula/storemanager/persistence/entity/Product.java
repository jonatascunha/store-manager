package br.com.youtube.customer.persistence.entity;

import javax.persistence.*;
import java.util.function.Function;

@Entity
@Table (name = "product")
public class Product {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id", nullable = false)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "salesPrice", nullable = false)
    private double salesPrice;

    @Column(name = "code", nullable = false)
    private double costPrice;

    @Column(name = "description")
    private String description;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "vendorDescription", nullable = false)
    private String vendorDescription;

    @Column(name = "quantityProduct", nullable = false)
    private String quantityProduct;

    @Column(name = "productType", nullable = false)
    private String productType;

    public <R> R map(Function<Product, R> func) {
        return func.apply(this);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getVendorDescription() {
        return vendorDescription;
    }

    public void setVendorDescription(String vendorDescription) {
        this.vendorDescription = vendorDescription;
    }

    public String getQuantityProduct() {
        return quantityProduct;
    }

    public void setQuantityProduct(String quantityProduct) {
        this.quantityProduct = quantityProduct;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
}
