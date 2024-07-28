package com.squareup.picasso;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import com.squareup.picasso.ab;
import com.squareup.picasso.w;
import i.n;
import i.v;
import java.io.IOException;

final class q extends g {

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f45438b = {"orientation"};

    q(Context context) {
        super(context);
    }

    public final boolean a(z zVar) {
        Uri uri = zVar.f45479d;
        return "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    public final ab.a a(z zVar, int i2) throws IOException {
        a aVar;
        Bitmap bitmap;
        z zVar2 = zVar;
        ContentResolver contentResolver = this.f45410a.getContentResolver();
        int a2 = a(contentResolver, zVar2.f45479d);
        String type = contentResolver.getType(zVar2.f45479d);
        boolean z = type != null && type.startsWith("video/");
        if (zVar.c()) {
            int i3 = zVar2.f45483h;
            int i4 = zVar2.f45484i;
            if (i3 <= a.MICRO.width && i4 <= a.MICRO.height) {
                aVar = a.MICRO;
            } else if (i3 > a.MINI.width || i4 > a.MINI.height) {
                aVar = a.FULL;
            } else {
                aVar = a.MINI;
            }
            a aVar2 = aVar;
            if (!z && aVar2 == a.FULL) {
                return new ab.a((Bitmap) null, n.a(b(zVar)), w.d.DISK, a2);
            }
            long parseId = ContentUris.parseId(zVar2.f45479d);
            BitmapFactory.Options c2 = c(zVar);
            c2.inJustDecodeBounds = true;
            BitmapFactory.Options options = c2;
            a(zVar2.f45483h, zVar2.f45484i, aVar2.width, aVar2.height, c2, zVar);
            if (z) {
                bitmap = MediaStore.Video.Thumbnails.getThumbnail(contentResolver, parseId, aVar2 == a.FULL ? 1 : aVar2.androidKind, options);
            } else {
                bitmap = MediaStore.Images.Thumbnails.getThumbnail(contentResolver, parseId, aVar2.androidKind, options);
            }
            if (bitmap != null) {
                return new ab.a(bitmap, (v) null, w.d.DISK, a2);
            }
        }
        return new ab.a((Bitmap) null, n.a(b(zVar)), w.d.DISK, a2);
    }

    private static int a(ContentResolver contentResolver, Uri uri) {
        Cursor cursor = null;
        try {
            Cursor query = contentResolver.query(uri, f45438b, (String) null, (String[]) null, (String) null);
            if (query != null) {
                if (query.moveToFirst()) {
                    int i2 = query.getInt(0);
                    if (query != null) {
                        query.close();
                    }
                    return i2;
                }
            }
            if (query != null) {
                query.close();
            }
            return 0;
        } catch (RuntimeException unused) {
            if (cursor != null) {
                cursor.close();
            }
            return 0;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    enum a {
        MICRO(3, 96, 96),
        MINI(1, 512, 384),
        FULL(2, -1, -1);
        
        final int androidKind;
        final int height;
        final int width;

        private a(int i2, int i3, int i4) {
            this.androidKind = i2;
            this.width = i3;
            this.height = i4;
        }
    }
}
