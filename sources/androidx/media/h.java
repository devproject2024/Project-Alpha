package androidx.media;

import android.text.TextUtils;
import androidx.core.g.c;
import androidx.media.e;

class h {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f3838a = e.f3834a;

    static class a implements e.b {

        /* renamed from: a  reason: collision with root package name */
        private String f3839a;

        /* renamed from: b  reason: collision with root package name */
        private int f3840b;

        /* renamed from: c  reason: collision with root package name */
        private int f3841c;

        a(String str, int i2, int i3) {
            this.f3839a = str;
            this.f3840b = i2;
            this.f3841c = i3;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return TextUtils.equals(this.f3839a, aVar.f3839a) && this.f3840b == aVar.f3840b && this.f3841c == aVar.f3841c;
        }

        public final int hashCode() {
            return c.a(this.f3839a, Integer.valueOf(this.f3840b), Integer.valueOf(this.f3841c));
        }
    }
}
