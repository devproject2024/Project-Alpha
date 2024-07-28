package io.reactivex.rxjava3.e.k;

import io.reactivex.rxjava3.d.q;

public final class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public final int f47731a = 4;

    /* renamed from: b  reason: collision with root package name */
    public final Object[] f47732b = new Object[5];

    /* renamed from: c  reason: collision with root package name */
    Object[] f47733c = this.f47732b;

    /* renamed from: d  reason: collision with root package name */
    int f47734d;

    /* renamed from: io.reactivex.rxjava3.e.k.a$a  reason: collision with other inner class name */
    public interface C0826a<T> extends q<T> {
        boolean test(T t);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(T r4) {
        /*
            r3 = this;
            int r0 = r3.f47731a
            int r1 = r3.f47734d
            if (r1 != r0) goto L_0x0011
            int r1 = r0 + 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.Object[] r2 = r3.f47733c
            r2[r0] = r1
            r3.f47733c = r1
            r1 = 0
        L_0x0011:
            java.lang.Object[] r0 = r3.f47733c
            r0[r1] = r4
            int r1 = r1 + 1
            r3.f47734d = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.e.k.a.a(java.lang.Object):void");
    }

    public final void a(C0826a<? super T> aVar) {
        int i2 = this.f47731a;
        for (Object[] objArr = this.f47732b; objArr != null; objArr = objArr[i2]) {
            int i3 = 0;
            while (i3 < i2) {
                Object[] objArr2 = objArr[i3];
                if (objArr2 == null) {
                    continue;
                    break;
                } else if (!aVar.test(objArr2)) {
                    i3++;
                } else {
                    return;
                }
            }
        }
    }
}
