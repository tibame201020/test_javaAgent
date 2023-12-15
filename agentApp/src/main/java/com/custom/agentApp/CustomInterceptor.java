package com.custom.agentApp;


import net.bytebuddy.asm.Advice;

import java.time.LocalDateTime;

/**
 * 自定義 Interceptor
 */
public class CustomInterceptor {
//    @RuntimeType
//    public static Object intercept(@Origin Method method,
//                                   @SuperCall Callable<?> callable) throws Exception {
//        long start = System.currentTimeMillis();
//        try {
//            return callable.call();
//        } finally {
//            System.out.println(method + ": took " + (System.currentTimeMillis() - start) + "ms");
//        }
//    }

    @Advice.OnMethodEnter
    public static void entry(@Advice.Origin String method) {
        System.out.printf("at %s, entry method: %s%n", LocalDateTime.now(), method);
    }

    @Advice.OnMethodExit
    public static void exit(@Advice.Origin String method) {
        System.out.printf("at %s, exit method: %s%n", LocalDateTime.now(), method);
    }
}
