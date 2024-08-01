package MenuPrincipal;
import java.util.Scanner;
import Listas.ListaEnlazada;
import Listas.Nodo;
import bicola.DNICola;
import Pilas.PilaLista;
import arbolbinario.ArbolBinario;
import static busquedabinariarecursiva.BusquedaBinariaRecursiva.busBinrecur;
import static busquedabinariarecursiva.BusquedaBinariaRecursiva.ordenarInsercion;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import com.mycompany.dijkstra.Dijkstra; 
import static com.mycompany.dijkstra.Dijkstra.dijkstra;

public class PrincipalMenu {

    public static void main(String[] args) throws Exception {  
        Scanner scan = new Scanner(System.in);
        int tam;
        int opcion = 0; 
      
     do {  
    System.out.println("Menu Principal:");
    System.out.println("1. Avance 1");
    System.out.println("2. Avance 2");
    System.out.println("3. Avance 3");
    System.out.println("4. Avance 4");
    System.out.println("5. Salir");    
    System.out.print("Ingrese la opcion: ");
    
    int avance = scan.nextInt();
     if (avance == 1) {
        System.out.print("Ingrese el tamano del arreglo ");
        tam= scan.nextInt();  //acá se guarda el tamaño del arreglo
            int[] dni = new int [tam]; // se crea el arreglo dni
        
            for (int i = 0; i < tam; i++) {
                System.out.print("Ingrese el dni del estudiante "+(i+1)+": ");   
                dni [i] = scan.nextInt();//aca se guarda el arreglo dni      
            }
        System.out.println("Los numeros de dni ingresados son: "); 
                for (int i = 0; i < tam; i++) {
                    System.out.print(dni[i]+" "); //aca se muestra el arreglo
                }
        do { 
        System.out.print("""
                            \nMenu
                               1. Ordene por burbuja ascendente los dni 
                               2. Ordene por burbuja descendente los dni
                               3. Ordene por seleccion desordenado los dni   
                               4. Ordene por insercion los dni 
                               5. Busqueda secuencial ascendente de dni desordenado
                               6. Busqueda secuencial ascendente de los dni ordenado
                               7. Busqueda secuencial descendente de los dni ordenado
                               8. Busqueda binaria ordenada
                               9. Inserte un nuevo numero de dni
                               10. Eliminar un numero de dni
                               11. Atras
                               12. Salir
                               Ingrese la opcion:
                                       """);
          opcion = scan.nextInt(); 
          switch(opcion){
            case 1:
                    OrdenaBurburja obj = new OrdenaBurburja();
                    obj.ordenarBurbuja(dni); //llama al metodo
                    System.out.println("Arreglo ordenado:");
                    OrdenaBurburja.mostrarArreglo(dni); //llama al metodo
                break;    
            case 2:
                    OrdenaBurbujaDes objetosffOrdenaburbujades = new OrdenaBurbujaDes();
                    objetosffOrdenaburbujades.ordenarBurbuja(dni); //llama al metodo
                    System.out.println("Arreglo ordenado:");
                    OrdenaBurbujaDes.mostrarArreglo(dni); //llama al metodo
                break;
            case 3:  
                    OrdenaSeleccion os = new OrdenaSeleccion();
                    os.ordenarSeleccion(dni);//llama al metodo
                    System.out.println("Arreglo ordenado:");
                    OrdenaSeleccion.mostrarArreglo(dni);//llama al metodo
                break;
            case 4:
                    OrdenaInsercion oi = new OrdenaInsercion();
                    oi.ordenaInsercion (dni);//llama al metodo
                    System.out.println("Arreglo ordenado:");
                    OrdenaInsercion.mostrarArreglo(dni);//llama al metodo
                break;
            case 5:
                    System.out.println("\nIngrese el numero a buscar");
                        int numeroBuscado = scan.nextInt();  
                    int indice = BusquedaSecuencialDesor.buscarNumero(dni, numeroBuscado); // llama al metodo
                    
                    if (indice!= -1) {
                        System.out.println("El numero " + numeroBuscado + " se encuentra en el arreglo y en la indice " + indice);
                    } 
                    else {
                        System.out.println("El numero " + numeroBuscado + " no se encontro en el arreglo");
                    }
                break;
            case 6:
                boolean estaordenado = true;

                    for (int i = 1; i < dni.length; i++) {
                            if (dni[i] < dni[i - 1]) { // valida si esta ordenado o no
                             estaordenado = false;
                        break; 
                        }
                    }
                    if (estaordenado) {
                            System.out.println("El arreglo esta ordenado ascendente");
                            System.out.println("\nIngrese el numero a buscar");
                                int elementoBuscado = scan.nextInt(); 
                                int resultado = BusquedaSecuencialAscendenteOrd.buscarNumero(dni, elementoBuscado); // al metodo
                                if (resultado != -1) {
                                    System.out.println("El elemento " + elementoBuscado + " se encuentra en el indice " + resultado);
                                } 
                                else {
                                     System.out.println("El elemento " + elementoBuscado + " no se encontr en el arreglo.");
                                    }
                                 } 
                                 else {
                                     System.out.println("El arreglo no esta ordenado ascendente");
                                }
                break;
            case 7:
                boolean estaordenadoDes = true;
                    for (int i = 0; i < dni.length - 1; i++) {
                        if (dni[i] < dni[i + 1]) {
                   estaordenadoDes = false; 
                    break; 
                    }
                }
                    
                     if (estaordenadoDes) {
                        System.out.println("El arreglo esta ordenado descendente");
                        System.out.println("\nIngrese el numero a buscar");
                            int elementoBuscado = scan.nextInt(); 
                            int resultado = BusquedaSecDescenOrd.buscarNumero(dni, elementoBuscado); // al metodo
                        if (resultado != -1) {
                            System.out.println("El elemento " + elementoBuscado + " se encuentra en el indice " + resultado);
                        } 
                        else {
                            System.out.println("El elemento " + elementoBuscado + " no se encontr en el arreglo.");
                        }
                    } 
                    else {
                        System.out.println("El arreglo no esta ordenado descendente");
                    }
                break;
            case 8:
                    boolean estaOrdenado = true;

                    for (int i = 1; i < dni.length; i++) {
                        if (dni[i] < dni[i - 1]) { // valida si esta ordenado o no
                             estaOrdenado = false;
                        break; 
                        }
                    }

                    if (estaOrdenado) {
                        System.out.println("El arreglo esta ordenado");
                        System.out.println("\nIngrese el numero a buscar");
                            int elementoBuscado = scan.nextInt(); 
                            int resultado = BusquedaBinariaOrden.buscar(dni, elementoBuscado); // al metodo
                        if (resultado != -1) {
                            System.out.println("El elemento " + elementoBuscado + " se encuentra en el indice " + resultado);
                        } 
                        else {
                            System.out.println("El elemento " + elementoBuscado + " no se encontr en el arreglo.");
                        }
                    } 
                    else {
                        System.out.println("El arreglo no esta ordenado");
                    }
                break;
            case 9:
                    System.out.println("Ingrese un numero: ");
                    int val = scan.nextInt();
                    System.out.println("Ingrese el indice: ");
                    int indic = scan.nextInt();     
                    InsertaNumero.inserta(dni,val, indic); //llama al metodo
                break;
            case 10:   
                    System.out.print("Ingrese el numero a eliminar: ");
                    int elementoEliminar = scan.nextInt();
                    EliminarNumero en = new EliminarNumero();
                    en.eliminarNumero(dni,elementoEliminar); //llama al metodo
                break;
            case 11:
                    System.out.println("Volviendo al menu anterior");
                    break;    
            case 12:
                    System.out.println("Sesion cerrada");
                    System.exit(0);
                break;
            default:
                    System.out.println("Opcion invalida, ingrese un numero que esta en el menu");
                break;
         }
        } while (opcion !=11);
   } else if (avance == 2) {
    Scanner scan1 = new Scanner(System.in);
    int tamListaEnlazada;
    int opcionAvance2;
do {
    System.out.println("Menu:");
    System.out.println("1. Trabajar con Lista Enlazada");
    System.out.println("2. Trabajar con Pila");
    System.out.println("3. Trabajar con Bicola");
   System.out.println("4. Salir");
    System.out.println("Ingrese la opcion:");
    opcionAvance2 = scan1.nextInt();

    switch (opcionAvance2) {
         case 1:
                Listas.ListaEnlazada lista = new Listas.ListaEnlazada();

                while (true) {
                    System.out.print("Ingrese el tamano de la lista enlazada: ");
                    try {
                        if (scan1.hasNextInt()) {
                            tamListaEnlazada = scan1.nextInt();
                            if (tamListaEnlazada <= 0) {
                                System.out.println("Tamano invalido. Debe ser mayor que 0.");
                            } else {
                                break; // Salir del bucle si el valor es válido
                            }
                        } else {
                            System.out.println("Entrada invalida. Ingrese un numero valido.");
                            scan1.next();
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada invalida. Ingrese un numero valido.");
                        scan1.next();
                    }
                }
            System.out.println("A continuacion, ingrese los elementos de la lista enlazada:");

            for (int i = 0; i < tamListaEnlazada; i++) {
                System.out.print("Ingrese el numero de DNI " + (i + 1) + ": ");
                int dni = scan1.nextInt();
                lista.añadirPrimero(dni);
            }
             do {
            while (true) {
                    System.out.println("Menu:");
                    System.out.println("1. Mostrar lista");
                    System.out.println("2. Anadir nodo al principio");
                    System.out.println("3. Eliminar nodo al principio");
                    System.out.println("4. Insertar nodo al final");
                    System.out.println("5. Eliminar ultimo nodo");
                    System.out.println("6. Anadir nodo en cualquier posicion");
                    System.out.println("7. Eliminar DNI");
                    System.out.println("8. Eliminar toda la lista");
                    System.out.println("9. Buscar en la lista");
                    System.out.println("10. Ordenar la lista");
                    System.out.println("11. Salir");
                    System.out.println("Ingrese una opcion: ");


                opcionAvance2 = scan1.nextInt();

                switch (opcionAvance2) {
                        case 1:
                            lista.mostrarLista();
                            break;
                        case 2:
                            if (lista.estaVacia()) {
                                System.out.println("La lista está vacia. No se puede agregar un nodo.");
                            } else {
                                System.out.print("Ingrese el numero de DNI a agregar al principio: ");
                                int dniAgregar = scan1.nextInt();
                                lista.añadirPrimero(dniAgregar);
                                lista.mostrarLista();
                            }
                            break;
                        case 3:
                            if (lista.estaVacia()) {
                                System.out.println("La lista esta vacia. No se puede eliminar un nodo.");
                            } else {
                                lista.EliminarPrimero();
                                lista.mostrarLista();
                            }
                            break;
                        case 4:
                            if (lista.estaVacia()) {
                                System.out.println("La lista esta vacia. No se puede insertar un nodo al final.");
                            } else {
                                System.out.print("Ingrese el numero de DNI a insertar al final: ");
                                int dniInsertar = scan1.nextInt();
                                lista.añadirUltimo(dniInsertar);
                                lista.mostrarLista();
                            }
                            break;
                        case 5:
                            if (lista.estaVacia()) {
                                System.out.println("La lista esta vacia. No se puede eliminar el ultimo nodo.");
                            } else {
                                lista.eliminarUltimo();
                                lista.mostrarLista();
                            }
                            break;
                        case 6:
                            System.out.print("Ingrese el numero de DNI a agregar en la mitad: ");
                            int dniAgregarMitad = scan1.nextInt();
                            System.out.print("Ingrese la posicion en la que desea agregarlo: ");
                            int posicionAgregarMitad = scan1.nextInt();
                            lista.añadirEnMedio(dniAgregarMitad, posicionAgregarMitad);
                            lista.mostrarLista();
                            break;
                        case 7:
                            System.out.print("Ingrese el DNI a eliminar: ");
                                int dniEliminar = scan1.nextInt();
                                lista.eliminarPorDNI(dniEliminar);
                                lista.mostrarLista();

                            break;


                        case 8:
                            lista.eliminarTodaLaLista();
                            System.out.println("Lista fue eliminada.");
                            break;
                        case 9:
                            System.out.print("Ingrese el numero de DNI a buscar: ");
                            int dniBuscado = scan1.nextInt();
                            int posicion = lista.buscarEnLista(dniBuscado);

                            if (posicion != -1) {
                                System.out.println("DNI encontrado en la posicion " + posicion);
                            } else {
                                System.out.println("DNI no encontrado en la lista.");
                            }
                            break;
                        case 10:
                            lista.ordenarLista();
                            lista.mostrarLista();
                            break;
                       
                        case 11:
                    System.out.println("Sesion cerrada");
                    System.exit(0);
                break;
                        default:
                            System.out.println("Opcion invalida, ingrese un numero que esta en el menu");
                            break;
                }
            }
            
              } while (opcion != 10);

                           
        case 2:
            
            
             Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el tamano de la pila: ");
        int tamanoPila = sc.nextInt();
        sc.nextLine(); // Consumir el salto de línea pendiente

        PilaLista pilaChar = new PilaLista(tamanoPila);

     String elemento;
       
        while(true){
            System.out.println("Menu:");
            System.out.println("1. Insertar un DNI en la pila"); // ok
            System.out.println("2. Quitar un DNI de la pila"); //ok
            System.out.println("3. Mostrar la pila de DNI"); //ok
            System.out.println("4. Mostrar el top de la pila");
            System.out.println("5. Limpiar la pila");// OK
            System.out.println("6. Salir"); //ok
            System.out.print("Ingrese la opcion: ");
            int opcion22 = sc.nextInt();
            sc.nextLine();
            switch (opcion22) {
                case 1:
                    System.out.print("Ingrese un dni: ");
                    elemento = sc.nextLine();
                    pilaChar.insertar(elemento);
                    break;
                case 2:
                    
                    try {
                      elemento = (String) pilaChar.quitar();
                        System.out.println("Elemento retirado de la pila: " + elemento);
                    } catch (Exception e) {
                        System.out.println("La pila esta vacia. No se puede retirar un elemento.");
                    }
                    break;
                case 3:
                    pilaChar.mostrarPila();
                    break;
                  case 4:
                         elemento=(String) pilaChar.topPila();
                  
                    System.out.println("Elemento top de la pila: "+elemento);
                    break;
                    case 5:
                    pilaChar.limpiaPila();
                    System.out.println("Pila limpia");
                    break;
                case 6:
                    System.out.println("Sesion cerrada");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion no valida. Por favor, seleccione una opcion valida.");
            }
        }
 
        case 3:
            // Código relacionado con la Bicola
            DNICola dniCola = new DNICola();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Cantidad de DNI a ingresar: ");
        int cantidadDNIs = scanner.nextInt();

        for (int i = 0; i < cantidadDNIs; i++) {
            System.out.print("Ingrese el numero de DNI: ");
            String dni = scanner.next();
            dniCola.ponerFinal(dni);
        }

        scanner.nextLine(); 

        while (true) {
            System.out.println("Opciones:");
            System.out.println("1. Colocar DNI al frente");
            System.out.println("2. Colocar DNI al final");
            System.out.println("3. Eliminar primer DNI");
            System.out.println("4. Eliminar el ultimo DNI");
            System.out.println("5. Mostrar el primer DNI");
            System.out.println("6. Mostrar el ultimo DNI");
            System.out.println("7. Cantidad de DNI en Cola");
            System.out.println("8. Mostrar todos los DNI");
            System.out.println("9. Salir");
            System.out.print("Opciones: ");

            int opcion23 = scanner.nextInt();

            switch (opcion23) {
                case 1:
                    System.out.print("Ingrese un DNI para poner al frente: ");
                    String dniFrente = scanner.next();
                    dniCola.ponerFrente(dniFrente);
                    break;
                case 2:
                    System.out.print("Ingrese un DNI para poner al final: ");
                    String dniFinal = scanner.next();
                    dniCola.ponerFinal(dniFinal);
                    break;
                case 3:
                    try {
                        String dniQuitado = dniCola.quitarFrente();
                        System.out.println("DNI quitado del frente: " + dniQuitado);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        String dniQuitado = dniCola.quitarFinal();
                        System.out.println("DNI quitado del final: " + dniQuitado);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        String dniFrenteCola = dniCola.frenteDNICola();
                        System.out.println("DNI en el frente de la DNICola: " + dniFrenteCola);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    try {
                        String dniFinalCola = dniCola.finalDNICola();
                        System.out.println("DNI en el final de la DNICola: " + dniFinalCola);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    int cantidadDNIsCola = dniCola.numElemsDNICola();
                    System.out.println("Cantidad de DNI ingresados en la Bicola: " + cantidadDNIsCola);
                    break;
                case 8:
                    System.out.print("Bicola: ");
                    dniCola.mostrarDNICola();
                    break;
                case 9:
                    scanner.close();
                    System.out.println("Sesion cerrada");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion no valida. Por favor, elija una opcion valida.");
                    break;
            }
           
        }
                 
           
                case 4:
                    System.out.println("Sesion cerrada");
                    System.exit(0);
                    break;
                        default:
                            System.out.println("Opcion no valida");
                            break;
                    }
                } while (opcion != 4);
   
}
   else if (avance == 3) {
    // Código para Avance 3 con opción de Árbol Binario y Búsqueda Binaria Recursiva
    int opcionArbol = 0;  // Variable para el submenú de Árbol Binario

    do {
        System.out.println("\nMenu Avance 3:");
        System.out.println("1. Arbol Binario");
        System.out.println("2. Busqueda Binaria Recursiva");
        System.out.println("3. Salir");

        System.out.print("Ingrese la opcion: ");
        int opcionMenuAvance3 = scan.nextInt();

        switch (opcionMenuAvance3) {
            case 1:                      
                // Código para Avance 3 con árbol binario
                Scanner scanner = new Scanner(System.in);
                ArbolBinario arbol = new ArbolBinario();

                do {
                    System.out.println("\nMenu:");
                    System.out.println("1. Insertar numero");
                    System.out.println("2. Imprimir preorden");
                    System.out.println("3. Imprimir inorden");
                    System.out.println("4. Imprimir posorden");
                    System.out.println("5. Imprimir eliminar numero");
                    System.out.println("6. Regresar al menu principal");
                    System.out.println("7. Salir");

                    System.out.print("Ingrese la opcion: ");
                    opcionArbol = scanner.nextInt();

                    switch (opcionArbol) {
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
                            System.out.println("Volviendo atras");
                            break;
                        case 7:
                            System.out.println("Sesion cerrada");
                            System.exit(0);
                            break;    
                        default:
                            System.out.println("Opcion no valida. Intente nuevamente.");
                            break;
                     }
                } while (opcionArbol != 6);
                break;
                
            case 2:
               do {
                    System.out.println("\nMenu:");
                    System.out.println("1. Ordenar con Búsqueda Binaria Recursiva");   
                    System.out.println("2. Atras");
                    System.out.println("3. Salir");

                    opcion = scan.nextInt();

                    switch (opcion) {
                        case 1:
                            // Lógica para Ordenar con Búsqueda Binaria Recursiva
                            System.out.print("Ingrese el tamano de la lista: ");
                            int tamano = scan.nextInt();

                            int[] lista = new int[tamano];

                            System.out.println("Ingrese los numeros de la lista:");
                            for (int i = 0; i < tamano; i++) {
                                lista[i] = scan.nextInt();
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
                                    int numeroBuscar = scan.nextInt();

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
                                    scan.nextLine();
                                }
                            }
                    case 3:
                    System.out.println("Sesion cerrada");
                    System.exit(0);
                     break;    
                            
                        }
                    } while (opcion != 2);
                    break;
                           
                            
                             case 3:
                                System.out.println("Sesion cerrada");
                                System.exit(0);
                                break; 
                                 
                             default:
                                  System.out.println("Opcion no valida. Intente nuevamente.");
                
                     }
                } while (opcion != 3); // no va atras

        } else if (avance == 4) {
              do {
        System.out.println("\nMenu:");
        System.out.println("1. Sistema de transporte privado con Origen:Rimac Hasta Carabayllo,se aplica algoritmo de Dijkstra");
        System.out.println("2. Atras");
        System.out.println("3. Salir");
        opcion = scan.nextInt();

        switch (opcion) {
            case 1:
                // Lógica para Aplicar el algoritmo de Dijkstra
                int[][] graph =   {{0, 7, 10, 5, 0, 0, 0},
                                  {7, 0, 4, 0, 0, 0, 0},
                                  {10, 4, 0, 5, 7, 0, 0},
                                  {5, 0, 5, 0, 10, 0, 0},
                                  {0, 0, 7, 10, 0, 10, 8},
                                  {0, 12, 0, 0, 10, 0, 6},
                                  {0, 0, 0, 0, 8, 6, 0}};

                Map<Integer, String> nombresVertices = new HashMap<>();
                nombresVertices.put(0, "Rimac");
                nombresVertices.put(1, "SMP");
                nombresVertices.put(2, "Los Olivos");
                nombresVertices.put(3, "Independencia");
                nombresVertices.put(4, "Comas");
                nombresVertices.put(5, "Puenta Piedra");
                nombresVertices.put(6, "Carabayllo");

                dijkstra(graph, 0, nombresVertices);
                break;

            case 2:
                System.out.println("Regresando al menu principal");
                break;
            
            case 3:
                System.out.println("Sesion cerrada");
                System.exit(0);
                break;
                
            default:
                System.out.println("Opcion no valida. Intente nuevamente.");
                break;
                  }
              } while (opcion != 2);

            } else if (avance == 5) {
                System.out.println("Sesion Cerrada");
                return;
            } else {
                System.out.println("Opcion no valida");
            }
        } while (true);
    }
}