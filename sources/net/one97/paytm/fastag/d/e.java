package net.one97.paytm.fastag.d;

import android.content.Context;
import com.paytm.network.a;
import com.paytm.network.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.Map;
import net.one97.paytm.fastag.d.g;

public abstract class e {
    public abstract String a();

    /* access modifiers changed from: protected */
    public final b a(Context context, String str, final g.a aVar, final d dVar, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map) {
        b bVar = new b();
        bVar.f42877a = context;
        bVar.f42880d = str;
        bVar.f42882f = map;
        bVar.f42885i = iJRPaytmDataModel;
        bVar.n = a.b.USER_FACING;
        bVar.j = new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                aVar.onResponse(iJRPaytmDataModel);
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                dVar.onErrorResponse(i2, iJRPaytmDataModel, networkCustomError);
            }
        };
        bVar.f42878b = a.c.PAYMENTSBANK;
        return bVar;
    }
}
