package logica;
import java.util.ArrayList;
import java.util.List;

public class Utilidades {
    private static final double minimoIndice = 0;
    private static final double maximoIndice = 4;

    public static List<Estudiante> generarEstudiantes(int n){
        List<Estudiante> lista = new ArrayList<Estudiante>();

        for(int i = 0; i < n; i++){
            int matricula = genMatricula(n);
            double indice = Math.round(genIndice() * 10.0) / 10.0;
            lista.add(new Estudiante(matricula,("Estudiante #" + (i+1)),indice));
        }

        return lista;
    }

    private static int genMatricula(int maximoMat){
        return (int)(Math.random() * (maximoMat + 1));
    }

    private static double genIndice(){
        return Math.random() * (maximoIndice - minimoIndice) + minimoIndice;
    }
}
