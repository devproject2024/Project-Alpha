package org.apache.xml.security.signature;

import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import java.io.IOException;
import java.io.OutputStream;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.algorithms.MessageDigestAlgorithm;
import org.apache.xml.security.c14n.CanonicalizationException;
import org.apache.xml.security.c14n.InvalidCanonicalizerException;
import org.apache.xml.security.exceptions.XMLSecurityException;
import org.apache.xml.security.transforms.TransformationException;
import org.apache.xml.security.transforms.Transforms;
import org.apache.xml.security.utils.Base64;
import org.apache.xml.security.utils.DigesterOutputStream;
import org.apache.xml.security.utils.SignatureElementProxy;
import org.apache.xml.security.utils.UnsyncBufferedOutputStream;
import org.apache.xml.security.utils.XMLUtils;
import org.apache.xml.security.utils.resolver.ResourceResolver;
import org.apache.xml.security.utils.resolver.ResourceResolverException;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;

public class Reference extends SignatureElementProxy {

    /* renamed from: a  reason: collision with root package name */
    static Log f72687a;

    /* renamed from: d  reason: collision with root package name */
    static Class f72688d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f72689e = ((Boolean) AccessController.doPrivileged(new PrivilegedAction() {
        public Object run() {
            return Boolean.valueOf(Boolean.getBoolean("org.apache.xml.security.useC14N11"));
        }
    })).booleanValue();

    /* renamed from: b  reason: collision with root package name */
    Manifest f72690b = null;

    /* renamed from: c  reason: collision with root package name */
    XMLSignatureInput f72691c;

    /* renamed from: f  reason: collision with root package name */
    private Transforms f72692f;

    /* renamed from: g  reason: collision with root package name */
    private Element f72693g;

    /* renamed from: h  reason: collision with root package name */
    private Element f72694h;

    static {
        Class cls = f72688d;
        if (cls == null) {
            cls = a("org.apache.xml.security.signature.Reference");
            f72688d = cls;
        }
        f72687a = LogFactory.getLog(cls.getName());
    }

    protected Reference(Element element, String str, Manifest manifest) {
        super(element, str);
        this.l = str;
        Element a2 = XMLUtils.a(element.getFirstChild());
        if ("Transforms".equals(a2.getLocalName()) && "http://www.w3.org/2000/09/xmldsig#".equals(a2.getNamespaceURI())) {
            this.f72692f = new Transforms(a2, this.l);
            a2 = XMLUtils.a(a2.getNextSibling());
        }
        this.f72693g = a2;
        this.f72694h = XMLUtils.a(this.f72693g.getNextSibling());
        this.f72690b = manifest;
    }

    static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    private XMLSignatureInput a(XMLSignatureInput xMLSignatureInput, OutputStream outputStream) {
        try {
            Transforms h2 = h();
            if (h2 == null) {
                return xMLSignatureInput;
            }
            XMLSignatureInput a2 = h2.a(xMLSignatureInput, outputStream);
            this.f72691c = a2;
            return a2;
        } catch (ResourceResolverException e2) {
            throw new XMLSignatureException("empty", (Exception) e2);
        } catch (CanonicalizationException e3) {
            throw new XMLSignatureException("empty", (Exception) e3);
        } catch (InvalidCanonicalizerException e4) {
            throw new XMLSignatureException("empty", (Exception) e4);
        } catch (TransformationException e5) {
            throw new XMLSignatureException("empty", (Exception) e5);
        } catch (XMLSecurityException e6) {
            throw new XMLSignatureException("empty", (Exception) e6);
        }
    }

    private byte[] a(boolean z) {
        try {
            MessageDigestAlgorithm a2 = a();
            a2.c();
            DigesterOutputStream digesterOutputStream = new DigesterOutputStream(a2);
            UnsyncBufferedOutputStream unsyncBufferedOutputStream = new UnsyncBufferedOutputStream(digesterOutputStream);
            XMLSignatureInput a3 = a((OutputStream) unsyncBufferedOutputStream);
            if (!f72689e || z || a3.i() || a3.h()) {
                a3.a((OutputStream) unsyncBufferedOutputStream);
            } else {
                if (this.f72692f == null) {
                    this.f72692f = new Transforms(this.m);
                    this.k.insertBefore(this.f72692f.k(), this.f72693g);
                }
                this.f72692f.a("http://www.w3.org/2006/12/xml-c14n11");
                a3.a(unsyncBufferedOutputStream, true);
            }
            unsyncBufferedOutputStream.flush();
            return digesterOutputStream.a();
        } catch (XMLSecurityException e2) {
            throw new ReferenceNotInitializedException("empty", (Exception) e2);
        } catch (IOException e3) {
            throw new ReferenceNotInitializedException("empty", (Exception) e3);
        }
    }

    public MessageDigestAlgorithm a() {
        String attributeNS;
        Element element = this.f72693g;
        if (element == null || (attributeNS = element.getAttributeNS((String) null, "Algorithm")) == null) {
            return null;
        }
        return MessageDigestAlgorithm.a(this.m, attributeNS);
    }

    /* access modifiers changed from: protected */
    public XMLSignatureInput a(OutputStream outputStream) {
        try {
            XMLSignatureInput a2 = a(g(), outputStream);
            this.f72691c = a2;
            return a2;
        } catch (XMLSecurityException e2) {
            throw new ReferenceNotInitializedException("empty", (Exception) e2);
        }
    }

    public String b() {
        return this.k.getAttributeNS((String) null, "URI");
    }

    public String c() {
        return this.k.getAttributeNS((String) null, AppManagerUtil.EXTEND_TYPE);
    }

    public String e() {
        return "Reference";
    }

    public boolean f() {
        return "http://www.w3.org/2000/09/xmldsig#Manifest".equals(c());
    }

    public XMLSignatureInput g() {
        try {
            String str = null;
            Attr attributeNodeNS = this.k.getAttributeNodeNS((String) null, "URI");
            if (attributeNodeNS != null) {
                str = attributeNodeNS.getNodeValue();
            }
            ResourceResolver a2 = ResourceResolver.a(attributeNodeNS, this.l, this.f72690b.f72684e);
            if (a2 != null) {
                a2.a((Map) this.f72690b.f72683d);
                return a2.b(attributeNodeNS, this.l);
            }
            throw new ReferenceNotInitializedException("signature.Verification.Reference.NoInput", new Object[]{str});
        } catch (ResourceResolverException e2) {
            throw new ReferenceNotInitializedException("empty", (Exception) e2);
        } catch (XMLSecurityException e3) {
            throw new ReferenceNotInitializedException("empty", (Exception) e3);
        }
    }

    public Transforms h() {
        return this.f72692f;
    }

    public byte[] i() {
        Element element = this.f72694h;
        if (element != null) {
            return Base64.a(element);
        }
        throw new XMLSecurityException("signature.Verification.NoSignatureElement", new Object[]{"DigestValue", "http://www.w3.org/2000/09/xmldsig#"});
    }

    public boolean j() {
        byte[] i2 = i();
        byte[] a2 = a(true);
        boolean a3 = MessageDigestAlgorithm.a(i2, a2);
        if (!a3) {
            Log log = f72687a;
            StringBuffer stringBuffer = new StringBuffer("Verification failed for URI \"");
            stringBuffer.append(b());
            stringBuffer.append("\"");
            log.warn(stringBuffer.toString());
            Log log2 = f72687a;
            StringBuffer stringBuffer2 = new StringBuffer("Expected Digest: ");
            stringBuffer2.append(Base64.b(i2));
            log2.warn(stringBuffer2.toString());
            Log log3 = f72687a;
            StringBuffer stringBuffer3 = new StringBuffer("Actual Digest: ");
            stringBuffer3.append(Base64.b(a2));
            log3.warn(stringBuffer3.toString());
        } else {
            Log log4 = f72687a;
            StringBuffer stringBuffer4 = new StringBuffer("Verification successful for URI \"");
            stringBuffer4.append(b());
            stringBuffer4.append("\"");
            log4.debug(stringBuffer4.toString());
        }
        return a3;
    }
}
