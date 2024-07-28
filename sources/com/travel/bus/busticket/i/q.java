package com.travel.bus.busticket.i;

import android.content.Context;
import android.text.TextUtils;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.utility.a;
import com.travel.bus.pojo.common.entity.travel.CJRBusTpUserProfileContact;
import org.json.JSONException;
import org.json.JSONObject;

public final class q {
    public static JSONObject a(Context context, CJRBusTpUserProfileContact cJRBusTpUserProfileContact) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(cJRBusTpUserProfileContact.getPerson_id())) {
                jSONObject.put("person_id", cJRBusTpUserProfileContact.getPerson_id());
            }
            jSONObject.put(AppConstants.SSO_TOKEN, a.q(context));
            return jSONObject;
        } catch (JSONException e2) {
            com.paytm.utility.q.c(e2.getMessage());
            return null;
        }
    }
}
