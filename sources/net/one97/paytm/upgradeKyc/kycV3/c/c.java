package net.one97.paytm.upgradeKyc.kycV3.c;

import android.app.Application;
import android.webkit.URLUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ah;
import androidx.lifecycle.y;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.upgradeKyc.FetchCashPointRequestModal;
import net.one97.paytm.common.entity.upgradeKyc.NearbyRequestCreator;
import net.one97.paytm.common.entity.upgradeKyc.PayTMPartnerListModal;
import net.one97.paytm.upgradeKyc.activity.KycVisitActivity;
import net.one97.paytm.upgradeKyc.helper.a;
import net.one97.paytm.upgradeKyc.helper.d;
import net.one97.paytm.upgradeKyc.kycV3.b.b;
import net.one97.paytm.upgradeKyc.kycV3.b.c;
import org.json.JSONObject;

public final class c extends androidx.lifecycle.a {

    /* renamed from: a  reason: collision with root package name */
    public final y<net.one97.paytm.upgradeKyc.kycV3.b.b<IJRPaytmDataModel>> f66213a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public final LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<PayTMPartnerListModal>> f66214b;

    /* renamed from: c  reason: collision with root package name */
    public final net.one97.paytm.upgradeKyc.kycV3.b.c f66215c;

    /* renamed from: d  reason: collision with root package name */
    private final y<a> f66216d = new y<>();

    /* renamed from: e  reason: collision with root package name */
    private final Application f66217e;

    static final class b<I, O> implements androidx.arch.core.c.a<X, LiveData<Y>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f66220a;

        b(c cVar) {
            this.f66220a = cVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            String str;
            a aVar = (a) obj;
            net.one97.paytm.upgradeKyc.kycV3.b.c a2 = this.f66220a.f66215c;
            k.a((Object) aVar, "it");
            k.c(aVar, "loc");
            double parseDouble = Double.parseDouble(aVar.f66218a);
            double parseDouble2 = Double.parseDouble(aVar.f66219b);
            String filterType = FetchCashPointRequestModal.FilterType.KYC_POINT.toString();
            FetchCashPointRequestModal fetchCashPointRequestModal = new FetchCashPointRequestModal();
            fetchCashPointRequestModal.request = new FetchCashPointRequestModal.Request();
            fetchCashPointRequestModal.request.searchFilter = new ArrayList(1);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(FetchCashPointRequestModal.SortByFilter.OPENING_TIME_SORT.toString(), FetchCashPointRequestModal.SortingType.ASC.toString());
            fetchCashPointRequestModal.request.sortBy = hashMap;
            fetchCashPointRequestModal.request.startLimit = 0;
            fetchCashPointRequestModal.request.endLimit = 20;
            FetchCashPointRequestModal.SearchFilter searchFilter = new FetchCashPointRequestModal.SearchFilter();
            searchFilter.filterType = "SERVICE";
            searchFilter.value = filterType;
            fetchCashPointRequestModal.request.searchFilter.add(0, searchFilter);
            FetchCashPointRequestModal.Request request = fetchCashPointRequestModal.request;
            request.latitude = String.valueOf(parseDouble);
            FetchCashPointRequestModal.Request request2 = fetchCashPointRequestModal.request;
            request2.longitude = String.valueOf(parseDouble2);
            y yVar = new y();
            b.a aVar2 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
            yVar.setValue(b.a.a());
            d.a aVar3 = d.f66026a;
            if (d.a.a() != null) {
                d.a aVar4 = d.f66026a;
                if (d.a.a() == null) {
                    k.a();
                }
                str = d.a("nearbyMerchantKycFlow");
            } else {
                str = null;
            }
            if (str == null || !URLUtil.isValidUrl(str)) {
                b.a aVar5 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
                yVar.setValue(b.a.a(a2.a()));
            }
            if (com.paytm.utility.d.a(a2.f66175b) == null) {
                b.a aVar6 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
                yVar.setValue(b.a.a(a2.b()));
            } else {
                HashMap hashMap2 = new HashMap();
                Map map = hashMap2;
                map.put("Content-Type", "application/json");
                String a3 = com.paytm.utility.d.a(a2.f66175b);
                k.a((Object) a3, "CJRNetUtility.getSSOToken(appContext)");
                map.put("ssotoken", a3);
                new StringBuilder("SSO Token :: ").append((String) hashMap2.get("ssotoken"));
                com.paytm.utility.b.j();
                JSONObject createNearByRequestBody = NearbyRequestCreator.getNearbyRequestCreatorInstance().createNearByRequestBody(fetchCashPointRequestModal);
                a.C1317a aVar7 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                com.paytm.network.a l = a.C1317a.a().a(a2.f66175b).a(a.C0715a.POST).a((Map<String, String>) map).a((IJRPaytmDataModel) new PayTMPartnerListModal()).b(createNearByRequestBody.toString()).c(KycVisitActivity.class.getName()).a(str).a(a.c.KYC).a(a.b.USER_FACING).a((com.paytm.network.listener.b) new c.o(yVar)).l();
                if (com.paytm.utility.b.c(a2.f66175b)) {
                    l.a();
                } else {
                    b.a aVar8 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
                    yVar.setValue(b.a.a(a2.c()));
                }
            }
            return ah.a(yVar, new androidx.arch.core.c.a<X, Y>(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ b f66221a;

                {
                    this.f66221a = r1;
                }

                public final /* synthetic */ Object apply(Object obj) {
                    net.one97.paytm.upgradeKyc.kycV3.b.b bVar = (net.one97.paytm.upgradeKyc.kycV3.b.b) obj;
                    k.a((Object) bVar, "it");
                    return c.a(bVar);
                }
            });
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Application application, net.one97.paytm.upgradeKyc.kycV3.b.c cVar) {
        super(application);
        k.c(application, AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        k.c(cVar, "kycRepository");
        this.f66217e = application;
        this.f66215c = cVar;
        LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<PayTMPartnerListModal>> b2 = ah.b(this.f66216d, new b(this));
        k.a((Object) b2, "Transformations.switchMa… mapToUiModel(it) }\n    }");
        this.f66214b = b2;
    }

    public final void a(a aVar) {
        k.c(aVar, "location");
        this.f66216d.setValue(aVar);
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f66218a;

        /* renamed from: b  reason: collision with root package name */
        public final String f66219b;

        public /* synthetic */ a() {
            this("0.0d", "0.0d");
        }

        public a(String str, String str2) {
            k.c(str, "lat");
            k.c(str2, "long");
            this.f66218a = str;
            this.f66219b = str2;
        }
    }

    public static final /* synthetic */ net.one97.paytm.upgradeKyc.kycV3.b.b a(net.one97.paytm.upgradeKyc.kycV3.b.b bVar) {
        ArrayList<PayTMPartnerListModal.Response> arrayList;
        int i2 = d.f66222a[bVar.f66168a.ordinal()];
        if (i2 == 1) {
            PayTMPartnerListModal payTMPartnerListModal = (PayTMPartnerListModal) bVar.f66169b;
            if (!(payTMPartnerListModal == null || (arrayList = payTMPartnerListModal.response) == null || !(!arrayList.isEmpty()))) {
                b.a aVar = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
                ResultType resulttype = bVar.f66169b;
                if (resulttype == null) {
                    k.a();
                }
                return b.a.a(resulttype);
            }
        } else if (i2 == 2) {
            b.a aVar2 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
            return b.a.a();
        } else if (i2 == 3) {
            b.a aVar3 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
            return b.a.a(bVar.f66170c);
        }
        b.a aVar4 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
        ResultType resulttype2 = bVar.f66169b;
        if (resulttype2 == null) {
            k.a();
        }
        return b.a.a(resulttype2);
    }
}
