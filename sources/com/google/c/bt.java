package com.google.c;

import java.io.IOException;

abstract class bt<T, B> {
    /* access modifiers changed from: package-private */
    public abstract B a();

    /* access modifiers changed from: package-private */
    public abstract T a(B b2);

    /* access modifiers changed from: package-private */
    public abstract void a(B b2, int i2, int i3);

    /* access modifiers changed from: package-private */
    public abstract void a(B b2, int i2, long j);

    /* access modifiers changed from: package-private */
    public abstract void a(B b2, int i2, j jVar);

    /* access modifiers changed from: package-private */
    public abstract void a(B b2, int i2, T t);

    /* access modifiers changed from: package-private */
    public abstract void a(T t, ca caVar) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void a(Object obj, T t);

    /* access modifiers changed from: package-private */
    public abstract T b(Object obj);

    /* access modifiers changed from: package-private */
    public abstract void b(B b2, int i2, long j);

    /* access modifiers changed from: package-private */
    public abstract void b(T t, ca caVar) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void b(Object obj, B b2);

    /* access modifiers changed from: package-private */
    public abstract B c(Object obj);

    /* access modifiers changed from: package-private */
    public abstract T c(T t, T t2);

    /* access modifiers changed from: package-private */
    public abstract void d(Object obj);

    /* access modifiers changed from: package-private */
    public abstract int e(T t);

    /* access modifiers changed from: package-private */
    public abstract int f(T t);

    bt() {
    }

    /* access modifiers changed from: package-private */
    public final boolean a(B b2, bk bkVar) throws IOException {
        int b3 = bkVar.b();
        int b4 = bz.b(b3);
        int a2 = bz.a(b3);
        if (a2 == 0) {
            a(b2, b4, bkVar.g());
            return true;
        } else if (a2 == 1) {
            b(b2, b4, bkVar.i());
            return true;
        } else if (a2 == 2) {
            a(b2, b4, bkVar.n());
            return true;
        } else if (a2 == 3) {
            Object a3 = a();
            int a4 = bz.a(b4, 4);
            b(a3, bkVar);
            if (a4 == bkVar.b()) {
                a(b2, b4, a(a3));
                return true;
            }
            throw ad.invalidEndTag();
        } else if (a2 == 4) {
            return false;
        } else {
            if (a2 == 5) {
                a(b2, b4, bkVar.j());
                return true;
            }
            throw ad.invalidWireType();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:3:0x000d, LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(B r3, com.google.c.bk r4) throws java.io.IOException {
        /*
            r2 = this;
        L_0x0000:
            int r0 = r4.a()
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r0 == r1) goto L_0x000f
            boolean r0 = r2.a(r3, (com.google.c.bk) r4)
            if (r0 != 0) goto L_0x0000
        L_0x000f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.c.bt.b(java.lang.Object, com.google.c.bk):void");
    }
}
