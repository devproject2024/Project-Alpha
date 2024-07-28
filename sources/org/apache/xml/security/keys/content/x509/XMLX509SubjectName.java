package org.apache.xml.security.keys.content.x509;

import org.apache.xml.security.utils.RFC2253Parser;
import org.apache.xml.security.utils.SignatureElementProxy;

public class XMLX509SubjectName extends SignatureElementProxy implements XMLX509DataContent {
    public String a() {
        return RFC2253Parser.a(o());
    }

    public String e() {
        return "X509SubjectName";
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof XMLX509SubjectName)) {
            return false;
        }
        return a().equals(((XMLX509SubjectName) obj).a());
    }

    public int hashCode() {
        return a().hashCode() + 527;
    }
}
