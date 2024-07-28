package androidx.media;

import android.media.session.MediaSessionManager;
import androidx.core.g.c;
import androidx.media.e;

final class g extends f {

    static final class a implements e.b {

        /* renamed from: a  reason: collision with root package name */
        final MediaSessionManager.RemoteUserInfo f3837a;

        a(String str, int i2, int i3) {
            this.f3837a = new MediaSessionManager.RemoteUserInfo(str, i2, i3);
        }

        public final int hashCode() {
            return c.a(this.f3837a);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            return this.f3837a.equals(((a) obj).f3837a);
        }
    }
}
