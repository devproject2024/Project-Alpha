package net.one97.paytm.deeplink;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.l;
import kotlin.m.p;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.dynamicModule.CommonDynamicLoaderActivity;
import net.one97.paytm.dynamicModule.DynamicModuleManager;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.utils.ba;
import net.one97.paytm.utils.c;

public final class aj {

    /* renamed from: a  reason: collision with root package name */
    public static final aj f50320a = new aj();

    /* renamed from: b  reason: collision with root package name */
    private static final Map<String, y> f50321b;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("busrating", new y(ba.l(), "flight_dynamic"));
        hashMap.put("bus-search", new y(ba.j(), "flight_dynamic"));
        hashMap.put("bus_order_summary", new y(ba.b(), "flight_dynamic"));
        hashMap.put("busticket", new y(ba.j(), "flight_dynamic"));
        hashMap.put("bustickets", new y(ba.j(), "flight_dynamic"));
        hashMap.put("bus_review_rating", new y(ba.p(), "flight_dynamic"));
        hashMap.put("trainticket", new y(ba.j(), "flight_dynamic"));
        hashMap.put("trainticketv2", new y(ba.j(), "flight_dynamic"));
        hashMap.put("train-search-result", new y(ba.k(), "flight_dynamic"));
        hashMap.put("train-traveller", new y(ba.h(), "flight_dynamic"));
        hashMap.put("train-review", new y(ba.h(), "flight_dynamic"));
        hashMap.put("track-train", new y(ba.f(), "flight_dynamic"));
        hashMap.put("train-pnr", new y(ba.g(), "flight_dynamic"));
        hashMap.put("train_order_summary", new y(ba.i(), "flight_dynamic"));
        hashMap.put("train_order_summary_v2", new y(ba.i(), "flight_dynamic"));
        hashMap.put("train-resume", new y(ba.h(), "flight_dynamic"));
        hashMap.put("flight_order_summary", new y(ba.a(), "flight_dynamic"));
        hashMap.put("flightreview", new y(ba.s(), "flight_dynamic"));
        hashMap.put("travelpass", new y(ba.j(), "flight_dynamic"));
        hashMap.put("travel-pass-about", new y(ba.j(), "flight_dynamic"));
        hashMap.put("travel-pass-details", new y(ba.j(), "flight_dynamic"));
        hashMap.put("travel-my-pass", new y(ba.j(), "flight_dynamic"));
        hashMap.put("travel_pass_order_summary", new y(ba.c(), "flight_dynamic"));
        hashMap.put("flightticket", new y(ba.j(), "flight_dynamic"));
        hashMap.put("prioritycheckin", new y(ba.d(), "flight_dynamic"));
        hashMap.put("refer-earn", new y(ba.m(), "flight_dynamic"));
        hashMap.put("travelcampaign", new y(ba.j(), "flight_dynamic"));
        hashMap.put("travelhome", new y(ba.j(), "flight_dynamic"));
        hashMap.put("hotel-city-search", new y(ba.j(), "flight_dynamic"));
        hashMap.put("hotel_order_summary", new y(ba.e(), "flight_dynamic"));
        hashMap.put("hotel_order_summary_v2", new y(ba.e(), "flight_dynamic"));
        hashMap.put("hotel-listings", new y(ba.j(), "flight_dynamic"));
        hashMap.put("hotel-results", new y(ba.j(), "flight_dynamic"));
        hashMap.put("hotel-details", new y(ba.j(), "flight_dynamic"));
        hashMap.put("hotel-booking", new y(ba.j(), "flight_dynamic"));
        hashMap.put("citybus", new y(ba.j(), "flight_dynamic"));
        hashMap.put("citybus_mumbai_order_summary", new y(ba.o(), "flight_dynamic"));
        f50321b = hashMap;
    }

    private aj() {
    }

    private static Intent a(Context context, y yVar, DeepLinkData deepLinkData) {
        CJRHomePageItem cJRHomePageItem;
        Intent intent;
        String str;
        Bundle bundle = new Bundle();
        boolean z = false;
        if (deepLinkData != null) {
            cJRHomePageItem = b(context, deepLinkData);
            Uri build = Uri.parse(deepLinkData.f50283a).buildUpon().build();
            k.a((Object) build, "uri");
            boolean z2 = false;
            for (String next : build.getQueryParameterNames()) {
                List<String> queryParameters = build.getQueryParameters(next);
                if (queryParameters != null && queryParameters.size() > 0) {
                    bundle.putString(next, queryParameters.get(0));
                    if (p.a(next, "from", true)) {
                        z2 = true;
                    }
                }
            }
            z = z2;
        } else {
            cJRHomePageItem = null;
        }
        if (cJRHomePageItem != null) {
            bundle.putSerializable("extra_home_data", cJRHomePageItem);
            if (cJRHomePageItem.getOrigin() != null) {
                bundle.putSerializable("origin", cJRHomePageItem.getOrigin());
            }
        }
        if (DynamicModuleManager.getInstance().isInstalled(yVar.f50389b) || (!TextUtils.isEmpty(yVar.f50389b) && yVar.f50389b.equals("travel_independent"))) {
            if (deepLinkData != null && (str = deepLinkData.f50283a) != null && p.a((CharSequence) str, (CharSequence) "paytmmp", false) && !z) {
                Intent intent2 = new Intent(context, Class.forName("net.one97.paytm.landingpage.activity.AJRMainActivity"));
                if (!(context instanceof Activity)) {
                    intent2.addFlags(268435456);
                }
                context.startActivity(intent2);
            }
            new StringBuilder("starting ").append(yVar.f50388a);
            intent = new Intent(context, Class.forName(yVar.f50388a));
        } else {
            intent = new Intent(context, CommonDynamicLoaderActivity.class);
        }
        intent.putExtras(bundle);
        intent.putExtra("EXTRA_DEEP_LINK_DATA", deepLinkData);
        intent.putExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, true);
        intent.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_ACTIVITY, yVar.f50388a);
        intent.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_MODULE, yVar.f50389b);
        intent.putExtra(CommonDynamicLoaderActivity.EXTRA_TARGET_ACTIVITY_ARGS, bundle);
        return intent;
    }

    public static Intent a(Context context, y yVar) {
        k.c(context, "context");
        k.c(yVar, "moduleActivityInfo");
        if (DynamicModuleManager.getInstance().isInstalled(yVar.f50389b)) {
            return new Intent(context, Class.forName(yVar.f50388a));
        }
        Intent intent = new Intent(context, CommonDynamicLoaderActivity.class);
        intent.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_ACTIVITY, yVar.f50388a);
        intent.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_MODULE, yVar.f50389b);
        return intent;
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str) || (!p.a(str, "busticket", true) && !p.a(str, "bus-search", true) && !p.a(str, "bustickets", true) && !p.a(str, "bus_order_summary", true) && !p.a(str, "busrating", true))) {
            return false;
        }
        return true;
    }

    public static boolean b(String str) {
        return !TextUtils.isEmpty(str) && p.a(str, "flightticket", true);
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str) || (!p.a(str, "train-search-result", true) && !p.a(str, "train-traveller", true) && !p.a(str, "train-review", true) && !p.a(str, "track-train", true) && !p.a(str, "train-pnr", true) && !p.a(str, "train_order_summary", true) && !p.a(str, "train_order_summary_v2", true) && !p.a(str, "trainticket", true) && !p.a(str, "trainticketv2", true) && !p.a(str, "train-resume", true))) {
            return false;
        }
        return true;
    }

    private static CJRHomePageItem b(Context context, DeepLinkData deepLinkData) {
        String str;
        Boolean bool;
        CJRHomePageItem cJRHomePageItem = new CJRHomePageItem();
        String str2 = null;
        if (deepLinkData != null) {
            str = deepLinkData.f50283a;
        } else {
            str = null;
        }
        if (!(str == null || deepLinkData.f50284b == null)) {
            String str3 = deepLinkData.f50283a;
            if (str3 == null) {
                k.a();
            }
            boolean z = false;
            if (p.b(str3, "http", false)) {
                CJRHomePageItem a2 = c.a(context, deepLinkData.f50283a);
                k.a((Object) a2, "AppLinksHelper.handleDee…eepLinkData.mDeepLinkUrl)");
                return a2;
            }
            String str4 = deepLinkData.f50283a;
            String str5 = deepLinkData.f50284b;
            if (str5 == null) {
                k.a();
            }
            if (p.a((CharSequence) str5, (CharSequence) "paytm.com", false)) {
                if (str4 == null) {
                    k.a();
                }
                CharSequence charSequence = str4;
                int a3 = p.a(charSequence, "paytm.com", 0, false, 6);
                int a4 = p.a(charSequence, "-", 0, false, 6);
                if (a3 != -1) {
                    str5 = str4.substring(a3 + 10, a4);
                    k.b(str5, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
            }
            CharSequence charSequence2 = str4;
            if (!TextUtils.isEmpty(charSequence2)) {
                if (str4 == null) {
                    k.a();
                }
                if (p.a(charSequence2, (CharSequence) "$", false)) {
                    str4 = new l("\\$").replace(charSequence2, AppConstants.AND_SIGN);
                }
            }
            CharSequence charSequence3 = str4;
            if (!TextUtils.isEmpty(charSequence3)) {
                cJRHomePageItem.setUrl(str4);
            }
            Uri parse = Uri.parse(str4);
            cJRHomePageItem.setUrlType(str5);
            cJRHomePageItem.setPushUtmSource(parse.getQueryParameter("utm_source"));
            if (!TextUtils.isEmpty(charSequence3)) {
                k.a((Object) parse, "uri");
                if (parse.getQueryParameterNames() != null) {
                    if (!TextUtils.isEmpty(charSequence3)) {
                        if (str4 == null) {
                            k.a();
                        }
                        if (p.a(charSequence3, (CharSequence) AppConstants.AND_SIGN, false) && !p.a(charSequence3, (CharSequence) "?", false)) {
                            str4 = new l(AppConstants.AND_SIGN).replaceFirst(charSequence3, "?");
                        }
                    }
                    CharSequence charSequence4 = str4;
                    if (!TextUtils.isEmpty(charSequence4)) {
                        if (str4 == null) {
                            k.a();
                        }
                        if (!p.a(charSequence4, (CharSequence) "versionidentifier", false) && !TextUtils.isEmpty(str5) && !p.a(str5, "train_order_summary", true)) {
                            if (!p.a(charSequence4, (CharSequence) "?", false)) {
                                str4 = str4 + "?versionidentifier=1";
                            } else {
                                str4 = str4 + "&versionidentifier=1";
                            }
                        }
                    }
                    cJRHomePageItem.setUrl(str4);
                }
            }
            cJRHomePageItem.setPushQuantity(parse.getQueryParameter("quantity"));
            cJRHomePageItem.setPushPromoCode(parse.getQueryParameter(PayUtility.PROMO_CODE));
            cJRHomePageItem.setPushProductId(parse.getQueryParameter(CLPConstants.PRODUCT_ID));
            cJRHomePageItem.setPushCashAdd(parse.getQueryParameter("amount"));
            cJRHomePageItem.setPushFeatureType(parse.getQueryParameter("featuretype"));
            cJRHomePageItem.setPushWalletCode(parse.getQueryParameter("wallet_code"));
            cJRHomePageItem.setPushRecipient(parse.getQueryParameter("recipient"));
            cJRHomePageItem.setPushComment(parse.getQueryParameter(CJRQRScanResultModel.KEY_COMMENT_SMALL));
            cJRHomePageItem.setUtmMedium(parse.getQueryParameter("utm_medium"));
            cJRHomePageItem.setUtmTerm(parse.getQueryParameter("utm_term"));
            cJRHomePageItem.setUtmContent(parse.getQueryParameter("utm_content"));
            cJRHomePageItem.setUtmCampaign(parse.getQueryParameter("utm_campaign"));
            cJRHomePageItem.setDeepLinking(true);
            String queryParameter = parse.getQueryParameter("showpopup");
            if (!TextUtils.isEmpty(queryParameter)) {
                if (queryParameter == null) {
                    k.a();
                }
                if (p.a(queryParameter, "true", true)) {
                    z = true;
                }
            }
            cJRHomePageItem.setPushShowPopup(z);
            cJRHomePageItem.setPushCheckInDate(parse.getQueryParameter("check_in_date"));
            cJRHomePageItem.setPushCheckOutDate(parse.getQueryParameter("check_out_date"));
            cJRHomePageItem.setPushCity(parse.getQueryParameter("city"));
            cJRHomePageItem.setPushCityValue(parse.getQueryParameter("city_value"));
            cJRHomePageItem.setPushRoomDetailsJson(parse.getQueryParameter("rooms_details"));
            cJRHomePageItem.setQueryString(parse.getQueryParameter("query_string"));
            cJRHomePageItem.setQrid(parse.getQueryParameter("qrid"));
            cJRHomePageItem.setPushHotelName(parse.getQueryParameter("hotel_name"));
            cJRHomePageItem.setPushHotelId(parse.getQueryParameter("hotel_id"));
            cJRHomePageItem.setPushHotelExtras(parse.getQueryParameter("hotel_extras"));
            cJRHomePageItem.setPushHotelFinalPriceWithTax(parse.getQueryParameter("hotel_final_price_with_tax"));
            cJRHomePageItem.setPushSourceCityName(parse.getQueryParameter("source_city_name"));
            cJRHomePageItem.setPushSourceCityShortName(parse.getQueryParameter("source_city_short_name"));
            cJRHomePageItem.setPushDestinationCityName(parse.getQueryParameter("destination_city_name"));
            cJRHomePageItem.setPushDestinationCityShortName(parse.getQueryParameter("destination_city_short_name"));
            cJRHomePageItem.setPushDate(parse.getQueryParameter(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR));
            cJRHomePageItem.setPushPassengerCount(parse.getQueryParameter("passenger_count"));
            cJRHomePageItem.setPushRechargeNumber(parse.getQueryParameter("recharge_number"));
            cJRHomePageItem.setPushRechargeAmount(parse.getQueryParameter("price"));
            cJRHomePageItem.setPushRechargePromo(parse.getQueryParameter("promo"));
            cJRHomePageItem.setPushRechargeRoaming(parse.getQueryParameter("roaming"));
            cJRHomePageItem.setPushType(parse.getQueryParameter("type"));
            cJRHomePageItem.setPushCode(parse.getQueryParameter("code"));
            cJRHomePageItem.setPushFlightClass(parse.getQueryParameter("flight_class"));
            cJRHomePageItem.setPushFlightTripType(parse.getQueryParameter("flight_trip_type"));
            cJRHomePageItem.setPushFlightDepartDate(parse.getQueryParameter("flight_depart_date"));
            cJRHomePageItem.setPushFlightReturnDate(parse.getQueryParameter("flight_return_date"));
            cJRHomePageItem.setTrainSourceCityCode(parse.getQueryParameter("source"));
            cJRHomePageItem.setTrainDestinationCityCode(parse.getQueryParameter("destination"));
            cJRHomePageItem.setTrainDepartureDate(parse.getQueryParameter("departureDate"));
            cJRHomePageItem.setTrainSourceCityName(parse.getQueryParameter("source_name"));
            cJRHomePageItem.setTrainDestinationCityName(parse.getQueryParameter("destination_name"));
            if (parse != null) {
                str2 = parse.getQueryParameter("is_round_trip");
            }
            if (str2 != null) {
                bool = Boolean.valueOf(parse.getQueryParameter("is_round_trip"));
            } else {
                bool = Boolean.FALSE;
            }
            k.a((Object) bool, "if (uri?.getQueryParamet…lse\n                false");
            cJRHomePageItem.setTrainRoundTrip(bool.booleanValue());
            cJRHomePageItem.setOrigin("deeplinking");
            cJRHomePageItem.setmFlightReferral(parse.getQueryParameter("referral"));
        }
        return cJRHomePageItem;
    }

    public static boolean a(DeepLinkData deepLinkData) {
        String str;
        k.c(deepLinkData, "deepLinkData");
        String str2 = deepLinkData.f50284b;
        if (deepLinkData == null) {
            k.a();
        }
        String str3 = deepLinkData.f50283a;
        boolean z = false;
        if (str2 == null || str3 == null) {
            return false;
        }
        if (p.a(str2, "order_summary", true)) {
            if (!p.a((CharSequence) str3, (CharSequence) "bus", false)) {
                return false;
            }
            deepLinkData.f50284b = "bus_order_summary";
            deepLinkData.f50283a = "paytmmp://bus_order_summary?url=".concat(String.valueOf(str3));
            return true;
        } else if (p.a(str2, CLPConstants.URL_TYPE_EMBED, true)) {
            return false;
        } else {
            if (p.a(str2, "external", true)) {
                Bundle bundle = deepLinkData.f50290h;
                if (bundle != null) {
                    str = bundle.getString("bus_action_new", "");
                } else {
                    str = null;
                }
                if (p.a(str, "bus_rating_popup", false)) {
                    z = true;
                }
            }
            switch (str2.hashCode()) {
                case -2044543567:
                    if (str2.equals("hotel-city-search") || str2.equals("hotel-city-search")) {
                        return true;
                    }
                case -1871399148:
                    if (str2.equals("trainticket")) {
                        return true;
                    }
                    break;
                case -1805176726:
                    if (str2.equals("hotel_order_summary") || str2.equals("hotel_order_summary")) {
                        return true;
                    }
                case -1573925921:
                    if (str2.equals("travel-my-pass")) {
                        return true;
                    }
                    break;
                case -1565513625:
                    if (str2.equals("bustickets")) {
                        return true;
                    }
                    break;
                case -1493609548:
                    if (str2.equals("travel_metro")) {
                        return true;
                    }
                    break;
                case -1384638375:
                    if (str2.equals("travel-pass-details")) {
                        return true;
                    }
                    break;
                case -1373988810:
                    if (str2.equals("bus_order_summary")) {
                        return true;
                    }
                    break;
                case -1358469176:
                    if (str2.equals("flightreview")) {
                        return true;
                    }
                    break;
                case -1298080900:
                    if (str2.equals("flightticket")) {
                        return true;
                    }
                    break;
                case -1015267906:
                    if (str2.equals("train_order_summary")) {
                        return true;
                    }
                    break;
                case -945926115:
                    if (str2.equals("busrating")) {
                        return true;
                    }
                    break;
                case -881784436:
                    if (str2.equals("busticket")) {
                        return true;
                    }
                    break;
                case -734236047:
                    if (str2.equals("hotel_order_summary_v2") || str2.equals("hotel_order_summary_v2")) {
                        return true;
                    }
                case -720274906:
                    if (str2.equals("flight_order_summary")) {
                        return true;
                    }
                    break;
                case -689634712:
                    if (str2.equals("hotel-listings") || str2.equals("hotel-listings")) {
                        return true;
                    }
                case -686394211:
                    if (str2.equals("train_order_summary_v2")) {
                        return true;
                    }
                    break;
                case -637724340:
                    if (str2.equals("travel_pass_order_summary")) {
                        return true;
                    }
                    break;
                case -507287662:
                    if (str2.equals("train-resume")) {
                        return true;
                    }
                    break;
                case -507210051:
                    if (str2.equals("train-review")) {
                        return true;
                    }
                    break;
                case -416630464:
                    if (str2.equals("hotel-booking") || str2.equals("hotel-booking")) {
                        return true;
                    }
                case -312570305:
                    if (str2.equals("travelmetro")) {
                        return true;
                    }
                    break;
                case 1295914:
                    if (str2.equals("travelcampaign")) {
                        return true;
                    }
                    break;
                case 53278217:
                    if (str2.equals("prioritycheckin")) {
                        return true;
                    }
                    break;
                case 134087061:
                    if (str2.equals("bus-search")) {
                        return true;
                    }
                    break;
                case 167023366:
                    if (str2.equals("track-train")) {
                        return true;
                    }
                    break;
                case 176324410:
                    if (str2.equals("train-traveller")) {
                        return true;
                    }
                    break;
                case 530961629:
                    if (str2.equals("train-search-result")) {
                        return true;
                    }
                    break;
                case 616230109:
                    if (str2.equals("hotel-results") || str2.equals("hotel-results")) {
                        return true;
                    }
                case 682514169:
                    if (str2.equals("travelhome")) {
                        return true;
                    }
                    break;
                case 682739243:
                    if (str2.equals("travelpass")) {
                        return true;
                    }
                    break;
                case 785443125:
                    if (str2.equals("citybus")) {
                        return true;
                    }
                    break;
                case 903206127:
                    if (str2.equals("train-pnr")) {
                        return true;
                    }
                    break;
                case 1076405033:
                    if (str2.equals("hotel-details") || str2.equals("hotel-details")) {
                        return true;
                    }
                case 1176719504:
                    if (str2.equals("trainticketv2")) {
                        return true;
                    }
                    break;
                case 1300548581:
                    if (str2.equals("citybus_mumbai_order_summary")) {
                        return true;
                    }
                    break;
                case 1332963589:
                    if (str2.equals("refer-earn")) {
                        return true;
                    }
                    break;
                case 2064966500:
                    if (str2.equals("travel-pass-about")) {
                        return true;
                    }
                    break;
                case 2128330677:
                    if (str2.equals("internationalflights")) {
                        return true;
                    }
                    break;
            }
            return z;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0056, code lost:
        if (r8 == false) goto L_0x0058;
     */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0186  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r12, net.one97.paytm.deeplink.DeepLinkData r13) {
        /*
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r12, r0)
            java.lang.String r0 = "deepLinkData"
            kotlin.g.b.k.c(r13, r0)
            java.lang.String r1 = r13.f50284b
            r2 = 1
            java.lang.String r3 = "travelhome"
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r3, (boolean) r2)
            java.lang.String r3 = "url"
            r4 = 0
            r5 = 0
            if (r1 == 0) goto L_0x007b
            kotlin.g.b.k.c(r13, r0)
            java.lang.String r0 = r13.f50284b
            android.net.Uri r1 = r13.f50289g
            if (r1 == 0) goto L_0x002c
            java.lang.String r6 = "type"
            java.lang.String r1 = r1.getQueryParameter(r6)
            goto L_0x002d
        L_0x002c:
            r1 = r5
        L_0x002d:
            android.net.Uri r6 = r13.f50289g
            if (r6 == 0) goto L_0x0036
            java.lang.String r6 = r6.getQueryParameter(r3)
            goto L_0x0037
        L_0x0036:
            r6 = r5
        L_0x0037:
            java.lang.String r7 = r13.f50283a
            r13.f50284b = r1
            java.lang.String r8 = "homepage"
            boolean r8 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r8, (boolean) r2)
            if (r8 != 0) goto L_0x0058
            java.lang.String r8 = "travelcampaign"
            boolean r8 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r8, (boolean) r2)
            if (r8 != 0) goto L_0x0058
            if (r6 == 0) goto L_0x0055
            java.lang.String r8 = "paytmmp://"
            boolean r8 = kotlin.m.p.b(r6, r8, r2)
            goto L_0x0056
        L_0x0055:
            r8 = 0
        L_0x0056:
            if (r8 != 0) goto L_0x006b
        L_0x0058:
            if (r7 == 0) goto L_0x006a
            if (r0 != 0) goto L_0x005f
            kotlin.g.b.k.a()
        L_0x005f:
            if (r1 != 0) goto L_0x0064
            kotlin.g.b.k.a()
        L_0x0064:
            java.lang.String r0 = kotlin.m.p.a(r7, r0, r1, r4)
            r6 = r0
            goto L_0x006b
        L_0x006a:
            r6 = r5
        L_0x006b:
            r13.f50283a = r6
            android.net.Uri r0 = android.net.Uri.parse(r6)
            android.net.Uri$Builder r0 = r0.buildUpon()
            android.net.Uri r0 = r0.build()
            r13.f50289g = r0
        L_0x007b:
            java.lang.String r0 = r13.f50284b
            java.lang.String r1 = "external"
            boolean r1 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r2)
            if (r1 == 0) goto L_0x0109
            android.os.Bundle r1 = r13.f50290h
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x0092
            java.lang.String r6 = "bus_action_new"
            java.lang.String r1 = r1.getString(r6, r2)
            goto L_0x0093
        L_0x0092:
            r1 = r5
        L_0x0093:
            java.lang.String r6 = "bus_rating_popup"
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r6, (boolean) r4)
            if (r1 == 0) goto L_0x0109
            android.os.Bundle r0 = r13.f50290h
            if (r0 == 0) goto L_0x00a6
            java.lang.String r1 = "description_message"
            java.lang.String r1 = r0.getString(r1, r2)
            goto L_0x00a7
        L_0x00a6:
            r1 = r5
        L_0x00a7:
            if (r0 == 0) goto L_0x00b1
            java.lang.String r4 = "title_message"
            java.lang.String r4 = r0.getString(r4, r2)
            goto L_0x00b2
        L_0x00b1:
            r4 = r5
        L_0x00b2:
            if (r0 == 0) goto L_0x00b9
            java.lang.String r6 = r0.getString(r3, r2)
            goto L_0x00ba
        L_0x00b9:
            r6 = r5
        L_0x00ba:
            if (r0 == 0) goto L_0x00c3
            java.lang.String r7 = "rating_url"
            java.lang.String r7 = r0.getString(r7, r2)
            goto L_0x00c4
        L_0x00c3:
            r7 = r5
        L_0x00c4:
            if (r0 == 0) goto L_0x00cd
            java.lang.String r8 = "secret"
            java.lang.String r8 = r0.getString(r8, r2)
            goto L_0x00ce
        L_0x00cd:
            r8 = r5
        L_0x00ce:
            if (r0 == 0) goto L_0x00d7
            java.lang.String r9 = "order_id"
            java.lang.String r9 = r0.getString(r9, r2)
            goto L_0x00d8
        L_0x00d7:
            r9 = r5
        L_0x00d8:
            java.lang.String r10 = "channel"
            if (r0 == 0) goto L_0x00e1
            java.lang.String r0 = r0.getString(r10, r2)
            goto L_0x00e2
        L_0x00e1:
            r0 = r5
        L_0x00e2:
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            java.lang.String r11 = "description"
            r2.putString(r11, r1)
            java.lang.String r1 = "contentTitle"
            r2.putString(r1, r4)
            java.lang.String r1 = "ratingUrl"
            r2.putString(r1, r7)
            java.lang.String r1 = "secretKey"
            r2.putString(r1, r8)
            java.lang.String r1 = "orderID"
            r2.putString(r1, r9)
            r2.putString(r10, r0)
            r2.putString(r3, r6)
            java.lang.String r0 = "bus_review_rating"
            goto L_0x010a
        L_0x0109:
            r2 = r5
        L_0x010a:
            java.util.Map<java.lang.String, net.one97.paytm.deeplink.y> r1 = f50321b
            if (r1 == 0) goto L_0x0186
            boolean r1 = r1.containsKey(r0)
            if (r1 == 0) goto L_0x011d
            java.util.Map<java.lang.String, net.one97.paytm.deeplink.y> r1 = f50321b
            java.lang.Object r0 = r1.get(r0)
            r5 = r0
            net.one97.paytm.deeplink.y r5 = (net.one97.paytm.deeplink.y) r5
        L_0x011d:
            if (r5 == 0) goto L_0x0129
            android.content.Intent r0 = a(r12, r5, r13)
            if (r2 == 0) goto L_0x0158
            r0.putExtras(r2)
            goto L_0x0158
        L_0x0129:
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = b(r12, r13)
            android.content.Intent r1 = new android.content.Intent
            java.lang.String r2 = "com.travel.travels.activity.AJRTravelsHomeActivity"
            java.lang.Class r2 = java.lang.Class.forName(r2)
            r1.<init>(r12, r2)
            r2 = r13
            android.os.Parcelable r2 = (android.os.Parcelable) r2
            java.lang.String r3 = "EXTRA_DEEP_LINK_DATA"
            r1.putExtra(r3, r2)
            r2 = r0
            java.io.Serializable r2 = (java.io.Serializable) r2
            java.lang.String r3 = "extra_home_data"
            r1.putExtra(r3, r2)
            java.lang.String r2 = r0.getOrigin()
            if (r2 == 0) goto L_0x0157
            java.lang.String r0 = r0.getOrigin()
            java.lang.String r2 = "origin"
            r1.putExtra(r2, r0)
        L_0x0157:
            r0 = r1
        L_0x0158:
            boolean r1 = r12 instanceof android.app.Activity
            if (r1 != 0) goto L_0x0161
            r1 = 268435456(0x10000000, float:2.5243549E-29)
            r0.addFlags(r1)
        L_0x0161:
            android.os.Bundle r1 = r13.f50290h
            if (r1 == 0) goto L_0x0182
            android.os.Bundle r1 = r13.f50290h
            if (r1 != 0) goto L_0x016c
            kotlin.g.b.k.a()
        L_0x016c:
            java.lang.String r2 = "From"
            java.lang.String r1 = r1.getString(r2)
            if (r1 == 0) goto L_0x0182
            android.os.Bundle r13 = r13.f50290h
            if (r13 != 0) goto L_0x017b
            kotlin.g.b.k.a()
        L_0x017b:
            java.lang.String r13 = r13.getString(r2)
            r0.putExtra(r2, r13)
        L_0x0182:
            r12.startActivity(r0)
            return
        L_0x0186:
            java.lang.NullPointerException r12 = new java.lang.NullPointerException
            java.lang.String r13 = "null cannot be cast to non-null type kotlin.collections.Map<K, *>"
            r12.<init>(r13)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.deeplink.aj.a(android.content.Context, net.one97.paytm.deeplink.DeepLinkData):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0052 A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean d(java.lang.String r1) {
        /*
            r0 = r1
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0054
            if (r1 != 0) goto L_0x000c
            goto L_0x0054
        L_0x000c:
            int r0 = r1.hashCode()
            switch(r0) {
                case -2044543567: goto L_0x004a;
                case -1805176726: goto L_0x0041;
                case -734236047: goto L_0x0038;
                case -689634712: goto L_0x002f;
                case -416630464: goto L_0x0026;
                case 616230109: goto L_0x001d;
                case 1076405033: goto L_0x0014;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x0054
        L_0x0014:
            java.lang.String r0 = "hotel-details"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0054
            goto L_0x0052
        L_0x001d:
            java.lang.String r0 = "hotel-results"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0054
            goto L_0x0052
        L_0x0026:
            java.lang.String r0 = "hotel-booking"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0054
            goto L_0x0052
        L_0x002f:
            java.lang.String r0 = "hotel-listings"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0054
            goto L_0x0052
        L_0x0038:
            java.lang.String r0 = "hotel_order_summary_v2"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0054
            goto L_0x0052
        L_0x0041:
            java.lang.String r0 = "hotel_order_summary"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0054
            goto L_0x0052
        L_0x004a:
            java.lang.String r0 = "hotel-city-search"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0054
        L_0x0052:
            r1 = 1
            goto L_0x0055
        L_0x0054:
            r1 = 0
        L_0x0055:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.deeplink.aj.d(java.lang.String):boolean");
    }

    public static boolean b(DeepLinkData deepLinkData) {
        k.c(deepLinkData, "deepLinkData");
        return p.a("hotel_order_summary", deepLinkData.f50284b, true);
    }
}
