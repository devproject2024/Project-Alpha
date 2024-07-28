package org.apache.xml.security.c14n.implementations;

import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import org.apache.xml.security.c14n.CanonicalizationException;
import org.apache.xml.security.c14n.helper.C14nHelper;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.transforms.params.InclusiveNamespaces;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public abstract class Canonicalizer20010315Excl extends CanonicalizerBase {

    /* renamed from: b  reason: collision with root package name */
    TreeSet f72590b = new TreeSet();

    /* renamed from: c  reason: collision with root package name */
    final SortedSet f72591c = new TreeSet(f72597g);

    public Canonicalizer20010315Excl(boolean z) {
        super(z);
    }

    /* access modifiers changed from: package-private */
    public Iterator a(Element element, NameSpaceSymbTable nameSpaceSymbTable) {
        int i2;
        NamedNodeMap namedNodeMap;
        String prefix;
        SortedSet sortedSet = this.f72591c;
        sortedSet.clear();
        if (element.hasAttributes()) {
            namedNodeMap = element.getAttributes();
            i2 = namedNodeMap.getLength();
        } else {
            namedNodeMap = null;
            i2 = 0;
        }
        SortedSet<String> sortedSet2 = (SortedSet) this.f72590b.clone();
        int i3 = 0;
        while (true) {
            String str = "xmlns";
            if (i3 < i2) {
                Attr attr = (Attr) namedNodeMap.item(i3);
                if (!"http://www.w3.org/2000/xmlns/".equals(attr.getNamespaceURI())) {
                    String prefix2 = attr.getPrefix();
                    if (prefix2 != null && !prefix2.equals("xml") && !prefix2.equals(str)) {
                        sortedSet2.add(prefix2);
                    }
                    sortedSet.add(attr);
                } else {
                    String localName = attr.getLocalName();
                    String nodeValue = attr.getNodeValue();
                    if ((!"xml".equals(localName) || !"http://www.w3.org/XML/1998/namespace".equals(nodeValue)) && nameSpaceSymbTable.a(localName, nodeValue, attr) && C14nHelper.a(nodeValue)) {
                        throw new CanonicalizationException("c14n.Canonicalizer.RelativeNamespace", new Object[]{element.getTagName(), localName, attr.getNodeValue()});
                    }
                }
                i3++;
            } else {
                if (!(element.getNamespaceURI() == null || (prefix = element.getPrefix()) == null || prefix.length() == 0)) {
                    str = prefix;
                }
                sortedSet2.add(str);
                for (String a2 : sortedSet2) {
                    Attr a3 = nameSpaceSymbTable.a(a2);
                    if (a3 != null) {
                        sortedSet.add(a3);
                    }
                }
                return sortedSet.iterator();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(XMLSignatureInput xMLSignatureInput) {
        if (xMLSignatureInput.a() && !this.f72590b.isEmpty()) {
            XMLUtils.a(xMLSignatureInput.m() != null ? XMLUtils.b(xMLSignatureInput.m()) : XMLUtils.a(xMLSignatureInput.b()));
        }
    }

    public byte[] a(XMLSignatureInput xMLSignatureInput, String str) {
        this.f72590b = (TreeSet) InclusiveNamespaces.a(str);
        return super.b(xMLSignatureInput);
    }

    public byte[] a(Node node) {
        return a(node, "", (Node) null);
    }

    public byte[] a(Node node, String str) {
        return a(node, str, (Node) null);
    }

    public byte[] a(Node node, String str, Node node2) {
        this.f72590b = (TreeSet) InclusiveNamespaces.a(str);
        return super.a(node, node2);
    }

    /* access modifiers changed from: package-private */
    public final Iterator b(Element element, NameSpaceSymbTable nameSpaceSymbTable) {
        int i2;
        NamedNodeMap namedNodeMap;
        String prefix;
        Node b2;
        Element element2 = element;
        NameSpaceSymbTable nameSpaceSymbTable2 = nameSpaceSymbTable;
        SortedSet sortedSet = this.f72591c;
        sortedSet.clear();
        Set<String> set = null;
        if (element.hasAttributes()) {
            namedNodeMap = element.getAttributes();
            i2 = namedNodeMap.getLength();
        } else {
            namedNodeMap = null;
            i2 = 0;
        }
        boolean z = a((Node) element2, nameSpaceSymbTable.f()) == 1;
        if (z) {
            set = (Set) this.f72590b.clone();
        }
        for (int i3 = 0; i3 < i2; i3++) {
            Attr attr = (Attr) namedNodeMap.item(i3);
            if ("http://www.w3.org/2000/xmlns/".equals(attr.getNamespaceURI())) {
                String localName = attr.getLocalName();
                if (!z || c(attr) || "xmlns".equals(localName)) {
                    String nodeValue = attr.getNodeValue();
                    if (!z && c(attr) && this.f72590b.contains(localName) && !nameSpaceSymbTable2.e(localName) && (b2 = nameSpaceSymbTable2.b(localName, nodeValue, attr)) != null) {
                        sortedSet.add(b2);
                        if (C14nHelper.a(attr)) {
                            throw new CanonicalizationException("c14n.Canonicalizer.RelativeNamespace", new Object[]{element.getTagName(), localName, attr.getNodeValue()});
                        }
                    }
                    if (nameSpaceSymbTable2.a(localName, nodeValue, attr) && C14nHelper.a(nodeValue)) {
                        throw new CanonicalizationException("c14n.Canonicalizer.RelativeNamespace", new Object[]{element.getTagName(), localName, attr.getNodeValue()});
                    }
                } else {
                    nameSpaceSymbTable2.d(localName);
                }
            } else if (c(attr) && z) {
                String prefix2 = attr.getPrefix();
                if (prefix2 != null && !prefix2.equals("xml") && !prefix2.equals("xmlns")) {
                    set.add(prefix2);
                }
                sortedSet.add(attr);
            }
        }
        if (z) {
            Attr attributeNodeNS = element2.getAttributeNodeNS("http://www.w3.org/2000/xmlns/", "xmlns");
            if (attributeNodeNS != null && !c(attributeNodeNS)) {
                nameSpaceSymbTable2.a("xmlns", "", f72599i);
            }
            if (element.getNamespaceURI() == null || (prefix = element.getPrefix()) == null || prefix.length() == 0) {
                set.add("xmlns");
            } else {
                set.add(prefix);
            }
            for (String a2 : set) {
                Attr a3 = nameSpaceSymbTable2.a(a2);
                if (a3 != null) {
                    sortedSet.add(a3);
                }
            }
        }
        return sortedSet.iterator();
    }
}
