package com.bumptech.glide.load.b;

import com.bumptech.glide.g.k;
import com.bumptech.glide.load.b.a.b;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.m;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

final class x implements g {

    /* renamed from: b  reason: collision with root package name */
    private static final com.bumptech.glide.g.g<Class<?>, byte[]> f6959b = new com.bumptech.glide.g.g<>(50);

    /* renamed from: c  reason: collision with root package name */
    private final b f6960c;

    /* renamed from: d  reason: collision with root package name */
    private final g f6961d;

    /* renamed from: e  reason: collision with root package name */
    private final g f6962e;

    /* renamed from: f  reason: collision with root package name */
    private final int f6963f;

    /* renamed from: g  reason: collision with root package name */
    private final int f6964g;

    /* renamed from: h  reason: collision with root package name */
    private final Class<?> f6965h;

    /* renamed from: i  reason: collision with root package name */
    private final i f6966i;
    private final m<?> j;

    x(b bVar, g gVar, g gVar2, int i2, int i3, m<?> mVar, Class<?> cls, i iVar) {
        this.f6960c = bVar;
        this.f6961d = gVar;
        this.f6962e = gVar2;
        this.f6963f = i2;
        this.f6964g = i3;
        this.j = mVar;
        this.f6965h = cls;
        this.f6966i = iVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof x) {
            x xVar = (x) obj;
            if (this.f6964g != xVar.f6964g || this.f6963f != xVar.f6963f || !k.a((Object) this.j, (Object) xVar.j) || !this.f6965h.equals(xVar.f6965h) || !this.f6961d.equals(xVar.f6961d) || !this.f6962e.equals(xVar.f6962e) || !this.f6966i.equals(xVar.f6966i)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (((((this.f6961d.hashCode() * 31) + this.f6962e.hashCode()) * 31) + this.f6963f) * 31) + this.f6964g;
        m<?> mVar = this.j;
        if (mVar != null) {
            hashCode = (hashCode * 31) + mVar.hashCode();
        }
        return (((hashCode * 31) + this.f6965h.hashCode()) * 31) + this.f6966i.hashCode();
    }

    public final void updateDiskCacheKey(MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f6960c.a(byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f6963f).putInt(this.f6964g).array();
        this.f6962e.updateDiskCacheKey(messageDigest);
        this.f6961d.updateDiskCacheKey(messageDigest);
        messageDigest.update(bArr);
        m<?> mVar = this.j;
        if (mVar != null) {
            mVar.updateDiskCacheKey(messageDigest);
        }
        this.f6966i.updateDiskCacheKey(messageDigest);
        byte[] b2 = f6959b.b(this.f6965h);
        if (b2 == null) {
            b2 = this.f6965h.getName().getBytes(f7264a);
            f6959b.b(this.f6965h, b2);
        }
        messageDigest.update(b2);
        this.f6960c.a(bArr);
    }

    public final String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f6961d + ", signature=" + this.f6962e + ", width=" + this.f6963f + ", height=" + this.f6964g + ", decodedResourceClass=" + this.f6965h + ", transformation='" + this.j + '\'' + ", options=" + this.f6966i + '}';
    }
}
