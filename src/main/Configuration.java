package main;

public enum Configuration {
    instance;

    public final int order = 12000;
    public int numberOfCores = Runtime.getRuntime().availableProcessors();
}
