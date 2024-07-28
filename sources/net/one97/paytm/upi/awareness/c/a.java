package net.one97.paytm.upi.awareness.c;

import androidx.core.g.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import net.one97.paytm.upi.awareness.a.a;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.registration.b.a.a;
import net.one97.paytm.upi.registration.b.a.b;
import net.one97.paytm.upi.util.UpiConstants;

public final class a implements a.C1341a, a.C1389a {

    /* renamed from: a  reason: collision with root package name */
    List<UpiBaseDataModel> f66533a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private a.b f66534b;

    /* renamed from: c  reason: collision with root package name */
    private b f66535c;

    /* renamed from: d  reason: collision with root package name */
    private final String f66536d = "AccountProviderPresenter";

    /* renamed from: e  reason: collision with root package name */
    private List<net.one97.paytm.upi.awareness.b.a> f66537e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private int[] f66538f = {0, 1, 2, 3, 4, 5};

    /* renamed from: g  reason: collision with root package name */
    private String[] f66539g = new String[6];

    /* renamed from: h  reason: collision with root package name */
    private int[] f66540h = new int[6];

    /* renamed from: i  reason: collision with root package name */
    private String f66541i;

    public a(b bVar, a.b bVar2) {
        this.f66535c = (b) f.a(bVar, "accountProviderRepo cannot be null");
        this.f66534b = (a.b) f.a(bVar2, "accountProvider cannot be null!");
        this.f66541i = this.f66534b.getClass().getSimpleName();
        this.f66534b.a(this);
    }

    public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
        a.b bVar = this.f66534b;
        if (bVar != null) {
            if (upiBaseDataModel instanceof AccountProviderBody.AccountProviderDetails) {
                final AccountProviderBody.AccountProviderDetails accountProviderDetails = (AccountProviderBody.AccountProviderDetails) upiBaseDataModel;
                List<AccountProviderBody.AccountProvider> providers = accountProviderDetails.getProviders();
                HashSet hashSet = new HashSet();
                int i2 = 0;
                for (int i3 = 0; i3 < providers.size(); i3++) {
                    AccountProviderBody.AccountProvider accountProvider = providers.get(i3);
                    if (accountProvider.getIfsc().equalsIgnoreCase(UpiConstants.FAVORITE_BANKS.SBI_BANK.getIfscCode())) {
                        this.f66538f[i2] = i3;
                        this.f66539g[i2] = UpiConstants.FAVORITE_BANKS.SBI_BANK.getDrawableName();
                        this.f66540h[i2] = UpiConstants.FAVORITE_BANKS.SBI_BANK.getDrawableId();
                        hashSet.add(Integer.valueOf(i3));
                        this.f66537e.add(new net.one97.paytm.upi.awareness.b.a(UpiConstants.FAVORITE_BANKS.SBI_BANK.getDrawableId(), accountProvider));
                        i2++;
                    }
                }
                for (int i4 = 0; i4 < providers.size(); i4++) {
                    AccountProviderBody.AccountProvider accountProvider2 = providers.get(i4);
                    if (accountProvider2.getIfsc().equalsIgnoreCase(UpiConstants.FAVORITE_BANKS.ICICI_BANK.getIfscCode())) {
                        this.f66538f[i2] = i4;
                        this.f66539g[i2] = UpiConstants.FAVORITE_BANKS.ICICI_BANK.getDrawableName();
                        this.f66540h[i2] = UpiConstants.FAVORITE_BANKS.ICICI_BANK.getDrawableId();
                        hashSet.add(Integer.valueOf(i4));
                        this.f66537e.add(new net.one97.paytm.upi.awareness.b.a(UpiConstants.FAVORITE_BANKS.ICICI_BANK.getDrawableId(), accountProvider2));
                        i2++;
                    }
                }
                for (int i5 = 0; i5 < providers.size(); i5++) {
                    AccountProviderBody.AccountProvider accountProvider3 = providers.get(i5);
                    if (accountProvider3.getIfsc().equalsIgnoreCase(UpiConstants.FAVORITE_BANKS.HDFC_BANK.getIfscCode())) {
                        this.f66538f[i2] = i5;
                        this.f66539g[i2] = UpiConstants.FAVORITE_BANKS.HDFC_BANK.getDrawableName();
                        this.f66540h[i2] = UpiConstants.FAVORITE_BANKS.HDFC_BANK.getDrawableId();
                        hashSet.add(Integer.valueOf(i5));
                        this.f66537e.add(new net.one97.paytm.upi.awareness.b.a(UpiConstants.FAVORITE_BANKS.HDFC_BANK.getDrawableId(), accountProvider3));
                        i2++;
                    }
                }
                for (int i6 = 0; i6 < providers.size() && i2 < 6; i6++) {
                    AccountProviderBody.AccountProvider accountProvider4 = providers.get(i6);
                    if (accountProvider4.getIfsc().equalsIgnoreCase(UpiConstants.FAVORITE_BANKS.PNB.getIfscCode())) {
                        this.f66538f[i2] = i6;
                        this.f66539g[i2] = UpiConstants.FAVORITE_BANKS.PNB.getDrawableName();
                        this.f66540h[i2] = UpiConstants.FAVORITE_BANKS.PNB.getDrawableId();
                        hashSet.add(Integer.valueOf(i6));
                        this.f66537e.add(new net.one97.paytm.upi.awareness.b.a(UpiConstants.FAVORITE_BANKS.PNB.getDrawableId(), accountProvider4));
                        i2++;
                    }
                    if (accountProvider4.getIfsc().equalsIgnoreCase(UpiConstants.FAVORITE_BANKS.AXIS_BANK.getIfscCode())) {
                        this.f66538f[i2] = i6;
                        this.f66539g[i2] = UpiConstants.FAVORITE_BANKS.AXIS_BANK.getDrawableName();
                        this.f66540h[i2] = UpiConstants.FAVORITE_BANKS.AXIS_BANK.getDrawableId();
                        hashSet.add(Integer.valueOf(i6));
                        this.f66537e.add(new net.one97.paytm.upi.awareness.b.a(UpiConstants.FAVORITE_BANKS.AXIS_BANK.getDrawableId(), accountProvider4));
                        i2++;
                    }
                    if (accountProvider4.getIfsc().equalsIgnoreCase(UpiConstants.FAVORITE_BANKS.BOB.getIfscCode())) {
                        this.f66538f[i2] = i6;
                        this.f66539g[i2] = UpiConstants.FAVORITE_BANKS.BOB.getDrawableName();
                        this.f66540h[i2] = UpiConstants.FAVORITE_BANKS.BOB.getDrawableId();
                        hashSet.add(Integer.valueOf(i6));
                        this.f66537e.add(new net.one97.paytm.upi.awareness.b.a(UpiConstants.FAVORITE_BANKS.BOB.getDrawableId(), accountProvider4));
                        i2++;
                    }
                }
                while (i2 < 6) {
                    int i7 = 0;
                    while (true) {
                        if (i7 >= providers.size()) {
                            break;
                        } else if (!hashSet.contains(Integer.valueOf(i7))) {
                            hashSet.add(Integer.valueOf(i7));
                            this.f66538f[i2] = i7;
                            this.f66539g[i2] = "";
                            this.f66540h[i2] = -1;
                            i2++;
                            this.f66537e.add(new net.one97.paytm.upi.awareness.b.a(-1, providers.get(i7)));
                            break;
                        } else {
                            i7++;
                        }
                    }
                }
                if (accountProviderDetails != null && accountProviderDetails.getProviders() != null && accountProviderDetails.getProviders().size() > 0) {
                    ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
                    Future submit = newSingleThreadExecutor.submit(new Callable<List<UpiBaseDataModel>>() {
                        public final /* synthetic */ Object call() throws Exception {
                            for (AccountProviderBody.AccountProvider add : accountProviderDetails.getProviders()) {
                                a.this.f66533a.add(add);
                            }
                            return a.this.f66533a;
                        }
                    });
                    try {
                        newSingleThreadExecutor.shutdown();
                        newSingleThreadExecutor.awaitTermination(5000, TimeUnit.SECONDS);
                        this.f66534b.b(this.f66537e);
                        this.f66534b.a((List) submit.get());
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.f66534b.b();
                    } catch (ExecutionException e3) {
                        e3.printStackTrace();
                        this.f66534b.b();
                    }
                }
            } else {
                bVar.b();
            }
        }
    }

    public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
        a.b bVar = this.f66534b;
        if (bVar != null) {
            bVar.b();
        }
    }

    public final void f() {
        this.f66534b = null;
        this.f66535c.c("AccountProviderPresenter");
    }

    public final void e() {
        this.f66534b.a();
        this.f66535c.a((a.C1389a) this, "AccountProviderPresenter", this.f66541i);
    }
}
