package net.one97.paytm.upgradeKyc.editprofile.e;

import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytm.utility.q;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.CJRAadharPanGet;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.upgradeKyc.editprofile.b.a;

public final class e implements a.d {

    /* renamed from: a  reason: collision with root package name */
    public a.f f65834a;

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.upgradeKyc.editprofile.d.a f65835b;

    public final void a() {
    }

    public final void a(NetworkCustomError networkCustomError) {
        k.c(networkCustomError, "error");
    }

    public e(a.f fVar, net.one97.paytm.upgradeKyc.editprofile.d.a aVar) {
        k.c(fVar, "view");
        k.c(aVar, "model");
        this.f65834a = fVar;
        this.f65835b = aVar;
    }

    public final void a(IJRDataModel iJRDataModel) {
        a.f fVar;
        k.c(iJRDataModel, Payload.RESPONSE);
        a.f fVar2 = this.f65834a;
        if (fVar2 != null) {
            fVar2.b();
        }
        CJRAadharPanGet cJRAadharPanGet = (CJRAadharPanGet) iJRDataModel;
        try {
            if (cJRAadharPanGet.getCersaiInfo() != null && (fVar = this.f65834a) != null) {
                fVar.a(cJRAadharPanGet.getCersaiInfo());
            }
        } catch (Exception e2) {
            if (b.v) {
                q.b(e2.getMessage());
            }
        }
    }
}
