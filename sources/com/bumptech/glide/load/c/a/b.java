package com.bumptech.glide.load.c.a;

import android.net.Uri;
import com.bumptech.glide.load.c.g;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.c.o;
import com.bumptech.glide.load.c.r;
import com.bumptech.glide.load.i;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class b implements n<Uri, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f6985a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"http", "https"})));

    /* renamed from: b  reason: collision with root package name */
    private final n<g, InputStream> f6986b;

    public final /* synthetic */ n.a a(Object obj, int i2, int i3, i iVar) {
        return this.f6986b.a(new g(((Uri) obj).toString()), i2, i3, iVar);
    }

    public final /* synthetic */ boolean a(Object obj) {
        return f6985a.contains(((Uri) obj).getScheme());
    }

    public b(n<g, InputStream> nVar) {
        this.f6986b = nVar;
    }

    public static class a implements o<Uri, InputStream> {
        public final n<Uri, InputStream> a(r rVar) {
            return new b(rVar.a(g.class, InputStream.class));
        }
    }
}
