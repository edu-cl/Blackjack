package blackjack;

public class Jugador {

    private String nombre;
    private int suma;
    

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.suma=0;
    }

    private Jugador() {
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSuma() {
        return suma;
    }

    public void setSuma(int suma) {
        this.suma = suma;
    }
    
    

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + '}';
        
        
    }
    
    public boolean equals(Object ob){
        boolean result=false;
        
        if(this==ob){
            result=true;
        }else if (ob instanceof Jugador){
            Jugador p=(Jugador)ob;
            if(nombre.equals(p.getNombre())&& this.suma==p.getSuma()){
                result=true;
            }
        }
        return result;
    }

}
