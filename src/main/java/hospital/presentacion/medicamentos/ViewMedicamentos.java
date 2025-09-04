package hospital.presentacion.medicamentos;

//import javax.swing.*;
//import java.beans.PropertyChangeEvent;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ViewMedicamentos implements PropertyChangeListener{
    private JPanel PanelMedicamentos;
    private JTable listaMedicamentos_Table;
    private JButton cargarListaButton;

    public JPanel getPanelMedicamentos() {
        return PanelMedicamentos;
    }

    public ViewMedicamentos(){
//        cargarListaButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e){
//                controller.loadMedicamentos();
//            }
//        });
    }

    //============== MVC ==============//
    MedicamentosController controller;
    MedicamentosModel model;

    public void setController(MedicamentosController controller) {
        this.controller = controller;
    }
    public void setModel(MedicamentosModel model) {
         this.model = model;
        model.addPropertyChangeListener(this);
    }

    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case MedicamentosModel.LISTAMEDICAMENTOS:
                int[] cols = {MedicamentosTableModel.ID, MedicamentosTableModel.NOMBRE , MedicamentosTableModel.PRESENTACION};
                MedicamentosTableModel tableModel = new MedicamentosTableModel(cols, model.getMedicamentos());
                listaMedicamentos_Table.setModel(tableModel);
                listaMedicamentos_Table.updateUI();
                break;
        }
    }

}
