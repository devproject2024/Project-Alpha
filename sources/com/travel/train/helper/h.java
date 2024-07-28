package com.travel.train.helper;

import android.content.Context;
import android.text.TextUtils;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.travel.train.R;
import com.travel.train.i.ai;
import com.travel.train.i.k;
import com.travel.train.j.g;
import com.travel.train.j.n;
import com.travel.train.j.o;
import com.travel.train.model.trainticket.CJRTrainActionResponse;
import com.travel.train.model.trainticket.CJRTrainFavouriteResponse;
import com.travel.train.model.trainticket.CJRTrainOrderSummaryResponse;
import com.travel.train.model.trainticket.CJRTrainPromotionalBanner;
import com.travel.train.model.trainticket.CJRTrainSummaryItem;
import java.util.ArrayList;
import net.one97.paytm.common.entity.recharge.CJRNpsTrackingResponse;

public final class h implements b {

    /* renamed from: a  reason: collision with root package name */
    public Context f27305a;

    /* renamed from: b  reason: collision with root package name */
    public k f27306b;

    /* renamed from: c  reason: collision with root package name */
    public String f27307c = "CJRTrainOrderSummaryPresenter";

    /* renamed from: d  reason: collision with root package name */
    private String f27308d = "";

    /* renamed from: e  reason: collision with root package name */
    private String f27309e = "";

    /* renamed from: f  reason: collision with root package name */
    private String f27310f = "https://cart.paytm.com/v1/";

    /* renamed from: g  reason: collision with root package name */
    private String f27311g;

    public h(Context context, k kVar) {
        this.f27305a = context;
        this.f27306b = kVar;
    }

    public final void a(String str, String str2) {
        this.f27311g = str2;
        com.travel.train.b.a();
        String Q = com.travel.train.b.b().Q();
        if (!TextUtils.isEmpty(Q)) {
            this.f27308d = Q + str;
            b(this.f27308d);
        }
    }

    public final void b(String str, String str2) {
        this.f27311g = str2;
        com.travel.train.b.a();
        String Q = com.travel.train.b.b().Q();
        if (str.contains(this.f27310f)) {
            String a2 = a(str);
            this.f27308d = Q + a2;
        } else {
            this.f27308d = str;
        }
        b(this.f27308d);
    }

    private static String a(String str) {
        int length = str.length();
        if (str.charAt(length - 1) == '/') {
            str = str.substring(0, length - 2);
        }
        int i2 = -1;
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (str.charAt(i3) == '/') {
                i2 = i3;
            }
        }
        return (i2 == -1 || str.length() <= i2) ? "" : str.substring(i2 + 1);
    }

    private void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            a c2 = c(str);
            if (com.paytm.utility.b.c(this.f27305a)) {
                this.f27306b.d();
                c2.a();
                return;
            }
            this.f27306b.e();
            this.f27306b.showNetworkDialog(c2, this.f27305a.getString(R.string.no_connection), this.f27305a.getString(R.string.no_internet));
        }
    }

    private a c(String str) {
        String b2 = o.b(this.f27305a, com.paytm.utility.b.s(this.f27305a, str));
        if (!TextUtils.isEmpty(this.f27309e)) {
            b2 = b2 + "&hash_value=" + this.f27309e;
        }
        com.paytm.network.b bVar = new com.paytm.network.b();
        bVar.f42877a = this.f27305a;
        bVar.f42878b = a.c.TRAIN;
        bVar.n = a.b.SILENT;
        bVar.o = g.k;
        bVar.f42879c = a.C0715a.POST;
        bVar.f42880d = b2;
        bVar.f42882f = n.b(this.f27305a);
        bVar.f42885i = new CJRTrainOrderSummaryResponse();
        bVar.j = this;
        bVar.l = false;
        a l = bVar.l();
        l.f42859c = false;
        return l;
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        this.f27306b.e();
        if (iJRPaytmDataModel instanceof CJRTrainOrderSummaryResponse) {
            if (this.f27306b != null) {
                CJRTrainOrderSummaryResponse cJRTrainOrderSummaryResponse = (CJRTrainOrderSummaryResponse) iJRPaytmDataModel;
                if (cJRTrainOrderSummaryResponse == null || cJRTrainOrderSummaryResponse.getBody() == null) {
                    NetworkCustomError networkCustomError = new NetworkCustomError();
                    networkCustomError.setmAlertTitle(this.f27305a.getString(R.string.error_dialog_title));
                    networkCustomError.setAlertMessage(this.f27305a.getString(R.string.error_dialog_message));
                    this.f27306b.a(200, iJRPaytmDataModel, networkCustomError, c(this.f27308d));
                    return;
                } else if (cJRTrainOrderSummaryResponse.getMeta() == null || TextUtils.isEmpty(cJRTrainOrderSummaryResponse.getMeta().getHashValue()) || cJRTrainOrderSummaryResponse.getMeta().getHashValue().equalsIgnoreCase(this.f27309e)) {
                    this.f27306b.c();
                    return;
                } else {
                    this.f27309e = cJRTrainOrderSummaryResponse.getMeta().getHashValue();
                }
            } else {
                return;
            }
        } else if (iJRPaytmDataModel instanceof CJRNpsTrackingResponse) {
            this.f27306b.e();
            this.f27306b.a((CJRNpsTrackingResponse) iJRPaytmDataModel);
            return;
        } else if (!(iJRPaytmDataModel instanceof CJRTrainFavouriteResponse) && !(iJRPaytmDataModel instanceof CJRTrainActionResponse)) {
            return;
        }
        this.f27306b.a(iJRPaytmDataModel);
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.f27306b.e();
        this.f27306b.a(i2, iJRPaytmDataModel, networkCustomError, c(this.f27308d));
    }

    public static ArrayList<CJRTrainSummaryItem> a(CJRTrainOrderSummaryResponse cJRTrainOrderSummaryResponse) {
        ArrayList<CJRTrainSummaryItem> arrayList = new ArrayList<>();
        if (!(cJRTrainOrderSummaryResponse == null || cJRTrainOrderSummaryResponse.getMeta() == null || cJRTrainOrderSummaryResponse.getMeta().getPositionDetails() == null || cJRTrainOrderSummaryResponse.getMeta().getPositionDetails().size() <= 0)) {
            ArrayList<String> positionDetails = cJRTrainOrderSummaryResponse.getMeta().getPositionDetails();
            for (int i2 = 0; i2 < positionDetails.size(); i2++) {
                switch (ai.fromName(positionDetails.get(i2))) {
                    case ORDER_STATUS_LAYOUT:
                        if (!(cJRTrainOrderSummaryResponse.getBody() == null || cJRTrainOrderSummaryResponse.getBody().getOrderStatus() == null)) {
                            CJRTrainSummaryItem cJRTrainSummaryItem = new CJRTrainSummaryItem();
                            cJRTrainSummaryItem.setLayoutType(ai.ORDER_STATUS_LAYOUT.getName());
                            cJRTrainSummaryItem.setItem(cJRTrainOrderSummaryResponse.getBody().getOrderStatus());
                            cJRTrainSummaryItem.setMetaItem(cJRTrainOrderSummaryResponse.getMeta());
                            arrayList.add(cJRTrainSummaryItem);
                            break;
                        }
                    case ORDER_ACTIONS_LAYOUT:
                        if (!(cJRTrainOrderSummaryResponse.getBody() == null || cJRTrainOrderSummaryResponse.getBody().getOrderActions() == null || cJRTrainOrderSummaryResponse.getBody().getOrderActions().size() <= 0)) {
                            CJRTrainSummaryItem cJRTrainSummaryItem2 = new CJRTrainSummaryItem();
                            cJRTrainSummaryItem2.setLayoutType(ai.ORDER_ACTIONS_LAYOUT.getName());
                            cJRTrainSummaryItem2.setItem(cJRTrainOrderSummaryResponse.getBody());
                            cJRTrainSummaryItem2.setMetaItem(cJRTrainOrderSummaryResponse.getMeta());
                            arrayList.add(cJRTrainSummaryItem2);
                            break;
                        }
                    case ORDER_BOOKING_DETAILS_LAYOUT:
                        if (!(cJRTrainOrderSummaryResponse.getBody() == null || cJRTrainOrderSummaryResponse.getBody().getBookingDetails() == null)) {
                            CJRTrainSummaryItem cJRTrainSummaryItem3 = new CJRTrainSummaryItem();
                            cJRTrainSummaryItem3.setLayoutType(ai.ORDER_BOOKING_DETAILS_LAYOUT.getName());
                            cJRTrainSummaryItem3.setItem(cJRTrainOrderSummaryResponse.getBody().getBookingDetails());
                            cJRTrainSummaryItem3.setMetaItem(cJRTrainOrderSummaryResponse.getMeta());
                            arrayList.add(cJRTrainSummaryItem3);
                            break;
                        }
                    case ORDER_TRAVELLER_DETAILS_LAYOUT:
                        if (!(cJRTrainOrderSummaryResponse.getBody() == null || cJRTrainOrderSummaryResponse.getBody().getPaxInfo() == null || cJRTrainOrderSummaryResponse.getBody().getPaxInfo().size() <= 0)) {
                            CJRTrainSummaryItem cJRTrainSummaryItem4 = new CJRTrainSummaryItem();
                            cJRTrainSummaryItem4.setLayoutType(ai.ORDER_TRAVELLER_DETAILS_LAYOUT.getName());
                            cJRTrainSummaryItem4.setItem(cJRTrainOrderSummaryResponse.getBody());
                            cJRTrainSummaryItem4.setMetaItem(cJRTrainOrderSummaryResponse.getMeta());
                            arrayList.add(cJRTrainSummaryItem4);
                            break;
                        }
                    case ORDER_CP_LAYOUT:
                        b(arrayList, cJRTrainOrderSummaryResponse);
                        break;
                    case ORDER_CASHBACK_LAYOUT:
                        if (!(cJRTrainOrderSummaryResponse.getBody() == null || cJRTrainOrderSummaryResponse.getBody().getPromoInfo() == null || TextUtils.isEmpty(cJRTrainOrderSummaryResponse.getBody().getPromoInfo().getCashbackText()))) {
                            CJRTrainSummaryItem cJRTrainSummaryItem5 = new CJRTrainSummaryItem();
                            cJRTrainSummaryItem5.setLayoutType(ai.ORDER_CASHBACK_LAYOUT.getName());
                            cJRTrainSummaryItem5.setItem(cJRTrainOrderSummaryResponse.getBody().getPromoInfo());
                            cJRTrainSummaryItem5.setMetaItem(cJRTrainOrderSummaryResponse.getMeta());
                            arrayList.add(cJRTrainSummaryItem5);
                            break;
                        }
                    case ORDER_FARE_DETAILS_LAYOUT:
                        if (!(cJRTrainOrderSummaryResponse.getBody() == null || cJRTrainOrderSummaryResponse.getBody().getFareDetails() == null || cJRTrainOrderSummaryResponse.getBody().getFareDetails().size() <= 0)) {
                            CJRTrainSummaryItem cJRTrainSummaryItem6 = new CJRTrainSummaryItem();
                            cJRTrainSummaryItem6.setLayoutType(ai.ORDER_FARE_DETAILS_LAYOUT.getName());
                            cJRTrainSummaryItem6.setItem(cJRTrainOrderSummaryResponse.getBody());
                            cJRTrainSummaryItem6.setMetaItem(cJRTrainOrderSummaryResponse.getMeta());
                            arrayList.add(cJRTrainSummaryItem6);
                            break;
                        }
                    case ORDER_REFUND_LAYOUT:
                        if (cJRTrainOrderSummaryResponse.getBody() != null && ((cJRTrainOrderSummaryResponse.getBody().getRefunds() != null && cJRTrainOrderSummaryResponse.getBody().getRefunds().size() > 0) || (cJRTrainOrderSummaryResponse.getBody().getRefundDetails() != null && cJRTrainOrderSummaryResponse.getBody().getRefundDetails().size() > 0))) {
                            CJRTrainSummaryItem cJRTrainSummaryItem7 = new CJRTrainSummaryItem();
                            cJRTrainSummaryItem7.setLayoutType(ai.ORDER_REFUND_LAYOUT.getName());
                            cJRTrainSummaryItem7.setItem(cJRTrainOrderSummaryResponse.getBody());
                            cJRTrainSummaryItem7.setMetaItem(cJRTrainOrderSummaryResponse.getMeta());
                            arrayList.add(cJRTrainSummaryItem7);
                            break;
                        }
                    case ORDER_TEXT_HOLDER_LAYOUT:
                        if (!(cJRTrainOrderSummaryResponse.getBody() == null || cJRTrainOrderSummaryResponse.getBody().getTextHolder() == null)) {
                            CJRTrainSummaryItem cJRTrainSummaryItem8 = new CJRTrainSummaryItem();
                            cJRTrainSummaryItem8.setLayoutType(ai.ORDER_TEXT_HOLDER_LAYOUT.getName());
                            cJRTrainSummaryItem8.setItem(cJRTrainOrderSummaryResponse.getBody().getTextHolder());
                            arrayList.add(cJRTrainSummaryItem8);
                            break;
                        }
                    case ORDER_GST_DETAILS_LAYOUT:
                        if (!(cJRTrainOrderSummaryResponse.getBody() == null || cJRTrainOrderSummaryResponse.getBody().getGstDetails() == null || TextUtils.isEmpty(cJRTrainOrderSummaryResponse.getBody().getGstDetails().getGstIn()))) {
                            CJRTrainSummaryItem cJRTrainSummaryItem9 = new CJRTrainSummaryItem();
                            cJRTrainSummaryItem9.setLayoutType(ai.ORDER_GST_DETAILS_LAYOUT.getName());
                            cJRTrainSummaryItem9.setItem(cJRTrainOrderSummaryResponse.getBody());
                            arrayList.add(cJRTrainSummaryItem9);
                            break;
                        }
                    case ORDER_CONTACT_US_LAYOUT:
                        if (!(cJRTrainOrderSummaryResponse.getBody() == null || cJRTrainOrderSummaryResponse.getBody().getFooter() == null)) {
                            CJRTrainSummaryItem cJRTrainSummaryItem10 = new CJRTrainSummaryItem();
                            cJRTrainSummaryItem10.setLayoutType(ai.ORDER_CONTACT_US_LAYOUT.getName());
                            cJRTrainSummaryItem10.setItem(cJRTrainOrderSummaryResponse);
                            arrayList.add(cJRTrainSummaryItem10);
                            break;
                        }
                    case ORDER_CANCELLATION_CHARGES_LAYOUT:
                        if (!(cJRTrainOrderSummaryResponse.getBody() == null || cJRTrainOrderSummaryResponse.getBody().getCancellationCharges() == null || !cJRTrainOrderSummaryResponse.getBody().getCancellationCharges().getEnabled())) {
                            CJRTrainSummaryItem cJRTrainSummaryItem11 = new CJRTrainSummaryItem();
                            cJRTrainSummaryItem11.setLayoutType(ai.ORDER_CANCELLATION_CHARGES_LAYOUT.getName());
                            cJRTrainSummaryItem11.setItem(cJRTrainOrderSummaryResponse.getBody().getCancellationCharges());
                            cJRTrainSummaryItem11.setMetaItem(cJRTrainOrderSummaryResponse.getMeta());
                            arrayList.add(cJRTrainSummaryItem11);
                            break;
                        }
                }
            }
        }
        a(arrayList, cJRTrainOrderSummaryResponse);
        return arrayList;
    }

    public final boolean b(CJRTrainOrderSummaryResponse cJRTrainOrderSummaryResponse) {
        boolean z;
        if (cJRTrainOrderSummaryResponse != null && cJRTrainOrderSummaryResponse.getMeta() != null && cJRTrainOrderSummaryResponse.getMeta().getPositionDetails() != null && cJRTrainOrderSummaryResponse.getMeta().getPositionDetails().size() > 0) {
            ArrayList<String> positionDetails = cJRTrainOrderSummaryResponse.getMeta().getPositionDetails();
            int i2 = 0;
            while (true) {
                if (i2 >= positionDetails.size()) {
                    break;
                } else if (ai.fromName(positionDetails.get(i2)).equals(ai.ORDER_VIP_CASHBACK_LAYOUT)) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
        }
        z = false;
        if (z && cJRTrainOrderSummaryResponse.getBody() != null && cJRTrainOrderSummaryResponse.getBody().getCashback() != null && cJRTrainOrderSummaryResponse.getBody().getCashback().f27720a) {
            com.travel.train.b.a();
            if (com.travel.train.b.b().a(this.f27305a) && !TextUtils.isEmpty(this.f27311g) && this.f27311g.equalsIgnoreCase("Payment")) {
                return c(cJRTrainOrderSummaryResponse);
            }
        }
        return false;
    }

    private static boolean c(CJRTrainOrderSummaryResponse cJRTrainOrderSummaryResponse) {
        try {
            if (7 == cJRTrainOrderSummaryResponse.getBody().getOrderStatus().getStatus()) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            q.d(e2.getMessage());
            return false;
        }
    }

    private static void a(ArrayList<CJRTrainSummaryItem> arrayList, CJRTrainOrderSummaryResponse cJRTrainOrderSummaryResponse) {
        if (cJRTrainOrderSummaryResponse.getBody() != null && cJRTrainOrderSummaryResponse.getBody().getPromotionalBanners() != null && cJRTrainOrderSummaryResponse.getBody().getPromotionalBanners().size() > 0) {
            for (int i2 = 0; i2 < cJRTrainOrderSummaryResponse.getBody().getPromotionalBanners().size(); i2++) {
                CJRTrainPromotionalBanner cJRTrainPromotionalBanner = cJRTrainOrderSummaryResponse.getBody().getPromotionalBanners().get(i2);
                if (cJRTrainPromotionalBanner != null && !TextUtils.isEmpty(cJRTrainPromotionalBanner.getUrl())) {
                    CJRTrainSummaryItem cJRTrainSummaryItem = new CJRTrainSummaryItem();
                    cJRTrainSummaryItem.setLayoutType(ai.ORDER_PROMOTION_BANNERS_LAYOUT.getName());
                    cJRTrainSummaryItem.setItem(cJRTrainPromotionalBanner);
                    if (cJRTrainPromotionalBanner.getPosition().equalsIgnoreCase("top")) {
                        int size = arrayList.size();
                        if (arrayList.size() > 0) {
                            int i3 = 0;
                            while (true) {
                                if (i3 >= arrayList.size()) {
                                    break;
                                } else if (arrayList.get(i3).getLayoutType().equalsIgnoreCase(ai.ORDER_STATUS_LAYOUT.getName())) {
                                    size = i3 + 1;
                                    break;
                                } else {
                                    i3++;
                                }
                            }
                        }
                        arrayList.add(size, cJRTrainSummaryItem);
                    } else {
                        int size2 = arrayList.size();
                        if (arrayList.size() > 0) {
                            int i4 = 0;
                            while (true) {
                                if (i4 >= arrayList.size()) {
                                    break;
                                } else if (arrayList.get(i4).getLayoutType().equalsIgnoreCase(ai.ORDER_FARE_DETAILS_LAYOUT.getName())) {
                                    size2 = i4 + 1;
                                    break;
                                } else {
                                    i4++;
                                }
                            }
                        }
                        arrayList.add(size2, cJRTrainSummaryItem);
                    }
                }
            }
        }
    }

    private static void b(ArrayList<CJRTrainSummaryItem> arrayList, CJRTrainOrderSummaryResponse cJRTrainOrderSummaryResponse) {
        if (cJRTrainOrderSummaryResponse.getBody() != null && cJRTrainOrderSummaryResponse.getBody().getCpActions() != null && cJRTrainOrderSummaryResponse.getBody().getCpActions().size() > 0) {
            for (int i2 = 0; i2 < cJRTrainOrderSummaryResponse.getBody().getCpActions().size(); i2++) {
                CJRTrainSummaryItem cJRTrainSummaryItem = new CJRTrainSummaryItem();
                cJRTrainSummaryItem.setLayoutType(ai.ORDER_CP_LAYOUT.getName());
                cJRTrainSummaryItem.setItem(cJRTrainOrderSummaryResponse.getBody().getCpActions().get(i2));
                arrayList.add(cJRTrainSummaryItem);
            }
        }
    }
}
