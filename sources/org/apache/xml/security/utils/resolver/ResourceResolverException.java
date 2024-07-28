package org.apache.xml.security.utils.resolver;

import org.apache.xml.security.exceptions.XMLSecurityException;
import org.w3c.dom.Attr;

public class ResourceResolverException extends XMLSecurityException {

    /* renamed from: c  reason: collision with root package name */
    Attr f72804c = null;

    /* renamed from: d  reason: collision with root package name */
    String f72805d;

    public ResourceResolverException(String str, Exception exc, Attr attr, String str2) {
        super(str, exc);
        this.f72804c = attr;
        this.f72805d = str2;
    }

    public ResourceResolverException(String str, Object[] objArr, Attr attr, String str2) {
        super(str, objArr);
        this.f72804c = attr;
        this.f72805d = str2;
    }
}
