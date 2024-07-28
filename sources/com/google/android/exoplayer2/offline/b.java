package com.google.android.exoplayer2.offline;

import android.net.Uri;
import com.google.android.exoplayer2.f.z;
import com.google.android.exoplayer2.offline.a;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public final class b<T extends a<T>> implements z.a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final z.a<? extends T> f32768a;

    /* renamed from: b  reason: collision with root package name */
    private final List<StreamKey> f32769b;

    public b(z.a<? extends T> aVar, List<StreamKey> list) {
        this.f32768a = aVar;
        this.f32769b = list;
    }

    public final /* synthetic */ Object a(Uri uri, InputStream inputStream) throws IOException {
        a aVar = (a) this.f32768a.a(uri, inputStream);
        List<StreamKey> list = this.f32769b;
        return (list == null || list.isEmpty()) ? aVar : (a) aVar.a(this.f32769b);
    }
}
