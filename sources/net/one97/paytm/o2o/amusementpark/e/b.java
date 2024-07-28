package net.one97.paytm.o2o.amusementpark.e;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.mobile.h5container.api.H5Param;
import com.google.gson.f;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.amPark.AmParkInputForm;
import net.one97.paytm.common.entity.amPark.AmParkTravellerResponseModel;
import net.one97.paytm.common.entity.amPark.CJRAddressDetailModel;
import net.one97.paytm.common.entity.amPark.CJRAmParkConvenienceFee;
import net.one97.paytm.common.entity.amPark.CJRAmParkDateTimeModel;
import net.one97.paytm.common.entity.amPark.CJRConfigurationModel;
import net.one97.paytm.common.entity.amPark.CJRInputMetaDataModel;
import net.one97.paytm.common.entity.amPark.CJRInputSeatInfo;
import net.one97.paytm.common.entity.amPark.CJRInputStaticMetaDataModel;
import net.one97.paytm.common.entity.amPark.CJRParticularAmParkDescriptionModel;
import net.one97.paytm.common.entity.amPark.CJRPrevalidateCartItemModel;
import net.one97.paytm.common.entity.amPark.CJRPrevalidateCartItemStaticModel;
import net.one97.paytm.common.entity.amPark.CJRPrevalidateInputModel;
import net.one97.paytm.common.entity.amPark.CJRPrevalidateStaticInputModel;
import net.one97.paytm.common.entity.amPark.CJRPromoValidateResponseModel;
import net.one97.paytm.common.entity.amPark.CJRPromoValidateStaticResponseModel;
import net.one97.paytm.common.entity.amPark.CJRResourceDetailModel;
import net.one97.paytm.common.entity.amPark.CJRSataticPassengerModel;
import net.one97.paytm.common.entity.amPark.CJRSeatDetailsModel;
import net.one97.paytm.common.entity.amPark.CJRValidatePackage;
import net.one97.paytm.common.entity.amPark.FormValuesData;
import net.one97.paytm.common.entity.movies.booking.CJRTaxInfo;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.o2o.amusementpark.R;
import net.one97.paytm.o2o.amusementpark.c.a.a;
import net.one97.paytm.o2o.amusementpark.d.c;
import net.one97.paytm.o2o.amusementpark.utils.d;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionHistory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b implements com.paytm.network.listener.b {

    /* renamed from: a  reason: collision with root package name */
    public Context f73605a;

    /* renamed from: b  reason: collision with root package name */
    public c f73606b;

    /* renamed from: c  reason: collision with root package name */
    public List<CJRSeatDetailsModel> f73607c;

    /* renamed from: d  reason: collision with root package name */
    public CJRParticularAmParkDescriptionModel f73608d;

    /* renamed from: e  reason: collision with root package name */
    public CJRPrevalidateInputModel f73609e;

    /* renamed from: f  reason: collision with root package name */
    public CJRPrevalidateStaticInputModel f73610f;

    /* renamed from: g  reason: collision with root package name */
    public AmParkTravellerResponseModel f73611g;

    /* renamed from: h  reason: collision with root package name */
    public Activity f73612h;

    /* renamed from: i  reason: collision with root package name */
    public CJRAmParkConvenienceFee f73613i;
    public CJRAddressDetailModel j;
    public String k;
    public CJRAmParkDateTimeModel.Time l;
    public String m;
    private CJRValidatePackage n;
    private a.C1473a o;

    public b(Context context, a.C1473a aVar) {
        this.f73605a = context;
        this.o = aVar;
    }

    public final void a() {
        this.f73609e = new CJRPrevalidateInputModel();
        CJRPrevalidateCartItemModel cJRPrevalidateCartItemModel = new CJRPrevalidateCartItemModel();
        cJRPrevalidateCartItemModel.setProduct_id(this.f73608d.getProductId());
        cJRPrevalidateCartItemModel.setQty("1");
        CJRConfigurationModel cJRConfigurationModel = new CJRConfigurationModel();
        cJRConfigurationModel.setPrice(String.valueOf(e()));
        cJRConfigurationModel.setconv_fee(String.valueOf(this.f73613i.getTotalCommision()));
        cJRPrevalidateCartItemModel.setConfiguration(cJRConfigurationModel);
        CJRInputMetaDataModel cJRInputMetaDataModel = new CJRInputMetaDataModel();
        cJRInputMetaDataModel.setEntityType("themeparks");
        cJRInputMetaDataModel.setEntityId(this.f73608d.getId());
        cJRInputMetaDataModel.setEntityName(this.f73608d.getName());
        cJRInputMetaDataModel.setEmail(this.j.getEmail());
        cJRInputMetaDataModel.setContact(this.j.getmContact());
        cJRInputMetaDataModel.setCategory(l());
        cJRInputMetaDataModel.setStartTime(this.k + " " + this.l.getmStart());
        cJRInputMetaDataModel.setEndTime(this.k + " " + this.l.getmTo());
        cJRInputMetaDataModel.setAddressName(this.j.getAddressName());
        cJRInputMetaDataModel.setAddress(this.j.getAddress());
        cJRInputMetaDataModel.setLatitude(String.valueOf(this.j.getLatitude()));
        cJRInputMetaDataModel.setLongitude(String.valueOf(this.j.getLongitude()));
        cJRInputMetaDataModel.setPincode(this.j.getPincode());
        cJRInputMetaDataModel.setProviderId(this.f73608d.getProviderId());
        cJRInputMetaDataModel.setProviderName(this.f73608d.getProviderName());
        cJRInputMetaDataModel.setTicketCount(n());
        cJRInputMetaDataModel.setTotalTicketPrice(String.valueOf(e()));
        a(cJRInputMetaDataModel);
        cJRInputMetaDataModel.setImageUrl(k());
        b(cJRInputMetaDataModel);
        cJRInputMetaDataModel.setVertical("amusement-parks");
        cJRInputMetaDataModel.setBookingId(this.f73611g.getProviderOid());
        cJRInputMetaDataModel.setProductId(this.f73608d.getProductId());
        c(cJRInputMetaDataModel);
        cJRInputMetaDataModel.setEntityCity(this.f73608d.getEntityCity());
        cJRInputMetaDataModel.setCitySearched(this.f73608d.getCitySearched());
        cJRInputMetaDataModel.setSeatMap(this.f73608d.getmSeatMap());
        cJRInputMetaDataModel.setMerchantId(this.f73608d.getmMerchantId());
        cJRPrevalidateCartItemModel.setMetadata(cJRInputMetaDataModel);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cJRPrevalidateCartItemModel);
        this.f73609e.setCart_items((ArrayList<CJRPrevalidateCartItemModel>) arrayList);
    }

    public final void b() {
        this.f73610f = new CJRPrevalidateStaticInputModel();
        CJRPrevalidateCartItemStaticModel cJRPrevalidateCartItemStaticModel = new CJRPrevalidateCartItemStaticModel();
        cJRPrevalidateCartItemStaticModel.setProduct_id(this.f73608d.getProductId());
        cJRPrevalidateCartItemStaticModel.setQty("1");
        CJRConfigurationModel cJRConfigurationModel = new CJRConfigurationModel();
        cJRConfigurationModel.setPrice(String.valueOf(e()));
        cJRConfigurationModel.setconv_fee(String.valueOf(this.f73613i.getTotalCommision()));
        cJRPrevalidateCartItemStaticModel.setConfiguration(cJRConfigurationModel);
        CJRInputStaticMetaDataModel cJRInputStaticMetaDataModel = new CJRInputStaticMetaDataModel();
        cJRInputStaticMetaDataModel.setEntityType("themeparks");
        cJRInputStaticMetaDataModel.setEntityId(this.f73608d.getId());
        cJRInputStaticMetaDataModel.setEntityName(this.f73608d.getName());
        cJRInputStaticMetaDataModel.setEmail(this.j.getEmail());
        cJRInputStaticMetaDataModel.setContact(this.j.getmContact());
        cJRInputStaticMetaDataModel.setCategory(l());
        cJRInputStaticMetaDataModel.setStartTime(this.k + " " + this.l.getmStart());
        cJRInputStaticMetaDataModel.setEndTime(this.k + " " + this.l.getmTo());
        cJRInputStaticMetaDataModel.setAddressName(this.j.getAddressName());
        cJRInputStaticMetaDataModel.setAddress(this.j.getAddress());
        cJRInputStaticMetaDataModel.setLatitude(String.valueOf(this.j.getLatitude()));
        cJRInputStaticMetaDataModel.setLongitude(String.valueOf(this.j.getLongitude()));
        cJRInputStaticMetaDataModel.setPincode(this.j.getPincode());
        cJRInputStaticMetaDataModel.setProviderId(this.f73608d.getProviderId());
        cJRInputStaticMetaDataModel.setProviderName(this.f73608d.getProviderName());
        cJRInputStaticMetaDataModel.setTicketCount(n());
        cJRInputStaticMetaDataModel.setTotalTicketPrice(String.valueOf(e()));
        b(cJRInputStaticMetaDataModel);
        cJRInputStaticMetaDataModel.setImageUrl(k());
        a(cJRInputStaticMetaDataModel);
        cJRInputStaticMetaDataModel.setVertical("amusement-parks");
        cJRInputStaticMetaDataModel.setBookingId(this.f73611g.getProviderOid());
        cJRInputStaticMetaDataModel.setProductId(this.f73608d.getProductId());
        c(cJRInputStaticMetaDataModel);
        cJRInputStaticMetaDataModel.setEntityCity(this.f73608d.getEntityCity());
        cJRInputStaticMetaDataModel.setCitySearched(this.f73608d.getCitySearched());
        cJRInputStaticMetaDataModel.setSeatMap(this.f73608d.getmSeatMap());
        cJRInputStaticMetaDataModel.setMerchantId(this.f73608d.getmMerchantId());
        cJRPrevalidateCartItemStaticModel.setMetadata(cJRInputStaticMetaDataModel);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cJRPrevalidateCartItemStaticModel);
        this.f73610f.setCart_items((ArrayList<CJRPrevalidateCartItemStaticModel>) arrayList);
    }

    private void a(CJRInputStaticMetaDataModel cJRInputStaticMetaDataModel) {
        ArrayList arrayList;
        CJRSataticPassengerModel cJRSataticPassengerModel = new CJRSataticPassengerModel();
        AmParkTravellerResponseModel amParkTravellerResponseModel = this.f73611g;
        if (!(amParkTravellerResponseModel == null || amParkTravellerResponseModel.getForm() == null || this.f73611g.getForm().size() <= 0 || (arrayList = this.f73611g.getForm().get(0)) == null)) {
            Iterator it2 = arrayList.iterator();
            String str = "";
            String str2 = str;
            while (it2.hasNext()) {
                AmParkInputForm amParkInputForm = (AmParkInputForm) it2.next();
                if (amParkInputForm.getTitle().contains("First Name")) {
                    str = amParkInputForm.getAppliedData();
                } else if (amParkInputForm.getTitle().contains("Age")) {
                    cJRSataticPassengerModel.setAge(amParkInputForm.getAppliedData());
                } else if (amParkInputForm.getTitle().contains("Mobile Number")) {
                    cJRSataticPassengerModel.setMobileNumber(amParkInputForm.getAppliedData());
                } else if (amParkInputForm.getTitle().contains("EmailID")) {
                    cJRSataticPassengerModel.setEmail(amParkInputForm.getAppliedData());
                } else if (amParkInputForm.getTitle().contains("Pin Code")) {
                    cJRSataticPassengerModel.setPinCode(amParkInputForm.getAppliedData());
                } else if (amParkInputForm.getTitle().contains("City")) {
                    cJRSataticPassengerModel.setCity(amParkInputForm.getAppliedData());
                } else if (amParkInputForm.getTitle().contains("Last Name")) {
                    str2 = amParkInputForm.getAppliedData();
                }
            }
            cJRSataticPassengerModel.setName(str.trim() + " " + str2.trim());
        }
        cJRInputStaticMetaDataModel.setPassenger(cJRSataticPassengerModel);
    }

    private String k() {
        List<CJRResourceDetailModel> resources;
        CJRParticularAmParkDescriptionModel cJRParticularAmParkDescriptionModel = this.f73608d;
        String str = "";
        if (!(cJRParticularAmParkDescriptionModel == null || (resources = cJRParticularAmParkDescriptionModel.getResources()) == null)) {
            for (CJRResourceDetailModel next : resources) {
                if (!TextUtils.isEmpty(next.getType()) && next.getType().toLowerCase().equalsIgnoreCase("thumbnail")) {
                    str = next.getValue1();
                    if (TextUtils.isEmpty(str)) {
                        str = next.getValue2();
                    }
                }
            }
        }
        return str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0010, code lost:
        r0 = (r0 = r0.getCategories()).get(0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String l() {
        /*
            r2 = this;
            net.one97.paytm.common.entity.amPark.CJRParticularAmParkDescriptionModel r0 = r2.f73608d
            if (r0 == 0) goto L_0x001e
            java.util.List r0 = r0.getCategories()
            if (r0 == 0) goto L_0x001e
            int r1 = r0.size()
            if (r1 <= 0) goto L_0x001e
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            net.one97.paytm.common.entity.amPark.CJRCategoriesDetailModel r0 = (net.one97.paytm.common.entity.amPark.CJRCategoriesDetailModel) r0
            if (r0 == 0) goto L_0x001e
            java.lang.String r0 = r0.getCategory()
            goto L_0x0020
        L_0x001e:
            java.lang.String r0 = ""
        L_0x0020:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.amusementpark.e.b.l():java.lang.String");
    }

    private void b(CJRInputStaticMetaDataModel cJRInputStaticMetaDataModel) {
        ArrayList arrayList = new ArrayList();
        for (CJRSeatDetailsModel next : this.f73607c) {
            if (next.getSelectedQuantity() > 0) {
                CJRInputSeatInfo cJRInputSeatInfo = new CJRInputSeatInfo();
                cJRInputSeatInfo.setSeatId(String.valueOf(next.getSeatId()));
                cJRInputSeatInfo.setSeatType(next.getSeatType());
                cJRInputSeatInfo.setCount(next.getSelectedQuantity());
                cJRInputSeatInfo.setDescription(next.getSeatDescription());
                cJRInputSeatInfo.setPricePerSeat(String.valueOf(next.getPrice()));
                cJRInputSeatInfo.setProviderSeatId(next.getProviderSeatId());
                arrayList.add(cJRInputSeatInfo);
            }
        }
        cJRInputStaticMetaDataModel.setseatInfo(arrayList);
    }

    private void a(CJRInputMetaDataModel cJRInputMetaDataModel) {
        ArrayList arrayList = new ArrayList();
        for (CJRSeatDetailsModel next : this.f73607c) {
            if (next.getSelectedQuantity() > 0) {
                CJRInputSeatInfo cJRInputSeatInfo = new CJRInputSeatInfo();
                cJRInputSeatInfo.setSeatId(String.valueOf(next.getSeatId()));
                cJRInputSeatInfo.setSeatType(next.getSeatType());
                cJRInputSeatInfo.setCount(next.getSelectedQuantity());
                cJRInputSeatInfo.setDescription(next.getSeatDescription());
                cJRInputSeatInfo.setPackageType(next.getmPackageType());
                cJRInputSeatInfo.setPricePerSeat(String.valueOf(next.getPrice()));
                cJRInputSeatInfo.setProviderSeatId(next.getProviderSeatId());
                arrayList.add(cJRInputSeatInfo);
            }
        }
        cJRInputMetaDataModel.setseatInfo(arrayList);
    }

    private void b(CJRInputMetaDataModel cJRInputMetaDataModel) {
        cJRInputMetaDataModel.setPassenger(this.f73611g.getForm());
    }

    private void c(CJRInputStaticMetaDataModel cJRInputStaticMetaDataModel) {
        if (this.f73613i.getTaxList() != null) {
            Iterator<CJRTaxInfo> it2 = this.f73613i.getTaxList().iterator();
            while (it2.hasNext()) {
                CJRTaxInfo next = it2.next();
                if (next.getKey().equalsIgnoreCase("sgst")) {
                    cJRInputStaticMetaDataModel.setSgst(String.valueOf(next.getValue()));
                }
                if (next.getKey().equalsIgnoreCase("igst")) {
                    cJRInputStaticMetaDataModel.setIgst(String.valueOf(next.getValue()));
                }
                if (next.getKey().equalsIgnoreCase("cgst")) {
                    cJRInputStaticMetaDataModel.setCgst(String.valueOf(next.getValue()));
                }
                if (next.getKey().equalsIgnoreCase("convFee")) {
                    cJRInputStaticMetaDataModel.setConvFee(String.valueOf(next.getValue()));
                }
                if (next.getKey().equalsIgnoreCase("pgCharges")) {
                    cJRInputStaticMetaDataModel.setPgCharges(String.valueOf(next.getValue()));
                }
            }
        }
        if (this.f73613i.getTotalTaxList() != null) {
            Iterator<CJRTaxInfo> it3 = this.f73613i.getTotalTaxList().iterator();
            while (it3.hasNext()) {
                CJRTaxInfo next2 = it3.next();
                if (next2.getKey().equalsIgnoreCase("totalSGST")) {
                    cJRInputStaticMetaDataModel.setTotalSGST(String.valueOf(next2.getValue()));
                }
                if (next2.getKey().equalsIgnoreCase("totalIGST")) {
                    cJRInputStaticMetaDataModel.setTotalIGST(String.valueOf(next2.getValue()));
                }
                if (next2.getKey().equalsIgnoreCase("totalCGST")) {
                    cJRInputStaticMetaDataModel.setTotalCGST(String.valueOf(next2.getValue()));
                }
                if (next2.getKey().equalsIgnoreCase("totalConvFee")) {
                    cJRInputStaticMetaDataModel.setTotalConvFee(String.valueOf(next2.getValue()));
                }
                if (next2.getKey().equalsIgnoreCase("totalPgCharges")) {
                    cJRInputStaticMetaDataModel.setTotalPgCharges(String.valueOf(next2.getValue()));
                }
                if (next2.getKey().equalsIgnoreCase("otherTax")) {
                    cJRInputStaticMetaDataModel.setOtherTax(String.valueOf(next2.getValue()));
                }
            }
        }
        cJRInputStaticMetaDataModel.setTotalCommision(String.valueOf(this.f73613i.getTotalCommision()));
    }

    private void c(CJRInputMetaDataModel cJRInputMetaDataModel) {
        if (this.f73613i.getTaxList() != null) {
            Iterator<CJRTaxInfo> it2 = this.f73613i.getTaxList().iterator();
            while (it2.hasNext()) {
                CJRTaxInfo next = it2.next();
                if (next.getKey().equalsIgnoreCase("sgst")) {
                    cJRInputMetaDataModel.setSgst(String.valueOf(next.getValue()));
                }
                if (next.getKey().equalsIgnoreCase("igst")) {
                    cJRInputMetaDataModel.setIgst(String.valueOf(next.getValue()));
                }
                if (next.getKey().equalsIgnoreCase("cgst")) {
                    cJRInputMetaDataModel.setCgst(String.valueOf(next.getValue()));
                }
                if (next.getKey().equalsIgnoreCase("convFee")) {
                    cJRInputMetaDataModel.setConvFee(String.valueOf(next.getValue()));
                }
                if (next.getKey().equalsIgnoreCase("pgCharges")) {
                    cJRInputMetaDataModel.setPgCharges(String.valueOf(next.getValue()));
                }
            }
        }
        if (this.f73613i.getTotalTaxList() != null) {
            Iterator<CJRTaxInfo> it3 = this.f73613i.getTotalTaxList().iterator();
            while (it3.hasNext()) {
                CJRTaxInfo next2 = it3.next();
                if (next2.getKey().equalsIgnoreCase("totalSGST")) {
                    cJRInputMetaDataModel.setTotalSGST(String.valueOf(next2.getValue()));
                }
                if (next2.getKey().equalsIgnoreCase("totalIGST")) {
                    cJRInputMetaDataModel.setTotalIGST(String.valueOf(next2.getValue()));
                }
                if (next2.getKey().equalsIgnoreCase("totalCGST")) {
                    cJRInputMetaDataModel.setTotalCGST(String.valueOf(next2.getValue()));
                }
                if (next2.getKey().equalsIgnoreCase("totalConvFee")) {
                    cJRInputMetaDataModel.setTotalConvFee(String.valueOf(next2.getValue()));
                }
                if (next2.getKey().equalsIgnoreCase("totalPgCharges")) {
                    cJRInputMetaDataModel.setTotalPgCharges(String.valueOf(next2.getValue()));
                }
                if (next2.getKey().equalsIgnoreCase("otherTax")) {
                    cJRInputMetaDataModel.setOtherTax(String.valueOf(next2.getValue()));
                }
            }
        }
        cJRInputMetaDataModel.setTotalCommision(String.valueOf(this.f73613i.getTotalCommision()));
    }

    private void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            NetworkCustomError networkCustomError = new NetworkCustomError();
            networkCustomError.setmAlertTitle(this.f73605a.getString(R.string.error));
            networkCustomError.setAlertMessage(str);
            a(networkCustomError);
        }
    }

    private void a(NetworkCustomError networkCustomError) {
        if (networkCustomError != null) {
            String message = networkCustomError.getMessage();
            if (message != null && message.equalsIgnoreCase("417")) {
                com.paytm.utility.b.b(this.f73605a, networkCustomError.getAlertTitle(), networkCustomError.getMessage());
            } else if (networkCustomError.getMessage() != null && networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                com.paytm.utility.b.d(this.f73605a, networkCustomError.getUrl(), String.valueOf(networkCustomError.networkResponse.statusCode));
            } else if (TextUtils.isEmpty(networkCustomError.getAlertTitle()) && !TextUtils.isEmpty(networkCustomError.getAlertMessage())) {
                Context context = this.f73605a;
                com.paytm.utility.b.b(context, context.getResources().getString(R.string.error), networkCustomError.getAlertMessage());
            } else if (TextUtils.isEmpty(networkCustomError.getAlertTitle()) || TextUtils.isEmpty(networkCustomError.getAlertMessage())) {
                Context context2 = this.f73605a;
                com.paytm.utility.b.b(context2, context2.getResources().getString(R.string.network_error_heading), this.f73605a.getResources().getString(R.string.network_error_message) + " " + networkCustomError.getUrl());
            } else {
                com.paytm.utility.b.b(this.f73605a, networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
            }
        }
    }

    private JSONArray m() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (CJRSeatDetailsModel next : this.f73607c) {
            if (next.getSelectedQuantity() > 0) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("seatId", next.getSeatId());
                jSONObject.put("seatType", next.getSeatType());
                jSONObject.put("count", next.getSelectedQuantity());
                jSONObject.put(RequestConfirmationDialogFragment.KEY_DESCRIPTION, next.getSeatDescription());
                jSONObject.put("packageType", next.getmPackageType());
                jSONObject.put("pricePerSeat", next.getPrice());
                jSONObject.put("providerSeatId", next.getProviderSeatId());
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray;
    }

    private int n() {
        List<CJRSeatDetailsModel> list = this.f73607c;
        int i2 = 0;
        if (!(list == null || list.size() == 0)) {
            for (CJRSeatDetailsModel selectedQuantity : this.f73607c) {
                i2 += selectedQuantity.getSelectedQuantity();
            }
        }
        return i2;
    }

    public final String c() {
        JSONObject jSONObject = new JSONObject();
        int n2 = n();
        try {
            jSONObject.put("providerId", this.f73608d.getProviderId());
            jSONObject.put("entId", Integer.parseInt(this.f73608d.getId()));
            jSONObject.put("ticketCount", n2);
            jSONObject.put("seatInfo", m());
            return jSONObject.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    public final void d() {
        a(CJRAutomaticSubscriptionHistory.PROCESSING);
        AmParkTravellerResponseModel amParkTravellerResponseModel = this.f73611g;
        int flag = amParkTravellerResponseModel == null ? 0 : amParkTravellerResponseModel.getFlag();
        if (flag == 1) {
            a();
        } else {
            b();
        }
        if (flag != 1 || this.f73609e != null) {
            if (flag != 0 || this.f73610f != null) {
                String u = com.paytm.utility.b.u(this.f73605a, com.paytm.utility.c.b(net.one97.paytm.o2o.amusementpark.a.a().getStringFromGTM("ampark_prevalidate_url"), this.f73605a));
                if (flag == 0) {
                    this.f73610f.setPromocode(this.m);
                } else {
                    this.f73609e.setPromocode(this.m);
                }
                String b2 = new f().b(flag == 0 ? this.f73610f : this.f73609e);
                HashMap hashMap = new HashMap();
                hashMap.put("Content-Type", "application/json");
                com.paytm.network.b bVar = new com.paytm.network.b();
                bVar.f42877a = this.f73605a;
                bVar.f42878b = a.c.AM_PARK;
                bVar.f42879c = a.C0715a.POST;
                bVar.f42880d = u;
                bVar.f42881e = null;
                bVar.f42882f = hashMap;
                bVar.f42883g = null;
                bVar.f42884h = b2;
                bVar.f42885i = flag == 0 ? new CJRPrevalidateStaticInputModel() : new CJRPrevalidateInputModel();
                bVar.j = this;
                bVar.n = a.b.USER_FACING;
                bVar.o = "AmPark";
                bVar.t = j();
                com.paytm.network.a l2 = bVar.l();
                l2.f42859c = false;
                l2.a();
            }
        }
    }

    private void o() {
        a(CJRAutomaticSubscriptionHistory.PROCESSING);
        net.one97.paytm.o2o.amusementpark.a.a().getWalletToken(net.one97.paytm.o2o.amusementpark.a.a().getSSOToken(this.f73605a), this.f73612h, this);
    }

    private static String a(CJRConfigurationModel cJRConfigurationModel) {
        double parseDouble = !TextUtils.isEmpty(cJRConfigurationModel.getPrice()) ? Double.parseDouble(cJRConfigurationModel.getPrice()) : 0.0d;
        if (!TextUtils.isEmpty(cJRConfigurationModel.getconv_fee())) {
            parseDouble += Double.parseDouble(cJRConfigurationModel.getconv_fee());
        }
        return String.valueOf(parseDouble);
    }

    public final int e() {
        int i2 = 0;
        for (CJRSeatDetailsModel next : this.f73607c) {
            i2 += next.getSelectedQuantity() * next.getPrice();
        }
        return i2;
    }

    public final void a(String str) {
        a.C1473a aVar = this.o;
        if (aVar != null) {
            aVar.a(str);
        }
    }

    public final void f() {
        a.C1473a aVar = this.o;
        if (aVar != null) {
            aVar.i();
        }
    }

    public final String g() {
        CJRParticularAmParkDescriptionModel cJRParticularAmParkDescriptionModel = this.f73608d;
        if (cJRParticularAmParkDescriptionModel != null) {
            return cJRParticularAmParkDescriptionModel.getName();
        }
        return null;
    }

    public final String h() {
        CJRAmParkConvenienceFee cJRAmParkConvenienceFee = this.f73613i;
        if (cJRAmParkConvenienceFee == null || cJRAmParkConvenienceFee.getTaxList() == null) {
            return null;
        }
        Iterator<CJRTaxInfo> it2 = this.f73613i.getTaxList().iterator();
        while (it2.hasNext()) {
            CJRTaxInfo next = it2.next();
            if (next.getKey().equalsIgnoreCase("convFee")) {
                return String.valueOf(next.getValue());
            }
        }
        return null;
    }

    public final String i() {
        CJRAmParkConvenienceFee cJRAmParkConvenienceFee = this.f73613i;
        if (cJRAmParkConvenienceFee == null || cJRAmParkConvenienceFee.getTotalTaxList() == null) {
            return null;
        }
        Iterator<CJRTaxInfo> it2 = this.f73613i.getTotalTaxList().iterator();
        while (it2.hasNext()) {
            CJRTaxInfo next = it2.next();
            if (next.getKey().equalsIgnoreCase("totalConvFee")) {
                return String.valueOf(next.getValue());
            }
        }
        return null;
    }

    public final JSONObject a(List<CJRSeatDetailsModel> list, ArrayList<ArrayList<AmParkInputForm>> arrayList) {
        if (list == null || list.size() == 0 || this.f73608d == null) {
            return null;
        }
        int i2 = 0;
        for (CJRSeatDetailsModel selectedQuantity : list) {
            i2 += selectedQuantity.getSelectedQuantity();
        }
        JSONObject jSONObject = new JSONObject();
        String a2 = d.a(this.f73608d.getmParkDateTimeList().get(0).getmTime().getmStart(), "hh:mm:ss", "h:mm a");
        try {
            jSONObject.put("providerId", this.f73608d.getProviderId());
            jSONObject.put("entId", this.f73608d.getId());
            jSONObject.put("ticketCount", i2);
            jSONObject.put("seatInfo", a(list));
            jSONObject.put("passenger", a(arrayList));
            jSONObject.put(H5Param.PAGE, 2);
            jSONObject.put("startTime", a2);
            jSONObject.put("channel", "android");
            jSONObject.put("version", 2);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    private static JSONArray a(ArrayList<ArrayList<AmParkInputForm>> arrayList) {
        if (arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            try {
                Iterator<ArrayList<AmParkInputForm>> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    JSONArray jSONArray2 = new JSONArray();
                    Iterator it3 = it2.next().iterator();
                    while (it3.hasNext()) {
                        AmParkInputForm amParkInputForm = (AmParkInputForm) it3.next();
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("title", amParkInputForm.getTitle());
                        jSONObject.put("type", amParkInputForm.getType());
                        jSONObject.put("applied", amParkInputForm.getAppliedData());
                        jSONObject.put("id", amParkInputForm.getId());
                        jSONObject.put("regex", amParkInputForm.getRegex());
                        JSONArray jSONArray3 = new JSONArray();
                        if (amParkInputForm.getType().equalsIgnoreCase("dropdown")) {
                            for (String put : amParkInputForm.getDropDownListValues()) {
                                jSONArray3.put(put);
                            }
                            jSONObject.put("values", jSONArray3);
                        } else if (amParkInputForm.getType().equalsIgnoreCase("radio")) {
                            for (String put2 : amParkInputForm.getRadioListValues()) {
                                jSONArray3.put(put2);
                            }
                            jSONObject.put("values", jSONArray3);
                        } else if (amParkInputForm.getType().equalsIgnoreCase("checkbox")) {
                            for (FormValuesData put3 : amParkInputForm.getCheckBoxListValues()) {
                                jSONArray3.put(put3);
                            }
                            jSONObject.put("values", jSONArray3);
                        } else {
                            jSONObject.put("values", amParkInputForm.getValues());
                        }
                        jSONObject.put("hint", amParkInputForm.getHint());
                        jSONObject.put("label", amParkInputForm.getLabel());
                        jSONObject.put("seat_id", amParkInputForm.getSeatId());
                        jSONObject.put("provider_seat_id", amParkInputForm.getProviderSeatId());
                        jSONArray2.put(jSONObject);
                    }
                    jSONArray.put(jSONArray2);
                }
                return jSONArray;
            } catch (Exception e2) {
                b.class.getSimpleName();
                e2.getMessage();
            }
        }
        return null;
    }

    private static JSONArray a(List<CJRSeatDetailsModel> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (CJRSeatDetailsModel next : list) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("seatId", next.getSeatId());
            jSONObject.put("seatType", next.getSeatType());
            jSONObject.put("count", next.getSelectedQuantity());
            jSONObject.put(RequestConfirmationDialogFragment.KEY_DESCRIPTION, next.getSeatDescription());
            jSONObject.put("pricePerSeat", next.getPrice());
            jSONObject.put("providerSeatId", next.getProviderSeatId());
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        CJRPrevalidateCartItemStaticModel cJRPrevalidateCartItemStaticModel;
        CJRPrevalidateCartItemModel cJRPrevalidateCartItemModel;
        c cVar = this.f73606b;
        if (cVar != null) {
            if (iJRPaytmDataModel instanceof CJRPrevalidateInputModel) {
                this.f73609e = (CJRPrevalidateInputModel) iJRPaytmDataModel;
                CJRPrevalidateInputModel cJRPrevalidateInputModel = this.f73609e;
                if (cJRPrevalidateInputModel == null || TextUtils.isEmpty(cJRPrevalidateInputModel.getError())) {
                    o();
                    return;
                }
                f();
                this.f73606b.b();
                b(this.f73609e.getError());
            } else if (iJRPaytmDataModel instanceof CJRPrevalidateStaticInputModel) {
                this.f73610f = (CJRPrevalidateStaticInputModel) iJRPaytmDataModel;
                CJRPrevalidateStaticInputModel cJRPrevalidateStaticInputModel = this.f73610f;
                if (cJRPrevalidateStaticInputModel == null || TextUtils.isEmpty(cJRPrevalidateStaticInputModel.getError())) {
                    o();
                    return;
                }
                f();
                b(this.f73610f.getError());
            } else {
                String str = null;
                if (iJRPaytmDataModel instanceof CJRPromoValidateResponseModel) {
                    f();
                    CJRPromoValidateResponseModel cJRPromoValidateResponseModel = (CJRPromoValidateResponseModel) iJRPaytmDataModel;
                    if (cJRPromoValidateResponseModel != null && cJRPromoValidateResponseModel.getCart() != null && cJRPromoValidateResponseModel.getCart().getCart_items() != null) {
                        this.f73609e = cJRPromoValidateResponseModel.getCart();
                        CJRPrevalidateInputModel cJRPrevalidateInputModel2 = this.f73609e;
                        if (cJRPrevalidateInputModel2 == null || cJRPrevalidateInputModel2.getPromostatus() == null || !this.f73609e.getPromostatus().equalsIgnoreCase("SUCCESS")) {
                            this.m = null;
                            CJRPrevalidateInputModel cJRPrevalidateInputModel3 = this.f73609e;
                            if (cJRPrevalidateInputModel3 != null) {
                                str = cJRPrevalidateInputModel3.getPromofailuretext();
                            }
                            if (str == null || str.trim().length() == 0) {
                                str = this.f73612h.getResources().getString(R.string.msg_invalid_recharge_promo_code);
                            }
                            Activity activity = this.f73612h;
                            com.paytm.utility.b.b((Context) activity, activity.getString(R.string.error), str);
                        } else if (this.f73609e.getCart_items() != null && this.f73609e.getCart_items().size() > 0 && (cJRPrevalidateCartItemModel = this.f73609e.getCart_items().get(0)) != null) {
                            this.f73606b.a(cJRPrevalidateCartItemModel.getPromocode(), cJRPrevalidateCartItemModel.getPromotext());
                        }
                    }
                } else if (iJRPaytmDataModel instanceof CJRPromoValidateStaticResponseModel) {
                    f();
                    CJRPromoValidateStaticResponseModel cJRPromoValidateStaticResponseModel = (CJRPromoValidateStaticResponseModel) iJRPaytmDataModel;
                    if (cJRPromoValidateStaticResponseModel != null && cJRPromoValidateStaticResponseModel.getCart() != null && cJRPromoValidateStaticResponseModel.getCart().getCart_items() != null) {
                        this.f73610f = cJRPromoValidateStaticResponseModel.getCart();
                        CJRPrevalidateStaticInputModel cJRPrevalidateStaticInputModel2 = this.f73610f;
                        if (cJRPrevalidateStaticInputModel2 == null || cJRPrevalidateStaticInputModel2.getPromostatus() == null || !this.f73610f.getPromostatus().equalsIgnoreCase("SUCCESS")) {
                            CJRPrevalidateStaticInputModel cJRPrevalidateStaticInputModel3 = this.f73610f;
                            if (cJRPrevalidateStaticInputModel3 != null) {
                                str = cJRPrevalidateStaticInputModel3.getPromofailuretext();
                            }
                            if (str == null || str.trim().length() == 0) {
                                str = this.f73612h.getResources().getString(R.string.msg_invalid_recharge_promo_code);
                            }
                            Activity activity2 = this.f73612h;
                            com.paytm.utility.b.b((Context) activity2, activity2.getString(R.string.error), str);
                        } else if (this.f73610f.getCart_items() != null && this.f73610f.getCart_items().size() > 0 && (cJRPrevalidateCartItemStaticModel = this.f73610f.getCart_items().get(0)) != null) {
                            this.f73606b.a(cJRPrevalidateCartItemStaticModel.getPromocode(), cJRPrevalidateCartItemStaticModel.getPromotext());
                        }
                    }
                } else if (iJRPaytmDataModel instanceof CJRAmParkConvenienceFee) {
                    f();
                    this.f73613i = (CJRAmParkConvenienceFee) iJRPaytmDataModel;
                    this.f73606b.a(this.f73613i);
                } else if (iJRPaytmDataModel instanceof CJRPGTokenList) {
                    String pgToken = net.one97.paytm.o2o.amusementpark.a.a().getPgToken((CJRPGTokenList) iJRPaytmDataModel);
                    if (!TextUtils.isEmpty(pgToken)) {
                        a(CJRAutomaticSubscriptionHistory.PROCESSING);
                        AmParkTravellerResponseModel amParkTravellerResponseModel = this.f73611g;
                        int flag = amParkTravellerResponseModel == null ? 0 : amParkTravellerResponseModel.getFlag();
                        String stringFromGTM = net.one97.paytm.o2o.amusementpark.a.a().getStringFromGTM("cartCheckout");
                        String k2 = com.paytm.utility.b.k();
                        HashMap hashMap = new HashMap();
                        hashMap.put("client_id", k2);
                        hashMap.put("native_withdraw", "1");
                        HashMap hashMap2 = new HashMap();
                        String jsonOfRiskExtendedInfo = net.one97.paytm.o2o.amusementpark.a.a().getJsonOfRiskExtendedInfo(this.f73605a);
                        if (!TextUtils.isEmpty(jsonOfRiskExtendedInfo)) {
                            hashMap2.put("risk_extended_info", jsonOfRiskExtendedInfo);
                        }
                        hashMap2.put("wallet_token", pgToken);
                        net.one97.paytm.o2o.amusementpark.a.a().clearRiskInformation();
                        HashMap<String, String> a2 = com.paytm.utility.b.a((HashMap<String, String>) hashMap2, this.f73605a);
                        a2.put("Content-Type", "application/json");
                        final String str2 = "";
                        if (flag == 0) {
                            this.f73610f.setPromocode(this.m);
                            CJRConfigurationModel configuration = this.f73610f.getCart_items().get(0).getConfiguration();
                            if (configuration != null) {
                                str2 = a(configuration);
                            }
                        } else {
                            this.f73609e.setPromocode(this.m);
                            CJRConfigurationModel configuration2 = this.f73609e.getCart_items().get(0).getConfiguration();
                            if (configuration2 != null) {
                                str2 = a(configuration2);
                            }
                        }
                        String b2 = new f().b(flag == 0 ? this.f73610f : this.f73609e);
                        String s = com.paytm.utility.b.s(this.f73605a, stringFromGTM);
                        com.paytm.network.b bVar = new com.paytm.network.b();
                        bVar.f42877a = this.f73605a;
                        bVar.f42878b = a.c.AM_PARK;
                        bVar.f42879c = a.C0715a.POST;
                        bVar.f42880d = s;
                        bVar.f42881e = null;
                        bVar.f42882f = a2;
                        bVar.f42883g = hashMap;
                        bVar.f42884h = b2;
                        bVar.f42885i = new CJRRechargePayment();
                        bVar.n = a.b.USER_FACING;
                        bVar.o = "AmPark";
                        bVar.r = true;
                        bVar.l = false;
                        bVar.j = new com.paytm.network.listener.b() {
                            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                                CJRRechargePayment cJRRechargePayment;
                                if ((iJRPaytmDataModel instanceof CJRRechargePayment) && (cJRRechargePayment = (CJRRechargePayment) iJRPaytmDataModel) != null) {
                                    if (b.a(cJRRechargePayment)) {
                                        net.one97.paytm.o2o.amusementpark.a.a().fetchPaymentOptions(b.this.f73605a, cJRRechargePayment, new net.one97.paytm.o2o.amusementpark.d.f(cJRRechargePayment, str2) {
                                            public final void a() {
                                                b.this.f();
                                                b.this.f73606b.a(r4, r5);
                                            }

                                            public final void b() {
                                                b.this.f();
                                                b.this.f73606b.a(r4, r5);
                                            }
                                        });
                                        return;
                                    }
                                    b.this.f();
                                    b.this.f73606b.a(cJRRechargePayment, str2);
                                }
                            }

                            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v21, resolved type: java.lang.Object} */
                            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v19, resolved type: com.paytm.network.model.CJRIllegalCodeError} */
                            /* JADX WARNING: Multi-variable type inference failed */
                            /* Code decompiled incorrectly, please refer to instructions dump. */
                            public final void handleErrorCode(int r2, com.paytm.network.model.IJRPaytmDataModel r3, com.paytm.network.model.NetworkCustomError r4) {
                                /*
                                    r1 = this;
                                    net.one97.paytm.o2o.amusementpark.e.b r2 = net.one97.paytm.o2o.amusementpark.e.b.this
                                    r2.f()
                                    net.one97.paytm.o2o.amusementpark.e.b r2 = net.one97.paytm.o2o.amusementpark.e.b.this
                                    net.one97.paytm.o2o.amusementpark.d.c r2 = r2.f73606b
                                    if (r2 == 0) goto L_0x0016
                                    net.one97.paytm.o2o.amusementpark.e.b r2 = net.one97.paytm.o2o.amusementpark.e.b.this
                                    net.one97.paytm.o2o.amusementpark.d.c r2 = r2.f73606b
                                    r2.b()
                                L_0x0016:
                                    if (r4 == 0) goto L_0x00ea
                                    java.lang.String r2 = new java.lang.String
                                    com.paytm.network.model.NetworkResponse r3 = r4.networkResponse
                                    byte[] r3 = r3.data
                                    r2.<init>(r3)
                                    r3 = 0
                                    boolean r0 = android.text.TextUtils.isEmpty(r2)
                                    if (r0 != 0) goto L_0x003d
                                    com.paytm.network.model.CJRIllegalCodeError r3 = new com.paytm.network.model.CJRIllegalCodeError
                                    r3.<init>()
                                    com.google.gsonhtcfix.f r0 = new com.google.gsonhtcfix.f
                                    r0.<init>()
                                    java.lang.Class r3 = r3.getClass()
                                    java.lang.Object r2 = r0.a((java.lang.String) r2, r3)
                                    r3 = r2
                                    com.paytm.network.model.CJRIllegalCodeError r3 = (com.paytm.network.model.CJRIllegalCodeError) r3
                                L_0x003d:
                                    java.lang.String r2 = r4.getMessage()
                                    if (r2 == 0) goto L_0x005d
                                    java.lang.String r0 = "417"
                                    boolean r2 = r2.equalsIgnoreCase(r0)
                                    if (r2 == 0) goto L_0x005d
                                    net.one97.paytm.o2o.amusementpark.e.b r2 = net.one97.paytm.o2o.amusementpark.e.b.this
                                    android.content.Context r2 = r2.f73605a
                                    java.lang.String r3 = r4.getAlertMessage()
                                    java.lang.String r4 = r4.getMessage()
                                    com.paytm.utility.b.b((android.content.Context) r2, (java.lang.String) r3, (java.lang.String) r4)
                                    return
                                L_0x005d:
                                    java.lang.String r2 = r4.getMessage()
                                    if (r2 == 0) goto L_0x007f
                                    java.lang.String r2 = r4.getMessage()
                                    java.lang.String r0 = "parsing_error"
                                    boolean r2 = r2.equalsIgnoreCase(r0)
                                    if (r2 == 0) goto L_0x007f
                                    net.one97.paytm.o2o.amusementpark.e.b r2 = net.one97.paytm.o2o.amusementpark.e.b.this
                                    android.content.Context r2 = r2.f73605a
                                    java.lang.String r3 = r4.getUrl()
                                    java.lang.String r4 = ""
                                    com.paytm.utility.b.d((android.content.Context) r2, (java.lang.String) r3, (java.lang.String) r4)
                                    return
                                L_0x007f:
                                    com.paytm.network.model.CJRStatusError r2 = r3.getStatusError()
                                    if (r2 == 0) goto L_0x00b1
                                    com.paytm.network.model.CJRStatusError r2 = r3.getStatusError()
                                    com.paytm.network.model.CJRError r2 = r2.getmMessage()
                                    if (r2 == 0) goto L_0x00b1
                                    net.one97.paytm.o2o.amusementpark.e.b r2 = net.one97.paytm.o2o.amusementpark.e.b.this
                                    android.app.Activity r2 = r2.f73612h
                                    com.paytm.network.model.CJRStatusError r4 = r3.getStatusError()
                                    com.paytm.network.model.CJRError r4 = r4.getmMessage()
                                    java.lang.String r4 = r4.getTitle()
                                    com.paytm.network.model.CJRStatusError r3 = r3.getStatusError()
                                    com.paytm.network.model.CJRError r3 = r3.getmMessage()
                                    java.lang.String r3 = r3.getMessage()
                                    com.paytm.utility.b.b((android.content.Context) r2, (java.lang.String) r4, (java.lang.String) r3)
                                    return
                                L_0x00b1:
                                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                                    r2.<init>()
                                    net.one97.paytm.o2o.amusementpark.e.b r3 = net.one97.paytm.o2o.amusementpark.e.b.this
                                    android.content.Context r3 = r3.f73605a
                                    int r0 = net.one97.paytm.o2o.amusementpark.R.string.network_error_message
                                    java.lang.String r3 = r3.getString(r0)
                                    r2.append(r3)
                                    java.lang.String r3 = " "
                                    r2.append(r3)
                                    java.lang.String r3 = r4.getUrl()
                                    r2.append(r3)
                                    java.lang.String r2 = r2.toString()
                                    net.one97.paytm.o2o.amusementpark.e.b r3 = net.one97.paytm.o2o.amusementpark.e.b.this
                                    android.content.Context r3 = r3.f73605a
                                    net.one97.paytm.o2o.amusementpark.e.b r4 = net.one97.paytm.o2o.amusementpark.e.b.this
                                    android.content.Context r4 = r4.f73605a
                                    int r0 = net.one97.paytm.o2o.amusementpark.R.string.network_error_heading
                                    java.lang.String r4 = r4.getString(r0)
                                    com.paytm.utility.b.b((android.content.Context) r3, (java.lang.String) r4, (java.lang.String) r2)
                                L_0x00ea:
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.amusementpark.e.b.AnonymousClass1.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void");
                            }
                        };
                        bVar.t = j();
                        com.paytm.network.a l2 = bVar.l();
                        l2.f42859c = false;
                        l2.a();
                        return;
                    }
                    net.one97.paytm.o2o.amusementpark.a.a().showSessionTimeoutAlert(this.f73612h, (String) null, (Bundle) null, (Exception) null);
                } else if (iJRPaytmDataModel instanceof CJRValidatePackage) {
                    this.n = (CJRValidatePackage) iJRPaytmDataModel;
                    if (cVar != null) {
                        cVar.a(this.n);
                    } else {
                        f();
                    }
                }
            }
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        c cVar = this.f73606b;
        if (cVar != null) {
            cVar.b();
            f();
            CJRAmParkConvenienceFee cJRAmParkConvenienceFee = this.f73613i;
            if (cJRAmParkConvenienceFee == null) {
                this.f73606b.a(cJRAmParkConvenienceFee);
            }
            a(networkCustomError);
        }
    }

    public static JSONObject j() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "AmParkReviewAndPayPresenter");
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    static /* synthetic */ boolean a(CJRRechargePayment cJRRechargePayment) {
        return "1".equalsIgnoreCase(cJRRechargePayment.isNativeEnabled());
    }
}
