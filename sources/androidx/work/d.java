package androidx.work;

import android.net.Uri;
import java.util.HashSet;
import java.util.Set;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final Set<a> f5089a = new HashSet();

    public final int a() {
        return this.f5089a.size();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f5089a.equals(((d) obj).f5089a);
    }

    public final int hashCode() {
        return this.f5089a.hashCode();
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Uri f5090a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f5091b;

        public a(Uri uri, boolean z) {
            this.f5090a = uri;
            this.f5091b = z;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                a aVar = (a) obj;
                return this.f5091b == aVar.f5091b && this.f5090a.equals(aVar.f5090a);
            }
        }

        public final int hashCode() {
            return (this.f5090a.hashCode() * 31) + (this.f5091b ? 1 : 0);
        }
    }
}
