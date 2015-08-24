package tests;

public interface Config {
    final String browser = System.getProperty("browser", "firefox");
}