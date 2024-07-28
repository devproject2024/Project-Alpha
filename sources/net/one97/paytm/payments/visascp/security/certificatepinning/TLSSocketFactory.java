package net.one97.paytm.payments.visascp.security.certificatepinning;

import android.os.Build;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import net.one97.paytm.payments.visascp.network.model.VisaCertificateData;

public class TLSSocketFactory extends SSLSocketFactory {

    /* renamed from: ॱ  reason: contains not printable characters */
    private SSLSocketFactory f642;

    public TLSSocketFactory(ArrayList<VisaCertificateData> arrayList) throws KeyManagementException, NoSuchAlgorithmException {
        SSLContext instance = SSLContext.getInstance("TLS");
        instance.init((KeyManager[]) null, new TrustManager[]{new VisaPubKeyManager(arrayList)}, (SecureRandom) null);
        this.f642 = instance.getSocketFactory();
    }

    public String[] getDefaultCipherSuites() {
        return this.f642.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return this.f642.getSupportedCipherSuites();
    }

    public Socket createSocket(Socket socket, String str, int i2, boolean z) throws IOException {
        return m718(this.f642.createSocket(socket, str, i2, z));
    }

    public Socket createSocket(String str, int i2) throws IOException {
        return m718(this.f642.createSocket(str, i2));
    }

    public Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) throws IOException {
        return m718(this.f642.createSocket(str, i2, inetAddress, i3));
    }

    public Socket createSocket(InetAddress inetAddress, int i2) throws IOException {
        return m718(this.f642.createSocket(inetAddress, i2));
    }

    public Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) throws IOException {
        return m718(this.f642.createSocket(inetAddress, i2, inetAddress2, i3));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static Socket m718(Socket socket) {
        if (socket != null && (socket instanceof SSLSocket)) {
            SSLSocket sSLSocket = (SSLSocket) socket;
            String[] enabledProtocols = sSLSocket.getEnabledProtocols();
            if (Build.VERSION.SDK_INT < 16) {
                sSLSocket.setEnabledProtocols(enabledProtocols);
            } else {
                sSLSocket.setEnabledProtocols(m719(enabledProtocols));
            }
        }
        return socket;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static String[] m719(String[] strArr) {
        ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
        boolean z = false;
        boolean z2 = false;
        for (String str : strArr) {
            if (str.equals("TLSv1.1")) {
                z = true;
            }
            if (str.equals("TLSv1.2")) {
                z2 = true;
            }
        }
        if (!z) {
            arrayList.add("TLSv1.1");
        }
        if (!z2) {
            arrayList.add("TLSv1.2");
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
