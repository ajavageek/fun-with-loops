package ch.frankel.blog.decorator;

public class RepeatingDecorator implements Logger {

    private final Logger logger;
    private final int times;

    public RepeatingDecorator(Logger logger, int times) {
        this.logger = logger;
        this.times = times;
    }

    @Override
    public void log(String message) {
        for (int i = 0; i < times; i++) {
            logger.log(message);
        }
    }
}
