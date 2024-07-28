package com.sendbird.android.shadow.okhttp3.internal.platform;

import com.sendbird.android.shadow.okhttp3.Protocol;
import com.sendbird.android.shadow.okhttp3.internal.Util;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

final class c extends Platform {

    /* renamed from: a  reason: collision with root package name */
    private final Method f45204a;

    /* renamed from: b  reason: collision with root package name */
    private final Method f45205b;

    /* renamed from: c  reason: collision with root package name */
    private final Method f45206c;

    /* renamed from: d  reason: collision with root package name */
    private final Class<?> f45207d;

    /* renamed from: e  reason: collision with root package name */
    private final Class<?> f45208e;

    private c(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f45204a = method;
        this.f45205b = method2;
        this.f45206c = method3;
        this.f45207d = cls;
        this.f45208e = cls2;
    }

    public final void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) {
        List<String> alpnProtocolNames = alpnProtocolNames(list);
        try {
            Object newProxyInstance = Proxy.newProxyInstance(Platform.class.getClassLoader(), new Class[]{this.f45207d, this.f45208e}, new a(alpnProtocolNames));
            this.f45204a.invoke((Object) null, new Object[]{sSLSocket, newProxyInstance});
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw Util.assertionError("unable to set alpn", e2);
        }
    }

    public final void afterHandshake(SSLSocket sSLSocket) {
        try {
            this.f45206c.invoke((Object) null, new Object[]{sSLSocket});
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw Util.assertionError("unable to remove alpn", e2);
        }
    }

    public final String getSelectedProtocol(SSLSocket sSLSocket) {
        try {
            a aVar = (a) Proxy.getInvocationHandler(this.f45205b.invoke((Object) null, new Object[]{sSLSocket}));
            if (!aVar.f45209a && aVar.f45210b == null) {
                Platform.get().log(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            } else if (aVar.f45209a) {
                return null;
            } else {
                return aVar.f45210b;
            }
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw Util.assertionError("unable to get selected protocol", e2);
        }
    }

    public static Platform a() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$Provider");
            Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ClientProvider");
            Class<?> cls4 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ServerProvider");
            Method method = cls.getMethod("put", new Class[]{SSLSocket.class, cls2});
            return new c(method, cls.getMethod("get", new Class[]{SSLSocket.class}), cls.getMethod("remove", new Class[]{SSLSocket.class}), cls3, cls4);
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    static class a implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        boolean f45209a;

        /* renamed from: b  reason: collision with root package name */
        String f45210b;

        /* renamed from: c  reason: collision with root package name */
        private final List<String> f45211c;

        a(List<String> list) {
            this.f45211c = list;
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = Util.EMPTY_STRING_ARRAY;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f45209a = true;
                return null;
            } else if (name.equals("protocols") && objArr.length == 0) {
                return this.f45211c;
            } else {
                if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List)) {
                    List list = (List) objArr[0];
                    int size = list.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        if (this.f45211c.contains(list.get(i2))) {
                            String str = (String) list.get(i2);
                            this.f45210b = str;
                            return str;
                        }
                    }
                    String str2 = this.f45211c.get(0);
                    this.f45210b = str2;
                    return str2;
                } else if ((!name.equals("protocolSelected") && !name.equals(SDKConstants.SELECTED)) || objArr.length != 1) {
                    return method.invoke(this, objArr);
                } else {
                    this.f45210b = (String) objArr[0];
                    return null;
                }
            }
        }
    }
}
