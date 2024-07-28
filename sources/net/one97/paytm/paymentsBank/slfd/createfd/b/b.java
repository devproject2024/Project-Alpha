package net.one97.paytm.paymentsBank.slfd.createfd.b;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.paymentsBank.model.slfd.SlfdMetaApiResponseModel;
import net.one97.paytm.paymentsBank.slfd.a.a.b;
import net.one97.paytm.paymentsBank.slfd.createfd.a.b;

public final class b implements g.a, g.b<IJRPaytmDataModel>, b.a {

    /* renamed from: a  reason: collision with root package name */
    private SlfdMetaApiResponseModel f19053a;

    /* renamed from: b  reason: collision with root package name */
    private final net.one97.paytm.paymentsBank.slfd.a.a.b f19054b;

    /* renamed from: c  reason: collision with root package name */
    private final b.C0334b f19055c;

    public b(net.one97.paytm.paymentsBank.slfd.a.a.b bVar, b.C0334b bVar2) {
        k.c(bVar, "slfdRepository");
        k.c(bVar2, "slfdInfoView");
        this.f19054b = bVar;
        this.f19055c = bVar2;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
        this.f19055c.a(false);
        if (iJRPaytmDataModel instanceof SlfdMetaApiResponseModel) {
            this.f19053a = (SlfdMetaApiResponseModel) iJRPaytmDataModel;
            b.C0334b bVar = this.f19055c;
            SlfdMetaApiResponseModel slfdMetaApiResponseModel = this.f19053a;
            String str = null;
            bVar.a(slfdMetaApiResponseModel != null ? slfdMetaApiResponseModel.getInterestRateText() : null);
            b.C0334b bVar2 = this.f19055c;
            SlfdMetaApiResponseModel slfdMetaApiResponseModel2 = this.f19053a;
            if (slfdMetaApiResponseModel2 != null) {
                str = slfdMetaApiResponseModel2.getExitLoadText();
            }
            bVar2.b(str);
        }
    }

    public final void b() {
        b.a aVar = net.one97.paytm.paymentsBank.slfd.a.a.b.f18944a;
        net.one97.paytm.paymentsBank.slfd.a.a.b.f18945d = null;
    }

    public final void c() {
        this.f19055c.a(this.f19053a);
    }

    public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        String str;
        this.f19055c.a(false);
        b.C0334b bVar = this.f19055c;
        if (networkCustomError == null || (str = networkCustomError.getAlertMessage()) == null) {
            str = "Some error occurred";
        }
        bVar.a("", str);
    }

    public final void a() {
        this.f19055c.a(true);
        this.f19054b.a(this, this);
    }
}
