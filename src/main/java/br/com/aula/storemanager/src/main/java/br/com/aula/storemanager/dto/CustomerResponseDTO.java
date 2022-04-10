package br.com.aula.storemanager.dto;

public class CustomerResponseDTO {

    private long id;
    private String name;
    private long cpf;
    private String favoriteProduct;
    private int score;
    private long cellPhone;
    private String adress;

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

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getFavoriteProduct() {
        return favoriteProduct;
    }

    public void setFavoriteProduct(String favoriteProduct) {
        this.favoriteProduct = favoriteProduct;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public long getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(long cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
