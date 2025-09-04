package hospital.logic;

public class Fecha {//aa
    //Atributos
    private int dia;
    private int mes;
    private int anio;


    //Constructores
    public Fecha() {
        this.dia = 0;
        this.mes = 0;
        this.anio = 0;
    }

    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    //Setters | Getters

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getDia() {
        return dia;
    }
    public int getMes() {
        return mes;
    }
    public int getAnio() {
        return anio;
    }

    // Metodos de la clase

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", dia, mes, anio);
    }
}
