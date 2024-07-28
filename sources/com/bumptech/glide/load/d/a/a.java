package com.bumptech.glide.load.d.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.g.j;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.k;
import java.io.IOException;

public final class a<DataType> implements k<DataType, BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final k<DataType, Bitmap> f7105a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources f7106b;

    public a(Resources resources, k<DataType, Bitmap> kVar) {
        this.f7106b = (Resources) j.a(resources, "Argument must not be null");
        this.f7105a = (k) j.a(kVar, "Argument must not be null");
    }

    public final boolean a(DataType datatype, i iVar) throws IOException {
        return this.f7105a.a(datatype, iVar);
    }

    public final v<BitmapDrawable> a(DataType datatype, int i2, int i3, i iVar) throws IOException {
        return w.a(this.f7106b, this.f7105a.a(datatype, i2, i3, iVar));
    }
}
