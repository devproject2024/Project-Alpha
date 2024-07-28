package org.apache.xml.security.transforms;

import java.io.OutputStream;
import org.apache.xml.security.signature.XMLSignatureInput;

public abstract class TransformSpi {

    /* renamed from: a  reason: collision with root package name */
    protected Transform f72723a = null;

    /* access modifiers changed from: protected */
    public XMLSignatureInput a(XMLSignatureInput xMLSignatureInput) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: protected */
    public XMLSignatureInput a(XMLSignatureInput xMLSignatureInput, OutputStream outputStream, Transform transform) {
        return a(xMLSignatureInput, transform);
    }

    /* access modifiers changed from: protected */
    public XMLSignatureInput a(XMLSignatureInput xMLSignatureInput, Transform transform) {
        try {
            TransformSpi transformSpi = (TransformSpi) getClass().newInstance();
            transformSpi.a(transform);
            return transformSpi.a(xMLSignatureInput);
        } catch (InstantiationException e2) {
            throw new TransformationException("", (Exception) e2);
        } catch (IllegalAccessException e3) {
            throw new TransformationException("", (Exception) e3);
        }
    }

    /* access modifiers changed from: protected */
    public void a(Transform transform) {
        this.f72723a = transform;
    }
}
