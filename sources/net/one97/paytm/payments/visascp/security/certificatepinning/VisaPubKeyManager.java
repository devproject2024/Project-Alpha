package net.one97.paytm.payments.visascp.security.certificatepinning;

import android.util.Base64;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;
import java.util.ArrayList;
import java.util.Iterator;
import javax.net.ssl.X509TrustManager;
import net.one97.paytm.payments.visascp.network.model.VisaCertificateData;
import net.one97.paytm.payments.visascp.util.VisaSCPConstants;

public class VisaPubKeyManager implements X509TrustManager {

    /* renamed from: ˋ  reason: contains not printable characters */
    private ArrayList<VisaCertificateData> f643;

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
    }

    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }

    public VisaPubKeyManager(ArrayList<VisaCertificateData> arrayList) {
        this.f643 = arrayList;
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        if (x509CertificateArr == null) {
            throw new IllegalArgumentException("checkServerTrusted: X509Certificate array is null");
        } else if (x509CertificateArr.length > 0) {
            ArrayList<VisaCertificateData> arrayList = this.f643;
            if (arrayList != null) {
                Iterator<VisaCertificateData> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    VisaCertificateData next = it2.next();
                    int length = x509CertificateArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 < length) {
                            if (!next.getCertificateKey().equalsIgnoreCase(Base64.encodeToString(((RSAPublicKey) x509CertificateArr[i2].getPublicKey()).getEncoded(), 2))) {
                                i2++;
                            } else {
                                return;
                            }
                        }
                    }
                }
                throw new CertificateException(VisaSCPConstants.VISA_SSL_HANDSHAKE_EXCEPTION_MESSAGE);
            }
            throw new CertificateException(VisaSCPConstants.VISA_SSL_HANDSHAKE_EXCEPTION_MESSAGE);
        } else {
            throw new IllegalArgumentException("checkServerTrusted: X509Certificate is empty");
        }
    }
}
