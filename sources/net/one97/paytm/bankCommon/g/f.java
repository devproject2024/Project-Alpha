package net.one97.paytm.bankCommon.g;

import android.content.Context;
import com.paytm.network.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.Map;
import net.one97.paytm.bankCommon.g.g;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private String f16269a;

    /* renamed from: b  reason: collision with root package name */
    public String f16270b;

    /* access modifiers changed from: protected */
    public final b a(Context context, String str, final g.b bVar, final g.a aVar, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map) {
        this.f16269a = str;
        b bVar2 = new b();
        bVar2.f42877a = context;
        bVar2.f42880d = str;
        bVar2.f42882f = map;
        bVar2.f42885i = iJRPaytmDataModel;
        bVar2.k = false;
        bVar2.j = new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                bVar.onResponse(iJRPaytmDataModel);
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                aVar.onErrorResponse(i2, iJRPaytmDataModel, networkCustomError);
            }
        };
        return bVar2;
    }

    public final void a(String str) {
        this.f16270b = str;
    }
}
