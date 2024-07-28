package androidx.recyclerview.widget;

public final class e implements s {

    /* renamed from: a  reason: collision with root package name */
    final s f4197a;

    /* renamed from: b  reason: collision with root package name */
    int f4198b = 0;

    /* renamed from: c  reason: collision with root package name */
    int f4199c = -1;

    /* renamed from: d  reason: collision with root package name */
    int f4200d = -1;

    /* renamed from: e  reason: collision with root package name */
    Object f4201e = null;

    public e(s sVar) {
        this.f4197a = sVar;
    }

    public final void a() {
        int i2 = this.f4198b;
        if (i2 != 0) {
            if (i2 == 1) {
                this.f4197a.a(this.f4199c, this.f4200d);
            } else if (i2 == 2) {
                this.f4197a.b(this.f4199c, this.f4200d);
            } else if (i2 == 3) {
                this.f4197a.a(this.f4199c, this.f4200d, this.f4201e);
            }
            this.f4201e = null;
            this.f4198b = 0;
        }
    }

    public final void a(int i2, int i3) {
        int i4;
        if (this.f4198b == 1 && i2 >= (i4 = this.f4199c)) {
            int i5 = this.f4200d;
            if (i2 <= i4 + i5) {
                this.f4200d = i5 + i3;
                this.f4199c = Math.min(i2, i4);
                return;
            }
        }
        a();
        this.f4199c = i2;
        this.f4200d = i3;
        this.f4198b = 1;
    }

    public final void b(int i2, int i3) {
        int i4;
        if (this.f4198b != 2 || (i4 = this.f4199c) < i2 || i4 > i2 + i3) {
            a();
            this.f4199c = i2;
            this.f4200d = i3;
            this.f4198b = 2;
            return;
        }
        this.f4200d += i3;
        this.f4199c = i2;
    }

    public final void c(int i2, int i3) {
        a();
        this.f4197a.c(i2, i3);
    }

    public final void a(int i2, int i3, Object obj) {
        int i4;
        if (this.f4198b == 3) {
            int i5 = this.f4199c;
            int i6 = this.f4200d;
            if (i2 <= i5 + i6 && (i4 = i2 + i3) >= i5 && this.f4201e == obj) {
                this.f4199c = Math.min(i2, i5);
                this.f4200d = Math.max(i6 + i5, i4) - this.f4199c;
                return;
            }
        }
        a();
        this.f4199c = i2;
        this.f4200d = i3;
        this.f4201e = obj;
        this.f4198b = 3;
    }
}
