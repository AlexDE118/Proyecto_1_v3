package hospital.presentacion.prescripcion;

import javax.swing.*;

public class View {
    private JPanel prescripcionJPanel;
    private JButton buscarPacienteButton;
    private JButton agregarMedicamentoButton;

    public JPanel getPrescripcionJPanel() {
        return prescripcionJPanel;
    }

    public View(){

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
}
