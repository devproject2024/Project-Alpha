package androidx.browser.customtabs;

import android.os.Bundle;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final Integer f1873a;

    /* renamed from: b  reason: collision with root package name */
    public final Integer f1874b;

    /* renamed from: c  reason: collision with root package name */
    public final Integer f1875c;

    a(Integer num, Integer num2, Integer num3) {
        this.f1873a = num;
        this.f1874b = num2;
        this.f1875c = num3;
    }

    public final Bundle a() {
        Bundle bundle = new Bundle();
        Integer num = this.f1873a;
        if (num != null) {
            bundle.putInt("android.support.customtabs.extra.TOOLBAR_COLOR", num.intValue());
        }
        Integer num2 = this.f1874b;
        if (num2 != null) {
            bundle.putInt("android.support.customtabs.extra.SECONDARY_TOOLBAR_COLOR", num2.intValue());
        }
        Integer num3 = this.f1875c;
        if (num3 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_COLOR", num3.intValue());
        }
        return bundle;
    }

    static a a(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle(0);
        }
        return new a((Integer) bundle.get("android.support.customtabs.extra.TOOLBAR_COLOR"), (Integer) bundle.get("android.support.customtabs.extra.SECONDARY_TOOLBAR_COLOR"), (Integer) bundle.get("androidx.browser.customtabs.extra.NAVIGATION_BAR_COLOR"));
    }

    /* renamed from: androidx.browser.customtabs.a$a  reason: collision with other inner class name */
    public static final class C0027a {

        /* renamed from: a  reason: collision with root package name */
        private Integer f1876a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f1877b;

        /* renamed from: c  reason: collision with root package name */
        private Integer f1878c;

        public final C0027a a(int i2) {
            this.f1876a = Integer.valueOf(i2 | -16777216);
            return this;
        }

        public final C0027a b(int i2) {
            this.f1878c = Integer.valueOf(i2 | -16777216);
            return this;
        }

        public final a a() {
            return new a(this.f1876a, this.f1877b, this.f1878c);
        }
    }
}
