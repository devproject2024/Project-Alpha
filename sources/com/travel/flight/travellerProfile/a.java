package com.travel.flight.travellerProfile;

import com.travel.flight.travellerProfile.model.CJRTpUserProfileBody;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytmflight.common.entity.travel.CJRTpUserProfileContact;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {

    /* renamed from: d  reason: collision with root package name */
    private static a f25521d;

    /* renamed from: a  reason: collision with root package name */
    public CJRTpUserProfileBody f25522a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<CJRTpUserProfileContact> f25523b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<Integer, CJRTpUserProfileContact> f25524c = new HashMap<>();

    public static a a() {
        if (f25521d == null) {
            f25521d = new a();
        }
        return f25521d;
    }

    private a() {
    }

    public static JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "BusTravellersScreen");
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
