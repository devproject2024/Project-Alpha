package com.travel.bus.busticket.g;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.mobile.h5container.api.H5ErrorCode;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.a;
import com.paytm.utility.q;
import com.paytm.utility.v;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.travel.bus.R;
import com.travel.bus.busticket.c.c;
import com.travel.bus.busticket.i.d;
import com.travel.bus.pojo.bussearch.CJRBusBPDPCancellationPolicyItem;
import com.travel.bus.pojo.busticket.CJRBusSearchItem;
import com.travel.bus.pojo.busticket.TripBusDetail;
import com.travel.bus.pojo.busticket.TripBusDetailsItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import org.json.JSONException;
import org.json.JSONObject;

public final class e implements b, com.travel.bus.busticket.f.e {

    /* renamed from: a  reason: collision with root package name */
    public com.travel.bus.busticket.d.b f22370a;

    /* renamed from: b  reason: collision with root package name */
    private c.a f22371b;

    /* renamed from: c  reason: collision with root package name */
    private Context f22372c;

    public e(c.a aVar, Context context) {
        this.f22371b = aVar;
        this.f22372c = context;
    }

    public final void a(boolean z, Context context, String str, String str2, String str3, boolean z2, String str4, String str5) {
        String str6 = str;
        String str7 = str2;
        String str8 = str3;
        boolean z3 = z2;
        String str9 = str4;
        String str10 = str5;
        if (str10 != null) {
            JSONObject jSONObject = new JSONObject();
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put(AppConstants.SSO_TOKEN, a.q(context));
            try {
                com.travel.bus.a.a();
                jSONObject.put("is_deal_applicable", com.travel.bus.a.b().a("isBusDealsApplicable", true));
            } catch (JSONException unused) {
            }
            if (z3) {
                try {
                    jSONObject.put("extra_params", true);
                    jSONObject.put("tripId", str6);
                    jSONObject.put("providerId", str7);
                    jSONObject.put("requestid", str9);
                    jSONObject.put(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR, str8);
                    jSONObject.put("isSingleLady", z3);
                } catch (JSONException e2) {
                    q.c(e2.getMessage());
                }
            } else {
                try {
                    jSONObject.put("extra_params", true);
                    jSONObject.put("tripId", str6);
                    jSONObject.put("providerId", str7);
                    jSONObject.put("requestid", str9);
                    jSONObject.put(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR, str8);
                } catch (JSONException e3) {
                    q.c(e3.getMessage());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(H5ErrorCode.HTTP_SERVICE_UNAVAILABLE));
            arrayList.add(Integer.valueOf(SDKConstants.ERROR_CODE_753));
            this.f22371b.b();
            if (z) {
                com.paytm.network.b bVar = new com.paytm.network.b();
                bVar.f42877a = context;
                bVar.f42878b = a.c.BUS;
                bVar.f42879c = a.C0715a.POST;
                bVar.f42880d = str10;
                bVar.f42884h = jSONObject.toString();
                bVar.f42881e = null;
                bVar.f42882f = hashMap;
                bVar.f42883g = null;
                bVar.f42885i = new TripBusDetail();
                bVar.j = this;
                bVar.t = a();
                bVar.n = a.b.SILENT;
                bVar.o = "bus-seat-layout-page";
                bVar.l().a();
                return;
            }
            this.f22371b.d();
        }
    }

    private static JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "BusSelectSeatScreen");
            if (d.a().f22430h != null) {
                jSONObject.put("requestId", d.a().f22430h);
            }
        } catch (JSONException e2) {
            q.c(e2.getMessage());
        }
        return jSONObject;
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        Context context = this.f22372c;
        if (context != null && (iJRPaytmDataModel instanceof TripBusDetail)) {
            TripBusDetail tripBusDetail = (TripBusDetail) iJRPaytmDataModel;
            if (tripBusDetail != null && tripBusDetail.getBody() != null && tripBusDetail.getBody().size() > 0) {
                this.f22371b.a(tripBusDetail);
                this.f22371b.f();
            } else if (tripBusDetail == null || TextUtils.isEmpty((String) tripBusDetail.getError())) {
                this.f22371b.a(context.getString(R.string.error), context.getString(R.string.error), false);
            } else {
                this.f22371b.a(context.getString(R.string.error), (String) tripBusDetail.getError(), false);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0065 A[Catch:{ Exception -> 0x023c }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008b A[Catch:{ Exception -> 0x023c }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0233 A[Catch:{ Exception -> 0x023c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void handleErrorCode(int r9, com.paytm.network.model.IJRPaytmDataModel r10, com.paytm.network.model.NetworkCustomError r11) {
        /*
            r8 = this;
            android.content.Context r0 = r8.f22372c
            if (r0 == 0) goto L_0x0244
            com.travel.bus.busticket.c.c$a r0 = r8.f22371b
            r0.c()
            if (r11 == 0) goto L_0x002c
            java.lang.String r0 = r11.getAlertMessage()     // Catch:{ Exception -> 0x0050 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0050 }
            if (r0 != 0) goto L_0x002c
            com.travel.bus.a.a()     // Catch:{ Exception -> 0x0050 }
            com.travel.g.a r1 = com.travel.bus.a.b()     // Catch:{ Exception -> 0x0050 }
            java.lang.String r2 = "bus_bus_selection_error"
            java.lang.String r3 = "/bus-tickets/search-results"
            java.lang.String r4 = "ERROR_MESSAGE"
            java.lang.String r5 = r11.getAlertMessage()     // Catch:{ Exception -> 0x0050 }
            android.content.Context r6 = r8.f22372c     // Catch:{ Exception -> 0x0050 }
            r1.a((java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5, (android.content.Context) r6)     // Catch:{ Exception -> 0x0050 }
            goto L_0x005c
        L_0x002c:
            android.content.Context r0 = r8.f22372c     // Catch:{ Exception -> 0x0050 }
            int r1 = com.travel.bus.R.string.network_error_message     // Catch:{ Exception -> 0x0050 }
            java.lang.String r6 = r0.getString(r1)     // Catch:{ Exception -> 0x0050 }
            com.travel.bus.a.a()     // Catch:{ Exception -> 0x0050 }
            com.travel.g.a r2 = com.travel.bus.a.b()     // Catch:{ Exception -> 0x0050 }
            java.lang.String r3 = "bus_bus_selection_error"
            java.lang.String r4 = "/bus-tickets/search-results"
            java.lang.String r5 = "ERROR_MESSAGE"
            com.travel.bus.a.a()     // Catch:{ Exception -> 0x0050 }
            com.travel.g.a r0 = com.travel.bus.a.b()     // Catch:{ Exception -> 0x0050 }
            android.content.Context r7 = r0.D()     // Catch:{ Exception -> 0x0050 }
            r2.a((java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (android.content.Context) r7)     // Catch:{ Exception -> 0x0050 }
            goto L_0x005c
        L_0x0050:
            r0 = move-exception
            boolean r1 = com.paytm.utility.b.v
            if (r1 == 0) goto L_0x005c
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.c(r0)
        L_0x005c:
            com.travel.bus.pojo.busticket.CJRNewErrorFormat r0 = new com.travel.bus.pojo.busticket.CJRNewErrorFormat     // Catch:{ Exception -> 0x023c }
            r0.<init>()     // Catch:{ Exception -> 0x023c }
            com.paytm.network.model.NetworkResponse r1 = r11.networkResponse     // Catch:{ Exception -> 0x023c }
            if (r1 == 0) goto L_0x0087
            com.paytm.network.model.NetworkResponse r1 = r11.networkResponse     // Catch:{ Exception -> 0x023c }
            byte[] r2 = r1.data     // Catch:{ Exception -> 0x023c }
            if (r2 == 0) goto L_0x0087
            java.lang.String r2 = new java.lang.String     // Catch:{ Exception -> 0x0083 }
            byte[] r1 = r1.data     // Catch:{ Exception -> 0x0083 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0083 }
            com.google.gsonhtcfix.f r1 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x0083 }
            r1.<init>()     // Catch:{ Exception -> 0x0083 }
            java.lang.Class r3 = r0.getClass()     // Catch:{ Exception -> 0x0083 }
            java.lang.Object r1 = r1.a((java.lang.String) r2, r3)     // Catch:{ Exception -> 0x0083 }
            com.travel.bus.pojo.busticket.CJRNewErrorFormat r1 = (com.travel.bus.pojo.busticket.CJRNewErrorFormat) r1     // Catch:{ Exception -> 0x0083 }
            r0 = r1
            goto L_0x0087
        L_0x0083:
            r1 = move-exception
            r1.getMessage()     // Catch:{ Exception -> 0x023c }
        L_0x0087:
            r1 = 503(0x1f7, float:7.05E-43)
            if (r9 == r1) goto L_0x0233
            r1 = 753(0x2f1, float:1.055E-42)
            if (r9 == r1) goto L_0x0183
            a((int) r9, (com.paytm.network.model.NetworkCustomError) r11)     // Catch:{ Exception -> 0x023c }
            boolean r9 = r10 instanceof com.travel.bus.pojo.busticket.TripBusDetail     // Catch:{ Exception -> 0x023c }
            if (r9 == 0) goto L_0x00c9
            com.travel.bus.pojo.busticket.i r9 = r0.getStatus()     // Catch:{ Exception -> 0x023c }
            com.travel.bus.pojo.busticket.j r9 = r9.getMessage()     // Catch:{ Exception -> 0x023c }
            java.lang.String r9 = r9.f22819b     // Catch:{ Exception -> 0x023c }
            if (r9 != 0) goto L_0x00c3
            com.travel.bus.pojo.busticket.i r9 = r0.getStatus()     // Catch:{ Exception -> 0x023c }
            com.travel.bus.pojo.busticket.j r9 = r9.getMessage()     // Catch:{ Exception -> 0x023c }
            java.lang.String r9 = r9.f22820c     // Catch:{ Exception -> 0x023c }
            if (r9 == 0) goto L_0x00af
            goto L_0x00c3
        L_0x00af:
            com.travel.bus.a.a()     // Catch:{ Exception -> 0x023c }
            com.travel.g.a r9 = com.travel.bus.a.b()     // Catch:{ Exception -> 0x023c }
            android.content.Context r9 = r9.D()     // Catch:{ Exception -> 0x023c }
            com.paytm.network.model.NetworkResponse r10 = r11.networkResponse     // Catch:{ Exception -> 0x023c }
            boolean r9 = com.travel.bus.busticket.i.o.a((android.content.Context) r9, (com.paytm.network.model.NetworkResponse) r10)     // Catch:{ Exception -> 0x023c }
            if (r9 == 0) goto L_0x012e
            return
        L_0x00c3:
            com.travel.bus.busticket.c.c$a r9 = r8.f22371b     // Catch:{ Exception -> 0x023c }
            r9.a((com.travel.bus.pojo.busticket.CJRNewErrorFormat) r0)     // Catch:{ Exception -> 0x023c }
            return
        L_0x00c9:
            com.travel.bus.pojo.busticket.i r9 = r0.getStatus()     // Catch:{ Exception -> 0x023c }
            com.travel.bus.pojo.busticket.j r9 = r9.getMessage()     // Catch:{ Exception -> 0x023c }
            java.lang.String r9 = r9.f22819b     // Catch:{ Exception -> 0x023c }
            if (r9 != 0) goto L_0x012f
            com.travel.bus.pojo.busticket.i r9 = r0.getStatus()     // Catch:{ Exception -> 0x023c }
            com.travel.bus.pojo.busticket.j r9 = r9.getMessage()     // Catch:{ Exception -> 0x023c }
            java.lang.String r9 = r9.f22820c     // Catch:{ Exception -> 0x023c }
            if (r9 == 0) goto L_0x00e2
            goto L_0x012f
        L_0x00e2:
            java.lang.String r9 = r11.getAlertTitle()     // Catch:{ Exception -> 0x023c }
            r10 = 0
            if (r9 == 0) goto L_0x00fd
            java.lang.String r9 = r11.getAlertMessage()     // Catch:{ Exception -> 0x023c }
            if (r9 == 0) goto L_0x00fd
            com.travel.bus.busticket.c.c$a r9 = r8.f22371b     // Catch:{ Exception -> 0x023c }
            java.lang.String r0 = r11.getAlertTitle()     // Catch:{ Exception -> 0x023c }
            java.lang.String r11 = r11.getAlertMessage()     // Catch:{ Exception -> 0x023c }
            r9.a((java.lang.String) r0, (java.lang.String) r11, (boolean) r10)     // Catch:{ Exception -> 0x023c }
            return
        L_0x00fd:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x023c }
            r9.<init>()     // Catch:{ Exception -> 0x023c }
            android.content.Context r0 = r8.f22372c     // Catch:{ Exception -> 0x023c }
            int r1 = com.travel.bus.R.string.network_error_message     // Catch:{ Exception -> 0x023c }
            java.lang.String r0 = r0.getString(r1)     // Catch:{ Exception -> 0x023c }
            r9.append(r0)     // Catch:{ Exception -> 0x023c }
            java.lang.String r0 = " "
            r9.append(r0)     // Catch:{ Exception -> 0x023c }
            java.lang.String r11 = r11.getUrl()     // Catch:{ Exception -> 0x023c }
            r9.append(r11)     // Catch:{ Exception -> 0x023c }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x023c }
            com.travel.bus.busticket.c.c$a r11 = r8.f22371b     // Catch:{ Exception -> 0x023c }
            android.content.Context r0 = r8.f22372c     // Catch:{ Exception -> 0x023c }
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ Exception -> 0x023c }
            int r1 = com.travel.bus.R.string.network_error_heading     // Catch:{ Exception -> 0x023c }
            java.lang.String r0 = r0.getString(r1)     // Catch:{ Exception -> 0x023c }
            r11.a((java.lang.String) r0, (java.lang.String) r9, (boolean) r10)     // Catch:{ Exception -> 0x023c }
        L_0x012e:
            return
        L_0x012f:
            com.travel.bus.pojo.busticket.i r9 = r0.getStatus()     // Catch:{ Exception -> 0x023c }
            com.travel.bus.pojo.busticket.j r9 = r9.getMessage()     // Catch:{ Exception -> 0x023c }
            java.lang.String r9 = r9.f22818a     // Catch:{ Exception -> 0x023c }
            java.lang.String r10 = "redirect_SRP"
            boolean r9 = r9.equalsIgnoreCase(r10)     // Catch:{ Exception -> 0x023c }
            if (r9 == 0) goto L_0x015d
            android.content.Intent r9 = new android.content.Intent     // Catch:{ Exception -> 0x023c }
            com.travel.bus.a.a()     // Catch:{ Exception -> 0x023c }
            com.travel.g.a r10 = com.travel.bus.a.b()     // Catch:{ Exception -> 0x023c }
            android.content.Context r10 = r10.D()     // Catch:{ Exception -> 0x023c }
            java.lang.Class<com.travel.bus.busticket.activity.AJRBusSearchSRPActivity> r11 = com.travel.bus.busticket.activity.AJRBusSearchSRPActivity.class
            r9.<init>(r10, r11)     // Catch:{ Exception -> 0x023c }
            r10 = 67108864(0x4000000, float:1.5046328E-36)
            r9.addFlags(r10)     // Catch:{ Exception -> 0x023c }
            r10 = 268435456(0x10000000, float:2.5243549E-29)
            r9.addFlags(r10)     // Catch:{ Exception -> 0x023c }
        L_0x015d:
            com.travel.bus.busticket.c.c$a r9 = r8.f22371b     // Catch:{ Exception -> 0x023c }
            com.travel.bus.pojo.busticket.i r10 = r0.getStatus()     // Catch:{ Exception -> 0x023c }
            com.travel.bus.pojo.busticket.j r10 = r10.getMessage()     // Catch:{ Exception -> 0x023c }
            java.lang.String r10 = r10.f22819b     // Catch:{ Exception -> 0x023c }
            com.travel.bus.pojo.busticket.i r11 = r0.getStatus()     // Catch:{ Exception -> 0x023c }
            com.travel.bus.pojo.busticket.j r11 = r11.getMessage()     // Catch:{ Exception -> 0x023c }
            java.lang.String r11 = r11.f22820c     // Catch:{ Exception -> 0x023c }
            com.travel.bus.pojo.busticket.i r0 = r0.getStatus()     // Catch:{ Exception -> 0x023c }
            com.travel.bus.pojo.busticket.j r0 = r0.getMessage()     // Catch:{ Exception -> 0x023c }
            java.lang.String r0 = r0.a()     // Catch:{ Exception -> 0x023c }
            r9.a((java.lang.String) r10, (java.lang.String) r11, (java.lang.String) r0)     // Catch:{ Exception -> 0x023c }
            return
        L_0x0183:
            java.util.HashMap r9 = new java.util.HashMap     // Catch:{ Exception -> 0x023c }
            r9.<init>()     // Catch:{ Exception -> 0x023c }
            java.lang.String r10 = "event_category"
            java.lang.String r1 = "bus_seat"
            r9.put(r10, r1)     // Catch:{ Exception -> 0x023c }
            java.lang.String r10 = "event_action"
            java.lang.String r1 = "no_seats_availabe"
            r9.put(r10, r1)     // Catch:{ Exception -> 0x023c }
            java.lang.String r10 = "screenName"
            java.lang.String r1 = "/bus-tickets-seatlayout"
            r9.put(r10, r1)     // Catch:{ Exception -> 0x023c }
            java.lang.String r10 = "vertical_name"
            java.lang.String r1 = "bus"
            r9.put(r10, r1)     // Catch:{ Exception -> 0x023c }
            java.lang.String r10 = "user_id"
            com.travel.bus.a.a()     // Catch:{ Exception -> 0x023c }
            com.travel.g.a r1 = com.travel.bus.a.b()     // Catch:{ Exception -> 0x023c }
            android.content.Context r1 = r1.D()     // Catch:{ Exception -> 0x023c }
            java.lang.String r1 = com.paytm.utility.b.n((android.content.Context) r1)     // Catch:{ Exception -> 0x023c }
            r9.put(r10, r1)     // Catch:{ Exception -> 0x023c }
            com.travel.bus.a.a()     // Catch:{ Exception -> 0x023c }
            com.travel.g.a r10 = com.travel.bus.a.b()     // Catch:{ Exception -> 0x023c }
            java.lang.String r1 = "custom_event"
            com.travel.bus.a.a()     // Catch:{ Exception -> 0x023c }
            com.travel.g.a r2 = com.travel.bus.a.b()     // Catch:{ Exception -> 0x023c }
            android.content.Context r2 = r2.D()     // Catch:{ Exception -> 0x023c }
            r10.a((java.lang.String) r1, (java.util.Map<java.lang.String, java.lang.Object>) r9, (android.content.Context) r2)     // Catch:{ Exception -> 0x023c }
            com.travel.bus.pojo.busticket.i r9 = r0.getStatus()     // Catch:{ Exception -> 0x023c }
            com.travel.bus.pojo.busticket.j r9 = r9.getMessage()     // Catch:{ Exception -> 0x023c }
            java.lang.String r9 = r9.f22819b     // Catch:{ Exception -> 0x023c }
            if (r9 != 0) goto L_0x020d
            com.travel.bus.pojo.busticket.i r9 = r0.getStatus()     // Catch:{ Exception -> 0x023c }
            com.travel.bus.pojo.busticket.j r9 = r9.getMessage()     // Catch:{ Exception -> 0x023c }
            java.lang.String r9 = r9.f22820c     // Catch:{ Exception -> 0x023c }
            if (r9 == 0) goto L_0x01ea
            goto L_0x020d
        L_0x01ea:
            com.travel.bus.a.a()     // Catch:{ Exception -> 0x023c }
            com.travel.g.a r9 = com.travel.bus.a.b()     // Catch:{ Exception -> 0x023c }
            android.content.Context r9 = r9.D()     // Catch:{ Exception -> 0x023c }
            com.paytm.network.model.NetworkResponse r10 = r11.networkResponse     // Catch:{ Exception -> 0x023c }
            boolean r9 = com.travel.bus.busticket.i.o.a((android.content.Context) r9, (com.paytm.network.model.NetworkResponse) r10)     // Catch:{ Exception -> 0x023c }
            if (r9 == 0) goto L_0x01fe
            return
        L_0x01fe:
            com.travel.bus.busticket.c.c$a r9 = r8.f22371b     // Catch:{ Exception -> 0x023c }
            java.lang.String r10 = r11.getAlertTitle()     // Catch:{ Exception -> 0x023c }
            java.lang.String r11 = r11.getAlertMessage()     // Catch:{ Exception -> 0x023c }
            r0 = 1
            r9.a((java.lang.String) r10, (java.lang.String) r11, (boolean) r0)     // Catch:{ Exception -> 0x023c }
            return
        L_0x020d:
            com.travel.bus.busticket.c.c$a r9 = r8.f22371b     // Catch:{ Exception -> 0x023c }
            com.travel.bus.pojo.busticket.i r10 = r0.getStatus()     // Catch:{ Exception -> 0x023c }
            com.travel.bus.pojo.busticket.j r10 = r10.getMessage()     // Catch:{ Exception -> 0x023c }
            java.lang.String r10 = r10.f22819b     // Catch:{ Exception -> 0x023c }
            com.travel.bus.pojo.busticket.i r11 = r0.getStatus()     // Catch:{ Exception -> 0x023c }
            com.travel.bus.pojo.busticket.j r11 = r11.getMessage()     // Catch:{ Exception -> 0x023c }
            java.lang.String r11 = r11.f22820c     // Catch:{ Exception -> 0x023c }
            com.travel.bus.pojo.busticket.i r0 = r0.getStatus()     // Catch:{ Exception -> 0x023c }
            com.travel.bus.pojo.busticket.j r0 = r0.getMessage()     // Catch:{ Exception -> 0x023c }
            java.lang.String r0 = r0.a()     // Catch:{ Exception -> 0x023c }
            r9.a((java.lang.String) r10, (java.lang.String) r11, (java.lang.String) r0)     // Catch:{ Exception -> 0x023c }
            return
        L_0x0233:
            a((int) r9, (com.paytm.network.model.NetworkCustomError) r11)     // Catch:{ Exception -> 0x023c }
            com.travel.bus.busticket.c.c$a r9 = r8.f22371b     // Catch:{ Exception -> 0x023c }
            r9.e()     // Catch:{ Exception -> 0x023c }
            return
        L_0x023c:
            r9 = move-exception
            java.lang.String r9 = r9.getMessage()
            com.paytm.utility.q.c(r9)
        L_0x0244:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.busticket.g.e.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void");
    }

    public static String a(CJRBusSearchItem cJRBusSearchItem, String str) {
        String str2;
        StringBuilder sb = new StringBuilder();
        if (cJRBusSearchItem == null) {
            return "";
        }
        if (cJRBusSearchItem.getBusTypeTags() != null) {
            String str3 = "";
            for (int i2 = 0; i2 < cJRBusSearchItem.getBusTypeTags().size(); i2++) {
                String str4 = cJRBusSearchItem.getBusTypeTags().get(i2);
                if (i2 == cJRBusSearchItem.getBusTypeTags().size() - 1) {
                    sb.append(str4);
                    str3 = sb.toString().toUpperCase();
                } else {
                    sb.append(str4);
                    sb.append(", ");
                    str3 = sb.toString().toUpperCase();
                }
            }
            str2 = str3;
        } else if (cJRBusSearchItem.getBusTypeName() != null) {
            str2 = cJRBusSearchItem.getBusTypeName().toUpperCase();
        } else {
            str2 = "";
        }
        if (!str2.isEmpty() && str2.length() > 25) {
            str2 = v.c(str2);
        }
        if (str == null || str.trim().equalsIgnoreCase("")) {
            return str2;
        }
        return v.a(str2, " ", "|", " ", str);
    }

    private static void a(int i2, NetworkCustomError networkCustomError) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_category", "bus_seat");
        hashMap.put("event_action", "error_popup");
        if (networkCustomError != null) {
            hashMap.put("event_label", networkCustomError.getAlertMessage());
            hashMap.put("event_label2", Integer.valueOf(i2));
        }
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets-seatlayout");
        hashMap.put("vertical_name", "bus");
        com.travel.bus.a.a();
        hashMap.put("user_id", com.paytm.utility.b.n(com.travel.bus.a.b().D()));
        com.travel.bus.a.a();
        com.travel.g.a b2 = com.travel.bus.a.b();
        com.travel.bus.a.a();
        b2.a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, com.travel.bus.a.b().D());
    }

    public static void a(ArrayList<TripBusDetailsItem> arrayList, String str) {
        String str2 = "";
        try {
            Iterator<TripBusDetailsItem> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                TripBusDetailsItem next = it2.next();
                if (!TextUtils.isEmpty(next.getSeatName())) {
                    str2 = str2 + next.getSeatName() + " ";
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put("bus_seat_numbers", str2);
            hashMap.put("bus_number_of_seats", Integer.valueOf(arrayList.size()));
            hashMap.put("event_label2", str);
            com.travel.bus.a.a();
            com.travel.g.a b2 = com.travel.bus.a.b();
            com.travel.bus.a.a();
            b2.a("bus_seat_proceed_clicked", (Map<String, Object>) hashMap, com.travel.bus.a.b().D());
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.c(e2.getMessage());
            }
        }
    }

    public final void a(CJRBusBPDPCancellationPolicyItem cJRBusBPDPCancellationPolicyItem) {
        this.f22371b.a(cJRBusBPDPCancellationPolicyItem);
    }
}
