package com.alipay.mobile.nebulacore.android;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class DynamicProxy {
    DynamicProxy() {
    }

    public static <T> T dynamicProxy(Class<T> cls, final Object obj) {
        AnonymousClass1 r0 = new InvocationHandler() {
            public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                try {
                    return obj.getClass().getMethod(method.getName(), method.getParameterTypes()).invoke(obj, objArr);
                } catch (InvocationTargetException e2) {
                    throw e2.getCause();
                }
            }
        };
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, r0);
    }
}
