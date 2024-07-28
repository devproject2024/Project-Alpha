package org.apache.xml.security.signature;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.exceptions.XMLSecurityException;
import org.apache.xml.security.utils.I18n;
import org.apache.xml.security.utils.SignatureElementProxy;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class Manifest extends SignatureElementProxy {

    /* renamed from: a  reason: collision with root package name */
    static Log f72679a;

    /* renamed from: f  reason: collision with root package name */
    static Class f72680f;

    /* renamed from: b  reason: collision with root package name */
    List f72681b;

    /* renamed from: c  reason: collision with root package name */
    Element[] f72682c = XMLUtils.a(this.k.getFirstChild(), "Reference");

    /* renamed from: d  reason: collision with root package name */
    HashMap f72683d = null;

    /* renamed from: e  reason: collision with root package name */
    List f72684e = null;

    /* renamed from: g  reason: collision with root package name */
    private boolean[] f72685g = null;

    static {
        Class cls = f72680f;
        if (cls == null) {
            cls = a("org.apache.xml.security.signature.Manifest");
            f72680f = cls;
        }
        f72679a = LogFactory.getLog(cls.getName());
    }

    public Manifest(Element element, String str) {
        super(element, str);
        int length = this.f72682c.length;
        if (length != 0) {
            this.f72681b = new ArrayList(length);
            for (int i2 = 0; i2 < length; i2++) {
                this.f72681b.add((Object) null);
            }
            return;
        }
        throw new DOMException(4, I18n.a("xml.WrongContent", new Object[]{"Reference", "Manifest"}));
    }

    static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    private void a(int i2, boolean z) {
        if (this.f72685g == null) {
            this.f72685g = new boolean[a()];
        }
        this.f72685g[i2] = z;
    }

    public int a() {
        return this.f72681b.size();
    }

    public boolean a(boolean z) {
        if (this.f72682c == null) {
            this.f72682c = XMLUtils.a(this.k.getFirstChild(), "Reference");
        }
        if (f72679a.isDebugEnabled()) {
            Log log = f72679a;
            StringBuffer stringBuffer = new StringBuffer("verify ");
            stringBuffer.append(this.f72682c.length);
            stringBuffer.append(" References");
            log.debug(stringBuffer.toString());
            Log log2 = f72679a;
            StringBuffer stringBuffer2 = new StringBuffer("I am ");
            stringBuffer2.append(z ? "" : "not");
            stringBuffer2.append(" requested to follow nested Manifests");
            log2.debug(stringBuffer2.toString());
        }
        Element[] elementArr = this.f72682c;
        if (elementArr.length != 0) {
            this.f72685g = new boolean[elementArr.length];
            int i2 = 0;
            boolean z2 = true;
            while (true) {
                Element[] elementArr2 = this.f72682c;
                if (i2 >= elementArr2.length) {
                    return z2;
                }
                Reference reference = new Reference(elementArr2[i2], this.l, this);
                this.f72681b.set(i2, reference);
                try {
                    boolean j = reference.j();
                    a(i2, j);
                    if (!j) {
                        z2 = false;
                    }
                    if (f72679a.isDebugEnabled()) {
                        Log log3 = f72679a;
                        StringBuffer stringBuffer3 = new StringBuffer("The Reference has Type ");
                        stringBuffer3.append(reference.c());
                        log3.debug(stringBuffer3.toString());
                    }
                    if (z2 && z && reference.f()) {
                        f72679a.debug("We have to follow a nested Manifest");
                        Manifest manifest = null;
                        XMLSignatureInput a2 = reference.a((OutputStream) null);
                        Iterator it2 = a2.b().iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            Node node = (Node) it2.next();
                            if (node.getNodeType() == 1 && ((Element) node).getNamespaceURI().equals("http://www.w3.org/2000/09/xmldsig#") && ((Element) node).getLocalName().equals("Manifest")) {
                                try {
                                    manifest = new Manifest((Element) node, a2.k());
                                    break;
                                } catch (XMLSecurityException unused) {
                                    continue;
                                }
                            }
                        }
                        if (manifest != null) {
                            manifest.f72684e = this.f72684e;
                            manifest.f72683d = this.f72683d;
                            if (!manifest.a(z)) {
                                f72679a.warn("The nested Manifest was invalid (bad)");
                                z2 = false;
                            } else {
                                f72679a.debug("The nested Manifest was valid (good)");
                            }
                        } else {
                            throw new MissingResourceFailureException("empty", reference);
                        }
                    }
                    i2++;
                } catch (IOException e2) {
                    throw new ReferenceNotInitializedException("empty", (Exception) e2);
                } catch (ParserConfigurationException e3) {
                    throw new ReferenceNotInitializedException("empty", (Exception) e3);
                } catch (SAXException e4) {
                    throw new ReferenceNotInitializedException("empty", (Exception) e4);
                } catch (ReferenceNotInitializedException e5) {
                    throw new MissingResourceFailureException("signature.Verification.Reference.NoInput", new Object[]{reference.b()}, e5, reference);
                }
            }
        } else {
            throw new XMLSecurityException("empty");
        }
    }

    public String e() {
        return "Manifest";
    }
}
