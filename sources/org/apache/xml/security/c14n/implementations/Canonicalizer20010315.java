package org.apache.xml.security.c14n.implementations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import org.apache.xml.security.c14n.CanonicalizationException;
import org.apache.xml.security.c14n.helper.C14nHelper;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public abstract class Canonicalizer20010315 extends CanonicalizerBase {

    /* renamed from: b  reason: collision with root package name */
    boolean f72580b = true;

    /* renamed from: c  reason: collision with root package name */
    final SortedSet f72581c = new TreeSet(f72597g);

    /* renamed from: d  reason: collision with root package name */
    XmlAttrStack f72582d = new XmlAttrStack();

    class XmlAttrStack {

        /* renamed from: a  reason: collision with root package name */
        int f72583a = 0;

        /* renamed from: b  reason: collision with root package name */
        int f72584b = 0;

        /* renamed from: c  reason: collision with root package name */
        XmlsStackElement f72585c;

        /* renamed from: d  reason: collision with root package name */
        List f72586d = new ArrayList();

        class XmlsStackElement {

            /* renamed from: a  reason: collision with root package name */
            int f72587a;

            /* renamed from: b  reason: collision with root package name */
            boolean f72588b = false;

            /* renamed from: c  reason: collision with root package name */
            List f72589c = new ArrayList();

            XmlsStackElement() {
            }
        }

        XmlAttrStack() {
        }

        /* access modifiers changed from: package-private */
        public void a(int i2) {
            this.f72583a = i2;
            if (this.f72583a != -1) {
                this.f72585c = null;
                while (this.f72584b >= this.f72583a) {
                    List list = this.f72586d;
                    list.remove(list.size() - 1);
                    if (this.f72586d.size() == 0) {
                        this.f72584b = 0;
                        return;
                    } else {
                        List list2 = this.f72586d;
                        this.f72584b = ((XmlsStackElement) list2.get(list2.size() - 1)).f72587a;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0037, code lost:
            if ((r3.f72587a + 1) == r6.f72583a) goto L_0x0024;
         */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x003c  */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0048  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(java.util.Collection r7) {
            /*
                r6 = this;
                java.util.List r0 = r6.f72586d
                int r0 = r0.size()
                r1 = 1
                int r0 = r0 - r1
                org.apache.xml.security.c14n.implementations.Canonicalizer20010315$XmlAttrStack$XmlsStackElement r2 = r6.f72585c
                if (r2 != 0) goto L_0x0020
                org.apache.xml.security.c14n.implementations.Canonicalizer20010315$XmlAttrStack$XmlsStackElement r2 = new org.apache.xml.security.c14n.implementations.Canonicalizer20010315$XmlAttrStack$XmlsStackElement
                r2.<init>()
                r6.f72585c = r2
                org.apache.xml.security.c14n.implementations.Canonicalizer20010315$XmlAttrStack$XmlsStackElement r2 = r6.f72585c
                int r3 = r6.f72583a
                r2.f72587a = r3
                r6.f72584b = r3
                java.util.List r3 = r6.f72586d
                r3.add(r2)
            L_0x0020:
                r2 = 0
                r3 = -1
                if (r0 != r3) goto L_0x0026
            L_0x0024:
                r2 = 1
                goto L_0x003a
            L_0x0026:
                java.util.List r3 = r6.f72586d
                java.lang.Object r3 = r3.get(r0)
                org.apache.xml.security.c14n.implementations.Canonicalizer20010315$XmlAttrStack$XmlsStackElement r3 = (org.apache.xml.security.c14n.implementations.Canonicalizer20010315.XmlAttrStack.XmlsStackElement) r3
                boolean r4 = r3.f72588b
                if (r4 == 0) goto L_0x003a
                int r3 = r3.f72587a
                int r3 = r3 + r1
                int r4 = r6.f72583a
                if (r3 != r4) goto L_0x003a
                goto L_0x0024
            L_0x003a:
                if (r2 == 0) goto L_0x0048
                org.apache.xml.security.c14n.implementations.Canonicalizer20010315$XmlAttrStack$XmlsStackElement r0 = r6.f72585c
                java.util.List r0 = r0.f72589c
                r7.addAll(r0)
                org.apache.xml.security.c14n.implementations.Canonicalizer20010315$XmlAttrStack$XmlsStackElement r7 = r6.f72585c
                r7.f72588b = r1
                return
            L_0x0048:
                java.util.HashMap r2 = new java.util.HashMap
                r2.<init>()
            L_0x004d:
                if (r0 < 0) goto L_0x007e
                java.util.List r3 = r6.f72586d
                java.lang.Object r3 = r3.get(r0)
                org.apache.xml.security.c14n.implementations.Canonicalizer20010315$XmlAttrStack$XmlsStackElement r3 = (org.apache.xml.security.c14n.implementations.Canonicalizer20010315.XmlAttrStack.XmlsStackElement) r3
                java.util.List r3 = r3.f72589c
                java.util.Iterator r3 = r3.iterator()
            L_0x005d:
                boolean r4 = r3.hasNext()
                if (r4 == 0) goto L_0x007b
                java.lang.Object r4 = r3.next()
                org.w3c.dom.Attr r4 = (org.w3c.dom.Attr) r4
                java.lang.String r5 = r4.getName()
                boolean r5 = r2.containsKey(r5)
                if (r5 != 0) goto L_0x005d
                java.lang.String r5 = r4.getName()
                r2.put(r5, r4)
                goto L_0x005d
            L_0x007b:
                int r0 = r0 + -1
                goto L_0x004d
            L_0x007e:
                org.apache.xml.security.c14n.implementations.Canonicalizer20010315$XmlAttrStack$XmlsStackElement r0 = r6.f72585c
                r0.f72588b = r1
                java.util.Collection r0 = r2.values()
                r7.addAll(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.xml.security.c14n.implementations.Canonicalizer20010315.XmlAttrStack.a(java.util.Collection):void");
        }

        /* access modifiers changed from: package-private */
        public void a(Attr attr) {
            if (this.f72585c == null) {
                this.f72585c = new XmlsStackElement();
                XmlsStackElement xmlsStackElement = this.f72585c;
                xmlsStackElement.f72587a = this.f72583a;
                this.f72586d.add(xmlsStackElement);
                this.f72584b = this.f72583a;
            }
            this.f72585c.f72589c.add(attr);
        }
    }

    public Canonicalizer20010315(boolean z) {
        super(z);
    }

    /* access modifiers changed from: package-private */
    public Iterator a(Element element, NameSpaceSymbTable nameSpaceSymbTable) {
        Node b2;
        if (!element.hasAttributes() && !this.f72580b) {
            return null;
        }
        SortedSet sortedSet = this.f72581c;
        sortedSet.clear();
        NamedNodeMap attributes = element.getAttributes();
        int length = attributes.getLength();
        for (int i2 = 0; i2 < length; i2++) {
            Attr attr = (Attr) attributes.item(i2);
            if (!"http://www.w3.org/2000/xmlns/".equals(attr.getNamespaceURI())) {
                sortedSet.add(attr);
            } else {
                String localName = attr.getLocalName();
                String value = attr.getValue();
                if ((!"xml".equals(localName) || !"http://www.w3.org/XML/1998/namespace".equals(value)) && (b2 = nameSpaceSymbTable.b(localName, value, attr)) != null) {
                    sortedSet.add(b2);
                    if (C14nHelper.a(attr)) {
                        throw new CanonicalizationException("c14n.Canonicalizer.RelativeNamespace", new Object[]{element.getTagName(), localName, attr.getNodeValue()});
                    }
                }
            }
        }
        if (this.f72580b) {
            nameSpaceSymbTable.a((Collection) sortedSet);
            this.f72582d.a((Collection) sortedSet);
            this.f72580b = false;
        }
        return sortedSet.iterator();
    }

    /* access modifiers changed from: package-private */
    public void a(XMLSignatureInput xMLSignatureInput) {
        if (xMLSignatureInput.a()) {
            XMLUtils.a(xMLSignatureInput.m() != null ? XMLUtils.b(xMLSignatureInput.m()) : XMLUtils.a(xMLSignatureInput.b()));
        }
    }

    public byte[] a(Node node, String str) {
        throw new CanonicalizationException("c14n.Canonicalizer.UnsupportedOperation");
    }

    /* access modifiers changed from: package-private */
    public Iterator b(Element element, NameSpaceSymbTable nameSpaceSymbTable) {
        int i2;
        NamedNodeMap namedNodeMap;
        Node b2;
        Element element2 = element;
        NameSpaceSymbTable nameSpaceSymbTable2 = nameSpaceSymbTable;
        this.f72582d.a(nameSpaceSymbTable.f());
        boolean z = a((Node) element2, nameSpaceSymbTable.f()) == 1;
        if (element.hasAttributes()) {
            namedNodeMap = element.getAttributes();
            i2 = namedNodeMap.getLength();
        } else {
            namedNodeMap = null;
            i2 = 0;
        }
        SortedSet sortedSet = this.f72581c;
        sortedSet.clear();
        for (int i3 = 0; i3 < i2; i3++) {
            Attr attr = (Attr) namedNodeMap.item(i3);
            String namespaceURI = attr.getNamespaceURI();
            if ("http://www.w3.org/2000/xmlns/".equals(namespaceURI)) {
                String localName = attr.getLocalName();
                String value = attr.getValue();
                if (!"xml".equals(localName) || !"http://www.w3.org/XML/1998/namespace".equals(value)) {
                    if (c(attr)) {
                        if ((z || !nameSpaceSymbTable2.e(localName)) && (b2 = nameSpaceSymbTable2.b(localName, value, attr)) != null) {
                            sortedSet.add(b2);
                            if (C14nHelper.a(attr)) {
                                throw new CanonicalizationException("c14n.Canonicalizer.RelativeNamespace", new Object[]{element.getTagName(), localName, attr.getNodeValue()});
                            }
                        }
                    } else if (!z || "xmlns".equals(localName)) {
                        nameSpaceSymbTable2.a(localName, value, attr);
                    } else {
                        nameSpaceSymbTable2.c(localName);
                    }
                }
            } else if ("http://www.w3.org/XML/1998/namespace".equals(namespaceURI)) {
                this.f72582d.a(attr);
            } else if (z) {
                sortedSet.add(attr);
            }
        }
        if (z) {
            Attr attributeNodeNS = element2.getAttributeNodeNS("http://www.w3.org/2000/xmlns/", "xmlns");
            Object a2 = attributeNodeNS == null ? nameSpaceSymbTable2.a("xmlns") : !c(attributeNodeNS) ? nameSpaceSymbTable2.b("xmlns", "", f72599i) : null;
            if (a2 != null) {
                sortedSet.add(a2);
            }
            this.f72582d.a((Collection) sortedSet);
            nameSpaceSymbTable2.a((Collection) sortedSet);
        }
        return sortedSet.iterator();
    }

    /* access modifiers changed from: package-private */
    public void c(Element element, NameSpaceSymbTable nameSpaceSymbTable) {
        if (element.hasAttributes()) {
            this.f72582d.a(-1);
            NamedNodeMap attributes = element.getAttributes();
            int length = attributes.getLength();
            for (int i2 = 0; i2 < length; i2++) {
                Attr attr = (Attr) attributes.item(i2);
                if ("http://www.w3.org/2000/xmlns/".equals(attr.getNamespaceURI())) {
                    String localName = attr.getLocalName();
                    String nodeValue = attr.getNodeValue();
                    if (!"xml".equals(localName) || !"http://www.w3.org/XML/1998/namespace".equals(nodeValue)) {
                        nameSpaceSymbTable.a(localName, nodeValue, attr);
                    }
                } else if ("http://www.w3.org/XML/1998/namespace".equals(attr.getNamespaceURI())) {
                    this.f72582d.a(attr);
                }
            }
        }
    }
}
