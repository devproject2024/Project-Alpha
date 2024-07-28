package org.apache.xml.security.utils;

import java.io.ByteArrayOutputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.algorithms.MessageDigestAlgorithm;

public class DigesterOutputStream extends ByteArrayOutputStream {

    /* renamed from: b  reason: collision with root package name */
    static Log f72759b;

    /* renamed from: c  reason: collision with root package name */
    static Class f72760c;

    /* renamed from: a  reason: collision with root package name */
    final MessageDigestAlgorithm f72761a;

    static {
        Class cls = f72760c;
        if (cls == null) {
            cls = a("org.apache.xml.security.utils.DigesterOutputStream");
            f72760c = cls;
        }
        f72759b = LogFactory.getLog(cls.getName());
    }

    public DigesterOutputStream(MessageDigestAlgorithm messageDigestAlgorithm) {
        this.f72761a = messageDigestAlgorithm;
    }

    static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    public byte[] a() {
        return this.f72761a.b();
    }

    public void write(int i2) {
        this.f72761a.a((byte) i2);
    }

    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i2, int i3) {
        if (f72759b.isDebugEnabled()) {
            f72759b.debug("Pre-digested input:");
            StringBuffer stringBuffer = new StringBuffer(i3);
            for (int i4 = i2; i4 < i2 + i3; i4++) {
                stringBuffer.append((char) bArr[i4]);
            }
            f72759b.debug(stringBuffer.toString());
        }
        this.f72761a.a(bArr, i2, i3);
    }
}
