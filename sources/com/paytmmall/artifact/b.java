package com.paytmmall.artifact;

import android.app.Activity;
import android.content.Intent;
import com.google.gsonhtcfix.f;
import com.paytmmall.artifact.d.s;
import com.paytmmall.artifact.d.t;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b {
    public static void a(Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            Intent intent = new Intent(activity, t.e().getSearchActivity());
            intent.putExtra(CLPConstants.EXTRA_INTENT_CONTEXT_PARAMS_OBJECT, (Serializable) null);
            intent.putExtra(CLPConstants.CONTEXT_STORE_CATEGORY_NAME, (String) null);
            intent.putExtra("category", false);
            intent.putExtra("SHOW_SMART_WIDGET_SEARCH", false);
            intent.addFlags(131072);
            activity.startActivity(intent);
        }
    }

    public static Map<String, Object> a(JSONObject jSONObject, String str) {
        try {
            return (HashMap) new f().a(jSONObject.get(str).toString(), HashMap.class);
        } catch (Exception e2) {
            s.a(e2);
            return null;
        }
    }
}
