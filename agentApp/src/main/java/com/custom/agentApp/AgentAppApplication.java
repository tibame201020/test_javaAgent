package com.custom.agentApp;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class AgentAppApplication {

    /**
     * premain 註冊 bytebuddy AgentBuilder
     */
    public static void premain(String agentArgs, Instrumentation instrumentation) {
        new AgentBuilder.Default()
                .type(ElementMatchers.nameStartsWith("org.springframework.boot"))
                .transform((builder, typeDescription, classLoader, module, domain) -> builder.visit(Advice.to(SpringBootInterceptor.class).on(ElementMatchers.isMethod())))
                .installOn(instrumentation);
    }

    /**
     * OnMethodEnter
     */
    public static class SpringBootInterceptor {
        @Advice.OnMethodEnter
        public static void enter(@Advice.Origin String method) {
            String sysdate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss",Locale.TAIWAN));
            System.out.printf("at %s, entry point: %s%n", sysdate, method);
        }
    }

}
