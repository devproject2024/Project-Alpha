package com.business.a;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

public final class d extends SSLSocketFactory {

    /* renamed from: a  reason: collision with root package name */
    private SSLSocketFactory f7275a;

    public d() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory instance = TrustManagerFactory.getInstance("X509");
        instance.init((KeyStore) null);
        SSLContext instance2 = SSLContext.getInstance("TLS");
        instance2.init((KeyManager[]) null, instance.getTrustManagers(), (SecureRandom) null);
        this.f7275a = instance2.getSocketFactory();
    }

    public final String[] getDefaultCipherSuites() {
        return this.f7275a.getDefaultCipherSuites();
    }

    public final String[] getSupportedCipherSuites() {
        return this.f7275a.getSupportedCipherSuites();
    }

    public final Socket createSocket(Socket socket, String str, int i2, boolean z) throws IOException {
        return a(this.f7275a.createSocket(socket, str, i2, z));
    }

    public final Socket createSocket(String str, int i2) throws IOException, UnknownHostException {
        return a(this.f7275a.createSocket(str, i2));
    }

    public final Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) throws IOException, UnknownHostException {
        return a(this.f7275a.createSocket(str, i2, inetAddress, i3));
    }

    public final Socket createSocket(InetAddress inetAddress, int i2) throws IOException {
        return a(this.f7275a.createSocket(inetAddress, i2));
    }

    public final Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) throws IOException {
        return a(this.f7275a.createSocket(inetAddress, i2, inetAddress2, i3));
    }

    private static Socket a(Socket socket) {
        if (socket != null && (socket instanceof SSLSocket)) {
            ((SSLSocket) socket).setEnabledProtocols(new String[]{"TLSv1.1", "TLSv1.2"});
        }
        return socket;
    }
}
