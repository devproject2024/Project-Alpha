package org.apache.xml.security.transforms.implementations;

import com.paytmmoney.lite.mod.util.PMConstants;
import org.apache.xml.security.signature.NodeFilter;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.transforms.Transform;
import org.apache.xml.security.transforms.TransformSpi;
import org.apache.xml.security.transforms.TransformationException;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class TransformEnvelopedSignature extends TransformSpi {

    class EnvelopedNodeFilter implements NodeFilter {

        /* renamed from: a  reason: collision with root package name */
        Node f72727a;

        EnvelopedNodeFilter(Node node) {
            this.f72727a = node;
        }

        public int a(Node node) {
            Node node2 = this.f72727a;
            return (node == node2 || XMLUtils.a(node2, node)) ? -1 : 1;
        }

        public int a(Node node, int i2) {
            return node == this.f72727a ? -1 : 1;
        }
    }

    private static Node a(Node node) {
        boolean z;
        while (true) {
            if (node != null && node.getNodeType() != 9) {
                Element element = (Element) node;
                if (element.getNamespaceURI().equals("http://www.w3.org/2000/09/xmldsig#") && element.getLocalName().equals(PMConstants.SIGNATURE)) {
                    z = true;
                    break;
                }
                node = node.getParentNode();
            } else {
                z = false;
            }
        }
        z = false;
        if (z) {
            return node;
        }
        throw new TransformationException("transform.envelopedSignatureTransformNotInSignatureElement");
    }

    public XMLSignatureInput a(XMLSignatureInput xMLSignatureInput, Transform transform) {
        Node a2 = a(transform.k());
        xMLSignatureInput.a(a2);
        xMLSignatureInput.a((NodeFilter) new EnvelopedNodeFilter(a2));
        return xMLSignatureInput;
    }
}
