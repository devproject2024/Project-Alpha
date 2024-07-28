package com.google.android.play.core.assetpacks;

import java.util.HashMap;
import java.util.Map;

final class ba {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, Double> f37040a = new HashMap();

    ba() {
    }

    /* access modifiers changed from: package-private */
    public final synchronized double a(String str, bq bqVar) {
        double d2;
        d2 = 1.0d;
        if (bqVar instanceof au) {
            d2 = (((double) ((au) bqVar).f37006e) + 1.0d) / ((double) ((au) bqVar).f37007f);
        }
        this.f37040a.put(str, Double.valueOf(d2));
        return d2;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(String str) {
        this.f37040a.put(str, Double.valueOf(0.0d));
    }

    /* access modifiers changed from: package-private */
    public final synchronized double b(String str) {
        Double d2 = this.f37040a.get(str);
        if (d2 == null) {
            return 0.0d;
        }
        return d2.doubleValue();
    }
}
