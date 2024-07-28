package org.apache.xml.security.algorithms;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.exceptions.AlgorithmAlreadyRegisteredException;
import org.apache.xml.security.signature.XMLSignatureException;
import org.w3c.dom.Element;

public class SignatureAlgorithm extends Algorithm {

    /* renamed from: a  reason: collision with root package name */
    static Log f72537a;

    /* renamed from: b  reason: collision with root package name */
    static boolean f72538b = false;

    /* renamed from: c  reason: collision with root package name */
    static HashMap f72539c = null;

    /* renamed from: d  reason: collision with root package name */
    static ThreadLocal f72540d = new ThreadLocal() {
        /* access modifiers changed from: protected */
        public Object initialValue() {
            return new HashMap();
        }
    };

    /* renamed from: e  reason: collision with root package name */
    static ThreadLocal f72541e = new ThreadLocal() {
        /* access modifiers changed from: protected */
        public Object initialValue() {
            return new HashMap();
        }
    };

    /* renamed from: f  reason: collision with root package name */
    static ThreadLocal f72542f = new ThreadLocal() {
        /* access modifiers changed from: protected */
        public Object initialValue() {
            return new HashMap();
        }
    };

    /* renamed from: g  reason: collision with root package name */
    static ThreadLocal f72543g = new ThreadLocal() {
        /* access modifiers changed from: protected */
        public Object initialValue() {
            return new HashMap();
        }
    };

    /* renamed from: i  reason: collision with root package name */
    static Class f72544i;

    /* renamed from: h  reason: collision with root package name */
    protected SignatureAlgorithmSpi f72545h = null;
    private String q = g();

    static {
        Class cls = f72544i;
        if (cls == null) {
            cls = b("org.apache.xml.security.algorithms.SignatureAlgorithm");
            f72544i = cls;
        }
        f72537a = LogFactory.getLog(cls.getName());
    }

    public SignatureAlgorithm(Element element, String str) {
        super(element, str);
    }

    public static void a(String str, String str2) {
        String name;
        if (f72537a.isDebugEnabled()) {
            Log log = f72537a;
            StringBuffer stringBuffer = new StringBuffer("Try to register ");
            stringBuffer.append(str);
            stringBuffer.append(" ");
            stringBuffer.append(str2);
            log.debug(stringBuffer.toString());
        }
        Class g2 = g(str);
        if (g2 == null || (name = g2.getName()) == null || name.length() == 0) {
            try {
                f72539c.put(str, Class.forName(str2));
            } catch (ClassNotFoundException e2) {
                throw new XMLSignatureException("algorithms.NoSuchAlgorithm", new Object[]{str, e2.getMessage()}, e2);
            } catch (NullPointerException e3) {
                throw new XMLSignatureException("algorithms.NoSuchAlgorithm", new Object[]{str, e3.getMessage()}, e3);
            }
        } else {
            throw new AlgorithmAlreadyRegisteredException("algorithm.alreadyRegistered", new Object[]{str, name});
        }
    }

    private void a(boolean z) {
        this.f72545h = z ? d(this.q) : e(this.q);
        this.f72545h.a(this.k);
    }

    static Class b(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    private static SignatureAlgorithmSpi d(String str) {
        SignatureAlgorithmSpi signatureAlgorithmSpi = (SignatureAlgorithmSpi) ((Map) f72540d.get()).get(str);
        if (signatureAlgorithmSpi != null) {
            signatureAlgorithmSpi.c();
            return signatureAlgorithmSpi;
        }
        SignatureAlgorithmSpi f2 = f(str);
        ((Map) f72540d.get()).put(str, f2);
        return f2;
    }

    private static SignatureAlgorithmSpi e(String str) {
        SignatureAlgorithmSpi signatureAlgorithmSpi = (SignatureAlgorithmSpi) ((Map) f72541e.get()).get(str);
        if (signatureAlgorithmSpi != null) {
            signatureAlgorithmSpi.c();
            return signatureAlgorithmSpi;
        }
        SignatureAlgorithmSpi f2 = f(str);
        ((Map) f72541e.get()).put(str, f2);
        return f2;
    }

    private static SignatureAlgorithmSpi f(String str) {
        try {
            Class g2 = g(str);
            if (f72537a.isDebugEnabled()) {
                Log log = f72537a;
                StringBuffer stringBuffer = new StringBuffer("Create URI \"");
                stringBuffer.append(str);
                stringBuffer.append("\" class \"");
                stringBuffer.append(g2);
                stringBuffer.append("\"");
                log.debug(stringBuffer.toString());
            }
            return (SignatureAlgorithmSpi) g2.newInstance();
        } catch (IllegalAccessException e2) {
            throw new XMLSignatureException("algorithms.NoSuchAlgorithm", new Object[]{str, e2.getMessage()}, e2);
        } catch (InstantiationException e3) {
            throw new XMLSignatureException("algorithms.NoSuchAlgorithm", new Object[]{str, e3.getMessage()}, e3);
        } catch (NullPointerException e4) {
            throw new XMLSignatureException("algorithms.NoSuchAlgorithm", new Object[]{str, e4.getMessage()}, e4);
        }
    }

    private static Class g(String str) {
        HashMap hashMap = f72539c;
        if (hashMap == null) {
            return null;
        }
        return (Class) hashMap.get(str);
    }

    public static void h() {
        if (f72537a == null) {
            Class cls = f72544i;
            if (cls == null) {
                cls = b("org.apache.xml.security.algorithms.SignatureAlgorithm");
                f72544i = cls;
            }
            f72537a = LogFactory.getLog(cls.getName());
        }
        f72537a.debug("Init() called");
        if (!f72538b) {
            f72539c = new HashMap(10);
            f72538b = true;
        }
    }

    public void a(byte b2) {
        this.f72545h.a(b2);
    }

    public void a(Key key) {
        a(false);
        Map map = (Map) f72543g.get();
        if (map.get(this.q) != key) {
            map.put(this.q, key);
            this.f72545h.a(key);
        }
    }

    public void a(byte[] bArr) {
        this.f72545h.a(bArr);
    }

    public void a(byte[] bArr, int i2, int i3) {
        this.f72545h.a(bArr, i2, i3);
    }

    public String b() {
        try {
            return e(this.q).a();
        } catch (XMLSignatureException unused) {
            return null;
        }
    }

    public boolean b(byte[] bArr) {
        return this.f72545h.b(bArr);
    }

    public String c() {
        try {
            return e(this.q).b();
        } catch (XMLSignatureException unused) {
            return null;
        }
    }

    public String d() {
        return "http://www.w3.org/2000/09/xmldsig#";
    }

    public String e() {
        return "SignatureMethod";
    }

    public void f() {
        ((Map) f72543g.get()).clear();
        ((Map) f72541e.get()).clear();
    }

    public final String g() {
        return this.k.getAttributeNS((String) null, "Algorithm");
    }
}
