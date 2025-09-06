package hospital.presentacion.prescripcion.medicamentos;

import javax.swing.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

import hospital.presentacion.prescripcion.Model;
import hospital.presentacion.prescripcion.Controller;

public class View extends JDialog implements PropertyChangeListener {
    private JPanel medicamentosJPanel;
    private JComboBox comboBoxSearchMode;
    private JTextField buscar_textField;
    private JButton OKButton;
    private JButton cancelButton;
    private JButton buscarButton;
    private JTable medicamentosTable;

    public View() {
        setContentPane(medicamentosJPanel);
        setModal(true);
        getRootPane().setDefaultButton(OKButton);
        setLocationRelativeTo(null);
        setTitle("Medicamentos");
        setSize(400,250);

        //END OF VIEW
    }

    // ----- MVC ----- //
    Controller controller;
    Model model;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {

        }
    }
}
