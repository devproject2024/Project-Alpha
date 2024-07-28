package net.one97.paytm.h5.a;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.nebula.provider.H5ProviderManager;
import com.alipay.mobile.nebulacore.Nebula;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.utility.d;
import com.paytm.utility.h;
import com.paytm.utility.q;
import java.util.Observable;
import java.util.Observer;
import kotlin.m.p;
import net.one97.paytm.deeplink.h;
import net.one97.paytm.deeplink.u;
import net.one97.paytm.h5paytmsdk.b.ad;
import net.one97.paytm.h5paytmsdk.c.k;
import net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity;

public final class b extends ad {
    public b() {
        super("paytmAddMoney");
    }

    public final boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        Activity activity;
        super.handleEvent(h5Event, h5BridgeContext);
        if (!(h5Event == null || (activity = h5Event.getActivity()) == null)) {
            String string = h5Event.getParam().getString("amount");
            CharSequence charSequence = string;
            boolean z = false;
            if (charSequence == null || charSequence.length() == 0) {
                a(H5Event.Error.INVALID_PARAM, "Amount string not passed!");
                return false;
            }
            try {
                if (Integer.parseInt(string) <= 0) {
                    a(H5Event.Error.INVALID_PARAM, "Amount cannot be <= 0!");
                    return false;
                }
                if (h5Event.getActivity() != null) {
                    CharSequence a2 = d.a(h5Event.getActivity());
                    if (a2 == null || a2.length() == 0) {
                        z = true;
                    }
                    if (z) {
                        H5ProviderManager providerManager = Nebula.getProviderManager();
                        Activity activity2 = null;
                        k kVar = (k) (providerManager != null ? providerManager.getProvider(k.class.getName()) : null);
                        if (kVar == null) {
                            a(H5Event.Error.FORBIDDEN, "No implementation found for 'PaytmH5AuthProvider'");
                        } else {
                            Intent a3 = kVar.a(h5Event != null ? h5Event.getActivity() : null);
                            if (a3 != null) {
                                if (h5Event != null) {
                                    activity2 = h5Event.getActivity();
                                }
                                Activity activity3 = activity2;
                                if (activity3 != null && (activity3 instanceof PaytmH5Activity)) {
                                    PaytmH5Activity paytmH5Activity = (PaytmH5Activity) activity3;
                                    paytmH5Activity.f17107e.addObserver(new C0254b(activity3, this, h5Event, h5BridgeContext, string, a3));
                                    paytmH5Activity.a(a3, 567, "paytmLogin");
                                }
                            }
                        }
                    } else {
                        try {
                            u.a(activity, Double.parseDouble(string));
                        } catch (Exception e2) {
                            q.b(e2.getMessage());
                            a(H5Event.Error.INVALID_PARAM, "Amount is not numeric");
                        }
                    }
                }
                if (activity instanceof PaytmH5Activity) {
                    ((PaytmH5Activity) activity).f17111i.addObserver(new a(this, h5Event, h5BridgeContext));
                }
            } catch (Exception e3) {
                q.b(e3.getMessage());
                a(H5Event.Error.INVALID_PARAM, "Amount passed is not numeric");
                return false;
            }
        }
        return true;
    }

    static final class a implements Observer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f16789a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ H5Event f16790b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ H5BridgeContext f16791c;

        a(b bVar, H5Event h5Event, H5BridgeContext h5BridgeContext) {
            this.f16789a = bVar;
            this.f16790b = h5Event;
            this.f16791c = h5BridgeContext;
        }

        public final void update(Observable observable, Object obj) {
            Activity activity;
            b bVar = this.f16789a;
            if (!(obj instanceof String)) {
                bVar.a("status", (Object) "cancelled");
                bVar.a((Object) null);
            } else if (p.a((CharSequence) obj, (CharSequence) "session_timeout", false)) {
                H5Event h5Event = this.f16790b;
                if (!(h5Event == null || (activity = h5Event.getActivity()) == null)) {
                    b.a(activity);
                }
                bVar.a(-13, "Invalid Token");
            } else {
                bVar.a("status", obj);
                bVar.a((Object) null);
            }
        }
    }

    /* renamed from: net.one97.paytm.h5.a.b$b  reason: collision with other inner class name */
    static final class C0254b implements Observer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f16792a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f16793b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ H5Event f16794c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ H5BridgeContext f16795d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f16796e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Intent f16797f;

        C0254b(Activity activity, b bVar, H5Event h5Event, H5BridgeContext h5BridgeContext, String str, Intent intent) {
            this.f16792a = activity;
            this.f16793b = bVar;
            this.f16794c = h5Event;
            this.f16795d = h5BridgeContext;
            this.f16796e = str;
            this.f16797f = intent;
        }

        public final void update(Observable observable, Object obj) {
            b bVar = this.f16793b;
            if (kotlin.g.b.k.a(obj, (Object) Boolean.FALSE)) {
                H5BridgeContext h5BridgeContext = this.f16795d;
                if (h5BridgeContext != null) {
                    h5BridgeContext.sendError(-2, "user login failed");
                }
            } else {
                try {
                    u.a(this.f16792a, Double.parseDouble(this.f16796e));
                } catch (Exception e2) {
                    q.b(e2.getMessage());
                    bVar.a(H5Event.Error.INVALID_PARAM, "Amount is not numeric");
                }
            }
            ((PaytmH5Activity) this.f16792a).f17107e.deleteObservers();
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
        final /* synthetic */ h f16798a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f16799b;

        c(h hVar, Activity activity) {
            this.f16798a = hVar;
            this.f16799b = activity;
        }

        public final void onClick(View view) {
            this.f16798a.cancel();
            h.a aVar = net.one97.paytm.deeplink.h.f50349a;
            h.a.a(this.f16799b, "paytmmp://login?screen=signOutLogin", (Bundle) null);
        }
    }
}
