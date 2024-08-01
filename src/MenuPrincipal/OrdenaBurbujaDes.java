package MenuPrincipal;

public class OrdenaBurbujaDes {
     public  void ordenarBurbuja(int[] dni){
        int n = dni.length; 
        boolean intercambiado;
        do {
            intercambiado = false;
            for (int i = 1; i < n; i++){ 
                if (dni[i - 1] < dni[i]){ 
                    int temp = dni[i - 1]; 
                    dni[i - 1] = dni[i]; 
                    dni[i] = temp;
                    intercambiado = true;
                }
            }
        } while (intercambiado);
    }

    public static void mostrarArreglo(int[] dni) { 
        for (int num : dni){ 
            System.out.print(num + " ");
        }
        System.out.println();
    }   

}
