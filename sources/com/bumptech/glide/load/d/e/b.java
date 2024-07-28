package com.bumptech.glide.load.d.e;

import android.graphics.Bitmap;
import com.bumptech.glide.gifdecoder.a;
import com.bumptech.glide.load.b.a.e;

public final class b implements a.C0092a {

    /* renamed from: a  reason: collision with root package name */
    private final e f7212a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.load.b.a.b f7213b;

    public b(e eVar, com.bumptech.glide.load.b.a.b bVar) {
        this.f7212a = eVar;
        this.f7213b = bVar;
    }

    public final Bitmap a(int i2, int i3, Bitmap.Config config) {
        return this.f7212a.b(i2, i3, config);
    }

    public final void a(Bitmap bitmap) {
        this.f7212a.a(bitmap);
    }

    public final byte[] a(int i2) {
        com.bumptech.glide.load.b.a.b bVar = this.f7213b;
        if (bVar == null) {
            return new byte[i2];
        }
        return (byte[]) bVar.a(i2, byte[].class);
    }

    public final void a(byte[] bArr) {
        com.bumptech.glide.load.b.a.b bVar = this.f7213b;
        if (bVar != null) {
            bVar.a(bArr);
        }
    }

    public final int[] b(int i2) {
        com.bumptech.glide.load.b.a.b bVar = this.f7213b;
        if (bVar == null) {
            return new int[i2];
        }
        return (int[]) bVar.a(i2, int[].class);
    }

    public final void a(int[] iArr) {
        com.bumptech.glide.load.b.a.b bVar = this.f7213b;
        if (bVar != null) {
            bVar.a(iArr);
        }
    }
}
