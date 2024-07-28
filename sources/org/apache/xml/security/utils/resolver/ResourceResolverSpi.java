package org.apache.xml.security.utils.resolver;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.w3c.dom.Attr;

public abstract class ResourceResolverSpi {

    /* renamed from: a  reason: collision with root package name */
    static Log f72806a;

    /* renamed from: c  reason: collision with root package name */
    static Class f72807c;

    /* renamed from: b  reason: collision with root package name */
    protected Map f72808b = null;

    static {
        Class cls = f72807c;
        if (cls == null) {
            cls = b("org.apache.xml.security.utils.resolver.ResourceResolverSpi");
            f72807c = cls;
        }
        f72806a = LogFactory.getLog(cls.getName());
    }

    static Class b(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    public String a(String str) {
        Map map = this.f72808b;
        if (map == null) {
            return null;
        }
        return (String) map.get(str);
    }

    public abstract XMLSignatureInput a(Attr attr, String str);

    public void a(Map map) {
        if (map != null) {
            if (this.f72808b == null) {
                this.f72808b = new HashMap();
            }
            this.f72808b.putAll(map);
        }
    }

    public boolean a() {
        return false;
    }

    public abstract boolean b(Attr attr, String str);
}
