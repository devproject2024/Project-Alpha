package com.sendbird.android.shadow.okhttp3.internal.platform;

import android.os.Build;
import android.util.Log;
import com.sendbird.android.shadow.okhttp3.Protocol;
import com.sendbird.android.shadow.okhttp3.internal.Util;
import com.sendbird.android.shadow.okhttp3.internal.tls.CertificateChainCleaner;
import com.sendbird.android.shadow.okhttp3.internal.tls.TrustRootIndex;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

final class a extends Platform {

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f45189a;

    /* renamed from: b  reason: collision with root package name */
    private final d<Socket> f45190b;

    /* renamed from: c  reason: collision with root package name */
    private final d<Socket> f45191c;

    /* renamed from: d  reason: collision with root package name */
    private final d<Socket> f45192d;

    /* renamed from: e  reason: collision with root package name */
    private final d<Socket> f45193e;

    /* renamed from: f  reason: collision with root package name */
    private final c f45194f = c.a();

    private a(Class<?> cls, d<Socket> dVar, d<Socket> dVar2, d<Socket> dVar3, d<Socket> dVar4) {
        this.f45189a = cls;
        this.f45190b = dVar;
        this.f45191c = dVar2;
        this.f45192d = dVar3;
        this.f45193e = dVar4;
    }

    public final void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int i2) throws IOException {
        try {
            socket.connect(inetSocketAddress, i2);
        } catch (AssertionError e2) {
            if (Util.isAndroidGetsocknameError(e2)) {
                throw new IOException(e2);
            }
            throw e2;
        } catch (SecurityException e3) {
            IOException iOException = new IOException("Exception in connect");
            iOException.initCause(e3);
            throw iOException;
        } catch (ClassCastException e4) {
            if (Build.VERSION.SDK_INT == 26) {
                IOException iOException2 = new IOException("Exception in connect");
                iOException2.initCause(e4);
                throw iOException2;
            }
            throw e4;
        }
    }

    /* access modifiers changed from: protected */
    public final X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        Object readFieldOrNull = readFieldOrNull(sSLSocketFactory, this.f45189a, "sslParameters");
        if (readFieldOrNull == null) {
            try {
                readFieldOrNull = readFieldOrNull(sSLSocketFactory, Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, sSLSocketFactory.getClass().getClassLoader()), "sslParameters");
            } catch (ClassNotFoundException unused) {
                return super.trustManager(sSLSocketFactory);
            }
        }
        X509TrustManager x509TrustManager = (X509TrustManager) readFieldOrNull(readFieldOrNull, X509TrustManager.class, "x509TrustManager");
        if (x509TrustManager != null) {
            return x509TrustManager;
        }
        return (X509TrustManager) readFieldOrNull(readFieldOrNull, X509TrustManager.class, "trustManager");
    }

    public final void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) {
        if (str != null) {
            this.f45190b.a(sSLSocket, Boolean.TRUE);
            this.f45191c.a(sSLSocket, str);
        }
        d<Socket> dVar = this.f45193e;
        if (dVar != null && dVar.a(sSLSocket)) {
            this.f45193e.b(sSLSocket, concatLengthPrefixed(list));
        }
    }

    public final String getSelectedProtocol(SSLSocket sSLSocket) {
        byte[] bArr;
        d<Socket> dVar = this.f45192d;
        if (dVar == null || !dVar.a(sSLSocket) || (bArr = (byte[]) this.f45192d.b(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, Util.UTF_8);
    }

    public final void log(int i2, String str, Throwable th) {
        int min;
        int i3 = 5;
        if (i2 != 5) {
            i3 = 3;
        }
        if (th != null) {
            str = str + 10 + Log.getStackTraceString(th);
        }
        int i4 = 0;
        int length = str.length();
        while (i4 < length) {
            int indexOf = str.indexOf(10, i4);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i4 + 4000);
                Log.println(i3, "OkHttp", str.substring(i4, min));
                if (min >= indexOf) {
                    break;
                }
                i4 = min;
            }
            i4 = min + 1;
        }
    }

    public final Object getStackTraceForCloseable(String str) {
        return this.f45194f.a(str);
    }

    public final void logCloseableLeak(String str, Object obj) {
        if (!this.f45194f.a(obj)) {
            log(5, str, (Throwable) null);
        }
    }

    public final boolean isCleartextTrafficPermitted(String str) {
        if (Build.VERSION.SDK_INT < 23) {
            return super.isCleartextTrafficPermitted(str);
        }
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return a(str, cls, cls.getMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.isCleartextTrafficPermitted(str);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
            throw Util.assertionError("unable to determine cleartext support", e2);
        }
    }

    private boolean a(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[]{String.class}).invoke(obj, new Object[]{str})).booleanValue();
        } catch (NoSuchMethodException unused) {
            return b(str, cls, obj);
        }
    }

    private boolean b(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.isCleartextTrafficPermitted(str);
        }
    }

    private static boolean b() {
        if (Security.getProvider("GMSCore_OpenSSL") != null) {
            return true;
        }
        try {
            Class.forName("android.net.Network");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C0760a(cls.getConstructor(new Class[]{X509TrustManager.class}).newInstance(new Object[]{x509TrustManager}), cls.getMethod("checkServerTrusted", new Class[]{X509Certificate[].class, String.class, String.class}));
        } catch (Exception unused) {
            return super.buildCertificateChainCleaner(x509TrustManager);
        }
    }

    public static Platform a() {
        Class<?> cls;
        d dVar;
        d dVar2;
        Class<byte[]> cls2 = byte[].class;
        try {
            cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
        } catch (ClassNotFoundException unused) {
            try {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            } catch (ClassNotFoundException unused2) {
                return null;
            }
        }
        Class<?> cls3 = cls;
        d dVar3 = new d((Class<?>) null, "setUseSessionTickets", Boolean.TYPE);
        d dVar4 = new d((Class<?>) null, "setHostname", String.class);
        if (b()) {
            d dVar5 = new d(cls2, "getAlpnSelectedProtocol", new Class[0]);
            dVar = new d((Class<?>) null, "setAlpnProtocols", cls2);
            dVar2 = dVar5;
        } else {
            dVar2 = null;
            dVar = null;
        }
        return new a(cls3, dVar3, dVar4, dVar2, dVar);
    }

    public final TrustRootIndex buildTrustRootIndex(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[]{X509Certificate.class});
            declaredMethod.setAccessible(true);
            return new b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.buildTrustRootIndex(x509TrustManager);
        }
    }

    /* renamed from: com.sendbird.android.shadow.okhttp3.internal.platform.a$a  reason: collision with other inner class name */
    static final class C0760a extends CertificateChainCleaner {

        /* renamed from: a  reason: collision with root package name */
        private final Object f45195a;

        /* renamed from: b  reason: collision with root package name */
        private final Method f45196b;

        public final int hashCode() {
            return 0;
        }

        C0760a(Object obj, Method method) {
            this.f45195a = obj;
            this.f45196b = method;
        }

        public final List<Certificate> clean(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                return (List) this.f45196b.invoke(this.f45195a, new Object[]{(X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str});
            } catch (InvocationTargetException e2) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e2.getMessage());
                sSLPeerUnverifiedException.initCause(e2);
                throw sSLPeerUnverifiedException;
            } catch (IllegalAccessException e3) {
                throw new AssertionError(e3);
            }
        }

        public final boolean equals(Object obj) {
            return obj instanceof C0760a;
        }
    }

    static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final Method f45199a;

        /* renamed from: b  reason: collision with root package name */
        private final Method f45200b;

        /* renamed from: c  reason: collision with root package name */
        private final Method f45201c;

        private c(Method method, Method method2, Method method3) {
            this.f45199a = method;
            this.f45200b = method2;
            this.f45201c = method3;
        }

        /* access modifiers changed from: package-private */
        public final Object a(String str) {
            Method method = this.f45199a;
            if (method != null) {
                try {
                    Object invoke = method.invoke((Object) null, new Object[0]);
                    this.f45200b.invoke(invoke, new Object[]{str});
                    return invoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public final boolean a(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                this.f45201c.invoke(obj, new Object[0]);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        static c a() {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod("get", new Class[0]);
                method = cls.getMethod("open", new Class[]{String.class});
                method2 = cls.getMethod("warnIfOpen", new Class[0]);
                method3 = method4;
            } catch (Exception unused) {
                method2 = null;
                method = null;
            }
            return new c(method3, method, method2);
        }
    }

    static final class b implements TrustRootIndex {

        /* renamed from: a  reason: collision with root package name */
        private final X509TrustManager f45197a;

        /* renamed from: b  reason: collision with root package name */
        private final Method f45198b;

        b(X509TrustManager x509TrustManager, Method method) {
            this.f45198b = method;
            this.f45197a = x509TrustManager;
        }

        public final X509Certificate findByIssuerAndSignature(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f45198b.invoke(this.f45197a, new Object[]{x509Certificate});
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
            } catch (IllegalAccessException e2) {
                throw Util.assertionError("unable to get issues and signature", e2);
            } catch (InvocationTargetException unused) {
            }
            return null;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f45197a.equals(bVar.f45197a) && this.f45198b.equals(bVar.f45198b);
        }

        public final int hashCode() {
            return this.f45197a.hashCode() + (this.f45198b.hashCode() * 31);
        }
    }

    public final SSLContext getSSLContext() {
        boolean z = true;
        try {
            if (Build.VERSION.SDK_INT < 16 || Build.VERSION.SDK_INT >= 22) {
                z = false;
            }
        } catch (NoClassDefFoundError unused) {
        }
        if (z) {
            try {
                return SSLContext.getInstance("TLSv1.2");
            } catch (NoSuchAlgorithmException unused2) {
            }
        }
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalStateException("No TLS provider", e2);
        }
    }
}
