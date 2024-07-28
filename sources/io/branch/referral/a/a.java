package io.branch.referral.a;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import io.branch.referral.ag;
import io.branch.referral.c;
import io.branch.referral.m;
import io.branch.referral.q;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class a {
    public abstract b a(String str) throws C0780a;

    public abstract b a(String str, JSONObject jSONObject) throws C0780a;

    public final ag a(String str, JSONObject jSONObject, String str2, String str3) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (!a(jSONObject, str3)) {
            return new ag(str2, -114);
        }
        String str4 = str + a(jSONObject);
        long currentTimeMillis = System.currentTimeMillis();
        q.h("getting ".concat(String.valueOf(str4)));
        try {
            b a2 = a(str4);
            ag a3 = a(a2.f46417a, a2.f46418b, str2);
            if (c.a() != null) {
                c.a().a(str2 + "-" + m.a.Branch_Round_Trip_Time.getKey(), String.valueOf((int) (System.currentTimeMillis() - currentTimeMillis)));
            }
            return a3;
        } catch (C0780a e2) {
            if (e2.branchErrorCode == -111) {
                ag agVar = new ag(str2, -111);
                if (c.a() != null) {
                    c.a().a(str2 + "-" + m.a.Branch_Round_Trip_Time.getKey(), String.valueOf((int) (System.currentTimeMillis() - currentTimeMillis)));
                }
                return agVar;
            }
            ag agVar2 = new ag(str2, -113);
            if (c.a() != null) {
                c.a().a(str2 + "-" + m.a.Branch_Round_Trip_Time.getKey(), String.valueOf((int) (System.currentTimeMillis() - currentTimeMillis)));
            }
            return agVar2;
        } catch (Throwable th) {
            if (c.a() != null) {
                c.a().a(str2 + "-" + m.a.Branch_Round_Trip_Time.getKey(), String.valueOf((int) (System.currentTimeMillis() - currentTimeMillis)));
            }
            throw th;
        }
    }

    public final ag a(JSONObject jSONObject, String str, String str2, String str3) {
        long currentTimeMillis = System.currentTimeMillis();
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (!a(jSONObject, str3)) {
            return new ag(str2, -114);
        }
        q.h("posting to ".concat(String.valueOf(str)));
        q.h("Post value = " + jSONObject.toString());
        try {
            b a2 = a(str, jSONObject);
            ag a3 = a(a2.f46417a, a2.f46418b, str2);
            if (c.a() != null) {
                c a4 = c.a();
                a4.a(str2 + "-" + m.a.Branch_Round_Trip_Time.getKey(), String.valueOf((int) (System.currentTimeMillis() - currentTimeMillis)));
            }
            return a3;
        } catch (C0780a e2) {
            if (e2.branchErrorCode == -111) {
                ag agVar = new ag(str2, -111);
                if (c.a() != null) {
                    c a5 = c.a();
                    a5.a(str2 + "-" + m.a.Branch_Round_Trip_Time.getKey(), String.valueOf((int) (System.currentTimeMillis() - currentTimeMillis)));
                }
                return agVar;
            }
            ag agVar2 = new ag(str2, -113);
            if (c.a() != null) {
                c a6 = c.a();
                a6.a(str2 + "-" + m.a.Branch_Round_Trip_Time.getKey(), String.valueOf((int) (System.currentTimeMillis() - currentTimeMillis)));
            }
            return agVar2;
        } catch (Throwable th) {
            if (c.a() != null) {
                c a7 = c.a();
                a7.a(str2 + "-" + m.a.Branch_Round_Trip_Time.getKey(), String.valueOf((int) (System.currentTimeMillis() - currentTimeMillis)));
            }
            throw th;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:2|3|4|5) */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0024, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0025, code lost:
        io.branch.referral.q.h("JSON exception: " + r1.getMessage());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x001c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static io.branch.referral.ag a(java.lang.String r1, int r2, java.lang.String r3) {
        /*
            io.branch.referral.ag r0 = new io.branch.referral.ag
            r0.<init>(r3, r2)
            java.lang.String r2 = java.lang.String.valueOf(r1)
            java.lang.String r3 = "returned "
            java.lang.String r2 = r3.concat(r2)
            io.branch.referral.q.h(r2)
            if (r1 == 0) goto L_0x003a
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x001c }
            r2.<init>(r1)     // Catch:{ JSONException -> 0x001c }
            r0.f46432b = r2     // Catch:{ JSONException -> 0x001c }
            goto L_0x003a
        L_0x001c:
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0024 }
            r2.<init>(r1)     // Catch:{ JSONException -> 0x0024 }
            r0.f46432b = r2     // Catch:{ JSONException -> 0x0024 }
            goto L_0x003a
        L_0x0024:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "JSON exception: "
            r2.<init>(r3)
            java.lang.String r1 = r1.getMessage()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            io.branch.referral.q.h(r1)
        L_0x003a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.a.a.a(java.lang.String, int, java.lang.String):io.branch.referral.ag");
    }

    private static boolean a(JSONObject jSONObject, String str) {
        try {
            if (!jSONObject.has(m.a.UserData.getKey())) {
                jSONObject.put(m.a.SDK.getKey(), "android4.3.2");
            }
            if (str.equals("bnc_no_value")) {
                return false;
            }
            jSONObject.put(m.a.BranchKey.getKey(), str);
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    private static String a(JSONObject jSONObject) {
        JSONArray names;
        StringBuilder sb = new StringBuilder();
        if (!(jSONObject == null || (names = jSONObject.names()) == null)) {
            int length = names.length();
            int i2 = 0;
            boolean z = true;
            while (i2 < length) {
                try {
                    String string = names.getString(i2);
                    if (z) {
                        sb.append("?");
                        z = false;
                    } else {
                        sb.append(AppConstants.AND_SIGN);
                    }
                    String string2 = jSONObject.getString(string);
                    sb.append(string);
                    sb.append("=");
                    sb.append(string2);
                    i2++;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
        }
        return sb.toString();
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        final String f46417a;

        /* renamed from: b  reason: collision with root package name */
        final int f46418b;

        public b(String str, int i2) {
            this.f46417a = str;
            this.f46418b = i2;
        }
    }

    /* renamed from: io.branch.referral.a.a$a  reason: collision with other inner class name */
    public static class C0780a extends Exception {
        /* access modifiers changed from: private */
        public int branchErrorCode = -113;

        public C0780a(int i2) {
            this.branchErrorCode = i2;
        }
    }
}
