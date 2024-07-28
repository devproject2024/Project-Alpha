package org.apache.xml.security.transforms.implementations;

import java.io.OutputStream;
import org.apache.xml.security.c14n.implementations.Canonicalizer11_WithComments;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.transforms.Transform;
import org.apache.xml.security.transforms.TransformSpi;

public class TransformC14N11_WithComments extends TransformSpi {
    public XMLSignatureInput a(XMLSignatureInput xMLSignatureInput, OutputStream outputStream, Transform transform) {
        Canonicalizer11_WithComments canonicalizer11_WithComments = new Canonicalizer11_WithComments();
        if (outputStream != null) {
            canonicalizer11_WithComments.a(outputStream);
        }
        XMLSignatureInput xMLSignatureInput2 = new XMLSignatureInput(canonicalizer11_WithComments.b(xMLSignatureInput));
        if (outputStream != null) {
            xMLSignatureInput2.b(outputStream);
        }
        return xMLSignatureInput2;
    }

    public XMLSignatureInput a(XMLSignatureInput xMLSignatureInput, Transform transform) {
        return a(xMLSignatureInput, (OutputStream) null, transform);
    }
}
