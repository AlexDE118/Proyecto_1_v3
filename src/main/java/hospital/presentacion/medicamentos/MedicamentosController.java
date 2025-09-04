package hospital.presentacion.medicamentos;

import hospital.logic.Medicamento;
import hospital.logic.Service;

public class MedicamentosController {
    ViewMedicamentos view;
    MedicamentosModel model;


    public MedicamentosController(ViewMedicamentos view,MedicamentosModel model){
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public void createMedicamentos(Medicamento e) throws Exception {
        Service.instance().createMedicamentos(e);
    }

    public void readMedicamentos(String id) throws Exception {
        Medicamento e = new Medicamento();
        e.setID(id);
        Service.instance().readMedicamentos(e);
    }

    public void loadMedicamentos(){
        model.setMedicamentos(Service.instance().loadListaMedicamentos());
    }
}
