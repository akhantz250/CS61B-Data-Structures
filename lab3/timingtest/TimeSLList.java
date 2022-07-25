package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();
        SLList <Integer> sList = new SLList<Integer>(1);
        final int N = 128000;
        int step = 1000;
        // Number of getLast calls
        final int M = 10000;
        for (int i = 2; i <= N; i++) {
            sList.addLast(i);
            if (i == step) {
                Stopwatch sw = new Stopwatch();
                for (int j = 0; j < M; j++) {
                    sList.getLast();
                }
                double timeInSeconds = sw.elapsedTime();
                Ns.addLast(i);
                times.addLast(timeInSeconds);
                opCounts.addLast(M);
                step *= 2;
            }
        }

        printTimingTable(Ns,times,opCounts);
    }

}
