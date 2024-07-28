package net.one97.paytm.upi.profile.presenter;

import android.graphics.Typeface;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.BaseUpiResponse;
import net.one97.paytm.upi.common.upi.UpiProfileModel;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.profile.a.k;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.profile.b.b;
import net.one97.paytm.upi.profile.view.n;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public final class k implements k.a {

    /* renamed from: a  reason: collision with root package name */
    k.b f68113a;

    /* renamed from: b  reason: collision with root package name */
    String f68114b;

    /* renamed from: c  reason: collision with root package name */
    int f68115c;

    /* renamed from: d  reason: collision with root package name */
    List<BankAccountDetails.BankAccount> f68116d;

    /* renamed from: e  reason: collision with root package name */
    private final String f68117e = "UpiSelectDefaultAccountPresenter";

    /* renamed from: f  reason: collision with root package name */
    private b f68118f;

    /* renamed from: g  reason: collision with root package name */
    private String f68119g;

    /* renamed from: h  reason: collision with root package name */
    private String f68120h;

    public k(k.b bVar, b bVar2, String str, String str2) {
        this.f68113a = bVar;
        this.f68120h = bVar.getClass().getSimpleName();
        this.f68118f = bVar2;
        this.f68119g = str;
        this.f68114b = str2;
        this.f68115c = -1;
        this.f68116d = new LinkedList();
    }

    public final void e() {
        int size = this.f68116d.size();
        if (size > 0) {
            this.f68116d.clear();
            this.f68113a.b(size);
        }
        this.f68113a.a(true);
        this.f68118f.a((a.C1382a) new a.C1382a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                k.this.f68113a.a(false);
                if (upiBaseDataModel instanceof UpiProfileModel) {
                    UpiProfileModel upiProfileModel = (UpiProfileModel) upiBaseDataModel;
                    if (upiProfileModel.getStatus().equalsIgnoreCase("SUCCESS") && "0".equalsIgnoreCase(upiProfileModel.getRespCode()) && upiProfileModel.getResponse().getProfileDetail().getBankAccountList() != null && upiProfileModel.getResponse().getProfileDetail().getBankAccountList().size() > 0) {
                        LinkedList linkedList = new LinkedList();
                        Iterator<BankAccountDetails.BankAccount> it2 = upiProfileModel.getResponse().getProfileDetail().getBankAccountList().iterator();
                        while (it2.hasNext()) {
                            BankAccountDetails.BankAccount next = it2.next();
                            BankAccountDetails.BankAccount bankAccount = new BankAccountDetails.BankAccount();
                            bankAccount.setMbeba(next.isMpinSet() ? "Y" : UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT);
                            bankAccount.setMmid(next.getMmid());
                            bankAccount.setCustomerName(next.getCustomerName());
                            bankAccount.setAccRefId(next.getAccRefId());
                            bankAccount.setAeba(next.getAeba());
                            bankAccount.setAccount(next.getAccount());
                            bankAccount.setCredsAllowed(next.getCredsAllowed());
                            bankAccount.setBankCredsAllowed(next.getBankCredsAllowed());
                            bankAccount.setAccRefNumber(next.getAccRefNumber());
                            bankAccount.setIfsc(next.getIfsc());
                            bankAccount.setDefaultDebit(next.isDefaultDebit());
                            bankAccount.setDefaultCredit(next.isDefaultCredit());
                            bankAccount.setBankName(next.getBankName());
                            bankAccount.setAccountType(next.getAccountType());
                            linkedList.add(bankAccount);
                        }
                        int size = k.this.f68116d.size();
                        if (size > 0) {
                            k.this.f68116d.clear();
                            k.this.f68113a.b(size);
                        }
                        int size2 = linkedList.size();
                        for (int i2 = 0; i2 < size2; i2++) {
                            BankAccountDetails.BankAccount bankAccount2 = (BankAccountDetails.BankAccount) linkedList.get(i2);
                            if (k.this.f68114b.equals(bankAccount2.getAccRefNumber())) {
                                bankAccount2.setDefaultDebit(true);
                                k.this.f68115c = i2;
                            }
                            k.this.f68116d.add(bankAccount2);
                        }
                        k.this.f68113a.c(size2);
                    }
                }
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                k.this.f68113a.a(false);
            }
        }, "UpiSelectDefaultAccountPresenter", this.f68120h);
    }

    public final void f() {
        this.f68118f.a("UpiSelectDefaultAccountPresenter");
    }

    public final void a(int i2, n.a aVar) {
        BankAccountDetails.BankAccount bankAccount = this.f68116d.get(i2);
        boolean isDefaultDebit = bankAccount.isDefaultDebit();
        String bankName = bankAccount.getBankName();
        String accRefNumber = bankAccount.getAccRefNumber();
        if (isDefaultDebit) {
            aVar.f68326b.setTypeface(Typeface.create("sans-serif-medium", 0));
            aVar.f68328d.setVisibility(0);
            aVar.f68325a.setChecked(true);
        } else {
            aVar.f68326b.setTypeface(Typeface.create("sans-serif", 0));
            aVar.f68328d.setVisibility(8);
            aVar.f68325a.setChecked(false);
        }
        aVar.f68326b.setText(bankName);
        aVar.f68327c.setText(n.this.f68323a.getString(R.string.upi_ppb_account_number, new Object[]{UpiUtils.maskNumber(accRefNumber)}));
        aVar.f68325a.setOnClickListener(new View.OnClickListener(i2) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f68332a;

            {
                this.f68332a = r2;
            }

            public final void onClick(View view) {
                if (UpiAppUtils.isNetworkAvailable(n.this.f68323a)) {
                    n.this.f68324b.a(this.f68332a, true);
                    n.this.f68324b.a(this.f68332a, false);
                    return;
                }
                a.this.f68325a.setChecked(false);
                Toast.makeText(n.this.f68323a, n.this.f68323a.getResources().getString(R.string.no_internet), 0).show();
            }
        });
        aVar.f68330f.setOnClickListener(new View.OnClickListener(i2) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f68334a;

            {
                this.f68334a = r2;
            }

            public final void onClick(View view) {
                if (UpiAppUtils.isNetworkAvailable(n.this.f68323a)) {
                    n.this.f68324b.a(this.f68334a, true);
                    n.this.f68324b.a(this.f68334a, false);
                    return;
                }
                a.this.f68325a.setChecked(false);
                Toast.makeText(n.this.f68323a, n.this.f68323a.getResources().getString(R.string.no_internet), 0).show();
            }
        });
        aVar.f68329e.setOnClickListener(new View.OnClickListener(i2) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f68336a;

            {
                this.f68336a = r2;
            }

            public final void onClick(View view) {
                n.this.f68324b.a(this.f68336a);
            }
        });
    }

    public final int a() {
        return this.f68116d.size();
    }

    public final void a(final int i2, final boolean z) {
        UpiConstants.PROFILE_VPA_ACCOUNT_TYPE profile_vpa_account_type = UpiConstants.PROFILE_VPA_ACCOUNT_TYPE.CREDIT;
        if (z) {
            this.f68113a.b(true);
        } else {
            profile_vpa_account_type = UpiConstants.PROFILE_VPA_ACCOUNT_TYPE.DEBIT;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f68116d.get(i2));
        this.f68118f.a(profile_vpa_account_type, new UserUpiDetails.Builder((AccountProviderBody.AccountProvider) null, this.f68119g).setBankAccountList(arrayList).build(), new a.C1382a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                if (z && k.this.f68113a != null) {
                    k.this.f68113a.b(false);
                    if (upiBaseDataModel instanceof BaseUpiResponse) {
                        BaseUpiResponse baseUpiResponse = (BaseUpiResponse) upiBaseDataModel;
                        if (!baseUpiResponse.isSuccess() || !"0".equals(baseUpiResponse.getResponse())) {
                            if (i2 != -1) {
                                k.this.f68116d.get(i2).setDefaultDebit(false);
                                k.this.f68113a.a(i2);
                            }
                            k.this.f68113a.c(false);
                            return;
                        }
                        k.this.f68113a.c(true);
                        k.this.f68113a.a();
                        if (k.this.f68115c != -1) {
                            k.this.f68116d.get(k.this.f68115c).setDefaultDebit(false);
                            k.this.f68113a.a(k.this.f68115c);
                        }
                        k kVar = k.this;
                        kVar.f68115c = i2;
                        kVar.f68116d.get(k.this.f68115c).setDefaultDebit(true);
                        k.this.f68113a.a(k.this.f68115c);
                        return;
                    }
                    if (i2 != -1) {
                        k.this.f68116d.get(i2).setDefaultDebit(false);
                        k.this.f68113a.a(i2);
                    }
                    k.this.f68113a.c(false);
                }
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                if (i2 != -1) {
                    k.this.f68116d.get(i2).setDefaultDebit(false);
                    k.this.f68113a.a(i2);
                }
                if (z && k.this.f68113a != null) {
                    k.this.f68113a.b(false);
                    k.this.f68113a.c(false);
                }
            }
        }, "UpiSelectDefaultAccountPresenter", this.f68120h);
    }

    public final void a(int i2) {
        this.f68113a.a(this.f68116d.get(i2));
    }
}
