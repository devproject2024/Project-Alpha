package net.one97.paytm.upgradeKyc.editprofile.e;

import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.common.entity.upgradeKyc.CkycResponse;
import net.one97.paytm.upgradeKyc.editprofile.b.a;

public final class a implements a.d {

    /* renamed from: a  reason: collision with root package name */
    public a.C1307a f65826a;

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.upgradeKyc.editprofile.d.a f65827b;

    public a(a.C1307a aVar, net.one97.paytm.upgradeKyc.editprofile.d.a aVar2) {
        k.c(aVar, "view");
        k.c(aVar2, "model");
        this.f65826a = aVar;
        this.f65827b = aVar2;
    }

    public final void a(IJRDataModel iJRDataModel) {
        k.c(iJRDataModel, Payload.RESPONSE);
        this.f65826a.b();
        if (!(iJRDataModel instanceof CkycResponse)) {
            return;
        }
        if (p.a(((CkycResponse) iJRDataModel).getCode(), WebLogin.RESPONSE_CODE_SUCCESS, false)) {
            this.f65826a.d();
        } else {
            this.f65826a.c();
        }
    }

    public final void a(NetworkCustomError networkCustomError) {
        k.c(networkCustomError, "error");
        this.f65826a.c();
    }

    public final void a() {
        this.f65826a.b();
        this.f65826a.c();
    }
}
