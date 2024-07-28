package org.apache.xml.security.utils;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.HashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.exceptions.XMLSecurityException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

public abstract class ElementProxy {
    static Log j;
    static HashMap n = new HashMap();
    static HashMap o = new HashMap();
    static Class p;
    protected Element k = null;
    protected String l = null;
    protected Document m = null;

    static {
        Class cls = p;
        if (cls == null) {
            cls = c("org.apache.xml.security.utils.ElementProxy");
            p = cls;
        }
        j = LogFactory.getLog(cls.getName());
    }

    public ElementProxy() {
    }

    public ElementProxy(Element element, String str) {
        if (element != null) {
            if (j.isDebugEnabled()) {
                Log log = j;
                StringBuffer stringBuffer = new StringBuffer("setElement(\"");
                stringBuffer.append(element.getTagName());
                stringBuffer.append("\", \"");
                stringBuffer.append(str);
                stringBuffer.append("\")");
                log.debug(stringBuffer.toString());
            }
            this.m = element.getOwnerDocument();
            this.k = element;
            this.l = str;
            m();
            return;
        }
        throw new XMLSecurityException("ElementProxy.nullElement");
    }

    static Class c(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    public static void d(String str, String str2) {
        if (n.containsValue(str2)) {
            Object obj = n.get(str);
            if (!obj.equals(str2)) {
                throw new XMLSecurityException("prefix.AlreadyAssigned", new Object[]{str2, str, obj});
            }
        }
        if ("http://www.w3.org/2000/09/xmldsig#".equals(str)) {
            XMLUtils.f72794a = str2;
        }
        if ("http://www.w3.org/2001/04/xmlenc#".equals(str)) {
            XMLUtils.f72795b = str2;
        }
        n.put(str, str2.intern());
        if (str2.length() == 0) {
            o.put(str, "xmlns");
        } else {
            o.put(str, "xmlns:".concat(String.valueOf(str2)).intern());
        }
    }

    public String b(String str, String str2) {
        return ((Text) XMLUtils.a(this.k.getFirstChild(), str2, str, 0).getFirstChild()).getData();
    }

    public int c(String str, String str2) {
        int i2 = 0;
        for (Node firstChild = this.k.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            if (str2.equals(firstChild.getLocalName()) && str.equals(firstChild.getNamespaceURI())) {
                i2++;
            }
        }
        return i2;
    }

    public abstract String d();

    public abstract String e();

    public final Element k() {
        return this.k;
    }

    public String l() {
        return this.l;
    }

    /* access modifiers changed from: package-private */
    public void m() {
        String e2 = e();
        String d2 = d();
        String localName = this.k.getLocalName();
        String namespaceURI = this.k.getNamespaceURI();
        if (!d2.equals(namespaceURI) && !e2.equals(localName)) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(namespaceURI);
            stringBuffer.append(AppConstants.COLON);
            stringBuffer.append(localName);
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(d2);
            stringBuffer2.append(AppConstants.COLON);
            stringBuffer2.append(e2);
            throw new XMLSecurityException("xml.WrongElement", new Object[]{stringBuffer.toString(), stringBuffer2.toString()});
        }
    }

    public byte[] n() {
        return Base64.a(XMLUtils.a(this.k));
    }

    public String o() {
        return XMLUtils.a(this.k);
    }
}
