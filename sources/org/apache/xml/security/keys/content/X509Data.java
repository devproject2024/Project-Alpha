package org.apache.xml.security.keys.content;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.utils.SignatureElementProxy;

public class X509Data extends SignatureElementProxy implements KeyInfoContent {

    /* renamed from: a  reason: collision with root package name */
    static Log f72630a;

    /* renamed from: b  reason: collision with root package name */
    static Class f72631b;

    static {
        Class cls = f72631b;
        if (cls == null) {
            cls = a("org.apache.xml.security.keys.content.X509Data");
            f72631b = cls;
        }
        f72630a = LogFactory.getLog(cls.getName());
    }

    static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    public String e() {
        return "X509Data";
    }
}
