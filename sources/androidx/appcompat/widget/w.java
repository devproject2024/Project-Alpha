package androidx.appcompat.widget;

final class w {

    /* renamed from: a  reason: collision with root package name */
    int f1814a = 0;

    /* renamed from: b  reason: collision with root package name */
    int f1815b = 0;

    /* renamed from: c  reason: collision with root package name */
    int f1816c = Integer.MIN_VALUE;

    /* renamed from: d  reason: collision with root package name */
    int f1817d = Integer.MIN_VALUE;

    /* renamed from: e  reason: collision with root package name */
    int f1818e = 0;

    /* renamed from: f  reason: collision with root package name */
    int f1819f = 0;

    /* renamed from: g  reason: collision with root package name */
    boolean f1820g = false;

    /* renamed from: h  reason: collision with root package name */
    boolean f1821h = false;

    w() {
    }

    public final void a(int i2, int i3) {
        this.f1816c = i2;
        this.f1817d = i3;
        this.f1821h = true;
        if (this.f1820g) {
            if (i3 != Integer.MIN_VALUE) {
                this.f1814a = i3;
            }
            if (i2 != Integer.MIN_VALUE) {
                this.f1815b = i2;
                return;
            }
            return;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f1814a = i2;
        }
        if (i3 != Integer.MIN_VALUE) {
            this.f1815b = i3;
        }
    }

    public final void b(int i2, int i3) {
        this.f1821h = false;
        if (i2 != Integer.MIN_VALUE) {
            this.f1818e = i2;
            this.f1814a = i2;
        }
        if (i3 != Integer.MIN_VALUE) {
            this.f1819f = i3;
            this.f1815b = i3;
        }
    }
}
