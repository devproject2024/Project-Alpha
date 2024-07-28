package net.one97.paytm.h5.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.nebula.provider.H5ProviderManager;
import com.alipay.mobile.nebulacore.Nebula;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import com.paytm.utility.h;
import com.paytm.utility.q;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.UUID;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.entity.prime.cart.PrimeRechargePayment;
import net.one97.paytm.deeplink.h;
import net.one97.paytm.h5paytmsdk.b.ad;
import net.one97.paytm.h5paytmsdk.c.k;
import net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity;
import net.one97.paytm.utils.t;
import org.json.JSONException;
import org.json.JSONObject;

public final class m extends ad {

    /* renamed from: a  reason: collision with root package name */
    private String f16893a;

    public m() {
        super("paytmPrePaymentNotificaion");
    }

    public final boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        super.handleEvent(h5Event, h5BridgeContext);
        if (!(h5Event == null || h5Event.getActivity() == null)) {
            this.f16893a = h5Event.getParam().getString("clientId");
            CharSequence charSequence = this.f16893a;
            boolean z = false;
            if (charSequence == null || charSequence.length() == 0) {
                a(0, "Unable to process your request");
                return false;
            } else if (h5Event.getActivity() != null) {
                CharSequence q = com.paytm.utility.a.q(h5Event.getActivity());
                if (q == null || q.length() == 0) {
                    z = true;
                }
                if (z) {
                    H5ProviderManager providerManager = Nebula.getProviderManager();
                    Activity activity = null;
                    k kVar = (k) (providerManager != null ? providerManager.getProvider(k.class.getName()) : null);
                    if (kVar == null) {
                        a(H5Event.Error.FORBIDDEN, "No implementation found for 'PaytmH5AuthProvider'");
                    } else {
                        Intent a2 = kVar.a(h5Event != null ? h5Event.getActivity() : null);
                        if (a2 != null) {
                            if (h5Event != null) {
                                activity = h5Event.getActivity();
                            }
                            Activity activity2 = activity;
                            if (activity2 != null && (activity2 instanceof PaytmH5Activity)) {
                                PaytmH5Activity paytmH5Activity = (PaytmH5Activity) activity2;
                                paytmH5Activity.f17107e.addObserver(new b(activity2, this, h5Event, h5BridgeContext, a2));
                                paytmH5Activity.a(a2, 567, "paytmLogin");
                            }
                        }
                    }
                } else {
                    d(h5Event);
                }
            }
        }
        return true;
    }

    private final void c(H5Event h5Event) {
        Activity activity = null;
        String b2 = t.b((Context) h5Event != null ? h5Event.getActivity() : null);
        kotlin.g.b.k.a((Object) b2, "CJRServerUtility.getSSOToken(event?.activity)");
        Map hashMap = new HashMap();
        hashMap.put("client_id", String.valueOf(this.f16893a));
        hashMap.put(AppConstants.SSO_TOKEN, b2);
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        String uuid = UUID.randomUUID().toString();
        kotlin.g.b.k.a((Object) uuid, "UUID.randomUUID().toString()");
        net.one97.paytm.j.c.a();
        String aq = net.one97.paytm.j.c.aq();
        kotlin.g.b.k.a((Object) aq, "GTMLoader.getInstance().…ePaymentNotificationUrl()");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("reg_id", uuid);
        jSONObject.put("timestamp", valueOf);
        if (h5Event != null) {
            activity = h5Event.getActivity();
        }
        com.paytm.network.a a2 = d.a(activity, aq, new a(this, h5Event), hashMap, (Map<String, String>) null, a.C0715a.POST, jSONObject.toString(), new PrimeRechargePayment(), a.c.HOME, a.b.SILENT);
        kotlin.g.b.k.a((Object) a2, "HomeHelper.createRequest…rkCall.UserFacing.SILENT)");
        a2.a();
    }

    public static final class a implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m f16894a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ H5Event f16895b;

        a(m mVar, H5Event h5Event) {
            this.f16894a = mVar;
            this.f16895b = h5Event;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "dataModel");
            if (((PrimeRechargePayment) iJRPaytmDataModel).getNetworkResponse().statusCode == 200) {
                this.f16894a.a("success", (Object) Boolean.TRUE);
                this.f16894a.a((Object) null);
                return;
            }
            this.f16894a.a(0, "Unable to process your request");
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            byte[] bArr;
            Activity activity;
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            kotlin.g.b.k.c(networkCustomError, "networkCustomError");
            NetworkResponse networkResponse = networkCustomError.networkResponse;
            if (networkResponse != null && (bArr = networkResponse.data) != null) {
                try {
                    JSONObject jSONObject = new JSONObject(new String(bArr, kotlin.m.d.f47971a));
                    kotlin.g.b.k.a((Object) jSONObject.optString("message"), "jsonObject.optString(\"message\")");
                    if (jSONObject.has("code")) {
                        Object obj = jSONObject.get("code");
                        if (kotlin.g.b.k.a(obj, (Object) "ER_4500")) {
                            this.f16894a.a(-12, "Invalid clientId");
                        } else if (kotlin.g.b.k.a(obj, (Object) "ER_4501")) {
                            H5Event h5Event = this.f16895b;
                            if (!(h5Event == null || (activity = h5Event.getActivity()) == null)) {
                                m.a(activity);
                            }
                            this.f16894a.a(-13, "Invalid Token");
                        } else if (kotlin.g.b.k.a(obj, (Object) "ER_4233")) {
                            this.f16894a.a(-14, "Pre Payment Notification not allowed for this client");
                        } else {
                            this.f16894a.a(0, "Unable to process your request");
                        }
                    }
                } catch (JSONException e2) {
                    q.b(e2.getMessage());
                }
            }
        }
    }

    static final class b implements Observer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f16896a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ m f16897b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ H5Event f16898c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ H5BridgeContext f16899d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Intent f16900e;

        b(Activity activity, m mVar, H5Event h5Event, H5BridgeContext h5BridgeContext, Intent intent) {
            this.f16896a = activity;
            this.f16897b = mVar;
            this.f16898c = h5Event;
            this.f16899d = h5BridgeContext;
            this.f16900e = intent;
        }

        public final void update(Observable observable, Object obj) {
            m mVar = this.f16897b;
            if (kotlin.g.b.k.a(obj, (Object) Boolean.FALSE)) {
                H5BridgeContext h5BridgeContext = this.f16899d;
                if (h5BridgeContext != null) {
                    h5BridgeContext.sendError(-2, "user login failed");
                }
            } else {
                mVar.d(this.f16898c);
            }
            ((PaytmH5Activity) this.f16896a).f17107e.deleteObservers();
        }
    }

    /* access modifiers changed from: private */
    public final void d(H5Event h5Event) {
        if (kotlin.g.b.k.a((Object) h5Event != null ? h5Event.getAction() : null, (Object) "paytmPrePaymentNotificaion") && this.f16893a != null) {
            c(h5Event);
        }
    }

    public static void a(Activity activity) {
        kotlin.g.b.k.c(activity, "activity");
        net.one97.paytm.auth.b.b.b(activity);
        h hVar = new h(activity);
        hVar.setTitle("Session Time Out");
        hVar.a("You've been logged out of Paytm. Don't worry, just login again to continue");
        hVar.setCancelable(false);
        hVar.a(-3, Payload.RESPONSE_OK, new c(hVar, activity));
        hVar.show();
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f16901a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f16902b;

        c(h hVar, Activity activity) {
            this.f16901a = hVar;
            this.f16902b = activity;
        }

        public final void onClick(View view) {
            this.f16901a.cancel();
            h.a aVar = net.one97.paytm.deeplink.h.f50349a;
            h.a.a(this.f16902b, "paytmmp://login?screen=signOutLogin", (Bundle) null);
        }
    }
}
