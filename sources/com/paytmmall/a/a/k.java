package com.paytmmall.a.a;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.paytm.utility.q;
import com.paytmmall.artifact.d.t;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.api.b;
import net.one97.paytm.phoenix.core.a;
import org.json.JSONException;
import org.json.JSONObject;

public final class k extends a {

    /* renamed from: a  reason: collision with root package name */
    public static b f15381a;

    /* renamed from: b  reason: collision with root package name */
    private static H5Event f15382b;

    public k() {
        super("scanAction");
    }

    public final boolean a(H5Event h5Event, b bVar) {
        f15381a = bVar;
        f15382b = h5Event;
        if (h5Event == null || h5Event.getActivity() == null) {
            return false;
        }
        Activity activity = h5Event.getActivity();
        t.e().isMallApp();
        com.paytmmall.artifact.common.b.a.a.a(activity);
        return super.a(h5Event, bVar);
    }

    public static void a(int i2, int i3, Bundle bundle) {
        if (bundle != null && i2 == 201 && i3 == -1) {
            String string = bundle.getString("BarCodeResult");
            if (f15381a != null && !TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("scanData", string);
                } catch (JSONException e2) {
                    q.b(e2.getMessage());
                }
                f15381a.a(f15382b, jSONObject);
                f15381a = null;
            }
        }
    }
}
