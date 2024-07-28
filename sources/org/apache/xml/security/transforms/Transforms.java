package org.apache.xml.security.transforms;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.c14n.CanonicalizationException;
import org.apache.xml.security.c14n.InvalidCanonicalizerException;
import org.apache.xml.security.exceptions.XMLSecurityException;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.utils.SignatureElementProxy;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Transforms extends SignatureElementProxy {

    /* renamed from: a  reason: collision with root package name */
    static Log f72724a;

    /* renamed from: c  reason: collision with root package name */
    static Class f72725c;

    /* renamed from: b  reason: collision with root package name */
    Element[] f72726b;

    static {
        Class cls = f72725c;
        if (cls == null) {
            cls = b("org.apache.xml.security.transforms.Transforms");
            f72725c = cls;
        }
        f72724a = LogFactory.getLog(cls.getName());
    }

    protected Transforms() {
    }

    public Transforms(Document document) {
        super(document);
        XMLUtils.b(this.k);
    }

    public Transforms(Element element, String str) {
        super(element, str);
        if (a() == 0) {
            throw new TransformationException("xml.WrongContent", new Object[]{"Transform", "Transforms"});
        }
    }

    private void a(Transform transform) {
        if (f72724a.isDebugEnabled()) {
            Log log = f72724a;
            StringBuffer stringBuffer = new StringBuffer("Transforms.addTransform(");
            stringBuffer.append(transform.b());
            stringBuffer.append(")");
            log.debug(stringBuffer.toString());
        }
        this.k.appendChild(transform.k());
        XMLUtils.b(this.k);
    }

    static Class b(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    public int a() {
        if (this.f72726b == null) {
            this.f72726b = XMLUtils.a(this.k.getFirstChild(), "Transform");
        }
        return this.f72726b.length;
    }

    public XMLSignatureInput a(XMLSignatureInput xMLSignatureInput, OutputStream outputStream) {
        try {
            int a2 = a() - 1;
            for (int i2 = 0; i2 < a2; i2++) {
                Transform a3 = a(i2);
                if (f72724a.isDebugEnabled()) {
                    Log log = f72724a;
                    StringBuffer stringBuffer = new StringBuffer("Perform the (");
                    stringBuffer.append(i2);
                    stringBuffer.append(")th ");
                    stringBuffer.append(a3.b());
                    stringBuffer.append(" transform");
                    log.debug(stringBuffer.toString());
                }
                xMLSignatureInput = a3.a(xMLSignatureInput);
            }
            return a2 >= 0 ? a(a2).a(xMLSignatureInput, outputStream) : xMLSignatureInput;
        } catch (IOException e2) {
            throw new TransformationException("empty", (Exception) e2);
        } catch (CanonicalizationException e3) {
            throw new TransformationException("empty", (Exception) e3);
        } catch (InvalidCanonicalizerException e4) {
            throw new TransformationException("empty", (Exception) e4);
        }
    }

    public Transform a(int i2) {
        try {
            if (this.f72726b == null) {
                this.f72726b = XMLUtils.a(this.k.getFirstChild(), "Transform");
            }
            return new Transform(this.f72726b[i2], this.l);
        } catch (XMLSecurityException e2) {
            throw new TransformationException("empty", (Exception) e2);
        }
    }

    public void a(String str) {
        try {
            if (f72724a.isDebugEnabled()) {
                Log log = f72724a;
                StringBuffer stringBuffer = new StringBuffer("Transforms.addTransform(");
                stringBuffer.append(str);
                stringBuffer.append(")");
                log.debug(stringBuffer.toString());
            }
            a(Transform.a(this.m, str));
        } catch (InvalidTransformException e2) {
            throw new TransformationException("empty", (Exception) e2);
        }
    }

    public String e() {
        return "Transforms";
    }
}
