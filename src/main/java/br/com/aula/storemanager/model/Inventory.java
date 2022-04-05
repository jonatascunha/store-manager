package br.com.aula.storemanager.model;
import javax.persistence.*;

@Entity
@Table (name = "inventory")
public class Inventory {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id", nullable = false)
    private long id;

    @Column (name = "finalUpdated", nullable = false)
    private long finalUpdated;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFinalUpdated() {
        return finalUpdated;
    }

    public void setFinalUpdated(long finalUpdated) {
        this.finalUpdated = finalUpdated;
    }
}
