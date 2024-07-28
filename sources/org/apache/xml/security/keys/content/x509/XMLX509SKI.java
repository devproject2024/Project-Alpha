package org.apache.xml.security.keys.content.x509;

import java.util.Arrays;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.exceptions.XMLSecurityException;
import org.apache.xml.security.utils.SignatureElementProxy;

public class XMLX509SKI extends SignatureElementProxy implements XMLX509DataContent {

    /* renamed from: a  reason: collision with root package name */
    static Log f72634a;

    /* renamed from: b  reason: collision with root package name */
    static Class f72635b;

    static {
        Class cls = f72635b;
        if (cls == null) {
            cls = a("org.apache.xml.security.keys.content.x509.XMLX509SKI");
            f72635b = cls;
        }
        f72634a = LogFactory.getLog(cls.getName());
    }

    static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    public byte[] a() {
        return n();
    }

    public String e() {
        return "X509SKI";
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof XMLX509SKI)) {
            return false;
        }
        try {
            return Arrays.equals(((XMLX509SKI) obj).a(), a());
        } catch (XMLSecurityException unused) {
            return false;
        }
    }

    public int hashCode() {
        int i2 = 17;
        try {
            for (byte b2 : a()) {
                i2 = b2 + (i2 * 31);
            }
        } catch (XMLSecurityException unused) {
        }
        return i2;
    }
}
