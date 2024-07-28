package org.apache.xml.security.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

public class IgnoreAllErrorHandler implements ErrorHandler {

    /* renamed from: a  reason: collision with root package name */
    static Log f72775a;

    /* renamed from: b  reason: collision with root package name */
    static final boolean f72776b = System.getProperty("org.apache.xml.security.test.warn.on.exceptions", "false").equals("true");

    /* renamed from: c  reason: collision with root package name */
    static final boolean f72777c = System.getProperty("org.apache.xml.security.test.throw.exceptions", "false").equals("true");

    /* renamed from: d  reason: collision with root package name */
    static Class f72778d;

    static {
        Class cls = f72778d;
        if (cls == null) {
            cls = a("org.apache.xml.security.utils.IgnoreAllErrorHandler");
            f72778d = cls;
        }
        f72775a = LogFactory.getLog(cls.getName());
    }

    static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    public void error(SAXParseException sAXParseException) {
        if (f72776b) {
            f72775a.error("", sAXParseException);
        }
        if (f72777c) {
            throw sAXParseException;
        }
    }

    public void fatalError(SAXParseException sAXParseException) {
        if (f72776b) {
            f72775a.warn("", sAXParseException);
        }
        if (f72777c) {
            throw sAXParseException;
        }
    }

    public void warning(SAXParseException sAXParseException) {
        if (f72776b) {
            f72775a.warn("", sAXParseException);
        }
        if (f72777c) {
            throw sAXParseException;
        }
    }
}
