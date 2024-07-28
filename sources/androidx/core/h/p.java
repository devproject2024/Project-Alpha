package androidx.core.h;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    private int f3114a;

    /* renamed from: b  reason: collision with root package name */
    private int f3115b;

    public final void a(int i2, int i3) {
        if (i3 == 1) {
            this.f3115b = i2;
        } else {
            this.f3114a = i2;
        }
    }

    public final int a() {
        return this.f3114a | this.f3115b;
    }

    public final void a(int i2) {
        if (i2 == 1) {
            this.f3115b = 0;
        } else {
            this.f3114a = 0;
        }
    }
}
