package com.squareup.picasso;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import com.squareup.picasso.ab;
import com.squareup.picasso.w;
import java.io.IOException;

final class ac extends ab {

    /* renamed from: a  reason: collision with root package name */
    private final Context f45364a;

    ac(Context context) {
        this.f45364a = context;
    }

    public final boolean a(z zVar) {
        if (zVar.f45480e != 0) {
            return true;
        }
        return "android.resource".equals(zVar.f45479d.getScheme());
    }

    public final ab.a a(z zVar, int i2) throws IOException {
        Resources a2 = ai.a(this.f45364a, zVar);
        int a3 = ai.a(a2, zVar);
        BitmapFactory.Options c2 = c(zVar);
        if (a(c2)) {
            BitmapFactory.decodeResource(a2, a3, c2);
            a(zVar.f45483h, zVar.f45484i, c2, zVar);
        }
        return new ab.a(BitmapFactory.decodeResource(a2, a3, c2), w.d.DISK);
    }
}
