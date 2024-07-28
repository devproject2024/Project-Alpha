package net.one97.paytm.addmoney.addmoneysource.b.b;

import android.text.TextUtils;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.addmoney.addmoneysource.b.a.a;
import net.one97.paytm.addmoney.addmoneysource.b.c.b;
import net.one97.paytm.addmoney.common.model.AccountNameModel;
import net.one97.paytm.addmoney.common.model.IsaDetailsModel;
import net.one97.paytm.addmoney.h;

public final class a implements a.C0840a, h {

    /* renamed from: a  reason: collision with root package name */
    private final String f48183a = "SourceOtherBankPresenter";

    /* renamed from: b  reason: collision with root package name */
    private a.b f48184b;

    /* renamed from: c  reason: collision with root package name */
    private b f48185c;

    /* renamed from: d  reason: collision with root package name */
    private String f48186d;

    /* renamed from: e  reason: collision with root package name */
    private int f48187e;

    public a(a.b bVar, b bVar2, int i2, String str) {
        this.f48184b = bVar;
        this.f48185c = bVar2;
        this.f48187e = i2;
        this.f48186d = str;
    }

    public final void a() {
        this.f48185c.a((h) this, "SourceOtherBankPresenter");
    }

    public final void b() {
        this.f48185c.a("SourceOtherBankPresenter");
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
        a.b bVar = this.f48184b;
        if (bVar != null) {
            if (iJRPaytmDataModel instanceof IsaDetailsModel) {
                IsaDetailsModel isaDetailsModel = (IsaDetailsModel) iJRPaytmDataModel;
                bVar.a(isaDetailsModel.getAccountNumber(), isaDetailsModel.getIfscCode());
            } else if (iJRPaytmDataModel instanceof AccountNameModel) {
                this.f48184b.a(((AccountNameModel) iJRPaytmDataModel).getName());
            }
        }
    }

    public final void b(NetworkCustomError networkCustomError) {
        a.b bVar = this.f48184b;
        if (bVar != null) {
            bVar.a(false);
            if (networkCustomError != null && !TextUtils.isEmpty(networkCustomError.getMessage()) && "401,403,410".contains(networkCustomError.getMessage())) {
                this.f48184b.a(networkCustomError);
            }
        }
    }
}
