package Ejercicio2;

import Ejercicio2.resource.Mesa;
import Ejercicio2.threads.Comensal;

public class App {
    
    public static void main(String[] args) {

        Mesa mesa = new Mesa();

        Comensal adrian = new Comensal("Adrián", mesa);
        Comensal goyo = new Comensal("Goyo", mesa);
        Comensal alvaro = new Comensal("Álvaro", mesa);

        adrian.setPriority(Thread.MIN_PRIORITY);
        goyo.setPriority(Thread.NORM_PRIORITY);
        alvaro.setPriority(Thread.MAX_PRIORITY);

        adrian.start();
        goyo.start();
        alvaro.start();
    }
}
