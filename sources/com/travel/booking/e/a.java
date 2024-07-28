package com.travel.booking.e;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ag;
import androidx.lifecycle.y;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.paytm.network.model.NetworkCustomError;
import com.travel.booking.datamodel.BookingInfo;
import com.travel.booking.datamodel.CJRTravelBookingData;
import com.travel.booking.datamodel.CityBusBookingInfo;
import com.travel.booking.datamodel.NetworkErrorLiveDataModel;
import com.travel.booking.model.CJRTravelBookingModel;
import com.travel.d;
import java.util.List;
import kotlin.a.w;
import kotlin.g.b.k;
import kotlin.u;
import kotlin.x;

public final class a extends androidx.lifecycle.a implements CJRTravelBookingModel.IBookingDataListener {

    /* renamed from: c  reason: collision with root package name */
    public static final C0427a f21487c = new C0427a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public final y<NetworkErrorLiveDataModel> f21488a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public final y<x> f21489b = new ag();

    /* renamed from: d  reason: collision with root package name */
    private final y<Boolean> f21490d = new y<>();

    /* renamed from: e  reason: collision with root package name */
    private final y<Boolean> f21491e = new y<>();

    /* renamed from: f  reason: collision with root package name */
    private final LiveData<Boolean> f21492f = this.f21491e;

    /* renamed from: g  reason: collision with root package name */
    private final y<List<CJRTravelBookingData>> f21493g = new y<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Application application) {
        super(application);
        k.c(application, AppManagerUtil.EXTEND_PREFIX_DEFAULT);
    }

    public final LiveData<Boolean> a() {
        y<Boolean> yVar = this.f21490d;
        if (yVar != null) {
            return yVar;
        }
        throw new u("null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Boolean>");
    }

    public final LiveData<List<CJRTravelBookingData>> b() {
        y<List<CJRTravelBookingData>> yVar = this.f21493g;
        if (yVar != null) {
            return yVar;
        }
        throw new u("null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.collections.List<com.travel.booking.datamodel.CJRTravelBookingData>>");
    }

    public final void a(Context context, boolean z) {
        k.c(context, "baseContext");
        Boolean value = this.f21490d.getValue();
        if (value == null) {
            value = Boolean.FALSE;
        }
        if (!value.booleanValue() || z) {
            this.f21490d.postValue(Boolean.FALSE);
            CJRTravelBookingModel.Companion.fetchBookingData(context, this);
        }
    }

    public final void onDataFetch(List<CJRTravelBookingData> list) {
        k.c(list, "bookingList");
        this.f21490d.postValue(Boolean.TRUE);
        a(true);
        this.f21493g.setValue(list);
    }

    private void a(boolean z) {
        this.f21491e.postValue(Boolean.valueOf(z));
    }

    public final void onNetworkError() {
        this.f21490d.postValue(Boolean.TRUE);
        this.f21493g.setValue(w.INSTANCE);
    }

    public final void onApiError(int i2, NetworkCustomError networkCustomError) {
        this.f21490d.postValue(Boolean.TRUE);
        this.f21493g.setValue(w.INSTANCE);
        this.f21488a.postValue(new NetworkErrorLiveDataModel(i2, networkCustomError));
        a(false);
    }

    public final void a(BookingInfo bookingInfo) {
        String str;
        String str2 = null;
        if (bookingInfo != null) {
            str = bookingInfo.getVertical();
        } else {
            str = null;
        }
        if (str != null) {
            switch (str.hashCode()) {
                case -1211468481:
                    if (str.equals("hotels")) {
                        String orderId = bookingInfo.getOrderId();
                        d.a();
                        d.a(getApplication(), "paytmmp://hotel_order_summary_v2?url=https://cart.paytm.com/v1/myOrders/" + orderId + "&order-summary-type=hotel&order_id=" + orderId + "&From=Order_history");
                        return;
                    }
                    return;
                case -865710229:
                    if (str.equals("trains")) {
                        String orderId2 = bookingInfo.getOrderId();
                        d.a();
                        d.a(getApplication(), "paytmmp://train_order_summary_v2?url=https://cart.paytm.com/v1/myOrders/" + orderId2 + "&order-summary-type=train&order_id=" + orderId2 + "&From=Order_history");
                        return;
                    }
                    return;
                case -771814909:
                    if (str.equals("flights")) {
                        String orderId3 = bookingInfo.getOrderId();
                        d.a();
                        d.a(getApplication(), "paytmmp://flight_order_summary?url=https://cart.paytm.com/v1/myOrders/" + orderId3 + "&order-summary-type=flight&order_id=" + orderId3 + "&From=Order_history");
                        return;
                    }
                    return;
                case 97920:
                    if (str.equals("bus")) {
                        String orderId4 = bookingInfo.getOrderId();
                        d.a();
                        d.a(getApplication(), "paytmmp://bus_order_summary?url=https://cart.paytm.com/v1/myOrders/" + orderId4 + "&order-summary-type=bus&order_id=" + orderId4 + "&From=Order_history");
                        return;
                    }
                    return;
                case 785443125:
                    if (str.equals("citybus")) {
                        CityBusBookingInfo cityBusBookingInfo = bookingInfo.getCityBusBookingInfo();
                        if (cityBusBookingInfo != null) {
                            str2 = cityBusBookingInfo.getTokenId();
                        }
                        d.a();
                        d.a(getApplication(), "paytmmp://citybus_mumbai_order_summary?url=https://cart.paytm.com/v1/myOrders/" + str2 + "&order-summary-type=citybus&order_id=" + str2 + "&From=Order_history");
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.travel.booking.e.a$a  reason: collision with other inner class name */
    public static final class C0427a {
        private C0427a() {
        }

        public /* synthetic */ C0427a(byte b2) {
            this();
        }
    }

    public static final void a(LottieAnimationView lottieAnimationView, LiveData<Boolean> liveData) {
        k.c(lottieAnimationView, "animationView");
        if (liveData == null || liveData.getValue() == null || !k.a((Object) liveData.getValue(), (Object) Boolean.TRUE)) {
            lottieAnimationView.setVisibility(0);
            net.one97.paytm.common.widgets.a.a(lottieAnimationView);
            return;
        }
        lottieAnimationView.setVisibility(8);
        net.one97.paytm.common.widgets.a.b(lottieAnimationView);
    }
}
