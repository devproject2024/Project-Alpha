package com.travel.train.helper;

import android.content.Context;
import android.text.TextUtils;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.business.merchantprofile.common.utility.ProfileSharedPreferences;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.travel.train.j.g;
import com.travel.train.j.o;
import com.travel.train.model.CJRTrainSearchInput;
import com.travel.train.model.trainticket.CJRPassengerInfo;
import com.travel.train.model.trainticket.CJRTrainAvailability;
import com.travel.train.model.trainticket.CJRTrainConfig;
import com.travel.train.model.trainticket.CJRTrainDetailsBody;
import com.travel.train.model.trainticket.CJRTrainSearchResultsTrain;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import org.json.JSONException;
import org.json.JSONObject;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    private String f27328a;

    /* renamed from: b  reason: collision with root package name */
    private String f27329b;

    /* renamed from: c  reason: collision with root package name */
    private String f27330c;

    /* renamed from: d  reason: collision with root package name */
    private String f27331d;

    /* renamed from: e  reason: collision with root package name */
    private String f27332e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f27333f = false;

    /* renamed from: g  reason: collision with root package name */
    private CJRTrainDetailsBody f27334g;

    /* renamed from: h  reason: collision with root package name */
    private Context f27335h;

    /* renamed from: i  reason: collision with root package name */
    private String f27336i;
    private String j = "CJRTrainReviewItineraryHelper";

    public l(Context context, CJRTrainDetailsBody cJRTrainDetailsBody, String str, String str2, boolean z, String str3) {
        this.f27335h = context;
        this.f27328a = str;
        this.f27329b = str2;
        this.f27334g = cJRTrainDetailsBody;
        this.f27333f = z;
        this.f27331d = str3;
        CJRTrainDetailsBody cJRTrainDetailsBody2 = this.f27334g;
        if (cJRTrainDetailsBody2 != null) {
            CJRTrainAvailability cJRTrainAvailability = cJRTrainDetailsBody2.getmTrainAvailability().get(this.f27334g.getMiSelectedPosition());
            String[] split = this.f27334g.getSelectedBoardingStation().split("-");
            if (split.length > 0 && split[1] != null) {
                this.f27336i = split[1];
            }
            this.f27330c = cJRTrainAvailability.getmQuotaCode();
            this.f27332e = cJRTrainAvailability.getmDate();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:8|9|10|(1:12)|13|(3:16|17|(5:21|(1:23)|24|(1:26)|27))|(3:30|31|(1:33))|34|35|(8:37|(6:41|42|(2:48|74)|69|38|39)|70|49|(4:52|(4:58|59|60|79)|75|50)|62|63|(1:65))) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x00bd */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c3 A[Catch:{ JSONException -> 0x017b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.json.JSONObject a(com.travel.train.model.trainticket.CJRTrainDetailsBody r10, com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r11, com.travel.train.model.CJRTrainSearchInput r12) {
        /*
            r9 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            org.json.JSONArray r1 = new org.json.JSONArray
            r1.<init>()
            org.json.JSONArray r2 = new org.json.JSONArray
            r2.<init>()
            if (r10 == 0) goto L_0x0183
            java.lang.String r3 = "mobileNumber"
            java.lang.String r4 = r10.getUserMobileNumber()     // Catch:{ JSONException -> 0x017b }
            r0.put(r3, r4)     // Catch:{ JSONException -> 0x017b }
            java.lang.String r3 = r11.getMirctcuserid()     // Catch:{ JSONException -> 0x017b }
            if (r3 != 0) goto L_0x002d
            android.content.Context r10 = r9.f27335h     // Catch:{ JSONException -> 0x017b }
            android.content.res.Resources r10 = r10.getResources()     // Catch:{ JSONException -> 0x017b }
            int r11 = com.travel.train.R.string.train_irctc_user_id_error     // Catch:{ JSONException -> 0x017b }
            r10.getString(r11)     // Catch:{ JSONException -> 0x017b }
            r10 = 0
            return r10
        L_0x002d:
            java.lang.String r3 = "irctcUserId"
            java.lang.String r11 = r11.getMirctcuserid()     // Catch:{ JSONException -> 0x017b }
            r0.put(r3, r11)     // Catch:{ JSONException -> 0x017b }
            java.lang.String r11 = r10.getEmailAddress()     // Catch:{ JSONException -> 0x0049 }
            boolean r3 = android.text.TextUtils.isEmpty(r11)     // Catch:{ JSONException -> 0x0049 }
            if (r3 != 0) goto L_0x0044
            java.lang.String r11 = r11.trim()     // Catch:{ JSONException -> 0x0049 }
        L_0x0044:
            java.lang.String r3 = "email"
            r0.put(r3, r11)     // Catch:{ JSONException -> 0x0049 }
        L_0x0049:
            if (r10 == 0) goto L_0x0087
            com.travel.train.model.trainticket.CJRTrainPreferences r11 = r10.getTrainPreferences()     // Catch:{ JSONException -> 0x0087 }
            if (r11 == 0) goto L_0x0087
            com.travel.train.model.trainticket.CJRTrainPreferences r11 = r10.getTrainPreferences()     // Catch:{ JSONException -> 0x0087 }
            boolean r11 = r11.isEnable()     // Catch:{ JSONException -> 0x0087 }
            if (r11 == 0) goto L_0x0087
            int r11 = r10.getReservationCode()     // Catch:{ JSONException -> 0x0087 }
            r3 = -1
            if (r11 == r3) goto L_0x006b
            java.lang.String r11 = "reservationChoice"
            int r3 = r10.getReservationCode()     // Catch:{ JSONException -> 0x0087 }
            r0.put(r11, r3)     // Catch:{ JSONException -> 0x0087 }
        L_0x006b:
            java.lang.String r11 = r10.getCoachNumber()     // Catch:{ JSONException -> 0x0087 }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ JSONException -> 0x0087 }
            if (r11 != 0) goto L_0x007e
            java.lang.String r11 = "coachId"
            java.lang.String r3 = r10.getCoachNumber()     // Catch:{ JSONException -> 0x0087 }
            r0.put(r11, r3)     // Catch:{ JSONException -> 0x0087 }
        L_0x007e:
            java.lang.String r11 = "autoupgrade"
            boolean r3 = r10.getAutoUpgrade()     // Catch:{ JSONException -> 0x0087 }
            r0.put(r11, r3)     // Catch:{ JSONException -> 0x0087 }
        L_0x0087:
            if (r10 == 0) goto L_0x00bd
            boolean r11 = r10.ismIsAddressCapture()     // Catch:{ JSONException -> 0x00bd }
            if (r11 == 0) goto L_0x00bd
            java.lang.String r11 = "address"
            java.lang.String r3 = r10.getmAddressLine()     // Catch:{ JSONException -> 0x00bd }
            r0.put(r11, r3)     // Catch:{ JSONException -> 0x00bd }
            java.lang.String r11 = "pinCode"
            java.lang.String r3 = r10.getmPincode()     // Catch:{ JSONException -> 0x00bd }
            r0.put(r11, r3)     // Catch:{ JSONException -> 0x00bd }
            java.lang.String r11 = "state"
            java.lang.String r3 = r10.getmState()     // Catch:{ JSONException -> 0x00bd }
            r0.put(r11, r3)     // Catch:{ JSONException -> 0x00bd }
            java.lang.String r11 = "city"
            java.lang.String r3 = r10.getmCity()     // Catch:{ JSONException -> 0x00bd }
            r0.put(r11, r3)     // Catch:{ JSONException -> 0x00bd }
            java.lang.String r11 = "postOffice"
            java.lang.String r3 = r10.getmPostOffice()     // Catch:{ JSONException -> 0x00bd }
            r0.put(r11, r3)     // Catch:{ JSONException -> 0x00bd }
        L_0x00bd:
            java.util.ArrayList r11 = r10.getPassengerInfo()     // Catch:{ JSONException -> 0x017b }
            if (r11 == 0) goto L_0x0183
            java.util.ArrayList r11 = r10.getPassengerInfo()     // Catch:{ JSONException -> 0x017b }
            com.travel.train.model.trainticket.CJRTrainConfig r10 = r10.getTrainConfig()     // Catch:{ JSONException -> 0x017b }
            java.util.Iterator r3 = r11.iterator()     // Catch:{ JSONException -> 0x017b }
            r4 = 0
            r5 = 0
        L_0x00d1:
            boolean r6 = r3.hasNext()     // Catch:{ JSONException -> 0x017b }
            java.lang.String r7 = "IF"
            if (r6 == 0) goto L_0x00fb
            java.lang.Object r6 = r3.next()     // Catch:{ JSONException -> 0x017b }
            com.travel.train.model.trainticket.CJRPassengerInfo r6 = (com.travel.train.model.trainticket.CJRPassengerInfo) r6     // Catch:{ JSONException -> 0x017b }
            if (r6 == 0) goto L_0x00d1
            java.lang.String r8 = r6.getmCategory()     // Catch:{ JSONException -> 0x017b }
            if (r8 == 0) goto L_0x00d1
            java.lang.String r8 = r6.getmCategory()     // Catch:{ JSONException -> 0x017b }
            boolean r7 = r8.equalsIgnoreCase(r7)     // Catch:{ JSONException -> 0x017b }
            if (r7 != 0) goto L_0x00d1
            org.json.JSONObject r6 = r9.a((int) r5, (com.travel.train.model.trainticket.CJRTrainConfig) r10, (com.travel.train.model.trainticket.CJRPassengerInfo) r6)     // Catch:{ JSONException -> 0x017b }
            r1.put(r6)     // Catch:{ JSONException -> 0x017b }
            int r5 = r5 + 1
            goto L_0x00d1
        L_0x00fb:
            java.lang.String r10 = "gst_details"
            org.json.JSONObject r12 = a((com.travel.train.model.CJRTrainSearchInput) r12)     // Catch:{ JSONException -> 0x017b }
            r0.put(r10, r12)     // Catch:{ JSONException -> 0x017b }
            java.lang.String r10 = "pax_info"
            r0.put(r10, r1)     // Catch:{ JSONException -> 0x017b }
            java.util.Iterator r10 = r11.iterator()     // Catch:{ JSONException -> 0x017b }
        L_0x010d:
            boolean r11 = r10.hasNext()     // Catch:{ JSONException -> 0x017b }
            if (r11 == 0) goto L_0x016f
            java.lang.Object r11 = r10.next()     // Catch:{ JSONException -> 0x017b }
            com.travel.train.model.trainticket.CJRPassengerInfo r11 = (com.travel.train.model.trainticket.CJRPassengerInfo) r11     // Catch:{ JSONException -> 0x017b }
            if (r11 == 0) goto L_0x010d
            java.lang.String r12 = r11.getmCategory()     // Catch:{ JSONException -> 0x017b }
            if (r12 == 0) goto L_0x010d
            java.lang.String r12 = r11.getmCategory()     // Catch:{ JSONException -> 0x017b }
            boolean r12 = r12.equalsIgnoreCase(r7)     // Catch:{ JSONException -> 0x017b }
            if (r12 == 0) goto L_0x010d
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ JSONException -> 0x016c }
            r12.<init>()     // Catch:{ JSONException -> 0x016c }
            java.lang.String r1 = "name"
            java.lang.String r3 = r11.getFullName()     // Catch:{ JSONException -> 0x016c }
            r12.put(r1, r3)     // Catch:{ JSONException -> 0x016c }
            java.lang.String r1 = "age"
            java.lang.String r3 = r11.getAge()     // Catch:{ JSONException -> 0x016c }
            r12.put(r1, r3)     // Catch:{ JSONException -> 0x016c }
            java.lang.String r1 = "gender"
            java.lang.String r11 = r11.getTIttle()     // Catch:{ JSONException -> 0x016c }
            android.content.Context r3 = r9.f27335h     // Catch:{ JSONException -> 0x016c }
            java.lang.String r11 = com.travel.train.j.o.a((java.lang.String) r11, (android.content.Context) r3)     // Catch:{ JSONException -> 0x016c }
            r12.put(r1, r11)     // Catch:{ JSONException -> 0x016c }
            java.lang.String r11 = "passengerCategory"
            r12.put(r11, r7)     // Catch:{ JSONException -> 0x016c }
            java.lang.String r11 = "infantSerialNumber"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x016c }
            r1.<init>()     // Catch:{ JSONException -> 0x016c }
            int r3 = r4 + 1
            r1.append(r3)     // Catch:{ JSONException -> 0x016c }
            java.lang.String r1 = r1.toString()     // Catch:{ JSONException -> 0x016c }
            r12.put(r11, r1)     // Catch:{ JSONException -> 0x016c }
            r2.put(r12)     // Catch:{ JSONException -> 0x016c }
        L_0x016c:
            int r4 = r4 + 1
            goto L_0x010d
        L_0x016f:
            int r10 = r2.length()     // Catch:{ JSONException -> 0x017b }
            if (r10 <= 0) goto L_0x0183
            java.lang.String r10 = "infant_info"
            r0.put(r10, r2)     // Catch:{ JSONException -> 0x017b }
            goto L_0x0183
        L_0x017b:
            r10 = move-exception
            java.lang.String r10 = r10.getMessage()
            com.paytm.utility.q.c(r10)
        L_0x0183:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.helper.l.a(com.travel.train.model.trainticket.CJRTrainDetailsBody, com.travel.train.model.trainticket.CJRTrainSearchResultsTrain, com.travel.train.model.CJRTrainSearchInput):org.json.JSONObject");
    }

    private JSONObject a(int i2, CJRTrainConfig cJRTrainConfig, CJRPassengerInfo cJRPassengerInfo) {
        JSONObject jSONObject = new JSONObject();
        if (cJRPassengerInfo != null) {
            try {
                String str = cJRPassengerInfo.getmCategory();
                if (str.equalsIgnoreCase("SW") || str.equalsIgnoreCase("SM")) {
                    jSONObject.put("concessionOpted", cJRPassengerInfo.getIsSeniorCityZen());
                }
                if (str.equalsIgnoreCase("CH")) {
                    if (cJRTrainConfig.isChildBerthMandatory()) {
                        jSONObject.put("childBerthFlag", "true");
                    } else if (cJRPassengerInfo.isIsBerthFlag()) {
                        jSONObject.put("childBerthFlag", "true");
                    } else {
                        jSONObject.put("childBerthFlag", "false");
                    }
                }
                jSONObject.put("passengerCategory", str);
                if (cJRPassengerInfo.getBerthPreference() != null) {
                    o.h(cJRPassengerInfo.getBerthPreference());
                    if (!TextUtils.isEmpty(o.h(cJRPassengerInfo.getBerthPreference()))) {
                        jSONObject.put("passengerBerthChoice", o.h(cJRPassengerInfo.getBerthPreference()));
                    }
                }
                jSONObject.put("passengerAge", cJRPassengerInfo.getAge());
                if (cJRTrainConfig.ismBedRollFlagEnabled()) {
                    jSONObject.put("passengerBedrollChoice", cJRPassengerInfo.isBedRollChoice());
                }
                jSONObject.put("passengerGender", o.a(cJRPassengerInfo.getTIttle(), this.f27335h));
                jSONObject.put("passengerName", cJRPassengerInfo.getFullName());
                jSONObject.put("passengerNationality", cJRPassengerInfo.getCountryCode());
                if (cJRTrainConfig.ismFoodChoiceEnables()) {
                    jSONObject.put("passengerFoodChoice", o.j(cJRPassengerInfo.getMealPreference()));
                }
                StringBuilder sb = new StringBuilder();
                sb.append(i2 + 1);
                jSONObject.put("passengerSerialNumber", sb.toString());
                if (cJRTrainConfig.ismIdRequired()) {
                    jSONObject.put("passengerIcardFlag", cJRTrainConfig.ismIdRequired());
                    jSONObject.put("passengerCardType", cJRPassengerInfo.getIdentity());
                    jSONObject.put("passengerCardNumber", cJRPassengerInfo.getIdNumber());
                }
                if (cJRPassengerInfo.getCountryCode() != null && !cJRPassengerInfo.getCountryCode().equalsIgnoreCase("IN")) {
                    jSONObject.put("passengerIcardFlag", true);
                    jSONObject.put("passengerCardType", "PASSPORT");
                    jSONObject.put("passengerCardNumber", cJRPassengerInfo.getPassportNumber());
                }
                if (this.f27331d != null) {
                    if (this.f27331d.equalsIgnoreCase("true")) {
                        jSONObject.put("travelInsuranceOpted", true);
                    }
                }
                jSONObject.put("travelInsuranceOpted", false);
            } catch (JSONException unused) {
            }
        }
        return jSONObject;
    }

    private static JSONObject a(CJRTrainSearchInput cJRTrainSearchInput) {
        JSONObject jSONObject = new JSONObject();
        if (cJRTrainSearchInput != null) {
            try {
                if (cJRTrainSearchInput.getmGSTINNumber() != null && !TextUtils.isEmpty(cJRTrainSearchInput.getmGSTINNumber().trim())) {
                    jSONObject.put("gstIn", cJRTrainSearchInput.getmGSTINNumber());
                }
                if (cJRTrainSearchInput.getmGSTName() != null && !TextUtils.isEmpty(cJRTrainSearchInput.getmGSTName().trim())) {
                    jSONObject.put("nameOnGst", cJRTrainSearchInput.getmGSTName());
                }
                if (cJRTrainSearchInput.getmGSTFlat() != null && !TextUtils.isEmpty(cJRTrainSearchInput.getmGSTFlat().trim())) {
                    jSONObject.put("flat", cJRTrainSearchInput.getmGSTFlat());
                }
                if (cJRTrainSearchInput.getmGSTStreet() != null && !TextUtils.isEmpty(cJRTrainSearchInput.getmGSTStreet().trim())) {
                    jSONObject.put("street", cJRTrainSearchInput.getmGSTStreet());
                }
                if (cJRTrainSearchInput.getmGSTPinCode() != null && !TextUtils.isEmpty(cJRTrainSearchInput.getmGSTPinCode().trim())) {
                    jSONObject.put("pin", cJRTrainSearchInput.getmGSTPinCode());
                }
                if (cJRTrainSearchInput.getmGSTState() != null && !TextUtils.isEmpty(cJRTrainSearchInput.getmGSTState().trim())) {
                    jSONObject.put("state", cJRTrainSearchInput.getmGSTState());
                }
                if (cJRTrainSearchInput.getmGSTCity() != null && !TextUtils.isEmpty(cJRTrainSearchInput.getmGSTCity().trim())) {
                    jSONObject.put("city", cJRTrainSearchInput.getmGSTCity());
                    jSONObject.put(ProfileSharedPreferences.AREA, "");
                }
            } catch (JSONException e2) {
                q.c(e2.getMessage());
            }
        }
        return jSONObject;
    }

    public final HashMap<String, String> a(CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain, boolean z) {
        String b2 = b.b(this.f27332e, "yyyy-mm-dd", "yyyymmdd");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("source", cJRTrainSearchResultsTrain.getSource());
        hashMap.put("destination", cJRTrainSearchResultsTrain.getDestination());
        hashMap.put("departureDate", b2);
        hashMap.put("requestid", this.f27328a);
        hashMap.put("trainNumber", cJRTrainSearchResultsTrain.getTrainNumber());
        hashMap.put(Item.KEY_CLASS, this.f27329b);
        hashMap.put("quota", this.f27330c);
        hashMap.put("boardingStation", this.f27336i.trim());
        hashMap.put("train_type", cJRTrainSearchResultsTrain.getTrainType());
        if (this.f27334g.ismIsAddressCapture()) {
            hashMap.put("captureAddress", "1");
        }
        if (!(g.f27551a == null || g.f27551a.getTestId() == null)) {
            hashMap.put("test_id", g.f27551a.getTestId().toString());
        }
        if (z) {
            hashMap.put("alternate_stations", "true");
        }
        return hashMap;
    }

    public final HashMap<String, String> a(boolean z, boolean z2, boolean z3, HashMap<Integer, String> hashMap, boolean z4, boolean z5, boolean z6) {
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("requestid", this.f27328a);
        if (!(g.f27551a == null || g.f27551a.getTestId() == null)) {
            hashMap2.put("test_id", g.f27551a.getTestId().toString());
        }
        if (z) {
            hashMap2.put("alternate_stations", "true");
        }
        if (z2) {
            hashMap2.put(AppConstants.WITHDRAW, "1");
        }
        if (z3) {
            hashMap2.put("cancellation_insurance_opted", "true");
        } else {
            for (Map.Entry<Integer, String> value : hashMap.entrySet()) {
                hashMap2.put((String) value.getValue(), "true");
            }
        }
        hashMap2.put("opt_out_pg_charges", String.valueOf(z4));
        hashMap2.put("opt_out_service_charges", String.valueOf(z5));
        if (z6) {
            hashMap2.put("native_withdraw", "1");
            hashMap2.put("payment_info", "1");
        }
        return hashMap2;
    }

    public static JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONObject.put(PayUtility.PROMO_CODE, str);
            } catch (JSONException e2) {
                q.c(e2.getMessage());
            }
        }
        return jSONObject;
    }
}
