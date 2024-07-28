package com.squareup.b;

import com.business.merchant_payments.common.utility.AppUtility;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.squareup.b.g;
import com.squareup.b.m;
import i.f;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;

public final class h<M extends g> {

    /* renamed from: a  reason: collision with root package name */
    final Class<M> f16060a;

    /* renamed from: b  reason: collision with root package name */
    final l<a> f16061b;

    /* renamed from: c  reason: collision with root package name */
    private final n f16062c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, Integer> f16063d = new LinkedHashMap();

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final int f16066a;

        /* renamed from: b  reason: collision with root package name */
        final String f16067b;

        /* renamed from: c  reason: collision with root package name */
        final g.a f16068c;

        /* renamed from: d  reason: collision with root package name */
        final g.b f16069d;

        /* renamed from: e  reason: collision with root package name */
        final Class<? extends j> f16070e;

        /* renamed from: f  reason: collision with root package name */
        final Class<? extends g> f16071f;

        /* renamed from: g  reason: collision with root package name */
        final boolean f16072g;

        /* renamed from: h  reason: collision with root package name */
        h<? extends g> f16073h;

        /* renamed from: i  reason: collision with root package name */
        b<? extends j> f16074i;
        final Field j;
        final Field k;

        /* synthetic */ a(int i2, String str, g.a aVar, g.b bVar, boolean z, Class cls, Field field, Field field2, byte b2) {
            this(i2, str, aVar, bVar, z, cls, field, field2);
        }

        private a(int i2, String str, g.a aVar, g.b bVar, boolean z, Class<?> cls, Field field, Field field2) {
            this.f16066a = i2;
            this.f16067b = str;
            this.f16068c = aVar;
            this.f16069d = bVar;
            this.f16072g = z;
            if (aVar == g.a.ENUM) {
                this.f16070e = cls;
                this.f16071f = null;
            } else if (aVar == g.a.MESSAGE) {
                this.f16071f = cls;
                this.f16070e = null;
            } else {
                this.f16070e = null;
                this.f16071f = null;
            }
            this.j = field;
            this.k = field2;
        }
    }

    private void a(M m, int i2, Object obj) {
        try {
            this.f16061b.a(i2).k.set(m, obj);
        } catch (IllegalAccessException e2) {
            throw new AssertionError(e2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0075, code lost:
        if (java.lang.Enum.class.isAssignableFrom(r10) != false) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00ac, code lost:
        if (com.squareup.b.g.class.isAssignableFrom(r10) != false) goto L_0x0079;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    h(com.squareup.b.n r19, java.lang.Class<M> r20) {
        /*
            r18 = this;
            r0 = r18
            r18.<init>()
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
            r1.<init>()
            r0.f16063d = r1
            r1 = r19
            r0.f16062c = r1
            r1 = r20
            r0.f16060a = r1
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r2.<init>()
            java.lang.reflect.Field[] r1 = r20.getDeclaredFields()
            int r3 = r1.length
            r4 = 0
            r5 = 0
        L_0x0020:
            if (r5 >= r3) goto L_0x00dd
            r13 = r1[r5]
            java.lang.Class<com.squareup.b.k> r6 = com.squareup.b.k.class
            java.lang.annotation.Annotation r6 = r13.getAnnotation(r6)
            com.squareup.b.k r6 = (com.squareup.b.k) r6
            if (r6 == 0) goto L_0x00d4
            int r7 = r6.a()
            java.lang.String r8 = r13.getName()
            java.util.Map<java.lang.String, java.lang.Integer> r9 = r0.f16063d
            java.lang.Integer r10 = java.lang.Integer.valueOf(r7)
            r9.put(r8, r10)
            com.squareup.b.g$a r9 = r6.b()
            com.squareup.b.g$a r10 = com.squareup.b.g.a.ENUM
            r11 = 0
            if (r9 != r10) goto L_0x007b
            java.lang.Class r10 = r13.getType()
            java.lang.Class<java.lang.Enum> r12 = java.lang.Enum.class
            boolean r12 = r12.isAssignableFrom(r10)
            if (r12 == 0) goto L_0x0055
            goto L_0x0079
        L_0x0055:
            java.lang.Class<java.util.List> r12 = java.util.List.class
            boolean r10 = r12.isAssignableFrom(r10)
            if (r10 == 0) goto L_0x0078
            java.lang.reflect.Type r10 = r13.getGenericType()
            java.lang.reflect.ParameterizedType r10 = (java.lang.reflect.ParameterizedType) r10
            java.lang.reflect.Type[] r10 = r10.getActualTypeArguments()
            r10 = r10[r4]
            boolean r12 = r10 instanceof java.lang.Class
            if (r12 == 0) goto L_0x0078
            java.lang.Class<java.lang.Enum> r12 = java.lang.Enum.class
            java.lang.Class r10 = (java.lang.Class) r10
            boolean r12 = r12.isAssignableFrom(r10)
            if (r12 == 0) goto L_0x0078
            goto L_0x0079
        L_0x0078:
            r10 = r11
        L_0x0079:
            r12 = r10
            goto L_0x00b0
        L_0x007b:
            com.squareup.b.g$a r10 = com.squareup.b.g.a.MESSAGE
            if (r9 != r10) goto L_0x00af
            java.lang.Class r10 = r13.getType()
            java.lang.Class<com.squareup.b.g> r12 = com.squareup.b.g.class
            boolean r12 = r12.isAssignableFrom(r10)
            if (r12 == 0) goto L_0x008c
            goto L_0x0079
        L_0x008c:
            java.lang.Class<java.util.List> r12 = java.util.List.class
            boolean r10 = r12.isAssignableFrom(r10)
            if (r10 == 0) goto L_0x0078
            java.lang.reflect.Type r10 = r13.getGenericType()
            java.lang.reflect.ParameterizedType r10 = (java.lang.reflect.ParameterizedType) r10
            java.lang.reflect.Type[] r10 = r10.getActualTypeArguments()
            r10 = r10[r4]
            boolean r12 = r10 instanceof java.lang.Class
            if (r12 == 0) goto L_0x0078
            java.lang.Class<com.squareup.b.g> r12 = com.squareup.b.g.class
            java.lang.Class r10 = (java.lang.Class) r10
            boolean r12 = r12.isAssignableFrom(r10)
            if (r12 == 0) goto L_0x0078
            goto L_0x0079
        L_0x00af:
            r12 = r11
        L_0x00b0:
            java.lang.Integer r15 = java.lang.Integer.valueOf(r7)
            com.squareup.b.h$a r14 = new com.squareup.b.h$a
            com.squareup.b.g$b r10 = r6.c()
            boolean r11 = r6.d()
            java.lang.reflect.Field r16 = r0.a((java.lang.String) r8)
            r17 = 0
            r6 = r14
            r4 = r14
            r14 = r16
            r20 = r1
            r1 = r15
            r15 = r17
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r2.put(r1, r4)
            goto L_0x00d6
        L_0x00d4:
            r20 = r1
        L_0x00d6:
            int r5 = r5 + 1
            r1 = r20
            r4 = 0
            goto L_0x0020
        L_0x00dd:
            com.squareup.b.l r1 = com.squareup.b.l.a(r2)
            r0.f16061b = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.b.h.<init>(com.squareup.b.n, java.lang.Class):void");
    }

    private Field a(String str) {
        try {
            return this.f16060a.getField(str);
        } catch (NoSuchFieldException unused) {
            throw new AssertionError("No builder field " + this.f16060a.getName() + AppUtility.CENTER_DOT + str);
        }
    }

    private int a(List<?> list, int i2, g.a aVar) {
        int i3 = 0;
        for (Object a2 : list) {
            i3 += a(i2, (Object) a2, aVar);
        }
        return i3;
    }

    private int b(List<?> list, int i2, g.a aVar) {
        int i3 = 0;
        for (Object a2 : list) {
            i3 += a((Object) a2, aVar);
        }
        return p.c(p.a(i2, q.LENGTH_DELIMITED)) + p.c(i3) + i3;
    }

    private void a(p pVar, List<?> list, int i2, g.a aVar) throws IOException {
        for (Object a2 : list) {
            a(pVar, i2, (Object) a2, aVar);
        }
    }

    private void b(p pVar, List<?> list, int i2, g.a aVar) throws IOException {
        int i3 = 0;
        for (Object a2 : list) {
            i3 += a((Object) a2, aVar);
        }
        pVar.b(i2, q.LENGTH_DELIMITED);
        pVar.e(i3);
        for (Object a3 : list) {
            a(pVar, (Object) a3, aVar);
        }
    }

    public final byte[] b(M m) {
        byte[] bArr = new byte[a(m)];
        try {
            a(m, new p(bArr, bArr.length));
            return bArr;
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    private int a(int i2, Object obj, g.a aVar) {
        return p.b(i2) + a(obj, aVar);
    }

    private int a(Object obj, g.a aVar) {
        int b2;
        int c2;
        switch (aVar) {
            case INT32:
                return p.a(((Integer) obj).intValue());
            case INT64:
            case UINT64:
                return p.a(((Long) obj).longValue());
            case UINT32:
                return p.c(((Integer) obj).intValue());
            case SINT32:
                return p.c(p.g(((Integer) obj).intValue()));
            case SINT64:
                return p.a(p.d(((Long) obj).longValue()));
            case BOOL:
                return 1;
            case ENUM:
                return a((j) obj);
            case STRING:
                b2 = b((String) obj);
                c2 = p.c(b2);
                break;
            case BYTES:
                b2 = ((f) obj).size();
                c2 = p.c(b2);
                break;
            case MESSAGE:
                return c((g) obj);
            case FIXED32:
            case SFIXED32:
            case FLOAT:
                return 4;
            case FIXED64:
            case SFIXED64:
            case DOUBLE:
                return 8;
            default:
                throw new RuntimeException();
        }
        return c2 + b2;
    }

    private static int b(String str) {
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            if (charAt <= 127) {
                i3++;
            } else if (charAt <= 2047) {
                i3 += 2;
            } else if (Character.isHighSurrogate(charAt)) {
                i3 += 4;
                i2++;
            } else {
                i3 += 3;
            }
            i2++;
        }
        return i3;
    }

    private <E extends j> int a(E e2) {
        this.f16062c.c(e2.getClass());
        return p.c(b.a(e2));
    }

    private static <M extends g> int c(M m) {
        int a2 = m.a();
        return p.c(a2) + a2;
    }

    private void a(p pVar, int i2, Object obj, g.a aVar) throws IOException {
        pVar.b(i2, aVar.wireType());
        a(pVar, obj, aVar);
    }

    private void a(p pVar, Object obj, g.a aVar) throws IOException {
        switch (aVar) {
            case INT32:
                pVar.d(((Integer) obj).intValue());
                return;
            case INT64:
            case UINT64:
                pVar.b(((Long) obj).longValue());
                return;
            case UINT32:
                pVar.e(((Integer) obj).intValue());
                return;
            case SINT32:
                pVar.e(p.g(((Integer) obj).intValue()));
                return;
            case SINT64:
                pVar.b(p.d(((Long) obj).longValue()));
                return;
            case BOOL:
                pVar.a(((Boolean) obj).booleanValue() ? (byte) 1 : 0);
                return;
            case ENUM:
                a((j) obj, pVar);
                return;
            case STRING:
                byte[] bytes = ((String) obj).getBytes(AppConstants.UTF_8);
                pVar.e(bytes.length);
                pVar.a(bytes, bytes.length);
                return;
            case BYTES:
                f fVar = (f) obj;
                pVar.e(fVar.size());
                byte[] byteArray = fVar.toByteArray();
                pVar.a(byteArray, byteArray.length);
                return;
            case MESSAGE:
                b((g) obj, pVar);
                return;
            case FIXED32:
            case SFIXED32:
                pVar.f(((Integer) obj).intValue());
                return;
            case FLOAT:
                pVar.f(Float.floatToIntBits(((Float) obj).floatValue()));
                return;
            case FIXED64:
            case SFIXED64:
                pVar.c(((Long) obj).longValue());
                return;
            case DOUBLE:
                pVar.c(Double.doubleToLongBits(((Double) obj).doubleValue()));
                return;
            default:
                throw new RuntimeException();
        }
    }

    private <M extends g> void b(M m, p pVar) throws IOException {
        pVar.e(m.a());
        this.f16062c.a(m.getClass()).a(m, pVar);
    }

    private <E extends j> void a(E e2, p pVar) throws IOException {
        this.f16062c.c(e2.getClass());
        pVar.e(b.a(e2));
    }

    public final M a(o oVar) throws IOException {
        Set<Integer> set;
        g.a aVar;
        g.b bVar;
        try {
            M m = (g) this.f16060a.newInstance();
            c cVar = new c((byte) 0);
            while (true) {
                d<c<?>, ?> dVar = null;
                int a2 = oVar.a();
                int i2 = a2 >> 3;
                q valueOf = q.valueOf(a2);
                if (i2 == 0) {
                    if (cVar.f16075a == null) {
                        set = Collections.emptySet();
                    } else {
                        set = cVar.f16075a.keySet();
                    }
                    for (Integer intValue : set) {
                        int intValue2 = intValue.intValue();
                        if (this.f16061b.b(intValue2)) {
                            a(m, intValue2, (Object) cVar.a(intValue2));
                        } else {
                            ((c) m).a(a(intValue2), cVar.a(intValue2));
                        }
                    }
                    return m;
                }
                a a3 = this.f16061b.a(i2);
                if (a3 != null) {
                    aVar = a3.f16068c;
                    bVar = a3.f16069d;
                } else {
                    dVar = a(i2);
                    if (dVar == null) {
                        switch (valueOf) {
                            case VARINT:
                                m.c().a(i2, Long.valueOf(oVar.c()));
                                break;
                            case FIXED32:
                                m c2 = m.c();
                                m.a(c2.a(), i2, Integer.valueOf(oVar.d()), q.FIXED32);
                                break;
                            case FIXED64:
                                m c3 = m.c();
                                m.a(c3.a(), i2, Long.valueOf(oVar.e()), q.FIXED64);
                                break;
                            case LENGTH_DELIMITED:
                                int b2 = oVar.b();
                                m c4 = m.c();
                                m.a(c4.a(), i2, oVar.b(b2), q.LENGTH_DELIMITED);
                                break;
                            case START_GROUP:
                                oVar.f();
                                break;
                            case END_GROUP:
                                break;
                            default:
                                throw new RuntimeException("Unsupported wire type: ".concat(String.valueOf(valueOf)));
                        }
                    } else {
                        aVar = dVar.f16051f;
                        bVar = dVar.f16052g;
                    }
                }
                if (!bVar.isPacked() || valueOf != q.LENGTH_DELIMITED) {
                    Object a4 = a(oVar, i2, aVar);
                    if (aVar == g.a.ENUM && (a4 instanceof Integer)) {
                        m.a(i2, (long) ((Integer) a4).intValue());
                    } else if (bVar.isRepeated()) {
                        cVar.a(i2, a4);
                    } else if (dVar != null) {
                        ((c) m).a(dVar, a4);
                    } else {
                        a(m, i2, a4);
                    }
                } else {
                    int b3 = oVar.b();
                    long j = (long) oVar.f16096c;
                    int d2 = oVar.d(b3);
                    while (true) {
                        long j2 = ((long) b3) + j;
                        if (((long) oVar.f16096c) < j2) {
                            Object a5 = a(oVar, i2, aVar);
                            if (aVar != g.a.ENUM || !(a5 instanceof Integer)) {
                                cVar.a(i2, a5);
                            } else {
                                m.a(i2, (long) ((Integer) a5).intValue());
                            }
                        } else {
                            oVar.f16097d = d2;
                            if (((long) oVar.f16096c) != j2) {
                                throw new IOException("Packed data had wrong length!");
                            }
                        }
                    }
                }
            }
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException(e3);
        }
    }

    private Object a(o oVar, int i2, g.a aVar) throws IOException {
        b bVar;
        d<c<?>, ?> a2;
        h hVar;
        d<c<?>, ?> a3;
        Class cls = null;
        boolean z = false;
        switch (aVar) {
            case INT32:
            case UINT32:
                return Integer.valueOf(oVar.b());
            case INT64:
            case UINT64:
                return Long.valueOf(oVar.c());
            case SINT32:
                return Integer.valueOf(o.c(oVar.b()));
            case SINT64:
                return Long.valueOf(o.a(oVar.c()));
            case BOOL:
                if (oVar.b() != 0) {
                    z = true;
                }
                return Boolean.valueOf(z);
            case ENUM:
                a a4 = this.f16061b.a(i2);
                if (a4 == null || a4.f16074i == null) {
                    n nVar = this.f16062c;
                    a a5 = this.f16061b.a(i2);
                    if (a5 != null) {
                        cls = a5.f16070e;
                    }
                    if (cls == null && (a2 = a(i2)) != null) {
                        cls = a2.f16048c;
                    }
                    bVar = nVar.c(cls);
                    if (a4 != null) {
                        a4.f16074i = bVar;
                    }
                } else {
                    bVar = a4.f16074i;
                }
                int b2 = oVar.b();
                try {
                    return bVar.a(b2);
                } catch (IllegalArgumentException unused) {
                    return Integer.valueOf(b2);
                }
            case STRING:
                int b3 = oVar.b();
                oVar.f16096c += b3;
                return oVar.f16095b.a((long) b3, o.f16094a);
            case BYTES:
                return oVar.b(oVar.b());
            case MESSAGE:
                int b4 = oVar.b();
                if (oVar.f16098e < 64) {
                    int d2 = oVar.d(b4);
                    oVar.f16098e++;
                    a a6 = this.f16061b.a(i2);
                    if (a6 == null || a6.f16073h == null) {
                        n nVar2 = this.f16062c;
                        a a7 = this.f16061b.a(i2);
                        if (a7 != null) {
                            cls = a7.f16071f;
                        }
                        if (cls == null && (a3 = a(i2)) != null) {
                            cls = a3.f16047b;
                        }
                        hVar = nVar2.a(cls);
                        if (a6 != null) {
                            a6.f16073h = hVar;
                        }
                    } else {
                        hVar = a6.f16073h;
                    }
                    g a8 = hVar.a(oVar);
                    oVar.a(0);
                    oVar.f16098e--;
                    oVar.f16097d = d2;
                    return a8;
                }
                throw new IOException("Wire recursion limit exceeded");
            case FIXED32:
            case SFIXED32:
                return Integer.valueOf(oVar.d());
            case FLOAT:
                return Float.valueOf(Float.intBitsToFloat(oVar.d()));
            case FIXED64:
            case SFIXED64:
                return Long.valueOf(oVar.e());
            case DOUBLE:
                return Double.valueOf(Double.longBitsToDouble(oVar.e()));
            default:
                throw new RuntimeException();
        }
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        Map<Integer, b<Object>> f16075a;

        private c() {
        }

        /* synthetic */ c(byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public final void a(int i2, Object obj) {
            Map<Integer, b<Object>> map = this.f16075a;
            b bVar = map == null ? null : map.get(Integer.valueOf(i2));
            if (bVar == null) {
                bVar = new b();
                if (this.f16075a == null) {
                    this.f16075a = new LinkedHashMap();
                }
                this.f16075a.put(Integer.valueOf(i2), bVar);
            }
            bVar.list.add(obj);
        }

        /* access modifiers changed from: package-private */
        public final List<Object> a(int i2) {
            Map<Integer, b<Object>> map = this.f16075a;
            if (map == null) {
                return null;
            }
            return map.get(Integer.valueOf(i2));
        }
    }

    private d<c<?>, ?> a(int i2) {
        f fVar = this.f16062c.f16089a;
        if (fVar == null) {
            return null;
        }
        return fVar.a(this.f16060a, i2);
    }

    static class b<T> extends AbstractList<T> implements Serializable, Cloneable, RandomAccess {
        /* access modifiers changed from: private */
        public final List<T> list = new ArrayList();

        public final Object clone() {
            return this;
        }

        b() {
        }

        public final int size() {
            return this.list.size();
        }

        public final T get(int i2) {
            return this.list.get(i2);
        }
    }

    static Object a(M m, a aVar) {
        if (aVar.j != null) {
            try {
                return aVar.j.get(m);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        } else {
            throw new AssertionError("Field is not of type \"Message\"");
        }
    }

    /* access modifiers changed from: package-private */
    public final int a(M m) {
        int i2;
        int i3 = 0;
        for (T t : this.f16061b.f16077a) {
            Object a2 = a(m, (a) t);
            if (a2 != null) {
                int i4 = t.f16066a;
                g.a aVar = t.f16068c;
                g.b bVar = t.f16069d;
                if (!bVar.isRepeated()) {
                    i2 = a(i4, a2, aVar);
                } else if (bVar.isPacked()) {
                    i2 = b((List) a2, i4, aVar);
                } else {
                    i2 = a((List<?>) (List) a2, i4, aVar);
                }
                i3 += i2;
            }
        }
        if (m instanceof c) {
            c cVar = (c) m;
            if (cVar.f16045a != null) {
                i3 += a(cVar.f16045a);
            }
        }
        return i3 + m.b();
    }

    private <T extends c<?>> int a(e<T> eVar) {
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < eVar.f16054b; i4++) {
            d<T, ?> a2 = eVar.a(i4);
            Object b2 = eVar.b(i4);
            int i5 = a2.f16050e;
            g.a aVar = a2.f16051f;
            g.b bVar = a2.f16052g;
            if (!bVar.isRepeated()) {
                i2 = a(i5, b2, aVar);
            } else if (bVar.isPacked()) {
                i2 = b((List) b2, i5, aVar);
            } else {
                i2 = a((List<?>) (List) b2, i5, aVar);
            }
            i3 += i2;
        }
        return i3;
    }

    private void a(M m, p pVar) throws IOException {
        for (T t : this.f16061b.f16077a) {
            Object a2 = a(m, (a) t);
            if (a2 != null) {
                int i2 = t.f16066a;
                g.a aVar = t.f16068c;
                g.b bVar = t.f16069d;
                if (!bVar.isRepeated()) {
                    a(pVar, i2, a2, aVar);
                } else if (bVar.isPacked()) {
                    b(pVar, (List) a2, i2, aVar);
                } else {
                    a(pVar, (List<?>) (List) a2, i2, aVar);
                }
            }
        }
        if (m instanceof c) {
            c cVar = (c) m;
            if (cVar.f16045a != null) {
                e<T> eVar = cVar.f16045a;
                for (int i3 = 0; i3 < eVar.f16054b; i3++) {
                    d<T, ?> a3 = eVar.a(i3);
                    Object b2 = eVar.b(i3);
                    int i4 = a3.f16050e;
                    g.a aVar2 = a3.f16051f;
                    g.b bVar2 = a3.f16052g;
                    if (!bVar2.isRepeated()) {
                        a(pVar, i4, b2, aVar2);
                    } else if (bVar2.isPacked()) {
                        b(pVar, (List) b2, i4, aVar2);
                    } else {
                        a(pVar, (List<?>) (List) b2, i4, aVar2);
                    }
                }
            }
        }
        if (m.v != null) {
            m mVar = m.v;
            if (mVar.f16081a != null) {
                for (Map.Entry next : mVar.f16081a.entrySet()) {
                    int intValue = ((Integer) next.getKey()).intValue();
                    for (m.a a4 : (List) next.getValue()) {
                        a4.a(intValue, pVar);
                    }
                }
            }
        }
    }
}
