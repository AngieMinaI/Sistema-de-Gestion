
package busquedabinariarecursiva;

import java.util.Scanner;

public class BusquedaBinariaRecursiva {

   // inicia la búsqueda binaria recursiva
     public static int busBinrecur(int[] lista, int key) {
        int inf = 0, sup = lista.length - 1; // indice 0 es inf y el indice final es sup
        return busBinrecur(lista, key, inf, sup); // se llama al metodo busBinrecur
    }

    // Método para la búsqueda binaria recursiva
    public static int busBinrecur(int[] lista, int key, int inf, int sup) {
        if (inf > sup) // si el indice 0 es mayor que el indice final pues no hay ningún elemento en la lista
            return -inf - 1; // no se encontró nada

        int med = (inf + sup) / 2; // se calcula el índice medio

        if (key < lista[med]) // se compara key con el elemento en med, si key es menor se llama a la recursividad en la izquierda
            return busBinrecur(lista, key, inf, med - 1);
        else if (key > lista[med]) // lo mismo pero a la derecha si es mayor que med
            return busBinrecur(lista, key, med + 1, sup);
        else
            return med;
    }

    public static void ordenarInsercion(int[] lista) {
        for (int i = 1; i < lista.length; i++) {
            int actual = lista[i];
            int j = i - 1;
            while (j >= 0 && lista[j] > actual) {
                lista[j + 1] = lista[j];
                j--;
            }
            lista[j + 1] = actual;
        }
    }

    // el proceso se repite hasta que se encuentra el número y de esa manera se utiliza la recursividad
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el tamano de la lista: ");
        int tamano = scanner.nextInt();

        int[] lista = new int[tamano];

        System.out.println("Ingrese los numeros de la lista:");
        for (int i = 0; i < tamano; i++) {
            lista[i] = scanner.nextInt();
        }

        ordenarInsercion(lista);

        System.out.println("Lista ordenada:");
        for (int i = 0; i < tamano; i++) {
            System.out.print(lista[i] + " ");
        }
        System.out.println();

        boolean salir = false;

        while (!salir) {
            try {
                System.out.print("Ingrese el numero a buscar (o ingrese -1 para salir): ");
                int numeroBuscar = scanner.nextInt();

                if (numeroBuscar == -1) {
                    salir = true;
                    System.out.println("Saliendo del programa");
                } else {
                    int indiceEncontrado = busBinrecur(lista, numeroBuscar);

                    if (indiceEncontrado < 0)
                        System.out.println("El numero no se encuentra en la lista");
                    else
                        System.out.println("El numero se encuentra en el indice " + indiceEncontrado);
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Por favor, ingrese un numero valido.");
                scanner.nextLine();
            }
        }

        scanner.close();
    }
}
