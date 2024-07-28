package net.one97.paytm.bankCommon.h;

import android.content.Context;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.concurrent.TimeUnit;
import net.one97.paytm.bankCommon.b.b;
import net.one97.paytm.bankCommon.g.f;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankOpen.d.c;

public class a implements g.a, g.b<IJRPaytmDataModel> {

    /* renamed from: c  reason: collision with root package name */
    private static volatile a f16274c;

    /* renamed from: a  reason: collision with root package name */
    public Context f16275a;

    /* renamed from: b  reason: collision with root package name */
    public g.a f16276b;

    /* renamed from: d  reason: collision with root package name */
    private b f16277d;

    public /* bridge */ /* synthetic */ void onResponse(Object obj) {
    }

    public static a a() {
        if (f16274c == null) {
            synchronized (a.class.getSimpleName()) {
                if (f16274c == null) {
                    f16274c = new a();
                }
            }
        }
        return f16274c;
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        g.a aVar = this.f16276b;
        if (aVar != null) {
            aVar.onErrorResponse(i2, iJRPaytmDataModel, networkCustomError);
        }
        b bVar = this.f16277d;
        if (bVar != null && bVar.f16208c != null) {
            this.f16277d.f16208c.onErrorResponse(i2, iJRPaytmDataModel, networkCustomError);
        }
    }

    public static boolean a(Context context) {
        boolean z;
        boolean z2 = false;
        if (!(System.currentTimeMillis() > c.a(context.getApplicationContext()).b("prodBankServiceCache", 0, true) + TimeUnit.DAYS.toMillis(1)) || !com.paytm.utility.b.c(context)) {
            z = false;
        } else {
            context.getApplicationContext();
            new net.one97.paytm.bankCommon.g.c();
            net.one97.paytm.bankCommon.g.c.a((f) null);
            z = true;
        }
        if (System.currentTimeMillis() > c.a(context.getApplicationContext()).b("secureBankServiceCache", 0, true) + TimeUnit.DAYS.toMillis(1)) {
            z2 = true;
        }
        if (z2) {
            com.paytm.utility.b.c(context);
        }
        return z;
    }
}
