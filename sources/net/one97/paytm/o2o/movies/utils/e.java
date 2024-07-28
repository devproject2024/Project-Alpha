package net.one97.paytm.o2o.movies.utils;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaV2;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieDataResponse;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeListItem;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieMeta;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieRating;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieRatings;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieSessionsPageData;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession;
import net.one97.paytm.o2o.movies.common.movies.search.CJRSessionsItem;
import net.one97.paytm.o2o.movies.common.movies.search.GroupFormatObject;
import net.one97.paytm.o2o.movies.common.movies.search.RNR;
import net.one97.paytm.o2o.movies.common.movies.search.Rating;
import net.one97.paytm.o2o.movies.entity.CJRCinemas;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f75922a = new e();

    private e() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01a7, code lost:
        r8 = r8.f75187a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.paytm.network.model.IJRPaytmDataModel a(com.paytm.network.model.IJRPaytmDataModel r18, java.lang.String r19) {
        /*
            r0 = r18
            r1 = 0
            if (r0 == 0) goto L_0x0472
            boolean r2 = r0 instanceof net.one97.paytm.o2o.movies.common.movies.search.CJRMovieDataResponse
            if (r2 == 0) goto L_0x0472
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieDataResponse r0 = (net.one97.paytm.o2o.movies.common.movies.search.CJRMovieDataResponse) r0
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieMeta r2 = r0.getMeta()
            if (r2 == 0) goto L_0x0014
            java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeListItem> r2 = r2.f75174a
            goto L_0x0015
        L_0x0014:
            r2 = r1
        L_0x0015:
            java.lang.String r3 = "CJRMovieSearchResponseHo…erSingleton.getInstance()"
            if (r2 != 0) goto L_0x002a
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieMeta r2 = r0.getMeta()
            if (r2 == 0) goto L_0x002a
            net.one97.paytm.o2o.movies.utils.i r4 = net.one97.paytm.o2o.movies.utils.i.a()
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r3)
            java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeListItem> r4 = r4.f75937g
            r2.f75174a = r4
        L_0x002a:
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieMeta r2 = r0.getMeta()
            if (r2 == 0) goto L_0x0033
            java.util.ArrayList<net.one97.paytm.o2o.movies.entity.CJRCinemas> r2 = r2.f75175b
            goto L_0x0034
        L_0x0033:
            r2 = r1
        L_0x0034:
            if (r2 != 0) goto L_0x0047
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieMeta r2 = r0.getMeta()
            if (r2 == 0) goto L_0x0047
            net.one97.paytm.o2o.movies.utils.i r4 = net.one97.paytm.o2o.movies.utils.i.a()
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r3)
            java.util.ArrayList<net.one97.paytm.o2o.movies.entity.CJRCinemas> r4 = r4.f75933c
            r2.f75175b = r4
        L_0x0047:
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieMeta r2 = r0.getMeta()
            if (r2 == 0) goto L_0x0050
            java.util.ArrayList<net.one97.paytm.o2o.movies.entity.CJRAmenity> r2 = r2.f75177d
            goto L_0x0051
        L_0x0050:
            r2 = r1
        L_0x0051:
            if (r2 != 0) goto L_0x006b
            net.one97.paytm.o2o.movies.utils.i r2 = net.one97.paytm.o2o.movies.utils.i.a()
            java.util.List<net.one97.paytm.o2o.movies.entity.CJRAmenity> r2 = r2.f75935e
            if (r2 == 0) goto L_0x006b
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieMeta r2 = r0.getMeta()
            if (r2 == 0) goto L_0x006b
            net.one97.paytm.o2o.movies.utils.i r4 = net.one97.paytm.o2o.movies.utils.i.a()
            java.util.List<net.one97.paytm.o2o.movies.entity.CJRAmenity> r4 = r4.f75935e
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            r2.f75177d = r4
        L_0x006b:
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieMeta r2 = r0.getMeta()
            if (r2 == 0) goto L_0x0074
            net.one97.paytm.o2o.movies.common.movies.search.CJRFilterData r2 = r2.f75176c
            goto L_0x0075
        L_0x0074:
            r2 = r1
        L_0x0075:
            if (r2 != 0) goto L_0x0088
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieMeta r2 = r0.getMeta()
            if (r2 == 0) goto L_0x0088
            net.one97.paytm.o2o.movies.utils.i r4 = net.one97.paytm.o2o.movies.utils.i.a()
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r3)
            net.one97.paytm.o2o.movies.common.movies.search.CJRFilterData r4 = r4.f75934d
            r2.f75176c = r4
        L_0x0088:
            net.one97.paytm.o2o.movies.utils.i r2 = net.one97.paytm.o2o.movies.utils.i.a()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieMeta r4 = r0.getMeta()
            if (r4 == 0) goto L_0x0098
            net.one97.paytm.o2o.movies.common.movies.search.CJRFilterData r4 = r4.f75176c
            goto L_0x0099
        L_0x0098:
            r4 = r1
        L_0x0099:
            r2.f75934d = r4
            net.one97.paytm.o2o.movies.common.movies.search.CJRSessionDatesData r2 = r0.getData()
            if (r2 == 0) goto L_0x00a4
            java.util.ArrayList<java.lang.String> r2 = r2.f75187a
            goto L_0x00a5
        L_0x00a4:
            r2 = r1
        L_0x00a5:
            if (r2 != 0) goto L_0x00b8
            net.one97.paytm.o2o.movies.common.movies.search.CJRSessionDatesData r2 = r0.getData()
            if (r2 == 0) goto L_0x00b8
            net.one97.paytm.o2o.movies.utils.i r4 = net.one97.paytm.o2o.movies.utils.i.a()
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r3)
            java.util.ArrayList<java.lang.String> r4 = r4.j
            r2.f75187a = r4
        L_0x00b8:
            net.one97.paytm.o2o.movies.utils.i r2 = net.one97.paytm.o2o.movies.utils.i.a()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            net.one97.paytm.o2o.movies.common.movies.search.CJRSessionDatesData r4 = r0.getData()
            if (r4 == 0) goto L_0x00c8
            java.util.ArrayList<java.lang.String> r4 = r4.f75187a
            goto L_0x00c9
        L_0x00c8:
            r4 = r1
        L_0x00c9:
            r2.j = r4
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieMeta r2 = r0.getMeta()
            if (r2 == 0) goto L_0x00e1
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieMeta r4 = r0.getMeta()
            if (r4 == 0) goto L_0x00da
            java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeListItem> r4 = r4.f75174a
            goto L_0x00db
        L_0x00da:
            r4 = r1
        L_0x00db:
            java.util.ArrayList r4 = a(r4)
            r2.f75174a = r4
        L_0x00e1:
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaDetailV2 r2 = new net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaDetailV2
            r2.<init>()
            net.one97.paytm.o2o.movies.common.movies.search.CJRSessionDatesData r4 = r0.getData()
            if (r4 == 0) goto L_0x00ef
            java.lang.Integer r4 = r4.f75189c
            goto L_0x00f0
        L_0x00ef:
            r4 = r1
        L_0x00f0:
            if (r4 != 0) goto L_0x00f5
            kotlin.g.b.k.a()
        L_0x00f5:
            int r4 = r4.intValue()
            r2.pageSize = r4
            net.one97.paytm.o2o.movies.common.movies.search.CJRSessionDatesData r4 = r0.getData()
            if (r4 == 0) goto L_0x0105
            java.util.ArrayList<java.lang.Integer> r4 = r4.f75188b
            if (r4 != 0) goto L_0x0106
        L_0x0105:
            r4 = r1
        L_0x0106:
            r2.cinemasOrder = r4
            java.util.LinkedHashMap r4 = new java.util.LinkedHashMap
            r4.<init>()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.LinkedHashMap r6 = new java.util.LinkedHashMap
            r6.<init>()
            net.one97.paytm.o2o.movies.common.movies.search.OrderedMap r7 = new net.one97.paytm.o2o.movies.common.movies.search.OrderedMap
            r7.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.List r8 = (java.util.List) r8
            r7.setCinemaIds(r8)
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieMeta r8 = r0.getMeta()
            if (r8 == 0) goto L_0x018e
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieMeta r8 = r0.getMeta()
            if (r8 == 0) goto L_0x0135
            java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeListItem> r8 = r8.f75174a
            goto L_0x0136
        L_0x0135:
            r8 = r1
        L_0x0136:
            if (r8 == 0) goto L_0x018e
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieMeta r8 = r0.getMeta()
            if (r8 != 0) goto L_0x0141
            kotlin.g.b.k.a()
        L_0x0141:
            java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeListItem> r8 = r8.f75174a
            if (r8 != 0) goto L_0x0148
            kotlin.g.b.k.a()
        L_0x0148:
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r8 = r8.iterator()
        L_0x014e:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x018e
            java.lang.Object r9 = r8.next()
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeListItem r9 = (net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeListItem) r9
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieDetailList r10 = new net.one97.paytm.o2o.movies.common.movies.search.CJRMovieDetailList
            r10.<init>()
            java.lang.String r11 = r9.getId()
            if (r11 != 0) goto L_0x0168
            kotlin.g.b.k.a()
        L_0x0168:
            r10.setCode(r11)
            net.one97.paytm.o2o.movies.common.movies.search.CJRSessionDatesData r11 = r0.getData()
            if (r11 == 0) goto L_0x0174
            java.util.ArrayList<java.lang.String> r11 = r11.f75187a
            goto L_0x0175
        L_0x0174:
            r11 = r1
        L_0x0175:
            java.util.List r11 = (java.util.List) r11
            r10.setSessionDates(r11)
            r5.add(r10)
            java.lang.String r10 = r9.getId()
            if (r10 != 0) goto L_0x0186
            kotlin.g.b.k.a()
        L_0x0186:
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaV2 r9 = a(r9, r9, r0)
            r4.put(r10, r9)
            goto L_0x014e
        L_0x018e:
            r2.setMovies(r4)
            java.util.List r5 = (java.util.List) r5
            r2.setMovieList(r5)
            r5 = r19
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r8 = android.text.TextUtils.isEmpty(r5)
            r9 = 0
            if (r8 == 0) goto L_0x01b4
            net.one97.paytm.o2o.movies.common.movies.search.CJRSessionDatesData r8 = r0.getData()
            if (r8 == 0) goto L_0x01b2
            java.util.ArrayList<java.lang.String> r8 = r8.f75187a
            if (r8 == 0) goto L_0x01b2
            java.lang.Object r8 = r8.get(r9)
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x01b6
        L_0x01b2:
            r8 = r1
            goto L_0x01b6
        L_0x01b4:
            r8 = r19
        L_0x01b6:
            net.one97.paytm.o2o.movies.utils.i r10 = net.one97.paytm.o2o.movies.utils.i.a()
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r3)
            java.util.HashMap<java.lang.String, net.one97.paytm.o2o.movies.common.movies.search.OrderedMap> r10 = r10.f75939i
            java.lang.Object r10 = r10.get(r8)
            net.one97.paytm.o2o.movies.common.movies.search.OrderedMap r10 = (net.one97.paytm.o2o.movies.common.movies.search.OrderedMap) r10
            if (r10 != 0) goto L_0x0200
            net.one97.paytm.o2o.movies.common.movies.search.CJRSessionDatesData r10 = r0.getData()
            if (r10 == 0) goto L_0x01f3
            java.util.ArrayList<java.lang.Integer> r10 = r10.f75188b
            if (r10 == 0) goto L_0x01f3
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.Iterator r10 = r10.iterator()
        L_0x01d7:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x01f3
            java.lang.Object r11 = r10.next()
            java.lang.Number r11 = (java.lang.Number) r11
            int r11 = r11.intValue()
            java.util.List r12 = r7.getCinemaIds()
            java.lang.String r11 = java.lang.String.valueOf(r11)
            r12.add(r11)
            goto L_0x01d7
        L_0x01f3:
            net.one97.paytm.o2o.movies.utils.i r10 = net.one97.paytm.o2o.movies.utils.i.a()
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r3)
            java.util.HashMap<java.lang.String, net.one97.paytm.o2o.movies.common.movies.search.OrderedMap> r10 = r10.f75939i
            r10.put(r8, r7)
            goto L_0x0201
        L_0x0200:
            r7 = r10
        L_0x0201:
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieMeta r8 = r0.getMeta()
            if (r8 == 0) goto L_0x02ea
            java.util.ArrayList<net.one97.paytm.o2o.movies.entity.CJRCinemas> r8 = r8.f75175b
            if (r8 == 0) goto L_0x02ea
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r8 = r8.iterator()
        L_0x0211:
            boolean r10 = r8.hasNext()
            if (r10 == 0) goto L_0x02ea
            java.lang.Object r10 = r8.next()
            net.one97.paytm.o2o.movies.entity.CJRCinemas r10 = (net.one97.paytm.o2o.movies.entity.CJRCinemas) r10
            java.lang.Integer r11 = r10.getPaytmCinemaId()
            java.lang.String r11 = java.lang.String.valueOf(r11)
            java.util.Set r12 = r4.keySet()
            java.lang.String r13 = "linkedHashMap.keys"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r13)
            net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaV2 r13 = new net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaV2
            r13.<init>()
            if (r10 == 0) goto L_0x023a
            java.lang.Integer r14 = r10.getPaytmCinemaId()
            goto L_0x023b
        L_0x023a:
            r14 = r1
        L_0x023b:
            java.lang.String r14 = java.lang.String.valueOf(r14)
            r13.setId(r14)
            if (r10 == 0) goto L_0x0251
            java.lang.Double r16 = r10.getLatitude()
            if (r16 == 0) goto L_0x0251
            double r16 = r16.doubleValue()
            r14 = r16
            goto L_0x0253
        L_0x0251:
            r14 = 0
        L_0x0253:
            r13.setLatitude(r14)
            if (r10 == 0) goto L_0x0263
            java.lang.Double r14 = r10.getLongitude()
            if (r14 == 0) goto L_0x0263
            double r14 = r14.doubleValue()
            goto L_0x0265
        L_0x0263:
            r14 = 0
        L_0x0265:
            r13.setLongitude(r14)
            if (r10 == 0) goto L_0x026f
            java.lang.String r14 = r10.getAddress()
            goto L_0x0270
        L_0x026f:
            r14 = r1
        L_0x0270:
            r13.setAddress(r14)
            if (r10 == 0) goto L_0x027a
            java.lang.String r14 = r10.getAppCovrImgUrl()
            goto L_0x027b
        L_0x027a:
            r14 = r1
        L_0x027b:
            r13.setAppCoverImageUrl(r14)
            if (r10 == 0) goto L_0x0285
            java.lang.String r14 = r10.getCovrImgUrl()
            goto L_0x0286
        L_0x0285:
            r14 = r1
        L_0x0286:
            r13.setCoverImageUrl(r14)
            if (r10 == 0) goto L_0x0290
            java.lang.String r14 = r10.getChainLogoUrl()
            goto L_0x0291
        L_0x0290:
            r14 = r1
        L_0x0291:
            r13.setProviderChain(r14)
            if (r10 == 0) goto L_0x029b
            java.lang.String r14 = r10.getName()
            goto L_0x029c
        L_0x029b:
            r14 = r1
        L_0x029c:
            r13.setName(r14)
            if (r10 == 0) goto L_0x02b1
            java.lang.Long r14 = r10.getProviderId()
            if (r14 == 0) goto L_0x02b1
            long r14 = r14.longValue()
            int r15 = (int) r14
            java.lang.Integer r14 = java.lang.Integer.valueOf(r15)
            goto L_0x02b2
        L_0x02b1:
            r14 = r1
        L_0x02b2:
            r13.setProviderId(r14)
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.util.List r12 = kotlin.a.k.e(r12)
            r13.setMovies(r12)
            if (r10 == 0) goto L_0x02c6
            java.util.ArrayList r12 = r10.getPromos()
            if (r12 != 0) goto L_0x02c7
        L_0x02c6:
            r12 = r1
        L_0x02c7:
            r13.offerList = r12
            net.one97.paytm.o2o.movies.utils.d r12 = net.one97.paytm.o2o.movies.utils.d.f75921a
            if (r10 == 0) goto L_0x02d2
            java.util.HashMap r10 = r10.getAmenitiesMap()
            goto L_0x02d3
        L_0x02d2:
            r10 = r1
        L_0x02d3:
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieMeta r12 = r0.getMeta()
            if (r12 == 0) goto L_0x02dc
            java.util.ArrayList<net.one97.paytm.o2o.movies.entity.CJRAmenity> r12 = r12.f75177d
            goto L_0x02dd
        L_0x02dc:
            r12 = r1
        L_0x02dd:
            java.util.List r12 = (java.util.List) r12
            java.util.ArrayList r10 = net.one97.paytm.o2o.movies.utils.d.a((java.util.HashMap<java.lang.String, java.lang.Integer>) r10, (java.util.List<net.one97.paytm.o2o.movies.entity.CJRAmenity>) r12)
            r13.amenities = r10
            r6.put(r11, r13)
            goto L_0x0211
        L_0x02ea:
            r2.setCinemas(r6)
            r2.setOrderedMap(r7)
            r2.setMovies(r4)
            boolean r4 = android.text.TextUtils.isEmpty(r5)
            if (r4 == 0) goto L_0x030e
            if (r0 == 0) goto L_0x030c
            net.one97.paytm.o2o.movies.common.movies.search.CJRSessionDatesData r4 = r0.getData()
            if (r4 == 0) goto L_0x030c
            java.util.ArrayList<java.lang.String> r4 = r4.f75187a
            if (r4 == 0) goto L_0x030c
            java.lang.Object r4 = r4.get(r9)
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0310
        L_0x030c:
            r4 = r1
            goto L_0x0310
        L_0x030e:
            r4 = r19
        L_0x0310:
            if (r0 == 0) goto L_0x0463
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieMeta r0 = r0.getMeta()
            if (r0 == 0) goto L_0x0463
            net.one97.paytm.o2o.movies.common.movies.search.CJRFilterData r0 = r0.f75176c
            if (r0 == 0) goto L_0x0463
            net.one97.paytm.o2o.movies.common.movies.CJRMovieDateWiseFactor r5 = new net.one97.paytm.o2o.movies.common.movies.CJRMovieDateWiseFactor
            r5.<init>()
            java.lang.Double r6 = r0.f75168d
            java.lang.String r7 = "slider"
            if (r6 == 0) goto L_0x0374
            java.lang.Number r6 = (java.lang.Number) r6
            r6.doubleValue()
            net.one97.paytm.o2o.movies.common.movies.CJRMovieShowTimeSearchFilterItem r6 = new net.one97.paytm.o2o.movies.common.movies.CJRMovieShowTimeSearchFilterItem
            r6.<init>()
            r5.price = r6
            net.one97.paytm.o2o.movies.common.movies.CJRMovieShowTimeSearchFilterItem r6 = r5.price
            java.lang.String r8 = "price"
            r6.title = r8
            net.one97.paytm.o2o.movies.common.movies.CJRMovieShowTimeSearchFilterItem r6 = r5.price
            r8 = 100
            r6.interval = r8
            net.one97.paytm.o2o.movies.common.movies.CJRMovieShowTimeSearchFilterItem r6 = r5.price
            java.lang.Double r8 = r0.f75168d
            if (r8 == 0) goto L_0x0355
            java.lang.Number r8 = (java.lang.Number) r8
            double r10 = r8.doubleValue()
            int r8 = kotlin.h.a.a((double) r10)
            java.lang.String r8 = java.lang.String.valueOf(r8)
            goto L_0x0356
        L_0x0355:
            r8 = r1
        L_0x0356:
            r6.maxVal = r8
            net.one97.paytm.o2o.movies.common.movies.CJRMovieShowTimeSearchFilterItem r6 = r5.price
            java.lang.Double r8 = r0.f75167c
            if (r8 == 0) goto L_0x036d
            java.lang.Number r8 = (java.lang.Number) r8
            double r10 = r8.doubleValue()
            int r8 = kotlin.h.a.a((double) r10)
            java.lang.String r8 = java.lang.String.valueOf(r8)
            goto L_0x036e
        L_0x036d:
            r8 = r1
        L_0x036e:
            r6.minVal = r8
            net.one97.paytm.o2o.movies.common.movies.CJRMovieShowTimeSearchFilterItem r6 = r5.price
            r6.uiType = r7
        L_0x0374:
            java.lang.String r6 = r0.f75166b
            if (r6 == 0) goto L_0x03fc
            net.one97.paytm.o2o.movies.common.movies.CJRMovieShowTimeSearchFilterItem r6 = new net.one97.paytm.o2o.movies.common.movies.CJRMovieShowTimeSearchFilterItem
            r6.<init>()
            r5.showTime = r6
            net.one97.paytm.o2o.movies.common.movies.CJRMovieShowTimeSearchFilterItem r6 = r5.showTime
            java.lang.String r8 = "showTime"
            r6.title = r8
            net.one97.paytm.o2o.movies.common.movies.CJRMovieShowTimeSearchFilterItem r6 = r5.showTime
            r8 = 60
            r6.interval = r8
            java.lang.String r6 = r0.f75166b
            if (r6 != 0) goto L_0x0393
            kotlin.g.b.k.a()
        L_0x0393:
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            java.lang.String r8 = ":00.000Z"
            r10 = r8
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            boolean r6 = kotlin.m.p.a((java.lang.CharSequence) r6, (java.lang.CharSequence) r10, (boolean) r9)
            java.lang.String r9 = "T"
            if (r6 != 0) goto L_0x03c5
            net.one97.paytm.o2o.movies.common.movies.CJRMovieShowTimeSearchFilterItem r6 = r5.showTime
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r4)
            r10.append(r9)
            java.lang.String r11 = r0.f75166b
            if (r11 == 0) goto L_0x03b8
            java.lang.String r11 = r11.toString()
            goto L_0x03b9
        L_0x03b8:
            r11 = r1
        L_0x03b9:
            r10.append(r11)
            r10.append(r8)
            java.lang.String r10 = r10.toString()
            r6.maxVal = r10
        L_0x03c5:
            java.lang.String r6 = r0.f75165a
            if (r6 != 0) goto L_0x03cc
            kotlin.g.b.k.a()
        L_0x03cc:
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r10 = r8
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            boolean r6 = kotlin.m.p.a((java.lang.CharSequence) r6, (java.lang.CharSequence) r10, false)
            if (r6 != 0) goto L_0x03f8
            net.one97.paytm.o2o.movies.common.movies.CJRMovieShowTimeSearchFilterItem r6 = r5.showTime
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r4)
            r10.append(r9)
            java.lang.String r9 = r0.f75165a
            if (r9 == 0) goto L_0x03ec
            java.lang.String r1 = r9.toString()
        L_0x03ec:
            r10.append(r1)
            r10.append(r8)
            java.lang.String r1 = r10.toString()
            r6.minVal = r1
        L_0x03f8:
            net.one97.paytm.o2o.movies.common.movies.CJRMovieShowTimeSearchFilterItem r1 = r5.showTime
            r1.uiType = r7
        L_0x03fc:
            java.lang.Boolean r1 = r0.f75169e
            if (r1 != 0) goto L_0x0403
            kotlin.g.b.k.a()
        L_0x0403:
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0423
            net.one97.paytm.o2o.movies.common.movies.CJRMovieShowTimeSearchFilterItem r1 = new net.one97.paytm.o2o.movies.common.movies.CJRMovieShowTimeSearchFilterItem
            r1.<init>()
            r5.premium = r1
            net.one97.paytm.o2o.movies.common.movies.CJRMovieShowTimeSearchFilterItem r1 = r5.premium
            java.lang.String r6 = "premium"
            r1.title = r6
            net.one97.paytm.o2o.movies.common.movies.CJRMovieShowTimeSearchFilterItem r1 = r5.premium
            java.lang.String r6 = "toggle"
            r1.uiType = r6
            net.one97.paytm.o2o.movies.common.movies.CJRMovieShowTimeSearchFilterItem r1 = r5.premium
            java.lang.String r6 = "Premium seats include(s) shows in INSIGNIA for INOX, Director's cut & Gold class for PVR, etc."
            r1.description = r6
        L_0x0423:
            java.util.ArrayList<java.lang.String> r0 = r0.f75170f
            if (r0 == 0) goto L_0x043e
            net.one97.paytm.o2o.movies.common.movies.CJRMovieShowTimeSearchFilterItem r1 = new net.one97.paytm.o2o.movies.common.movies.CJRMovieShowTimeSearchFilterItem
            r1.<init>()
            r5.format = r1
            net.one97.paytm.o2o.movies.common.movies.CJRMovieShowTimeSearchFilterItem r1 = r5.format
            java.lang.String r6 = "format"
            r1.title = r6
            net.one97.paytm.o2o.movies.common.movies.CJRMovieShowTimeSearchFilterItem r1 = r5.format
            java.lang.String r6 = "row"
            r1.uiType = r6
            net.one97.paytm.o2o.movies.common.movies.CJRMovieShowTimeSearchFilterItem r1 = r5.format
            r1.listOfVal = r0
        L_0x043e:
            net.one97.paytm.o2o.movies.utils.i r0 = net.one97.paytm.o2o.movies.utils.i.a()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            java.util.HashMap<java.lang.String, net.one97.paytm.o2o.movies.common.movies.CJRMovieDateWiseFactor> r0 = r0.f75938h
            if (r0 != 0) goto L_0x0457
            net.one97.paytm.o2o.movies.utils.i r0 = net.one97.paytm.o2o.movies.utils.i.a()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r0.f75938h = r1
        L_0x0457:
            net.one97.paytm.o2o.movies.utils.i r0 = net.one97.paytm.o2o.movies.utils.i.a()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            java.util.HashMap<java.lang.String, net.one97.paytm.o2o.movies.common.movies.CJRMovieDateWiseFactor> r0 = r0.f75938h
            r0.put(r4, r5)
        L_0x0463:
            net.one97.paytm.o2o.movies.utils.i r0 = net.one97.paytm.o2o.movies.utils.i.a()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            java.util.HashMap<java.lang.String, net.one97.paytm.o2o.movies.common.movies.CJRMovieDateWiseFactor> r0 = r0.f75938h
            r2.setSearchFilters(r0)
            com.paytm.network.model.IJRPaytmDataModel r2 = (com.paytm.network.model.IJRPaytmDataModel) r2
            return r2
        L_0x0472:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.utils.e.a(com.paytm.network.model.IJRPaytmDataModel, java.lang.String):com.paytm.network.model.IJRPaytmDataModel");
    }

    public static ArrayList<CJRMovieHomeListItem> a(ArrayList<CJRMovieHomeListItem> arrayList) {
        ArrayList<GroupFormatObject> scrnFmtList;
        ArrayList<CJRMovieHomeListItem> arrayList2 = new ArrayList<>();
        if (arrayList != null) {
            Iterator<CJRMovieHomeListItem> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                CJRMovieHomeListItem next = it2.next();
                if (!arrayList2.contains(next)) {
                    if (next.getScrnFmtList() == null) {
                        next.setScrnFmtList(new ArrayList());
                        GroupFormatObject groupFormatObject = new GroupFormatObject(next.getId(), next.getScrnFmt());
                        ArrayList<GroupFormatObject> scrnFmtList2 = next.getScrnFmtList();
                        if (scrnFmtList2 == null) {
                            k.a();
                        }
                        scrnFmtList2.add(groupFormatObject);
                    }
                    arrayList2.add(next);
                } else {
                    CJRMovieHomeListItem cJRMovieHomeListItem = arrayList2.get(arrayList2.indexOf(next));
                    k.a((Object) cJRMovieHomeListItem, "newCjrMovieHomeListItems…Of(cjrMovieHomeListItem))");
                    CJRMovieHomeListItem cJRMovieHomeListItem2 = cJRMovieHomeListItem;
                    GroupFormatObject groupFormatObject2 = new GroupFormatObject(next.getId(), next.getScrnFmt());
                    ArrayList<GroupFormatObject> scrnFmtList3 = cJRMovieHomeListItem2.getScrnFmtList();
                    if (!(scrnFmtList3 == null || scrnFmtList3.contains(groupFormatObject2) || (scrnFmtList = cJRMovieHomeListItem2.getScrnFmtList()) == null)) {
                        scrnFmtList.add(groupFormatObject2);
                    }
                }
            }
        }
        return arrayList2;
    }

    private static CJRMovieCinemaV2 a(CJRMovieHomeListItem cJRMovieHomeListItem, CJRMovieHomeListItem cJRMovieHomeListItem2, CJRMovieDataResponse cJRMovieDataResponse) {
        Integer num;
        CJRMovieCinemaV2 cJRMovieCinemaV2 = new CJRMovieCinemaV2();
        cJRMovieCinemaV2.setContentId(cJRMovieHomeListItem2.getContentId());
        cJRMovieCinemaV2.setImageUrl(cJRMovieHomeListItem2.getImgPath());
        cJRMovieCinemaV2.setDisplay(cJRMovieHomeListItem2.getLabel());
        cJRMovieCinemaV2.setTitle(cJRMovieHomeListItem2.getLabel());
        ArrayList<String> grn = cJRMovieHomeListItem2.getGrn();
        String str = "";
        if (grn != null) {
            for (String str2 : grn) {
                if (!TextUtils.isEmpty(str)) {
                    str = str + ", " + str2;
                } else {
                    str = str2;
                }
            }
        }
        cJRMovieCinemaV2.setGenre(str);
        cJRMovieCinemaV2.setCensor(cJRMovieHomeListItem2.getCensor());
        cJRMovieCinemaV2.setDuration(cJRMovieHomeListItem2.getDuration());
        cJRMovieCinemaV2.setUrlForTrailer(cJRMovieHomeListItem2.getTrailer());
        cJRMovieCinemaV2.setLanguage(cJRMovieHomeListItem2.getLang());
        cJRMovieCinemaV2.setSessions(a(cJRMovieHomeListItem, cJRMovieDataResponse));
        cJRMovieCinemaV2.setAppCoverUrl(cJRMovieHomeListItem2.getAppCvrPath());
        cJRMovieCinemaV2.setScreenFormat(cJRMovieHomeListItem2.getScrnFmt());
        cJRMovieCinemaV2.setSoundFormat(cJRMovieHomeListItem2.getSndFmt());
        Integer contentId = cJRMovieHomeListItem2.getContentId();
        boolean z = true;
        if ((contentId == null || contentId.intValue() != 0) && cJRMovieHomeListItem2.getContentId() != null) {
            cJRMovieCinemaV2.setContentAvailable(1);
        }
        RNR rnr = cJRMovieHomeListItem2.getRnr();
        if (rnr != null) {
            Integer num2 = rnr.f75204c;
            if (num2 == null) {
                k.a();
            }
            cJRMovieCinemaV2.setContentAvailable(num2.intValue());
            ArrayList<Rating> arrayList = rnr.f75202a;
            if (arrayList != null) {
                for (Rating rating : arrayList) {
                    String str3 = rating.f75205a;
                    if (str3 != null) {
                        if (str3 == null) {
                            throw new u("null cannot be cast to non-null type java.lang.String");
                        } else if (str3.contentEquals(r3)) {
                            CJRMovieRatings cJRMovieRatings = new CJRMovieRatings();
                            cJRMovieRatings.setImdb(new CJRMovieRating());
                            CJRMovieRating imdb = cJRMovieRatings.getImdb();
                            k.a((Object) imdb, "oldRating.imdb");
                            imdb.setBase_rating(rating.f75206b);
                            CJRMovieRating imdb2 = cJRMovieRatings.getImdb();
                            k.a((Object) imdb2, "oldRating.imdb");
                            imdb2.setRating(rating.f75207c);
                            cJRMovieCinemaV2.setRatings(cJRMovieRatings);
                        }
                    }
                }
            }
        }
        RNR rnr2 = cJRMovieHomeListItem2.getRnr();
        if (rnr2 != null) {
            num = rnr2.f75203b;
        } else {
            num = null;
        }
        if (num == null || num.intValue() != 1) {
            z = false;
        }
        cJRMovieCinemaV2.setReviewAvailable(z);
        return cJRMovieCinemaV2;
    }

    private static ArrayList<CJRMoviesSession> a(CJRMovieHomeListItem cJRMovieHomeListItem, CJRMovieDataResponse cJRMovieDataResponse) {
        HashMap<String, ArrayList<CJRSessionsItem>> hashMap;
        ArrayList<CJRCinemas> arrayList;
        CJRMovieMeta meta;
        ArrayList<CJRCinemas> arrayList2;
        ArrayList<CJRMoviesSession> arrayList3 = new ArrayList<>();
        CJRMovieSessionsPageData pageData = cJRMovieDataResponse.getPageData();
        if (!(pageData == null || (hashMap = pageData.f75178a) == null)) {
            Set<String> keySet = hashMap.keySet();
            k.a((Object) keySet, "keys");
            for (String str : keySet) {
                ArrayList<CJRSessionsItem> arrayList4 = hashMap.get(str);
                if (arrayList4 != null) {
                    for (CJRSessionsItem cJRSessionsItem : arrayList4) {
                        String str2 = cJRSessionsItem.f75195f;
                        if (str2 != null && str2.equals(cJRMovieHomeListItem.getFrmtId())) {
                            CJRCinemas cJRCinemas = new CJRCinemas((String) null, (String) null, (Double) null, (Double) null, (Long) null, (Integer) null, (Integer) null, (HashMap) null, (String) null, (String) null, (String) null, (Integer) null, 0.0d, (Integer) null, (String) null, (Integer) null, (String) null, (Integer) null, (Integer) null, (Boolean) null, (ArrayList) null, 2097151, (g) null);
                            String str3 = cJRSessionsItem.f75193d;
                            CJRCinemas cJRCinemas2 = null;
                            cJRCinemas.setPaytmCinemaId(str3 != null ? Integer.valueOf(Integer.parseInt(str3)) : null);
                            Integer valueOf = (cJRMovieDataResponse == null || (meta = cJRMovieDataResponse.getMeta()) == null || (arrayList2 = meta.f75175b) == null) ? null : Integer.valueOf(arrayList2.indexOf(cJRCinemas));
                            if ((valueOf == null || valueOf.intValue() != -1) && valueOf != null) {
                                CJRMovieMeta meta2 = cJRMovieDataResponse.getMeta();
                                if (!(meta2 == null || (arrayList = meta2.f75175b) == null)) {
                                    cJRCinemas2 = arrayList.get(valueOf.intValue());
                                }
                                arrayList3.add(a(cJRSessionsItem, cJRCinemas2));
                            }
                        }
                    }
                }
            }
        }
        return arrayList3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0076 A[Catch:{ Exception -> 0x0084 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0077 A[Catch:{ Exception -> 0x0084 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x017c  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0192  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession a(net.one97.paytm.o2o.movies.common.movies.search.CJRSessionsItem r8, net.one97.paytm.o2o.movies.entity.CJRCinemas r9) {
        /*
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r0 = new net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession
            r0.<init>()
            r1 = 0
            if (r9 == 0) goto L_0x000d
            java.lang.Double r2 = r9.getLatitude()
            goto L_0x000e
        L_0x000d:
            r2 = r1
        L_0x000e:
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r0.setmLatitude(r2)
            if (r9 == 0) goto L_0x001c
            java.lang.Double r2 = r9.getLongitude()
            goto L_0x001d
        L_0x001c:
            r2 = r1
        L_0x001d:
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r0.setmLongitude(r2)
            java.lang.String r2 = r8.f75193d
            r0.setmCinemaID(r2)
            if (r9 == 0) goto L_0x0030
            java.lang.String r2 = r9.getName()
            goto L_0x0031
        L_0x0030:
            r2 = r1
        L_0x0031:
            r0.setmCinemaName(r2)
            java.lang.String r2 = r8.f75190a
            r0.setmSessionID(r2)
            java.lang.String r2 = r8.f75196g
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            r3 = 0
            if (r2 != 0) goto L_0x0062
            java.lang.String r2 = r8.f75196g
            if (r2 != 0) goto L_0x004b
            kotlin.g.b.k.a()
        L_0x004b:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.String r4 = ":00.000Z"
            r5 = r4
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r2 = kotlin.m.p.a((java.lang.CharSequence) r2, (java.lang.CharSequence) r5, (boolean) r3)
            if (r2 != 0) goto L_0x0062
            java.lang.String r2 = r8.f75196g
            java.lang.String r2 = kotlin.g.b.k.a((java.lang.String) r2, (java.lang.Object) r4)
            r0.setmRealShowDateTime(r2)
            goto L_0x0067
        L_0x0062:
            java.lang.String r2 = r8.f75196g
            r0.setmRealShowDateTime(r2)
        L_0x0067:
            java.lang.String r2 = r8.f75191b
            r0.setmProviderId(r2)
            java.lang.String r2 = r8.f75192c
            r0.setpKey(r2)
            r2 = 1
            java.lang.Integer r4 = r8.n     // Catch:{ Exception -> 0x0084 }
            if (r4 != 0) goto L_0x0077
            goto L_0x007f
        L_0x0077:
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x0084 }
            if (r4 != r2) goto L_0x007f
            r4 = 1
            goto L_0x0080
        L_0x007f:
            r4 = 0
        L_0x0080:
            r0.setmFreeSeating(r4)     // Catch:{ Exception -> 0x0084 }
            goto L_0x0085
        L_0x0084:
        L_0x0085:
            if (r9 == 0) goto L_0x008c
            java.lang.Integer r4 = r9.getFnb()
            goto L_0x008d
        L_0x008c:
            r4 = r1
        L_0x008d:
            if (r4 != 0) goto L_0x0092
            kotlin.g.b.k.a()
        L_0x0092:
            int r4 = r4.intValue()
            r0.setmIsFoodAvailable(r4)
            java.lang.Integer r4 = r8.n
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r0.setStype(r4)
            if (r8 == 0) goto L_0x00a7
            java.lang.String r4 = r8.f75194e
            goto L_0x00a8
        L_0x00a7:
            r4 = r1
        L_0x00a8:
            r0.setMovieCode(r4)
            java.lang.String r4 = r8.f75195f
            r0.setFrmtId(r4)
            java.lang.String r4 = r8.q
            r0.setScreenFormat(r4)
            if (r9 == 0) goto L_0x00bc
            java.lang.String r4 = r9.getBCode()
            goto L_0x00bd
        L_0x00bc:
            r4 = r1
        L_0x00bd:
            r0.setmBranchCode(r4)
            if (r9 == 0) goto L_0x00c7
            java.lang.String r4 = r9.getAddress()
            goto L_0x00c8
        L_0x00c7:
            r4 = r1
        L_0x00c8:
            r0.setmAddress(r4)
            java.lang.Integer r4 = r8.p
            if (r4 != 0) goto L_0x00d2
            kotlin.g.b.k.a()
        L_0x00d2:
            int r4 = r4.intValue()
            r0.setmMaxTickets(r4)
            java.lang.String r4 = r8.j
            r0.setmAudi(r4)
            java.lang.Integer r4 = r8.m
            if (r4 != 0) goto L_0x00e5
            kotlin.g.b.k.a()
        L_0x00e5:
            int r4 = r4.intValue()
            r0.setmTokenFeePickupTime(r4)
            java.lang.Integer r4 = r8.o
            if (r4 != 0) goto L_0x00f1
            goto L_0x00f8
        L_0x00f1:
            int r4 = r4.intValue()
            if (r4 != r2) goto L_0x00f8
            goto L_0x00f9
        L_0x00f8:
            r2 = 0
        L_0x00f9:
            r0.setmTokenFeeOnly(r2)
            java.lang.Integer r2 = r9.getMTkt()
            if (r2 == 0) goto L_0x010b
            int r2 = r2.intValue()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            goto L_0x010c
        L_0x010b:
            r2 = r1
        L_0x010c:
            r0.setmMultipleTickets(r2)
            java.lang.Integer r2 = r8.k
            if (r2 != 0) goto L_0x0116
            kotlin.g.b.k.a()
        L_0x0116:
            int r2 = r2.intValue()
            r0.setIsPremium(r2)
            java.lang.String r2 = r8.l
            r0.setPremiumLabel(r2)
            java.lang.Integer r2 = r8.k
            if (r2 != 0) goto L_0x0129
            kotlin.g.b.k.a()
        L_0x0129:
            int r2 = r2.intValue()
            r0.setDisplayPremiumLabel(r2)
            if (r9 == 0) goto L_0x0137
            java.lang.Integer r9 = r9.getFnb()
            goto L_0x0138
        L_0x0137:
            r9 = r1
        L_0x0138:
            if (r9 != 0) goto L_0x013d
            kotlin.g.b.k.a()
        L_0x013d:
            int r9 = r9.intValue()
            r0.setmIsFoodMandatoryVoucer(r9)
            java.lang.String r9 = r8.f75193d
            java.lang.String r9 = java.lang.String.valueOf(r9)
            r0.setmCinemaID(r9)
            java.lang.String r9 = r8.f75190a
            r0.setmSessionID(r9)
            java.lang.String r9 = r8.r
            r0.colorCode = r9
            java.lang.String r9 = r8.f75197h
            if (r9 == 0) goto L_0x0163
            int r9 = java.lang.Integer.parseInt(r9)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            goto L_0x0164
        L_0x0163:
            r9 = r1
        L_0x0164:
            if (r9 != 0) goto L_0x0169
            kotlin.g.b.k.a()
        L_0x0169:
            int r9 = r9.intValue()
            r0.totalSeats = r9
            java.lang.String r9 = r8.f75198i
            if (r9 == 0) goto L_0x017c
            int r9 = java.lang.Integer.parseInt(r9)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            goto L_0x017d
        L_0x017c:
            r9 = r1
        L_0x017d:
            if (r9 != 0) goto L_0x0182
            kotlin.g.b.k.a()
        L_0x0182:
            int r9 = r9.intValue()
            r0.setmSeatsAvailable(r9)
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.search.CJRArea> r2 = r8.s
            if (r2 == 0) goto L_0x0211
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x0198:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0211
            java.lang.Object r3 = r2.next()
            net.one97.paytm.o2o.movies.common.movies.search.CJRArea r3 = (net.one97.paytm.o2o.movies.common.movies.search.CJRArea) r3
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSessionDetails r4 = new net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSessionDetails
            r4.<init>()
            java.lang.String r5 = r3.f75157a
            r4.mAreaCatCode = r5
            java.lang.String r5 = r8.f75198i
            if (r5 == 0) goto L_0x01ba
            int r5 = java.lang.Integer.parseInt(r5)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            goto L_0x01bb
        L_0x01ba:
            r5 = r1
        L_0x01bb:
            if (r5 != 0) goto L_0x01c0
            kotlin.g.b.k.a()
        L_0x01c0:
            int r5 = r5.intValue()
            r4.mSeatsAvailable = r5
            java.lang.String r5 = r8.f75197h
            if (r5 == 0) goto L_0x01d3
            int r5 = java.lang.Integer.parseInt(r5)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            goto L_0x01d4
        L_0x01d3:
            r5 = r1
        L_0x01d4:
            if (r5 != 0) goto L_0x01d9
            kotlin.g.b.k.a()
        L_0x01d9:
            int r5 = r5.intValue()
            r4.mTotalSeats = r5
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesPriceDetails r5 = new net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesPriceDetails
            r5.<init>()
            r4.mMoviesPriceDetails = r5
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesPriceDetails r5 = r4.mMoviesPriceDetails
            java.lang.String r6 = r3.f75159c
            r5.mTypeCode = r6
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesPriceDetails r5 = r4.mMoviesPriceDetails
            java.lang.String r6 = r3.f75158b
            r5.mTypeDescription = r6
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesPriceDetails r5 = r4.mMoviesPriceDetails
            java.lang.Double r3 = r3.f75160d
            if (r3 == 0) goto L_0x0201
            double r6 = r3.doubleValue()
            java.lang.Double r3 = java.lang.Double.valueOf(r6)
            goto L_0x0202
        L_0x0201:
            r3 = r1
        L_0x0202:
            if (r3 != 0) goto L_0x0207
            kotlin.g.b.k.a()
        L_0x0207:
            double r6 = r3.doubleValue()
            r5.mPrice = r6
            r9.add(r4)
            goto L_0x0198
        L_0x0211:
            r0.setmMoviesSessionDetails(r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.utils.e.a(net.one97.paytm.o2o.movies.common.movies.search.CJRSessionsItem, net.one97.paytm.o2o.movies.entity.CJRCinemas):net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession");
    }
}
