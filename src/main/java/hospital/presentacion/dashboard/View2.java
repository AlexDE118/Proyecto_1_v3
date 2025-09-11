package hospital.presentacion.dashboard;

import com.github.lgooddatepicker.components.DatePicker;
import hospital.data.Listas;
import hospital.logic.Medicamento;
import hospital.logic.Prescripcion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

public class View2 implements java.beans.PropertyChangeListener {
    private JPanel dashboard_JPanel;
    private JComboBox<String> medicamentos_comboBox;
    private JButton mostrarButton;
    private JTable table1;
    private DatePicker fechaDesde;
    private DatePicker fechaHasta;

    private Controller controller;
    private Model model;

    public JPanel getDashboard_JPanel() {
        return dashboard_JPanel;
    }

    public View2() {
        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalDate desde = fechaDesde.getDate();
                LocalDate hasta = fechaHasta.getDate();
                String medicamento = (String) medicamentos_comboBox.getSelectedItem();

                try {
                    controller.cargarPrescripciones(desde, hasta, medicamento);
                    // ya no mostramos JOptionPane, la tabla se actualizará automáticamente
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(dashboard_JPanel,
                            "Error cargando prescripciones: " + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void setModel(Model model) {
        this.model = model;
        this.model.addPropertyChangeListener(this);

        // llenar combobox con los medicamentos disponibles + "Todos"
        Listas listas = new Listas();

        
        listas.getMedicamentos().forEach(m -> {
            String nombre = m.getNombre();
            if (((DefaultComboBoxModel<String>) medicamentos_comboBox.getModel()).getIndexOf(nombre) == -1)
            {medicamentos_comboBox.addItem(nombre);}
        });

        
    }

    @Override
    public void propertyChange(java.beans.PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case Model.LISTAPRESCRIPCIONES:
                String medicamentoSeleccionado = (String) medicamentos_comboBox.getSelectedItem();
                List<Prescripcion> prescripciones = model.getListaPrescripcion();

                TableModel tableModel = new TableModel(model.getListaPrescripcion());
                table1.setModel(tableModel);
                table1.updateUI();
                break;
        }
    }
}

