package hospital.presentacion.login;

import hospital.presentacion.dashboard.View2;
import hospital.presentacion.medicamentos.View3;

import javax.swing.*;

public class View {
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
