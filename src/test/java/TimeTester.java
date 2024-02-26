public class TimeTester {
    public static int runCount;
    public static int runMax;

    public TimeTester(int max) {runMax = max;}

    public long test(Runnable task) {
        long s = System.nanoTime();
        for (int i = 0; i < runMax; i++) {
            task.run();
        }
        long e = System.nanoTime();
        reset();
        return e - s;
    }

    public void reset() {
        runCount = 0;
    }
}
