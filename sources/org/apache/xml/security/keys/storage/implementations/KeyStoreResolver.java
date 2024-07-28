package org.apache.xml.security.keys.storage.implementations;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.Certificate;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.xml.security.keys.storage.StorageResolverSpi;

public class KeyStoreResolver extends StorageResolverSpi {

    /* renamed from: a  reason: collision with root package name */
    KeyStore f72671a;

    class KeyStoreIterator implements Iterator {

        /* renamed from: a  reason: collision with root package name */
        KeyStore f72673a = null;

        /* renamed from: b  reason: collision with root package name */
        Enumeration f72674b = null;

        /* renamed from: c  reason: collision with root package name */
        Certificate f72675c = null;

        public KeyStoreIterator(KeyStore keyStore) {
            try {
                this.f72673a = keyStore;
                this.f72674b = this.f72673a.aliases();
            } catch (KeyStoreException unused) {
                this.f72674b = new Enumeration(this) {

                    /* renamed from: a  reason: collision with root package name */
                    private final KeyStoreIterator f72672a;

                    {
                        this.f72672a = r1;
                    }

                    public boolean hasMoreElements() {
                        return false;
                    }

                    public Object nextElement() {
                        return null;
                    }
                };
            }
        }

        private Certificate a() {
            while (this.f72674b.hasMoreElements()) {
                try {
                    Certificate certificate = this.f72673a.getCertificate((String) this.f72674b.nextElement());
                    if (certificate != null) {
                        return certificate;
                    }
                } catch (KeyStoreException unused) {
                }
            }
            return null;
        }

        public boolean hasNext() {
            if (this.f72675c == null) {
                this.f72675c = a();
            }
            return this.f72675c != null;
        }

        public Object next() {
            if (this.f72675c == null) {
                this.f72675c = a();
                if (this.f72675c == null) {
                    throw new NoSuchElementException();
                }
            }
            Certificate certificate = this.f72675c;
            this.f72675c = null;
            return certificate;
        }

        public void remove() {
            throw new UnsupportedOperationException("Can't remove keys from KeyStore");
        }
    }

    public Iterator a() {
        return new KeyStoreIterator(this.f72671a);
    }
}
