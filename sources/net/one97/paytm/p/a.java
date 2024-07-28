package net.one97.paytm.p;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.paymentsettings.common.data.PaymentSettingsCallBacks;
import com.paytm.paymentsettings.common.data.PaymentSettingsHelper;
import com.paytm.paymentsettings.merchantSubscriptions.view.ActiveSubscriptionActivity;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.x;
import net.one97.paytm.utils.r;

public final class a {

    /* renamed from: b  reason: collision with root package name */
    public static final C0166a f12661b = new C0166a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f12662c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static PaymentSettingsCallBacks f12663d;

    /* renamed from: a  reason: collision with root package name */
    public Activity f12664a;

    private a() {
    }

    public /* synthetic */ a(byte b2) {
        this();
    }

    /* renamed from: net.one97.paytm.p.a$a  reason: collision with other inner class name */
    public static final class C0166a {
        private C0166a() {
        }

        public /* synthetic */ C0166a(byte b2) {
            this();
        }

        /* renamed from: net.one97.paytm.p.a$a$a  reason: collision with other inner class name */
        public static final class C0167a implements PaymentSettingsCallBacks {
            C0167a() {
            }

            public final void sendCustomGtmEventWithMap(String str, HashMap<String, String> hashMap, Context context) {
                k.c(str, "key");
                k.c(hashMap, Item.CTA_URL_TYPE_MAP);
                k.c(context, "context");
                net.one97.paytm.j.a.b(str, (Map<String, Object>) hashMap, context);
            }

            public final void showSessionTimeoutAlert(Activity activity) {
                k.c(activity, "activity");
                new NetworkCustomError();
                r.a(activity, (String) null, (Bundle) null, true, false);
            }
        }

        public static a a(Activity activity) {
            k.c(activity, "activity");
            if (a.f12662c == null) {
                synchronized (a.class) {
                    if (a.f12662c == null) {
                        C0166a aVar = a.f12661b;
                        k.c(activity, "activity");
                        if (a.f12662c == null) {
                            a.f12662c = new a((byte) 0);
                            a b2 = a.f12662c;
                            if (b2 != null) {
                                b2.f12664a = activity;
                            }
                            a.f12663d = new C0167a();
                            PaymentSettingsHelper.Companion.init(a.f12663d);
                        }
                    }
                    x xVar = x.f47997a;
                }
            }
            return a.f12662c;
        }
    }

    public final Intent a() {
        Activity activity = this.f12664a;
        if (activity == null) {
            k.a("mActivity");
        }
        return new Intent(activity, ActiveSubscriptionActivity.class);
    }
}
