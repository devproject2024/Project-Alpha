package com.squareup.picasso;

import android.content.Context;
import com.squareup.picasso.ab;
import com.squareup.picasso.w;
import i.n;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

class g extends ab {

    /* renamed from: a  reason: collision with root package name */
    final Context f45410a;

    g(Context context) {
        this.f45410a = context;
    }

    public boolean a(z zVar) {
        return "content".equals(zVar.f45479d.getScheme());
    }

    public ab.a a(z zVar, int i2) throws IOException {
        return new ab.a(n.a(b(zVar)), w.d.DISK);
    }

    /* access modifiers changed from: package-private */
    public final InputStream b(z zVar) throws FileNotFoundException {
        return this.f45410a.getContentResolver().openInputStream(zVar.f45479d);
    }
}
