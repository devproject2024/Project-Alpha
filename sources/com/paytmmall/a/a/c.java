package com.paytmmall.a.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.paytm.utility.q;
import com.paytmmall.artifact.d.m;
import com.paytmmall.artifact.d.v;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.Iterator;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.core.a;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c extends a {

    /* renamed from: a  reason: collision with root package name */
    private static String f15369a = "H5CommonKeyValuePairPlugin";

    public c() {
        super("mpSetGetKey", "get", "set", "remove");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005d, code lost:
        if (r0.equals("get") != false) goto L_0x006b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a7 A[SYNTHETIC, Splitter:B:39:0x00a7] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(net.one97.paytm.phoenix.api.H5Event r8, net.one97.paytm.phoenix.api.b r9) {
        /*
            r7 = this;
            if (r8 == 0) goto L_0x00c3
            org.json.JSONObject r0 = r8.getParams()
            if (r0 == 0) goto L_0x00c3
            org.json.JSONObject r0 = r8.getParams()
            java.lang.String r1 = "action"
            java.lang.Object r0 = r0.opt(r1)
            if (r0 == 0) goto L_0x00c3
            org.json.JSONObject r0 = r8.getParams()
            java.lang.Object r0 = r0.opt(r1)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r1 = 0
            r2 = 1
            if (r9 == 0) goto L_0x0034
            org.json.JSONObject r3 = r8.getParams()
            java.lang.String r4 = "data"
            java.lang.Object r3 = r3.opt(r4)
            boolean r3 = r3 instanceof org.json.JSONObject
            if (r3 == 0) goto L_0x0034
            r3 = 1
            goto L_0x0035
        L_0x0034:
            r3 = 0
        L_0x0035:
            if (r3 == 0) goto L_0x00c3
            r3 = -1
            int r4 = r0.hashCode()
            r5 = -934610812(0xffffffffc84af884, float:-207842.06)
            r6 = 2
            if (r4 == r5) goto L_0x0060
            r5 = 102230(0x18f56, float:1.43255E-40)
            if (r4 == r5) goto L_0x0057
            r1 = 113762(0x1bc62, float:1.59415E-40)
            if (r4 == r1) goto L_0x004d
            goto L_0x006a
        L_0x004d:
            java.lang.String r1 = "set"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x006a
            r1 = 1
            goto L_0x006b
        L_0x0057:
            java.lang.String r4 = "get"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x006a
            goto L_0x006b
        L_0x0060:
            java.lang.String r1 = "remove"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x006a
            r1 = 2
            goto L_0x006b
        L_0x006a:
            r1 = -1
        L_0x006b:
            java.lang.String r0 = "keys"
            if (r1 == 0) goto L_0x00a7
            if (r1 == r2) goto L_0x008f
            if (r1 == r6) goto L_0x0074
            goto L_0x00c3
        L_0x0074:
            org.json.JSONObject r1 = b(r8)     // Catch:{ Exception -> 0x008a }
            java.lang.Object r0 = r1.get(r0)     // Catch:{ Exception -> 0x008a }
            org.json.JSONArray r0 = (org.json.JSONArray) r0     // Catch:{ Exception -> 0x008a }
            android.app.Activity r1 = r8.getActivity()     // Catch:{ Exception -> 0x008a }
            org.json.JSONObject r0 = a((android.app.Activity) r1, (org.json.JSONArray) r0)     // Catch:{ Exception -> 0x008a }
            r9.a(r8, r0)     // Catch:{ Exception -> 0x008a }
            goto L_0x00c3
        L_0x008a:
            r0 = move-exception
            com.paytmmall.artifact.d.s.a(r0)
            goto L_0x00c3
        L_0x008f:
            org.json.JSONObject r1 = b(r8)     // Catch:{ Exception -> 0x00a2 }
            org.json.JSONObject r0 = r1.optJSONObject(r0)     // Catch:{ Exception -> 0x00a2 }
            android.app.Activity r1 = r8.getActivity()     // Catch:{ Exception -> 0x00a2 }
            a((android.app.Activity) r1, (org.json.JSONObject) r0)     // Catch:{ Exception -> 0x00a2 }
            r9.a(r8, r0)     // Catch:{ Exception -> 0x00a2 }
            goto L_0x00c3
        L_0x00a2:
            r0 = move-exception
            com.paytmmall.artifact.d.s.a(r0)
            goto L_0x00c3
        L_0x00a7:
            org.json.JSONObject r1 = b(r8)     // Catch:{ Exception -> 0x00bf }
            java.lang.Object r0 = r1.get(r0)     // Catch:{ Exception -> 0x00bf }
            org.json.JSONArray r0 = (org.json.JSONArray) r0     // Catch:{ Exception -> 0x00bf }
            android.app.Activity r1 = r8.getActivity()     // Catch:{ Exception -> 0x00bf }
            org.json.JSONObject r0 = b((android.app.Activity) r1, (org.json.JSONArray) r0)     // Catch:{ Exception -> 0x00bf }
            if (r0 == 0) goto L_0x00c3
            r9.a(r8, r0)     // Catch:{ Exception -> 0x00bf }
            goto L_0x00c3
        L_0x00bf:
            r0 = move-exception
            com.paytmmall.artifact.d.s.a(r0)
        L_0x00c3:
            boolean r8 = super.a((net.one97.paytm.phoenix.api.H5Event) r8, (net.one97.paytm.phoenix.api.b) r9)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.a.a.c.a(net.one97.paytm.phoenix.api.H5Event, net.one97.paytm.phoenix.api.b):boolean");
    }

    private static JSONObject b(H5Event h5Event) {
        return h5Event.getParams().optJSONObject("data");
    }

    public static JSONObject a(Activity activity, JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                a((Context) activity, jSONArray.getString(i2));
            }
            return jSONObject;
        } catch (Exception e2) {
            q.c(e2.getMessage());
            return null;
        }
    }

    public static JSONObject b(Activity activity, JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                String string = jSONArray.getString(i2);
                jSONObject.put(string, m.a().a(activity, string));
            }
            return jSONObject;
        } catch (Exception e2) {
            q.c(e2.getMessage());
            return null;
        }
    }

    public static void a(Activity activity, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    b(activity, next, jSONObject.optString(next));
                }
            } catch (Exception e2) {
                q.c(e2.getMessage());
            }
        }
    }

    public static void a(Context context, String str, String str2) {
        b(context, str, str2);
    }

    public static void a(Context context, String str) {
        m.a().a(context, str);
    }

    private static void b(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1147692044:
                    if (str.equals(AddEditGstinViewModelKt.BODY_PARAM_ADDRESS)) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1039767846:
                    if (str.equals("wishlistResponse")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 1268962177:
                    if (str.equals("cartResponse")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 1425666271:
                    if (str.equals("recentProducts")) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                b(context, str2);
            } else if (c2 == 1) {
                c(context, str2);
            } else if (c2 == 2) {
                d(context, str2);
            } else if (c2 != 3) {
                m.a().a(context, str, str2);
            } else {
                v.a().g(context, str2);
            }
        }
    }

    private static void b(Context context, String str) {
        v.a().a(context, str);
        v.a();
        v.f(context, str);
        androidx.localbroadcastmanager.a.a.a(context).a(new Intent(CLPConstants.ACTION_UPDATE_CLP));
    }

    private static void c(Context context, String str) {
        v.a().c(context, str);
        androidx.localbroadcastmanager.a.a.a(context).a(new Intent(CLPConstants.ACTION_UPDATE_CLP));
    }

    private static void d(Context context, String str) {
        v.a().b(context, str);
        androidx.localbroadcastmanager.a.a.a(context).a(new Intent(CLPConstants.ACTION_UPDATE_CLP));
    }
}
