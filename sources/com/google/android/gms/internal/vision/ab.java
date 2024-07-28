package com.google.android.gms.internal.vision;

final class ab extends z<Long> {
    ab(ad adVar, String str, Long l) {
        super(adVar, str, l, (byte) 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final Long a(Object obj) {
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof String) {
            try {
                return Long.valueOf(Long.parseLong((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        String b2 = super.b();
        String valueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(String.valueOf(b2).length() + 25 + String.valueOf(valueOf).length());
        sb.append("Invalid long value for ");
        sb.append(b2);
        sb.append(": ");
        sb.append(valueOf);
        return null;
    }
}
