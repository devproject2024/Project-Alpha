package com.alibaba.a.b;

import com.alibaba.a.a.c;
import com.alibaba.a.b;
import com.alibaba.a.b.a.ab;
import com.alibaba.a.b.a.ac;
import com.alibaba.a.b.a.ae;
import com.alibaba.a.b.a.af;
import com.alibaba.a.b.a.ag;
import com.alibaba.a.b.a.f;
import com.alibaba.a.b.a.g;
import com.alibaba.a.b.a.j;
import com.alibaba.a.b.a.p;
import com.alibaba.a.b.a.q;
import com.alibaba.a.b.a.r;
import com.alibaba.a.b.a.s;
import com.alibaba.a.b.a.t;
import com.alibaba.a.b.a.v;
import com.alibaba.a.b.a.w;
import com.alibaba.a.b.a.y;
import com.alibaba.a.b.a.z;
import com.alibaba.a.c.aa;
import com.alibaba.a.c.ad;
import com.alibaba.a.c.al;
import com.alibaba.a.c.an;
import com.alibaba.a.c.au;
import com.alibaba.a.c.bd;
import com.alibaba.a.c.be;
import com.alibaba.a.c.bf;
import com.alibaba.a.c.bg;
import com.alibaba.a.c.bh;
import com.alibaba.a.c.d;
import com.alibaba.a.c.k;
import com.alibaba.a.c.l;
import com.alibaba.a.c.o;
import com.alibaba.a.d.e;
import java.io.Closeable;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;

public final class i {

    /* renamed from: c  reason: collision with root package name */
    private static i f6243c = new i();

    /* renamed from: a  reason: collision with root package name */
    public final Set<Class<?>> f6244a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    protected final j f6245b = new j();

    /* renamed from: d  reason: collision with root package name */
    private final e<Type, z> f6246d = new e<>();

    public static i a() {
        return f6243c;
    }

    public i() {
        this.f6244a.add(Boolean.TYPE);
        this.f6244a.add(Boolean.class);
        this.f6244a.add(Character.TYPE);
        this.f6244a.add(Character.class);
        this.f6244a.add(Byte.TYPE);
        this.f6244a.add(Byte.class);
        this.f6244a.add(Short.TYPE);
        this.f6244a.add(Short.class);
        this.f6244a.add(Integer.TYPE);
        this.f6244a.add(Integer.class);
        this.f6244a.add(Long.TYPE);
        this.f6244a.add(Long.class);
        this.f6244a.add(Float.TYPE);
        this.f6244a.add(Float.class);
        this.f6244a.add(Double.TYPE);
        this.f6244a.add(Double.class);
        this.f6244a.add(BigInteger.class);
        this.f6244a.add(BigDecimal.class);
        this.f6244a.add(String.class);
        this.f6244a.add(Date.class);
        this.f6244a.add(java.sql.Date.class);
        this.f6244a.add(Time.class);
        this.f6244a.add(Timestamp.class);
        this.f6246d.a(SimpleDateFormat.class, j.f6194a);
        this.f6246d.a(Timestamp.class, ag.f6184a);
        this.f6246d.a(java.sql.Date.class, ab.f6180a);
        this.f6246d.a(Time.class, af.f6183a);
        this.f6246d.a(Date.class, com.alibaba.a.b.a.i.f6193a);
        this.f6246d.a(Calendar.class, com.alibaba.a.c.i.f6322a);
        this.f6246d.a(com.alibaba.a.e.class, r.f6202a);
        this.f6246d.a(b.class, q.f6201a);
        this.f6246d.a(Map.class, w.f6213a);
        this.f6246d.a(HashMap.class, w.f6213a);
        this.f6246d.a(LinkedHashMap.class, w.f6213a);
        this.f6246d.a(TreeMap.class, w.f6213a);
        this.f6246d.a(ConcurrentMap.class, w.f6213a);
        this.f6246d.a(ConcurrentHashMap.class, w.f6213a);
        this.f6246d.a(Collection.class, g.f6191a);
        this.f6246d.a(List.class, g.f6191a);
        this.f6246d.a(ArrayList.class, g.f6191a);
        this.f6246d.a(Object.class, t.f6208a);
        this.f6246d.a(String.class, bd.f6309a);
        this.f6246d.a(Character.TYPE, k.f6324a);
        this.f6246d.a(Character.class, k.f6324a);
        this.f6246d.a(Byte.TYPE, y.f6216a);
        this.f6246d.a(Byte.class, y.f6216a);
        this.f6246d.a(Short.TYPE, y.f6216a);
        this.f6246d.a(Short.class, y.f6216a);
        this.f6246d.a(Integer.TYPE, ad.f6263a);
        this.f6246d.a(Integer.class, ad.f6263a);
        this.f6246d.a(Long.TYPE, an.f6282a);
        this.f6246d.a(Long.class, an.f6282a);
        this.f6246d.a(BigInteger.class, com.alibaba.a.c.e.f6318a);
        this.f6246d.a(BigDecimal.class, d.f6317a);
        this.f6246d.a(Float.TYPE, com.alibaba.a.c.z.f6342a);
        this.f6246d.a(Float.class, com.alibaba.a.c.z.f6342a);
        this.f6246d.a(Double.TYPE, y.f6216a);
        this.f6246d.a(Double.class, y.f6216a);
        this.f6246d.a(Boolean.TYPE, com.alibaba.a.c.g.f6320a);
        this.f6246d.a(Boolean.class, com.alibaba.a.c.g.f6320a);
        this.f6246d.a(Class.class, f.f6190a);
        this.f6246d.a(char[].class, com.alibaba.a.b.a.e.f6189a);
        this.f6246d.a(UUID.class, bh.f6313a);
        this.f6246d.a(TimeZone.class, be.f6310a);
        this.f6246d.a(Locale.class, al.f6280a);
        this.f6246d.a(Currency.class, o.f6328a);
        this.f6246d.a(InetAddress.class, aa.f6260a);
        this.f6246d.a(Inet4Address.class, aa.f6260a);
        this.f6246d.a(Inet6Address.class, aa.f6260a);
        this.f6246d.a(InetSocketAddress.class, com.alibaba.a.c.ab.f6261a);
        this.f6246d.a(URI.class, bf.f6311a);
        this.f6246d.a(URL.class, bg.f6312a);
        this.f6246d.a(Pattern.class, au.f6294a);
        this.f6246d.a(Charset.class, l.f6325a);
        this.f6246d.a(Number.class, y.f6216a);
        this.f6246d.a(StackTraceElement.class, ac.f6181a);
        this.f6246d.a(Serializable.class, t.f6208a);
        this.f6246d.a(Cloneable.class, t.f6208a);
        this.f6246d.a(Comparable.class, t.f6208a);
        this.f6246d.a(Closeable.class, t.f6208a);
    }

    public final j b() {
        return this.f6245b;
    }

    public final z a(Type type) {
        while (true) {
            z a2 = this.f6246d.a(type);
            if (a2 != null) {
                return a2;
            }
            if (type instanceof Class) {
                return a((Class<?>) (Class) type, type);
            }
            if (!(type instanceof ParameterizedType)) {
                return t.f6208a;
            }
            Type rawType = ((ParameterizedType) type).getRawType();
            if (rawType instanceof Class) {
                return a((Class<?>) (Class) rawType, type);
            }
            type = rawType;
        }
    }

    private z a(Class<?> cls, Type type) {
        z a2;
        z zVar;
        Class<?> e2;
        while (true) {
            z a3 = this.f6246d.a(type);
            if (a3 != null) {
                return a3;
            }
            if (type == null) {
                type = cls;
            }
            a2 = this.f6246d.a(type);
            if (a2 != null) {
                return a2;
            }
            c cVar = (c) cls.getAnnotation(c.class);
            if (cVar != null && (e2 = cVar.e()) != Void.class) {
                cls = e2;
                type = cls;
            }
        }
        if ((type instanceof WildcardType) || (type instanceof TypeVariable) || (type instanceof ParameterizedType)) {
            a2 = this.f6246d.a(cls);
        }
        if (a2 != null) {
            return a2;
        }
        z a4 = this.f6246d.a(type);
        if (a4 != null) {
            return a4;
        }
        if (cls.isEnum()) {
            zVar = new com.alibaba.a.b.a.l(cls);
        } else if (cls.isArray()) {
            zVar = com.alibaba.a.b.a.b.f6185a;
        } else if (cls == Set.class || cls == HashSet.class || cls == Collection.class || cls == List.class || cls == ArrayList.class) {
            zVar = g.f6191a;
        } else if (Collection.class.isAssignableFrom(cls)) {
            zVar = g.f6191a;
        } else if (Map.class.isAssignableFrom(cls)) {
            zVar = w.f6213a;
        } else if (Throwable.class.isAssignableFrom(cls)) {
            zVar = new ae(this, cls);
        } else {
            zVar = b(cls, type);
        }
        a(type, zVar);
        return zVar;
    }

    private z b(Class<?> cls, Type type) {
        return new s(this, cls, type);
    }

    private void a(Type type, z zVar) {
        this.f6246d.a(type, zVar);
    }

    public static Field a(Class<?> cls, String str) {
        Field b2 = b(cls, str);
        if (b2 == null) {
            b2 = b(cls, "_".concat(String.valueOf(str)));
        }
        return b2 == null ? b(cls, "m_".concat(String.valueOf(str))) : b2;
    }

    private static Field b(Class<?> cls, String str) {
        for (Field field : cls.getDeclaredFields()) {
            if (str.equals(field.getName())) {
                return field;
            }
        }
        if (cls.getSuperclass() == null || cls.getSuperclass() == Object.class) {
            return null;
        }
        return a((Class<?>) cls.getSuperclass(), str);
    }

    public final Map<String, com.alibaba.a.b.a.o> a(Class<?> cls) {
        z a2 = a((Type) cls);
        if (a2 instanceof s) {
            return ((s) a2).f6203a;
        }
        return Collections.emptyMap();
    }

    public static com.alibaba.a.b.a.o a(i iVar, Class<?> cls, com.alibaba.a.d.c cVar) {
        Class<?> cls2 = cVar.f6354d;
        if (cls2 == Boolean.TYPE || cls2 == Boolean.class) {
            return new com.alibaba.a.b.a.d(cls, cVar);
        }
        if (cls2 == Integer.TYPE || cls2 == Integer.class) {
            return new p(cls, cVar);
        }
        if (cls2 == Long.TYPE || cls2 == Long.class) {
            return new v(iVar, cls, cVar);
        }
        if (cls2 == String.class) {
            return new com.alibaba.a.b.a.ad(iVar, cls, cVar);
        }
        if (cls2 == List.class || cls2 == ArrayList.class) {
            return new com.alibaba.a.b.a.c(cls, cVar);
        }
        return new com.alibaba.a.b.a.k(cls, cVar);
    }

    public final z a(com.alibaba.a.d.c cVar) {
        return a(cVar.f6354d, cVar.f6355e);
    }
}
