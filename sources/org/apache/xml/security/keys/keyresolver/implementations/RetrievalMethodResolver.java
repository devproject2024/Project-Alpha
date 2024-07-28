package org.apache.xml.security.keys.keyresolver.implementations;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.keys.keyresolver.KeyResolverSpi;

public class RetrievalMethodResolver extends KeyResolverSpi {

    /* renamed from: c  reason: collision with root package name */
    static Log f72650c;

    /* renamed from: d  reason: collision with root package name */
    static Class f72651d;

    static {
        Class cls = f72651d;
        if (cls == null) {
            cls = a("org.apache.xml.security.keys.keyresolver.implementations.RetrievalMethodResolver");
            f72651d = cls;
        }
        f72650c = LogFactory.getLog(cls.getName());
    }

    static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }
}
