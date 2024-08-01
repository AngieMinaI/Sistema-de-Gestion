package MenuPrincipal;

public class OrdenaInsercion {
    public  void ordenaInsercion(int[] dni){
        for(int i=1;i<dni.length;i++){ // indice 1
            int elemactual = dni[i];
            int k;
            
            for(k=i-1;k>=0&&elemactual<dni[k];k--){ // compara
                dni[k+1]=dni[k]; // cambia si esta en desorden
            }
            dni[k+1]=elemactual; // no cambia si esta en orden
        }
    }
    public static void mostrarArreglo(int[] dni){
        for (int num : dni) { //foreach
            System.out.print(num + " ");
        }
        System.out.println();
    }   
}
