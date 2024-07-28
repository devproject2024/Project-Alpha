package com.bumptech.glide.load.a.a;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import com.bumptech.glide.f;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.a.g;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class c implements d<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f6675a;

    /* renamed from: b  reason: collision with root package name */
    private final e f6676b;

    /* renamed from: c  reason: collision with root package name */
    private InputStream f6677c;

    public final void c() {
    }

    public static c a(Context context, Uri uri, d dVar) {
        return new c(uri, new e(com.bumptech.glide.b.a(context).f6427c.a(), dVar, com.bumptech.glide.b.a(context).f6428d, context.getContentResolver()));
    }

    private c(Uri uri, e eVar) {
        this.f6675a = uri;
        this.f6676b = eVar;
    }

    public final void b() {
        InputStream inputStream = this.f6677c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public final Class<InputStream> a() {
        return InputStream.class;
    }

    public final com.bumptech.glide.load.a d() {
        return com.bumptech.glide.load.a.LOCAL;
    }

    public static class b implements d {

        /* renamed from: b  reason: collision with root package name */
        private static final String[] f6680b = {"_data"};

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f6681a;

        public b(ContentResolver contentResolver) {
            this.f6681a = contentResolver;
        }

        public final Cursor a(Uri uri) {
            String lastPathSegment = uri.getLastPathSegment();
            return this.f6681a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f6680b, "kind = 1 AND video_id = ?", new String[]{lastPathSegment}, (String) null);
        }
    }

    public static class a implements d {

        /* renamed from: b  reason: collision with root package name */
        private static final String[] f6678b = {"_data"};

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f6679a;

        public a(ContentResolver contentResolver) {
            this.f6679a = contentResolver;
        }

        public final Cursor a(Uri uri) {
            String lastPathSegment = uri.getLastPathSegment();
            return this.f6679a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f6678b, "kind = 1 AND image_id = ?", new String[]{lastPathSegment}, (String) null);
        }
    }

    public final void a(f fVar, d.a<? super InputStream> aVar) {
        try {
            InputStream b2 = this.f6676b.b(this.f6675a);
            int a2 = b2 != null ? this.f6676b.a(this.f6675a) : -1;
            if (a2 != -1) {
                b2 = new g(b2, a2);
            }
            this.f6677c = b2;
            aVar.a(this.f6677c);
        } catch (FileNotFoundException e2) {
            Log.isLoggable("MediaStoreThumbFetcher", 3);
            aVar.a((Exception) e2);
        }
    }
}
