package org.apache.xml.security.transforms.implementations;

import com.business.merchant_payments.utility.StringUtility;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.exceptions.XMLSecurityException;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.transforms.Transform;
import org.apache.xml.security.transforms.TransformSpi;
import org.apache.xml.security.transforms.TransformationException;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.Element;

public class TransformXSLT extends TransformSpi {

    /* renamed from: b  reason: collision with root package name */
    static Log f72732b;

    /* renamed from: c  reason: collision with root package name */
    static Class f72733c;

    /* renamed from: d  reason: collision with root package name */
    static Class f72734d;

    /* renamed from: e  reason: collision with root package name */
    private static Class f72735e;

    static {
        try {
            f72735e = Class.forName("javax.xml.XMLConstants");
        } catch (Exception unused) {
        }
        Class cls = f72733c;
        if (cls == null) {
            cls = a("org.apache.xml.security.transforms.implementations.TransformXSLT");
            f72733c = cls;
        }
        f72732b = LogFactory.getLog(cls.getName());
    }

    static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    public XMLSignatureInput a(XMLSignatureInput xMLSignatureInput, OutputStream outputStream, Transform transform) {
        Class cls;
        if (f72735e != null) {
            try {
                Element a2 = XMLUtils.a(transform.k().getFirstChild(), "http://www.w3.org/1999/XSL/Transform", "stylesheet", 0);
                if (a2 != null) {
                    TransformerFactory newInstance = TransformerFactory.newInstance();
                    Class<?> cls2 = newInstance.getClass();
                    Class[] clsArr = new Class[2];
                    if (f72734d == null) {
                        cls = a("java.lang.String");
                        f72734d = cls;
                    } else {
                        cls = f72734d;
                    }
                    clsArr[0] = cls;
                    clsArr[1] = Boolean.TYPE;
                    cls2.getMethod("setFeature", clsArr).invoke(newInstance, new Object[]{"http://javax.xml.XMLConstants/feature/secure-processing", Boolean.TRUE});
                    StreamSource streamSource = new StreamSource(new ByteArrayInputStream(xMLSignatureInput.e()));
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    newInstance.newTransformer().transform(new DOMSource(a2), new StreamResult(byteArrayOutputStream));
                    Transformer newTransformer = newInstance.newTransformer(new StreamSource(new ByteArrayInputStream(byteArrayOutputStream.toByteArray())));
                    try {
                        newTransformer.setOutputProperty("{http://xml.apache.org/xalan}line-separator", StringUtility.NEW_LINE);
                    } catch (Exception e2) {
                        Log log = f72732b;
                        StringBuffer stringBuffer = new StringBuffer("Unable to set Xalan line-separator property: ");
                        stringBuffer.append(e2.getMessage());
                        log.warn(stringBuffer.toString());
                    }
                    if (outputStream == null) {
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                        newTransformer.transform(streamSource, new StreamResult(byteArrayOutputStream2));
                        return new XMLSignatureInput(byteArrayOutputStream2.toByteArray());
                    }
                    newTransformer.transform(streamSource, new StreamResult(outputStream));
                    XMLSignatureInput xMLSignatureInput2 = new XMLSignatureInput((byte[]) null);
                    xMLSignatureInput2.b(outputStream);
                    return xMLSignatureInput2;
                }
                throw new TransformationException("xml.WrongContent", new Object[]{"xslt:stylesheet", "Transform"});
            } catch (XMLSecurityException e3) {
                throw new TransformationException("generic.EmptyMessage", new Object[]{e3.getMessage()}, e3);
            } catch (TransformerConfigurationException e4) {
                throw new TransformationException("generic.EmptyMessage", new Object[]{e4.getMessage()}, e4);
            } catch (TransformerException e5) {
                throw new TransformationException("generic.EmptyMessage", new Object[]{e5.getMessage()}, e5);
            } catch (NoSuchMethodException e6) {
                throw new TransformationException("generic.EmptyMessage", new Object[]{e6.getMessage()}, e6);
            } catch (IllegalAccessException e7) {
                throw new TransformationException("generic.EmptyMessage", new Object[]{e7.getMessage()}, e7);
            } catch (InvocationTargetException e8) {
                throw new TransformationException("generic.EmptyMessage", new Object[]{e8.getMessage()}, e8);
            }
        } else {
            throw new TransformationException("generic.EmptyMessage", new Object[]{"SECURE_PROCESSING_FEATURE not supported"});
        }
    }

    public XMLSignatureInput a(XMLSignatureInput xMLSignatureInput, Transform transform) {
        return a(xMLSignatureInput, (OutputStream) null, transform);
    }
}
