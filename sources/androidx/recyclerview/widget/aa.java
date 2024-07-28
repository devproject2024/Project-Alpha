package androidx.recyclerview.widget;

import android.view.View;

final class aa {

    /* renamed from: a  reason: collision with root package name */
    final b f4158a;

    /* renamed from: b  reason: collision with root package name */
    a f4159b = new a();

    interface b {
        int a();

        int a(View view);

        View a(int i2);

        int b();

        int b(View view);
    }

    aa(b bVar) {
        this.f4158a = bVar;
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        int f4160a = 0;

        /* renamed from: b  reason: collision with root package name */
        int f4161b;

        /* renamed from: c  reason: collision with root package name */
        int f4162c;

        /* renamed from: d  reason: collision with root package name */
        int f4163d;

        /* renamed from: e  reason: collision with root package name */
        int f4164e;

        private static int a(int i2, int i3) {
            if (i2 > i3) {
                return 1;
            }
            return i2 == i3 ? 2 : 4;
        }

        a() {
        }

        /* access modifiers changed from: package-private */
        public final void a(int i2, int i3, int i4, int i5) {
            this.f4161b = i2;
            this.f4162c = i3;
            this.f4163d = i4;
            this.f4164e = i5;
        }

        /* access modifiers changed from: package-private */
        public final void a(int i2) {
            this.f4160a = i2 | this.f4160a;
        }

        /* access modifiers changed from: package-private */
        public final boolean a() {
            int i2 = this.f4160a;
            if ((i2 & 7) != 0 && (i2 & (a(this.f4163d, this.f4161b) << 0)) == 0) {
                return false;
            }
            int i3 = this.f4160a;
            if ((i3 & 112) != 0 && (i3 & (a(this.f4163d, this.f4162c) << 4)) == 0) {
                return false;
            }
            int i4 = this.f4160a;
            if ((i4 & 1792) != 0 && (i4 & (a(this.f4164e, this.f4161b) << 8)) == 0) {
                return false;
            }
            int i5 = this.f4160a;
            if ((i5 & 28672) == 0 || (i5 & (a(this.f4164e, this.f4162c) << 12)) != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final View a(int i2, int i3, int i4, int i5) {
        int a2 = this.f4158a.a();
        int b2 = this.f4158a.b();
        int i6 = i3 > i2 ? 1 : -1;
        View view = null;
        while (i2 != i3) {
            View a3 = this.f4158a.a(i2);
            this.f4159b.a(a2, b2, this.f4158a.a(a3), this.f4158a.b(a3));
            if (i4 != 0) {
                a aVar = this.f4159b;
                aVar.f4160a = 0;
                aVar.a(i4);
                if (this.f4159b.a()) {
                    return a3;
                }
            }
            if (i5 != 0) {
                a aVar2 = this.f4159b;
                aVar2.f4160a = 0;
                aVar2.a(i5);
                if (this.f4159b.a()) {
                    view = a3;
                }
            }
            i2 += i6;
        }
        return view;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(View view) {
        this.f4159b.a(this.f4158a.a(), this.f4158a.b(), this.f4158a.a(view), this.f4158a.b(view));
        a aVar = this.f4159b;
        aVar.f4160a = 0;
        aVar.a(24579);
        return this.f4159b.a();
    }
}
