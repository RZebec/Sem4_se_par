import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 ** Java Program to implement Pollard Rho Algorithm
 **/
public class Application {
    public static void main(String... args) {
        long rangeEndStartValue = 1;
        long runtimeStart = System.currentTimeMillis();

        try {
            final List<Callable<Long>> partitions = new ArrayList<>();
            final ExecutorService executorPool = Executors.newFixedThreadPool(Configuration.instance.numberOfProcessors);

            for (long i = rangeEndStartValue + 10000; i <= Configuration.instance.maximum; i+=100) {
                final long endOfRange = i;
                final long startOfRange = rangeEndStartValue;
                partitions.add(new Callable<Long>() {
                    public Long call() {
                        ConsecutivePairValidator.testInRange(startOfRange, endOfRange);
                        //System.out.println("Test to: " + endOfRange + " finished.");
                        return endOfRange;
                    }
                });
                rangeEndStartValue = endOfRange;
            }

            final List<Future<Long>> resultFromParts = executorPool.invokeAll(partitions,60000000, TimeUnit.SECONDS);
            executorPool.shutdown();

            for (final Future<Long> result : resultFromParts) {
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println(System.currentTimeMillis()-runtimeStart + " ms");
    }
}