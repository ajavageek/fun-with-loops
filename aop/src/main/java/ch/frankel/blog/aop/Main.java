package ch.frankel.blog.aop;

public class Main {

    public static void main(String[] args) {
        log("Hello world!");
    }

    @Repeat(times = 3)
    public static void log(String message) {
        new ConsoleLogger().log(message);
    }
}
