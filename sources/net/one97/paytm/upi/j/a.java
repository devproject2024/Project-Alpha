package net.one97.paytm.upi.j;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.y;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import kotlin.g.b.k;
import kotlin.o;
import kotlin.u;
import net.one97.paytm.common.entity.trainticket.CJRStoreFrontBanners;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.models.CustProductList;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.registration.b.a.a;

public final class a extends androidx.lifecycle.a implements a.C1347a {

    /* renamed from: a  reason: collision with root package name */
    public final net.one97.paytm.upi.registration.b.a.a f67008a;

    /* renamed from: b  reason: collision with root package name */
    public final net.one97.paytm.upi.profile.b.b.a f67009b;

    /* renamed from: c  reason: collision with root package name */
    public final y<List<AccountProviderBody.AccountProvider>> f67010c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    public final y<Boolean> f67011d = new y<>();

    /* renamed from: e  reason: collision with root package name */
    public final y<o<String, String>> f67012e = new y<>();

    public final void onServiceConnected() {
    }

    public final void onServiceDisconnected() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Application application) {
        super(application);
        k.c(application, "application");
        net.one97.paytm.upi.registration.b.a.b a2 = g.a(g.a((a.C1347a) this));
        k.a((Object) a2, "net.one97.paytm.upi.Inje…lication, this)\n        )");
        this.f67008a = a2;
        net.one97.paytm.upi.profile.b.b.a a3 = net.one97.paytm.upi.profile.b.b.a.a((Context) application);
        k.a((Object) a3, "UpiProfileRemoteDataSour….getInstance(application)");
        this.f67009b = a3;
    }

    public static final class b implements a.C1389a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f67013a;

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            k.c(upiCustomVolleyError, "error");
        }

        public b(a aVar) {
            this.f67013a = aVar;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            k.c(upiBaseDataModel, Payload.RESPONSE);
            if (upiBaseDataModel instanceof AccountProviderBody.AccountProviderDetails) {
                AccountProviderBody.AccountProviderDetails accountProviderDetails = (AccountProviderBody.AccountProviderDetails) upiBaseDataModel;
                if (accountProviderDetails.getProviders() != null && accountProviderDetails.getProviders().size() > 0) {
                    a aVar = this.f67013a;
                    List<AccountProviderBody.AccountProvider> topProviders = accountProviderDetails.getTopProviders();
                    k.a((Object) topProviders, "accountProviderDetails.topProviders");
                    aVar.f67010c.setValue(topProviders);
                }
            }
        }
    }

    public static final class c implements a.C1382a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f67014a;

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
        }

        public c(a aVar) {
            this.f67014a = aVar;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            if (upiBaseDataModel == null) {
                return;
            }
            if (upiBaseDataModel != null) {
                CustProductList custProductList = (CustProductList) upiBaseDataModel;
                if (!TextUtils.isEmpty(custProductList.getIsaStatus())) {
                    this.f67014a.f67011d.setValue(Boolean.valueOf(custProductList.getIsaStatus().equals(C1348a.ISSUED.name())));
                } else {
                    this.f67014a.f67011d.setValue(Boolean.FALSE);
                }
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.upi.common.models.CustProductList");
            }
        }
    }

    /* renamed from: net.one97.paytm.upi.j.a$a  reason: collision with other inner class name */
    public enum C1348a {
        DEFAULT(0),
        NOT_APPLIED(1),
        PROCESSING(2),
        ISSUED(3);
        
        private final int numVal;

        private C1348a(int i2) {
            this.numVal = i2;
        }

        public final int getNumVal() {
            return this.numVal;
        }
    }

    public static final class d implements a.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f67015a;

        public d(a aVar) {
            this.f67015a = aVar;
        }

        public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel instanceof CJRStoreFrontBanners) {
                try {
                    this.f67015a.f67012e.setValue(new o(((CJRStoreFrontBanners) iJRPaytmDataModel).getPage().get(0).getmBannerDetails().get(0).getmBannerItems().get(0).getmImageUrl(), ((CJRStoreFrontBanners) iJRPaytmDataModel).getPage().get(0).getmBannerDetails().get(0).getmBannerItems().get(0).getmUrl()));
                } catch (Exception e2) {
                    e2.printStackTrace();
                    this.f67015a.f67012e.setValue(null);
                }
            }
        }

        public final void a(UpiCustomVolleyError upiCustomVolleyError) {
            this.f67015a.f67012e.setValue(null);
        }
    }
}
