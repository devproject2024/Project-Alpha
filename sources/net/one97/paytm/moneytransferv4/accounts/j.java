package net.one97.paytm.moneytransferv4.accounts;

import dagger.a.c;
import javax.a.a;

public final class j implements c<i> {

    /* renamed from: a  reason: collision with root package name */
    private final a<net.one97.paytm.upi.profile.b.a> f54985a;

    /* renamed from: b  reason: collision with root package name */
    private final a<net.one97.paytm.upi.registration.b.a.a> f54986b;

    public j(a<net.one97.paytm.upi.profile.b.a> aVar, a<net.one97.paytm.upi.registration.b.a.a> aVar2) {
        this.f54985a = aVar;
        this.f54986b = aVar2;
    }

    public final /* synthetic */ Object get() {
        return new i(this.f54985a.get(), this.f54986b.get());
    }
}
