package com.bumptech.glide.e;

import com.bumptech.glide.load.b.j;
import com.bumptech.glide.load.g;

public final class h extends a<h> {
    public static h b(j jVar) {
        return (h) new h().a(jVar);
    }

    public static h b(g gVar) {
        return (h) new h().a(gVar);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.bumptech.glide.load.m, com.bumptech.glide.load.m<android.graphics.Bitmap>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.bumptech.glide.e.h b(com.bumptech.glide.load.m<android.graphics.Bitmap> r2) {
        /*
            com.bumptech.glide.e.h r0 = new com.bumptech.glide.e.h
            r0.<init>()
            r1 = 1
            com.bumptech.glide.e.a r2 = r0.a((com.bumptech.glide.load.m<android.graphics.Bitmap>) r2, (boolean) r1)
            com.bumptech.glide.e.h r2 = (com.bumptech.glide.e.h) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.e.h.b(com.bumptech.glide.load.m):com.bumptech.glide.e.h");
    }

    public static h a(Class<?> cls) {
        a hVar = new h();
        while (hVar.x) {
            hVar = hVar.clone();
        }
        hVar.u = (Class) com.bumptech.glide.g.j.a(cls, "Argument must not be null");
        hVar.f6505c |= 4096;
        return (h) super.m();
    }
}
