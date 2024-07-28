package org.apache.xml.security.utils;

import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.WeakHashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class IdResolver {

    /* renamed from: a  reason: collision with root package name */
    static Class f72770a;

    /* renamed from: b  reason: collision with root package name */
    private static Log f72771b;

    /* renamed from: c  reason: collision with root package name */
    private static WeakHashMap f72772c = new WeakHashMap();

    /* renamed from: d  reason: collision with root package name */
    private static List f72773d;

    /* renamed from: e  reason: collision with root package name */
    private static int f72774e;

    static {
        Class cls = f72770a;
        if (cls == null) {
            cls = a("org.apache.xml.security.utils.IdResolver");
            f72770a = cls;
        }
        f72771b = LogFactory.getLog(cls.getName());
        List asList = Arrays.asList(new String[]{"http://www.w3.org/2000/09/xmldsig#", "http://www.w3.org/2001/04/xmlenc#", "http://schemas.xmlsoap.org/soap/security/2000-12", "http://www.w3.org/2002/03/xkms#", "urn:oasis:names:tc:SAML:1.0:assertion", "urn:oasis:names:tc:SAML:1.0:protocol"});
        f72773d = asList;
        f72774e = asList.size();
    }

    private IdResolver() {
    }

    public static int a(Element element, String str, Element[] elementArr) {
        if (!element.hasAttributes()) {
            return 0;
        }
        NamedNodeMap attributes = element.getAttributes();
        int indexOf = f72773d.indexOf(element.getNamespaceURI());
        if (indexOf < 0) {
            indexOf = f72774e;
        }
        int length = attributes.getLength();
        for (int i2 = 0; i2 < length; i2++) {
            Attr attr = (Attr) attributes.item(i2);
            int indexOf2 = attr.getNamespaceURI() == null ? indexOf : f72773d.indexOf(attr.getNamespaceURI());
            if (indexOf2 < 0) {
                indexOf2 = f72774e;
            }
            String localName = attr.getLocalName();
            if (localName == null) {
                localName = attr.getName();
            }
            if (localName.length() <= 2) {
                String nodeValue = attr.getNodeValue();
                if (localName.charAt(0) == 'I') {
                    char charAt = localName.charAt(1);
                    if (charAt == 'd' && nodeValue.equals(str)) {
                        elementArr[indexOf2] = element;
                        if (indexOf2 == 0) {
                            return 1;
                        }
                    } else if (charAt == 'D' && nodeValue.endsWith(str)) {
                        if (indexOf2 != 3) {
                            indexOf2 = f72774e;
                        }
                        elementArr[indexOf2] = element;
                    }
                } else if ("id".equals(localName) && nodeValue.equals(str)) {
                    if (indexOf2 != 2) {
                        indexOf2 = f72774e;
                    }
                    elementArr[indexOf2] = element;
                }
            }
        }
        if (indexOf == 3 && (element.getAttribute("OriginalRequestID").equals(str) || element.getAttribute("RequestID").equals(str) || element.getAttribute("ResponseID").equals(str))) {
            elementArr[3] = element;
        } else if (indexOf == 4 && element.getAttribute("AssertionID").equals(str)) {
            elementArr[4] = element;
        } else if (indexOf == 5 && (element.getAttribute("RequestID").equals(str) || element.getAttribute("ResponseID").equals(str))) {
            elementArr[5] = element;
        }
        return 0;
    }

    private static int a(Node node, String str, Element[] elementArr) {
        Element element = null;
        Node node2 = null;
        while (true) {
            short nodeType = node.getNodeType();
            if (nodeType != 1) {
                node = (nodeType == 9 || nodeType == 11) ? node.getFirstChild() : node2;
            } else {
                Element element2 = (Element) node;
                if (a(element2, str, elementArr) == 1) {
                    return 1;
                }
                Node firstChild = node.getFirstChild();
                if (firstChild != null) {
                    element = element2;
                } else if (element != null) {
                    node = node.getNextSibling();
                }
                node = firstChild;
            }
            while (node == null && element != null) {
                node = element.getNextSibling();
                element = element.getParentNode();
                if (!(element == null || 1 == element.getNodeType())) {
                    element = null;
                }
            }
            if (node == null) {
                return 1;
            }
            node2 = node.getNextSibling();
        }
    }

    static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    public static Element a(Document document, String str) {
        Log log;
        StringBuffer stringBuffer;
        Element c2 = c(document, str);
        if (c2 != null) {
            log = f72771b;
            stringBuffer = new StringBuffer("I could find an Element using the simple getElementByIdType method: ");
        } else {
            c2 = b(document, str);
            if (c2 != null) {
                log = f72771b;
                stringBuffer = new StringBuffer("I could find an Element using the simple getElementByIdUsingDOM method: ");
            } else {
                Element a2 = a((Node) document, str);
                if (a2 == null) {
                    return null;
                }
                a(a2, str);
                return a2;
            }
        }
        stringBuffer.append(c2.getTagName());
        log.debug(stringBuffer.toString());
        return c2;
    }

    private static Element a(Node node, String str) {
        Element[] elementArr = new Element[(f72774e + 1)];
        a(node, str, elementArr);
        for (int i2 = 0; i2 < elementArr.length; i2++) {
            if (elementArr[i2] != null) {
                return elementArr[i2];
            }
        }
        return null;
    }

    public static void a(Element element, String str) {
        WeakHashMap weakHashMap;
        Document ownerDocument = element.getOwnerDocument();
        synchronized (f72772c) {
            weakHashMap = (WeakHashMap) f72772c.get(ownerDocument);
            if (weakHashMap == null) {
                weakHashMap = new WeakHashMap();
                f72772c.put(ownerDocument, weakHashMap);
            }
        }
        weakHashMap.put(str, new WeakReference(element));
    }

    private static Element b(Document document, String str) {
        if (f72771b.isDebugEnabled()) {
            f72771b.debug("getElementByIdUsingDOM() Search for ID ".concat(String.valueOf(str)));
        }
        return document.getElementById(str);
    }

    private static Element c(Document document, String str) {
        WeakHashMap weakHashMap;
        WeakReference weakReference;
        if (f72771b.isDebugEnabled()) {
            f72771b.debug("getElementByIdType() Search for ID ".concat(String.valueOf(str)));
        }
        synchronized (f72772c) {
            weakHashMap = (WeakHashMap) f72772c.get(document);
        }
        if (weakHashMap == null || (weakReference = (WeakReference) weakHashMap.get(str)) == null) {
            return null;
        }
        return (Element) weakReference.get();
    }
}
