package androidx.work.impl.a.a;

import android.content.Context;
import android.os.Build;
import androidx.work.impl.a.b;
import androidx.work.impl.a.b.g;
import androidx.work.impl.b.p;
import androidx.work.impl.utils.b.a;
import androidx.work.l;
import androidx.work.m;

public final class f extends c<b> {

    /* renamed from: c  reason: collision with root package name */
    private static final String f5115c = l.a("NetworkNotRoamingCtrlr");

    /* access modifiers changed from: package-private */
    public final /* synthetic */ boolean b(Object obj) {
        b bVar = (b) obj;
        if (Build.VERSION.SDK_INT >= 24) {
            return !bVar.f5116a || !bVar.f5119d;
        }
        l.a();
        return !bVar.f5116a;
    }

    public f(Context context, a aVar) {
        super(g.a(context, aVar).f5143c);
    }

    /* access modifiers changed from: package-private */
    public final boolean a(p pVar) {
        return pVar.j.f5073b == m.NOT_ROAMING;
    }
}
