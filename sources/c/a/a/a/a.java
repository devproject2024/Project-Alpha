package c.a.a.a;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public OkHttpClient.Builder f5548a;

    public a(OkHttpClient.Builder builder) {
        this.f5548a = builder;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[ExcHandler: Exception | KeyStoreException | NoSuchAlgorithmException | CertificateException (unused java.lang.Throwable), SYNTHETIC, Splitter:B:5:0x0009] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static javax.net.ssl.TrustManager[] a(java.io.InputStream... r9) {
        /*
            r0 = 0
            if (r9 == 0) goto L_0x0045
            int r1 = r9.length
            if (r1 > 0) goto L_0x0007
            goto L_0x0045
        L_0x0007:
            java.lang.String r1 = "X.509"
            java.security.cert.CertificateFactory r1 = java.security.cert.CertificateFactory.getInstance(r1)     // Catch:{ Exception | KeyStoreException | NoSuchAlgorithmException | CertificateException -> 0x0045 }
            java.lang.String r2 = java.security.KeyStore.getDefaultType()     // Catch:{ Exception | KeyStoreException | NoSuchAlgorithmException | CertificateException -> 0x0045 }
            java.security.KeyStore r2 = java.security.KeyStore.getInstance(r2)     // Catch:{ Exception | KeyStoreException | NoSuchAlgorithmException | CertificateException -> 0x0045 }
            r2.load(r0)     // Catch:{ Exception | KeyStoreException | NoSuchAlgorithmException | CertificateException -> 0x0045 }
            int r3 = r9.length     // Catch:{ Exception | KeyStoreException | NoSuchAlgorithmException | CertificateException -> 0x0045 }
            r4 = 0
            r5 = 0
        L_0x001b:
            if (r4 >= r3) goto L_0x0035
            r6 = r9[r4]     // Catch:{ Exception | KeyStoreException | NoSuchAlgorithmException | CertificateException -> 0x0045 }
            int r7 = r5 + 1
            java.lang.String r5 = java.lang.Integer.toString(r5)     // Catch:{ Exception | KeyStoreException | NoSuchAlgorithmException | CertificateException -> 0x0045 }
            java.security.cert.Certificate r8 = r1.generateCertificate(r6)     // Catch:{ Exception | KeyStoreException | NoSuchAlgorithmException | CertificateException -> 0x0045 }
            r2.setCertificateEntry(r5, r8)     // Catch:{ Exception | KeyStoreException | NoSuchAlgorithmException | CertificateException -> 0x0045 }
            if (r6 == 0) goto L_0x0031
            r6.close()     // Catch:{ IOException -> 0x0031, Exception | KeyStoreException | NoSuchAlgorithmException | CertificateException -> 0x0045, Exception | KeyStoreException | NoSuchAlgorithmException | CertificateException -> 0x0045, Exception | KeyStoreException | NoSuchAlgorithmException | CertificateException -> 0x0045 }
        L_0x0031:
            int r4 = r4 + 1
            r5 = r7
            goto L_0x001b
        L_0x0035:
            java.lang.String r9 = javax.net.ssl.TrustManagerFactory.getDefaultAlgorithm()     // Catch:{ Exception | KeyStoreException | NoSuchAlgorithmException | CertificateException -> 0x0045 }
            javax.net.ssl.TrustManagerFactory r9 = javax.net.ssl.TrustManagerFactory.getInstance(r9)     // Catch:{ Exception | KeyStoreException | NoSuchAlgorithmException | CertificateException -> 0x0045 }
            r9.init(r2)     // Catch:{ Exception | KeyStoreException | NoSuchAlgorithmException | CertificateException -> 0x0045 }
            javax.net.ssl.TrustManager[] r9 = r9.getTrustManagers()     // Catch:{ Exception | KeyStoreException | NoSuchAlgorithmException | CertificateException -> 0x0045 }
            return r9
        L_0x0045:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c.a.a.a.a.a(java.io.InputStream[]):javax.net.ssl.TrustManager[]");
    }

    public static X509TrustManager a(TrustManager[] trustManagerArr) {
        for (X509TrustManager x509TrustManager : trustManagerArr) {
            if (x509TrustManager instanceof X509TrustManager) {
                return x509TrustManager;
            }
        }
        return null;
    }

    /* renamed from: c.a.a.a.a$a  reason: collision with other inner class name */
    public class C0081a implements X509TrustManager {

        /* renamed from: b  reason: collision with root package name */
        private X509TrustManager f5550b;

        /* renamed from: c  reason: collision with root package name */
        private X509TrustManager f5551c;

        public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        public final X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }

        public C0081a(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyStoreException {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init((KeyStore) null);
            this.f5550b = a.a(instance.getTrustManagers());
            this.f5551c = x509TrustManager;
        }

        public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            try {
                this.f5550b.checkServerTrusted(x509CertificateArr, str);
            } catch (CertificateException unused) {
                this.f5551c.checkServerTrusted(x509CertificateArr, str);
            }
        }
    }
}
