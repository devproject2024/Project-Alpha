package net.one97.paytm.hotel4.service.a;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import androidx.lifecycle.y;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.google.gson.f;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.travel.utils.l;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.hotel4.service.model.ErrorData;
import net.one97.paytm.hotel4.service.model.GSTDetails;
import net.one97.paytm.hotel4.service.model.UserDetails;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem;
import net.one97.paytm.hotel4.service.model.details.CJRRoom;
import net.one97.paytm.hotel4.service.model.details.CancellationPolicy;
import net.one97.paytm.hotel4.service.model.details.Otas;
import net.one97.paytm.hotel4.service.model.details.PriceData;
import net.one97.paytm.hotel4.service.model.details.SubRoomOptions;
import net.one97.paytm.hotel4.service.model.details.SubRoomProvider;
import net.one97.paytm.hotel4.service.model.promocode.PromoCodeApply;
import net.one97.paytm.hotel4.service.model.promocode.PromocodeDataItem;
import net.one97.paytm.hotels2.entity.CJRHotelSearchInput;
import net.one97.paytm.hotels2.utils.c;
import net.one97.paytm.nativesdk.orflow.Utility;
import org.json.JSONObject;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public SRPDataItem f28614a;

    /* renamed from: b  reason: collision with root package name */
    public SubRoomOptions f28615b;

    /* renamed from: c  reason: collision with root package name */
    public CJRHotelSearchInput f28616c;

    /* renamed from: d  reason: collision with root package name */
    public PromocodeDataItem f28617d;

    /* renamed from: e  reason: collision with root package name */
    public UserDetails f28618e;

    /* renamed from: f  reason: collision with root package name */
    public GSTDetails f28619f;

    /* renamed from: g  reason: collision with root package name */
    public y<PromoCodeApply> f28620g;

    /* renamed from: h  reason: collision with root package name */
    public y<ErrorData> f28621h;

    /* renamed from: i  reason: collision with root package name */
    public y<CJRRechargePayment> f28622i;
    public y<CancellationPolicy> j;
    public l<Boolean> k;
    public y<ErrorData> l;
    public final Application m;
    private String n = "";
    private String o = "";
    private final Context p;

    public e(Application application, Context context) {
        k.c(application, AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        k.c(context, "context");
        this.m = application;
        this.p = context;
    }

    public final y<CancellationPolicy> a() {
        y<CancellationPolicy> yVar = this.j;
        if (yVar == null) {
            k.a("successCancellationListener");
        }
        return yVar;
    }

    public final l<Boolean> b() {
        l<Boolean> lVar = this.k;
        if (lVar == null) {
            k.a("successWalletTokenListener");
        }
        return lVar;
    }

    public final void a(String str) {
        k.c(str, "<set-?>");
        this.n = str;
    }

    public final JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        CJRHotelSearchInput cJRHotelSearchInput = this.f28616c;
        if (cJRHotelSearchInput == null) {
            k.a();
        }
        jSONObject.put("check_in_date", cJRHotelSearchInput.getCheckInDate());
        CJRHotelSearchInput cJRHotelSearchInput2 = this.f28616c;
        if (cJRHotelSearchInput2 == null) {
            k.a();
        }
        jSONObject.put("check_out_date", cJRHotelSearchInput2.getCheckOutDate());
        CJRHotelSearchInput cJRHotelSearchInput3 = this.f28616c;
        if (cJRHotelSearchInput3 == null) {
            k.a();
        }
        jSONObject.put("city", cJRHotelSearchInput3.getCity());
        if (this.f28618e != null) {
            jSONObject.put("customer_details", new f().b(this.f28618e));
        }
        SRPDataItem sRPDataItem = this.f28614a;
        ArrayList<CJRRoom> arrayList = null;
        jSONObject.put("hotel_id", sRPDataItem != null ? sRPDataItem.getPaytmId() : null);
        CJRHotelSearchInput cJRHotelSearchInput4 = this.f28616c;
        if (cJRHotelSearchInput4 == null) {
            k.a();
        }
        jSONObject.put("num_adults", cJRHotelSearchInput4.getAdultCount());
        CJRHotelSearchInput cJRHotelSearchInput5 = this.f28616c;
        if (cJRHotelSearchInput5 == null) {
            k.a();
        }
        jSONObject.put("num_children", cJRHotelSearchInput5.getChildCount());
        CJRHotelSearchInput cJRHotelSearchInput6 = this.f28616c;
        if (cJRHotelSearchInput6 == null) {
            k.a();
        }
        ArrayList<CJRRoom> rooms = cJRHotelSearchInput6.getRooms();
        if (rooms == null) {
            k.a();
        }
        jSONObject.put("num_rooms", rooms.size());
        SubRoomOptions subRoomOptions = this.f28615b;
        List<SubRoomProvider> subRoomProviders = subRoomOptions != null ? subRoomOptions.getSubRoomProviders() : null;
        if (subRoomProviders == null) {
            k.a();
        }
        Otas ota = subRoomProviders.get(0).getOta();
        if (ota == null) {
            k.a();
        }
        jSONObject.put("ota", ota.getName());
        SubRoomOptions subRoomOptions2 = this.f28615b;
        if (subRoomOptions2 == null) {
            k.a();
        }
        List<SubRoomProvider> subRoomProviders2 = subRoomOptions2.getSubRoomProviders();
        if (subRoomProviders2 == null) {
            k.a();
        }
        jSONObject.put("ota_data", String.valueOf(subRoomProviders2.get(0).getBookParams()));
        SubRoomOptions subRoomOptions3 = this.f28615b;
        List<SubRoomProvider> subRoomProviders3 = subRoomOptions3 != null ? subRoomOptions3.getSubRoomProviders() : null;
        if (subRoomProviders3 == null) {
            k.a();
        }
        PriceData priceData = subRoomProviders3.get(0).getPriceData();
        if (priceData == null) {
            k.a();
        }
        jSONObject.put("price", priceData.getTotalPriceWithTax());
        SubRoomOptions subRoomOptions4 = this.f28615b;
        List<SubRoomProvider> subRoomProviders4 = subRoomOptions4 != null ? subRoomOptions4.getSubRoomProviders() : null;
        if (subRoomProviders4 == null) {
            k.a();
        }
        PriceData priceData2 = subRoomProviders4.get(0).getPriceData();
        if (priceData2 == null) {
            k.a();
        }
        jSONObject.put("basePrice", priceData2.getTotalPrice());
        PromocodeDataItem promocodeDataItem = this.f28617d;
        if (promocodeDataItem != null) {
            if (promocodeDataItem == null) {
                k.a();
            }
            jSONObject.put(Utility.EVENT_CATEGORY_PROMOCODE, promocodeDataItem.getCode());
        }
        GSTDetails gSTDetails = this.f28619f;
        if (gSTDetails != null) {
            if (gSTDetails == null) {
                k.a();
            }
            if (gSTDetails.getGstin() != null) {
                jSONObject.put("gst_details", new f().b(this.f28619f));
            }
        }
        f fVar = new f();
        CJRHotelSearchInput cJRHotelSearchInput7 = this.f28616c;
        if (cJRHotelSearchInput7 != null) {
            arrayList = cJRHotelSearchInput7.getRooms();
        }
        jSONObject.put("rooms_details", fVar.b(arrayList));
        jSONObject.put(AppConstants.SSO_TOKEN, d());
        jSONObject.put("wallet_token", this.n);
        return jSONObject;
    }

    public final class a implements b {
        public a() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:28:0x0075  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0086  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onApiSuccess(com.paytm.network.model.IJRPaytmDataModel r5) {
            /*
                r4 = this;
                java.lang.String r0 = ""
                boolean r1 = r5 instanceof net.one97.paytm.hotel4.service.model.promocode.PromoCodeApply
                r2 = 0
                if (r1 == 0) goto L_0x002a
                net.one97.paytm.hotel4.service.a.e r0 = net.one97.paytm.hotel4.service.a.e.this
                androidx.lifecycle.y<net.one97.paytm.hotel4.service.model.promocode.PromoCodeApply> r0 = r0.f28620g
                if (r0 != 0) goto L_0x0013
                java.lang.String r3 = "successCheckPromoListener"
                kotlin.g.b.k.a((java.lang.String) r3)
            L_0x0013:
                if (r1 != 0) goto L_0x0016
                goto L_0x0017
            L_0x0016:
                r2 = r5
            L_0x0017:
                net.one97.paytm.hotel4.service.model.promocode.PromoCodeApply r2 = (net.one97.paytm.hotel4.service.model.promocode.PromoCodeApply) r2
                r0.postValue(r2)
                java.lang.String r5 = java.lang.String.valueOf(r5)
                java.lang.String r0 = "Check Promo Response>>>>>>"
                java.lang.String r5 = r0.concat(r5)
                com.paytm.utility.q.a(r5)
                return
            L_0x002a:
                boolean r1 = r5 instanceof net.one97.paytm.common.entity.recharge.CJRRechargePayment
                if (r1 == 0) goto L_0x0051
                net.one97.paytm.hotel4.service.a.e r0 = net.one97.paytm.hotel4.service.a.e.this
                androidx.lifecycle.y<net.one97.paytm.common.entity.recharge.CJRRechargePayment> r0 = r0.f28622i
                if (r0 != 0) goto L_0x003a
                java.lang.String r3 = "successProcessPayListener"
                kotlin.g.b.k.a((java.lang.String) r3)
            L_0x003a:
                if (r1 != 0) goto L_0x003d
                goto L_0x003e
            L_0x003d:
                r2 = r5
            L_0x003e:
                net.one97.paytm.common.entity.recharge.CJRRechargePayment r2 = (net.one97.paytm.common.entity.recharge.CJRRechargePayment) r2
                r0.postValue(r2)
                java.lang.String r5 = java.lang.String.valueOf(r5)
                java.lang.String r0 = "Process To Pay Response>>>>>>"
                java.lang.String r5 = r0.concat(r5)
                com.paytm.utility.q.a(r5)
                return
            L_0x0051:
                boolean r1 = r5 instanceof net.one97.paytm.common.entity.CJRPGTokenList
                if (r1 == 0) goto L_0x0097
                net.one97.paytm.hotels2.utils.d r1 = net.one97.paytm.hotels2.utils.c.b()     // Catch:{ Exception -> 0x006b }
                if (r1 == 0) goto L_0x006b
                net.one97.paytm.hotels2.utils.d r1 = net.one97.paytm.hotels2.utils.c.b()     // Catch:{ Exception -> 0x006b }
                net.one97.paytm.common.entity.CJRPGTokenList r5 = (net.one97.paytm.common.entity.CJRPGTokenList) r5     // Catch:{ Exception -> 0x006b }
                java.lang.String r5 = r1.a((net.one97.paytm.common.entity.CJRPGTokenList) r5)     // Catch:{ Exception -> 0x006b }
                java.lang.String r1 = "HotelController.getHotel…er().getPgToken(response)"
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r1)     // Catch:{ Exception -> 0x006b }
                goto L_0x006c
            L_0x006b:
                r5 = r0
            L_0x006c:
                r1 = r5
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                if (r1 == 0) goto L_0x0086
                net.one97.paytm.hotel4.service.a.e r5 = net.one97.paytm.hotel4.service.a.e.this
                r5.a(r0)
                net.one97.paytm.hotel4.service.a.e r5 = net.one97.paytm.hotel4.service.a.e.this
                com.travel.utils.l r5 = r5.b()
                java.lang.Boolean r0 = java.lang.Boolean.FALSE
                r5.setValue(r0)
                return
            L_0x0086:
                net.one97.paytm.hotel4.service.a.e r0 = net.one97.paytm.hotel4.service.a.e.this
                r0.a(r5)
                net.one97.paytm.hotel4.service.a.e r5 = net.one97.paytm.hotel4.service.a.e.this
                com.travel.utils.l r5 = r5.b()
                java.lang.Boolean r0 = java.lang.Boolean.TRUE
                r5.setValue(r0)
                return
            L_0x0097:
                boolean r0 = r5 instanceof net.one97.paytm.hotel4.service.model.details.CancellationPolicy
                if (r0 == 0) goto L_0x00aa
                net.one97.paytm.hotel4.service.a.e r1 = net.one97.paytm.hotel4.service.a.e.this
                androidx.lifecycle.y r1 = r1.a()
                if (r0 != 0) goto L_0x00a4
                r5 = r2
            L_0x00a4:
                net.one97.paytm.hotel4.service.model.details.CancellationPolicy r5 = (net.one97.paytm.hotel4.service.model.details.CancellationPolicy) r5
                r1.postValue(r5)
                return
            L_0x00aa:
                boolean r0 = r5 instanceof net.one97.paytm.hotel4.service.model.details.ReviewBookingEvent
                if (r0 == 0) goto L_0x00bb
                java.lang.String r5 = java.lang.String.valueOf(r5)
                java.lang.String r0 = "ReviewBookingEvent success>>>>>>"
                java.lang.String r5 = r0.concat(r5)
                com.paytm.utility.q.a(r5)
            L_0x00bb:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.service.a.e.a.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void");
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            ErrorData errorData = new ErrorData(networkCustomError != null ? Integer.valueOf(networkCustomError.getStatusCode()) : null, networkCustomError != null ? networkCustomError.getAlertTitle() : null, networkCustomError != null ? networkCustomError.getAlertMessage() : null);
            if (iJRPaytmDataModel instanceof PromoCodeApply) {
                y<ErrorData> yVar = e.this.f28621h;
                if (yVar == null) {
                    k.a("failureCheckPromoListener");
                }
                yVar.postValue(errorData);
            } else if (iJRPaytmDataModel instanceof CJRRechargePayment) {
                y<ErrorData> yVar2 = e.this.l;
                if (yVar2 == null) {
                    k.a("failureListener");
                }
                yVar2.postValue(errorData);
            } else if (iJRPaytmDataModel instanceof CJRPGTokenList) {
                e.this.b().setValue(Boolean.FALSE);
            } else if (iJRPaytmDataModel instanceof CancellationPolicy) {
                e.this.a().postValue(null);
            }
        }
    }

    public final void a(l<Boolean> lVar, Activity activity) {
        k.c(lVar, "liveData");
        this.k = lVar;
        c.b().a(activity, (b) new a());
    }

    public final String d() {
        String a2 = c.b().a((Context) this.m);
        if (a2 == null) {
            this.o = "";
        } else {
            this.o = a2;
        }
        return this.o;
    }
}
