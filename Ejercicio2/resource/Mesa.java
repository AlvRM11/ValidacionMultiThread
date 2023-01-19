package Ejercicio2.resource;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Mesa {

    private int numMagdalenas;
    private boolean mesaOcupada;

    public Mesa() {
        this.numMagdalenas = 15;
        this.mesaOcupada = false;
    }

    public synchronized void consumir() {

        while(isMesaOcupada()) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Mesa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        setMesaOcupada(true);
        setNumMagdalenas(getNumMagdalenas() - 1);

        setMesaOcupada(false);
        
        notifyAll();
    }

    public int getNumMagdalenas() {
        return numMagdalenas;
    }

    public void setNumMagdalenas(int numMagdalenas) {
        this.numMagdalenas = numMagdalenas;
    }

    public boolean isMesaOcupada() {
        return mesaOcupada;
    }

    public void setMesaOcupada(boolean mesaOcupada) {
        this.mesaOcupada = mesaOcupada;
    } 
}
