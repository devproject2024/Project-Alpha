package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

final class f {

    /* renamed from: a  reason: collision with root package name */
    final b f4202a;

    /* renamed from: b  reason: collision with root package name */
    final a f4203b = new a();

    /* renamed from: c  reason: collision with root package name */
    final List<View> f4204c = new ArrayList();

    interface b {
        int a();

        int a(View view);

        void a(int i2);

        void a(View view, int i2);

        void a(View view, int i2, ViewGroup.LayoutParams layoutParams);

        View b(int i2);

        RecyclerView.v b(View view);

        void b();

        void c(int i2);

        void c(View view);

        void d(View view);
    }

    f(b bVar) {
        this.f4202a = bVar;
    }

    /* access modifiers changed from: package-private */
    public final void a(View view) {
        this.f4204c.add(view);
        this.f4202a.c(view);
    }

    /* access modifiers changed from: package-private */
    public final boolean b(View view) {
        if (!this.f4204c.remove(view)) {
            return false;
        }
        this.f4202a.d(view);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void a(View view, int i2, boolean z) {
        int i3;
        if (i2 < 0) {
            i3 = this.f4202a.a();
        } else {
            i3 = e(i2);
        }
        this.f4203b.a(i3, z);
        if (z) {
            a(view);
        }
        this.f4202a.a(view, i3);
    }

    private int e(int i2) {
        if (i2 < 0) {
            return -1;
        }
        int a2 = this.f4202a.a();
        int i3 = i2;
        while (i3 < a2) {
            int e2 = i2 - (i3 - this.f4203b.e(i3));
            if (e2 == 0) {
                while (this.f4203b.c(i3)) {
                    i3++;
                }
                return i3;
            }
            i3 += e2;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        int e2 = e(i2);
        View b2 = this.f4202a.b(e2);
        if (b2 != null) {
            if (this.f4203b.d(e2)) {
                b(b2);
            }
            this.f4202a.a(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public final View b(int i2) {
        return this.f4202a.b(e(i2));
    }

    /* access modifiers changed from: package-private */
    public final void a(View view, int i2, ViewGroup.LayoutParams layoutParams, boolean z) {
        int i3;
        if (i2 < 0) {
            i3 = this.f4202a.a();
        } else {
            i3 = e(i2);
        }
        this.f4203b.a(i3, z);
        if (z) {
            a(view);
        }
        this.f4202a.a(view, i3, layoutParams);
    }

    /* access modifiers changed from: package-private */
    public final int a() {
        return this.f4202a.a() - this.f4204c.size();
    }

    /* access modifiers changed from: package-private */
    public final int b() {
        return this.f4202a.a();
    }

    /* access modifiers changed from: package-private */
    public final View c(int i2) {
        return this.f4202a.b(i2);
    }

    /* access modifiers changed from: package-private */
    public final void d(int i2) {
        int e2 = e(i2);
        this.f4203b.d(e2);
        this.f4202a.c(e2);
    }

    /* access modifiers changed from: package-private */
    public final int c(View view) {
        int a2 = this.f4202a.a(view);
        if (a2 != -1 && !this.f4203b.c(a2)) {
            return a2 - this.f4203b.e(a2);
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public final boolean d(View view) {
        return this.f4204c.contains(view);
    }

    public final String toString() {
        return this.f4203b.toString() + ", hidden list:" + this.f4204c.size();
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        long f4205a = 0;

        /* renamed from: b  reason: collision with root package name */
        a f4206b;

        a() {
        }

        /* access modifiers changed from: package-private */
        public final void a(int i2) {
            a aVar = this;
            while (i2 >= 64) {
                aVar.a();
                aVar = aVar.f4206b;
                i2 -= 64;
            }
            aVar.f4205a |= 1 << i2;
        }

        private void a() {
            if (this.f4206b == null) {
                this.f4206b = new a();
            }
        }

        /* access modifiers changed from: package-private */
        public final void b(int i2) {
            a aVar = this;
            while (i2 >= 64) {
                aVar = aVar.f4206b;
                if (aVar != null) {
                    i2 -= 64;
                } else {
                    return;
                }
            }
            aVar.f4205a &= ~(1 << i2);
        }

        /* access modifiers changed from: package-private */
        public final boolean c(int i2) {
            a aVar = this;
            while (i2 >= 64) {
                aVar.a();
                aVar = aVar.f4206b;
                i2 -= 64;
            }
            return (aVar.f4205a & (1 << i2)) != 0;
        }

        /* access modifiers changed from: package-private */
        public final void a(int i2, boolean z) {
            boolean z2 = z;
            a aVar = this;
            while (true) {
                if (i2 >= 64) {
                    aVar.a();
                    aVar = aVar.f4206b;
                    i2 -= 64;
                } else {
                    boolean z3 = (aVar.f4205a & Long.MIN_VALUE) != 0;
                    long j = (1 << i2) - 1;
                    long j2 = aVar.f4205a;
                    aVar.f4205a = ((j2 & (~j)) << 1) | (j2 & j);
                    if (z2) {
                        aVar.a(i2);
                    } else {
                        aVar.b(i2);
                    }
                    if (z3 || aVar.f4206b != null) {
                        aVar.a();
                        aVar = aVar.f4206b;
                        z2 = z3;
                        i2 = 0;
                    } else {
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean d(int i2) {
            a aVar = this;
            while (i2 >= 64) {
                aVar.a();
                aVar = aVar.f4206b;
                i2 -= 64;
            }
            long j = 1 << i2;
            boolean z = (aVar.f4205a & j) != 0;
            aVar.f4205a &= ~j;
            long j2 = j - 1;
            long j3 = aVar.f4205a;
            aVar.f4205a = Long.rotateRight(j3 & (~j2), 1) | (j3 & j2);
            a aVar2 = aVar.f4206b;
            if (aVar2 != null) {
                if (aVar2.c(0)) {
                    aVar.a(63);
                }
                aVar.f4206b.d(0);
            }
            return z;
        }

        /* access modifiers changed from: package-private */
        public final int e(int i2) {
            a aVar = this.f4206b;
            if (aVar == null) {
                if (i2 >= 64) {
                    return Long.bitCount(this.f4205a);
                }
                return Long.bitCount(this.f4205a & ((1 << i2) - 1));
            } else if (i2 < 64) {
                return Long.bitCount(this.f4205a & ((1 << i2) - 1));
            } else {
                return aVar.e(i2 - 64) + Long.bitCount(this.f4205a);
            }
        }

        public final String toString() {
            if (this.f4206b == null) {
                return Long.toBinaryString(this.f4205a);
            }
            return this.f4206b.toString() + "xx" + Long.toBinaryString(this.f4205a);
        }
    }
}
