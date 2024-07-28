package com.paytm.notification.data.b;

import android.content.Context;
import com.google.gson.f;
import com.paytm.notification.b.e;
import com.paytm.notification.models.FlashFetchResponse;
import com.paytm.pai.network.model.EventResponse;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.u;

public final class c extends a {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Context context) {
        super(context);
        k.c(context, "context");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0088, code lost:
        r11 = r8.getResponseCode();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.paytm.pai.network.model.EventResponse<java.util.ArrayList<com.paytm.notification.models.FlashFetchResponse>> a(java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, com.paytm.notification.models.request.FetchInboxRequest r12) {
        /*
            r7 = this;
            java.lang.String r0 = "end"
            kotlin.g.b.k.c(r8, r0)
            java.lang.String r0 = "customerId"
            kotlin.g.b.k.c(r9, r0)
            java.lang.String r0 = "secret"
            kotlin.g.b.k.c(r10, r0)
            java.lang.String r0 = "clientId"
            kotlin.g.b.k.c(r11, r0)
            java.lang.String r0 = "request"
            kotlin.g.b.k.c(r12, r0)
            r7.a(r12)
            r7.a((java.lang.String) r8)
            java.lang.String r8 = r7.f43055c
            r7.f43055c = r8
            java.lang.String r8 = java.lang.String.valueOf(r9)
            java.lang.String r9 = "/v2/api/flash/"
            java.lang.String r8 = r9.concat(r8)
            r7.b(r8)
            r7.c(r10)
            r7.d(r11)
            com.paytm.signal.c r8 = com.paytm.signal.c.f43614a
            com.paytm.pai.network.d r0 = r8.a()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = r7.a()
            r8.append(r9)
            java.lang.String r9 = r7.b()
            r8.append(r9)
            java.lang.String r1 = r8.toString()
            java.lang.String r2 = r7.b()
            java.lang.String r3 = r7.f43054b
            if (r3 != 0) goto L_0x005e
            kotlin.g.b.k.a()
        L_0x005e:
            java.lang.String r4 = r7.d()
            java.lang.String r5 = r7.c()
            r6 = 1
            com.paytm.pai.network.model.EventResponse r8 = r0.a(r1, r2, r3, r4, r5, r6)
            com.paytm.notification.data.b.c$a r9 = new com.paytm.notification.data.b.c$a
            r9.<init>(r8)
            kotlin.g.a.b r9 = (kotlin.g.a.b) r9
            com.paytm.pai.network.model.EventResponse r9 = a((com.paytm.pai.network.model.EventResponse<java.lang.String>) r8, r9)
            java.lang.Boolean r10 = r9.isSuccess()
            if (r10 != 0) goto L_0x007f
            kotlin.g.b.k.a()
        L_0x007f:
            boolean r10 = r10.booleanValue()
            if (r10 != 0) goto L_0x00fe
            r10 = 0
            if (r8 == 0) goto L_0x0093
            java.lang.Integer r11 = r8.getResponseCode()
            if (r11 == 0) goto L_0x0093
            int r11 = r11.intValue()
            goto L_0x0094
        L_0x0093:
            r11 = 0
        L_0x0094:
            r12 = 404(0x194, float:5.66E-43)
            if (r11 == r12) goto L_0x00fe
            if (r8 == 0) goto L_0x00a5
            java.lang.Integer r11 = r8.getResponseCode()
            if (r11 == 0) goto L_0x00a5
            int r11 = r11.intValue()
            goto L_0x00a6
        L_0x00a5:
            r11 = 0
        L_0x00a6:
            r12 = 1
            if (r11 == r12) goto L_0x00fe
            com.paytm.notification.b.e$b r11 = com.paytm.notification.b.e.f43014a
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r0 = "[ServerCallError] syncFlashMessages() failed. ResponseCode: "
            r12.<init>(r0)
            r0 = 0
            if (r8 == 0) goto L_0x00ba
            java.lang.Integer r1 = r8.getResponseCode()
            goto L_0x00bb
        L_0x00ba:
            r1 = r0
        L_0x00bb:
            r12.append(r1)
            r1 = 32
            r12.append(r1)
            java.lang.String r2 = "URL: "
            r12.append(r2)
            java.lang.String r2 = r7.b()
            r12.append(r2)
            r12.append(r1)
            java.lang.String r2 = "Response: "
            r12.append(r2)
            if (r8 == 0) goto L_0x00e0
            java.lang.Object r2 = r8.getResponse()
            java.lang.String r2 = (java.lang.String) r2
            goto L_0x00e1
        L_0x00e0:
            r2 = r0
        L_0x00e1:
            r12.append(r2)
            r12.append(r1)
            java.lang.String r1 = "ErrorMessage: "
            r12.append(r1)
            if (r8 == 0) goto L_0x00f2
            java.lang.String r0 = r8.getErrorMessage()
        L_0x00f2:
            r12.append(r0)
            java.lang.String r8 = r12.toString()
            java.lang.Object[] r10 = new java.lang.Object[r10]
            r11.d(r8, r10)
        L_0x00fe:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.notification.data.b.c.a(java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.paytm.notification.models.request.FetchInboxRequest):com.paytm.pai.network.model.EventResponse");
    }

    static final class a extends l implements b<String, ArrayList<FlashFetchResponse>> {
        final /* synthetic */ EventResponse $response;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(EventResponse eventResponse) {
            super(1);
            this.$response = eventResponse;
        }

        /* renamed from: com.paytm.notification.data.b.c$a$a  reason: collision with other inner class name */
        public static final class C0722a extends com.google.gson.b.a<List<? extends FlashFetchResponse>> {
            C0722a() {
            }
        }

        public final ArrayList<FlashFetchResponse> invoke(String str) {
            if (str == null) {
                return null;
            }
            try {
                Object a2 = new f().a(str, new C0722a().getType());
                if (a2 != null) {
                    return (ArrayList) a2;
                }
                throw new u("null cannot be cast to non-null type kotlin.collections.ArrayList<com.paytm.notification.models.FlashFetchResponse> /* = java.util.ArrayList<com.paytm.notification.models.FlashFetchResponse> */");
            } catch (Exception e2) {
                e.b bVar = e.f43014a;
                StringBuilder sb = new StringBuilder("response code: ");
                EventResponse eventResponse = this.$response;
                sb.append(eventResponse != null ? eventResponse.getResponseCode() : null);
                sb.append(" response: ");
                sb.append(str);
                sb.append(" \nerror: ");
                sb.append(e2.getMessage());
                bVar.d(sb.toString(), new Object[0]);
                return null;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x007e, code lost:
        r10 = r7.getResponseCode();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.paytm.pai.network.model.EventResponse<java.lang.Boolean> a(com.paytm.notification.models.request.FetchInboxRequest r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11) {
        /*
            r6 = this;
            java.lang.String r0 = "pushIds"
            kotlin.g.b.k.c(r7, r0)
            java.lang.String r0 = "endPoints"
            kotlin.g.b.k.c(r8, r0)
            java.lang.String r0 = "customerId"
            kotlin.g.b.k.c(r9, r0)
            java.lang.String r0 = "secret"
            kotlin.g.b.k.c(r10, r0)
            java.lang.String r0 = "clientId"
            kotlin.g.b.k.c(r11, r0)
            r6.a(r7)
            r6.a((java.lang.String) r8)
            java.lang.String r7 = java.lang.String.valueOf(r9)
            java.lang.String r9 = "/v2/api/flash/"
            java.lang.String r7 = r9.concat(r7)
            r6.b(r7)
            r6.c(r10)
            r6.d(r11)
            com.paytm.signal.c r7 = com.paytm.signal.c.f43614a
            com.paytm.pai.network.d r0 = r7.a()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r8)
            java.lang.String r8 = r6.b()
            r7.append(r8)
            java.lang.String r1 = r7.toString()
            java.lang.String r2 = r6.b()
            java.lang.String r3 = r6.f43054b
            if (r3 != 0) goto L_0x0056
            kotlin.g.b.k.a()
        L_0x0056:
            r4 = r11
            r5 = r10
            com.paytm.pai.network.model.EventResponse r7 = r0.b(r1, r2, r3, r4, r5)
            com.paytm.notification.data.b.e r8 = new com.paytm.notification.data.b.e
            com.google.gson.f r9 = new com.google.gson.f
            r9.<init>()
            r8.<init>(r9)
            java.lang.Class r9 = java.lang.Boolean.TYPE
            com.paytm.pai.network.model.EventResponse r8 = a(r7, r8, r9)
            java.lang.Boolean r9 = r8.isSuccess()
            if (r9 != 0) goto L_0x0075
            kotlin.g.b.k.a()
        L_0x0075:
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto L_0x00f4
            r9 = 0
            if (r7 == 0) goto L_0x0089
            java.lang.Integer r10 = r7.getResponseCode()
            if (r10 == 0) goto L_0x0089
            int r10 = r10.intValue()
            goto L_0x008a
        L_0x0089:
            r10 = 0
        L_0x008a:
            r11 = 404(0x194, float:5.66E-43)
            if (r10 == r11) goto L_0x00f4
            if (r7 == 0) goto L_0x009b
            java.lang.Integer r10 = r7.getResponseCode()
            if (r10 == 0) goto L_0x009b
            int r10 = r10.intValue()
            goto L_0x009c
        L_0x009b:
            r10 = 0
        L_0x009c:
            r11 = 1
            if (r10 == r11) goto L_0x00f4
            com.paytm.notification.b.e$b r10 = com.paytm.notification.b.e.f43014a
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r0 = "[ServerCallError] syncFlashDeleted() failed. ResponseCode: "
            r11.<init>(r0)
            r0 = 0
            if (r7 == 0) goto L_0x00b0
            java.lang.Integer r1 = r7.getResponseCode()
            goto L_0x00b1
        L_0x00b0:
            r1 = r0
        L_0x00b1:
            r11.append(r1)
            r1 = 32
            r11.append(r1)
            java.lang.String r2 = "URL: "
            r11.append(r2)
            java.lang.String r2 = r6.b()
            r11.append(r2)
            r11.append(r1)
            java.lang.String r2 = "Response: "
            r11.append(r2)
            if (r7 == 0) goto L_0x00d6
            java.lang.Object r2 = r7.getResponse()
            java.lang.String r2 = (java.lang.String) r2
            goto L_0x00d7
        L_0x00d6:
            r2 = r0
        L_0x00d7:
            r11.append(r2)
            r11.append(r1)
            java.lang.String r1 = "ErrorMessage: "
            r11.append(r1)
            if (r7 == 0) goto L_0x00e8
            java.lang.String r0 = r7.getErrorMessage()
        L_0x00e8:
            r11.append(r0)
            java.lang.String r7 = r11.toString()
            java.lang.Object[] r9 = new java.lang.Object[r9]
            r10.d(r7, r9)
        L_0x00f4:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.notification.data.b.c.a(com.paytm.notification.models.request.FetchInboxRequest, java.lang.String, java.lang.String, java.lang.String, java.lang.String):com.paytm.pai.network.model.EventResponse");
    }
}
