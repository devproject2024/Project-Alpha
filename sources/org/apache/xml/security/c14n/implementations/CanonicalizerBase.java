package org.apache.xml.security.c14n.implementations;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.xml.security.c14n.CanonicalizationException;
import org.apache.xml.security.c14n.CanonicalizerSpi;
import org.apache.xml.security.c14n.helper.AttrCompare;
import org.apache.xml.security.signature.NodeFilter;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.utils.UnsyncByteArrayOutputStream;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.Attr;
import org.w3c.dom.Comment;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.ProcessingInstruction;
import org.xml.sax.SAXException;

public abstract class CanonicalizerBase extends CanonicalizerSpi {

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f72592b = {63, 62};

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f72593c = {60, 63};

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f72594d = {45, 45, 62};

    /* renamed from: e  reason: collision with root package name */
    private static final byte[] f72595e = {60, 33, 45, 45};

    /* renamed from: f  reason: collision with root package name */
    private static final byte[] f72596f = {38, 35, 120, 65, 59};

    /* renamed from: g  reason: collision with root package name */
    static final AttrCompare f72597g = new AttrCompare();

    /* renamed from: h  reason: collision with root package name */
    static final byte[] f72598h = {61, 34};

    /* renamed from: i  reason: collision with root package name */
    protected static final Attr f72599i;
    private static final byte[] o = {38, 35, 120, 57, 59};
    private static final byte[] p = {38, 113, 117, 111, 116, 59};
    private static final byte[] q = {38, 35, 120, 68, 59};
    private static final byte[] r = {38, 103, 116, 59};
    private static final byte[] s = {38, 108, 116, 59};
    private static final byte[] t = {60, 47};
    private static final byte[] u = {38, 97, 109, 112, 59};
    List j;
    boolean k;
    Set l = null;
    Node m = null;
    OutputStream n = new UnsyncByteArrayOutputStream();

    static {
        try {
            Attr createAttributeNS = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument().createAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns");
            f72599i = createAttributeNS;
            createAttributeNS.setValue("");
        } catch (Exception e2) {
            throw new RuntimeException("Unable to create nullNode".concat(String.valueOf(e2)));
        }
    }

    public CanonicalizerBase(boolean z) {
        this.k = z;
    }

    static final void a(String str, OutputStream outputStream) {
        byte[] bArr;
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt == 13) {
                bArr = q;
            } else if (charAt == '&') {
                bArr = u;
            } else if (charAt == '<') {
                bArr = s;
            } else if (charAt != '>') {
                if (charAt < 128) {
                    outputStream.write(charAt);
                } else {
                    UtfHelpper.a(charAt, outputStream);
                }
            } else {
                bArr = r;
            }
            outputStream.write(bArr);
        }
    }

    static final void a(String str, String str2, OutputStream outputStream, Map map) {
        byte[] bArr;
        outputStream.write(32);
        UtfHelpper.a(str, outputStream, map);
        outputStream.write(f72598h);
        int length = str2.length();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            char charAt = str2.charAt(i2);
            if (charAt == 9) {
                bArr = o;
            } else if (charAt == 10) {
                bArr = f72596f;
            } else if (charAt == 13) {
                bArr = q;
            } else if (charAt == '\"') {
                bArr = p;
            } else if (charAt == '&') {
                bArr = u;
            } else if (charAt != '<') {
                if (charAt < 128) {
                    outputStream.write(charAt);
                } else {
                    UtfHelpper.a(charAt, outputStream);
                }
                i2 = i3;
            } else {
                bArr = s;
            }
            outputStream.write(bArr);
            i2 = i3;
        }
        outputStream.write(34);
    }

    static final void a(Comment comment, OutputStream outputStream, int i2) {
        if (i2 == 1) {
            outputStream.write(10);
        }
        outputStream.write(f72595e);
        String data = comment.getData();
        int length = data.length();
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = data.charAt(i3);
            if (charAt == 13) {
                outputStream.write(q);
            } else if (charAt < 128) {
                outputStream.write(charAt);
            } else {
                UtfHelpper.a(charAt, outputStream);
            }
        }
        outputStream.write(f72594d);
        if (i2 == -1) {
            outputStream.write(10);
        }
    }

    static final void a(ProcessingInstruction processingInstruction, OutputStream outputStream, int i2) {
        if (i2 == 1) {
            outputStream.write(10);
        }
        outputStream.write(f72593c);
        String target = processingInstruction.getTarget();
        int length = target.length();
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = target.charAt(i3);
            if (charAt == 13) {
                outputStream.write(q);
            } else if (charAt < 128) {
                outputStream.write(charAt);
            } else {
                UtfHelpper.a(charAt, outputStream);
            }
        }
        String data = processingInstruction.getData();
        int length2 = data.length();
        if (length2 > 0) {
            outputStream.write(32);
            for (int i4 = 0; i4 < length2; i4++) {
                char charAt2 = data.charAt(i4);
                if (charAt2 == 13) {
                    outputStream.write(q);
                } else {
                    UtfHelpper.a(charAt2, outputStream);
                }
            }
        }
        outputStream.write(f72592b);
        if (i2 == -1) {
            outputStream.write(10);
        }
    }

    private byte[] d(Node node) {
        try {
            b(node, node);
            this.n.close();
            if (this.n instanceof ByteArrayOutputStream) {
                byte[] byteArray = ((ByteArrayOutputStream) this.n).toByteArray();
                if (this.f72567a) {
                    ((ByteArrayOutputStream) this.n).reset();
                }
                return byteArray;
            } else if (!(this.n instanceof UnsyncByteArrayOutputStream)) {
                return null;
            } else {
                byte[] a2 = ((UnsyncByteArrayOutputStream) this.n).a();
                if (this.f72567a) {
                    ((UnsyncByteArrayOutputStream) this.n).b();
                }
                return a2;
            }
        } catch (UnsupportedEncodingException e2) {
            throw new CanonicalizationException("empty", (Exception) e2);
        } catch (IOException e3) {
            throw new CanonicalizationException("empty", (Exception) e3);
        }
    }

    /* access modifiers changed from: package-private */
    public int a(Node node, int i2) {
        List<NodeFilter> list = this.j;
        if (list != null) {
            for (NodeFilter a2 : list) {
                int a3 = a2.a(node, i2);
                if (a3 != 1) {
                    return a3;
                }
            }
        }
        Set set = this.l;
        return (set == null || set.contains(node)) ? 1 : 0;
    }

    /* access modifiers changed from: package-private */
    public abstract Iterator a(Element element, NameSpaceSymbTable nameSpaceSymbTable);

    public void a(OutputStream outputStream) {
        this.n = outputStream;
    }

    /* access modifiers changed from: package-private */
    public abstract void a(XMLSignatureInput xMLSignatureInput);

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(org.w3c.dom.Node r17, org.apache.xml.security.c14n.implementations.NameSpaceSymbTable r18, org.w3c.dom.Node r19, int r20) {
        /*
            r16 = this;
            r0 = r16
            int r1 = r16.b((org.w3c.dom.Node) r17)
            r2 = -1
            if (r1 != r2) goto L_0x000a
            return
        L_0x000a:
            java.io.OutputStream r1 = r0.n
            org.w3c.dom.Node r2 = r0.m
            boolean r3 = r0.k
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            r6 = r17
            r7 = r20
            r8 = 0
            r9 = 0
        L_0x001b:
            short r10 = r6.getNodeType()
            r11 = 1
            r12 = 62
            switch(r10) {
                case 1: goto L_0x0050;
                case 2: goto L_0x0048;
                case 3: goto L_0x0040;
                case 4: goto L_0x0040;
                case 5: goto L_0x0025;
                case 6: goto L_0x0048;
                case 7: goto L_0x003a;
                case 8: goto L_0x0032;
                case 9: goto L_0x0027;
                case 10: goto L_0x0025;
                case 11: goto L_0x0027;
                case 12: goto L_0x0048;
                default: goto L_0x0025;
            }
        L_0x0025:
            goto L_0x00a7
        L_0x0027:
            r18.a()
            org.w3c.dom.Node r6 = r6.getFirstChild()
            r13 = r18
            goto L_0x00aa
        L_0x0032:
            if (r3 == 0) goto L_0x00a7
            org.w3c.dom.Comment r6 = (org.w3c.dom.Comment) r6
            a((org.w3c.dom.Comment) r6, (java.io.OutputStream) r1, (int) r7)
            goto L_0x0025
        L_0x003a:
            org.w3c.dom.ProcessingInstruction r6 = (org.w3c.dom.ProcessingInstruction) r6
            a((org.w3c.dom.ProcessingInstruction) r6, (java.io.OutputStream) r1, (int) r7)
            goto L_0x0025
        L_0x0040:
            java.lang.String r6 = r6.getNodeValue()
            a((java.lang.String) r6, (java.io.OutputStream) r1)
            goto L_0x0025
        L_0x0048:
            org.apache.xml.security.c14n.CanonicalizationException r1 = new org.apache.xml.security.c14n.CanonicalizationException
            java.lang.String r2 = "empty"
            r1.<init>(r2)
            throw r1
        L_0x0050:
            r7 = 0
            if (r6 == r2) goto L_0x00a7
            r9 = r6
            org.w3c.dom.Element r9 = (org.w3c.dom.Element) r9
            r18.a()
            r10 = 60
            r1.write(r10)
            java.lang.String r10 = r9.getTagName()
            org.apache.xml.security.c14n.implementations.UtfHelpper.a(r10, r1, r4)
            r13 = r18
            java.util.Iterator r14 = r0.a((org.w3c.dom.Element) r9, (org.apache.xml.security.c14n.implementations.NameSpaceSymbTable) r13)
            if (r14 == 0) goto L_0x0085
        L_0x006d:
            boolean r15 = r14.hasNext()
            if (r15 == 0) goto L_0x0085
            java.lang.Object r15 = r14.next()
            org.w3c.dom.Attr r15 = (org.w3c.dom.Attr) r15
            java.lang.String r5 = r15.getNodeName()
            java.lang.String r15 = r15.getNodeValue()
            a((java.lang.String) r5, (java.lang.String) r15, (java.io.OutputStream) r1, (java.util.Map) r4)
            goto L_0x006d
        L_0x0085:
            r1.write(r12)
            org.w3c.dom.Node r5 = r6.getFirstChild()
            if (r5 != 0) goto L_0x00a4
            byte[] r9 = t
            r1.write(r9)
            org.apache.xml.security.c14n.implementations.UtfHelpper.a((java.lang.String) r10, (java.io.OutputStream) r1)
            r1.write(r12)
            r18.b()
            if (r8 == 0) goto L_0x00a2
            org.w3c.dom.Node r5 = r6.getNextSibling()
        L_0x00a2:
            r6 = r5
            goto L_0x00aa
        L_0x00a4:
            r6 = r5
            r8 = r9
            goto L_0x00aa
        L_0x00a7:
            r13 = r18
            r6 = r9
        L_0x00aa:
            if (r6 != 0) goto L_0x00db
            if (r8 == 0) goto L_0x00db
            byte[] r5 = t
            r1.write(r5)
            r5 = r8
            org.w3c.dom.Element r5 = (org.w3c.dom.Element) r5
            java.lang.String r5 = r5.getTagName()
            org.apache.xml.security.c14n.implementations.UtfHelpper.a(r5, r1, r4)
            r1.write(r12)
            r18.b()
            r5 = r19
            if (r8 != r5) goto L_0x00c8
            return
        L_0x00c8:
            org.w3c.dom.Node r6 = r8.getNextSibling()
            org.w3c.dom.Node r8 = r8.getParentNode()
            if (r8 == 0) goto L_0x00d8
            short r9 = r8.getNodeType()
            if (r11 == r9) goto L_0x00aa
        L_0x00d8:
            r7 = 1
            r8 = 0
            goto L_0x00aa
        L_0x00db:
            r5 = r19
            if (r6 != 0) goto L_0x00e0
            return
        L_0x00e0:
            org.w3c.dom.Node r9 = r6.getNextSibling()
            goto L_0x001b
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xml.security.c14n.implementations.CanonicalizerBase.a(org.w3c.dom.Node, org.apache.xml.security.c14n.implementations.NameSpaceSymbTable, org.w3c.dom.Node, int):void");
    }

    public byte[] a(Set set) {
        this.l = set;
        return d(XMLUtils.a(this.l));
    }

    public byte[] a(Node node) {
        return a(node, (Node) null);
    }

    /* access modifiers changed from: package-private */
    public byte[] a(Node node, Node node2) {
        this.m = node2;
        try {
            NameSpaceSymbTable nameSpaceSymbTable = new NameSpaceSymbTable();
            int i2 = -1;
            if (node != null && 1 == node.getNodeType()) {
                d((Element) node, nameSpaceSymbTable);
                i2 = 0;
            }
            a(node, nameSpaceSymbTable, node, i2);
            this.n.close();
            if (this.n instanceof ByteArrayOutputStream) {
                byte[] byteArray = ((ByteArrayOutputStream) this.n).toByteArray();
                if (this.f72567a) {
                    ((ByteArrayOutputStream) this.n).reset();
                }
                return byteArray;
            } else if (!(this.n instanceof UnsyncByteArrayOutputStream)) {
                return null;
            } else {
                byte[] a2 = ((UnsyncByteArrayOutputStream) this.n).a();
                if (this.f72567a) {
                    ((UnsyncByteArrayOutputStream) this.n).b();
                }
                return a2;
            }
        } catch (UnsupportedEncodingException e2) {
            throw new CanonicalizationException("empty", (Exception) e2);
        } catch (IOException e3) {
            throw new CanonicalizationException("empty", (Exception) e3);
        }
    }

    /* access modifiers changed from: package-private */
    public int b(Node node) {
        List<NodeFilter> list = this.j;
        if (list != null) {
            for (NodeFilter a2 : list) {
                int a3 = a2.a(node);
                if (a3 != 1) {
                    return a3;
                }
            }
        }
        Set set = this.l;
        return (set == null || set.contains(node)) ? 1 : 0;
    }

    /* access modifiers changed from: package-private */
    public abstract Iterator b(Element element, NameSpaceSymbTable nameSpaceSymbTable);

    /* access modifiers changed from: package-private */
    public final void b(Node node, Node node2) {
        String str;
        int i2 = -1;
        if (b(node) != -1) {
            NameSpaceSymbTable nameSpaceSymbTable = new NameSpaceSymbTable();
            if (node != null && 1 == node.getNodeType()) {
                d((Element) node, nameSpaceSymbTable);
            }
            OutputStream outputStream = this.n;
            HashMap hashMap = new HashMap();
            Node node3 = node;
            Element element = null;
            Node node4 = null;
            int i3 = -1;
            while (true) {
                switch (node3.getNodeType()) {
                    case 1:
                        Element element2 = (Element) node3;
                        int a2 = a(node3, nameSpaceSymbTable.f());
                        if (a2 == i2) {
                            node3 = node3.getNextSibling();
                        } else {
                            boolean z = a2 == 1;
                            if (z) {
                                nameSpaceSymbTable.a();
                                outputStream.write(60);
                                str = element2.getTagName();
                                UtfHelpper.a(str, outputStream, hashMap);
                            } else {
                                nameSpaceSymbTable.c();
                                str = null;
                            }
                            Iterator b2 = b(element2, nameSpaceSymbTable);
                            if (b2 != null) {
                                while (b2.hasNext()) {
                                    Attr attr = (Attr) b2.next();
                                    a(attr.getNodeName(), attr.getNodeValue(), outputStream, (Map) hashMap);
                                }
                            }
                            if (z) {
                                outputStream.write(62);
                            }
                            Node firstChild = node3.getFirstChild();
                            if (firstChild == null) {
                                if (z) {
                                    outputStream.write(t);
                                    UtfHelpper.a(str, outputStream, hashMap);
                                    outputStream.write(62);
                                    nameSpaceSymbTable.b();
                                } else {
                                    nameSpaceSymbTable.d();
                                }
                                if (element != null) {
                                    firstChild = node3.getNextSibling();
                                }
                                node3 = firstChild;
                            } else {
                                node3 = firstChild;
                                element = element2;
                            }
                        }
                        i3 = 0;
                        break;
                    case 2:
                    case 6:
                    case 12:
                        throw new CanonicalizationException("empty");
                    case 3:
                    case 4:
                        if (c(node3)) {
                            a(node3.getNodeValue(), outputStream);
                            while (true) {
                                node3 = node3.getNextSibling();
                                if (node3 != null && (node3.getNodeType() == 3 || node3.getNodeType() == 4)) {
                                    a(node3.getNodeValue(), outputStream);
                                    node4 = node3.getNextSibling();
                                }
                            }
                        }
                        break;
                    case 7:
                        if (c(node3)) {
                            a((ProcessingInstruction) node3, outputStream, i3);
                            break;
                        }
                        break;
                    case 8:
                        if (this.k && a(node3, nameSpaceSymbTable.f()) == 1) {
                            a((Comment) node3, outputStream, i3);
                            break;
                        }
                    case 9:
                    case 11:
                        nameSpaceSymbTable.a();
                        node3 = node3.getFirstChild();
                        break;
                }
                node3 = node4;
                while (node3 == null && element != null) {
                    if (c(element)) {
                        outputStream.write(t);
                        UtfHelpper.a(element.getTagName(), outputStream, hashMap);
                        outputStream.write(62);
                        nameSpaceSymbTable.b();
                    } else {
                        nameSpaceSymbTable.d();
                    }
                    if (element != node2) {
                        node3 = element.getNextSibling();
                        element = element.getParentNode();
                        if (element == null || 1 != element.getNodeType()) {
                            element = null;
                            i3 = 1;
                        }
                    } else {
                        return;
                    }
                }
                Node node5 = node2;
                if (node3 != null) {
                    node4 = node3.getNextSibling();
                    i2 = -1;
                } else {
                    return;
                }
            }
        }
    }

    public byte[] b(XMLSignatureInput xMLSignatureInput) {
        try {
            if (xMLSignatureInput.n()) {
                this.k = false;
            }
            if (xMLSignatureInput.h()) {
                return a(xMLSignatureInput.e());
            }
            if (xMLSignatureInput.g()) {
                return a(xMLSignatureInput.m(), xMLSignatureInput.l());
            }
            if (!xMLSignatureInput.f()) {
                return null;
            }
            this.j = xMLSignatureInput.p();
            a(xMLSignatureInput);
            return xMLSignatureInput.m() != null ? d(xMLSignatureInput.m()) : a(xMLSignatureInput.b());
        } catch (CanonicalizationException e2) {
            throw new CanonicalizationException("empty", (Exception) e2);
        } catch (ParserConfigurationException e3) {
            throw new CanonicalizationException("empty", (Exception) e3);
        } catch (IOException e4) {
            throw new CanonicalizationException("empty", (Exception) e4);
        } catch (SAXException e5) {
            throw new CanonicalizationException("empty", (Exception) e5);
        }
    }

    /* access modifiers changed from: package-private */
    public void c(Element element, NameSpaceSymbTable nameSpaceSymbTable) {
        if (element.hasAttributes()) {
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
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean c(Node node) {
        List<NodeFilter> list = this.j;
        if (list != null) {
            for (NodeFilter a2 : list) {
                if (a2.a(node) != 1) {
                    return false;
                }
            }
        }
        Set set = this.l;
        return set == null || set.contains(node);
    }

    /* access modifiers changed from: package-private */
    public final void d(Element element, NameSpaceSymbTable nameSpaceSymbTable) {
        ArrayList arrayList = new ArrayList(10);
        Node parentNode = element.getParentNode();
        if (parentNode != null && 1 == parentNode.getNodeType()) {
            do {
                Element element2 = (Element) parentNode;
                if (element2 == null) {
                    break;
                }
                arrayList.add(element2);
                parentNode = element2.getParentNode();
                if (parentNode == null) {
                    break;
                }
            } while (1 != parentNode.getNodeType());
            ListIterator listIterator = arrayList.listIterator(arrayList.size());
            while (listIterator.hasPrevious()) {
                c((Element) listIterator.previous(), nameSpaceSymbTable);
            }
            Attr b2 = nameSpaceSymbTable.b("xmlns");
            if (b2 != null && "".equals(b2.getValue())) {
                nameSpaceSymbTable.b("xmlns", "", f72599i);
            }
        }
    }
}
