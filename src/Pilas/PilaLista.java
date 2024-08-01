
package Pilas;


    public class PilaLista { // uno encima de otro y se desempaqueta LIFO
    private Nodo cima; // nodo superior de la pila 
    private int cimaIndex; // indice del nodo superior
     private int maxTamaño;
     
     public PilaLista(int maxTamaño) { // constructor
        cima = null;
        cimaIndex = -1; // incialmente vacia
        this.maxTamaño = maxTamaño; 
    }

    public Object topPila() {
    try {
        if (pilaVacia()) {
            throw new Exception("Pila vacia");
        }
        return cima.valor; // devuelve el valor de la parte superior sin eliminarlo
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
        return null; // o puedes retornar algún valor predeterminado o lanzar otra excepción según tus necesidades
    }
}


    public Object quitar() {
    try {
        if (pilaVacia()) {
            throw new Exception("Pila vacia");
        }
        Object temp = cima.valor; // guarda el elemento que esta en la cima en temp
        cima = cima.siguiente;  // actualiza la cima apunta al sgt  nodo, elimina
        cimaIndex--; // se reduce en  indice 1, indica q ha eliminado
        return temp;
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
        return null; 
    }
}

public void insertar(Object elemento) {
    try {
        if (pilaLlena()) {
            throw new Exception("Overflow de Pila"); // no se puede insertar por estar llena
        }

        Nodo nuevoNodo = new Nodo(elemento); // crea un nuevo nodo
        nuevoNodo.siguiente = cima; // el nodo que está en la cima, va a tener como referencia el nuevo nodo
        cima = nuevoNodo; // el nuevo nodo es la actual cima
        cimaIndex++; // incrementa el índice en 1
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
        // Realizar manejo de error adicional si es necesario
    }
}


    public void limpiaPila() {
        cima = null;
        cimaIndex = -1; // incialmente vacia 
    }

    public boolean pilaVacia() {
        return cima == null;
    }

    public boolean pilaLlena() {
        return cimaIndex == maxTamaño - 1; // indice == nro que ingreso -1
    }
   public void mostrarPila() {
    try {
        if (pilaVacia()) {
            throw new Exception("Pila vacia");
        }
        
        System.out.println("Contenido de la pila:");
        Nodo actual = cima; // crea nuevo nodo, para recorrer la pila
        
        while (actual != null) { // al menos haya 1 elemento
            System.out.println(actual.valor); // valor del nodo
            actual = actual.siguiente; // apunta al siguiente elemento de la pila hasta el fin 
        }
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
        // Realizar manejo de error adicional si es necesario
    }
}
}


class Nodo {
    Object valor; // valor del nodo
    Nodo siguiente; // sgte nodo de la pila

    public Nodo(Object valor) {
        this.valor = valor;
        this.siguiente = null;
    }
}

    

