package MenuPrincipal;
import java.util.Arrays;

public class InsertaNumero {     
public static int []inserta(int[]dni,int val, int indic) { //recibe
        int[]resultado=new int[dni.length+1]; //dni+1
            for(int i=0;i<indic;i++)resultado[i]=dni[i]; //copia todos anterior
                resultado[indic]=val; //inserta numero
                    for(int i=indic+1;i<=dni.length;i++){
                        resultado[i]=dni[i-1]; //copia hasta el final nuevo
                    }
        System.out.println(Arrays.toString(resultado)); 
        return resultado;
    }
}
    
