package hospital.presentacion.prescripcion;

import hospital.logic.Prescripcion;
import hospital.logic.Service;
import hospital.logic.Paciente;
import hospital.logic.Receta;

public class Controller {
    View view;
    Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public void createPrescripcion(Prescripcion prescripcion) throws Exception {
        prescripcion.setPaciente(model.getCurrent().getPaciente());
        prescripcion.setReceta(model.getCurrent().getReceta());
        model.setCurrent(new Prescripcion());
    }
}
