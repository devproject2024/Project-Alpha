package com.google.android.exoplayer2.f.a;

import android.net.Uri;
import com.google.android.exoplayer2.g.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, Object> f32345a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f32346b = new ArrayList();

    public static j a(j jVar, Uri uri) {
        if (uri == null) {
            return jVar.a("exo_redir");
        }
        return jVar.a("exo_redir", (Object) uri.toString());
    }

    public final j a(String str, long j) {
        return a(str, (Object) Long.valueOf(j));
    }

    private j a(String str) {
        this.f32346b.add(str);
        this.f32345a.remove(str);
        return this;
    }

    private j a(String str, Object obj) {
        this.f32345a.put(a.a(str), a.a(obj));
        this.f32346b.remove(str);
        return this;
    }
}
