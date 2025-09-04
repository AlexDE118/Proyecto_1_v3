package hospital.presentacion.prescripcion.pacientes;

import hospital.logic.Paciente;
import hospital.presentacion.paciente.Model;
import hospital.presentacion.paciente.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class View extends JDialog implements PropertyChangeListener {
    private JPanel contentPanePacientes;
    private JButton OKButton;
    private JButton cancelButton;
    private JTextField nombre_textField;
    private JButton buscarButton;
    private JTable table1;

    public View(){
        setContentPane(contentPanePacientes);
        setModal(true);
        getRootPane().setDefaultButton(OKButton);
        setLocationRelativeTo(null);
        setTitle("Pacientes");
        setSize(400,250);

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        //END OF VIEW
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
