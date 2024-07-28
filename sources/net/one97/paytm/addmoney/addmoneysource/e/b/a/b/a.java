package net.one97.paytm.addmoney.addmoneysource.e.b.a.b;

import android.content.Context;
import android.webkit.URLUtil;
import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import com.paytm.network.f;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import java.util.HashMap;
import net.one97.paytm.addmoney.h;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.common.entity.upgradeKyc.NearbyRequestCreator;
import net.one97.paytm.common.entity.wallet.CJRP2BStatus;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONException;
import org.json.JSONObject;

public final class a implements net.one97.paytm.addmoney.addmoneysource.e.b.a.a {

    /* renamed from: b  reason: collision with root package name */
    private static a f48290b;

    /* renamed from: a  reason: collision with root package name */
    private Context f48291a;

    private a(Context context) {
        this.f48291a = context;
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f48290b == null) {
                f48290b = new a(context);
            }
            aVar = f48290b;
        }
        return aVar;
    }

    public final void a(String str) {
        f.b(this.f48291a).cancelAll((Object) str);
        f48290b = null;
    }

    public final void a(String str, String str2, String str3, String str4, final h hVar) {
        if (this.f48291a != null) {
            String f2 = net.one97.paytm.helper.a.b().f("getW2BTxnValidation");
            if (URLUtil.isValidUrl(f2)) {
                String e2 = b.e(this.f48291a, f2);
                HashMap hashMap = new HashMap();
                hashMap.put("ssotoken", com.paytm.utility.a.q(this.f48291a));
                hashMap.put("Content-Type", "application/json");
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(SDKConstants.TXN_TYPE, "PAYER_TO_BANK_TRANSFER");
                    jSONObject2.put("ssoId", b.n(this.f48291a));
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("ifscCode", str);
                    jSONObject3.put(CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER, str2);
                    jSONObject3.put("txnAmount", str3);
                    jSONObject2.put("additionalParams", jSONObject3);
                    jSONObject.put("request", jSONObject2);
                    jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.ipAddress, b.o());
                    jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.platformName, "PayTM");
                    jSONObject.put(H5RpcPlugin.RpcRequest.RpcParam.OPERATION_TYPE, "P2B_TRANSFER");
                    jSONObject.put("channel", UpiConstants.MP_ANDROID);
                    String Q = b.Q(this.f48291a);
                    if (Q != null) {
                        jSONObject.put("version", Q);
                    }
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                if (b.c(this.f48291a)) {
                    com.paytm.network.b b2 = net.one97.paytm.addmoney.common.a.b();
                    b2.f42880d = e2;
                    b2.f42885i = new CJRP2BStatus();
                    b2.f42877a = this.f48291a.getApplicationContext();
                    b2.f42882f = hashMap;
                    b2.f42884h = jSONObject.toString();
                    b2.j = new com.paytm.network.listener.b() {
                        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                            if (iJRPaytmDataModel instanceof CJRP2BStatus) {
                                hVar.a(iJRPaytmDataModel);
                            }
                        }

                        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                            hVar.b(networkCustomError);
                        }
                    };
                    com.paytm.network.a l = b2.l();
                    l.a((Object) str4);
                    l.a();
                    return;
                }
                hVar.b(new NetworkCustomError());
            }
        }
    }
}
