package androidx.browser.trusted.a;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f1928a;

    /* renamed from: b  reason: collision with root package name */
    public final String f1929b;

    /* renamed from: c  reason: collision with root package name */
    public final String f1930c;

    /* renamed from: d  reason: collision with root package name */
    public final C0028b f1931d;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f1932a;

        /* renamed from: b  reason: collision with root package name */
        public final List<String> f1933b;
    }

    /* renamed from: androidx.browser.trusted.a.b$b  reason: collision with other inner class name */
    public static class C0028b {

        /* renamed from: a  reason: collision with root package name */
        public final String f1934a;

        /* renamed from: b  reason: collision with root package name */
        public final String f1935b;

        /* renamed from: c  reason: collision with root package name */
        public final List<a> f1936c;

        public final Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putString("androidx.browser.trusted.sharing.KEY_TITLE", this.f1934a);
            bundle.putString("androidx.browser.trusted.sharing.KEY_TEXT", this.f1935b);
            if (this.f1936c != null) {
                ArrayList arrayList = new ArrayList();
                for (a next : this.f1936c) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("androidx.browser.trusted.sharing.KEY_FILE_NAME", next.f1932a);
                    bundle2.putStringArrayList("androidx.browser.trusted.sharing.KEY_ACCEPTED_TYPES", new ArrayList(next.f1933b));
                    arrayList.add(bundle2);
                }
                bundle.putParcelableArrayList("androidx.browser.trusted.sharing.KEY_FILES", arrayList);
            }
            return bundle;
        }
    }
}
