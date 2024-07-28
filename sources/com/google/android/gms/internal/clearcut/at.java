package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.bf;
import java.io.IOException;
import java.util.Map;

final class at extends as<bf.e> {
    at() {
    }

    /* access modifiers changed from: package-private */
    public final int a(Map.Entry<?, ?> entry) {
        return ((bf.e) entry.getKey()).f9187a;
    }

    /* access modifiers changed from: package-private */
    public final aw<bf.e> a(Object obj) {
        return ((bf.d) obj).zzjv;
    }

    /* access modifiers changed from: package-private */
    public final void a(ep epVar, Map.Entry<?, ?> entry) throws IOException {
        bf.e eVar = (bf.e) entry.getKey();
        switch (au.f9165a[eVar.f9188b.ordinal()]) {
            case 1:
                epVar.a(eVar.f9187a, ((Double) entry.getValue()).doubleValue());
                return;
            case 2:
                epVar.a(eVar.f9187a, ((Float) entry.getValue()).floatValue());
                return;
            case 3:
                epVar.a(eVar.f9187a, ((Long) entry.getValue()).longValue());
                return;
            case 4:
                epVar.c(eVar.f9187a, ((Long) entry.getValue()).longValue());
                return;
            case 5:
                epVar.c(eVar.f9187a, ((Integer) entry.getValue()).intValue());
                return;
            case 6:
                epVar.d(eVar.f9187a, ((Long) entry.getValue()).longValue());
                return;
            case 7:
                epVar.d(eVar.f9187a, ((Integer) entry.getValue()).intValue());
                return;
            case 8:
                epVar.a(eVar.f9187a, ((Boolean) entry.getValue()).booleanValue());
                return;
            case 9:
                epVar.e(eVar.f9187a, ((Integer) entry.getValue()).intValue());
                return;
            case 10:
                epVar.a(eVar.f9187a, ((Integer) entry.getValue()).intValue());
                return;
            case 11:
                epVar.b(eVar.f9187a, ((Long) entry.getValue()).longValue());
                return;
            case 12:
                epVar.f(eVar.f9187a, ((Integer) entry.getValue()).intValue());
                return;
            case 13:
                epVar.e(eVar.f9187a, ((Long) entry.getValue()).longValue());
                return;
            case 14:
                epVar.c(eVar.f9187a, ((Integer) entry.getValue()).intValue());
                return;
            case 15:
                epVar.a(eVar.f9187a, (ab) entry.getValue());
                return;
            case 16:
                epVar.a(eVar.f9187a, (String) entry.getValue());
                return;
            case 17:
                epVar.b(eVar.f9187a, (Object) entry.getValue(), (de) cz.a().a(entry.getValue().getClass()));
                return;
            case 18:
                epVar.a(eVar.f9187a, (Object) entry.getValue(), (de) cz.a().a(entry.getValue().getClass()));
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Object obj, aw<bf.e> awVar) {
        ((bf.d) obj).zzjv = awVar;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(cm cmVar) {
        return cmVar instanceof bf.d;
    }

    /* access modifiers changed from: package-private */
    public final void c(Object obj) {
        a(obj).b();
    }

    /* access modifiers changed from: package-private */
    public final aw<bf.e> b(Object obj) {
        aw<bf.e> a2 = a(obj);
        if (!a2.f9170b) {
            return a2;
        }
        aw<bf.e> awVar = (aw) a2.clone();
        a(obj, awVar);
        return awVar;
    }
}
