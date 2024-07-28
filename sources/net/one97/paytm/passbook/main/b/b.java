package net.one97.paytm.passbook.main.b;

import java.util.HashSet;
import java.util.List;
import net.one97.paytm.passbook.beans.upi.AccountProviderBody;
import net.one97.paytm.passbook.beans.upi.UpiCallback;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.main.b.a;
import net.one97.paytm.passbook.utility.p;

public final class b extends a.C1098a implements UpiCallback {

    /* renamed from: b  reason: collision with root package name */
    private List<AccountProviderBody.AccountProvider> f57825b;

    /* renamed from: c  reason: collision with root package name */
    private AccountProviderBody.AccountProvider f57826c;

    /* renamed from: d  reason: collision with root package name */
    private int[] f57827d = {0, 1, 2, 3};

    /* renamed from: e  reason: collision with root package name */
    private String[] f57828e = new String[4];

    /* renamed from: f  reason: collision with root package name */
    private int[] f57829f = new int[4];

    /* renamed from: g  reason: collision with root package name */
    private final String f57830g = "SelectBankPresenter";

    /* renamed from: h  reason: collision with root package name */
    private String f57831h;

    public b(a.b bVar) {
        super(bVar);
        this.f57831h = bVar.getClass().getSimpleName();
    }

    public final void a() {
        d.b().a((UpiCallback) this);
    }

    public final void a(AccountProviderBody.AccountProvider accountProvider) {
        this.f57826c = accountProvider;
        if (this.f57826c != null) {
            ((a.b) this.f57072a).a(this.f57826c);
        } else {
            ((a.b) this.f57072a).a("Please select a bank to proceed.");
        }
    }

    public final void b() {
        ((a.b) this.f57072a).a();
    }

    public final void onSuccess(Object obj) {
        AccountProviderBody.AccountProviderDetails accountProviderDetails;
        if ((obj instanceof AccountProviderBody.AccountProviderDetails) && (accountProviderDetails = (AccountProviderBody.AccountProviderDetails) obj) != null && accountProviderDetails.getProviders() != null && accountProviderDetails.getProviders().size() > 0) {
            this.f57825b = accountProviderDetails.getProviders();
            HashSet hashSet = new HashSet();
            int i2 = 0;
            for (int i3 = 0; i3 < this.f57825b.size(); i3++) {
                if (this.f57825b.get(i3).getIfsc().equalsIgnoreCase(p.a.SBI_BANK.getIfscCode())) {
                    this.f57827d[i2] = i3;
                    this.f57828e[i2] = p.a.SBI_BANK.getDrawableName();
                    this.f57829f[i2] = p.a.SBI_BANK.getDrawableId();
                    hashSet.add(Integer.valueOf(i3));
                    i2++;
                }
            }
            for (int i4 = 0; i4 < this.f57825b.size(); i4++) {
                if (this.f57825b.get(i4).getIfsc().equalsIgnoreCase(p.a.HDFC_BANK.getIfscCode())) {
                    this.f57827d[i2] = i4;
                    this.f57828e[i2] = p.a.HDFC_BANK.getDrawableName();
                    this.f57829f[i2] = p.a.HDFC_BANK.getDrawableId();
                    hashSet.add(Integer.valueOf(i4));
                    i2++;
                }
            }
            for (int i5 = 0; i5 < this.f57825b.size(); i5++) {
                if (this.f57825b.get(i5).getIfsc().equalsIgnoreCase(p.a.ICICI_BANK.getIfscCode())) {
                    this.f57827d[i2] = i5;
                    this.f57828e[i2] = p.a.ICICI_BANK.getDrawableName();
                    this.f57829f[i2] = p.a.ICICI_BANK.getDrawableId();
                    hashSet.add(Integer.valueOf(i5));
                    i2++;
                }
            }
            for (int i6 = 0; i6 < this.f57825b.size() && i2 < 4; i6++) {
                if (this.f57825b.get(i6).getIfsc().equalsIgnoreCase(p.a.AXIS_BANK.getIfscCode())) {
                    this.f57827d[i2] = i6;
                    this.f57828e[i2] = p.a.AXIS_BANK.getDrawableName();
                    this.f57829f[i2] = p.a.AXIS_BANK.getDrawableId();
                    hashSet.add(Integer.valueOf(i6));
                    i2++;
                }
            }
            while (i2 < 4) {
                int i7 = 0;
                while (true) {
                    if (i7 >= this.f57825b.size()) {
                        break;
                    } else if (!hashSet.contains(Integer.valueOf(i7))) {
                        hashSet.add(Integer.valueOf(i7));
                        this.f57827d[i2] = i7;
                        this.f57828e[i2] = "";
                        this.f57829f[i2] = -1;
                        i2++;
                        break;
                    } else {
                        i7++;
                    }
                }
            }
            ((a.b) this.f57072a).setFavoriteBanks(this.f57829f[0], this.f57825b.get(this.f57827d[0]), this.f57829f[1], this.f57825b.get(this.f57827d[1]), this.f57829f[2], this.f57825b.get(this.f57827d[2]), this.f57829f[3], this.f57825b.get(this.f57827d[3]));
        }
    }

    public final void onError(Throwable th) {
        th.getMessage();
    }
}
