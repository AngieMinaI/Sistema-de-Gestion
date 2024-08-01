
package Listas;


public class Nodo {
    public int DNI; 
    public Nodo siguiente;

    public Nodo(int DNI) {
        this.DNI = DNI;
        this.siguiente = null;
    }
    
    public int ObtenerDNI()
    {
    return DNI;
    }
    
    public void EnlazarSiguiente (Nodo n)
    {
        siguiente =n;
    }
    
    public Nodo ObtenerSiguiente()
    {
        return siguiente;
    }
    
    
}