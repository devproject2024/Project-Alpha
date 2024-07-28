package net.one97.paytm.payments.c.a;

import android.os.Build;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.business.merchant_payments.common.utility.AppConstants;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.biometricAuthWall.b;
import net.one97.paytm.paymentsBank.biometricAuthWall.c;
import net.one97.paytm.paymentsBank.biometricAuthWall.e;
import net.one97.paytm.paymentsBank.biometricAuthWall.f;
import net.one97.paytm.paymentsBank.utils.g;
import net.one97.paytm.paymentsBank.utils.j;
import net.one97.paytm.paymentsBank.utils.o;
import net.one97.paytm.phoenix.api.H5Event;
import org.json.JSONObject;

public final class e extends net.one97.paytm.phoenix.core.a implements e.a {

    /* renamed from: a  reason: collision with root package name */
    FragmentActivity f17211a;

    /* renamed from: b  reason: collision with root package name */
    private H5Event f17212b;

    /* renamed from: c  reason: collision with root package name */
    private net.one97.paytm.phoenix.api.b f17213c;

    public final void a() {
    }

    public final void a(String str) {
        k.c(str, "xCode");
    }

    static final class a<T> implements z<g<? extends c>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f17214a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FragmentActivity f17215b;

        a(e eVar, FragmentActivity fragmentActivity) {
            this.f17214a = eVar;
            this.f17215b = fragmentActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            g gVar = (g) obj;
            k.c(gVar, "it");
            c cVar = (c) gVar.a();
            if (this.f17215b != null && cVar != null && k.a((Object) "Proceed FingerPrint", (Object) cVar.f17450b) && cVar.f17449a != null) {
                FragmentActivity fragmentActivity = this.f17215b;
                e.b bVar = net.one97.paytm.paymentsBank.biometricAuthWall.e.f17453d;
                String string = fragmentActivity.getString(R.string.pb_finger_print_signup_header);
                k.a((Object) string, "getString(R.string.pb_finger_print_signup_header)");
                String string2 = fragmentActivity.getString(R.string.pb_finger_print_signup_desc);
                k.a((Object) string2, "getString(R.string.pb_finger_print_signup_desc)");
                String string3 = fragmentActivity.getString(R.string.pb_cancel);
                k.a((Object) string3, "getString(R.string.pb_cancel)");
                net.one97.paytm.paymentsBank.biometricAuthWall.e eVar = new net.one97.paytm.paymentsBank.biometricAuthWall.e(this.f17214a, e.b.a(string, "", string2, string3));
                FragmentActivity fragmentActivity2 = this.f17215b;
                String str = cVar.f17449a;
                if (str == null) {
                    k.a();
                }
                eVar.a(fragmentActivity2, str);
            } else if (cVar != null && k.a((Object) cVar.f17450b, (Object) "Will do it later")) {
                net.one97.paytm.paymentsBank.h.a a2 = o.a();
                k.a((Object) a2, "PaymentsBankHelper.getImplListener()");
                net.one97.paytm.bankCommon.h.b.k(a2.getApplicationContext(), "willdoitlater");
                this.f17214a.d("willdoitlater");
            }
        }
    }

    public e() {
        super("bankOpenBiometricPopup");
    }

    public final boolean a(H5Event h5Event, net.one97.paytm.phoenix.api.b bVar) {
        boolean z;
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(bVar, "bridgeContext");
        super.a(h5Event, bVar);
        b(h5Event, bVar);
        net.one97.paytm.payments.c.c.c cVar = net.one97.paytm.payments.c.c.c.f17266a;
        String a2 = net.one97.paytm.payments.c.c.c.a();
        net.one97.paytm.paymentsBank.h.a a3 = o.a();
        k.a((Object) a3, "PaymentsBankHelper.getImplListener()");
        if (!(!k.a((Object) net.one97.paytm.bankCommon.h.b.j(a3.getApplicationContext(), "notsetupedyet"), (Object) "notsetupedyet")) && j.c()) {
            z = false;
        } else {
            z = true;
        }
        if (z || a2 == null) {
            d("already invoked once");
            return true;
        }
        this.f17212b = h5Event;
        this.f17213c = bVar;
        this.f17211a = (FragmentActivity) h5Event.getActivity();
        if (Build.VERSION.SDK_INT >= 23) {
            FragmentActivity fragmentActivity = this.f17211a;
            if (fragmentActivity != null) {
                if (fragmentActivity != null) {
                    fragmentActivity.runOnUiThread(new b(this, fragmentActivity));
                }
                if (this.f17211a != null) {
                    b.a aVar = net.one97.paytm.paymentsBank.biometricAuthWall.b.f17445a;
                    net.one97.paytm.paymentsBank.biometricAuthWall.b a4 = b.a.a(a2);
                    FragmentActivity fragmentActivity2 = this.f17211a;
                    if (fragmentActivity2 instanceof FragmentActivity) {
                        if (fragmentActivity2 != null) {
                            a4.show(fragmentActivity2.getSupportFragmentManager(), net.one97.paytm.paymentsBank.biometricAuthWall.b.class.getName());
                        } else {
                            throw new u("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                        }
                    }
                }
            } else {
                throw new u("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            }
        }
        return true;
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f17216a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FragmentActivity f17217b;

        b(e eVar, FragmentActivity fragmentActivity) {
            this.f17216a = eVar;
            this.f17217b = fragmentActivity;
        }

        public final void run() {
            e eVar = this.f17216a;
            FragmentActivity fragmentActivity = this.f17217b;
            ai a2 = am.a(fragmentActivity).a(f.class);
            k.a((Object) a2, "ViewModelProviders.of(fr…del::class.java\n        )");
            y<g<c>> yVar = ((f) a2).f17467a;
            FragmentActivity fragmentActivity2 = eVar.f17211a;
            if (fragmentActivity2 != null) {
                yVar.observe(fragmentActivity2, new a(eVar, fragmentActivity));
                return;
            }
            throw new u("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        }
    }

    public final void a(int i2, String str, String str2) {
        k.c(str, "errString");
        k.c(str2, "flowType");
        b();
    }

    public final void b(String str) {
        k.c(str, "flowType");
        b();
    }

    public final void c(String str) {
        k.c(str, "flowType");
        net.one97.paytm.paymentsBank.h.a a2 = o.a();
        k.a((Object) a2, "PaymentsBankHelper.getImplListener()");
        net.one97.paytm.bankCommon.h.b.i(a2.getApplicationContext(), "willdoitlater");
        d((String) null);
    }

    public final void a(String str, String str2) {
        k.c(str, "ivString");
        k.c(str2, "encyptedData");
        net.one97.paytm.paymentsBank.h.a a2 = o.a();
        k.a((Object) a2, "PaymentsBankHelper.getImplListener()");
        net.one97.paytm.bankCommon.h.b.a(a2.getApplicationContext(), str, str2, "turnedon");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", "true");
        net.one97.paytm.phoenix.api.b bVar = this.f17213c;
        if (bVar != null) {
            H5Event h5Event = this.f17212b;
            if (h5Event == null) {
                k.a("ev");
            }
            bVar.a(h5Event, jSONObject);
        }
    }

    private static void b() {
        net.one97.paytm.paymentsBank.h.a a2 = o.a();
        k.a((Object) a2, "PaymentsBankHelper.getImplListener()");
        net.one97.paytm.bankCommon.h.b.k(a2.getApplicationContext(), "willdoitlater");
    }

    /* access modifiers changed from: package-private */
    public final void d(String str) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", "false");
        FragmentActivity fragmentActivity = this.f17211a;
        String string = fragmentActivity != null ? fragmentActivity.getString(R.string.error) : null;
        if (str == null) {
            FragmentActivity fragmentActivity2 = this.f17211a;
            str = fragmentActivity2 != null ? fragmentActivity2.getString(R.string.pb_something_wrong_try_again) : null;
        }
        jSONObject.put(string, str);
        net.one97.paytm.phoenix.api.b bVar = this.f17213c;
        if (bVar != null) {
            H5Event h5Event = this.f17212b;
            if (h5Event == null) {
                k.a("ev");
            }
            bVar.a(h5Event, jSONObject);
        }
    }
}
