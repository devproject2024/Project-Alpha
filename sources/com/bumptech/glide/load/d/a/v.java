package com.bumptech.glide.load.d.a;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import com.bumptech.glide.g.a;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.k;
import java.io.IOException;
import java.io.InputStream;

public final class v implements k<InputStream, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final d f7185a = new d();

    public final /* bridge */ /* synthetic */ boolean a(Object obj, i iVar) throws IOException {
        return true;
    }

    public final /* synthetic */ com.bumptech.glide.load.b.v a(Object obj, int i2, int i3, i iVar) throws IOException {
        return this.f7185a.a(ImageDecoder.createSource(a.a((InputStream) obj)), i2, i3, iVar);
    }
}
