package org.apache.xml.security.keys.storage.implementations;

import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.xml.security.keys.storage.StorageResolverSpi;

public class SingleCertificateResolver extends StorageResolverSpi {

    /* renamed from: a  reason: collision with root package name */
    X509Certificate f72676a;

    class InternalIterator implements Iterator {

        /* renamed from: a  reason: collision with root package name */
        boolean f72677a = false;

        /* renamed from: b  reason: collision with root package name */
        X509Certificate f72678b = null;

        public InternalIterator(X509Certificate x509Certificate) {
            this.f72678b = x509Certificate;
        }

        public boolean hasNext() {
            return !this.f72677a;
        }

        public Object next() {
            if (!this.f72677a) {
                this.f72677a = true;
                return this.f72678b;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException("Can't remove keys from KeyStore");
        }
    }

    public Iterator a() {
        return new InternalIterator(this.f72676a);
    }
}
