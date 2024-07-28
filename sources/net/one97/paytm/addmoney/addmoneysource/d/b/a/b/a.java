package net.one97.paytm.addmoney.addmoneysource.d.b.a.b;

import android.content.Context;
import com.paytm.network.f;
import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.addmoney.i;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.profile.b.a;

public final class a implements net.one97.paytm.addmoney.addmoneysource.d.b.a.a {

    /* renamed from: b  reason: collision with root package name */
    private static a f48243b;

    /* renamed from: a  reason: collision with root package name */
    private Context f48244a;

    public final boolean b(String str) {
        return false;
    }

    private a(Context context) {
        this.f48244a = context;
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f48243b == null) {
                f48243b = new a(context);
            }
            aVar = f48243b;
        }
        return aVar;
    }

    public final void a(String str) {
        f.b(this.f48244a).cancelAll((Object) str);
        f48243b = null;
    }

    public final void a(final i iVar, String str) {
        g.a().a((a.C1382a) new a.C1382a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                iVar.a(upiBaseDataModel);
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                iVar.a(new NetworkCustomError(upiCustomVolleyError.toString()));
            }
        }, str, this.f48244a.getClass().getSimpleName());
    }
}
