package br.com.aula.storemanager.model;
import javax.persistence.*;

@Entity
@Table (name = "finance")
public class Finance {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;
    //O intelij informou que deveriamos ter um "id" na entidade finance (estava dando erro), porém não entendemos muito bem o motivo.

    @Column(name = "cost", nullable = false)
    private double cost;

    @Column(name = "grossRevenue", nullable = false)
    private double grossRevenue;

    @Column(name = "netRevenue", nullable = false)
    private double netRevenue;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getGrossRevenue() {
        return grossRevenue;
    }

    public void setGrossRevenue(double grossRevenue) {
        this.grossRevenue = grossRevenue;
    }

    public double getNetRevenue() {
        return netRevenue;
    }

    public void setNetRevenue(double netRevenue) {
        this.netRevenue = netRevenue;
    }
}
