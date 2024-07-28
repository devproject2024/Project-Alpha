package com.sendbird.android.shadow.okhttp3.internal.platform;

import com.sendbird.android.shadow.okhttp3.Protocol;
import com.sendbird.android.shadow.okhttp3.internal.Util;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

final class b extends Platform {

    /* renamed from: a  reason: collision with root package name */
    final Method f45202a;

    /* renamed from: b  reason: collision with root package name */
    final Method f45203b;

    private b(Method method, Method method2) {
        this.f45202a = method;
        this.f45203b = method2;
    }

    public final void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> alpnProtocolNames = alpnProtocolNames(list);
            this.f45202a.invoke(sSLParameters, new Object[]{alpnProtocolNames.toArray(new String[alpnProtocolNames.size()])});
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw Util.assertionError("unable to set ssl parameters", e2);
        }
    }

    public final String getSelectedProtocol(SSLSocket sSLSocket) {
        try {
            String str = (String) this.f45203b.invoke(sSLSocket, new Object[0]);
            if (str == null || str.equals("")) {
                return null;
            }
            return str;
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw Util.assertionError("unable to get selected protocols", e2);
        }
    }

    public final X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 9+");
    }

    public static b a() {
        try {
            return new b(SSLParameters.class.getMethod("setApplicationProtocols", new Class[]{String[].class}), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }
}
