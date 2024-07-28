package com.bumptech.glide.load.a.a;

import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.b.a.b;
import com.bumptech.glide.load.f;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final a f6682a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final a f6683b;

    /* renamed from: c  reason: collision with root package name */
    private final d f6684c;

    /* renamed from: d  reason: collision with root package name */
    private final b f6685d;

    /* renamed from: e  reason: collision with root package name */
    private final ContentResolver f6686e;

    /* renamed from: f  reason: collision with root package name */
    private final List<ImageHeaderParser> f6687f;

    e(List<ImageHeaderParser> list, d dVar, b bVar, ContentResolver contentResolver) {
        this(list, f6682a, dVar, bVar, contentResolver);
    }

    private e(List<ImageHeaderParser> list, a aVar, d dVar, b bVar, ContentResolver contentResolver) {
        this.f6683b = aVar;
        this.f6684c = dVar;
        this.f6685d = bVar;
        this.f6686e = contentResolver;
        this.f6687f = list;
    }

    /* access modifiers changed from: package-private */
    public final int a(Uri uri) {
        InputStream inputStream = null;
        try {
            InputStream openInputStream = this.f6686e.openInputStream(uri);
            int b2 = f.b(this.f6687f, openInputStream, this.f6685d);
            if (openInputStream != null) {
                try {
                    openInputStream.close();
                } catch (IOException unused) {
                }
            }
            return b2;
        } catch (IOException | NullPointerException unused2) {
            if (Log.isLoggable("ThumbStreamOpener", 3)) {
                new StringBuilder("Failed to open uri: ").append(uri);
            }
            if (inputStream == null) {
                return -1;
            }
            try {
                inputStream.close();
                return -1;
            } catch (IOException unused3) {
                return -1;
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
    }

    public final InputStream b(Uri uri) throws FileNotFoundException {
        String c2 = c(uri);
        if (TextUtils.isEmpty(c2)) {
            return null;
        }
        File file = new File(c2);
        if (!(file.exists() && 0 < file.length())) {
            return null;
        }
        Uri fromFile = Uri.fromFile(file);
        try {
            return this.f6686e.openInputStream(fromFile);
        } catch (NullPointerException e2) {
            throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + fromFile).initCause(e2));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x002d A[Catch:{ all -> 0x003d }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String c(android.net.Uri r5) {
        /*
            r4 = this;
            r0 = 0
            com.bumptech.glide.load.a.a.d r1 = r4.f6684c     // Catch:{ SecurityException -> 0x0023, all -> 0x0020 }
            android.database.Cursor r1 = r1.a(r5)     // Catch:{ SecurityException -> 0x0023, all -> 0x0020 }
            if (r1 == 0) goto L_0x001a
            boolean r2 = r1.moveToFirst()     // Catch:{ SecurityException -> 0x0024 }
            if (r2 == 0) goto L_0x001a
            r2 = 0
            java.lang.String r5 = r1.getString(r2)     // Catch:{ SecurityException -> 0x0024 }
            if (r1 == 0) goto L_0x0019
            r1.close()
        L_0x0019:
            return r5
        L_0x001a:
            if (r1 == 0) goto L_0x001f
            r1.close()
        L_0x001f:
            return r0
        L_0x0020:
            r5 = move-exception
            r1 = r0
            goto L_0x003e
        L_0x0023:
            r1 = r0
        L_0x0024:
            java.lang.String r2 = "ThumbStreamOpener"
            r3 = 3
            boolean r2 = android.util.Log.isLoggable(r2, r3)     // Catch:{ all -> 0x003d }
            if (r2 == 0) goto L_0x0037
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x003d }
            java.lang.String r3 = "Failed to query for thumbnail for Uri: "
            r2.<init>(r3)     // Catch:{ all -> 0x003d }
            r2.append(r5)     // Catch:{ all -> 0x003d }
        L_0x0037:
            if (r1 == 0) goto L_0x003c
            r1.close()
        L_0x003c:
            return r0
        L_0x003d:
            r5 = move-exception
        L_0x003e:
            if (r1 == 0) goto L_0x0043
            r1.close()
        L_0x0043:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.a.a.e.c(android.net.Uri):java.lang.String");
    }
}
