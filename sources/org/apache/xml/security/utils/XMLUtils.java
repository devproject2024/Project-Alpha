package org.apache.xml.security.utils;

import com.business.merchant_payments.utility.StringUtility;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class XMLUtils {

    /* renamed from: a  reason: collision with root package name */
    static String f72794a = null;

    /* renamed from: b  reason: collision with root package name */
    static String f72795b = null;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f72796c = ((Boolean) AccessController.doPrivileged(new PrivilegedAction() {
        public Object run() {
            return Boolean.valueOf(Boolean.getBoolean("org.apache.xml.security.ignoreLineBreaks"));
        }
    })).booleanValue();

    /* renamed from: d  reason: collision with root package name */
    private static Map f72797d = Collections.synchronizedMap(new HashMap());

    private XMLUtils() {
    }

    public static String a(Element element) {
        StringBuffer stringBuffer = new StringBuffer();
        NodeList childNodes = element.getChildNodes();
        int length = childNodes.getLength();
        for (int i2 = 0; i2 < length; i2++) {
            Node item = childNodes.item(i2);
            if (item.getNodeType() == 3) {
                stringBuffer.append(((Text) item).getData());
            }
        }
        return stringBuffer.toString();
    }

    public static Document a(Set set) {
        Iterator it2 = set.iterator();
        NullPointerException e2 = null;
        while (it2.hasNext()) {
            Node node = (Node) it2.next();
            short nodeType = node.getNodeType();
            if (nodeType == 9) {
                return (Document) node;
            }
            if (nodeType != 2) {
                return node.getOwnerDocument();
            }
            try {
                return ((Attr) node).getOwnerElement().getOwnerDocument();
            } catch (NullPointerException e3) {
                e2 = e3;
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(I18n.a("endorsed.jdk1.4.0"));
        stringBuffer.append(" Original message was \"");
        stringBuffer.append(e2 == null ? "" : e2.getMessage());
        stringBuffer.append("\"");
        throw new NullPointerException(stringBuffer.toString());
    }

    public static Element a(Document document, String str) {
        if (document != null) {
            String str2 = f72794a;
            if (str2 == null || str2.length() == 0) {
                return document.createElementNS("http://www.w3.org/2000/09/xmldsig#", str);
            }
            String str3 = (String) f72797d.get(str);
            if (str3 == null) {
                StringBuffer stringBuffer = new StringBuffer(f72794a);
                stringBuffer.append(':');
                stringBuffer.append(str);
                str3 = stringBuffer.toString();
                f72797d.put(str, str3);
            }
            return document.createElementNS("http://www.w3.org/2000/09/xmldsig#", str3);
        }
        throw new RuntimeException("Document is null");
    }

    public static Element a(Node node) {
        while (node != null && node.getNodeType() != 1) {
            node = node.getNextSibling();
        }
        return (Element) node;
    }

    public static Element a(Node node, String str, int i2) {
        while (node != null) {
            if ("http://www.w3.org/2000/09/xmldsig#".equals(node.getNamespaceURI()) && node.getLocalName().equals(str)) {
                if (i2 == 0) {
                    return (Element) node;
                }
                i2--;
            }
            node = node.getNextSibling();
        }
        return null;
    }

    public static Element a(Node node, String str, String str2, int i2) {
        while (node != null) {
            if (node.getNamespaceURI() != null && node.getNamespaceURI().equals(str) && node.getLocalName().equals(str2)) {
                if (i2 == 0) {
                    return (Element) node;
                }
                i2--;
            }
            node = node.getNextSibling();
        }
        return null;
    }

    public static void a(Document document) {
        Element documentElement = document.getDocumentElement();
        if (documentElement.getAttributeNodeNS("http://www.w3.org/2000/xmlns/", "xmlns") == null) {
            documentElement.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns", "");
        }
        c(document);
    }

    public static void a(Node node, Set set, Node node2, boolean z) {
        if (node2 == null || !a(node2, node)) {
            b(node, set, node2, z);
        }
    }

    public static boolean a() {
        return f72796c;
    }

    public static boolean a(Node node, Node node2) {
        if (node == node2) {
            return true;
        }
        while (node2 != null) {
            if (node2 == node) {
                return true;
            }
            node2 = node2.getNodeType() == 2 ? ((Attr) node2).getOwnerElement() : node2.getParentNode();
        }
        return false;
    }

    public static Element[] a(Node node, String str) {
        return a(node, "http://www.w3.org/2000/09/xmldsig#", str);
    }

    public static Element[] a(Node node, String str, String str2) {
        Element[] elementArr = new Element[20];
        int i2 = 0;
        int i3 = 20;
        while (node != null) {
            if (node.getNamespaceURI() != null && node.getNamespaceURI().equals(str) && node.getLocalName().equals(str2)) {
                int i4 = i2 + 1;
                elementArr[i2] = (Element) node;
                if (i3 <= i4) {
                    int i5 = i3 << 2;
                    Element[] elementArr2 = new Element[i5];
                    System.arraycopy(elementArr, 0, elementArr2, 0, i3);
                    i3 = i5;
                    i2 = i4;
                    elementArr = elementArr2;
                } else {
                    i2 = i4;
                }
            }
            node = node.getNextSibling();
        }
        Element[] elementArr3 = new Element[i2];
        System.arraycopy(elementArr, 0, elementArr3, 0, i2);
        return elementArr3;
    }

    public static Document b(Node node) {
        if (node.getNodeType() == 9) {
            return (Document) node;
        }
        try {
            return node.getOwnerDocument();
        } catch (NullPointerException e2) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(I18n.a("endorsed.jdk1.4.0"));
            stringBuffer.append(" Original message was \"");
            stringBuffer.append(e2.getMessage());
            stringBuffer.append("\"");
            throw new NullPointerException(stringBuffer.toString());
        }
    }

    public static Text b(Node node, String str, int i2) {
        Element a2 = a(node, str, i2);
        if (a2 == null) {
            return null;
        }
        Node firstChild = a2.getFirstChild();
        while (firstChild != null && firstChild.getNodeType() != 3) {
            firstChild = firstChild.getNextSibling();
        }
        return (Text) firstChild;
    }

    public static void b(Element element) {
        if (!f72796c) {
            element.appendChild(element.getOwnerDocument().createTextNode(StringUtility.NEW_LINE));
        }
    }

    static final void b(Node node, Set set, Node node2, boolean z) {
        if (node != node2) {
            short nodeType = node.getNodeType();
            if (nodeType != 1) {
                switch (nodeType) {
                    case 8:
                        if (z) {
                            set.add(node);
                            return;
                        }
                        return;
                    case 9:
                        break;
                    case 10:
                        return;
                    default:
                        set.add(node);
                        return;
                }
            } else {
                set.add(node);
                Element element = (Element) node;
                if (element.hasAttributes()) {
                    NamedNodeMap attributes = element.getAttributes();
                    for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                        set.add(attributes.item(i2));
                    }
                }
            }
            Node firstChild = node.getFirstChild();
            while (firstChild != null) {
                if (firstChild.getNodeType() == 3) {
                    set.add(firstChild);
                    while (firstChild != null && firstChild.getNodeType() == 3) {
                        firstChild = firstChild.getNextSibling();
                    }
                    if (firstChild == null) {
                        return;
                    }
                }
                b(firstChild, set, node2, z);
                firstChild = firstChild.getNextSibling();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        if (r2 != 9) goto L_0x0071;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0082 A[LOOP:0: B:1:0x0002->B:31:0x0082, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0081 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void c(org.w3c.dom.Node r10) {
        /*
            r0 = 0
            r1 = r0
        L_0x0002:
            short r2 = r10.getNodeType()
            r3 = 1
            if (r2 == r3) goto L_0x0011
            r3 = 5
            if (r2 == r3) goto L_0x0069
            r3 = 9
            if (r2 == r3) goto L_0x0069
            goto L_0x0071
        L_0x0011:
            r2 = r10
            org.w3c.dom.Element r2 = (org.w3c.dom.Element) r2
            boolean r4 = r2.hasChildNodes()
            if (r4 == 0) goto L_0x0071
            boolean r0 = r2.hasAttributes()
            if (r0 == 0) goto L_0x0069
            org.w3c.dom.NamedNodeMap r0 = r2.getAttributes()
            int r1 = r0.getLength()
            org.w3c.dom.Node r2 = r2.getFirstChild()
        L_0x002c:
            if (r2 == 0) goto L_0x0069
            short r4 = r2.getNodeType()
            if (r4 != r3) goto L_0x0064
            r4 = r2
            org.w3c.dom.Element r4 = (org.w3c.dom.Element) r4
            r5 = 0
        L_0x0038:
            if (r5 >= r1) goto L_0x0064
            org.w3c.dom.Node r6 = r0.item(r5)
            org.w3c.dom.Attr r6 = (org.w3c.dom.Attr) r6
            java.lang.String r7 = r6.getNamespaceURI()
            java.lang.String r8 = "http://www.w3.org/2000/xmlns/"
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L_0x0061
            java.lang.String r7 = r6.getLocalName()
            boolean r7 = r4.hasAttributeNS(r8, r7)
            if (r7 != 0) goto L_0x0061
            java.lang.String r7 = r6.getName()
            java.lang.String r6 = r6.getNodeValue()
            r4.setAttributeNS(r8, r7, r6)
        L_0x0061:
            int r5 = r5 + 1
            goto L_0x0038
        L_0x0064:
            org.w3c.dom.Node r2 = r2.getNextSibling()
            goto L_0x002c
        L_0x0069:
            org.w3c.dom.Node r0 = r10.getFirstChild()
            r9 = r0
            r0 = r10
            r10 = r9
            goto L_0x0072
        L_0x0071:
            r10 = r1
        L_0x0072:
            if (r10 != 0) goto L_0x007f
            if (r0 == 0) goto L_0x007f
            org.w3c.dom.Node r10 = r0.getNextSibling()
            org.w3c.dom.Node r0 = r0.getParentNode()
            goto L_0x0072
        L_0x007f:
            if (r10 != 0) goto L_0x0082
            return
        L_0x0082:
            org.w3c.dom.Node r1 = r10.getNextSibling()
            goto L_0x0002
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xml.security.utils.XMLUtils.c(org.w3c.dom.Node):void");
    }
}
