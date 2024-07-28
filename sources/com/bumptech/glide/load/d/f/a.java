package com.bumptech.glide.load.d.f;

import android.graphics.Bitmap;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.d.b.b;
import com.bumptech.glide.load.i;
import java.io.ByteArrayOutputStream;

public final class a implements e<Bitmap, byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private final Bitmap.CompressFormat f7245a;

    /* renamed from: b  reason: collision with root package name */
    private final int f7246b;

    public a() {
        this(Bitmap.CompressFormat.JPEG);
    }

    private a(Bitmap.CompressFormat compressFormat) {
        this.f7245a = compressFormat;
        this.f7246b = 100;
    }

    public final v<byte[]> a(v<Bitmap> vVar, i iVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        vVar.b().compress(this.f7245a, this.f7246b, byteArrayOutputStream);
        vVar.d();
        return new b(byteArrayOutputStream.toByteArray());
    }
}
