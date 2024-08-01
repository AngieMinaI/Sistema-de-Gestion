
package Listas;


public class ListaEnlazada {
        Nodo cabeza;
    Nodo ultimo; // Declaración de la variable "ultimo"
    int tamaño;

    public ListaEnlazada() {
        this.cabeza = null;
        this.ultimo = null;
        this.tamaño =0; // el tamaño comienza con el valor 0
    }
    public boolean estaVacia() {
    return (cabeza == null);
}
    public void eliminarTodaLaLista() {
    cabeza = null;
    ultimo = null;
    tamaño = 0;
}
    public void eliminarPorDNI(int dni) {
    if (estaVacia()) {
        System.out.println("La lista está vacía. No se puede eliminar un nodo.");
        return;
    }

    Nodo actual = cabeza;
    Nodo anterior = null;

    while (actual != null) {
        if (actual.ObtenerDNI() == dni) {
            // Encontramos un nodo con el DNI deseado, lo eliminamos
            if (anterior != null) {
                anterior.EnlazarSiguiente(actual.ObtenerSiguiente());
            } else {
                // Si el nodo a eliminar es el primero, actualizamos la cabeza
                cabeza = actual.ObtenerSiguiente();
            }
            tamaño--;
            System.out.println("Nodo con DNI " + dni + " eliminado.");
            return; // Salimos del bucle una vez que se elimina el nodo.
        }

        anterior = actual;
        actual = actual.ObtenerSiguiente();
    }

    System.out.println("Nodo con DNI " + dni + " no encontrado en la lista.");
}

    
    
    public void añadirEnMedio(int dni, int posicion) {
    if (posicion < 0 || posicion > tamaño) {
        System.out.println("Posición inválida. Debe estar en el rango de 0 a " + tamaño);
        return;
    }

    Nodo nuevoNodo = new Nodo(dni);
    if (posicion == 0) {
        nuevoNodo.EnlazarSiguiente(cabeza);
        cabeza = nuevoNodo;
    } else {
        Nodo actual = cabeza;
        for (int i = 0; i < posicion - 1; i++) {
            actual = actual.ObtenerSiguiente();
        }
        nuevoNodo.EnlazarSiguiente(actual.ObtenerSiguiente());
        actual.EnlazarSiguiente(nuevoNodo);
    }
    tamaño++;
}
public void eliminarEnMedio() {
    if (cabeza == null) {
        // La lista está vacía, no se puede eliminar un nodo.
        return;
    }

    int tamañoLista = TamañoDeLista();

    if (tamañoLista < 3) {
        // No hay un nodo en el medio, pero hay al menos un nodo.
        cabeza = cabeza.ObtenerSiguiente();
        tamaño--;
        return;
    }

    int posicionMitad = tamañoLista / 2;

    int contador = 0;
    Nodo temporal = cabeza;
    while (contador < posicionMitad - 1) {
        temporal = temporal.ObtenerSiguiente();
        contador++;
    }

    temporal.EnlazarSiguiente(temporal.ObtenerSiguiente().ObtenerSiguiente());

    tamaño--;
}




    
    public void mostrarLista() {
    Nodo actual = cabeza;
    while (actual != null) {
        System.out.print(actual.ObtenerDNI() + " ");
        actual = actual.ObtenerSiguiente();
    }
    System.out.println(); 
}

   public void añadirPrimero(int dato){
        if(cabeza == null)  // revisar si la cabeza es nula
        {
          cabeza = new Nodo(dato);
          this.ultimo = null;
        }  
        else{
            Nodo temp = cabeza; // separamos la cabeza
            Nodo nuevo = new Nodo(dato); //creamos un nuevo nodo con el dni que añadimos
            nuevo.EnlazarSiguiente(temp);// aqui hemos enlazado el nuevo nodo con el nodo temporal se convierte en la cabeza
            cabeza = nuevo; // la nueva cabeza será nuevo. 
        }
        tamaño++; // cada vez que añadimos un elemento lo aumentamos en 1 
    }
   
   public int TamañoDeLista(){ // metodo para ver el tamaño de la lista
       return tamaño;
   }
   
   public int Buscar(int Posicion){ //creamos las posiciones para realizar busquedas
       int contador =0; // creamos un contador desde 0
       Nodo temporal = cabeza; // creamos un temporal que sera igual a la cabeza 
       while(contador<Posicion){
           temporal=temporal.ObtenerSiguiente(); // para pasar de 1 en 1 hasta encontrar el DNI que quiero
           contador++;
       }
       return temporal.ObtenerDNI(); //que nos devuelva el DNI que encontró. 
   }
    
   public void EliminarPrimero(){
       cabeza = cabeza.ObtenerSiguiente();//remplazo la cabeza con el siguiente
       tamaño--; // el tamapo disminuye en 1 
   }
   
   public void EliminarElemento(int Posicion){
       if(Posicion ==0)
       {
           cabeza=cabeza.ObtenerSiguiente();
       }
       else{
            int contador = 0;
            Nodo temporal = cabeza;
            while(contador < Posicion -1){ // busco la posicion anterior
                temporal = temporal.ObtenerSiguiente();
                contador++;
                }
                    temporal.EnlazarSiguiente(
                            temporal.ObtenerSiguiente().ObtenerSiguiente() );// obtengo el siguiente del siguiente 
       }
           tamaño--; // el tamaño disminuye
   }
    public void añadirUltimo(int dni) {
        Nodo nuevoNodo = new Nodo(dni);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            this.ultimo = null;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
        tamaño++;
    }

    public void eliminarUltimo() {
        if (cabeza != null) {
            if (cabeza.siguiente == null) {
                cabeza = null;
                this.ultimo = null;
            } else {
                Nodo actual = cabeza;
                while (actual.siguiente.siguiente != null) {
                    actual = actual.siguiente;
                }
                actual.siguiente = null;
            }
            tamaño--;
        }
    }
    
    public int buscarEnLista(int dni) {
    Nodo actual = cabeza;
    int posicion = 0;

    while (actual != null) {
        if (actual.ObtenerDNI() == dni) {
            return posicion; // Devuelve la posición del DNI si se encuentra.
        }
        actual = actual.ObtenerSiguiente();
        posicion++;
    }

    return -1; // Devuelve -1 si el DNI no se encuentra en la lista.
}

    public void ordenarLista() {
    if (cabeza == null) {
        // La lista está vacía, no se puede ordenar.
        return;
    }

    Nodo actual;
    boolean intercambio;

    do {
        intercambio = false;
        actual = cabeza;

        while (actual.siguiente != null) {
            if (actual.ObtenerDNI() > actual.ObtenerSiguiente().ObtenerDNI()) {
                // Realiza el intercambio de nodos.
                int temp = actual.ObtenerDNI();
                actual.DNI = actual.ObtenerSiguiente().ObtenerDNI();
                actual.ObtenerSiguiente().DNI = temp;

                intercambio = true;
            }
            actual = actual.ObtenerSiguiente();
        }
    } while (intercambio);
}


}
