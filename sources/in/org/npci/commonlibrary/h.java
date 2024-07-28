package in.org.npci.commonlibrary;

public class h {
    /* JADX WARNING: Can't wrap try/catch for region: R(6:9|10|11|12|13|14) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0024 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.security.cert.Certificate a(java.lang.String r2) {
        /*
            java.lang.String r0 = "X.509"
            java.security.cert.CertificateFactory r0 = java.security.cert.CertificateFactory.getInstance(r0)
            java.lang.Class<in.org.npci.commonlibrary.h> r1 = in.org.npci.commonlibrary.h.class
            java.lang.ClassLoader r1 = r1.getClassLoader()
            java.io.InputStream r2 = r1.getResourceAsStream(r2)
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream
            r1.<init>(r2)
            java.security.cert.Certificate r0 = r0.generateCertificate(r1)     // Catch:{ all -> 0x0020 }
            r1.close()     // Catch:{ IOException -> 0x001c }
        L_0x001c:
            r2.close()     // Catch:{ IOException -> 0x001f }
        L_0x001f:
            return r0
        L_0x0020:
            r0 = move-exception
            r1.close()     // Catch:{ IOException -> 0x0024 }
        L_0x0024:
            r2.close()     // Catch:{ IOException -> 0x0027 }
        L_0x0027:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: in.org.npci.commonlibrary.h.a(java.lang.String):java.security.cert.Certificate");
    }
}
