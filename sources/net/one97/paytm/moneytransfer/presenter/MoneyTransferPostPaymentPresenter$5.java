package net.one97.paytm.moneytransfer.presenter;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

class MoneyTransferPostPaymentPresenter$5 extends ResultReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f54039a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ d f54040b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MoneyTransferPostPaymentPresenter$5(d dVar, Handler handler, boolean z) {
        super(handler);
        this.f54040b = dVar;
        this.f54039a = z;
    }

    /* access modifiers changed from: protected */
    public void onReceiveResult(int i2, Bundle bundle) {
        super.onReceiveResult(i2, bundle);
        if (this.f54040b.c()) {
            d dVar = this.f54040b;
            String string = bundle.getString("error");
            if (string == null || string.isEmpty()) {
                HashMap hashMap = (HashMap) bundle.getSerializable("credBlocks");
                String str = "";
                for (String str2 : hashMap.keySet()) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) hashMap.get(str2));
                        q.a(jSONObject.toString());
                        str = jSONObject.getJSONObject("data").getString("code") + AppConstants.COMMA + jSONObject.getJSONObject("data").getString(CLConstants.FIELD_KI) + AppConstants.COMMA + jSONObject.getJSONObject("data").getString("encryptedBase64String");
                        q.a(jSONObject.getJSONObject("data").getString("encryptedBase64String"));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                dVar.f54078a.b(str);
            }
        }
    }
}
