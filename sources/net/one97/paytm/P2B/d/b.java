package net.one97.paytm.p2b.d;

import android.text.method.PasswordTransformationMethod;
import android.view.View;

public final class b extends PasswordTransformationMethod {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static char f12668a = '⬤';

    public final CharSequence getTransformation(CharSequence charSequence, View view) {
        return new a(charSequence);
    }

    class a implements CharSequence {

        /* renamed from: b  reason: collision with root package name */
        private CharSequence f12670b;

        public a(CharSequence charSequence) {
            this.f12670b = charSequence;
        }

        public final char charAt(int i2) {
            return b.f12668a;
        }

        public final int length() {
            return this.f12670b.length();
        }

        public final CharSequence subSequence(int i2, int i3) {
            return this.f12670b.subSequence(i2, i3);
        }
    }
}
