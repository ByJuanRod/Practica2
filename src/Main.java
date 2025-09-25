import logica.Estudiante;
import logica.Utilidades;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Estudiante> lista = ordenarMergeSort(Utilidades.generarEstudiantes(10),false);

        for(Estudiante estudiante : lista){
            System.out.println(estudiante);
        }
    }

    public static List<Estudiante> ordenarMergeSort(List<Estudiante> lista, boolean ascendente) {
        if (lista.size() <= 1) {
            return lista;
        }

        int medio = lista.size() / 2;
        List<Estudiante> izquierda = new ArrayList<>();
        List<Estudiante> derecha = new ArrayList<>();

        for (int indice = 0; indice < medio; indice++) {
            izquierda.add(lista.get(indice));
        }

        for (int indice = medio; indice < lista.size(); indice++) {
            derecha.add(lista.get(indice));
        }

        izquierda = ordenarMergeSort(izquierda, ascendente);
        derecha = ordenarMergeSort(derecha, ascendente);
        return merge(izquierda, derecha, ascendente);
    }

    private static List<Estudiante> merge(List<Estudiante> izquierda, List<Estudiante> derecha, boolean ascendente) {
        List<Estudiante> resultado = new ArrayList<>();
        int i = 0, j = 0;

        while (i < izquierda.size() && j < derecha.size()) {
            double indiceIzq = izquierda.get(i).getIndice();
            double indiceDer = derecha.get(j).getIndice();

            if (ascendente) {
                if (indiceIzq <= indiceDer) {
                    resultado.add(izquierda.get(i));
                    i++;
                } else {
                    resultado.add(derecha.get(j));
                    j++;
                }
            } else {
                if (indiceIzq >= indiceDer) {
                    resultado.add(izquierda.get(i));
                    i++;
                } else {
                    resultado.add(derecha.get(j));
                    j++;
                }
            }
        }
        while (i < izquierda.size()) {
            resultado.add(izquierda.get(i));
            i++;
        }
        while (j < derecha.size()) {
            resultado.add(derecha.get(j));
            j++;
        }
        return resultado;
    }

}