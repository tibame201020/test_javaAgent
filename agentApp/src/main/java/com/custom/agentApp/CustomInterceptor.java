package com.custom.agentApp;


import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;

import java.lang.reflect.Method;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.Callable;

/**
 * focus method execute
 */
public class CustomInterceptor {
    @RuntimeType
    public static Object intercept(@Origin Method method,
                                   @SuperCall Callable<?> callable) throws Exception {
        LocalDateTime start = LocalDateTime.now();
        try {
            return callable.call();
        } finally {
            Duration duration = Duration.between(LocalDateTime.now(), start);
            System.out.printf("%s take %s mills%n", method, duration.toMillis());
        }
    }
}
