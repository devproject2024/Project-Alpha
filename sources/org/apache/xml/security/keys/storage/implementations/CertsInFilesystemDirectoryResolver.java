package org.apache.xml.security.keys.storage.implementations;

import java.util.Iterator;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.keys.storage.StorageResolverSpi;

public class CertsInFilesystemDirectoryResolver extends StorageResolverSpi {

    /* renamed from: a  reason: collision with root package name */
    static Log f72666a;

    /* renamed from: b  reason: collision with root package name */
    static Class f72667b;

    /* renamed from: c  reason: collision with root package name */
    private List f72668c;

    class FilesystemIterator implements Iterator {

        /* renamed from: a  reason: collision with root package name */
        List f72669a = null;

        /* renamed from: b  reason: collision with root package name */
        int f72670b;

        public FilesystemIterator(List list) {
            this.f72669a = list;
            this.f72670b = 0;
        }

        public boolean hasNext() {
            return this.f72670b < this.f72669a.size();
        }

        public Object next() {
            List list = this.f72669a;
            int i2 = this.f72670b;
            this.f72670b = i2 + 1;
            return list.get(i2);
        }

        public void remove() {
            throw new UnsupportedOperationException("Can't remove keys from KeyStore");
        }
    }

    static {
        Class cls = f72667b;
        if (cls == null) {
            cls = a("org.apache.xml.security.keys.storage.implementations.CertsInFilesystemDirectoryResolver");
            f72667b = cls;
        }
        f72666a = LogFactory.getLog(cls.getName());
    }

    static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    public Iterator a() {
        return new FilesystemIterator(this.f72668c);
    }
}
