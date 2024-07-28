package com.squareup.b;

import i.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

final class m {

    /* renamed from: a  reason: collision with root package name */
    Map<Integer, List<a>> f16081a;

    static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        final q f16083a;

        /* renamed from: b  reason: collision with root package name */
        private final int f16084b;

        public abstract int a();

        public abstract void a(int i2, p pVar) throws IOException;

        public a(int i2, q qVar) {
            this.f16084b = i2;
            this.f16083a = qVar;
        }

        public static e a(int i2, Long l) {
            return new e(i2, l);
        }

        public static b a(int i2, Integer num) {
            return new b(i2, num);
        }

        public static c b(int i2, Long l) {
            return new c(i2, l);
        }

        public static d a(int i2, f fVar) {
            return new d(i2, fVar);
        }
    }

    static final class e extends a {

        /* renamed from: b  reason: collision with root package name */
        private final Long f16088b;

        public e(int i2, Long l) {
            super(i2, q.VARINT);
            this.f16088b = l;
        }

        public final int a() {
            return p.a(this.f16088b.longValue());
        }

        public final void a(int i2, p pVar) throws IOException {
            pVar.b(i2, q.VARINT);
            pVar.b(this.f16088b.longValue());
        }
    }

    static final class b extends a {

        /* renamed from: b  reason: collision with root package name */
        private final Integer f16085b;

        public final int a() {
            return 4;
        }

        public b(int i2, Integer num) {
            super(i2, q.FIXED32);
            this.f16085b = num;
        }

        public final void a(int i2, p pVar) throws IOException {
            pVar.b(i2, q.FIXED32);
            pVar.f(this.f16085b.intValue());
        }
    }

    static final class c extends a {

        /* renamed from: b  reason: collision with root package name */
        private final Long f16086b;

        public final int a() {
            return 8;
        }

        public c(int i2, Long l) {
            super(i2, q.FIXED64);
            this.f16086b = l;
        }

        public final void a(int i2, p pVar) throws IOException {
            pVar.b(i2, q.FIXED64);
            pVar.c(this.f16086b.longValue());
        }
    }

    static final class d extends a {

        /* renamed from: b  reason: collision with root package name */
        private final f f16087b;

        public d(int i2, f fVar) {
            super(i2, q.LENGTH_DELIMITED);
            this.f16087b = fVar;
        }

        public final int a() {
            return p.c(this.f16087b.size()) + this.f16087b.size();
        }

        public final void a(int i2, p pVar) throws IOException {
            pVar.b(i2, q.LENGTH_DELIMITED);
            pVar.e(this.f16087b.size());
            byte[] byteArray = this.f16087b.toByteArray();
            pVar.a(byteArray, byteArray.length);
        }
    }

    m() {
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, Long l) throws IOException {
        a(a(), i2, l, q.VARINT);
    }

    /* access modifiers changed from: package-private */
    public final Map<Integer, List<a>> a() {
        if (this.f16081a == null) {
            this.f16081a = new TreeMap();
        }
        return this.f16081a;
    }

    static <T> void a(Map<Integer, List<a>> map, int i2, T t, q qVar) throws IOException {
        a aVar;
        List list = map.get(Integer.valueOf(i2));
        if (list == null) {
            list = new ArrayList();
            map.put(Integer.valueOf(i2), list);
        }
        int i3 = AnonymousClass1.f16082a[qVar.ordinal()];
        if (i3 == 1) {
            aVar = a.a(i2, (Long) t);
        } else if (i3 == 2) {
            aVar = a.a(i2, (Integer) t);
        } else if (i3 == 3) {
            aVar = a.b(i2, (Long) t);
        } else if (i3 == 4) {
            aVar = a.a(i2, (f) t);
        } else {
            throw new IllegalArgumentException("Unsupported wireType = ".concat(String.valueOf(qVar)));
        }
        if (list.size() <= 0 || ((a) list.get(0)).f16083a == aVar.f16083a) {
            list.add(aVar);
        } else {
            throw new IOException(String.format("Wire type %s differs from previous type %s for tag %s", new Object[]{aVar.f16083a, ((a) list.get(0)).f16083a, Integer.valueOf(i2)}));
        }
    }

    /* renamed from: com.squareup.b.m$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f16082a = new int[q.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                com.squareup.b.q[] r0 = com.squareup.b.q.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f16082a = r0
                int[] r0 = f16082a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.squareup.b.q r1 = com.squareup.b.q.VARINT     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f16082a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.squareup.b.q r1 = com.squareup.b.q.FIXED32     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f16082a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.squareup.b.q r1 = com.squareup.b.q.FIXED64     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f16082a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.squareup.b.q r1 = com.squareup.b.q.LENGTH_DELIMITED     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.b.m.AnonymousClass1.<clinit>():void");
        }
    }
}
