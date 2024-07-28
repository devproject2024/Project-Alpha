package androidx.navigation;

import android.os.Bundle;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    final q f3876a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f3877b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f3878c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f3879d;

    f(q<?> qVar, boolean z, Object obj, boolean z2) {
        if (!qVar.f3962a && z) {
            throw new IllegalArgumentException(qVar.a() + " does not allow nullable values");
        } else if (z || !z2 || obj != null) {
            this.f3876a = qVar;
            this.f3878c = z;
            this.f3879d = obj;
            this.f3877b = z2;
        } else {
            throw new IllegalArgumentException("Argument with type " + qVar.a() + " has null value but is not nullable.");
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, Bundle bundle) {
        if (this.f3877b) {
            this.f3876a.a(bundle, str, this.f3879d);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean b(String str, Bundle bundle) {
        if (!this.f3878c && bundle.containsKey(str) && bundle.get(str) == null) {
            return false;
        }
        try {
            this.f3876a.a(bundle, str);
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            f fVar = (f) obj;
            if (this.f3878c != fVar.f3878c || this.f3877b != fVar.f3877b || !this.f3876a.equals(fVar.f3876a)) {
                return false;
            }
            Object obj2 = this.f3879d;
            Object obj3 = fVar.f3879d;
            if (obj2 != null) {
                return obj2.equals(obj3);
            }
            if (obj3 == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = ((((this.f3876a.hashCode() * 31) + (this.f3878c ? 1 : 0)) * 31) + (this.f3877b ? 1 : 0)) * 31;
        Object obj = this.f3879d;
        return hashCode + (obj != null ? obj.hashCode() : 0);
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        q<?> f3880a;

        /* renamed from: b  reason: collision with root package name */
        boolean f3881b = false;

        /* renamed from: c  reason: collision with root package name */
        private Object f3882c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f3883d = false;

        public final a a(Object obj) {
            this.f3882c = obj;
            this.f3883d = true;
            return this;
        }

        public final f a() {
            if (this.f3880a == null) {
                this.f3880a = q.a(this.f3882c);
            }
            return new f(this.f3880a, this.f3881b, this.f3882c, this.f3883d);
        }
    }
}
