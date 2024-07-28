package net.one97.paytm.upi.mandate.utils;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.upi.mandate.utils.i;
import net.one97.paytm.upi.mandate.utils.t;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public final class MandateMpinHelper$getMpinForCheckBalance$clRemoteResultReceiver$1 extends ResultReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f67383a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f67384b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MandateMpinHelper$getMpinForCheckBalance$clRemoteResultReceiver$1(i iVar, String str, Handler handler) {
        super(handler);
        this.f67383a = iVar;
        this.f67384b = str;
    }

    /* access modifiers changed from: protected */
    public final void onReceiveResult(int i2, Bundle bundle) {
        k.c(bundle, "resultData");
        super.onReceiveResult(i2, bundle);
        i iVar = this.f67383a;
        k.a((Object) this.f67384b, "txnId");
        String string = bundle.getString("error");
        if (string != null) {
            if (!(string.length() == 0)) {
                i.a aVar = iVar.f67400d;
                if (aVar == null) {
                    k.a("listener");
                }
                aVar.a((t) new t.e(string));
                return;
            }
        }
        Serializable serializable = bundle.getSerializable("credBlocks");
        if (serializable != null) {
            HashMap hashMap = (HashMap) serializable;
            String str = "";
            for (String str2 : hashMap.keySet()) {
                try {
                    JSONObject jSONObject = new JSONObject((String) hashMap.get(str2));
                    q.a(jSONObject.toString());
                    str = jSONObject.getJSONObject("data").getString("code") + AppConstants.COMMA + jSONObject.getJSONObject("data").getString(CLConstants.FIELD_KI) + AppConstants.COMMA + jSONObject.getJSONObject("data").getString("encryptedBase64String");
                    q.a(jSONObject.getJSONObject("data").getString("encryptedBase64String"));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    i.a aVar2 = iVar.f67400d;
                    if (aVar2 == null) {
                        k.a("listener");
                    }
                    aVar2.a((t) new t.e("Error fetching MPIN"));
                }
            }
            if (!TextUtils.isEmpty(str)) {
                i.a aVar3 = iVar.f67400d;
                if (aVar3 == null) {
                    k.a("listener");
                }
                aVar3.a(str);
                return;
            }
            i.a aVar4 = iVar.f67400d;
            if (aVar4 == null) {
                k.a("listener");
            }
            aVar4.a((t) new t.e("Error fetching MPIN"));
            return;
        }
        throw new u("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>");
    }
}
