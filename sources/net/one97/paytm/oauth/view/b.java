package net.one97.paytm.oauth.view;

import android.text.method.PasswordTransformationMethod;
import android.view.View;

public final class b extends PasswordTransformationMethod {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static char f56852a = '●';

    public final CharSequence getTransformation(CharSequence charSequence, View view) {
        return new a(charSequence);
    }

    static class a implements CharSequence {

        /* renamed from: a  reason: collision with root package name */
        private CharSequence f56853a;

        public a(CharSequence charSequence) {
            this.f56853a = charSequence;
        }

        public final char charAt(int i2) {
            return b.f56852a;
        }

        public final int length() {
            return this.f56853a.length();
        }

        public final CharSequence subSequence(int i2, int i3) {
            return this.f56853a.subSequence(i2, i3);
        }
    }
}
