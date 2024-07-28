package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import com.squareup.picasso.w;
import i.v;
import java.io.IOException;

public abstract class ab {
    /* access modifiers changed from: package-private */
    public int a() {
        return 0;
    }

    public abstract a a(z zVar, int i2) throws IOException;

    /* access modifiers changed from: package-private */
    public boolean a(NetworkInfo networkInfo) {
        return false;
    }

    public abstract boolean a(z zVar);

    /* access modifiers changed from: package-private */
    public boolean b() {
        return false;
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final w.d f45360a;

        /* renamed from: b  reason: collision with root package name */
        final Bitmap f45361b;

        /* renamed from: c  reason: collision with root package name */
        final v f45362c;

        /* renamed from: d  reason: collision with root package name */
        final int f45363d;

        public a(Bitmap bitmap, w.d dVar) {
            this((Bitmap) ai.a(bitmap, "bitmap == null"), (v) null, dVar, 0);
        }

        public a(v vVar, w.d dVar) {
            this((Bitmap) null, (v) ai.a(vVar, "source == null"), dVar, 0);
        }

        a(Bitmap bitmap, v vVar, w.d dVar, int i2) {
            if ((bitmap != null) != (vVar == null ? false : true)) {
                this.f45361b = bitmap;
                this.f45362c = vVar;
                this.f45360a = (w.d) ai.a(dVar, "loadedFrom == null");
                this.f45363d = i2;
                return;
            }
            throw new AssertionError();
        }
    }

    static BitmapFactory.Options c(z zVar) {
        boolean c2 = zVar.c();
        boolean z = zVar.s != null;
        BitmapFactory.Options options = null;
        if (c2 || z || zVar.r) {
            options = new BitmapFactory.Options();
            options.inJustDecodeBounds = c2;
            options.inInputShareable = zVar.r;
            options.inPurgeable = zVar.r;
            if (z) {
                options.inPreferredConfig = zVar.s;
            }
        }
        return options;
    }

    static boolean a(BitmapFactory.Options options) {
        return options != null && options.inJustDecodeBounds;
    }

    static void a(int i2, int i3, BitmapFactory.Options options, z zVar) {
        a(i2, i3, options.outWidth, options.outHeight, options, zVar);
    }

    static void a(int i2, int i3, int i4, int i5, BitmapFactory.Options options, z zVar) {
        int i6;
        double floor;
        if (i5 > i3 || i4 > i2) {
            if (i3 == 0) {
                floor = Math.floor((double) (((float) i4) / ((float) i2)));
            } else if (i2 == 0) {
                floor = Math.floor((double) (((float) i5) / ((float) i3)));
            } else {
                int floor2 = (int) Math.floor((double) (((float) i5) / ((float) i3)));
                int floor3 = (int) Math.floor((double) (((float) i4) / ((float) i2)));
                i6 = zVar.l ? Math.max(floor2, floor3) : Math.min(floor2, floor3);
            }
            i6 = (int) floor;
        } else {
            i6 = 1;
        }
        options.inSampleSize = i6;
        options.inJustDecodeBounds = false;
    }
}
