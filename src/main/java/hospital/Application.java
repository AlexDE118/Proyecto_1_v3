package hospital;

import hospital.presentacion.dashboard.View2;
import hospital.presentacion.doctor.Controller;
import hospital.presentacion.doctor.Model;
import hospital.presentacion.doctor.View;
import hospital.presentacion.medicamentos.MedicamentosController;
import hospital.presentacion.medicamentos.MedicamentosModel;
import hospital.presentacion.medicamentos.View3;

import javax.swing.*;

public class Application {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ex) { ex.printStackTrace();}

//        JFrame window = new JFrame();
//        window.setSize(800,600);
//        window.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//        window.setTitle("Medicamentos");
//        // ---- SETCONTENTPANE PARA TESTEAR ---- //
//        window.setContentPane(viewRecetas.getRecetasJPanel());
//        window.setVisible(true);


        //DOCTORES
        hospital.presentacion.doctor.View doctorView = new hospital.presentacion.doctor.View();
        hospital.presentacion.doctor.Model doctorModel = new hospital.presentacion.doctor.Model();
        hospital.presentacion.doctor.Controller controllerDoctor = new hospital.presentacion.doctor.Controller(doctorView, doctorModel);

        //FARMACEUTAS
        hospital.presentacion.farmaceuta.View farmaceutaView = new hospital.presentacion.farmaceuta.View();
        hospital.presentacion.farmaceuta.Model farmaceutaModel = new hospital.presentacion.farmaceuta.Model();
        hospital.presentacion.farmaceuta.Controller controllerFarmaceuta = new hospital.presentacion.farmaceuta.Controller(farmaceutaView, farmaceutaModel);
        //PACIENTES
        hospital.presentacion.paciente.View pacienteView = new hospital.presentacion.paciente.View();
        hospital.presentacion.paciente.Model pacienteModel = new hospital.presentacion.paciente.Model();
        hospital.presentacion.paciente.Controller pacienteController = new hospital.presentacion.paciente.Controller(pacienteView, pacienteModel);
        //Medicamentos
        MedicamentosModel medicamentosModel = new MedicamentosModel();
        View3 medicamentosView = new View3();
        MedicamentosController medicamentosController = new MedicamentosController(medicamentosView,medicamentosModel);

        //PRESCRIPCION
        hospital.presentacion.prescripcion.View prescripcionView = new hospital.presentacion.prescripcion.View();
        hospital.presentacion.prescripcion.Model prescripcionModel = new hospital.presentacion.prescripcion.Model();
        hospital.presentacion.prescripcion.Controller prescripcionController = new hospital.presentacion.prescripcion.Controller(prescripcionView,prescripcionModel);

        //DASHBOARD
        View2 dashboardView = new  View2();

        // ----------- FRAME ----------- //
        JFrame window = new JFrame();
        JTabbedPane tabbedPane = new JTabbedPane();
        window.setSize(1300, 500);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setTitle("Proyecto_1");
        window.setContentPane(tabbedPane);
        tabbedPane.addTab("Doctores", doctorView.getMedicos_JPanel());
        tabbedPane.addTab("Medicamentos",medicamentosView.getMedicamentos_JPanel());
        tabbedPane.addTab("Farmaceutas",farmaceutaView.getFarmaceutaPanel());
        tabbedPane.addTab("Pacientes", pacienteView.getPacientesJPanel());
        tabbedPane.addTab("Prescripcion", prescripcionView.getPrescripcionJPanel());
        tabbedPane.addTab("Dashboard", dashboardView.getDashboard_JPanel());
        tabbedPane.addTab("Historico",null);
        tabbedPane.addTab("Acerca de", null);
        // -----
        controllerDoctor.loadDoctors();
//        medicamentosController.loadMedicamentos();
        controllerFarmaceuta.loadFarmaceutas();
        pacienteController.loadPacientes();
        //System.out.println();
        window.setContentPane(tabbedPane);
        window.setVisible(true);

    }
}
