package net.one97.paytm.upi.registration.presenter;

import android.text.TextUtils;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.registration.a.b;

public final class b implements b.a {

    /* renamed from: a  reason: collision with root package name */
    private net.one97.paytm.upi.registration.b.a.b f68611a;

    /* renamed from: b  reason: collision with root package name */
    private b.C1388b f68612b;

    /* renamed from: c  reason: collision with root package name */
    private AccountProviderBody.AccountProvider f68613c;

    /* renamed from: d  reason: collision with root package name */
    private int f68614d;

    /* renamed from: e  reason: collision with root package name */
    private final String f68615e = "MultiSimSelectionPresenter";

    public b(net.one97.paytm.upi.registration.b.a.b bVar, b.C1388b bVar2, AccountProviderBody.AccountProvider accountProvider, int i2) {
        this.f68611a = bVar;
        this.f68612b = bVar2;
        this.f68613c = accountProvider;
        this.f68614d = i2;
        this.f68612b.a(this);
    }

    public final void e() {
        AccountProviderBody.AccountProvider accountProvider = this.f68613c;
        this.f68612b.a(this.f68614d, (accountProvider == null || TextUtils.isEmpty(accountProvider.getAccountProvider())) ? "" : this.f68613c.getAccountProvider());
        this.f68612b.a();
    }

    public final void f() {
        this.f68611a.c("MultiSimSelectionPresenter");
    }

    private void c(int i2) {
        this.f68612b.a(i2, this.f68613c);
    }

    public final void a(int i2) {
        c(i2);
    }

    public final void b(int i2) {
        c(i2);
    }
}
