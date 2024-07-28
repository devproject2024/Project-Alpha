package net.one97.paytm.o2o.movies.utils;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.x;
import net.one97.paytm.o2o.movies.common.a.d;
import org.json.JSONObject;

public final class c extends com.paytm.network.b {
    public static final a A = new a((byte) 0);
    /* access modifiers changed from: private */
    public static String C;
    /* access modifiers changed from: private */
    public static final Object D = new Object();
    /* access modifiers changed from: private */
    public com.paytm.network.listener.b B;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final class b implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f75920a;

        b(c cVar) {
            this.f75920a = cVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            NetworkCustomError a2 = c.b(networkCustomError);
            com.paytm.network.listener.b a3 = this.f75920a.B;
            if (a3 != null) {
                a3.handleErrorCode(i2, iJRPaytmDataModel, a2);
            }
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            NetworkResponse networkResponse;
            Map<String, String> map;
            synchronized (c.D) {
                if (!(c.C != null || iJRPaytmDataModel == null || (networkResponse = iJRPaytmDataModel.getNetworkResponse()) == null || (map = networkResponse.headers) == null)) {
                    c.C = map.get("paytmRequestId");
                }
                x xVar = x.f47997a;
            }
            com.paytm.network.listener.b a2 = this.f75920a.B;
            if (a2 != null) {
                a2.onApiSuccess(iJRPaytmDataModel);
            }
        }
    }

    /* access modifiers changed from: private */
    public static NetworkCustomError b(NetworkCustomError networkCustomError) {
        String optString;
        String b2;
        String optString2;
        String b3;
        if (networkCustomError != null) {
            try {
                JSONObject c2 = c(networkCustomError);
                JSONObject jSONObject = null;
                JSONObject optJSONObject = c2 != null ? c2.optJSONObject("status") : null;
                if (optJSONObject != null) {
                    jSONObject = optJSONObject.optJSONObject("message");
                }
                if (!(jSONObject == null || (optString2 = jSONObject.optString("title")) == null || (b3 = d.b(optString2)) == null)) {
                    networkCustomError.setmAlertTitle(b3);
                }
                if (!(jSONObject == null || (optString = jSONObject.optString("message")) == null || (b2 = d.b(optString)) == null)) {
                    networkCustomError.setAlertMessage(b2);
                }
            } catch (Exception unused) {
            }
        }
        return networkCustomError;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0017, code lost:
        r4 = (r4 = (r4 = r4.networkResponse).headers).get("Content-Encoding");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static org.json.JSONObject c(com.paytm.network.model.NetworkCustomError r4) {
        /*
            r0 = 0
            if (r4 == 0) goto L_0x0049
            com.paytm.network.model.NetworkResponse r1 = r4.networkResponse     // Catch:{ Exception -> 0x0049 }
            if (r1 == 0) goto L_0x0049
            byte[] r1 = r1.data     // Catch:{ Exception -> 0x0049 }
            if (r1 == 0) goto L_0x0049
            java.lang.String r2 = "gzip"
            if (r4 == 0) goto L_0x0026
            com.paytm.network.model.NetworkResponse r4 = r4.networkResponse     // Catch:{ Exception -> 0x0049 }
            if (r4 == 0) goto L_0x0026
            java.util.Map<java.lang.String, java.lang.String> r4 = r4.headers     // Catch:{ Exception -> 0x0049 }
            if (r4 == 0) goto L_0x0026
            java.lang.String r3 = "Content-Encoding"
            java.lang.Object r4 = r4.get(r3)     // Catch:{ Exception -> 0x0049 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0049 }
            if (r4 == 0) goto L_0x0026
            java.lang.String r4 = net.one97.paytm.o2o.movies.common.a.d.b(r4)     // Catch:{ Exception -> 0x0049 }
            goto L_0x0027
        L_0x0026:
            r4 = r0
        L_0x0027:
            r3 = 1
            boolean r4 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r4, (boolean) r3)     // Catch:{ Exception -> 0x0049 }
            if (r4 == 0) goto L_0x003c
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x0049 }
            java.io.Reader r1 = com.paytm.network.b.g.a((byte[]) r1)     // Catch:{ Exception -> 0x0049 }
            java.lang.String r1 = com.paytm.network.b.g.a((java.io.Reader) r1)     // Catch:{ Exception -> 0x0049 }
            r4.<init>(r1)     // Catch:{ Exception -> 0x0049 }
            return r4
        L_0x003c:
            java.lang.String r4 = new java.lang.String     // Catch:{ Exception -> 0x0049 }
            java.nio.charset.Charset r2 = kotlin.m.d.f47971a     // Catch:{ Exception -> 0x0049 }
            r4.<init>(r1, r2)     // Catch:{ Exception -> 0x0049 }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x0049 }
            r1.<init>(r4)     // Catch:{ Exception -> 0x0049 }
            return r1
        L_0x0049:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.utils.c.c(com.paytm.network.model.NetworkCustomError):org.json.JSONObject");
    }

    public final com.paytm.network.a l() {
        this.B = this.j;
        this.j = new b(this);
        if (C != null) {
            Map<String, String> map = this.f42882f;
            if (map == null) {
                map = new LinkedHashMap<>();
            }
            map.put("paytmRequestId", C);
            this.f42882f = map;
        }
        com.paytm.network.a l = super.l();
        k.a((Object) l, "super.build()");
        return l;
    }
}
