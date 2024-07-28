package com.zhihu.matisse.internal.a;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.MergeCursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import androidx.loader.b.b;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.zhihu.matisse.internal.entity.Album;
import com.zhihu.matisse.internal.entity.c;
import java.util.HashMap;
import java.util.HashSet;

public final class a extends b {

    /* renamed from: i  reason: collision with root package name */
    private static final Uri f45723i = MediaStore.Files.getContentUri("external");
    private static final String[] j = {"_id", "bucket_id", "bucket_display_name", "mime_type", "uri", "count"};
    private static final String[] k = {"_id", "bucket_id", "bucket_display_name", "mime_type", "COUNT(*) AS count"};
    private static final String[] l = {"_id", "bucket_id", "bucket_display_name", "mime_type"};
    private static final String[] m = {"1", "3"};

    public final void onContentChanged() {
    }

    private static String[] a(int i2) {
        return new String[]{String.valueOf(i2)};
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private a(android.content.Context r8, java.lang.String r9, java.lang.String[] r10) {
        /*
            r7 = this;
            android.net.Uri r2 = f45723i
            boolean r0 = b()
            if (r0 == 0) goto L_0x000b
            java.lang.String[] r0 = k
            goto L_0x000d
        L_0x000b:
            java.lang.String[] r0 = l
        L_0x000d:
            r3 = r0
            java.lang.String r6 = "datetaken DESC"
            r0 = r7
            r1 = r8
            r4 = r9
            r5 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zhihu.matisse.internal.a.a.<init>(android.content.Context, java.lang.String, java.lang.String[]):void");
    }

    /* renamed from: a */
    public final Cursor loadInBackground() {
        Uri uri;
        int i2;
        long j2;
        int i3;
        Uri uri2;
        String str;
        Cursor a2 = super.loadInBackground();
        MatrixCursor matrixCursor = new MatrixCursor(j);
        if (b()) {
            MatrixCursor matrixCursor2 = new MatrixCursor(j);
            if (a2 != null) {
                i3 = 0;
                while (a2.moveToNext()) {
                    long j3 = a2.getLong(a2.getColumnIndex("_id"));
                    long j4 = a2.getLong(a2.getColumnIndex("bucket_id"));
                    String string = a2.getString(a2.getColumnIndex("bucket_display_name"));
                    String string2 = a2.getString(a2.getColumnIndex("mime_type"));
                    Uri a3 = a(a2);
                    int i4 = a2.getInt(a2.getColumnIndex("count"));
                    matrixCursor2.addRow(new String[]{Long.toString(j3), Long.toString(j4), string, string2, a3.toString(), String.valueOf(i4)});
                    i3 += i4;
                }
                uri2 = a2.moveToFirst() ? a(a2) : null;
            } else {
                uri2 = null;
                i3 = 0;
            }
            String[] strArr = new String[6];
            strArr[0] = Album.f45758a;
            strArr[1] = Album.f45758a;
            strArr[2] = AppConstants.FOR_ALL;
            strArr[3] = null;
            if (uri2 == null) {
                str = null;
            } else {
                str = uri2.toString();
            }
            strArr[4] = str;
            strArr[5] = String.valueOf(i3);
            matrixCursor.addRow(strArr);
            return new MergeCursor(new Cursor[]{matrixCursor, matrixCursor2});
        }
        HashMap hashMap = new HashMap();
        if (a2 != null) {
            while (a2.moveToNext()) {
                long j5 = a2.getLong(a2.getColumnIndex("bucket_id"));
                Long l2 = (Long) hashMap.get(Long.valueOf(j5));
                if (l2 == null) {
                    j2 = 1L;
                } else {
                    j2 = Long.valueOf(l2.longValue() + 1);
                }
                hashMap.put(Long.valueOf(j5), j2);
            }
        }
        MatrixCursor matrixCursor3 = new MatrixCursor(j);
        if (a2 == null || !a2.moveToFirst()) {
            i2 = 0;
            uri = null;
        } else {
            uri = a(a2);
            HashSet hashSet = new HashSet();
            i2 = 0;
            while (true) {
                long j6 = a2.getLong(a2.getColumnIndex("bucket_id"));
                if (!hashSet.contains(Long.valueOf(j6))) {
                    long j7 = a2.getLong(a2.getColumnIndex("_id"));
                    String string3 = a2.getString(a2.getColumnIndex("bucket_display_name"));
                    String string4 = a2.getString(a2.getColumnIndex("mime_type"));
                    Uri a4 = a(a2);
                    long longValue = ((Long) hashMap.get(Long.valueOf(j6))).longValue();
                    matrixCursor3.addRow(new String[]{Long.toString(j7), Long.toString(j6), string3, string4, a4.toString(), String.valueOf(longValue)});
                    hashSet.add(Long.valueOf(j6));
                    i2 = (int) (((long) i2) + longValue);
                }
                if (!a2.moveToNext()) {
                    break;
                }
            }
        }
        String[] strArr2 = new String[6];
        strArr2[0] = Album.f45758a;
        strArr2[1] = Album.f45758a;
        strArr2[2] = AppConstants.FOR_ALL;
        String str2 = null;
        strArr2[3] = null;
        if (uri != null) {
            str2 = uri.toString();
        }
        strArr2[4] = str2;
        strArr2[5] = String.valueOf(i2);
        matrixCursor.addRow(strArr2);
        return new MergeCursor(new Cursor[]{matrixCursor, matrixCursor3});
    }

    private static Uri a(Cursor cursor) {
        Uri uri;
        long j2 = cursor.getLong(cursor.getColumnIndex("_id"));
        String string = cursor.getString(cursor.getColumnIndex("mime_type"));
        if (com.zhihu.matisse.b.isImage(string)) {
            uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        } else if (com.zhihu.matisse.b.isVideo(string)) {
            uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        } else {
            uri = MediaStore.Files.getContentUri("external");
        }
        return ContentUris.withAppendedId(uri, j2);
    }

    private static boolean b() {
        return Build.VERSION.SDK_INT < 29;
    }

    public static b a(Context context) {
        String[] strArr;
        String str;
        if (c.a.f45787a.f()) {
            str = b() ? "media_type=? AND _size>0 AND mime_type=?) GROUP BY (bucket_id" : "media_type=? AND _size>0 AND mime_type=?";
            strArr = new String[]{"1", "image/gif"};
        } else if (c.a.f45787a.d()) {
            str = b() ? "media_type=? AND _size>0) GROUP BY (bucket_id" : "media_type=? AND _size>0";
            strArr = a(1);
        } else if (c.a.f45787a.e()) {
            str = b() ? "media_type=? AND _size>0) GROUP BY (bucket_id" : "media_type=? AND _size>0";
            strArr = a(3);
        } else {
            str = b() ? "(media_type=? OR media_type=?) AND _size>0) GROUP BY (bucket_id" : "(media_type=? OR media_type=?) AND _size>0";
            strArr = m;
        }
        return new a(context, str, strArr);
    }
}
