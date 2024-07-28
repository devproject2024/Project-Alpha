package com.travel.train.a.a;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.train.j.g;
import com.travel.train.j.o;
import com.travel.train.model.metro.CJRMetroListModesApiModel;
import com.travel.train.model.searchResult.Body;
import com.travel.train.model.searchResult.CJRSearchByTrainNumberModel;
import com.travel.train.model.searchResult.SearchResultMetaData;
import com.travel.train.model.searchResult.Status;
import com.travel.train.model.trainticket.CJRNearByStationResult;
import com.travel.train.model.trainticket.CJRTrainBooking;
import com.travel.train.model.trainticket.CJRTrainCity;
import com.travel.train.model.trainticket.CJRTrainDetails;
import com.travel.train.model.trainticket.CJRTrainHolidayList;
import com.travel.train.model.trainticket.CJRTrainLSSearchResult;
import com.travel.train.model.trainticket.CJRTrainMsgResponse;
import com.travel.train.model.trainticket.CJRTrainPNRStatus;
import com.travel.train.model.trainticket.CJRTrainQuickBookFavourites;
import com.travel.train.model.trainticket.CJRTrainRecentBooking;
import com.travel.train.model.trainticket.CJRTrainSearchResults;
import com.travel.train.model.trainticket.CJRTrainSearchResultsBody;
import com.travel.train.model.trainticket.CJRTrainSearchResultsMeta;
import com.travel.train.model.trainticket.CJRTrainStatus;
import com.travel.train.model.trainticket.CJRTrainVerifyCheckout;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import org.json.JSONObject;

public final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f25800a = "CJRTrainCommonRemoteDataSource";

    /* renamed from: b  reason: collision with root package name */
    private com.paytm.network.a f25801b;

    /* renamed from: c  reason: collision with root package name */
    private Context f25802c;

    public a(Context context) {
        k.c(context, "mContext");
        this.f25802c = context;
    }

    private static String a(String str, HashMap<String, String> hashMap) {
        StringBuilder sb = new StringBuilder(str);
        for (Map.Entry entry : hashMap.entrySet()) {
            String str2 = (String) entry.getKey();
            String str3 = (String) entry.getValue();
            if (sb.length() > 1) {
                String sb2 = sb.toString();
                k.a((Object) sb2, "paramsURL.toString()");
                if (p.a((CharSequence) sb2, (CharSequence) "?", false)) {
                    sb.append(AppConstants.AND_SIGN);
                    sb.append(str2);
                    sb.append("=");
                    sb.append(str3);
                    k.a((Object) sb, "paramsURL.append(\"&\").ap…append(\"=\").append(value)");
                }
            }
            sb.append("?");
            sb.append(str2);
            sb.append("=");
            sb.append(str3);
            k.a((Object) sb, "paramsURL.append(\"?\").ap…append(\"=\").append(value)");
        }
        String sb3 = sb.toString();
        k.a((Object) sb3, "paramsURL.toString()");
        return sb3;
    }

    public final com.paytm.network.a a() {
        return this.f25801b;
    }

    private final void a(com.paytm.network.listener.b bVar, com.paytm.network.listener.b bVar2, IJRPaytmDataModel iJRPaytmDataModel, String str, HashMap<String, String> hashMap) {
        try {
            com.paytm.network.a l = new com.paytm.network.b().a(this.f25802c).a(a.c.TRAIN).a(a.b.SILENT).c(g.f27558h).a(a.C0715a.GET).a(str).a((Map<String, String>) hashMap).a(iJRPaytmDataModel).a((com.paytm.network.listener.b) new C0485a(bVar, bVar2)).l();
            this.f25801b = l;
            l.b(false);
            if (com.paytm.utility.b.c(this.f25802c)) {
                l.a();
                return;
            }
            NetworkCustomError networkCustomError = new NetworkCustomError();
            networkCustomError.setErrorType(NetworkCustomError.ErrorType.NetworkError);
            bVar2.handleErrorCode(-1, (IJRPaytmDataModel) null, networkCustomError);
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
    }

    /* renamed from: com.travel.train.a.a.a$a  reason: collision with other inner class name */
    public static final class C0485a implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.paytm.network.listener.b f25803a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.paytm.network.listener.b f25804b;

        C0485a(com.paytm.network.listener.b bVar, com.paytm.network.listener.b bVar2) {
            this.f25803a = bVar;
            this.f25804b = bVar2;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            this.f25803a.onApiSuccess(iJRPaytmDataModel);
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            k.c(networkCustomError, "networkCustomError");
            this.f25804b.handleErrorCode(i2, iJRPaytmDataModel, networkCustomError);
        }
    }

    private final void a(com.paytm.network.listener.b bVar, com.paytm.network.listener.b bVar2, IJRPaytmDataModel iJRPaytmDataModel, String str, HashMap<String, String> hashMap, JSONObject jSONObject) {
        try {
            com.paytm.network.a l = new com.paytm.network.b().a(this.f25802c).a(a.c.TRAIN).a(a.b.SILENT).c(g.j).a(a.C0715a.POST).a(str).a((Map<String, String>) hashMap).b(jSONObject != null ? jSONObject.toString() : null).a(iJRPaytmDataModel).a(1).a((com.paytm.network.listener.b) new b(bVar, bVar2)).l();
            this.f25801b = l;
            l.b(false);
            if (com.paytm.utility.b.c(this.f25802c)) {
                l.a();
                return;
            }
            NetworkCustomError networkCustomError = new NetworkCustomError();
            networkCustomError.setErrorType(NetworkCustomError.ErrorType.NetworkError);
            bVar2.handleErrorCode(-1, (IJRPaytmDataModel) null, networkCustomError);
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
    }

    public static final class b implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.paytm.network.listener.b f25805a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.paytm.network.listener.b f25806b;

        b(com.paytm.network.listener.b bVar, com.paytm.network.listener.b bVar2) {
            this.f25805a = bVar;
            this.f25806b = bVar2;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            this.f25805a.onApiSuccess(iJRPaytmDataModel);
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            k.c(networkCustomError, "networkCustomError");
            this.f25806b.handleErrorCode(i2, iJRPaytmDataModel, networkCustomError);
        }
    }

    public final void a(com.paytm.network.listener.b bVar, com.paytm.network.listener.b bVar2, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, JSONObject jSONObject) {
        k.c(bVar, "onApiSuccess");
        k.c(bVar2, "handleErrorCode");
        k.c(hashMap, "headers");
        k.c(hashMap2, "urlParams");
        if (this.f25802c != null) {
            k.a((Object) com.travel.train.b.a(), "TrainController.getInstance()");
            String a2 = com.travel.train.b.b().a("trainDetailsURL");
            if (!TextUtils.isEmpty(a2) && URLUtil.isValidUrl(a2)) {
                k.a((Object) a2, "URL");
                String b2 = o.b(this.f25802c, com.paytm.utility.b.s(this.f25802c, a(a2, hashMap2)));
                k.a((Object) b2, "URL");
                a(bVar, bVar2, new CJRTrainBooking(), b2, hashMap, jSONObject);
            }
        }
    }

    public final void b(com.paytm.network.listener.b bVar, com.paytm.network.listener.b bVar2, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, JSONObject jSONObject) {
        k.c(bVar, "onApiSuccess");
        k.c(bVar2, "handleErrorCode");
        k.c(hashMap, "headers");
        k.c(hashMap2, "urlParams");
        if (this.f25802c != null) {
            k.a((Object) com.travel.train.b.a(), "TrainController.getInstance()");
            String a2 = com.travel.train.b.b().a("TrainVerifyUrl");
            if (!TextUtils.isEmpty(a2) && URLUtil.isValidUrl(a2)) {
                k.a((Object) a2, "URL");
                String b2 = o.b(this.f25802c, com.paytm.utility.b.s(this.f25802c, a(a2, hashMap2)));
                k.a((Object) b2, "URL");
                a(bVar, bVar2, new CJRTrainVerifyCheckout(), b2, hashMap, jSONObject);
            }
        }
    }

    public final void c(com.paytm.network.listener.b bVar, com.paytm.network.listener.b bVar2, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, JSONObject jSONObject) {
        k.c(bVar, "onApiSuccess");
        k.c(bVar2, "handleErrorCode");
        k.c(hashMap, "headers");
        k.c(hashMap2, "urlParams");
        if (this.f25802c != null && jSONObject != null) {
            k.a((Object) com.travel.train.b.a(), "TrainController.getInstance()");
            String a2 = com.travel.train.b.b().a("TrainV2CheckoutUrl");
            if (!TextUtils.isEmpty(a2) && URLUtil.isValidUrl(a2)) {
                k.a((Object) a2, "URL");
                String b2 = o.b(this.f25802c, com.paytm.utility.b.s(this.f25802c, a(a2, hashMap2)));
                k.a((Object) com.travel.train.b.a(), "TrainController.getInstance()");
                String b3 = com.travel.train.b.b().b(b2);
                k.a((Object) b3, "URL");
                a(bVar, bVar2, new CJRTrainVerifyCheckout(), b3, hashMap, jSONObject);
            }
        }
    }

    public final void a(com.paytm.network.listener.b bVar, com.paytm.network.listener.b bVar2, HashMap<String, String> hashMap, HashMap<String, String> hashMap2) {
        HashMap<String, String> hashMap3 = hashMap2;
        k.c(bVar, "onApiSuccess");
        k.c(bVar2, "handleErrorCode");
        k.c(hashMap, "headers");
        k.c(hashMap3, "urlParams");
        if (this.f25802c != null) {
            com.travel.train.b.a();
            String a2 = com.travel.train.b.b().a("URLSearchTrainsV4");
            if (!TextUtils.isEmpty(a2) && URLUtil.isValidUrl(a2)) {
                k.a((Object) a2, "URL");
                String b2 = o.b(this.f25802c, com.paytm.utility.b.s(this.f25802c, a(a2, hashMap3)));
                k.a((Object) b2, "URL");
                a(bVar, bVar2, (IJRPaytmDataModel) new CJRTrainSearchResults((String) null, (CJRTrainStatus) null, (CJRTrainSearchResultsBody) null, (CJRTrainSearchResultsMeta) null, (Integer) null, (HashMap) null, (HashMap) null, (HashMap) null, PriceRangeSeekBar.INVALID_POINTER_ID, (kotlin.g.b.g) null), b2, hashMap);
            }
        }
    }

    public final void b(com.paytm.network.listener.b bVar, com.paytm.network.listener.b bVar2, HashMap<String, String> hashMap, HashMap<String, String> hashMap2) {
        k.c(bVar, "onApiSuccess");
        k.c(bVar2, "handleErrorCode");
        k.c(hashMap, "headers");
        k.c(hashMap2, "urlParams");
        if (this.f25802c != null) {
            com.travel.train.b.a();
            String a2 = com.travel.train.b.b().a("URLNearybyStations");
            if (!TextUtils.isEmpty(a2) && URLUtil.isValidUrl(a2)) {
                k.a((Object) a2, "URL");
                String b2 = o.b(this.f25802c, com.paytm.utility.b.s(this.f25802c, a(a2, hashMap2)));
                k.a((Object) b2, "URL");
                a(bVar, bVar2, (IJRPaytmDataModel) new CJRNearByStationResult(), b2, hashMap);
            }
        }
    }

    public final void a(com.paytm.network.listener.b bVar, com.paytm.network.listener.b bVar2, HashMap<String, String> hashMap, String str) {
        k.c(bVar, "onApiSuccess");
        k.c(bVar2, "handleErrorCode");
        k.c(hashMap, "headers");
        k.c(str, "trainNumber");
        if (this.f25802c != null) {
            k.a((Object) com.travel.train.b.a(), "TrainController.getInstance()");
            String a2 = com.travel.train.b.b().a("URLTrainLiveSearch");
            if (!TextUtils.isEmpty(a2) && URLUtil.isValidUrl(a2)) {
                String s = com.paytm.utility.b.s(this.f25802c, a2 + '/' + str);
                k.a((Object) s, "URL");
                a(bVar, bVar2, (IJRPaytmDataModel) new CJRTrainLSSearchResult(), s, hashMap);
            }
        }
    }

    public final void c(com.paytm.network.listener.b bVar, com.paytm.network.listener.b bVar2, HashMap<String, String> hashMap, HashMap<String, String> hashMap2) {
        HashMap<String, String> hashMap3 = hashMap2;
        k.c(bVar, "onApiSuccess");
        k.c(bVar2, "handleErrorCode");
        k.c(hashMap, "headers");
        k.c(hashMap3, "urlParams");
        if (this.f25802c != null) {
            k.a((Object) com.travel.train.b.a(), "TrainController.getInstance()");
            String a2 = com.travel.train.b.b().a("URLAvailabilityCalendar");
            if (!TextUtils.isEmpty(a2) && URLUtil.isValidUrl(a2)) {
                k.a((Object) a2, "URL");
                String s = com.paytm.utility.b.s(this.f25802c, a(a2, hashMap3));
                k.a((Object) s, "URL");
                a(bVar, bVar2, (IJRPaytmDataModel) new CJRSearchByTrainNumberModel((String) null, (Status) null, (Body) null, (SearchResultMetaData) null, 0, (String) null, 63, (kotlin.g.b.g) null), s, hashMap);
            }
        }
    }

    public final void d(com.paytm.network.listener.b bVar, com.paytm.network.listener.b bVar2, HashMap<String, String> hashMap, HashMap<String, String> hashMap2) {
        k.c(bVar, "onApiSuccess");
        k.c(bVar2, "handleErrorCode");
        k.c(hashMap, "headers");
        k.c(hashMap2, "urlParams");
        if (this.f25802c != null) {
            k.a((Object) com.travel.train.b.a(), "TrainController.getInstance()");
            String a2 = com.travel.train.b.b().a("trainDetailsURL");
            if (!TextUtils.isEmpty(a2) && URLUtil.isValidUrl(a2)) {
                k.a((Object) a2, "URL");
                String b2 = o.b(this.f25802c, com.paytm.utility.b.s(this.f25802c, a(a2, hashMap2)));
                k.a((Object) b2, "URL");
                a(bVar, bVar2, (IJRPaytmDataModel) new CJRTrainDetails(), b2, hashMap);
            }
        }
    }

    public final void a(com.paytm.network.listener.b bVar, com.paytm.network.listener.b bVar2, HashMap<String, String> hashMap) {
        k.c(bVar, "onApiSuccess");
        k.c(bVar2, "handleErrorCode");
        k.c(hashMap, "headers");
        if (this.f25802c != null) {
            k.a((Object) com.travel.train.b.a(), "TrainController.getInstance()");
            String a2 = com.travel.train.b.b().a("trainServerMsgsURL");
            if (!TextUtils.isEmpty(a2) && URLUtil.isValidUrl(a2)) {
                String b2 = o.b(this.f25802c, com.paytm.utility.b.s(this.f25802c, a2));
                k.a((Object) b2, "URL");
                a(bVar, bVar2, (IJRPaytmDataModel) new CJRTrainMsgResponse(), b2, hashMap);
            }
        }
    }

    public final void b(com.paytm.network.listener.b bVar, com.paytm.network.listener.b bVar2, HashMap<String, String> hashMap) {
        k.c(bVar, "onApiSuccess");
        k.c(bVar2, "handleErrorCode");
        k.c(hashMap, "headers");
        if (this.f25802c != null) {
            k.a((Object) com.travel.train.b.a(), "TrainController.getInstance()");
            String a2 = com.travel.train.b.b().a("TrainHolidayList");
            if (!TextUtils.isEmpty(a2) && URLUtil.isValidUrl(a2)) {
                k.a((Object) a2, "URL");
                a(bVar, bVar2, (IJRPaytmDataModel) new CJRTrainHolidayList(), a2, hashMap);
            }
        }
    }

    public final void c(com.paytm.network.listener.b bVar, com.paytm.network.listener.b bVar2, HashMap<String, String> hashMap) {
        k.c(bVar, "onApiSuccess");
        k.c(bVar2, "handleErrorCode");
        k.c(hashMap, "headers");
        if (this.f25802c != null) {
            k.a((Object) com.travel.train.b.a(), "TrainController.getInstance()");
            String a2 = com.travel.train.b.b().a("URLTrainsFavouriteBookings");
            if (!TextUtils.isEmpty(a2) && URLUtil.isValidUrl(a2)) {
                k.a((Object) a2, "URL");
                a(bVar, bVar2, (IJRPaytmDataModel) new CJRTrainQuickBookFavourites(), a2, hashMap);
            }
        }
    }

    public final void e(com.paytm.network.listener.b bVar, com.paytm.network.listener.b bVar2, HashMap<String, String> hashMap, HashMap<String, String> hashMap2) {
        k.c(bVar, "onApiSuccess");
        k.c(bVar2, "handleErrorCode");
        k.c(hashMap, "headers");
        k.c(hashMap2, "urlParams");
        if (this.f25802c != null) {
            com.travel.train.b.a();
            String a2 = com.travel.train.b.b().a("travelMetroModeListURL");
            if (!TextUtils.isEmpty(a2) && URLUtil.isValidUrl(a2)) {
                k.a((Object) a2, "URL");
                String s = com.paytm.utility.b.s(this.f25802c, a(a2, hashMap2));
                k.a((Object) s, "URL");
                a(bVar, bVar2, (IJRPaytmDataModel) new CJRMetroListModesApiModel(), s, hashMap);
            }
        }
    }

    public final void d(com.paytm.network.listener.b bVar, com.paytm.network.listener.b bVar2, HashMap<String, String> hashMap) {
        k.c(bVar, "onApiSuccess");
        k.c(bVar2, "handleErrorCode");
        k.c(hashMap, "headers");
        if (this.f25802c != null) {
            com.travel.train.b.a();
            String a2 = com.travel.train.b.b().a("TrainRecentBookings");
            if (!TextUtils.isEmpty(a2) && URLUtil.isValidUrl(a2) && com.paytm.utility.b.r(this.f25802c)) {
                String b2 = o.b(this.f25802c, com.paytm.utility.b.s(this.f25802c, a2));
                k.a((Object) b2, "URL");
                a(bVar, bVar2, (IJRPaytmDataModel) new CJRTrainRecentBooking(), b2, hashMap);
            }
        }
    }

    public final void f(com.paytm.network.listener.b bVar, com.paytm.network.listener.b bVar2, HashMap<String, String> hashMap, HashMap<String, String> hashMap2) {
        k.c(bVar, "onApiSuccess");
        k.c(bVar2, "handleErrorCode");
        k.c(hashMap, "headers");
        k.c(hashMap2, "urlParams");
        if (this.f25802c != null) {
            k.a((Object) com.travel.train.b.a(), "TrainController.getInstance()");
            String a2 = com.travel.train.b.b().a("trainPNRStatusURL");
            if (!TextUtils.isEmpty(a2) && URLUtil.isValidUrl(a2)) {
                k.a((Object) a2, "URL");
                String b2 = o.b(this.f25802c, com.paytm.utility.b.s(this.f25802c, a(a2, hashMap2)));
                k.a((Object) b2, "URL");
                a(bVar, bVar2, (IJRPaytmDataModel) new CJRTrainPNRStatus(), b2, hashMap);
            }
        }
    }

    public final void a(String str, com.paytm.network.listener.b bVar, com.paytm.network.listener.b bVar2, HashMap<String, String> hashMap) {
        k.c(str, "url");
        k.c(bVar, "onApiSuccess");
        k.c(bVar2, "handleErrorCode");
        k.c(hashMap, "headers");
        a(bVar, bVar2, (IJRPaytmDataModel) new CJRTrainCity(), str, hashMap);
    }
}
