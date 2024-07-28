package org.apache.xml.security.keys.keyresolver.implementations;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.keys.keyresolver.KeyResolverSpi;

public class X509SKIResolver extends KeyResolverSpi {

    /* renamed from: c  reason: collision with root package name */
    static Log f72656c;

    /* renamed from: d  reason: collision with root package name */
    static Class f72657d;

    static {
        Class cls = f72657d;
        if (cls == null) {
            cls = a("org.apache.xml.security.keys.keyresolver.implementations.X509SKIResolver");
            f72657d = cls;
        }
        f72656c = LogFactory.getLog(cls.getName());
    }

    static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }
}
