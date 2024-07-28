package com.airbnb.lottie.c.c;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.a.a.c;
import com.airbnb.lottie.a.a.d;
import com.airbnb.lottie.c.b.n;
import com.airbnb.lottie.c.e;
import java.util.Collections;
import java.util.List;

public final class f extends a {

    /* renamed from: h  reason: collision with root package name */
    private final d f5950h;

    f(com.airbnb.lottie.f fVar, d dVar) {
        super(fVar, dVar);
        this.f5950h = new d(fVar, this, new n("__container", dVar.f5941a, false));
        this.f5950h.a((List<c>) Collections.emptyList(), (List<c>) Collections.emptyList());
    }

    /* access modifiers changed from: package-private */
    public final void b(Canvas canvas, Matrix matrix, int i2) {
        this.f5950h.a(canvas, matrix, i2);
    }

    public final void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        this.f5950h.a(rectF, this.f5924a, z);
    }

    /* access modifiers changed from: protected */
    public final void b(e eVar, int i2, List<e> list, e eVar2) {
        this.f5950h.a(eVar, i2, list, eVar2);
    }
}
