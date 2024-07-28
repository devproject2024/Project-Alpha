package net.one97.paytm.hotel4.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.b;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.hotel4.service.a.c;
import net.one97.paytm.hotel4.service.model.ErrorData;
import net.one97.paytm.hotel4.service.model.details.Address;
import net.one97.paytm.hotel4.service.model.ordersummary.CancelOrderModel;
import net.one97.paytm.hotel4.service.model.ordersummary.CancelRefundData;
import net.one97.paytm.hotel4.service.model.ordersummary.MetaData;
import net.one97.paytm.hotel4.utils.d;
import net.one97.paytm.hotel4.utils.e;
import net.one97.paytm.hotel4.view.ui.activity.AJRHotelOrderSummaryActivity;
import org.json.JSONObject;

public final class CancelOrderViewModel extends ai {
    private final y<ErrorData> cancelBookingError = new y<>();
    private final y<CancelOrderModel> cancelBookingResponse = new y<>();
    private y<Boolean> cancelButtonClick = new y<>();
    private final y<ErrorData> cancelRefundError = new y<>();
    private final y<CancelOrderModel> cancelRefundResponse = new y<>();
    private y<Boolean> cancellationPolicy = new y<>();
    private y<Boolean> closeCancelBookinScreen = new y<>();
    private y<Boolean> closePaymentDetails = new y<>();
    private final y<MetaData> metaData = new y<>();
    private String orderId = "";
    private CancelRefundData refundDetails;
    private String requestId = "";
    private y<Integer> selectedCancelReason = new y<>();

    public CancelOrderViewModel() {
        this.selectedCancelReason.setValue(0);
    }

    public final y<MetaData> getMetaData() {
        return this.metaData;
    }

    public final y<ErrorData> getCancelRefundError() {
        return this.cancelRefundError;
    }

    public final y<CancelOrderModel> getCancelRefundResponse() {
        return this.cancelRefundResponse;
    }

    public final y<ErrorData> getCancelBookingError() {
        return this.cancelBookingError;
    }

    public final y<CancelOrderModel> getCancelBookingResponse() {
        return this.cancelBookingResponse;
    }

    public final CancelRefundData getRefundDetails() {
        return this.refundDetails;
    }

    public final void setRefundDetails(CancelRefundData cancelRefundData) {
        this.refundDetails = cancelRefundData;
    }

    public final y<Boolean> getCancelButtonClick() {
        return this.cancelButtonClick;
    }

    public final void setCancelButtonClick(y<Boolean> yVar) {
        k.c(yVar, "<set-?>");
        this.cancelButtonClick = yVar;
    }

    public final y<Boolean> getCancellationPolicy() {
        return this.cancellationPolicy;
    }

    public final void setCancellationPolicy(y<Boolean> yVar) {
        k.c(yVar, "<set-?>");
        this.cancellationPolicy = yVar;
    }

    public final y<Boolean> getCloseCancelBookinScreen() {
        return this.closeCancelBookinScreen;
    }

    public final void setCloseCancelBookinScreen(y<Boolean> yVar) {
        k.c(yVar, "<set-?>");
        this.closeCancelBookinScreen = yVar;
    }

    public final y<Integer> getSelectedCancelReason() {
        return this.selectedCancelReason;
    }

    public final void setSelectedCancelReason(y<Integer> yVar) {
        k.c(yVar, "<set-?>");
        this.selectedCancelReason = yVar;
    }

    public final y<Boolean> getClosePaymentDetails() {
        return this.closePaymentDetails;
    }

    public final void setClosePaymentDetails(y<Boolean> yVar) {
        k.c(yVar, "<set-?>");
        this.closePaymentDetails = yVar;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final void setOrderId(String str) {
        k.c(str, "<set-?>");
        this.orderId = str;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final void setRequestId(String str) {
        k.c(str, "<set-?>");
        this.requestId = str;
    }

    public final String getHotelAddress() {
        MetaData value = this.metaData.getValue();
        if (value == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Address address = value.address;
        if (address == null) {
            k.a();
        }
        sb.append(address.getStreetAddress());
        sb.append(" - ");
        sb.append(value.address.getLocality());
        sb.append(" - ");
        sb.append(value.address.getCity());
        sb.append(" - ");
        sb.append(value.address.getZip());
        return sb.toString();
    }

    public final void getDataFromIntent(Intent intent) {
        k.c(intent, "data");
        if (intent.hasExtra("metaData")) {
            y<MetaData> yVar = this.metaData;
            Serializable serializableExtra = intent.getSerializableExtra("metaData");
            if (serializableExtra != null) {
                yVar.setValue((MetaData) serializableExtra);
                String stringExtra = intent.getStringExtra("orderid");
                k.a((Object) stringExtra, "data.getStringExtra(\"orderid\")");
                this.orderId = stringExtra;
                String stringExtra2 = intent.getStringExtra("requestId");
                k.a((Object) stringExtra2, "data.getStringExtra(\"requestId\")");
                this.requestId = stringExtra2;
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.hotel4.service.model.ordersummary.MetaData");
        }
    }

    public final String getNightText() {
        MetaData value = this.metaData.getValue();
        if (value == null) {
            return "";
        }
        e eVar = e.f28642a;
        return e.a("Night", "", value.numNights);
    }

    public final void getCancelRefundDetails(Context context) {
        net.one97.paytm.hotels2.utils.e.a();
        Uri.Builder buildUpon = Uri.parse(net.one97.paytm.hotels2.utils.e.a("hotel_cancel_refund_url", "")).buildUpon();
        buildUpon.appendQueryParameter("order_id", this.orderId);
        buildUpon.appendQueryParameter("request_id", this.requestId);
        if (context != null) {
            c cVar = new c(context);
            String uri = buildUpon.build().toString();
            y<CancelOrderModel> yVar = this.cancelRefundResponse;
            y<ErrorData> yVar2 = this.cancelRefundError;
            k.c(yVar, "orderSummary");
            k.c(yVar2, "orderSummaryError");
            if (uri != null) {
                d.a aVar = d.f28640a;
                net.one97.paytm.hotels2.utils.d b2 = net.one97.paytm.hotels2.utils.c.b();
                k.a((Object) b2, "HotelController.getHotelEventListener()");
                Context a2 = b2.a();
                k.a((Object) a2, "HotelController.getHotelEventListener().appContext");
                Context applicationContext = a2.getApplicationContext();
                k.a((Object) applicationContext, "HotelController.getHotel…ontext.applicationContext");
                if (!TextUtils.isEmpty(d.a.a(applicationContext).b("sso_token=", "", true))) {
                    String str = uri + "&actions=1";
                    Map hashMap = new HashMap();
                    String a3 = net.one97.paytm.hotels2.utils.c.b().a(cVar.f28603f);
                    k.a((Object) a3, "HotelController.getHotel…er().getSSOToken(context)");
                    hashMap.put(AppConstants.SSO_TOKEN, a3);
                    if (b.c(cVar.f28603f)) {
                        new com.paytm.network.b().a(cVar.f28603f).a(a.b.USER_FACING).c(AJRHotelOrderSummaryActivity.class.getName()).a(a.C0715a.GET).a(str).a(a.c.HOTELS).a((Map<String, String>) hashMap).a((com.paytm.network.listener.b) new c.a()).a((com.paytm.network.listener.b) new c.b(cVar, uri, yVar2, yVar)).a((IJRPaytmDataModel) new CancelOrderModel((String) null, (String) null, (CancelRefundData) null, 7, (g) null)).a(true).l().a();
                    } else {
                        yVar.postValue(null);
                    }
                } else {
                    yVar.postValue(null);
                }
            }
        }
    }

    public final void closeButtonClickHandler() {
        this.cancelButtonClick.postValue(Boolean.TRUE);
    }

    public final void setSelectedOptions(int i2) {
        this.selectedCancelReason.setValue(Integer.valueOf(i2));
    }

    public final void cancelBookingClicked() {
        this.cancelButtonClick.postValue(Boolean.FALSE);
    }

    public final void cancellationPolicyClickHandler() {
        this.cancellationPolicy.postValue(Boolean.TRUE);
    }

    public final void doCancelBookingApiCall(Context context, String str) {
        k.c(str, Item.KEY_REASON);
        net.one97.paytm.hotels2.utils.e.a();
        Uri.Builder buildUpon = Uri.parse(net.one97.paytm.hotels2.utils.e.a("hotel_cancel_booking_url", "")).buildUpon();
        buildUpon.appendQueryParameter("order_id", this.orderId);
        buildUpon.appendQueryParameter("request_id", this.requestId);
        if (context != null) {
            c cVar = new c(context);
            String uri = buildUpon.build().toString();
            y<CancelOrderModel> yVar = this.cancelBookingResponse;
            y<ErrorData> yVar2 = this.cancelBookingError;
            k.c(str, "cancelreason");
            k.c(yVar, "orderSummary");
            if (uri != null) {
                cVar.f28601d = yVar;
                cVar.f28602e = yVar2;
                d.a aVar = d.f28640a;
                net.one97.paytm.hotels2.utils.d b2 = net.one97.paytm.hotels2.utils.c.b();
                k.a((Object) b2, "HotelController.getHotelEventListener()");
                Context a2 = b2.a();
                k.a((Object) a2, "HotelController.getHotelEventListener().appContext");
                Context applicationContext = a2.getApplicationContext();
                k.a((Object) applicationContext, "HotelController.getHotel…ontext.applicationContext");
                if (!TextUtils.isEmpty(d.a.a(applicationContext).b("sso_token=", "", true))) {
                    String str2 = uri + "&actions=1";
                    Map hashMap = new HashMap();
                    String a3 = net.one97.paytm.hotels2.utils.c.b().a(cVar.f28603f);
                    k.a((Object) a3, "HotelController.getHotel…er().getSSOToken(context)");
                    hashMap.put(AppConstants.SSO_TOKEN, a3);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(Item.KEY_REASON, str);
                    if (b.c(cVar.f28603f)) {
                        new com.paytm.network.b().a(cVar.f28603f).a(a.b.USER_FACING).c(AJRHotelOrderSummaryActivity.class.getName()).a(a.C0715a.POST).b(jSONObject.toString()).a(str2).a(a.c.HOTELS).a((Map<String, String>) hashMap).a((com.paytm.network.listener.b) new c.a()).a((IJRPaytmDataModel) new CancelOrderModel((String) null, (String) null, (CancelRefundData) null, 7, (g) null)).a(true).l().a();
                        return;
                    }
                    ErrorData errorData = new ErrorData(901, "", "");
                    if (yVar2 != null) {
                        yVar2.postValue(errorData);
                        return;
                    }
                    return;
                }
                ErrorData errorData2 = new ErrorData(401, "", "");
                if (yVar2 != null) {
                    yVar2.postValue(errorData2);
                }
            }
        }
    }

    public final void closeScreen() {
        this.closeCancelBookinScreen.postValue(Boolean.TRUE);
    }

    public final boolean canShowTaxText() {
        MetaData value = this.metaData.getValue();
        if (value == null) {
            return false;
        }
        k.a((Object) value, "it");
        if (value.getTaxes().size() == 0) {
            return false;
        }
        return true;
    }

    public final String getTotalPrice() {
        MetaData value = this.metaData.getValue();
        if (value == null) {
            return "";
        }
        return FilterPriceSliderFragment.RUPEE_SYMBOL + String.valueOf(value.priceData.totalPriceWithTax);
    }

    public final void closePaymentDetailsClickHandler() {
        this.closePaymentDetails.postValue(Boolean.TRUE);
    }
}
