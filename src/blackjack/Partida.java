package blackjack;

import java.util.ArrayList;
import blackjack.Naipe;
import java.util.Scanner;

public class Partida {

    public static void main(String[] args) {
        Baraja b1 = new Baraja();
        Scanner teclado = new Scanner(System.in);

        Menu(teclado, b1);

    }

    public static void Menu(Scanner teclado, Baraja b1) {
        int sum1 = 0, sum2 = 0;
        boolean resultado = false;
        int opcion = 0;

        do {
            boolean result = false;
            do {
                System.out.println("  ___               _                  ___      _                            _      ");
                System.out.println(" / __|  __ _   ___ (_)  _ _    ___    | __|  __| | __ __ __  __ _   _ _   __| |  ___");
                System.out.println("| (__  / _` | (_-< | | | ' \\  / _ \\   | _|  / _` | \\ V  V / / _` | | '_| / _` | (_-<");
                System.out.println(" \\___| \\__,_| /__/ |_| |_||_| \\___/   |___| \\__,_|  \\_/\\_/  \\__,_| |_|   \\__,_| /__/");
                System.out.println("\n+-----------------------------+");
                System.out.println("|        Menu                 |");
                System.out.println("+-----------------------------+");
                System.out.println("| 1) Jugador VS Jugador       |");
                System.out.println("| 2) Jugador VS CPU           |");
                System.out.println("| 0) Salir                    |");
                System.out.println("+-----------------------------+");
                System.out.print("Introduce tu opcion: ");
                try {
                    opcion = teclado.nextInt();
                    result=true;
                } catch (Exception ex) {
                    System.out.println("Introduce un numero");
                    teclado.nextLine();
                }
            } while (!result);

            switch (opcion) {
                case 1:
                    Jugador j1 = crearJugador();
                    pulsarEnter();
                    Jugador j2 = crearJugador();
                    pulsarEnter();
                    for (int i = 0; i < 2; i++) {

                        if (i == 0) {
                            System.out.println("Va a jugar el jugador " + j1.getNombre());
                            sum1 = MenuJUgador(teclado, b1, j1);
                        } else {
                            System.out.println("Va a jugar el jugador " + j2.getNombre());
                            sum2 = MenuJUgador(teclado, b1, j2);
                        }
                    }

                    if (sum1 < 21 && sum1 > sum2) {
                        System.out.println("El jugador " + j1.getNombre() + " es el ganador");
                    } else {
                        System.out.println("El jugador " + j2.getNombre() + " es el ganador");
                    }

                    break;

                case 2:
                    Jugador j3 = crearJugador();
                    Jugador CPU = new Jugador("CPU");

                    for (int i = 0; i < 2; i++) {

                        if (i == 0) {
                            System.out.println("Va a jugar el jugador " + j3.getNombre());
                            sum1 = MenuJUgador(teclado, b1, j3);
                        } else {
                            System.out.println("Va a jugar el jugador " + CPU.getNombre());
                            sum2 = MenuCPU(teclado, b1, j3, CPU);
                        }
                    }
                    if (sum1 < 21 && sum1 > sum2) {
                        System.out.println("El jugador " + j3.getNombre() + " es el ganador");
                    } else {
                        System.out.println("El jugador " + CPU.getNombre() + " es el ganador");
                    }
                    break;

                case 0:
                    System.out.println("Esperemos que hayais disfrutado del casino edwards");
                    break;

                default:
                    System.out.println("Introduce una opcion correcta");
            }

        } while (opcion != 0);
    }

    public static Jugador crearJugador() {
        Jugador resultado = null;

        Scanner teclado = new Scanner(System.in);
        System.out.println("Creacion del personaje");

        System.out.println("Introduce tu nombre.");
        String nombre = teclado.nextLine();

        resultado = new Jugador(nombre);

        return resultado;

    }

    public static int MenuJUgador(Scanner teclado, Baraja b1, Jugador j1) {
        int opcion = 0;
        boolean resultado = false;
        int suma = 0;
        do {
            System.out.println("1) Pedir una carta");
            System.out.println("2) Plantarse");
            System.out.println("3) Salir");
            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:
                    int x = (int) Math.floor(Math.random() * 48);
                    Naipe nuevo = b1.baraja[x];
                    Carta(nuevo);

                    if (b1.baraja[x].getNumero() == 11 || b1.baraja[x].getNumero() == 12 || b1.baraja[x].getNumero() == 10) {
                        suma += 1;
                        j1.setSuma(suma);

                    } else {
                        suma += b1.baraja[x].getNumero();
                        j1.setSuma(suma);
                    }

                    System.out.println("Tus puntos son: " + j1.getSuma());
                    if (suma > 21) {
                        System.out.println("Has perdido");
                        j1.setSuma(1);
                        suma = 1;
                        resultado = true;
                        pulsarEnter();
                    }

                    break;
                case 2:
                    System.out.println("Usted se ha plantado con " + j1.getSuma());
                    resultado = true;
                    pulsarEnter();
                    break;
                case 3:
                    System.out.println("Que vuelva usted pronto");
                    resultado = true;
                    break;
            }
        } while (!resultado);
        return suma;
    }

    public static int MenuCPU(Scanner teclado, Baraja b1, Jugador j1, Jugador cpu) {
        int opcion = 0;
        boolean resultado = false;
        int suma = 0;
        do {
            if (j1.getSuma() > suma) {

                opcion = 1;
            } else {
                opcion = 2;
            }
            switch (opcion) {

                case 1:
                    int x = (int) Math.floor(Math.random() * 48);
                    Naipe nuevo = b1.baraja[x];
                    Carta(nuevo);

                    if (b1.baraja[x].getNumero() == 11 || b1.baraja[x].getNumero() == 12 || b1.baraja[x].getNumero() == 10) {
                        suma += 1;

                    } else {
                        suma += b1.baraja[x].getNumero();

                    }

                    System.out.println("Tus puntos son: " + suma);
                    pulsarEnter();

                    if (suma > 21) {
                        cpu.setSuma(1);
                        suma = 1;
                        System.out.println("Has perdido");
                        resultado = true;
                        pulsarEnter();
                    }

                    break;
                case 2:
                    System.out.println("Usted se ha plantado con " + suma);
                    resultado = true;
                    pulsarEnter();
                    break;
                case 3:
                    System.out.println("Que vuelva usted pronto");
                    resultado = true;
                    break;
            }

        } while (!resultado);
        return suma;
    }

    public static void Carta(Naipe numero) {
        String resultado = "";

        switch (numero.getNumero()) {
            case 1:
                System.out.println(" .----------------. ");
                System.out.println("| .--------------. |");
                System.out.println("| |     __       | |");
                System.out.println("| |    /  |      | |");
                System.out.println("| |    `| |      | |");
                System.out.println("| |     | |      | |");
                System.out.println("| |    _| |_     | |");
                System.out.println("| |   |_____|    | |");
                System.out.println("| |              | |");
                System.out.println("| '--------------' |");
                System.out.println(" '----------------' ");
                break;

            case 2:
                System.out.println(" .----------------. ");
                System.out.println("| .--------------. |");
                System.out.println("| |    _____     | |");
                System.out.println("| |   / ___ `.   | |");
                System.out.println("| |  |_/___) |   | |");
                System.out.println("| |   .'____.'   | |");
                System.out.println("| |  / /____     | |");
                System.out.println("| |  |_______|   | |");
                System.out.println("| |              | |");
                System.out.println("| '--------------' |");
                System.out.println(" '----------------' ");
                System.out.println("      " + numero.getColor() + "");
                break;
            case 3:
                System.out.println(" .----------------. ");
                System.out.println("| .--------------. |");
                System.out.println("| |    ______    | |");
                System.out.println("| |   / ____ `.  | |");
                System.out.println("| |   `'  __) |  | |");
                System.out.println("| |   _  |__ '.  | |");
                System.out.println("| |  | \\____) |  | |");
                System.out.println("| |   \\______.'  | |");
                System.out.println("| |              | |");
                System.out.println("| '--------------' |");
                System.out.println(" '----------------' ");
                System.out.println("      " + numero.getColor() + "");
                break;
            case 4:
                System.out.println(" .----------------. ");
                System.out.println("| .--------------. |");
                System.out.println("| |   _    _     | |");
                System.out.println("| |  | |  | |    | |");
                System.out.println("| |  | |__| |_   | |");
                System.out.println("| |  |____   _|  | |");
                System.out.println("| |      _| |_   | |");
                System.out.println("| |     |_____|  | |");
                System.out.println("| |              | |");
                System.out.println("| '--------------' |");
                System.out.println(" '----------------' ");
                System.out.println("      " + numero.getColor() + "");
                break;
            case 5:
                System.out.println(" .----------------. ");
                System.out.println("| .--------------. |");
                System.out.println("| |   _______    | |");
                System.out.println("| |  |  _____|   | |");
                System.out.println("| |  | |____     | |");
                System.out.println("| |  '_.____''.  | |");
                System.out.println("| |  | \\____) |  | |");
                System.out.println("| |   \\______.'  | |");
                System.out.println("| |              | |");
                System.out.println("| '--------------' |");
                System.out.println(" '----------------' ");
                System.out.println("      " + numero.getColor() + "");
                break;
            case 6:
                System.out.println(" .----------------. ");
                System.out.println("| .--------------. |");
                System.out.println("| |    ______    | |");
                System.out.println("| |  .' ____ \\   | |");
                System.out.println("| |  | |____\\_|  | |");
                System.out.println("| |  | '____`'.  | |");
                System.out.println("| |  | (____) |  | |");
                System.out.println("| |  '.______.'  | |");
                System.out.println("| |              | |");
                System.out.println("| '--------------' |");
                System.out.println(" '----------------' ");
                System.out.println("      " + numero.getColor() + "");
                break;
            case 7:
                System.out.println(" .----------------. ");
                System.out.println("| .--------------. |");
                System.out.println("| |   _______    | |");
                System.out.println("| |  |  ___  |   | |");
                System.out.println("| |  |_/  / /    | |");
                System.out.println("| |      / /     | |");
                System.out.println("| |     / /      | |");
                System.out.println("| |    /_/       | |");
                System.out.println("| |              | |");
                System.out.println("| '--------------' |");
                System.out.println(" '----------------' ");
                System.out.println("      " + numero.getColor() + "");
                break;
            case 8:
                System.out.println(" .----------------. ");
                System.out.println("| .--------------. |");
                System.out.println("| |     ____     | |");
                System.out.println("| |   .' __ '.   | |");
                System.out.println("| |   | (__) |   | |");
                System.out.println("| |   .`____'.   | |");
                System.out.println("| |  | (____) |  | |");
                System.out.println("| |  `.______.'  | |");
                System.out.println("| |              | |");
                System.out.println("| '--------------' |");
                System.out.println(" '----------------' ");
                System.out.println("      " + numero.getColor() + "");
                break;
            case 9:
                System.out.println(" .----------------. ");
                System.out.println("| .--------------. |");
                System.out.println("| |    ______    | |");
                System.out.println("| |  .' ____ '.  | |");
                System.out.println("| |  | (____) |  | |");
                System.out.println("| |  '_.____. |  | |");
                System.out.println("| |  | \\____| |  | |");
                System.out.println("| |   \\______,'  | |");
                System.out.println("| |              | |");
                System.out.println("| '--------------' |");
                System.out.println(" '----------------' ");
                System.out.println("      " + numero.getColor() + "");
                break;
            case 10:
                System.out.println(" .---------------------------. ");
                System.out.println("| .-------------------------. |");
                System.out.println("| |     __                  | |");
                System.out.println("| |    /  |       ____      | |");
                System.out.println("| |    `| |    .'     '.    | |");
                System.out.println("| |     | |    |  .--.  |   | |");
                System.out.println("| |    _| |_   | |    | |   | |");
                System.out.println("| |   |_____|  |  `--'  |   | |");
                System.out.println("| |             '.____.'    | |");
                System.out.println("| '-------------------------' |");
                System.out.println(" '---------------------------' ");
                System.out.println("      " + numero.getColor() + "");
                break;
            case 11:
                System.out.println(" .---------------------------. ");
                System.out.println("| .-------------------------. |");
                System.out.println("| |     __                  | |");
                System.out.println("| |    /  |       __        | |");
                System.out.println("| |    `| |      /  |       | |");
                System.out.println("| |     | |      `| |       | |");
                System.out.println("| |    _| |_      | |       | |");
                System.out.println("| |   |_____|    _| |_      | |");
                System.out.println("| |             |_____|     | |");
                System.out.println("| '-------------------------' |");
                System.out.println(" '---------------------------' ");
                System.out.println("      " + numero.getColor() + "");
                break;
            case 12:
                System.out.println(" .---------------------------. ");
                System.out.println("| .-------------------------. |");
                System.out.println("| |     __                  | |");
                System.out.println("| |    /  |       _____     | |");
                System.out.println("| |    `| |      / ___ `.   | |");
                System.out.println("| |     | |     |_/___) |   | |");
                System.out.println("| |    _| |_     .'____.'   | |");
                System.out.println("| |   |_____|   / /____     | |");
                System.out.println("| |             |_______|   | |");
                System.out.println("| '-------------------------' |");
                System.out.println(" '---------------------------' ");
                System.out.println("      " + numero.getColor() + "");
                break;
        }

    }

    public static void pulsarEnter() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Pulsa Enter para continuar");
        String espacio = teclado.nextLine();
    }

}
