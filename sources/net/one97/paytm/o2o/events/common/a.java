package net.one97.paytm.o2o.events.common;

import android.content.Context;
import android.net.Uri;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.CJRSelectCitiesModel;
import net.one97.paytm.common.entity.CJRSelectCityModel;
import net.one97.paytm.common.entity.events.CJRInsiderHoldCallResponse;
import net.one97.paytm.common.entity.events.EventsTravellerResponseModel;
import net.one97.paytm.common.entity.shopping.CJRHomePageV2;
import net.one97.paytm.dynamic.module.movie.EventsModuleManager;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.o2o.events.b.c;
import net.one97.paytm.o2o.events.common.entity.events.CJREventModel;
import net.one97.paytm.o2o.events.common.entity.events.CJRPinCodeValidationModel;
import org.json.JSONException;
import org.json.JSONObject;

public class a implements c.b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f73726a = a.class.getSimpleName();

    /* renamed from: h  reason: collision with root package name */
    private static a f73727h;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Context f73728b;

    /* renamed from: c  reason: collision with root package name */
    private CJRSelectCityModel f73729c;

    /* renamed from: d  reason: collision with root package name */
    private String f73730d;

    /* renamed from: e  reason: collision with root package name */
    private String f73731e;

    /* renamed from: f  reason: collision with root package name */
    private int f73732f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, c.b.a> f73733g;

    private a() {
        this.f73729c = null;
        this.f73730d = AppConstants.FOR_ALL;
        this.f73731e = "";
        this.f73732f = 0;
        this.f73733g = new HashMap<>();
        this.f73728b = net.one97.paytm.o2o.events.e.a.a();
        this.f73729c = null;
    }

    public final void a(c.a aVar, String str, c.b.a aVar2) {
        switch (aVar2) {
            case PINCODE_VALIDATION:
                StringBuilder sb = new StringBuilder("https://apiproxy.paytm.com/v1/entertainment/events/validate/pincode");
                this.f73733g.put(sb.toString(), c.b.a.PINCODE_VALIDATION);
                sb.replace(0, sb.length() - 1, com.paytm.utility.c.b(sb.toString(), this.f73728b));
                HashMap hashMap = new HashMap();
                hashMap.put("Content-Type", "application/json");
                a(sb.toString(), new CJRPinCodeValidationModel(), aVar, str, hashMap);
                return;
            case CITIES_LIST_API:
                StringBuilder sb2 = new StringBuilder(net.one97.paytm.o2o.events.a.a().getStringFromGTM("event_cities_url"));
                this.f73733g.put(sb2.toString(), c.b.a.CITIES_LIST_API);
                sb2.replace(0, sb2.length() - 1, com.paytm.utility.c.b(sb2.toString(), this.f73728b));
                if (b.r(this.f73728b)) {
                    sb2.append("&customer_id=" + b.n(this.f73728b));
                }
                a(sb2.toString(), (IJRPaytmDataModel) new CJRSelectCitiesModel(), aVar);
                return;
            case BANNER_API:
                String stringFromGTM = net.one97.paytm.o2o.events.a.a().getStringFromGTM("event_home_banner");
                this.f73733g.put(stringFromGTM, c.b.a.BANNER_API);
                StringBuilder sb3 = new StringBuilder(com.paytm.utility.c.b(stringFromGTM.replace("v1", "v2"), this.f73728b));
                if (b.r(this.f73728b)) {
                    sb3.append("&customer_id=" + b.n(this.f73728b));
                }
                String createRequestBodyForV2 = net.one97.paytm.o2o.events.a.a().createRequestBodyForV2(this.f73728b, "paytm-home", "events page", this.f73729c);
                HashMap hashMap2 = new HashMap();
                hashMap2.put("Content-Type", "application/json");
                a(sb3.toString(), new CJRHomePageV2(), aVar, createRequestBodyForV2, hashMap2);
                return;
            case GRID_DATA_API:
                StringBuilder sb4 = new StringBuilder(net.one97.paytm.o2o.events.a.a().getStringFromGTM("city_events_url").trim());
                this.f73733g.put(sb4.toString(), c.b.a.GRID_DATA_API);
                sb4.append(this.f73731e.replace(" ", "%20"));
                Uri build = Uri.parse(b.u(this.f73728b, com.paytm.utility.c.b(sb4.toString(), this.f73728b))).buildUpon().appendQueryParameter("start", String.valueOf(this.f73732f)).appendQueryParameter("count", "20").appendQueryParameter("cat", this.f73730d).build();
                q.d("making api call with url : " + build.toString());
                a(build.toString(), (IJRPaytmDataModel) new CJREventModel(), aVar);
                return;
            case TRAVELLER_FORM_INFO:
                StringBuilder sb5 = new StringBuilder(net.one97.paytm.o2o.events.a.a().getStringFromGTM("event_fetch_detail_url"));
                this.f73733g.put(sb5.toString(), c.b.a.TRAVELLER_FORM_INFO);
                sb5.replace(0, sb5.length(), com.paytm.utility.c.b(sb5.toString(), this.f73728b));
                sb5.replace(0, sb5.length(), b.u(this.f73728b, sb5.toString()));
                HashMap hashMap3 = new HashMap();
                hashMap3.put("Content-Type", "application/json");
                a(sb5.toString(), new EventsTravellerResponseModel(), aVar, str, hashMap3);
                return;
            case INSIDER_HOLD_CALL_RESPONSE:
                String stringFromGTM2 = net.one97.paytm.o2o.events.a.a().getStringFromGTM("courierEventHoldcallUrl");
                this.f73733g.put(stringFromGTM2, c.b.a.INSIDER_HOLD_CALL_RESPONSE);
                HashMap hashMap4 = new HashMap();
                hashMap4.put("Content-Type", "application/json");
                a(stringFromGTM2, new CJRInsiderHoldCallResponse(), aVar, str, hashMap4);
                return;
            default:
                return;
        }
    }

    private void a(String str, IJRPaytmDataModel iJRPaytmDataModel, final c.a aVar) {
        com.paytm.network.b bVar = new com.paytm.network.b();
        bVar.f42877a = this.f73728b;
        bVar.f42878b = a.c.EVENT;
        bVar.f42879c = a.C0715a.GET;
        bVar.f42880d = str;
        bVar.f42881e = null;
        bVar.f42882f = null;
        bVar.f42883g = null;
        bVar.f42884h = null;
        bVar.f42885i = iJRPaytmDataModel;
        bVar.j = new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                aVar.a(iJRPaytmDataModel, a.this.f73733g);
            }

            /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
                net.one97.paytm.o2o.events.common.a.a(r6.f73735b).remove(r2);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:9:0x0029, code lost:
                r1 = (net.one97.paytm.o2o.events.b.c.b.a) net.one97.paytm.o2o.events.common.a.a(r6.f73735b).get(r2);
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void handleErrorCode(int r7, com.paytm.network.model.IJRPaytmDataModel r8, com.paytm.network.model.NetworkCustomError r9) {
                /*
                    r6 = this;
                    java.lang.String r8 = ""
                    if (r9 == 0) goto L_0x00f4
                    r0 = 0
                    net.one97.paytm.o2o.events.common.a r1 = net.one97.paytm.o2o.events.common.a.this     // Catch:{ Exception -> 0x00de }
                    java.util.HashMap r1 = r1.f73733g     // Catch:{ Exception -> 0x00de }
                    java.util.Set r1 = r1.keySet()     // Catch:{ Exception -> 0x00de }
                    java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x00de }
                L_0x0013:
                    boolean r2 = r1.hasNext()     // Catch:{ Exception -> 0x00de }
                    if (r2 == 0) goto L_0x003f
                    java.lang.Object r2 = r1.next()     // Catch:{ Exception -> 0x00de }
                    java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x00de }
                    java.lang.String r3 = r9.getFullUrl()     // Catch:{ Exception -> 0x00de }
                    boolean r3 = r3.contains(r2)     // Catch:{ Exception -> 0x00de }
                    if (r3 == 0) goto L_0x0013
                    net.one97.paytm.o2o.events.common.a r1 = net.one97.paytm.o2o.events.common.a.this     // Catch:{ Exception -> 0x00de }
                    java.util.HashMap r1 = r1.f73733g     // Catch:{ Exception -> 0x00de }
                    java.lang.Object r1 = r1.get(r2)     // Catch:{ Exception -> 0x00de }
                    net.one97.paytm.o2o.events.b.c$b$a r1 = (net.one97.paytm.o2o.events.b.c.b.a) r1     // Catch:{ Exception -> 0x00de }
                    net.one97.paytm.o2o.events.common.a r3 = net.one97.paytm.o2o.events.common.a.this     // Catch:{ Exception -> 0x00df }
                    java.util.HashMap r3 = r3.f73733g     // Catch:{ Exception -> 0x00df }
                    r3.remove(r2)     // Catch:{ Exception -> 0x00df }
                    goto L_0x0040
                L_0x003f:
                    r1 = r0
                L_0x0040:
                    int r2 = r9.getStatusCode()     // Catch:{ Exception -> 0x00df }
                    r3 = 401(0x191, float:5.62E-43)
                    if (r2 != r3) goto L_0x0074
                    net.one97.paytm.o2o.events.common.a r7 = net.one97.paytm.o2o.events.common.a.this     // Catch:{ Exception -> 0x00df }
                    android.content.Context r7 = r7.f73728b     // Catch:{ Exception -> 0x00df }
                    android.content.res.Resources r7 = r7.getResources()     // Catch:{ Exception -> 0x00df }
                    int r8 = net.one97.paytm.o2o.events.R.string.session_expiry_msg     // Catch:{ Exception -> 0x00df }
                    java.lang.String r7 = r7.getString(r8)     // Catch:{ Exception -> 0x00df }
                    net.one97.paytm.o2o.events.b.c$a r8 = r5     // Catch:{ Exception -> 0x00df }
                    java.lang.String r2 = r9.getFullUrl()     // Catch:{ Exception -> 0x00df }
                    net.one97.paytm.o2o.events.b.c$b$a r3 = net.one97.paytm.o2o.events.b.c.b.a.GET_WALLET_TOKEN_API     // Catch:{ Exception -> 0x00df }
                    net.one97.paytm.o2o.events.common.a r4 = net.one97.paytm.o2o.events.common.a.this     // Catch:{ Exception -> 0x00df }
                    android.content.Context r4 = r4.f73728b     // Catch:{ Exception -> 0x00df }
                    android.content.res.Resources r4 = r4.getResources()     // Catch:{ Exception -> 0x00df }
                    int r5 = net.one97.paytm.o2o.events.R.string.session_expiry_title     // Catch:{ Exception -> 0x00df }
                    java.lang.String r4 = r4.getString(r5)     // Catch:{ Exception -> 0x00df }
                    r8.a(r2, r3, r4, r7)     // Catch:{ Exception -> 0x00df }
                    return
                L_0x0074:
                    r3 = 206(0xce, float:2.89E-43)
                    if (r2 != r3) goto L_0x0086
                    net.one97.paytm.o2o.events.b.c$b$a r3 = net.one97.paytm.o2o.events.b.c.b.a.GRID_DATA_API     // Catch:{ Exception -> 0x00df }
                    if (r1 != r3) goto L_0x0086
                    net.one97.paytm.o2o.events.b.c$a r2 = r5     // Catch:{ Exception -> 0x00df }
                    java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x00df }
                    r2.a(r8, r1, r8, r7)     // Catch:{ Exception -> 0x00df }
                    return
                L_0x0086:
                    java.lang.String r7 = r9.getAlertTitle()     // Catch:{ Exception -> 0x00df }
                    if (r7 == 0) goto L_0x0092
                    java.lang.String r7 = r9.getAlertMessage()     // Catch:{ Exception -> 0x00df }
                    if (r7 != 0) goto L_0x0096
                L_0x0092:
                    r7 = 417(0x1a1, float:5.84E-43)
                    if (r2 != r7) goto L_0x00a8
                L_0x0096:
                    net.one97.paytm.o2o.events.b.c$a r7 = r5     // Catch:{ Exception -> 0x00df }
                    java.lang.String r8 = r9.getAlertMessage()     // Catch:{ Exception -> 0x00df }
                    java.lang.String r2 = r9.getAlertTitle()     // Catch:{ Exception -> 0x00df }
                    java.lang.String r3 = r9.getAlertMessage()     // Catch:{ Exception -> 0x00df }
                    r7.a(r8, r1, r2, r3)     // Catch:{ Exception -> 0x00df }
                    return
                L_0x00a8:
                    java.lang.String r7 = r9.getMessage()     // Catch:{ Exception -> 0x00df }
                    if (r7 == 0) goto L_0x00cc
                    java.lang.String r7 = r9.getMessage()     // Catch:{ Exception -> 0x00df }
                    java.lang.String r8 = "parsing_error"
                    boolean r7 = r7.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x00df }
                    if (r7 == 0) goto L_0x00cc
                    net.one97.paytm.o2o.events.b.c$a r7 = r5     // Catch:{ Exception -> 0x00df }
                    java.lang.String r8 = r9.getUrl()     // Catch:{ Exception -> 0x00df }
                    java.lang.String r2 = r9.getAlertTitle()     // Catch:{ Exception -> 0x00df }
                    java.lang.String r3 = r9.getAlertMessage()     // Catch:{ Exception -> 0x00df }
                    r7.a(r8, r1, r2, r3)     // Catch:{ Exception -> 0x00df }
                    return
                L_0x00cc:
                    net.one97.paytm.o2o.events.b.c$a r7 = r5     // Catch:{ Exception -> 0x00df }
                    java.lang.String r8 = r9.getUrl()     // Catch:{ Exception -> 0x00df }
                    java.lang.String r2 = r9.getAlertTitle()     // Catch:{ Exception -> 0x00df }
                    java.lang.String r3 = r9.getAlertMessage()     // Catch:{ Exception -> 0x00df }
                    r7.a(r8, r1, r2, r3)     // Catch:{ Exception -> 0x00df }
                    goto L_0x00f4
                L_0x00de:
                    r1 = r0
                L_0x00df:
                    java.lang.String unused = net.one97.paytm.o2o.events.common.a.f73726a
                    java.lang.String r7 = "onErrorResponse"
                    com.paytm.utility.q.c(r7)
                    net.one97.paytm.o2o.events.b.c$a r7 = r5
                    java.lang.String r8 = r9.getAlertTitle()
                    java.lang.String r9 = r9.getAlertMessage()
                    r7.a(r0, r1, r8, r9)
                L_0x00f4:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.events.common.a.AnonymousClass1.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void");
            }
        };
        bVar.n = a.b.USER_FACING;
        bVar.o = EventsModuleManager.MODULE_NAME;
        bVar.t = c();
        com.paytm.network.a l = bVar.l();
        l.f42859c = false;
        l.a();
    }

    private void a(String str, IJRPaytmDataModel iJRPaytmDataModel, final c.a aVar, String str2, Map<String, String> map) {
        com.paytm.network.b bVar = new com.paytm.network.b();
        bVar.f42877a = this.f73728b;
        bVar.f42878b = a.c.EVENT;
        bVar.f42879c = a.C0715a.POST;
        bVar.f42880d = str;
        bVar.f42881e = null;
        bVar.f42882f = map;
        bVar.f42883g = null;
        bVar.f42884h = str2;
        bVar.f42885i = iJRPaytmDataModel;
        bVar.j = new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                aVar.a(iJRPaytmDataModel, a.this.f73733g);
            }

            /* JADX WARNING: Code restructure failed: missing block: B:12:0x004c, code lost:
                r0 = (net.one97.paytm.o2o.events.b.c.b.a) net.one97.paytm.o2o.events.common.a.a(r6.f73737b).get(r1);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
                net.one97.paytm.o2o.events.common.a.a(r6.f73737b).remove(r1);
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void handleErrorCode(int r7, com.paytm.network.model.IJRPaytmDataModel r8, com.paytm.network.model.NetworkCustomError r9) {
                /*
                    r6 = this;
                    if (r9 == 0) goto L_0x013b
                    r7 = 0
                    java.lang.String r8 = new java.lang.String     // Catch:{ Exception -> 0x0125 }
                    com.paytm.network.model.NetworkResponse r0 = r9.networkResponse     // Catch:{ Exception -> 0x0125 }
                    byte[] r0 = r0.data     // Catch:{ Exception -> 0x0125 }
                    r8.<init>(r0)     // Catch:{ Exception -> 0x0125 }
                    boolean r0 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x0125 }
                    if (r0 != 0) goto L_0x0027
                    com.paytm.network.model.CJRIllegalCodeError r0 = new com.paytm.network.model.CJRIllegalCodeError     // Catch:{ Exception -> 0x0125 }
                    r0.<init>()     // Catch:{ Exception -> 0x0125 }
                    com.google.gsonhtcfix.f r1 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x0125 }
                    r1.<init>()     // Catch:{ Exception -> 0x0125 }
                    java.lang.Class r0 = r0.getClass()     // Catch:{ Exception -> 0x0125 }
                    java.lang.Object r8 = r1.a((java.lang.String) r8, r0)     // Catch:{ Exception -> 0x0125 }
                    com.paytm.network.model.CJRIllegalCodeError r8 = (com.paytm.network.model.CJRIllegalCodeError) r8     // Catch:{ Exception -> 0x0125 }
                    goto L_0x0028
                L_0x0027:
                    r8 = r7
                L_0x0028:
                    net.one97.paytm.o2o.events.common.a r0 = net.one97.paytm.o2o.events.common.a.this     // Catch:{ Exception -> 0x0125 }
                    java.util.HashMap r0 = r0.f73733g     // Catch:{ Exception -> 0x0125 }
                    java.util.Set r0 = r0.keySet()     // Catch:{ Exception -> 0x0125 }
                    java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x0125 }
                L_0x0036:
                    boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x0125 }
                    if (r1 == 0) goto L_0x0062
                    java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x0125 }
                    java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0125 }
                    java.lang.String r2 = r9.getFullUrl()     // Catch:{ Exception -> 0x0125 }
                    boolean r2 = r2.contains(r1)     // Catch:{ Exception -> 0x0125 }
                    if (r2 == 0) goto L_0x0036
                    net.one97.paytm.o2o.events.common.a r0 = net.one97.paytm.o2o.events.common.a.this     // Catch:{ Exception -> 0x0125 }
                    java.util.HashMap r0 = r0.f73733g     // Catch:{ Exception -> 0x0125 }
                    java.lang.Object r0 = r0.get(r1)     // Catch:{ Exception -> 0x0125 }
                    net.one97.paytm.o2o.events.b.c$b$a r0 = (net.one97.paytm.o2o.events.b.c.b.a) r0     // Catch:{ Exception -> 0x0125 }
                    net.one97.paytm.o2o.events.common.a r2 = net.one97.paytm.o2o.events.common.a.this     // Catch:{ Exception -> 0x0126 }
                    java.util.HashMap r2 = r2.f73733g     // Catch:{ Exception -> 0x0126 }
                    r2.remove(r1)     // Catch:{ Exception -> 0x0126 }
                    goto L_0x0063
                L_0x0062:
                    r0 = r7
                L_0x0063:
                    int r1 = r9.getStatusCode()     // Catch:{ Exception -> 0x0126 }
                    r2 = 401(0x191, float:5.62E-43)
                    if (r1 != r2) goto L_0x0097
                    net.one97.paytm.o2o.events.common.a r8 = net.one97.paytm.o2o.events.common.a.this     // Catch:{ Exception -> 0x0126 }
                    android.content.Context r8 = r8.f73728b     // Catch:{ Exception -> 0x0126 }
                    android.content.res.Resources r8 = r8.getResources()     // Catch:{ Exception -> 0x0126 }
                    int r1 = net.one97.paytm.o2o.events.R.string.session_expiry_msg     // Catch:{ Exception -> 0x0126 }
                    java.lang.String r8 = r8.getString(r1)     // Catch:{ Exception -> 0x0126 }
                    net.one97.paytm.o2o.events.b.c$a r1 = r5     // Catch:{ Exception -> 0x0126 }
                    java.lang.String r2 = r9.getFullUrl()     // Catch:{ Exception -> 0x0126 }
                    net.one97.paytm.o2o.events.b.c$b$a r3 = net.one97.paytm.o2o.events.b.c.b.a.GET_WALLET_TOKEN_API     // Catch:{ Exception -> 0x0126 }
                    net.one97.paytm.o2o.events.common.a r4 = net.one97.paytm.o2o.events.common.a.this     // Catch:{ Exception -> 0x0126 }
                    android.content.Context r4 = r4.f73728b     // Catch:{ Exception -> 0x0126 }
                    android.content.res.Resources r4 = r4.getResources()     // Catch:{ Exception -> 0x0126 }
                    int r5 = net.one97.paytm.o2o.events.R.string.session_expiry_title     // Catch:{ Exception -> 0x0126 }
                    java.lang.String r4 = r4.getString(r5)     // Catch:{ Exception -> 0x0126 }
                    r1.a(r2, r3, r4, r8)     // Catch:{ Exception -> 0x0126 }
                    return
                L_0x0097:
                    if (r8 == 0) goto L_0x00cd
                    com.paytm.network.model.CJRStatusError r2 = r8.getStatusError()     // Catch:{ Exception -> 0x0126 }
                    com.paytm.network.model.CJRError r2 = r2.getmMessage()     // Catch:{ Exception -> 0x0126 }
                    if (r2 == 0) goto L_0x00cd
                    net.one97.paytm.o2o.events.b.c$a r1 = r5     // Catch:{ Exception -> 0x0126 }
                    com.paytm.network.model.CJRStatusError r2 = r8.getStatusError()     // Catch:{ Exception -> 0x0126 }
                    com.paytm.network.model.CJRError r2 = r2.getmMessage()     // Catch:{ Exception -> 0x0126 }
                    java.lang.String r2 = r2.getMessage()     // Catch:{ Exception -> 0x0126 }
                    com.paytm.network.model.CJRStatusError r3 = r8.getStatusError()     // Catch:{ Exception -> 0x0126 }
                    com.paytm.network.model.CJRError r3 = r3.getmMessage()     // Catch:{ Exception -> 0x0126 }
                    java.lang.String r3 = r3.getTitle()     // Catch:{ Exception -> 0x0126 }
                    com.paytm.network.model.CJRStatusError r8 = r8.getStatusError()     // Catch:{ Exception -> 0x0126 }
                    com.paytm.network.model.CJRError r8 = r8.getmMessage()     // Catch:{ Exception -> 0x0126 }
                    java.lang.String r8 = r8.getMessage()     // Catch:{ Exception -> 0x0126 }
                    r1.a(r2, r0, r3, r8)     // Catch:{ Exception -> 0x0126 }
                    return
                L_0x00cd:
                    java.lang.String r8 = r9.getAlertTitle()     // Catch:{ Exception -> 0x0126 }
                    if (r8 == 0) goto L_0x00d9
                    java.lang.String r8 = r9.getAlertMessage()     // Catch:{ Exception -> 0x0126 }
                    if (r8 != 0) goto L_0x00dd
                L_0x00d9:
                    r8 = 417(0x1a1, float:5.84E-43)
                    if (r1 != r8) goto L_0x00ef
                L_0x00dd:
                    net.one97.paytm.o2o.events.b.c$a r8 = r5     // Catch:{ Exception -> 0x0126 }
                    java.lang.String r1 = r9.getAlertMessage()     // Catch:{ Exception -> 0x0126 }
                    java.lang.String r2 = r9.getAlertTitle()     // Catch:{ Exception -> 0x0126 }
                    java.lang.String r3 = r9.getAlertMessage()     // Catch:{ Exception -> 0x0126 }
                    r8.a(r1, r0, r2, r3)     // Catch:{ Exception -> 0x0126 }
                    return
                L_0x00ef:
                    java.lang.String r8 = r9.getMessage()     // Catch:{ Exception -> 0x0126 }
                    if (r8 == 0) goto L_0x0113
                    java.lang.String r8 = r9.getMessage()     // Catch:{ Exception -> 0x0126 }
                    java.lang.String r1 = "parsing_error"
                    boolean r8 = r8.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x0126 }
                    if (r8 == 0) goto L_0x0113
                    net.one97.paytm.o2o.events.b.c$a r8 = r5     // Catch:{ Exception -> 0x0126 }
                    java.lang.String r1 = r9.getUrl()     // Catch:{ Exception -> 0x0126 }
                    java.lang.String r2 = r9.getAlertTitle()     // Catch:{ Exception -> 0x0126 }
                    java.lang.String r3 = r9.getAlertMessage()     // Catch:{ Exception -> 0x0126 }
                    r8.a(r1, r0, r2, r3)     // Catch:{ Exception -> 0x0126 }
                    return
                L_0x0113:
                    net.one97.paytm.o2o.events.b.c$a r8 = r5     // Catch:{ Exception -> 0x0126 }
                    java.lang.String r1 = r9.getUrl()     // Catch:{ Exception -> 0x0126 }
                    java.lang.String r2 = r9.getAlertTitle()     // Catch:{ Exception -> 0x0126 }
                    java.lang.String r3 = r9.getAlertMessage()     // Catch:{ Exception -> 0x0126 }
                    r8.a(r1, r0, r2, r3)     // Catch:{ Exception -> 0x0126 }
                    goto L_0x013b
                L_0x0125:
                    r0 = r7
                L_0x0126:
                    java.lang.String unused = net.one97.paytm.o2o.events.common.a.f73726a
                    java.lang.String r8 = "onErrorResponse"
                    com.paytm.utility.q.c(r8)
                    net.one97.paytm.o2o.events.b.c$a r8 = r5
                    java.lang.String r1 = r9.getAlertTitle()
                    java.lang.String r9 = r9.getAlertMessage()
                    r8.a(r7, r0, r1, r9)
                L_0x013b:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.events.common.a.AnonymousClass2.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void");
            }
        };
        bVar.n = a.b.USER_FACING;
        bVar.o = EventsModuleManager.MODULE_NAME;
        bVar.t = c();
        com.paytm.network.a l = bVar.l();
        l.f42859c = false;
        l.a();
    }

    private static JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "CJRApiClient");
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static a a() {
        if (f73727h == null) {
            f73727h = new a();
        }
        return f73727h;
    }
}
