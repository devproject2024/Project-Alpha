package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.ad;
import com.google.android.exoplayer2.g.ae;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final int f33509a;

    /* renamed from: b  reason: collision with root package name */
    public final ad[] f33510b;

    /* renamed from: c  reason: collision with root package name */
    public final g f33511c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f33512d;

    public j(ad[] adVarArr, f[] fVarArr, Object obj) {
        this.f33510b = adVarArr;
        this.f33511c = new g(fVarArr);
        this.f33512d = obj;
        this.f33509a = adVarArr.length;
    }

    public final boolean a(int i2) {
        return this.f33510b[i2] != null;
    }

    public final boolean a(j jVar) {
        if (jVar == null || jVar.f33511c.f33504a != this.f33511c.f33504a) {
            return false;
        }
        for (int i2 = 0; i2 < this.f33511c.f33504a; i2++) {
            if (!a(jVar, i2)) {
                return false;
            }
        }
        return true;
    }

    public final boolean a(j jVar, int i2) {
        if (jVar != null && ae.a((Object) this.f33510b[i2], (Object) jVar.f33510b[i2]) && ae.a((Object) this.f33511c.f33505b[i2], (Object) jVar.f33511c.f33505b[i2])) {
            return true;
        }
        return false;
    }
}
