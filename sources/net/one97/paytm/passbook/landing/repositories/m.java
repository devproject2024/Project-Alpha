package net.one97.paytm.passbook.landing.repositories;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.alipay.mobile.h5container.api.H5Param;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.g.b.x;
import net.one97.paytm.passbook.beans.CJRCashWallet;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.f;
import net.one97.paytm.passbook.mapping.a.g;
import net.one97.paytm.passbook.mapping.a.i;
import net.one97.paytm.passbook.mapping.e;
import org.json.JSONException;
import org.json.JSONObject;

public final class m extends a {

    /* renamed from: b  reason: collision with root package name */
    public static final m f57814b = new m();

    static final class b<T> implements i.a<IJRDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f57816a;

        b(x.e eVar) {
            this.f57816a = eVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            IJRDataModel iJRDataModel = (IJRDataModel) obj;
            if (iJRDataModel instanceof CJRCashWallet) {
                f.a aVar = f.f57885d;
                ((y) this.f57816a.element).postValue(f.a.a(iJRDataModel));
            }
        }
    }

    private m() {
    }

    public final LiveData<f<CJRCashWallet>> b() {
        x.e eVar = new x.e();
        eVar.element = new y();
        k.a((Object) e.a(), "GTMLoader.getInstance()");
        String e2 = com.paytm.utility.b.e(a(), e.j());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("request", new JSONObject().put("isDetailInfo", H5Param.DEFAULT_LONG_PRESSO_LOGIN));
        } catch (JSONException unused) {
        }
        Map hashMap = new HashMap();
        if (a() != null && !TextUtils.isEmpty(net.one97.paytm.passbook.mapping.b.a(f57814b.a()))) {
            String a2 = net.one97.paytm.passbook.mapping.b.a(f57814b.a());
            k.a((Object) a2, "CJRServerUtility.getSSOToken(context)");
            hashMap.put("ssotoken", a2);
        }
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("Content-Type", "application/json");
        k.a((Object) e2, "mCheckUserBalanceUrl");
        a(e2, new CJRCashWallet(), hashMap, jSONObject.toString(), new b(eVar), new a(eVar));
        return (y) eVar.element;
    }

    static final class a implements g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f57815a;

        a(x.e eVar) {
            this.f57815a = eVar;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            if (iJRPaytmDataModel instanceof CJRCashWallet) {
                f.a aVar = f.f57885d;
                k.a((Object) networkCustomError, "networkError");
                ((y) this.f57815a.element).postValue(f.a.a(i2, iJRPaytmDataModel, networkCustomError));
            }
        }
    }
}
