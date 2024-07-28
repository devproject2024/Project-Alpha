package io.branch.referral;

import android.app.Activity;
import android.content.Context;
import com.alipay.mobile.h5container.api.H5Param;
import io.branch.indexing.a;
import io.branch.indexing.b;
import io.branch.referral.aj;
import io.branch.referral.c;
import io.branch.referral.m;
import io.branch.referral.s;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

abstract class z extends s {

    /* renamed from: h  reason: collision with root package name */
    private final Context f46607h;

    /* renamed from: i  reason: collision with root package name */
    private final b f46608i = b.a(this.f46607h);

    /* access modifiers changed from: protected */
    public final boolean e() {
        return true;
    }

    public abstract String n();

    z(Context context, String str) {
        super(context, str);
        this.f46607h = context;
    }

    z(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
        this.f46607h = context;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x007b, code lost:
        if ((r4 - r2) >= 86400000) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0086, code lost:
        if (io.branch.referral.q.d("bnc_app_version").equals(r1) == false) goto L_0x0088;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(org.json.JSONObject r12) throws org.json.JSONException {
        /*
            r11 = this;
            super.a((org.json.JSONObject) r12)
            io.branch.referral.n r0 = io.branch.referral.n.a()
            android.content.Context r0 = r0.f46549b
            java.lang.String r0 = io.branch.referral.ah.a(r0)
            boolean r1 = io.branch.referral.n.a((java.lang.String) r0)
            if (r1 != 0) goto L_0x001c
            io.branch.referral.m$a r1 = io.branch.referral.m.a.AppVersion
            java.lang.String r1 = r1.getKey()
            r12.put(r1, r0)
        L_0x001c:
            io.branch.referral.m$a r0 = io.branch.referral.m.a.FaceBookAppLinkChecked
            java.lang.String r0 = r0.getKey()
            java.lang.String r1 = "bnc_triggered_by_fb_app_link"
            boolean r1 = io.branch.referral.q.e(r1)
            r12.put(r0, r1)
            io.branch.referral.m$a r0 = io.branch.referral.m.a.IsReferrable
            java.lang.String r0 = r0.getKey()
            int r1 = io.branch.referral.q.f()
            r12.put(r0, r1)
            io.branch.referral.m$a r0 = io.branch.referral.m.a.Debug
            java.lang.String r0 = r0.getKey()
            boolean r1 = io.branch.referral.j.b()
            r12.put(r0, r1)
            r0 = 1
            io.branch.referral.n r1 = io.branch.referral.n.a()
            android.content.Context r1 = r1.f46549b
            java.lang.String r1 = io.branch.referral.ah.a(r1)
            io.branch.referral.n r2 = io.branch.referral.n.a()
            android.content.Context r2 = r2.f46549b
            long r2 = io.branch.referral.ah.b(r2)
            io.branch.referral.n r4 = io.branch.referral.n.a()
            android.content.Context r4 = r4.f46549b
            long r4 = io.branch.referral.ah.d(r4)
            java.lang.String r6 = "bnc_app_version"
            java.lang.String r7 = io.branch.referral.q.d(r6)
            java.lang.String r8 = "bnc_no_value"
            boolean r7 = r8.equals(r7)
            r8 = 2
            if (r7 == 0) goto L_0x007e
            r0 = 0
            long r6 = r4 - r2
            r9 = 86400000(0x5265c00, double:4.2687272E-316)
            int r1 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r1 < 0) goto L_0x0089
            goto L_0x0088
        L_0x007e:
            java.lang.String r6 = io.branch.referral.q.d(r6)
            boolean r1 = r6.equals(r1)
            if (r1 != 0) goto L_0x0089
        L_0x0088:
            r0 = 2
        L_0x0089:
            io.branch.referral.m$a r1 = io.branch.referral.m.a.Update
            java.lang.String r1 = r1.getKey()
            r12.put(r1, r0)
            io.branch.referral.m$a r0 = io.branch.referral.m.a.FirstInstallTime
            java.lang.String r0 = r0.getKey()
            r12.put(r0, r2)
            io.branch.referral.m$a r0 = io.branch.referral.m.a.LastUpdateTime
            java.lang.String r0 = r0.getKey()
            r12.put(r0, r4)
            java.lang.String r0 = "bnc_original_install_time"
            long r6 = io.branch.referral.q.c((java.lang.String) r0)
            r8 = 0
            int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r1 != 0) goto L_0x00b4
            io.branch.referral.q.a((java.lang.String) r0, (long) r2)
            goto L_0x00b5
        L_0x00b4:
            r2 = r6
        L_0x00b5:
            io.branch.referral.m$a r0 = io.branch.referral.m.a.OriginalInstallTime
            java.lang.String r0 = r0.getKey()
            r12.put(r0, r2)
            java.lang.String r0 = "bnc_last_known_update_time"
            long r1 = io.branch.referral.q.c((java.lang.String) r0)
            java.lang.String r3 = "bnc_previous_update_time"
            int r6 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x00d0
            io.branch.referral.q.a((java.lang.String) r3, (long) r1)
            io.branch.referral.q.a((java.lang.String) r0, (long) r4)
        L_0x00d0:
            io.branch.referral.m$a r0 = io.branch.referral.m.a.PreviousUpdateTime
            java.lang.String r0 = r0.getKey()
            long r1 = io.branch.referral.q.c((java.lang.String) r3)
            r12.put(r0, r1)
            io.branch.referral.n r0 = io.branch.referral.n.a()     // Catch:{ Exception -> 0x011a }
            android.content.Context r0 = r0.f46549b     // Catch:{ Exception -> 0x011a }
            boolean r0 = io.branch.referral.ah.c(r0)     // Catch:{ Exception -> 0x011a }
            if (r0 == 0) goto L_0x00f0
            io.branch.referral.m$a r0 = io.branch.referral.m.a.NativeApp     // Catch:{ Exception -> 0x011a }
        L_0x00eb:
            java.lang.String r0 = r0.getKey()     // Catch:{ Exception -> 0x011a }
            goto L_0x00f3
        L_0x00f0:
            io.branch.referral.m$a r0 = io.branch.referral.m.a.InstantApp     // Catch:{ Exception -> 0x011a }
            goto L_0x00eb
        L_0x00f3:
            io.branch.referral.s$a r1 = r11.k()     // Catch:{ Exception -> 0x011a }
            io.branch.referral.s$a r2 = io.branch.referral.s.a.V2     // Catch:{ Exception -> 0x011a }
            if (r1 != r2) goto L_0x0111
            io.branch.referral.m$a r1 = io.branch.referral.m.a.UserData     // Catch:{ Exception -> 0x011a }
            java.lang.String r1 = r1.getKey()     // Catch:{ Exception -> 0x011a }
            org.json.JSONObject r12 = r12.optJSONObject(r1)     // Catch:{ Exception -> 0x011a }
            if (r12 == 0) goto L_0x0110
            io.branch.referral.m$a r1 = io.branch.referral.m.a.Environment     // Catch:{ Exception -> 0x011a }
            java.lang.String r1 = r1.getKey()     // Catch:{ Exception -> 0x011a }
            r12.put(r1, r0)     // Catch:{ Exception -> 0x011a }
        L_0x0110:
            return
        L_0x0111:
            io.branch.referral.m$a r1 = io.branch.referral.m.a.Environment     // Catch:{ Exception -> 0x011a }
            java.lang.String r1 = r1.getKey()     // Catch:{ Exception -> 0x011a }
            r12.put(r1, r0)     // Catch:{ Exception -> 0x011a }
        L_0x011a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.z.a(org.json.JSONObject):void");
    }

    static boolean a(String str) {
        if (str != null) {
            return str.equalsIgnoreCase("open") || str.equalsIgnoreCase("install");
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(ag agVar) {
        if (!(agVar == null || agVar.a() == null || !agVar.a().has(m.a.BranchViewData.getKey()))) {
            try {
                JSONObject jSONObject = agVar.a().getJSONObject(m.a.BranchViewData.getKey());
                String n = n();
                if (c.a().n == null || c.a().n.get() == null) {
                    return k.a().a(jSONObject, n);
                }
                Activity activity = (Activity) c.a().n.get();
                boolean z = true;
                if (activity instanceof c.f) {
                    z = true ^ ((c.f) activity).a();
                }
                if (z) {
                    return k.a().a(jSONObject, n, activity, c.a());
                }
                return k.a().a(jSONObject, n);
            } catch (JSONException unused) {
            }
        }
        return false;
    }

    public void a(ag agVar, c cVar) {
        c a2 = c.a();
        if (a2.f46472i != null) {
            a2.f46472i.a(s.b.SDK_INIT_WAIT_LOCK);
            a2.h();
        }
        q.a("bnc_link_click_identifier", "bnc_no_value");
        q.a("bnc_google_search_install_identifier", "bnc_no_value");
        q.a("bnc_google_play_install_referrer_extras", "bnc_no_value");
        q.a("bnc_external_intent_uri", "bnc_no_value");
        q.a("bnc_external_intent_extra", "bnc_no_value");
        q.a("bnc_app_link", "bnc_no_value");
        q.a("bnc_push_identifier", "bnc_no_value");
        q.a("bnc_triggered_by_fb_app_link", Boolean.FALSE);
        q.a("bnc_install_referrer", "bnc_no_value");
        q.a(false);
        if (q.c("bnc_previous_update_time") == 0) {
            q.a("bnc_previous_update_time", q.c("bnc_last_known_update_time"));
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(ag agVar, c cVar) {
        int i2;
        b bVar = this.f46608i;
        if (bVar != null) {
            JSONObject a2 = agVar.a();
            if (a2.has(H5Param.CAN_DESTROY)) {
                bVar.f46399f = true;
                try {
                    JSONObject jSONObject = a2.getJSONObject(H5Param.CAN_DESTROY);
                    if (jSONObject.has("mv")) {
                        bVar.f46395b = jSONObject.getString("mv");
                    }
                    if (jSONObject.has("mhl")) {
                        bVar.f46397d = jSONObject.getInt("mhl");
                    }
                    if (jSONObject.has("m")) {
                        bVar.f46400g = jSONObject.getJSONArray("m");
                    }
                    if (jSONObject.has("mtl") && (i2 = jSONObject.getInt("mtl")) > 0) {
                        bVar.f46396c = i2;
                    }
                    if (jSONObject.has("mps")) {
                        bVar.f46398e = jSONObject.getInt("mps");
                    }
                    bVar.f46394a.put("mv", bVar.f46395b);
                    bVar.f46394a.put("m", bVar.f46400g);
                    bVar.f46401h.edit().putString("BNC_CD_MANIFEST", bVar.f46394a.toString()).apply();
                } catch (JSONException unused) {
                }
            } else {
                bVar.f46399f = false;
            }
            if (cVar.n != null) {
                try {
                    a a3 = a.a();
                    String d2 = c.d();
                    a3.f46389i = new ArrayList<>();
                    a3.a((Activity) cVar.n.get(), d2);
                } catch (Exception unused2) {
                }
            }
        }
        io.branch.referral.b.a.a(cVar.n);
        aj.a(cVar.f46470g);
        try {
            new aj.a(cVar.f46470g, (byte) 0).a(new Void[0]);
        } catch (Throwable unused3) {
        }
    }

    public void j() {
        JSONObject jSONObject = this.f46573b;
        try {
            if (!q.d("bnc_app_link").equals("bnc_no_value")) {
                jSONObject.put(m.a.AndroidAppLinkURL.getKey(), q.d("bnc_app_link"));
            }
            if (!q.d("bnc_push_identifier").equals("bnc_no_value")) {
                jSONObject.put(m.a.AndroidPushIdentifier.getKey(), q.d("bnc_push_identifier"));
            }
            if (!q.d("bnc_external_intent_uri").equals("bnc_no_value")) {
                jSONObject.put(m.a.External_Intent_URI.getKey(), q.d("bnc_external_intent_uri"));
            }
            if (!q.d("bnc_external_intent_extra").equals("bnc_no_value")) {
                jSONObject.put(m.a.External_Intent_Extra.getKey(), q.d("bnc_external_intent_extra"));
            }
            if (this.f46608i != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("mv", this.f46608i.a());
                jSONObject2.put("pn", this.f46607h.getPackageName());
                jSONObject.put(H5Param.CAN_DESTROY, jSONObject2);
            }
        } catch (JSONException unused) {
        }
    }

    /* access modifiers changed from: protected */
    public final boolean m() {
        JSONObject jSONObject = this.f46573b;
        if (!jSONObject.has(m.a.AndroidAppLinkURL.getKey()) && !jSONObject.has(m.a.AndroidPushIdentifier.getKey()) && !jSONObject.has(m.a.LinkIdentifier.getKey())) {
            return super.m();
        }
        jSONObject.remove(m.a.DeviceFingerprintID.getKey());
        jSONObject.remove(m.a.IdentityID.getKey());
        jSONObject.remove(m.a.FaceBookAppLinkChecked.getKey());
        jSONObject.remove(m.a.External_Intent_Extra.getKey());
        jSONObject.remove(m.a.External_Intent_URI.getKey());
        jSONObject.remove(m.a.FirstInstallTime.getKey());
        jSONObject.remove(m.a.LastUpdateTime.getKey());
        jSONObject.remove(m.a.OriginalInstallTime.getKey());
        jSONObject.remove(m.a.PreviousUpdateTime.getKey());
        jSONObject.remove(m.a.InstallBeginTimeStamp.getKey());
        jSONObject.remove(m.a.ClickedReferrerTimeStamp.getKey());
        jSONObject.remove(m.a.HardwareID.getKey());
        jSONObject.remove(m.a.IsHardwareIDReal.getKey());
        jSONObject.remove(m.a.LocalIP.getKey());
        try {
            jSONObject.put(m.a.TrackingDisabled.getKey(), true);
        } catch (JSONException unused) {
        }
        return true;
    }
}
