package com.bumptech.glide.load.c;

import android.net.Uri;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.i;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class x<Data> implements n<Uri, Data> {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f7094a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"http", "https"})));

    /* renamed from: b  reason: collision with root package name */
    private final n<g, Data> f7095b;

    public final /* synthetic */ n.a a(Object obj, int i2, int i3, i iVar) {
        return this.f7095b.a(new g(((Uri) obj).toString()), i2, i3, iVar);
    }

    public final /* synthetic */ boolean a(Object obj) {
        return f7094a.contains(((Uri) obj).getScheme());
    }

    public x(n<g, Data> nVar) {
        this.f7095b = nVar;
    }

    public static class a implements o<Uri, InputStream> {
        public final n<Uri, InputStream> a(r rVar) {
            return new x(rVar.a(g.class, InputStream.class));
        }
    }
}
