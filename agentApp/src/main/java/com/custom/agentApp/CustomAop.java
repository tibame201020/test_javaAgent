package com.custom.agentApp;

import net.bytebuddy.asm.Advice;

import java.time.LocalDateTime;

/**
 * focus method entry and exit
 */
public class CustomAop {
    @Advice.OnMethodEnter
    public static void entry(@Advice.Origin String method) {
        System.out.printf("at %s, entry method: %s%n", LocalDateTime.now(), method);
    }

    @Advice.OnMethodExit
    public static void exit(@Advice.Origin String method) {
        System.out.printf("at %s, exit method: %s%n", LocalDateTime.now(), method);
    }
}
