package androidx.constraintlayout.a;

import net.one97.paytm.upi.util.UpiConstants;

final class f {

    interface a<T> {
        T a();

        void a(T[] tArr, int i2);

        boolean a(T t);
    }

    static class b<T> implements a<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Object[] f2157a = new Object[UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS];

        /* renamed from: b  reason: collision with root package name */
        private int f2158b;

        b() {
        }

        public final T a() {
            int i2 = this.f2158b;
            if (i2 <= 0) {
                return null;
            }
            int i3 = i2 - 1;
            T[] tArr = this.f2157a;
            T t = tArr[i3];
            tArr[i3] = null;
            this.f2158b = i2 - 1;
            return t;
        }

        public final boolean a(T t) {
            int i2 = this.f2158b;
            Object[] objArr = this.f2157a;
            if (i2 >= objArr.length) {
                return false;
            }
            objArr[i2] = t;
            this.f2158b = i2 + 1;
            return true;
        }

        public final void a(T[] tArr, int i2) {
            if (i2 > tArr.length) {
                i2 = tArr.length;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                T t = tArr[i3];
                int i4 = this.f2158b;
                Object[] objArr = this.f2157a;
                if (i4 < objArr.length) {
                    objArr[i4] = t;
                    this.f2158b = i4 + 1;
                }
            }
        }
    }
}
