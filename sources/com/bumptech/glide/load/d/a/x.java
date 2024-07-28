package com.bumptech.glide.load.d.a;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.d.a.u;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.k;
import java.io.IOException;

public final class x implements k<ParcelFileDescriptor, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final o f7188a;

    public final /* synthetic */ v a(Object obj, int i2, int i3, i iVar) throws IOException {
        o oVar = this.f7188a;
        return oVar.a((u) new u.b((ParcelFileDescriptor) obj, oVar.f7167h, oVar.f7166g), i2, i3, iVar, o.f7164f);
    }

    public x(o oVar) {
        this.f7188a = oVar;
    }

    public final /* bridge */ /* synthetic */ boolean a(Object obj, i iVar) throws IOException {
        return o.a();
    }
}
