package hospital.logic;


public class Paciente extends Persona {//aa

    //Attritubtos

    private String fechaNacimiento;
    private String numeroTelefono;

    //Constructores

    public Paciente() {
        super("","");
        this.fechaNacimiento = "";
        this.numeroTelefono = "0000-0000";
    }
    public Paciente(String nombre, String id, String fechaNacimiento, String numeroTelefono) {
        super(nombre, id);
        this.fechaNacimiento = fechaNacimiento;
        this.numeroTelefono = numeroTelefono;
    }

    //Setters | Getters

    //public Fecha getFechaNacimiento() { return fechaNacimiento; }
    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    //public void setFechaNacimiento(Fecha fechaNacimiento) {this.fechaNacimiento = fechaNacimiento; }
    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    //Metodos de la clase
    public String toString() {
        return this.nombre + "\n"
                + this.id + "\n"
    //            + this.fechaNacimiento.toString() + "\n"
                + this.numeroTelefono;
    }
}
