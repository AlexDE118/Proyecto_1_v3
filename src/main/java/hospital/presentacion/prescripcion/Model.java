package hospital.presentacion.prescripcion;

import hospital.logic.Medicamento;
import hospital.logic.Paciente;
import hospital.logic.Prescripcion;
import hospital.presentacion.AbstractModel;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class Model extends AbstractModel {
    Prescripcion current;
    List<Prescripcion> prescripciones;
    List<Medicamento> medicamentos;

    public static final String CURRENT = "prescripcion";
    public static final String LISTPrescripciones = "prescripciones";
    public static final String LISTMedicamentos = "medicamentos";
    public static final String PACIENTE = "paciente";

    public Model() {
        current = new Prescripcion();
        prescripciones = new ArrayList<>();
        medicamentos = new ArrayList<>();
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        super.addPropertyChangeListener(listener);
        firePropertyChange(CURRENT);
        firePropertyChange(LISTPrescripciones);
        firePropertyChange(LISTMedicamentos);
        firePropertyChange(PACIENTE);
    }

    public Prescripcion getCurrent() {
        return current;
    }

    public void setCurrent(Prescripcion prescripcion) {
        this.current = prescripcion;
        firePropertyChange(CURRENT);
        firePropertyChange(PACIENTE);
    }

    public List<Prescripcion> getPrescripciones() {
        return prescripciones;
    }

    public void setPrescripciones(List<Prescripcion> prescripciones) {
        this.prescripciones = prescripciones;
        firePropertyChange(LISTPrescripciones);
    }
}
