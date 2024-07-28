package net.one97.paytm.o2o.movies.utils;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.o2o.movies.common.movies.search.CJRAmenity;
import net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaDataResponse;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaV2;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeListItem;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieRating;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieRatings;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession;
import net.one97.paytm.o2o.movies.common.movies.search.CJRSessionsItem;
import net.one97.paytm.o2o.movies.common.movies.search.CJRSessionsPageData;
import net.one97.paytm.o2o.movies.common.movies.search.RNR;
import net.one97.paytm.o2o.movies.common.movies.search.Rating;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f75921a = new d();

    private d() {
    }

    public static ArrayList<CJRAmenity> a(HashMap<String, Integer> hashMap, List<net.one97.paytm.o2o.movies.entity.CJRAmenity> list) {
        ArrayList<CJRAmenity> arrayList = new ArrayList<>();
        if (!(list == null || hashMap == null)) {
            for (String next : hashMap.keySet()) {
                net.one97.paytm.o2o.movies.entity.CJRAmenity cJRAmenity = new net.one97.paytm.o2o.movies.entity.CJRAmenity((Integer) null, (String) null, (String) null, (Integer) null, 15, (g) null);
                cJRAmenity.setAmenityId(Integer.valueOf(next));
                net.one97.paytm.o2o.movies.entity.CJRAmenity cJRAmenity2 = list.get(list.indexOf(cJRAmenity));
                CJRAmenity cJRAmenity3 = new CJRAmenity();
                cJRAmenity3.setAmenity(cJRAmenity2.getAmenity());
                Integer amenityId = cJRAmenity2.getAmenityId();
                if (amenityId == null) {
                    k.a();
                }
                cJRAmenity3.setAmenityId(amenityId.intValue());
                Integer num = hashMap.get(next);
                if (num == null) {
                    k.a();
                }
                cJRAmenity3.setStatus(num.intValue());
                Integer rank = cJRAmenity2.getRank();
                if (rank == null) {
                    k.a();
                }
                cJRAmenity3.rank = rank.intValue();
                arrayList.add(cJRAmenity3);
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0075, code lost:
        r4 = r4.f75162b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.LinkedHashMap<java.lang.String, net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaV2> a(net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaDataResponse r12, net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaDetailV2 r13) {
        /*
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
            r1.<init>()
            net.one97.paytm.o2o.movies.common.movies.search.OrderedMap r2 = new net.one97.paytm.o2o.movies.common.movies.search.OrderedMap
            r2.<init>()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaMeta r4 = r12.getMeta()
            r5 = 0
            if (r4 == 0) goto L_0x0059
            java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeListItem> r4 = r4.f75161a
            if (r4 == 0) goto L_0x0059
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.Iterator r4 = r4.iterator()
        L_0x0025:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x0059
            java.lang.Object r6 = r4.next()
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeListItem r6 = (net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeListItem) r6
            java.lang.String r7 = r6.getId()
            if (r7 == 0) goto L_0x0025
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieDetailList r8 = new net.one97.paytm.o2o.movies.common.movies.search.CJRMovieDetailList
            r8.<init>()
            r8.setCode(r7)
            net.one97.paytm.o2o.movies.common.movies.search.CJRSessionDatesData r9 = r12.getData()
            if (r9 == 0) goto L_0x0048
            java.util.ArrayList<java.lang.String> r9 = r9.f75187a
            goto L_0x0049
        L_0x0048:
            r9 = r5
        L_0x0049:
            java.util.List r9 = (java.util.List) r9
            r8.setSessionDates(r9)
            r3.add(r8)
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaV2 r6 = a((net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeListItem) r6, (net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeListItem) r6, (net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaDataResponse) r12)
            r0.put(r7, r6)
            goto L_0x0025
        L_0x0059:
            r13.setMovies(r0)
            java.util.List r3 = (java.util.List) r3
            r13.setMovieList(r3)
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.List r3 = (java.util.List) r3
            r2.setCinemaIds(r3)
            java.util.List r3 = r2.getCinemaIds()
            net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaMeta r4 = r12.getMeta()
            if (r4 == 0) goto L_0x007e
            net.one97.paytm.o2o.movies.entity.CJRCinemas r4 = r4.f75162b
            if (r4 == 0) goto L_0x007e
            java.lang.Integer r4 = r4.getPaytmCinemaId()
            goto L_0x007f
        L_0x007e:
            r4 = r5
        L_0x007f:
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r3.add(r4)
            net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaMeta r3 = r12.getMeta()
            if (r3 == 0) goto L_0x0095
            net.one97.paytm.o2o.movies.entity.CJRCinemas r3 = r3.f75162b
            if (r3 == 0) goto L_0x0095
            java.lang.Integer r3 = r3.getPaytmCinemaId()
            goto L_0x0096
        L_0x0095:
            r3 = r5
        L_0x0096:
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.util.Set r4 = r0.keySet()
            if (r12 == 0) goto L_0x00a9
            net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaMeta r6 = r12.getMeta()
            if (r6 == 0) goto L_0x00a9
            net.one97.paytm.o2o.movies.entity.CJRCinemas r6 = r6.f75162b
            goto L_0x00aa
        L_0x00a9:
            r6 = r5
        L_0x00aa:
            net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaV2 r7 = new net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaV2
            r7.<init>()
            if (r6 == 0) goto L_0x00b6
            java.lang.Integer r8 = r6.getPaytmCinemaId()
            goto L_0x00b7
        L_0x00b6:
            r8 = r5
        L_0x00b7:
            java.lang.String r8 = java.lang.String.valueOf(r8)
            r7.setId(r8)
            r8 = 0
            if (r6 == 0) goto L_0x00cd
            java.lang.Double r10 = r6.getLatitude()
            if (r10 == 0) goto L_0x00cd
            double r10 = r10.doubleValue()
            goto L_0x00ce
        L_0x00cd:
            r10 = r8
        L_0x00ce:
            r7.setLatitude(r10)
            if (r6 == 0) goto L_0x00dd
            java.lang.Double r10 = r6.getLongitude()
            if (r10 == 0) goto L_0x00dd
            double r8 = r10.doubleValue()
        L_0x00dd:
            r7.setLongitude(r8)
            if (r6 == 0) goto L_0x00e7
            java.lang.String r8 = r6.getAddress()
            goto L_0x00e8
        L_0x00e7:
            r8 = r5
        L_0x00e8:
            r7.setAddress(r8)
            if (r6 == 0) goto L_0x00f2
            java.lang.String r8 = r6.getAppCovrImgUrl()
            goto L_0x00f3
        L_0x00f2:
            r8 = r5
        L_0x00f3:
            r7.setAppCoverImageUrl(r8)
            if (r6 == 0) goto L_0x00fd
            java.lang.String r8 = r6.getCovrImgUrl()
            goto L_0x00fe
        L_0x00fd:
            r8 = r5
        L_0x00fe:
            r7.setCoverImageUrl(r8)
            if (r6 == 0) goto L_0x0108
            java.lang.String r8 = r6.getChainLogoUrl()
            goto L_0x0109
        L_0x0108:
            r8 = r5
        L_0x0109:
            r7.setProviderChain(r8)
            if (r6 == 0) goto L_0x0113
            java.lang.String r8 = r6.getName()
            goto L_0x0114
        L_0x0113:
            r8 = r5
        L_0x0114:
            r7.setName(r8)
            if (r6 == 0) goto L_0x0129
            java.lang.Long r8 = r6.getProviderId()
            if (r8 == 0) goto L_0x0129
            long r8 = r8.longValue()
            int r9 = (int) r8
            java.lang.Integer r8 = java.lang.Integer.valueOf(r9)
            goto L_0x012a
        L_0x0129:
            r8 = r5
        L_0x012a:
            r7.setProviderId(r8)
            if (r4 == 0) goto L_0x0136
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.List r4 = kotlin.a.k.e(r4)
            goto L_0x0137
        L_0x0136:
            r4 = r5
        L_0x0137:
            r7.setMovies(r4)
            if (r6 == 0) goto L_0x0141
            java.util.HashMap r4 = r6.getAmenitiesMap()
            goto L_0x0142
        L_0x0141:
            r4 = r5
        L_0x0142:
            if (r12 == 0) goto L_0x014c
            net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaMeta r12 = r12.getMeta()
            if (r12 == 0) goto L_0x014c
            java.util.ArrayList<net.one97.paytm.o2o.movies.entity.CJRAmenity> r5 = r12.f75163c
        L_0x014c:
            java.util.List r5 = (java.util.List) r5
            java.util.ArrayList r12 = a((java.util.HashMap<java.lang.String, java.lang.Integer>) r4, (java.util.List<net.one97.paytm.o2o.movies.entity.CJRAmenity>) r5)
            r7.amenities = r12
            r1.put(r3, r7)
            r13.setCinemas(r1)
            r13.setOrderedMap(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.utils.d.a(net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaDataResponse, net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaDetailV2):java.util.LinkedHashMap");
    }

    private static CJRMovieCinemaV2 a(CJRMovieHomeListItem cJRMovieHomeListItem, CJRMovieHomeListItem cJRMovieHomeListItem2, CJRCinemaDataResponse cJRCinemaDataResponse) {
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
        cJRMovieCinemaV2.setSessions(a(cJRMovieHomeListItem, cJRCinemaDataResponse));
        cJRMovieCinemaV2.setAppCoverUrl(cJRMovieHomeListItem2.getAppCvrPath());
        cJRMovieCinemaV2.setScreenFormat(cJRMovieHomeListItem2.getScrnFmt());
        cJRMovieCinemaV2.setSoundFormat(cJRMovieHomeListItem2.getSndFmt());
        Integer contentId = cJRMovieCinemaV2.getContentId();
        boolean z = true;
        if ((contentId == null || contentId.intValue() != 0) && cJRMovieCinemaV2.getContentId() != null) {
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

    private static ArrayList<CJRMoviesSession> a(CJRMovieHomeListItem cJRMovieHomeListItem, CJRCinemaDataResponse cJRCinemaDataResponse) {
        CJRSessionsPageData pageData;
        ArrayList<CJRSessionsItem> arrayList;
        String str;
        ArrayList<CJRMoviesSession> arrayList2 = new ArrayList<>();
        if (!(cJRCinemaDataResponse == null || (pageData = cJRCinemaDataResponse.getPageData()) == null || (arrayList = pageData.f75199a) == null)) {
            for (CJRSessionsItem cJRSessionsItem : arrayList) {
                if (!(cJRSessionsItem == null || (str = cJRSessionsItem.f75194e) == null || !str.equals(cJRMovieHomeListItem.getId()))) {
                    arrayList2.add(a(cJRMovieHomeListItem, cJRSessionsItem, cJRCinemaDataResponse));
                }
            }
        }
        return arrayList2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000c, code lost:
        r1 = r1.f75162b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01cf  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01e2  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008e A[Catch:{ Exception -> 0x009c }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x008f A[Catch:{ Exception -> 0x009c }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x018a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession a(net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeListItem r7, net.one97.paytm.o2o.movies.common.movies.search.CJRSessionsItem r8, net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaDataResponse r9) {
        /*
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r0 = new net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession
            r0.<init>()
            net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaMeta r1 = r9.getMeta()
            r2 = 0
            if (r1 == 0) goto L_0x0015
            net.one97.paytm.o2o.movies.entity.CJRCinemas r1 = r1.f75162b
            if (r1 == 0) goto L_0x0015
            java.lang.Double r1 = r1.getLatitude()
            goto L_0x0016
        L_0x0015:
            r1 = r2
        L_0x0016:
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r0.setmLatitude(r1)
            net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaMeta r1 = r9.getMeta()
            if (r1 == 0) goto L_0x002c
            net.one97.paytm.o2o.movies.entity.CJRCinemas r1 = r1.f75162b
            if (r1 == 0) goto L_0x002c
            java.lang.Double r1 = r1.getLongitude()
            goto L_0x002d
        L_0x002c:
            r1 = r2
        L_0x002d:
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r0.setmLongitude(r1)
            java.lang.String r1 = r8.f75193d
            r0.setmCinemaID(r1)
            net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaMeta r1 = r9.getMeta()
            if (r1 == 0) goto L_0x0048
            net.one97.paytm.o2o.movies.entity.CJRCinemas r1 = r1.f75162b
            if (r1 == 0) goto L_0x0048
            java.lang.String r1 = r1.getName()
            goto L_0x0049
        L_0x0048:
            r1 = r2
        L_0x0049:
            r0.setmCinemaName(r1)
            java.lang.String r1 = r8.f75190a
            r0.setmSessionID(r1)
            java.lang.String r1 = r8.f75196g
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            r3 = 0
            if (r1 != 0) goto L_0x007a
            java.lang.String r1 = r8.f75196g
            if (r1 != 0) goto L_0x0063
            kotlin.g.b.k.a()
        L_0x0063:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.String r4 = ":00.000Z"
            r5 = r4
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r1 = kotlin.m.p.a((java.lang.CharSequence) r1, (java.lang.CharSequence) r5, (boolean) r3)
            if (r1 != 0) goto L_0x007a
            java.lang.String r1 = r8.f75196g
            java.lang.String r1 = kotlin.g.b.k.a((java.lang.String) r1, (java.lang.Object) r4)
            r0.setmRealShowDateTime(r1)
            goto L_0x007f
        L_0x007a:
            java.lang.String r1 = r8.f75196g
            r0.setmRealShowDateTime(r1)
        L_0x007f:
            java.lang.String r1 = r8.f75191b
            r0.setmProviderId(r1)
            java.lang.String r1 = r8.f75192c
            r0.setpKey(r1)
            r1 = 1
            java.lang.Integer r4 = r8.n     // Catch:{ Exception -> 0x009c }
            if (r4 != 0) goto L_0x008f
            goto L_0x0097
        L_0x008f:
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x009c }
            if (r4 != r1) goto L_0x0097
            r4 = 1
            goto L_0x0098
        L_0x0097:
            r4 = 0
        L_0x0098:
            r0.setmFreeSeating(r4)     // Catch:{ Exception -> 0x009c }
            goto L_0x009d
        L_0x009c:
        L_0x009d:
            net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaMeta r4 = r9.getMeta()
            if (r4 == 0) goto L_0x00ac
            net.one97.paytm.o2o.movies.entity.CJRCinemas r4 = r4.f75162b
            if (r4 == 0) goto L_0x00ac
            java.lang.Integer r4 = r4.getFnb()
            goto L_0x00ad
        L_0x00ac:
            r4 = r2
        L_0x00ad:
            if (r4 != 0) goto L_0x00b2
            kotlin.g.b.k.a()
        L_0x00b2:
            int r4 = r4.intValue()
            r0.setmIsFoodAvailable(r4)
            java.lang.Integer r4 = r8.n
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r0.setStype(r4)
            net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaMeta r4 = r9.getMeta()
            if (r4 == 0) goto L_0x00d1
            net.one97.paytm.o2o.movies.entity.CJRCinemas r4 = r4.f75162b
            if (r4 == 0) goto L_0x00d1
            java.lang.String r4 = r4.getBCode()
            goto L_0x00d2
        L_0x00d1:
            r4 = r2
        L_0x00d2:
            r0.setmBranchCode(r4)
            net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaMeta r4 = r9.getMeta()
            if (r4 == 0) goto L_0x00e4
            net.one97.paytm.o2o.movies.entity.CJRCinemas r4 = r4.f75162b
            if (r4 == 0) goto L_0x00e4
            java.lang.String r4 = r4.getAddress()
            goto L_0x00e5
        L_0x00e4:
            r4 = r2
        L_0x00e5:
            r0.setmAddress(r4)
            java.lang.Integer r4 = r8.p
            if (r4 == 0) goto L_0x00f5
            int r4 = r4.intValue()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            goto L_0x00f6
        L_0x00f5:
            r4 = r2
        L_0x00f6:
            if (r4 != 0) goto L_0x00fb
            kotlin.g.b.k.a()
        L_0x00fb:
            int r4 = r4.intValue()
            r0.setmMaxTickets(r4)
            java.lang.String r4 = r8.j
            r0.setmAudi(r4)
            if (r7 == 0) goto L_0x010e
            java.lang.String r7 = r7.getId()
            goto L_0x010f
        L_0x010e:
            r7 = r2
        L_0x010f:
            r0.setMovieCode(r7)
            java.lang.String r7 = r8.f75195f
            r0.setFrmtId(r7)
            java.lang.String r7 = r8.q
            r0.setScreenFormat(r7)
            java.lang.Integer r7 = r8.m
            if (r7 != 0) goto L_0x0123
            kotlin.g.b.k.a()
        L_0x0123:
            int r7 = r7.intValue()
            r0.setmTokenFeePickupTime(r7)
            java.lang.Integer r7 = r8.o
            if (r7 != 0) goto L_0x012f
            goto L_0x0136
        L_0x012f:
            int r7 = r7.intValue()
            if (r7 != r1) goto L_0x0136
            goto L_0x0137
        L_0x0136:
            r1 = 0
        L_0x0137:
            r0.setmTokenFeeOnly(r1)
            net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaMeta r7 = r9.getMeta()
            if (r7 == 0) goto L_0x0153
            net.one97.paytm.o2o.movies.entity.CJRCinemas r7 = r7.f75162b
            if (r7 == 0) goto L_0x0153
            java.lang.Integer r7 = r7.getMTkt()
            if (r7 == 0) goto L_0x0153
            int r7 = r7.intValue()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            goto L_0x0154
        L_0x0153:
            r7 = r2
        L_0x0154:
            r0.setmMultipleTickets(r7)
            java.lang.Integer r7 = r8.k
            if (r7 != 0) goto L_0x015e
            kotlin.g.b.k.a()
        L_0x015e:
            int r7 = r7.intValue()
            r0.setIsPremium(r7)
            java.lang.String r7 = r8.l
            r0.setPremiumLabel(r7)
            java.lang.Integer r7 = r8.k
            if (r7 != 0) goto L_0x0171
            kotlin.g.b.k.a()
        L_0x0171:
            int r7 = r7.intValue()
            r0.setDisplayPremiumLabel(r7)
            net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaMeta r7 = r9.getMeta()
            if (r7 == 0) goto L_0x0187
            net.one97.paytm.o2o.movies.entity.CJRCinemas r7 = r7.f75162b
            if (r7 == 0) goto L_0x0187
            java.lang.Integer r7 = r7.getFnb()
            goto L_0x0188
        L_0x0187:
            r7 = r2
        L_0x0188:
            if (r7 != 0) goto L_0x018d
            kotlin.g.b.k.a()
        L_0x018d:
            int r7 = r7.intValue()
            r0.setmIsFoodMandatoryVoucer(r7)
            java.lang.String r7 = r8.f75193d
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r0.setmCinemaID(r7)
            java.lang.String r7 = r8.f75190a
            r0.setmSessionID(r7)
            java.lang.String r7 = r8.r
            r0.colorCode = r7
            java.lang.String r7 = r8.f75197h
            if (r7 == 0) goto L_0x01b3
            int r7 = java.lang.Integer.parseInt(r7)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            goto L_0x01b4
        L_0x01b3:
            r7 = r2
        L_0x01b4:
            if (r7 != 0) goto L_0x01b9
            kotlin.g.b.k.a()
        L_0x01b9:
            int r7 = r7.intValue()
            r0.totalSeats = r7
            java.lang.String r7 = r8.f75198i
            if (r7 == 0) goto L_0x01cc
            int r7 = java.lang.Integer.parseInt(r7)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            goto L_0x01cd
        L_0x01cc:
            r7 = r2
        L_0x01cd:
            if (r7 != 0) goto L_0x01d2
            kotlin.g.b.k.a()
        L_0x01d2:
            int r7 = r7.intValue()
            r0.setmSeatsAvailable(r7)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.search.CJRArea> r9 = r8.s
            if (r9 == 0) goto L_0x0261
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.Iterator r9 = r9.iterator()
        L_0x01e8:
            boolean r1 = r9.hasNext()
            if (r1 == 0) goto L_0x0261
            java.lang.Object r1 = r9.next()
            net.one97.paytm.o2o.movies.common.movies.search.CJRArea r1 = (net.one97.paytm.o2o.movies.common.movies.search.CJRArea) r1
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSessionDetails r3 = new net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSessionDetails
            r3.<init>()
            java.lang.String r4 = r1.f75157a
            r3.mAreaCatCode = r4
            java.lang.String r4 = r8.f75198i
            if (r4 == 0) goto L_0x020a
            int r4 = java.lang.Integer.parseInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            goto L_0x020b
        L_0x020a:
            r4 = r2
        L_0x020b:
            if (r4 != 0) goto L_0x0210
            kotlin.g.b.k.a()
        L_0x0210:
            int r4 = r4.intValue()
            r3.mSeatsAvailable = r4
            java.lang.String r4 = r8.f75197h
            if (r4 == 0) goto L_0x0223
            int r4 = java.lang.Integer.parseInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            goto L_0x0224
        L_0x0223:
            r4 = r2
        L_0x0224:
            if (r4 != 0) goto L_0x0229
            kotlin.g.b.k.a()
        L_0x0229:
            int r4 = r4.intValue()
            r3.mTotalSeats = r4
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesPriceDetails r4 = new net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesPriceDetails
            r4.<init>()
            r3.mMoviesPriceDetails = r4
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesPriceDetails r4 = r3.mMoviesPriceDetails
            java.lang.String r5 = r1.f75159c
            r4.mTypeCode = r5
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesPriceDetails r4 = r3.mMoviesPriceDetails
            java.lang.String r5 = r1.f75158b
            r4.mTypeDescription = r5
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesPriceDetails r4 = r3.mMoviesPriceDetails
            java.lang.Double r1 = r1.f75160d
            if (r1 == 0) goto L_0x0251
            double r5 = r1.doubleValue()
            java.lang.Double r1 = java.lang.Double.valueOf(r5)
            goto L_0x0252
        L_0x0251:
            r1 = r2
        L_0x0252:
            if (r1 != 0) goto L_0x0257
            kotlin.g.b.k.a()
        L_0x0257:
            double r5 = r1.doubleValue()
            r4.mPrice = r5
            r7.add(r3)
            goto L_0x01e8
        L_0x0261:
            r0.setmMoviesSessionDetails(r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.utils.d.a(net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeListItem, net.one97.paytm.o2o.movies.common.movies.search.CJRSessionsItem, net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaDataResponse):net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession");
    }
}
