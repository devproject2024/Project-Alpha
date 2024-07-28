package net.one97.paytm.phoenix.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.alipay.mobile.h5container.api.H5Param;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.n;
import com.paytmmall.clpartifact.utils.GAUtil;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.deeplink.h;
import net.one97.paytm.h5.consent.CJRConsentModel;
import net.one97.paytm.h5.consent.CJRsaveConsentModel;
import net.one97.paytm.h5.consent.ConsentActivity;
import net.one97.paytm.h5.model.OpenIdResponseModel;
import net.one97.paytm.h5.model.ResponseModel;
import net.one97.paytm.h5.model.TrustLoginResponseModel;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.provider.H5PartnerAppsDataProvider;
import net.one97.paytm.phoenix.ui.PhoenixActivity;
import org.json.JSONObject;

public final class y extends net.one97.paytm.phoenix.core.a {

    /* renamed from: a  reason: collision with root package name */
    boolean f19856a;

    /* renamed from: b  reason: collision with root package name */
    net.one97.paytm.phoenix.api.b f19857b;

    /* renamed from: c  reason: collision with root package name */
    String f19858c;

    /* renamed from: d  reason: collision with root package name */
    boolean f19859d;

    public interface a {
        void a(IJRPaytmDataModel iJRPaytmDataModel);

        void a(IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError);
    }

    public y() {
        super("paytmFetchAuthCode", "paytmFetchOpenId");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(net.one97.paytm.phoenix.api.H5Event r7, net.one97.paytm.phoenix.api.b r8) {
        /*
            r6 = this;
            java.lang.String r0 = "event"
            kotlin.g.b.k.c(r7, r0)
            java.lang.String r0 = "bridgeContext"
            kotlin.g.b.k.c(r8, r0)
            super.a((net.one97.paytm.phoenix.api.H5Event) r7, (net.one97.paytm.phoenix.api.b) r8)
            boolean r0 = r6.a((net.one97.paytm.phoenix.api.H5Event) r7)
            r1 = 1
            if (r0 == 0) goto L_0x00c1
            r6.f19857b = r8
            android.app.Activity r8 = r7.getActivity()
            r0 = 0
            if (r8 == 0) goto L_0x003b
            android.app.Activity r8 = r7.getActivity()
            if (r8 != 0) goto L_0x0026
            kotlin.g.b.k.a()
        L_0x0026:
            boolean r8 = r8 instanceof net.one97.paytm.phoenix.ui.PhoenixActivity
            if (r8 == 0) goto L_0x003b
            android.app.Activity r8 = r7.getActivity()
            if (r8 == 0) goto L_0x0033
            net.one97.paytm.phoenix.ui.PhoenixActivity r8 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r8
            goto L_0x003c
        L_0x0033:
            kotlin.u r7 = new kotlin.u
            java.lang.String r8 = "null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity"
            r7.<init>(r8)
            throw r7
        L_0x003b:
            r8 = r0
        L_0x003c:
            r2 = 0
            if (r8 != 0) goto L_0x0040
            return r2
        L_0x0040:
            org.json.JSONObject r3 = r7.getParams()
            if (r3 == 0) goto L_0x004d
            java.lang.String r4 = "clientId"
            java.lang.String r3 = r3.getString(r4)
            goto L_0x004e
        L_0x004d:
            r3 = r0
        L_0x004e:
            r6.f19858c = r3
            java.lang.String r3 = r6.f19858c
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            if (r3 == 0) goto L_0x005f
            int r3 = r3.length()
            if (r3 != 0) goto L_0x005d
            goto L_0x005f
        L_0x005d:
            r3 = 0
            goto L_0x0060
        L_0x005f:
            r3 = 1
        L_0x0060:
            if (r3 == 0) goto L_0x006c
            net.one97.paytm.phoenix.api.b r3 = r6.f19857b
            if (r3 == 0) goto L_0x006c
            r4 = 2
            java.lang.String r5 = "clientID not passed"
            r3.a((net.one97.paytm.phoenix.api.H5Event) r7, (int) r4, (java.lang.String) r5)
        L_0x006c:
            r3 = r8
            android.content.Context r3 = (android.content.Context) r3
            java.lang.String r3 = com.paytm.utility.d.a(r3)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            if (r3 == 0) goto L_0x007d
            int r3 = r3.length()
            if (r3 != 0) goto L_0x007e
        L_0x007d:
            r2 = 1
        L_0x007e:
            if (r2 == 0) goto L_0x00be
            net.one97.paytm.phoenix.core.c r2 = net.one97.paytm.phoenix.core.c.f59399a
            net.one97.paytm.phoenix.api.f r2 = r2.b()
            java.lang.Class<net.one97.paytm.phoenix.provider.PhoenixAuthProvider> r3 = net.one97.paytm.phoenix.provider.PhoenixAuthProvider.class
            java.lang.String r3 = r3.getName()
            java.lang.String r4 = "PhoenixAuthProvider::class.java.name"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            java.lang.Object r2 = r2.a(r3)
            net.one97.paytm.phoenix.provider.PhoenixAuthProvider r2 = (net.one97.paytm.phoenix.provider.PhoenixAuthProvider) r2
            if (r2 != 0) goto L_0x00a1
            net.one97.paytm.phoenix.api.a r8 = net.one97.paytm.phoenix.api.a.FORBIDDEN
            java.lang.String r0 = "No implementation found for 'PhoenixAuthProvider'"
            r6.a((net.one97.paytm.phoenix.api.H5Event) r7, (net.one97.paytm.phoenix.api.a) r8, (java.lang.String) r0)
            goto L_0x00c1
        L_0x00a1:
            r3 = r8
            android.app.Activity r3 = (android.app.Activity) r3
            android.content.Intent r0 = r2.login(r3, r0)
            java.util.Observable r2 = r8.h()
            net.one97.paytm.phoenix.d.y$g r3 = new net.one97.paytm.phoenix.d.y$g
            r3.<init>(r6, r8, r7, r0)
            java.util.Observer r3 = (java.util.Observer) r3
            r2.addObserver(r3)
            r7 = 567(0x237, float:7.95E-43)
            java.lang.String r2 = "paytmLogin"
            r8.a(r0, r7, r2)
            goto L_0x00c1
        L_0x00be:
            r6.a((net.one97.paytm.phoenix.api.H5Event) r7, (net.one97.paytm.phoenix.ui.PhoenixActivity) r8)
        L_0x00c1:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.d.y.a(net.one97.paytm.phoenix.api.H5Event, net.one97.paytm.phoenix.api.b):boolean");
    }

    static final class g implements Observer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f19878a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PhoenixActivity f19879b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ H5Event f19880c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Intent f19881d;

        g(y yVar, PhoenixActivity phoenixActivity, H5Event h5Event, Intent intent) {
            this.f19878a = yVar;
            this.f19879b = phoenixActivity;
            this.f19880c = h5Event;
            this.f19881d = intent;
        }

        public final void update(Observable observable, Object obj) {
            y yVar = this.f19878a;
            if (k.a(obj, (Object) Boolean.FALSE)) {
                net.one97.paytm.phoenix.api.b bVar = yVar.f19857b;
                if (bVar != null) {
                    bVar.a(this.f19880c, -2, "user login failed");
                }
            } else {
                yVar.a(this.f19880c, this.f19879b);
            }
            this.f19879b.h().deleteObservers();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(H5Event h5Event, PhoenixActivity phoenixActivity) {
        String bridgeName = h5Event.getBridgeName();
        if (k.a((Object) bridgeName, (Object) "paytmFetchAuthCode")) {
            b(h5Event, phoenixActivity);
        } else if (k.a((Object) bridgeName, (Object) "paytmFetchOpenId")) {
            c(h5Event, phoenixActivity);
        }
    }

    private final void b(H5Event h5Event, PhoenixActivity phoenixActivity) {
        if (!TextUtils.isEmpty(this.f19858c)) {
            HashMap hashMap = new HashMap();
            Context context = phoenixActivity;
            Map map = hashMap;
            map.put(AppConstants.SSO_TOKEN, com.paytm.utility.d.a(context));
            String str = this.f19858c;
            if (str == null) {
                k.a();
            }
            map.put("client_id", str);
            String a2 = n.a(h5Event.getActivity());
            HashMap hashMap2 = new HashMap();
            hashMap2.put("locale=", a2 + "-IN");
            k.a((Object) net.one97.paytm.j.c.a(), "GTMLoader.getInstance()");
            String ah = net.one97.paytm.j.c.ah();
            k.a((Object) ah, "GTMLoader.getInstance().h5ConsentUrl");
            a(context, ah, a.C0715a.GET, hashMap, hashMap2, new CJRConsentModel(), new d(this, phoenixActivity, h5Event), (String) null);
        }
    }

    public static final class d implements a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f19870a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PhoenixActivity f19871b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ H5Event f19872c;

        static final class a implements Observer {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ d f19873a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f19874b;

            a(d dVar, String str) {
                this.f19873a = dVar;
                this.f19874b = str;
            }

            public final /* synthetic */ void update(Observable observable, Object obj) {
                String str;
                k.c(observable, "o");
                this.f19873a.f19870a.f19856a = false;
                if (obj instanceof Boolean) {
                    this.f19873a.f19870a.f19859d = ((Boolean) obj).booleanValue();
                }
                y yVar = this.f19873a.f19870a;
                H5Event h5Event = this.f19873a.f19872c;
                PhoenixActivity phoenixActivity = this.f19873a.f19871b;
                HashMap hashMap = new HashMap();
                Map map = hashMap;
                Context context = phoenixActivity;
                map.put(AppConstants.SSO_TOKEN, com.paytm.utility.d.a(context));
                String str2 = yVar.f19858c;
                if (str2 == null) {
                    k.a();
                }
                map.put("client_id", str2);
                String jSONObject = new JSONObject().put("consent", yVar.f19859d).toString();
                k.a((Object) jSONObject, "JSONObject().put(\"consen…AccessGranted).toString()");
                k.a((Object) net.one97.paytm.j.c.a(), "GTMLoader.getInstance()");
                String ai = net.one97.paytm.j.c.ai();
                k.a((Object) ai, "GTMLoader.getInstance().h5SaveConsentUrl");
                y.a(context, ai, a.C0715a.POST, hashMap, (HashMap<String, String>) null, new CJRsaveConsentModel(), new h(yVar, h5Event, phoenixActivity), jSONObject);
                String appName = H5PartnerAppsDataProvider.getAppName(this.f19874b);
                Map hashMap2 = new HashMap();
                hashMap2.put("event_label", this.f19873a.f19870a.f19859d ? "Consent Allowed" : "Consent Denied");
                hashMap2.put("screen", appName == null ? "" : appName);
                hashMap2.put("event_action", "Consent Analytics");
                hashMap2.put("event_label2", "1.0.0-9.1.0-CA-83248-RC2");
                if (appName == null) {
                    str = "";
                } else {
                    str = appName;
                }
                hashMap2.put("event_category", str);
                hashMap2.put("custId", net.one97.paytm.j.a.b((Context) this.f19873a.f19871b));
                Context context2 = this.f19873a.f19871b;
                if (appName == null) {
                    appName = "";
                }
                net.one97.paytm.j.a.a(context2, GAUtil.CUSTOM_EVENT, appName, (Map<String, Object>) hashMap2);
            }
        }

        d(y yVar, PhoenixActivity phoenixActivity, H5Event h5Event) {
            this.f19870a = yVar;
            this.f19871b = phoenixActivity;
            this.f19872c = h5Event;
        }

        public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof CJRConsentModel)) {
                CJRConsentModel cJRConsentModel = (CJRConsentModel) iJRPaytmDataModel;
                if (!cJRConsentModel.response.consentRequired || cJRConsentModel.response.consentGiven) {
                    y.a(this.f19870a, this.f19872c, this.f19871b);
                    return;
                }
                String str = cJRConsentModel.response.consentData;
                boolean z = false;
                if (str != null) {
                    CharSequence charSequence = str;
                    if (!(charSequence == null || charSequence.length() == 0)) {
                        z = true;
                    }
                }
                if (z) {
                    PhoenixActivity phoenixActivity = this.f19871b;
                    if (!(phoenixActivity instanceof PhoenixActivity)) {
                        return;
                    }
                    if (phoenixActivity != null) {
                        phoenixActivity.i().deleteObservers();
                        String f2 = this.f19871b.f();
                        PhoenixActivity phoenixActivity2 = this.f19871b;
                        if (phoenixActivity2 != null) {
                            phoenixActivity2.i().addObserver(new a(this, f2));
                            if (!this.f19870a.f19856a) {
                                this.f19870a.f19856a = true;
                                Intent intent = new Intent(this.f19871b, ConsentActivity.class);
                                intent.putExtra("data", str);
                                intent.putExtra(H5Param.AID, f2);
                                this.f19871b.a(intent, 10021, "paytmNavigateTo");
                                this.f19871b.overridePendingTransition(17432576, 17432577);
                                return;
                            }
                            return;
                        }
                        throw new u("null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity");
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity");
                }
            }
        }

        public final void a(IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            y.a(this.f19870a, networkCustomError, this.f19872c);
        }
    }

    private final void c(H5Event h5Event, PhoenixActivity phoenixActivity) {
        JSONObject params = h5Event.getParams();
        String string = params != null ? params.getString("clientId") : null;
        if (TextUtils.isEmpty(string)) {
            net.one97.paytm.phoenix.api.b bVar = this.f19857b;
            if (bVar != null) {
                bVar.a(h5Event, 2, "clientID not passed");
                return;
            }
            return;
        }
        a(phoenixActivity, string, (a) new e(this, h5Event));
    }

    public static final class e implements a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f19875a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ H5Event f19876b;

        e(y yVar, H5Event h5Event) {
            this.f19875a = yVar;
            this.f19876b = h5Event;
        }

        public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel == null || !(iJRPaytmDataModel instanceof OpenIdResponseModel)) {
                net.one97.paytm.phoenix.api.b bVar = this.f19875a.f19857b;
                if (bVar != null) {
                    bVar.a(this.f19876b, -14, "Failed to fetch OpenID");
                    return;
                }
                return;
            }
            y yVar = this.f19875a;
            ResponseModel response = ((OpenIdResponseModel) iJRPaytmDataModel).getResponse();
            k.a((Object) response, "model.response");
            String openId = response.getOpenId();
            k.a((Object) openId, "model.response.openId");
            yVar.a("openId", (Object) openId);
            net.one97.paytm.phoenix.core.a.a(this.f19875a, this.f19876b, (Object) null, false, 6);
        }

        public final void a(IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            y.a(this.f19875a, networkCustomError, this.f19876b);
        }
    }

    private static void a(PhoenixActivity phoenixActivity, String str, a aVar) {
        HashMap hashMap = new HashMap();
        Map map = hashMap;
        Context context = phoenixActivity;
        map.put(AppConstants.SSO_TOKEN, com.paytm.utility.d.a(context));
        map.put("client_id", str);
        map.put("Content-Type", "application/json");
        k.a((Object) net.one97.paytm.j.c.a(), "GTMLoader.getInstance()");
        String aj = net.one97.paytm.j.c.aj();
        k.a((Object) aj, "GTMLoader.getInstance().h5OpenIdUrl");
        a(context, aj, a.C0715a.GET, hashMap, (HashMap<String, String>) null, new OpenIdResponseModel(), aVar, (String) null);
    }

    public static final class f implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f19877a;

        f(a aVar) {
            this.f19877a = aVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f19877a.a(iJRPaytmDataModel, networkCustomError);
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            this.f19877a.a(iJRPaytmDataModel);
        }
    }

    /* access modifiers changed from: package-private */
    public static void a(Context context, String str, a.C0715a aVar, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, IJRPaytmDataModel iJRPaytmDataModel, a aVar2, String str2) {
        com.paytm.network.a a2 = net.one97.paytm.common.b.d.a(context, str, new f(aVar2), hashMap, hashMap2, aVar, str2, iJRPaytmDataModel, a.c.HOME, a.b.SILENT);
        a2.b(true);
        a2.a();
    }

    public static final class h implements a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f19882a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ H5Event f19883b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ PhoenixActivity f19884c;

        h(y yVar, H5Event h5Event, PhoenixActivity phoenixActivity) {
            this.f19882a = yVar;
            this.f19883b = h5Event;
            this.f19884c = phoenixActivity;
        }

        public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel == null || !(iJRPaytmDataModel instanceof CJRsaveConsentModel)) {
                net.one97.paytm.phoenix.api.b bVar = this.f19882a.f19857b;
                if (bVar != null) {
                    bVar.a(this.f19883b, -5, "Failed to save consent");
                }
            } else if (this.f19882a.f19859d) {
                y.a(this.f19882a, this.f19883b, this.f19884c);
            } else {
                net.one97.paytm.phoenix.api.b bVar2 = this.f19882a.f19857b;
                if (bVar2 != null) {
                    bVar2.a(this.f19883b, -1, "User denied consent");
                }
            }
        }

        public final void a(IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            y.a(this.f19882a, networkCustomError, this.f19883b);
        }
    }

    public static final class b implements a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f19860a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ H5Event f19861b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f19862c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ x.e f19863d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ x.e f19864e;

        b(y yVar, H5Event h5Event, String str, x.e eVar, x.e eVar2) {
            this.f19860a = yVar;
            this.f19861b = h5Event;
            this.f19862c = str;
            this.f19863d = eVar;
            this.f19864e = eVar2;
        }

        public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel == null || !(iJRPaytmDataModel instanceof TrustLoginResponseModel)) {
                net.one97.paytm.phoenix.api.b bVar = this.f19860a.f19857b;
                if (bVar != null) {
                    bVar.a(this.f19861b, -9, "Failed to fetch AuthCode");
                    return;
                }
                return;
            }
            TrustLoginResponseModel trustLoginResponseModel = (TrustLoginResponseModel) iJRPaytmDataModel;
            if ("991".equals(trustLoginResponseModel.getResponseCode())) {
                net.one97.paytm.phoenix.api.b bVar2 = this.f19860a.f19857b;
                if (bVar2 != null) {
                    bVar2.a(this.f19861b, -8, "Device Not Verified");
                }
            } else if ("1503".equals(trustLoginResponseModel.getResponseCode())) {
                net.one97.paytm.phoenix.api.b bVar3 = this.f19860a.f19857b;
                if (bVar3 != null) {
                    bVar3.a(this.f19861b, -7, "Invalid token");
                }
            } else {
                x.e eVar = this.f19863d;
                T data = trustLoginResponseModel.getData();
                if (data == null) {
                    data = "";
                }
                eVar.element = data;
                y.a(this.f19860a, (String) this.f19863d.element, (String) this.f19864e.element, this.f19861b);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r9 = r9.getNetworkResponse();
         */
        /* JADX WARNING: Removed duplicated region for block: B:70:0x00f6  */
        /* JADX WARNING: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(com.paytm.network.model.IJRPaytmDataModel r9, com.paytm.network.model.NetworkCustomError r10) {
            /*
                r8 = this;
                java.lang.String r0 = "responseCode"
                if (r9 == 0) goto L_0x0011
                com.paytm.network.model.NetworkResponse r9 = r9.getNetworkResponse()
                if (r9 == 0) goto L_0x0011
                int r9 = r9.statusCode
                java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
                goto L_0x0012
            L_0x0011:
                r9 = 0
            L_0x0012:
                r1 = -6
                r2 = -7
                r3 = -9
                r4 = 0
                java.lang.String r5 = "Unable to process your request"
                if (r9 != 0) goto L_0x001c
                goto L_0x0024
            L_0x001c:
                int r6 = r9.intValue()
                r7 = 400(0x190, float:5.6E-43)
                if (r6 == r7) goto L_0x00ef
            L_0x0024:
                if (r9 != 0) goto L_0x0027
                goto L_0x002f
            L_0x0027:
                int r6 = r9.intValue()
                r7 = 401(0x191, float:5.62E-43)
                if (r6 == r7) goto L_0x00ea
            L_0x002f:
                if (r9 != 0) goto L_0x0032
                goto L_0x003a
            L_0x0032:
                int r6 = r9.intValue()
                r7 = 430(0x1ae, float:6.03E-43)
                if (r6 == r7) goto L_0x00ea
            L_0x003a:
                if (r9 != 0) goto L_0x003d
                goto L_0x0047
            L_0x003d:
                int r6 = r9.intValue()
                r7 = 435(0x1b3, float:6.1E-43)
                if (r6 != r7) goto L_0x0047
                goto L_0x00ea
            L_0x0047:
                if (r9 != 0) goto L_0x004a
                goto L_0x0057
            L_0x004a:
                int r6 = r9.intValue()
                r7 = 530(0x212, float:7.43E-43)
                if (r6 != r7) goto L_0x0057
                java.lang.String r5 = "Invalid SSO token"
            L_0x0054:
                r1 = -7
                goto L_0x00f0
            L_0x0057:
                if (r9 != 0) goto L_0x005a
                goto L_0x0066
            L_0x005a:
                int r9 = r9.intValue()
                r6 = 711(0x2c7, float:9.96E-43)
                if (r9 != r6) goto L_0x0066
                java.lang.String r5 = "Invalid clientID"
                goto L_0x00f0
            L_0x0066:
                if (r10 == 0) goto L_0x00ef
                com.paytm.network.model.NetworkResponse r9 = r10.networkResponse
                if (r9 == 0) goto L_0x00ef
                byte[] r9 = r9.data
                if (r9 == 0) goto L_0x00ef
                java.lang.String r10 = new java.lang.String     // Catch:{ JSONException -> 0x00e1 }
                java.nio.charset.Charset r6 = kotlin.m.d.f47971a     // Catch:{ JSONException -> 0x00e1 }
                r10.<init>(r9, r6)     // Catch:{ JSONException -> 0x00e1 }
                org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00e1 }
                r9.<init>(r10)     // Catch:{ JSONException -> 0x00e1 }
                java.lang.String r10 = "message"
                java.lang.String r10 = r9.optString(r10)     // Catch:{ JSONException -> 0x00e1 }
                java.lang.String r6 = "jsonObject.optString(\"message\")"
                kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r6)     // Catch:{ JSONException -> 0x00e1 }
                r5 = r10
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ JSONException -> 0x00de }
                boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ JSONException -> 0x00de }
                if (r5 == 0) goto L_0x009c
                java.lang.String r5 = "responseMessage"
                java.lang.String r5 = r9.optString(r5)     // Catch:{ JSONException -> 0x00de }
                java.lang.String r6 = "jsonObject.optString(\"responseMessage\")"
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)     // Catch:{ JSONException -> 0x00de }
                goto L_0x009d
            L_0x009c:
                r5 = r10
            L_0x009d:
                boolean r10 = r9.has(r0)     // Catch:{ JSONException -> 0x00e1 }
                if (r10 == 0) goto L_0x00ef
                java.lang.Object r9 = r9.get(r0)     // Catch:{ JSONException -> 0x00e1 }
                java.lang.String r10 = "991"
                boolean r10 = kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.Object) r10)     // Catch:{ JSONException -> 0x00e1 }
                if (r10 == 0) goto L_0x00b1
                r1 = -8
                goto L_0x00f0
            L_0x00b1:
                java.lang.String r10 = "430"
                boolean r10 = kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.Object) r10)     // Catch:{ JSONException -> 0x00e1 }
                if (r10 != 0) goto L_0x00ec
                java.lang.String r10 = "435"
                boolean r10 = kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.Object) r10)     // Catch:{ JSONException -> 0x00e1 }
                if (r10 == 0) goto L_0x00c2
                goto L_0x00ec
            L_0x00c2:
                java.lang.String r10 = "530"
                boolean r10 = kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.Object) r10)     // Catch:{ JSONException -> 0x00e1 }
                if (r10 == 0) goto L_0x00cb
                goto L_0x0054
            L_0x00cb:
                java.lang.String r10 = "711"
                boolean r10 = kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.Object) r10)     // Catch:{ JSONException -> 0x00e1 }
                if (r10 == 0) goto L_0x00d4
                goto L_0x00f0
            L_0x00d4:
                java.lang.String r10 = "827"
                boolean r9 = kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.Object) r10)     // Catch:{ JSONException -> 0x00e1 }
                if (r9 == 0) goto L_0x00ef
                r1 = -5
                goto L_0x00f0
            L_0x00de:
                r9 = move-exception
                r5 = r10
                goto L_0x00e2
            L_0x00e1:
                r9 = move-exception
            L_0x00e2:
                java.lang.String r9 = r9.getMessage()
                com.paytm.utility.q.b(r9)
                goto L_0x00ef
            L_0x00ea:
                java.lang.String r5 = "Invalid Authorization"
            L_0x00ec:
                r1 = -9
                goto L_0x00f0
            L_0x00ef:
                r1 = 0
            L_0x00f0:
                net.one97.paytm.phoenix.d.y r9 = r8.f19860a
                net.one97.paytm.phoenix.api.b r9 = r9.f19857b
                if (r9 == 0) goto L_0x00fb
                net.one97.paytm.phoenix.api.H5Event r10 = r8.f19861b
                r9.a((net.one97.paytm.phoenix.api.H5Event) r10, (int) r1, (java.lang.String) r5)
            L_0x00fb:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.d.y.b.a(com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void");
        }
    }

    public static final class c implements a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f19865a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ H5Event f19866b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f19867c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ x.e f19868d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ x.e f19869e;

        c(y yVar, H5Event h5Event, String str, x.e eVar, x.e eVar2) {
            this.f19865a = yVar;
            this.f19866b = h5Event;
            this.f19867c = str;
            this.f19868d = eVar;
            this.f19869e = eVar2;
        }

        public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
            T t;
            if (iJRPaytmDataModel == null || !(iJRPaytmDataModel instanceof OpenIdResponseModel)) {
                net.one97.paytm.phoenix.api.b bVar = this.f19865a.f19857b;
                if (bVar != null) {
                    bVar.a(this.f19866b, -14, "Failed to fetch OpenID");
                    return;
                }
                return;
            }
            x.e eVar = this.f19869e;
            ResponseModel response = ((OpenIdResponseModel) iJRPaytmDataModel).getResponse();
            if (response == null || (t = response.getOpenId()) == null) {
                t = "";
            }
            eVar.element = t;
            y.a(this.f19865a, (String) this.f19868d.element, (String) this.f19869e.element, this.f19866b);
        }

        public final void a(IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            y.a(this.f19865a, networkCustomError, this.f19866b);
        }
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.paytm.utility.h f19885a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f19886b;

        i(com.paytm.utility.h hVar, Activity activity) {
            this.f19885a = hVar;
            this.f19886b = activity;
        }

        public final void onClick(View view) {
            this.f19885a.cancel();
            h.a aVar = net.one97.paytm.deeplink.h.f50349a;
            h.a.a(this.f19886b, "paytmmp://login?screen=signOutLogin", (Bundle) null);
        }
    }

    public static final /* synthetic */ void a(y yVar, H5Event h5Event, PhoenixActivity phoenixActivity) {
        String str;
        PackageInfo packageInfo;
        y yVar2 = yVar;
        H5Event h5Event2 = h5Event;
        PhoenixActivity phoenixActivity2 = phoenixActivity;
        String bridgeName = h5Event.getBridgeName();
        if (bridgeName != null) {
            int hashCode = bridgeName.hashCode();
            if (hashCode != -689105682) {
                if (hashCode == 1427433598 && bridgeName.equals("paytmFetchOpenId")) {
                    yVar.c(h5Event, phoenixActivity);
                }
            } else if (bridgeName.equals("paytmFetchAuthCode")) {
                x.e eVar = new x.e();
                String str2 = null;
                eVar.element = null;
                x.e eVar2 = new x.e();
                eVar2.element = null;
                JSONObject params = h5Event.getParams();
                if (params != null) {
                    str2 = params.getString("clientId");
                }
                String str3 = str2;
                if (TextUtils.isEmpty(str3)) {
                    yVar2.a(h5Event2, net.one97.paytm.phoenix.api.a.INVALID_PARAM, "clientID not passed");
                    return;
                }
                Context context = phoenixActivity2;
                if (!com.paytm.utility.b.c(context)) {
                    yVar2.a(h5Event2, net.one97.paytm.phoenix.api.a.FORBIDDEN, "Message empty!");
                    return;
                }
                k.a((Object) net.one97.paytm.j.c.a(), "GTMLoader.getInstance()");
                CharSequence ag = net.one97.paytm.j.c.ag();
                if (ag == null || ag.length() == 0) {
                    yVar2.a(h5Event2, net.one97.paytm.phoenix.api.a.UNKNOWN_ERROR, "trust login url empty");
                    return;
                }
                HashMap hashMap = new HashMap();
                Map map = hashMap;
                map.put("Authorization", "Basic bWFya2V0LWFwcDo5YTA3MTc2Mi1hNDk5LTRiZDktOTE0YS00MzYxZTdjM2Y0YmM=");
                map.put("sessionToken", com.paytm.utility.d.a(context));
                map.put("reqClientId", str3);
                map.put("Content-Type", "application/x-www-form-urlencoded");
                HashMap hashMap2 = new HashMap();
                Map map2 = hashMap2;
                String z = com.paytm.utility.b.z(context);
                if (z == null) {
                    z = "";
                }
                map2.put("deviceIdentifier", z);
                map2.put("playStore", String.valueOf(com.paytm.utility.c.c(context)));
                map2.put("client", "androidapp");
                PackageManager packageManager = phoenixActivity.getPackageManager();
                if (packageManager == null || (packageInfo = packageManager.getPackageInfo(phoenixActivity.getPackageName(), 0)) == null || (str = packageInfo.versionName) == null) {
                    str = "";
                }
                map2.put("version", str);
                String str4 = Build.VERSION.RELEASE;
                k.a((Object) str4, "Build.VERSION.RELEASE");
                map2.put("osVersion", str4);
                String w = com.paytm.utility.b.w(context);
                if (w == null) {
                    w = "";
                }
                map2.put("language", w);
                String str5 = Build.MODEL;
                k.a((Object) str5, "Build.MODEL");
                String encode = URLEncoder.encode(p.a(str5, " ", "_", false), com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8);
                if (encode == null) {
                    encode = "";
                }
                map2.put("deviceName", encode);
                String s = com.paytm.utility.b.s(context);
                if (s == null) {
                    s = "";
                }
                map2.put("lat", s);
                String t = com.paytm.utility.b.t(context);
                if (t == null) {
                    t = "";
                }
                map2.put("long", t);
                map2.put(com.business.merchant_payments.common.utility.AppConstants.TAG_CHILD_SITE_ID, "1");
                map2.put(com.business.merchant_payments.common.utility.AppConstants.TAG_SITE_ID, "1");
                k.a((Object) net.one97.paytm.j.c.a(), "GTMLoader.getInstance()");
                String ag2 = net.one97.paytm.j.c.ag();
                k.a((Object) ag2, "GTMLoader.getInstance().h5TrustLoginUrl");
                y yVar3 = yVar;
                H5Event h5Event3 = h5Event;
                String str6 = str3;
                x.e eVar3 = eVar;
                x.e eVar4 = eVar2;
                a(context, ag2, a.C0715a.POST, hashMap, hashMap2, new TrustLoginResponseModel(), new b(yVar3, h5Event3, str6, eVar3, eVar4), (String) null);
                a(phoenixActivity2, str3, (a) new c(yVar3, h5Event3, str6, eVar3, eVar4));
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.phoenix.d.y r7, com.paytm.network.model.NetworkCustomError r8, net.one97.paytm.phoenix.api.H5Event r9) {
        /*
            java.lang.String r0 = "code"
            r1 = -13
            r2 = 0
            java.lang.String r3 = "Unable to process your request"
            if (r8 == 0) goto L_0x00bc
            com.paytm.network.model.NetworkResponse r8 = r8.networkResponse
            if (r8 == 0) goto L_0x00bc
            byte[] r8 = r8.data
            if (r8 == 0) goto L_0x00bc
            java.lang.String r4 = new java.lang.String     // Catch:{ JSONException -> 0x00b2 }
            java.nio.charset.Charset r5 = kotlin.m.d.f47971a     // Catch:{ JSONException -> 0x00b2 }
            r4.<init>(r8, r5)     // Catch:{ JSONException -> 0x00b2 }
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00b2 }
            r8.<init>(r4)     // Catch:{ JSONException -> 0x00b2 }
            java.lang.String r4 = "message"
            java.lang.String r4 = r8.optString(r4)     // Catch:{ JSONException -> 0x00b2 }
            java.lang.String r5 = "jsonObject.optString(\"message\")"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)     // Catch:{ JSONException -> 0x00b2 }
            boolean r3 = r8.has(r0)     // Catch:{ JSONException -> 0x00b0 }
            if (r3 == 0) goto L_0x00bb
            java.lang.Object r8 = r8.get(r0)     // Catch:{ JSONException -> 0x00b0 }
            java.lang.String r0 = "ER_4500"
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.Object) r0)     // Catch:{ JSONException -> 0x00b0 }
            if (r0 == 0) goto L_0x003e
            r8 = -12
            goto L_0x00be
        L_0x003e:
            java.lang.String r0 = "ER_4501"
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.Object) r0)     // Catch:{ JSONException -> 0x00b0 }
            if (r0 == 0) goto L_0x0084
            if (r9 == 0) goto L_0x0081
            android.app.Activity r8 = r9.getActivity()     // Catch:{ JSONException -> 0x00b0 }
            if (r8 == 0) goto L_0x0081
            java.lang.String r0 = "activity"
            kotlin.g.b.k.c(r8, r0)     // Catch:{ JSONException -> 0x00b0 }
            net.one97.paytm.auth.b.b.b((android.app.Activity) r8)     // Catch:{ JSONException -> 0x00b0 }
            com.paytm.utility.h r0 = new com.paytm.utility.h     // Catch:{ JSONException -> 0x00b0 }
            r3 = r8
            android.content.Context r3 = (android.content.Context) r3     // Catch:{ JSONException -> 0x00b0 }
            r0.<init>(r3)     // Catch:{ JSONException -> 0x00b0 }
            java.lang.String r3 = "Session Time Out"
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ JSONException -> 0x00b0 }
            r0.setTitle(r3)     // Catch:{ JSONException -> 0x00b0 }
            java.lang.String r3 = "You've been logged out of Paytm. Don't worry, just login again to continue"
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ JSONException -> 0x00b0 }
            r0.a(r3)     // Catch:{ JSONException -> 0x00b0 }
            r0.setCancelable(r2)     // Catch:{ JSONException -> 0x00b0 }
            r3 = -3
            java.lang.String r5 = "OK"
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ JSONException -> 0x00b0 }
            net.one97.paytm.phoenix.d.y$i r6 = new net.one97.paytm.phoenix.d.y$i     // Catch:{ JSONException -> 0x00b0 }
            r6.<init>(r0, r8)     // Catch:{ JSONException -> 0x00b0 }
            android.view.View$OnClickListener r6 = (android.view.View.OnClickListener) r6     // Catch:{ JSONException -> 0x00b0 }
            r0.a(r3, r5, r6)     // Catch:{ JSONException -> 0x00b0 }
            r0.show()     // Catch:{ JSONException -> 0x00b0 }
        L_0x0081:
            r8 = -13
            goto L_0x00be
        L_0x0084:
            java.lang.String r0 = "ER_4003"
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.Object) r0)     // Catch:{ JSONException -> 0x00b0 }
            if (r0 == 0) goto L_0x008f
            r8 = -15
            goto L_0x00be
        L_0x008f:
            java.lang.String r0 = "ER_4002"
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.Object) r0)     // Catch:{ JSONException -> 0x00b0 }
            if (r0 == 0) goto L_0x009a
            r8 = -16
            goto L_0x00be
        L_0x009a:
            java.lang.String r0 = "ER_5009"
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.Object) r0)     // Catch:{ JSONException -> 0x00b0 }
            if (r0 == 0) goto L_0x00a5
            r8 = -17
            goto L_0x00be
        L_0x00a5:
            java.lang.String r0 = "ER_5005"
            boolean r8 = kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.Object) r0)     // Catch:{ JSONException -> 0x00b0 }
            if (r8 == 0) goto L_0x00bd
            r8 = -18
            goto L_0x00be
        L_0x00b0:
            r8 = move-exception
            goto L_0x00b4
        L_0x00b2:
            r8 = move-exception
            r4 = r3
        L_0x00b4:
            java.lang.String r8 = r8.getMessage()
            com.paytm.utility.q.b(r8)
        L_0x00bb:
            r3 = r4
        L_0x00bc:
            r4 = r3
        L_0x00bd:
            r8 = 0
        L_0x00be:
            if (r8 == r1) goto L_0x00c7
            net.one97.paytm.phoenix.api.b r7 = r7.f19857b
            if (r7 == 0) goto L_0x00c7
            r7.a((net.one97.paytm.phoenix.api.H5Event) r9, (int) r8, (java.lang.String) r4)
        L_0x00c7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.d.y.a(net.one97.paytm.phoenix.d.y, com.paytm.network.model.NetworkCustomError, net.one97.paytm.phoenix.api.H5Event):void");
    }

    public static final /* synthetic */ void a(y yVar, String str, String str2, H5Event h5Event) {
        if (str != null && str2 != null) {
            yVar.a("authId", (Object) str);
            yVar.a("openId", (Object) str2);
            net.one97.paytm.phoenix.core.a.a(yVar, h5Event, (Object) null, false, 6);
        }
    }
}
