package hospital.logic;
import hospital.data.Listas;

import javax.print.Doc;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//singleton

public class Service {
    private static Service instance;
    private Listas listas;

    public static Service instance(){
        if(instance == null) instance = new Service();
        return instance;
    }

    private Service(){ listas = new Listas(); }

    //================== DOCTORES ==================//

    public void createDoctor(Doctor doctor) throws Exception{
        Doctor result = listas.getDoctores().stream()
                .filter(x -> x.getId().equals(doctor.getId())).findFirst().orElse(null);
        // Linea anterior revisa si la ID del doctor existe, de ser asi result apunta al objeto encontrado, o a NULL//

        if(result == null){
            listas.getDoctores().add(doctor);
        }else{
            throw new Exception("Doctor existente");
        }
    }

    public Doctor readDoctor(Doctor doctor) throws Exception {
        Doctor result = listas.getDoctores().stream().filter(x -> x.getId().equals(doctor.getId())).findFirst().orElse(null);

        if(result != null){
            return result;
        }else {
            throw new Exception("Doctor no existente");
        }

    }

    public List<Doctor> loadListaDoctores(){
        return listas.getDoctores();
    }

    public void deleteDoctor(Doctor doctor) throws Exception {
        Doctor result = listas.getDoctores().stream().filter(x -> x.getId().equals(doctor.getId())).findFirst().orElse(null);
        if(result != null){
            listas.getDoctores().remove(result);
        }
        else {
            throw new Exception("Doctor no existente");
        }
    }

    public List<Doctor> searchDoctorByName(Doctor e) {
        return listas.getDoctores().stream()
                .filter(i -> i.getNombre().toLowerCase().contains(e.getNombre().toLowerCase()))
                .sorted(Comparator.comparing(Doctor::getNombre))
                .collect(Collectors.toList());
    }

//    public void DeleteDoctor(Doctor doctor) throws Exception {
//        Doctor result = listas.getDoctores().stream().filter(i -> i.getId().equals(doctor.getId())).findFirst().orElse(null);
//        if(result != null){
//            listas.getDoctores().remove(result);
//        } else {
//            throw new Exception("Doctor no existente");
//        }
//    }

    //================== Pacientes ==================//

    public void createPaciente(Paciente paciente) throws Exception{
        Paciente result = listas.getPacientes().stream()
                .filter(x -> x.getId().equals(paciente.getId())).findFirst().orElse(null);
        if(result == null){
            listas.getPacientes().add(paciente);
        }else {
            throw new Exception("Paciente existente");
        }
    }

    public Paciente readPaciente(Paciente paciente) throws Exception {
        Paciente result = listas.getPacientes().stream()
                .filter(x -> x.getId().equals(paciente.getId())).findFirst().orElse(null);
        if(result != null){
            return result;
        }else  {
            throw new Exception("Paciente no existente");
        }
    }

    public List<Paciente> loadListaPacientes(){
        return listas.getPacientes();
    }

    public void deletePaciente(Paciente paciente) throws Exception {
        Paciente result = listas.getPacientes().stream()
                .filter(x -> x.getId().equals(paciente.getId())).findFirst().orElse(null);

        if(result != null){
            listas.getPacientes().remove(result);
        } else {
            throw new Exception("Paciente no existente");
        }
    }

    public List<Paciente> searchPaciente(Paciente paciente) {
        return listas.getPacientes().stream()
                .filter(i -> i.getNombre().toLowerCase().contains(paciente.getNombre().toLowerCase()))
                .sorted(Comparator.comparing(Paciente::getNombre))
                .collect(Collectors.toList());
    }

    public List<Paciente> searchPacienteID(Paciente paciente) {
        return listas.getPacientes().stream()
                .filter(i -> i.getNombre().toLowerCase().contains(paciente.getId().toLowerCase()))
                .sorted(Comparator.comparing(Paciente::getId))
                .collect(Collectors.toList());
    }

    //================== Farmaceutas ==================//

    public void createFarmaceuta(Farmaceuta farmaceuta) throws Exception{
        Farmaceuta result = listas.getFarmaceutas().stream()
                .filter(x -> x.getId().equals(farmaceuta.getId())).findFirst().orElse(null);

        if(result == null){
            listas.getFarmaceutas().add(farmaceuta);
        }else {
            throw new Exception("Farmaceuta existente");
        }
    }

    public Farmaceuta readFarmaceuta(Farmaceuta farmaceuta) throws Exception{
        Farmaceuta result = listas.getFarmaceutas().stream()
                .filter(x -> x.getId().equals(farmaceuta.getId())).findFirst().orElse(null);

        if(result != null){
            return result;
        }else {
            throw new Exception("Farmaceuta no existente");
        }
    }

    public void deleteFarmaceuta(Farmaceuta farmaceuta) throws Exception {
        Farmaceuta result = listas.getFarmaceutas().stream()
                .filter(x -> x.getId().equals(farmaceuta.getId())).findFirst().orElse(null);

        if(result != null){
            listas.getFarmaceutas().remove(result);
        } else {
            throw new Exception("Farmaceuta no existente");
        }
    }

    public List<Farmaceuta> loadListaFarmaceutas(){
        return listas.getFarmaceutas();
    }

    public List<Farmaceuta> searchFarmaceuta(Farmaceuta farmaceuta) {
        return listas.getFarmaceutas().stream()
                .filter(f -> (farmaceuta.getNombre() == null || farmaceuta.getNombre().isEmpty() ||
                        f.getNombre().toLowerCase().contains(farmaceuta.getNombre().toLowerCase())) &&
                        (farmaceuta.getId() == null || farmaceuta.getId().isEmpty() ||
                                f.getId().equalsIgnoreCase(farmaceuta.getId())))
                .collect(Collectors.toList());
    }

    //================== Medicamentos ==================//

    public void createMedicamentos(Medicamento medicamento) throws Exception{
        Medicamento result = listas.getMedicamentos().stream()
                .filter(x -> x.getID().equals(medicamento.getID())).findFirst().orElse(null);
        if(result == null){
            listas.getMedicamentos().add(medicamento);
        } else  {
            throw new Exception("Medicamento existente");
        }
    }

    public Medicamento readMedicamentos(Medicamento medicamento) throws Exception{
        Medicamento result = listas.getMedicamentos().stream()
                .filter(x -> x.getID().equals(medicamento.getID())).findFirst().orElse(null);
        if(result != null){
            return result;
        } else   {
            throw new Exception("Medicamento no existente");
        }
    }

    public List<Medicamento> loadListaMedicamentos(){
        return listas.getMedicamentos();
    }

    public List<Medicamento> searchMedicamento(Medicamento medicamento) {
        return listas.getMedicamentos().stream()
                .filter(m -> (medicamento.getID() == null || medicamento.getID().isEmpty() ||
                        m.getID().toLowerCase().contains(medicamento.getID().toLowerCase())) &&
                        (medicamento.getID() == null || medicamento.getID().isEmpty() ||
                                m.getID().equalsIgnoreCase(medicamento.getID())))
                .collect(Collectors.toList());
    }
    //========================== Receta ==========================//

    public void createReceta(Receta receta) {
        listas.getRecetas().add(receta);
    }

    public List<Receta>  loadListaRecetas(){
        return listas.getRecetas();
    }

    public void removeReceta(Receta receta) {
        listas.getRecetas().remove(receta);
    }

    //========================== Prescripcion ==========================//

    public void createPrescripcion(Prescripcion prescripcion) throws Exception{
        Prescripcion result = listas.getPrescripciones().stream()
                .filter(x -> x.getPaciente().getId().equals(prescripcion.getPaciente().getId())).findFirst().orElse(null);
        if(result == null){
            listas.getPrescripciones().add(prescripcion);
        } else {
            throw new Exception("Prescripcion existente");
        }
    }

    public Prescripcion readPrescripcion(Prescripcion prescripcion) throws Exception{
        Prescripcion result = listas.getPrescripciones().stream()
                .filter(x -> x.getPaciente().getId().equals(prescripcion.getPaciente().getId())).findFirst().orElse(null);
        if(result != null){
            return result;
        } else {
            throw new Exception("Prescripcion no existente");
        }
    }

    public List<Prescripcion> loadListaPrescripciones(){
        return listas.getPrescripciones();
    }

    public void updatePrescripcion(Prescripcion prescripcion) throws Exception {
        Prescripcion result = listas.getPrescripciones().stream()
                .filter(x -> x.getPaciente().getId().equals(prescripcion.getPaciente().getId())).findFirst().orElse(null);
        if(result != null){
            listas.getPrescripciones().remove(result);
            listas.getPrescripciones().add(prescripcion);
        } else {
            throw new Exception("Prescripcion no existente");
        }
    }

    //======================= END ======================//
}

