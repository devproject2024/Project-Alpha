package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.c;
import com.google.android.gms.common.d;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public final SparseIntArray f8860a;

    /* renamed from: b  reason: collision with root package name */
    private d f8861b;

    public k() {
        this(c.a());
    }

    public k(d dVar) {
        this.f8860a = new SparseIntArray();
        s.a(dVar);
        this.f8861b = dVar;
    }

    public final int a(Context context, a.f fVar) {
        s.a(context);
        s.a(fVar);
        int e2 = fVar.e();
        int i2 = this.f8860a.get(e2, -1);
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        while (true) {
            if (i3 < this.f8860a.size()) {
                int keyAt = this.f8860a.keyAt(i3);
                if (keyAt > e2 && this.f8860a.get(keyAt) == 0) {
                    i2 = 0;
                    break;
                }
                i3++;
            } else {
                break;
            }
        }
        if (i2 == -1) {
            i2 = this.f8861b.a(context, e2);
        }
        this.f8860a.put(e2, i2);
        return i2;
    }
}
