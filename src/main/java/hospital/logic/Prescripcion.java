package hospital.logic;

import java.util.ArrayList;
import java.util.List;

public class Prescripcion {
    Paciente paciente;
    List<Receta> receta;

    public Prescripcion(){
        paciente = new Paciente();
        receta = new ArrayList<Receta>();
    }

    public Prescripcion(Paciente paciente, List<Receta> receta) {
        this.paciente = paciente;
        this.receta = receta;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public List<Receta> getReceta() {
        return receta;
    }

    public void setReceta(List<Receta> receta) {
        this.receta = receta;
    }


}
