
package MenuPrincipal;

public class BusquedaSecDescenOrd {
       public static int buscarNumero(int[] dni, int elementoBuscado) {
        for (int i = dni.length-1; i >= 0; i--) { //empieza desde la derecha a buscar
            if (dni[i] == elementoBuscado) {
                return i;  
            }
        }
        return -1;  //devuelve -1 si no se encuentra el numero
    }
}
