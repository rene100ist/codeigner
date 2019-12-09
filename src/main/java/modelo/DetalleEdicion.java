
package modelo;



public class DetalleEdicion {
    // APLICANDO TRIGGER
    private int id;
    private String fecha;
    private String newComp;
    private String oldComp;
    private String coleccion;
    private String oldColeccion;

    public DetalleEdicion(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


    public String getNewComp() {
        return newComp;
    }

    public void setNewComp(String newComp) {
        this.newComp = newComp;
    }

    public String getOldComp() {
        return oldComp;
    }

    public void setOldComp(String oldComp) {
        this.oldComp = oldComp;
    }

    public String getColeccion() {
        return coleccion;
    }

    public void setColeccion(String coleccion) {
        this.coleccion = coleccion;
    }

    public String getOldColeccion() {
        return oldColeccion;
    }

    public void setOldColeccion(String oldColeccion) {
        this.oldColeccion = oldColeccion;
    }

    
    
    
}
