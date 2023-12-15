package com.custom.agentApp;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.utility.JavaModule;

public class AgentListener implements AgentBuilder.Listener {
    @Override
    public void onDiscovery(String s, ClassLoader classLoader, JavaModule javaModule, boolean b) {
        printListenerEventInfo("onDiscovery", s, classLoader, javaModule, b, null);
    }

    @Override
    public void onTransformation(TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule, boolean b, DynamicType dynamicType) {
        printListenerEventInfo("onTransformation", typeDescription, classLoader, javaModule, b, null);
    }

    @Override
    public void onIgnored(TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule, boolean b) {
        printListenerEventInfo("onIgnored", typeDescription, classLoader, javaModule, b, null);
    }

    @Override
    public void onError(String s, ClassLoader classLoader, JavaModule javaModule, boolean b, Throwable throwable) {
        printListenerEventInfo("onComplete", s, classLoader, javaModule, b, null);
    }

    @Override
    public void onComplete(String s, ClassLoader classLoader, JavaModule javaModule, boolean b) {
        printListenerEventInfo("onComplete", s, classLoader, javaModule, b, null);
    }

    private void printListenerEventInfo(String eventName, Object s, ClassLoader classLoader, JavaModule javaModule, boolean b, Throwable throwable) {
        System.out.println("=== in listener " + eventName);
        System.out.println(s);
        System.out.println(classLoader);
        System.out.println(javaModule);
        System.out.println(b);
        if (null != throwable) {
            System.out.println(throwable.getMessage());
        }
    }
}
