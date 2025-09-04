package hospital.presentacion.farmaceuta;

import hospital.logic.Service;
import hospital.logic.Farmaceuta;

import java.util.List;
import hospital.logic.Farmaceuta;

public class Controller {
    View view;
    Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
        model.addPropertyChangeListener(view);
    }

    public void readFarmaceuta(String id) throws Exception{
        Farmaceuta farmaceuta = new Farmaceuta();
    }

    public void createFarmaceuta(Farmaceuta farmaceuta) throws Exception{
        Farmaceuta farmaceuta1 = new Farmaceuta();
        Service.instance().createFarmaceuta(farmaceuta);
    }

    public void loadFarmaceutas(){
        List<Farmaceuta> farmaceutas = Service.instance().loadListaFarmaceutas();
        model.setListaFarmaceuta(farmaceutas);
    }

    public void deleteFarmaceuta(Farmaceuta farmaceuta) throws Exception{

    }

    public void searchFarmaceuta(String nombre, String id){
        Farmaceuta farmaceuta = new Farmaceuta();
        farmaceuta.setNombre(nombre);
        farmaceuta.setId(id);

        List<Farmaceuta> resultado = Service.instance().searchFarmaceuta(farmaceuta);
        model.setListaFarmaceuta(resultado);
    }
}
