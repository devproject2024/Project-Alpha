package com.google.android.gms.measurement.internal;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

final class jt extends SSLSocketFactory {

    /* renamed from: a  reason: collision with root package name */
    private final SSLSocketFactory f12295a;

    jt() {
        this(HttpsURLConnection.getDefaultSSLSocketFactory());
    }

    private jt(SSLSocketFactory sSLSocketFactory) {
        this.f12295a = sSLSocketFactory;
    }

    public final Socket createSocket(Socket socket, String str, int i2, boolean z) throws IOException {
        return a((SSLSocket) this.f12295a.createSocket(socket, str, i2, z));
    }

    public final String[] getDefaultCipherSuites() {
        return this.f12295a.getDefaultCipherSuites();
    }

    public final String[] getSupportedCipherSuites() {
        return this.f12295a.getSupportedCipherSuites();
    }

    public final Socket createSocket(String str, int i2) throws IOException {
        return a((SSLSocket) this.f12295a.createSocket(str, i2));
    }

    public final Socket createSocket(InetAddress inetAddress, int i2) throws IOException {
        return a((SSLSocket) this.f12295a.createSocket(inetAddress, i2));
    }

    public final Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) throws IOException {
        return a((SSLSocket) this.f12295a.createSocket(str, i2, inetAddress, i3));
    }

    public final Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) throws IOException {
        return a((SSLSocket) this.f12295a.createSocket(inetAddress, i2, inetAddress2, i3));
    }

    public final Socket createSocket() throws IOException {
        return a((SSLSocket) this.f12295a.createSocket());
    }

    private static SSLSocket a(SSLSocket sSLSocket) {
        return new js(sSLSocket);
    }
}
