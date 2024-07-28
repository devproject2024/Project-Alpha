package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import com.bumptech.glide.b;
import com.bumptech.glide.e.a.f;
import com.bumptech.glide.e.g;
import com.bumptech.glide.e.h;
import com.bumptech.glide.load.b.a.b;
import com.bumptech.glide.load.b.k;
import java.util.List;
import java.util.Map;

public final class d extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    static final j<?, ?> f6479a = new a();

    /* renamed from: b  reason: collision with root package name */
    public final b f6480b;

    /* renamed from: c  reason: collision with root package name */
    public final g f6481c;

    /* renamed from: d  reason: collision with root package name */
    final List<g<Object>> f6482d;

    /* renamed from: e  reason: collision with root package name */
    final Map<Class<?>, j<?, ?>> f6483e;

    /* renamed from: f  reason: collision with root package name */
    final k f6484f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f6485g;

    /* renamed from: h  reason: collision with root package name */
    public final int f6486h;

    /* renamed from: i  reason: collision with root package name */
    private final f f6487i;
    private final b.a j;
    private h k;

    public d(Context context, com.bumptech.glide.load.b.a.b bVar, g gVar, f fVar, b.a aVar, Map<Class<?>, j<?, ?>> map, List<g<Object>> list, k kVar, boolean z, int i2) {
        super(context.getApplicationContext());
        this.f6480b = bVar;
        this.f6481c = gVar;
        this.f6487i = fVar;
        this.j = aVar;
        this.f6482d = list;
        this.f6483e = map;
        this.f6484f = kVar;
        this.f6485g = z;
        this.f6486h = i2;
    }

    public final synchronized h a() {
        if (this.k == null) {
            h a2 = this.j.a();
            a2.v = true;
            this.k = a2;
        }
        return this.k;
    }
}
