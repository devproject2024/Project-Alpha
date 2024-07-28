package kotlin.a;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import kotlin.a.d;
import kotlin.g.b.k;

final class aj<T> extends d<T> implements RandomAccess {
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public final int f47871b;
    /* access modifiers changed from: package-private */

    /* renamed from: c  reason: collision with root package name */
    public int f47872c;

    /* renamed from: d  reason: collision with root package name */
    int f47873d;
    /* access modifiers changed from: package-private */

    /* renamed from: e  reason: collision with root package name */
    public final Object[] f47874e;

    public aj(Object[] objArr, int i2) {
        k.d(objArr, "buffer");
        this.f47874e = objArr;
        boolean z = true;
        if (i2 >= 0) {
            if (i2 > this.f47874e.length ? false : z) {
                this.f47871b = this.f47874e.length;
                this.f47873d = i2;
                return;
            }
            throw new IllegalArgumentException(("ring buffer filled size: " + i2 + " cannot be larger than the buffer size: " + this.f47874e.length).toString());
        }
        throw new IllegalArgumentException("ring buffer filled size should not be negative but it is ".concat(String.valueOf(i2)).toString());
    }

    public aj(int i2) {
        this(new Object[i2], 0);
    }

    public final int a() {
        return this.f47873d;
    }

    public final T get(int i2) {
        d.a.a(i2, size());
        return this.f47874e[(this.f47872c + i2) % this.f47871b];
    }

    public final boolean b() {
        return size() == this.f47871b;
    }

    public static final class a extends b<T> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ aj f47875c;

        /* renamed from: d  reason: collision with root package name */
        private int f47876d;

        /* renamed from: e  reason: collision with root package name */
        private int f47877e;

        a(aj ajVar) {
            this.f47875c = ajVar;
            this.f47876d = ajVar.size();
            this.f47877e = ajVar.f47872c;
        }

        /* access modifiers changed from: protected */
        public final void a() {
            if (this.f47876d == 0) {
                this.f47878a = ap.Done;
                return;
            }
            this.f47879b = this.f47875c.f47874e[this.f47877e];
            this.f47878a = ap.Ready;
            this.f47877e = (this.f47877e + 1) % this.f47875c.f47871b;
            this.f47876d--;
        }
    }

    public final Iterator<T> iterator() {
        return new a(this);
    }

    public final <T> T[] toArray(T[] tArr) {
        k.d(tArr, "array");
        if (tArr.length < size()) {
            tArr = Arrays.copyOf(tArr, size());
            k.b(tArr, "java.util.Arrays.copyOf(this, newSize)");
        }
        int size = size();
        int i2 = 0;
        int i3 = this.f47872c;
        int i4 = 0;
        while (i4 < size && i3 < this.f47871b) {
            tArr[i4] = this.f47874e[i3];
            i4++;
            i3++;
        }
        while (i4 < size) {
            tArr[i4] = this.f47874e[i2];
            i4++;
            i2++;
        }
        if (tArr.length > size()) {
            tArr[size()] = null;
        }
        if (tArr != null) {
            return tArr;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public final Object[] toArray() {
        return toArray(new Object[size()]);
    }

    public final void a(int i2) {
        boolean z = true;
        if (i2 >= 0) {
            if (i2 > size()) {
                z = false;
            }
            if (!z) {
                throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + i2 + ", size = " + size()).toString());
            } else if (i2 > 0) {
                int i3 = this.f47872c;
                int i4 = this.f47871b;
                int i5 = (i3 + i2) % i4;
                if (i3 > i5) {
                    f.a(this.f47874e, i3, i4);
                    f.a(this.f47874e, 0, i5);
                } else {
                    f.a(this.f47874e, i3, i5);
                }
                this.f47872c = i5;
                this.f47873d = size() - i2;
            }
        } else {
            throw new IllegalArgumentException("n shouldn't be negative but it is ".concat(String.valueOf(i2)).toString());
        }
    }
}
