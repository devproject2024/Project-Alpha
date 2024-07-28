package net.one97.paytm.paymentslimit.b;

import android.content.Context;
import com.paytm.network.a;
import com.paytm.network.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.Map;
import net.one97.paytm.paymentslimit.b.h;

public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    public a f59303a;

    /* access modifiers changed from: protected */
    public final b a(Context context, String str, final h.a aVar, final f fVar, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map) {
        b bVar = new b();
        bVar.f42877a = context;
        bVar.f42880d = str;
        bVar.f42882f = map;
        bVar.f42885i = iJRPaytmDataModel;
        bVar.n = a.b.USER_FACING;
        bVar.j = new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                aVar.a(iJRPaytmDataModel);
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                fVar.a(networkCustomError);
            }
        };
        bVar.f42878b = a.c.PAYMENTSBANK;
        return bVar;
    }
}
