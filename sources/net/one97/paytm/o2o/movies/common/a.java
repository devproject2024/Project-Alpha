package net.one97.paytm.o2o.movies.common;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.paytm.contactsSdk.constant.ContactsConstant;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.v;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.CJRSelectCitiesModel;
import net.one97.paytm.common.entity.movies.search.CJRUpcomingMovies;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.o2o.movies.common.movies.booking.CJRMovieCart;
import net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMPCartItems;
import net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassHomeModel;
import net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassPrevalidateResponseModel;
import net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassStorefrontModel;
import net.one97.paytm.o2o.movies.common.movies.moviepass.CJRUserMoviePassModel;
import net.one97.paytm.o2o.movies.common.movies.moviepass.CJRUserMoviePassWrapperModel;
import net.one97.paytm.o2o.movies.d.e;
import net.one97.paytm.o2o.movies.entity.CJRAmenity;
import net.one97.paytm.o2o.movies.entity.CJRBrowseByCinema;
import net.one97.paytm.o2o.movies.entity.CJRBrowseByCinemaMeta;
import net.one97.paytm.o2o.movies.entity.CJRBrowseByData;
import net.one97.paytm.o2o.movies.entity.CJRCinemaV1;
import net.one97.paytm.o2o.movies.entity.CJRCinemas;
import net.one97.paytm.o2o.movies.entity.CJRMovieOffers;
import net.one97.paytm.o2o.movies.utils.n;

public final class a implements e.b {

    /* renamed from: b  reason: collision with root package name */
    public static final C1484a f74984b = new C1484a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final a f74985g = new a();
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static final int f74986h = -1;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static final int f74987i = 14;
    /* access modifiers changed from: private */
    public static final int j = 13;

    /* renamed from: a  reason: collision with root package name */
    final int f74988a = 12;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Context f74989c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<String, e.b.a> f74990d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private final int f74991e = 20;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final String f74992f;

    private a() {
        Context c2 = n.c();
        k.a((Object) c2, "CJRMoviesUtility.getAppContext()");
        this.f74989c = c2;
        String simpleName = a.class.getSimpleName();
        k.a((Object) simpleName, "CJRMovieAPIClient::class.java.simpleName");
        this.f74992f = simpleName;
    }

    /* renamed from: net.one97.paytm.o2o.movies.common.a$a  reason: collision with other inner class name */
    public static final class C1484a {
        private C1484a() {
        }

        public /* synthetic */ C1484a(byte b2) {
            this();
        }

        public final synchronized a a() {
            return a.f74985g;
        }
    }

    public static final class c implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f74995a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ e.a f74996b;

        c(a aVar, e.a aVar2) {
            this.f74995a = aVar;
            this.f74996b = aVar2;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f74995a.a(networkCustomError, this.f74996b, e.b.a.WALLET_TOKEN_API);
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            a.a(this.f74995a, iJRPaytmDataModel, this.f74996b);
        }
    }

    public final String a(e.a aVar, String str, e.b.a aVar2) {
        k.c(aVar, "mListener");
        k.c(aVar2, "type");
        int i2 = b.f75001a[aVar2.ordinal()];
        if (i2 == 1) {
            k.a((Object) net.one97.paytm.o2o.movies.common.b.c.a(), "MoviesGTMLoader.getInstance()");
            String a2 = net.one97.paytm.o2o.movies.common.b.c.a("moviesPrevalidate", (String) null);
            if (TextUtils.isEmpty(a2)) {
                k.a((Object) a2, "url");
                return a2;
            }
            this.f74990d.put(a2, e.b.a.MOVIEPASS_PREVAIDATE_API);
            String b2 = com.paytm.utility.c.b(a2, this.f74989c);
            Map hashMap = new HashMap();
            hashMap.put("ClientId", "paytm");
            hashMap.put("Content-Type", "application/json");
            k.a((Object) b2, "url");
            IJRPaytmDataModel cJRMoviePassPrevalidateResponseModel = new CJRMoviePassPrevalidateResponseModel((List<CJRMPCartItems>) null, "");
            if (str == null) {
                k.a();
            }
            a(b2, cJRMoviePassPrevalidateResponseModel, aVar, str, hashMap);
            return b2;
        } else if (i2 != 2) {
            if (i2 == 3) {
                k.a((Object) net.one97.paytm.o2o.movies.common.b.c.a(), "MoviesGTMLoader.getInstance()");
                String a3 = net.one97.paytm.o2o.movies.common.b.c.a("moviePassVerifyURL", (String) null);
                if (TextUtils.isEmpty(a3)) {
                    k.a((Object) a3, "url");
                    return a3;
                }
                this.f74990d.put(a3, e.b.a.MOVIEPASS_VERIFY_API);
                com.paytm.utility.c.b(a3, this.f74989c);
            }
            return "";
        } else {
            k.a((Object) net.one97.paytm.o2o.movies.common.b.c.a(), "MoviesGTMLoader.getInstance()");
            String a4 = net.one97.paytm.o2o.movies.common.b.c.a("movie_pass_cities_list_url", (String) null);
            if (TextUtils.isEmpty(a4)) {
                return "";
            }
            this.f74990d.put(a4, e.b.a.MOVIEPASS_CITY_LIST_API);
            Map hashMap2 = new HashMap();
            hashMap2.put("ClientId", "paytm");
            k.a((Object) a4, "url");
            a(a4, (IJRPaytmDataModel) new CJRSelectCitiesModel(), aVar, (Map<String, String>) hashMap2);
            return a4;
        }
    }

    public final String a(e.a aVar, String str, e.b.a aVar2, Map<String, Object> map) {
        String str2;
        e.a aVar3 = aVar;
        Map<String, Object> map2 = map;
        k.c(aVar3, "mListener");
        k.c(aVar2, "type");
        k.c(map2, Item.CTA_URL_TYPE_MAP);
        switch (b.f75002b[aVar2.ordinal()]) {
            case 1:
                String valueOf = String.valueOf(map2.get("city"));
                k.a((Object) net.one97.paytm.o2o.movies.common.b.c.a(), "MoviesGTMLoader.getInstance()");
                String a2 = net.one97.paytm.o2o.movies.common.b.c.a("moviePassStorefrontURL", (String) null);
                if (TextUtils.isEmpty(a2)) {
                    return "";
                }
                this.f74990d.put(a2.toString(), e.b.a.MOVIEPASS_CATELOG_API);
                String a3 = n.a("city", valueOf, a2);
                if (n.c(this.f74989c)) {
                    a3 = n.a("customerId", com.paytm.utility.b.n(n.c()), a3);
                }
                String a4 = n.a(ContactsConstant.LOCALE, com.paytm.utility.b.g(), a3);
                Map hashMap = new HashMap();
                hashMap.put("ClientId", "paytm");
                a(a4.toString(), (IJRPaytmDataModel) new CJRMoviePassStorefrontModel(), aVar3, (Map<String, String>) hashMap);
                return a4.toString();
            case 2:
                String valueOf2 = String.valueOf(map2.get("city"));
                k.a((Object) net.one97.paytm.o2o.movies.common.b.c.a(), "MoviesGTMLoader.getInstance()");
                String a5 = net.one97.paytm.o2o.movies.common.b.c.a("movie_pass_user_all_pass_url_v2", (String) null);
                if (TextUtils.isEmpty(a5)) {
                    return "";
                }
                this.f74990d.put(a5.toString(), e.b.a.MOVIEPASS_ACTIVE_EXPIRE);
                String a6 = n.a(ContactsConstant.LOCALE, com.paytm.utility.b.g(), n.a("city", valueOf2, a5));
                HashMap hashMap2 = new HashMap();
                hashMap2.put("ClientId", "paytm");
                HashMap<String, String> a7 = com.paytm.utility.b.a((HashMap<String, String>) hashMap2, this.f74989c);
                k.a((Object) a7, "CJRAppCommonUtility.addS…der(headers, mAppContext)");
                a(a6.toString(), (IJRPaytmDataModel) new CJRUserMoviePassWrapperModel((String) null, (ArrayList<CJRUserMoviePassModel>) null, (List<CJRUserMoviePassModel>) null), aVar3, (Map<String, String>) a7);
                return a6.toString();
            case 3:
                String valueOf3 = String.valueOf(map2.get("wallet_token"));
                k.a((Object) net.one97.paytm.o2o.movies.common.b.c.a(), "MoviesGTMLoader.getInstance()");
                String a8 = net.one97.paytm.o2o.movies.common.b.c.a("moviePassCheckoutURL", (String) null);
                this.f74990d.put(a8, e.b.a.MOVIEPASS_CHECKOUT_API);
                String b2 = com.paytm.utility.c.b(a8, this.f74989c);
                String k = com.paytm.utility.b.k();
                Uri parse = Uri.parse(b2);
                k.a((Object) parse, "Uri.parse(url)");
                if (parse.getQuery() != null) {
                    str2 = b2 + "&wallet_token=" + valueOf3 + "&client_id=" + k;
                } else {
                    str2 = b2 + "?wallet_token=" + valueOf3 + "&client_id=" + k;
                }
                String d2 = com.paytm.utility.b.d(str2, "POST");
                HashMap hashMap3 = new HashMap();
                hashMap3.put("Content-Type", "application/json");
                HashMap<String, String> a9 = com.paytm.utility.b.a((HashMap<String, String>) hashMap3, this.f74989c);
                k.a((Object) a9, "CJRAppCommonUtility.addS…der(headers, mAppContext)");
                Map map3 = a9;
                map3.put("wallet_token", valueOf3);
                String str3 = d2 + "&native_withdraw=1";
                k.a((Object) str3, "url");
                IJRPaytmDataModel cJRRechargePayment = new CJRRechargePayment();
                if (str == null) {
                    k.a();
                }
                a(str3, cJRRechargePayment, aVar, str, map3);
                return str3.toString();
            case 4:
                String valueOf4 = String.valueOf(map2.get("city"));
                k.a((Object) net.one97.paytm.o2o.movies.common.b.c.a(), "MoviesGTMLoader.getInstance()");
                StringBuilder sb = new StringBuilder(net.one97.paytm.o2o.movies.common.b.c.a("moviePassBannerURL_v2", (String) null));
                this.f74990d.put(sb.toString(), e.b.a.MOVIEPASS_BANNER_API);
                if (!v.a(valueOf4)) {
                    sb.append("city=");
                    sb.append(valueOf4);
                }
                String n = com.paytm.utility.b.n(n.c());
                if (!v.a(n) && n.c(this.f74989c)) {
                    sb.append("&customerId=");
                    sb.append(n);
                }
                Map hashMap4 = new HashMap();
                hashMap4.put("ClientId", "paytm");
                sb.append("&locale=" + com.paytm.utility.b.g());
                String sb2 = sb.toString();
                k.a((Object) sb2, "url.toString()");
                a(sb2, (IJRPaytmDataModel) new CJRMoviePassHomeModel((Integer) null, (Boolean) null, (Boolean) null, (Boolean) null, (String) null, (String) null, (String) null, (List<CJRUserMoviePassModel>) null), aVar3, (Map<String, String>) hashMap4);
                String sb3 = sb.toString();
                k.a((Object) sb3, "url.toString()");
                return sb3;
            case 5:
                String valueOf5 = String.valueOf(map2.get(CLPConstants.PRODUCT_ID));
                net.one97.paytm.o2o.movies.common.b.c.a();
                String a10 = net.one97.paytm.o2o.movies.common.b.c.a("moviePromoSearchUrl", (String) null);
                k.a((Object) a10, "MoviesGTMLoader.getInsta…MoviePromoOffersPartOne()");
                String a11 = p.a(a10, "v1", "v2", false);
                net.one97.paytm.o2o.movies.common.b.c.a();
                String a12 = net.one97.paytm.o2o.movies.common.b.c.a("moviePromoSearchUrlExtension", (String) null);
                net.one97.paytm.o2o.movies.common.b.c.a();
                String a13 = net.one97.paytm.o2o.movies.common.b.c.a("moviepassCategoryId", (String) null);
                if (TextUtils.isEmpty(a13)) {
                    a13 = "8765634523";
                }
                String b3 = com.paytm.utility.c.b(a11 + valueOf5 + a12, this.f74989c);
                k.a((Object) b3, "CJRDefaultRequestParam.g…houtSSO(url, mAppContext)");
                String a14 = n.a("price", String.valueOf(map2.get("price")), b3);
                k.a((Object) a14, "CJRMoviesUtility.addQuer…\"price\"].toString(), url)");
                String a15 = n.a("category_id", a13, a14);
                k.a((Object) a15, "CJRMoviesUtility.addQuer…ory_id\", categoryId, url)");
                this.f74990d.put(a15, e.b.a.MOVIEPASS_PROMO);
                HashMap hashMap5 = new HashMap();
                hashMap5.put("Content-Type", "application/json");
                HashMap<String, String> a16 = com.paytm.utility.b.a((HashMap<String, String>) hashMap5, this.f74989c);
                k.a((Object) a16, "CJRAppCommonUtility.addS…der(headers, mAppContext)");
                Map map4 = a16;
                map4.put("ClientId", "paytm");
                a(a15, (IJRPaytmDataModel) new CJRMovieOffers(), aVar3, (Map<String, String>) map4);
                return a15;
            case 6:
                String valueOf6 = String.valueOf(map2.get("city"));
                k.a((Object) net.one97.paytm.o2o.movies.common.b.c.a(), "MoviesGTMLoader.getInstance()");
                String d3 = net.one97.paytm.o2o.movies.common.b.c.d();
                if (TextUtils.isEmpty(d3)) {
                    return "";
                }
                this.f74990d.put(d3.toString(), e.b.a.UPCOMING_MOVIES);
                String a17 = n.a("city", valueOf6, d3);
                if (n.c(this.f74989c)) {
                    a17 = n.a("customerId", com.paytm.utility.b.n(n.c()), a17);
                }
                String a18 = n.a(ContactsConstant.LOCALE, com.paytm.utility.b.g(), a17);
                Map hashMap6 = new HashMap();
                hashMap6.put("ClientId", "paytm");
                a(a18.toString(), (IJRPaytmDataModel) new CJRUpcomingMovies(), aVar3, (Map<String, String>) hashMap6);
                return a18.toString();
            case 7:
                String valueOf7 = String.valueOf(map2.get("city"));
                net.one97.paytm.o2o.movies.common.b.c.a();
                String a19 = net.one97.paytm.o2o.movies.common.b.c.a("movieCinemaURLV3", (String) null);
                if (TextUtils.isEmpty(a19)) {
                    return "";
                }
                this.f74990d.put(a19.toString(), e.b.a.CINEMA_LIST);
                String a20 = n.a("city", valueOf7, a19);
                if (n.c(this.f74989c)) {
                    a20 = n.a("userId", com.paytm.utility.b.n(n.c()), a20);
                }
                Map hashMap7 = new HashMap();
                hashMap7.put("ClientId", "paytm");
                a(a20.toString(), (IJRPaytmDataModel) new CJRBrowseByCinema((CJRBrowseByCinemaMeta) null, (CJRBrowseByData) null, 3, (g) null), aVar3, (Map<String, String>) hashMap7);
                return a20.toString();
            case 8:
                k.a((Object) net.one97.paytm.o2o.movies.common.b.c.a(), "MoviesGTMLoader.getInstance()");
                String a21 = net.one97.paytm.o2o.movies.common.b.c.a("moviePassVerifyURL", (String) null);
                this.f74990d.put(a21, e.b.a.MOVIEPASS_VERIFY_API);
                String a22 = n.a("native_withdraw", "1", n.a("payment_info_version", "2", n.a("payment_info", "1", com.paytm.utility.c.b(a21, this.f74989c))));
                if (String.valueOf(map2.get("manual_promo")).equals("1")) {
                    a22 = n.a("manual_promocode", "1", a22);
                }
                HashMap hashMap8 = new HashMap();
                hashMap8.put("Content-Type", "application/json");
                HashMap<String, String> a23 = com.paytm.utility.b.a((HashMap<String, String>) hashMap8, this.f74989c);
                k.a((Object) a23, "CJRAppCommonUtility.addS…der(headers, mAppContext)");
                Map map5 = a23;
                map5.put("ClientId", "paytm");
                map5.put("Content-Type", "application/json");
                k.a((Object) a22, "url");
                IJRPaytmDataModel cJRMovieCart = new CJRMovieCart();
                if (str == null) {
                    k.a();
                }
                a(a22, cJRMovieCart, aVar, str, map5);
                break;
        }
        return "";
    }

    private final void a(String str, IJRPaytmDataModel iJRPaytmDataModel, e.a aVar, String str2, Map<String, String> map) {
        net.one97.paytm.o2o.movies.utils.c cVar = new net.one97.paytm.o2o.movies.utils.c();
        cVar.f42877a = this.f74989c;
        cVar.f42878b = a.c.MOVIES;
        cVar.f42879c = a.C0715a.POST;
        cVar.f42880d = str;
        cVar.f42881e = null;
        cVar.f42882f = map;
        cVar.f42883g = null;
        cVar.f42884h = str2;
        cVar.f42885i = iJRPaytmDataModel;
        cVar.j = new d(this, aVar, str);
        cVar.n = a.b.USER_FACING;
        cVar.o = "movies";
        cVar.t = n.h("");
        com.paytm.network.a l = cVar.l();
        l.f42859c = false;
        l.a();
    }

    public static final class d implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f74997a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ e.a f74998b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f74999c;

        d(a aVar, e.a aVar2, String str) {
            this.f74997a = aVar;
            this.f74998b = aVar2;
            this.f74999c = str;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            this.f74998b.a(iJRPaytmDataModel, this.f74997a.f74990d);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0034, code lost:
            r0 = (net.one97.paytm.o2o.movies.d.e.b.a) net.one97.paytm.o2o.movies.common.a.a(r10.f74997a).get(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
            net.one97.paytm.o2o.movies.common.a.a(r10.f74997a).remove(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0049, code lost:
            r9 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x004b, code lost:
            r4 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x008b, code lost:
            r3 = r3.getmMessage();
         */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x00bd A[Catch:{ Exception -> 0x01be }] */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x00dc A[Catch:{ Exception -> 0x01be }] */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x00de A[Catch:{ Exception -> 0x01be }] */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x010d A[Catch:{ Exception -> 0x01be }] */
        /* JADX WARNING: Removed duplicated region for block: B:86:0x01d2  */
        /* JADX WARNING: Removed duplicated region for block: B:87:0x01d7  */
        /* JADX WARNING: Removed duplicated region for block: B:89:0x01da  */
        /* JADX WARNING: Removed duplicated region for block: B:90:0x01df  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void handleErrorCode(int r11, com.paytm.network.model.IJRPaytmDataModel r12, com.paytm.network.model.NetworkCustomError r13) {
            /*
                r10 = this;
                if (r13 == 0) goto L_0x01e4
                r8 = 0
                net.one97.paytm.o2o.movies.common.a r0 = r10.f74997a     // Catch:{ Exception -> 0x01c0 }
                java.util.HashMap r0 = r0.f74990d     // Catch:{ Exception -> 0x01c0 }
                java.util.Set r0 = r0.keySet()     // Catch:{ Exception -> 0x01c0 }
                java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x01c0 }
            L_0x0011:
                boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x01c0 }
                r2 = 0
                if (r1 == 0) goto L_0x004e
                java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x01c0 }
                java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x01c0 }
                if (r1 == 0) goto L_0x0011
                java.lang.String r3 = r13.getFullUrl()     // Catch:{ Exception -> 0x01c0 }
                java.lang.String r4 = "error.fullUrl"
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)     // Catch:{ Exception -> 0x01c0 }
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x01c0 }
                r4 = r1
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x01c0 }
                boolean r3 = kotlin.m.p.a((java.lang.CharSequence) r3, (java.lang.CharSequence) r4, (boolean) r2)     // Catch:{ Exception -> 0x01c0 }
                if (r3 == 0) goto L_0x0011
                net.one97.paytm.o2o.movies.common.a r0 = r10.f74997a     // Catch:{ Exception -> 0x01c0 }
                java.util.HashMap r0 = r0.f74990d     // Catch:{ Exception -> 0x01c0 }
                java.lang.Object r0 = r0.get(r1)     // Catch:{ Exception -> 0x01c0 }
                net.one97.paytm.o2o.movies.d.e$b$a r0 = (net.one97.paytm.o2o.movies.d.e.b.a) r0     // Catch:{ Exception -> 0x01c0 }
                net.one97.paytm.o2o.movies.common.a r3 = r10.f74997a     // Catch:{ Exception -> 0x004b }
                java.util.HashMap r3 = r3.f74990d     // Catch:{ Exception -> 0x004b }
                r3.remove(r1)     // Catch:{ Exception -> 0x004b }
                r9 = r0
                goto L_0x004f
            L_0x004b:
                r4 = r0
                goto L_0x01c1
            L_0x004e:
                r9 = r8
            L_0x004f:
                com.paytm.network.model.NetworkResponse r0 = r13.networkResponse     // Catch:{ Exception -> 0x01be }
                byte[] r0 = r0.data     // Catch:{ Exception -> 0x01be }
                java.lang.String r1 = "error.networkResponse.data"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x01be }
                java.lang.String r1 = new java.lang.String     // Catch:{ Exception -> 0x01be }
                java.nio.charset.Charset r3 = kotlin.m.d.f47971a     // Catch:{ Exception -> 0x01be }
                r1.<init>(r0, r3)     // Catch:{ Exception -> 0x01be }
                com.paytm.network.model.CJRIllegalCodeError r0 = new com.paytm.network.model.CJRIllegalCodeError     // Catch:{ Exception -> 0x01be }
                r0.<init>()     // Catch:{ Exception -> 0x01be }
                r3 = r1
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x01be }
                boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x01be }
                if (r3 != 0) goto L_0x0081
                com.google.gsonhtcfix.f r3 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x01be }
                r3.<init>()     // Catch:{ Exception -> 0x01be }
                java.lang.Class r0 = r0.getClass()     // Catch:{ Exception -> 0x01be }
                java.lang.Object r0 = r3.a((java.lang.String) r1, r0)     // Catch:{ Exception -> 0x01be }
                java.lang.String r1 = "Gson().fromJson(jsonStri… errorStatus::class.java)"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x01be }
                com.paytm.network.model.CJRIllegalCodeError r0 = (com.paytm.network.model.CJRIllegalCodeError) r0     // Catch:{ Exception -> 0x01be }
            L_0x0081:
                java.lang.String r1 = r0.getCode()     // Catch:{ Exception -> 0x01be }
                com.paytm.network.model.CJRStatusError r3 = r0.getStatusError()     // Catch:{ Exception -> 0x01be }
                if (r3 == 0) goto L_0x0096
                com.paytm.network.model.CJRError r3 = r3.getmMessage()     // Catch:{ Exception -> 0x01be }
                if (r3 == 0) goto L_0x0096
                java.lang.String r3 = r3.getTitle()     // Catch:{ Exception -> 0x01be }
                goto L_0x0097
            L_0x0096:
                r3 = r8
            L_0x0097:
                com.paytm.network.model.CJRStatusError r4 = r0.getStatusError()     // Catch:{ Exception -> 0x01be }
                if (r4 == 0) goto L_0x00a8
                com.paytm.network.model.CJRError r4 = r4.getmMessage()     // Catch:{ Exception -> 0x01be }
                if (r4 == 0) goto L_0x00a8
                java.lang.String r4 = r4.getMessage()     // Catch:{ Exception -> 0x01be }
                goto L_0x00a9
            L_0x00a8:
                r4 = r8
            L_0x00a9:
                r5 = r3
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x01be }
                r6 = 1
                if (r5 == 0) goto L_0x00b8
                int r5 = r5.length()     // Catch:{ Exception -> 0x01be }
                if (r5 != 0) goto L_0x00b6
                goto L_0x00b8
            L_0x00b6:
                r5 = 0
                goto L_0x00b9
            L_0x00b8:
                r5 = 1
            L_0x00b9:
                if (r5 != 0) goto L_0x00bd
            L_0x00bb:
                r5 = r3
                goto L_0x00ce
            L_0x00bd:
                net.one97.paytm.o2o.movies.common.a r3 = r10.f74997a     // Catch:{ Exception -> 0x01be }
                android.content.Context r3 = r3.f74989c     // Catch:{ Exception -> 0x01be }
                android.content.res.Resources r3 = r3.getResources()     // Catch:{ Exception -> 0x01be }
                int r5 = net.one97.paytm.o2o.movies.R.string.network_error_heading     // Catch:{ Exception -> 0x01be }
                java.lang.String r3 = r3.getString(r5)     // Catch:{ Exception -> 0x01be }
                goto L_0x00bb
            L_0x00ce:
                r3 = r4
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x01be }
                if (r3 == 0) goto L_0x00d9
                int r3 = r3.length()     // Catch:{ Exception -> 0x01be }
                if (r3 != 0) goto L_0x00da
            L_0x00d9:
                r2 = 1
            L_0x00da:
                if (r2 != 0) goto L_0x00de
                r7 = r4
                goto L_0x0105
            L_0x00de:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01be }
                r2.<init>()     // Catch:{ Exception -> 0x01be }
                net.one97.paytm.o2o.movies.common.a r3 = r10.f74997a     // Catch:{ Exception -> 0x01be }
                android.content.Context r3 = r3.f74989c     // Catch:{ Exception -> 0x01be }
                android.content.res.Resources r3 = r3.getResources()     // Catch:{ Exception -> 0x01be }
                int r4 = net.one97.paytm.o2o.movies.R.string.network_error_message     // Catch:{ Exception -> 0x01be }
                java.lang.String r3 = r3.getString(r4)     // Catch:{ Exception -> 0x01be }
                r2.append(r3)     // Catch:{ Exception -> 0x01be }
                java.lang.String r3 = " "
                r2.append(r3)     // Catch:{ Exception -> 0x01be }
                java.lang.String r3 = r10.f74999c     // Catch:{ Exception -> 0x01be }
                r2.append(r3)     // Catch:{ Exception -> 0x01be }
                java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x01be }
                r7 = r2
            L_0x0105:
                java.lang.String r2 = "401"
                boolean r2 = r1.equals(r2)     // Catch:{ Exception -> 0x01be }
                if (r2 != 0) goto L_0x0185
                if (r9 == 0) goto L_0x0115
                net.one97.paytm.o2o.movies.d.e$b$a r2 = net.one97.paytm.o2o.movies.d.e.b.a.WALLET_TOKEN_API     // Catch:{ Exception -> 0x01be }
                if (r9 != r2) goto L_0x0115
                goto L_0x0185
            L_0x0115:
                if (r5 == 0) goto L_0x0136
                java.lang.String r2 = r0.getError_message()     // Catch:{ Exception -> 0x01be }
                if (r2 == 0) goto L_0x0136
                java.lang.String r2 = "-1"
                boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x01be }
                if (r0 == 0) goto L_0x0136
                net.one97.paytm.o2o.movies.d.e$a r0 = r10.f74998b     // Catch:{ Exception -> 0x01be }
                r1 = 1
                net.one97.paytm.o2o.movies.common.a$a r2 = net.one97.paytm.o2o.movies.common.a.f74984b     // Catch:{ Exception -> 0x01be }
                int r3 = net.one97.paytm.o2o.movies.common.a.f74986h     // Catch:{ Exception -> 0x01be }
                r2 = r7
                r4 = r9
                r6 = r7
                r7 = r13
                r0.a(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x01be }
                return
            L_0x0136:
                if (r5 == 0) goto L_0x013a
                if (r7 != 0) goto L_0x0144
            L_0x013a:
                if (r1 == 0) goto L_0x0155
                java.lang.String r0 = "417"
                boolean r0 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r0, (boolean) r6)     // Catch:{ Exception -> 0x01be }
                if (r0 == 0) goto L_0x0155
            L_0x0144:
                net.one97.paytm.o2o.movies.d.e$a r0 = r10.f74998b     // Catch:{ Exception -> 0x01be }
                r1 = 1
                net.one97.paytm.o2o.movies.common.a$a r2 = net.one97.paytm.o2o.movies.common.a.f74984b     // Catch:{ Exception -> 0x01be }
                int r3 = net.one97.paytm.o2o.movies.common.a.f74987i     // Catch:{ Exception -> 0x01be }
                r2 = r7
                r4 = r9
                r6 = r7
                r7 = r13
                r0.a(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x01be }
                return
            L_0x0155:
                if (r7 == 0) goto L_0x0171
                java.lang.String r0 = "parsing_error"
                boolean r0 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r0, (boolean) r6)     // Catch:{ Exception -> 0x01be }
                if (r0 == 0) goto L_0x0171
                net.one97.paytm.o2o.movies.d.e$a r0 = r10.f74998b     // Catch:{ Exception -> 0x01be }
                r1 = 1
                java.lang.String r2 = r13.getFullUrl()     // Catch:{ Exception -> 0x01be }
                net.one97.paytm.o2o.movies.common.a r3 = r10.f74997a     // Catch:{ Exception -> 0x01be }
                int r3 = r3.f74988a     // Catch:{ Exception -> 0x01be }
                r4 = r9
                r6 = r7
                r7 = r13
                r0.a(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x01be }
                return
            L_0x0171:
                net.one97.paytm.o2o.movies.d.e$a r0 = r10.f74998b     // Catch:{ Exception -> 0x01be }
                r1 = 1
                java.lang.String r2 = r13.getFullUrl()     // Catch:{ Exception -> 0x01be }
                net.one97.paytm.o2o.movies.common.a$a r3 = net.one97.paytm.o2o.movies.common.a.f74984b     // Catch:{ Exception -> 0x01be }
                int r3 = net.one97.paytm.o2o.movies.common.a.j     // Catch:{ Exception -> 0x01be }
                r4 = r9
                r6 = r7
                r7 = r13
                r0.a(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x01be }
                return
            L_0x0185:
                net.one97.paytm.o2o.movies.common.a r0 = r10.f74997a     // Catch:{ Exception -> 0x01be }
                android.content.Context r0 = r0.f74989c     // Catch:{ Exception -> 0x01be }
                android.content.res.Resources r0 = r0.getResources()     // Catch:{ Exception -> 0x01be }
                int r1 = net.one97.paytm.o2o.movies.R.string.session_expiry_msg     // Catch:{ Exception -> 0x01be }
                java.lang.String r6 = r0.getString(r1)     // Catch:{ Exception -> 0x01be }
                java.lang.String r0 = "mAppContext.resources.ge…tring.session_expiry_msg)"
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r0)     // Catch:{ Exception -> 0x01be }
                net.one97.paytm.o2o.movies.d.e$a r0 = r10.f74998b     // Catch:{ Exception -> 0x01be }
                r1 = 1
                java.lang.String r2 = r13.getFullUrl()     // Catch:{ Exception -> 0x01be }
                net.one97.paytm.o2o.movies.common.a$a r3 = net.one97.paytm.o2o.movies.common.a.f74984b     // Catch:{ Exception -> 0x01be }
                int r3 = net.one97.paytm.o2o.movies.common.a.j     // Catch:{ Exception -> 0x01be }
                net.one97.paytm.o2o.movies.d.e$b$a r4 = net.one97.paytm.o2o.movies.d.e.b.a.WALLET_TOKEN_API     // Catch:{ Exception -> 0x01be }
                net.one97.paytm.o2o.movies.common.a r5 = r10.f74997a     // Catch:{ Exception -> 0x01be }
                android.content.Context r5 = r5.f74989c     // Catch:{ Exception -> 0x01be }
                android.content.res.Resources r5 = r5.getResources()     // Catch:{ Exception -> 0x01be }
                int r7 = net.one97.paytm.o2o.movies.R.string.session_expiry_title     // Catch:{ Exception -> 0x01be }
                java.lang.String r5 = r5.getString(r7)     // Catch:{ Exception -> 0x01be }
                r7 = r13
                r0.a(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x01be }
                return
            L_0x01be:
                r4 = r9
                goto L_0x01c1
            L_0x01c0:
                r4 = r8
            L_0x01c1:
                net.one97.paytm.o2o.movies.common.a r0 = r10.f74997a
                java.lang.String unused = r0.f74992f
                java.lang.String r0 = "onErrorResponse"
                com.paytm.utility.q.c(r0)
                net.one97.paytm.o2o.movies.d.e$a r0 = r10.f74998b
                r1 = 0
                r2 = 0
                r3 = 0
                if (r13 == 0) goto L_0x01d7
                java.lang.String r5 = r13.getAlertTitle()
                goto L_0x01d8
            L_0x01d7:
                r5 = r8
            L_0x01d8:
                if (r13 == 0) goto L_0x01df
                java.lang.String r6 = r13.getAlertMessage()
                goto L_0x01e0
            L_0x01df:
                r6 = r8
            L_0x01e0:
                r7 = r13
                r0.a(r1, r2, r3, r4, r5, r6, r7)
            L_0x01e4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.common.a.d.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void");
        }
    }

    private final void a(String str, IJRPaytmDataModel iJRPaytmDataModel, e.a aVar, Map<String, String> map) {
        net.one97.paytm.o2o.movies.utils.c cVar = new net.one97.paytm.o2o.movies.utils.c();
        cVar.f42877a = this.f74989c;
        cVar.f42878b = a.c.MOVIES;
        cVar.f42879c = a.C0715a.GET;
        cVar.f42880d = str;
        cVar.f42881e = null;
        cVar.f42882f = map;
        cVar.f42883g = null;
        cVar.f42884h = null;
        cVar.f42885i = iJRPaytmDataModel;
        cVar.j = new b(this, aVar);
        cVar.n = a.b.USER_FACING;
        cVar.o = "movies";
        cVar.t = n.h("AjrUpcomingMovie");
        com.paytm.network.a l = cVar.l();
        l.f42859c = false;
        l.a();
    }

    public static final class b implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f74993a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ e.a f74994b;

        b(a aVar, e.a aVar2) {
            this.f74993a = aVar;
            this.f74994b = aVar2;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f74993a.a(networkCustomError, this.f74994b, (e.b.a) null);
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            a.a(this.f74993a, iJRPaytmDataModel, this.f74994b);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0031, code lost:
        r0 = r9.f74990d.get(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r9.f74990d.remove(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003e, code lost:
        r8 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0040, code lost:
        r4 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0140, code lost:
        kotlin.g.b.k.a();
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004f A[Catch:{ Exception -> 0x0135 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0140  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.paytm.network.model.NetworkCustomError r10, net.one97.paytm.o2o.movies.d.e.a r11, net.one97.paytm.o2o.movies.d.e.b.a r12) {
        /*
            r9 = this;
            if (r10 == 0) goto L_0x0150
            if (r12 != 0) goto L_0x0046
            java.util.HashMap<java.lang.String, net.one97.paytm.o2o.movies.d.e$b$a> r0 = r9.f74990d     // Catch:{ Exception -> 0x0043 }
            java.util.Set r0 = r0.keySet()     // Catch:{ Exception -> 0x0043 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x0043 }
        L_0x000e:
            boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x0043 }
            if (r1 == 0) goto L_0x0046
            java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x0043 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0043 }
            if (r1 == 0) goto L_0x000e
            java.lang.String r2 = r10.getFullUrl()     // Catch:{ Exception -> 0x0043 }
            java.lang.String r3 = "error.fullUrl"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x0043 }
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x0043 }
            r3 = r1
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x0043 }
            r4 = 0
            boolean r2 = kotlin.m.p.a((java.lang.CharSequence) r2, (java.lang.CharSequence) r3, (boolean) r4)     // Catch:{ Exception -> 0x0043 }
            if (r2 == 0) goto L_0x000e
            java.util.HashMap<java.lang.String, net.one97.paytm.o2o.movies.d.e$b$a> r0 = r9.f74990d     // Catch:{ Exception -> 0x0043 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ Exception -> 0x0043 }
            net.one97.paytm.o2o.movies.d.e$b$a r0 = (net.one97.paytm.o2o.movies.d.e.b.a) r0     // Catch:{ Exception -> 0x0043 }
            java.util.HashMap<java.lang.String, net.one97.paytm.o2o.movies.d.e$b$a> r2 = r9.f74990d     // Catch:{ Exception -> 0x0040 }
            r2.remove(r1)     // Catch:{ Exception -> 0x0040 }
            r8 = r0
            goto L_0x0047
        L_0x0040:
            r4 = r0
            goto L_0x0136
        L_0x0043:
            r4 = r12
            goto L_0x0136
        L_0x0046:
            r8 = r12
        L_0x0047:
            int r0 = r10.getStatusCode()     // Catch:{ Exception -> 0x0135 }
            r1 = 401(0x191, float:5.62E-43)
            if (r0 == r1) goto L_0x0109
            if (r8 == 0) goto L_0x0057
            net.one97.paytm.o2o.movies.d.e$b$a r1 = net.one97.paytm.o2o.movies.d.e.b.a.WALLET_TOKEN_API     // Catch:{ Exception -> 0x0135 }
            if (r8 != r1) goto L_0x0057
            goto L_0x0109
        L_0x0057:
            java.lang.String r1 = r10.getAlertTitle()     // Catch:{ Exception -> 0x0135 }
            if (r1 == 0) goto L_0x007c
            java.lang.String r1 = r10.getAlertMessage()     // Catch:{ Exception -> 0x0135 }
            if (r1 == 0) goto L_0x007c
            r1 = -1
            if (r0 != r1) goto L_0x007c
            r1 = 1
            java.lang.String r2 = r10.getAlertMessage()     // Catch:{ Exception -> 0x0135 }
            int r3 = f74986h     // Catch:{ Exception -> 0x0135 }
            java.lang.String r5 = r10.getAlertTitle()     // Catch:{ Exception -> 0x0135 }
            java.lang.String r6 = r10.getAlertMessage()     // Catch:{ Exception -> 0x0135 }
            r0 = r11
            r4 = r8
            r7 = r10
            r0.a(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0135 }
            return
        L_0x007c:
            java.lang.String r1 = r10.getAlertTitle()     // Catch:{ Exception -> 0x0135 }
            if (r1 == 0) goto L_0x0088
            java.lang.String r1 = r10.getAlertMessage()     // Catch:{ Exception -> 0x0135 }
            if (r1 != 0) goto L_0x008c
        L_0x0088:
            r1 = 417(0x1a1, float:5.84E-43)
            if (r0 != r1) goto L_0x00a2
        L_0x008c:
            r1 = 1
            java.lang.String r2 = r10.getAlertMessage()     // Catch:{ Exception -> 0x0135 }
            int r3 = f74987i     // Catch:{ Exception -> 0x0135 }
            java.lang.String r5 = r10.getAlertTitle()     // Catch:{ Exception -> 0x0135 }
            java.lang.String r6 = r10.getAlertMessage()     // Catch:{ Exception -> 0x0135 }
            r0 = r11
            r4 = r8
            r7 = r10
            r0.a(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0135 }
            return
        L_0x00a2:
            java.lang.String r0 = r10.getMessage()     // Catch:{ Exception -> 0x0135 }
            if (r0 == 0) goto L_0x00cb
            java.lang.String r0 = r10.getMessage()     // Catch:{ Exception -> 0x0135 }
            java.lang.String r1 = "parsing_error"
            r2 = 1
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r2)     // Catch:{ Exception -> 0x0135 }
            if (r0 == 0) goto L_0x00cb
            r1 = 1
            java.lang.String r2 = r10.getFullUrl()     // Catch:{ Exception -> 0x0135 }
            int r3 = r9.f74988a     // Catch:{ Exception -> 0x0135 }
            java.lang.String r5 = r10.getAlertTitle()     // Catch:{ Exception -> 0x0135 }
            java.lang.String r6 = r10.getAlertMessage()     // Catch:{ Exception -> 0x0135 }
            r0 = r11
            r4 = r8
            r7 = r10
            r0.a(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0135 }
            return
        L_0x00cb:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0135 }
            r0.<init>()     // Catch:{ Exception -> 0x0135 }
            android.content.Context r1 = r9.f74989c     // Catch:{ Exception -> 0x0135 }
            android.content.res.Resources r1 = r1.getResources()     // Catch:{ Exception -> 0x0135 }
            int r2 = net.one97.paytm.o2o.movies.R.string.network_error_message     // Catch:{ Exception -> 0x0135 }
            java.lang.String r1 = r1.getString(r2)     // Catch:{ Exception -> 0x0135 }
            r0.append(r1)     // Catch:{ Exception -> 0x0135 }
            java.lang.String r1 = " "
            r0.append(r1)     // Catch:{ Exception -> 0x0135 }
            java.lang.String r1 = r10.getFullUrl()     // Catch:{ Exception -> 0x0135 }
            r0.append(r1)     // Catch:{ Exception -> 0x0135 }
            java.lang.String r6 = r0.toString()     // Catch:{ Exception -> 0x0135 }
            r1 = 1
            java.lang.String r2 = r10.getFullUrl()     // Catch:{ Exception -> 0x0135 }
            int r3 = j     // Catch:{ Exception -> 0x0135 }
            android.content.Context r0 = r9.f74989c     // Catch:{ Exception -> 0x0135 }
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ Exception -> 0x0135 }
            int r4 = net.one97.paytm.o2o.movies.R.string.network_error_heading     // Catch:{ Exception -> 0x0135 }
            java.lang.String r5 = r0.getString(r4)     // Catch:{ Exception -> 0x0135 }
            r0 = r11
            r4 = r8
            r7 = r10
            r0.a(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0135 }
            return
        L_0x0109:
            android.content.Context r0 = r9.f74989c     // Catch:{ Exception -> 0x0135 }
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ Exception -> 0x0135 }
            int r1 = net.one97.paytm.o2o.movies.R.string.session_expiry_msg     // Catch:{ Exception -> 0x0135 }
            java.lang.String r6 = r0.getString(r1)     // Catch:{ Exception -> 0x0135 }
            java.lang.String r0 = "mAppContext.resources.ge…tring.session_expiry_msg)"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r0)     // Catch:{ Exception -> 0x0135 }
            r1 = 1
            java.lang.String r2 = r10.getFullUrl()     // Catch:{ Exception -> 0x0135 }
            int r3 = j     // Catch:{ Exception -> 0x0135 }
            net.one97.paytm.o2o.movies.d.e$b$a r4 = net.one97.paytm.o2o.movies.d.e.b.a.WALLET_TOKEN_API     // Catch:{ Exception -> 0x0135 }
            android.content.Context r0 = r9.f74989c     // Catch:{ Exception -> 0x0135 }
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ Exception -> 0x0135 }
            int r5 = net.one97.paytm.o2o.movies.R.string.session_expiry_title     // Catch:{ Exception -> 0x0135 }
            java.lang.String r5 = r0.getString(r5)     // Catch:{ Exception -> 0x0135 }
            r0 = r11
            r7 = r10
            r0.a(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0135 }
            return
        L_0x0135:
            r4 = r8
        L_0x0136:
            java.lang.String r0 = "onErrorResponse"
            com.paytm.utility.q.c(r0)
            r1 = 0
            r2 = 0
            r3 = 0
            if (r10 != 0) goto L_0x0143
            kotlin.g.b.k.a()
        L_0x0143:
            java.lang.String r5 = r10.getAlertTitle()
            java.lang.String r6 = r10.getAlertMessage()
            r0 = r11
            r7 = r10
            r0.a(r1, r2, r3, r4, r5, r6, r7)
        L_0x0150:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.common.a.a(com.paytm.network.model.NetworkCustomError, net.one97.paytm.o2o.movies.d.e$a, net.one97.paytm.o2o.movies.d.e$b$a):void");
    }

    public final void a(Activity activity, e.a aVar) {
        k.c(activity, "activity");
        k.c(aVar, "mListener");
        net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.getWalletTokenMovies(net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.getSSOToken(this.f74989c), activity, new c(this, aVar));
    }

    public static final /* synthetic */ void a(a aVar, IJRPaytmDataModel iJRPaytmDataModel, e.a aVar2) {
        CJRBrowseByData data;
        ArrayList<CJRCinemas> cinemas;
        ArrayList<CJRAmenity> amenities;
        if (iJRPaytmDataModel instanceof CJRBrowseByCinema) {
            CJRBrowseByCinema cJRBrowseByCinema = (CJRBrowseByCinema) iJRPaytmDataModel;
            CJRCinemaV1 cJRCinemaV1 = new CJRCinemaV1();
            if (cJRBrowseByCinema == null || (data = cJRBrowseByCinema.getData()) == null || (cinemas = data.getCinemas()) == null) {
                cJRCinemaV1.setCinemas(new ArrayList());
            } else {
                cJRCinemaV1.setCinemas(cinemas);
                CJRBrowseByCinemaMeta meta = cJRBrowseByCinema.getMeta();
                if (!(meta == null || (amenities = meta.getAmenities()) == null)) {
                    cJRCinemaV1.setCjrAmenities(amenities);
                }
            }
            aVar2.a(cJRCinemaV1, aVar.f74990d);
            return;
        }
        aVar2.a(iJRPaytmDataModel, aVar.f74990d);
    }
}
