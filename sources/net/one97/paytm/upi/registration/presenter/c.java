package net.one97.paytm.upi.registration.presenter;

import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.registration.a.c;
import net.one97.paytm.upi.registration.b.a.b;

public final class c implements c.a {

    /* renamed from: a  reason: collision with root package name */
    private final b f68616a;

    /* renamed from: b  reason: collision with root package name */
    private final c.b f68617b;

    /* renamed from: c  reason: collision with root package name */
    private final String f68618c = "RegistrationErrorPresenter";

    /* renamed from: d  reason: collision with root package name */
    private AccountProviderBody.AccountProvider f68619d;

    /* renamed from: e  reason: collision with root package name */
    private int f68620e;

    /* renamed from: f  reason: collision with root package name */
    private int f68621f;

    /* renamed from: g  reason: collision with root package name */
    private String f68622g;

    /* renamed from: h  reason: collision with root package name */
    private String f68623h;

    public c(b bVar, c.b bVar2, AccountProviderBody.AccountProvider accountProvider, int i2, int i3, String str, String str2) {
        this.f68616a = bVar;
        this.f68617b = bVar2;
        this.f68619d = accountProvider;
        this.f68621f = i3;
        this.f68620e = i2;
        this.f68622g = str2;
        this.f68623h = str;
        this.f68617b.a(this);
    }

    public final void e() {
        this.f68617b.a(this.f68621f, this.f68623h);
    }

    public final void f() {
        this.f68616a.c("RegistrationErrorPresenter");
    }

    public final void a() {
        this.f68617b.a(this.f68619d, this.f68620e, this.f68621f, this.f68622g);
    }
}
