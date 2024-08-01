package MenuPrincipal;
public class EliminarNumero {
    public int eliminarNumero(int[] dni, int elementoEliminar) { //recibe
        int[] nuevoDni = null;
        
        boolean encontrado = false; //ubicar ele
            for (int i = 0; i < dni.length; i++) { //recorre arr para buscar al num
                if (dni[i] == elementoEliminar) {
                    nuevoDni = new int[dni.length - 1];// new arre
                    for (int indice = 0; indice < i; indice++) {
                    nuevoDni[indice] = dni[indice]; //copia elem
                    }               
                    for (int j = i; j < dni.length - 1; j++) {
                    nuevoDni[j] = dni[j + 1]; // copia eleme faltante
                    }               
                encontrado = true; //se elimino
                break;
                }
            }       
        if (encontrado) {
            System.out.print("Nuevo arreglo:\n");
            for (int i = 0; i < nuevoDni.length; i++) { //recorre new
                if (i > 0) { // valida que no sea el primeri nro del elem priprime espac
                    System.out.print(" "); 
                }
                System.out.print(nuevoDni[i]);
            }              
        } 
        else {
                System.out.println("Número no encontrado");
        }
    return 0;
    } 
}

