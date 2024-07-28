package com.google.android.exoplayer2.e.h;

import android.text.SpannableStringBuilder;
import com.business.merchant_payments.utility.StringUtility;
import com.google.android.exoplayer2.e.b;
import com.google.android.exoplayer2.e.e;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.ae;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class i implements e {

    /* renamed from: a  reason: collision with root package name */
    private final List<e> f31639a;

    /* renamed from: b  reason: collision with root package name */
    private final int f31640b;

    /* renamed from: c  reason: collision with root package name */
    private final long[] f31641c = new long[(this.f31640b * 2)];

    /* renamed from: d  reason: collision with root package name */
    private final long[] f31642d;

    public i(List<e> list) {
        this.f31639a = list;
        this.f31640b = list.size();
        for (int i2 = 0; i2 < this.f31640b; i2++) {
            e eVar = list.get(i2);
            int i3 = i2 * 2;
            this.f31641c[i3] = eVar.p;
            this.f31641c[i3 + 1] = eVar.q;
        }
        long[] jArr = this.f31641c;
        this.f31642d = Arrays.copyOf(jArr, jArr.length);
        Arrays.sort(this.f31642d);
    }

    public final int a(long j) {
        int a2 = ae.a(this.f31642d, j, false, false);
        if (a2 < this.f31642d.length) {
            return a2;
        }
        return -1;
    }

    public final int b() {
        return this.f31642d.length;
    }

    public final long a_(int i2) {
        boolean z = true;
        a.a(i2 >= 0);
        if (i2 >= this.f31642d.length) {
            z = false;
        }
        a.a(z);
        return this.f31642d[i2];
    }

    public final List<b> b(long j) {
        SpannableStringBuilder spannableStringBuilder = null;
        e eVar = null;
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < this.f31640b; i2++) {
            long[] jArr = this.f31641c;
            int i3 = i2 * 2;
            if (jArr[i3] <= j && j < jArr[i3 + 1]) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                e eVar2 = this.f31639a.get(i2);
                if (!(eVar2.f31449e == Float.MIN_VALUE && eVar2.f31452h == Float.MIN_VALUE)) {
                    arrayList.add(eVar2);
                } else if (eVar == null) {
                    eVar = eVar2;
                } else if (spannableStringBuilder == null) {
                    spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append(eVar.f31446b).append(StringUtility.NEW_LINE).append(eVar2.f31446b);
                } else {
                    spannableStringBuilder.append(StringUtility.NEW_LINE).append(eVar2.f31446b);
                }
            }
        }
        if (spannableStringBuilder != null) {
            arrayList.add(new e(spannableStringBuilder));
        } else if (eVar != null) {
            arrayList.add(eVar);
        }
        if (arrayList != null) {
            return arrayList;
        }
        return Collections.emptyList();
    }
}
