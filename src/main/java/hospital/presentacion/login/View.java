package hospital.presentacion.login;

import hospital.logic.Service;
import hospital.logic.Usuario;
import hospital.presentacion.dashboard.Controller;
import hospital.presentacion.dashboard.View2;
import hospital.presentacion.medicamentos.View3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class View implements PropertyChangeListener {
    private JPanel loginJPanel;
    private JPasswordField passwordField1;
    private JTextField id_textField;
    private JButton cambiarClaveButton;
    private JButton logInButton;
    private JButton limpiarButton;

    View2 dashboardView;
    hospital.presentacion.despacho.View despachosView;
    hospital.presentacion.doctor.View doctorView;
    hospital.presentacion.farmaceuta.View farmaceutaView;
    View3 medicamentosView;
    hospital.presentacion.paciente.View pacientesView;
    hospital.presentacion.prescripcion.View prescripcionesView;


    public JPanel getLoginJPanel() {
        return loginJPanel;
    }

    public View() {

        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Usuario usuario = new Usuario();
                usuario.setId(id_textField.getText());
                usuario.setClave(passwordField1.getText());
                try {
                    Service.instance().readUsuario(usuario);
                    model.setCurrent(usuario);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(loginJPanel, "Error: " + ex.getMessage());
                }
            }
        });

        cambiarClaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    Controller controller;
    Model model;

    @Override
    public void propertyChange(PropertyChangeEvent evt){
        switch (evt.getPropertyName()){
            case Model.CURRENT:

            break;
            case Model.LISTA_USUARIOS:

            break;
        }
    }
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void setModel(Model model) {
        this.model = model;
        model.addPropertyChangeListener(this);
    }

    public String modeSelector(String ID){
        if(id_textField.getText().equals("Admin")){
            return "Admin";
        }
        return "INVALID";
    }

    public void mostratPantalla(String userType){
        switch (userType){
            case "Doctor":
                //TABBED PANES
            break;
            case "Farmaceuta":
                //TABBED PANES
                break;
            case "Admin":
                //TABBED PANES
                break;
            case "INVALID":

                break;
        }
    }
}
