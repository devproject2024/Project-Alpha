package net.one97.paytm.acceptPayment.configs;

import android.app.Application;
import com.business.common_module.b.h;
import com.business.merchant_payments.PaymentsConfig;
import com.paytm.business.merchantprofile.ProfileConfig;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f52046a;

    /* renamed from: b  reason: collision with root package name */
    public Application f52047b;

    /* renamed from: c  reason: collision with root package name */
    public h f52048c;

    /* renamed from: d  reason: collision with root package name */
    public net.one97.paytm.acceptPayment.b.a f52049d;

    public a(AcceptPaymentsInitConfig acceptPaymentsInitConfig) {
        this.f52047b = acceptPaymentsInitConfig.getApplication();
        this.f52048c = acceptPaymentsInitConfig.getAppKeys();
        this.f52049d = acceptPaymentsInitConfig.getAcceptPaymentsListener();
    }

    public static a a() {
        return f52046a;
    }

    public final net.one97.paytm.acceptPayment.b.a b() {
        return this.f52049d;
    }

    public static void c() {
        net.one97.paytm.acceptPayment.d.a aVar = net.one97.paytm.acceptPayment.d.a.f52050a;
        net.one97.paytm.acceptPayment.d.a.M();
        PaymentsConfig.getInstance().onSignOut();
        ProfileConfig.getInstance().onSignOut();
    }
}
