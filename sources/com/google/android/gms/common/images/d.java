package com.google.android.gms.common.images;

import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.internal.q;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public final class d extends c {

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<ImageManager.a> f8725c;

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f8723a});
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        d dVar = (d) obj;
        ImageManager.a aVar = (ImageManager.a) this.f8725c.get();
        ImageManager.a aVar2 = (ImageManager.a) dVar.f8725c.get();
        return aVar2 != null && aVar != null && q.a(aVar2, aVar) && q.a(dVar.f8723a, this.f8723a);
    }

    /* access modifiers changed from: protected */
    public final void a() {
        this.f8725c.get();
    }
}
