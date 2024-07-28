package androidx.core.h.c;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.view.inputmethod.InputContentInfo;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final C0049c f3086a;

    /* renamed from: androidx.core.h.c.c$c  reason: collision with other inner class name */
    interface C0049c {
        Uri a();

        ClipDescription b();

        void c();
    }

    static final class b implements C0049c {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f3088a;

        /* renamed from: b  reason: collision with root package name */
        private final ClipDescription f3089b;

        /* renamed from: c  reason: collision with root package name */
        private final Uri f3090c;

        public final void c() {
        }

        b(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.f3088a = uri;
            this.f3089b = clipDescription;
            this.f3090c = uri2;
        }

        public final Uri a() {
            return this.f3088a;
        }

        public final ClipDescription b() {
            return this.f3089b;
        }
    }

    static final class a implements C0049c {

        /* renamed from: a  reason: collision with root package name */
        final InputContentInfo f3087a;

        a(Object obj) {
            this.f3087a = (InputContentInfo) obj;
        }

        a(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.f3087a = new InputContentInfo(uri, clipDescription, uri2);
        }

        public final Uri a() {
            return this.f3087a.getContentUri();
        }

        public final ClipDescription b() {
            return this.f3087a.getDescription();
        }

        public final void c() {
            this.f3087a.requestPermission();
        }
    }

    public c(Uri uri, ClipDescription clipDescription, Uri uri2) {
        if (Build.VERSION.SDK_INT >= 25) {
            this.f3086a = new a(uri, clipDescription, uri2);
        } else {
            this.f3086a = new b(uri, clipDescription, uri2);
        }
    }

    c(C0049c cVar) {
        this.f3086a = cVar;
    }

    public final Uri a() {
        return this.f3086a.a();
    }

    public final ClipDescription b() {
        return this.f3086a.b();
    }

    public final void c() {
        this.f3086a.c();
    }
}
