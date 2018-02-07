package main;

public enum Configuration {
    instance;

    public final int order = 25000;
    public int numberOfCores = Runtime.getRuntime().availableProcessors();
}
