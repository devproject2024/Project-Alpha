package org.apache.xml.security.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public abstract class SignatureElementProxy extends ElementProxy {
    protected SignatureElementProxy() {
    }

    public SignatureElementProxy(Document document) {
        if (document != null) {
            this.m = document;
            this.k = XMLUtils.a(this.m, e());
            return;
        }
        throw new RuntimeException("Document is null");
    }

    public SignatureElementProxy(Element element, String str) {
        super(element, str);
    }

    public String d() {
        return "http://www.w3.org/2000/09/xmldsig#";
    }
}
