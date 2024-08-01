
package bicola;

public class DNIColaLista { // ELIMINA INICIO y AGREGA final, FIFO
    protected NodoDNI frente; //primero 
    protected NodoDNI fin;// ultimo

    public DNIColaLista() { // constructor
        frente = fin = null;
    }

    public void insertar(String dni) {
        NodoDNI a = new NodoDNI(dni); // crea nuevo nodo y asigna variable a
        if (colaVacia()) {
            frente = a; // indica que  a es el primer nodo
        } else { // al menos 1 elemento
            fin.siguiente = a; // vincula el ultimo elemento  anterior de la cola al nuevo nodo q ahora es ultimo
        }
        fin = a; // a es el ultimo 
    }

    public String quitar() throws Exception {
        String aux;
        if (!colaVacia()) { // si NO esta vacia 
            aux = frente.elemento; // GUARDA aux el elemento inicio
            frente = frente.siguiente; // elimina, ahora el frente el siguiente elemento 
        } else
            throw new Exception("No se puede eliminar de una DNICola vacía");
        return aux;
    }

    public void borrarCola() {
        for (; frente != null; ) { // que hay al menos 1, continua mientras haya elementos
            frente = frente.siguiente; // elimina el primer elemento  y frente apunta al sgt elemento de la cola
        }
        System.gc(); // recolección de basura para liberar memoria
    }

    public String frenteCola() throws Exception {
        if (colaVacia()) {
            throw new Exception("Error: DNICola vacía");
        }
        return (frente.elemento);
    }

    public boolean colaVacia() {
        return (frente == null);
    }
}
