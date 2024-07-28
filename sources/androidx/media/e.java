package androidx.media;

import android.os.Build;
import android.util.Log;
import androidx.media.g;
import androidx.media.h;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    static final boolean f3834a = Log.isLoggable("MediaSessionManager", 3);

    /* renamed from: b  reason: collision with root package name */
    private static final Object f3835b = new Object();

    interface b {
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        b f3836a;

        public a(String str, int i2, int i3) {
            if (Build.VERSION.SDK_INT >= 28) {
                this.f3836a = new g.a(str, i2, i3);
            } else {
                this.f3836a = new h.a(str, i2, i3);
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            return this.f3836a.equals(((a) obj).f3836a);
        }

        public final int hashCode() {
            return this.f3836a.hashCode();
        }
    }
}
