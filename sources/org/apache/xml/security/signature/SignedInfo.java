package org.apache.xml.security.signature;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.xml.security.algorithms.SignatureAlgorithm;
import org.apache.xml.security.c14n.Canonicalizer;
import org.apache.xml.security.exceptions.XMLSecurityException;
import org.apache.xml.security.transforms.params.InclusiveNamespaces;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class SignedInfo extends Manifest {

    /* renamed from: g  reason: collision with root package name */
    private SignatureAlgorithm f72695g = null;

    /* renamed from: h  reason: collision with root package name */
    private byte[] f72696h = null;

    /* renamed from: i  reason: collision with root package name */
    private Element f72697i;
    private Element q;

    public SignedInfo(Element element, String str) {
        super(a(element), str);
        this.f72697i = XMLUtils.a(element.getFirstChild());
        this.q = XMLUtils.a(this.f72697i.getNextSibling());
        this.f72695g = new SignatureAlgorithm(this.q, l());
    }

    private static Element a(Element element) {
        String attributeNS = XMLUtils.a(element.getFirstChild()).getAttributeNS((String) null, "Algorithm");
        if (attributeNS.equals("http://www.w3.org/TR/2001/REC-xml-c14n-20010315") || attributeNS.equals("http://www.w3.org/TR/2001/REC-xml-c14n-20010315#WithComments") || attributeNS.equals("http://www.w3.org/2001/10/xml-exc-c14n#") || attributeNS.equals("http://www.w3.org/2001/10/xml-exc-c14n#WithComments") || attributeNS.equals("http://www.w3.org/2006/12/xml-c14n11") || attributeNS.equals("http://www.w3.org/2006/12/xml-c14n11#WithComments")) {
            return element;
        }
        try {
            byte[] a2 = Canonicalizer.a(attributeNS).a((Node) element);
            DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
            newInstance.setNamespaceAware(true);
            Node importNode = element.getOwnerDocument().importNode(newInstance.newDocumentBuilder().parse(new ByteArrayInputStream(a2)).getDocumentElement(), true);
            element.getParentNode().replaceChild(importNode, element);
            return (Element) importNode;
        } catch (ParserConfigurationException e2) {
            throw new XMLSecurityException("empty", (Exception) e2);
        } catch (IOException e3) {
            throw new XMLSecurityException("empty", (Exception) e3);
        } catch (SAXException e4) {
            throw new XMLSecurityException("empty", (Exception) e4);
        }
    }

    public void a(OutputStream outputStream) {
        byte[] bArr = this.f72696h;
        if (bArr == null) {
            Canonicalizer a2 = Canonicalizer.a(b());
            a2.a(outputStream);
            String f2 = f();
            if (f2 == null) {
                a2.a((Node) this.k);
            } else {
                a2.a((Node) this.k, f2);
            }
        } else {
            try {
                outputStream.write(bArr);
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public String b() {
        return this.f72697i.getAttributeNS((String) null, "Algorithm");
    }

    public boolean b(boolean z) {
        return super.a(z);
    }

    /* access modifiers changed from: protected */
    public SignatureAlgorithm c() {
        return this.f72695g;
    }

    public String e() {
        return "SignedInfo";
    }

    public String f() {
        Element a2;
        String attributeNS = this.f72697i.getAttributeNS((String) null, "Algorithm");
        if ((attributeNS.equals("http://www.w3.org/2001/10/xml-exc-c14n#") || attributeNS.equals("http://www.w3.org/2001/10/xml-exc-c14n#WithComments")) && (a2 = XMLUtils.a(this.f72697i.getFirstChild())) != null) {
            try {
                return new InclusiveNamespaces(a2, "http://www.w3.org/2001/10/xml-exc-c14n#").a();
            } catch (XMLSecurityException unused) {
            }
        }
        return null;
    }
}
