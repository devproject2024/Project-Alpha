package androidx.a;

public final class d<E> implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f934a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public boolean f935b;

    /* renamed from: c  reason: collision with root package name */
    public long[] f936c;

    /* renamed from: d  reason: collision with root package name */
    public Object[] f937d;

    /* renamed from: e  reason: collision with root package name */
    public int f938e;

    public d() {
        this(10);
    }

    public d(int i2) {
        this.f935b = false;
        if (i2 == 0) {
            this.f936c = c.f932b;
            this.f937d = c.f933c;
            return;
        }
        int b2 = c.b(i2);
        this.f936c = new long[b2];
        this.f937d = new Object[b2];
    }

    /* renamed from: a */
    public final d<E> clone() {
        try {
            d<E> dVar = (d) super.clone();
            dVar.f936c = (long[]) this.f936c.clone();
            dVar.f937d = (Object[]) this.f937d.clone();
            return dVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public final E a(long j, E e2) {
        int a2 = c.a(this.f936c, this.f938e, j);
        if (a2 >= 0) {
            E[] eArr = this.f937d;
            if (eArr[a2] != f934a) {
                return eArr[a2];
            }
        }
        return e2;
    }

    public final void a(int i2) {
        Object[] objArr = this.f937d;
        Object obj = objArr[i2];
        Object obj2 = f934a;
        if (obj != obj2) {
            objArr[i2] = obj2;
            this.f935b = true;
        }
    }

    private void e() {
        int i2 = this.f938e;
        long[] jArr = this.f936c;
        Object[] objArr = this.f937d;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != f934a) {
                if (i4 != i3) {
                    jArr[i3] = jArr[i4];
                    objArr[i3] = obj;
                    objArr[i4] = null;
                }
                i3++;
            }
        }
        this.f935b = false;
        this.f938e = i3;
    }

    public final void b(long j, E e2) {
        int a2 = c.a(this.f936c, this.f938e, j);
        if (a2 >= 0) {
            this.f937d[a2] = e2;
            return;
        }
        int i2 = ~a2;
        if (i2 < this.f938e) {
            Object[] objArr = this.f937d;
            if (objArr[i2] == f934a) {
                this.f936c[i2] = j;
                objArr[i2] = e2;
                return;
            }
        }
        if (this.f935b && this.f938e >= this.f936c.length) {
            e();
            i2 = ~c.a(this.f936c, this.f938e, j);
        }
        int i3 = this.f938e;
        if (i3 >= this.f936c.length) {
            int b2 = c.b(i3 + 1);
            long[] jArr = new long[b2];
            Object[] objArr2 = new Object[b2];
            long[] jArr2 = this.f936c;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f937d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f936c = jArr;
            this.f937d = objArr2;
        }
        int i4 = this.f938e;
        if (i4 - i2 != 0) {
            long[] jArr3 = this.f936c;
            int i5 = i2 + 1;
            System.arraycopy(jArr3, i2, jArr3, i5, i4 - i2);
            Object[] objArr4 = this.f937d;
            System.arraycopy(objArr4, i2, objArr4, i5, this.f938e - i2);
        }
        this.f936c[i2] = j;
        this.f937d[i2] = e2;
        this.f938e++;
    }

    public final int b() {
        if (this.f935b) {
            e();
        }
        return this.f938e;
    }

    public final boolean c() {
        return b() == 0;
    }

    public final long b(int i2) {
        if (this.f935b) {
            e();
        }
        return this.f936c[i2];
    }

    public final E c(int i2) {
        if (this.f935b) {
            e();
        }
        return this.f937d[i2];
    }

    public final int a(long j) {
        if (this.f935b) {
            e();
        }
        return c.a(this.f936c, this.f938e, j);
    }

    public final void d() {
        int i2 = this.f938e;
        Object[] objArr = this.f937d;
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = null;
        }
        this.f938e = 0;
        this.f935b = false;
    }

    public final void c(long j, E e2) {
        int i2 = this.f938e;
        if (i2 == 0 || j > this.f936c[i2 - 1]) {
            if (this.f935b && this.f938e >= this.f936c.length) {
                e();
            }
            int i3 = this.f938e;
            if (i3 >= this.f936c.length) {
                int b2 = c.b(i3 + 1);
                long[] jArr = new long[b2];
                Object[] objArr = new Object[b2];
                long[] jArr2 = this.f936c;
                System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
                Object[] objArr2 = this.f937d;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.f936c = jArr;
                this.f937d = objArr;
            }
            this.f936c[i3] = j;
            this.f937d[i3] = e2;
            this.f938e = i3 + 1;
            return;
        }
        b(j, e2);
    }

    public final String toString() {
        if (b() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f938e * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f938e; i2++) {
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
