package modelo.entidades;

public class Item {
	
    private int idItem;
    private String nombreItem;
    private String tipoItem; // BIEN o SERVICIO

    public Item(int idItem, String nombreItem, String tipoItem) {
        this.idItem = idItem;
        this.nombreItem = nombreItem;
        this.tipoItem = tipoItem;
    }

    // Getters y setters
    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public String getNombreItem() {
        return nombreItem;
    }

    public void setNombreItem(String nombreItem) {
        this.nombreItem = nombreItem;
    }

    public String getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(String tipoItem) {
        this.tipoItem = tipoItem;
    }
}