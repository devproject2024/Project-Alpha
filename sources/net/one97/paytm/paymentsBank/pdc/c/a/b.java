package net.one97.paytm.paymentsBank.pdc.c.a;

import android.content.Context;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import net.one97.paytm.bankCommon.f.f;
import net.one97.paytm.bankCommon.g.c;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.paymentsBank.pdc.a;
import net.one97.paytm.paymentsBank.utils.o;

public final class b implements net.one97.paytm.paymentsBank.pdc.c.b.b {
    public final void a(Context context, f fVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("screen_name", "PDCSelectAtmActivity");
        net.one97.paytm.bankCommon.g.f b2 = a.b(context, new g.b() {
            public final void onResponse(Object obj) {
                f.this.a((IJRPaytmDataModel) obj);
            }
        }, new g.a() {
            public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                f.this.a(networkCustomError);
            }
        }, o.a().getNonPersonalisedPDCProductId(), a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap);
        b2.f16270b = getClass().getSimpleName();
        new c();
        c.a(b2);
    }
}
