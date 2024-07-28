package io.branch.referral;

import android.content.Context;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import io.branch.referral.c;
import io.branch.referral.m;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Collection;
import org.json.JSONObject;

final class u extends s {

    /* renamed from: h  reason: collision with root package name */
    g f46582h;

    /* renamed from: i  reason: collision with root package name */
    c.a f46583i;
    private boolean j = true;
    private boolean k = true;

    public final boolean a() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean d() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean m() {
        return true;
    }

    public u(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
    }

    public final void a(ag agVar, c cVar) {
        try {
            agVar.a().getString("url");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void a(int i2, String str) {
        if (this.f46583i != null) {
            if (this.k) {
                if (!q.d("bnc_user_url").equals("bnc_no_value")) {
                    a(q.d("bnc_user_url"));
                } else {
                    a("https://bnc.lt/a/" + q.e());
                }
            }
            new f("Trouble creating a URL. ".concat(String.valueOf(str)), i2);
        }
    }

    public final void b() {
        this.f46583i = null;
    }

    private String a(String str) {
        String str2;
        try {
            String str3 = "";
            if (c.a().q.f46439a) {
                if (!str.contains("https://bnc.lt/a/")) {
                    str = str.replace(new URL(str).getQuery(), str3);
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            if (str.contains("?")) {
                str2 = str3;
            } else {
                str2 = "?";
            }
            sb.append(str2);
            str = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            if (!str.endsWith("?")) {
                str3 = AppConstants.AND_SIGN;
            }
            sb2.append(str3);
            str = sb2.toString();
            Collection<String> collection = this.f46582h.f46481a;
            if (collection != null) {
                for (String next : collection) {
                    if (next != null && next.length() > 0) {
                        str = str + m.b.Tags + "=" + URLEncoder.encode(next, "UTF8") + AppConstants.AND_SIGN;
                    }
                }
            }
            String str4 = this.f46582h.f46482b;
            if (str4 != null && str4.length() > 0) {
                str = str + m.b.Alias + "=" + URLEncoder.encode(str4, "UTF8") + AppConstants.AND_SIGN;
            }
            String str5 = this.f46582h.f46484d;
            if (str5 != null && str5.length() > 0) {
                str = str + m.b.Channel + "=" + URLEncoder.encode(str5, "UTF8") + AppConstants.AND_SIGN;
            }
            String str6 = this.f46582h.f46485e;
            if (str6 != null && str6.length() > 0) {
                str = str + m.b.Feature + "=" + URLEncoder.encode(str6, "UTF8") + AppConstants.AND_SIGN;
            }
            String str7 = this.f46582h.f46486f;
            if (str7 != null && str7.length() > 0) {
                str = str + m.b.Stage + "=" + URLEncoder.encode(str7, "UTF8") + AppConstants.AND_SIGN;
            }
            String str8 = this.f46582h.f46487g;
            if (str8 != null && str8.length() > 0) {
                str = str + m.b.Campaign + "=" + URLEncoder.encode(str8, "UTF8") + AppConstants.AND_SIGN;
            }
            String str9 = (str + m.b.Type + "=" + ((long) this.f46582h.f46483c) + AppConstants.AND_SIGN) + m.b.Duration + "=" + ((long) this.f46582h.f46489i);
            String jSONObject = this.f46582h.f46488h.toString();
            if (jSONObject == null || jSONObject.length() <= 0) {
                return str9;
            }
            return str9 + "&source=android&data=" + URLEncoder.encode(b.b(jSONObject.getBytes()), "UTF8");
        } catch (Exception unused) {
            new f("Trouble creating a URL.", -116);
            return str;
        }
    }
}
