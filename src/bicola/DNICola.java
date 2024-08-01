package bicola;

public class DNICola extends DNIColaLista { // hereda del padre 
    public DNICola() { // constructor
        super(); //  llamar al constructor de la clase padre
    }

    public void ponerFinal(String dni) {
        insertar(dni);
    }

    public void ponerFrente(String dni) {
        NodoDNI a = new NodoDNI(dni); // crea nodo a
        if (colaVacia()) {
            fin = a; // el nuevo nodo es el fin
        }
        a.siguiente = frente; // el sgt del nodo a es el nuevo vincula al actual frente
        frente = a; // al frente esta el nuevo nodo
    }

    public String quitarFrente() throws Exception {
        return quitar();
    }

    public String quitarFinal() throws Exception {
        String aux;
        if (!colaVacia()) { // si la cola no está vacía 
            if (frente == fin) // cuando hay1  elemento en la cola 
                aux = quitar(); // se elimina el unico elemento 
            else { // hay mas elementos 
                NodoDNI a = frente; 
                while (a.siguiente != fin) // recorre la cola hasta allegar al nodo justo antes del último nodo, penultimo
                    a = a.siguiente; // a va ser el fin
                a.siguiente = null; // sgt lo vuelve null
                aux = fin.elemento; // guarda el  elemento eliminar
                fin = a; // a es el nuevo fin
            }
        } else
            throw new Exception("Eliminar de una DNICola vacía");
        return aux;
    }

    public String frenteDNICola() throws Exception {
        return frenteCola();
    }

    public String finalDNICola() throws Exception {
        if (colaVacia()) {
            throw new Exception("Error: DNICola vacía");
        }
        return (fin.elemento);
    }

    public boolean dnicolaVacia() {
        return colaVacia();
    }

    public void borrarDNICola() {
        borrarCola();
    }

    public int numElemsDNICola() { // indica cuantos elemento hay en la cola
        int n;
        NodoDNI a = frente;
        if (dnicolaVacia())
            n = 0;
        else {
            n = 1;
            while (a != fin) {
                n++;
                a = a.siguiente;
            }
        }
        return n;
    }

    public void mostrarDNICola() {
        NodoDNI current = frente;
        while (current != null) {
            System.out.print(current.elemento + " ");
            current = current.siguiente;
        }
        System.out.println();
    }
}
