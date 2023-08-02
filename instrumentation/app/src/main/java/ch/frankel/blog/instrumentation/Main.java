package ch.frankel.blog.instrumentation;

public class Main {

    public static void main(String[] args) {
        log("Hello world");
    }

    @Repeat
    private static void log(String message) {
        System.out.println(message);
    }
}
