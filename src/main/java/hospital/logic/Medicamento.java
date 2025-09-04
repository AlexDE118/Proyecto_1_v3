package hospital.logic;

public class Medicamento {
    //Atributos
    private String ID;
    private String nombre;
    private double presentacion;

    //Constructores

    public Medicamento() {
        this.ID = "";
        this.nombre = "";
        this.presentacion = 0;
    }

    public Medicamento(String ID, String nombre, double presentacion) {
        this.ID = ID;
        this.nombre = nombre;
        this.presentacion = presentacion;
    }

    //Setters | Getters

    public String getID() {
        return ID;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPresentacion() {
        return presentacion;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPresentacion(double presentacion) {
        this.presentacion = presentacion;
    }
    //Metodos de la clase

    public String toString() {
        return ID + " " + nombre + " " + presentacion;
    }
}
