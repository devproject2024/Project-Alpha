package androidx.core.f;

import java.util.Locale;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final d f2949a = new C0044e((c) null, false);

    /* renamed from: b  reason: collision with root package name */
    public static final d f2950b = new C0044e((c) null, true);

    /* renamed from: c  reason: collision with root package name */
    public static final d f2951c = new C0044e(b.f2957a, false);

    /* renamed from: d  reason: collision with root package name */
    public static final d f2952d = new C0044e(b.f2957a, true);

    /* renamed from: e  reason: collision with root package name */
    public static final d f2953e = new C0044e(a.f2955a, false);

    /* renamed from: f  reason: collision with root package name */
    public static final d f2954f = f.f2960a;

    interface c {
        int a(CharSequence charSequence, int i2);
    }

    static int a(int i2) {
        if (i2 != 0) {
            return (i2 == 1 || i2 == 2) ? 0 : 2;
        }
        return 1;
    }

    static int b(int i2) {
        if (i2 != 0) {
            if (i2 == 1 || i2 == 2) {
                return 0;
            }
            switch (i2) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }

    static abstract class d implements d {

        /* renamed from: a  reason: collision with root package name */
        private final c f2958a;

        /* access modifiers changed from: protected */
        public abstract boolean a();

        d(c cVar) {
            this.f2958a = cVar;
        }

        public final boolean a(CharSequence charSequence, int i2) {
            if (charSequence == null || i2 < 0 || charSequence.length() - i2 < 0) {
                throw new IllegalArgumentException();
            }
            c cVar = this.f2958a;
            if (cVar == null) {
                return a();
            }
            int a2 = cVar.a(charSequence, i2);
            if (a2 == 0) {
                return true;
            }
            if (a2 != 1) {
                return a();
            }
            return false;
        }
    }

    /* renamed from: androidx.core.f.e$e  reason: collision with other inner class name */
    static class C0044e extends d {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f2959a;

        C0044e(c cVar, boolean z) {
            super(cVar);
            this.f2959a = z;
        }

        /* access modifiers changed from: protected */
        public final boolean a() {
            return this.f2959a;
        }
    }

    static class b implements c {

        /* renamed from: a  reason: collision with root package name */
        static final b f2957a = new b();

        public final int a(CharSequence charSequence, int i2) {
            int i3 = i2 + 0;
            int i4 = 2;
            for (int i5 = 0; i5 < i3 && i4 == 2; i5++) {
                i4 = e.b(Character.getDirectionality(charSequence.charAt(i5)));
            }
            return i4;
        }

        private b() {
        }
    }

    static class a implements c {

        /* renamed from: a  reason: collision with root package name */
        static final a f2955a = new a();

        /* renamed from: b  reason: collision with root package name */
        private final boolean f2956b = true;

        public final int a(CharSequence charSequence, int i2) {
            int i3 = i2 + 0;
            boolean z = false;
            for (int i4 = 0; i4 < i3; i4++) {
                int a2 = e.a(Character.getDirectionality(charSequence.charAt(i4)));
                if (a2 != 0) {
                    if (a2 != 1) {
                        continue;
                    } else if (!this.f2956b) {
                        return 1;
                    }
                } else if (this.f2956b) {
                    return 0;
                }
                z = true;
            }
            if (z) {
                return this.f2956b ? 1 : 0;
            }
            return 2;
        }

        private a() {
        }
    }

    static class f extends d {

        /* renamed from: a  reason: collision with root package name */
        static final f f2960a = new f();

        f() {
            super((c) null);
        }

        /* access modifiers changed from: protected */
        public final boolean a() {
            return f.a(Locale.getDefault()) == 1;
        }
    }
}
