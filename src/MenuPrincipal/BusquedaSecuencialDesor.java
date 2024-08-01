
package MenuPrincipal;

public class BusquedaSecuencialDesor {

    public static int buscarNumero(int[] dni, int numeroBuscado) {
        for (int i = 0; i < dni.length; i++) {
            if (dni[i] == numeroBuscado) {
                return i;  // Devolvemos la posición si encontramos el número
            }
        }
        return -1;  // Devolvemos -1 si no se encuentra el número
    }
}

