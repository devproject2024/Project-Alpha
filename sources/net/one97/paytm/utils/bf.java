package net.one97.paytm.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.paytm.network.a;
import com.paytm.utility.b;
import com.sendbird.android.constant.StringSet;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import net.one97.paytm.j.c;
import net.one97.paytm.managebeneficiary.ManageWalletBeneficiaryActivity;
import net.one97.paytm.utils.au;
import org.json.JSONObject;

public final class bf {
    public static void a(Activity activity) {
        activity.startActivity(new Intent(activity, ManageWalletBeneficiaryActivity.class));
    }

    public static void a(Context context, String str, a.b bVar, String str2, a.c cVar) {
        au.e eVar = new au.e();
        eVar.o = b.P(str);
        eVar.f69690e = au.c.LocalError.stringValue;
        if (bVar != null) {
            eVar.t = bVar.toString();
        } else {
            eVar.t = "None";
        }
        if (!TextUtils.isEmpty(str2)) {
            eVar.g(str2);
        }
        if (cVar != null) {
            eVar.l = cVar.toString();
        } else {
            eVar.l = a.c.P2P.toString();
        }
        if (bVar != null) {
            eVar.t = bVar.toString();
        } else {
            eVar.t = "None";
        }
        au.a(eVar, au.c.LocalError.stringValue, context);
    }

    public static String a(boolean z, String str, String str2, String str3, String str4, boolean z2, String str5, String str6) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isSingleAPI", z);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("transcationTime", System.currentTimeMillis() - Long.parseLong(str));
            }
            jSONObject.put("suggestedInstrument", str2);
            jSONObject.put("usedInstrument", str3);
            jSONObject.put("transcationStatus", str4);
            jSONObject.put("isFromRecent", z2);
            if (!TextUtils.isEmpty(str5)) {
                jSONObject.put("page_load_type", str5);
            }
            if (!TextUtils.isEmpty(str6) && !TextUtils.isEmpty(str)) {
                jSONObject.put("page_load_time", Long.parseLong(str6) - Long.parseLong(str));
            }
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean a(Context context) {
        if (Build.VERSION.SDK_INT < 19) {
            return false;
        }
        c.a();
        String a2 = c.a("vscp_enabled_cust_id_v5", (String) null);
        if (!TextUtils.isEmpty(a2)) {
            if (StringSet.all.equalsIgnoreCase(a2)) {
                return true;
            }
            String a3 = com.paytm.utility.a.a(context);
            if (!TextUtils.isEmpty(a3)) {
                String trim = a3.trim();
                for (String trim2 : a2.split(AppConstants.COMMA)) {
                    if (trim2.trim().equalsIgnoreCase(trim)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
