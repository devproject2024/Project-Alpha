package com.paytm.notification.data.b;

import android.content.Context;
import com.google.gson.f;
import com.paytm.notification.b.e;
import com.paytm.notification.models.request.TokenRegisterRequest;
import com.paytm.notification.models.request.User;
import com.paytm.pai.network.d;
import com.paytm.pai.network.model.EventResponse;
import com.paytm.signal.c;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.g.b.l;

public final class b extends a {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context);
        k.c(context, "context");
    }

    public final EventResponse<?> a(TokenRegisterRequest tokenRegisterRequest, String str, String str2, String str3, String str4) throws com.paytm.notification.data.a.a, MalformedURLException {
        Integer responseCode;
        Integer responseCode2;
        k.c(tokenRegisterRequest, "t");
        k.c(str, "endPoints");
        k.c(str2, "channelId");
        k.c(str3, "secret");
        k.c(str4, "clientId");
        this.f43054b = new f().a((Object) tokenRegisterRequest, (Type) TokenRegisterRequest.class);
        a(str);
        String str5 = null;
        this.f43055c = null;
        b("/v1/api/devices/".concat(String.valueOf(str2)));
        c(str3);
        d(str4);
        d a2 = c.f43614a.a();
        String str6 = a() + b();
        String b2 = b();
        String str7 = this.f43054b;
        if (str7 == null) {
            k.a();
        }
        String d2 = d();
        String c2 = c();
        k.c(str6, "url");
        k.c(str7, "requestBody");
        EventResponse<String> a3 = a2.a("PUT", str6, b2, str7, d2, c2, true);
        EventResponse<?> a4 = a(a3, new e(new f()), Map.class);
        com.paytm.notification.b.a aVar = com.paytm.notification.b.a.f42999a;
        StringBuilder sb = new StringBuilder("updateToken(): channelId: ");
        sb.append(str2);
        sb.append(" user: ");
        User user = tokenRegisterRequest.getUser();
        sb.append(user != null ? user.getId() : null);
        sb.append(" responseCode: ");
        sb.append(a3 != null ? a3.getResponseCode() : null);
        com.paytm.notification.b.a.c(sb.toString());
        Boolean isSuccess = a4.isSuccess();
        if (isSuccess == null) {
            k.a();
        }
        if (!isSuccess.booleanValue()) {
            if (((a3 == null || (responseCode2 = a3.getResponseCode()) == null) ? 0 : responseCode2.intValue()) != 404) {
                if (((a3 == null || (responseCode = a3.getResponseCode()) == null) ? 0 : responseCode.intValue()) != 1) {
                    e.b bVar = e.f43014a;
                    StringBuilder sb2 = new StringBuilder("[ServerCallError] updateToken() failed. ResponseCode: ");
                    sb2.append(a3 != null ? a3.getResponseCode() : null);
                    sb2.append(' ');
                    sb2.append("URL: ");
                    sb2.append(b());
                    sb2.append(' ');
                    sb2.append("Response: ");
                    sb2.append(a3 != null ? a3.getResponse() : null);
                    sb2.append(' ');
                    sb2.append("ErrorMessage: ");
                    if (a3 != null) {
                        str5 = a3.getErrorMessage();
                    }
                    sb2.append(str5);
                    bVar.d(sb2.toString(), new Object[0]);
                }
            }
        }
        return a4;
    }

    public final EventResponse<Map<String, String>> a(TokenRegisterRequest tokenRegisterRequest, String str, String str2, String str3) throws com.paytm.notification.data.a.a, MalformedURLException {
        Integer responseCode;
        Integer responseCode2;
        k.c(tokenRegisterRequest, "t");
        k.c(str, "endPoints");
        k.c(str2, "secret");
        k.c(str3, "clientId");
        this.f43054b = new f().a((Object) tokenRegisterRequest, (Type) TokenRegisterRequest.class);
        a(str);
        b("/v1/api/devices");
        String str4 = null;
        this.f43055c = null;
        c(str2);
        d(str3);
        d a2 = c.f43614a.a();
        String str5 = a() + b();
        String b2 = b();
        String str6 = this.f43054b;
        if (str6 == null) {
            k.a();
        }
        EventResponse<String> a3 = a2.a(str5, b2, str6, d(), c(), true);
        EventResponse<?> a4 = a(a3, new e(new f()), Map.class);
        com.paytm.notification.b.a aVar = com.paytm.notification.b.a.f42999a;
        StringBuilder sb = new StringBuilder("pushFcmToken(): user: ");
        User user = tokenRegisterRequest.getUser();
        sb.append(user != null ? user.getId() : null);
        sb.append(" responseCode: ");
        sb.append(a3 != null ? a3.getResponseCode() : null);
        com.paytm.notification.b.a.c(sb.toString());
        Boolean isSuccess = a4.isSuccess();
        if (isSuccess == null) {
            k.a();
        }
        if (!isSuccess.booleanValue()) {
            if (((a3 == null || (responseCode2 = a3.getResponseCode()) == null) ? 0 : responseCode2.intValue()) != 404) {
                if (((a3 == null || (responseCode = a3.getResponseCode()) == null) ? 0 : responseCode.intValue()) != 1) {
                    e.b bVar = e.f43014a;
                    StringBuilder sb2 = new StringBuilder("[ServerCallError] pushFcmToken() failed. ResponseCode: ");
                    sb2.append(a3 != null ? a3.getResponseCode() : null);
                    sb2.append(' ');
                    sb2.append("URL: ");
                    sb2.append(b());
                    sb2.append(' ');
                    sb2.append("Response: ");
                    sb2.append(a3 != null ? a3.getResponse() : null);
                    sb2.append(' ');
                    sb2.append("ErrorMessage: ");
                    if (a3 != null) {
                        str4 = a3.getErrorMessage();
                    }
                    sb2.append(str4);
                    bVar.d(sb2.toString(), new Object[0]);
                }
            }
        }
        return a4;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0071, code lost:
        r1 = r8.getResponseCode();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.paytm.pai.network.model.EventResponse<java.util.HashMap<java.lang.String, java.lang.String>> a(java.lang.String r7, java.lang.String r8, java.lang.String r9) throws com.paytm.notification.data.a.a, java.net.MalformedURLException {
        /*
            r6 = this;
            java.lang.String r0 = "end"
            kotlin.g.b.k.c(r7, r0)
            java.lang.String r0 = "secret"
            kotlin.g.b.k.c(r8, r0)
            java.lang.String r0 = "clientId"
            kotlin.g.b.k.c(r9, r0)
            r6.a((java.lang.String) r7)
            java.lang.String r7 = "/v1/config"
            r6.b(r7)
            r6.c(r8)
            r6.d(r9)
            r7 = 0
            r6.f43054b = r7
            com.paytm.signal.c r8 = com.paytm.signal.c.f43614a
            com.paytm.pai.network.d r0 = r8.a()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = r6.a()
            r8.append(r9)
            java.lang.String r9 = r6.b()
            r8.append(r9)
            java.lang.String r1 = r8.toString()
            java.lang.String r2 = r6.b()
            java.lang.String r3 = r6.f43054b
            java.lang.String r4 = r6.d()
            if (r4 != 0) goto L_0x004c
            kotlin.g.b.k.a()
        L_0x004c:
            java.lang.String r5 = r6.c()
            com.paytm.pai.network.model.EventResponse r8 = r0.a(r1, r2, r3, r4, r5)
            com.paytm.notification.data.b.b$a r9 = new com.paytm.notification.data.b.b$a
            r9.<init>(r8)
            kotlin.g.a.b r9 = (kotlin.g.a.b) r9
            com.paytm.pai.network.model.EventResponse r9 = a((com.paytm.pai.network.model.EventResponse<java.lang.String>) r8, r9)
            java.lang.Boolean r0 = r9.isSuccess()
            if (r0 != 0) goto L_0x0068
            kotlin.g.b.k.a()
        L_0x0068:
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x00e6
            r0 = 0
            if (r8 == 0) goto L_0x007c
            java.lang.Integer r1 = r8.getResponseCode()
            if (r1 == 0) goto L_0x007c
            int r1 = r1.intValue()
            goto L_0x007d
        L_0x007c:
            r1 = 0
        L_0x007d:
            r2 = 404(0x194, float:5.66E-43)
            if (r1 == r2) goto L_0x00e6
            if (r8 == 0) goto L_0x008e
            java.lang.Integer r1 = r8.getResponseCode()
            if (r1 == 0) goto L_0x008e
            int r1 = r1.intValue()
            goto L_0x008f
        L_0x008e:
            r1 = 0
        L_0x008f:
            r2 = 1
            if (r1 == r2) goto L_0x00e6
            com.paytm.notification.b.e$b r1 = com.paytm.notification.b.e.f43014a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "[ServerCallError] getRemoteConfig() failed. ResponseCode: "
            r2.<init>(r3)
            if (r8 == 0) goto L_0x00a2
            java.lang.Integer r3 = r8.getResponseCode()
            goto L_0x00a3
        L_0x00a2:
            r3 = r7
        L_0x00a3:
            r2.append(r3)
            r3 = 32
            r2.append(r3)
            java.lang.String r4 = "URL: "
            r2.append(r4)
            java.lang.String r4 = r6.b()
            r2.append(r4)
            r2.append(r3)
            java.lang.String r4 = "Response: "
            r2.append(r4)
            if (r8 == 0) goto L_0x00c8
            java.lang.Object r4 = r8.getResponse()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x00c9
        L_0x00c8:
            r4 = r7
        L_0x00c9:
            r2.append(r4)
            r2.append(r3)
            java.lang.String r3 = "ErrorMessage: "
            r2.append(r3)
            if (r8 == 0) goto L_0x00da
            java.lang.String r7 = r8.getErrorMessage()
        L_0x00da:
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            java.lang.Object[] r8 = new java.lang.Object[r0]
            r1.d(r7, r8)
        L_0x00e6:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.notification.data.b.b.a(java.lang.String, java.lang.String, java.lang.String):com.paytm.pai.network.model.EventResponse");
    }

    static final class a extends l implements kotlin.g.a.b<String, HashMap<String, String>> {
        final /* synthetic */ EventResponse $response;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(EventResponse eventResponse) {
            super(1);
            this.$response = eventResponse;
        }

        /* renamed from: com.paytm.notification.data.b.b$a$a  reason: collision with other inner class name */
        public static final class C0721a extends com.google.gson.b.a<HashMap<String, String>> {
            C0721a() {
            }
        }

        public final HashMap<String, String> invoke(String str) {
            if (str == null) {
                return null;
            }
            try {
                return (HashMap) new f().a(str, new C0721a().getType());
            } catch (Exception e2) {
                e.b bVar = e.f43014a;
                StringBuilder sb = new StringBuilder("response code: ");
                EventResponse eventResponse = this.$response;
                sb.append(eventResponse != null ? eventResponse.getResponseCode() : null);
                sb.append(" response: ");
                sb.append(str);
                sb.append(" \nerror: ");
                sb.append(e2.getMessage());
                bVar.c(sb.toString(), new Object[0]);
                return null;
            }
        }
    }
}
