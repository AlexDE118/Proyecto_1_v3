package hospital.presentacion.prescripcion;

import com.github.lgooddatepicker.components.DatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class View implements PropertyChangeListener {
    private JPanel prescripcionJPanel;
    private JButton buscarPacienteButton;
    private JButton agregarMedicamentoButton;
    private JLabel pacienteLabel;
    private JTable listaMedicamentos_JTable;
    private JButton guardarButton;
    private JButton limpiarButton;
    private JButton descartarMedicamentoButton;
    private DatePicker datePicker;

    private hospital.presentacion.prescripcion.pacientes.View pacienteView;
    private hospital.presentacion.prescripcion.medicamentos.View medicamentosView;

    public JPanel getPrescripcionJPanel() {
        return prescripcionJPanel;
    }

    public View(){
        pacienteView = new hospital.presentacion.prescripcion.pacientes.View();
        medicamentosView = new hospital.presentacion.prescripcion.medicamentos.View();

        agregarMedicamentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                medicamentosView.setVisible(true);
            }
        });

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        descartarMedicamentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        buscarPacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pacienteView.setVisible(true);
            }
        });
    }

    // ---- MVC ---- //

    Controller controller;
    Model model;

    public void setController(Controller controller) {
        this.controller = controller;
        pacienteView.setController(controller);
    }

    public void setModel(Model model) {
        this.model = model;
        model.addPropertyChangeListener(this);

        pacienteView.setModel(model);
        model.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()){
            case Model.PACIENTS:
                int[] cols = {0,1,2,3};
            break;
            case Model.PACIENT: {
                if (model.getCurrent().getPaciente() != null) {
                    pacienteLabel.setText(model.getCurrent().getPaciente().getNombre());
                } else pacienteLabel.setText("Paciente no seleccionado");
            }
            break;
        }
    }
}
