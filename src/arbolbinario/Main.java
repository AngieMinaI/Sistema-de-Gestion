package arbolbinario;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {       
        Scanner scanner = new Scanner(System.in);
        ArbolBinario arbol = new ArbolBinario();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Insertar numero");
            System.out.println("2. Imprimir preorden");
            System.out.println("3. Imprimir inorden");
            System.out.println("4. Imprimir posorden");
            System.out.println("5. Imprimir eliminar numero");
            System.out.println("6. Salir");

            System.out.print("Ingrese la opcion: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese un numero: ");
                    int numero = scanner.nextInt();
                    arbol.insertar(numero);
                    break;
                case 2:
                    System.out.println("Recorrido preorden:");
                    arbol.preorden();
                    break;
                case 3:
                    System.out.println("Recorrido inorden:");
                    arbol.inorden();
                    break;
                case 4:
                    System.out.println("Recorrido posorden:");
                    arbol.posorden();
                    break;
                case 5:
                    System.out.println("Ingrese el valor para eliminar:");
                    int valorEliminar = scanner.nextInt();
                    arbol.eliminar(valorEliminar);
                    break;
                case 6:
                    System.out.println("Saliendo del programa");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opcion no valida. Intente nuevamente.");
            }
        }
    }
}