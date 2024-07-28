package net.one97.paytm.h5.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebula.provider.H5ProviderManager;
import com.alipay.mobile.nebulacore.Nebula;
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
import net.one97.paytm.h5paytmsdk.b.ad;
import net.one97.paytm.h5paytmsdk.c.k;
import net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity;
import org.json.JSONObject;

public final class c extends ad {

    /* renamed from: a  reason: collision with root package name */
    private Activity f16800a;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f16801d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public H5BridgeContext f16802e;

    /* renamed from: f  reason: collision with root package name */
    private String f16803f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f16804g;

    public interface a {
        void a(IJRPaytmDataModel iJRPaytmDataModel);

        void a(IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError);
    }

    public c() {
        super("paytmFetchAuthCode", "paytmFetchOpenId");
    }

    public final boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        Activity activity;
        com.alibaba.a.e param;
        super.handleEvent(h5Event, h5BridgeContext);
        if (b(h5Event)) {
            Object obj = null;
            this.f16800a = h5Event != null ? h5Event.getActivity() : null;
            this.f16802e = h5BridgeContext;
            this.f16803f = null;
            this.f16803f = (h5Event == null || (param = h5Event.getParam()) == null) ? null : param.getString("clientId");
            CharSequence charSequence = this.f16803f;
            boolean z = false;
            if (charSequence == null || charSequence.length() == 0) {
                H5BridgeContext h5BridgeContext2 = this.f16802e;
                if (h5BridgeContext2 != null) {
                    h5BridgeContext2.sendError(2, "clientID not passed");
                }
                return true;
            } else if (h5Event != null) {
                CharSequence q = com.paytm.utility.a.q(h5Event.getActivity());
                if (q == null || q.length() == 0) {
                    z = true;
                }
                if (z) {
                    H5ProviderManager providerManager = Nebula.getProviderManager();
                    if (providerManager != null) {
                        obj = providerManager.getProvider(k.class.getName());
                    }
                    k kVar = (k) obj;
                    if (kVar == null) {
                        a(H5Event.Error.FORBIDDEN, "No implementation found for 'PaytmH5AuthProvider'");
                    } else {
                        Intent a2 = kVar.a(h5Event.getActivity());
                        if (!(a2 == null || (activity = h5Event.getActivity()) == null || !(activity instanceof PaytmH5Activity))) {
                            PaytmH5Activity paytmH5Activity = (PaytmH5Activity) activity;
                            paytmH5Activity.f17107e.addObserver(new g(activity, this, h5Event, a2));
                            paytmH5Activity.a(a2, 567, "paytmLogin");
                        }
                    }
                } else {
                    c(h5Event);
                }
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public final void c(H5Event h5Event) {
        String action = h5Event.getAction();
        if (kotlin.g.b.k.a((Object) action, (Object) "paytmFetchAuthCode")) {
            e(h5Event);
        } else if (kotlin.g.b.k.a((Object) action, (Object) "paytmFetchOpenId")) {
            d(h5Event);
        }
    }

    private final void d(H5Event h5Event) {
        String string = h5Event.getParam().getString("clientId");
        if (TextUtils.isEmpty(string)) {
            H5BridgeContext h5BridgeContext = this.f16802e;
            if (h5BridgeContext != null) {
                h5BridgeContext.sendError(2, "clientID not passed");
                return;
            }
            return;
        }
        Activity activity = h5Event.getActivity();
        if (activity != null) {
            kotlin.g.b.k.a((Object) string, "clientId");
            a((Context) activity, string, (a) new e(this, string, h5Event));
        }
    }

    public static final class e implements a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f16820a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f16821b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ H5Event f16822c;

        e(c cVar, String str, H5Event h5Event) {
            this.f16820a = cVar;
            this.f16821b = str;
            this.f16822c = h5Event;
        }

        public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel == null || !(iJRPaytmDataModel instanceof OpenIdResponseModel)) {
                H5BridgeContext a2 = this.f16820a.f16802e;
                if (a2 != null) {
                    a2.sendError(-14, "Failed to fetch OpenID");
                    return;
                }
                return;
            }
            c cVar = this.f16820a;
            ResponseModel response = ((OpenIdResponseModel) iJRPaytmDataModel).getResponse();
            kotlin.g.b.k.a((Object) response, "model.response");
            String openId = response.getOpenId();
            kotlin.g.b.k.a((Object) openId, "model.response.openId");
            cVar.a("openId", (Object) openId);
            this.f16820a.a((Object) null);
        }

        public final void a(IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            c.a(this.f16820a, networkCustomError, this.f16822c);
        }
    }

    private final void e(H5Event h5Event) {
        if (!TextUtils.isEmpty(this.f16803f)) {
            HashMap hashMap = new HashMap();
            String q = com.paytm.utility.a.q(h5Event.getActivity());
            Map map = hashMap;
            kotlin.g.b.k.a((Object) q, "ssoToken");
            map.put(AppConstants.SSO_TOKEN, q);
            String str = this.f16803f;
            if (str == null) {
                kotlin.g.b.k.a();
            }
            map.put("client_id", str);
            String a2 = n.a(h5Event.getActivity());
            HashMap hashMap2 = new HashMap();
            hashMap2.put("locale=", a2 + "-IN");
            Activity activity = h5Event.getActivity();
            kotlin.g.b.k.a((Object) activity, "event.activity");
            kotlin.g.b.k.a((Object) net.one97.paytm.j.c.a(), "GTMLoader.getInstance()");
            String ah = net.one97.paytm.j.c.ah();
            kotlin.g.b.k.a((Object) ah, "GTMLoader.getInstance().h5ConsentUrl");
            a(activity, ah, a.C0715a.GET, hashMap, hashMap2, new CJRConsentModel(), new d(this, h5Event), (String) null);
        }
    }

    public static final class d implements a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f16815a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ H5Event f16816b;

        static final class a implements Observer {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ d f16817a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f16818b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Activity f16819c;

            a(d dVar, String str, Activity activity) {
                this.f16817a = dVar;
                this.f16818b = str;
                this.f16819c = activity;
            }

            public final /* synthetic */ void update(Observable observable, Object obj) {
                String str;
                kotlin.g.b.k.c(observable, "o");
                this.f16817a.f16815a.f16801d = false;
                if (obj instanceof Boolean) {
                    this.f16817a.f16815a.f16804g = ((Boolean) obj).booleanValue();
                }
                c.a(this.f16817a.f16815a, this.f16817a.f16816b);
                String a2 = net.one97.paytm.h5.b.c.a(this.f16818b);
                Map hashMap = new HashMap();
                hashMap.put("event_label", this.f16817a.f16815a.f16804g ? "Consent Allowed" : "Consent Denied");
                hashMap.put("screen", a2 == null ? "" : a2);
                hashMap.put("event_action", "Consent Analytics");
                hashMap.put("event_label2", "2.1.40-MB-07");
                if (a2 == null) {
                    str = "";
                } else {
                    str = a2;
                }
                hashMap.put("event_category", str);
                hashMap.put("custId", net.one97.paytm.j.a.b((Context) this.f16819c));
                Context context = this.f16819c;
                if (a2 == null) {
                    a2 = "";
                }
                net.one97.paytm.j.a.a(context, GAUtil.CUSTOM_EVENT, a2, (Map<String, Object>) hashMap);
            }
        }

        d(c cVar, H5Event h5Event) {
            this.f16815a = cVar;
            this.f16816b = h5Event;
        }

        public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof CJRConsentModel)) {
                CJRConsentModel cJRConsentModel = (CJRConsentModel) iJRPaytmDataModel;
                if (!cJRConsentModel.response.consentRequired || cJRConsentModel.response.consentGiven) {
                    c.b(this.f16815a, this.f16816b);
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
                    Activity activity = this.f16816b.getActivity();
                    if (activity instanceof PaytmH5Activity) {
                        Activity activity2 = this.f16816b.getActivity();
                        if (activity2 != null) {
                            ((PaytmH5Activity) activity2).f17108f.deleteObservers();
                            PaytmH5Activity paytmH5Activity = (PaytmH5Activity) activity;
                            String a2 = paytmH5Activity.a();
                            Activity activity3 = this.f16816b.getActivity();
                            if (activity3 != null) {
                                ((PaytmH5Activity) activity3).f17108f.addObserver(new a(this, a2, activity));
                                if (!this.f16815a.f16801d) {
                                    this.f16815a.f16801d = true;
                                    Intent intent = new Intent(activity, ConsentActivity.class);
                                    intent.putExtra("data", str);
                                    intent.putExtra(H5Param.AID, a2);
                                    paytmH5Activity.a(intent, 10021, "paytmNavigateTo");
                                    activity.overridePendingTransition(17432576, 17432577);
                                    return;
                                }
                                return;
                            }
                            throw new u("null cannot be cast to non-null type net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity");
                        }
                        throw new u("null cannot be cast to non-null type net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity");
                    }
                }
            }
        }

        public final void a(IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            c.a(this.f16815a, networkCustomError, this.f16816b);
        }
    }

    static final class g implements Observer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f16824a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f16825b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ H5Event f16826c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Intent f16827d;

        g(Activity activity, c cVar, H5Event h5Event, Intent intent) {
            this.f16824a = activity;
            this.f16825b = cVar;
            this.f16826c = h5Event;
            this.f16827d = intent;
        }

        public final void update(Observable observable, Object obj) {
            c cVar = this.f16825b;
            if (kotlin.g.b.k.a(obj, (Object) Boolean.FALSE)) {
                H5BridgeContext a2 = cVar.f16802e;
                if (a2 != null) {
                    a2.sendError(-2, "user login failed");
                }
            } else {
                cVar.c(this.f16826c);
            }
            ((PaytmH5Activity) this.f16824a).f17107e.deleteObservers();
        }
    }

    public static final class h implements a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f16828a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ H5Event f16829b;

        h(c cVar, H5Event h5Event) {
            this.f16828a = cVar;
            this.f16829b = h5Event;
        }

        public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel == null || !(iJRPaytmDataModel instanceof CJRsaveConsentModel)) {
                H5BridgeContext a2 = this.f16828a.f16802e;
                if (a2 != null) {
                    a2.sendError(-5, "Failed to save consent");
                }
            } else if (this.f16828a.f16804g) {
                c.b(this.f16828a, this.f16829b);
            } else {
                H5BridgeContext a3 = this.f16828a.f16802e;
                if (a3 != null) {
                    a3.sendError(-1, "User denied consent");
                }
            }
        }

        public final void a(IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            c.a(this.f16828a, networkCustomError, this.f16829b);
        }
    }

    public static final class b implements a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f16805a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f16806b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ x.e f16807c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ x.e f16808d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ H5Event f16809e;

        b(c cVar, String str, x.e eVar, x.e eVar2, H5Event h5Event) {
            this.f16805a = cVar;
            this.f16806b = str;
            this.f16807c = eVar;
            this.f16808d = eVar2;
            this.f16809e = h5Event;
        }

        public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel == null || !(iJRPaytmDataModel instanceof TrustLoginResponseModel)) {
                H5BridgeContext a2 = this.f16805a.f16802e;
                if (a2 != null) {
                    a2.sendError(-9, "Failed to fetch AuthCode");
                    return;
                }
                return;
            }
            TrustLoginResponseModel trustLoginResponseModel = (TrustLoginResponseModel) iJRPaytmDataModel;
            if ("991".equals(trustLoginResponseModel.getResponseCode())) {
                H5BridgeContext a3 = this.f16805a.f16802e;
                if (a3 != null) {
                    a3.sendError(-8, "Device Not Verified");
                }
            } else if ("1503".equals(trustLoginResponseModel.getResponseCode())) {
                H5BridgeContext a4 = this.f16805a.f16802e;
                if (a4 != null) {
                    a4.sendError(-7, "Invalid token");
                }
            } else {
                x.e eVar = this.f16807c;
                T data = trustLoginResponseModel.getData();
                if (data == null) {
                    data = "";
                }
                eVar.element = data;
                this.f16805a.a((String) this.f16807c.element, (String) this.f16808d.element);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r9 = r9.getNetworkResponse();
         */
        /* JADX WARNING: Removed duplicated region for block: B:70:0x00f8  */
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
                net.one97.paytm.h5.a.c r9 = r8.f16805a
                com.alipay.mobile.h5container.api.H5BridgeContext r9 = r9.f16802e
                if (r9 == 0) goto L_0x00fb
                r9.sendError((int) r1, (java.lang.String) r5)
            L_0x00fb:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.h5.a.c.b.a(com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void");
        }
    }

    /* renamed from: net.one97.paytm.h5.a.c$c  reason: collision with other inner class name */
    public static final class C0255c implements a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f16810a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f16811b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ x.e f16812c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ x.e f16813d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ H5Event f16814e;

        C0255c(c cVar, String str, x.e eVar, x.e eVar2, H5Event h5Event) {
            this.f16810a = cVar;
            this.f16811b = str;
            this.f16812c = eVar;
            this.f16813d = eVar2;
            this.f16814e = h5Event;
        }

        public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
            T t;
            if (iJRPaytmDataModel == null || !(iJRPaytmDataModel instanceof OpenIdResponseModel)) {
                H5BridgeContext a2 = this.f16810a.f16802e;
                if (a2 != null) {
                    a2.sendError(-14, "Failed to fetch OpenID");
                    return;
                }
                return;
            }
            x.e eVar = this.f16813d;
            ResponseModel response = ((OpenIdResponseModel) iJRPaytmDataModel).getResponse();
            if (response == null || (t = response.getOpenId()) == null) {
                t = "";
            }
            eVar.element = t;
            this.f16810a.a((String) this.f16812c.element, (String) this.f16813d.element);
        }

        public final void a(IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            c.a(this.f16810a, networkCustomError, this.f16814e);
        }
    }

    /* access modifiers changed from: private */
    public final synchronized void a(String str, String str2) {
        if (!(str == null || str2 == null)) {
            a("authId", (Object) str);
            a("openId", (Object) str2);
            a((Object) null);
        }
    }

    private static void a(Context context, String str, a aVar) {
        HashMap hashMap = new HashMap();
        Map map = hashMap;
        String q = com.paytm.utility.a.q(context);
        kotlin.g.b.k.a((Object) q, "ApplaunchUtility.getSSOToken(context)");
        map.put(AppConstants.SSO_TOKEN, q);
        map.put("client_id", str);
        map.put("Content-Type", "application/json");
        kotlin.g.b.k.a((Object) net.one97.paytm.j.c.a(), "GTMLoader.getInstance()");
        String aj = net.one97.paytm.j.c.aj();
        kotlin.g.b.k.a((Object) aj, "GTMLoader.getInstance().h5OpenIdUrl");
        a(context, aj, a.C0715a.GET, hashMap, (HashMap<String, String>) null, new OpenIdResponseModel(), aVar, (String) null);
    }

    public static final class f implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f16823a;

        f(a aVar) {
            this.f16823a = aVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f16823a.a(iJRPaytmDataModel, networkCustomError);
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            this.f16823a.a(iJRPaytmDataModel);
        }
    }

    /* access modifiers changed from: private */
    public static void a(Context context, String str, a.C0715a aVar, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, IJRPaytmDataModel iJRPaytmDataModel, a aVar2, String str2) {
        com.paytm.network.a a2 = net.one97.paytm.common.b.d.a(context, str, new f(aVar2), hashMap, hashMap2, aVar, str2, iJRPaytmDataModel, a.c.HOME, a.b.SILENT);
        a2.b(true);
        a2.a();
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.paytm.utility.h f16830a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f16831b;

        i(com.paytm.utility.h hVar, Activity activity) {
            this.f16830a = hVar;
            this.f16831b = activity;
        }

        public final void onClick(View view) {
            this.f16830a.cancel();
            h.a aVar = net.one97.paytm.deeplink.h.f50349a;
            h.a.a(this.f16831b, "paytmmp://login?screen=signOutLogin", (Bundle) null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.h5.a.c r5, com.paytm.network.model.NetworkCustomError r6, com.alipay.mobile.h5container.api.H5Event r7) {
        /*
            java.lang.String r0 = "code"
            r1 = 0
            java.lang.String r2 = "Unable to process your request"
            if (r6 == 0) goto L_0x00ba
            com.paytm.network.model.NetworkResponse r6 = r6.networkResponse
            if (r6 == 0) goto L_0x00ba
            byte[] r6 = r6.data
            if (r6 == 0) goto L_0x00ba
            java.lang.String r3 = new java.lang.String     // Catch:{ JSONException -> 0x00b0 }
            java.nio.charset.Charset r4 = kotlin.m.d.f47971a     // Catch:{ JSONException -> 0x00b0 }
            r3.<init>(r6, r4)     // Catch:{ JSONException -> 0x00b0 }
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00b0 }
            r6.<init>(r3)     // Catch:{ JSONException -> 0x00b0 }
            java.lang.String r3 = "message"
            java.lang.String r3 = r6.optString(r3)     // Catch:{ JSONException -> 0x00b0 }
            java.lang.String r4 = "jsonObject.optString(\"message\")"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)     // Catch:{ JSONException -> 0x00b0 }
            boolean r2 = r6.has(r0)     // Catch:{ JSONException -> 0x00ae }
            if (r2 == 0) goto L_0x00b9
            java.lang.Object r6 = r6.get(r0)     // Catch:{ JSONException -> 0x00ae }
            java.lang.String r0 = "ER_4500"
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.Object) r0)     // Catch:{ JSONException -> 0x00ae }
            if (r0 == 0) goto L_0x003c
            r1 = -12
            goto L_0x00bb
        L_0x003c:
            java.lang.String r0 = "ER_4501"
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.Object) r0)     // Catch:{ JSONException -> 0x00ae }
            if (r0 == 0) goto L_0x0082
            if (r7 == 0) goto L_0x007f
            android.app.Activity r6 = r7.getActivity()     // Catch:{ JSONException -> 0x00ae }
            if (r6 == 0) goto L_0x007f
            java.lang.String r7 = "activity"
            kotlin.g.b.k.c(r6, r7)     // Catch:{ JSONException -> 0x00ae }
            net.one97.paytm.auth.b.b.b((android.app.Activity) r6)     // Catch:{ JSONException -> 0x00ae }
            com.paytm.utility.h r7 = new com.paytm.utility.h     // Catch:{ JSONException -> 0x00ae }
            r0 = r6
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ JSONException -> 0x00ae }
            r7.<init>(r0)     // Catch:{ JSONException -> 0x00ae }
            java.lang.String r0 = "Session Time Out"
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ JSONException -> 0x00ae }
            r7.setTitle(r0)     // Catch:{ JSONException -> 0x00ae }
            java.lang.String r0 = "You've been logged out of Paytm. Don't worry, just login again to continue"
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ JSONException -> 0x00ae }
            r7.a(r0)     // Catch:{ JSONException -> 0x00ae }
            r7.setCancelable(r1)     // Catch:{ JSONException -> 0x00ae }
            r0 = -3
            java.lang.String r2 = "OK"
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ JSONException -> 0x00ae }
            net.one97.paytm.h5.a.c$i r4 = new net.one97.paytm.h5.a.c$i     // Catch:{ JSONException -> 0x00ae }
            r4.<init>(r7, r6)     // Catch:{ JSONException -> 0x00ae }
            android.view.View$OnClickListener r4 = (android.view.View.OnClickListener) r4     // Catch:{ JSONException -> 0x00ae }
            r7.a(r0, r2, r4)     // Catch:{ JSONException -> 0x00ae }
            r7.show()     // Catch:{ JSONException -> 0x00ae }
        L_0x007f:
            r1 = -13
            goto L_0x00bb
        L_0x0082:
            java.lang.String r7 = "ER_4003"
            boolean r7 = kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.Object) r7)     // Catch:{ JSONException -> 0x00ae }
            if (r7 == 0) goto L_0x008d
            r1 = -15
            goto L_0x00bb
        L_0x008d:
            java.lang.String r7 = "ER_4002"
            boolean r7 = kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.Object) r7)     // Catch:{ JSONException -> 0x00ae }
            if (r7 == 0) goto L_0x0098
            r1 = -16
            goto L_0x00bb
        L_0x0098:
            java.lang.String r7 = "ER_5009"
            boolean r7 = kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.Object) r7)     // Catch:{ JSONException -> 0x00ae }
            if (r7 == 0) goto L_0x00a3
            r1 = -17
            goto L_0x00bb
        L_0x00a3:
            java.lang.String r7 = "ER_5005"
            boolean r6 = kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.Object) r7)     // Catch:{ JSONException -> 0x00ae }
            if (r6 == 0) goto L_0x00bb
            r1 = -18
            goto L_0x00bb
        L_0x00ae:
            r6 = move-exception
            goto L_0x00b2
        L_0x00b0:
            r6 = move-exception
            r3 = r2
        L_0x00b2:
            java.lang.String r6 = r6.getMessage()
            com.paytm.utility.q.b(r6)
        L_0x00b9:
            r2 = r3
        L_0x00ba:
            r3 = r2
        L_0x00bb:
            com.alipay.mobile.h5container.api.H5BridgeContext r5 = r5.f16802e
            if (r5 == 0) goto L_0x00c2
            r5.sendError((int) r1, (java.lang.String) r3)
        L_0x00c2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.h5.a.c.a(net.one97.paytm.h5.a.c, com.paytm.network.model.NetworkCustomError, com.alipay.mobile.h5container.api.H5Event):void");
    }

    public static final /* synthetic */ void a(c cVar, H5Event h5Event) {
        HashMap hashMap = new HashMap();
        Map map = hashMap;
        String q = com.paytm.utility.a.q(h5Event.getActivity());
        kotlin.g.b.k.a((Object) q, "ApplaunchUtility.getSSOToken(event.activity)");
        map.put(AppConstants.SSO_TOKEN, q);
        String str = cVar.f16803f;
        if (str == null) {
            kotlin.g.b.k.a();
        }
        map.put("client_id", str);
        String jSONObject = new JSONObject().put("consent", cVar.f16804g).toString();
        kotlin.g.b.k.a((Object) jSONObject, "JSONObject().put(\"consen…AccessGranted).toString()");
        Activity activity = h5Event.getActivity();
        kotlin.g.b.k.a((Object) activity, "event.activity");
        kotlin.g.b.k.a((Object) net.one97.paytm.j.c.a(), "GTMLoader.getInstance()");
        String ai = net.one97.paytm.j.c.ai();
        kotlin.g.b.k.a((Object) ai, "GTMLoader.getInstance().h5SaveConsentUrl");
        a(activity, ai, a.C0715a.POST, hashMap, (HashMap<String, String>) null, new CJRsaveConsentModel(), new h(cVar, h5Event), jSONObject);
    }

    public static final /* synthetic */ void b(c cVar, H5Event h5Event) {
        String str;
        PackageInfo packageInfo;
        c cVar2 = cVar;
        String action = h5Event.getAction();
        if (action != null) {
            int hashCode = action.hashCode();
            if (hashCode != -689105682) {
                if (hashCode == 1427433598 && action.equals("paytmFetchOpenId")) {
                    cVar.d(h5Event);
                }
            } else if (action.equals("paytmFetchAuthCode")) {
                x.e eVar = new x.e();
                eVar.element = null;
                x.e eVar2 = new x.e();
                eVar2.element = null;
                String string = h5Event.getParam().getString("clientId");
                if (TextUtils.isEmpty(string)) {
                    cVar2.a(H5Event.Error.INVALID_PARAM, "clientID not passed");
                    return;
                }
                Activity activity = h5Event.getActivity();
                Context context = activity;
                if (!com.paytm.utility.a.m(context)) {
                    cVar2.a(H5Event.Error.FORBIDDEN, "Message empty!");
                    return;
                }
                kotlin.g.b.k.a((Object) net.one97.paytm.j.c.a(), "GTMLoader.getInstance()");
                CharSequence ag = net.one97.paytm.j.c.ag();
                if (ag == null || ag.length() == 0) {
                    cVar2.a(H5Event.Error.UNKNOWN_ERROR, "trust login url empty");
                    return;
                }
                HashMap hashMap = new HashMap();
                Map map = hashMap;
                map.put("Authorization", "Basic bWFya2V0LWFwcDo5YTA3MTc2Mi1hNDk5LTRiZDktOTE0YS00MzYxZTdjM2Y0YmM=");
                String q = com.paytm.utility.a.q(context);
                kotlin.g.b.k.a((Object) q, "ApplaunchUtility.getSSOToken(activity)");
                map.put("sessionToken", q);
                kotlin.g.b.k.a((Object) string, "clientId");
                map.put("reqClientId", string);
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
                kotlin.g.b.k.a((Object) activity, "activity");
                PackageManager packageManager = activity.getPackageManager();
                if (packageManager == null || (packageInfo = packageManager.getPackageInfo(activity.getPackageName(), 0)) == null || (str = packageInfo.versionName) == null) {
                    str = "";
                }
                map2.put("version", str);
                String str2 = Build.VERSION.RELEASE;
                kotlin.g.b.k.a((Object) str2, "VERSION.RELEASE");
                map2.put("osVersion", str2);
                String k = com.paytm.utility.a.k(context);
                if (k == null) {
                    k = "";
                }
                map2.put("language", k);
                String str3 = Build.MODEL;
                kotlin.g.b.k.a((Object) str3, "Build.MODEL");
                String encode = URLEncoder.encode(p.a(str3, " ", "_", false), com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8);
                if (encode == null) {
                    encode = "";
                }
                map2.put("deviceName", encode);
                String g2 = com.paytm.utility.a.g(context);
                if (g2 == null) {
                    g2 = "";
                }
                map2.put("lat", g2);
                String h2 = com.paytm.utility.a.h(context);
                if (h2 == null) {
                    h2 = "";
                }
                map2.put("long", h2);
                map2.put(com.business.merchant_payments.common.utility.AppConstants.TAG_CHILD_SITE_ID, "1");
                map2.put(com.business.merchant_payments.common.utility.AppConstants.TAG_SITE_ID, "1");
                kotlin.g.b.k.a((Object) net.one97.paytm.j.c.a(), "GTMLoader.getInstance()");
                String ag2 = net.one97.paytm.j.c.ag();
                kotlin.g.b.k.a((Object) ag2, "GTMLoader.getInstance().h5TrustLoginUrl");
                c cVar3 = cVar;
                String str4 = string;
                x.e eVar3 = eVar;
                x.e eVar4 = eVar2;
                a(context, ag2, a.C0715a.POST, hashMap, hashMap2, new TrustLoginResponseModel(), new b(cVar3, str4, eVar3, eVar4, h5Event), (String) null);
                a(context, string, (a) new C0255c(cVar3, str4, eVar3, eVar4, h5Event));
            }
        }
    }
}
