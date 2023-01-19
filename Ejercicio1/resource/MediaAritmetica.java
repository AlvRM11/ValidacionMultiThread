package resource;

import java.util.ArrayList;
import java.util.List;

import threads.ThreadSumatorio;

public class MediaAritmetica {

    private int totalSum;
    private List<Integer> notas;
    private ArrayList<ThreadSumatorio> threads;

    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RESET = "\u001B[0m";

    public MediaAritmetica(List<Integer> notas, ArrayList<ThreadSumatorio> threads) {
        this.notas = notas;
        this.threads = threads;
        this.totalSum = 0;
    }

    public void calcularMedia(List<Integer> notas, ArrayList<ThreadSumatorio> threads) {

        for (ThreadSumatorio thread : threads) {
            try {
                thread.join();
                setTotalSum(thread.getTotalSum());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        double media = ((double) getTotalSum() / getNotas().size());

        System.out.println(ANSI_GREEN + "La media aritmética es de " + media + ANSI_RESET);
    }

    public int getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(int totalSum) {
        this.totalSum += totalSum;
    }

    public List<Integer> getNotas() {
        return notas;
    }

    public void setNotas(List<Integer> notas) {
        this.notas = notas;
    }

    public ArrayList<ThreadSumatorio> getThreads() {
        return threads;
    }

    public void setThreads(ArrayList<ThreadSumatorio> threads) {
        this.threads = threads;
    }   
}