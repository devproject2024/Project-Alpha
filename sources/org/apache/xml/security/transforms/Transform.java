package org.apache.xml.security.transforms;

import java.io.OutputStream;
import java.util.HashMap;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.c14n.CanonicalizationException;
import org.apache.xml.security.exceptions.AlgorithmAlreadyRegisteredException;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.utils.ClassLoaderUtils;
import org.apache.xml.security.utils.SignatureElementProxy;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public final class Transform extends SignatureElementProxy {

    /* renamed from: a  reason: collision with root package name */
    static Class f72717a;

    /* renamed from: b  reason: collision with root package name */
    private static Log f72718b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f72719c = false;

    /* renamed from: d  reason: collision with root package name */
    private static HashMap f72720d = null;

    /* renamed from: e  reason: collision with root package name */
    private static HashMap f72721e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private TransformSpi f72722f = null;

    static {
        Class cls = f72717a;
        if (cls == null) {
            cls = a("org.apache.xml.security.transforms.Transform");
            f72717a = cls;
        }
        f72718b = LogFactory.getLog(cls.getName());
    }

    public Transform(Document document, String str, NodeList nodeList) {
        super(document);
        this.k.setAttributeNS((String) null, "Algorithm", str);
        this.f72722f = d(str);
        if (this.f72722f != null) {
            if (f72718b.isDebugEnabled()) {
                Log log = f72718b;
                StringBuffer stringBuffer = new StringBuffer("Create URI \"");
                stringBuffer.append(str);
                stringBuffer.append("\" class \"");
                stringBuffer.append(this.f72722f.getClass());
                stringBuffer.append("\"");
                log.debug(stringBuffer.toString());
                f72718b.debug("The NodeList is ".concat(String.valueOf(nodeList)));
            }
            if (nodeList != null) {
                for (int i2 = 0; i2 < nodeList.getLength(); i2++) {
                    this.k.appendChild(nodeList.item(i2).cloneNode(true));
                }
                return;
            }
            return;
        }
        throw new InvalidTransformException("signature.Transform.UnknownTransform", new Object[]{str});
    }

    public Transform(Element element, String str) {
        super(element, str);
        String attributeNS = element.getAttributeNS((String) null, "Algorithm");
        if (attributeNS == null || attributeNS.length() == 0) {
            throw new TransformationException("xml.WrongContent", new Object[]{"Algorithm", "Transform"});
        }
        this.f72722f = d(attributeNS);
        if (this.f72722f == null) {
            throw new InvalidTransformException("signature.Transform.UnknownTransform", new Object[]{attributeNS});
        }
    }

    static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    public static Transform a(Document document, String str) {
        return a(document, str, (NodeList) null);
    }

    public static Transform a(Document document, String str, NodeList nodeList) {
        return new Transform(document, str, nodeList);
    }

    public static void a() {
        if (!f72719c) {
            f72720d = new HashMap(10);
            f72719c = true;
        }
    }

    public static void a(String str, String str2) {
        Class cls;
        Class b2 = b(str);
        if (b2 == null) {
            try {
                HashMap hashMap = f72720d;
                if (f72717a == null) {
                    cls = a("org.apache.xml.security.transforms.Transform");
                    f72717a = cls;
                } else {
                    cls = f72717a;
                }
                hashMap.put(str, ClassLoaderUtils.a(str2, cls));
            } catch (ClassNotFoundException e2) {
                throw new RuntimeException(e2);
            }
        } else {
            throw new AlgorithmAlreadyRegisteredException("algorithm.alreadyRegistered", new Object[]{str, b2});
        }
    }

    private static Class b(String str) {
        return (Class) f72720d.get(str);
    }

    private static TransformSpi d(String str) {
        try {
            Object obj = f72721e.get(str);
            if (obj != null) {
                return (TransformSpi) obj;
            }
            Class cls = (Class) f72720d.get(str);
            if (cls == null) {
                return null;
            }
            TransformSpi transformSpi = (TransformSpi) cls.newInstance();
            f72721e.put(str, transformSpi);
            return transformSpi;
        } catch (InstantiationException e2) {
            throw new InvalidTransformException("signature.Transform.UnknownTransform", new Object[]{str}, e2);
        } catch (IllegalAccessException e3) {
            throw new InvalidTransformException("signature.Transform.UnknownTransform", new Object[]{str}, e3);
        }
    }

    public final XMLSignatureInput a(XMLSignatureInput xMLSignatureInput) {
        try {
            return this.f72722f.a(xMLSignatureInput, this);
        } catch (ParserConfigurationException e2) {
            throw new CanonicalizationException("signature.Transform.ErrorDuringTransform", new Object[]{b(), "ParserConfigurationException"}, e2);
        } catch (SAXException e3) {
            throw new CanonicalizationException("signature.Transform.ErrorDuringTransform", new Object[]{b(), "SAXException"}, e3);
        }
    }

    public final XMLSignatureInput a(XMLSignatureInput xMLSignatureInput, OutputStream outputStream) {
        try {
            return this.f72722f.a(xMLSignatureInput, outputStream, this);
        } catch (ParserConfigurationException e2) {
            throw new CanonicalizationException("signature.Transform.ErrorDuringTransform", new Object[]{b(), "ParserConfigurationException"}, e2);
        } catch (SAXException e3) {
            throw new CanonicalizationException("signature.Transform.ErrorDuringTransform", new Object[]{b(), "SAXException"}, e3);
        }
    }

    public final String b() {
        return this.k.getAttributeNS((String) null, "Algorithm");
    }

    public final String e() {
        return "Transform";
    }
}
