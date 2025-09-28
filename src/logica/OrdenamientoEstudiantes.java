package logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrdenamientoEstudiantes {
    public static void ordenamientoEstudiantes() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de estudiantes: ");
        int n = sc.nextInt();

        System.out.println("Seleccione el metodo de ordenamiento (desc/asc): ");
        String ordenamiento = sc.next();
        sc.close();
        boolean orden = ordenamiento.equalsIgnoreCase("asc");
        List<Estudiante> lista = Utilidades.generarEstudiantes(n);

        long inicio = System.nanoTime();
        List<Estudiante>listaOrdenada = ordenarMergeSort(lista,orden);
        long tiempo = System.nanoTime() - inicio;

        System.out.println("Tiempo: " + tiempo + " ns");
        for(Estudiante estudiante : listaOrdenada){
            System.out.println(estudiante);
        }
    }

    private static List<Estudiante> ordenarMergeSort(List<Estudiante> listaSinOrdenar, boolean ascendente) {
        if (listaSinOrdenar.size() <= 1) {
            return new ArrayList<>(listaSinOrdenar);
        }

        int mitad = listaSinOrdenar.size() / 2;

        List<Estudiante> izquierda = ordenarMergeSort(listaSinOrdenar.subList(0, mitad), ascendente);
        List<Estudiante> derecha = ordenarMergeSort(listaSinOrdenar.subList(mitad, listaSinOrdenar.size()), ascendente);

        return mezclar(izquierda, derecha, ascendente);
    }

    private static List<Estudiante> mezclar(List<Estudiante> izquierda, List<Estudiante> derecha, boolean ascendente) {
        List<Estudiante> resultado = new ArrayList<>(izquierda.size() + derecha.size());
        int i = 0, j = 0;

        while (i < izquierda.size() && j < derecha.size()) {
            Estudiante leftElem = izquierda.get(i);
            Estudiante rightElem = derecha.get(j);

            boolean condicion = ascendente ?
                    leftElem.getIndice() <= rightElem.getIndice() :
                    leftElem.getIndice() >= rightElem.getIndice();

            if (condicion) {
                resultado.add(leftElem);
                i++;
            } else {
                resultado.add(rightElem);
                j++;
            }
        }

        while (i < izquierda.size()) {
            resultado.add(izquierda.get(i++));
        }
        while (j < derecha.size()) {
            resultado.add(derecha.get(j++));
        }

        return resultado;
    }
}
