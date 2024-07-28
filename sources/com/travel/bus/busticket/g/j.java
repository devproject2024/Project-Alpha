package com.travel.bus.busticket.g;

import android.app.Activity;
import android.content.Context;
import android.widget.CheckBox;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.travel.bus.busticket.fragment.m;
import com.travel.bus.busticket.i.p;
import com.travel.bus.pojo.busticket.CJRBusInsuranceItem;
import com.travel.bus.pojo.busticket.CJRBusInsurancePlans;
import com.travel.bus.pojo.busticket.CJRBusSearchInput;
import com.travel.bus.pojo.busticket.CJRBusSearchItem;
import com.travel.bus.pojo.busticket.CJRInsuranceDetail;
import com.travel.bus.pojo.busticket.CJRLocation;
import com.travel.bus.pojo.busticket.CJRPassengerDetails;
import com.travel.bus.pojo.busticket.TripBusDetailsItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class j implements b {

    /* renamed from: a  reason: collision with root package name */
    public m f22394a;

    /* renamed from: b  reason: collision with root package name */
    public Context f22395b;

    /* renamed from: c  reason: collision with root package name */
    private String f22396c = "CJRTravellerPresenter";

    /* renamed from: d  reason: collision with root package name */
    private Activity f22397d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f22398e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f22399f = false;

    public j(m mVar) {
        this.f22394a = mVar;
        this.f22397d = this.f22394a.getActivity();
        this.f22395b = this.f22397d.getApplicationContext();
    }

    public static ArrayList<CJRPassengerDetails> a(ArrayList<CJRPassengerDetails> arrayList, List<TripBusDetailsItem> list) {
        int size = (arrayList == null || arrayList.isEmpty()) ? 0 : arrayList.size();
        int i2 = 0;
        for (TripBusDetailsItem next : list) {
            CJRPassengerDetails cJRPassengerDetails = i2 < size ? arrayList.get(i2) : new CJRPassengerDetails();
            cJRPassengerDetails.setSeatNumber(next.getSeatName());
            cJRPassengerDetails.setGender("");
            if (i2 == 0) {
                cJRPassengerDetails.setIsFirstPassenger(true);
                cJRPassengerDetails.setIsPrimary(true);
            } else {
                cJRPassengerDetails.setIsFirstPassenger(false);
                cJRPassengerDetails.setIsPrimary(false);
            }
            if (next.getLadiesSeat().booleanValue()) {
                cJRPassengerDetails.setIsLadiesSeat(true);
            } else {
                cJRPassengerDetails.setIsLadiesSeat(false);
            }
            if (i2 < size) {
                arrayList.set(i2, cJRPassengerDetails);
            } else {
                arrayList.add(cJRPassengerDetails);
            }
            i2++;
        }
        return arrayList;
    }

    public static String a(CJRBusSearchInput cJRBusSearchInput, CJRBusSearchItem cJRBusSearchItem, String str) {
        JSONObject jSONObject = new JSONObject();
        if (cJRBusSearchInput != null) {
            try {
                jSONObject.put(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR, cJRBusSearchInput.getDate());
                if (cJRBusSearchItem != null) {
                    jSONObject.put("provider_id", cJRBusSearchItem.getOperatorObj().getProviderId());
                    jSONObject.put("provider_trip_id", cJRBusSearchItem.getTripId());
                }
                if (str != null) {
                    jSONObject.put("request_id", str);
                }
                jSONObject.put("is_return", false);
            } catch (JSONException e2) {
                q.c(e2.getMessage());
            }
        }
        return jSONObject.toString();
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof CJRBusInsurancePlans) {
            this.f22394a.a(0, iJRPaytmDataModel);
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (iJRPaytmDataModel instanceof CJRBusInsurancePlans) {
            this.f22394a.a(0, networkCustomError);
        }
    }

    public static String a(ArrayList<CJRPassengerDetails> arrayList, String str, String str2) {
        JSONArray jSONArray = new JSONArray();
        if (arrayList != null) {
            try {
                Iterator<CJRPassengerDetails> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    CJRPassengerDetails next = it2.next();
                    if (next != null) {
                        JSONObject jSONObject = new JSONObject();
                        if (next.getmTitle() != null) {
                            jSONObject.put("title", next.getmTitle());
                        }
                        if (next.getPassengerName() != null) {
                            jSONObject.put("fullname", next.getPassengerName());
                        }
                        jSONObject.put("age", next.getPassengerage());
                        String str3 = null;
                        String str4 = (next == null || !next.getIsPrimary()) ? null : str;
                        if (str != null) {
                            jSONObject.put(AppConstants.KEY_EMAIL, str4);
                        }
                        if (next != null && next.getIsPrimary()) {
                            str3 = str2;
                        }
                        if (str3 != null) {
                            jSONObject.put("mobile", str3);
                        }
                        jSONArray.put(jSONObject);
                    }
                }
            } catch (JSONException e2) {
                q.c(e2.getMessage());
            }
        }
        return jSONArray.toString();
    }

    public static void a(Context context, String str, Map<String, String> map, String str2, a.C0715a aVar, IJRPaytmDataModel iJRPaytmDataModel, b bVar) {
        com.paytm.network.b bVar2 = new com.paytm.network.b();
        bVar2.f42877a = context;
        bVar2.f42878b = a.c.BUS;
        bVar2.f42879c = aVar;
        bVar2.f42880d = str;
        bVar2.f42881e = null;
        bVar2.f42882f = map;
        bVar2.f42883g = null;
        bVar2.f42884h = str2;
        bVar2.f42885i = iJRPaytmDataModel;
        bVar2.j = bVar;
        bVar2.t = a();
        bVar2.n = a.b.SILENT;
        bVar2.o = "bus-traveller-page";
        bVar2.l().a();
    }

    private static JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "BusTravellersScreen");
        } catch (JSONException e2) {
            q.c(e2.getMessage());
        }
        return jSONObject;
    }

    public static String a(Context context, CJRBusSearchInput cJRBusSearchInput, CJRBusSearchItem cJRBusSearchItem, String str, CJRLocation cJRLocation, CJRLocation cJRLocation2, List<CJRPassengerDetails> list, String str2, boolean z, CJRBusInsuranceItem cJRBusInsuranceItem, String str3, String str4, boolean z2, boolean z3, String str5, String str6, String str7, String str8, String str9, CheckBox checkBox) {
        String str10 = str;
        boolean z4 = z;
        String str11 = str3;
        if (list != null) {
            for (CJRPassengerDetails next : list) {
                if (next != null) {
                    next.setInsuranceEnabled(z4);
                    next.setInsuranceDetailObj((!z4 || cJRBusInsuranceItem == null) ? null : new CJRInsuranceDetail(cJRBusInsuranceItem.getId()));
                }
            }
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (cJRBusSearchInput != null) {
            try {
                jSONObject2.put(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR, cJRBusSearchInput.getDate());
            } catch (JSONException e2) {
                q.c(e2.getMessage());
            }
        }
        if (cJRBusSearchItem != null) {
            jSONObject2.put("provider_id", cJRBusSearchItem.getOperatorObj().getProviderId());
            jSONObject2.put("provider_trip_id", cJRBusSearchItem.getTripId());
        }
        if (cJRLocation != null) {
            jSONObject2.put("boarding_point_id", cJRLocation.getProviderLocationId());
        }
        if (cJRLocation2 != null) {
            jSONObject2.put("dropping_point_id", cJRLocation2.getProviderLocationId());
        }
        jSONObject2.put("isSingleLady", z2);
        if (list != null) {
            JSONObject jSONObject3 = new JSONObject();
            Iterator<CJRPassengerDetails> it2 = list.iterator();
            while (true) {
                if (it2.hasNext()) {
                    CJRPassengerDetails next2 = it2.next();
                    if (next2 != null) {
                        if (next2.getmConcessionType() != null) {
                            if (next2.getmConcessionType() == "Senior Citizen") {
                                jSONObject3.put("senior_citizen", next2.getmConcessionId());
                                jSONObject2.put("concession", jSONObject3);
                                break;
                            }
                        }
                        if (next2.getmConcessionType() != null && next2.getmConcessionType() == "Cat Card") {
                            jSONObject3.put("cat_card", next2.getmConcessionId());
                            jSONObject2.put("concession", jSONObject3);
                            break;
                        }
                    }
                } else {
                    break;
                }
            }
        }
        if (str10 != null) {
            jSONObject.put("requestid", str);
        }
        jSONObject.put("user_id", com.paytm.utility.b.n(context));
        jSONObject.put("version", "3");
        jSONObject.put("channel", "androidapp");
        if (cJRBusSearchInput != null) {
            if (cJRBusSearchInput.getSource() != null) {
                jSONObject.put("source", cJRBusSearchInput.getSource().getName());
            }
            if (cJRBusSearchInput.getDestination() != null) {
                jSONObject.put("destination", cJRBusSearchInput.getDestination().getName());
            }
        }
        jSONObject.put(com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN, p.a(context));
        if (list != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator<CJRPassengerDetails> it3 = list.iterator();
            while (it3.hasNext()) {
                CJRPassengerDetails next3 = it3.next();
                if (next3 != null) {
                    JSONObject jSONObject4 = new JSONObject();
                    String str12 = (next3 == null || !next3.getIsPrimary()) ? null : str11;
                    if (str11 != null) {
                        jSONObject4.put(AppConstants.KEY_EMAIL, str12);
                    }
                    if (next3.getGender() != null) {
                        jSONObject4.put("gender", next3.getGender());
                    }
                    if (next3.getIdName() != null) {
                        jSONObject4.put("idName", next3.getIdName());
                    }
                    String str13 = (next3 == null || !next3.getIsPrimary()) ? null : str4;
                    if (str13 != null) {
                        jSONObject4.put("mobile_number", str13);
                    }
                    if (next3.getPassengerName() != null) {
                        jSONObject4.put("name", next3.getPassengerName());
                    }
                    if (next3.getSeatNumber() != null) {
                        jSONObject4.put("seat_number", next3.getSeatNumber());
                    }
                    if (next3.getmTitle() != null) {
                        jSONObject4.put("title", next3.getmTitle());
                    }
                    jSONObject4.put("primary", next3.getIsPrimary());
                    jSONObject4.put("age", next3.getPassengerage());
                    JSONObject jSONObject5 = new JSONObject();
                    if (next3.getIdCardType() != null) {
                        jSONObject5.put("idType", next3.getIdCardType());
                    }
                    if (next3.getIdCardValue() != null) {
                        jSONObject5.put("idNumber", next3.getIdCardValue());
                    }
                    jSONObject4.put("extra_params", jSONObject5);
                    if (next3.isInsuranceEnabled()) {
                        if (next3.getInsuranceDetailObj() != null) {
                            jSONObject4.put("is_insurance", next3.isInsuranceEnabled());
                            JSONObject jSONObject6 = new JSONObject();
                            jSONObject6.put("id", next3.getInsuranceDetailObj().getId());
                            jSONObject4.put("insurance_details", jSONObject6);
                            jSONArray.put(jSONObject4);
                        }
                    }
                    jSONObject4.put("is_insurance", false);
                    jSONArray.put(jSONObject4);
                }
            }
            jSONObject2.put("passengers", jSONArray);
            jSONObject.put("primary_mobile", str4);
            jSONObject.put("primary_email", str11);
            jSONObject.put("onward_leg", jSONObject2);
        }
        if (z3 && checkBox.isChecked() && !str5.isEmpty() && !str6.isEmpty() && !str7.isEmpty() && !str8.isEmpty() && !str9.isEmpty()) {
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("gst_number", str5);
            jSONObject7.put("state_code", str6);
            jSONObject7.put("business_name", str7);
            jSONObject7.put("business_address", str8);
            jSONObject7.put("business_email", str9);
            jSONObject.put("gst_info", jSONObject7);
        }
        jSONObject.put("appName", "");
        jSONObject.put("totalFare", str2);
        return jSONObject.toString();
    }
}
