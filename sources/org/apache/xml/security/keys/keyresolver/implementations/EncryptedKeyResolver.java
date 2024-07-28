package org.apache.xml.security.keys.keyresolver.implementations;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.keys.keyresolver.KeyResolverSpi;

public class EncryptedKeyResolver extends KeyResolverSpi {

    /* renamed from: c  reason: collision with root package name */
    static Log f72646c;

    /* renamed from: d  reason: collision with root package name */
    static Class f72647d;

    static {
        Class cls = f72647d;
        if (cls == null) {
            cls = a("org.apache.xml.security.keys.keyresolver.implementations.RSAKeyValueResolver");
            f72647d = cls;
        }
        f72646c = LogFactory.getLog(cls.getName());
    }

    static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }
}
