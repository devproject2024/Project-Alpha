package org.apache.xml.security.keys.storage;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class StorageResolver {

    /* renamed from: a  reason: collision with root package name */
    static Log f72660a;

    /* renamed from: d  reason: collision with root package name */
    static Class f72661d;

    /* renamed from: b  reason: collision with root package name */
    List f72662b = null;

    /* renamed from: c  reason: collision with root package name */
    Iterator f72663c = null;

    class StorageResolverIterator implements Iterator {

        /* renamed from: a  reason: collision with root package name */
        Iterator f72664a;

        /* renamed from: b  reason: collision with root package name */
        Iterator f72665b;

        private Iterator a() {
            while (this.f72664a.hasNext()) {
                Iterator a2 = ((StorageResolverSpi) this.f72664a.next()).a();
                if (a2.hasNext()) {
                    return a2;
                }
            }
            return null;
        }

        public boolean hasNext() {
            Iterator it2 = this.f72665b;
            if (it2 == null) {
                return false;
            }
            if (it2.hasNext()) {
                return true;
            }
            this.f72665b = a();
            return this.f72665b != null;
        }

        public Object next() {
            if (hasNext()) {
                return this.f72665b.next();
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException("Can't remove keys from KeyStore");
        }
    }

    static {
        Class cls = f72661d;
        if (cls == null) {
            cls = a("org.apache.xml.security.keys.storage.StorageResolver");
            f72661d = cls;
        }
        f72660a = LogFactory.getLog(cls.getName());
    }

    static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }
}
