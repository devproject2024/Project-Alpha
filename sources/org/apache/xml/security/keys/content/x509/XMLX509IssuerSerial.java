package org.apache.xml.security.keys.content.x509;

import java.math.BigInteger;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.utils.RFC2253Parser;
import org.apache.xml.security.utils.SignatureElementProxy;

public class XMLX509IssuerSerial extends SignatureElementProxy implements XMLX509DataContent {

    /* renamed from: a  reason: collision with root package name */
    static Log f72632a;

    /* renamed from: b  reason: collision with root package name */
    static Class f72633b;

    static {
        Class cls = f72633b;
        if (cls == null) {
            cls = a("org.apache.xml.security.keys.content.x509.XMLX509IssuerSerial");
            f72633b = cls;
        }
        f72632a = LogFactory.getLog(cls.getName());
    }

    static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    public BigInteger a() {
        String b2 = b("X509SerialNumber", "http://www.w3.org/2000/09/xmldsig#");
        if (f72632a.isDebugEnabled()) {
            f72632a.debug("X509SerialNumber text: ".concat(String.valueOf(b2)));
        }
        return new BigInteger(b2);
    }

    public String b() {
        return RFC2253Parser.a(b("X509IssuerName", "http://www.w3.org/2000/09/xmldsig#"));
    }

    public String e() {
        return "X509IssuerSerial";
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof XMLX509IssuerSerial)) {
            return false;
        }
        XMLX509IssuerSerial xMLX509IssuerSerial = (XMLX509IssuerSerial) obj;
        return a().equals(xMLX509IssuerSerial.a()) && b().equals(xMLX509IssuerSerial.b());
    }

    public int hashCode() {
        return ((a().hashCode() + 527) * 31) + b().hashCode();
    }
}
