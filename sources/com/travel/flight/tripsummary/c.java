package com.travel.flight.tripsummary;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.lifecycle.y;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.d;
import com.travel.flight.R;
import com.travel.flight.b;
import com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBody;
import com.travel.flight.pojo.flightticket.CJRConvenienceFee;
import com.travel.flight.pojo.flightticket.CJRFlightClientLoginPayload;
import com.travel.flight.pojo.flightticket.CJRFlightDetails;
import com.travel.flight.pojo.flightticket.CJRFlightPayment;
import com.travel.flight.pojo.flightticket.CJRFlightSearchInput;
import com.travel.flight.pojo.flightticket.CJRFlightSearchResult;
import com.travel.flight.pojo.flightticket.CJRFlightVerify;
import com.travel.flight.pojo.flightticket.CJRMetadetails;
import com.travel.flight.pojo.flightticket.FlightSellingBundleResponseData;
import com.travel.flight.pojo.flightticket.insurance.CJRCancelProtectInsuranceItem;
import com.travel.flight.pojo.flightticket.insurance.CJRInsuranceBody;
import com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem;
import com.travel.flight.pojo.flightticket.insurance.CJRInsuranceModel;
import com.travel.flight.pojo.flightticket.insurance.CJRInsurancePriceDetail;
import com.travel.flight.pojo.model.CJRSeatSelection;
import com.travel.flight.pojo.model.CJRTravellerSeatTransition;
import com.travel.flight.utils.f;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.nativesdk.emiSubvention.EMIConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c extends androidx.lifecycle.a implements a {
    private static final int A = 111;
    private static final String B = B;
    private static final String C = C;
    private static final String D = D;
    private static final String E = E;
    private static final String F = F;
    private static final String G = G;
    private static final String H = H;
    private static final String I = I;
    private static final String J = J;
    private static final String K = K;
    private static final String L = L;
    private static final String M = M;
    private static final String N = N;
    private static final String O = O;
    private static final String P = P;
    private static final String Q = Q;
    private static final String R = R;
    private static final String S = S;
    private static final String T = T;
    private static final String U = U;
    private static final String V = V;
    private static final String W = W;
    private static final String X = X;
    /* access modifiers changed from: private */
    public static Context Y = null;
    public static final a n = new a((byte) 0);
    /* access modifiers changed from: private */
    public static final String p = p;
    /* access modifiers changed from: private */
    public static final String q = q;
    /* access modifiers changed from: private */
    public static final String r = r;
    /* access modifiers changed from: private */
    public static final String s = s;
    /* access modifiers changed from: private */
    public static final String t = t;
    /* access modifiers changed from: private */
    public static final String u = "items";
    /* access modifiers changed from: private */
    public static final String v = "code";
    /* access modifiers changed from: private */
    public static final String w = w;
    /* access modifiers changed from: private */
    public static final String x = x;
    /* access modifiers changed from: private */
    public static final String y = y;
    private static final String z = z;

    /* renamed from: a  reason: collision with root package name */
    CJRFlightDetails f25560a;

    /* renamed from: b  reason: collision with root package name */
    JSONObject f25561b;

    /* renamed from: c  reason: collision with root package name */
    CJRFlightSearchInput f25562c;

    /* renamed from: d  reason: collision with root package name */
    y<f> f25563d = new y<>();

    /* renamed from: e  reason: collision with root package name */
    y<CJRFlightSearchResult> f25564e = new y<>();

    /* renamed from: f  reason: collision with root package name */
    y<CJRFlightPayment> f25565f = new y<>();

    /* renamed from: g  reason: collision with root package name */
    y<CJRFlightPayment> f25566g = new y<>();

    /* renamed from: h  reason: collision with root package name */
    y<CJRFlightVerify> f25567h = new y<>();

    /* renamed from: i  reason: collision with root package name */
    y<Boolean> f25568i = new y<>();
    y<Boolean> j = new y<>();
    y<f> k = new y<>();
    y<f> l = new y<>();
    b m = new b(this);
    private String o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Application application) {
        super(application);
        k.c(application, "context");
        b.a();
        String e2 = b.b().e(application);
        k.a((Object) e2, "FlightController.getInst…ectedProfileType(context)");
        this.o = e2;
    }

    public final void onCleared() {
        super.onCleared();
        Y = null;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static double a(CJRTravellerSeatTransition cJRTravellerSeatTransition) {
            double d2 = 0.0d;
            if (!(cJRTravellerSeatTransition == null || cJRTravellerSeatTransition.getOnwardSeatSelections() == null)) {
                int size = cJRTravellerSeatTransition.getOnwardSeatSelections().size();
                for (int i2 = 0; i2 < size; i2++) {
                    CJRSeatSelection cJRSeatSelection = cJRTravellerSeatTransition.getOnwardSeatSelections().get(i2);
                    if (cJRSeatSelection != null) {
                        d2 += cJRSeatSelection.getmTotalSeatPrice();
                    }
                }
            }
            return d2;
        }

        public static String a(String str, CJRFlightDetails cJRFlightDetails) {
            k.c(str, "url");
            if (cJRFlightDetails == null) {
                k.a();
            }
            CJRFlightSearchInput searchInput = cJRFlightDetails.getSearchInput();
            if (searchInput == null) {
                k.a();
            }
            String str2 = searchInput.getmServiceProviserSelectedOnTop();
            String str3 = cJRFlightDetails.getmOnwardJourney().getmFlightId();
            k.a((Object) str3, "mFlightDetails!!.getmOnw…dJourney().getmFlightId()");
            String str4 = cJRFlightDetails.getmReturnJourney().getmFlightId();
            k.a((Object) str4, "mFlightDetails!!.getmRet…nJourney().getmFlightId()");
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            CJRFlightDetails.JourneyDetails journeyDetails = cJRFlightDetails.getJourneyDetails();
            k.a((Object) journeyDetails, "mFlightDetails!!.journeyDetails");
            Uri.Builder appendQueryParameter = buildUpon.appendQueryParameter("requestid", journeyDetails.getRequestId()).appendQueryParameter("onward_provider", str2).appendQueryParameter("return_provider", str2).appendQueryParameter("onward_flightid", str3).appendQueryParameter("return_flightid", str4);
            try {
                CJRInsuranceModel insuranceData = cJRFlightDetails.getInsuranceData();
                k.a((Object) insuranceData, "mFlightDetails.insuranceData");
                CJRInsuranceBody body = insuranceData.getBody();
                k.a((Object) body, "mFlightDetails.insuranceData.body");
                CJRInsuranceItem cJRInsuranceItem = body.getInsuranceDetail().get(0);
                k.a((Object) cJRInsuranceItem, "mFlightDetails.insurance…a.body.insuranceDetail[0]");
                if (cJRInsuranceItem.getUserInputInfo().getSelectedDays() > 0) {
                    CJRInsuranceModel insuranceData2 = cJRFlightDetails.getInsuranceData();
                    k.a((Object) insuranceData2, "mFlightDetails.insuranceData");
                    CJRInsuranceBody body2 = insuranceData2.getBody();
                    k.a((Object) body2, "mFlightDetails.insuranceData.body");
                    CJRInsuranceItem cJRInsuranceItem2 = body2.getInsuranceDetail().get(0);
                    k.a((Object) cJRInsuranceItem2, "mFlightDetails.insurance…a.body.insuranceDetail[0]");
                    appendQueryParameter.appendQueryParameter("insured_days", String.valueOf(cJRInsuranceItem2.getUserInputInfo().getSelectedDays()));
                    CJRInsuranceModel insuranceData3 = cJRFlightDetails.getInsuranceData();
                    k.a((Object) insuranceData3, "mFlightDetails.insuranceData");
                    CJRInsuranceBody body3 = insuranceData3.getBody();
                    k.a((Object) body3, "mFlightDetails.insuranceData.body");
                    CJRInsuranceItem cJRInsuranceItem3 = body3.getInsuranceDetail().get(0);
                    k.a((Object) cJRInsuranceItem3, "mFlightDetails.insurance…a.body.insuranceDetail[0]");
                    cJRInsuranceItem3.getUserInputInfo().getSelectedDays();
                }
            } catch (Exception unused) {
            }
            String uri = appendQueryParameter.build().toString();
            k.a((Object) uri, "uriBuilder.build().toString()");
            return uri;
        }

        public static String b(String str, CJRFlightDetails cJRFlightDetails) {
            String str2;
            k.c(str, "url");
            if (cJRFlightDetails == null) {
                k.a();
            }
            if (cJRFlightDetails.getmOnwardServiceProvider() != null) {
                str2 = cJRFlightDetails.getmOnwardServiceProvider();
                k.a((Object) str2, "mFlightDetails!!.getmOnwardServiceProvider()");
            } else if (cJRFlightDetails.getmOnwardJourney() == null || cJRFlightDetails.getmOnwardJourney().getmServiceProviderSelected() == null) {
                str2 = cJRFlightDetails.getmOnwardJourney().getmPrice().get(0).getmServiceProvider();
                k.a((Object) str2, "mFlightDetails!!.getmOnw…   .getmServiceProvider()");
            } else {
                str2 = cJRFlightDetails.getmOnwardJourney().getmServiceProviderSelected().getmServiceProvider();
                k.a((Object) str2, "mFlightDetails!!.getmOnw…   .getmServiceProvider()");
            }
            String str3 = cJRFlightDetails.getmOnwardJourney().getmFlightId();
            k.a((Object) str3, "mFlightDetails!!.getmOnw…dJourney().getmFlightId()");
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            CJRFlightDetails.JourneyDetails journeyDetails = cJRFlightDetails.getJourneyDetails();
            k.a((Object) journeyDetails, "mFlightDetails!!.journeyDetails");
            Uri.Builder appendQueryParameter = buildUpon.appendQueryParameter("requestid", journeyDetails.getRequestId()).appendQueryParameter("onward_provider", str2).appendQueryParameter("onward_flightid", str3);
            try {
                CJRInsuranceModel insuranceData = cJRFlightDetails.getInsuranceData();
                k.a((Object) insuranceData, "mFlightDetails.insuranceData");
                CJRInsuranceBody body = insuranceData.getBody();
                k.a((Object) body, "mFlightDetails.insuranceData.body");
                CJRInsuranceItem cJRInsuranceItem = body.getInsuranceDetail().get(0);
                k.a((Object) cJRInsuranceItem, "mFlightDetails.insurance…a.body.insuranceDetail[0]");
                if (cJRInsuranceItem.getUserInputInfo().getSelectedDays() > 0) {
                    CJRInsuranceModel insuranceData2 = cJRFlightDetails.getInsuranceData();
                    k.a((Object) insuranceData2, "mFlightDetails.insuranceData");
                    CJRInsuranceBody body2 = insuranceData2.getBody();
                    k.a((Object) body2, "mFlightDetails.insuranceData.body");
                    CJRInsuranceItem cJRInsuranceItem2 = body2.getInsuranceDetail().get(0);
                    k.a((Object) cJRInsuranceItem2, "mFlightDetails.insurance…a.body.insuranceDetail[0]");
                    appendQueryParameter.appendQueryParameter("insured_days", String.valueOf(cJRInsuranceItem2.getUserInputInfo().getSelectedDays()));
                    CJRInsuranceModel insuranceData3 = cJRFlightDetails.getInsuranceData();
                    k.a((Object) insuranceData3, "mFlightDetails.insuranceData");
                    CJRInsuranceBody body3 = insuranceData3.getBody();
                    k.a((Object) body3, "mFlightDetails.insuranceData.body");
                    CJRInsuranceItem cJRInsuranceItem3 = body3.getInsuranceDetail().get(0);
                    k.a((Object) cJRInsuranceItem3, "mFlightDetails.insurance…a.body.insuranceDetail[0]");
                    cJRInsuranceItem3.getUserInputInfo().getSelectedDays();
                }
            } catch (Exception unused) {
            }
            String uri = appendQueryParameter.build().toString();
            k.a((Object) uri, "uriBuilder.build().toString()");
            return uri;
        }

        /* JADX WARNING: Removed duplicated region for block: B:107:0x038f A[LOOP:0: B:28:0x00c4->B:107:0x038f, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:226:0x03b1 A[EDGE_INSN: B:226:0x03b1->B:109:0x03b1 ?: BREAK  , SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static org.json.JSONObject a(boolean r26, com.travel.flight.pojo.flightticket.CJRFlightDetails r27, android.content.Context r28) {
            /*
                r0 = r27
                java.lang.String r1 = "title"
                java.lang.String r2 = "travellerDetails.getTravellerTitle()"
                java.lang.String r3 = "mFlightDetails!!.journeyDetails"
                java.lang.String r4 = "context"
                r5 = r28
                kotlin.g.b.k.c(r5, r4)
                org.json.JSONObject r4 = new org.json.JSONObject
                r4.<init>()
                if (r0 != 0) goto L_0x001b
                kotlin.g.b.k.a()     // Catch:{ JSONException -> 0x06e6 }
            L_0x001b:
                com.travel.flight.pojo.flightticket.CJRFlightDetails$JourneyDetails r5 = r27.getJourneyDetails()     // Catch:{ JSONException -> 0x06e6 }
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r3)     // Catch:{ JSONException -> 0x06e6 }
                java.lang.String r5 = r5.getRequestId()     // Catch:{ JSONException -> 0x06e6 }
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ JSONException -> 0x06e6 }
                boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ JSONException -> 0x06e6 }
                if (r5 != 0) goto L_0x003e
                java.lang.String r5 = "requestid"
                com.travel.flight.pojo.flightticket.CJRFlightDetails$JourneyDetails r6 = r27.getJourneyDetails()     // Catch:{ JSONException -> 0x06e6 }
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r3)     // Catch:{ JSONException -> 0x06e6 }
                java.lang.String r6 = r6.getRequestId()     // Catch:{ JSONException -> 0x06e6 }
                r4.put(r5, r6)     // Catch:{ JSONException -> 0x06e6 }
            L_0x003e:
                java.util.List r5 = r27.getBundleList()     // Catch:{ JSONException -> 0x06e6 }
                r6 = 0
                if (r5 == 0) goto L_0x0069
                int r7 = r5.size()     // Catch:{ JSONException -> 0x06e6 }
                if (r7 <= 0) goto L_0x0069
                java.lang.Object r5 = r5.get(r6)     // Catch:{ JSONException -> 0x06e6 }
                java.lang.String r7 = "bundleList.get(0)"
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r7)     // Catch:{ JSONException -> 0x06e6 }
                com.travel.flight.pojo.flightticket.FlightSellingBundleResponseData r5 = (com.travel.flight.pojo.flightticket.FlightSellingBundleResponseData) r5     // Catch:{ JSONException -> 0x06e6 }
                java.lang.String r5 = r5.getPartner_bundle_id()     // Catch:{ JSONException -> 0x06e6 }
                r7 = r5
                java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ JSONException -> 0x06e6 }
                boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ JSONException -> 0x06e6 }
                if (r7 != 0) goto L_0x0069
                java.lang.String r7 = "selected_partner_bundle_id"
                r4.put(r7, r5)     // Catch:{ JSONException -> 0x06e6 }
            L_0x0069:
                boolean r5 = r27.isInsuranceApplied()     // Catch:{ JSONException -> 0x06e6 }
                java.lang.String r7 = "fare"
                double r8 = a((com.travel.flight.pojo.flightticket.CJRFlightDetails) r0, (boolean) r5)     // Catch:{ JSONException -> 0x06e6 }
                r4.put(r7, r8)     // Catch:{ JSONException -> 0x06e6 }
                com.travel.flight.pojo.flightticket.CJRFlightDetails$JourneyDetails r5 = r27.getJourneyDetails()     // Catch:{ JSONException -> 0x06e6 }
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r3)     // Catch:{ JSONException -> 0x06e6 }
                java.util.ArrayList r5 = r5.getTravellersList()     // Catch:{ JSONException -> 0x06e6 }
                if (r5 == 0) goto L_0x06e4
                com.travel.flight.pojo.flightticket.CJRFlightDetails$JourneyDetails r5 = r27.getJourneyDetails()     // Catch:{ JSONException -> 0x06e6 }
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r3)     // Catch:{ JSONException -> 0x06e6 }
                java.util.ArrayList r5 = r5.getTravellersList()     // Catch:{ JSONException -> 0x06e6 }
                if (r5 != 0) goto L_0x0093
                kotlin.g.b.k.a()     // Catch:{ JSONException -> 0x06e6 }
            L_0x0093:
                int r5 = r5.size()     // Catch:{ JSONException -> 0x06e6 }
                if (r5 <= 0) goto L_0x06e4
                org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ JSONException -> 0x06e6 }
                r5.<init>()     // Catch:{ JSONException -> 0x06e6 }
                org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ JSONException -> 0x06e6 }
                r7.<init>()     // Catch:{ JSONException -> 0x06e6 }
                com.travel.flight.pojo.flightticket.CJRFlightDetails$JourneyDetails r8 = r27.getJourneyDetails()     // Catch:{ JSONException -> 0x06e6 }
                kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r3)     // Catch:{ JSONException -> 0x06e6 }
                java.util.ArrayList r8 = r8.getTravellersList()     // Catch:{ JSONException -> 0x06e6 }
                if (r8 != 0) goto L_0x00b3
                kotlin.g.b.k.a()     // Catch:{ JSONException -> 0x06e6 }
            L_0x00b3:
                int r8 = r8.size()     // Catch:{ JSONException -> 0x06e6 }
                r9 = 1
                int r8 = r8 - r9
                java.lang.String r10 = "lastname"
                java.lang.String r11 = "firstname"
                java.lang.String r12 = ""
                if (r8 < 0) goto L_0x03a4
                r14 = r12
                r15 = r14
                r13 = 0
            L_0x00c4:
                com.travel.flight.pojo.flightticket.CJRFlightDetails$JourneyDetails r9 = r27.getJourneyDetails()     // Catch:{ JSONException -> 0x06e6 }
                kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r3)     // Catch:{ JSONException -> 0x06e6 }
                java.util.ArrayList r9 = r9.getTravellersList()     // Catch:{ JSONException -> 0x06e6 }
                if (r9 != 0) goto L_0x00d4
                kotlin.g.b.k.a()     // Catch:{ JSONException -> 0x06e6 }
            L_0x00d4:
                java.lang.Object r9 = r9.get(r13)     // Catch:{ JSONException -> 0x06e6 }
                java.lang.String r6 = "mFlightDetails!!.journey…s.travellersList!!.get(i)"
                kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r6)     // Catch:{ JSONException -> 0x06e6 }
                com.travel.flight.pojo.flightticket.CJRTravellerDetails r9 = (com.travel.flight.pojo.flightticket.CJRTravellerDetails) r9     // Catch:{ JSONException -> 0x06e6 }
                org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x06e6 }
                r6.<init>()     // Catch:{ JSONException -> 0x06e6 }
                r16 = r14
                java.lang.String r14 = "id"
                r17 = r15
                int r15 = r13 + 1
                r6.put(r14, r15)     // Catch:{ JSONException -> 0x06e6 }
                java.lang.String r14 = "type"
                r18 = r15
                java.lang.String r15 = r9.getmTravellerType_en()     // Catch:{ JSONException -> 0x06e6 }
                r6.put(r14, r15)     // Catch:{ JSONException -> 0x06e6 }
                java.lang.String r14 = r9.getmTravellerType_en()     // Catch:{ JSONException -> 0x06e6 }
                java.lang.String r15 = "travellerDetails.getmTravellerType_en()"
                kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r15)     // Catch:{ JSONException -> 0x06e6 }
                boolean r14 = c(r14, r0)     // Catch:{ JSONException -> 0x06e6 }
                if (r14 == 0) goto L_0x01ab
                org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ JSONException -> 0x06e6 }
                r14.<init>()     // Catch:{ JSONException -> 0x06e6 }
                boolean r15 = r27.isInsuranceApplied()     // Catch:{ JSONException -> 0x06e6 }
                java.lang.String r0 = "mFlightDetails!!.insuranceData.body"
                r19 = r4
                java.lang.String r4 = "mFlightDetails!!.insuranceData"
                if (r15 == 0) goto L_0x0160
                org.json.JSONArray r15 = new org.json.JSONArray     // Catch:{ JSONException -> 0x06d6 }
                r15.<init>()     // Catch:{ JSONException -> 0x06d6 }
                r20 = r12
                com.travel.flight.pojo.flightticket.insurance.CJRInsuranceModel r12 = r27.getInsuranceData()     // Catch:{ JSONException -> 0x06d6 }
                kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r4)     // Catch:{ JSONException -> 0x06d6 }
                com.travel.flight.pojo.flightticket.insurance.CJRInsuranceBody r12 = r12.getBody()     // Catch:{ JSONException -> 0x06d6 }
                kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r0)     // Catch:{ JSONException -> 0x06d6 }
                java.util.List r12 = r12.getInsuranceDetail()     // Catch:{ JSONException -> 0x06d6 }
                r21 = r3
                r3 = 0
                java.lang.Object r12 = r12.get(r3)     // Catch:{ JSONException -> 0x06d6 }
                java.lang.String r3 = "mFlightDetails!!.insuran…a.body.insuranceDetail[0]"
                kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r3)     // Catch:{ JSONException -> 0x06d6 }
                com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem r12 = (com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem) r12     // Catch:{ JSONException -> 0x06d6 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x06d6 }
                r3.<init>()     // Catch:{ JSONException -> 0x06d6 }
                r22 = r7
                java.lang.String r7 = r12.getInsuranceId()     // Catch:{ JSONException -> 0x06d6 }
                r3.append(r7)     // Catch:{ JSONException -> 0x06d6 }
                java.lang.String r3 = r3.toString()     // Catch:{ JSONException -> 0x06d6 }
                r15.put(r3)     // Catch:{ JSONException -> 0x06d6 }
                java.lang.String r3 = r12.getInsuranceType()     // Catch:{ JSONException -> 0x06d6 }
                r14.put(r3, r15)     // Catch:{ JSONException -> 0x06d6 }
                goto L_0x0166
            L_0x0160:
                r21 = r3
                r22 = r7
                r20 = r12
            L_0x0166:
                boolean r3 = r27.isInsuranceCancelProtectApplied()     // Catch:{ JSONException -> 0x06d6 }
                if (r3 == 0) goto L_0x01a4
                org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ JSONException -> 0x06d6 }
                r3.<init>()     // Catch:{ JSONException -> 0x06d6 }
                com.travel.flight.pojo.flightticket.insurance.CJRInsuranceModel r7 = r27.getInsuranceData()     // Catch:{ JSONException -> 0x06d6 }
                kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r4)     // Catch:{ JSONException -> 0x06d6 }
                com.travel.flight.pojo.flightticket.insurance.CJRInsuranceBody r4 = r7.getBody()     // Catch:{ JSONException -> 0x06d6 }
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)     // Catch:{ JSONException -> 0x06d6 }
                java.util.List r0 = r4.getCancelProtectInsuranceDetail()     // Catch:{ JSONException -> 0x06d6 }
                r4 = 0
                java.lang.Object r0 = r0.get(r4)     // Catch:{ JSONException -> 0x06d6 }
                com.travel.flight.pojo.flightticket.insurance.CJRCancelProtectInsuranceItem r0 = (com.travel.flight.pojo.flightticket.insurance.CJRCancelProtectInsuranceItem) r0     // Catch:{ JSONException -> 0x06d6 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x06d6 }
                r4.<init>()     // Catch:{ JSONException -> 0x06d6 }
                java.lang.String r7 = r0.getInsuranceId()     // Catch:{ JSONException -> 0x06d6 }
                r4.append(r7)     // Catch:{ JSONException -> 0x06d6 }
                java.lang.String r4 = r4.toString()     // Catch:{ JSONException -> 0x06d6 }
                r3.put(r4)     // Catch:{ JSONException -> 0x06d6 }
                java.lang.String r0 = r0.getInsuranceType()     // Catch:{ JSONException -> 0x06d6 }
                r14.put(r0, r3)     // Catch:{ JSONException -> 0x06d6 }
            L_0x01a4:
                java.lang.String r0 = "selected_addons"
                r6.put(r0, r14)     // Catch:{ JSONException -> 0x06d6 }
                goto L_0x01b3
            L_0x01ab:
                r21 = r3
                r19 = r4
                r22 = r7
                r20 = r12
            L_0x01b3:
                java.lang.String r0 = r9.getTravellerTitle()     // Catch:{ JSONException -> 0x06d6 }
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)     // Catch:{ JSONException -> 0x06d6 }
                java.lang.String r0 = a((java.lang.String) r0)     // Catch:{ JSONException -> 0x06d6 }
                r9.setTravellerTitle(r0)     // Catch:{ JSONException -> 0x06d6 }
                java.lang.String r0 = r9.getTravellerTitle()     // Catch:{ JSONException -> 0x06d6 }
                r6.put(r1, r0)     // Catch:{ JSONException -> 0x06d6 }
                java.util.List r0 = r9.getValidations()     // Catch:{ JSONException -> 0x06d6 }
                if (r0 == 0) goto L_0x0369
                java.util.List r0 = r9.getValidations()     // Catch:{ JSONException -> 0x06d6 }
                int r3 = r0.size()     // Catch:{ JSONException -> 0x06d6 }
                r4 = 1
                int r3 = r3 - r4
                if (r3 < 0) goto L_0x0369
                r4 = 0
            L_0x01db:
                java.lang.Object r7 = r0.get(r4)     // Catch:{ JSONException -> 0x06d6 }
                net.one97.paytmflight.common.entity.travel.CJRDynamicValidation r7 = (net.one97.paytmflight.common.entity.travel.CJRDynamicValidation) r7     // Catch:{ JSONException -> 0x06d6 }
                java.lang.String r7 = r7.getKey()     // Catch:{ JSONException -> 0x06d6 }
                java.lang.Object r12 = r0.get(r4)     // Catch:{ JSONException -> 0x06d6 }
                net.one97.paytmflight.common.entity.travel.CJRDynamicValidation r12 = (net.one97.paytmflight.common.entity.travel.CJRDynamicValidation) r12     // Catch:{ JSONException -> 0x06d6 }
                java.lang.String r12 = r12.getmValue()     // Catch:{ JSONException -> 0x06d6 }
                if (r13 != 0) goto L_0x020d
                r14 = 1
                boolean r15 = kotlin.m.p.a((java.lang.String) r11, (java.lang.String) r7, (boolean) r14)     // Catch:{ JSONException -> 0x06d6 }
                java.lang.String r14 = "value"
                if (r15 == 0) goto L_0x0201
                kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r14)     // Catch:{ JSONException -> 0x06d6 }
                r16 = r12
                goto L_0x020d
            L_0x0201:
                r15 = 1
                boolean r23 = kotlin.m.p.a((java.lang.String) r10, (java.lang.String) r7, (boolean) r15)     // Catch:{ JSONException -> 0x06d6 }
                if (r23 == 0) goto L_0x020d
                kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r14)     // Catch:{ JSONException -> 0x06d6 }
                r17 = r12
            L_0x020d:
                java.lang.Object r14 = r0.get(r4)     // Catch:{ JSONException -> 0x06d6 }
                net.one97.paytmflight.common.entity.travel.CJRDynamicValidation r14 = (net.one97.paytmflight.common.entity.travel.CJRDynamicValidation) r14     // Catch:{ JSONException -> 0x06d6 }
                java.lang.String r14 = r14.getKey()     // Catch:{ JSONException -> 0x06d6 }
                r15 = 1
                boolean r14 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r14, (boolean) r15)     // Catch:{ JSONException -> 0x06d6 }
                java.lang.String r15 = "onward_frequent_flyer_number"
                r23 = r1
                java.lang.String r1 = "mValid[j]"
                if (r14 == 0) goto L_0x0235
                java.lang.String r12 = r9.getTravellerTitle()     // Catch:{ JSONException -> 0x06d6 }
                kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r2)     // Catch:{ JSONException -> 0x06d6 }
                java.lang.String r12 = a((java.lang.String) r12)     // Catch:{ JSONException -> 0x06d6 }
                r25 = r2
                r24 = r10
                goto L_0x0331
            L_0x0235:
                java.lang.String r14 = "multi_dropdown"
                java.lang.Object r24 = r0.get(r4)     // Catch:{ JSONException -> 0x06d6 }
                net.one97.paytmflight.common.entity.travel.CJRDynamicValidation r24 = (net.one97.paytmflight.common.entity.travel.CJRDynamicValidation) r24     // Catch:{ JSONException -> 0x06d6 }
                r25 = r2
                java.lang.String r2 = r24.getType()     // Catch:{ JSONException -> 0x06d6 }
                r24 = r10
                r10 = 1
                boolean r2 = kotlin.m.p.a((java.lang.String) r14, (java.lang.String) r2, (boolean) r10)     // Catch:{ JSONException -> 0x06d6 }
                if (r2 == 0) goto L_0x02ba
                r2 = r12
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ JSONException -> 0x06d6 }
                boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ JSONException -> 0x06d6 }
                if (r2 != 0) goto L_0x0331
                org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x06d6 }
                r2.<init>()     // Catch:{ JSONException -> 0x06d6 }
                r10 = 1
                boolean r14 = kotlin.m.p.a((java.lang.String) r15, (java.lang.String) r7, (boolean) r10)     // Catch:{ JSONException -> 0x06d6 }
                if (r14 == 0) goto L_0x0289
                java.lang.String r10 = r9.getMflyerNumber()     // Catch:{ JSONException -> 0x06d6 }
                java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ JSONException -> 0x06d6 }
                boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ JSONException -> 0x06d6 }
                if (r10 != 0) goto L_0x0331
                java.lang.String r10 = r9.getMflyerName()     // Catch:{ JSONException -> 0x06d6 }
                java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ JSONException -> 0x06d6 }
                boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ JSONException -> 0x06d6 }
                if (r10 != 0) goto L_0x0331
                java.lang.String r10 = r9.getMflyerName()     // Catch:{ JSONException -> 0x06d6 }
                java.lang.String r14 = r9.getMflyerNumber()     // Catch:{ JSONException -> 0x06d6 }
                r2.put(r10, r14)     // Catch:{ JSONException -> 0x06d6 }
                r6.put(r7, r2)     // Catch:{ JSONException -> 0x06d6 }
                goto L_0x0331
            L_0x0289:
                java.lang.String r10 = "return_frequent_flyer_number"
                r14 = 1
                boolean r10 = kotlin.m.p.a((java.lang.String) r10, (java.lang.String) r7, (boolean) r14)     // Catch:{ JSONException -> 0x06d6 }
                if (r10 == 0) goto L_0x0331
                java.lang.String r10 = r9.getMflyerNumberReturn()     // Catch:{ JSONException -> 0x06d6 }
                java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ JSONException -> 0x06d6 }
                boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ JSONException -> 0x06d6 }
                if (r10 != 0) goto L_0x0331
                java.lang.String r10 = r9.getMflyerNameReturn()     // Catch:{ JSONException -> 0x06d6 }
                java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ JSONException -> 0x06d6 }
                boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ JSONException -> 0x06d6 }
                if (r10 != 0) goto L_0x0331
                java.lang.String r10 = r9.getMflyerNameReturn()     // Catch:{ JSONException -> 0x06d6 }
                java.lang.String r14 = r9.getMflyerNumberReturn()     // Catch:{ JSONException -> 0x06d6 }
                r2.put(r10, r14)     // Catch:{ JSONException -> 0x06d6 }
                r6.put(r7, r2)     // Catch:{ JSONException -> 0x06d6 }
                goto L_0x0331
            L_0x02ba:
                java.lang.Object r2 = r0.get(r4)     // Catch:{ JSONException -> 0x06d6 }
                net.one97.paytmflight.common.entity.travel.CJRDynamicValidation r2 = (net.one97.paytmflight.common.entity.travel.CJRDynamicValidation) r2     // Catch:{ JSONException -> 0x06d6 }
                java.lang.String r2 = r2.getType()     // Catch:{ JSONException -> 0x06d6 }
                java.lang.String r10 = "date"
                boolean r2 = r2.equals(r10)     // Catch:{ JSONException -> 0x06d6 }
                if (r2 == 0) goto L_0x02d6
                java.lang.String r2 = "dd/MM/yyyy"
                java.lang.String r10 = "yyyyMMdd"
                java.lang.String r12 = com.paytm.utility.b.b((java.lang.String) r12, (java.lang.String) r2, (java.lang.String) r10)     // Catch:{ JSONException -> 0x06d6 }
                goto L_0x0331
            L_0x02d6:
                java.lang.Object r2 = r0.get(r4)     // Catch:{ JSONException -> 0x06d6 }
                net.one97.paytmflight.common.entity.travel.CJRDynamicValidation r2 = (net.one97.paytmflight.common.entity.travel.CJRDynamicValidation) r2     // Catch:{ JSONException -> 0x06d6 }
                java.lang.String r2 = r2.getType()     // Catch:{ JSONException -> 0x06d6 }
                java.lang.String r10 = "autosuggest"
                boolean r2 = r2.equals(r10)     // Catch:{ JSONException -> 0x06d6 }
                if (r2 == 0) goto L_0x0331
                java.lang.String r2 = "passport_issue_country"
                java.lang.Object r10 = r0.get(r4)     // Catch:{ JSONException -> 0x06d6 }
                net.one97.paytmflight.common.entity.travel.CJRDynamicValidation r10 = (net.one97.paytmflight.common.entity.travel.CJRDynamicValidation) r10     // Catch:{ JSONException -> 0x06d6 }
                java.lang.String r10 = r10.getKey()     // Catch:{ JSONException -> 0x06d6 }
                r14 = 1
                boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r10, (boolean) r14)     // Catch:{ JSONException -> 0x06d6 }
                if (r2 == 0) goto L_0x0300
                java.lang.String r12 = r9.getPassportCountryCode()     // Catch:{ JSONException -> 0x06d6 }
                goto L_0x0331
            L_0x0300:
                java.lang.String r2 = "birth_country"
                java.lang.Object r10 = r0.get(r4)     // Catch:{ JSONException -> 0x06d6 }
                net.one97.paytmflight.common.entity.travel.CJRDynamicValidation r10 = (net.one97.paytmflight.common.entity.travel.CJRDynamicValidation) r10     // Catch:{ JSONException -> 0x06d6 }
                java.lang.String r10 = r10.getKey()     // Catch:{ JSONException -> 0x06d6 }
                r14 = 1
                boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r10, (boolean) r14)     // Catch:{ JSONException -> 0x06d6 }
                if (r2 == 0) goto L_0x0318
                java.lang.String r12 = r9.getBirthCountryCode()     // Catch:{ JSONException -> 0x06d6 }
                goto L_0x0331
            L_0x0318:
                java.lang.String r2 = "nationality"
                java.lang.Object r10 = r0.get(r4)     // Catch:{ JSONException -> 0x06d6 }
                kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r1)     // Catch:{ JSONException -> 0x06d6 }
                net.one97.paytmflight.common.entity.travel.CJRDynamicValidation r10 = (net.one97.paytmflight.common.entity.travel.CJRDynamicValidation) r10     // Catch:{ JSONException -> 0x06d6 }
                java.lang.String r10 = r10.getKey()     // Catch:{ JSONException -> 0x06d6 }
                boolean r2 = r2.equals(r10)     // Catch:{ JSONException -> 0x06d6 }
                if (r2 == 0) goto L_0x0331
                java.lang.String r12 = r9.getNationalityCountryCode()     // Catch:{ JSONException -> 0x06d6 }
            L_0x0331:
                java.lang.Object r2 = r0.get(r4)     // Catch:{ JSONException -> 0x06d6 }
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r1)     // Catch:{ JSONException -> 0x06d6 }
                net.one97.paytmflight.common.entity.travel.CJRDynamicValidation r2 = (net.one97.paytmflight.common.entity.travel.CJRDynamicValidation) r2     // Catch:{ JSONException -> 0x06d6 }
                java.lang.String r2 = r2.getKey()     // Catch:{ JSONException -> 0x06d6 }
                boolean r2 = r15.equals(r2)     // Catch:{ JSONException -> 0x06d6 }
                if (r2 != 0) goto L_0x035d
                java.lang.String r2 = "return_frequent_flyer_number"
                java.lang.Object r10 = r0.get(r4)     // Catch:{ JSONException -> 0x06d6 }
                kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r1)     // Catch:{ JSONException -> 0x06d6 }
                net.one97.paytmflight.common.entity.travel.CJRDynamicValidation r10 = (net.one97.paytmflight.common.entity.travel.CJRDynamicValidation) r10     // Catch:{ JSONException -> 0x06d6 }
                java.lang.String r1 = r10.getKey()     // Catch:{ JSONException -> 0x06d6 }
                r10 = 1
                boolean r1 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r1, (boolean) r10)     // Catch:{ JSONException -> 0x06d6 }
                if (r1 != 0) goto L_0x035d
                r6.put(r7, r12)     // Catch:{ JSONException -> 0x06d6 }
            L_0x035d:
                if (r4 == r3) goto L_0x036f
                int r4 = r4 + 1
                r1 = r23
                r10 = r24
                r2 = r25
                goto L_0x01db
            L_0x0369:
                r23 = r1
                r25 = r2
                r24 = r10
            L_0x036f:
                r14 = r16
                r15 = r17
                java.lang.String r0 = "selected_from_traveller_list"
                r1 = 0
                r6.put(r0, r1)     // Catch:{ JSONException -> 0x06d6 }
                java.lang.String r0 = "was_name_edited"
                r6.put(r0, r1)     // Catch:{ JSONException -> 0x06d6 }
                java.lang.String r0 = "selected_from_drop_down"
                boolean r1 = r9.isSelected_from_drop_down()     // Catch:{ JSONException -> 0x06d6 }
                r6.put(r0, r1)     // Catch:{ JSONException -> 0x06d6 }
                r5.put(r6)     // Catch:{ JSONException -> 0x06d6 }
                if (r13 == r8) goto L_0x03b1
                r0 = r27
                r13 = r18
                r4 = r19
                r12 = r20
                r3 = r21
                r7 = r22
                r1 = r23
                r10 = r24
                r2 = r25
                r6 = 0
                goto L_0x00c4
            L_0x03a4:
                r21 = r3
                r19 = r4
                r22 = r7
                r24 = r10
                r20 = r12
                r14 = r20
                r15 = r14
            L_0x03b1:
                java.lang.String r0 = "null cannot be cast to non-null type kotlin.CharSequence"
                if (r14 == 0) goto L_0x06da
                java.lang.CharSequence r14 = (java.lang.CharSequence) r14     // Catch:{ JSONException -> 0x06d6 }
                java.lang.CharSequence r1 = kotlin.m.p.b(r14)     // Catch:{ JSONException -> 0x06d6 }
                java.lang.String r1 = r1.toString()     // Catch:{ JSONException -> 0x06d6 }
                r2 = r22
                r2.put(r11, r1)     // Catch:{ JSONException -> 0x06d6 }
                if (r15 == 0) goto L_0x06ce
                java.lang.CharSequence r15 = (java.lang.CharSequence) r15     // Catch:{ JSONException -> 0x06d6 }
                java.lang.CharSequence r1 = kotlin.m.p.b(r15)     // Catch:{ JSONException -> 0x06d6 }
                java.lang.String r1 = r1.toString()     // Catch:{ JSONException -> 0x06d6 }
                r3 = r24
                r2.put(r3, r1)     // Catch:{ JSONException -> 0x06d6 }
                if (r26 != 0) goto L_0x0429
                com.travel.flight.pojo.flightticket.CJRFlightDetails$JourneyDetails r1 = r27.getJourneyDetails()     // Catch:{ JSONException -> 0x06d6 }
                r3 = r21
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)     // Catch:{ JSONException -> 0x06d6 }
                java.lang.String r1 = r1.getEmailId()     // Catch:{ JSONException -> 0x06d6 }
                r4 = r1
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ JSONException -> 0x06d6 }
                boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x06d6 }
                if (r4 != 0) goto L_0x0405
                if (r1 != 0) goto L_0x03f2
                kotlin.g.b.k.a()     // Catch:{ JSONException -> 0x06d6 }
            L_0x03f2:
                if (r1 == 0) goto L_0x03ff
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ JSONException -> 0x06d6 }
                java.lang.CharSequence r0 = kotlin.m.p.b(r1)     // Catch:{ JSONException -> 0x06d6 }
                java.lang.String r1 = r0.toString()     // Catch:{ JSONException -> 0x06d6 }
                goto L_0x0405
            L_0x03ff:
                kotlin.u r1 = new kotlin.u     // Catch:{ JSONException -> 0x06d6 }
                r1.<init>(r0)     // Catch:{ JSONException -> 0x06d6 }
                throw r1     // Catch:{ JSONException -> 0x06d6 }
            L_0x0405:
                java.lang.String r0 = "email"
                r2.put(r0, r1)     // Catch:{ JSONException -> 0x06d6 }
                java.lang.String r0 = "mobile"
                com.travel.flight.pojo.flightticket.CJRFlightDetails$JourneyDetails r1 = r27.getJourneyDetails()     // Catch:{ JSONException -> 0x06d6 }
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)     // Catch:{ JSONException -> 0x06d6 }
                java.lang.String r1 = r1.getMobileNumber()     // Catch:{ JSONException -> 0x06d6 }
                if (r1 != 0) goto L_0x041c
                kotlin.g.b.k.a()     // Catch:{ JSONException -> 0x06d6 }
            L_0x041c:
                java.lang.String r4 = "+91 "
                r6 = r20
                r7 = 0
                java.lang.String r1 = kotlin.m.p.a(r1, r4, r6, r7)     // Catch:{ JSONException -> 0x06d6 }
                r2.put(r0, r1)     // Catch:{ JSONException -> 0x06d6 }
                goto L_0x042c
            L_0x0429:
                r3 = r21
                r7 = 0
            L_0x042c:
                java.lang.String r0 = "pax_info"
                r1 = r19
                r1.put(r0, r5)     // Catch:{ JSONException -> 0x06e2 }
                java.lang.String r0 = "contact_info"
                r1.put(r0, r2)     // Catch:{ JSONException -> 0x06e2 }
                com.travel.flight.pojo.flightticket.CJRFlightPromoResponse r0 = r27.getPromoResponse()     // Catch:{ JSONException -> 0x06e2 }
                if (r0 == 0) goto L_0x046d
                com.travel.flight.pojo.flightticket.CJRFlightPromoResponse r0 = r27.getPromoResponse()     // Catch:{ JSONException -> 0x06e2 }
                com.travel.flight.pojo.CJRFlightPromoBody r0 = r0.getBody()     // Catch:{ JSONException -> 0x06e2 }
                if (r0 == 0) goto L_0x046d
                com.travel.flight.pojo.flightticket.CJRFlightPromoResponse r0 = r27.getPromoResponse()     // Catch:{ JSONException -> 0x06e2 }
                com.travel.flight.pojo.CJRFlightPromoBody r0 = r0.getBody()     // Catch:{ JSONException -> 0x06e2 }
                java.lang.String r0 = r0.getPaytmPromocode()     // Catch:{ JSONException -> 0x06e2 }
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ JSONException -> 0x06e2 }
                boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x06e2 }
                if (r0 != 0) goto L_0x046d
                java.lang.String r0 = "promocode"
                com.travel.flight.pojo.flightticket.CJRFlightPromoResponse r2 = r27.getPromoResponse()     // Catch:{ JSONException -> 0x06e2 }
                com.travel.flight.pojo.CJRFlightPromoBody r2 = r2.getBody()     // Catch:{ JSONException -> 0x06e2 }
                java.lang.String r2 = r2.getPaytmPromocode()     // Catch:{ JSONException -> 0x06e2 }
                r1.put(r0, r2)     // Catch:{ JSONException -> 0x06e2 }
            L_0x046d:
                com.travel.flight.pojo.flightticket.CJRFlightDetails$JourneyDetails r0 = r27.getJourneyDetails()     // Catch:{ JSONException -> 0x06e2 }
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)     // Catch:{ JSONException -> 0x06e2 }
                com.travel.flight.pojo.model.CJRTravellerSeatTransition r0 = r0.getTravellerSeatTransitionObj()     // Catch:{ JSONException -> 0x06e2 }
                if (r0 == 0) goto L_0x058f
                com.travel.flight.pojo.flightticket.CJRFlightDetails$JourneyDetails r0 = r27.getJourneyDetails()     // Catch:{ JSONException -> 0x06e2 }
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)     // Catch:{ JSONException -> 0x06e2 }
                com.travel.flight.pojo.model.CJRTravellerSeatTransition r0 = r0.getTravellerSeatTransitionObj()     // Catch:{ JSONException -> 0x06e2 }
                if (r0 != 0) goto L_0x048a
                kotlin.g.b.k.a()     // Catch:{ JSONException -> 0x06e2 }
            L_0x048a:
                java.util.ArrayList r0 = r0.getOnwardSeatSelections()     // Catch:{ JSONException -> 0x06e2 }
                if (r0 == 0) goto L_0x058f
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x06e2 }
                r0.<init>()     // Catch:{ JSONException -> 0x06e2 }
                org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ JSONException -> 0x06e2 }
                r2.<init>()     // Catch:{ JSONException -> 0x06e2 }
                com.travel.flight.pojo.flightticket.CJRFlightDetails$JourneyDetails r4 = r27.getJourneyDetails()     // Catch:{ JSONException -> 0x06e2 }
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r3)     // Catch:{ JSONException -> 0x06e2 }
                com.travel.flight.pojo.model.CJRTravellerSeatTransition r4 = r4.getTravellerSeatTransitionObj()     // Catch:{ JSONException -> 0x06e2 }
                if (r4 != 0) goto L_0x04aa
                kotlin.g.b.k.a()     // Catch:{ JSONException -> 0x06e2 }
            L_0x04aa:
                java.util.ArrayList r4 = r4.getOnwardSeatSelections()     // Catch:{ JSONException -> 0x06e2 }
                int r4 = r4.size()     // Catch:{ JSONException -> 0x06e2 }
                r5 = 1
                int r4 = r4 - r5
                if (r4 < 0) goto L_0x057e
                r5 = 0
                r6 = 0
            L_0x04b8:
                org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ JSONException -> 0x06e2 }
                r8.<init>()     // Catch:{ JSONException -> 0x06e2 }
                com.travel.flight.pojo.flightticket.CJRFlightDetails$JourneyDetails r9 = r27.getJourneyDetails()     // Catch:{ JSONException -> 0x06e2 }
                kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r3)     // Catch:{ JSONException -> 0x06e2 }
                com.travel.flight.pojo.model.CJRTravellerSeatTransition r9 = r9.getTravellerSeatTransitionObj()     // Catch:{ JSONException -> 0x06e2 }
                if (r9 != 0) goto L_0x04cd
                kotlin.g.b.k.a()     // Catch:{ JSONException -> 0x06e2 }
            L_0x04cd:
                java.util.ArrayList r9 = r9.getOnwardSeatSelections()     // Catch:{ JSONException -> 0x06e2 }
                java.lang.Object r9 = r9.get(r5)     // Catch:{ JSONException -> 0x06e2 }
                java.lang.String r10 = "mFlightDetails!!.journey…OnwardSeatSelections()[i]"
                kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r10)     // Catch:{ JSONException -> 0x06e2 }
                com.travel.flight.pojo.model.CJRSeatSelection r9 = (com.travel.flight.pojo.model.CJRSeatSelection) r9     // Catch:{ JSONException -> 0x06e2 }
                if (r9 == 0) goto L_0x0578
                int r10 = r9.getmSelectedSeatsCount()     // Catch:{ JSONException -> 0x06e2 }
                if (r10 <= 0) goto L_0x0578
                java.lang.String r6 = com.travel.flight.tripsummary.c.r     // Catch:{ JSONException -> 0x06e2 }
                java.lang.String r10 = r9.getmFlightNumber()     // Catch:{ JSONException -> 0x06e2 }
                r8.put(r6, r10)     // Catch:{ JSONException -> 0x06e2 }
                java.lang.String r6 = com.travel.flight.tripsummary.c.s     // Catch:{ JSONException -> 0x06e2 }
                java.lang.String r10 = r9.getmOrigin()     // Catch:{ JSONException -> 0x06e2 }
                r8.put(r6, r10)     // Catch:{ JSONException -> 0x06e2 }
                java.lang.String r6 = com.travel.flight.tripsummary.c.t     // Catch:{ JSONException -> 0x06e2 }
                java.lang.String r10 = r9.getmDestination()     // Catch:{ JSONException -> 0x06e2 }
                r8.put(r6, r10)     // Catch:{ JSONException -> 0x06e2 }
                org.json.JSONArray r6 = new org.json.JSONArray     // Catch:{ JSONException -> 0x06e2 }
                r6.<init>()     // Catch:{ JSONException -> 0x06e2 }
                java.util.ArrayList r10 = r9.getmSeatSelectedItems()     // Catch:{ JSONException -> 0x06e2 }
                int r10 = r10.size()     // Catch:{ JSONException -> 0x06e2 }
                r11 = 1
                int r10 = r10 - r11
                if (r10 < 0) goto L_0x056d
                r11 = 0
            L_0x0517:
                java.util.ArrayList r12 = r9.getmSeatSelectedItems()     // Catch:{ JSONException -> 0x06e2 }
                java.lang.Object r12 = r12.get(r11)     // Catch:{ JSONException -> 0x06e2 }
                java.lang.String r13 = "seatSelection.getmSeatSelectedItems().get(j)"
                kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r13)     // Catch:{ JSONException -> 0x06e2 }
                com.travel.flight.pojo.model.CJRSeatSelectedItem r12 = (com.travel.flight.pojo.model.CJRSeatSelectedItem) r12     // Catch:{ JSONException -> 0x06e2 }
                org.json.JSONObject r13 = new org.json.JSONObject     // Catch:{ JSONException -> 0x06e2 }
                r13.<init>()     // Catch:{ JSONException -> 0x06e2 }
                if (r12 == 0) goto L_0x0568
                java.lang.String r14 = r12.getmSeatNumber()     // Catch:{ JSONException -> 0x06e2 }
                java.lang.CharSequence r14 = (java.lang.CharSequence) r14     // Catch:{ JSONException -> 0x06e2 }
                boolean r14 = android.text.TextUtils.isEmpty(r14)     // Catch:{ JSONException -> 0x06e2 }
                if (r14 != 0) goto L_0x0568
                java.lang.String r14 = com.travel.flight.tripsummary.c.v     // Catch:{ JSONException -> 0x06e2 }
                java.lang.String r15 = r12.getmSeatCode()     // Catch:{ JSONException -> 0x06e2 }
                r13.put(r14, r15)     // Catch:{ JSONException -> 0x06e2 }
                java.lang.String r14 = com.travel.flight.tripsummary.c.w     // Catch:{ JSONException -> 0x06e2 }
                int r15 = r12.getmPassengerId()     // Catch:{ JSONException -> 0x06e2 }
                r13.put(r14, r15)     // Catch:{ JSONException -> 0x06e2 }
                java.lang.String r14 = com.travel.flight.tripsummary.c.x     // Catch:{ JSONException -> 0x06e2 }
                java.lang.String r15 = r12.getmSeatNumber()     // Catch:{ JSONException -> 0x06e2 }
                r13.put(r14, r15)     // Catch:{ JSONException -> 0x06e2 }
                java.lang.String r14 = com.travel.flight.tripsummary.c.y     // Catch:{ JSONException -> 0x06e2 }
                java.lang.String r12 = r12.getmDeck()     // Catch:{ JSONException -> 0x06e2 }
                r13.put(r14, r12)     // Catch:{ JSONException -> 0x06e2 }
                r6.put(r13)     // Catch:{ JSONException -> 0x06e2 }
            L_0x0568:
                if (r11 == r10) goto L_0x056d
                int r11 = r11 + 1
                goto L_0x0517
            L_0x056d:
                java.lang.String r9 = com.travel.flight.tripsummary.c.u     // Catch:{ JSONException -> 0x06e2 }
                r8.put(r9, r6)     // Catch:{ JSONException -> 0x06e2 }
                r2.put(r8)     // Catch:{ JSONException -> 0x06e2 }
                r6 = 1
            L_0x0578:
                if (r5 == r4) goto L_0x057f
                int r5 = r5 + 1
                goto L_0x04b8
            L_0x057e:
                r6 = 0
            L_0x057f:
                java.lang.String r4 = com.travel.flight.tripsummary.c.q     // Catch:{ JSONException -> 0x06e2 }
                r0.put(r4, r2)     // Catch:{ JSONException -> 0x06e2 }
                if (r6 == 0) goto L_0x058f
                java.lang.String r2 = com.travel.flight.tripsummary.c.p     // Catch:{ JSONException -> 0x06e2 }
                r1.put(r2, r0)     // Catch:{ JSONException -> 0x06e2 }
            L_0x058f:
                if (r27 != 0) goto L_0x0594
                kotlin.g.b.k.a()     // Catch:{ JSONException -> 0x06e2 }
            L_0x0594:
                com.travel.flight.pojo.flightticket.CJRFlightReviewGst r0 = r27.getGst()     // Catch:{ JSONException -> 0x06e2 }
                if (r0 == 0) goto L_0x05a8
                com.travel.flight.pojo.flightticket.CJRFlightReviewGst r0 = r27.getGst()     // Catch:{ JSONException -> 0x06e2 }
                java.lang.String r2 = "mFlightDetails!!.getGst()"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)     // Catch:{ JSONException -> 0x06e2 }
                boolean r6 = r0.isEnabled()     // Catch:{ JSONException -> 0x06e2 }
                goto L_0x05a9
            L_0x05a8:
                r6 = 0
            L_0x05a9:
                if (r6 == 0) goto L_0x0635
                com.travel.flight.pojo.flightticket.CJRFlightDetails$JourneyDetails r0 = r27.getJourneyDetails()     // Catch:{ JSONException -> 0x06e2 }
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)     // Catch:{ JSONException -> 0x06e2 }
                com.travel.flight.pojo.flightticket.paxinfo.CJRDynamicPassenger r0 = r0.getGstObject()     // Catch:{ JSONException -> 0x06e2 }
                if (r0 == 0) goto L_0x0635
                com.travel.flight.pojo.flightticket.CJRFlightDetails$JourneyDetails r0 = r27.getJourneyDetails()     // Catch:{ JSONException -> 0x06e2 }
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)     // Catch:{ JSONException -> 0x06e2 }
                boolean r0 = r0.isGstSelected()     // Catch:{ JSONException -> 0x06e2 }
                if (r0 == 0) goto L_0x0635
                java.lang.String r0 = "business_profile"
                r2 = 1
                r1.put(r0, r2)     // Catch:{ JSONException -> 0x06e2 }
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x06e2 }
                r0.<init>()     // Catch:{ JSONException -> 0x06e2 }
                com.travel.flight.pojo.flightticket.CJRFlightDetails$JourneyDetails r2 = r27.getJourneyDetails()     // Catch:{ JSONException -> 0x06e2 }
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)     // Catch:{ JSONException -> 0x06e2 }
                com.travel.flight.pojo.flightticket.paxinfo.CJRDynamicPassenger r2 = r2.getGstObject()     // Catch:{ JSONException -> 0x06e2 }
                if (r2 != 0) goto L_0x05e0
                kotlin.g.b.k.a()     // Catch:{ JSONException -> 0x06e2 }
            L_0x05e0:
                java.util.List r2 = r2.getValidations()     // Catch:{ JSONException -> 0x06e2 }
                int r2 = r2.size()     // Catch:{ JSONException -> 0x06e2 }
                r4 = 1
                int r2 = r2 - r4
                if (r2 < 0) goto L_0x0630
            L_0x05ec:
                com.travel.flight.pojo.flightticket.CJRFlightDetails$JourneyDetails r4 = r27.getJourneyDetails()     // Catch:{ JSONException -> 0x06e2 }
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r3)     // Catch:{ JSONException -> 0x06e2 }
                com.travel.flight.pojo.flightticket.paxinfo.CJRDynamicPassenger r4 = r4.getGstObject()     // Catch:{ JSONException -> 0x06e2 }
                if (r4 != 0) goto L_0x05fc
                kotlin.g.b.k.a()     // Catch:{ JSONException -> 0x06e2 }
            L_0x05fc:
                java.util.List r4 = r4.getValidations()     // Catch:{ JSONException -> 0x06e2 }
                java.lang.Object r4 = r4.get(r7)     // Catch:{ JSONException -> 0x06e2 }
                net.one97.paytmflight.common.entity.travel.CJRDynamicValidation r4 = (net.one97.paytmflight.common.entity.travel.CJRDynamicValidation) r4     // Catch:{ JSONException -> 0x06e2 }
                java.lang.String r4 = r4.getKey()     // Catch:{ JSONException -> 0x06e2 }
                com.travel.flight.pojo.flightticket.CJRFlightDetails$JourneyDetails r5 = r27.getJourneyDetails()     // Catch:{ JSONException -> 0x06e2 }
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r3)     // Catch:{ JSONException -> 0x06e2 }
                com.travel.flight.pojo.flightticket.paxinfo.CJRDynamicPassenger r5 = r5.getGstObject()     // Catch:{ JSONException -> 0x06e2 }
                if (r5 != 0) goto L_0x061a
                kotlin.g.b.k.a()     // Catch:{ JSONException -> 0x06e2 }
            L_0x061a:
                java.util.List r5 = r5.getValidations()     // Catch:{ JSONException -> 0x06e2 }
                java.lang.Object r5 = r5.get(r7)     // Catch:{ JSONException -> 0x06e2 }
                net.one97.paytmflight.common.entity.travel.CJRDynamicValidation r5 = (net.one97.paytmflight.common.entity.travel.CJRDynamicValidation) r5     // Catch:{ JSONException -> 0x06e2 }
                java.lang.String r5 = r5.getmValue()     // Catch:{ JSONException -> 0x06e2 }
                r0.put(r4, r5)     // Catch:{ JSONException -> 0x06e2 }
                if (r7 == r2) goto L_0x0630
                int r7 = r7 + 1
                goto L_0x05ec
            L_0x0630:
                java.lang.String r2 = "gst_details"
                r1.put(r2, r0)     // Catch:{ JSONException -> 0x06e2 }
            L_0x0635:
                com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBody r0 = com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBody.getInstance()     // Catch:{ JSONException -> 0x06e2 }
                java.util.ArrayList r0 = r0.getOnwardJrny()     // Catch:{ JSONException -> 0x06e2 }
                int r0 = r0.size()     // Catch:{ JSONException -> 0x06e2 }
                java.lang.String r2 = "ancillary"
                if (r0 <= 0) goto L_0x066a
                com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBody r0 = com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBody.getInstance()     // Catch:{ JSONException -> 0x06e2 }
                java.util.ArrayList r0 = r0.getReturnJrny()     // Catch:{ JSONException -> 0x06e2 }
                int r0 = r0.size()     // Catch:{ JSONException -> 0x06e2 }
                if (r0 <= 0) goto L_0x066a
                com.google.gsonhtcfix.f r0 = new com.google.gsonhtcfix.f     // Catch:{ JSONException -> 0x06e2 }
                r0.<init>()     // Catch:{ JSONException -> 0x06e2 }
                com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBody r3 = com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBody.getInstance()     // Catch:{ JSONException -> 0x06e2 }
                java.lang.String r0 = r0.a((java.lang.Object) r3)     // Catch:{ JSONException -> 0x06e2 }
                org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x06e2 }
                r3.<init>(r0)     // Catch:{ JSONException -> 0x06e2 }
                r1.put(r2, r3)     // Catch:{ JSONException -> 0x06e2 }
                goto L_0x06eb
            L_0x066a:
                com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBody r0 = com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBody.getInstance()     // Catch:{ JSONException -> 0x06e2 }
                java.util.ArrayList r0 = r0.getOnwardJrny()     // Catch:{ JSONException -> 0x06e2 }
                int r0 = r0.size()     // Catch:{ JSONException -> 0x06e2 }
                if (r0 <= 0) goto L_0x069c
                com.google.gsonhtcfix.f r0 = new com.google.gsonhtcfix.f     // Catch:{ JSONException -> 0x06e2 }
                r0.<init>()     // Catch:{ JSONException -> 0x06e2 }
                com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBody r3 = com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBody.getInstance()     // Catch:{ JSONException -> 0x06e2 }
                java.util.ArrayList r3 = r3.getOnwardJrny()     // Catch:{ JSONException -> 0x06e2 }
                java.lang.String r0 = r0.a((java.lang.Object) r3)     // Catch:{ JSONException -> 0x06e2 }
                org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x06e2 }
                r3.<init>()     // Catch:{ JSONException -> 0x06e2 }
                java.lang.String r4 = "onward"
                org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ JSONException -> 0x06e2 }
                r5.<init>(r0)     // Catch:{ JSONException -> 0x06e2 }
                r3.put(r4, r5)     // Catch:{ JSONException -> 0x06e2 }
                r1.put(r2, r3)     // Catch:{ JSONException -> 0x06e2 }
                goto L_0x06eb
            L_0x069c:
                com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBody r0 = com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBody.getInstance()     // Catch:{ JSONException -> 0x06e2 }
                java.util.ArrayList r0 = r0.getReturnJrny()     // Catch:{ JSONException -> 0x06e2 }
                int r0 = r0.size()     // Catch:{ JSONException -> 0x06e2 }
                if (r0 <= 0) goto L_0x06eb
                com.google.gsonhtcfix.f r0 = new com.google.gsonhtcfix.f     // Catch:{ JSONException -> 0x06e2 }
                r0.<init>()     // Catch:{ JSONException -> 0x06e2 }
                com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBody r3 = com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBody.getInstance()     // Catch:{ JSONException -> 0x06e2 }
                java.util.ArrayList r3 = r3.getReturnJrny()     // Catch:{ JSONException -> 0x06e2 }
                java.lang.String r0 = r0.a((java.lang.Object) r3)     // Catch:{ JSONException -> 0x06e2 }
                org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x06e2 }
                r3.<init>()     // Catch:{ JSONException -> 0x06e2 }
                java.lang.String r4 = "return"
                org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ JSONException -> 0x06e2 }
                r5.<init>(r0)     // Catch:{ JSONException -> 0x06e2 }
                r3.put(r4, r5)     // Catch:{ JSONException -> 0x06e2 }
                r1.put(r2, r3)     // Catch:{ JSONException -> 0x06e2 }
                goto L_0x06eb
            L_0x06ce:
                r1 = r19
                kotlin.u r2 = new kotlin.u     // Catch:{ JSONException -> 0x06e2 }
                r2.<init>(r0)     // Catch:{ JSONException -> 0x06e2 }
                throw r2     // Catch:{ JSONException -> 0x06e2 }
            L_0x06d6:
                r0 = move-exception
                r1 = r19
                goto L_0x06e8
            L_0x06da:
                r1 = r19
                kotlin.u r2 = new kotlin.u     // Catch:{ JSONException -> 0x06e2 }
                r2.<init>(r0)     // Catch:{ JSONException -> 0x06e2 }
                throw r2     // Catch:{ JSONException -> 0x06e2 }
            L_0x06e2:
                r0 = move-exception
                goto L_0x06e8
            L_0x06e4:
                r1 = r4
                goto L_0x06eb
            L_0x06e6:
                r0 = move-exception
                r1 = r4
            L_0x06e8:
                r0.getMessage()
            L_0x06eb:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.tripsummary.c.a.a(boolean, com.travel.flight.pojo.flightticket.CJRFlightDetails, android.content.Context):org.json.JSONObject");
        }

        private static boolean c(String str, CJRFlightDetails cJRFlightDetails) {
            if (cJRFlightDetails == null) {
                k.a();
            }
            if (cJRFlightDetails.getInsuranceData() != null) {
                CJRInsuranceModel insuranceData = cJRFlightDetails.getInsuranceData();
                k.a((Object) insuranceData, "mFlightDetails!!.getInsuranceData()");
                if (insuranceData.getBody() != null) {
                    CJRInsuranceModel insuranceData2 = cJRFlightDetails.getInsuranceData();
                    k.a((Object) insuranceData2, "mFlightDetails!!.getInsuranceData()");
                    CJRInsuranceBody body = insuranceData2.getBody();
                    k.a((Object) body, "mFlightDetails!!.getInsuranceData().body");
                    if (body.getInsuranceDetail() != null) {
                        CJRInsuranceModel insuranceData3 = cJRFlightDetails.getInsuranceData();
                        k.a((Object) insuranceData3, "mFlightDetails!!.getInsuranceData()");
                        CJRInsuranceBody body2 = insuranceData3.getBody();
                        k.a((Object) body2, "mFlightDetails!!.getInsuranceData().body");
                        if (body2.getInsuranceDetail().size() > 0) {
                            CJRInsuranceModel insuranceData4 = cJRFlightDetails.getInsuranceData();
                            k.a((Object) insuranceData4, "mFlightDetails!!.getInsuranceData()");
                            CJRInsuranceBody body3 = insuranceData4.getBody();
                            k.a((Object) body3, "mFlightDetails!!.getInsuranceData().body");
                            if (body3.getInsuranceDetail().get(0) != null) {
                                CJRInsuranceModel insuranceData5 = cJRFlightDetails.getInsuranceData();
                                k.a((Object) insuranceData5, "mFlightDetails!!.getInsuranceData()");
                                CJRInsuranceBody body4 = insuranceData5.getBody();
                                k.a((Object) body4, "mFlightDetails!!.getInsuranceData().body");
                                CJRInsuranceItem cJRInsuranceItem = body4.getInsuranceDetail().get(0);
                                k.a((Object) cJRInsuranceItem, "insuranceItem");
                                Iterator<CJRInsurancePriceDetail> it2 = cJRInsuranceItem.getPriceDetails().iterator();
                                while (it2.hasNext()) {
                                    CJRInsurancePriceDetail next = it2.next();
                                    k.a((Object) next, "priceDetail");
                                    if (p.a(next.getPassengerType(), str, true)) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }

        public static double a(CJRFlightDetails cJRFlightDetails, boolean z) {
            float f2;
            if (cJRFlightDetails == null) {
                k.a();
            }
            double d2 = 0.0d;
            double parseDouble = (cJRFlightDetails.getmRepriceFareDetails() == null || cJRFlightDetails.getmRepriceFareDetails().getmTotalFare() == null || TextUtils.isEmpty(cJRFlightDetails.getmRepriceFareDetails().getmTotalFare())) ? 0.0d : Double.parseDouble(cJRFlightDetails.getmRepriceFareDetails().getmTotalFare());
            if (cJRFlightDetails.getmConvenienceFee() != null) {
                CJRConvenienceFee cJRConvenienceFee = cJRFlightDetails.getmConvenienceFee();
                k.a((Object) cJRConvenienceFee, "mFlightDetails.getmConvenienceFee()");
                Double mtotalConFee = cJRConvenienceFee.getMtotalConFee();
                if (mtotalConFee == null) {
                    k.a();
                }
                f2 = (float) ((int) mtotalConFee.doubleValue());
            } else {
                f2 = 0.0f;
            }
            double d3 = parseDouble + ((double) f2);
            if (z && cJRFlightDetails.getInsuranceData() != null) {
                CJRInsuranceModel insuranceData = cJRFlightDetails.getInsuranceData();
                k.a((Object) insuranceData, "mFlightDetails.insuranceData");
                if (insuranceData.getBody() != null) {
                    CJRInsuranceModel insuranceData2 = cJRFlightDetails.getInsuranceData();
                    k.a((Object) insuranceData2, "mFlightDetails.insuranceData");
                    CJRInsuranceBody body = insuranceData2.getBody();
                    k.a((Object) body, "mFlightDetails.insuranceData.body");
                    if (body.getInsuranceDetail() != null) {
                        CJRInsuranceModel insuranceData3 = cJRFlightDetails.getInsuranceData();
                        k.a((Object) insuranceData3, "mFlightDetails.insuranceData");
                        CJRInsuranceBody body2 = insuranceData3.getBody();
                        k.a((Object) body2, "mFlightDetails.insuranceData.body");
                        if (body2.getInsuranceDetail().size() > 0) {
                            CJRInsuranceModel insuranceData4 = cJRFlightDetails.getInsuranceData();
                            k.a((Object) insuranceData4, "mFlightDetails.insuranceData");
                            CJRInsuranceBody body3 = insuranceData4.getBody();
                            k.a((Object) body3, "mFlightDetails.insuranceData.body");
                            if (body3.getInsuranceDetail().get(0) != null) {
                                CJRInsuranceModel insuranceData5 = cJRFlightDetails.getInsuranceData();
                                k.a((Object) insuranceData5, "mFlightDetails.insuranceData");
                                CJRInsuranceBody body4 = insuranceData5.getBody();
                                k.a((Object) body4, "mFlightDetails.insuranceData.body");
                                CJRInsuranceItem cJRInsuranceItem = body4.getInsuranceDetail().get(0);
                                k.a((Object) cJRInsuranceItem, "mFlightDetails.insurance…a.body.insuranceDetail[0]");
                                double totalPremium = cJRInsuranceItem.getTotalPremium();
                                CJRInsuranceModel insuranceData6 = cJRFlightDetails.getInsuranceData();
                                k.a((Object) insuranceData6, "mFlightDetails.insuranceData");
                                CJRInsuranceBody body5 = insuranceData6.getBody();
                                k.a((Object) body5, "mFlightDetails.insuranceData.body");
                                CJRInsuranceItem cJRInsuranceItem2 = body5.getInsuranceDetail().get(0);
                                k.a((Object) cJRInsuranceItem2, "mFlightDetails.insurance…a.body.insuranceDetail[0]");
                                if (cJRInsuranceItem2.getUserInputInfo() != null) {
                                    CJRInsuranceModel insuranceData7 = cJRFlightDetails.getInsuranceData();
                                    k.a((Object) insuranceData7, "mFlightDetails.insuranceData");
                                    CJRInsuranceBody body6 = insuranceData7.getBody();
                                    k.a((Object) body6, "mFlightDetails.insuranceData.body");
                                    CJRInsuranceItem cJRInsuranceItem3 = body6.getInsuranceDetail().get(0);
                                    k.a((Object) cJRInsuranceItem3, "mFlightDetails.insurance…a.body.insuranceDetail[0]");
                                    if (cJRInsuranceItem3.isOne_way_international()) {
                                        CJRInsuranceModel insuranceData8 = cJRFlightDetails.getInsuranceData();
                                        k.a((Object) insuranceData8, "mFlightDetails.insuranceData");
                                        CJRInsuranceBody body7 = insuranceData8.getBody();
                                        k.a((Object) body7, "mFlightDetails.insuranceData.body");
                                        CJRInsuranceItem cJRInsuranceItem4 = body7.getInsuranceDetail().get(0);
                                        k.a((Object) cJRInsuranceItem4, "mFlightDetails.insurance…a.body.insuranceDetail[0]");
                                        int selectedDays = cJRInsuranceItem4.getUserInputInfo().getSelectedDays();
                                        if (selectedDays > 0) {
                                            totalPremium *= (double) selectedDays;
                                        }
                                    }
                                }
                                d3 += totalPremium;
                            }
                        }
                    }
                }
            }
            if (cJRFlightDetails.isInsuranceCancelProtectApplied() && cJRFlightDetails.getInsuranceData() != null) {
                CJRInsuranceModel insuranceData9 = cJRFlightDetails.getInsuranceData();
                k.a((Object) insuranceData9, "mFlightDetails.insuranceData");
                if (insuranceData9.getBody() != null) {
                    CJRInsuranceModel insuranceData10 = cJRFlightDetails.getInsuranceData();
                    k.a((Object) insuranceData10, "mFlightDetails.insuranceData");
                    CJRInsuranceBody body8 = insuranceData10.getBody();
                    k.a((Object) body8, "mFlightDetails.insuranceData.body");
                    if (body8.getCancelProtectInsuranceDetail() != null) {
                        CJRInsuranceModel insuranceData11 = cJRFlightDetails.getInsuranceData();
                        k.a((Object) insuranceData11, "mFlightDetails.insuranceData");
                        CJRInsuranceBody body9 = insuranceData11.getBody();
                        k.a((Object) body9, "mFlightDetails.insuranceData.body");
                        if (body9.getCancelProtectInsuranceDetail().size() > 0) {
                            CJRInsuranceModel insuranceData12 = cJRFlightDetails.getInsuranceData();
                            k.a((Object) insuranceData12, "mFlightDetails.insuranceData");
                            CJRInsuranceBody body10 = insuranceData12.getBody();
                            k.a((Object) body10, "mFlightDetails.insuranceData.body");
                            if (body10.getCancelProtectInsuranceDetail().get(0) != null) {
                                CJRInsuranceModel insuranceData13 = cJRFlightDetails.getInsuranceData();
                                k.a((Object) insuranceData13, "mFlightDetails.insuranceData");
                                CJRInsuranceBody body11 = insuranceData13.getBody();
                                k.a((Object) body11, "mFlightDetails.insuranceData.body");
                                CJRCancelProtectInsuranceItem cJRCancelProtectInsuranceItem = body11.getCancelProtectInsuranceDetail().get(0);
                                k.a((Object) cJRCancelProtectInsuranceItem, "mFlightDetails.insurance…ProtectInsuranceDetail[0]");
                                d3 += cJRCancelProtectInsuranceItem.getTotalPremium();
                            }
                        }
                    }
                }
            }
            if (cJRFlightDetails.getBundleList() != null && cJRFlightDetails.getBundleList().size() > 0) {
                if (cJRFlightDetails.getBundleList() != null && cJRFlightDetails.getBundleList().size() > 0) {
                    try {
                        double d4 = 0.0d;
                        for (FlightSellingBundleResponseData component9 : cJRFlightDetails.getBundleList()) {
                            d4 += component9.component9();
                        }
                        d2 = d4;
                    } catch (Exception unused) {
                    }
                }
                d3 += d2;
            }
            CJRFlightDetails.JourneyDetails journeyDetails = cJRFlightDetails.getJourneyDetails();
            k.a((Object) journeyDetails, "mFlightDetails.journeyDetails");
            double a2 = a(journeyDetails.getTravellerSeatTransitionObj());
            Double d5 = CJRFlightAncillaryReqBody.getInstance().getmSelectedBaggageTotalAmount();
            if (d5 == null) {
                k.a();
            }
            double doubleValue = d5.doubleValue();
            Double d6 = CJRFlightAncillaryReqBody.getInstance().getmSelectedMealsTotalAmount();
            if (d6 == null) {
                k.a();
            }
            return d3 + a2 + doubleValue + d6.doubleValue();
        }

        public static void a(Context context) {
            k.c(context, "context");
            c.Y = context;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
            r0 = r0.getResources();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static java.lang.String a(java.lang.String r5) {
            /*
                android.content.Context r0 = com.travel.flight.tripsummary.c.Y
                r1 = 0
                if (r0 == 0) goto L_0x0014
                android.content.res.Resources r0 = r0.getResources()
                if (r0 == 0) goto L_0x0014
                int r2 = com.travel.flight.R.string.flights_mr
                java.lang.String r0 = r0.getString(r2)
                goto L_0x0015
            L_0x0014:
                r0 = r1
            L_0x0015:
                android.content.Context r2 = com.travel.flight.tripsummary.c.Y
                if (r2 == 0) goto L_0x0028
                android.content.res.Resources r2 = r2.getResources()
                if (r2 == 0) goto L_0x0028
                int r3 = com.travel.flight.R.string.flights_mrs
                java.lang.String r2 = r2.getString(r3)
                goto L_0x0029
            L_0x0028:
                r2 = r1
            L_0x0029:
                android.content.Context r3 = com.travel.flight.tripsummary.c.Y
                if (r3 == 0) goto L_0x003c
                android.content.res.Resources r3 = r3.getResources()
                if (r3 == 0) goto L_0x003c
                int r4 = com.travel.flight.R.string.flights_ms
                java.lang.String r3 = r3.getString(r4)
                goto L_0x003d
            L_0x003c:
                r3 = r1
            L_0x003d:
                android.content.Context r4 = com.travel.flight.tripsummary.c.Y
                if (r4 == 0) goto L_0x004f
                android.content.res.Resources r4 = r4.getResources()
                if (r4 == 0) goto L_0x004f
                int r1 = com.travel.flight.R.string.flights_mstr
                java.lang.String r1 = r4.getString(r1)
            L_0x004f:
                r4 = r5
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                boolean r4 = android.text.TextUtils.isEmpty(r4)
                if (r4 != 0) goto L_0x007c
                r4 = 1
                boolean r0 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r0, (boolean) r4)
                if (r0 == 0) goto L_0x0062
                java.lang.String r5 = "MR"
                return r5
            L_0x0062:
                boolean r0 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r2, (boolean) r4)
                if (r0 == 0) goto L_0x006b
                java.lang.String r5 = "Mrs"
                return r5
            L_0x006b:
                boolean r0 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r3, (boolean) r4)
                if (r0 == 0) goto L_0x0074
                java.lang.String r5 = "Ms"
                return r5
            L_0x0074:
                boolean r0 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r1, (boolean) r4)
                if (r0 == 0) goto L_0x007c
                java.lang.String r5 = "Mstr"
            L_0x007c:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.tripsummary.c.a.a(java.lang.String):java.lang.String");
        }
    }

    public final void a(Activity activity) {
        k.c(activity, "activty");
        a((com.paytm.network.listener.b) this.m, activity);
    }

    private void a(com.paytm.network.listener.b bVar, Activity activity) {
        k.c(bVar, "paytmCommonAppListener");
        k.c(activity, "activty");
        if (com.paytm.utility.b.c((Context) getApplication())) {
            String string = activity.getResources().getString(R.string.pre_f_please_wait_progress_msg);
            k.a((Object) string, "activty.getResources().g…please_wait_progress_msg)");
            a(string);
            com.travel.flight.flightorder.i.a.a(Y);
            com.travel.flight.flightorder.i.a.a(activity, bVar);
            return;
        }
        Application application = getApplication();
        k.a((Object) application, "getApplication()");
        Context context = application;
        String string2 = context.getResources().getString(R.string.no_internet);
        k.a((Object) string2, "context.resources.getString(R.string.no_internet)");
        String string3 = context.getResources().getString(R.string.no_connection);
        k.a((Object) string3, "context.resources.getStr…g(R.string.no_connection)");
        String string4 = context.getResources().getString(R.string.retry);
        k.a((Object) string4, "context.resources.getString(R.string.retry)");
        a(new f(string3, string2, string4, (String) null));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0078, code lost:
        if (r1.getBookingSegment() != com.travel.flight.flightticket.d.b.Modify) goto L_0x007a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r8, com.travel.flight.pojo.flightticket.CJRFlightDetails r9) {
        /*
            r7 = this;
            boolean r0 = r7.a()
            if (r0 == 0) goto L_0x000a
            r7.b(r8, r9)
            return
        L_0x000a:
            r0 = 1
            java.lang.String r1 = ""
            java.lang.String r8 = r7.a(r8, r1, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r8)
            java.lang.String r8 = "&userType="
            r0.append(r8)
            java.lang.String r8 = r7.o
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            android.app.Application r0 = r7.getApplication()
            java.lang.String r1 = "getApplication()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.content.Context r0 = (android.content.Context) r0
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r2.<init>()
            java.util.Map r2 = (java.util.Map) r2
            java.lang.String r3 = "Content-Type"
            java.lang.String r4 = "application/json"
            r2.put(r3, r4)
            java.lang.String r3 = com.paytm.utility.d.a(r0)
            java.lang.String r4 = "CJRNetUtility.getSSOToken(context)"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            java.lang.String r4 = "sso_token"
            r2.put(r4, r3)
            r3 = 0
            android.app.Application r4 = r7.getApplication()
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r1)
            android.content.Context r4 = (android.content.Context) r4
            org.json.JSONObject r9 = com.travel.flight.tripsummary.c.a.a(r3, r9, r4)
            r7.f25561b = r9
            boolean r1 = com.paytm.utility.b.c((android.content.Context) r0)
            if (r1 == 0) goto L_0x015a
            java.lang.String r1 = "Please wait..."
            r7.a((java.lang.String) r1)
            com.travel.flight.pojo.flightticket.CJRFlightSearchInput r1 = r7.f25562c
            if (r1 == 0) goto L_0x007a
            if (r1 != 0) goto L_0x0072
            kotlin.g.b.k.a()
        L_0x0072:
            com.travel.flight.flightticket.d.b r1 = r1.getBookingSegment()
            com.travel.flight.flightticket.d.b r3 = com.travel.flight.flightticket.d.b.Modify
            if (r1 == r3) goto L_0x0090
        L_0x007a:
            com.travel.flight.b r1 = com.travel.flight.b.a()
            java.lang.String r3 = "FlightController.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            com.travel.flight.c r1 = com.travel.flight.b.b()
            java.lang.String r8 = r1.a((java.lang.String) r8)
            java.lang.String r1 = "FlightController.getInst…reVerifyNativePGFlow(url)"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r1)
        L_0x0090:
            com.travel.flight.pojo.flightticket.CJRFlightSearchInput r1 = r7.f25562c
            java.lang.String r3 = "NETWORK_TAG_TRAVELLER_ITINERARY"
            java.lang.String r4 = "networking"
            r5 = 0
            if (r1 == 0) goto L_0x00fc
            if (r1 != 0) goto L_0x009e
            kotlin.g.b.k.a()
        L_0x009e:
            com.travel.flight.flightticket.d.b r1 = r1.getBookingSegment()
            com.travel.flight.flightticket.d.b r6 = com.travel.flight.flightticket.d.b.Modify
            if (r1 != r6) goto L_0x00fc
            com.paytm.network.b r9 = new com.paytm.network.b
            r9.<init>()
            com.paytm.network.b r9 = r9.a((android.content.Context) r0)
            com.paytm.network.a$b r0 = com.paytm.network.a.b.SILENT
            com.paytm.network.b r9 = r9.a((com.paytm.network.a.b) r0)
            java.lang.String r0 = z
            com.paytm.network.b r9 = r9.c(r0)
            com.paytm.network.a$c r0 = com.paytm.network.a.c.FLIGHT
            com.paytm.network.b r9 = r9.a((com.paytm.network.a.c) r0)
            com.paytm.network.a$a r0 = com.paytm.network.a.C0715a.POST
            com.paytm.network.b r9 = r9.a((com.paytm.network.a.C0715a) r0)
            com.paytm.network.b r8 = r9.a((java.lang.String) r8)
            com.paytm.network.b r8 = r8.h()
            com.paytm.network.b r8 = r8.a((java.util.Map<java.lang.String, java.lang.String>) r2)
            com.paytm.network.b r8 = r8.b((java.util.Map) r5)
            com.travel.flight.pojo.flightticket.CJRFlightPayment r9 = new com.travel.flight.pojo.flightticket.CJRFlightPayment
            r9.<init>()
            com.paytm.network.model.IJRPaytmDataModel r9 = (com.paytm.network.model.IJRPaytmDataModel) r9
            com.paytm.network.b r8 = r8.a((com.paytm.network.model.IJRPaytmDataModel) r9)
            com.travel.flight.tripsummary.b r9 = r7.m
            com.paytm.network.listener.b r9 = (com.paytm.network.listener.b) r9
            com.paytm.network.b r8 = r8.a((com.paytm.network.listener.b) r9)
            com.paytm.network.b r8 = r8.a((org.json.JSONObject) r5)
            com.paytm.network.a r8 = r8.l()
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r4)
            r8.a((java.lang.Object) r3)
            r8.a()
            return
        L_0x00fc:
            com.paytm.network.b r1 = new com.paytm.network.b
            r1.<init>()
            com.paytm.network.b r0 = r1.a((android.content.Context) r0)
            com.paytm.network.a$b r1 = com.paytm.network.a.b.SILENT
            com.paytm.network.b r0 = r0.a((com.paytm.network.a.b) r1)
            java.lang.String r1 = z
            com.paytm.network.b r0 = r0.c(r1)
            com.paytm.network.a$c r1 = com.paytm.network.a.c.FLIGHT
            com.paytm.network.b r0 = r0.a((com.paytm.network.a.c) r1)
            com.paytm.network.a$a r1 = com.paytm.network.a.C0715a.POST
            com.paytm.network.b r0 = r0.a((com.paytm.network.a.C0715a) r1)
            com.paytm.network.b r8 = r0.a((java.lang.String) r8)
            com.paytm.network.b r8 = r8.h()
            com.paytm.network.b r8 = r8.a((java.util.Map<java.lang.String, java.lang.String>) r2)
            com.paytm.network.b r8 = r8.b((java.util.Map) r5)
            java.lang.String r9 = r9.toString()
            com.paytm.network.b r8 = r8.b((java.lang.String) r9)
            com.travel.flight.pojo.flightticket.CJRFlightPayment r9 = new com.travel.flight.pojo.flightticket.CJRFlightPayment
            r9.<init>()
            com.paytm.network.model.IJRPaytmDataModel r9 = (com.paytm.network.model.IJRPaytmDataModel) r9
            com.paytm.network.b r8 = r8.a((com.paytm.network.model.IJRPaytmDataModel) r9)
            com.travel.flight.tripsummary.b r9 = r7.m
            com.paytm.network.listener.b r9 = (com.paytm.network.listener.b) r9
            com.paytm.network.b r8 = r8.a((com.paytm.network.listener.b) r9)
            com.paytm.network.b r8 = r8.a((org.json.JSONObject) r5)
            com.paytm.network.a r8 = r8.l()
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r4)
            r8.a((java.lang.Object) r3)
            r8.a()
            return
        L_0x015a:
            android.content.res.Resources r8 = r0.getResources()
            int r9 = com.travel.flight.R.string.no_connection
            java.lang.String r8 = r8.getString(r9)
            android.content.res.Resources r9 = r0.getResources()
            int r1 = com.travel.flight.R.string.no_internet
            java.lang.String r9 = r9.getString(r1)
            com.paytm.utility.b.b((android.content.Context) r0, (java.lang.String) r8, (java.lang.String) r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.tripsummary.c.a(java.lang.String, com.travel.flight.pojo.flightticket.CJRFlightDetails):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:84:0x01ca  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(com.travel.flight.pojo.flightticket.CJRFlightSearchResult r7) {
        /*
            r6 = this;
            android.app.Application r0 = r6.getApplication()
            java.lang.String r1 = "getApplication()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.content.Context r0 = (android.content.Context) r0
            java.lang.String r1 = "round_trip"
            java.lang.String r2 = "mFlightDetails!!.journeyDetails"
            r3 = 1
            if (r7 == 0) goto L_0x01ea
            com.travel.flight.pojo.flightticket.CJRStatus r4 = r7.getmStatus()
            if (r4 == 0) goto L_0x01ea
            com.travel.flight.pojo.flightticket.CJRStatus r4 = r7.getmStatus()
            java.lang.String r4 = r4.getmResult()
            java.lang.String r5 = "success"
            boolean r4 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r4, (boolean) r3)
            if (r4 == 0) goto L_0x01ea
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r6.f25560a
            if (r0 != 0) goto L_0x002f
            kotlin.g.b.k.a()
        L_0x002f:
            com.travel.flight.pojo.flightticket.CJRStatus r4 = r7.getmStatus()
            r0.setStatus(r4)
            com.travel.flight.pojo.flightticket.CJROnwardReturnFlightInformation r0 = r7.getmOnwardReturnFlights()
            if (r0 == 0) goto L_0x004e
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r6.f25560a
            if (r0 != 0) goto L_0x0043
            kotlin.g.b.k.a()
        L_0x0043:
            com.travel.flight.pojo.flightticket.CJROnwardReturnFlightInformation r4 = r7.getmOnwardReturnFlights()
            com.travel.flight.pojo.flightticket.CJRMeta r4 = r4.getmCJRMeta()
            r0.setMeta(r4)
        L_0x004e:
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r6.f25560a
            if (r0 != 0) goto L_0x0055
            kotlin.g.b.k.a()
        L_0x0055:
            com.travel.flight.pojo.flightticket.CJRRepriceFlightFare r0 = r0.getmRepriceFareDetails()
            if (r0 == 0) goto L_0x00a5
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r6.f25560a
            if (r0 != 0) goto L_0x0062
            kotlin.g.b.k.a()
        L_0x0062:
            com.travel.flight.pojo.flightticket.CJRRepriceFlightFare r0 = r0.getmRepriceFareDetails()
            java.lang.String r0 = r0.getmTotalFare()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00a5
            com.travel.flight.pojo.flightticket.CJRFlightPrice r0 = new com.travel.flight.pojo.flightticket.CJRFlightPrice
            r0.<init>()
            com.travel.flight.pojo.flightticket.CJRFlightDetails r4 = r6.f25560a
            if (r4 != 0) goto L_0x007e
            kotlin.g.b.k.a()
        L_0x007e:
            com.travel.flight.pojo.flightticket.CJRRepriceFlightFare r4 = r4.getmRepriceFareDetails()
            java.lang.String r4 = r4.getmTotalFare()
            java.lang.String r4 = r4.toString()
            r0.setmFlightCost(r4)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r4 = r6.f25560a
            if (r4 != 0) goto L_0x0094
            kotlin.g.b.k.a()
        L_0x0094:
            java.lang.String r4 = r4.getmOnwardServiceProvider()
            r0.setmServiceProvider(r4)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r4 = r6.f25560a
            if (r4 != 0) goto L_0x00a2
            kotlin.g.b.k.a()
        L_0x00a2:
            r4.setmFareDetails(r0)
        L_0x00a5:
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r6.f25560a
            if (r0 != 0) goto L_0x00ac
            kotlin.g.b.k.a()
        L_0x00ac:
            com.travel.flight.pojo.flightticket.CJRFlightDetails$JourneyDetails r0 = r0.getJourneyDetails()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            java.lang.String r0 = r0.getTripType()
            if (r0 == 0) goto L_0x016f
            com.travel.flight.pojo.flightticket.CJROnwardReturnFlightInformation r0 = r7.getmOnwardReturnFlights()
            if (r0 == 0) goto L_0x016f
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r6.f25560a
            if (r0 != 0) goto L_0x00c6
            kotlin.g.b.k.a()
        L_0x00c6:
            com.travel.flight.pojo.flightticket.CJRFlightDetails$JourneyDetails r0 = r0.getJourneyDetails()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            java.lang.String r0 = r0.getTripType()
            boolean r0 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r0, (boolean) r3)
            if (r0 == 0) goto L_0x016f
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r6.f25560a
            if (r0 != 0) goto L_0x00de
            kotlin.g.b.k.a()
        L_0x00de:
            com.travel.flight.pojo.flightticket.CJROnwardReturnFlightInformation r1 = r7.getmOnwardReturnFlights()
            com.travel.flight.pojo.flightticket.CJROnwardFlights r1 = r1.getmRepriceOnwardFlight()
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r1 = r1.getmRepriceFlight()
            r0.setmOnwardJourney(r1)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r6.f25560a
            if (r0 != 0) goto L_0x00f4
            kotlin.g.b.k.a()
        L_0x00f4:
            com.travel.flight.pojo.flightticket.CJROnwardReturnFlightInformation r1 = r7.getmOnwardReturnFlights()
            com.travel.flight.pojo.flightticket.CJROnwardFlights r1 = r1.getmRepriceOnwardFlight()
            java.lang.String r1 = r1.getmRepriceProvider()
            r0.setmOnwardServiceProvider(r1)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r6.f25560a
            if (r0 != 0) goto L_0x010a
            kotlin.g.b.k.a()
        L_0x010a:
            com.travel.flight.pojo.flightticket.CJROnwardReturnFlightInformation r1 = r7.getmOnwardReturnFlights()
            com.travel.flight.pojo.flightticket.CJROnwardFlights r1 = r1.getmRepriceReturnFlight()
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r1 = r1.getmRepriceFlight()
            r0.setmReturnJourney(r1)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r6.f25560a
            if (r0 != 0) goto L_0x0120
            kotlin.g.b.k.a()
        L_0x0120:
            com.travel.flight.pojo.flightticket.CJROnwardReturnFlightInformation r1 = r7.getmOnwardReturnFlights()
            com.travel.flight.pojo.flightticket.CJROnwardFlights r1 = r1.getmRepriceReturnFlight()
            java.lang.String r1 = r1.getmRepriceProvider()
            r0.setmReturnServiceProvider(r1)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r6.f25560a
            if (r0 != 0) goto L_0x0136
            kotlin.g.b.k.a()
        L_0x0136:
            com.travel.flight.pojo.flightticket.CJROnwardReturnFlightInformation r1 = r7.getmOnwardReturnFlights()
            com.travel.flight.pojo.flightticket.CJRRepriceFlightFare r1 = r1.getmRepriceFare()
            r0.setmRepriceFareDetails(r1)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r6.f25560a
            if (r0 != 0) goto L_0x0148
            kotlin.g.b.k.a()
        L_0x0148:
            com.travel.flight.pojo.flightticket.CJROnwardReturnFlightInformation r1 = r7.getmOnwardReturnFlights()
            com.travel.flight.pojo.flightticket.CJRRepriceFlightFare r1 = r1.getmRepriceFare()
            com.travel.flight.pojo.flightticket.CJRConvenienceFee r1 = r1.getmConvenienceFee()
            r0.setmConvenienceFee(r1)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r6.f25560a
            if (r0 != 0) goto L_0x015e
            kotlin.g.b.k.a()
        L_0x015e:
            com.travel.flight.pojo.flightticket.CJROnwardReturnFlightInformation r1 = r7.getmOnwardReturnFlights()
            java.lang.String r2 = "flightSearchResult.getmOnwardReturnFlights()"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            com.travel.flight.pojo.flightticket.CJRFlightReviewGst r1 = r1.getGst()
            r0.setGst(r1)
            goto L_0x01c3
        L_0x016f:
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r6.f25560a
            if (r0 != 0) goto L_0x0176
            kotlin.g.b.k.a()
        L_0x0176:
            com.travel.flight.pojo.flightticket.CJROnwardReturnFlightInformation r1 = r7.getmOnwardReturnFlights()
            com.travel.flight.pojo.flightticket.CJROnwardFlights r1 = r1.getmRepriceOnwardFlight()
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r1 = r1.getmRepriceFlight()
            r0.setmOnwardJourney(r1)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r6.f25560a
            if (r0 != 0) goto L_0x018c
            kotlin.g.b.k.a()
        L_0x018c:
            com.travel.flight.pojo.flightticket.CJROnwardReturnFlightInformation r1 = r7.getmOnwardReturnFlights()
            com.travel.flight.pojo.flightticket.CJROnwardFlights r1 = r1.getmRepriceOnwardFlight()
            java.lang.String r1 = r1.getmRepriceProvider()
            r0.setmOnwardServiceProvider(r1)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r6.f25560a
            if (r0 != 0) goto L_0x01a2
            kotlin.g.b.k.a()
        L_0x01a2:
            com.travel.flight.pojo.flightticket.CJROnwardReturnFlightInformation r1 = r7.getmOnwardReturnFlights()
            com.travel.flight.pojo.flightticket.CJRRepriceFlightFare r1 = r1.getmRepriceFare()
            r0.setmRepriceFareDetails(r1)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r6.f25560a
            if (r0 != 0) goto L_0x01b4
            kotlin.g.b.k.a()
        L_0x01b4:
            com.travel.flight.pojo.flightticket.CJROnwardReturnFlightInformation r1 = r7.getmOnwardReturnFlights()
            com.travel.flight.pojo.flightticket.CJRRepriceFlightFare r1 = r1.getmRepriceFare()
            com.travel.flight.pojo.flightticket.CJRConvenienceFee r1 = r1.getmConvenienceFee()
            r0.setmConvenienceFee(r1)
        L_0x01c3:
            r6.n()
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r6.f25560a
            if (r0 != 0) goto L_0x01cd
            kotlin.g.b.k.a()
        L_0x01cd:
            com.travel.flight.pojo.flightticket.CJRRepriceFlightFare r0 = r0.getmRepriceFareDetails()
            java.lang.String r1 = "mFlightDetails!!.getmRepriceFareDetails()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r1 = r6.f25560a
            r2 = 0
            double r1 = com.travel.flight.tripsummary.c.a.a((com.travel.flight.pojo.flightticket.CJRFlightDetails) r1, (boolean) r2)
            java.lang.String r1 = java.lang.Double.toString(r1)
            r0.setTotalFee(r1)
            androidx.lifecycle.y<com.travel.flight.pojo.flightticket.CJRFlightSearchResult> r0 = r6.f25564e
            r0.postValue(r7)
            return
        L_0x01ea:
            if (r7 != 0) goto L_0x01ef
            kotlin.g.b.k.a()
        L_0x01ef:
            com.travel.flight.pojo.flightticket.CJRStatus r7 = r7.getmStatus()
            if (r7 == 0) goto L_0x026e
            com.travel.flight.pojo.flightticket.CJRFlightMessage r4 = r7.getmFlightMesssgae()
            java.lang.String r4 = r4.getmTitle()
            com.travel.flight.pojo.flightticket.CJRFlightMessage r7 = r7.getmFlightMesssgae()
            java.lang.String r7 = r7.getmMessage()
            com.paytm.utility.b.b((android.content.Context) r0, (java.lang.String) r4, (java.lang.String) r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            com.travel.flight.pojo.flightticket.CJRFlightDetails r4 = r6.f25560a
            if (r4 != 0) goto L_0x0214
            kotlin.g.b.k.a()
        L_0x0214:
            java.lang.Boolean r4 = r4.getmIsInternational()
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 == 0) goto L_0x022b
            android.content.res.Resources r4 = r0.getResources()
            int r5 = com.travel.flight.R.string.international_text
            java.lang.String r4 = r4.getString(r5)
            goto L_0x0235
        L_0x022b:
            android.content.res.Resources r4 = r0.getResources()
            int r5 = com.travel.flight.R.string.domestic_text
            java.lang.String r4 = r4.getString(r5)
        L_0x0235:
            r7.append(r4)
            java.lang.String r4 = "&"
            r7.append(r4)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r4 = r6.f25560a
            if (r4 != 0) goto L_0x0244
            kotlin.g.b.k.a()
        L_0x0244:
            com.travel.flight.pojo.flightticket.CJRFlightDetails$JourneyDetails r4 = r4.getJourneyDetails()
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r2)
            java.lang.String r2 = r4.getTripType()
            boolean r1 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r1, (boolean) r3)
            if (r1 == 0) goto L_0x0260
            android.content.res.Resources r0 = r0.getResources()
            int r1 = com.travel.flight.R.string.flight_roundtrip_text
            java.lang.String r0 = r0.getString(r1)
            goto L_0x026a
        L_0x0260:
            android.content.res.Resources r0 = r0.getResources()
            int r1 = com.travel.flight.R.string.flight_oneway_text
            java.lang.String r0 = r0.getString(r1)
        L_0x026a:
            r7.append(r0)
            return
        L_0x026e:
            kotlin.u r7 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type com.travel.flight.pojo.flightticket.CJRStatus"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.tripsummary.c.a(com.travel.flight.pojo.flightticket.CJRFlightSearchResult):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x009e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0117  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String a(java.lang.String r6, java.lang.String r7, boolean r8) {
        /*
            r5 = this;
            com.travel.flight.pojo.flightticket.CJRFlightSearchInput r0 = r5.f25562c
            java.lang.String r1 = "FlightController.getInstance().flightEventListener"
            java.lang.String r2 = "FlightController.getInstance()"
            java.lang.String r3 = ""
            if (r0 == 0) goto L_0x0079
            if (r0 != 0) goto L_0x000f
            kotlin.g.b.k.a()
        L_0x000f:
            com.travel.flight.flightticket.d.b r0 = r0.getBookingSegment()
            com.travel.flight.flightticket.d.b r4 = com.travel.flight.flightticket.d.b.Modify
            if (r0 != r4) goto L_0x0079
            com.travel.flight.b r7 = com.travel.flight.b.a()
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r2)
            com.travel.flight.c r7 = com.travel.flight.b.b()
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r1)
            java.lang.String r7 = r7.W()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r7)
            java.lang.String r7 = "?order_id="
            r8.append(r7)
            com.travel.flight.pojo.flightticket.CJRFlightSearchInput r7 = r5.f25562c
            if (r7 != 0) goto L_0x003d
            kotlin.g.b.k.a()
        L_0x003d:
            java.lang.String r7 = r7.getModifyBookingOrderId()
            r8.append(r7)
            java.lang.String r7 = "&departureDate="
            r8.append(r7)
            com.travel.flight.pojo.flightticket.CJRFlightSearchInput r7 = r5.f25562c
            if (r7 != 0) goto L_0x0050
            kotlin.g.b.k.a()
        L_0x0050:
            java.lang.String r7 = r7.getDate()
            java.lang.String r7 = r7.toString()
            r0 = 0
            java.lang.String r1 = "-"
            java.lang.String r7 = kotlin.m.p.a(r7, r1, r3, r0)
            r8.append(r7)
            java.lang.String r7 = "&sso_token="
            r8.append(r7)
            android.app.Application r7 = r5.getApplication()
            android.content.Context r7 = (android.content.Context) r7
            java.lang.String r7 = com.paytm.utility.d.a(r7)
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            goto L_0x0098
        L_0x0079:
            r0 = r7
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0098
            if (r8 == 0) goto L_0x0097
            com.travel.flight.b r7 = com.travel.flight.b.a()
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r2)
            com.travel.flight.c r7 = com.travel.flight.b.b()
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r1)
            java.lang.String r7 = r7.d()
            goto L_0x0098
        L_0x0097:
            return r3
        L_0x0098:
            boolean r8 = android.webkit.URLUtil.isValidUrl(r7)
            if (r8 != 0) goto L_0x009f
            return r3
        L_0x009f:
            android.app.Application r8 = r5.getApplication()
            java.lang.String r0 = "getApplication()"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r0)
            android.content.Context r8 = (android.content.Context) r8
            java.lang.String r7 = com.paytm.utility.b.s(r8, r7)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r8 = r5.f25560a
            if (r8 != 0) goto L_0x00b5
            kotlin.g.b.k.a()
        L_0x00b5:
            com.travel.flight.pojo.flightticket.CJRFlightDetails$JourneyDetails r8 = r8.getJourneyDetails()
            java.lang.String r0 = "mFlightDetails!!.journeyDetails"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r0)
            java.lang.String r8 = r8.getTripType()
            java.lang.String r1 = "url"
            if (r8 == 0) goto L_0x00ec
            com.travel.flight.pojo.flightticket.CJRFlightDetails r8 = r5.f25560a
            if (r8 != 0) goto L_0x00ce
            kotlin.g.b.k.a()
        L_0x00ce:
            com.travel.flight.pojo.flightticket.CJRFlightDetails$JourneyDetails r8 = r8.getJourneyDetails()
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r0)
            java.lang.String r8 = r8.getTripType()
            r2 = 1
            java.lang.String r3 = "round_trip"
            boolean r8 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r3, (boolean) r2)
            if (r8 == 0) goto L_0x00ec
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r1)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r8 = r5.f25560a
            java.lang.String r7 = com.travel.flight.tripsummary.c.a.a((java.lang.String) r7, (com.travel.flight.pojo.flightticket.CJRFlightDetails) r8)
            goto L_0x00f5
        L_0x00ec:
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r1)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r8 = r5.f25560a
            java.lang.String r7 = com.travel.flight.tripsummary.c.a.b(r7, r8)
        L_0x00f5:
            android.net.Uri r7 = android.net.Uri.parse(r7)
            android.net.Uri$Builder r7 = r7.buildUpon()
            java.lang.String r8 = "wallet_token"
            r7.appendQueryParameter(r8, r6)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r6 = r5.f25560a
            if (r6 != 0) goto L_0x010a
            kotlin.g.b.k.a()
        L_0x010a:
            com.travel.flight.pojo.flightticket.CJRFlightDetails$JourneyDetails r6 = r6.getJourneyDetails()
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r0)
            boolean r6 = r6.isIslastnameValidationRequiered()
            if (r6 == 0) goto L_0x011e
            java.lang.String r6 = "ignore_last_name_validation"
            java.lang.String r8 = "true"
            r7.appendQueryParameter(r6, r8)
        L_0x011e:
            android.net.Uri r6 = r7.build()
            java.lang.String r6 = r6.toString()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.tripsummary.c.a(java.lang.String, java.lang.String, boolean):java.lang.String");
    }

    public final boolean a() {
        CJRFlightDetails cJRFlightDetails = this.f25560a;
        if (cJRFlightDetails == null) {
            k.a();
        }
        CJRMetadetails cJRMetadetails = cJRFlightDetails.getmMetaDetails();
        k.a((Object) cJRMetadetails, "mFlightDetails!!.getmMetaDetails()");
        return cJRMetadetails.isAndFlowEnabled() && !TextUtils.isEmpty(m());
    }

    private final void b(String str, CJRFlightDetails cJRFlightDetails) {
        Application application = getApplication();
        k.a((Object) application, "getApplication()");
        Context context = application;
        String str2 = a(str, m(), false) + "&userType=" + this.o;
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("Content-Type", "application/json");
        String a2 = d.a(context);
        k.a((Object) a2, "CJRNetUtility.getSSOToken(context)");
        linkedHashMap.put(AppConstants.SSO_TOKEN, a2);
        Application application2 = getApplication();
        k.a((Object) application2, "getApplication()");
        JSONObject a3 = a.a(false, cJRFlightDetails, application2);
        if (cJRFlightDetails == null) {
            k.a();
        }
        if (cJRFlightDetails.getJourneyDetails().getmPaymentIntent() != null) {
            try {
                a3.put(EMIConstants.PAYMENT_INTENT, new JSONArray(cJRFlightDetails.getJourneyDetails().getmPaymentIntent()));
            } catch (JSONException unused) {
            }
        }
        this.f25561b = a3;
        if (com.paytm.utility.b.c(context)) {
            a("Please wait...");
            k.a((Object) b.a(), "FlightController.getInstance()");
            String a4 = b.b().a(str2);
            k.a((Object) a4, "FlightController.getInst…reVerifyNativePGFlow(url)");
            Uri.Builder buildUpon = Uri.parse(a4).buildUpon();
            buildUpon.appendQueryParameter("payment_info", "1");
            buildUpon.appendQueryParameter("payment_info_version", "2");
            String uri = buildUpon.build().toString();
            k.a((Object) uri, "builder.build().toString()");
            com.paytm.network.a l2 = new com.paytm.network.b().a(context).a(a.b.SILENT).c(z).a(a.c.FLIGHT).a(a.C0715a.POST).a(uri).h().a((Map<String, String>) linkedHashMap).b((Map) null).b(String.valueOf(a3)).a((IJRPaytmDataModel) new CJRFlightVerify()).a((com.paytm.network.listener.b) this.m).a((JSONObject) null).l();
            k.a((Object) l2, "CJRCommonNetworkCallBuil…                 .build()");
            l2.a((Object) "NETWORK_TAG_TRAVELLER_ITINERARY");
            l2.a();
            return;
        }
        com.paytm.utility.b.b(context, context.getResources().getString(R.string.no_connection), context.getResources().getString(R.string.no_internet));
    }

    private static String m() {
        k.a((Object) b.a(), "FlightController.getInstance()");
        com.travel.flight.c b2 = b.b();
        k.a((Object) b2, "FlightController.getInstance().flightEventListener");
        String X2 = b2.X();
        k.a((Object) X2, "FlightController.getInst…istener.deferredVerifyURL");
        return X2;
    }

    private void a(String str) {
        k.c(str, "message");
        this.f25568i.postValue(Boolean.TRUE);
    }

    private final void n() {
        this.f25568i.postValue(Boolean.FALSE);
    }

    private void a(f fVar) {
        k.c(fVar, "dialogMessage");
        com.paytm.utility.b.b((Context) getApplication(), fVar.f25584c, fVar.f25585d);
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
        boolean z2 = true;
        if (iJRPaytmDataModel instanceof CJRPGTokenList) {
            b bVar = this.m;
            if (bVar != null) {
                bVar.f25558a = com.travel.flight.flightorder.i.a.a((CJRPGTokenList) iJRPaytmDataModel);
                if (!TextUtils.isEmpty(bVar.f25558a)) {
                    a(bVar.f25558a, this.f25560a);
                    try {
                        k.a((Object) b.a(), "FlightController.getInstance()");
                        com.travel.flight.c b2 = b.b();
                        k.a((Object) b2, "FlightController.getInstance().flightEventListener");
                        String f2 = b2.f();
                        if (!TextUtils.isEmpty(f2)) {
                            Application application = getApplication();
                            k.a((Object) application, "getApplication()");
                            Context context = application;
                            Map linkedHashMap = new LinkedHashMap();
                            linkedHashMap.put("Content-Type", "application/json");
                            String a2 = d.a(context);
                            k.a((Object) a2, "CJRNetUtility.getSSOToken(context)");
                            linkedHashMap.put(AppConstants.SSO_TOKEN, a2);
                            CJRFlightClientLoginPayload instance = CJRFlightClientLoginPayload.getInstance();
                            k.a((Object) instance, "objClientLoginPayload");
                            CJRFlightDetails cJRFlightDetails = this.f25560a;
                            if (cJRFlightDetails == null) {
                                k.a();
                            }
                            CJRFlightDetails.JourneyDetails journeyDetails = cJRFlightDetails.getJourneyDetails();
                            k.a((Object) journeyDetails, "mFlightDetails!!.journeyDetails");
                            instance.setRequestid(journeyDetails.getRequestId());
                            instance.setUser_id(com.paytm.utility.b.n(context));
                            JSONObject jSONObject = new JSONObject(new com.google.gsonhtcfix.f().a((Object) CJRFlightClientLoginPayload.getInstance()));
                            if (com.paytm.utility.b.c((Context) getApplication())) {
                                com.paytm.network.a l2 = new com.paytm.network.b().a(context).a(a.c.FLIGHT).a(a.C0715a.POST).a(a.b.SILENT).c(z).a(f2).h().a((Map<String, String>) linkedHashMap).b((Map) null).b(jSONObject.toString()).a((IJRPaytmDataModel) null).a((com.paytm.network.listener.b) null).a((JSONObject) null).l();
                                k.a((Object) l2, "networkCall");
                                l2.a(true);
                                l2.a((Object) "NETWORK_TAG_TRAVELLER_ITINERARY");
                                l2.a();
                            }
                            CJRFlightClientLoginPayload.clear();
                        }
                    } catch (Exception unused) {
                    }
                } else {
                    this.j.postValue(Boolean.TRUE);
                }
            }
        } else if (iJRPaytmDataModel instanceof CJRFlightPayment) {
            CJRFlightPayment cJRFlightPayment = (CJRFlightPayment) iJRPaytmDataModel;
            if (cJRFlightPayment.getFlightPriceChannge() != null) {
                a(cJRFlightPayment.getFlightPriceChannge());
            } else if (cJRFlightPayment.getPaymentInfo() != null) {
                CJRRechargePayment paymentInfo = cJRFlightPayment.getPaymentInfo();
                k.a((Object) paymentInfo, "response.paymentInfo");
                CharSequence txnAmount = paymentInfo.getTxnAmount();
                if (!(txnAmount == null || txnAmount.length() == 0)) {
                    z2 = false;
                }
                if (!z2) {
                    CJRRechargePayment paymentInfo2 = cJRFlightPayment.getPaymentInfo();
                    k.a((Object) paymentInfo2, "response.paymentInfo");
                    if (a(paymentInfo2)) {
                        this.f25565f.postValue(iJRPaytmDataModel);
                    } else {
                        this.f25566g.postValue(iJRPaytmDataModel);
                    }
                } else {
                    CJRFlightSearchInput cJRFlightSearchInput = this.f25562c;
                    if (cJRFlightSearchInput != null) {
                        if (cJRFlightSearchInput == null) {
                            k.a();
                        }
                        if (cJRFlightSearchInput.getBookingSegment() == com.travel.flight.flightticket.d.b.Modify) {
                            CJRRechargePayment paymentInfo3 = cJRFlightPayment.getPaymentInfo();
                            k.a((Object) paymentInfo3, "response.paymentInfo");
                            if (a(paymentInfo3)) {
                                this.f25565f.postValue(iJRPaytmDataModel);
                                return;
                            } else {
                                this.f25566g.postValue(iJRPaytmDataModel);
                                return;
                            }
                        }
                    }
                    NetworkCustomError networkCustomError = new NetworkCustomError();
                    networkCustomError.networkResponse = iJRPaytmDataModel.getNetworkResponse();
                    a(200, networkCustomError);
                }
            } else {
                NetworkCustomError networkCustomError2 = new NetworkCustomError();
                networkCustomError2.networkResponse = iJRPaytmDataModel.getNetworkResponse();
                a(200, networkCustomError2);
            }
        } else if (iJRPaytmDataModel instanceof CJRFlightSearchResult) {
            a((CJRFlightSearchResult) iJRPaytmDataModel);
        } else if (iJRPaytmDataModel instanceof CJRFlightVerify) {
            CJRFlightVerify cJRFlightVerify = (CJRFlightVerify) iJRPaytmDataModel;
            if (cJRFlightVerify.getFlightPriceChannge() != null) {
                a(cJRFlightVerify.getFlightPriceChannge());
            } else if (cJRFlightVerify.getPaymentInstruments() == null || TextUtils.isEmpty(cJRFlightVerify.getPaymentInstruments())) {
                NetworkCustomError networkCustomError3 = new NetworkCustomError();
                networkCustomError3.networkResponse = iJRPaytmDataModel.getNetworkResponse();
                a(200, networkCustomError3);
            } else {
                this.f25567h.postValue(iJRPaytmDataModel);
            }
        }
    }

    private static boolean a(CJRRechargePayment cJRRechargePayment) {
        return p.a("1", cJRRechargePayment.isNativeEnabled(), true);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:4|(2:6|(3:8|9|10))(1:11)|12|13|(1:17)|18|(22:27|(2:31|(2:33|(2:35|(5:37|39|(2:73|(1:75)(2:76|(2:78|79)(2:80|(2:82|83)(2:84|(2:86|87)(2:88|(2:90|91)(4:92|(2:94|(2:124|125)(2:98|(2:100|(2:102|(1:106))(3:113|(2:115|(1:121))|(2:123|138)(1:139)))))|126|127))))))|128|(2:130|131)(2:132|(2:134|135)(2:136|140))))))|38|39|41|43|45|47|49|51|53|55|57|59|61|63|65|67|69|71|73|(0)(0))(1:(2:23|24)(2:25|26))) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0057 */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x008d A[Catch:{ NotFoundException | Exception -> 0x0338 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b3 A[Catch:{ NotFoundException | Exception -> 0x0338 }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01b5 A[Catch:{ NotFoundException | Exception -> 0x0338 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01b7 A[Catch:{ NotFoundException | Exception -> 0x0338 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r12, com.paytm.network.model.NetworkCustomError r13) {
        /*
            r11 = this;
            java.lang.String r0 = "cjrNewErrorFormat.status.message"
            java.lang.String r1 = "cjrNewErrorFormat.status"
            r11.n()     // Catch:{ NotFoundException | Exception -> 0x0338 }
            if (r13 == 0) goto L_0x0338
            com.travel.flight.pojo.model.a r2 = new com.travel.flight.pojo.model.a     // Catch:{ NotFoundException | Exception -> 0x0338 }
            r2.<init>()     // Catch:{ NotFoundException | Exception -> 0x0338 }
            com.paytm.network.model.NetworkResponse r3 = r13.networkResponse     // Catch:{ NotFoundException | Exception -> 0x0338 }
            r4 = 0
            if (r3 == 0) goto L_0x0056
            com.google.gsonhtcfix.f r3 = new com.google.gsonhtcfix.f     // Catch:{ NotFoundException | Exception -> 0x0338 }
            r3.<init>()     // Catch:{ NotFoundException | Exception -> 0x0338 }
            com.paytm.network.model.NetworkResponse r5 = r13.networkResponse     // Catch:{ NotFoundException | Exception -> 0x0338 }
            byte[] r5 = r5.data     // Catch:{ NotFoundException | Exception -> 0x0338 }
            java.lang.String r6 = "volleyError.networkResponse.data"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            java.lang.String r6 = new java.lang.String     // Catch:{ NotFoundException | Exception -> 0x0338 }
            java.nio.charset.Charset r7 = kotlin.m.d.f47971a     // Catch:{ NotFoundException | Exception -> 0x0338 }
            r6.<init>(r5, r7)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            java.lang.Class<com.paytm.network.model.CJRIllegalCodeError> r5 = com.paytm.network.model.CJRIllegalCodeError.class
            java.lang.Object r3 = r3.a((java.lang.String) r6, r5)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            com.paytm.network.model.CJRIllegalCodeError r3 = (com.paytm.network.model.CJRIllegalCodeError) r3     // Catch:{ NotFoundException | Exception -> 0x0338 }
            com.paytm.network.model.NetworkResponse r5 = r13.networkResponse     // Catch:{ NotFoundException | Exception -> 0x0338 }
            byte[] r6 = r5.data     // Catch:{ NotFoundException | Exception -> 0x0338 }
            if (r6 == 0) goto L_0x0057
            byte[] r5 = r5.data     // Catch:{ Exception -> 0x0057 }
            java.lang.String r6 = "response.data"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r6 = new java.lang.String     // Catch:{ Exception -> 0x0057 }
            java.nio.charset.Charset r7 = kotlin.m.d.f47971a     // Catch:{ Exception -> 0x0057 }
            r6.<init>(r5, r7)     // Catch:{ Exception -> 0x0057 }
            com.google.gsonhtcfix.f r5 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x0057 }
            r5.<init>()     // Catch:{ Exception -> 0x0057 }
            java.lang.Class r7 = r2.getClass()     // Catch:{ Exception -> 0x0057 }
            java.lang.Object r5 = r5.a((java.lang.String) r6, r7)     // Catch:{ Exception -> 0x0057 }
            com.travel.flight.pojo.model.a r5 = (com.travel.flight.pojo.model.a) r5     // Catch:{ Exception -> 0x0057 }
            r2 = r5
            goto L_0x0057
        L_0x0056:
            r3 = r4
        L_0x0057:
            android.app.Application r5 = r11.getApplication()     // Catch:{ NotFoundException | Exception -> 0x0338 }
            java.lang.String r6 = "getApplication()"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            android.content.Context r5 = (android.content.Context) r5     // Catch:{ NotFoundException | Exception -> 0x0338 }
            java.lang.String r6 = ""
            if (r3 == 0) goto L_0x007b
            java.lang.String r7 = r3.getmInternalErrorCode()     // Catch:{ NotFoundException | Exception -> 0x0338 }
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ NotFoundException | Exception -> 0x0338 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            if (r7 != 0) goto L_0x007b
            java.lang.String r6 = r3.getmInternalErrorCode()     // Catch:{ NotFoundException | Exception -> 0x0338 }
            java.lang.String r3 = "errorStatus.getmInternalErrorCode()"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r3)     // Catch:{ NotFoundException | Exception -> 0x0338 }
        L_0x007b:
            java.lang.String r3 = r13.getAlertTitle()     // Catch:{ NotFoundException | Exception -> 0x0338 }
            java.lang.String r7 = r13.getAlertMessage()     // Catch:{ NotFoundException | Exception -> 0x0338 }
            com.paytm.network.model.NetworkCustomError$ErrorType r8 = r13.mErrorType     // Catch:{ NotFoundException | Exception -> 0x0338 }
            if (r8 == 0) goto L_0x00b3
            com.paytm.network.model.NetworkCustomError$ErrorType r8 = r13.mErrorType     // Catch:{ NotFoundException | Exception -> 0x0338 }
            com.paytm.network.model.NetworkCustomError$ErrorType r9 = com.paytm.network.model.NetworkCustomError.ErrorType.InvalidArgumentError     // Catch:{ NotFoundException | Exception -> 0x0338 }
            if (r8 != r9) goto L_0x00b3
            if (r5 != 0) goto L_0x00a1
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ NotFoundException | Exception -> 0x0338 }
            r12.<init>()     // Catch:{ NotFoundException | Exception -> 0x0338 }
            java.lang.String r13 = r13.getUrl()     // Catch:{ NotFoundException | Exception -> 0x0338 }
            r12.append(r13)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            java.lang.String r13 = "/1"
            r12.append(r13)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            return
        L_0x00a1:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ NotFoundException | Exception -> 0x0338 }
            r12.<init>()     // Catch:{ NotFoundException | Exception -> 0x0338 }
            java.lang.String r13 = r13.getUrl()     // Catch:{ NotFoundException | Exception -> 0x0338 }
            r12.append(r13)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            java.lang.String r13 = "/2"
            r12.append(r13)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            return
        L_0x00b3:
            r8 = 0
            r9 = 1
            if (r2 == 0) goto L_0x0124
            com.travel.flight.pojo.model.b r10 = r2.getStatus()     // Catch:{ NotFoundException | Exception -> 0x0338 }
            if (r10 == 0) goto L_0x0124
            com.travel.flight.pojo.model.b r10 = r2.getStatus()     // Catch:{ NotFoundException | Exception -> 0x0338 }
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r1)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            com.travel.flight.pojo.model.c r10 = r10.getMessage()     // Catch:{ NotFoundException | Exception -> 0x0338 }
            if (r10 == 0) goto L_0x0124
            com.travel.flight.pojo.model.b r10 = r2.getStatus()     // Catch:{ NotFoundException | Exception -> 0x0338 }
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r1)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            com.travel.flight.pojo.model.c r10 = r10.getMessage()     // Catch:{ NotFoundException | Exception -> 0x0338 }
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r0)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            java.lang.String r10 = r10.a()     // Catch:{ NotFoundException | Exception -> 0x0338 }
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ NotFoundException | Exception -> 0x0338 }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            if (r10 != 0) goto L_0x0124
            com.travel.flight.pojo.model.b r10 = r2.getStatus()     // Catch:{ NotFoundException | Exception -> 0x0338 }
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r1)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            com.travel.flight.pojo.model.c r10 = r10.getMessage()     // Catch:{ NotFoundException | Exception -> 0x0338 }
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r0)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            java.lang.String r10 = r10.b()     // Catch:{ NotFoundException | Exception -> 0x0338 }
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ NotFoundException | Exception -> 0x0338 }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            if (r10 != 0) goto L_0x0124
            com.travel.flight.pojo.model.b r3 = r2.getStatus()     // Catch:{ NotFoundException | Exception -> 0x0338 }
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r1)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            com.travel.flight.pojo.model.c r3 = r3.getMessage()     // Catch:{ NotFoundException | Exception -> 0x0338 }
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r0)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            java.lang.String r3 = r3.a()     // Catch:{ NotFoundException | Exception -> 0x0338 }
            com.travel.flight.pojo.model.b r2 = r2.getStatus()     // Catch:{ NotFoundException | Exception -> 0x0338 }
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r1)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            com.travel.flight.pojo.model.c r1 = r2.getMessage()     // Catch:{ NotFoundException | Exception -> 0x0338 }
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r0)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            java.lang.String r7 = r1.b()     // Catch:{ NotFoundException | Exception -> 0x0338 }
            r0 = 1
            goto L_0x0125
        L_0x0124:
            r0 = 0
        L_0x0125:
            java.lang.String r1 = V     // Catch:{ NotFoundException | Exception -> 0x0338 }
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r6, (boolean) r9)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            if (r1 != 0) goto L_0x02f4
            java.lang.String r1 = B     // Catch:{ NotFoundException | Exception -> 0x0338 }
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r6, (boolean) r9)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            if (r1 != 0) goto L_0x02f4
            java.lang.String r1 = C     // Catch:{ NotFoundException | Exception -> 0x0338 }
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r6, (boolean) r9)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            if (r1 != 0) goto L_0x02f4
            java.lang.String r1 = D     // Catch:{ NotFoundException | Exception -> 0x0338 }
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r6, (boolean) r9)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            if (r1 != 0) goto L_0x02f4
            java.lang.String r1 = E     // Catch:{ NotFoundException | Exception -> 0x0338 }
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r6, (boolean) r9)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            if (r1 != 0) goto L_0x02f4
            java.lang.String r1 = F     // Catch:{ NotFoundException | Exception -> 0x0338 }
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r6, (boolean) r9)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            if (r1 != 0) goto L_0x02f4
            java.lang.String r1 = G     // Catch:{ NotFoundException | Exception -> 0x0338 }
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r6, (boolean) r9)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            if (r1 != 0) goto L_0x02f4
            java.lang.String r1 = H     // Catch:{ NotFoundException | Exception -> 0x0338 }
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r6, (boolean) r9)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            if (r1 != 0) goto L_0x02f4
            java.lang.String r1 = I     // Catch:{ NotFoundException | Exception -> 0x0338 }
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r6, (boolean) r9)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            if (r1 != 0) goto L_0x02f4
            java.lang.String r1 = J     // Catch:{ NotFoundException | Exception -> 0x0338 }
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r6, (boolean) r9)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            if (r1 != 0) goto L_0x02f4
            java.lang.String r1 = K     // Catch:{ NotFoundException | Exception -> 0x0338 }
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r6, (boolean) r9)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            if (r1 != 0) goto L_0x02f4
            java.lang.String r1 = L     // Catch:{ NotFoundException | Exception -> 0x0338 }
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r6, (boolean) r9)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            if (r1 != 0) goto L_0x02f4
            java.lang.String r1 = M     // Catch:{ NotFoundException | Exception -> 0x0338 }
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r6, (boolean) r9)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            if (r1 != 0) goto L_0x02f4
            java.lang.String r1 = N     // Catch:{ NotFoundException | Exception -> 0x0338 }
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r6, (boolean) r9)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            if (r1 != 0) goto L_0x02f4
            java.lang.String r1 = O     // Catch:{ NotFoundException | Exception -> 0x0338 }
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r6, (boolean) r9)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            if (r1 != 0) goto L_0x02f4
            java.lang.String r1 = P     // Catch:{ NotFoundException | Exception -> 0x0338 }
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r6, (boolean) r9)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            if (r1 != 0) goto L_0x02f4
            java.lang.String r1 = Q     // Catch:{ NotFoundException | Exception -> 0x0338 }
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r6, (boolean) r9)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            if (r1 != 0) goto L_0x02f4
            java.lang.String r1 = X     // Catch:{ NotFoundException | Exception -> 0x0338 }
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r6, (boolean) r9)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            if (r1 == 0) goto L_0x01b7
            goto L_0x02f4
        L_0x01b7:
            java.lang.String r1 = R     // Catch:{ NotFoundException | Exception -> 0x0338 }
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r6, (boolean) r9)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            if (r1 == 0) goto L_0x01ca
            androidx.lifecycle.y<com.travel.flight.utils.f> r12 = r11.f25563d     // Catch:{ NotFoundException | Exception -> 0x0338 }
            com.travel.flight.utils.f r13 = new com.travel.flight.utils.f     // Catch:{ NotFoundException | Exception -> 0x0338 }
            r13.<init>(r3, r7, r4, r4)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            r12.postValue(r13)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            return
        L_0x01ca:
            java.lang.String r1 = S     // Catch:{ NotFoundException | Exception -> 0x0338 }
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r6, (boolean) r9)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            if (r1 == 0) goto L_0x01dd
            androidx.lifecycle.y<com.travel.flight.utils.f> r12 = r11.f25563d     // Catch:{ NotFoundException | Exception -> 0x0338 }
            com.travel.flight.utils.f r13 = new com.travel.flight.utils.f     // Catch:{ NotFoundException | Exception -> 0x0338 }
            r13.<init>(r3, r7, r4, r4)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            r12.postValue(r13)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            return
        L_0x01dd:
            java.lang.String r1 = T     // Catch:{ NotFoundException | Exception -> 0x0338 }
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r6, (boolean) r9)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            if (r1 == 0) goto L_0x0204
            androidx.lifecycle.y<com.travel.flight.utils.f> r12 = r11.k     // Catch:{ NotFoundException | Exception -> 0x0338 }
            com.travel.flight.utils.f r13 = new com.travel.flight.utils.f     // Catch:{ NotFoundException | Exception -> 0x0338 }
            android.content.res.Resources r0 = r5.getResources()     // Catch:{ NotFoundException | Exception -> 0x0338 }
            int r1 = com.travel.flight.R.string.select_another_seats     // Catch:{ NotFoundException | Exception -> 0x0338 }
            java.lang.String r0 = r0.getString(r1)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            android.content.res.Resources r1 = r5.getResources()     // Catch:{ NotFoundException | Exception -> 0x0338 }
            int r2 = com.travel.flight.R.string.proceed_to_pay_without_seat     // Catch:{ NotFoundException | Exception -> 0x0338 }
            java.lang.String r1 = r1.getString(r2)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            r13.<init>(r3, r7, r0, r1)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            r12.postValue(r13)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            return
        L_0x0204:
            java.lang.String r1 = U     // Catch:{ NotFoundException | Exception -> 0x0338 }
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r6, (boolean) r9)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            if (r1 == 0) goto L_0x022b
            androidx.lifecycle.y<com.travel.flight.utils.f> r12 = r11.l     // Catch:{ NotFoundException | Exception -> 0x0338 }
            com.travel.flight.utils.f r13 = new com.travel.flight.utils.f     // Catch:{ NotFoundException | Exception -> 0x0338 }
            android.content.res.Resources r0 = r5.getResources()     // Catch:{ NotFoundException | Exception -> 0x0338 }
            int r1 = com.travel.flight.R.string.add_last_name     // Catch:{ NotFoundException | Exception -> 0x0338 }
            java.lang.String r0 = r0.getString(r1)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            android.content.res.Resources r1 = r5.getResources()     // Catch:{ NotFoundException | Exception -> 0x0338 }
            int r2 = com.travel.flight.R.string.proceed_to_pay     // Catch:{ NotFoundException | Exception -> 0x0338 }
            java.lang.String r1 = r1.getString(r2)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            r13.<init>(r3, r7, r0, r1)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            r12.postValue(r13)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            return
        L_0x022b:
            r1 = 400(0x190, float:5.6E-43)
            if (r12 == r1) goto L_0x02e9
            r1 = 401(0x191, float:5.62E-43)
            if (r12 == r1) goto L_0x02e1
            r1 = 410(0x19a, float:5.75E-43)
            if (r12 == r1) goto L_0x02e1
            r1 = 417(0x1a1, float:5.84E-43)
            if (r12 == r1) goto L_0x02e9
            r1 = 500(0x1f4, float:7.0E-43)
            if (r12 == r1) goto L_0x0279
            r13 = 517(0x205, float:7.24E-43)
            if (r12 == r13) goto L_0x02e9
            r13 = 522(0x20a, float:7.31E-43)
            if (r12 == r13) goto L_0x02e9
            switch(r12) {
                case 502: goto L_0x025f;
                case 503: goto L_0x025f;
                case 504: goto L_0x025f;
                default: goto L_0x024a;
            }     // Catch:{ NotFoundException | Exception -> 0x0338 }
        L_0x024a:
            androidx.lifecycle.y<com.travel.flight.utils.f> r12 = r11.f25563d     // Catch:{ NotFoundException | Exception -> 0x0338 }
            com.travel.flight.utils.f r13 = new com.travel.flight.utils.f     // Catch:{ NotFoundException | Exception -> 0x0338 }
            android.content.res.Resources r0 = r5.getResources()     // Catch:{ NotFoundException | Exception -> 0x0338 }
            int r1 = com.travel.flight.R.string.ok     // Catch:{ NotFoundException | Exception -> 0x0338 }
            java.lang.String r0 = r0.getString(r1)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            r13.<init>(r3, r7, r0, r4)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            r12.postValue(r13)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            return
        L_0x025f:
            if (r0 == 0) goto L_0x0264
            com.paytm.utility.b.b((android.content.Context) r5, (java.lang.String) r3, (java.lang.String) r7)     // Catch:{ NotFoundException | Exception -> 0x0338 }
        L_0x0264:
            androidx.lifecycle.y<com.travel.flight.utils.f> r12 = r11.f25563d     // Catch:{ NotFoundException | Exception -> 0x0338 }
            com.travel.flight.utils.f r13 = new com.travel.flight.utils.f     // Catch:{ NotFoundException | Exception -> 0x0338 }
            android.content.res.Resources r0 = r5.getResources()     // Catch:{ NotFoundException | Exception -> 0x0338 }
            int r1 = com.travel.flight.R.string.ok     // Catch:{ NotFoundException | Exception -> 0x0338 }
            java.lang.String r0 = r0.getString(r1)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            r13.<init>(r3, r7, r0, r4)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            r12.postValue(r13)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            return
        L_0x0279:
            java.lang.String r0 = r13.getUrl()     // Catch:{ NotFoundException | Exception -> 0x0338 }
            if (r0 == 0) goto L_0x02d4
            java.lang.String r13 = r13.getUrl()     // Catch:{ NotFoundException | Exception -> 0x0338 }
            java.lang.String r0 = "volleyError.getUrl()"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r0)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13     // Catch:{ NotFoundException | Exception -> 0x0338 }
            java.lang.String r0 = "flights/v1/cartcheckout"
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ NotFoundException | Exception -> 0x0338 }
            boolean r13 = kotlin.m.p.a((java.lang.CharSequence) r13, (java.lang.CharSequence) r0, false)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            if (r13 == 0) goto L_0x02d4
            java.lang.String r13 = java.lang.String.valueOf(r12)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13     // Catch:{ NotFoundException | Exception -> 0x0338 }
            boolean r13 = android.text.TextUtils.isEmpty(r13)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            if (r13 != 0) goto L_0x02d4
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            android.content.res.Resources r13 = r5.getResources()     // Catch:{ NotFoundException | Exception -> 0x0338 }
            int r0 = com.travel.flight.R.string.internal_error_code     // Catch:{ NotFoundException | Exception -> 0x0338 }
            java.lang.String r13 = r13.getString(r0)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            boolean r12 = kotlin.m.p.a((java.lang.String) r12, (java.lang.String) r13, (boolean) r9)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            if (r12 == 0) goto L_0x02d4
            androidx.lifecycle.y<com.travel.flight.utils.f> r12 = r11.l     // Catch:{ NotFoundException | Exception -> 0x0338 }
            com.travel.flight.utils.f r13 = new com.travel.flight.utils.f     // Catch:{ NotFoundException | Exception -> 0x0338 }
            android.content.res.Resources r0 = r5.getResources()     // Catch:{ NotFoundException | Exception -> 0x0338 }
            int r1 = com.travel.flight.R.string.add_last_name     // Catch:{ NotFoundException | Exception -> 0x0338 }
            java.lang.String r0 = r0.getString(r1)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            android.content.res.Resources r1 = r5.getResources()     // Catch:{ NotFoundException | Exception -> 0x0338 }
            int r2 = com.travel.flight.R.string.proceed_to_pay     // Catch:{ NotFoundException | Exception -> 0x0338 }
            java.lang.String r1 = r1.getString(r2)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            r13.<init>(r3, r7, r0, r1)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            r12.postValue(r13)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            r8 = 1
        L_0x02d4:
            if (r8 != 0) goto L_0x02e0
            com.travel.flight.utils.f r12 = new com.travel.flight.utils.f     // Catch:{ NotFoundException | Exception -> 0x0338 }
            r12.<init>(r3, r7, r4, r4)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            androidx.lifecycle.y<com.travel.flight.utils.f> r13 = r11.f25563d     // Catch:{ NotFoundException | Exception -> 0x0338 }
            r13.postValue(r12)     // Catch:{ NotFoundException | Exception -> 0x0338 }
        L_0x02e0:
            return
        L_0x02e1:
            androidx.lifecycle.y<java.lang.Boolean> r12 = r11.j     // Catch:{ NotFoundException | Exception -> 0x0338 }
            java.lang.Boolean r13 = java.lang.Boolean.TRUE     // Catch:{ NotFoundException | Exception -> 0x0338 }
            r12.postValue(r13)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            return
        L_0x02e9:
            androidx.lifecycle.y<com.travel.flight.utils.f> r12 = r11.f25563d     // Catch:{ NotFoundException | Exception -> 0x0338 }
            com.travel.flight.utils.f r13 = new com.travel.flight.utils.f     // Catch:{ NotFoundException | Exception -> 0x0338 }
            r13.<init>(r3, r7, r4, r4)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            r12.postValue(r13)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            return
        L_0x02f4:
            java.lang.String r12 = F     // Catch:{ NotFoundException | Exception -> 0x0338 }
            boolean r12 = kotlin.m.p.a((java.lang.String) r12, (java.lang.String) r6, (boolean) r9)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            if (r12 == 0) goto L_0x0311
            androidx.lifecycle.y<com.travel.flight.utils.f> r12 = r11.f25563d     // Catch:{ NotFoundException | Exception -> 0x0338 }
            com.travel.flight.utils.f r13 = new com.travel.flight.utils.f     // Catch:{ NotFoundException | Exception -> 0x0338 }
            android.content.res.Resources r0 = r5.getResources()     // Catch:{ NotFoundException | Exception -> 0x0338 }
            int r1 = com.travel.flight.R.string.select_another_flight     // Catch:{ NotFoundException | Exception -> 0x0338 }
            java.lang.String r0 = r0.getString(r1)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            r13.<init>(r3, r7, r0, r4)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            r12.postValue(r13)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            return
        L_0x0311:
            java.lang.String r12 = X     // Catch:{ NotFoundException | Exception -> 0x0338 }
            boolean r12 = kotlin.m.p.a((java.lang.String) r12, (java.lang.String) r6, (boolean) r9)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            if (r12 == 0) goto L_0x0324
            androidx.lifecycle.y<com.travel.flight.utils.f> r12 = r11.f25563d     // Catch:{ NotFoundException | Exception -> 0x0338 }
            com.travel.flight.utils.f r13 = new com.travel.flight.utils.f     // Catch:{ NotFoundException | Exception -> 0x0338 }
            r13.<init>(r3, r7, r4, r4)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            r12.postValue(r13)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            return
        L_0x0324:
            androidx.lifecycle.y<com.travel.flight.utils.f> r12 = r11.f25563d     // Catch:{ NotFoundException | Exception -> 0x0338 }
            com.travel.flight.utils.f r13 = new com.travel.flight.utils.f     // Catch:{ NotFoundException | Exception -> 0x0338 }
            android.content.res.Resources r0 = r5.getResources()     // Catch:{ NotFoundException | Exception -> 0x0338 }
            int r1 = com.travel.flight.R.string.flight_view_updated_search_results     // Catch:{ NotFoundException | Exception -> 0x0338 }
            java.lang.String r0 = r0.getString(r1)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            r13.<init>(r3, r7, r0, r4)     // Catch:{ NotFoundException | Exception -> 0x0338 }
            r12.postValue(r13)     // Catch:{ NotFoundException | Exception -> 0x0338 }
        L_0x0338:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.tripsummary.c.a(int, com.paytm.network.model.NetworkCustomError):void");
    }

    public static double a(double d2, CJRFlightDetails cJRFlightDetails) {
        float f2;
        k.c(cJRFlightDetails, "mFlightDetails");
        if (cJRFlightDetails.getmConvenienceFee() != null) {
            CJRConvenienceFee cJRConvenienceFee = cJRFlightDetails.getmConvenienceFee();
            k.a((Object) cJRConvenienceFee, "mFlightDetails.getmConvenienceFee()");
            Double mtotalConFee = cJRConvenienceFee.getMtotalConFee();
            if (mtotalConFee == null) {
                k.a();
            }
            f2 = (float) ((int) mtotalConFee.doubleValue());
        } else {
            f2 = 0.0f;
        }
        double d3 = d2 + ((double) f2);
        if (cJRFlightDetails.isInsuranceApplied() && cJRFlightDetails.getInsuranceData() != null) {
            CJRInsuranceModel insuranceData = cJRFlightDetails.getInsuranceData();
            k.a((Object) insuranceData, "mFlightDetails.insuranceData");
            if (insuranceData.getBody() != null) {
                CJRInsuranceModel insuranceData2 = cJRFlightDetails.getInsuranceData();
                k.a((Object) insuranceData2, "mFlightDetails.insuranceData");
                CJRInsuranceBody body = insuranceData2.getBody();
                k.a((Object) body, "mFlightDetails.insuranceData.body");
                if (body.getInsuranceDetail() != null) {
                    CJRInsuranceModel insuranceData3 = cJRFlightDetails.getInsuranceData();
                    k.a((Object) insuranceData3, "mFlightDetails.insuranceData");
                    CJRInsuranceBody body2 = insuranceData3.getBody();
                    k.a((Object) body2, "mFlightDetails.insuranceData.body");
                    if (body2.getInsuranceDetail().size() > 0) {
                        CJRInsuranceModel insuranceData4 = cJRFlightDetails.getInsuranceData();
                        k.a((Object) insuranceData4, "mFlightDetails.insuranceData");
                        CJRInsuranceBody body3 = insuranceData4.getBody();
                        k.a((Object) body3, "mFlightDetails.insuranceData.body");
                        if (body3.getInsuranceDetail().get(0) != null) {
                            CJRInsuranceModel insuranceData5 = cJRFlightDetails.getInsuranceData();
                            k.a((Object) insuranceData5, "mFlightDetails.insuranceData");
                            CJRInsuranceBody body4 = insuranceData5.getBody();
                            k.a((Object) body4, "mFlightDetails.insuranceData.body");
                            CJRInsuranceItem cJRInsuranceItem = body4.getInsuranceDetail().get(0);
                            k.a((Object) cJRInsuranceItem, "mFlightDetails.insurance…a.body.insuranceDetail[0]");
                            double totalPremium = cJRInsuranceItem.getTotalPremium();
                            CJRInsuranceModel insuranceData6 = cJRFlightDetails.getInsuranceData();
                            k.a((Object) insuranceData6, "mFlightDetails.insuranceData");
                            CJRInsuranceBody body5 = insuranceData6.getBody();
                            k.a((Object) body5, "mFlightDetails.insuranceData.body");
                            CJRInsuranceItem cJRInsuranceItem2 = body5.getInsuranceDetail().get(0);
                            k.a((Object) cJRInsuranceItem2, "mFlightDetails.insurance…a.body.insuranceDetail[0]");
                            if (cJRInsuranceItem2.getUserInputInfo() != null) {
                                CJRInsuranceModel insuranceData7 = cJRFlightDetails.getInsuranceData();
                                k.a((Object) insuranceData7, "mFlightDetails.insuranceData");
                                CJRInsuranceBody body6 = insuranceData7.getBody();
                                k.a((Object) body6, "mFlightDetails.insuranceData.body");
                                CJRInsuranceItem cJRInsuranceItem3 = body6.getInsuranceDetail().get(0);
                                k.a((Object) cJRInsuranceItem3, "mFlightDetails.insurance…a.body.insuranceDetail[0]");
                                if (cJRInsuranceItem3.isOne_way_international()) {
                                    CJRInsuranceModel insuranceData8 = cJRFlightDetails.getInsuranceData();
                                    k.a((Object) insuranceData8, "mFlightDetails.insuranceData");
                                    CJRInsuranceBody body7 = insuranceData8.getBody();
                                    k.a((Object) body7, "mFlightDetails.insuranceData.body");
                                    CJRInsuranceItem cJRInsuranceItem4 = body7.getInsuranceDetail().get(0);
                                    k.a((Object) cJRInsuranceItem4, "mFlightDetails.insurance…a.body.insuranceDetail[0]");
                                    int selectedDays = cJRInsuranceItem4.getUserInputInfo().getSelectedDays();
                                    if (selectedDays > 0) {
                                        totalPremium *= (double) selectedDays;
                                    }
                                }
                            }
                            d3 += totalPremium;
                        }
                    }
                }
            }
        }
        if (cJRFlightDetails.isInsuranceCancelProtectApplied() && cJRFlightDetails.getInsuranceData() != null) {
            CJRInsuranceModel insuranceData9 = cJRFlightDetails.getInsuranceData();
            k.a((Object) insuranceData9, "mFlightDetails.insuranceData");
            if (insuranceData9.getBody() != null) {
                CJRInsuranceModel insuranceData10 = cJRFlightDetails.getInsuranceData();
                k.a((Object) insuranceData10, "mFlightDetails.insuranceData");
                CJRInsuranceBody body8 = insuranceData10.getBody();
                k.a((Object) body8, "mFlightDetails.insuranceData.body");
                if (body8.getCancelProtectInsuranceDetail() != null) {
                    CJRInsuranceModel insuranceData11 = cJRFlightDetails.getInsuranceData();
                    k.a((Object) insuranceData11, "mFlightDetails.insuranceData");
                    CJRInsuranceBody body9 = insuranceData11.getBody();
                    k.a((Object) body9, "mFlightDetails.insuranceData.body");
                    if (body9.getCancelProtectInsuranceDetail().size() > 0) {
                        CJRInsuranceModel insuranceData12 = cJRFlightDetails.getInsuranceData();
                        k.a((Object) insuranceData12, "mFlightDetails.insuranceData");
                        CJRInsuranceBody body10 = insuranceData12.getBody();
                        k.a((Object) body10, "mFlightDetails.insuranceData.body");
                        if (body10.getCancelProtectInsuranceDetail().get(0) != null) {
                            CJRInsuranceModel insuranceData13 = cJRFlightDetails.getInsuranceData();
                            k.a((Object) insuranceData13, "mFlightDetails.insuranceData");
                            CJRInsuranceBody body11 = insuranceData13.getBody();
                            k.a((Object) body11, "mFlightDetails.insuranceData.body");
                            CJRCancelProtectInsuranceItem cJRCancelProtectInsuranceItem = body11.getCancelProtectInsuranceDetail().get(0);
                            k.a((Object) cJRCancelProtectInsuranceItem, "mFlightDetails.insurance…ProtectInsuranceDetail[0]");
                            d3 += cJRCancelProtectInsuranceItem.getTotalPremium();
                        }
                    }
                }
            }
        }
        CJRFlightDetails.JourneyDetails journeyDetails = cJRFlightDetails.getJourneyDetails();
        k.a((Object) journeyDetails, "mFlightDetails.journeyDetails");
        double a2 = a.a(journeyDetails.getTravellerSeatTransitionObj());
        Double d4 = CJRFlightAncillaryReqBody.getInstance().getmSelectedBaggageTotalAmount();
        if (d4 == null) {
            k.a();
        }
        double doubleValue = d4.doubleValue();
        Double d5 = CJRFlightAncillaryReqBody.getInstance().getmSelectedMealsTotalAmount();
        if (d5 == null) {
            k.a();
        }
        double doubleValue2 = doubleValue + d5.doubleValue();
        double d6 = 0.0d;
        if (cJRFlightDetails.getBundleList() != null && cJRFlightDetails.getBundleList().size() > 0 && cJRFlightDetails.getBundleList() != null && cJRFlightDetails.getBundleList().size() > 0) {
            try {
                double d7 = 0.0d;
                for (FlightSellingBundleResponseData component9 : cJRFlightDetails.getBundleList()) {
                    d7 += component9.component9();
                }
                d6 = d7;
            } catch (Exception unused) {
            }
        }
        return d3 + a2 + doubleValue2 + d6;
    }
}
