package blackjack;

import java.util.Scanner;

public class Baraja {

    protected Naipe[] baraja;

    public Baraja() {
        baraja= AnadirNaipes();
    }

    public Naipe[] getBaraja() {
        return baraja;
    }

    public void setBaraja(Naipe[] baraja) {
        this.baraja = AnadirNaipes();
    }

    @Override
    public String toString() {
        return "Baraja{" + "baraja=" + baraja + '}';
    }

    
    public Naipe[] AnadirNaipes() {
        Naipe[] result = new Naipe[48];
        String[] palos = {"Copas", "Bastos", "Oros", "Espadas"};
        for (int i = 0, j = 0, x = 0, contador = 0; i < result.length; i++) {
            Naipe carta = new Naipe(j += 1, palos[x]);
            if (result[i] == null) {
                result[i] = carta;
            }
            if (contador < palos.length) {
                if (j == 12) {
                    x += 1;
                    j = 0;
                    contador++;
                }
            }
        }
        return result;
    }   

}
