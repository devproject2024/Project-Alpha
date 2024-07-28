package com.paytm.recyclerview;

import androidx.core.g.e;
import com.paytm.recyclerview.RecyclerView;
import com.paytm.recyclerview.d;
import java.util.ArrayList;
import java.util.List;

final class a implements d.a {

    /* renamed from: a  reason: collision with root package name */
    final ArrayList<b> f15291a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayList<b> f15292b;

    /* renamed from: c  reason: collision with root package name */
    final C0205a f15293c;

    /* renamed from: d  reason: collision with root package name */
    Runnable f15294d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f15295e;

    /* renamed from: f  reason: collision with root package name */
    final d f15296f;

    /* renamed from: g  reason: collision with root package name */
    private e.a<b> f15297g;

    /* renamed from: h  reason: collision with root package name */
    private int f15298h;

    /* renamed from: com.paytm.recyclerview.a$a  reason: collision with other inner class name */
    interface C0205a {
        RecyclerView.q a(int i2);

        void a(int i2, int i3);

        void a(int i2, int i3, Object obj);

        void b(int i2, int i3);

        void c(int i2, int i3);

        void d(int i2, int i3);
    }

    a(C0205a aVar) {
        this(aVar, (byte) 0);
    }

    private a(C0205a aVar, byte b2) {
        this.f15297g = new e.b(30);
        this.f15291a = new ArrayList<>();
        this.f15292b = new ArrayList<>();
        this.f15298h = 0;
        this.f15293c = aVar;
        this.f15295e = false;
        this.f15296f = new d(this);
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        a((List<b>) this.f15291a);
        a((List<b>) this.f15292b);
        this.f15298h = 0;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0006 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00af  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
            r16 = this;
            r0 = r16
            com.paytm.recyclerview.d r1 = r0.f15296f
            java.util.ArrayList<com.paytm.recyclerview.a$b> r2 = r0.f15291a
        L_0x0006:
            int r3 = r2.size()
            r4 = 1
            int r3 = r3 - r4
            r6 = 0
        L_0x000d:
            r7 = 8
            r8 = -1
            if (r3 < 0) goto L_0x0023
            java.lang.Object r9 = r2.get(r3)
            com.paytm.recyclerview.a$b r9 = (com.paytm.recyclerview.a.b) r9
            int r9 = r9.f15299a
            if (r9 != r7) goto L_0x001f
            if (r6 == 0) goto L_0x0020
            goto L_0x0024
        L_0x001f:
            r6 = 1
        L_0x0020:
            int r3 = r3 + -1
            goto L_0x000d
        L_0x0023:
            r3 = -1
        L_0x0024:
            r6 = 0
            r9 = 4
            r10 = 2
            if (r3 == r8) goto L_0x0208
            int r7 = r3 + 1
            java.lang.Object r11 = r2.get(r3)
            com.paytm.recyclerview.a$b r11 = (com.paytm.recyclerview.a.b) r11
            java.lang.Object r12 = r2.get(r7)
            com.paytm.recyclerview.a$b r12 = (com.paytm.recyclerview.a.b) r12
            int r13 = r12.f15299a
            if (r13 == r4) goto L_0x01d0
            if (r13 == r10) goto L_0x00b4
            if (r13 == r9) goto L_0x0040
            goto L_0x0006
        L_0x0040:
            int r5 = r11.f15302d
            int r8 = r12.f15300b
            if (r5 >= r8) goto L_0x004c
            int r5 = r12.f15300b
            int r5 = r5 - r4
            r12.f15300b = r5
            goto L_0x0065
        L_0x004c:
            int r5 = r11.f15302d
            int r8 = r12.f15300b
            int r10 = r12.f15302d
            int r8 = r8 + r10
            if (r5 >= r8) goto L_0x0065
            int r5 = r12.f15302d
            int r5 = r5 - r4
            r12.f15302d = r5
            com.paytm.recyclerview.d$a r5 = r1.f15350a
            int r8 = r11.f15300b
            java.lang.Object r10 = r12.f15301c
            com.paytm.recyclerview.a$b r5 = r5.a(r9, r8, r4, r10)
            goto L_0x0066
        L_0x0065:
            r5 = r6
        L_0x0066:
            int r8 = r11.f15300b
            int r10 = r12.f15300b
            if (r8 > r10) goto L_0x0072
            int r8 = r12.f15300b
            int r8 = r8 + r4
            r12.f15300b = r8
            goto L_0x0094
        L_0x0072:
            int r8 = r11.f15300b
            int r10 = r12.f15300b
            int r13 = r12.f15302d
            int r10 = r10 + r13
            if (r8 >= r10) goto L_0x0094
            int r6 = r12.f15300b
            int r8 = r12.f15302d
            int r6 = r6 + r8
            int r8 = r11.f15300b
            int r6 = r6 - r8
            com.paytm.recyclerview.d$a r8 = r1.f15350a
            int r10 = r11.f15300b
            int r10 = r10 + r4
            java.lang.Object r4 = r12.f15301c
            com.paytm.recyclerview.a$b r4 = r8.a(r9, r10, r6, r4)
            int r8 = r12.f15302d
            int r8 = r8 - r6
            r12.f15302d = r8
            goto L_0x0095
        L_0x0094:
            r4 = r6
        L_0x0095:
            r2.set(r7, r11)
            int r6 = r12.f15302d
            if (r6 <= 0) goto L_0x00a0
            r2.set(r3, r12)
            goto L_0x00a8
        L_0x00a0:
            r2.remove(r3)
            com.paytm.recyclerview.d$a r6 = r1.f15350a
            r6.a(r12)
        L_0x00a8:
            if (r5 == 0) goto L_0x00ad
            r2.add(r3, r5)
        L_0x00ad:
            if (r4 == 0) goto L_0x0006
            r2.add(r3, r4)
            goto L_0x0006
        L_0x00b4:
            int r8 = r11.f15300b
            int r9 = r11.f15302d
            if (r8 >= r9) goto L_0x00ce
            int r8 = r12.f15300b
            int r9 = r11.f15300b
            if (r8 != r9) goto L_0x00cb
            int r8 = r12.f15302d
            int r9 = r11.f15302d
            int r13 = r11.f15300b
            int r9 = r9 - r13
            if (r8 != r9) goto L_0x00cb
            r5 = 1
            goto L_0x00cc
        L_0x00cb:
            r5 = 0
        L_0x00cc:
            r8 = 0
            goto L_0x00e2
        L_0x00ce:
            int r8 = r12.f15300b
            int r9 = r11.f15302d
            int r9 = r9 + r4
            if (r8 != r9) goto L_0x00e0
            int r8 = r12.f15302d
            int r9 = r11.f15300b
            int r13 = r11.f15302d
            int r9 = r9 - r13
            if (r8 != r9) goto L_0x00e0
            r5 = 1
            goto L_0x00e1
        L_0x00e0:
            r5 = 0
        L_0x00e1:
            r8 = 1
        L_0x00e2:
            int r9 = r11.f15302d
            int r13 = r12.f15300b
            if (r9 >= r13) goto L_0x00ee
            int r9 = r12.f15300b
            int r9 = r9 - r4
            r12.f15300b = r9
            goto L_0x010e
        L_0x00ee:
            int r9 = r11.f15302d
            int r13 = r12.f15300b
            int r14 = r12.f15302d
            int r13 = r13 + r14
            if (r9 >= r13) goto L_0x010e
            int r3 = r12.f15302d
            int r3 = r3 - r4
            r12.f15302d = r3
            r11.f15299a = r10
            r11.f15302d = r4
            int r3 = r12.f15302d
            if (r3 != 0) goto L_0x0006
            r2.remove(r7)
            com.paytm.recyclerview.d$a r3 = r1.f15350a
            r3.a(r12)
            goto L_0x0006
        L_0x010e:
            int r9 = r11.f15300b
            int r13 = r12.f15300b
            if (r9 > r13) goto L_0x011a
            int r9 = r12.f15300b
            int r9 = r9 + r4
            r12.f15300b = r9
            goto L_0x013b
        L_0x011a:
            int r9 = r11.f15300b
            int r13 = r12.f15300b
            int r14 = r12.f15302d
            int r13 = r13 + r14
            if (r9 >= r13) goto L_0x013b
            int r9 = r12.f15300b
            int r13 = r12.f15302d
            int r9 = r9 + r13
            int r13 = r11.f15300b
            int r9 = r9 - r13
            com.paytm.recyclerview.d$a r13 = r1.f15350a
            int r14 = r11.f15300b
            int r14 = r14 + r4
            com.paytm.recyclerview.a$b r6 = r13.a(r10, r14, r9, r6)
            int r4 = r11.f15300b
            int r9 = r12.f15300b
            int r4 = r4 - r9
            r12.f15302d = r4
        L_0x013b:
            if (r5 == 0) goto L_0x014a
            r2.set(r3, r12)
            r2.remove(r7)
            com.paytm.recyclerview.d$a r3 = r1.f15350a
            r3.a(r11)
            goto L_0x0006
        L_0x014a:
            if (r8 == 0) goto L_0x0183
            if (r6 == 0) goto L_0x0168
            int r4 = r11.f15300b
            int r5 = r6.f15300b
            if (r4 <= r5) goto L_0x015b
            int r4 = r11.f15300b
            int r5 = r6.f15302d
            int r4 = r4 - r5
            r11.f15300b = r4
        L_0x015b:
            int r4 = r11.f15302d
            int r5 = r6.f15300b
            if (r4 <= r5) goto L_0x0168
            int r4 = r11.f15302d
            int r5 = r6.f15302d
            int r4 = r4 - r5
            r11.f15302d = r4
        L_0x0168:
            int r4 = r11.f15300b
            int r5 = r12.f15300b
            if (r4 <= r5) goto L_0x0175
            int r4 = r11.f15300b
            int r5 = r12.f15302d
            int r4 = r4 - r5
            r11.f15300b = r4
        L_0x0175:
            int r4 = r11.f15302d
            int r5 = r12.f15300b
            if (r4 <= r5) goto L_0x01b9
            int r4 = r11.f15302d
            int r5 = r12.f15302d
            int r4 = r4 - r5
            r11.f15302d = r4
            goto L_0x01b9
        L_0x0183:
            if (r6 == 0) goto L_0x019f
            int r4 = r11.f15300b
            int r5 = r6.f15300b
            if (r4 < r5) goto L_0x0192
            int r4 = r11.f15300b
            int r5 = r6.f15302d
            int r4 = r4 - r5
            r11.f15300b = r4
        L_0x0192:
            int r4 = r11.f15302d
            int r5 = r6.f15300b
            if (r4 < r5) goto L_0x019f
            int r4 = r11.f15302d
            int r5 = r6.f15302d
            int r4 = r4 - r5
            r11.f15302d = r4
        L_0x019f:
            int r4 = r11.f15300b
            int r5 = r12.f15300b
            if (r4 < r5) goto L_0x01ac
            int r4 = r11.f15300b
            int r5 = r12.f15302d
            int r4 = r4 - r5
            r11.f15300b = r4
        L_0x01ac:
            int r4 = r11.f15302d
            int r5 = r12.f15300b
            if (r4 < r5) goto L_0x01b9
            int r4 = r11.f15302d
            int r5 = r12.f15302d
            int r4 = r4 - r5
            r11.f15302d = r4
        L_0x01b9:
            r2.set(r3, r12)
            int r4 = r11.f15300b
            int r5 = r11.f15302d
            if (r4 == r5) goto L_0x01c6
            r2.set(r7, r11)
            goto L_0x01c9
        L_0x01c6:
            r2.remove(r7)
        L_0x01c9:
            if (r6 == 0) goto L_0x0006
            r2.add(r3, r6)
            goto L_0x0006
        L_0x01d0:
            int r4 = r11.f15302d
            int r6 = r12.f15300b
            if (r4 >= r6) goto L_0x01d8
            r5 = -1
            goto L_0x01d9
        L_0x01d8:
            r5 = 0
        L_0x01d9:
            int r4 = r11.f15300b
            int r6 = r12.f15300b
            if (r4 >= r6) goto L_0x01e1
            int r5 = r5 + 1
        L_0x01e1:
            int r4 = r12.f15300b
            int r6 = r11.f15300b
            if (r4 > r6) goto L_0x01ee
            int r4 = r11.f15300b
            int r6 = r12.f15302d
            int r4 = r4 + r6
            r11.f15300b = r4
        L_0x01ee:
            int r4 = r12.f15300b
            int r6 = r11.f15302d
            if (r4 > r6) goto L_0x01fb
            int r4 = r11.f15302d
            int r6 = r12.f15302d
            int r4 = r4 + r6
            r11.f15302d = r4
        L_0x01fb:
            int r4 = r12.f15300b
            int r4 = r4 + r5
            r12.f15300b = r4
            r2.set(r3, r12)
            r2.set(r7, r11)
            goto L_0x0006
        L_0x0208:
            java.util.ArrayList<com.paytm.recyclerview.a$b> r1 = r0.f15291a
            int r1 = r1.size()
            r2 = 0
        L_0x020f:
            if (r2 >= r1) goto L_0x02e4
            java.util.ArrayList<com.paytm.recyclerview.a$b> r3 = r0.f15291a
            java.lang.Object r3 = r3.get(r2)
            com.paytm.recyclerview.a$b r3 = (com.paytm.recyclerview.a.b) r3
            int r11 = r3.f15299a
            if (r11 == r4) goto L_0x02d6
            if (r11 == r10) goto L_0x027f
            if (r11 == r9) goto L_0x022a
            if (r11 == r7) goto L_0x0225
            goto L_0x02d9
        L_0x0225:
            r0.c((com.paytm.recyclerview.a.b) r3)
            goto L_0x02d9
        L_0x022a:
            int r11 = r3.f15300b
            int r12 = r3.f15300b
            int r13 = r3.f15302d
            int r12 = r12 + r13
            int r13 = r3.f15300b
            r14 = r11
            r11 = 0
            r15 = -1
        L_0x0236:
            if (r13 >= r12) goto L_0x0268
            com.paytm.recyclerview.a$a r5 = r0.f15293c
            com.paytm.recyclerview.RecyclerView$q r5 = r5.a(r13)
            if (r5 != 0) goto L_0x0256
            boolean r5 = r0.c((int) r13)
            if (r5 == 0) goto L_0x0247
            goto L_0x0256
        L_0x0247:
            if (r15 != r4) goto L_0x0254
            java.lang.Object r5 = r3.f15301c
            com.paytm.recyclerview.a$b r5 = r0.a(r9, r14, r11, r5)
            r0.c((com.paytm.recyclerview.a.b) r5)
            r14 = r13
            r11 = 0
        L_0x0254:
            r15 = 0
            goto L_0x0264
        L_0x0256:
            if (r15 != 0) goto L_0x0263
            java.lang.Object r5 = r3.f15301c
            com.paytm.recyclerview.a$b r5 = r0.a(r9, r14, r11, r5)
            r0.b((com.paytm.recyclerview.a.b) r5)
            r14 = r13
            r11 = 0
        L_0x0263:
            r15 = 1
        L_0x0264:
            int r11 = r11 + r4
            int r13 = r13 + 1
            goto L_0x0236
        L_0x0268:
            int r5 = r3.f15302d
            if (r11 == r5) goto L_0x0275
            java.lang.Object r5 = r3.f15301c
            r0.a((com.paytm.recyclerview.a.b) r3)
            com.paytm.recyclerview.a$b r3 = r0.a(r9, r14, r11, r5)
        L_0x0275:
            if (r15 != 0) goto L_0x027b
            r0.b((com.paytm.recyclerview.a.b) r3)
            goto L_0x02d9
        L_0x027b:
            r0.c((com.paytm.recyclerview.a.b) r3)
            goto L_0x02d9
        L_0x027f:
            int r5 = r3.f15300b
            int r11 = r3.f15300b
            int r12 = r3.f15302d
            int r11 = r11 + r12
            int r12 = r3.f15300b
            r13 = 0
            r14 = -1
        L_0x028a:
            if (r12 >= r11) goto L_0x02c1
            com.paytm.recyclerview.a$a r15 = r0.f15293c
            com.paytm.recyclerview.RecyclerView$q r15 = r15.a(r12)
            if (r15 != 0) goto L_0x02a9
            boolean r15 = r0.c((int) r12)
            if (r15 == 0) goto L_0x029b
            goto L_0x02a9
        L_0x029b:
            if (r14 != r4) goto L_0x02a6
            com.paytm.recyclerview.a$b r14 = r0.a(r10, r5, r13, r6)
            r0.c((com.paytm.recyclerview.a.b) r14)
            r14 = 1
            goto L_0x02a7
        L_0x02a6:
            r14 = 0
        L_0x02a7:
            r15 = 0
            goto L_0x02b6
        L_0x02a9:
            if (r14 != 0) goto L_0x02b4
            com.paytm.recyclerview.a$b r14 = r0.a(r10, r5, r13, r6)
            r0.b((com.paytm.recyclerview.a.b) r14)
            r14 = 1
            goto L_0x02b5
        L_0x02b4:
            r14 = 0
        L_0x02b5:
            r15 = 1
        L_0x02b6:
            if (r14 == 0) goto L_0x02bc
            int r12 = r12 - r13
            int r11 = r11 - r13
            r13 = 1
            goto L_0x02be
        L_0x02bc:
            int r13 = r13 + 1
        L_0x02be:
            int r12 = r12 + r4
            r14 = r15
            goto L_0x028a
        L_0x02c1:
            int r11 = r3.f15302d
            if (r13 == r11) goto L_0x02cc
            r0.a((com.paytm.recyclerview.a.b) r3)
            com.paytm.recyclerview.a$b r3 = r0.a(r10, r5, r13, r6)
        L_0x02cc:
            if (r14 != 0) goto L_0x02d2
            r0.b((com.paytm.recyclerview.a.b) r3)
            goto L_0x02d9
        L_0x02d2:
            r0.c((com.paytm.recyclerview.a.b) r3)
            goto L_0x02d9
        L_0x02d6:
            r0.c((com.paytm.recyclerview.a.b) r3)
        L_0x02d9:
            java.lang.Runnable r3 = r0.f15294d
            if (r3 == 0) goto L_0x02e0
            r3.run()
        L_0x02e0:
            int r2 = r2 + 1
            goto L_0x020f
        L_0x02e4:
            java.util.ArrayList<com.paytm.recyclerview.a$b> r1 = r0.f15291a
            r1.clear()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.recyclerview.a.b():void");
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        int size = this.f15292b.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f15292b.get(i2);
        }
        a((List<b>) this.f15292b);
        this.f15298h = 0;
    }

    private void b(b bVar) {
        int i2;
        if (bVar.f15299a == 1 || bVar.f15299a == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int b2 = b(bVar.f15300b, bVar.f15299a);
        int i3 = bVar.f15300b;
        int i4 = bVar.f15299a;
        if (i4 == 2) {
            i2 = 0;
        } else if (i4 == 4) {
            i2 = 1;
        } else {
            throw new IllegalArgumentException("op should be remove or update.".concat(String.valueOf(bVar)));
        }
        int i5 = b2;
        int i6 = i3;
        int i7 = 1;
        for (int i8 = 1; i8 < bVar.f15302d; i8++) {
            int b3 = b(bVar.f15300b + (i2 * i8), bVar.f15299a);
            int i9 = bVar.f15299a;
            if (i9 == 2 ? b3 == i5 : i9 == 4 && b3 == i5 + 1) {
                i7++;
            } else {
                b a2 = a(bVar.f15299a, i5, i7, bVar.f15301c);
                a(a2, i6);
                a(a2);
                if (bVar.f15299a == 4) {
                    i6 += i7;
                }
                i5 = b3;
                i7 = 1;
            }
        }
        Object obj = bVar.f15301c;
        a(bVar);
        if (i7 > 0) {
            b a3 = a(bVar.f15299a, i5, i7, obj);
            a(a3, i6);
            a(a3);
        }
    }

    private void a(b bVar, int i2) {
        int i3 = bVar.f15299a;
        if (i3 == 2) {
            this.f15293c.a(i2, bVar.f15302d);
        } else if (i3 == 4) {
            this.f15293c.a(i2, bVar.f15302d, bVar.f15301c);
        } else {
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    private int b(int i2, int i3) {
        int i4;
        int i5;
        for (int size = this.f15292b.size() - 1; size >= 0; size--) {
            b bVar = this.f15292b.get(size);
            if (bVar.f15299a == 8) {
                if (bVar.f15300b < bVar.f15302d) {
                    i5 = bVar.f15300b;
                    i4 = bVar.f15302d;
                } else {
                    i5 = bVar.f15302d;
                    i4 = bVar.f15300b;
                }
                if (i2 < i5 || i2 > i4) {
                    if (i2 < bVar.f15300b) {
                        if (i3 == 1) {
                            bVar.f15300b++;
                            bVar.f15302d++;
                        } else if (i3 == 2) {
                            bVar.f15300b--;
                            bVar.f15302d--;
                        }
                    }
                } else if (i5 == bVar.f15300b) {
                    if (i3 == 1) {
                        bVar.f15302d++;
                    } else if (i3 == 2) {
                        bVar.f15302d--;
                    }
                    i2++;
                } else {
                    if (i3 == 1) {
                        bVar.f15300b++;
                    } else if (i3 == 2) {
                        bVar.f15300b--;
                    }
                    i2--;
                }
            } else if (bVar.f15300b <= i2) {
                if (bVar.f15299a == 1) {
                    i2 -= bVar.f15302d;
                } else if (bVar.f15299a == 2) {
                    i2 += bVar.f15302d;
                }
            } else if (i3 == 1) {
                bVar.f15300b++;
            } else if (i3 == 2) {
                bVar.f15300b--;
            }
        }
        for (int size2 = this.f15292b.size() - 1; size2 >= 0; size2--) {
            b bVar2 = this.f15292b.get(size2);
            if (bVar2.f15299a == 8) {
                if (bVar2.f15302d == bVar2.f15300b || bVar2.f15302d < 0) {
                    this.f15292b.remove(size2);
                    a(bVar2);
                }
            } else if (bVar2.f15302d <= 0) {
                this.f15292b.remove(size2);
                a(bVar2);
            }
        }
        return i2;
    }

    private boolean c(int i2) {
        int size = this.f15292b.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.f15292b.get(i3);
            if (bVar.f15299a == 8) {
                if (a(bVar.f15302d, i3 + 1) == i2) {
                    return true;
                }
            } else if (bVar.f15299a == 1) {
                int i4 = bVar.f15300b + bVar.f15302d;
                for (int i5 = bVar.f15300b; i5 < i4; i5++) {
                    if (a(i5, i3 + 1) == i2) {
                        return true;
                    }
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    private void c(b bVar) {
        this.f15292b.add(bVar);
        int i2 = bVar.f15299a;
        if (i2 == 1) {
            this.f15293c.c(bVar.f15300b, bVar.f15302d);
        } else if (i2 == 2) {
            this.f15293c.b(bVar.f15300b, bVar.f15302d);
        } else if (i2 == 4) {
            this.f15293c.a(bVar.f15300b, bVar.f15302d, bVar.f15301c);
        } else if (i2 == 8) {
            this.f15293c.d(bVar.f15300b, bVar.f15302d);
        } else {
            throw new IllegalArgumentException("Unknown update op type for ".concat(String.valueOf(bVar)));
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean d() {
        return this.f15291a.size() > 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(int i2) {
        return (i2 & this.f15298h) != 0;
    }

    /* access modifiers changed from: package-private */
    public final int b(int i2) {
        return a(i2, 0);
    }

    /* access modifiers changed from: package-private */
    public final int a(int i2, int i3) {
        int size = this.f15292b.size();
        while (i3 < size) {
            b bVar = this.f15292b.get(i3);
            if (bVar.f15299a == 8) {
                if (bVar.f15300b == i2) {
                    i2 = bVar.f15302d;
                } else {
                    if (bVar.f15300b < i2) {
                        i2--;
                    }
                    if (bVar.f15302d <= i2) {
                        i2++;
                    }
                }
            } else if (bVar.f15300b > i2) {
                continue;
            } else if (bVar.f15299a == 2) {
                if (i2 < bVar.f15300b + bVar.f15302d) {
                    return -1;
                }
                i2 -= bVar.f15302d;
            } else if (bVar.f15299a == 1) {
                i2 += bVar.f15302d;
            }
            i3++;
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public final void e() {
        c();
        int size = this.f15291a.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.f15291a.get(i2);
            int i3 = bVar.f15299a;
            if (i3 == 1) {
                this.f15293c.c(bVar.f15300b, bVar.f15302d);
            } else if (i3 == 2) {
                this.f15293c.a(bVar.f15300b, bVar.f15302d);
            } else if (i3 == 4) {
                this.f15293c.a(bVar.f15300b, bVar.f15302d, bVar.f15301c);
            } else if (i3 == 8) {
                this.f15293c.d(bVar.f15300b, bVar.f15302d);
            }
            Runnable runnable = this.f15294d;
            if (runnable != null) {
                runnable.run();
            }
        }
        a((List<b>) this.f15291a);
        this.f15298h = 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean f() {
        return !this.f15292b.isEmpty() && !this.f15291a.isEmpty();
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        int f15299a;

        /* renamed from: b  reason: collision with root package name */
        int f15300b;

        /* renamed from: c  reason: collision with root package name */
        Object f15301c;

        /* renamed from: d  reason: collision with root package name */
        int f15302d;

        b(int i2, int i3, int i4, Object obj) {
            this.f15299a = i2;
            this.f15300b = i3;
            this.f15302d = i4;
            this.f15301c = obj;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append("[");
            int i2 = this.f15299a;
            sb.append(i2 != 1 ? i2 != 2 ? i2 != 4 ? i2 != 8 ? "??" : "mv" : "up" : "rm" : "add");
            sb.append(",s:");
            sb.append(this.f15300b);
            sb.append("c:");
            sb.append(this.f15302d);
            sb.append(",p:");
            sb.append(this.f15301c);
            sb.append("]");
            return sb.toString();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            int i2 = this.f15299a;
            if (i2 != bVar.f15299a) {
                return false;
            }
            if (i2 == 8 && Math.abs(this.f15302d - this.f15300b) == 1 && this.f15302d == bVar.f15300b && this.f15300b == bVar.f15302d) {
                return true;
            }
            if (this.f15302d != bVar.f15302d || this.f15300b != bVar.f15300b) {
                return false;
            }
            Object obj2 = this.f15301c;
            if (obj2 != null) {
                if (!obj2.equals(bVar.f15301c)) {
                    return false;
                }
            } else if (bVar.f15301c != null) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return (((this.f15299a * 31) + this.f15300b) * 31) + this.f15302d;
        }
    }

    public final b a(int i2, int i3, int i4, Object obj) {
        b a2 = this.f15297g.a();
        if (a2 == null) {
            return new b(i2, i3, i4, obj);
        }
        a2.f15299a = i2;
        a2.f15300b = i3;
        a2.f15302d = i4;
        a2.f15301c = obj;
        return a2;
    }

    public final void a(b bVar) {
        if (!this.f15295e) {
            bVar.f15301c = null;
            this.f15297g.a(bVar);
        }
    }

    private void a(List<b> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            a(list.get(i2));
        }
        list.clear();
    }
}
