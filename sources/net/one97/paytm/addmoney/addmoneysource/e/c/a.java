package net.one97.paytm.addmoney.addmoneysource.e.c;

import android.text.TextUtils;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.addmoney.addmoneysource.e.a.a;
import net.one97.paytm.addmoney.addmoneysource.e.b.a.b;
import net.one97.paytm.addmoney.h;
import net.one97.paytm.common.entity.wallet.CJRP2BStatus;

public final class a implements a.C0843a, h {

    /* renamed from: a  reason: collision with root package name */
    private final String f48294a = "SourceWalletPresenter";

    /* renamed from: b  reason: collision with root package name */
    private a.b f48295b;

    /* renamed from: c  reason: collision with root package name */
    private b f48296c;

    /* renamed from: d  reason: collision with root package name */
    private int f48297d;

    public a(a.b bVar, b bVar2, int i2) {
        this.f48295b = bVar;
        this.f48296c = bVar2;
        this.f48297d = i2;
    }

    public final void a() {
        this.f48295b.a();
    }

    public final void a(String str, String str2, String str3) {
        this.f48295b.a(true);
        this.f48296c.a(str, str2, str3, "SourceWalletPresenter", this);
    }

    public final void b() {
        this.f48296c.a("SourceWalletPresenter");
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
        CJRP2BStatus cJRP2BStatus;
        a.b bVar = this.f48295b;
        if (bVar != null) {
            bVar.a(false);
            if ((iJRPaytmDataModel instanceof CJRP2BStatus) && (cJRP2BStatus = (CJRP2BStatus) iJRPaytmDataModel) != null && cJRP2BStatus.getResponse() != null && cJRP2BStatus.getResponse().getStatusTxnWiseResponse() != null) {
                cJRP2BStatus.getResponse().getStatusTxnWiseResponse();
                this.f48295b.a(cJRP2BStatus);
            }
        }
    }

    public final void b(NetworkCustomError networkCustomError) {
        a.b bVar = this.f48295b;
        if (bVar != null) {
            bVar.a(false);
            if (networkCustomError != null && !TextUtils.isEmpty(networkCustomError.getMessage()) && "401,403,410".contains(networkCustomError.getMessage())) {
                this.f48295b.a(networkCustomError);
            }
        }
    }
}
