package net.one97.paytm.upi.profile.presenter;

import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.profile.a.e;
import net.one97.paytm.upi.profile.b.b;

public final class e implements e.a {

    /* renamed from: a  reason: collision with root package name */
    private b f68055a;

    /* renamed from: b  reason: collision with root package name */
    private e.b f68056b;

    /* renamed from: c  reason: collision with root package name */
    private UserUpiDetails f68057c;

    /* renamed from: d  reason: collision with root package name */
    private final String f68058d = "UpiPostRegistrationPresenter";

    public e(b bVar, e.b bVar2, UserUpiDetails userUpiDetails) {
        this.f68055a = bVar;
        this.f68056b = bVar2;
        this.f68057c = userUpiDetails;
        this.f68056b.a(this);
    }

    public final void e() {
        this.f68056b.a(this.f68057c);
    }

    public final void f() {
        this.f68056b = null;
        this.f68055a.a("UpiPostRegistrationPresenter");
    }

    public final void a() {
        this.f68056b.b(this.f68057c);
    }

    public final void a(AccountProviderBody.AccountProvider accountProvider) {
        this.f68056b.a(accountProvider, this.f68057c.getVpa());
    }
}
