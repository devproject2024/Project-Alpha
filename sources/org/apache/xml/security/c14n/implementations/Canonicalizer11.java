package org.apache.xml.security.c14n.implementations;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.c14n.CanonicalizationException;
import org.apache.xml.security.c14n.helper.C14nHelper;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public abstract class Canonicalizer11 extends CanonicalizerBase {

    /* renamed from: d  reason: collision with root package name */
    static Log f72568d;

    /* renamed from: f  reason: collision with root package name */
    static Class f72569f;

    /* renamed from: b  reason: collision with root package name */
    boolean f72570b = true;

    /* renamed from: c  reason: collision with root package name */
    final SortedSet f72571c = new TreeSet(f72597g);

    /* renamed from: e  reason: collision with root package name */
    XmlAttrStack f72572e = new XmlAttrStack();

    class XmlAttrStack {

        /* renamed from: a  reason: collision with root package name */
        int f72573a = 0;

        /* renamed from: b  reason: collision with root package name */
        int f72574b = 0;

        /* renamed from: c  reason: collision with root package name */
        XmlsStackElement f72575c;

        /* renamed from: d  reason: collision with root package name */
        List f72576d = new ArrayList();

        class XmlsStackElement {

            /* renamed from: a  reason: collision with root package name */
            int f72577a;

            /* renamed from: b  reason: collision with root package name */
            boolean f72578b = false;

            /* renamed from: c  reason: collision with root package name */
            List f72579c = new ArrayList();

            XmlsStackElement() {
            }
        }

        XmlAttrStack() {
        }

        /* access modifiers changed from: package-private */
        public void a(int i2) {
            this.f72573a = i2;
            if (this.f72573a != -1) {
                this.f72575c = null;
                while (this.f72574b >= this.f72573a) {
                    List list = this.f72576d;
                    list.remove(list.size() - 1);
                    if (this.f72576d.size() == 0) {
                        this.f72574b = 0;
                        return;
                    } else {
                        List list2 = this.f72576d;
                        this.f72574b = ((XmlsStackElement) list2.get(list2.size() - 1)).f72577a;
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: org.w3c.dom.Attr} */
        /* access modifiers changed from: package-private */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x003e  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x004a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(java.util.Collection r12) {
            /*
                r11 = this;
                org.apache.xml.security.c14n.implementations.Canonicalizer11$XmlAttrStack$XmlsStackElement r0 = r11.f72575c
                if (r0 != 0) goto L_0x0018
                org.apache.xml.security.c14n.implementations.Canonicalizer11$XmlAttrStack$XmlsStackElement r0 = new org.apache.xml.security.c14n.implementations.Canonicalizer11$XmlAttrStack$XmlsStackElement
                r0.<init>()
                r11.f72575c = r0
                org.apache.xml.security.c14n.implementations.Canonicalizer11$XmlAttrStack$XmlsStackElement r0 = r11.f72575c
                int r1 = r11.f72573a
                r0.f72577a = r1
                r11.f72574b = r1
                java.util.List r1 = r11.f72576d
                r1.add(r0)
            L_0x0018:
                java.util.List r0 = r11.f72576d
                int r0 = r0.size()
                int r0 = r0 + -2
                r1 = -1
                r2 = 0
                r3 = 1
                if (r0 != r1) goto L_0x0027
            L_0x0025:
                r1 = 1
                goto L_0x003c
            L_0x0027:
                java.util.List r1 = r11.f72576d
                java.lang.Object r1 = r1.get(r0)
                org.apache.xml.security.c14n.implementations.Canonicalizer11$XmlAttrStack$XmlsStackElement r1 = (org.apache.xml.security.c14n.implementations.Canonicalizer11.XmlAttrStack.XmlsStackElement) r1
                boolean r4 = r1.f72578b
                if (r4 == 0) goto L_0x003b
                int r1 = r1.f72577a
                int r1 = r1 + r3
                int r4 = r11.f72573a
                if (r1 != r4) goto L_0x003b
                goto L_0x0025
            L_0x003b:
                r1 = 0
            L_0x003c:
                if (r1 == 0) goto L_0x004a
                org.apache.xml.security.c14n.implementations.Canonicalizer11$XmlAttrStack$XmlsStackElement r0 = r11.f72575c
                java.util.List r0 = r0.f72579c
                r12.addAll(r0)
                org.apache.xml.security.c14n.implementations.Canonicalizer11$XmlAttrStack$XmlsStackElement r12 = r11.f72575c
                r12.f72578b = r3
                return
            L_0x004a:
                java.util.HashMap r1 = new java.util.HashMap
                r1.<init>()
                java.util.ArrayList r4 = new java.util.ArrayList
                r4.<init>()
                r5 = 1
            L_0x0055:
                java.lang.String r6 = "base"
                if (r0 < 0) goto L_0x00a1
                java.util.List r7 = r11.f72576d
                java.lang.Object r7 = r7.get(r0)
                org.apache.xml.security.c14n.implementations.Canonicalizer11$XmlAttrStack$XmlsStackElement r7 = (org.apache.xml.security.c14n.implementations.Canonicalizer11.XmlAttrStack.XmlsStackElement) r7
                boolean r8 = r7.f72578b
                if (r8 == 0) goto L_0x0066
                r5 = 0
            L_0x0066:
                java.util.List r8 = r7.f72579c
                java.util.Iterator r8 = r8.iterator()
            L_0x006c:
                boolean r9 = r8.hasNext()
                if (r9 == 0) goto L_0x009e
                if (r5 == 0) goto L_0x009e
                java.lang.Object r9 = r8.next()
                org.w3c.dom.Attr r9 = (org.w3c.dom.Attr) r9
                java.lang.String r10 = r9.getLocalName()
                boolean r10 = r10.equals(r6)
                if (r10 == 0) goto L_0x008c
                boolean r10 = r7.f72578b
                if (r10 != 0) goto L_0x006c
                r4.add(r9)
                goto L_0x006c
            L_0x008c:
                java.lang.String r10 = r9.getName()
                boolean r10 = r1.containsKey(r10)
                if (r10 != 0) goto L_0x006c
                java.lang.String r10 = r9.getName()
                r1.put(r10, r9)
                goto L_0x006c
            L_0x009e:
                int r0 = r0 + -1
                goto L_0x0055
            L_0x00a1:
                boolean r0 = r4.isEmpty()
                if (r0 != 0) goto L_0x0101
                org.apache.xml.security.c14n.implementations.Canonicalizer11$XmlAttrStack$XmlsStackElement r0 = r11.f72575c
                java.util.List r0 = r0.f72579c
                java.util.Iterator r0 = r0.iterator()
            L_0x00af:
                boolean r2 = r0.hasNext()
                r5 = 0
                if (r2 == 0) goto L_0x00cc
                java.lang.Object r2 = r0.next()
                r5 = r2
                org.w3c.dom.Attr r5 = (org.w3c.dom.Attr) r5
                java.lang.String r2 = r5.getLocalName()
                boolean r2 = r2.equals(r6)
                if (r2 == 0) goto L_0x00af
                java.lang.String r0 = r5.getValue()
                goto L_0x00cd
            L_0x00cc:
                r0 = r5
            L_0x00cd:
                java.util.Iterator r2 = r4.iterator()
            L_0x00d1:
                boolean r4 = r2.hasNext()
                if (r4 == 0) goto L_0x00f3
                java.lang.Object r4 = r2.next()
                org.w3c.dom.Attr r4 = (org.w3c.dom.Attr) r4
                if (r0 != 0) goto L_0x00e5
                java.lang.String r0 = r4.getValue()
                r5 = r4
                goto L_0x00d1
            L_0x00e5:
                java.lang.String r4 = r4.getValue()     // Catch:{ URISyntaxException -> 0x00ee }
                java.lang.String r0 = org.apache.xml.security.c14n.implementations.Canonicalizer11.a((java.lang.String) r4, (java.lang.String) r0)     // Catch:{ URISyntaxException -> 0x00ee }
                goto L_0x00d1
            L_0x00ee:
                r4 = move-exception
                r4.printStackTrace()
                goto L_0x00d1
            L_0x00f3:
                if (r0 == 0) goto L_0x0101
                int r2 = r0.length()
                if (r2 == 0) goto L_0x0101
                r5.setValue(r0)
                r12.add(r5)
            L_0x0101:
                org.apache.xml.security.c14n.implementations.Canonicalizer11$XmlAttrStack$XmlsStackElement r0 = r11.f72575c
                r0.f72578b = r3
                java.util.Collection r0 = r1.values()
                r12.addAll(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.xml.security.c14n.implementations.Canonicalizer11.XmlAttrStack.a(java.util.Collection):void");
        }

        /* access modifiers changed from: package-private */
        public void a(Attr attr) {
            if (this.f72575c == null) {
                this.f72575c = new XmlsStackElement();
                XmlsStackElement xmlsStackElement = this.f72575c;
                xmlsStackElement.f72577a = this.f72573a;
                this.f72576d.add(xmlsStackElement);
                this.f72574b = this.f72573a;
            }
            this.f72575c.f72579c.add(attr);
        }
    }

    static {
        Class cls = f72569f;
        if (cls == null) {
            cls = a("org.apache.xml.security.c14n.implementations.Canonicalizer11");
            f72569f = cls;
        }
        f72568d = LogFactory.getLog(cls.getName());
    }

    public Canonicalizer11(boolean z) {
        super(z);
    }

    static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    static String a(String str, String str2) {
        return b(str, str2);
    }

    private static void a(String str, String str2, String str3) {
        if (f72568d.isDebugEnabled()) {
            Log log = f72568d;
            StringBuffer stringBuffer = new StringBuffer(" ");
            stringBuffer.append(str);
            stringBuffer.append(":   ");
            stringBuffer.append(str2);
            log.debug(stringBuffer.toString());
            if (str2.length() == 0) {
                f72568d.debug("\t\t\t\t".concat(String.valueOf(str3)));
            } else {
                f72568d.debug("\t\t\t".concat(String.valueOf(str3)));
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d8, code lost:
        if (r13.charAt(0) == '/') goto L_0x00da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00da, code lost:
        r13 = r13.substring(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0128, code lost:
        if (r13.charAt(0) == '/') goto L_0x00da;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String b(java.lang.String r13) {
        /*
            org.apache.commons.logging.Log r0 = f72568d
            java.lang.String r1 = "STEP   OUTPUT BUFFER\t\tINPUT BUFFER"
            r0.debug(r1)
        L_0x0007:
            java.lang.String r0 = "//"
            int r1 = r13.indexOf(r0)
            java.lang.String r2 = "/"
            if (r1 < 0) goto L_0x0016
            java.lang.String r13 = r13.replaceAll(r0, r2)
            goto L_0x0007
        L_0x0016:
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            r1 = 0
            char r3 = r13.charAt(r1)
            r4 = 1
            r5 = 47
            if (r3 != r5) goto L_0x002c
            r0.append(r2)
            java.lang.String r13 = r13.substring(r4)
        L_0x002c:
            java.lang.String r3 = r0.toString()
            java.lang.String r6 = "1 "
            a(r6, r3, r13)
            java.lang.String r3 = ""
        L_0x0037:
            int r6 = r13.length()
            java.lang.String r7 = ".."
            if (r6 == 0) goto L_0x0183
            java.lang.String r6 = "./"
            boolean r6 = r13.startsWith(r6)
            java.lang.String r8 = "2A"
            r9 = 2
            if (r6 == 0) goto L_0x0056
            java.lang.String r13 = r13.substring(r9)
        L_0x004e:
            java.lang.String r6 = r0.toString()
            a(r8, r6, r13)
            goto L_0x0037
        L_0x0056:
            java.lang.String r6 = "../"
            boolean r10 = r13.startsWith(r6)
            r11 = 3
            if (r10 == 0) goto L_0x0071
            java.lang.String r13 = r13.substring(r11)
            java.lang.String r7 = r0.toString()
            boolean r7 = r7.equals(r2)
            if (r7 != 0) goto L_0x004e
            r0.append(r6)
            goto L_0x004e
        L_0x0071:
            java.lang.String r8 = "/./"
            boolean r8 = r13.startsWith(r8)
            java.lang.String r10 = "2B"
            if (r8 == 0) goto L_0x0087
            java.lang.String r13 = r13.substring(r9)
        L_0x007f:
            java.lang.String r6 = r0.toString()
            a(r10, r6, r13)
            goto L_0x0037
        L_0x0087:
            java.lang.String r8 = "/."
            boolean r9 = r13.equals(r8)
            if (r9 == 0) goto L_0x0094
            java.lang.String r13 = r13.replaceFirst(r8, r2)
            goto L_0x007f
        L_0x0094:
            java.lang.String r8 = "/../"
            boolean r8 = r13.startsWith(r8)
            r9 = -1
            java.lang.String r10 = "/.."
            if (r8 == 0) goto L_0x00f2
            java.lang.String r13 = r13.substring(r11)
            int r8 = r0.length()
            if (r8 != 0) goto L_0x00ad
        L_0x00a9:
            r0.append(r2)
            goto L_0x00e7
        L_0x00ad:
            java.lang.String r8 = r0.toString()
            boolean r6 = r8.endsWith(r6)
            if (r6 == 0) goto L_0x00bb
        L_0x00b7:
            r0.append(r7)
            goto L_0x00e7
        L_0x00bb:
            java.lang.String r6 = r0.toString()
            boolean r6 = r6.endsWith(r7)
            if (r6 == 0) goto L_0x00c9
        L_0x00c5:
            r0.append(r10)
            goto L_0x00e7
        L_0x00c9:
            int r6 = r0.lastIndexOf(r2)
            if (r6 != r9) goto L_0x00df
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            char r6 = r13.charAt(r1)
            if (r6 != r5) goto L_0x00e7
        L_0x00da:
            java.lang.String r13 = r13.substring(r4)
            goto L_0x00e7
        L_0x00df:
            int r7 = r0.length()
            java.lang.StringBuffer r0 = r0.delete(r6, r7)
        L_0x00e7:
            java.lang.String r6 = r0.toString()
            java.lang.String r7 = "2C"
            a(r7, r6, r13)
            goto L_0x0037
        L_0x00f2:
            boolean r8 = r13.equals(r10)
            if (r8 == 0) goto L_0x012b
            java.lang.String r13 = r13.replaceFirst(r10, r2)
            int r8 = r0.length()
            if (r8 != 0) goto L_0x0103
            goto L_0x00a9
        L_0x0103:
            java.lang.String r8 = r0.toString()
            boolean r6 = r8.endsWith(r6)
            if (r6 == 0) goto L_0x010e
            goto L_0x00b7
        L_0x010e:
            java.lang.String r6 = r0.toString()
            boolean r6 = r6.endsWith(r7)
            if (r6 == 0) goto L_0x0119
            goto L_0x00c5
        L_0x0119:
            int r6 = r0.lastIndexOf(r2)
            if (r6 != r9) goto L_0x00df
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            char r6 = r13.charAt(r1)
            if (r6 != r5) goto L_0x00e7
            goto L_0x00da
        L_0x012b:
            java.lang.String r6 = "."
            boolean r6 = r13.equals(r6)
            if (r6 == 0) goto L_0x013f
        L_0x0133:
            java.lang.String r13 = r0.toString()
            java.lang.String r6 = "2D"
            a(r6, r13, r3)
            r13 = r3
            goto L_0x0037
        L_0x013f:
            boolean r6 = r13.equals(r7)
            if (r6 == 0) goto L_0x0153
            java.lang.String r13 = r0.toString()
            boolean r13 = r13.equals(r2)
            if (r13 != 0) goto L_0x0133
            r0.append(r7)
            goto L_0x0133
        L_0x0153:
            int r6 = r13.indexOf(r5)
            if (r6 != 0) goto L_0x0161
            int r7 = r13.indexOf(r5, r4)
            r12 = r7
            r7 = r6
            r6 = r12
            goto L_0x0162
        L_0x0161:
            r7 = 0
        L_0x0162:
            if (r6 != r9) goto L_0x016a
            java.lang.String r13 = r13.substring(r7)
            r6 = r3
            goto L_0x0174
        L_0x016a:
            java.lang.String r7 = r13.substring(r7, r6)
            java.lang.String r13 = r13.substring(r6)
            r6 = r13
            r13 = r7
        L_0x0174:
            r0.append(r13)
            java.lang.String r13 = r0.toString()
            java.lang.String r7 = "2E"
            a(r7, r13, r6)
            r13 = r6
            goto L_0x0037
        L_0x0183:
            java.lang.String r1 = r0.toString()
            boolean r1 = r1.endsWith(r7)
            if (r1 == 0) goto L_0x0199
            r0.append(r2)
            java.lang.String r1 = r0.toString()
            java.lang.String r2 = "3 "
            a(r2, r1, r13)
        L_0x0199:
            java.lang.String r13 = r0.toString()
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xml.security.c14n.implementations.Canonicalizer11.b(java.lang.String):java.lang.String");
    }

    private static String b(String str, String str2) {
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        if (str != null) {
            if (str.endsWith("..")) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str);
                stringBuffer.append("/");
                str = stringBuffer.toString();
            }
            URI uri = new URI(str);
            str3 = uri.getScheme();
            str6 = uri.getAuthority();
            str5 = uri.getPath();
            str4 = uri.getQuery();
            uri.getFragment();
        } else {
            str5 = "";
            str3 = null;
            str6 = null;
            str4 = null;
        }
        URI uri2 = new URI(str2);
        String scheme = uri2.getScheme();
        String authority = uri2.getAuthority();
        String path = uri2.getPath();
        String query = uri2.getQuery();
        if (scheme != null && scheme.equals(str3)) {
            scheme = null;
        }
        if (scheme != null) {
            str9 = b(path);
            str7 = scheme;
            str8 = query;
        } else {
            if (authority != null) {
                str5 = b(path);
            } else if (path.length() == 0) {
                authority = str6;
                if (query == null) {
                    query = str4;
                }
            } else {
                if (!path.startsWith("/")) {
                    if (str6 == null || str5.length() != 0) {
                        int lastIndexOf = str5.lastIndexOf(47);
                        if (lastIndexOf != -1) {
                            StringBuffer stringBuffer2 = new StringBuffer();
                            stringBuffer2.append(str5.substring(0, lastIndexOf + 1));
                            stringBuffer2.append(path);
                            path = stringBuffer2.toString();
                        }
                    } else {
                        path = "/".concat(String.valueOf(path));
                    }
                }
                str5 = b(path);
                authority = str6;
            }
            str7 = str3;
            str8 = query;
            str9 = str5;
        }
        return new URI(str7, authority, str9, str8, (String) null).toString();
    }

    /* access modifiers changed from: package-private */
    public Iterator a(Element element, NameSpaceSymbTable nameSpaceSymbTable) {
        Node b2;
        if (!element.hasAttributes() && !this.f72570b) {
            return null;
        }
        SortedSet sortedSet = this.f72571c;
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
        if (this.f72570b) {
            nameSpaceSymbTable.a((Collection) sortedSet);
            this.f72572e.a((Collection) sortedSet);
            this.f72570b = false;
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
        this.f72572e.a(nameSpaceSymbTable.f());
        boolean z = a((Node) element2, nameSpaceSymbTable.f()) == 1;
        if (element.hasAttributes()) {
            namedNodeMap = element.getAttributes();
            i2 = namedNodeMap.getLength();
        } else {
            namedNodeMap = null;
            i2 = 0;
        }
        SortedSet sortedSet = this.f72571c;
        sortedSet.clear();
        for (int i3 = 0; i3 < i2; i3++) {
            Attr attr = (Attr) namedNodeMap.item(i3);
            String namespaceURI = attr.getNamespaceURI();
            if (!"http://www.w3.org/2000/xmlns/".equals(namespaceURI)) {
                if ("http://www.w3.org/XML/1998/namespace".equals(namespaceURI)) {
                    if (!attr.getLocalName().equals("id")) {
                        this.f72572e.a(attr);
                    } else if (!z) {
                    }
                } else if (!z) {
                }
                sortedSet.add(attr);
            } else {
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
            }
        }
        if (z) {
            Attr attributeNodeNS = element2.getAttributeNodeNS("http://www.w3.org/2000/xmlns/", "xmlns");
            Object a2 = attributeNodeNS == null ? nameSpaceSymbTable2.a("xmlns") : !c(attributeNodeNS) ? nameSpaceSymbTable2.b("xmlns", "", f72599i) : null;
            if (a2 != null) {
                sortedSet.add(a2);
            }
            this.f72572e.a((Collection) sortedSet);
            nameSpaceSymbTable2.a((Collection) sortedSet);
        }
        return sortedSet.iterator();
    }

    /* access modifiers changed from: package-private */
    public void c(Element element, NameSpaceSymbTable nameSpaceSymbTable) {
        if (element.hasAttributes()) {
            this.f72572e.a(-1);
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
                } else if (!"http://www.w3.org/XML/1998/namespace".equals(attr.getNamespaceURI())) {
                    this.f72572e.a(attr);
                }
            }
        }
    }
}
