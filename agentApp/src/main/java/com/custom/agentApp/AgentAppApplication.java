package com.custom.agentApp;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;

public class AgentAppApplication {

    /**
     * premain 註冊 bytebuddy
     */
    public static void premain(String agentArgs, Instrumentation instrumentation) {
        System.out.println("in AgentAppApplication premain.");

        new AgentBuilder
                .Default()
                .type(ElementMatchers.nameStartsWith("com.custom.beAgentApp"))
                .transform(transformer())
//                .with(new AgentListener())
                .installOn(instrumentation);
    }

    private static AgentBuilder.Transformer transformer() {
        return (builder, typeDescription, classLoader, javaModule, protectionDomain)
                -> builder.visit(Advice.to(CustomInterceptor.class).on(ElementMatchers.any()));

    }

}
