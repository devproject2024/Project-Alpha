package net.one97.paytm.phoenix.d;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.appsflyer.internal.referrer.Payload;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.utility.d;
import com.paytm.utility.h;
import com.paytm.utility.q;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.deeplink.h;
import net.one97.paytm.deeplink.u;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.api.f;
import net.one97.paytm.phoenix.provider.PhoenixAuthProvider;
import net.one97.paytm.phoenix.ui.PhoenixActivity;
import org.json.JSONObject;

public final class g extends net.one97.paytm.phoenix.core.a {
    public g() {
        super("paytmAddMoney");
    }

    public final boolean a(H5Event h5Event, net.one97.paytm.phoenix.api.b bVar) {
        Activity activity;
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(bVar, "bridgeContext");
        super.a(h5Event, bVar);
        Activity activity2 = h5Event.getActivity();
        if (activity2 != null) {
            JSONObject params = h5Event.getParams();
            String string = params != null ? params.getString("amount") : null;
            CharSequence charSequence = string;
            boolean z = false;
            if (charSequence == null || charSequence.length() == 0) {
                a(h5Event, net.one97.paytm.phoenix.api.a.INVALID_PARAM, "Amount string not passed!");
                return false;
            }
            try {
                if (Integer.parseInt(string) <= 0) {
                    a(h5Event, net.one97.paytm.phoenix.api.a.INVALID_PARAM, "Amount cannot be <= 0!");
                    return false;
                }
                Activity activity3 = h5Event.getActivity();
                if (activity3 != null) {
                    CharSequence a2 = d.a(activity3);
                    if (a2 == null || a2.length() == 0) {
                        z = true;
                    }
                    if (z) {
                        f b2 = net.one97.paytm.phoenix.core.c.f59399a.b();
                        String name = PhoenixAuthProvider.class.getName();
                        k.a((Object) name, "PhoenixAuthProvider::class.java.name");
                        PhoenixAuthProvider phoenixAuthProvider = (PhoenixAuthProvider) b2.a(name);
                        if (phoenixAuthProvider == null) {
                            a(h5Event, net.one97.paytm.phoenix.api.a.FORBIDDEN, "No implementation found for 'PaytmH5AuthProvider'");
                        } else {
                            Intent login = phoenixAuthProvider.login(h5Event.getActivity(), (HashMap<String, Object>) null);
                            if (!(login == null || (activity = h5Event.getActivity()) == null || !(activity instanceof PhoenixActivity))) {
                                PhoenixActivity phoenixActivity = (PhoenixActivity) activity;
                                phoenixActivity.h().addObserver(new b(activity, this, h5Event, bVar, string, login));
                                phoenixActivity.a(login, 567, "paytmLogin");
                            }
                        }
                    } else {
                        try {
                            u.a(activity2, Double.parseDouble(string));
                        } catch (Exception e2) {
                            q.b(e2.getMessage());
                            a(h5Event, net.one97.paytm.phoenix.api.a.INVALID_PARAM, "Amount is not numeric");
                        }
                    }
                }
                if (activity2 instanceof PhoenixActivity) {
                    ((PhoenixActivity) activity2).j().addObserver(new a(activity2, this, h5Event, bVar));
                }
            } catch (Exception e3) {
                q.b(e3.getMessage());
                a(h5Event, net.one97.paytm.phoenix.api.a.INVALID_PARAM, "Amount passed is not numeric");
                return false;
            }
        }
        return true;
    }

    static final class a implements Observer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f19771a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ g f19772b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ H5Event f19773c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.phoenix.api.b f19774d;

        a(Activity activity, g gVar, H5Event h5Event, net.one97.paytm.phoenix.api.b bVar) {
            this.f19771a = activity;
            this.f19772b = gVar;
            this.f19773c = h5Event;
            this.f19774d = bVar;
        }

        public final void update(Observable observable, Object obj) {
            g gVar = this.f19772b;
            if (!(obj instanceof String)) {
                gVar.a("status", (Object) "cancelled");
                net.one97.paytm.phoenix.core.a.a(gVar, this.f19773c, (Object) null, false, 6);
            } else if (p.a((CharSequence) obj, (CharSequence) "session_timeout", false)) {
                Activity activity = this.f19773c.getActivity();
                if (activity != null) {
                    net.one97.paytm.auth.b.b.b(activity);
                    h hVar = new h(activity);
                    hVar.setTitle("Session Time Out");
                    hVar.a("You've been logged out of Paytm. Don't worry, just login again to continue");
                    hVar.setCancelable(false);
                    hVar.a(-3, Payload.RESPONSE_OK, new c(hVar, activity));
                    hVar.show();
                }
                this.f19774d.a(this.f19773c, -13, "Invalid Token");
            } else {
                gVar.a("status", obj);
                net.one97.paytm.phoenix.core.a.a(gVar, this.f19773c, (Object) null, false, 6);
            }
            ((PhoenixActivity) this.f19771a).j().deleteObservers();
        }
    }

    static final class b implements Observer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f19775a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ g f19776b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ H5Event f19777c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.phoenix.api.b f19778d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f19779e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Intent f19780f;

        b(Activity activity, g gVar, H5Event h5Event, net.one97.paytm.phoenix.api.b bVar, String str, Intent intent) {
            this.f19775a = activity;
            this.f19776b = gVar;
            this.f19777c = h5Event;
            this.f19778d = bVar;
            this.f19779e = str;
            this.f19780f = intent;
        }

        public final void update(Observable observable, Object obj) {
            g gVar = this.f19776b;
            if (k.a(obj, (Object) Boolean.FALSE)) {
                net.one97.paytm.phoenix.api.b bVar = this.f19778d;
                if (bVar != null) {
                    bVar.a(this.f19777c, -2, "user login failed");
                }
            } else {
                try {
                    u.a(this.f19775a, Double.parseDouble(this.f19779e));
                } catch (Exception e2) {
                    q.b(e2.getMessage());
                    gVar.a(this.f19777c, net.one97.paytm.phoenix.api.a.INVALID_PARAM, "Amount is not numeric");
                }
            }
            ((PhoenixActivity) this.f19775a).h().deleteObservers();
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f19781a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f19782b;

        c(h hVar, Activity activity) {
            this.f19781a = hVar;
            this.f19782b = activity;
        }

        public final void onClick(View view) {
            this.f19781a.cancel();
            h.a aVar = net.one97.paytm.deeplink.h.f50349a;
            h.a.a(this.f19782b, "paytmmp://login?screen=signOutLogin", (Bundle) null);
        }
    }
}
