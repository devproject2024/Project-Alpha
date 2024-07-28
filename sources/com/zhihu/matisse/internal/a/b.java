package com.zhihu.matisse.internal.a;

import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.MergeCursor;
import android.net.Uri;
import android.provider.MediaStore;
import com.business.merchant_payments.common.utility.AppConstants;
import com.zhihu.matisse.internal.entity.Album;
import com.zhihu.matisse.internal.entity.c;

public final class b extends androidx.loader.b.b {

    /* renamed from: i  reason: collision with root package name */
    private static final Uri f45724i = MediaStore.Files.getContentUri("external");
    private static final String[] j = {"_id", "_display_name", "mime_type", "_size", AppConstants.DURATION};
    private static final String[] k = {"1", "3"};
    private final boolean l;

    public final void onContentChanged() {
    }

    private static String[] a(int i2) {
        return new String[]{String.valueOf(i2)};
    }

    private static String[] a(int i2, String str) {
        return new String[]{String.valueOf(i2), str};
    }

    private b(Context context, String str, String[] strArr, boolean z) {
        super(context, f45724i, j, str, strArr, "datetaken DESC");
        this.l = z;
    }

    public static androidx.loader.b.b a(Context context, Album album, boolean z) {
        String[] strArr;
        String[] strArr2;
        String str;
        String str2 = "media_type=? AND _size>0";
        if (!album.b()) {
            if (c.a.f45787a.f()) {
                strArr2 = new String[]{"1", album.f45759b, "image/gif"};
                str = "media_type=? AND  bucket_id=? AND mime_type=? AND _size>0";
            } else {
                if (c.a.f45787a.d()) {
                    strArr = a(1, album.f45759b);
                } else if (c.a.f45787a.e()) {
                    strArr = a(3, album.f45759b);
                } else {
                    strArr2 = new String[]{"1", "3", album.f45759b};
                    str = "(media_type=? OR media_type=?) AND  bucket_id=? AND _size>0";
                }
                str2 = "media_type=? AND  bucket_id=? AND _size>0";
                z = false;
            }
            str2 = str;
            strArr = strArr2;
            z = false;
        } else if (c.a.f45787a.f()) {
            strArr = new String[]{"1", "image/gif"};
            str2 = "media_type=? AND mime_type=? AND _size>0";
        } else if (c.a.f45787a.d()) {
            strArr = a(1);
        } else if (c.a.f45787a.e()) {
            strArr = a(3);
        } else {
            strArr = k;
            str2 = "(media_type=? OR media_type=?) AND _size>0";
        }
        return new b(context, str2, strArr, z);
    }

    /* renamed from: a */
    public final Cursor loadInBackground() {
        Cursor a2 = super.loadInBackground();
        if (!this.l || !com.zhihu.matisse.internal.c.c.a(getContext())) {
            return a2;
        }
        MatrixCursor matrixCursor = new MatrixCursor(j);
        matrixCursor.addRow(new Object[]{-1L, "Capture", "", 0, 0});
        return new MergeCursor(new Cursor[]{matrixCursor, a2});
    }
}
