package net.one97.paytm.addmoney.landing.c;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.common.model.CJRAccountSummary;
import net.one97.paytm.addmoney.landing.a.a;
import net.one97.paytm.addmoney.landing.view.a;
import net.one97.paytm.common.entity.paymentsbank.CustProductList;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UpiProfileModel;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.profile.b.b;

public final class a implements a.b {

    /* renamed from: a  reason: collision with root package name */
    public a.c f48579a;

    /* renamed from: b  reason: collision with root package name */
    public CustProductList f48580b;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<UpiBaseDataModel> f48581c;

    /* renamed from: d  reason: collision with root package name */
    int f48582d;

    /* renamed from: e  reason: collision with root package name */
    int f48583e;

    /* renamed from: f  reason: collision with root package name */
    public Double f48584f;

    /* renamed from: g  reason: collision with root package name */
    private final String f48585g = "AddMoneyMainPresenter";

    /* renamed from: h  reason: collision with root package name */
    private a.C0851a f48586h;

    /* renamed from: i  reason: collision with root package name */
    private b f48587i;
    private String j;

    public final void b() {
    }

    public a(a.c cVar, b bVar) {
        this.f48579a = cVar;
        this.j = cVar.getClass().getSimpleName();
        this.f48587i = bVar;
        this.f48586h = new net.one97.paytm.addmoney.landing.b.a(this, "AddMoneyMainPresenter");
        this.f48581c = new ArrayList<>();
    }

    public final void a() {
        net.one97.paytm.helper.a.b();
        this.f48579a.b(true);
        this.f48587i.a((a.C1382a) new a.C1382a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                if (upiBaseDataModel instanceof UpiProfileModel) {
                    a.this.f48579a.b(false);
                    UpiProfileModel upiProfileModel = (UpiProfileModel) upiBaseDataModel;
                    if (upiProfileModel.getResponse() != null && upiProfileModel.getResponse().getProfileDetail().getBankAccountList() != null) {
                        a aVar = a.this;
                        aVar.f48583e = aVar.j();
                        if (a.this.f48583e > 0) {
                            a.this.f48581c.clear();
                            a.this.f48579a.a(a.this.f48583e);
                            a.this.f48583e = 0;
                        }
                        if (upiProfileModel.getResponse().getProfileDetail().getBankAccountList().size() > 0) {
                            a.this.f48582d = 0;
                            Iterator<BankAccountDetails.BankAccount> it2 = upiProfileModel.getResponse().getProfileDetail().getBankAccountList().iterator();
                            while (it2.hasNext()) {
                                BankAccountDetails.BankAccount next = it2.next();
                                if (!next.getIfsc().contains("PYTM")) {
                                    a.this.f48581c.add(next);
                                    a.this.f48582d++;
                                }
                            }
                            a.this.k();
                        }
                    }
                }
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                a.this.f48579a.b(false);
                a.this.f48579a.c(false);
            }
        }, "AddMoneyMainPresenter", this.j);
    }

    public final String f() {
        CustProductList custProductList = this.f48580b;
        if (custProductList != null) {
            return custProductList.getSlfdStatus();
        }
        return null;
    }

    public final void d() {
        this.f48579a.d();
    }

    public final void g() {
        if (com.paytm.utility.b.c((Context) c())) {
            this.f48579a.b(true);
            this.f48586h.b();
            return;
        }
        this.f48579a.a(c().getString(R.string.check_your_network));
    }

    public final void a(CustProductList custProductList) {
        this.f48580b = custProductList;
        if ("ISSUED".equals(this.f48580b.getIsaStatus())) {
            this.f48579a.a(true, this.f48580b.getIsaAccountStatus());
        } else {
            this.f48579a.a(false, this.f48580b.getIsaAccountStatus());
        }
        k();
    }

    public final void h() {
        if (com.paytm.utility.b.c((Context) c())) {
            CustProductList custProductList = this.f48580b;
            if (custProductList != null) {
                a.C0851a aVar = this.f48586h;
                custProductList.getIsaAccNum();
                aVar.c();
                return;
            }
            return;
        }
        this.f48579a.a(c().getString(R.string.check_your_network));
    }

    public final void a(CJRAccountSummary cJRAccountSummary) {
        StringBuilder sb = new StringBuilder();
        sb.append(cJRAccountSummary.getAccounts().get(0).getEffectiveBalance());
        this.f48579a.b(sb.toString());
        this.f48584f = Double.valueOf(cJRAccountSummary.getAccounts().get(0).getSlfdBalance());
    }

    public final void a(NetworkCustomError networkCustomError) {
        if (networkCustomError != null && !TextUtils.isEmpty(networkCustomError.getMessage()) && "401,403,410".contains(networkCustomError.getMessage())) {
            this.f48579a.a(networkCustomError);
        } else if (networkCustomError != null && networkCustomError.networkResponse != null && (networkCustomError.networkResponse.statusCode == 403 || networkCustomError.networkResponse.statusCode == 401 || networkCustomError.networkResponse.statusCode == 410)) {
            this.f48579a.a(networkCustomError);
        } else if (networkCustomError != null) {
            a.c cVar = this.f48579a;
            cVar.a(networkCustomError.getAlertMessage());
        }
    }

    public final Activity c() {
        return this.f48579a.c();
    }

    public final void i() {
        this.f48586h.a();
    }

    public final void a(String str, String str2, String str3) {
        this.f48579a.a(str, str2, str3);
    }

    public final void a(int i2, a.C0852a aVar) {
        UpiBaseDataModel upiBaseDataModel = this.f48581c.get(i2);
        if (upiBaseDataModel instanceof BankAccountDetails.BankAccount) {
            BankAccountDetails.BankAccount bankAccount = (BankAccountDetails.BankAccount) upiBaseDataModel;
            aVar.a(i2, bankAccount.getBankName(), bankAccount.getAccRefNumber(), bankAccount.getIfsc(), bankAccount.getBankLogoUrl());
        }
    }

    public final int e() {
        return j();
    }

    public final void a(int i2) {
        UpiBaseDataModel upiBaseDataModel = this.f48581c.get(i2);
        if (upiBaseDataModel instanceof BankAccountDetails.BankAccount) {
            BankAccountDetails.BankAccount bankAccount = (BankAccountDetails.BankAccount) upiBaseDataModel;
            this.f48579a.a(bankAccount.getCustomerName(), bankAccount.getBankName(), bankAccount.getAccRefNumber(), bankAccount.getIfsc());
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized int j() {
        return this.f48581c.size();
    }

    /* access modifiers changed from: package-private */
    public final void k() {
        CustProductList custProductList = this.f48580b;
        if (custProductList == null) {
            return;
        }
        if ("ISSUED".equalsIgnoreCase(custProductList.getIsaStatus())) {
            if (j() > 0) {
                this.f48579a.c(true);
                this.f48579a.a(this.f48583e, this.f48582d);
                l();
                return;
            }
            m();
        } else if (j() > 1) {
            this.f48579a.c(true);
            this.f48579a.a(this.f48583e, this.f48582d);
            l();
        } else {
            m();
        }
    }

    private void l() {
        this.f48579a.f();
    }

    private void m() {
        this.f48579a.e();
    }
}
