package org.apache.xml.security.signature;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.c14n.CanonicalizationException;
import org.apache.xml.security.c14n.implementations.Canonicalizer11_OmitComments;
import org.apache.xml.security.c14n.implementations.Canonicalizer20010315OmitComments;
import org.apache.xml.security.c14n.implementations.CanonicalizerBase;
import org.apache.xml.security.exceptions.XMLSecurityRuntimeException;
import org.apache.xml.security.utils.IgnoreAllErrorHandler;
import org.apache.xml.security.utils.JavaUtils;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class XMLSignatureInput implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    static Log f72705a;
    static Class l;

    /* renamed from: b  reason: collision with root package name */
    InputStream f72706b = null;

    /* renamed from: c  reason: collision with root package name */
    Set f72707c = null;

    /* renamed from: d  reason: collision with root package name */
    Node f72708d = null;

    /* renamed from: e  reason: collision with root package name */
    Node f72709e = null;

    /* renamed from: f  reason: collision with root package name */
    boolean f72710f = false;

    /* renamed from: g  reason: collision with root package name */
    boolean f72711g = false;

    /* renamed from: h  reason: collision with root package name */
    byte[] f72712h = null;

    /* renamed from: i  reason: collision with root package name */
    List f72713i = new ArrayList();
    boolean j = false;
    OutputStream k = null;
    private String m = null;
    private String n = null;

    static {
        Class cls = l;
        if (cls == null) {
            cls = c("org.apache.xml.security.signature.XMLSignatureInput");
            l = cls;
        }
        f72705a = LogFactory.getLog(cls.getName());
    }

    public XMLSignatureInput(InputStream inputStream) {
        this.f72706b = inputStream;
    }

    public XMLSignatureInput(Node node) {
        this.f72708d = node;
    }

    public XMLSignatureInput(byte[] bArr) {
        this.f72712h = bArr;
    }

    static Class c(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    public void a(OutputStream outputStream) {
        a(outputStream, false);
    }

    public void a(OutputStream outputStream, boolean z) {
        if (outputStream != this.k) {
            byte[] bArr = this.f72712h;
            if (bArr != null) {
                outputStream.write(bArr);
                return;
            }
            InputStream inputStream = this.f72706b;
            if (inputStream == null) {
                CanonicalizerBase canonicalizer11_OmitComments = z ? new Canonicalizer11_OmitComments() : new Canonicalizer20010315OmitComments();
                canonicalizer11_OmitComments.a(outputStream);
                canonicalizer11_OmitComments.b(this);
            } else if (inputStream instanceof FileInputStream) {
                byte[] bArr2 = new byte[4096];
                while (true) {
                    int read = this.f72706b.read(bArr2);
                    if (read != -1) {
                        outputStream.write(bArr2, 0, read);
                    } else {
                        return;
                    }
                }
            } else {
                InputStream o = o();
                byte[] bArr3 = this.f72712h;
                if (bArr3 != null) {
                    outputStream.write(bArr3, 0, bArr3.length);
                    return;
                }
                o.reset();
                byte[] bArr4 = new byte[TarConstants.EOF_BLOCK];
                while (true) {
                    int read2 = o.read(bArr4);
                    if (read2 > 0) {
                        outputStream.write(bArr4, 0, read2);
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void a(String str) {
        this.m = str;
    }

    public void a(NodeFilter nodeFilter) {
        if (h()) {
            try {
                q();
            } catch (Exception e2) {
                throw new XMLSecurityRuntimeException("signature.XMLSignatureInput.nodesetReference", e2);
            }
        }
        this.f72713i.add(nodeFilter);
    }

    public void a(Node node) {
        this.f72709e = node;
    }

    public void a(boolean z) {
        this.j = z;
    }

    public boolean a() {
        return this.j;
    }

    public Set b() {
        return b(false);
    }

    public Set b(boolean z) {
        Node node;
        Set set = this.f72707c;
        if (set != null) {
            return set;
        }
        if (this.f72706b == null && (node = this.f72708d) != null) {
            if (z) {
                XMLUtils.a(XMLUtils.b(node));
            }
            this.f72707c = new HashSet();
            XMLUtils.a(this.f72708d, this.f72707c, this.f72709e, this.f72710f);
            return this.f72707c;
        } else if (h()) {
            q();
            HashSet hashSet = new HashSet();
            XMLUtils.a(this.f72708d, (Set) hashSet, (Node) null, false);
            return hashSet;
        } else {
            throw new RuntimeException("getNodeSet() called but no input data present");
        }
    }

    public void b(OutputStream outputStream) {
        this.k = outputStream;
    }

    public void b(String str) {
        this.n = str;
    }

    public InputStream c() {
        InputStream inputStream = this.f72706b;
        return inputStream instanceof FileInputStream ? inputStream : o();
    }

    public void c(boolean z) {
        this.f72710f = z;
    }

    public InputStream d() {
        return this.f72706b;
    }

    public void d(boolean z) {
        this.f72711g = z;
    }

    public byte[] e() {
        byte[] bArr = this.f72712h;
        if (bArr != null) {
            return bArr;
        }
        InputStream o = o();
        if (o != null) {
            if (this.f72712h == null) {
                o.reset();
                this.f72712h = JavaUtils.a(o);
            }
            return this.f72712h;
        }
        this.f72712h = new Canonicalizer20010315OmitComments().b(this);
        return this.f72712h;
    }

    public boolean f() {
        return (this.f72706b == null && this.f72707c != null) || this.f72711g;
    }

    public boolean g() {
        return this.f72706b == null && this.f72708d != null && this.f72707c == null && !this.f72711g;
    }

    public boolean h() {
        return !(this.f72706b == null && this.f72712h == null) && this.f72707c == null && this.f72708d == null;
    }

    public boolean i() {
        return this.k != null;
    }

    public boolean j() {
        return this.f72712h != null && this.f72707c == null && this.f72708d == null;
    }

    public String k() {
        return this.n;
    }

    public Node l() {
        return this.f72709e;
    }

    public Node m() {
        return this.f72708d;
    }

    public boolean n() {
        return this.f72710f;
    }

    /* access modifiers changed from: protected */
    public InputStream o() {
        ByteArrayInputStream byteArrayInputStream;
        InputStream inputStream = this.f72706b;
        if (!(inputStream instanceof ByteArrayInputStream)) {
            byte[] bArr = this.f72712h;
            if (bArr != null) {
                byteArrayInputStream = new ByteArrayInputStream(bArr);
            } else if (inputStream == null) {
                return null;
            } else {
                if (inputStream.markSupported()) {
                    f72705a.info("Mark Suported but not used as reset");
                }
                this.f72712h = JavaUtils.a(this.f72706b);
                this.f72706b.close();
                byteArrayInputStream = new ByteArrayInputStream(this.f72712h);
            }
            this.f72706b = byteArrayInputStream;
            return this.f72706b;
        } else if (inputStream.markSupported()) {
            return this.f72706b;
        } else {
            StringBuffer stringBuffer = new StringBuffer("Accepted as Markable but not truly been");
            stringBuffer.append(this.f72706b);
            throw new RuntimeException(stringBuffer.toString());
        }
    }

    public List p() {
        return this.f72713i;
    }

    /* access modifiers changed from: package-private */
    public void q() {
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        newInstance.setValidating(false);
        newInstance.setNamespaceAware(true);
        DocumentBuilder newDocumentBuilder = newInstance.newDocumentBuilder();
        try {
            newDocumentBuilder.setErrorHandler(new IgnoreAllErrorHandler());
            this.f72708d = newDocumentBuilder.parse(c());
        } catch (SAXException unused) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write("<container>".getBytes());
            byteArrayOutputStream.write(e());
            byteArrayOutputStream.write("</container>".getBytes());
            this.f72708d = newDocumentBuilder.parse(new ByteArrayInputStream(byteArrayOutputStream.toByteArray())).getDocumentElement().getFirstChild().getFirstChild();
        }
        this.f72706b = null;
        this.f72712h = null;
    }

    public String toString() {
        if (f()) {
            StringBuffer stringBuffer = new StringBuffer("XMLSignatureInput/NodeSet/");
            stringBuffer.append(this.f72707c.size());
            stringBuffer.append(" nodes/");
            stringBuffer.append(k());
            return stringBuffer.toString();
        } else if (g()) {
            StringBuffer stringBuffer2 = new StringBuffer("XMLSignatureInput/Element/");
            stringBuffer2.append(this.f72708d);
            stringBuffer2.append(" exclude ");
            stringBuffer2.append(this.f72709e);
            stringBuffer2.append(" comments:");
            stringBuffer2.append(this.f72710f);
            stringBuffer2.append("/");
            stringBuffer2.append(k());
            return stringBuffer2.toString();
        } else {
            try {
                StringBuffer stringBuffer3 = new StringBuffer("XMLSignatureInput/OctetStream/");
                stringBuffer3.append(e().length);
                stringBuffer3.append(" octets/");
                stringBuffer3.append(k());
                return stringBuffer3.toString();
            } catch (IOException unused) {
                StringBuffer stringBuffer4 = new StringBuffer("XMLSignatureInput/OctetStream//");
                stringBuffer4.append(k());
                return stringBuffer4.toString();
            } catch (CanonicalizationException unused2) {
                StringBuffer stringBuffer5 = new StringBuffer("XMLSignatureInput/OctetStream//");
                stringBuffer5.append(k());
                return stringBuffer5.toString();
            }
        }
    }
}
