package com.bumptech.glide.load.c.a;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.a.a.b;
import com.bumptech.glide.load.a.a.c;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.c.o;
import com.bumptech.glide.load.c.r;
import com.bumptech.glide.load.d.a.af;
import com.bumptech.glide.load.i;
import java.io.InputStream;

public final class d implements n<Uri, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f6990a;

    public final /* synthetic */ n.a a(Object obj, int i2, int i3, i iVar) {
        Uri uri = (Uri) obj;
        if (!b.a(i2, i3)) {
            return null;
        }
        Long l = (Long) iVar.a(af.f7122a);
        if (!(l != null && l.longValue() == -1)) {
            return null;
        }
        com.bumptech.glide.f.d dVar = new com.bumptech.glide.f.d(uri);
        Context context = this.f6990a;
        return new n.a(dVar, c.a(context, uri, new c.b(context.getContentResolver())));
    }

    public final /* synthetic */ boolean a(Object obj) {
        Uri uri = (Uri) obj;
        return b.a(uri) && b.b(uri);
    }

    public d(Context context) {
        this.f6990a = context.getApplicationContext();
    }

    public static class a implements o<Uri, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f6991a;

        public a(Context context) {
            this.f6991a = context;
        }

        public final n<Uri, InputStream> a(r rVar) {
            return new d(this.f6991a);
        }
    }
}
