package androidx.a;

public final class h<E> implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f961a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public boolean f962b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f963c;

    /* renamed from: d  reason: collision with root package name */
    public int f964d;

    /* renamed from: e  reason: collision with root package name */
    private int[] f965e;

    public h() {
        this(10);
    }

    public h(int i2) {
        this.f962b = false;
        if (i2 == 0) {
            this.f965e = c.f931a;
            this.f963c = c.f933c;
            return;
        }
        int a2 = c.a(i2);
        this.f965e = new int[a2];
        this.f963c = new Object[a2];
    }

    /* renamed from: a */
    public final h<E> clone() {
        try {
            h<E> hVar = (h) super.clone();
            hVar.f965e = (int[]) this.f965e.clone();
            hVar.f963c = (Object[]) this.f963c.clone();
            return hVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public final E a(int i2, E e2) {
        int a2 = c.a(this.f965e, this.f964d, i2);
        if (a2 >= 0) {
            E[] eArr = this.f963c;
            if (eArr[a2] != f961a) {
                return eArr[a2];
            }
        }
        return e2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = r3.f963c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r4) {
        /*
            r3 = this;
            int[] r0 = r3.f965e
            int r1 = r3.f964d
            int r4 = androidx.a.c.a((int[]) r0, (int) r1, (int) r4)
            if (r4 < 0) goto L_0x0017
            java.lang.Object[] r0 = r3.f963c
            r1 = r0[r4]
            java.lang.Object r2 = f961a
            if (r1 == r2) goto L_0x0017
            r0[r4] = r2
            r4 = 1
            r3.f962b = r4
        L_0x0017:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.a.h.a(int):void");
    }

    private void c() {
        int i2 = this.f964d;
        int[] iArr = this.f965e;
        Object[] objArr = this.f963c;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != f961a) {
                if (i4 != i3) {
                    iArr[i3] = iArr[i4];
                    objArr[i3] = obj;
                    objArr[i4] = null;
                }
                i3++;
            }
        }
        this.f962b = false;
        this.f964d = i3;
    }

    public final void b(int i2, E e2) {
        int a2 = c.a(this.f965e, this.f964d, i2);
        if (a2 >= 0) {
            this.f963c[a2] = e2;
            return;
        }
        int i3 = ~a2;
        if (i3 < this.f964d) {
            Object[] objArr = this.f963c;
            if (objArr[i3] == f961a) {
                this.f965e[i3] = i2;
                objArr[i3] = e2;
                return;
            }
        }
        if (this.f962b && this.f964d >= this.f965e.length) {
            c();
            i3 = ~c.a(this.f965e, this.f964d, i2);
        }
        int i4 = this.f964d;
        if (i4 >= this.f965e.length) {
            int a3 = c.a(i4 + 1);
            int[] iArr = new int[a3];
            Object[] objArr2 = new Object[a3];
            int[] iArr2 = this.f965e;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f963c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f965e = iArr;
            this.f963c = objArr2;
        }
        int i5 = this.f964d;
        if (i5 - i3 != 0) {
            int[] iArr3 = this.f965e;
            int i6 = i3 + 1;
            System.arraycopy(iArr3, i3, iArr3, i6, i5 - i3);
            Object[] objArr4 = this.f963c;
            System.arraycopy(objArr4, i3, objArr4, i6, this.f964d - i3);
        }
        this.f965e[i3] = i2;
        this.f963c[i3] = e2;
        this.f964d++;
    }

    public final int b() {
        if (this.f962b) {
            c();
        }
        return this.f964d;
    }

    public final int b(int i2) {
        if (this.f962b) {
            c();
        }
        return this.f965e[i2];
    }

    public final E c(int i2) {
        if (this.f962b) {
            c();
        }
        return this.f963c[i2];
    }

    public final int d(int i2) {
        if (this.f962b) {
            c();
        }
        return c.a(this.f965e, this.f964d, i2);
    }

    public final int a(E e2) {
        if (this.f962b) {
            c();
        }
        for (int i2 = 0; i2 < this.f964d; i2++) {
            if (this.f963c[i2] == e2) {
                return i2;
            }
        }
        return -1;
    }

    public final void c(int i2, E e2) {
        int i3 = this.f964d;
        if (i3 == 0 || i2 > this.f965e[i3 - 1]) {
            if (this.f962b && this.f964d >= this.f965e.length) {
                c();
            }
            int i4 = this.f964d;
            if (i4 >= this.f965e.length) {
                int a2 = c.a(i4 + 1);
                int[] iArr = new int[a2];
                Object[] objArr = new Object[a2];
                int[] iArr2 = this.f965e;
                System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
                Object[] objArr2 = this.f963c;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.f965e = iArr;
                this.f963c = objArr;
            }
            this.f965e[i4] = i2;
            this.f963c[i4] = e2;
            this.f964d = i4 + 1;
            return;
        }
        b(i2, e2);
    }

    public final String toString() {
        if (b() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f964d * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f964d; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(b(i2));
            sb.append('=');
            Object c2 = c(i2);
            if (c2 != this) {
                sb.append(c2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
