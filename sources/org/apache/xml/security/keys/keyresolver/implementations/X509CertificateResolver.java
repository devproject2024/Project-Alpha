package org.apache.xml.security.keys.keyresolver.implementations;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.keys.keyresolver.KeyResolverSpi;

public class X509CertificateResolver extends KeyResolverSpi {

    /* renamed from: c  reason: collision with root package name */
    static Log f72652c;

    /* renamed from: d  reason: collision with root package name */
    static Class f72653d;

    static {
        Class cls = f72653d;
        if (cls == null) {
            cls = a("org.apache.xml.security.keys.keyresolver.implementations.X509CertificateResolver");
            f72653d = cls;
        }
        f72652c = LogFactory.getLog(cls.getName());
    }

    static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }
}
