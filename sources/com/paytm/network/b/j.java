package com.paytm.network.b;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public final class j extends SSLSocketFactory {

    /* renamed from: a  reason: collision with root package name */
    private SSLSocketFactory f42899a;

    public j(X509TrustManager x509TrustManager) throws KeyManagementException, NoSuchAlgorithmException {
        SSLContext instance = SSLContext.getInstance("TLS");
        instance.init((KeyManager[]) null, new TrustManager[]{x509TrustManager}, (SecureRandom) null);
        this.f42899a = instance.getSocketFactory();
    }

    public j() throws KeyManagementException, NoSuchAlgorithmException {
        SSLContext instance = SSLContext.getInstance("TLS");
        instance.init((KeyManager[]) null, (TrustManager[]) null, (SecureRandom) null);
        this.f42899a = instance.getSocketFactory();
    }

    public final String[] getDefaultCipherSuites() {
        return this.f42899a.getDefaultCipherSuites();
    }

    public final String[] getSupportedCipherSuites() {
        return this.f42899a.getSupportedCipherSuites();
    }

    public final Socket createSocket() throws IOException {
        return a(this.f42899a.createSocket());
    }

    public final Socket createSocket(Socket socket, String str, int i2, boolean z) throws IOException {
        return a(this.f42899a.createSocket(socket, str, i2, z));
    }

    public final Socket createSocket(String str, int i2) throws IOException, UnknownHostException {
        return a(this.f42899a.createSocket(str, i2));
    }

    public final Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) throws IOException, UnknownHostException {
        return a(this.f42899a.createSocket(str, i2, inetAddress, i3));
    }

    public final Socket createSocket(InetAddress inetAddress, int i2) throws IOException {
        return a(this.f42899a.createSocket(inetAddress, i2));
    }

    public final Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) throws IOException {
        return a(this.f42899a.createSocket(inetAddress, i2, inetAddress2, i3));
    }

    private static Socket a(Socket socket) {
        if (socket != null && (socket instanceof SSLSocket)) {
            ((SSLSocket) socket).setEnabledProtocols(new String[]{"TLSv1.2", "TLSv1.1"});
        }
        return socket;
    }
}
