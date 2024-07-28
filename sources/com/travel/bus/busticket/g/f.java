package com.travel.bus.busticket.g;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.text.TextUtils;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import com.sendbird.android.constant.StringSet;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.bus.R;
import com.travel.bus.busticket.i.p;
import com.travel.bus.pojo.busticket.CJRBlockOneResponse;
import com.travel.bus.pojo.busticket.CJRBusInsuranceItem;
import com.travel.bus.pojo.busticket.CJRBusPaytmCash;
import com.travel.bus.pojo.busticket.CJRBusSearchInput;
import com.travel.bus.pojo.busticket.CJRInsuranceDetail;
import com.travel.bus.pojo.busticket.CJRPassengerDetails;
import com.travel.bus.pojo.busticket.TripBusDetail;
import com.travel.bus.pojo.busticket.TripBusDetailsItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final Context f22373a;

    /* renamed from: b  reason: collision with root package name */
    a f22374b;

    /* renamed from: c  reason: collision with root package name */
    boolean f22375c = false;

    /* renamed from: d  reason: collision with root package name */
    boolean f22376d = false;

    /* renamed from: e  reason: collision with root package name */
    private String f22377e = "CJRConfirmBookingPresenter";

    public interface a {
        void a(int i2, IJRPaytmDataModel iJRPaytmDataModel);
    }

    public f(Context context, a aVar) {
        this.f22373a = context;
        this.f22374b = aVar;
    }

    public final String a(CJRBusSearchInput cJRBusSearchInput, ArrayList<TripBusDetailsItem> arrayList, TripBusDetail tripBusDetail, String str, String str2, CJRBlockOneResponse cJRBlockOneResponse) {
        JSONObject jSONObject = new JSONObject();
        try {
            double grandTotal = cJRBlockOneResponse.getBlockResponse().getGrandTotal() / ((double) arrayList.size());
            jSONObject.put("vertical_id", 26);
            jSONObject.put("start_date", cJRBusSearchInput.getDate() + " " + (str2.subSequence(0, 2) + AppConstants.COLON + str2.subSequence(2, 4) + ":00"));
            jSONObject.put("request_id", tripBusDetail.getMeta().getRequestid());
            jSONObject.put("trip_id", str);
            jSONObject.put("user_id", b.n(this.f22373a));
            jSONObject.put(com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN, p.a(this.f22373a));
            JSONArray jSONArray = new JSONArray();
            Iterator<TripBusDetailsItem> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                TripBusDetailsItem next = it2.next();
                JSONObject jSONObject2 = new JSONObject();
                Double.parseDouble(next.getFare());
                new StringBuilder("fare : ").append(Double.parseDouble(next.getFare()));
                jSONObject2.put("price", grandTotal);
                jSONObject2.put("coloumn", String.valueOf(next.getColumn()));
                jSONObject2.put(ViewHolderFactory.TYPE_ROW, String.valueOf(next.getRow()));
                jSONObject2.put("seatName", next.getSeatName());
                jSONObject2.put(CLPConstants.PRODUCT_ID, next.getProductId());
                jSONObject2.put("length", next.getLength());
                jSONObject2.put(StringSet.width, next.getWidth());
                jSONObject2.put("isMenSeat", !next.getLadiesSeat().booleanValue());
                jSONObject2.put("isLadiesSeat", next.getLadiesSeat());
                jSONObject2.put("isLowerBerth", next.getLowerBerth());
                jSONObject2.put("isAvailable", next.getAvailable());
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("selected_seats", jSONArray);
        } catch (JSONException e2) {
            q.c(e2.getMessage());
        }
        return jSONObject.toString();
    }

    public static NetworkCustomError a(String str, String str2) {
        NetworkCustomError networkCustomError = new NetworkCustomError();
        networkCustomError.setmAlertTitle(str);
        networkCustomError.setAlertMessage(str2);
        return networkCustomError;
    }

    public final void a() {
        com.travel.bus.a.a();
        String u = com.travel.bus.a.b().u();
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put("ssotoken", p.a(this.f22373a));
        if (!TextUtils.isEmpty(u)) {
            a(this.f22373a, u, hashMap, (String) null, a.C0715a.POST, new CJRBusPaytmCash(), new com.paytm.network.listener.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    f fVar = f.this;
                    fVar.f22375c = true;
                    fVar.f22374b.a(4, iJRPaytmDataModel);
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    if (f.this.f22376d || !networkCustomError.getErrorType().equals(NetworkCustomError.ErrorType.TimeOutError)) {
                        if (f.this.f22373a == null) {
                        }
                        return;
                    }
                    f fVar = f.this;
                    String string = fVar.f22373a.getString(R.string.no_resonse_from_api_title);
                    String string2 = fVar.f22373a.getString(R.string.no_resonse_from_api_msg);
                    String string3 = fVar.f22373a.getString(R.string.network_retry_yes);
                    String string4 = fVar.f22373a.getString(R.string.cancel);
                    AlertDialog.Builder builder = new AlertDialog.Builder(fVar.f22373a);
                    builder.setTitle(string).setMessage(string2).setCancelable(false);
                    builder.setPositiveButton(string3, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            f fVar = f.this;
                            fVar.f22376d = true;
                            fVar.a();
                            dialogInterface.cancel();
                        }
                    });
                    builder.setNegativeButton(string4, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            dialogInterface.cancel();
                        }
                    });
                    builder.show();
                    new Handler().postDelayed(new Runnable() {
                        public final void run() {
                            f fVar = f.this;
                            if (!fVar.f22375c) {
                                b.b(fVar.f22373a, fVar.f22373a.getString(R.string.no_resonse_from_api_title), fVar.f22373a.getString(R.string.no_resonse_from_api_msg));
                            }
                        }
                    }, 30000);
                }
            });
        }
    }

    public static void a(Context context, String str, Map<String, String> map, String str2, a.C0715a aVar, IJRPaytmDataModel iJRPaytmDataModel, com.paytm.network.listener.b bVar) {
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
        bVar2.t = b();
        bVar2.n = a.b.SILENT;
        bVar2.o = "bus-review-itinerary-page";
        bVar2.l().a();
    }

    private static JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "BusReviewItinerayScreen");
        } catch (JSONException e2) {
            q.c(e2.getMessage());
        }
        return jSONObject;
    }

    public static String a(List<CJRPassengerDetails> list, String str, String str2, JSONObject jSONObject, boolean z, CJRBusInsuranceItem cJRBusInsuranceItem) {
        Iterator<CJRPassengerDetails> it2 = list.iterator();
        while (true) {
            CJRInsuranceDetail cJRInsuranceDetail = null;
            if (!it2.hasNext()) {
                break;
            }
            CJRPassengerDetails next = it2.next();
            next.setInsuranceEnabled(z);
            if (z && cJRBusInsuranceItem != null) {
                cJRInsuranceDetail = new CJRInsuranceDetail(cJRBusInsuranceItem.getId());
            }
            next.setInsuranceDetailObj(cJRInsuranceDetail);
        }
        if (list != null) {
            try {
                JSONArray jSONArray = new JSONArray();
                int i2 = 0;
                Iterator<CJRPassengerDetails> it3 = list.iterator();
                while (it3.hasNext()) {
                    CJRPassengerDetails next2 = it3.next();
                    i2++;
                    if (next2 != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        String str3 = (next2 == null || !next2.getIsPrimary()) ? null : str;
                        if (str != null) {
                            jSONObject2.put(com.business.merchant_payments.common.utility.AppConstants.KEY_EMAIL, str3);
                        }
                        if (next2.getGender() != null) {
                            jSONObject2.put("gender", next2.getGender());
                        }
                        if (next2.getIdName() != null) {
                            jSONObject2.put("idName", next2.getIdName());
                        }
                        String str4 = (next2 == null || !next2.getIsPrimary()) ? null : str2;
                        if (str4 != null) {
                            jSONObject2.put("mobileNumber", str4);
                        }
                        if (next2.getPassengerName() != null) {
                            jSONObject2.put("name", next2.getPassengerName());
                        }
                        if (next2.getSeatNumber() != null) {
                            jSONObject2.put("seatNumber", next2.getSeatNumber());
                        }
                        if (next2.getmTitle() != null) {
                            jSONObject2.put("title", next2.getmTitle());
                        }
                        jSONObject2.put("primary", next2.getIsPrimary());
                        jSONObject2.put("age", next2.getPassengerage());
                        if (z) {
                            jSONObject2.put("isInsurance", true);
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("id", i2);
                            jSONObject2.put("insurance_details", jSONObject3);
                        }
                        jSONArray.put(jSONObject2);
                    }
                }
                jSONObject.put("passengers", jSONArray);
            } catch (JSONException e2) {
                q.c(e2.getMessage());
            }
        }
        return jSONObject.toString();
    }
}
