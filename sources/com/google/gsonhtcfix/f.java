package com.google.gsonhtcfix;

import com.google.gsonhtcfix.b.a.g;
import com.google.gsonhtcfix.b.a.h;
import com.google.gsonhtcfix.b.a.i;
import com.google.gsonhtcfix.b.a.j;
import com.google.gsonhtcfix.b.a.l;
import com.google.gsonhtcfix.b.c;
import com.google.gsonhtcfix.b.d;
import com.google.gsonhtcfix.d.b;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    final j f39797a;

    /* renamed from: b  reason: collision with root package name */
    final t f39798b;

    /* renamed from: c  reason: collision with root package name */
    private final ThreadLocal<Map<com.google.gsonhtcfix.c.a<?>, a<?>>> f39799c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<com.google.gsonhtcfix.c.a<?>, y<?>> f39800d;

    /* renamed from: e  reason: collision with root package name */
    private final List<z> f39801e;

    /* renamed from: f  reason: collision with root package name */
    private final c f39802f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f39803g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f39804h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f39805i;
    private final boolean j;

    public f() {
        this(d.f39738a, d.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, w.DEFAULT, Collections.emptyList());
    }

    f(d dVar, e eVar, Map<Type, h<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, w wVar, List<z> list) {
        y yVar;
        y yVar2;
        y yVar3;
        this.f39799c = new ThreadLocal<>();
        this.f39800d = Collections.synchronizedMap(new HashMap());
        this.f39797a = new j() {
        };
        this.f39798b = new t() {
        };
        this.f39802f = new c(map);
        this.f39803g = z;
        this.f39805i = z3;
        this.f39804h = z4;
        this.j = z5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(l.Q);
        arrayList.add(g.f39667a);
        arrayList.add(dVar);
        arrayList.addAll(list);
        arrayList.add(l.x);
        arrayList.add(l.m);
        arrayList.add(l.f39697g);
        arrayList.add(l.f39699i);
        arrayList.add(l.k);
        Class cls = Long.TYPE;
        Class<Long> cls2 = Long.class;
        if (wVar == w.DEFAULT) {
            yVar = l.n;
        } else {
            yVar = new y<Number>() {
                public final /* synthetic */ void a(com.google.gsonhtcfix.d.c cVar, Object obj) throws IOException {
                    Number number = (Number) obj;
                    if (number == null) {
                        cVar.e();
                    } else {
                        cVar.b(number.toString());
                    }
                }

                public final /* synthetic */ Object a(com.google.gsonhtcfix.d.a aVar) throws IOException {
                    if (aVar.f() != b.NULL) {
                        return Long.valueOf(aVar.m());
                    }
                    aVar.k();
                    return null;
                }
            };
        }
        arrayList.add(l.a(cls, cls2, yVar));
        Class cls3 = Double.TYPE;
        Class<Double> cls4 = Double.class;
        if (z6) {
            yVar2 = l.p;
        } else {
            yVar2 = new y<Number>() {
                public final /* synthetic */ void a(com.google.gsonhtcfix.d.c cVar, Object obj) throws IOException {
                    Number number = (Number) obj;
                    if (number == null) {
                        cVar.e();
                        return;
                    }
                    f.a(number.doubleValue());
                    cVar.a(number);
                }

                public final /* synthetic */ Object a(com.google.gsonhtcfix.d.a aVar) throws IOException {
                    if (aVar.f() != b.NULL) {
                        return Double.valueOf(aVar.l());
                    }
                    aVar.k();
                    return null;
                }
            };
        }
        arrayList.add(l.a(cls3, cls4, yVar2));
        Class cls5 = Float.TYPE;
        Class<Float> cls6 = Float.class;
        if (z6) {
            yVar3 = l.o;
        } else {
            yVar3 = new y<Number>() {
                public final /* synthetic */ void a(com.google.gsonhtcfix.d.c cVar, Object obj) throws IOException {
                    Number number = (Number) obj;
                    if (number == null) {
                        cVar.e();
                        return;
                    }
                    f.a((double) number.floatValue());
                    cVar.a(number);
                }

                public final /* synthetic */ Object a(com.google.gsonhtcfix.d.a aVar) throws IOException {
                    if (aVar.f() != b.NULL) {
                        return Float.valueOf((float) aVar.l());
                    }
                    aVar.k();
                    return null;
                }
            };
        }
        arrayList.add(l.a(cls5, cls6, yVar3));
        arrayList.add(l.r);
        arrayList.add(l.t);
        arrayList.add(l.z);
        arrayList.add(l.B);
        arrayList.add(l.a(BigDecimal.class, l.v));
        arrayList.add(l.a(BigInteger.class, l.w));
        arrayList.add(l.D);
        arrayList.add(l.F);
        arrayList.add(l.J);
        arrayList.add(l.O);
        arrayList.add(l.H);
        arrayList.add(l.f39694d);
        arrayList.add(com.google.gsonhtcfix.b.a.c.f39649a);
        arrayList.add(l.M);
        arrayList.add(j.f39686a);
        arrayList.add(i.f39684a);
        arrayList.add(l.K);
        arrayList.add(com.google.gsonhtcfix.b.a.a.f39643a);
        arrayList.add(l.R);
        arrayList.add(l.f39692b);
        arrayList.add(new com.google.gsonhtcfix.b.a.b(this.f39802f));
        arrayList.add(new com.google.gsonhtcfix.b.a.f(this.f39802f, z2));
        arrayList.add(new h(this.f39802f, eVar, dVar));
        this.f39801e = Collections.unmodifiableList(arrayList);
    }

    public final <T> y<T> a(com.google.gsonhtcfix.c.a<T> aVar) {
        y<T> yVar = this.f39800d.get(aVar);
        if (yVar != null) {
            return yVar;
        }
        Map map = this.f39799c.get();
        boolean z = false;
        if (map == null) {
            map = new HashMap();
            this.f39799c.set(map);
            z = true;
        }
        a aVar2 = (a) map.get(aVar);
        if (aVar2 != null) {
            return aVar2;
        }
        try {
            a aVar3 = new a();
            map.put(aVar, aVar3);
            for (z a2 : this.f39801e) {
                y<T> a3 = a2.a(this, aVar);
                if (a3 != null) {
                    if (aVar3.f39811a == null) {
                        aVar3.f39811a = a3;
                        this.f39800d.put(aVar, a3);
                        return a3;
                    }
                    throw new AssertionError();
                }
            }
            throw new IllegalArgumentException("GSON cannot handle ".concat(String.valueOf(aVar)));
        } finally {
            map.remove(aVar);
            if (z) {
                this.f39799c.remove();
            }
        }
    }

    public final <T> y<T> a(z zVar, com.google.gsonhtcfix.c.a<T> aVar) {
        boolean z = false;
        for (z next : this.f39801e) {
            if (z) {
                y<T> a2 = next.a(this, aVar);
                if (a2 != null) {
                    return a2;
                }
            } else if (next == zVar) {
                z = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize ".concat(String.valueOf(aVar)));
    }

    public final <T> y<T> a(Class<T> cls) {
        return a(com.google.gsonhtcfix.c.a.get(cls));
    }

    public final String a(Object obj) {
        if (obj == null) {
            return a((l) n.f39822a);
        }
        return a(obj, (Type) obj.getClass());
    }

    public final String a(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        a(obj, type, (Appendable) stringWriter);
        return stringWriter.toString();
    }

    private void a(Object obj, Type type, Appendable appendable) throws m {
        try {
            a(obj, type, a(com.google.gsonhtcfix.b.j.a(appendable)));
        } catch (IOException e2) {
            throw new m((Throwable) e2);
        }
    }

    private void a(Object obj, Type type, com.google.gsonhtcfix.d.c cVar) throws m {
        y<?> a2 = a(com.google.gsonhtcfix.c.a.get(type));
        boolean z = cVar.f39790c;
        cVar.f39790c = true;
        boolean z2 = cVar.f39791d;
        cVar.f39791d = this.f39804h;
        boolean z3 = cVar.f39792e;
        cVar.f39792e = this.f39803g;
        try {
            a2.a(cVar, obj);
            cVar.f39790c = z;
            cVar.f39791d = z2;
            cVar.f39792e = z3;
        } catch (IOException e2) {
            throw new m((Throwable) e2);
        } catch (Throwable th) {
            cVar.f39790c = z;
            cVar.f39791d = z2;
            cVar.f39792e = z3;
            throw th;
        }
    }

    public final String a(l lVar) {
        StringWriter stringWriter = new StringWriter();
        a(lVar, (Appendable) stringWriter);
        return stringWriter.toString();
    }

    private void a(l lVar, Appendable appendable) throws m {
        try {
            a(lVar, a(com.google.gsonhtcfix.b.j.a(appendable)));
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    private com.google.gsonhtcfix.d.c a(Writer writer) throws IOException {
        if (this.f39805i) {
            writer.write(")]}'\n");
        }
        com.google.gsonhtcfix.d.c cVar = new com.google.gsonhtcfix.d.c(writer);
        if (this.j) {
            cVar.c("  ");
        }
        cVar.f39792e = this.f39803g;
        return cVar;
    }

    public final <T> T a(String str, Class<T> cls) throws v {
        return com.google.gsonhtcfix.b.i.a(cls).cast(a(str, (Type) cls));
    }

    public final <T> T a(String str, Type type) throws v {
        if (str == null) {
            return null;
        }
        return a((Reader) new StringReader(str), type);
    }

    public final <T> T a(Reader reader, Class<T> cls) throws v, m {
        com.google.gsonhtcfix.d.a aVar = new com.google.gsonhtcfix.d.a(reader);
        T a2 = a(aVar, (Type) cls);
        a((Object) a2, aVar);
        return com.google.gsonhtcfix.b.i.a(cls).cast(a2);
    }

    private <T> T a(Reader reader, Type type) throws m, v {
        com.google.gsonhtcfix.d.a aVar = new com.google.gsonhtcfix.d.a(reader);
        T a2 = a(aVar, type);
        a((Object) a2, aVar);
        return a2;
    }

    private static void a(Object obj, com.google.gsonhtcfix.d.a aVar) {
        if (obj != null) {
            try {
                if (aVar.f() != b.END_DOCUMENT) {
                    throw new m("JSON document was not fully consumed.");
                }
            } catch (com.google.gsonhtcfix.d.d e2) {
                throw new v((Throwable) e2);
            } catch (IOException e3) {
                throw new m((Throwable) e3);
            }
        }
    }

    static class a<T> extends y<T> {

        /* renamed from: a  reason: collision with root package name */
        y<T> f39811a;

        a() {
        }

        public final T a(com.google.gsonhtcfix.d.a aVar) throws IOException {
            y<T> yVar = this.f39811a;
            if (yVar != null) {
                return yVar.a(aVar);
            }
            throw new IllegalStateException();
        }

        public final void a(com.google.gsonhtcfix.d.c cVar, T t) throws IOException {
            y<T> yVar = this.f39811a;
            if (yVar != null) {
                yVar.a(cVar, t);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public final String toString() {
        return "{serializeNulls:" + this.f39803g + "factories:" + this.f39801e + ",instanceCreators:" + this.f39802f + "}";
    }

    private void a(l lVar, com.google.gsonhtcfix.d.c cVar) throws m {
        boolean z = cVar.f39790c;
        cVar.f39790c = true;
        boolean z2 = cVar.f39791d;
        cVar.f39791d = this.f39804h;
        boolean z3 = cVar.f39792e;
        cVar.f39792e = this.f39803g;
        try {
            com.google.gsonhtcfix.b.j.a(lVar, cVar);
            cVar.f39790c = z;
            cVar.f39791d = z2;
            cVar.f39792e = z3;
        } catch (IOException e2) {
            throw new m((Throwable) e2);
        } catch (Throwable th) {
            cVar.f39790c = z;
            cVar.f39791d = z2;
            cVar.f39792e = z3;
            throw th;
        }
    }

    private <T> T a(com.google.gsonhtcfix.d.a aVar, Type type) throws m, v {
        boolean z = aVar.f39780b;
        aVar.f39780b = true;
        try {
            aVar.f();
            T a2 = a(com.google.gsonhtcfix.c.a.get(type)).a(aVar);
            aVar.f39780b = z;
            return a2;
        } catch (EOFException e2) {
            if (1 != 0) {
                aVar.f39780b = z;
                return null;
            }
            throw new v((Throwable) e2);
        } catch (IllegalStateException e3) {
            throw new v((Throwable) e3);
        } catch (IOException e4) {
            throw new v((Throwable) e4);
        } catch (Throwable th) {
            aVar.f39780b = z;
            throw th;
        }
    }

    static /* synthetic */ void a(double d2) {
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            throw new IllegalArgumentException(d2 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }
}
