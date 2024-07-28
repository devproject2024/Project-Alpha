package net.one97.paytm.upi;

import android.content.Context;
import kotlin.g.b.k;
import net.one97.paytm.p2p.theme.DealsEntity;
import net.one97.paytm.p2p.theme.ThemeData;
import net.one97.paytm.p2p.theme.g;
import net.one97.paytm.upi.f.a;

public final class m implements a {
    public final void a(Context context) {
        k.c(context, "context");
        g.a(context).c();
    }

    public final DealsEntity b(Context context) {
        k.c(context, "context");
        g a2 = g.a(context);
        k.a((Object) a2, "P2PThemesDownloadManager.getInstance(context)");
        return a2.a();
    }

    public final ThemeData a(Context context, String str) {
        k.c(context, "context");
        return g.a(context).a(str);
    }
}
