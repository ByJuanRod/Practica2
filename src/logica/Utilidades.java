package logica;

import java.util.ArrayList;
import java.util.List;

public class Utilidades {
    private static final int minimoMat = 10;
    private static final int maximoMat = 100;
    private static final double minimoIndice = 0;
    private static final double maximoIndice = 4;

    public static List<Estudiante> generarEstudiantes(int n){
        List<Estudiante> lista = new ArrayList<>();

        for(int i = 0; i < n; i++){
            int matricula = genMatricula();
            double indice = Math.round(genIndice() * 10.0) / 10.0;
            lista.add(new Estudiante(matricula,("Estudiante #" + (i+1)),indice));
        }

        return lista;
    }

    private static int genMatricula(){
        return (int)(Math.random() * (maximoMat - minimoMat + 1)) + minimoMat;
    }

    private static double genIndice(){
        return Math.random() * (maximoIndice - minimoIndice + 1) + minimoIndice;
    }


}
