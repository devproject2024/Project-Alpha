package org.apache.xml.security.utils.resolver.implementations;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.utils.IdResolver;
import org.apache.xml.security.utils.resolver.ResourceResolverException;
import org.apache.xml.security.utils.resolver.ResourceResolverSpi;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class ResolverFragment extends ResourceResolverSpi {

    /* renamed from: d  reason: collision with root package name */
    static Log f72813d;

    /* renamed from: e  reason: collision with root package name */
    static Class f72814e;

    static {
        Class cls = f72814e;
        if (cls == null) {
            cls = c("org.apache.xml.security.utils.resolver.implementations.ResolverFragment");
            f72814e = cls;
        }
        f72813d = LogFactory.getLog(cls.getName());
    }

    static Class c(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    public XMLSignatureInput a(Attr attr, String str) {
        Node node;
        String nodeValue = attr.getNodeValue();
        Document ownerDocument = attr.getOwnerElement().getOwnerDocument();
        if (nodeValue.equals("")) {
            f72813d.debug("ResolverFragment with empty URI (means complete document)");
            node = ownerDocument;
        } else {
            String substring = nodeValue.substring(1);
            Node a2 = IdResolver.a(ownerDocument, substring);
            if (a2 != null) {
                node = a2;
                if (f72813d.isDebugEnabled()) {
                    Log log = f72813d;
                    StringBuffer stringBuffer = new StringBuffer("Try to catch an Element with ID ");
                    stringBuffer.append(substring);
                    stringBuffer.append(" and Element was ");
                    stringBuffer.append(a2);
                    log.debug(stringBuffer.toString());
                    node = a2;
                }
            } else {
                throw new ResourceResolverException("signature.Verification.MissingID", new Object[]{substring}, attr, str);
            }
        }
        XMLSignatureInput xMLSignatureInput = new XMLSignatureInput(node);
        xMLSignatureInput.c(true);
        xMLSignatureInput.a("text/xml");
        String nodeValue2 = attr.getNodeValue();
        if (str != null) {
            nodeValue2 = str.concat(nodeValue2);
        }
        xMLSignatureInput.b(nodeValue2);
        return xMLSignatureInput;
    }

    public boolean a() {
        return true;
    }

    public boolean b(Attr attr, String str) {
        if (attr == null) {
            f72813d.debug("Quick fail for null uri");
            return false;
        }
        String nodeValue = attr.getNodeValue();
        if (nodeValue.equals("") || (nodeValue.charAt(0) == '#' && (nodeValue.charAt(1) != 'x' || !nodeValue.startsWith("#xpointer(")))) {
            if (f72813d.isDebugEnabled()) {
                Log log = f72813d;
                StringBuffer stringBuffer = new StringBuffer("State I can resolve reference: \"");
                stringBuffer.append(nodeValue);
                stringBuffer.append("\"");
                log.debug(stringBuffer.toString());
            }
            return true;
        }
        if (f72813d.isDebugEnabled()) {
            Log log2 = f72813d;
            StringBuffer stringBuffer2 = new StringBuffer("Do not seem to be able to resolve reference: \"");
            stringBuffer2.append(nodeValue);
            stringBuffer2.append("\"");
            log2.debug(stringBuffer2.toString());
        }
        return false;
    }
}
