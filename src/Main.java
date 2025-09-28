import logica.DesplazamientoArreglo;
import logica.OrdenamientoEstudiantes;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        mostrarMenu();
        //OrdenamientoArreglo.ordenamientoArreglo();
        //OrdenamientoEstudiantes.ordenamientoEstudiantes();
    }

    public static void mostrarMenu(){
        Scanner scanner = new Scanner(System.in);
        int opcion;
        System.out.println("==== PRÁCTICA 2 (ALGORITMOS CLÁSICOS Y ESTRUCTURAS DE DATOS) ====");
        System.out.println("1. Algoritmo de desplazamientos en un arreglo.");
        System.out.println("2. Ordenamiento de estudiantes en un arreglo.");
        System.out.println("3. Salir.");
        System.out.print("Seleccione opción: ");

        opcion = scanner.nextInt();
        if(opcion == 1){
            DesplazamientoArreglo.ordenamientoArreglo();
        }
        else if(opcion == 2){
            OrdenamientoEstudiantes.ordenamientoEstudiantes();
        }
    }

}