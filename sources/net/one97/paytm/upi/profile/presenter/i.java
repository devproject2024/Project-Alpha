package net.one97.paytm.upi.profile.presenter;

import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.profile.a.i;
import net.one97.paytm.upi.profile.b.b;

public final class i implements i.a {

    /* renamed from: a  reason: collision with root package name */
    private final b f68103a;

    /* renamed from: b  reason: collision with root package name */
    private i.b f68104b;

    /* renamed from: c  reason: collision with root package name */
    private UpiProfileDefaultBank f68105c;

    public i(b bVar, i.b bVar2, UpiProfileDefaultBank upiProfileDefaultBank) {
        this.f68103a = bVar;
        this.f68104b = bVar2;
        this.f68105c = upiProfileDefaultBank;
        this.f68104b.a(this);
    }

    public final void e() {
        String virtualAddress = this.f68105c.getVirtualAddress();
        i.b bVar = this.f68104b;
        this.f68105c.isPrimary();
        bVar.a(virtualAddress, this.f68105c.getCreditBank(), this.f68105c.getQrData());
    }

    public final UpiProfileDefaultBank a() {
        return this.f68105c;
    }

    public final void b() {
        UpiProfileDefaultBank upiProfileDefaultBank = this.f68105c;
        if (upiProfileDefaultBank == null || upiProfileDefaultBank.getCreditBank() == null) {
            this.f68104b.a();
        } else {
            this.f68104b.b();
        }
    }

    public final void f() {
        this.f68104b = null;
    }
}
