package com.alipay.imobile.network.b;

import android.os.Build;
import com.alipay.iap.android.common.b.c;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public final class a extends SSLSocketFactory {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f14712a = {"SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"};

    /* renamed from: b  reason: collision with root package name */
    private SSLSocketFactory f14713b;

    private a(SSLSocketFactory sSLSocketFactory) {
        this.f14713b = sSLSocketFactory;
    }

    private static Socket a(Socket socket) {
        if (socket instanceof SSLSocket) {
            try {
                ((SSLSocket) socket).setEnabledProtocols(f14712a);
            } catch (Throwable th) {
                "patchTlsSocket error: ".concat(String.valueOf(th));
                c.g();
            }
        }
        return socket;
    }

    public final Socket createSocket() throws IOException {
        return a(this.f14713b.createSocket());
    }

    public final Socket createSocket(String str, int i2) throws IOException, UnknownHostException {
        return a(this.f14713b.createSocket(str, i2));
    }

    public final Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) throws IOException, UnknownHostException {
        return a(this.f14713b.createSocket(str, i2, inetAddress, i3));
    }

    public final Socket createSocket(InetAddress inetAddress, int i2) throws IOException {
        return a(this.f14713b.createSocket(inetAddress, i2));
    }

    public final Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) throws IOException {
        return a(this.f14713b.createSocket(inetAddress, i2, inetAddress2, i3));
    }

    public final Socket createSocket(Socket socket, String str, int i2, boolean z) throws IOException {
        return a(this.f14713b.createSocket(socket, str, i2, z));
    }

    public final String[] getDefaultCipherSuites() {
        return this.f14713b.getDefaultCipherSuites();
    }

    public final String[] getSupportedCipherSuites() {
        return this.f14713b.getSupportedCipherSuites();
    }

    public static SSLSocketFactory a(SSLSocketFactory sSLSocketFactory) {
        boolean z;
        if (sSLSocketFactory == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 16 || Build.VERSION.SDK_INT >= 21) {
            new StringBuilder("[enableTlsSupport] skip for osVersion = ").append(Build.VERSION.SDK_INT);
            c.e();
            z = false;
        } else {
            new StringBuilder("[enableTlsSupport] patch for osVersion = ").append(Build.VERSION.SDK_INT);
            c.e();
            z = true;
        }
        return !z ? sSLSocketFactory : new a(sSLSocketFactory);
    }
}
