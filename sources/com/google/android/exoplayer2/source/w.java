package com.google.android.exoplayer2.source;

public interface w {
    int a();

    int a(int i2);

    int b();

    int b(int i2);

    int c();

    public static final class a implements w {

        /* renamed from: a  reason: collision with root package name */
        private final int f33402a;

        public final int b(int i2) {
            int i3 = i2 - 1;
            if (i3 >= 0) {
                return i3;
            }
            return -1;
        }

        public a(int i2) {
            this.f33402a = i2;
        }

        public final int a() {
            return this.f33402a;
        }

        public final int a(int i2) {
            int i3 = i2 + 1;
            if (i3 < this.f33402a) {
                return i3;
            }
            return -1;
        }

        public final int b() {
            int i2 = this.f33402a;
            if (i2 > 0) {
                return i2 - 1;
            }
            return -1;
        }

        public final int c() {
            return this.f33402a > 0 ? 0 : -1;
        }
    }
}
