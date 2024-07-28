package kotlin.j;

import java.util.Iterator;
import kotlin.e.c;

public class b implements Iterable<Integer>, kotlin.g.b.a.a {

    /* renamed from: d  reason: collision with root package name */
    public static final a f47938d = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public final int f47939a;

    /* renamed from: b  reason: collision with root package name */
    public final int f47940b;

    /* renamed from: c  reason: collision with root package name */
    public final int f47941c;

    public b(int i2, int i3, int i4) {
        if (i4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (i4 != Integer.MIN_VALUE) {
            this.f47939a = i2;
            if (i4 > 0) {
                if (i2 < i3) {
                    i3 -= c.a(i3, i2, i4);
                }
            } else if (i4 >= 0) {
                throw new IllegalArgumentException("Step is zero.");
            } else if (i2 > i3) {
                i3 += c.a(i2, i3, -i4);
            }
            this.f47940b = i3;
            this.f47941c = i4;
        } else {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
    }

    public boolean a() {
        return this.f47941c > 0 ? this.f47939a > this.f47940b : this.f47939a < this.f47940b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        if (a() && ((b) obj).a()) {
            return true;
        }
        b bVar = (b) obj;
        return this.f47939a == bVar.f47939a && this.f47940b == bVar.f47940b && this.f47941c == bVar.f47941c;
    }

    public int hashCode() {
        if (a()) {
            return -1;
        }
        return (((this.f47939a * 31) + this.f47940b) * 31) + this.f47941c;
    }

    public String toString() {
        StringBuilder sb;
        int i2;
        if (this.f47941c > 0) {
            sb = new StringBuilder();
            sb.append(this.f47939a);
            sb.append("..");
            sb.append(this.f47940b);
            sb.append(" step ");
            i2 = this.f47941c;
        } else {
            sb = new StringBuilder();
            sb.append(this.f47939a);
            sb.append(" downTo ");
            sb.append(this.f47940b);
            sb.append(" step ");
            i2 = -this.f47941c;
        }
        sb.append(i2);
        return sb.toString();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static b a(int i2, int i3, int i4) {
            return new b(i2, i3, i4);
        }
    }

    public /* synthetic */ Iterator iterator() {
        return new c(this.f47939a, this.f47940b, this.f47941c);
    }
}
