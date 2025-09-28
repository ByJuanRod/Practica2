package logica;
import java.util.Scanner;

public class DesplazamientoArreglo {
    public static void ordenamientoArreglo() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese los números separados por espacio: ");
        String input = scanner.nextLine();

        System.out.print("Ingrese el valor de T: ");
        int t = scanner.nextInt();

        String[] elementos = input.split(" ");
        int n = elementos.length;
        int[] arreglo = new int[n];

        for (int i = 0; i < n; i++) {
            arreglo[i] = Integer.parseInt(elementos[i]);
        }

        if (n % 2 != 0) {
            System.out.println("Error: El número de elementos debe ser par.");
            return;
        }

        System.out.println("\nArreglo original:");
        imprimirArreglo(arreglo);

        long inicio = System.nanoTime();
        desplazarElementos(arreglo, t);
        long fin = System.nanoTime() - inicio;

        System.out.println("Arreglo después de T=" + t + " desplazamientos:");
        imprimirArreglo(arreglo);

        System.out.println("Tiempo: " + fin + " ns");

        scanner.close();
    }

    private static void desplazarElementos(int[] arreglo, int t) {
        int n = arreglo.length;
        if (n % 2 != 0 || t < 1 || t >= n) {
            throw new IllegalArgumentException("n debe ser par y t entre 1 y n-1");
        }

        int mitad = n / 2;

        for (int i = 0; i < t; i++) {
            if (i % 2 == 0) {
                int temp = arreglo[0];
                for (int j = 0; j < mitad - 1; j++) {
                    arreglo[j] = arreglo[j + 1];
                }
                arreglo[mitad - 1] = temp;
            } else {
                int temp = arreglo[n - 1];
                for (int j = n - 1; j > mitad; j--) {
                    arreglo[j] = arreglo[j - 1];
                }
                arreglo[mitad] = temp;
            }
        }
    }

    private static void imprimirArreglo(int[] arreglo) {
        for (int j : arreglo) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}
