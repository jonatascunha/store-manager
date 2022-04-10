package br.com.aula.storemanager.dto;

public class InventoryRequestDTO {

    private long id;
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
