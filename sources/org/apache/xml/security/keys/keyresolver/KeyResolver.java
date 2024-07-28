package org.apache.xml.security.keys.keyresolver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.keys.storage.StorageResolver;

public class KeyResolver {

    /* renamed from: a  reason: collision with root package name */
    static Log f72636a;

    /* renamed from: b  reason: collision with root package name */
    static boolean f72637b = false;

    /* renamed from: c  reason: collision with root package name */
    static List f72638c = null;

    /* renamed from: f  reason: collision with root package name */
    static Class f72639f;

    /* renamed from: d  reason: collision with root package name */
    protected KeyResolverSpi f72640d = null;

    /* renamed from: e  reason: collision with root package name */
    protected StorageResolver f72641e = null;

    class ResolverIterator implements Iterator {

        /* renamed from: a  reason: collision with root package name */
        Iterator f72642a;

        /* renamed from: b  reason: collision with root package name */
        int f72643b;

        public boolean hasNext() {
            return this.f72642a.hasNext();
        }

        public Object next() {
            this.f72643b++;
            KeyResolver keyResolver = (KeyResolver) this.f72642a.next();
            if (keyResolver != null) {
                return keyResolver.f72640d;
            }
            throw new RuntimeException("utils.resolver.noClass");
        }

        public void remove() {
            throw new UnsupportedOperationException("Can't remove resolvers using the iterator");
        }
    }

    static {
        Class cls = f72639f;
        if (cls == null) {
            cls = b("org.apache.xml.security.keys.keyresolver.KeyResolver");
            f72639f = cls;
        }
        f72636a = LogFactory.getLog(cls.getName());
    }

    private KeyResolver(String str) {
        this.f72640d = (KeyResolverSpi) Class.forName(str).newInstance();
        this.f72640d.a(true);
    }

    public static void a() {
        if (!f72637b) {
            f72638c = new ArrayList(10);
            f72637b = true;
        }
    }

    public static void a(String str) {
        f72638c.add(new KeyResolver(str));
    }

    static Class b(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }
}
