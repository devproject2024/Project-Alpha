package androidx.core.g;

public final class e {

    public interface a<T> {
        T a();

        boolean a(T t);
    }

    public static class b<T> implements a<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Object[] f2966a;

        /* renamed from: b  reason: collision with root package name */
        private int f2967b;

        public b(int i2) {
            if (i2 > 0) {
                this.f2966a = new Object[i2];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        public T a() {
            int i2 = this.f2967b;
            if (i2 <= 0) {
                return null;
            }
            int i3 = i2 - 1;
            T[] tArr = this.f2966a;
            T t = tArr[i3];
            tArr[i3] = null;
            this.f2967b = i2 - 1;
            return t;
        }

        public boolean a(T t) {
            boolean z;
            int i2 = 0;
            while (true) {
                if (i2 >= this.f2967b) {
                    z = false;
                    break;
                } else if (this.f2966a[i2] == t) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (!z) {
                int i3 = this.f2967b;
                Object[] objArr = this.f2966a;
                if (i3 >= objArr.length) {
                    return false;
                }
                objArr[i3] = t;
                this.f2967b = i3 + 1;
                return true;
            }
            throw new IllegalStateException("Already in the pool!");
        }
    }

    public static class c<T> extends b<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Object f2968a = new Object();

        public c(int i2) {
            super(i2);
        }

        public final T a() {
            T a2;
            synchronized (this.f2968a) {
                a2 = super.a();
            }
            return a2;
        }

        public final boolean a(T t) {
            boolean a2;
            synchronized (this.f2968a) {
                a2 = super.a(t);
            }
            return a2;
        }
    }
}
