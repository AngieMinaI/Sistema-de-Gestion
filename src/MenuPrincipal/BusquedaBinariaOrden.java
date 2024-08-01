package MenuPrincipal;

public class BusquedaBinariaOrden {
    public static int buscar(int[] dni, int elemento) {
        int izquierda = 0;
        int derecha = dni.length - 1;

        while (izquierda <= derecha) { 
            int medio = (izquierda + derecha) / 2;

            if (dni[medio] == elemento) {
                return medio; // Elemento encontrado devuelve su indice
            } 
            else if (dni[medio] < elemento) {
                izquierda = medio + 1; // El elemento esta en la mitad derecha
            }
            else {
                derecha = medio - 1; // El elemento esta en la mitad izquierda
            }
        }
        return -1; // Elemento no encontrado
    }
}
    

