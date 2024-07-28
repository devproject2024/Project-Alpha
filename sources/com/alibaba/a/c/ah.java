package com.alibaba.a.c;

import com.alibaba.a.c;
import com.alibaba.a.d;
import com.alibaba.a.f;
import java.io.IOException;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

public final class ah {

    /* renamed from: a  reason: collision with root package name */
    final ba f6266a;

    /* renamed from: b  reason: collision with root package name */
    public List<c> f6267b;

    /* renamed from: c  reason: collision with root package name */
    public List<a> f6268c;

    /* renamed from: d  reason: collision with root package name */
    public List<av> f6269d;

    /* renamed from: e  reason: collision with root package name */
    public List<bi> f6270e;

    /* renamed from: f  reason: collision with root package name */
    public List<ap> f6271f;

    /* renamed from: g  reason: collision with root package name */
    public List<aw> f6272g;

    /* renamed from: h  reason: collision with root package name */
    public String f6273h;

    /* renamed from: i  reason: collision with root package name */
    public DateFormat f6274i;
    ax j;
    private final ay k;
    private int l;
    private String m;
    private IdentityHashMap<Object, ax> n;

    public ah() {
        this(new ba(), ay.a());
    }

    public ah(ba baVar) {
        this(baVar, ay.a());
    }

    public ah(ba baVar, ay ayVar) {
        this.f6267b = null;
        this.f6268c = null;
        this.f6269d = null;
        this.f6270e = null;
        this.f6271f = null;
        this.f6272g = null;
        this.l = 0;
        this.m = "\t";
        this.n = null;
        this.f6266a = baVar;
        this.k = ayVar;
    }

    public final DateFormat a() {
        String str;
        if (this.f6274i == null && (str = this.f6273h) != null) {
            this.f6274i = new SimpleDateFormat(str);
        }
        return this.f6274i;
    }

    public final void a(ax axVar, Object obj, Object obj2, int i2) {
        if (!b(bb.DisableCircularReferenceDetect)) {
            this.j = new ax(axVar, obj, obj2, i2);
            if (this.n == null) {
                this.n = new IdentityHashMap<>();
            }
            this.n.put(obj, this.j);
        }
    }

    public final boolean a(Object obj) {
        IdentityHashMap<Object, ax> identityHashMap = this.n;
        if (identityHashMap == null) {
            return false;
        }
        return identityHashMap.containsKey(obj);
    }

    public final void b() {
        this.l++;
    }

    public final void c() {
        this.l--;
    }

    public final void d() {
        this.f6266a.a(10);
        for (int i2 = 0; i2 < this.l; i2++) {
            this.f6266a.write(this.m);
        }
    }

    public final String toString() {
        return this.f6266a.toString();
    }

    public final void a(bb bbVar) {
        this.f6266a.a(bbVar);
    }

    public final boolean b(bb bbVar) {
        return this.f6266a.b(bbVar);
    }

    public final void e() {
        this.f6266a.write("null");
    }

    public final void c(Object obj) {
        if (obj == null) {
            this.f6266a.write("null");
            return;
        }
        try {
            a(obj.getClass()).a(this, obj, (Object) null, (Type) null);
        } catch (IOException e2) {
            throw new d(e2.getMessage(), e2);
        }
    }

    public final void a(Object obj, String str) {
        if (obj instanceof Date) {
            DateFormat a2 = a();
            if (a2 == null) {
                a2 = new SimpleDateFormat(str);
            }
            this.f6266a.b(a2.format((Date) obj));
            return;
        }
        c(obj);
    }

    public final void a(String str) {
        bd bdVar = bd.f6309a;
        bd.a(this, str);
    }

    public final at a(Class<?> cls) {
        boolean z;
        at atVar = (at) this.k.a(cls);
        if (atVar != null) {
            return atVar;
        }
        if (Map.class.isAssignableFrom(cls)) {
            this.k.a(cls, ao.f6283a);
        } else if (List.class.isAssignableFrom(cls)) {
            this.k.a(cls, ak.f6279a);
        } else if (Collection.class.isAssignableFrom(cls)) {
            this.k.a(cls, n.f6327a);
        } else if (Date.class.isAssignableFrom(cls)) {
            this.k.a(cls, q.f6330a);
        } else if (c.class.isAssignableFrom(cls)) {
            this.k.a(cls, ae.f6264a);
        } else if (af.class.isAssignableFrom(cls)) {
            this.k.a(cls, ag.f6265a);
        } else if (f.class.isAssignableFrom(cls)) {
            this.k.a(cls, ai.f6275a);
        } else if (cls.isEnum() || (cls.getSuperclass() != null && cls.getSuperclass().isEnum())) {
            this.k.a(cls, t.f6334a);
        } else if (cls.isArray()) {
            Class<?> componentType = cls.getComponentType();
            this.k.a(cls, new b(componentType, a(componentType)));
        } else if (Throwable.class.isAssignableFrom(cls)) {
            this.k.a(cls, new v(cls));
        } else if (TimeZone.class.isAssignableFrom(cls)) {
            this.k.a(cls, be.f6310a);
        } else if (Charset.class.isAssignableFrom(cls)) {
            this.k.a(cls, l.f6325a);
        } else if (Enumeration.class.isAssignableFrom(cls)) {
            this.k.a(cls, u.f6335a);
        } else if (Calendar.class.isAssignableFrom(cls)) {
            this.k.a(cls, i.f6322a);
        } else {
            Class[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            boolean z2 = false;
            int i2 = 0;
            while (true) {
                z = true;
                if (i2 >= length) {
                    break;
                }
                Class cls2 = interfaces[i2];
                if (cls2.getName().equals("net.sf.cglib.proxy.Factory") || cls2.getName().equals("org.springframework.cglib.proxy.Factory")) {
                    z2 = true;
                } else if (cls2.getName().equals("javassist.util.proxy.ProxyObject")) {
                    break;
                } else {
                    i2++;
                }
            }
            z2 = true;
            z = false;
            if (z2 || z) {
                at a2 = a((Class<?>) cls.getSuperclass());
                this.k.a(cls, a2);
                return a2;
            } else if (Proxy.isProxyClass(cls)) {
                this.k.a(cls, ay.a(cls));
            } else {
                this.k.a(cls, ay.a(cls));
            }
        }
        return (at) this.k.a(cls);
    }

    public final void b(Object obj) {
        ax axVar;
        ax axVar2 = this.j;
        if (obj == axVar2.f6296b) {
            this.f6266a.write("{\"$ref\":\"@\"}");
            return;
        }
        ax axVar3 = axVar2.f6295a;
        if (axVar3 == null || obj != axVar3.f6296b) {
            while (axVar2.f6295a != null) {
                axVar2 = axVar2.f6295a;
            }
            if (obj == axVar2.f6296b) {
                this.f6266a.write("{\"$ref\":\"$\"}");
                return;
            }
            IdentityHashMap<Object, ax> identityHashMap = this.n;
            if (identityHashMap == null) {
                axVar = null;
            } else {
                axVar = identityHashMap.get(obj);
            }
            String a2 = axVar.a();
            this.f6266a.write("{\"$ref\":\"");
            this.f6266a.write(a2);
            this.f6266a.write("\"}");
            return;
        }
        this.f6266a.write("{\"$ref\":\"..\"}");
    }
}
