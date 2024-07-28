package com.alipay.imobile.network.quake.h.a;

import com.business.merchant_payments.utility.StringUtility;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    final String[] f14862a;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final List<String> f14863a = new ArrayList(20);
    }

    /* synthetic */ e(a aVar, byte b2) {
        this(aVar);
    }

    public final String a(int i2) {
        return this.f14862a[i2 * 2];
    }

    public final String b(int i2) {
        return this.f14862a[(i2 * 2) + 1];
    }

    private e(a aVar) {
        this.f14862a = (String[]) aVar.f14863a.toArray(new String[aVar.f14863a.size()]);
    }

    public final List<String> a(String str) {
        int length = this.f14862a.length / 2;
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equalsIgnoreCase(a(i2))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(b(i2));
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int length = this.f14862a.length / 2;
        for (int i2 = 0; i2 < length; i2++) {
            sb.append(a(i2));
            sb.append(": ");
            sb.append(b(i2));
            sb.append(StringUtility.NEW_LINE);
        }
        return sb.toString();
    }
}
