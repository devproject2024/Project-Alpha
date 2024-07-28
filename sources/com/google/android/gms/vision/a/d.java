package com.google.android.gms.vision.a;

import android.util.SparseArray;
import com.business.merchant_payments.utility.StringUtility;
import com.google.android.gms.internal.vision.zzac;
import java.util.ArrayList;
import java.util.List;

public final class d implements c {

    /* renamed from: a  reason: collision with root package name */
    private zzac[] f12537a;

    /* renamed from: b  reason: collision with root package name */
    private List<b> f12538b;

    d(SparseArray<zzac> sparseArray) {
        this.f12537a = new zzac[sparseArray.size()];
        int i2 = 0;
        while (true) {
            zzac[] zzacArr = this.f12537a;
            if (i2 < zzacArr.length) {
                zzacArr[i2] = sparseArray.valueAt(i2);
                i2++;
            } else {
                return;
            }
        }
    }

    public final String a() {
        zzac[] zzacArr = this.f12537a;
        if (zzacArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(zzacArr[0].f11285c);
        for (int i2 = 1; i2 < this.f12537a.length; i2++) {
            sb.append(StringUtility.NEW_LINE);
            sb.append(this.f12537a[i2].f11285c);
        }
        return sb.toString();
    }

    public final List<? extends c> b() {
        zzac[] zzacArr = this.f12537a;
        if (zzacArr.length == 0) {
            return new ArrayList(0);
        }
        if (this.f12538b == null) {
            this.f12538b = new ArrayList(zzacArr.length);
            for (zzac bVar : this.f12537a) {
                this.f12538b.add(new b(bVar));
            }
        }
        return this.f12538b;
    }
}
