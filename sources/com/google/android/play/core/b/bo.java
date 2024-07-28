package com.google.android.play.core.b;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;

final class bo extends bp {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f37296a;

    public bo(X509Certificate x509Certificate, byte[] bArr) {
        super(x509Certificate);
        this.f37296a = bArr;
    }

    public final byte[] getEncoded() throws CertificateEncodingException {
        return this.f37296a;
    }
}
