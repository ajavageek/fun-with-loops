package ch.frankel.blog.instrumentation;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.implementation.SuperMethodCall;

import java.lang.instrument.Instrumentation;

import static net.bytebuddy.matcher.ElementMatchers.*;

public class Repeater {

    public static void premain(String arguments, Instrumentation instrumentation) {
        var withRepeatAnnotation = isAnnotatedWith(named("ch.frankel.blog.instrumentation.Repeat"));
        new AgentBuilder.Default()
                .type(declaresMethod(withRepeatAnnotation))
                .transform((builder, typeDescription, classLoader, module, protectionDomain) -> builder
                        .method(withRepeatAnnotation)
                        .intercept(SuperMethodCall.INSTANCE
                                .andThen(SuperMethodCall.INSTANCE)
                                .andThen(SuperMethodCall.INSTANCE))
                ).installOn(instrumentation);
    }
}
