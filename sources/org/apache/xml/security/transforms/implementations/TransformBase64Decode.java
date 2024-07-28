package org.apache.xml.security.transforms.implementations;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.xml.security.exceptions.Base64DecodingException;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.transforms.Transform;
import org.apache.xml.security.transforms.TransformSpi;
import org.apache.xml.security.transforms.TransformationException;
import org.apache.xml.security.utils.Base64;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class TransformBase64Decode extends TransformSpi {
    public XMLSignatureInput a(XMLSignatureInput xMLSignatureInput, OutputStream outputStream, Transform transform) {
        try {
            if (xMLSignatureInput.g()) {
                Node m = xMLSignatureInput.m();
                if (xMLSignatureInput.m().getNodeType() == 3) {
                    m = m.getParentNode();
                }
                StringBuffer stringBuffer = new StringBuffer();
                a((Element) m, stringBuffer);
                if (outputStream == null) {
                    return new XMLSignatureInput(Base64.a(stringBuffer.toString()));
                }
                Base64.a(stringBuffer.toString(), outputStream);
                XMLSignatureInput xMLSignatureInput2 = new XMLSignatureInput((byte[]) null);
                xMLSignatureInput2.b(outputStream);
                return xMLSignatureInput2;
            } else if (!xMLSignatureInput.h() && !xMLSignatureInput.f()) {
                Element documentElement = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xMLSignatureInput.c()).getDocumentElement();
                StringBuffer stringBuffer2 = new StringBuffer();
                a(documentElement, stringBuffer2);
                return new XMLSignatureInput(Base64.a(stringBuffer2.toString()));
            } else if (outputStream == null) {
                return new XMLSignatureInput(Base64.a(xMLSignatureInput.e()));
            } else {
                if (!xMLSignatureInput.j()) {
                    if (!xMLSignatureInput.f()) {
                        Base64.a((InputStream) new BufferedInputStream(xMLSignatureInput.d()), outputStream);
                        XMLSignatureInput xMLSignatureInput3 = new XMLSignatureInput((byte[]) null);
                        xMLSignatureInput3.b(outputStream);
                        return xMLSignatureInput3;
                    }
                }
                Base64.a(xMLSignatureInput.e(), outputStream);
                XMLSignatureInput xMLSignatureInput32 = new XMLSignatureInput((byte[]) null);
                xMLSignatureInput32.b(outputStream);
                return xMLSignatureInput32;
            }
        } catch (ParserConfigurationException e2) {
            throw new TransformationException("c14n.Canonicalizer.Exception", (Exception) e2);
        } catch (SAXException e3) {
            throw new TransformationException("SAX exception", (Exception) e3);
        } catch (Base64DecodingException e4) {
            throw new TransformationException("Base64Decoding", (Exception) e4);
        }
    }

    public XMLSignatureInput a(XMLSignatureInput xMLSignatureInput, Transform transform) {
        return a(xMLSignatureInput, (OutputStream) null, transform);
    }

    /* access modifiers changed from: package-private */
    public void a(Element element, StringBuffer stringBuffer) {
        for (Node firstChild = element.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            short nodeType = firstChild.getNodeType();
            if (nodeType == 1) {
                a((Element) firstChild, stringBuffer);
            } else if (nodeType == 3) {
                stringBuffer.append(((Text) firstChild).getData());
            }
        }
    }
}
