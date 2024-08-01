package MenuPrincipal;

public class OrdenaBurburja {
    public  void ordenarBurbuja(int[] dni){
        int n = dni.length;
        boolean intercambiado;// si se han hecho intercambio 
        do {
            intercambiado = false;
            for (int i = 1; i < n; i++){ // indice 1
                if (dni[i - 1] > dni[i]){ //compara nro act con nro sig, actual mayor camb
                    int temp = dni[i - 1]; // var temp guarda actual
                    dni[i - 1] = dni[i]; //cambio
                    dni[i] = temp;
                    intercambiado = true;
                }
            }
        } while (intercambiado);//true pasada
    }

    public static void mostrarArreglo(int[] dni) {
        for (int num : dni){ //for each arreglodni
            System.out.print(num + " ");
        }
        System.out.println();
    }   
}
