package com.google.android.exoplayer2.source.b;

import com.google.android.exoplayer2.extractor.f;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.source.b.e;
import com.google.android.exoplayer2.source.t;

public final class c implements e.b {

    /* renamed from: a  reason: collision with root package name */
    final t[] f32812a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f32813b;

    public c(int[] iArr, t[] tVarArr) {
        this.f32813b = iArr;
        this.f32812a = tVarArr;
    }

    public final q a(int i2) {
        int i3 = 0;
        while (true) {
            int[] iArr = this.f32813b;
            if (i3 >= iArr.length) {
                "Unmatched track of type: ".concat(String.valueOf(i2));
                l.d();
                return new f();
            } else if (i2 == iArr[i3]) {
                return this.f32812a[i3];
            } else {
                i3++;
            }
        }
    }

    public final void a(long j) {
        for (t tVar : this.f32812a) {
            if (tVar != null) {
                tVar.b(j);
            }
        }
    }
}
