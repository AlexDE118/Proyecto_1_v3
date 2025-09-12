package hospital.logic;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Farmaceuta extends Persona {
    //Atributos
    private String clave;
    //Constructores

    public Farmaceuta() {
        super("","");
        this.clave = "111";
    }
    public Farmaceuta(String nombre, String id, String clave) {
        super(nombre, id);
        this.clave = clave;
    }
    //Setters | Getters
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    //Metodos de la clase

    public String toString() {
        return nombre + " " + id + " " + clave;
    }
}
