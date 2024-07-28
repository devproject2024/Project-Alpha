package androidx.work.impl.background.systemalarm;

import android.content.Context;
import androidx.work.impl.b.p;
import androidx.work.impl.e;
import androidx.work.l;

public final class f implements e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5283a = l.a("SystemAlarmScheduler");

    /* renamed from: b  reason: collision with root package name */
    private final Context f5284b;

    public final boolean a() {
        return true;
    }

    public f(Context context) {
        this.f5284b = context.getApplicationContext();
    }

    public final void a(p... pVarArr) {
        for (p pVar : pVarArr) {
            l.a();
            String.format("Scheduling work with workSpecId %s", new Object[]{pVar.f5180a});
            this.f5284b.startService(b.a(this.f5284b, pVar.f5180a));
        }
    }

    public final void a(String str) {
        this.f5284b.startService(b.c(this.f5284b, str));
    }
}
