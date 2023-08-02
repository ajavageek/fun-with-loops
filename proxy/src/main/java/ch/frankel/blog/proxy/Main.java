package ch.frankel.blog.proxy;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        var logger = new ConsoleLogger();
        var proxy = (Logger) Proxy.newProxyInstance(
                Main.class.getClassLoader(),
                new Class[]{Logger.class},
                new RepeatingInvocationHandler(logger, 3));
        proxy.log("Hello world!");
    }
}
