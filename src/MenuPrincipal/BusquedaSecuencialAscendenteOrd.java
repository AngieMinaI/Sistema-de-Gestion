package MenuPrincipal;

public class BusquedaSecuencialAscendenteOrd {
    public static int buscarNumero(int[] dni, int elementoBuscado) {
        for (int i = 0; i <= dni.length; i++) { // empieza desde la izquierda
            if (dni[i] == elementoBuscado) {
                return i;  // 
            }
        }
        return -1;  // Devuelve -1 si no se encuentra el número
    }
    
}
