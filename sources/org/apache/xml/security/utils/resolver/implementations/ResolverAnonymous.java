package org.apache.xml.security.utils.resolver.implementations;

import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.utils.resolver.ResourceResolverSpi;
import org.w3c.dom.Attr;

public class ResolverAnonymous extends ResourceResolverSpi {

    /* renamed from: d  reason: collision with root package name */
    private XMLSignatureInput f72809d;

    public XMLSignatureInput a(Attr attr, String str) {
        return this.f72809d;
    }

    public boolean b(Attr attr, String str) {
        return attr == null;
    }
}
