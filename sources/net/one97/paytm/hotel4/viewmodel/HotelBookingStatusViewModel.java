package net.one97.paytm.hotel4.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.appsflyer.internal.referrer.Payload;
import com.google.gsonhtcfix.f;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.travel.utils.l;
import com.travel.utils.s;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.BookingStatus;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.shopping.CJRActionResponse;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryAction;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryActionURLParams;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.deeplink.DeepLinkData;
import net.one97.paytm.hotel4.service.a.c;
import net.one97.paytm.hotel4.service.model.ErrorData;
import net.one97.paytm.hotel4.service.model.OrderSummary;
import net.one97.paytm.hotel4.service.model.details.Address;
import net.one97.paytm.hotel4.service.model.ordersummary.CancelOrderModel;
import net.one97.paytm.hotel4.service.model.ordersummary.MetaData;
import net.one97.paytm.hotel4.utils.d;
import net.one97.paytm.hotel4.view.ui.activity.AJRHotelsBookingStatusNew;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.entity.hoteldetail.ProviderPhoneNumber;
import net.one97.paytm.hotels2.utils.CJRHotelsUtilsLib;
import net.one97.paytm.hotels2.utils.d;
import net.one97.paytm.hotels2.utils.e;

public final class HotelBookingStatusViewModel extends ai {
    private String TAG_LOG = "HotelBookingStatusViewModel";
    private final String URL = "url";
    private final y<CJRActionResponse> actionResponse = new y<>();
    private final y<ArrayList<ProviderPhoneNumber>> callHotelClickObserver = new y<>();
    private final y<Boolean> cancelBookingClickObserver = new y<>();
    private final y<ErrorData> cancelRefundError = new l();
    private final y<CancelOrderModel> cancelRefundResponse = new l();
    private final y<String> cashBackPrice = new y<>();
    private final y<String> cashBackText = new y<>();
    private Context context;
    private c hotelBookingStatusRepository;
    private Intent intent;
    private boolean isFromBookingChecked;
    private BookingStatus mBookingStatus;
    private String mClientId = "";
    private String mOrderId = "";
    private final y<MetaData> metaData = new y<>();
    private final y<OrderSummary> orderSummary = new y<>();
    private final y<ErrorData> orderSummaryError = new y<>();
    private final y<CJROrderedCart> orderedCart = new y<>();
    private final l<String> progressStatus = new l<>();
    private final y<String> sharePressed = new y<>();

    public final void emailVoucher() {
    }

    public final void makeCancelPostCall(CJROrderSummaryAction cJROrderSummaryAction) {
        k.c(cJROrderSummaryAction, Payload.RESPONSE);
    }

    public final y<ErrorData> getOrderSummaryError() {
        return this.orderSummaryError;
    }

    public final y<OrderSummary> getOrderSummary() {
        return this.orderSummary;
    }

    public final y<CJRActionResponse> getActionResponse() {
        return this.actionResponse;
    }

    public final y<CJROrderedCart> getOrderedCart() {
        return this.orderedCart;
    }

    public final y<Boolean> getCancelBookingClickObserver() {
        return this.cancelBookingClickObserver;
    }

    public final y<String> getSharePressed() {
        return this.sharePressed;
    }

    public final y<ArrayList<ProviderPhoneNumber>> getCallHotelClickObserver() {
        return this.callHotelClickObserver;
    }

    public final y<CancelOrderModel> getCancelRefundResponse() {
        return this.cancelRefundResponse;
    }

    public final y<ErrorData> getCancelRefundError() {
        return this.cancelRefundError;
    }

    public final y<MetaData> getMetaData() {
        return this.metaData;
    }

    public final l<String> getProgressStatus() {
        return this.progressStatus;
    }

    public final y<String> getCashBackText() {
        return this.cashBackText;
    }

    public final y<String> getCashBackPrice() {
        return this.cashBackPrice;
    }

    public final void setup(Intent intent2, Context context2) {
        k.c(intent2, "intent");
        k.c(context2, "context");
        this.context = context2;
        this.intent = intent2;
        this.hotelBookingStatusRepository = new c(context2);
        this.mBookingStatus = getBookingInternal();
        this.mOrderId = getOrderIdInternal(intent2);
        this.mClientId = getClientIdInternal();
    }

    private final BookingStatus getBookingInternal() {
        try {
            f fVar = new f();
            k.a((Object) e.a(), "HotelsGTMLoader.getInstance()");
            Object a2 = fVar.a(e.g(), BookingStatus.class);
            k.a(a2, "gson.fromJson(dummyStrin…ookingStatus::class.java)");
            return (BookingStatus) a2;
        } catch (Exception unused) {
            return new BookingStatus();
        }
    }

    public final BookingStatus getBooking() {
        BookingStatus bookingStatus = this.mBookingStatus;
        if (bookingStatus == null) {
            k.a("mBookingStatus");
        }
        return bookingStatus;
    }

    public final String getOrderId() {
        return this.mOrderId;
    }

    public final String getBookingId() {
        OrderSummary value = this.orderSummary.getValue();
        if (value == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder("Booking Id - ");
        k.a((Object) value, "it");
        sb.append(value.getId());
        return sb.toString();
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

    public final String getOrderStatus() {
        OrderSummary value = this.orderSummary.getValue();
        if (value == null) {
            return "";
        }
        k.a((Object) value, "it");
        String status = value.getStatus();
        k.a((Object) status, "it.status");
        return status;
    }

    public final void onSharePressed() {
        MetaData value = this.metaData.getValue();
        if (value != null) {
            net.one97.paytm.hotel4.utils.e eVar = net.one97.paytm.hotel4.utils.e.f28642a;
            String str = value.city;
            k.a((Object) str, "it.city");
            OrderSummary value2 = this.orderSummary.getValue();
            if (value2 == null) {
                k.a();
            }
            k.a((Object) value2, "orderSummary.value!!");
            String id = value2.getId();
            k.a((Object) id, "orderSummary.value!!.id");
            String str2 = value.name;
            k.a((Object) str2, "it.name");
            this.sharePressed.postValue(net.one97.paytm.hotel4.utils.e.a(str, id, str2, value.paytmImages));
        }
    }

    public final String getCustomerName() {
        MetaData value = this.metaData.getValue();
        if (value == null) {
            return "";
        }
        return value.customerDetails.getFirstname() + " " + value.customerDetails.getLastname();
    }

    public final String getRoomNights() {
        MetaData value = this.metaData.getValue();
        return value != null ? String.valueOf(value.numNights.intValue()) : "";
    }

    public final String getNightText() {
        MetaData value = this.metaData.getValue();
        if (value == null) {
            return "";
        }
        net.one97.paytm.hotel4.utils.e eVar = net.one97.paytm.hotel4.utils.e.f28642a;
        return net.one97.paytm.hotel4.utils.e.a("Night", "", value.numNights);
    }

    public final String getGuestCount() {
        MetaData value = this.metaData.getValue();
        if (value == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(value.guestCount.intValue()));
        net.one97.paytm.hotel4.utils.e eVar = net.one97.paytm.hotel4.utils.e.f28642a;
        sb.append(net.one97.paytm.hotel4.utils.e.a(" Guest", ". ", value.guestCount));
        sb.append(value.numRooms);
        net.one97.paytm.hotel4.utils.e eVar2 = net.one97.paytm.hotel4.utils.e.f28642a;
        String str = value.numRooms;
        k.a((Object) str, "it.numRooms");
        sb.append(net.one97.paytm.hotel4.utils.e.a(" Room", "", Integer.valueOf(Integer.parseInt(str))));
        return sb.toString();
    }

    public final String getTotalPrice() {
        MetaData value = this.metaData.getValue();
        if (value == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Context context2 = this.context;
        if (context2 == null) {
            k.a("context");
        }
        sb.append(context2.getString(R.string.h4_hotels_rupees).toString());
        sb.append(String.valueOf(value.priceData.totalPriceWithTax));
        return sb.toString();
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

    private final String getOrderIdInternal(Intent intent2) {
        if (intent2 != null && intent2.hasExtra("from_payment") && intent2.getBooleanExtra("from_payment", false)) {
            String stringExtra = intent2.getStringExtra("hotel_booking_id");
            k.a((Object) stringExtra, "intent.getStringExtra(\"hotel_booking_id\")");
            return stringExtra;
        } else if (intent2 != null && intent2.hasExtra("order_id")) {
            String stringExtra2 = intent2.getStringExtra("order_id");
            k.a((Object) stringExtra2, "intent.getStringExtra(\"order_id\")");
            return stringExtra2;
        } else if (intent2 == null || !intent2.hasExtra("EXTRA_DEEP_LINK_DATA")) {
            return "";
        } else {
            Parcelable parcelableExtra = intent2.getParcelableExtra("EXTRA_DEEP_LINK_DATA");
            k.a((Object) parcelableExtra, "intent.getParcelableExtra(\"EXTRA_DEEP_LINK_DATA\")");
            DeepLinkData deepLinkData = (DeepLinkData) parcelableExtra;
            if (deepLinkData == null) {
                return "";
            }
            try {
                String queryParameter = Uri.parse(deepLinkData.f50283a).getQueryParameter("orderid");
                if (queryParameter == null) {
                    k.a();
                }
                return queryParameter;
            } catch (Exception e2) {
                q.c(e2.getMessage());
                return "";
            }
        }
    }

    private final String getClientIdInternal() {
        if (e.a() == null) {
            return "";
        }
        if (e.a() != null) {
            return e.i();
        }
        return null;
    }

    private final String getClientId() {
        return this.mClientId;
    }

    public final boolean getOrderDetails() {
        q.d("getOrderDetails End called");
        if (!TextUtils.isEmpty(this.mOrderId)) {
            k.a((Object) e.a(), "HotelsGTMLoader.getInstance()");
            String h2 = e.h();
            getOrderDetailServer(h2 + "?orderId=" + this.mOrderId);
            d b2 = net.one97.paytm.hotels2.utils.c.b();
            Context context2 = this.context;
            if (context2 == null) {
                k.a("context");
            }
            b2.a(context2, "/hotel-new/summary" + CJRHotelsUtilsLib.a());
            return true;
        }
        Intent intent2 = this.intent;
        if (intent2 == null) {
            k.a("intent");
        }
        if (intent2 == null) {
            return false;
        }
        Intent intent3 = this.intent;
        if (intent3 == null) {
            k.a("intent");
        }
        if (!intent3.hasExtra("extra_home_data")) {
            return false;
        }
        Intent intent4 = this.intent;
        if (intent4 == null) {
            k.a("intent");
        }
        Bundle extras = intent4.getExtras();
        String str = null;
        Serializable serializable = extras != null ? extras.getSerializable("extra_home_data") : null;
        if (serializable != null) {
            CJRItem cJRItem = (CJRItem) serializable;
            if (cJRItem != null) {
                str = cJRItem.getURL();
            }
            if (str == null) {
                return false;
            }
            getOrderDetailServer(cJRItem.getURL());
            return true;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.CJRItem");
    }

    private final void getOrderDetailServer(String str) {
        c cVar = this.hotelBookingStatusRepository;
        if (cVar == null) {
            k.a("hotelBookingStatusRepository");
        }
        y<OrderSummary> yVar = this.orderSummary;
        y<ErrorData> yVar2 = this.orderSummaryError;
        k.c(yVar, "orderSummary");
        k.c(yVar2, "orderSummaryError");
        if (str != null) {
            cVar.f28598a = yVar;
            cVar.f28599b = yVar2;
            d.a aVar = net.one97.paytm.hotel4.utils.d.f28640a;
            net.one97.paytm.hotels2.utils.d b2 = net.one97.paytm.hotels2.utils.c.b();
            k.a((Object) b2, "HotelController.getHotelEventListener()");
            Context a2 = b2.a();
            k.a((Object) a2, "HotelController.getHotelEventListener().appContext");
            Context applicationContext = a2.getApplicationContext();
            k.a((Object) applicationContext, "HotelController.getHotel…ontext.applicationContext");
            if (!TextUtils.isEmpty(d.a.a(applicationContext).b("sso_token=", "", true))) {
                String str2 = str + "&actions=1";
                Map hashMap = new HashMap();
                String a3 = net.one97.paytm.hotels2.utils.c.b().a(cVar.f28603f);
                k.a((Object) a3, "HotelController.getHotel…er().getSSOToken(context)");
                hashMap.put(AppConstants.SSO_TOKEN, a3);
                if (b.c(cVar.f28603f)) {
                    new com.paytm.network.b().a(cVar.f28603f).a(a.b.SILENT).c(AJRHotelsBookingStatusNew.class.getName()).a(a.C0715a.GET).a(str2).a(a.c.HOTELS).a((Map<String, String>) hashMap).f().a((com.paytm.network.listener.b) new c.a()).a((IJRPaytmDataModel) new OrderSummary()).l().a();
                } else {
                    yVar.postValue(null);
                }
            } else {
                yVar.postValue(null);
            }
        }
    }

    public final void saveVoucher() {
        Context context2 = this.context;
        if (context2 == null) {
            k.a("context");
        }
        if (context2 != null) {
            Context context3 = this.context;
            if (context3 == null) {
                k.a("context");
            }
            if (!b.c(context3)) {
                Context context4 = this.context;
                if (context4 == null) {
                    k.a("context");
                }
                Context context5 = this.context;
                if (context5 == null) {
                    k.a("context");
                }
                if (context5 == null) {
                    k.a();
                }
                String string = context5.getResources().getString(R.string.hotels_hotel_no_internet_title);
                Context context6 = this.context;
                if (context6 == null) {
                    k.a("context");
                }
                if (context6 == null) {
                    k.a();
                }
                b.a(context4, string, context6.getResources().getString(R.string.hotels_hotel_no_internet_message));
                return;
            }
        }
        this.progressStatus.postValue("Please wait...");
        OrderSummary value = this.orderSummary.getValue();
        if (value != null) {
            k.a((Object) value, "it");
            CJROrderedCart cJROrderedCart = value.getOrderedCartList().get(0);
            k.a((Object) cJROrderedCart, "cartItem");
            if (cJROrderedCart.getAction() != null) {
                Iterator<CJROrderSummaryAction> it2 = cJROrderedCart.getAction().iterator();
                CJROrderSummaryAction cJROrderSummaryAction = null;
                while (it2.hasNext()) {
                    CJROrderSummaryAction next = it2.next();
                    k.a((Object) next, "cjrOrderSummaryAction");
                    if (!TextUtils.isEmpty(next.getLabel()) && p.a(next.getLabel(), "Invoice", true)) {
                        cJROrderSummaryAction = next;
                    }
                }
                if (cJROrderSummaryAction != null) {
                    downloadVoucher(cJROrderSummaryAction);
                    return;
                } else {
                    this.actionResponse.postValue(null);
                    return;
                }
            }
        }
        this.actionResponse.postValue(null);
    }

    private final ArrayList<String> getListFromString(String str) {
        Object[] array = p.a((CharSequence) str, new String[]{com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COMMA}).toArray(new String[0]);
        if (array != null) {
            String[] strArr = (String[]) array;
            List b2 = kotlin.a.k.b((T[]) (String[]) Arrays.copyOf(strArr, strArr.length));
            ArrayList<String> arrayList = new ArrayList<>();
            int size = b2.size();
            for (int i2 = 0; i2 < size; i2++) {
                String replace = new kotlin.m.l("\\D+").replace((CharSequence) b2.get(i2), "");
                if (p.b(replace, "91", false) && replace.length() == 12) {
                    replace = "+".concat(String.valueOf(replace));
                }
                arrayList.add(replace);
            }
            return arrayList;
        }
        throw new u("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public final void callHotel() {
        String str;
        if (this.orderSummary.getValue() != null) {
            HashMap hashMap = new HashMap();
            this.progressStatus.postValue("Please wait...");
            OrderSummary value = this.orderSummary.getValue();
            if (value == null) {
                k.a();
            }
            k.a((Object) value, "orderSummary.value!!");
            CJROrderedCart cJROrderedCart = value.getOrderedCartList().get(0);
            k.a((Object) cJROrderedCart, "orderSummary.value!!.orderedCartList[0]");
            CJROrderedCart cJROrderedCart2 = cJROrderedCart;
            OrderSummary value2 = this.orderSummary.getValue();
            if (value2 == null) {
                k.a();
            }
            MetaData metaData2 = value2.getMetaData(cJROrderedCart2);
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(metaData2.phone)) {
                String str2 = metaData2.phone;
                k.a((Object) str2, "mMetaData.phone");
                ArrayList<String> listFromString = getListFromString(str2);
                if (listFromString == null) {
                    k.a();
                }
                ProviderPhoneNumber providerPhoneNumber = new ProviderPhoneNumber();
                StringBuilder sb = new StringBuilder();
                Context context2 = this.context;
                if (context2 == null) {
                    k.a("context");
                }
                sb.append(context2.getString(R.string.hotels_hotel_prefix).toString());
                sb.append(" ");
                sb.append(metaData2.name);
                providerPhoneNumber.setName(sb.toString());
                providerPhoneNumber.setNumbers(listFromString);
                arrayList.add(providerPhoneNumber);
                Map map = hashMap;
                if (listFromString != null) {
                    map.put("event_label2", listFromString);
                } else {
                    throw new u("null cannot be cast to non-null type kotlin.Any");
                }
            } else if (metaData2.merchantPhone != null && metaData2.merchantPhone.size() > 0) {
                ProviderPhoneNumber providerPhoneNumber2 = new ProviderPhoneNumber();
                providerPhoneNumber2.setName(metaData2.supplierName);
                ArrayList arrayList2 = new ArrayList();
                ArrayList<String> arrayList3 = metaData2.merchantPhone;
                k.a((Object) arrayList3, "mMetaData.merchantPhone");
                for (String str3 : arrayList3) {
                    k.a((Object) str3, "number");
                    if (p.b(str3, "91", false) && str3.length() == 12) {
                        str3 = "+".concat(String.valueOf(str3));
                    }
                    arrayList2.add(str3);
                }
                providerPhoneNumber2.setNumbers(arrayList2);
                arrayList.add(providerPhoneNumber2);
            }
            CJROrderSummaryProductDetail productDetail = cJROrderedCart2.getProductDetail();
            k.a((Object) productDetail, "cjrOrderedCart.productDetail");
            String valueOf = String.valueOf(productDetail.getId());
            k.a((Object) e.a(), "HotelsGTMLoader.getInstance()");
            if (k.a((Object) valueOf, (Object) e.e())) {
                k.a((Object) e.a(), "HotelsGTMLoader.getInstance()");
                str = e.j();
                k.a((Object) str, "HotelsGTMLoader.getInsta…lpineCallingNumberBooking");
                if (TextUtils.isEmpty(str)) {
                    Context context3 = this.context;
                    if (context3 == null) {
                        k.a("context");
                    }
                    str = context3.getString(R.string.hotels_booking_customer_care_number);
                    k.a((Object) str, "context.getString(R.stri…ing_customer_care_number)");
                    Map map2 = hashMap;
                    if (str != null) {
                        map2.put("event_label3", str);
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.Any");
                    }
                }
            } else {
                k.a((Object) e.a(), "HotelsGTMLoader.getInstance()");
                str = e.k();
                k.a((Object) str, "HotelsGTMLoader.getInsta…HotelHelpineCallingNumber");
                if (TextUtils.isEmpty(str)) {
                    Context context4 = this.context;
                    if (context4 == null) {
                        k.a("context");
                    }
                    str = context4.getString(R.string.hotels_travel_hotel_number);
                    k.a((Object) str, "context.getString(R.stri…tels_travel_hotel_number)");
                    Map map3 = hashMap;
                    if (str != null) {
                        map3.put("event_label3", str);
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.Any");
                    }
                }
            }
            if (!TextUtils.isEmpty(str)) {
                ArrayList arrayList4 = new ArrayList();
                arrayList4.add(str);
                ProviderPhoneNumber providerPhoneNumber3 = new ProviderPhoneNumber();
                CJROrderSummaryProductDetail productDetail2 = cJROrderedCart2.getProductDetail();
                k.a((Object) productDetail2, "cjrOrderedCart.productDetail");
                String valueOf2 = String.valueOf(productDetail2.getId());
                k.a((Object) e.a(), "HotelsGTMLoader.getInstance()");
                if (k.a((Object) valueOf2, (Object) e.e())) {
                    Context context5 = this.context;
                    if (context5 == null) {
                        k.a("context");
                    }
                    providerPhoneNumber3.setName(context5.getString(R.string.hotels_booking_customer_care));
                } else {
                    Context context6 = this.context;
                    if (context6 == null) {
                        k.a("context");
                    }
                    providerPhoneNumber3.setName(context6.getString(R.string.hotels_paytm_customer_care));
                }
                Context context7 = this.context;
                if (context7 == null) {
                    k.a("context");
                }
                providerPhoneNumber3.setTiming(context7.getString(R.string.hotels_twenty_four_seven));
                providerPhoneNumber3.setNumbers(arrayList4);
                hashMap.put("event_label3", arrayList4);
                arrayList.add(providerPhoneNumber3);
            }
            if (this.metaData.getValue() != null) {
                MetaData value3 = this.metaData.getValue();
                if (value3 == null) {
                    k.a();
                }
                if (value3.name != null) {
                    Map map4 = hashMap;
                    MetaData value4 = this.metaData.getValue();
                    if (value4 == null) {
                        k.a();
                    }
                    String str4 = value4.name;
                    if (str4 != null) {
                        map4.put("event_label", str4);
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.Any");
                    }
                }
            }
            net.one97.paytm.hotels2.utils.c.b().a("customEvent", "Order Page", "hotels_order_summary", "call_initiated", hashMap);
            this.callHotelClickObserver.postValue(arrayList);
        }
    }

    public final void cancelBooking() {
        Context context2 = this.context;
        if (context2 == null) {
            k.a("context");
        }
        if (context2 != null) {
            Context context3 = this.context;
            if (context3 == null) {
                k.a("context");
            }
            if (b.c(context3)) {
                this.cancelBookingClickObserver.postValue(Boolean.TRUE);
                return;
            }
        }
        Context context4 = this.context;
        if (context4 == null) {
            k.a("context");
        }
        Context context5 = this.context;
        if (context5 == null) {
            k.a("context");
        }
        if (context5 == null) {
            k.a();
        }
        String string = context5.getResources().getString(R.string.hotels_hotel_no_internet_title);
        Context context6 = this.context;
        if (context6 == null) {
            k.a("context");
        }
        if (context6 == null) {
            k.a();
        }
        b.a(context4, string, context6.getResources().getString(R.string.hotels_hotel_no_internet_message));
    }

    public final void openGoogleMap() {
        OrderSummary value = this.orderSummary.getValue();
        if (value != null) {
            k.a((Object) value, "it");
            ArrayList<CJROrderedCart> orderedCartList = value.getOrderedCartList();
            if (orderedCartList == null) {
                k.a();
            }
            CJROrderedCart cJROrderedCart = orderedCartList.get(0);
            try {
                k.a((Object) cJROrderedCart, "item");
                String name = cJROrderedCart.getName();
                OrderSummary value2 = this.orderSummary.getValue();
                if (value2 == null) {
                    k.a();
                }
                MetaData metaData2 = value2.getMetaData(cJROrderedCart);
                if (metaData2 == null) {
                    k.a();
                }
                Address address = metaData2.address;
                Double d2 = null;
                Double lat = address != null ? address.getLat() : null;
                Address address2 = metaData2.address;
                if (address2 != null) {
                    d2 = address2.getLng();
                }
                s sVar = s.f28553a;
                Context context2 = this.context;
                if (context2 == null) {
                    k.a("context");
                }
                if (lat == null) {
                    k.a();
                }
                double doubleValue = lat.doubleValue();
                if (d2 == null) {
                    k.a();
                }
                double doubleValue2 = d2.doubleValue();
                k.a((Object) name, "hotelName");
                s.a(context2, doubleValue, doubleValue2, name);
            } catch (Exception unused) {
            }
        }
    }

    public final boolean checkIfHotelFromBooking() {
        if (this.isFromBookingChecked) {
            return true;
        }
        OrderSummary value = this.orderSummary.getValue();
        if (value == null) {
            k.a();
        }
        k.a((Object) value, "orderSummary.value!!");
        if (value.getOrderedCartList().size() > 0) {
            OrderSummary value2 = this.orderSummary.getValue();
            if (value2 == null) {
                k.a();
            }
            k.a((Object) value2, "orderSummary.value!!");
            CJROrderedCart cJROrderedCart = value2.getOrderedCartList().get(0);
            k.a((Object) cJROrderedCart, "orderSummary.value!!.orderedCartList[0]");
            CJROrderSummaryProductDetail productDetail = cJROrderedCart.getProductDetail();
            k.a((Object) productDetail, "cjrOrderedCart.productDetail");
            String valueOf = String.valueOf(productDetail.getId());
            k.a((Object) e.a(), "HotelsGTMLoader.getInstance()");
            if (k.a((Object) valueOf, (Object) e.e())) {
                StringBuilder sb = new StringBuilder();
                k.a((Object) e.a(), "HotelsGTMLoader.getInstance()");
                sb.append(e.f());
                sb.append(this.mOrderId);
                this.isFromBookingChecked = true;
                return true;
            }
        }
        return false;
    }

    public final boolean canShowCancellationPolicy() {
        if (this.metaData.getValue() != null) {
            MetaData value = this.metaData.getValue();
            if (value == null) {
                k.a();
            }
            if (value.cancellationPolicy != null) {
                MetaData value2 = this.metaData.getValue();
                if (value2 == null) {
                    k.a();
                }
                String str = value2.cancellationPolicy;
                k.a((Object) str, "metaData.value!!.cancellationPolicy");
                if (str.length() > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public final String getCancellationPolicy() {
        if (this.metaData.getValue() != null) {
            MetaData value = this.metaData.getValue();
            if (value == null) {
                k.a();
            }
            if (value.cancellationPolicy != null) {
                MetaData value2 = this.metaData.getValue();
                if (value2 == null) {
                    k.a();
                }
                String str = value2.cancellationPolicy;
                k.a((Object) str, "metaData.value!!.cancellationPolicy");
                if (str.length() > 0) {
                    MetaData value3 = this.metaData.getValue();
                    if (value3 == null) {
                        k.a();
                    }
                    String str2 = value3.cancellationPolicy;
                    k.a((Object) str2, "metaData.value!!.cancellationPolicy");
                    return str2;
                }
            }
        }
        return "";
    }

    private final void downloadVoucher(CJROrderSummaryAction cJROrderSummaryAction) {
        String str;
        if (cJROrderSummaryAction == null) {
            k.a();
        }
        if (cJROrderSummaryAction.getUrlParams() != null) {
            CJROrderSummaryActionURLParams urlParams = cJROrderSummaryAction.getUrlParams();
            k.a((Object) urlParams, "action.urlParams");
            if (urlParams.getMethod() != null) {
                CJROrderSummaryActionURLParams urlParams2 = cJROrderSummaryAction.getUrlParams();
                k.a((Object) urlParams2, "action.urlParams");
                if (p.a(urlParams2.getMethod(), "POST", true)) {
                    CJROrderSummaryActionURLParams urlParams3 = cJROrderSummaryAction.getUrlParams();
                    k.a((Object) urlParams3, "action.urlParams");
                    if (urlParams3.getBody() != null) {
                        CJROrderSummaryActionURLParams urlParams4 = cJROrderSummaryAction.getUrlParams();
                        k.a((Object) urlParams4, "action.urlParams");
                        str = urlParams4.getBody().toString();
                        CJROrderSummaryActionURLParams urlParams5 = cJROrderSummaryAction.getUrlParams();
                        k.a((Object) urlParams5, "action.urlParams");
                        String url = urlParams5.getUrl();
                        k.a((Object) url, "action.urlParams.url");
                        downloadVoucherImplementation(url, str, false);
                    }
                }
            }
        }
        str = null;
        CJROrderSummaryActionURLParams urlParams52 = cJROrderSummaryAction.getUrlParams();
        k.a((Object) urlParams52, "action.urlParams");
        String url2 = urlParams52.getUrl();
        k.a((Object) url2, "action.urlParams.url");
        downloadVoucherImplementation(url2, str, false);
    }

    private final void downloadVoucherImplementation(String str, String str2, boolean z) {
        c cVar = this.hotelBookingStatusRepository;
        if (cVar == null) {
            k.a("hotelBookingStatusRepository");
        }
        y<CJRActionResponse> yVar = this.actionResponse;
        k.c(str, "url");
        k.c(yVar, "actionResponse");
        cVar.f28600c = yVar;
        if (!b.c(cVar.f28603f)) {
            yVar.postValue(null);
        } else {
            Uri parse = Uri.parse(str);
            String a2 = k.a(str, (Object) (parse == null || parse.getQuery() != null) ? com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.AND_SIGN : "?");
            d.a aVar = net.one97.paytm.hotel4.utils.d.f28640a;
            net.one97.paytm.hotels2.utils.d b2 = net.one97.paytm.hotels2.utils.c.b();
            k.a((Object) b2, "HotelController.getHotelEventListener()");
            Context a3 = b2.a();
            k.a((Object) a3, "HotelController.getHotelEventListener().appContext");
            Context applicationContext = a3.getApplicationContext();
            k.a((Object) applicationContext, "HotelController.getHotel…ontext.applicationContext");
            String a4 = k.a(a2, (Object) "sso_token=".concat(String.valueOf(d.a.a(applicationContext).b("sso_token=", "", true))));
            if (a4 == null) {
                k.a();
            }
            String a5 = p.a(a4, " ", "%20", false);
            Map hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            new com.paytm.network.b().a(cVar.f28603f).a(a.b.SILENT).c(AJRHotelsBookingStatusNew.class.getName()).a(a.C0715a.GET).a(a5).a(a.c.HOTELS).a((Map<String, String>) hashMap).a((com.paytm.network.listener.b) new c.a()).a((IJRPaytmDataModel) new CJRActionResponse()).b(str2).l().a();
        }
        sendDownloadPulseEvent();
    }

    public final void sendOpenPulseEvent() {
        HashMap hashMap = new HashMap();
        if (this.metaData.getValue() != null) {
            MetaData value = this.metaData.getValue();
            if (value == null) {
                k.a();
            }
            if (value.name != null) {
                Map map = hashMap;
                MetaData value2 = this.metaData.getValue();
                if (value2 == null) {
                    k.a();
                }
                String str = value2.name;
                if (str != null) {
                    map.put("event_label", str);
                } else {
                    throw new u("null cannot be cast to non-null type kotlin.Any");
                }
            }
        }
        if (this.orderSummary.getValue() != null) {
            OrderSummary value3 = this.orderSummary.getValue();
            if (value3 == null) {
                k.a();
            }
            k.a((Object) value3, "orderSummary.value!!");
            if (value3.getStatus() != null) {
                Map map2 = hashMap;
                OrderSummary value4 = this.orderSummary.getValue();
                if (value4 == null) {
                    k.a();
                }
                k.a((Object) value4, "orderSummary.value!!");
                String status = value4.getStatus();
                if (status != null) {
                    map2.put("event_label2", status);
                } else {
                    throw new u("null cannot be cast to non-null type kotlin.Any");
                }
            }
        }
        net.one97.paytm.hotels2.utils.c.b().a("customEvent", "Order Page", "hotels_order_summary", "page_opened", hashMap);
    }

    public final void sendDownloadPulseEvent() {
        HashMap hashMap = new HashMap();
        if (this.metaData.getValue() != null) {
            MetaData value = this.metaData.getValue();
            if (value == null) {
                k.a();
            }
            if (value.name != null) {
                Map map = hashMap;
                MetaData value2 = this.metaData.getValue();
                if (value2 == null) {
                    k.a();
                }
                String str = value2.name;
                if (str != null) {
                    map.put("event_label", str);
                } else {
                    throw new u("null cannot be cast to non-null type kotlin.Any");
                }
            }
        }
        net.one97.paytm.hotels2.utils.c.b().a("customEvent", "Order Page", "hotels_order_summary", "download_tapped", hashMap);
    }

    public final boolean isCancelOrder() {
        return p.a(getOrderStatus(), "Cancelled", true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.getValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getRequestId() {
        /*
            r2 = this;
            androidx.lifecycle.y<net.one97.paytm.hotel4.service.model.OrderSummary> r0 = r2.orderSummary
            r1 = 0
            if (r0 == 0) goto L_0x0012
            java.lang.Object r0 = r0.getValue()
            net.one97.paytm.hotel4.service.model.OrderSummary r0 = (net.one97.paytm.hotel4.service.model.OrderSummary) r0
            if (r0 == 0) goto L_0x0012
            java.lang.String r0 = r0.getRequest_id()
            goto L_0x0013
        L_0x0012:
            r0 = r1
        L_0x0013:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x001e
            java.lang.String r0 = "23"
            return r0
        L_0x001e:
            androidx.lifecycle.y<net.one97.paytm.hotel4.service.model.OrderSummary> r0 = r2.orderSummary
            if (r0 == 0) goto L_0x002f
            java.lang.Object r0 = r0.getValue()
            net.one97.paytm.hotel4.service.model.OrderSummary r0 = (net.one97.paytm.hotel4.service.model.OrderSummary) r0
            if (r0 == 0) goto L_0x002f
            java.lang.String r0 = r0.getRequest_id()
            return r0
        L_0x002f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.viewmodel.HotelBookingStatusViewModel.getRequestId():java.lang.String");
    }
}
