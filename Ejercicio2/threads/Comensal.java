package Ejercicio2.threads;

import java.util.logging.Level;
import java.util.logging.Logger;

import Ejercicio2.resource.Mesa;

public class Comensal extends Thread {
    
    private String nombre;
    private Mesa mesa;

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    public Comensal(String nombre, Mesa mesa) {
        this.nombre = nombre;
        this.mesa = mesa;
    }

    public void run() {
        while(true) {
            try {

                System.out.println(ANSI_RED + getNombre() + " ha cogido una magdalena de la mesa" + ANSI_RESET);

                getMesa().consumir();
                sleep(10000);

                System.out.println(ANSI_GREEN + getNombre() + " se ha terminado de comer una magdalena" + ANSI_RESET);

                if (getMesa().getNumMagdalenas() == 0) {
                    System.exit(0);
                }

            } catch (InterruptedException ex) {
                Logger.getLogger(Comensal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public Mesa getMesa() {
        return mesa;
    } 
}
