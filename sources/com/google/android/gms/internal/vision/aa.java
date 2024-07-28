package com.google.android.gms.internal.vision;

final class aa extends z<Boolean> {
    aa(ad adVar, String str, Boolean bool) {
        super(adVar, str, bool, (byte) 0);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object a(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (g.f11159b.matcher(str).matches()) {
                return Boolean.TRUE;
            }
            if (g.f11160c.matcher(str).matches()) {
                return Boolean.FALSE;
            }
        }
        String b2 = super.b();
        String valueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(String.valueOf(b2).length() + 28 + String.valueOf(valueOf).length());
        sb.append("Invalid boolean value for ");
        sb.append(b2);
        sb.append(": ");
        sb.append(valueOf);
        return null;
    }
}
