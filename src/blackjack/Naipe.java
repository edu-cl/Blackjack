
package blackjack;


public class Naipe {
   private  int numero;
   private    String color;

    public Naipe(int numero, String color) {
        this.numero = numero;
        this.color = color;
    }

    private  Naipe() {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Naipe{" + "numero=" + numero + ", color=" + color + '}';
    }

    
}
