package net.one97.paytm.wallet.rateMerchant;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.aa;
import androidx.lifecycle.k;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import kotlin.g.b.k;
import kotlin.m;
import net.one97.paytm.wallet.rateMerchant.b.a;
import net.one97.paytm.wallet.rateMerchant.b.b;
import net.one97.paytm.wallet.rateMerchant.b.c;
import net.one97.paytm.wallet.rateMerchant.b.d;
import net.one97.paytm.wallet.rateMerchant.entity.MerchantPPReviewData;

public final class RateMerchantHelper implements p {

    /* renamed from: a  reason: collision with root package name */
    private c f71602a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f71603b;

    /* renamed from: c  reason: collision with root package name */
    private final q f71604c;

    /* renamed from: d  reason: collision with root package name */
    private final String f71605d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public a f71606e;

    public interface a {
        void a();

        void a(MerchantPPReviewData merchantPPReviewData);
    }

    static final class b<T> implements z<net.one97.paytm.wallet.rateMerchant.a.a<MerchantPPReviewData>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RateMerchantHelper f71607a;

        b(RateMerchantHelper rateMerchantHelper) {
            this.f71607a = rateMerchantHelper;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.wallet.rateMerchant.a.a aVar = (net.one97.paytm.wallet.rateMerchant.a.a) obj;
            if (aVar != null) {
                int i2 = e.f71708a[aVar.f71611a.ordinal()];
                if (i2 == 1) {
                    MerchantPPReviewData merchantPPReviewData = (MerchantPPReviewData) aVar.f71612b;
                    if (merchantPPReviewData == null) {
                        return;
                    }
                    if (merchantPPReviewData.isEligible()) {
                        RateMerchantHelper.a(this.f71607a, merchantPPReviewData);
                        return;
                    }
                    a a2 = this.f71607a.f71606e;
                    if (a2 != null) {
                        a2.a();
                    }
                } else if (i2 == 2) {
                    a a3 = this.f71607a.f71606e;
                    if (a3 != null) {
                        a3.a();
                    }
                } else if (i2 != 3) {
                    throw new m();
                }
            }
        }
    }

    public RateMerchantHelper(Context context, q qVar, String str, a aVar) {
        LiveData<net.one97.paytm.wallet.rateMerchant.a.a<MerchantPPReviewData>> a2;
        k.c(context, "context");
        k.c(qVar, "lifeCycleOwner");
        k.c(str, "mid");
        this.f71603b = context;
        this.f71604c = qVar;
        this.f71605d = str;
        this.f71606e = aVar;
        this.f71604c.getLifecycle().a(this);
        d.a aVar2 = d.f71644a;
        Context context2 = this.f71603b;
        b.a aVar3 = net.one97.paytm.wallet.rateMerchant.b.b.f71634b;
        net.one97.paytm.wallet.rateMerchant.b.b a3 = b.a.a(this.f71603b);
        a.C1456a aVar4 = net.one97.paytm.wallet.rateMerchant.b.a.f71628c;
        this.f71602a = d.a.a(context2, a3, a.C1456a.a(this.f71603b));
        c cVar = this.f71602a;
        if (cVar != null && (a2 = cVar.a(this.f71605d)) != null) {
            a2.observe(this.f71604c, new b(this));
        }
    }

    @aa(a = k.a.ON_STOP)
    public final void unregisterObserver() {
        this.f71606e = null;
        this.f71604c.getLifecycle().b(this);
    }

    public static final /* synthetic */ void a(RateMerchantHelper rateMerchantHelper, MerchantPPReviewData merchantPPReviewData) {
        a aVar;
        androidx.lifecycle.k lifecycle = rateMerchantHelper.f71604c.getLifecycle();
        kotlin.g.b.k.a((Object) lifecycle, "lifeCycleOwner.lifecycle");
        if (lifecycle.a().isAtLeast(k.b.RESUMED) && merchantPPReviewData.getContractId() != null && (aVar = rateMerchantHelper.f71606e) != null) {
            aVar.a(merchantPPReviewData);
        }
    }
}
