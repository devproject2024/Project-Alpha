package kotlin.i;

import kotlin.e.b;
import kotlin.g.b.k;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f47936a = b.f47912a.a();

    /* renamed from: b  reason: collision with root package name */
    public static final a f47937b = new a((byte) 0);

    public abstract int a(int i2);

    public int b() {
        return a(32);
    }

    public int b(int i2) {
        return a(0, i2);
    }

    public int a(int i2, int i3) {
        int i4;
        int b2;
        int i5;
        if (i3 > i2) {
            int i6 = i3 - i2;
            if (i6 > 0 || i6 == Integer.MIN_VALUE) {
                if (((-i6) & i6) == i6) {
                    i4 = a(31 - Integer.numberOfLeadingZeros(i6));
                } else {
                    do {
                        b2 = b() >>> 1;
                        i5 = b2 % i6;
                    } while ((b2 - i5) + (i6 - 1) < 0);
                    i4 = i5;
                }
                return i2 + i4;
            }
            while (true) {
                int b3 = b();
                if (i2 <= b3 && i3 > b3) {
                    return b3;
                }
            }
        } else {
            Integer valueOf = Integer.valueOf(i2);
            Integer valueOf2 = Integer.valueOf(i3);
            k.d(valueOf, "from");
            k.d(valueOf2, "until");
            throw new IllegalArgumentException(("Random range is empty: [" + valueOf + ", " + valueOf2 + ").").toString());
        }
    }

    public static final class a extends c {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public final int a(int i2) {
            return c.f47936a.a(i2);
        }

        public final int b() {
            return c.f47936a.b();
        }

        public final int b(int i2) {
            return c.f47936a.b(i2);
        }

        public final int a(int i2, int i3) {
            return c.f47936a.a(i2, i3);
        }
    }
}
