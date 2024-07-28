package org.apache.xml.security.keys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.utils.SignatureElementProxy;
import org.w3c.dom.Element;

public class KeyInfo extends SignatureElementProxy {

    /* renamed from: a  reason: collision with root package name */
    static Log f72622a;

    /* renamed from: d  reason: collision with root package name */
    static final List f72623d;

    /* renamed from: g  reason: collision with root package name */
    static boolean f72624g = false;

    /* renamed from: h  reason: collision with root package name */
    static Class f72625h;

    /* renamed from: b  reason: collision with root package name */
    List f72626b = null;

    /* renamed from: c  reason: collision with root package name */
    List f72627c = null;

    /* renamed from: e  reason: collision with root package name */
    List f72628e = null;

    /* renamed from: f  reason: collision with root package name */
    List f72629f = f72623d;

    static {
        Class cls = f72625h;
        if (cls == null) {
            cls = a("org.apache.xml.security.keys.KeyInfo");
            f72625h = cls;
        }
        f72622a = LogFactory.getLog(cls.getName());
        ArrayList arrayList = new ArrayList();
        arrayList.add((Object) null);
        f72623d = Collections.unmodifiableList(arrayList);
    }

    public KeyInfo(Element element, String str) {
        super(element, str);
    }

    static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    public static void a() {
        if (!f72624g) {
            if (f72622a == null) {
                Class cls = f72625h;
                if (cls == null) {
                    cls = a("org.apache.xml.security.keys.KeyInfo");
                    f72625h = cls;
                }
                Log log = LogFactory.getLog(cls.getName());
                f72622a = log;
                log.error("Had to assign log in the init() function");
            }
            f72624g = true;
        }
    }

    public String e() {
        return "KeyInfo";
    }
}
