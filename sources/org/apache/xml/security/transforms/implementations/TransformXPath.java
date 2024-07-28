package org.apache.xml.security.transforms.implementations;

import javax.xml.transform.TransformerException;
import org.apache.xml.security.exceptions.XMLSecurityRuntimeException;
import org.apache.xml.security.signature.NodeFilter;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.transforms.Transform;
import org.apache.xml.security.transforms.TransformSpi;
import org.apache.xml.security.transforms.TransformationException;
import org.apache.xml.security.utils.CachedXPathAPIHolder;
import org.apache.xml.security.utils.CachedXPathFuncHereAPI;
import org.apache.xml.security.utils.XMLUtils;
import org.apache.xml.utils.PrefixResolver;
import org.apache.xml.utils.PrefixResolverDefault;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class TransformXPath extends TransformSpi {

    class XPathNodeFilter implements NodeFilter {

        /* renamed from: a  reason: collision with root package name */
        PrefixResolverDefault f72728a;

        /* renamed from: b  reason: collision with root package name */
        CachedXPathFuncHereAPI f72729b = new CachedXPathFuncHereAPI(CachedXPathAPIHolder.a());

        /* renamed from: c  reason: collision with root package name */
        Node f72730c;

        /* renamed from: d  reason: collision with root package name */
        String f72731d;

        XPathNodeFilter(Element element, Node node, String str) {
            this.f72730c = node;
            this.f72731d = str;
            this.f72728a = new PrefixResolverDefault(element);
        }

        public int a(Node node) {
            try {
                return this.f72729b.a(node, this.f72730c, this.f72731d, (PrefixResolver) this.f72728a).bool() ? 1 : 0;
            } catch (TransformerException e2) {
                throw new XMLSecurityRuntimeException("signature.Transform.node", new Object[]{node}, e2);
            } catch (Exception e3) {
                throw new XMLSecurityRuntimeException("signature.Transform.nodeAndType", new Object[]{node, new Short(node.getNodeType())}, e3);
            }
        }

        public int a(Node node, int i2) {
            return a(node);
        }
    }

    private boolean a(String str) {
        return (str.indexOf("namespace") == -1 && str.indexOf("name()") == -1) ? false : true;
    }

    public XMLSignatureInput a(XMLSignatureInput xMLSignatureInput, Transform transform) {
        try {
            CachedXPathAPIHolder.a(transform.k().getOwnerDocument());
            Element a2 = XMLUtils.a(transform.k().getFirstChild(), "XPath", 0);
            if (a2 != null) {
                Node item = a2.getChildNodes().item(0);
                String a3 = CachedXPathFuncHereAPI.a(item);
                xMLSignatureInput.a(a(a3));
                if (item != null) {
                    xMLSignatureInput.a((NodeFilter) new XPathNodeFilter(a2, item, a3));
                    xMLSignatureInput.d(true);
                    return xMLSignatureInput;
                }
                throw new DOMException(3, "Text must be in ds:Xpath");
            }
            throw new TransformationException("xml.WrongContent", new Object[]{"ds:XPath", "Transform"});
        } catch (DOMException e2) {
            throw new TransformationException("empty", (Exception) e2);
        }
    }
}
