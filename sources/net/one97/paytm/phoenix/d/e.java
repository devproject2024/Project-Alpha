package net.one97.paytm.phoenix.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.appsflyer.internal.referrer.Payload;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import com.paytm.utility.d;
import com.paytm.utility.h;
import com.paytm.utility.q;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.UUID;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.prime.cart.PrimeRechargePayment;
import net.one97.paytm.deeplink.h;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.api.f;
import net.one97.paytm.phoenix.provider.PhoenixAuthProvider;
import net.one97.paytm.phoenix.ui.PhoenixActivity;
import net.one97.paytm.utils.t;
import org.json.JSONException;
import org.json.JSONObject;

public final class e extends net.one97.paytm.phoenix.core.a {

    /* renamed from: a  reason: collision with root package name */
    net.one97.paytm.phoenix.api.b f19760a;

    /* renamed from: b  reason: collision with root package name */
    private String f19761b;

    public e() {
        super("paytmPrePaymentNotificaion");
    }

    public final boolean a(H5Event h5Event, net.one97.paytm.phoenix.api.b bVar) {
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(bVar, "bridgeContext");
        super.a(h5Event, bVar);
        this.f19760a = bVar;
        if (h5Event.getActivity() != null) {
            JSONObject params = h5Event.getParams();
            Activity activity = null;
            this.f19761b = params != null ? params.getString("clientId") : null;
            CharSequence charSequence = this.f19761b;
            boolean z = false;
            if (charSequence == null || charSequence.length() == 0) {
                net.one97.paytm.phoenix.api.b bVar2 = this.f19760a;
                if (bVar2 != null) {
                    bVar2.a(h5Event, 0, "Unable to process your request");
                }
                return false;
            } else if (h5Event.getActivity() != null) {
                CharSequence a2 = d.a(h5Event.getActivity());
                if (a2 == null || a2.length() == 0) {
                    z = true;
                }
                if (z) {
                    f b2 = net.one97.paytm.phoenix.core.c.f59399a.b();
                    String name = PhoenixAuthProvider.class.getName();
                    k.a((Object) name, "PhoenixAuthProvider::class.java.name");
                    PhoenixAuthProvider phoenixAuthProvider = (PhoenixAuthProvider) b2.a(name);
                    if (phoenixAuthProvider == null) {
                        if (h5Event == null) {
                            k.a();
                        }
                        a(h5Event, net.one97.paytm.phoenix.api.a.FORBIDDEN, "No implementation found for 'PaytmH5AuthProvider'");
                    } else {
                        Intent login = phoenixAuthProvider.login(h5Event != null ? h5Event.getActivity() : null, (HashMap<String, Object>) null);
                        if (login != null) {
                            if (h5Event != null) {
                                activity = h5Event.getActivity();
                            }
                            if (activity != null && (activity instanceof PhoenixActivity)) {
                                ((PhoenixActivity) activity).h().addObserver(new b(activity, this, h5Event, bVar, login));
                                activity.startActivityForResult(login, 567);
                            }
                        }
                    }
                } else {
                    b(h5Event);
                }
            }
        }
        return true;
    }

    private final void c(H5Event h5Event) {
        Activity activity = null;
        String b2 = t.b((Context) h5Event != null ? h5Event.getActivity() : null);
        k.a((Object) b2, "CJRServerUtility.getSSOToken(event?.getActivity())");
        Map hashMap = new HashMap();
        hashMap.put("client_id", String.valueOf(this.f19761b));
        hashMap.put(com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN, b2);
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        String uuid = UUID.randomUUID().toString();
        k.a((Object) uuid, "UUID.randomUUID().toString()");
        net.one97.paytm.j.c.a();
        String aq = net.one97.paytm.j.c.aq();
        k.a((Object) aq, "GTMLoader.getInstance().…ePaymentNotificationUrl()");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("reg_id", uuid);
        jSONObject.put("timestamp", valueOf);
        if (h5Event != null) {
            activity = h5Event.getActivity();
        }
        com.paytm.network.a a2 = net.one97.paytm.common.b.d.a(activity, aq, new a(this, h5Event), hashMap, (Map<String, String>) null, a.C0715a.POST, jSONObject.toString(), new PrimeRechargePayment(), a.c.HOME, a.b.SILENT);
        k.a((Object) a2, "HomeHelper.createRequest…rkCall.UserFacing.SILENT)");
        a2.a();
    }

    public static final class a implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f19762a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ H5Event f19763b;

        a(e eVar, H5Event h5Event) {
            this.f19762a = eVar;
            this.f19763b = h5Event;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "dataModel");
            if (((PrimeRechargePayment) iJRPaytmDataModel).getNetworkResponse().statusCode == 200) {
                this.f19762a.a("success", (Object) Boolean.TRUE);
                net.one97.paytm.phoenix.core.a.a(this.f19762a, this.f19763b, (Object) null, false, 6);
                return;
            }
            net.one97.paytm.phoenix.api.b bVar = this.f19762a.f19760a;
            if (bVar != null) {
                bVar.a(this.f19763b, 0, "Unable to process your request");
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            byte[] bArr;
            Activity activity;
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            k.c(networkCustomError, "networkCustomError");
            NetworkResponse networkResponse = networkCustomError.networkResponse;
            if (networkResponse != null && (bArr = networkResponse.data) != null) {
                try {
                    JSONObject jSONObject = new JSONObject(new String(bArr, kotlin.m.d.f47971a));
                    k.a((Object) jSONObject.optString("message"), "jsonObject.optString(\"message\")");
                    if (jSONObject.has("code")) {
                        Object obj = jSONObject.get("code");
                        if (k.a(obj, (Object) "ER_4500")) {
                            net.one97.paytm.phoenix.api.b bVar = this.f19762a.f19760a;
                            if (bVar != null) {
                                bVar.a(this.f19763b, -12, "Invalid clientId");
                            }
                        } else if (k.a(obj, (Object) "ER_4501")) {
                            H5Event h5Event = this.f19763b;
                            if (!(h5Event == null || (activity = h5Event.getActivity()) == null)) {
                                k.c(activity, "activity");
                                net.one97.paytm.auth.b.b.b(activity);
                                h hVar = new h(activity);
                                hVar.setTitle("Session Time Out");
                                hVar.a("You've been logged out of Paytm. Don't worry, just login again to continue");
                                hVar.setCancelable(false);
                                hVar.a(-3, Payload.RESPONSE_OK, new c(hVar, activity));
                                hVar.show();
                            }
                            net.one97.paytm.phoenix.api.b bVar2 = this.f19762a.f19760a;
                            if (bVar2 != null) {
                                bVar2.a(this.f19763b, -13, "Invalid Token");
                            }
                        } else if (k.a(obj, (Object) "ER_4233")) {
                            net.one97.paytm.phoenix.api.b bVar3 = this.f19762a.f19760a;
                            if (bVar3 != null) {
                                bVar3.a(this.f19763b, -14, "Pre Payment Notification not allowed for this client");
                            }
                        } else {
                            net.one97.paytm.phoenix.api.b bVar4 = this.f19762a.f19760a;
                            if (bVar4 != null) {
                                bVar4.a(this.f19763b, 0, "Unable to process your request");
                            }
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
        final /* synthetic */ Activity f19764a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ e f19765b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ H5Event f19766c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.phoenix.api.b f19767d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Intent f19768e;

        b(Activity activity, e eVar, H5Event h5Event, net.one97.paytm.phoenix.api.b bVar, Intent intent) {
            this.f19764a = activity;
            this.f19765b = eVar;
            this.f19766c = h5Event;
            this.f19767d = bVar;
            this.f19768e = intent;
        }

        public final void update(Observable observable, Object obj) {
            e eVar = this.f19765b;
            if (k.a(obj, (Object) Boolean.FALSE)) {
                net.one97.paytm.phoenix.api.b bVar = this.f19767d;
                if (bVar != null) {
                    bVar.a(this.f19766c, -2, "user login failed");
                }
            } else {
                eVar.b(this.f19766c);
            }
            ((PhoenixActivity) this.f19764a).h().deleteObservers();
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(H5Event h5Event) {
        if (k.a((Object) h5Event != null ? h5Event.getBridgeName() : null, (Object) "paytmPrePaymentNotificaion") && this.f19761b != null) {
            c(h5Event);
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f19769a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f19770b;

        c(h hVar, Activity activity) {
            this.f19769a = hVar;
            this.f19770b = activity;
        }

        public final void onClick(View view) {
            this.f19769a.cancel();
            h.a aVar = net.one97.paytm.deeplink.h.f50349a;
            h.a.a(this.f19770b, "paytmmp://login?screen=signOutLogin", (Bundle) null);
        }
    }
}
