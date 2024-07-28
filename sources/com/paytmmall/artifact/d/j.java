package com.paytmmall.artifact.d;

import com.paytm.utility.q;
import com.sendbird.android.constant.StringSet;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.net.URLEncoder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class j {

    /* renamed from: a  reason: collision with root package name */
    public static JSONArray f15722a;

    /* renamed from: b  reason: collision with root package name */
    public static JSONArray f15723b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f15724c = j.class.getSimpleName();

    public static String a(String str) {
        if (str == null || str.contains("&site_id=")) {
            return str;
        }
        try {
            String c2 = t.c().c("CHILD_SITE_ID");
            String d2 = d.d();
            if (c2 != null) {
                if (str.contains("?")) {
                    str = str + "&child_site_id=" + URLEncoder.encode(c2, AppConstants.UTF_8);
                } else {
                    str = str + "&child_site_id=".replace(AppConstants.AND_SIGN, "?") + URLEncoder.encode(c2, AppConstants.UTF_8);
                }
            }
            if (d2 == null) {
                return str;
            }
            return str + "&site_id=" + URLEncoder.encode(d2, AppConstants.UTF_8);
        } catch (Exception e2) {
            q.c(e2.getMessage());
            return str;
        }
    }

    public static String b(String str) {
        JSONArray jSONArray = f15722a;
        if (jSONArray != null && jSONArray.length() > 0) {
            int length = f15722a.length();
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                try {
                    JSONObject jSONObject = f15722a.getJSONObject(i2);
                    boolean equals = jSONObject.getString("rule_type").equals("GTM Override");
                    String string = jSONObject.getString("search_pattern");
                    String string2 = jSONObject.getString("replacement_pattern");
                    if (jSONObject.getBoolean(StringSet.is_muted)) {
                        StringBuilder sb = new StringBuilder("MockUrlActivity : URL ");
                        sb.append(string);
                        sb.append(" rule is muted. Not executing it");
                        boolean z = c.f15691a;
                    } else if (!equals && str.contains(string)) {
                        if (jSONObject.getBoolean("is_full_replacement")) {
                            str = string2;
                        } else if (!str.contains(string2)) {
                            str = str.replaceFirst(string, string2);
                        }
                        boolean z2 = c.f15691a;
                        StringBuilder sb2 = new StringBuilder("MockUrlActivity : Replacing ");
                        sb2.append(string);
                        sb2.append(" with ");
                        sb2.append(string2);
                        boolean z3 = c.f15691a;
                    }
                } catch (JSONException e2) {
                    e2.getMessage();
                    boolean z4 = c.f15691a;
                }
                i2++;
            }
        }
        return str;
    }
}
