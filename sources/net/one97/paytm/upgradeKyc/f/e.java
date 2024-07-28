package net.one97.paytm.upgradeKyc.f;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.upgradeKyc.FetchCashPointRequestModal;
import net.one97.paytm.common.entity.upgradeKyc.NearbyRequestCreator;
import net.one97.paytm.common.entity.upgradeKyc.PayTMPartnerListModal;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.upgradeKyc.helper.a;
import net.one97.paytm.upgradeKyc.helper.d;
import org.json.JSONObject;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    d f65984a;

    /* renamed from: b  reason: collision with root package name */
    private Context f65985b;

    /* renamed from: c  reason: collision with root package name */
    private Double f65986c;

    /* renamed from: d  reason: collision with root package name */
    private Double f65987d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<PayTMPartnerListModal.Response> f65988e = new ArrayList<>();

    public e(Context context, double d2, double d3, d dVar) {
        k.c(context, "context");
        k.c(dVar, "listener");
        this.f65984a = dVar;
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        this.f65985b = applicationContext;
        this.f65986c = Double.valueOf(d2);
        this.f65987d = Double.valueOf(d3);
    }

    public final void a() {
        if (b.c(this.f65985b)) {
            Double d2 = this.f65986c;
            if (d2 == null) {
                k.a();
            }
            double doubleValue = d2.doubleValue();
            Double d3 = this.f65987d;
            if (d3 == null) {
                k.a();
            }
            a(a(doubleValue, d3.doubleValue(), "SERVICE", FetchCashPointRequestModal.FilterType.KYC_POINT.toString()));
        }
    }

    private static FetchCashPointRequestModal a(double d2, double d3, String str, String str2) {
        FetchCashPointRequestModal fetchCashPointRequestModal = new FetchCashPointRequestModal();
        fetchCashPointRequestModal.request = new FetchCashPointRequestModal.Request();
        fetchCashPointRequestModal.request.searchFilter = new ArrayList(1);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(FetchCashPointRequestModal.SortByFilter.OPENING_TIME_SORT.toString(), FetchCashPointRequestModal.SortingType.ASC.toString());
        fetchCashPointRequestModal.request.sortBy = hashMap;
        fetchCashPointRequestModal.request.startLimit = 0;
        fetchCashPointRequestModal.request.endLimit = 20;
        FetchCashPointRequestModal.SearchFilter searchFilter = new FetchCashPointRequestModal.SearchFilter();
        searchFilter.filterType = str;
        searchFilter.value = str2;
        fetchCashPointRequestModal.request.searchFilter.add(0, searchFilter);
        FetchCashPointRequestModal.Request request = fetchCashPointRequestModal.request;
        request.latitude = String.valueOf(d2);
        FetchCashPointRequestModal.Request request2 = fetchCashPointRequestModal.request;
        request2.longitude = String.valueOf(d3);
        return fetchCashPointRequestModal;
    }

    private final void a(FetchCashPointRequestModal fetchCashPointRequestModal) {
        String str = null;
        try {
            d.a aVar = d.f66026a;
            if (d.a.a() != null) {
                d.a aVar2 = d.f66026a;
                if (d.a.a() == null) {
                    k.a();
                }
                str = d.a("nearbyMerchant");
            }
            if (str == null) {
                return;
            }
            if (URLUtil.isValidUrl(str)) {
                HashMap hashMap = new HashMap();
                hashMap.put("Content-Type", "application/json");
                String a2 = com.paytm.utility.d.a(this.f65985b);
                k.a((Object) a2, "CJRNetUtility.getSSOToken(mContext)");
                hashMap.put("ssotoken", a2);
                new StringBuilder("SSO Token :: ").append((String) hashMap.get("ssotoken"));
                b.j();
                JSONObject createNearByRequestBody = NearbyRequestCreator.getNearbyRequestCreatorInstance().createNearByRequestBody(fetchCashPointRequestModal);
                a.C1317a aVar3 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                com.paytm.network.a l = a.C1317a.a().a(this.f65985b).a(a.C0715a.POST).a((Map<String, String>) hashMap).a((IJRPaytmDataModel) new PayTMPartnerListModal()).b(createNearByRequestBody.toString()).a(str).c(e.class.getName()).a(a.b.USER_FACING).a((com.paytm.network.listener.b) new a(this)).l();
                if (b.c(this.f65985b)) {
                    d dVar = this.f65984a;
                    if (dVar != null) {
                        dVar.b();
                    }
                    l.a();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static final class a implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f65989a;

        a(e eVar) {
            this.f65989a = eVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            e.a(this.f65989a, iJRPaytmDataModel);
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            k.c(networkCustomError, "networkCustomError");
            d dVar = this.f65989a.f65984a;
            if (dVar != null) {
                dVar.a(networkCustomError);
            }
        }
    }

    public static final /* synthetic */ void a(e eVar, IJRPaytmDataModel iJRPaytmDataModel) {
        d dVar;
        d dVar2 = eVar.f65984a;
        if (dVar2 != null) {
            dVar2.a();
        }
        if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof PayTMPartnerListModal)) {
            e eVar2 = eVar;
            PayTMPartnerListModal payTMPartnerListModal = (PayTMPartnerListModal) iJRPaytmDataModel;
            if (!TextUtils.isEmpty(payTMPartnerListModal.status) && p.a(payTMPartnerListModal.status, "SUCCESS", true)) {
                ArrayList<PayTMPartnerListModal.Response> arrayList = eVar2.f65988e;
                if (arrayList != null) {
                    arrayList.addAll(payTMPartnerListModal.response);
                }
                ArrayList<PayTMPartnerListModal.Response> arrayList2 = eVar2.f65988e;
                if (arrayList2 != null) {
                    arrayList2.size();
                }
            } else if (!TextUtils.isEmpty(payTMPartnerListModal.status)) {
                p.a(payTMPartnerListModal.status, ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE, true);
            }
            ArrayList<PayTMPartnerListModal.Response> arrayList3 = eVar2.f65988e;
            if (arrayList3 != null && (dVar = eVar2.f65984a) != null) {
                if (arrayList3 == null) {
                    k.a();
                }
                dVar.a(arrayList3);
            }
        }
    }
}
