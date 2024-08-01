package MenuPrincipal;

public class OrdenaSeleccion {
    public  void ordenarSeleccion(int[] dni) {
        int n = dni.length;

        for (int i = 0; i < n - 1; i++) { //indice 1
            int indiceMinimo = i;
            for (int j = i + 1; j < n; j++) { //recorre los demas ele restantes
                if (dni[j] < dni[indiceMinimo]) { // compara
                    indiceMinimo = j;
                }
            }
            int temp = dni[i]; //aux
                dni[i] = dni[indiceMinimo];//asigna
                dni[indiceMinimo] = temp;//cambio
        }
    }

    public static void mostrarArreglo(int[] dni) {
        for (int num : dni) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
    

