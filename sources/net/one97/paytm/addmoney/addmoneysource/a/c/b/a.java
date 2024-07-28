package net.one97.paytm.addmoney.addmoneysource.a.c.b;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.paytm.network.f;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import java.util.HashMap;
import net.one97.paytm.addmoney.common.binRequest.CJRBinRequest;
import net.one97.paytm.addmoney.common.binRequest.CJRBinRequestBody;
import net.one97.paytm.addmoney.common.model.Head;
import net.one97.paytm.addmoney.h;
import net.one97.paytm.addmoney.utils.AddMoneyUtils;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.wallet.newdesign.addmoney.model.CJRBinResponse;

public final class a implements net.one97.paytm.addmoney.addmoneysource.a.c.a {

    /* renamed from: a  reason: collision with root package name */
    private static a f48136a;

    /* renamed from: b  reason: collision with root package name */
    private Context f48137b;

    /* renamed from: c  reason: collision with root package name */
    private Fragment f48138c;

    private a(Context context, Fragment fragment) {
        this.f48137b = context;
        this.f48138c = fragment;
    }

    public static synchronized a a(Context context, Fragment fragment) {
        a aVar;
        synchronized (a.class) {
            if (f48136a == null) {
                f48136a = new a(context, fragment);
            }
            aVar = f48136a;
        }
        return aVar;
    }

    public final void a(String str) {
        f.b(this.f48137b).cancelAll((Object) str);
        f48136a = null;
    }

    public final void a(String str, String str2, final h hVar, String str3) {
        HashMap hashMap = new HashMap();
        CJRBinRequest cJRBinRequest = new CJRBinRequest();
        Head head = new Head(SDKConstants.SSO, com.paytm.utility.a.q(this.f48137b), "M", str2, "1", "V1");
        head.setRequestTimeStamp("1");
        CJRBinRequestBody cJRBinRequestBody = new CJRBinRequestBody();
        cJRBinRequestBody.setBin(str);
        cJRBinRequestBody.setIndutryTypeId(SDKConstants.KEY_RETAIL);
        cJRBinRequestBody.setDeviceId(b.A(this.f48137b));
        cJRBinRequestBody.setChannelId("WEB");
        cJRBinRequestBody.setSignature("1");
        cJRBinRequestBody.setRequestType("OFFLINE");
        cJRBinRequestBody.setOrderId("123456");
        cJRBinRequest.setBody(cJRBinRequestBody);
        cJRBinRequest.setHead(head);
        String a2 = AddMoneyUtils.a((Object) cJRBinRequest);
        hashMap.put("Content-Type", "application/json");
        new HashMap().put("screen_name", getClass().getSimpleName());
        String f2 = net.one97.paytm.helper.a.b().f("offline_pg_fetch_bin_URL");
        com.paytm.network.b b2 = net.one97.paytm.addmoney.common.a.b();
        b2.f42885i = new CJRBinResponse();
        b2.f42877a = this.f48137b;
        b2.f42880d = f2;
        b2.f42882f = hashMap;
        b2.f42884h = a2;
        b2.o = getClass().getSimpleName();
        b2.j = new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                hVar.a(iJRPaytmDataModel);
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                hVar.b(networkCustomError);
            }
        };
        com.paytm.network.a l = b2.l();
        l.a((Object) str3);
        l.a();
    }

    public final void a(h hVar, String str) {
        new net.one97.paytm.addmoney.utils.a(this.f48137b, this.f48138c).a(hVar);
    }

    public final void a(h hVar, String str, String str2, int i2, String str3) {
        new net.one97.paytm.addmoney.utils.a(this.f48137b, this.f48138c).a(hVar, str, str2, i2, str3);
    }
}
