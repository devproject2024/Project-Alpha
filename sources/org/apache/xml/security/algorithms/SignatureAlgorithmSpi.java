package org.apache.xml.security.algorithms;

import java.security.Key;
import org.w3c.dom.Element;

public abstract class SignatureAlgorithmSpi {
    /* access modifiers changed from: protected */
    public abstract String a();

    /* access modifiers changed from: protected */
    public abstract void a(byte b2);

    /* access modifiers changed from: protected */
    public abstract void a(Key key);

    /* access modifiers changed from: protected */
    public void a(Element element) {
    }

    /* access modifiers changed from: protected */
    public abstract void a(byte[] bArr);

    /* access modifiers changed from: protected */
    public abstract void a(byte[] bArr, int i2, int i3);

    /* access modifiers changed from: protected */
    public abstract String b();

    /* access modifiers changed from: protected */
    public abstract boolean b(byte[] bArr);

    public void c() {
    }
}
