package logica;

public class Estudiante {
    private int matricula;
    private String nombre;
    private double indiceAcademico;

    public Estudiante(int matricula, String  nombre, double indiceAcademico){
        this.matricula = matricula;
        this.nombre = nombre;
        this.indiceAcademico = indiceAcademico;
    }

    public double getIndice(){
        return indiceAcademico;
    }

    @Override
    public String toString() {
        return matricula + "-" + nombre + "-" + indiceAcademico;
    }
}
