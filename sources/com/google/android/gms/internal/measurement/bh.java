package com.google.android.gms.internal.measurement;

final class bh extends bd<Double> {
    bh(bj bjVar, String str, Double d2) {
        super(bjVar, str, d2, (byte) 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final Double a(Object obj) {
        if (obj instanceof Double) {
            return (Double) obj;
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if (obj instanceof String) {
            try {
                return Double.valueOf(Double.parseDouble((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        String b2 = super.b();
        String valueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(String.valueOf(b2).length() + 27 + String.valueOf(valueOf).length());
        sb.append("Invalid double value for ");
        sb.append(b2);
        sb.append(": ");
        sb.append(valueOf);
        return null;
    }
}
