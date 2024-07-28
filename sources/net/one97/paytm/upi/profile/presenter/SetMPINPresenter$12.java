package net.one97.paytm.upi.profile.presenter;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.google.gson.f;
import com.google.gson.u;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.upi.common.PaytmLogs;
import net.one97.paytm.upi.common.upi.GetCredentialsResponse;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

class SetMPINPresenter$12 extends ResultReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f67993a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ d f67994b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SetMPINPresenter$12(d dVar, Handler handler, String str) {
        super(handler);
        this.f67994b = dVar;
        this.f67993a = str;
    }

    /* access modifiers changed from: protected */
    public void onReceiveResult(int i2, Bundle bundle) {
        super.onReceiveResult(i2, bundle);
        d dVar = this.f67994b;
        String str = this.f67993a;
        String string = bundle.getString("error");
        if (string == null || string.isEmpty()) {
            HashMap hashMap = (HashMap) bundle.getSerializable("credBlocks");
            ArrayList arrayList = new ArrayList();
            for (String str2 : hashMap.keySet()) {
                try {
                    GetCredentialsResponse getCredentialsResponse = (GetCredentialsResponse) new f().a((String) hashMap.get(str2), GetCredentialsResponse.class);
                    getCredentialsResponse.setSubtype(str2);
                    arrayList.add(getCredentialsResponse);
                } catch (u e2) {
                    e2.printStackTrace();
                }
            }
            PaytmLogs.d("getCredentials", hashMap.toString());
            PaytmLogs.d("getCredentialsList", arrayList.toString());
            dVar.b(arrayList, str);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            jSONObject.getString(CLConstants.FIELD_ERROR_CODE);
            jSONObject.getString(CLConstants.FIELD_ERROR_TEXT);
            dVar.f68033c.f();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }
}
