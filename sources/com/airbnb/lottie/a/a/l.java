package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.os.Build;
import com.airbnb.lottie.c.b.h;
import java.util.ArrayList;
import java.util.List;

public final class l implements j, m {

    /* renamed from: a  reason: collision with root package name */
    private final Path f5695a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final Path f5696b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private final Path f5697c = new Path();

    /* renamed from: d  reason: collision with root package name */
    private final String f5698d;

    /* renamed from: e  reason: collision with root package name */
    private final List<m> f5699e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private final h f5700f;

    public l(h hVar) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f5698d = hVar.f5865a;
            this.f5700f = hVar;
            return;
        }
        throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:3:0x000a, LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.util.ListIterator<com.airbnb.lottie.a.a.c> r3) {
        /*
            r2 = this;
        L_0x0000:
            boolean r0 = r3.hasPrevious()
            if (r0 == 0) goto L_0x000c
            java.lang.Object r0 = r3.previous()
            if (r0 != r2) goto L_0x0000
        L_0x000c:
            boolean r0 = r3.hasPrevious()
            if (r0 == 0) goto L_0x0027
            java.lang.Object r0 = r3.previous()
            com.airbnb.lottie.a.a.c r0 = (com.airbnb.lottie.a.a.c) r0
            boolean r1 = r0 instanceof com.airbnb.lottie.a.a.m
            if (r1 == 0) goto L_0x000c
            java.util.List<com.airbnb.lottie.a.a.m> r1 = r2.f5699e
            com.airbnb.lottie.a.a.m r0 = (com.airbnb.lottie.a.a.m) r0
            r1.add(r0)
            r3.remove()
            goto L_0x000c
        L_0x0027:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.a.a.l.a(java.util.ListIterator):void");
    }

    public final void a(List<c> list, List<c> list2) {
        for (int i2 = 0; i2 < this.f5699e.size(); i2++) {
            this.f5699e.get(i2).a(list, list2);
        }
    }

    public final Path e() {
        this.f5697c.reset();
        if (this.f5700f.f5867c) {
            return this.f5697c;
        }
        int i2 = AnonymousClass1.f5701a[this.f5700f.f5866b.ordinal()];
        if (i2 == 1) {
            for (int i3 = 0; i3 < this.f5699e.size(); i3++) {
                this.f5697c.addPath(this.f5699e.get(i3).e());
            }
        } else if (i2 == 2) {
            a(Path.Op.UNION);
        } else if (i2 == 3) {
            a(Path.Op.REVERSE_DIFFERENCE);
        } else if (i2 == 4) {
            a(Path.Op.INTERSECT);
        } else if (i2 == 5) {
            a(Path.Op.XOR);
        }
        return this.f5697c;
    }

    /* renamed from: com.airbnb.lottie.a.a.l$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5701a = new int[h.a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                com.airbnb.lottie.c.b.h$a[] r0 = com.airbnb.lottie.c.b.h.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5701a = r0
                int[] r0 = f5701a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.airbnb.lottie.c.b.h$a r1 = com.airbnb.lottie.c.b.h.a.MERGE     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f5701a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.airbnb.lottie.c.b.h$a r1 = com.airbnb.lottie.c.b.h.a.ADD     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f5701a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.airbnb.lottie.c.b.h$a r1 = com.airbnb.lottie.c.b.h.a.SUBTRACT     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f5701a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.airbnb.lottie.c.b.h$a r1 = com.airbnb.lottie.c.b.h.a.INTERSECT     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = f5701a     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.airbnb.lottie.c.b.h$a r1 = com.airbnb.lottie.c.b.h.a.EXCLUDE_INTERSECTIONS     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.a.a.l.AnonymousClass1.<clinit>():void");
        }
    }

    public final String b() {
        return this.f5698d;
    }

    private void a(Path.Op op) {
        this.f5696b.reset();
        this.f5695a.reset();
        for (int size = this.f5699e.size() - 1; size > 0; size--) {
            m mVar = this.f5699e.get(size);
            if (mVar instanceof d) {
                d dVar = (d) mVar;
                List<m> c2 = dVar.c();
                for (int size2 = c2.size() - 1; size2 >= 0; size2--) {
                    Path e2 = c2.get(size2).e();
                    e2.transform(dVar.d());
                    this.f5696b.addPath(e2);
                }
            } else {
                this.f5696b.addPath(mVar.e());
            }
        }
        m mVar2 = this.f5699e.get(0);
        if (mVar2 instanceof d) {
            d dVar2 = (d) mVar2;
            List<m> c3 = dVar2.c();
            for (int i2 = 0; i2 < c3.size(); i2++) {
                Path e3 = c3.get(i2).e();
                e3.transform(dVar2.d());
                this.f5695a.addPath(e3);
            }
        } else {
            this.f5695a.set(mVar2.e());
        }
        this.f5697c.op(this.f5695a, this.f5696b, op);
    }
}
