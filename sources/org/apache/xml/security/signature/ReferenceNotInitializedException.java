package org.apache.xml.security.signature;

public class ReferenceNotInitializedException extends XMLSignatureException {
    public ReferenceNotInitializedException() {
    }

    public ReferenceNotInitializedException(String str, Exception exc) {
        super(str, exc);
    }

    public ReferenceNotInitializedException(String str, Object[] objArr) {
        super(str, objArr);
    }
}
