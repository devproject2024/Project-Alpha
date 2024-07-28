package com.bumptech.glide.load.c.a;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.f.d;
import com.bumptech.glide.load.a.a.b;
import com.bumptech.glide.load.a.a.c;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.c.o;
import com.bumptech.glide.load.c.r;
import com.bumptech.glide.load.i;
import java.io.InputStream;

public final class c implements n<Uri, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f6988a;

    public final /* synthetic */ n.a a(Object obj, int i2, int i3, i iVar) {
        Uri uri = (Uri) obj;
        if (!b.a(i2, i3)) {
            return null;
        }
        d dVar = new d(uri);
        Context context = this.f6988a;
        return new n.a(dVar, com.bumptech.glide.load.a.a.c.a(context, uri, new c.a(context.getContentResolver())));
    }

    public final /* synthetic */ boolean a(Object obj) {
        Uri uri = (Uri) obj;
        return b.a(uri) && !b.b(uri);
    }

    public c(Context context) {
        this.f6988a = context.getApplicationContext();
    }

    public static class a implements o<Uri, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f6989a;

        public a(Context context) {
            this.f6989a = context;
        }

        public final n<Uri, InputStream> a(r rVar) {
            return new c(this.f6989a);
        }
    }
}
