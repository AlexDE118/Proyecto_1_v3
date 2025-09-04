package hospital.presentacion.prescripcion;

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

    private hospital.presentacion.prescripcion.pacientes.View pacienteView;

    public JPanel getPrescripcionJPanel() {
        return prescripcionJPanel;
    }

    public View(){

        agregarMedicamentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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

            }
        });
    }

    // ---- MVC ---- //

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
        switch (evt.getPropertyName()){
            case Model.CURRENT:
                break;
        }
    }
}
