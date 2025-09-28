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

        boolean ascendente = ordenamiento.equalsIgnoreCase("asc");
        List<Estudiante> lista = Utilidades.generarEstudiantes(n);

        long inicio = System.nanoTime();
        List<Estudiante>listaOrdenada = ordenarMergeSort(lista, ascendente);
        long tiempo = System.nanoTime() - inicio;

        System.out.println("Tiempo: " + tiempo + " ns");
        for(Estudiante estudiante : listaOrdenada) {
            System.out.println(estudiante);
        }
    }

    private static List<Estudiante> ordenarMergeSort(List<Estudiante> lista, boolean ascendente) {
        if (lista.size() <= 1) {
            return new ArrayList<>(lista);
        }

        int mitad = lista.size() / 2;
        List<Estudiante> izquierda = new ArrayList<>(lista.subList(0, mitad));
        List<Estudiante> derecha = new ArrayList<>(lista.subList(mitad, lista.size()));

        izquierda = ordenarMergeSort(izquierda, ascendente);
        derecha = ordenarMergeSort(derecha, ascendente);

        return mezclar(izquierda, derecha, ascendente);
    }

    private static List<Estudiante> mezclar(List<Estudiante> izquierda, List<Estudiante> derecha, boolean ascendente) {
        List<Estudiante> resultado = new ArrayList<>();
        int i = 0, j = 0;

        while (i < izquierda.size() && j < derecha.size()) {
            double indiceIzq = izquierda.get(i).getIndice();
            double indiceDer = derecha.get(j).getIndice();

            boolean condicion = ascendente ? indiceIzq <= indiceDer : indiceIzq >= indiceDer;

            if (condicion) {
                resultado.add(izquierda.get(i));
                i++;
            } else {
                resultado.add(derecha.get(j));
                j++;
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
