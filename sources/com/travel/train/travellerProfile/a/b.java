package com.travel.train.travellerProfile.a;

import android.text.TextUtils;
import com.paytm.utility.q;
import com.travel.train.travellerProfile.travel.CJRTpUserProfileContact;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static String f27734a = "CJRTpUtilityHelper";

    public static JSONObject a(CJRTpUserProfileContact cJRTpUserProfileContact) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(cJRTpUserProfileContact.getPerson_id())) {
                jSONObject.put("person_id", cJRTpUserProfileContact.getPerson_id());
            }
            return jSONObject;
        } catch (JSONException e2) {
            q.c(e2.getMessage());
            return null;
        }
    }
}
