package com.google.a.a.a;

import com.google.a.a.b.a.a.a.a.c;
import com.google.a.a.c.b;
import com.google.a.a.c.f;
import com.google.a.a.c.j;
import com.google.a.a.c.k;
import com.google.a.a.c.m;
import com.google.a.a.c.u;
import com.google.a.a.c.v;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class g extends k {
    @m(a = "Authorization")

    /* renamed from: a  reason: collision with root package name */
    List<String> f7481a;
    @m(a = "Content-Type")

    /* renamed from: b  reason: collision with root package name */
    List<String> f7482b;
    @m(a = "If-Modified-Since")

    /* renamed from: c  reason: collision with root package name */
    List<String> f7483c;
    @m(a = "If-Match")

    /* renamed from: d  reason: collision with root package name */
    List<String> f7484d;
    @m(a = "If-None-Match")

    /* renamed from: e  reason: collision with root package name */
    List<String> f7485e;
    @m(a = "If-Unmodified-Since")

    /* renamed from: f  reason: collision with root package name */
    List<String> f7486f;
    @m(a = "If-Range")

    /* renamed from: g  reason: collision with root package name */
    List<String> f7487g;
    @m(a = "Location")

    /* renamed from: h  reason: collision with root package name */
    List<String> f7488h;
    @m(a = "User-Agent")

    /* renamed from: i  reason: collision with root package name */
    List<String> f7489i;
    @m(a = "Accept-Encoding")
    private List<String> l = new ArrayList(Collections.singleton("gzip"));

    public g() {
        super(EnumSet.of(k.c.IGNORE_CASE));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public g a(String str, Object obj) {
        return (g) super.a(str, obj);
    }

    public final g a(String str) {
        this.f7489i = a(str);
        return this;
    }

    private static void a(Logger logger, StringBuilder sb, StringBuilder sb2, r rVar, String str, Object obj) throws IOException {
        String str2;
        if (obj != null && !com.google.a.a.c.g.a(obj)) {
            if (obj instanceof Enum) {
                str2 = j.a((Enum<?>) (Enum) obj).f7598c;
            } else {
                str2 = obj.toString();
            }
            String str3 = (("Authorization".equalsIgnoreCase(str) || "Cookie".equalsIgnoreCase(str)) && (logger == null || !logger.isLoggable(Level.ALL))) ? "<Not Logged>" : str2;
            if (sb != null) {
                sb.append(str);
                sb.append(": ");
                sb.append(str3);
                sb.append(u.f7617a);
            }
            if (sb2 != null) {
                sb2.append(" -H '");
                sb2.append(str);
                sb2.append(": ");
                sb2.append(str3);
                sb2.append("'");
            }
            if (rVar != null) {
                rVar.a(str, str2);
            }
        }
    }

    public final void a(s sVar, StringBuilder sb) throws IOException {
        Type type;
        clear();
        a aVar = new a(this, sb);
        int g2 = sVar.g();
        for (int i2 = 0; i2 < g2; i2++) {
            String a2 = sVar.a(i2);
            String b2 = sVar.b(i2);
            List<Type> list = aVar.f7493d;
            f fVar = aVar.f7492c;
            b bVar = aVar.f7490a;
            StringBuilder sb2 = aVar.f7491b;
            if (sb2 != null) {
                sb2.append(a2 + ": " + b2);
                sb2.append(u.f7617a);
            }
            j a3 = fVar.a(a2);
            if (a3 != null) {
                Type a4 = com.google.a.a.c.g.a(list, a3.f7597b.getGenericType());
                if (v.a(a4)) {
                    Class<?> a5 = v.a(list, v.b(a4));
                    bVar.a(a3.f7597b, a5, a(a5, list, b2));
                } else if (v.a(v.a(list, a4), (Class<?>) Iterable.class)) {
                    Collection<Object> collection = (Collection) a3.a((Object) this);
                    if (collection == null) {
                        collection = com.google.a.a.c.g.b(a4);
                        a3.a((Object) this, (Object) collection);
                    }
                    if (a4 == Object.class) {
                        type = null;
                    } else {
                        type = v.a(a4, (Class<?>) Iterable.class);
                    }
                    collection.add(a(type, list, b2));
                } else {
                    a3.a((Object) this, a(a4, list, b2));
                }
            } else {
                ArrayList arrayList = (ArrayList) get(a2);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    a(a2, arrayList);
                }
                arrayList.add(b2);
            }
        }
        aVar.f7490a.a();
    }

    static <T> T a(List<T> list) {
        if (list == null) {
            return null;
        }
        return list.get(0);
    }

    static <T> List<T> a(T t) {
        if (t == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(t);
        return arrayList;
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        final b f7490a;

        /* renamed from: b  reason: collision with root package name */
        final StringBuilder f7491b;

        /* renamed from: c  reason: collision with root package name */
        final f f7492c;

        /* renamed from: d  reason: collision with root package name */
        final List<Type> f7493d;

        public a(g gVar, StringBuilder sb) {
            Class<?> cls = gVar.getClass();
            this.f7493d = Arrays.asList(new Type[]{cls});
            this.f7492c = f.a(cls, true);
            this.f7491b = sb;
            this.f7490a = new b(gVar);
        }
    }

    private static Object a(Type type, List<Type> list, String str) {
        return com.google.a.a.c.g.a(com.google.a.a.c.g.a(list, type), str);
    }

    static void a(g gVar, StringBuilder sb, StringBuilder sb2, Logger logger, r rVar) throws IOException {
        HashSet hashSet = new HashSet();
        for (Map.Entry next : gVar.entrySet()) {
            String str = (String) next.getKey();
            c.a(hashSet.add(str), "multiple headers of the same name (headers are case insensitive): %s", str);
            Object value = next.getValue();
            g gVar2 = gVar;
            if (value != null) {
                j a2 = gVar2.k.a(str);
                if (a2 != null) {
                    str = a2.f7598c;
                }
                Class<?> cls = value.getClass();
                if ((value instanceof Iterable) || cls.isArray()) {
                    for (Object a3 : v.a(value)) {
                        a(logger, sb, sb2, rVar, str, a3);
                    }
                } else {
                    a(logger, sb, sb2, rVar, str, value);
                }
            }
        }
    }

    public final /* bridge */ /* synthetic */ k b() {
        return (g) super.clone();
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return (g) super.clone();
    }
}
