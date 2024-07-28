package org.apache.xml.security.utils;

import javax.xml.transform.ErrorListener;
import javax.xml.transform.SourceLocator;
import javax.xml.transform.TransformerException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.dtm.DTMManager;
import org.apache.xml.security.transforms.implementations.FuncHereContext;
import org.apache.xml.utils.PrefixResolver;
import org.apache.xml.utils.PrefixResolverDefault;
import org.apache.xpath.CachedXPathAPI;
import org.apache.xpath.XPath;
import org.apache.xpath.XPathContext;
import org.apache.xpath.compiler.FunctionTable;
import org.apache.xpath.objects.XObject;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;

public class CachedXPathFuncHereAPI {

    /* renamed from: a  reason: collision with root package name */
    static Log f72749a;

    /* renamed from: g  reason: collision with root package name */
    static FunctionTable f72750g = null;

    /* renamed from: h  reason: collision with root package name */
    static Class f72751h;

    /* renamed from: i  reason: collision with root package name */
    static Class f72752i;
    static Class j;
    static Class k;
    static Class l;
    static Class m;
    static Class n;
    static Class o;
    static Class p;
    static Class q;

    /* renamed from: b  reason: collision with root package name */
    FuncHereContext f72753b = null;

    /* renamed from: c  reason: collision with root package name */
    DTMManager f72754c = null;

    /* renamed from: d  reason: collision with root package name */
    XPathContext f72755d = null;

    /* renamed from: e  reason: collision with root package name */
    String f72756e = null;

    /* renamed from: f  reason: collision with root package name */
    XPath f72757f = null;

    static {
        Class cls = f72751h;
        if (cls == null) {
            cls = a("org.apache.xml.security.utils.CachedXPathFuncHereAPI");
            f72751h = cls;
        }
        f72749a = LogFactory.getLog(cls.getName());
        a();
    }

    private CachedXPathFuncHereAPI() {
    }

    public CachedXPathFuncHereAPI(CachedXPathAPI cachedXPathAPI) {
        this.f72754c = cachedXPathAPI.getXPathContext().getDTMManager();
        this.f72755d = cachedXPathAPI.getXPathContext();
    }

    static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    public static String a(Node node) {
        if (node.getNodeType() == 3) {
            StringBuffer stringBuffer = new StringBuffer();
            for (Node firstChild = node.getParentNode().getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
                if (firstChild.getNodeType() == 3) {
                    stringBuffer.append(((Text) firstChild).getData());
                }
            }
            return stringBuffer.toString();
        } else if (node.getNodeType() == 2) {
            return ((Attr) node).getNodeValue();
        } else {
            if (node.getNodeType() == 7) {
                return ((ProcessingInstruction) node).getNodeValue();
            }
            return null;
        }
    }

    private XPath a(String str, PrefixResolver prefixResolver) {
        XPath xPath;
        Class cls;
        Class[] clsArr = new Class[6];
        Class cls2 = f72752i;
        if (cls2 == null) {
            cls2 = a("java.lang.String");
            f72752i = cls2;
        }
        clsArr[0] = cls2;
        Class cls3 = j;
        if (cls3 == null) {
            cls3 = a("javax.xml.transform.SourceLocator");
            j = cls3;
        }
        clsArr[1] = cls3;
        Class cls4 = k;
        if (cls4 == null) {
            cls4 = a("org.apache.xml.utils.PrefixResolver");
            k = cls4;
        }
        clsArr[2] = cls4;
        clsArr[3] = Integer.TYPE;
        Class cls5 = l;
        if (cls5 == null) {
            cls5 = a("javax.xml.transform.ErrorListener");
            l = cls5;
        }
        clsArr[4] = cls5;
        Class cls6 = m;
        if (cls6 == null) {
            cls6 = a("org.apache.xpath.compiler.FunctionTable");
            m = cls6;
        }
        clsArr[5] = cls6;
        Object[] objArr = {str, null, prefixResolver, 0, null, f72750g};
        try {
            if (n == null) {
                cls = a("org.apache.xpath.XPath");
                n = cls;
            } else {
                cls = n;
            }
            xPath = (XPath) cls.getConstructor(clsArr).newInstance(objArr);
        } catch (Throwable unused) {
            xPath = null;
        }
        return xPath == null ? new XPath(str, (SourceLocator) null, prefixResolver, 0, (ErrorListener) null) : xPath;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x006b A[SYNTHETIC, Splitter:B:23:0x006b] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a() {
        /*
            java.lang.String r0 = "here"
            java.lang.String r1 = "installFunction"
            java.lang.String r2 = "org.apache.xpath.compiler.FunctionTable"
            java.lang.String r3 = "java.lang.String"
            java.lang.String r4 = "Error installing function using the static installFunction method"
            org.apache.commons.logging.Log r5 = f72749a
            java.lang.String r6 = "Registering Here function"
            r5.info(r6)
            r5 = 2
            r6 = 0
            r7 = 1
            java.lang.Class[] r8 = new java.lang.Class[r5]     // Catch:{ all -> 0x0060 }
            java.lang.Class r9 = f72752i     // Catch:{ all -> 0x0060 }
            if (r9 != 0) goto L_0x0021
            java.lang.Class r9 = a((java.lang.String) r3)     // Catch:{ all -> 0x0060 }
            f72752i = r9     // Catch:{ all -> 0x0060 }
            goto L_0x0023
        L_0x0021:
            java.lang.Class r9 = f72752i     // Catch:{ all -> 0x0060 }
        L_0x0023:
            r8[r6] = r9     // Catch:{ all -> 0x0060 }
            java.lang.Class r9 = o     // Catch:{ all -> 0x0060 }
            if (r9 != 0) goto L_0x0032
            java.lang.String r9 = "org.apache.xpath.Expression"
            java.lang.Class r9 = a((java.lang.String) r9)     // Catch:{ all -> 0x0060 }
            o = r9     // Catch:{ all -> 0x0060 }
            goto L_0x0034
        L_0x0032:
            java.lang.Class r9 = o     // Catch:{ all -> 0x0060 }
        L_0x0034:
            r8[r7] = r9     // Catch:{ all -> 0x0060 }
            java.lang.Class r9 = m     // Catch:{ all -> 0x0060 }
            if (r9 != 0) goto L_0x0041
            java.lang.Class r9 = a((java.lang.String) r2)     // Catch:{ all -> 0x0060 }
            m = r9     // Catch:{ all -> 0x0060 }
            goto L_0x0043
        L_0x0041:
            java.lang.Class r9 = m     // Catch:{ all -> 0x0060 }
        L_0x0043:
            java.lang.reflect.Method r8 = r9.getMethod(r1, r8)     // Catch:{ all -> 0x0060 }
            int r9 = r8.getModifiers()     // Catch:{ all -> 0x0060 }
            r9 = r9 & 8
            if (r9 == 0) goto L_0x0066
            java.lang.Object[] r9 = new java.lang.Object[r5]     // Catch:{ all -> 0x0060 }
            r9[r6] = r0     // Catch:{ all -> 0x0060 }
            org.apache.xml.security.transforms.implementations.FuncHere r10 = new org.apache.xml.security.transforms.implementations.FuncHere     // Catch:{ all -> 0x0060 }
            r10.<init>()     // Catch:{ all -> 0x0060 }
            r9[r7] = r10     // Catch:{ all -> 0x0060 }
            r10 = 0
            r8.invoke(r10, r9)     // Catch:{ all -> 0x0060 }
            r8 = 1
            goto L_0x0067
        L_0x0060:
            r8 = move-exception
            org.apache.commons.logging.Log r9 = f72749a
            r9.debug(r4, r8)
        L_0x0066:
            r8 = 0
        L_0x0067:
            java.lang.String r9 = "org.apache.xml.security.transforms.implementations.FuncHere"
            if (r8 != 0) goto L_0x00c4
            org.apache.xpath.compiler.FunctionTable r10 = new org.apache.xpath.compiler.FunctionTable     // Catch:{ all -> 0x00be }
            r10.<init>()     // Catch:{ all -> 0x00be }
            f72750g = r10     // Catch:{ all -> 0x00be }
            java.lang.Class[] r10 = new java.lang.Class[r5]     // Catch:{ all -> 0x00be }
            java.lang.Class r11 = f72752i     // Catch:{ all -> 0x00be }
            if (r11 != 0) goto L_0x007f
            java.lang.Class r3 = a((java.lang.String) r3)     // Catch:{ all -> 0x00be }
            f72752i = r3     // Catch:{ all -> 0x00be }
            goto L_0x0081
        L_0x007f:
            java.lang.Class r3 = f72752i     // Catch:{ all -> 0x00be }
        L_0x0081:
            r10[r6] = r3     // Catch:{ all -> 0x00be }
            java.lang.Class r3 = p     // Catch:{ all -> 0x00be }
            if (r3 != 0) goto L_0x0090
            java.lang.String r3 = "java.lang.Class"
            java.lang.Class r3 = a((java.lang.String) r3)     // Catch:{ all -> 0x00be }
            p = r3     // Catch:{ all -> 0x00be }
            goto L_0x0092
        L_0x0090:
            java.lang.Class r3 = p     // Catch:{ all -> 0x00be }
        L_0x0092:
            r10[r7] = r3     // Catch:{ all -> 0x00be }
            java.lang.Class r3 = m     // Catch:{ all -> 0x00be }
            if (r3 != 0) goto L_0x009f
            java.lang.Class r2 = a((java.lang.String) r2)     // Catch:{ all -> 0x00be }
            m = r2     // Catch:{ all -> 0x00be }
            goto L_0x00a1
        L_0x009f:
            java.lang.Class r2 = m     // Catch:{ all -> 0x00be }
        L_0x00a1:
            java.lang.reflect.Method r1 = r2.getMethod(r1, r10)     // Catch:{ all -> 0x00be }
            java.lang.Object[] r2 = new java.lang.Object[r5]     // Catch:{ all -> 0x00be }
            r2[r6] = r0     // Catch:{ all -> 0x00be }
            java.lang.Class r0 = q     // Catch:{ all -> 0x00be }
            if (r0 != 0) goto L_0x00b4
            java.lang.Class r0 = a((java.lang.String) r9)     // Catch:{ all -> 0x00be }
            q = r0     // Catch:{ all -> 0x00be }
            goto L_0x00b6
        L_0x00b4:
            java.lang.Class r0 = q     // Catch:{ all -> 0x00be }
        L_0x00b6:
            r2[r7] = r0     // Catch:{ all -> 0x00be }
            org.apache.xpath.compiler.FunctionTable r0 = f72750g     // Catch:{ all -> 0x00be }
            r1.invoke(r0, r2)     // Catch:{ all -> 0x00be }
            goto L_0x00c5
        L_0x00be:
            r0 = move-exception
            org.apache.commons.logging.Log r1 = f72749a
            r1.debug(r4, r0)
        L_0x00c4:
            r7 = r8
        L_0x00c5:
            org.apache.commons.logging.Log r0 = f72749a
            boolean r0 = r0.isDebugEnabled()
            if (r0 == 0) goto L_0x0116
            java.lang.String r0 = " for XPath function 'here()' function in internal table"
            org.apache.commons.logging.Log r1 = f72749a
            java.lang.StringBuffer r2 = new java.lang.StringBuffer
            if (r7 == 0) goto L_0x00f6
            java.lang.String r3 = "Registered class "
            r2.<init>(r3)
            java.lang.Class r3 = q
            if (r3 != 0) goto L_0x00e4
            java.lang.Class r3 = a((java.lang.String) r9)
            q = r3
        L_0x00e4:
            java.lang.String r3 = r3.getName()
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.debug(r0)
            return
        L_0x00f6:
            java.lang.String r3 = "Unable to register class "
            r2.<init>(r3)
            java.lang.Class r3 = q
            if (r3 != 0) goto L_0x0105
            java.lang.Class r3 = a((java.lang.String) r9)
            q = r3
        L_0x0105:
            java.lang.String r3 = r3.getName()
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.debug(r0)
        L_0x0116:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xml.security.utils.CachedXPathFuncHereAPI.a():void");
    }

    public XObject a(Node node, Node node2, String str, PrefixResolver prefixResolver) {
        if (str != this.f72756e) {
            if (str.indexOf("here()") > 0) {
                this.f72755d.reset();
                this.f72754c = this.f72755d.getDTMManager();
            }
            try {
                this.f72757f = a(str, prefixResolver);
                this.f72756e = str;
            } catch (TransformerException e2) {
                Throwable cause = e2.getCause();
                if (!(cause instanceof ClassNotFoundException) || cause.getMessage().indexOf("FuncHere") <= 0) {
                    throw e2;
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(I18n.a("endorsed.jdk1.4.0"));
                stringBuffer.append(e2);
                throw new RuntimeException(stringBuffer.toString());
            }
        }
        if (this.f72753b == null) {
            this.f72753b = new FuncHereContext(node2, this.f72754c);
        }
        return this.f72757f.execute(this.f72753b, this.f72753b.getDTMHandleFromNode(node), prefixResolver);
    }

    public NodeList a(Node node, Node node2, String str, Node node3) {
        return b(node, node2, str, node3).nodelist();
    }

    public XObject b(Node node, Node node2, String str, Node node3) {
        if (this.f72753b == null) {
            this.f72753b = new FuncHereContext(node2, this.f72754c);
        }
        if (node3.getNodeType() == 9) {
            node3 = ((Document) node3).getDocumentElement();
        }
        PrefixResolverDefault prefixResolverDefault = new PrefixResolverDefault(node3);
        if (str != this.f72756e) {
            if (str.indexOf("here()") > 0) {
                this.f72755d.reset();
                this.f72754c = this.f72755d.getDTMManager();
            }
            this.f72757f = a(str, prefixResolverDefault);
            this.f72756e = str;
        }
        return this.f72757f.execute(this.f72753b, this.f72753b.getDTMHandleFromNode(node), prefixResolverDefault);
    }
}
