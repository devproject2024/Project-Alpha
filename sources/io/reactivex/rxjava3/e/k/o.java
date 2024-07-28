package io.reactivex.rxjava3.e.k;

public final class o<T> {

    /* renamed from: a  reason: collision with root package name */
    public final float f47738a;

    /* renamed from: b  reason: collision with root package name */
    public int f47739b;

    /* renamed from: c  reason: collision with root package name */
    public int f47740c;

    /* renamed from: d  reason: collision with root package name */
    public int f47741d;

    /* renamed from: e  reason: collision with root package name */
    public T[] f47742e;

    public static int a(int i2) {
        int i3 = i2 * -1640531527;
        return i3 ^ (i3 >>> 16);
    }

    public o() {
        this((byte) 0);
    }

    private o(byte b2) {
        this.f47738a = 0.75f;
        int a2 = p.a(16);
        this.f47739b = a2 - 1;
        this.f47741d = (int) (((float) a2) * 0.75f);
        this.f47742e = (Object[]) new Object[a2];
    }

    public final boolean a(int i2, T[] tArr, int i3) {
        int i4;
        T t;
        this.f47740c--;
        while (true) {
            int i5 = i2 + 1;
            while (true) {
                i4 = i5 & i3;
                t = tArr[i4];
                if (t == null) {
                    tArr[i2] = null;
                    return true;
                }
                int a2 = a(t.hashCode()) & i3;
                if (i2 <= i4) {
                    if (i2 >= a2 || a2 > i4) {
                        break;
                    }
                    i5 = i4 + 1;
                } else {
                    if (i2 >= a2 && a2 > i4) {
                        break;
                    }
                    i5 = i4 + 1;
                }
            }
            tArr[i2] = t;
            i2 = i4;
        }
    }
}
