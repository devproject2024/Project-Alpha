package com.bumptech.glide.load.d.a;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.k;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class i implements k<ByteBuffer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final d f7141a = new d();

    public final /* bridge */ /* synthetic */ boolean a(Object obj, com.bumptech.glide.load.i iVar) throws IOException {
        return true;
    }

    public final /* synthetic */ v a(Object obj, int i2, int i3, com.bumptech.glide.load.i iVar) throws IOException {
        return this.f7141a.a(ImageDecoder.createSource((ByteBuffer) obj), i2, i3, iVar);
    }
}
