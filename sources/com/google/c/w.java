package com.google.c;

import com.google.c.ac;
import com.google.c.af;
import com.google.c.at;
import com.google.c.bz;
import com.google.c.w.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class w<T extends a<T>> {

    /* renamed from: d  reason: collision with root package name */
    private static final w f37924d = new w((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    final bp<T, Object> f37925a;

    /* renamed from: b  reason: collision with root package name */
    boolean f37926b;

    /* renamed from: c  reason: collision with root package name */
    boolean f37927c;

    public interface a<T extends a<T>> extends Comparable<T> {
        int a();

        at.a a(at.a aVar, at atVar);

        bz.a b();

        bz.b c();

        boolean d();

        boolean e();
    }

    private w() {
        this.f37925a = bp.a(16);
    }

    private w(byte b2) {
        this(bp.a(0));
        b();
    }

    private w(bp<T, Object> bpVar) {
        this.f37925a = bpVar;
        b();
    }

    public static <T extends a<T>> w<T> a() {
        return f37924d;
    }

    public final void b() {
        if (!this.f37926b) {
            this.f37925a.a();
            this.f37926b = true;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        return this.f37925a.equals(((w) obj).f37925a);
    }

    public final int hashCode() {
        return this.f37925a.hashCode();
    }

    public final Iterator<Map.Entry<T, Object>> d() {
        if (this.f37927c) {
            return new af.b(this.f37925a.entrySet().iterator());
        }
        return this.f37925a.entrySet().iterator();
    }

    public final Object a(T t) {
        Object obj = this.f37925a.get(t);
        return obj instanceof af ? ((af) obj).a() : obj;
    }

    public final void a(T t, Object obj) {
        if (!t.d()) {
            a(t.b(), obj);
        } else if (obj instanceof List) {
            ArrayList<Object> arrayList = new ArrayList<>();
            arrayList.addAll((List) obj);
            for (Object a2 : arrayList) {
                a(t.b(), a2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof af) {
            this.f37927c = true;
        }
        this.f37925a.put(t, obj);
    }

    public final void b(T t, Object obj) {
        List list;
        if (t.d()) {
            a(t.b(), obj);
            Object a2 = a(t);
            if (a2 == null) {
                list = new ArrayList();
                this.f37925a.put(t, list);
            } else {
                list = (List) a2;
            }
            list.add(obj);
            return;
        }
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    private static void a(bz.a aVar, Object obj) {
        if (!b(aVar, obj)) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    private static boolean b(bz.a aVar, Object obj) {
        ac.a(obj);
        switch (aVar.getJavaType()) {
            case INT:
                return obj instanceof Integer;
            case LONG:
                return obj instanceof Long;
            case FLOAT:
                return obj instanceof Float;
            case DOUBLE:
                return obj instanceof Double;
            case BOOLEAN:
                return obj instanceof Boolean;
            case STRING:
                return obj instanceof String;
            case BYTE_STRING:
                return (obj instanceof j) || (obj instanceof byte[]);
            case ENUM:
                return (obj instanceof Integer) || (obj instanceof ac.c);
            case MESSAGE:
                return (obj instanceof at) || (obj instanceof af);
            default:
                return false;
        }
    }

    public final boolean e() {
        for (int i2 = 0; i2 < this.f37925a.b(); i2++) {
            if (!c(this.f37925a.b(i2))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> c2 : this.f37925a.c()) {
            if (!c(c2)) {
                return false;
            }
        }
        return true;
    }

    private static <T extends a<T>> boolean c(Map.Entry<T, Object> entry) {
        a aVar = (a) entry.getKey();
        if (aVar.c() == bz.b.MESSAGE) {
            if (aVar.d()) {
                for (at i2 : (List) entry.getValue()) {
                    if (!i2.i()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof at) {
                    if (!((at) value).i()) {
                        return false;
                    }
                } else if (value instanceof af) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    private static Object a(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    /* access modifiers changed from: package-private */
    public final void a(Map.Entry<T, Object> entry) {
        a aVar = (a) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof af) {
            value = ((af) value).a();
        }
        if (aVar.d()) {
            Object a2 = a(aVar);
            if (a2 == null) {
                a2 = new ArrayList();
            }
            for (Object a3 : (List) value) {
                ((List) a2).add(a(a3));
            }
            this.f37925a.put(aVar, a2);
        } else if (aVar.c() == bz.b.MESSAGE) {
            Object a4 = a(aVar);
            if (a4 == null) {
                this.f37925a.put(aVar, a(value));
                return;
            }
            this.f37925a.put(aVar, aVar.a(((at) a4).m(), (at) value).c());
        } else {
            this.f37925a.put(aVar, a(value));
        }
    }

    static void a(m mVar, bz.a aVar, int i2, Object obj) throws IOException {
        if (aVar == bz.a.GROUP) {
            mVar.a(i2, 3);
            ((at) obj).a(mVar);
            mVar.a(i2, 4);
            return;
        }
        mVar.a(i2, aVar.getWireType());
        switch (aVar) {
            case DOUBLE:
                mVar.a(((Double) obj).doubleValue());
                return;
            case FLOAT:
                mVar.a(((Float) obj).floatValue());
                return;
            case INT64:
                mVar.a(((Long) obj).longValue());
                return;
            case UINT64:
                mVar.a(((Long) obj).longValue());
                return;
            case INT32:
                mVar.a(((Integer) obj).intValue());
                return;
            case FIXED64:
                mVar.c(((Long) obj).longValue());
                return;
            case FIXED32:
                mVar.d(((Integer) obj).intValue());
                return;
            case BOOL:
                mVar.a(((Boolean) obj).booleanValue());
                return;
            case GROUP:
                ((at) obj).a(mVar);
                return;
            case MESSAGE:
                mVar.a((at) obj);
                return;
            case STRING:
                if (obj instanceof j) {
                    mVar.a((j) obj);
                    return;
                } else {
                    mVar.a((String) obj);
                    return;
                }
            case BYTES:
                if (obj instanceof j) {
                    mVar.a((j) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                mVar.a(bArr, bArr.length);
                return;
            case UINT32:
                mVar.b(((Integer) obj).intValue());
                return;
            case SFIXED32:
                mVar.d(((Integer) obj).intValue());
                return;
            case SFIXED64:
                mVar.c(((Long) obj).longValue());
                return;
            case SINT32:
                mVar.c(((Integer) obj).intValue());
                return;
            case SINT64:
                mVar.b(((Long) obj).longValue());
                return;
            case ENUM:
                if (obj instanceof ac.c) {
                    mVar.a(((ac.c) obj).a());
                    return;
                } else {
                    mVar.a(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    static int b(Map.Entry<T, Object> entry) {
        a aVar = (a) entry.getKey();
        Object value = entry.getValue();
        if (aVar.c() != bz.b.MESSAGE || aVar.d() || aVar.e()) {
            return c((a<?>) aVar, value);
        }
        if (value instanceof af) {
            return m.b(((a) entry.getKey()).a(), (ag) (af) value);
        }
        return m.b(((a) entry.getKey()).a(), (at) value);
    }

    static int a(bz.a aVar, int i2, Object obj) {
        int l = m.l(i2);
        if (aVar == bz.a.GROUP) {
            l *= 2;
        }
        return l + c(aVar, obj);
    }

    private static int c(bz.a aVar, Object obj) {
        switch (aVar) {
            case DOUBLE:
                ((Double) obj).doubleValue();
                return m.f();
            case FLOAT:
                ((Float) obj).floatValue();
                return m.e();
            case INT64:
                return m.d(((Long) obj).longValue());
            case UINT64:
                return m.e(((Long) obj).longValue());
            case INT32:
                return m.m(((Integer) obj).intValue());
            case FIXED64:
                ((Long) obj).longValue();
                return m.c();
            case FIXED32:
                ((Integer) obj).intValue();
                return m.a();
            case BOOL:
                ((Boolean) obj).booleanValue();
                return m.g();
            case GROUP:
                return m.c((at) obj);
            case MESSAGE:
                if (obj instanceof af) {
                    return m.a((ag) (af) obj);
                }
                return m.b((at) obj);
            case STRING:
                if (obj instanceof j) {
                    return m.b((j) obj);
                }
                return m.b((String) obj);
            case BYTES:
                if (obj instanceof j) {
                    return m.b((j) obj);
                }
                return m.b((byte[]) obj);
            case UINT32:
                return m.n(((Integer) obj).intValue());
            case SFIXED32:
                ((Integer) obj).intValue();
                return m.b();
            case SFIXED64:
                ((Long) obj).longValue();
                return m.d();
            case SINT32:
                return m.o(((Integer) obj).intValue());
            case SINT64:
                return m.f(((Long) obj).longValue());
            case ENUM:
                if (obj instanceof ac.c) {
                    return m.p(((ac.c) obj).a());
                }
                return m.p(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int c(a<?> aVar, Object obj) {
        bz.a b2 = aVar.b();
        int a2 = aVar.a();
        if (!aVar.d()) {
            return a(b2, a2, obj);
        }
        int i2 = 0;
        if (aVar.e()) {
            for (Object c2 : (List) obj) {
                i2 += c(b2, c2);
            }
            return m.l(a2) + i2 + m.r(i2);
        }
        for (Object a3 : (List) obj) {
            i2 += a(b2, a2, a3);
        }
        return i2;
    }

    /* renamed from: c */
    public final w<T> clone() {
        w<T> wVar = new w<>();
        for (int i2 = 0; i2 < this.f37925a.b(); i2++) {
            Map.Entry<T, Object> b2 = this.f37925a.b(i2);
            wVar.a((T) (a) b2.getKey(), b2.getValue());
        }
        for (Map.Entry next : this.f37925a.c()) {
            wVar.a((T) (a) next.getKey(), next.getValue());
        }
        wVar.f37927c = this.f37927c;
        return wVar;
    }
}
