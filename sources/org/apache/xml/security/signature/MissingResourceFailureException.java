package org.apache.xml.security.signature;

public class MissingResourceFailureException extends XMLSignatureException {

    /* renamed from: c  reason: collision with root package name */
    Reference f72686c = null;

    public MissingResourceFailureException(String str, Reference reference) {
        super(str);
        this.f72686c = reference;
    }

    public MissingResourceFailureException(String str, Object[] objArr, Exception exc, Reference reference) {
        super(str, objArr, exc);
        this.f72686c = reference;
    }
}
