package org.apache.xml.security.utils;

import java.io.ByteArrayOutputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.algorithms.SignatureAlgorithm;
import org.apache.xml.security.signature.XMLSignatureException;

public class SignerOutputStream extends ByteArrayOutputStream {

    /* renamed from: b  reason: collision with root package name */
    static Log f72783b;

    /* renamed from: c  reason: collision with root package name */
    static Class f72784c;

    /* renamed from: a  reason: collision with root package name */
    final SignatureAlgorithm f72785a;

    static {
        Class cls = f72784c;
        if (cls == null) {
            cls = a("org.apache.xml.security.utils.SignerOutputStream");
            f72784c = cls;
        }
        f72783b = LogFactory.getLog(cls.getName());
    }

    public SignerOutputStream(SignatureAlgorithm signatureAlgorithm) {
        this.f72785a = signatureAlgorithm;
    }

    static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    public void write(int i2) {
        try {
            this.f72785a.a((byte) i2);
        } catch (XMLSignatureException e2) {
            throw new RuntimeException(String.valueOf(e2));
        }
    }

    public void write(byte[] bArr) {
        try {
            this.f72785a.a(bArr);
        } catch (XMLSignatureException e2) {
            throw new RuntimeException(String.valueOf(e2));
        }
    }

    public void write(byte[] bArr, int i2, int i3) {
        if (f72783b.isDebugEnabled()) {
            f72783b.debug("Canonicalized SignedInfo:");
            StringBuffer stringBuffer = new StringBuffer(i3);
            for (int i4 = i2; i4 < i2 + i3; i4++) {
                stringBuffer.append((char) bArr[i4]);
            }
            f72783b.debug(stringBuffer.toString());
        }
        try {
            this.f72785a.a(bArr, i2, i3);
        } catch (XMLSignatureException e2) {
            throw new RuntimeException(String.valueOf(e2));
        }
    }
}
