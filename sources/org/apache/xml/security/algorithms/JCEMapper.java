package org.apache.xml.security.algorithms;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.Element;

public class JCEMapper {

    /* renamed from: a  reason: collision with root package name */
    static Log f72527a;

    /* renamed from: b  reason: collision with root package name */
    static Class f72528b;

    /* renamed from: c  reason: collision with root package name */
    private static Map f72529c;

    /* renamed from: d  reason: collision with root package name */
    private static Map f72530d;

    /* renamed from: e  reason: collision with root package name */
    private static String f72531e = null;

    public class Algorithm {

        /* renamed from: a  reason: collision with root package name */
        String f72532a;

        /* renamed from: b  reason: collision with root package name */
        String f72533b;

        /* renamed from: c  reason: collision with root package name */
        String f72534c;

        public Algorithm(Element element) {
            this.f72532a = element.getAttribute("AlgorithmClass");
            this.f72533b = element.getAttribute("KeyLength");
            this.f72534c = element.getAttribute("RequiredKey");
        }
    }

    static {
        Class cls = f72528b;
        if (cls == null) {
            cls = b("org.apache.xml.security.algorithms.JCEMapper");
            f72528b = cls;
        }
        f72527a = LogFactory.getLog(cls.getName());
    }

    public static String a() {
        return f72531e;
    }

    public static String a(String str) {
        if (f72527a.isDebugEnabled()) {
            f72527a.debug("Request for URI ".concat(String.valueOf(str)));
        }
        return (String) f72529c.get(str);
    }

    public static void a(Element element) {
        b((Element) element.getElementsByTagName("Algorithms").item(0));
    }

    static Class b(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    static void b(Element element) {
        Element[] a2 = XMLUtils.a(element.getFirstChild(), "http://www.xmlsecurity.org/NS/#configuration", "Algorithm");
        f72529c = new HashMap(a2.length * 2);
        f72530d = new HashMap(a2.length * 2);
        for (Element element2 : a2) {
            String attribute = element2.getAttribute("URI");
            f72529c.put(attribute, element2.getAttribute("JCEName"));
            f72530d.put(attribute, new Algorithm(element2));
        }
    }
}
