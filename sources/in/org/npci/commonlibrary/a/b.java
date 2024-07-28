package in.org.npci.commonlibrary.a;

import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private Certificate f46331a;

    public b() {
        try {
            this.f46331a = b("signer.crt");
        } catch (CertificateException e2) {
            System.out.println("Error in loading exception");
            e2.printStackTrace();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:9|10|11|12|13|14) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|7) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0026 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.security.cert.Certificate b(java.lang.String r3) {
        /*
            r2 = this;
            java.lang.String r0 = "X.509"
            java.security.cert.CertificateFactory r0 = java.security.cert.CertificateFactory.getInstance(r0)
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            java.lang.ClassLoader r1 = r1.getContextClassLoader()
            java.io.InputStream r3 = r1.getResourceAsStream(r3)
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream
            r1.<init>(r3)
            java.security.cert.Certificate r0 = r0.generateCertificate(r1)     // Catch:{ all -> 0x0022 }
            r1.close()     // Catch:{ IOException -> 0x001e }
        L_0x001e:
            r3.close()     // Catch:{ IOException -> 0x0021 }
        L_0x0021:
            return r0
        L_0x0022:
            r0 = move-exception
            r1.close()     // Catch:{ IOException -> 0x0026 }
        L_0x0026:
            r3.close()     // Catch:{ IOException -> 0x0029 }
        L_0x0029:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: in.org.npci.commonlibrary.a.b.b(java.lang.String):java.security.cert.Certificate");
    }

    public boolean a(String str) {
        if (this.f46331a == null) {
            try {
                this.f46331a = b("signer.crt");
            } catch (CertificateException e2) {
                System.out.println("Error in loading certificate.");
                e2.printStackTrace();
                return false;
            }
        }
        try {
            return a.a(a.a(str), this.f46331a.getPublicKey());
        } catch (ParserConfigurationException | SAXException e3) {
            System.err.println("Parsing failed for message:".concat(String.valueOf(str)));
            e3.printStackTrace();
            return false;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }
}
