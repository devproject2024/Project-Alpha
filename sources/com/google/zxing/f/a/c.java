package com.google.zxing.f.a;

import com.google.zxing.b.b;
import com.google.zxing.m;
import com.google.zxing.t;

final class c {

    /* renamed from: a  reason: collision with root package name */
    final b f40430a;

    /* renamed from: b  reason: collision with root package name */
    final t f40431b;

    /* renamed from: c  reason: collision with root package name */
    final t f40432c;

    /* renamed from: d  reason: collision with root package name */
    final t f40433d;

    /* renamed from: e  reason: collision with root package name */
    final t f40434e;

    /* renamed from: f  reason: collision with root package name */
    final int f40435f;

    /* renamed from: g  reason: collision with root package name */
    final int f40436g;

    /* renamed from: h  reason: collision with root package name */
    final int f40437h;

    /* renamed from: i  reason: collision with root package name */
    final int f40438i;

    c(b bVar, t tVar, t tVar2, t tVar3, t tVar4) throws m {
        boolean z = false;
        boolean z2 = tVar == null || tVar2 == null;
        z = (tVar3 == null || tVar4 == null) ? true : z;
        if (!z2 || !z) {
            if (z2) {
                tVar = new t(0.0f, tVar3.f40585b);
                tVar2 = new t(0.0f, tVar4.f40585b);
            } else if (z) {
                tVar3 = new t((float) (bVar.f39889a - 1), tVar.f40585b);
                tVar4 = new t((float) (bVar.f39889a - 1), tVar2.f40585b);
            }
            this.f40430a = bVar;
            this.f40431b = tVar;
            this.f40432c = tVar2;
            this.f40433d = tVar3;
            this.f40434e = tVar4;
            this.f40435f = (int) Math.min(tVar.f40584a, tVar2.f40584a);
            this.f40436g = (int) Math.max(tVar3.f40584a, tVar4.f40584a);
            this.f40437h = (int) Math.min(tVar.f40585b, tVar3.f40585b);
            this.f40438i = (int) Math.max(tVar2.f40585b, tVar4.f40585b);
            return;
        }
        throw m.getNotFoundInstance();
    }

    c(c cVar) {
        this.f40430a = cVar.f40430a;
        this.f40431b = cVar.f40431b;
        this.f40432c = cVar.f40432c;
        this.f40433d = cVar.f40433d;
        this.f40434e = cVar.f40434e;
        this.f40435f = cVar.f40435f;
        this.f40436g = cVar.f40436g;
        this.f40437h = cVar.f40437h;
        this.f40438i = cVar.f40438i;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.zxing.f.a.c a(int r13, int r14, boolean r15) throws com.google.zxing.m {
        /*
            r12 = this;
            com.google.zxing.t r0 = r12.f40431b
            com.google.zxing.t r1 = r12.f40432c
            com.google.zxing.t r2 = r12.f40433d
            com.google.zxing.t r3 = r12.f40434e
            if (r13 <= 0) goto L_0x0025
            if (r15 == 0) goto L_0x000e
            r4 = r0
            goto L_0x000f
        L_0x000e:
            r4 = r2
        L_0x000f:
            float r5 = r4.f40585b
            int r5 = (int) r5
            int r5 = r5 - r13
            if (r5 >= 0) goto L_0x0016
            r5 = 0
        L_0x0016:
            com.google.zxing.t r13 = new com.google.zxing.t
            float r4 = r4.f40584a
            float r5 = (float) r5
            r13.<init>(r4, r5)
            if (r15 == 0) goto L_0x0022
            r8 = r13
            goto L_0x0026
        L_0x0022:
            r10 = r13
            r8 = r0
            goto L_0x0027
        L_0x0025:
            r8 = r0
        L_0x0026:
            r10 = r2
        L_0x0027:
            if (r14 <= 0) goto L_0x004f
            if (r15 == 0) goto L_0x002e
            com.google.zxing.t r13 = r12.f40432c
            goto L_0x0030
        L_0x002e:
            com.google.zxing.t r13 = r12.f40434e
        L_0x0030:
            float r0 = r13.f40585b
            int r0 = (int) r0
            int r0 = r0 + r14
            com.google.zxing.b.b r14 = r12.f40430a
            int r14 = r14.f39890b
            if (r0 < r14) goto L_0x0040
            com.google.zxing.b.b r14 = r12.f40430a
            int r14 = r14.f39890b
            int r0 = r14 + -1
        L_0x0040:
            com.google.zxing.t r14 = new com.google.zxing.t
            float r13 = r13.f40584a
            float r0 = (float) r0
            r14.<init>(r13, r0)
            if (r15 == 0) goto L_0x004c
            r9 = r14
            goto L_0x0050
        L_0x004c:
            r11 = r14
            r9 = r1
            goto L_0x0051
        L_0x004f:
            r9 = r1
        L_0x0050:
            r11 = r3
        L_0x0051:
            com.google.zxing.f.a.c r13 = new com.google.zxing.f.a.c
            com.google.zxing.b.b r7 = r12.f40430a
            r6 = r13
            r6.<init>(r7, r8, r9, r10, r11)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.f.a.c.a(int, int, boolean):com.google.zxing.f.a.c");
    }
}
