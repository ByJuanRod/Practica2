package logica;
import java.util.Scanner;

public class DesplazamientoArreglo {

    public static void ordenamientoArreglo() {
        Scanner scanner = new Scanner(System.in);
        int opcion = mostrarMenuOpciones(scanner);
        int[] arreglo = obtenerArreglo(scanner, opcion);

        if (arreglo.length % 2 == 1) {
            System.out.println("Error: El número de elementos debe ser par.");
            scanner.close();
            return;
        }

        System.out.print("Ingrese el valor de T: ");
        int t = scanner.nextInt();

        System.out.println("\nArreglo original:");
        imprimirArreglo(arreglo);

        long inicio = System.nanoTime();
        desplazarElementos(arreglo, t);
        long tiempoEjecucion = System.nanoTime() - inicio;

        System.out.println("Arreglo después de T=" + t + " desplazamientos:");
        imprimirArreglo(arreglo);

        System.out.println("Tiempo: " + tiempoEjecucion + " ns");

        scanner.close();
    }

    private static int mostrarMenuOpciones(Scanner scanner) {
        System.out.println("=== OPCIONES DE ENTRADA ===");
        System.out.println("1. Ingresar valores manualmente");
        System.out.println("2. Generar arreglo secuencial automáticamente");
        System.out.print("Seleccione opción (1 o 2): ");

        return scanner.nextInt();
    }

    private static int[] obtenerArreglo(Scanner scanner, int opcion) {
        scanner.nextLine();

        switch (opcion) {
            case 1:
                return obtenerArregloManual(scanner);
            case 2:
                return generarArregloNumerico(scanner);
            default:
                System.out.println("Opción inválida. Se usará generación automática.");
                return generarArregloNumerico(scanner);
        }
    }

    private static int[] obtenerArregloManual(Scanner scanner) {
        System.out.print("Ingrese los números separados por espacio: ");
        String input = scanner.nextLine();

        String[] elementos = input.split(" ");
        int n = elementos.length;
        int[] arreglo = new int[n];

        for (int i = 0; i < n; i++) {
            arreglo[i] = Integer.parseInt(elementos[i]);
        }

        return arreglo;
    }

    private static int[] generarArregloNumerico(Scanner scanner) {
        System.out.print("Ingrese la cantidad de elementos (número par): ");
        int n = scanner.nextInt();

        if (n % 2 != 0) {
            System.out.println("Se ajustará a " + (n + 1) + " elementos (número par).");
            n += 1;
        }

        int[] arreglo = new int[n];
        for (int i = 0; i < n; i++) {
            arreglo[i] = i + 1;
        }

        System.out.println("Arreglo generado automáticamente con " + n + " elementos.");
        return arreglo;
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
