package net.one97.paytm.upi.registration.presenter;

import android.content.Intent;
import java.util.HashSet;
import java.util.List;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.registration.a.e;
import net.one97.paytm.upi.registration.b.a.a;
import net.one97.paytm.upi.registration.b.a.b;
import net.one97.paytm.upi.util.UpiConstants;

public final class e implements e.a, a.C1389a {

    /* renamed from: a  reason: collision with root package name */
    private final b f68637a;

    /* renamed from: b  reason: collision with root package name */
    private final e.b f68638b;

    /* renamed from: c  reason: collision with root package name */
    private List<AccountProviderBody.AccountProvider> f68639c;

    /* renamed from: d  reason: collision with root package name */
    private AccountProviderBody.AccountProvider f68640d;

    /* renamed from: e  reason: collision with root package name */
    private int[] f68641e = {0, 1, 2, 3, 4, 5};

    /* renamed from: f  reason: collision with root package name */
    private String[] f68642f = new String[6];

    /* renamed from: g  reason: collision with root package name */
    private int[] f68643g = new int[6];

    /* renamed from: h  reason: collision with root package name */
    private final String f68644h = "SelectBankPresenter";

    /* renamed from: i  reason: collision with root package name */
    private String f68645i;

    public e(b bVar, e.b bVar2) {
        this.f68638b = bVar2;
        this.f68645i = bVar2.getClass().getSimpleName();
        this.f68637a = bVar;
        this.f68638b.a(this);
    }

    public final void f() {
        this.f68637a.c("SelectBankPresenter");
    }

    public final void a(AccountProviderBody.AccountProvider accountProvider, int i2) {
        this.f68638b.b();
        this.f68640d = accountProvider;
        this.f68638b.a(i2);
        AccountProviderBody.AccountProvider accountProvider2 = this.f68640d;
        if (accountProvider2 != null) {
            this.f68638b.a(accountProvider2);
        } else {
            this.f68638b.a("Please select a bank to proceed.");
        }
    }

    public final void a() {
        this.f68638b.a();
    }

    public final void a(int i2, int i3, Intent intent) {
        if (i3 == -1 && i2 == 1) {
            a((AccountProviderBody.AccountProvider) intent.getSerializableExtra(UpiConstants.EXTRA_ACCOUNT_PROVIDER), -1);
        }
    }

    public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
        AccountProviderBody.AccountProviderDetails accountProviderDetails;
        UpiBaseDataModel upiBaseDataModel2 = upiBaseDataModel;
        this.f68638b.a(false);
        if ((upiBaseDataModel2 instanceof AccountProviderBody.AccountProviderDetails) && (accountProviderDetails = (AccountProviderBody.AccountProviderDetails) upiBaseDataModel2) != null && accountProviderDetails.getProviders() != null && accountProviderDetails.getProviders().size() > 0) {
            this.f68639c = accountProviderDetails.getProviders();
            HashSet hashSet = new HashSet();
            int i2 = 0;
            for (int i3 = 0; i3 < this.f68639c.size(); i3++) {
                if (this.f68639c.get(i3).getIfsc().equalsIgnoreCase(UpiConstants.FAVORITE_BANKS.SBI_BANK.getIfscCode())) {
                    this.f68641e[i2] = i3;
                    this.f68642f[i2] = UpiConstants.FAVORITE_BANKS.SBI_BANK.getDrawableName();
                    this.f68643g[i2] = UpiConstants.FAVORITE_BANKS.SBI_BANK.getDrawableId();
                    hashSet.add(Integer.valueOf(i3));
                    i2++;
                }
            }
            for (int i4 = 0; i4 < this.f68639c.size(); i4++) {
                if (this.f68639c.get(i4).getIfsc().equalsIgnoreCase(UpiConstants.FAVORITE_BANKS.ICICI_BANK.getIfscCode())) {
                    this.f68641e[i2] = i4;
                    this.f68642f[i2] = UpiConstants.FAVORITE_BANKS.ICICI_BANK.getDrawableName();
                    this.f68643g[i2] = UpiConstants.FAVORITE_BANKS.ICICI_BANK.getDrawableId();
                    hashSet.add(Integer.valueOf(i4));
                    i2++;
                }
            }
            for (int i5 = 0; i5 < this.f68639c.size(); i5++) {
                if (this.f68639c.get(i5).getIfsc().equalsIgnoreCase(UpiConstants.FAVORITE_BANKS.HDFC_BANK.getIfscCode())) {
                    this.f68641e[i2] = i5;
                    this.f68642f[i2] = UpiConstants.FAVORITE_BANKS.HDFC_BANK.getDrawableName();
                    this.f68643g[i2] = UpiConstants.FAVORITE_BANKS.HDFC_BANK.getDrawableId();
                    hashSet.add(Integer.valueOf(i5));
                    i2++;
                }
            }
            for (int i6 = 0; i6 < this.f68639c.size() && i2 < 6; i6++) {
                AccountProviderBody.AccountProvider accountProvider = this.f68639c.get(i6);
                if (accountProvider.getIfsc().equalsIgnoreCase(UpiConstants.FAVORITE_BANKS.PNB.getIfscCode())) {
                    this.f68641e[i2] = i6;
                    this.f68642f[i2] = UpiConstants.FAVORITE_BANKS.PNB.getDrawableName();
                    this.f68643g[i2] = UpiConstants.FAVORITE_BANKS.PNB.getDrawableId();
                    hashSet.add(Integer.valueOf(i6));
                    i2++;
                }
                if (accountProvider.getIfsc().equalsIgnoreCase(UpiConstants.FAVORITE_BANKS.AXIS_BANK.getIfscCode())) {
                    this.f68641e[i2] = i6;
                    this.f68642f[i2] = UpiConstants.FAVORITE_BANKS.AXIS_BANK.getDrawableName();
                    this.f68643g[i2] = UpiConstants.FAVORITE_BANKS.AXIS_BANK.getDrawableId();
                    hashSet.add(Integer.valueOf(i6));
                    i2++;
                }
                if (accountProvider.getIfsc().equalsIgnoreCase(UpiConstants.FAVORITE_BANKS.BOB.getIfscCode())) {
                    this.f68641e[i2] = i6;
                    this.f68642f[i2] = UpiConstants.FAVORITE_BANKS.BOB.getDrawableName();
                    this.f68643g[i2] = UpiConstants.FAVORITE_BANKS.BOB.getDrawableId();
                    hashSet.add(Integer.valueOf(i6));
                    i2++;
                }
            }
            while (i2 < 6) {
                int i7 = 0;
                while (true) {
                    if (i7 >= this.f68639c.size()) {
                        break;
                    } else if (!hashSet.contains(Integer.valueOf(i7))) {
                        hashSet.add(Integer.valueOf(i7));
                        this.f68641e[i2] = i7;
                        this.f68642f[i2] = "";
                        this.f68643g[i2] = -1;
                        i2++;
                        break;
                    } else {
                        i7++;
                    }
                }
            }
            this.f68638b.a(this.f68643g[0], this.f68639c.get(this.f68641e[0]), this.f68643g[1], this.f68639c.get(this.f68641e[1]), this.f68643g[2], this.f68639c.get(this.f68641e[2]), this.f68643g[3], this.f68639c.get(this.f68641e[3]), this.f68643g[4], this.f68639c.get(this.f68641e[4]), this.f68643g[5], this.f68639c.get(this.f68641e[5]));
        }
    }

    public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
        this.f68638b.a(false);
        this.f68638b.b(upiCustomVolleyError.getAlertMessage());
    }

    public final void e() {
        this.f68638b.a(true);
        this.f68637a.a((a.C1389a) this, "SelectBankPresenter", this.f68645i);
    }
}
