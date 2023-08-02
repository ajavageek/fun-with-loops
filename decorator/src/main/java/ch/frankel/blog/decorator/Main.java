package ch.frankel.blog.decorator;

public class Main {

    public static void main(String[] args) {
        var logger = new ConsoleLogger();
        var threeTimesLogger = new RepeatingDecorator(logger, 3);
        threeTimesLogger.log("Hello world!");
    }
}
