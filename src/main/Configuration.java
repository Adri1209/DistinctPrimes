package main;

public enum Configuration {
    instance;

    public MersenneTwisterFast  randomGenerator = new MersenneTwisterFast();
    public final int order = 25;
    public int numberOfCores = Runtime.getRuntime().availableProcessors();
}
