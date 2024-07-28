package net.one97.paytm.h5paytmsdk.d;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import androidx.loader.b.b;
import java.io.Closeable;
import kotlin.f.a;
import kotlin.g.b.k;
import kotlin.x;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f17099a = new d();

    private d() {
    }

    public static String a(Context context, Uri uri) {
        k.c(context, "context");
        k.c(uri, "fileUri");
        if (Build.VERSION.SDK_INT < 19) {
            return b(context, uri);
        }
        return c(context, uri);
    }

    private static String b(Context context, Uri uri) {
        Closeable closeable;
        String string;
        String str = null;
        try {
            Cursor a2 = new b(context, uri, new String[]{"_data"}, (String) null, (String[]) null, (String) null).loadInBackground();
            if (a2 == null) {
                return null;
            }
            closeable = a2;
            try {
                int columnIndexOrThrow = a2.getColumnIndexOrThrow("_data");
                a2.moveToFirst();
                string = a2.getString(columnIndexOrThrow);
                try {
                    x xVar = x.f47997a;
                } catch (Throwable th) {
                    th = th;
                    str = string;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
            try {
                a.a(closeable, (Throwable) null);
                return string;
            } catch (Exception e2) {
                e = e2;
                str = string;
                e.printStackTrace();
                return str;
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            return str;
        } catch (Throwable th3) {
            a.a(closeable, th);
            throw th3;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:72:0x018e A[Catch:{ Exception -> 0x0213 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01d0 A[Catch:{ Exception -> 0x0213 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String c(android.content.Context r10, android.net.Uri r11) {
        /*
            java.lang.String r0 = "raw:"
            r1 = 0
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0213 }
            r3 = 19
            r4 = 1
            r5 = 0
            if (r2 < r3) goto L_0x000d
            r2 = 1
            goto L_0x000e
        L_0x000d:
            r2 = 0
        L_0x000e:
            if (r2 == 0) goto L_0x01d6
            boolean r2 = android.provider.DocumentsContract.isDocumentUri(r10, r11)     // Catch:{ Exception -> 0x0213 }
            if (r2 == 0) goto L_0x01d6
            java.lang.String r2 = "com.android.externalstorage.documents"
            java.lang.String r3 = r11.getAuthority()     // Catch:{ Exception -> 0x0213 }
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r3)     // Catch:{ Exception -> 0x0213 }
            java.lang.String r3 = "null cannot be cast to non-null type kotlin.Array<T>"
            java.lang.String r6 = "null cannot be cast to non-null type java.util.Collection<T>"
            java.lang.String r7 = ":"
            java.lang.String r8 = "docId"
            if (r2 == 0) goto L_0x00b6
            java.lang.String r10 = android.provider.DocumentsContract.getDocumentId(r11)     // Catch:{ Exception -> 0x0213 }
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r8)     // Catch:{ Exception -> 0x0213 }
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ Exception -> 0x0213 }
            kotlin.m.l r11 = new kotlin.m.l     // Catch:{ Exception -> 0x0213 }
            r11.<init>((java.lang.String) r7)     // Catch:{ Exception -> 0x0213 }
            java.util.List r10 = r11.split(r10, r5)     // Catch:{ Exception -> 0x0213 }
            boolean r11 = r10.isEmpty()     // Catch:{ Exception -> 0x0213 }
            if (r11 != 0) goto L_0x006f
            int r11 = r10.size()     // Catch:{ Exception -> 0x0213 }
            java.util.ListIterator r11 = r10.listIterator(r11)     // Catch:{ Exception -> 0x0213 }
        L_0x004a:
            boolean r0 = r11.hasPrevious()     // Catch:{ Exception -> 0x0213 }
            if (r0 == 0) goto L_0x006f
            java.lang.Object r0 = r11.previous()     // Catch:{ Exception -> 0x0213 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0213 }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x0213 }
            int r0 = r0.length()     // Catch:{ Exception -> 0x0213 }
            if (r0 != 0) goto L_0x0060
            r0 = 1
            goto L_0x0061
        L_0x0060:
            r0 = 0
        L_0x0061:
            if (r0 != 0) goto L_0x004a
            java.lang.Iterable r10 = (java.lang.Iterable) r10     // Catch:{ Exception -> 0x0213 }
            int r11 = r11.nextIndex()     // Catch:{ Exception -> 0x0213 }
            int r11 = r11 + r4
            java.util.List r10 = kotlin.a.k.b(r10, (int) r11)     // Catch:{ Exception -> 0x0213 }
            goto L_0x0073
        L_0x006f:
            kotlin.a.w r10 = kotlin.a.w.INSTANCE     // Catch:{ Exception -> 0x0213 }
            java.util.List r10 = (java.util.List) r10     // Catch:{ Exception -> 0x0213 }
        L_0x0073:
            java.util.Collection r10 = (java.util.Collection) r10     // Catch:{ Exception -> 0x0213 }
            if (r10 == 0) goto L_0x00b0
            java.lang.String[] r11 = new java.lang.String[r5]     // Catch:{ Exception -> 0x0213 }
            java.lang.Object[] r10 = r10.toArray(r11)     // Catch:{ Exception -> 0x0213 }
            if (r10 == 0) goto L_0x00aa
            java.lang.String[] r10 = (java.lang.String[]) r10     // Catch:{ Exception -> 0x0213 }
            r11 = r10[r5]     // Catch:{ Exception -> 0x0213 }
            java.lang.String r0 = "primary"
            boolean r11 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r11, (boolean) r4)     // Catch:{ Exception -> 0x0213 }
            if (r11 == 0) goto L_0x0217
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0213 }
            r11.<init>()     // Catch:{ Exception -> 0x0213 }
            java.io.File r0 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x0213 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0213 }
            r11.append(r0)     // Catch:{ Exception -> 0x0213 }
            java.lang.String r0 = "/"
            r11.append(r0)     // Catch:{ Exception -> 0x0213 }
            r10 = r10[r4]     // Catch:{ Exception -> 0x0213 }
            r11.append(r10)     // Catch:{ Exception -> 0x0213 }
            java.lang.String r10 = r11.toString()     // Catch:{ Exception -> 0x0213 }
            return r10
        L_0x00aa:
            kotlin.u r10 = new kotlin.u     // Catch:{ Exception -> 0x0213 }
            r10.<init>(r3)     // Catch:{ Exception -> 0x0213 }
            throw r10     // Catch:{ Exception -> 0x0213 }
        L_0x00b0:
            kotlin.u r10 = new kotlin.u     // Catch:{ Exception -> 0x0213 }
            r10.<init>(r6)     // Catch:{ Exception -> 0x0213 }
            throw r10     // Catch:{ Exception -> 0x0213 }
        L_0x00b6:
            java.lang.String r2 = "com.android.providers.downloads.documents"
            java.lang.String r9 = r11.getAuthority()     // Catch:{ Exception -> 0x0213 }
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r9)     // Catch:{ Exception -> 0x0213 }
            if (r2 == 0) goto L_0x0135
            java.lang.String r2 = d(r10, r11)     // Catch:{ Exception -> 0x0213 }
            if (r2 == 0) goto L_0x00f0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0213 }
            r3.<init>()     // Catch:{ Exception -> 0x0213 }
            java.io.File r4 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x0213 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0213 }
            r3.append(r4)     // Catch:{ Exception -> 0x0213 }
            java.lang.String r4 = "/Download/"
            r3.append(r4)     // Catch:{ Exception -> 0x0213 }
            r3.append(r2)     // Catch:{ Exception -> 0x0213 }
            java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x0213 }
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x0213 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0213 }
            boolean r3 = r3.exists()     // Catch:{ Exception -> 0x0213 }
            if (r3 == 0) goto L_0x00f0
            return r2
        L_0x00f0:
            java.lang.String r11 = android.provider.DocumentsContract.getDocumentId(r11)     // Catch:{ Exception -> 0x0213 }
            java.lang.String r2 = "id"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r2)     // Catch:{ Exception -> 0x0213 }
            boolean r2 = kotlin.m.p.b(r11, r0, r5)     // Catch:{ Exception -> 0x0213 }
            if (r2 == 0) goto L_0x0106
            java.lang.String r10 = ""
            java.lang.String r10 = kotlin.m.p.a((java.lang.String) r11, (java.lang.String) r0, (java.lang.String) r10)     // Catch:{ Exception -> 0x0213 }
            return r10
        L_0x0106:
            java.lang.String r0 = "content://downloads/public_downloads"
            java.lang.String r2 = "content://downloads/my_downloads"
            java.lang.String r3 = "content://downloads/all_downloads"
            java.lang.String[] r0 = new java.lang.String[]{r0, r2, r3}     // Catch:{ Exception -> 0x0213 }
        L_0x0110:
            r2 = 3
            if (r5 >= r2) goto L_0x0134
            r2 = r0[r5]     // Catch:{ Exception -> 0x0213 }
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch:{ Exception -> 0x0213 }
            java.lang.Long r3 = java.lang.Long.valueOf(r11)     // Catch:{ Exception -> 0x0213 }
            java.lang.String r4 = "java.lang.Long.valueOf(id)"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)     // Catch:{ Exception -> 0x0213 }
            long r3 = r3.longValue()     // Catch:{ Exception -> 0x0213 }
            android.net.Uri r2 = android.content.ContentUris.withAppendedId(r2, r3)     // Catch:{ Exception -> 0x0213 }
            java.lang.String r2 = a(r10, r2, r1, r1)     // Catch:{ Exception -> 0x0213 }
            if (r2 == 0) goto L_0x0131
            return r2
        L_0x0131:
            int r5 = r5 + 1
            goto L_0x0110
        L_0x0134:
            return r1
        L_0x0135:
            java.lang.String r0 = "com.android.providers.media.documents"
            java.lang.String r2 = r11.getAuthority()     // Catch:{ Exception -> 0x0213 }
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r2)     // Catch:{ Exception -> 0x0213 }
            if (r0 == 0) goto L_0x0217
            java.lang.String r11 = android.provider.DocumentsContract.getDocumentId(r11)     // Catch:{ Exception -> 0x0213 }
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r8)     // Catch:{ Exception -> 0x0213 }
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11     // Catch:{ Exception -> 0x0213 }
            kotlin.m.l r0 = new kotlin.m.l     // Catch:{ Exception -> 0x0213 }
            r0.<init>((java.lang.String) r7)     // Catch:{ Exception -> 0x0213 }
            java.util.List r11 = r0.split(r11, r5)     // Catch:{ Exception -> 0x0213 }
            boolean r0 = r11.isEmpty()     // Catch:{ Exception -> 0x0213 }
            if (r0 != 0) goto L_0x0186
            int r0 = r11.size()     // Catch:{ Exception -> 0x0213 }
            java.util.ListIterator r0 = r11.listIterator(r0)     // Catch:{ Exception -> 0x0213 }
        L_0x0161:
            boolean r2 = r0.hasPrevious()     // Catch:{ Exception -> 0x0213 }
            if (r2 == 0) goto L_0x0186
            java.lang.Object r2 = r0.previous()     // Catch:{ Exception -> 0x0213 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0213 }
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x0213 }
            int r2 = r2.length()     // Catch:{ Exception -> 0x0213 }
            if (r2 != 0) goto L_0x0177
            r2 = 1
            goto L_0x0178
        L_0x0177:
            r2 = 0
        L_0x0178:
            if (r2 != 0) goto L_0x0161
            java.lang.Iterable r11 = (java.lang.Iterable) r11     // Catch:{ Exception -> 0x0213 }
            int r0 = r0.nextIndex()     // Catch:{ Exception -> 0x0213 }
            int r0 = r0 + r4
            java.util.List r11 = kotlin.a.k.b(r11, (int) r0)     // Catch:{ Exception -> 0x0213 }
            goto L_0x018a
        L_0x0186:
            kotlin.a.w r11 = kotlin.a.w.INSTANCE     // Catch:{ Exception -> 0x0213 }
            java.util.List r11 = (java.util.List) r11     // Catch:{ Exception -> 0x0213 }
        L_0x018a:
            java.util.Collection r11 = (java.util.Collection) r11     // Catch:{ Exception -> 0x0213 }
            if (r11 == 0) goto L_0x01d0
            java.lang.String[] r0 = new java.lang.String[r5]     // Catch:{ Exception -> 0x0213 }
            java.lang.Object[] r11 = r11.toArray(r0)     // Catch:{ Exception -> 0x0213 }
            if (r11 == 0) goto L_0x01ca
            java.lang.String[] r11 = (java.lang.String[]) r11     // Catch:{ Exception -> 0x0213 }
            r0 = r11[r5]     // Catch:{ Exception -> 0x0213 }
            java.lang.String r2 = "image"
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r0)     // Catch:{ Exception -> 0x0213 }
            if (r2 == 0) goto L_0x01a5
            android.net.Uri r0 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI     // Catch:{ Exception -> 0x0213 }
            goto L_0x01bd
        L_0x01a5:
            java.lang.String r2 = "video"
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r0)     // Catch:{ Exception -> 0x0213 }
            if (r2 == 0) goto L_0x01b1
            android.net.Uri r0 = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI     // Catch:{ Exception -> 0x0213 }
            goto L_0x01bd
        L_0x01b1:
            java.lang.String r2 = "audio"
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r0)     // Catch:{ Exception -> 0x0213 }
            if (r0 == 0) goto L_0x01bc
            android.net.Uri r0 = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI     // Catch:{ Exception -> 0x0213 }
            goto L_0x01bd
        L_0x01bc:
            r0 = r1
        L_0x01bd:
            java.lang.String r2 = "_id=?"
            java.lang.String[] r3 = new java.lang.String[r4]     // Catch:{ Exception -> 0x0213 }
            r11 = r11[r4]     // Catch:{ Exception -> 0x0213 }
            r3[r5] = r11     // Catch:{ Exception -> 0x0213 }
            java.lang.String r10 = a(r10, r0, r2, r3)     // Catch:{ Exception -> 0x0213 }
            return r10
        L_0x01ca:
            kotlin.u r10 = new kotlin.u     // Catch:{ Exception -> 0x0213 }
            r10.<init>(r3)     // Catch:{ Exception -> 0x0213 }
            throw r10     // Catch:{ Exception -> 0x0213 }
        L_0x01d0:
            kotlin.u r10 = new kotlin.u     // Catch:{ Exception -> 0x0213 }
            r10.<init>(r6)     // Catch:{ Exception -> 0x0213 }
            throw r10     // Catch:{ Exception -> 0x0213 }
        L_0x01d6:
            java.lang.String r0 = "content"
            java.lang.String r2 = r11.getScheme()     // Catch:{ Exception -> 0x0213 }
            if (r2 != 0) goto L_0x01e1
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0213 }
        L_0x01e1:
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r2, (boolean) r4)     // Catch:{ Exception -> 0x0213 }
            if (r0 == 0) goto L_0x01fd
            java.lang.String r0 = "com.google.android.apps.photos.content"
            java.lang.String r2 = r11.getAuthority()     // Catch:{ Exception -> 0x0213 }
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r2)     // Catch:{ Exception -> 0x0213 }
            if (r0 == 0) goto L_0x01f8
            java.lang.String r10 = r11.getLastPathSegment()     // Catch:{ Exception -> 0x0213 }
            return r10
        L_0x01f8:
            java.lang.String r10 = a(r10, r11, r1, r1)     // Catch:{ Exception -> 0x0213 }
            return r10
        L_0x01fd:
            java.lang.String r10 = "file"
            java.lang.String r0 = r11.getScheme()     // Catch:{ Exception -> 0x0213 }
            if (r0 != 0) goto L_0x0208
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0213 }
        L_0x0208:
            boolean r10 = kotlin.m.p.a((java.lang.String) r10, (java.lang.String) r0, (boolean) r4)     // Catch:{ Exception -> 0x0213 }
            if (r10 == 0) goto L_0x0217
            java.lang.String r10 = r11.getPath()     // Catch:{ Exception -> 0x0213 }
            return r10
        L_0x0213:
            r10 = move-exception
            r10.printStackTrace()
        L_0x0217:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.h5paytmsdk.d.d.c(android.content.Context, android.net.Uri):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0039, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        kotlin.f.a.a(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003d, code lost:
        throw r12;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(android.content.Context r10, android.net.Uri r11, java.lang.String r12, java.lang.String[] r13) {
        /*
            java.lang.String r0 = "_data"
            java.lang.String[] r4 = new java.lang.String[]{r0}
            r8 = 0
            if (r11 == 0) goto L_0x0042
            androidx.loader.b.b r9 = new androidx.loader.b.b     // Catch:{ Exception -> 0x003e }
            r7 = 0
            r1 = r9
            r2 = r10
            r3 = r11
            r5 = r12
            r6 = r13
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x003e }
            android.database.Cursor r10 = r9.loadInBackground()     // Catch:{ Exception -> 0x003e }
            if (r10 == 0) goto L_0x0042
            java.io.Closeable r10 = (java.io.Closeable) r10     // Catch:{ Exception -> 0x003e }
            r11 = r10
            android.database.Cursor r11 = (android.database.Cursor) r11     // Catch:{ all -> 0x0037 }
            boolean r12 = r11.moveToFirst()     // Catch:{ all -> 0x0037 }
            if (r12 == 0) goto L_0x0031
            int r12 = r11.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x0037 }
            java.lang.String r11 = r11.getString(r12)     // Catch:{ all -> 0x0037 }
            kotlin.f.a.a(r10, r8)     // Catch:{ Exception -> 0x003e }
            return r11
        L_0x0031:
            kotlin.x r11 = kotlin.x.f47997a     // Catch:{ all -> 0x0037 }
            kotlin.f.a.a(r10, r8)     // Catch:{ Exception -> 0x003e }
            goto L_0x0042
        L_0x0037:
            r11 = move-exception
            throw r11     // Catch:{ all -> 0x0039 }
        L_0x0039:
            r12 = move-exception
            kotlin.f.a.a(r10, r11)     // Catch:{ Exception -> 0x003e }
            throw r12     // Catch:{ Exception -> 0x003e }
        L_0x003e:
            r10 = move-exception
            r10.printStackTrace()
        L_0x0042:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.h5paytmsdk.d.d.a(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0040, code lost:
        kotlin.f.a.a(r7, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0043, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String d(android.content.Context r7, android.net.Uri r8) {
        /*
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r7, r0)
            java.lang.String r0 = "uri"
            kotlin.g.b.k.c(r8, r0)
            java.lang.String r0 = "_display_name"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            android.content.ContentResolver r1 = r7.getContentResolver()
            r4 = 0
            r5 = 0
            r6 = 0
            r2 = r8
            android.database.Cursor r7 = r1.query(r2, r3, r4, r5, r6)
            r8 = 0
            if (r7 == 0) goto L_0x0044
            java.io.Closeable r7 = (java.io.Closeable) r7
            r1 = r7
            android.database.Cursor r1 = (android.database.Cursor) r1     // Catch:{ all -> 0x003d }
            boolean r2 = r1.moveToFirst()     // Catch:{ all -> 0x003d }
            if (r2 == 0) goto L_0x0037
            int r0 = r1.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x003d }
            java.lang.String r0 = r1.getString(r0)     // Catch:{ all -> 0x003d }
            kotlin.f.a.a(r7, r8)
            return r0
        L_0x0037:
            kotlin.x r0 = kotlin.x.f47997a     // Catch:{ all -> 0x003d }
            kotlin.f.a.a(r7, r8)
            goto L_0x0044
        L_0x003d:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x003f }
        L_0x003f:
            r0 = move-exception
            kotlin.f.a.a(r7, r8)
            throw r0
        L_0x0044:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.h5paytmsdk.d.d.d(android.content.Context, android.net.Uri):java.lang.String");
    }
}
