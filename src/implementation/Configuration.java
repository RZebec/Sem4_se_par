package implementation;

/**
 * The Configuration for the Search of Consecutive integers and prime factors.
 */
public enum Configuration {
    instance;
    /**
     * The upper limit to search for such numbers.
     */
    public final long maximum = 100000000;
    /**
     * The offset to spread the testing ranges between the threads.
     */
    public final int testingOffset = 10000;
    /**
     * The value at witch the process will timeout.
     */
    public final int timeout = 900000;
    /**
     * The number of available processor cores on the system.
     */
    public int numberOfProcessors = Runtime.getRuntime().availableProcessors();
}