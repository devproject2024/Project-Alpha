package net.one97.paytm.payments.b.a;

import android.content.Context;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import net.one97.paytm.common.entity.paymentsbank.CustProductList;
import net.one97.paytm.j.c;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.utils.t;

public final class a {
    public static com.paytm.network.a a(Context context, final b bVar, a.c cVar, a.b bVar2, HashMap<String, String> hashMap) {
        HashMap hashMap2 = new HashMap();
        hashMap2.put("User-Token", t.b(context));
        hashMap2.put("Content-Type", "application/json");
        hashMap2.put("channel", UpiConstants.B2C_ANDROID);
        c.a();
        String e2 = com.paytm.utility.b.e(context, c.ac());
        com.paytm.network.b bVar3 = new com.paytm.network.b();
        bVar3.f42877a = context;
        bVar3.f42879c = a.C0715a.GET;
        bVar3.f42880d = e2;
        bVar3.f42882f = hashMap2;
        bVar3.f42885i = new CustProductList();
        bVar3.k = false;
        bVar3.f42878b = cVar;
        bVar3.o = hashMap.get("screen_name");
        bVar3.n = bVar2;
        bVar3.f42877a = context;
        bVar3.j = new b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                bVar.onApiSuccess(iJRPaytmDataModel);
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                bVar.handleErrorCode(i2, iJRPaytmDataModel, networkCustomError);
            }
        };
        return bVar3.l();
    }
}
