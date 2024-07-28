package com.travel.bus.busticket.d;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.travel.bus.R;
import com.travel.bus.busticket.f.e;
import com.travel.bus.pojo.bussearch.CJRBusBPDPCancellationPolicyItem;
import com.travel.bus.pojo.busticket.CJRBusSearchItem;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import org.json.JSONException;
import org.json.JSONObject;

public final class b implements com.paytm.network.listener.b {

    /* renamed from: a  reason: collision with root package name */
    e f22116a;

    /* renamed from: b  reason: collision with root package name */
    Context f22117b;

    /* renamed from: c  reason: collision with root package name */
    String f22118c = "CJRApsrtcHelper";

    public b(Context context, e eVar) {
        this.f22116a = eVar;
        this.f22117b = context;
    }

    public static JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "BusSearchScreen");
            jSONObject.put("requestId", str);
        } catch (JSONException e2) {
            q.c(e2.getMessage());
        }
        return jSONObject;
    }

    public static void a(Context context, String str, String str2) {
        if (context == null || !(context instanceof Activity) || !((Activity) context).isFinishing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(str);
            builder.setMessage(str2);
            builder.setPositiveButton(context.getResources().getString(R.string.network_retry_yes), $$Lambda$b$iMir_gtrKgO6EhHB5438El5SR0I.INSTANCE);
            builder.show();
        }
    }

    public static JSONObject a(CJRBusSearchItem cJRBusSearchItem, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("bus_id", cJRBusSearchItem.getBusId());
            jSONObject.put("request_id", str);
            return jSONObject;
        } catch (JSONException e2) {
            q.c(e2.getMessage());
            return null;
        }
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof CJRBusBPDPCancellationPolicyItem) {
            this.f22116a.a((CJRBusBPDPCancellationPolicyItem) iJRPaytmDataModel);
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        a(this.f22117b, networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
    }
}
