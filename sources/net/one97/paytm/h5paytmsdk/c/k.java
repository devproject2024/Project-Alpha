package net.one97.paytm.h5paytmsdk.c;

import android.app.Activity;
import android.content.Intent;

public interface k {
    Intent a(Activity activity);

    boolean b(Activity activity);

    boolean c(Activity activity);

    a d(Activity activity);

    boolean e(Activity activity);

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f17092a;

        /* renamed from: b  reason: collision with root package name */
        public final String f17093b;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return kotlin.g.b.k.a((Object) this.f17092a, (Object) aVar.f17092a) && kotlin.g.b.k.a((Object) this.f17093b, (Object) aVar.f17093b);
        }

        public final int hashCode() {
            String str = this.f17092a;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.f17093b;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            return hashCode + i2;
        }

        public final String toString() {
            return "AuthData(authToken=" + this.f17092a + ", authorizationValue=" + this.f17093b + ")";
        }

        public a(String str, String str2) {
            this.f17092a = str;
            this.f17093b = str2;
        }
    }
}
