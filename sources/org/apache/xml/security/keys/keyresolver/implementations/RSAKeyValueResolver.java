package org.apache.xml.security.keys.keyresolver.implementations;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.keys.keyresolver.KeyResolverSpi;

public class RSAKeyValueResolver extends KeyResolverSpi {

    /* renamed from: c  reason: collision with root package name */
    static Log f72648c;

    /* renamed from: d  reason: collision with root package name */
    static Class f72649d;

    static {
        Class cls = f72649d;
        if (cls == null) {
            cls = a("org.apache.xml.security.keys.keyresolver.implementations.RSAKeyValueResolver");
            f72649d = cls;
        }
        f72648c = LogFactory.getLog(cls.getName());
    }

    static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }
}
