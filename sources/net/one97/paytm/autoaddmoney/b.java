package net.one97.paytm.autoaddmoney;

import android.content.Context;
import net.one97.paytm.autoaddmoney.data.source.a.a;
import net.one97.paytm.autoaddmoney.data.source.b;
import net.one97.paytm.autoaddmoney.data.source.local.AutoAddmoneyDatabase;
import net.one97.paytm.autoaddmoney.data.source.local.c;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f49147a = new b();

    private b() {
    }

    public static net.one97.paytm.autoaddmoney.data.source.b a(Context context) {
        AutoAddmoneyDatabase.a aVar = AutoAddmoneyDatabase.f49243a;
        AutoAddmoneyDatabase a2 = AutoAddmoneyDatabase.a.a(context);
        b.a aVar2 = net.one97.paytm.autoaddmoney.data.source.b.f49239b;
        c.a aVar3 = c.f49249a;
        return b.a.a(a.f49217a, c.a.a(new net.one97.paytm.autoaddmoney.util.b(), a2.a()));
    }
}
