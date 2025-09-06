package hospital.presentacion.prescripcion;

import hospital.logic.Paciente;
import hospital.logic.Medicamento;
import hospital.logic.Prescripcion;
import hospital.logic.Receta;
import hospital.presentacion.AbstractModel;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class Model extends AbstractModel {
    Prescripcion current;
    List<Paciente>  pacientes;

    public static final String CURRENT = "current";
    public static final String PACIENTS = "pacientes";
    public static final String PACIENT = "paciente";

    public Model() {
        current = new Prescripcion();
        pacientes = new ArrayList<Paciente>();
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        super.addPropertyChangeListener(listener);
        firePropertyChange(CURRENT);
        firePropertyChange(PACIENTS);
        firePropertyChange(PACIENT);
    }

    public Prescripcion getCurrent() {
        return current;
    }

    public void setCurrent(Prescripcion current) {
        this.current = current;
        firePropertyChange(CURRENT);
        firePropertyChange(PACIENT);
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes){
        this.pacientes = pacientes;
        firePropertyChange(PACIENTS);
    }

    public void setPaciente(Paciente paciente){
        this.current.setPaciente(paciente);
        firePropertyChange(PACIENT);
    }
}
