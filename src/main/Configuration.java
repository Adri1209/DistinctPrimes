package main;

public enum Configuration {
    instance;

    public final int order = 121;
    public int numberOfCores = Runtime.getRuntime().availableProcessors();
}
