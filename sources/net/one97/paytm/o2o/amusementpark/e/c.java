package net.one97.paytm.o2o.amusementpark.e;

import android.content.Context;
import com.alipay.mobile.h5container.api.H5Param;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.common.entity.amPark.AmParkTravellerResponseModel;
import net.one97.paytm.common.entity.amPark.CJRParticularAmParkDescriptionModel;
import net.one97.paytm.common.entity.amPark.CJRSeatDetailsModel;
import net.one97.paytm.common.entity.amPark.CJRValidatePackage;
import net.one97.paytm.common.entity.shopping.CJROffers;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.o2o.amusementpark.a;
import net.one97.paytm.o2o.amusementpark.d.h;
import net.one97.paytm.o2o.amusementpark.d.j;
import net.one97.paytm.o2o.amusementpark.d.k;
import net.one97.paytm.o2o.amusementpark.utils.d;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionHistory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c implements b, h.a {

    /* renamed from: a  reason: collision with root package name */
    public Context f73619a;

    /* renamed from: b  reason: collision with root package name */
    public k f73620b;

    /* renamed from: c  reason: collision with root package name */
    public CJRParticularAmParkDescriptionModel f73621c;

    /* renamed from: d  reason: collision with root package name */
    public j f73622d;

    /* renamed from: e  reason: collision with root package name */
    private AmParkTravellerResponseModel f73623e;

    /* renamed from: f  reason: collision with root package name */
    private CJRValidatePackage f73624f;

    /* renamed from: g  reason: collision with root package name */
    private h.b f73625g;

    public static JSONArray a(List<CJRSeatDetailsModel> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (CJRSeatDetailsModel next : list) {
            if (next.getSelectedQuantity() > 0) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("seatId", next.getSeatId());
                jSONObject.put("seatType", next.getSeatType());
                jSONObject.put("count", next.getSelectedQuantity());
                jSONObject.put(RequestConfirmationDialogFragment.KEY_DESCRIPTION, next.getSeatDescription());
                jSONObject.put("pricePerSeat", next.getPrice());
                jSONObject.put("providerSeatId", next.getProviderSeatId());
                jSONObject.put("packageType", next.getmPackageType());
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray;
    }

    public final JSONObject b(List<CJRSeatDetailsModel> list) {
        if (list == null || list.size() == 0 || this.f73621c == null) {
            return null;
        }
        int i2 = 0;
        for (CJRSeatDetailsModel selectedQuantity : list) {
            i2 += selectedQuantity.getSelectedQuantity();
        }
        JSONObject jSONObject = new JSONObject();
        String a2 = d.a(this.f73621c.getmParkDateTimeList().get(0).getmTime().getmStart(), "hh:mm:ss", "h:mm a");
        try {
            jSONObject.put("providerId", this.f73621c.getProviderId());
            jSONObject.put("entId", this.f73621c.getId());
            jSONObject.put("ticketCount", i2);
            jSONObject.put("seatInfo", a(list));
            jSONObject.put("passenger", (Object) null);
            jSONObject.put(H5Param.PAGE, 1);
            jSONObject.put("startTime", a2);
            jSONObject.put("channel", "android");
            jSONObject.put("version", 2);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public final void a(h.b bVar) {
        this.f73625g = bVar;
    }

    public final void a(String str) {
        this.f73620b.a(CJRAutomaticSubscriptionHistory.PROCESSING);
        HashMap hashMap = new HashMap();
        hashMap.put("sso_token=".replace("=", ""), a.a().getSSOToken(this.f73619a));
        com.paytm.network.b bVar = new com.paytm.network.b();
        bVar.f42877a = this.f73619a;
        bVar.f42878b = a.c.AM_PARK;
        bVar.f42879c = a.C0715a.GET;
        bVar.f42880d = str;
        bVar.f42881e = null;
        bVar.f42882f = hashMap;
        bVar.f42883g = null;
        bVar.f42884h = null;
        bVar.f42885i = new CJROffers();
        bVar.j = this;
        bVar.n = a.b.USER_FACING;
        bVar.o = "AmPark";
        bVar.t = a();
        com.paytm.network.a l = bVar.l();
        l.f42859c = false;
        l.a();
    }

    public final void b(String str) {
        this.f73620b.b(str);
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        j jVar = this.f73622d;
        if (jVar != null) {
            jVar.i();
        }
        if (iJRPaytmDataModel instanceof AmParkTravellerResponseModel) {
            this.f73623e = (AmParkTravellerResponseModel) iJRPaytmDataModel;
            k kVar = this.f73620b;
            if (kVar != null) {
                kVar.c(this.f73623e);
            }
        }
        if (iJRPaytmDataModel instanceof CJRValidatePackage) {
            this.f73624f = (CJRValidatePackage) iJRPaytmDataModel;
            k kVar2 = this.f73620b;
            if (kVar2 != null) {
                kVar2.a(this.f73624f);
            }
        } else if (iJRPaytmDataModel instanceof CJROffers) {
            h.b bVar = this.f73625g;
            if (bVar != null) {
                bVar.b();
            }
            CJROffers cJROffers = (CJROffers) iJRPaytmDataModel;
            if (cJROffers != null && this.f73620b != null) {
                this.f73625g.a(cJROffers.getOfferCodes());
            }
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        j jVar = this.f73622d;
        if (jVar != null) {
            jVar.i();
        }
        h.b bVar = this.f73625g;
        if (bVar != null) {
            bVar.b();
        }
    }

    public static JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "AmParkSeatSelectionPresenter");
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
