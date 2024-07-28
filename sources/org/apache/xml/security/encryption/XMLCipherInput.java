package org.apache.xml.security.encryption;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class XMLCipherInput {

    /* renamed from: a  reason: collision with root package name */
    static Class f72616a;

    /* renamed from: b  reason: collision with root package name */
    private static Log f72617b;

    static {
        Class cls = f72616a;
        if (cls == null) {
            cls = a("org.apache.xml.security.encryption.XMLCipher");
            f72616a = cls;
        }
        f72617b = LogFactory.getLog(cls.getName());
    }

    static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }
}
