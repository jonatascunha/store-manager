package br.com.aula.storemanager.model;
import javax.persistence.*;

@Entity
@Table (name = "customer")

public class Customer {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id", nullable = false)
    private long id;

    @Column (name = "name", nullable = false)
    private String name;

    @Column (name = "cpf", nullable = false)
    private long cpf;

    @Column (name = "pontos", nullable = false)
    private int score;

    @Column (name = "cellPhone", nullable = false)
    private long cellPhone;

    @Column (name = "adress", nullable = false)
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
