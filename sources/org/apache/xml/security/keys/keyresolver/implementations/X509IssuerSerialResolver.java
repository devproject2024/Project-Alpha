package org.apache.xml.security.keys.keyresolver.implementations;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.keys.keyresolver.KeyResolverSpi;

public class X509IssuerSerialResolver extends KeyResolverSpi {

    /* renamed from: c  reason: collision with root package name */
    static Log f72654c;

    /* renamed from: d  reason: collision with root package name */
    static Class f72655d;

    static {
        Class cls = f72655d;
        if (cls == null) {
            cls = a("org.apache.xml.security.keys.keyresolver.implementations.X509IssuerSerialResolver");
            f72655d = cls;
        }
        f72654c = LogFactory.getLog(cls.getName());
    }

    static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }
}
