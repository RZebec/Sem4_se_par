package implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Application that searches consecutive integers and their biggest prime factors, where the prime factors are smaller than the natural logarithm of the numbers.
 */
public class Application {
    public static void main(String... args) {
        long rangeEndStartValue = 1;
        long runtimeStart = System.currentTimeMillis();

        System.out.println("Searching for pairs: ");

        try {
            final List<Callable<Void>> partitions = new ArrayList<>();
            final ExecutorService executorPool = Executors.newFixedThreadPool(Configuration.instance.numberOfProcessors);

            for (long i = rangeEndStartValue + Configuration.instance.testingOffset; i <= Configuration.instance.maximum; i += Configuration.instance.testingOffset) {
                final long endOfRange = i;
                final long startOfRange = rangeEndStartValue;
                partitions.add(() -> {
                    ConsecutivePairValidator.testInRange(startOfRange, endOfRange);
                    return null;
                });
                rangeEndStartValue = endOfRange;
            }
            executorPool.invokeAll(partitions,Configuration.instance.timeout, TimeUnit.SECONDS);
            executorPool.shutdown();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("Tested all possible combinations to " + Configuration.instance.maximum);
        System.out.println(System.currentTimeMillis()-runtimeStart + " ms");
    }
}