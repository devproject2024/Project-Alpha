package androidx.work.impl.a.a;

import android.content.Context;
import android.os.Build;
import androidx.work.impl.a.b;
import androidx.work.impl.a.b.g;
import androidx.work.impl.b.p;
import androidx.work.impl.utils.b.a;
import androidx.work.m;

public final class d extends c<b> {
    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ boolean b(Object obj) {
        b bVar = (b) obj;
        return Build.VERSION.SDK_INT >= 26 ? !bVar.f5116a || !bVar.f5117b : !bVar.f5116a;
    }

    public d(Context context, a aVar) {
        super(g.a(context, aVar).f5143c);
    }

    /* access modifiers changed from: package-private */
    public final boolean a(p pVar) {
        return pVar.j.f5073b == m.CONNECTED;
    }
}
