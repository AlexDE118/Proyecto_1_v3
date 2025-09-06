package hospital.presentacion.prescripcion;

import hospital.logic.Paciente;
import hospital.logic.Prescripcion;
import hospital.logic.Service;

import java.util.List;

public class Controller {
    View view;
    Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);

        List<Paciente> allPatients = Service.instance().loadListaPacientes();
        System.out.println("Loaded " + allPatients.size() + " patients");
        model.setPacientes(allPatients);
        model.setPacientes(Service.instance().searchPaciente(new Paciente()));
    }

    public void createPrescripcion(Prescripcion prescripcion) throws Exception {
        prescripcion.setPaciente(model.current.getPaciente());
        Service.instance().createPrescripcion(prescripcion);
        model.setCurrent(new Prescripcion());
        model.setPacientes(Service.instance().loadListaPacientes());
    }

    public void clear(){
        model.setCurrent(new  Prescripcion());
    }

    public void setPaciente(int row){
        model.setPaciente(model.getPacientes().get(row));
    }

    public void searchPacientes(String nombre){
        Paciente paciente = new Paciente();
        paciente.setNombre(nombre);
        model.setPacientes(Service.instance().searchPaciente(paciente));
    }
}
