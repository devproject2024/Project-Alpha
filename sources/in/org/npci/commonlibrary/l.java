package in.org.npci.commonlibrary;

import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;

public class l {

    /* renamed from: a  reason: collision with root package name */
    private static Certificate f46371a;

    static {
        try {
            f46371a = h.a("signer.crt");
        } catch (CertificateException e2) {
            e2.printStackTrace();
        }
    }

    public static PublicKey a() {
        Certificate certificate = f46371a;
        if (certificate != null) {
            return certificate.getPublicKey();
        }
        return null;
    }
}
