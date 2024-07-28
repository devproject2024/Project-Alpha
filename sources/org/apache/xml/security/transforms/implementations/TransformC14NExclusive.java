package org.apache.xml.security.transforms.implementations;

import java.io.OutputStream;
import org.apache.xml.security.c14n.CanonicalizationException;
import org.apache.xml.security.c14n.implementations.Canonicalizer20010315ExclOmitComments;
import org.apache.xml.security.exceptions.XMLSecurityException;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.transforms.Transform;
import org.apache.xml.security.transforms.TransformSpi;
import org.apache.xml.security.transforms.params.InclusiveNamespaces;
import org.apache.xml.security.utils.XMLUtils;

public class TransformC14NExclusive extends TransformSpi {
    public XMLSignatureInput a(XMLSignatureInput xMLSignatureInput, OutputStream outputStream, Transform transform) {
        String str = null;
        try {
            if (transform.c("http://www.w3.org/2001/10/xml-exc-c14n#", "InclusiveNamespaces") == 1) {
                str = new InclusiveNamespaces(XMLUtils.a(transform.k().getFirstChild(), "http://www.w3.org/2001/10/xml-exc-c14n#", "InclusiveNamespaces", 0), transform.l()).a();
            }
            Canonicalizer20010315ExclOmitComments canonicalizer20010315ExclOmitComments = new Canonicalizer20010315ExclOmitComments();
            if (outputStream != null) {
                canonicalizer20010315ExclOmitComments.a(outputStream);
            }
            XMLSignatureInput xMLSignatureInput2 = new XMLSignatureInput(canonicalizer20010315ExclOmitComments.a(xMLSignatureInput, str));
            if (outputStream != null) {
                xMLSignatureInput2.b(outputStream);
            }
            return xMLSignatureInput2;
        } catch (XMLSecurityException e2) {
            throw new CanonicalizationException("empty", (Exception) e2);
        }
    }

    public XMLSignatureInput a(XMLSignatureInput xMLSignatureInput, Transform transform) {
        return a(xMLSignatureInput, (OutputStream) null, transform);
    }
}
