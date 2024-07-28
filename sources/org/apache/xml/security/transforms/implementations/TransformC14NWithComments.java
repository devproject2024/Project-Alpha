package org.apache.xml.security.transforms.implementations;

import java.io.OutputStream;
import org.apache.xml.security.c14n.implementations.Canonicalizer20010315WithComments;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.transforms.Transform;
import org.apache.xml.security.transforms.TransformSpi;

public class TransformC14NWithComments extends TransformSpi {
    public XMLSignatureInput a(XMLSignatureInput xMLSignatureInput, OutputStream outputStream, Transform transform) {
        Canonicalizer20010315WithComments canonicalizer20010315WithComments = new Canonicalizer20010315WithComments();
        if (outputStream != null) {
            canonicalizer20010315WithComments.a(outputStream);
        }
        XMLSignatureInput xMLSignatureInput2 = new XMLSignatureInput(canonicalizer20010315WithComments.b(xMLSignatureInput));
        if (outputStream != null) {
            xMLSignatureInput2.b(outputStream);
        }
        return xMLSignatureInput2;
    }

    public XMLSignatureInput a(XMLSignatureInput xMLSignatureInput, Transform transform) {
        return a(xMLSignatureInput, (OutputStream) null, transform);
    }
}
