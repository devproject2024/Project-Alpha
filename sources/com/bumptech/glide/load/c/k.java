package com.bumptech.glide.load.c;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.f;
import com.bumptech.glide.f.d;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.i;
import java.io.File;
import java.io.FileNotFoundException;

public final class k implements n<Uri, File> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f7042a;

    public final /* synthetic */ n.a a(Object obj, int i2, int i3, i iVar) {
        Uri uri = (Uri) obj;
        return new n.a(new d(uri), new b(this.f7042a, uri));
    }

    public final /* bridge */ /* synthetic */ boolean a(Object obj) {
        return com.bumptech.glide.load.a.a.b.a((Uri) obj);
    }

    public k(Context context) {
        this.f7042a = context;
    }

    static class b implements com.bumptech.glide.load.a.d<File> {

        /* renamed from: a  reason: collision with root package name */
        private static final String[] f7044a = {"_data"};

        /* renamed from: b  reason: collision with root package name */
        private final Context f7045b;

        /* renamed from: c  reason: collision with root package name */
        private final Uri f7046c;

        public final void b() {
        }

        public final void c() {
        }

        b(Context context, Uri uri) {
            this.f7045b = context;
            this.f7046c = uri;
        }

        public final void a(f fVar, d.a<? super File> aVar) {
            Cursor query = this.f7045b.getContentResolver().query(this.f7046c, f7044a, (String) null, (String[]) null, (String) null);
            String str = null;
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        str = query.getString(query.getColumnIndexOrThrow("_data"));
                    }
                } finally {
                    query.close();
                }
            }
            if (TextUtils.isEmpty(str)) {
                aVar.a((Exception) new FileNotFoundException("Failed to find file path for: " + this.f7046c));
                return;
            }
            aVar.a(new File(str));
        }

        public final Class<File> a() {
            return File.class;
        }

        public final com.bumptech.glide.load.a d() {
            return com.bumptech.glide.load.a.LOCAL;
        }
    }

    public static final class a implements o<Uri, File> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f7043a;

        public a(Context context) {
            this.f7043a = context;
        }

        public final n<Uri, File> a(r rVar) {
            return new k(this.f7043a);
        }
    }
}
