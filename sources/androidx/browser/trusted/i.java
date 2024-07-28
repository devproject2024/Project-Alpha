package androidx.browser.trusted;

import android.app.Notification;
import android.os.Bundle;
import android.os.Parcelable;

public final class i {

    static class d {

        /* renamed from: a  reason: collision with root package name */
        public final String f1954a;

        /* renamed from: b  reason: collision with root package name */
        public final int f1955b;

        /* renamed from: c  reason: collision with root package name */
        public final Notification f1956c;

        /* renamed from: d  reason: collision with root package name */
        public final String f1957d;

        d(String str, int i2, Notification notification, String str2) {
            this.f1954a = str;
            this.f1955b = i2;
            this.f1956c = notification;
            this.f1957d = str2;
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f1951a;

        /* renamed from: b  reason: collision with root package name */
        public final int f1952b;

        b(String str, int i2) {
            this.f1951a = str;
            this.f1952b = i2;
        }
    }

    static class e {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f1958a;

        e(boolean z) {
            this.f1958a = z;
        }

        public final Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putBoolean("android.support.customtabs.trusted.NOTIFICATION_SUCCESS", this.f1958a);
            return bundle;
        }
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        public final Parcelable[] f1950a;

        a(Parcelable[] parcelableArr) {
            this.f1950a = parcelableArr;
        }
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        public final String f1953a;

        c(String str) {
            this.f1953a = str;
        }
    }

    static void a(Bundle bundle, String str) {
        if (!bundle.containsKey(str)) {
            throw new IllegalArgumentException("Bundle must contain ".concat(String.valueOf(str)));
        }
    }
}
