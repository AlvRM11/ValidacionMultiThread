package threads;

import java.util.List;

public class ThreadSumatorio extends Thread {

    private int threadId;
    private int startIndex;
    private int endIndex;
    private List<Integer> notas;
    private int totalSum;

    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_RESET = "\u001B[0m";

    public ThreadSumatorio(int threadId, int startIndex, int endIndex, List<Integer> notas) {
        this.threadId = threadId;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.notas = notas;
        this.totalSum = 0;
    }

    public void run() {

        for (int i = getStartIndex(); i < getEndIndex(); i++) {
            setTotalSum(getNotas().get(i));
        }
        
        System.out.println(ANSI_YELLOW + "El hilo " + getThreadId() + ", que empezó en el índice " + getStartIndex() + " y ha contado " + (getEndIndex() - getStartIndex()) + " calificaciones, ha sumado un total de: " + getTotalSum() + ANSI_RESET);
    }

    public int getTotalSum() {
        return totalSum;
    }

    public int getThreadId() {
        return threadId;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public List<Integer> getNotas() {
        return notas;
    }

    public void setTotalSum(int totalSum) {
        this.totalSum += totalSum;
    }
}
