package com.travel.bus.busticket.g;

import android.text.TextUtils;
import com.alipay.mobile.h5container.api.H5ErrorCode;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.travel.bus.busticket.c.a;
import com.travel.bus.busticket.i.d;
import com.travel.bus.pojo.busticket.CJRBusReviewsRatingData;
import com.travel.bus.pojo.busticket.CJRBusSearchItem;
import com.travel.bus.pojo.busticket.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import org.json.JSONException;
import org.json.JSONObject;

public final class b implements com.paytm.network.listener.b {

    /* renamed from: a  reason: collision with root package name */
    public String f22355a;

    /* renamed from: b  reason: collision with root package name */
    public c f22356b;

    /* renamed from: c  reason: collision with root package name */
    public Boolean f22357c = Boolean.FALSE;

    /* renamed from: d  reason: collision with root package name */
    public CJRBusSearchItem f22358d;

    /* renamed from: e  reason: collision with root package name */
    private String f22359e = "CJRBusReviewFragmentPresenter";

    /* renamed from: f  reason: collision with root package name */
    private a.C0438a f22360f;

    /* renamed from: g  reason: collision with root package name */
    private String f22361g = "paytm_trip_id";

    /* renamed from: h  reason: collision with root package name */
    private String f22362h = "paytm_route_time_id";

    public b(a.C0438a aVar) {
        this.f22360f = aVar;
    }

    public final void a(int i2, CJRBusSearchItem cJRBusSearchItem) {
        if (cJRBusSearchItem != null) {
            com.travel.bus.a.a();
            String f2 = com.travel.bus.a.b().f("busV2Reviews");
            if (!TextUtils.isEmpty(f2)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    String tripId2 = cJRBusSearchItem.getTripId2();
                    boolean z = true;
                    if (cJRBusSearchItem.getRatingSource() != null) {
                        if (cJRBusSearchItem.getRatingSource().equalsIgnoreCase(this.f22361g)) {
                            tripId2 = cJRBusSearchItem.getTripId2();
                        } else if (cJRBusSearchItem.getRatingSource().equalsIgnoreCase(this.f22362h)) {
                            tripId2 = cJRBusSearchItem.getRouteTimeId();
                            z = false;
                        }
                    }
                    jSONObject.put("is_paytm_trip_id", z);
                    jSONObject.put("trip_id", tripId2);
                    jSONObject.put("page_start_offset", i2);
                    jSONObject.put("total_review_count", cJRBusSearchItem.getBusRating().getReview_count());
                } catch (JSONException e2) {
                    q.c(e2.getMessage());
                }
                HashMap hashMap = new HashMap();
                hashMap.put("Content-Type", "application/json");
                com.travel.bus.a.a();
                hashMap.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(com.travel.bus.a.b().D()));
                com.travel.bus.a.a();
                if (com.paytm.utility.b.c(com.travel.bus.a.b().D())) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(410);
                    arrayList.add(422);
                    arrayList.add(Integer.valueOf(H5ErrorCode.HTTP_SERVICE_UNAVAILABLE));
                    com.paytm.network.b bVar = new com.paytm.network.b();
                    com.travel.bus.a.a();
                    bVar.f42877a = com.travel.bus.a.b().D();
                    bVar.f42878b = a.c.BUS;
                    bVar.f42879c = a.C0715a.POST;
                    bVar.f42880d = f2;
                    bVar.f42884h = jSONObject.toString();
                    bVar.f42881e = null;
                    bVar.f42882f = hashMap;
                    bVar.f42883g = null;
                    bVar.f42885i = new CJRBusReviewsRatingData();
                    bVar.j = this;
                    bVar.t = a();
                    bVar.n = a.b.SILENT;
                    bVar.o = "bus-review-page";
                    bVar.l().a();
                    return;
                }
                this.f22360f.a();
            }
        }
    }

    private static JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "BusReviewScreen");
            if (d.a().f22430h != null) {
                jSONObject.put("requestId", d.a().f22430h);
            }
        } catch (JSONException e2) {
            q.c(e2.getMessage());
        }
        return jSONObject;
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.f22360f.a(i2, networkCustomError);
        this.f22360f.a(false);
    }

    public final void a(c cVar, CJRBusSearchItem cJRBusSearchItem, boolean z) {
        String str;
        if (z) {
            if (cVar != null && cJRBusSearchItem != null) {
                a(cVar, cJRBusSearchItem);
            }
        } else if (cVar != null && cJRBusSearchItem != null && (str = this.f22355a) != null && str.equals("ratings")) {
            a(cVar, cJRBusSearchItem);
        }
    }

    private void a(c cVar, CJRBusSearchItem cJRBusSearchItem) {
        int i2;
        String str;
        String str2;
        if (cJRBusSearchItem.getBusRating() != null) {
            str = String.valueOf(cJRBusSearchItem.getBusRating().getAvgRating());
            i2 = cJRBusSearchItem.getBusRating().getCount();
        } else {
            str = "0";
            i2 = 0;
        }
        String str3 = " ";
        if (cVar.f22805d != null) {
            for (int i3 = 0; i3 < cVar.f22805d.size(); i3++) {
                if (i3 == 0) {
                    str2 = str3 + cVar.f22805d.get(i3).f22807a;
                } else {
                    str2 = str3 + ";" + cVar.f22805d.get(i3).f22807a;
                }
                str3 = str2;
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put("event_action", "bus_search");
        hashMap.put("event_action", "reviews_displayed");
        hashMap.put("event_label", str + com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.AND_SIGN + i2 + com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.AND_SIGN + cVar.f22804c.f22792e + ";" + cVar.f22804c.f22791d + ";" + cVar.f22804c.f22790c + ";" + cVar.f22804c.f22789b + ";" + cVar.f22804c.f22788a + com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.AND_SIGN + str3 + com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.AND_SIGN + cJRBusSearchItem.getBusRating().getReview_count() + com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.AND_SIGN + this.f22355a);
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets-search");
        hashMap.put("vertical_name", "bus");
        com.travel.bus.a.a();
        hashMap.put("user_id", com.paytm.utility.b.n(com.travel.bus.a.b().D()));
        com.travel.bus.a.a();
        com.travel.g.a b2 = com.travel.bus.a.b();
        com.travel.bus.a.a();
        b2.a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, com.travel.bus.a.b().D());
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof CJRBusReviewsRatingData) {
            CJRBusReviewsRatingData cJRBusReviewsRatingData = (CJRBusReviewsRatingData) iJRPaytmDataModel;
            this.f22360f.a(false);
            this.f22360f.b(true);
            if (cJRBusReviewsRatingData == null || cJRBusReviewsRatingData.getBusReviewRatingBody() == null) {
                this.f22360f.a(true);
                this.f22360f.b(false);
            } else if (this.f22356b == null) {
                this.f22356b = cJRBusReviewsRatingData.getBusReviewRatingBody();
                this.f22360f.a(this.f22356b);
                a(this.f22356b, this.f22358d, false);
                this.f22357c = Boolean.TRUE;
            } else {
                c busReviewRatingBody = cJRBusReviewsRatingData.getBusReviewRatingBody();
                if (busReviewRatingBody != null && busReviewRatingBody.f22803b != null) {
                    this.f22356b.f22803b.addAll(busReviewRatingBody.f22803b);
                    this.f22360f.b(this.f22356b);
                }
            }
        }
    }
}
