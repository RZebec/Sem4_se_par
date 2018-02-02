public enum Configuration {
    instance;
    public final long maximum = 10000000;
    public final int testingOffset = 10000;
    public int numberOfProcessors = Runtime.getRuntime().availableProcessors();
}