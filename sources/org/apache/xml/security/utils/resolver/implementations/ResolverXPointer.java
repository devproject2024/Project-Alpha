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

public class ResolverXPointer extends ResourceResolverSpi {

    /* renamed from: d  reason: collision with root package name */
    static Log f72818d;

    /* renamed from: e  reason: collision with root package name */
    static Class f72819e;

    /* renamed from: f  reason: collision with root package name */
    private static final int f72820f = 13;

    static {
        Class cls = f72819e;
        if (cls == null) {
            cls = c("org.apache.xml.security.utils.resolver.implementations.ResolverXPointer");
            f72819e = cls;
        }
        f72818d = LogFactory.getLog(cls.getName());
    }

    static Class c(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    private static boolean d(String str) {
        return str.equals("#xpointer(/)");
    }

    private static boolean e(String str) {
        if (str.startsWith("#xpointer(id(") && str.endsWith("))")) {
            String substring = str.substring(f72820f, str.length() - 2);
            int length = substring.length() - 1;
            if ((substring.charAt(0) == '\"' && substring.charAt(length) == '\"') || (substring.charAt(0) == '\'' && substring.charAt(length) == '\'')) {
                if (f72818d.isDebugEnabled()) {
                    Log log = f72818d;
                    StringBuffer stringBuffer = new StringBuffer("Id=");
                    stringBuffer.append(substring.substring(1, length));
                    log.debug(stringBuffer.toString());
                }
                return true;
            }
        }
        return false;
    }

    private static String f(String str) {
        if (!str.startsWith("#xpointer(id(") || !str.endsWith("))")) {
            return null;
        }
        String substring = str.substring(f72820f, str.length() - 2);
        int length = substring.length() - 1;
        if ((substring.charAt(0) == '\"' && substring.charAt(length) == '\"') || (substring.charAt(0) == '\'' && substring.charAt(length) == '\'')) {
            return substring.substring(1, length);
        }
        return null;
    }

    public XMLSignatureInput a(Attr attr, String str) {
        Document ownerDocument = attr.getOwnerElement().getOwnerDocument();
        String nodeValue = attr.getNodeValue();
        Node node = ownerDocument;
        if (!d(nodeValue)) {
            if (e(nodeValue)) {
                String f2 = f(nodeValue);
                Node a2 = IdResolver.a(ownerDocument, f2);
                node = a2;
                if (a2 == null) {
                    throw new ResourceResolverException("signature.Verification.MissingID", new Object[]{f2}, attr, str);
                }
            } else {
                node = null;
            }
        }
        XMLSignatureInput xMLSignatureInput = new XMLSignatureInput(node);
        xMLSignatureInput.a("text/xml");
        xMLSignatureInput.b((str == null || str.length() <= 0) ? attr.getNodeValue() : str.concat(attr.getNodeValue()));
        return xMLSignatureInput;
    }

    public boolean a() {
        return true;
    }

    public boolean b(Attr attr, String str) {
        if (attr == null) {
            return false;
        }
        String nodeValue = attr.getNodeValue();
        return d(nodeValue) || e(nodeValue);
    }
}
