
package arbolbinario;

public class ArbolBinario {
     Nodo raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

   public void insertar(int valor) {
    raiz = insertarRec(raiz, valor);
}

private Nodo insertarRec(Nodo nodo, int valor) {
    if (nodo == null) {
        return new Nodo(valor);
    }

    if (valor < nodo.valor) {
        nodo.izquierda = insertarRec(nodo.izquierda, valor);
    } else if (valor > nodo.valor) {
        nodo.derecha = insertarRec(nodo.derecha, valor);
    } else {
        
        System.out.println("El numero " + valor + " ya esta en el arbol. Ingrese otro numero.");
    }

    return nodo;
}

    public void preorden() {
        preordenRec(raiz);
        System.out.println();
    }

    private void preordenRec(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            preordenRec(nodo.izquierda);
            preordenRec(nodo.derecha);
        }
    }

    public void inorden() {
        inordenRec(raiz);
        System.out.println();
    }

    private void inordenRec(Nodo nodo) {
        if (nodo != null) {
            inordenRec(nodo.izquierda);
            System.out.print(nodo.valor + " ");
            inordenRec(nodo.derecha);
        }
    }

    public void posorden() {
        posordenRec(raiz);
        System.out.println();
    }

    private void posordenRec(Nodo nodo) {
        if (nodo != null) {
            posordenRec(nodo.izquierda);
            posordenRec(nodo.derecha);
            System.out.print(nodo.valor + " ");
        }
    }
   public void eliminar(int valor) {
    ResultadoEliminacion resultado = new ResultadoEliminacion();
    raiz = eliminarRec(raiz, valor, resultado);

    if (resultado.eliminado) {
        System.out.println("Numero " + valor + " eliminado correctamente.");
    } else {
        System.out.println("Numero " + valor + " no encontrado en el arbol. Ingrese otro numero.");
    }
}

private Nodo eliminarRec(Nodo raiz, int valor, ResultadoEliminacion resultado) {
    if (raiz == null) {
        resultado.eliminado = false;
        return raiz;
    }

    if (valor < raiz.valor) {
        raiz.izquierda = eliminarRec(raiz.izquierda, valor, resultado);
    } else if (valor > raiz.valor) {
        raiz.derecha = eliminarRec(raiz.derecha, valor, resultado);
    } else {
        resultado.eliminado = true;

        if (raiz.izquierda == null) {
            return raiz.derecha;
        } else if (raiz.derecha == null) {
            return raiz.izquierda;
        }

        raiz.valor = obtenerMinimo(raiz.derecha);
        raiz.derecha = eliminarRec(raiz.derecha, raiz.valor, resultado);
    }

    return raiz;
}

private int obtenerMinimo(Nodo raiz) {
    int minimo = raiz.valor;
    while (raiz.izquierda != null) {
        minimo = raiz.izquierda.valor;
        raiz = raiz.izquierda;
    }
    return minimo;
}

class ResultadoEliminacion {
    boolean eliminado;
}

    
}
