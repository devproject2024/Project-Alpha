package net.one97.paytm.addmoney.common.c;

import android.content.Intent;
import java.util.HashSet;
import java.util.List;
import net.one97.paytm.addmoney.common.a.c;
import net.one97.paytm.addmoney.utils.AddMoneyUtils;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.util.UpiConstants;

public class c extends c.a {

    /* renamed from: b  reason: collision with root package name */
    private List<AccountProviderBody.AccountProvider> f48453b;

    /* renamed from: c  reason: collision with root package name */
    private AccountProviderBody.AccountProvider f48454c;

    /* renamed from: d  reason: collision with root package name */
    private int[] f48455d = {0, 1, 2, 3};

    /* renamed from: e  reason: collision with root package name */
    private String[] f48456e = new String[4];

    /* renamed from: f  reason: collision with root package name */
    private int[] f48457f = new int[4];

    /* renamed from: g  reason: collision with root package name */
    private final String f48458g = "SelectBankPresenter";

    /* renamed from: h  reason: collision with root package name */
    private String f48459h;

    public c(c.b bVar) {
        super(bVar);
        this.f48459h = bVar.getClass().getSimpleName();
    }

    public final void a(AccountProviderBody.AccountProvider accountProvider) {
        this.f48454c = accountProvider;
        if (this.f48454c != null) {
            ((c.b) this.f48452a).a(this.f48454c);
        } else {
            ((c.b) this.f48452a).a("Please select a bank to proceed.");
        }
    }

    public final void a() {
        ((c.b) this.f48452a).a();
    }

    public final void a(int i2, int i3, Intent intent) {
        if (i3 == -1 && i2 == 2304) {
            a((AccountProviderBody.AccountProvider) AddMoneyUtils.a((Object) intent.getSerializableExtra(UpiConstants.EXTRA_ACCOUNT_PROVIDER), AccountProviderBody.AccountProvider.class));
        }
    }

    public final void a(UpiBaseDataModel upiBaseDataModel) {
        AccountProviderBody.AccountProviderDetails accountProviderDetails;
        if ((upiBaseDataModel instanceof AccountProviderBody.AccountProviderDetails) && (accountProviderDetails = (AccountProviderBody.AccountProviderDetails) upiBaseDataModel) != null && accountProviderDetails.getProviders() != null && accountProviderDetails.getProviders().size() > 0) {
            this.f48453b = accountProviderDetails.getProviders();
            HashSet hashSet = new HashSet();
            int i2 = 0;
            for (int i3 = 0; i3 < this.f48453b.size(); i3++) {
                if (this.f48453b.get(i3).getIfsc().equalsIgnoreCase(UpiConstants.FAVORITE_BANKS.SBI_BANK.getIfscCode())) {
                    this.f48455d[i2] = i3;
                    this.f48456e[i2] = UpiConstants.FAVORITE_BANKS.SBI_BANK.getDrawableName();
                    this.f48457f[i2] = UpiConstants.FAVORITE_BANKS.SBI_BANK.getDrawableId();
                    hashSet.add(Integer.valueOf(i3));
                    i2++;
                }
            }
            for (int i4 = 0; i4 < this.f48453b.size(); i4++) {
                if (this.f48453b.get(i4).getIfsc().equalsIgnoreCase(UpiConstants.FAVORITE_BANKS.HDFC_BANK.getIfscCode())) {
                    this.f48455d[i2] = i4;
                    this.f48456e[i2] = UpiConstants.FAVORITE_BANKS.HDFC_BANK.getDrawableName();
                    this.f48457f[i2] = UpiConstants.FAVORITE_BANKS.HDFC_BANK.getDrawableId();
                    hashSet.add(Integer.valueOf(i4));
                    i2++;
                }
            }
            for (int i5 = 0; i5 < this.f48453b.size(); i5++) {
                if (this.f48453b.get(i5).getIfsc().equalsIgnoreCase(UpiConstants.FAVORITE_BANKS.ICICI_BANK.getIfscCode())) {
                    this.f48455d[i2] = i5;
                    this.f48456e[i2] = UpiConstants.FAVORITE_BANKS.ICICI_BANK.getDrawableName();
                    this.f48457f[i2] = UpiConstants.FAVORITE_BANKS.ICICI_BANK.getDrawableId();
                    hashSet.add(Integer.valueOf(i5));
                    i2++;
                }
            }
            for (int i6 = 0; i6 < this.f48453b.size() && i2 < 4; i6++) {
                if (this.f48453b.get(i6).getIfsc().equalsIgnoreCase(UpiConstants.FAVORITE_BANKS.AXIS_BANK.getIfscCode())) {
                    this.f48455d[i2] = i6;
                    this.f48456e[i2] = UpiConstants.FAVORITE_BANKS.AXIS_BANK.getDrawableName();
                    this.f48457f[i2] = UpiConstants.FAVORITE_BANKS.AXIS_BANK.getDrawableId();
                    hashSet.add(Integer.valueOf(i6));
                    i2++;
                }
            }
            while (i2 < 4) {
                int i7 = 0;
                while (true) {
                    if (i7 >= this.f48453b.size()) {
                        break;
                    } else if (!hashSet.contains(Integer.valueOf(i7))) {
                        hashSet.add(Integer.valueOf(i7));
                        this.f48455d[i2] = i7;
                        this.f48456e[i2] = "";
                        this.f48457f[i2] = -1;
                        i2++;
                        break;
                    } else {
                        i7++;
                    }
                }
            }
            ((c.b) this.f48452a).setFavoriteBanks(this.f48457f[0], this.f48453b.get(this.f48455d[0]), this.f48457f[1], this.f48453b.get(this.f48455d[1]), this.f48457f[2], this.f48453b.get(this.f48455d[2]), this.f48457f[3], this.f48453b.get(this.f48455d[3]));
        }
    }
}
