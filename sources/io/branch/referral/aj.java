package io.branch.referral;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class aj {

    /* renamed from: a  reason: collision with root package name */
    static JSONObject f46440a;

    /* renamed from: d  reason: collision with root package name */
    private static aj f46441d;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<String> f46442b;

    /* renamed from: c  reason: collision with root package name */
    private final JSONObject f46443c = new JSONObject();

    public static aj a(Context context) {
        if (f46441d == null) {
            f46441d = new aj(context);
        }
        return f46441d;
    }

    private aj(Context context) {
        try {
            this.f46443c.putOpt("version", 0);
            JSONArray jSONArray = new JSONArray();
            this.f46443c.putOpt("uri_skip_list", jSONArray);
            jSONArray.put("^fb\\d+:");
            jSONArray.put("^li\\d+:");
            jSONArray.put("^pdk\\d+:");
            jSONArray.put("^twitterkit-.*:");
            jSONArray.put("^com\\.googleusercontent\\.apps\\.\\d+-.*:\\/oauth");
            jSONArray.put("^(?i)(?!(http|https):).*(:|:.*\\b)(password|o?auth|o?auth.?token|access|access.?token)\\b");
            jSONArray.put("^(?i)((http|https):\\/\\/).*[\\/|?|#].*\\b(password|o?auth|o?auth.?token|access|access.?token)\\b");
        } catch (JSONException unused) {
        }
        f46440a = b(context);
        this.f46442b = new ArrayList<>();
    }

    private JSONObject b(Context context) {
        q.a(context);
        JSONObject jSONObject = new JSONObject();
        String d2 = q.d("skip_url_format_key");
        if (TextUtils.isEmpty(d2) || "bnc_no_value".equals(d2)) {
            return this.f46443c;
        }
        try {
            return new JSONObject(d2);
        } catch (JSONException unused) {
            return jSONObject;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002c A[SYNTHETIC, Splitter:B:14:0x002c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(java.lang.String r5) {
        /*
            r4 = this;
            org.json.JSONObject r0 = f46440a     // Catch:{ Exception -> 0x004e }
            java.lang.String r1 = "uri_skip_list"
            org.json.JSONArray r0 = r0.optJSONArray(r1)     // Catch:{ Exception -> 0x004e }
            if (r0 == 0) goto L_0x0029
            r1 = 0
        L_0x000c:
            int r2 = r0.length()     // Catch:{ Exception -> 0x004e }
            if (r1 >= r2) goto L_0x0029
            java.lang.String r2 = r0.getString(r1)     // Catch:{ JSONException -> 0x0026 }
            java.util.regex.Pattern r3 = java.util.regex.Pattern.compile(r2)     // Catch:{ JSONException -> 0x0026 }
            java.util.regex.Matcher r3 = r3.matcher(r5)     // Catch:{ JSONException -> 0x0026 }
            boolean r3 = r3.find()     // Catch:{ JSONException -> 0x0026 }
            if (r3 == 0) goto L_0x0026
            r0 = r2
            goto L_0x002a
        L_0x0026:
            int r1 = r1 + 1
            goto L_0x000c
        L_0x0029:
            r0 = 0
        L_0x002a:
            if (r0 != 0) goto L_0x004d
            java.util.ArrayList<java.lang.String> r1 = r4.f46442b     // Catch:{ Exception -> 0x004e }
            int r1 = r1.size()     // Catch:{ Exception -> 0x004e }
            if (r1 <= 0) goto L_0x004e
            java.util.ArrayList<java.lang.String> r1 = r4.f46442b     // Catch:{ Exception -> 0x004e }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x004e }
        L_0x003a:
            boolean r2 = r1.hasNext()     // Catch:{ Exception -> 0x004e }
            if (r2 == 0) goto L_0x004d
            java.lang.Object r2 = r1.next()     // Catch:{ Exception -> 0x004e }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x004e }
            boolean r2 = r5.matches(r2)     // Catch:{ Exception -> 0x004e }
            if (r2 == 0) goto L_0x003a
            goto L_0x004e
        L_0x004d:
            r5 = r0
        L_0x004e:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.aj.a(java.lang.String):java.lang.String");
    }

    static class a extends e<Void, Void, JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        private final q f46444a;

        /* renamed from: b  reason: collision with root package name */
        private final int f46445b;

        /* synthetic */ a(Context context, byte b2) {
            this(context);
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            return a();
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            super.onPostExecute(jSONObject);
            if (jSONObject.optInt("version") > aj.f46440a.optInt("version")) {
                aj.f46440a = jSONObject;
                q.a("skip_url_format_key", aj.f46440a.toString());
            }
        }

        private a(Context context) {
            this.f46445b = 1500;
            this.f46444a = q.a(context);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0069, code lost:
            if (r1 != null) goto L_0x006b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x006b, code lost:
            r1.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0072, code lost:
            if (r1 != null) goto L_0x006b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0075, code lost:
            return r0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static org.json.JSONObject a() {
            /*
                r0 = 0
                android.net.TrafficStats.setThreadStatsTag(r0)
                org.json.JSONObject r0 = new org.json.JSONObject
                r0.<init>()
                java.lang.String r1 = "%sdk/uriskiplist_v#.json"
                java.lang.String r2 = "%"
                java.lang.String r3 = io.branch.referral.q.b()     // Catch:{ all -> 0x0071 }
                java.lang.String r1 = r1.replace(r2, r3)     // Catch:{ all -> 0x0071 }
                java.net.URL r2 = new java.net.URL     // Catch:{ all -> 0x0071 }
                java.lang.String r3 = "#"
                org.json.JSONObject r4 = io.branch.referral.aj.f46440a     // Catch:{ all -> 0x0071 }
                java.lang.String r5 = "version"
                int r4 = r4.optInt(r5)     // Catch:{ all -> 0x0071 }
                int r4 = r4 + 1
                java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x0071 }
                java.lang.String r1 = r1.replace(r3, r4)     // Catch:{ all -> 0x0071 }
                r2.<init>(r1)     // Catch:{ all -> 0x0071 }
                java.net.URLConnection r1 = r2.openConnection()     // Catch:{ all -> 0x0071 }
                java.lang.Object r1 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r1)     // Catch:{ all -> 0x0071 }
                java.net.URLConnection r1 = (java.net.URLConnection) r1     // Catch:{ all -> 0x0071 }
                javax.net.ssl.HttpsURLConnection r1 = (javax.net.ssl.HttpsURLConnection) r1     // Catch:{ all -> 0x0071 }
                r2 = 1500(0x5dc, float:2.102E-42)
                r1.setConnectTimeout(r2)     // Catch:{ all -> 0x006f }
                r1.setReadTimeout(r2)     // Catch:{ all -> 0x006f }
                int r2 = r1.getResponseCode()     // Catch:{ all -> 0x006f }
                r3 = 200(0xc8, float:2.8E-43)
                if (r2 != r3) goto L_0x0069
                java.io.InputStream r2 = r1.getInputStream()     // Catch:{ all -> 0x006f }
                if (r2 == 0) goto L_0x0069
                java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x006f }
                java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x006f }
                java.io.InputStream r4 = r1.getInputStream()     // Catch:{ all -> 0x006f }
                r3.<init>(r4)     // Catch:{ all -> 0x006f }
                r2.<init>(r3)     // Catch:{ all -> 0x006f }
                org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ all -> 0x006f }
                java.lang.String r2 = r2.readLine()     // Catch:{ all -> 0x006f }
                r3.<init>(r2)     // Catch:{ all -> 0x006f }
                r0 = r3
            L_0x0069:
                if (r1 == 0) goto L_0x0075
            L_0x006b:
                r1.disconnect()
                goto L_0x0075
            L_0x006f:
                goto L_0x0072
            L_0x0071:
                r1 = 0
            L_0x0072:
                if (r1 == 0) goto L_0x0075
                goto L_0x006b
            L_0x0075:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.aj.a.a():org.json.JSONObject");
        }
    }
}
