

import java.util.ArrayList;
import java.util.List;

import resource.MediaAritmetica;
import threads.ThreadSumatorio;

public class App {

    private static final int CALIFICACIONES_TOTALES = 100000;

    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {

        List<Integer> notas = generarCalificaciones();
        ArrayList<ThreadSumatorio> threads = new ArrayList<>();

        final int numThreads = 10;
        int notasPorThread = notas.size() / numThreads;

        for (int i = 0; i < numThreads; i++) {
            int startIndex = i * notasPorThread;
            int endIndex = startIndex + notasPorThread;
            threads.add(new ThreadSumatorio((i + 1), startIndex, endIndex, notas));
            threads.get(i).start();
        }

        System.out.println(ANSI_RED + "Todos los hilos han acabado su tarea" + ANSI_RESET   );

        MediaAritmetica mediaArit = new MediaAritmetica(notas, threads);
        mediaArit.calcularMedia(notas, threads);
    }

    private static List<Integer> generarCalificaciones() {

        List<Integer> califications = new ArrayList<>();

        for (int i = 0; i < CALIFICACIONES_TOTALES; i++) {
            int randomCalification = (int) (Math.random() * 11);
            califications.add(randomCalification);
        }

        return califications;
    }
}
