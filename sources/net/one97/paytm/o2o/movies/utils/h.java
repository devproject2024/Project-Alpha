package net.one97.paytm.o2o.movies.utils;

import android.text.TextUtils;
import com.appsflyer.internal.referrer.Payload;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;
import kotlin.a.ae;
import kotlin.a.f;
import kotlin.a.w;
import kotlin.g.b.k;
import kotlin.j.d;
import kotlin.m.p;
import kotlin.o;
import net.one97.paytm.common.entity.CJRSelectCityModel;
import net.one97.paytm.common.entity.movies.search.CJRCityTranslationModel;
import net.one97.paytm.o2o.movies.common.movies.CJRMovieDateWiseFactor;
import net.one97.paytm.o2o.movies.common.movies.CJRMovieShowTimeSearchFilterItem;
import net.one97.paytm.o2o.movies.common.movies.movieslot.CJRMovieDetailsTab;
import net.one97.paytm.o2o.movies.common.movies.movieslot.CJRMovieSessionDetails;
import net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaTranslationModel;
import net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaTranslationModel2;
import net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaV2;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaDetailV2;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaV2;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieDetailList;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeTranslation;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieRatings;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieShowTimeFilterDataStorage;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesPriceDetails;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSessionDetails;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final h f75928a = new h();

    private h() {
    }

    public static final class a<T> implements Comparator<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f75929a;

        public a(List list) {
            this.f75929a = list;
        }

        public final int compare(T t, T t2) {
            String str = (String) t;
            List list = this.f75929a;
            Integer num = null;
            Comparable valueOf = list != null ? Integer.valueOf(list.indexOf(str)) : null;
            String str2 = (String) t2;
            List list2 = this.f75929a;
            if (list2 != null) {
                num = Integer.valueOf(list2.indexOf(str2));
            }
            return kotlin.b.a.a(valueOf, num);
        }
    }

    public static final class b<T> implements Comparator<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f75930a;

        public b(List list) {
            this.f75930a = list;
        }

        public final int compare(T t, T t2) {
            return kotlin.b.a.a(Integer.valueOf(this.f75930a.indexOf(((CJRSelectCityModel) t2).getLabel())), Integer.valueOf(this.f75930a.indexOf(((CJRSelectCityModel) t).getLabel())));
        }
    }

    public static final class c<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            return kotlin.b.a.a(Integer.valueOf(((List) ((o) t2).getSecond()).size()), Integer.valueOf(((List) ((o) t).getSecond()).size()));
        }
    }

    private static CJRMoviesSession a(CJRMovieCinemaDetailV2 cJRMovieCinemaDetailV2, String str, String str2) {
        List<CJRMoviesSession> sessions;
        CJRMovieCinemaV2 cJRMovieCinemaV2 = cJRMovieCinemaDetailV2.getMovies().get(str2);
        CJRMoviesSession cJRMoviesSession = null;
        if (cJRMovieCinemaV2 == null || (sessions = cJRMovieCinemaV2.getSessions()) == null) {
            return null;
        }
        ListIterator<CJRMoviesSession> listIterator = sessions.listIterator(sessions.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                break;
            }
            CJRMoviesSession previous = listIterator.previous();
            CJRMoviesSession cJRMoviesSession2 = previous;
            k.a((Object) cJRMoviesSession2, "it");
            if (p.a(cJRMoviesSession2.getSessionID(), str, true)) {
                cJRMoviesSession = previous;
                break;
            }
        }
        return cJRMoviesSession;
    }

    private static List<CJRMovieDetailsTab> b(List<? extends CJRMovieDetailList> list) {
        List<CJRMovieDetailsTab> arrayList = new ArrayList<>();
        List<String> a2 = a(list);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("Asia/Calcutta"));
        for (String next : a2) {
            k.a((Object) instance, "cal");
            instance.setTime(simpleDateFormat.parse(next));
            CJRMovieDetailsTab cJRMovieDetailsTab = new CJRMovieDetailsTab();
            cJRMovieDetailsTab.setmDate(next);
            cJRMovieDetailsTab.setmDay(String.valueOf(instance.get(5)));
            cJRMovieDetailsTab.setmDayName(instance.getDisplayName(7, 0, Locale.getDefault()));
            arrayList.add(cJRMovieDetailsTab);
        }
        return arrayList;
    }

    public static List<CJRMovieShowTimeSearchFilterItem> a(String str, CJRMovieCinemaDetailV2 cJRMovieCinemaDetailV2) {
        CJRMovieDateWiseFactor cJRMovieDateWiseFactor;
        k.c(str, "mSelectedDate");
        k.c(cJRMovieCinemaDetailV2, "mCJRMovieCinemaDetailV2");
        List<CJRMovieShowTimeSearchFilterItem> arrayList = new ArrayList<>();
        if (cJRMovieCinemaDetailV2.getSearchFilters() == null) {
            return arrayList;
        }
        if ((str.length() == 0) || (cJRMovieDateWiseFactor = cJRMovieCinemaDetailV2.getSearchFilters().get(str)) == null) {
            return arrayList;
        }
        k.a((Object) cJRMovieDateWiseFactor, "mCJRMovieCinemaDetailV2.…te] ?: return mFilterList");
        CJRMovieShowTimeSearchFilterItem cJRMovieShowTimeSearchFilterItem = cJRMovieDateWiseFactor.format;
        if (cJRMovieShowTimeSearchFilterItem == null) {
            return arrayList;
        }
        if (cJRMovieShowTimeSearchFilterItem.listOfVal.size() > 1) {
            arrayList.add(cJRMovieShowTimeSearchFilterItem);
        }
        CJRMovieShowTimeSearchFilterItem cJRMovieShowTimeSearchFilterItem2 = cJRMovieDateWiseFactor.price;
        if (cJRMovieShowTimeSearchFilterItem2 == null) {
            return arrayList;
        }
        arrayList.add(cJRMovieShowTimeSearchFilterItem2);
        CJRMovieShowTimeSearchFilterItem cJRMovieShowTimeSearchFilterItem3 = cJRMovieDateWiseFactor.price;
        if (cJRMovieShowTimeSearchFilterItem3 == null) {
            return arrayList;
        }
        arrayList.add(cJRMovieShowTimeSearchFilterItem3);
        return arrayList;
    }

    private static Map<String, Map<String, List<CJRMoviesSession>>> a(CJRMovieCinemaDetailV2 cJRMovieCinemaDetailV2) {
        LinkedHashMap<String, CJRMovieCinemaV2> movies;
        Collection<CJRMovieCinemaV2> values;
        if (cJRMovieCinemaDetailV2 == null || (movies = cJRMovieCinemaDetailV2.getMovies()) == null || (values = movies.values()) == null) {
            return null;
        }
        Iterable<CJRMovieCinemaV2> iterable = values;
        Collection arrayList = new ArrayList(kotlin.a.k.a(iterable));
        for (CJRMovieCinemaV2 cJRMovieCinemaV2 : iterable) {
            k.a((Object) cJRMovieCinemaV2, "item");
            arrayList.add(cJRMovieCinemaV2.getSessions());
        }
        Map linkedHashMap = new LinkedHashMap();
        for (Object next : kotlin.a.k.b((List) arrayList)) {
            CJRMoviesSession cJRMoviesSession = (CJRMoviesSession) next;
            k.a((Object) cJRMoviesSession, "item");
            String a2 = a(cJRMoviesSession.getRealShowDateTime());
            Object obj = linkedHashMap.get(a2);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(a2, obj);
            }
            ((List) obj).add(next);
        }
        Map linkedHashMap2 = new LinkedHashMap(ae.a(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Object key = entry.getKey();
            Map linkedHashMap3 = new LinkedHashMap();
            for (Object next2 : (Iterable) entry.getValue()) {
                CJRMoviesSession cJRMoviesSession2 = (CJRMoviesSession) next2;
                k.a((Object) cJRMoviesSession2, "data");
                String cinemaID = cJRMoviesSession2.getCinemaID();
                Object obj2 = linkedHashMap3.get(cinemaID);
                if (obj2 == null) {
                    obj2 = new ArrayList();
                    linkedHashMap3.put(cinemaID, obj2);
                }
                ((List) obj2).add(next2);
            }
            linkedHashMap2.put(key, linkedHashMap3);
        }
        return ae.b(linkedHashMap2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x008d, code lost:
        if (java.lang.Integer.parseInt(r12) != 0) goto L_0x008f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0130, code lost:
        if ((r13.getTimeInMillis() >= r12.getTimeInMillis() && r13.getTimeInMillis() <= r10.getTimeInMillis()) != false) goto L_0x0132;
     */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0161 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.util.List<net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession>>> a(net.one97.paytm.o2o.movies.common.movies.search.CJRMovieShowTimeFilterDataStorage r19, java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.util.List<net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession>>> r20) {
        /*
            r0 = r19
            java.lang.String r1 = "filters"
            kotlin.g.b.k.c(r0, r1)
            java.lang.String r1 = "value"
            r2 = r20
            kotlin.g.b.k.c(r2, r1)
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
            r1.<init>()
            java.util.Map r1 = (java.util.Map) r1
            java.util.Set r2 = r20.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x001e:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0188
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r3 = r3.getValue()
            java.util.Map r3 = (java.util.Map) r3
            java.util.LinkedHashMap r5 = new java.util.LinkedHashMap
            r5.<init>()
            java.util.Map r5 = (java.util.Map) r5
            java.util.Set r3 = r3.entrySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x0045:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x0181
            java.lang.Object r6 = r3.next()
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6
            java.lang.Object r7 = r6.getKey()
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r6 = r6.getValue()
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r6 = r6.iterator()
        L_0x0068:
            boolean r9 = r6.hasNext()
            if (r9 == 0) goto L_0x0167
            java.lang.Object r9 = r6.next()
            r11 = r9
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r11 = (net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession) r11
            java.lang.String r12 = r0.f75179a
            java.lang.String r13 = "filters.minPrice"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r13)
            int r12 = java.lang.Integer.parseInt(r12)
            if (r12 != 0) goto L_0x008f
            java.lang.String r12 = r0.f75180b
            java.lang.String r14 = "filters.maxPrice"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r14)
            int r12 = java.lang.Integer.parseInt(r12)
            if (r12 == 0) goto L_0x0095
        L_0x008f:
            boolean r12 = a((net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession) r11, (net.one97.paytm.o2o.movies.common.movies.search.CJRMovieShowTimeFilterDataStorage) r0)
            if (r12 == 0) goto L_0x0156
        L_0x0095:
            long r14 = r0.f75181c
            int r12 = (int) r14
            if (r12 != 0) goto L_0x00a7
            long r14 = r0.f75182d
            int r12 = (int) r14
            if (r12 == 0) goto L_0x00a0
            goto L_0x00a7
        L_0x00a0:
            r17 = r2
            r18 = r3
            r15 = r11
            goto L_0x0132
        L_0x00a7:
            java.util.Calendar r12 = java.util.Calendar.getInstance()
            java.lang.String r14 = "startTime"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r14)
            java.lang.String r14 = "GMT"
            java.util.TimeZone r15 = java.util.TimeZone.getTimeZone(r14)
            r12.setTimeZone(r15)
            r15 = r11
            long r10 = r0.f75181c
            r12.setTimeInMillis(r10)
            java.util.Calendar r10 = java.util.Calendar.getInstance()
            java.lang.String r11 = "endTime"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r11)
            java.util.TimeZone r11 = java.util.TimeZone.getTimeZone(r14)
            r10.setTimeZone(r11)
            r16 = r14
            long r13 = r0.f75182d
            r10.setTimeInMillis(r13)
            java.util.Calendar r13 = java.util.Calendar.getInstance()
            java.lang.String r14 = "sessionTime"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r14)
            java.util.TimeZone r14 = java.util.TimeZone.getTimeZone(r16)
            r13.setTimeZone(r14)
            java.util.Date r14 = r15.getRealDateTime()
            r13.setTime(r14)
            r14 = 1
            int r11 = r13.get(r14)
            r14 = 2
            r17 = r2
            int r2 = r13.get(r14)
            r14 = 5
            r18 = r3
            int r3 = r13.get(r14)
            r12.set(r11, r2, r3)
            r2 = 1
            int r3 = r13.get(r2)
            r2 = 2
            int r2 = r13.get(r2)
            int r11 = r13.get(r14)
            r10.set(r3, r2, r11)
            long r2 = r13.getTimeInMillis()
            long r11 = r12.getTimeInMillis()
            int r14 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r14 < 0) goto L_0x012f
            long r2 = r13.getTimeInMillis()
            long r10 = r10.getTimeInMillis()
            int r12 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r12 > 0) goto L_0x012f
            r2 = 1
            goto L_0x0130
        L_0x012f:
            r2 = 0
        L_0x0130:
            if (r2 == 0) goto L_0x015a
        L_0x0132:
            java.util.ArrayList<java.lang.String> r2 = r0.f75183e
            java.util.List r2 = (java.util.List) r2
            boolean r2 = net.one97.paytm.o2o.movies.common.a.b.a(r2)
            if (r2 != 0) goto L_0x0148
            java.util.ArrayList<java.lang.String> r2 = r0.f75183e
            java.lang.String r3 = r15.getScreenFormat()
            boolean r2 = r2.contains(r3)
            if (r2 == 0) goto L_0x015a
        L_0x0148:
            int r2 = r0.f75185g
            if (r2 == 0) goto L_0x0153
            int r2 = r15.getIsPremium()
            r3 = 1
            if (r2 != r3) goto L_0x015a
        L_0x0153:
            r16 = 1
            goto L_0x015c
        L_0x0156:
            r17 = r2
            r18 = r3
        L_0x015a:
            r16 = 0
        L_0x015c:
            if (r16 == 0) goto L_0x0161
            r8.add(r9)
        L_0x0161:
            r2 = r17
            r3 = r18
            goto L_0x0068
        L_0x0167:
            r17 = r2
            r18 = r3
            java.util.List r8 = (java.util.List) r8
            r2 = r8
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            r3 = 1
            r2 = r2 ^ r3
            if (r2 == 0) goto L_0x017b
            r5.put(r7, r8)
        L_0x017b:
            r2 = r17
            r3 = r18
            goto L_0x0045
        L_0x0181:
            r17 = r2
            r1.put(r4, r5)
            goto L_0x001e
        L_0x0188:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.utils.h.a(net.one97.paytm.o2o.movies.common.movies.search.CJRMovieShowTimeFilterDataStorage, java.util.Map):java.util.Map");
    }

    public static List<CJRMovieSessionDetails> a(CJRMovieCinemaDetailV2 cJRMovieCinemaDetailV2, Map<String, List<CJRMoviesSession>> map, List<String> list) {
        CJRMovieRatings ratings;
        Map<String, List<CJRMoviesSession>> map2 = map;
        k.c(cJRMovieCinemaDetailV2, Payload.RESPONSE);
        k.c(map2, "mSessionMap");
        Collection<CJRMovieCinemaV2> values = cJRMovieCinemaDetailV2.getMovies().values();
        k.a((Object) values, "response.movies.values");
        List e2 = kotlin.a.k.e(values);
        LinkedHashMap<String, CJRCinemaV2> cinemas = cJRMovieCinemaDetailV2.getCinemas();
        Comparator aVar = new a(list);
        k.d(map2, "$this$toSortedMap");
        k.d(aVar, "comparator");
        TreeMap treeMap = new TreeMap(aVar);
        treeMap.putAll(map2);
        Map map3 = treeMap;
        Collection arrayList = new ArrayList(map3.size());
        for (Map.Entry entry : map3.entrySet()) {
            CJRCinemaV2 cJRCinemaV2 = cinemas.get(entry.getKey());
            String name = cJRCinemaV2 != null ? cJRCinemaV2.getName() : null;
            String a2 = a(cinemas.get(entry.getKey()));
            String movieCode = ((CJRMoviesSession) ((List) entry.getValue()).get(0)).getMovieCode();
            CJRMovieCinemaV2 cJRMovieCinemaV2 = (CJRMovieCinemaV2) e2.get(0);
            String imageUrl = cJRMovieCinemaV2 != null ? cJRMovieCinemaV2.getImageUrl() : null;
            CJRMovieCinemaV2 cJRMovieCinemaV22 = (CJRMovieCinemaV2) e2.get(0);
            String censor = cJRMovieCinemaV22 != null ? cJRMovieCinemaV22.getCensor() : null;
            Object obj = e2.get(0);
            k.a(obj, "moviesMap[0]");
            String language = ((CJRMovieCinemaV2) obj).getLanguage();
            String a3 = a((CJRMovieCinemaV2) e2.get(0));
            CJRCinemaV2 cJRCinemaV22 = cinemas.get(entry.getKey());
            String id = cJRCinemaV22 != null ? cJRCinemaV22.getId() : null;
            Object obj2 = e2.get(0);
            k.a(obj2, "moviesMap[0]");
            String display = ((CJRMovieCinemaV2) obj2).getDisplay();
            String b2 = b((CJRMovieCinemaV2) e2.get(0));
            int i2 = 0;
            for (List size : map.values()) {
                i2 += size.size();
            }
            Object obj3 = e2.get(0);
            k.a(obj3, "moviesMap[0]");
            Integer duration = ((CJRMovieCinemaV2) obj3).getDuration();
            k.a((Object) duration, "moviesMap[0].duration");
            int intValue = duration.intValue();
            String screenFormat = ((CJRMoviesSession) ((List) entry.getValue()).get(0)).getScreenFormat();
            ArrayList arrayList2 = (ArrayList) entry.getValue();
            CJRCinemaV2 cJRCinemaV23 = cinemas.get(entry.getKey());
            CJRCinemaTranslationModel translated = cJRCinemaV23 != null ? cJRCinemaV23.getTranslated() : null;
            CJRMovieCinemaV2 cJRMovieCinemaV23 = (CJRMovieCinemaV2) e2.get(0);
            Integer valueOf = cJRMovieCinemaV23 != null ? Integer.valueOf(cJRMovieCinemaV23.isContentAvailable()) : null;
            if (valueOf == null) {
                k.a();
            }
            int intValue2 = valueOf.intValue();
            CJRMovieCinemaV2 cJRMovieCinemaV24 = (CJRMovieCinemaV2) e2.get(0);
            CJRMovieRatings cJRMovieRatings = (cJRMovieCinemaV24 == null || (ratings = cJRMovieCinemaV24.getRatings()) == null) ? null : ratings;
            CJRCinemaV2 cJRCinemaV24 = cinemas.get(entry.getKey());
            double latitude = cJRCinemaV24 != null ? cJRCinemaV24.getLatitude() : 0.0d;
            CJRCinemaV2 cJRCinemaV25 = cinemas.get(entry.getKey());
            Double valueOf2 = cJRCinemaV25 != null ? Double.valueOf(cJRCinemaV25.getLongitude()) : null;
            arrayList.add(new CJRMovieSessionDetails(name, a2, movieCode, imageUrl, censor, language, a3, id, display, b2, i2, intValue, screenFormat, arrayList2, translated, intValue2, cJRMovieRatings, latitude, valueOf2 != null ? valueOf2.doubleValue() : Double.valueOf(0.0d).doubleValue()));
        }
        return (List) arrayList;
    }

    public static List<CJRMovieSessionDetails> a(LinkedHashMap<String, CJRMovieCinemaV2> linkedHashMap, Map<String, List<CJRMoviesSession>> map) {
        String str;
        CJRMovieRatings ratings;
        Integer duration;
        LinkedHashMap<String, CJRMovieCinemaV2> linkedHashMap2 = linkedHashMap;
        k.c(linkedHashMap2, "movies");
        k.c(map, "mSessionMap");
        Iterable<o> a2 = kotlin.a.k.a(ae.c(map), new c());
        Collection arrayList = new ArrayList(kotlin.a.k.a(a2));
        for (o oVar : a2) {
            String tempMoveCode = ((CJRMoviesSession) ((List) oVar.getSecond()).get(0)).getTempMoveCode();
            CJRMovieCinemaV2 cJRMovieCinemaV2 = linkedHashMap2.get(tempMoveCode);
            String b2 = n.b(cJRMovieCinemaV2 != null ? cJRMovieCinemaV2.getFinalDisplayName() : null);
            String movieCode = ((CJRMoviesSession) ((List) oVar.getSecond()).get(0)).getMovieCode();
            CJRMovieCinemaV2 cJRMovieCinemaV22 = linkedHashMap2.get(tempMoveCode);
            String imageUrl = cJRMovieCinemaV22 != null ? cJRMovieCinemaV22.getImageUrl() : null;
            CJRMovieCinemaV2 cJRMovieCinemaV23 = linkedHashMap2.get(tempMoveCode);
            String censor = cJRMovieCinemaV23 != null ? cJRMovieCinemaV23.getCensor() : null;
            CJRMovieCinemaV2 cJRMovieCinemaV24 = linkedHashMap2.get(tempMoveCode);
            String language = cJRMovieCinemaV24 != null ? cJRMovieCinemaV24.getLanguage() : null;
            String a3 = a(linkedHashMap2.get(tempMoveCode));
            String cinemaID = ((CJRMoviesSession) ((List) oVar.getSecond()).get(0)).getCinemaID();
            CJRMovieCinemaV2 cJRMovieCinemaV25 = linkedHashMap2.get(tempMoveCode);
            String display = cJRMovieCinemaV25 != null ? cJRMovieCinemaV25.getDisplay() : null;
            String b3 = b(linkedHashMap2.get(tempMoveCode));
            int i2 = 0;
            for (List size : map.values()) {
                i2 += size.size();
            }
            CJRMovieCinemaV2 cJRMovieCinemaV26 = linkedHashMap2.get(tempMoveCode);
            int intValue = (cJRMovieCinemaV26 == null || (duration = cJRMovieCinemaV26.getDuration()) == null) ? 0 : duration.intValue();
            String screenFormat = ((CJRMoviesSession) ((List) oVar.getSecond()).get(0)).getScreenFormat();
            ArrayList arrayList2 = (ArrayList) oVar.getSecond();
            CJRCinemaTranslationModel2 translated = ((CJRMoviesSession) ((List) oVar.getSecond()).get(0)).getTranslated();
            CJRMovieCinemaV2 cJRMovieCinemaV27 = linkedHashMap2.get(tempMoveCode);
            int isContentAvailable = cJRMovieCinemaV27 != null ? cJRMovieCinemaV27.isContentAvailable() : 0;
            CJRMovieCinemaV2 cJRMovieCinemaV28 = linkedHashMap2.get(tempMoveCode);
            CJRMovieRatings cJRMovieRatings = (cJRMovieCinemaV28 == null || (ratings = cJRMovieCinemaV28.getRatings()) == null) ? null : ratings;
            String str2 = ((CJRMoviesSession) ((List) oVar.getSecond()).get(0)).getmLatitude();
            String str3 = str2 == null ? "0.0" : str2;
            String str4 = ((CJRMoviesSession) ((List) oVar.getSecond()).get(0)).getmLongitude();
            if (str4 == null) {
                str = "0.0";
            } else {
                str = str4;
            }
            arrayList.add(new CJRMovieSessionDetails(b2, movieCode, imageUrl, censor, language, a3, cinemaID, display, b3, i2, intValue, screenFormat, arrayList2, translated, isContentAvailable, cJRMovieRatings, str3, str));
        }
        return (List) arrayList;
    }

    public static List<CJRSelectCityModel> a(List<? extends CJRSelectCityModel> list, List<String> list2) {
        if (list == null || list2 == null) {
            return null;
        }
        return kotlin.a.k.a(list, new b(list2));
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x003e */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0063 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0064 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(java.lang.String r5) {
        /*
            r0 = r5
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x000e
            int r0 = r0.length()
            if (r0 != 0) goto L_0x000c
            goto L_0x000e
        L_0x000c:
            r0 = 0
            goto L_0x000f
        L_0x000e:
            r0 = 1
        L_0x000f:
            if (r0 != 0) goto L_0x0065
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.util.Locale r1 = java.util.Locale.ENGLISH
            java.lang.String r2 = "yyyy-MM-dd'T'HH:mm:ss"
            r0.<init>(r2, r1)
            java.lang.String r1 = "UTC"
            java.util.TimeZone r2 = java.util.TimeZone.getTimeZone(r1)
            r0.setTimeZone(r2)
            r2 = 0
            java.util.Date r2 = r0.parse(r5)     // Catch:{ ParseException -> 0x0029 }
        L_0x0029:
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.util.Locale r3 = java.util.Locale.ENGLISH
            java.lang.String r4 = "yyyy-MM-dd'T'HH:mm"
            r0.<init>(r4, r3)
            java.util.TimeZone r1 = java.util.TimeZone.getTimeZone(r1)
            r0.setTimeZone(r1)
            java.util.Date r2 = r0.parse(r5)     // Catch:{ ParseException -> 0x003e }
        L_0x003e:
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x0065 }
            java.lang.String r1 = "yyyy-MM-dd"
            java.util.Locale r3 = java.util.Locale.ENGLISH     // Catch:{ Exception -> 0x0065 }
            r0.<init>(r1, r3)     // Catch:{ Exception -> 0x0065 }
            java.lang.String r1 = "Asia/Calcutta"
            java.util.TimeZone r1 = java.util.TimeZone.getTimeZone(r1)     // Catch:{ Exception -> 0x0065 }
            r0.setTimeZone(r1)     // Catch:{ Exception -> 0x0065 }
            java.lang.String r0 = r0.format(r2)     // Catch:{ Exception -> 0x0065 }
            java.lang.String r1 = "s.format(date)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x0065 }
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x0065 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0065 }
            if (r1 != 0) goto L_0x0064
            return r0
        L_0x0064:
            return r5
        L_0x0065:
            java.lang.String r5 = ""
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.utils.h.a(java.lang.String):java.lang.String");
    }

    public static String a(CJRMovieCinemaV2 cJRMovieCinemaV2) {
        String str = "";
        if (cJRMovieCinemaV2 == null) {
            return str;
        }
        if (!TextUtils.isEmpty(cJRMovieCinemaV2.getLanguage())) {
            String language = cJRMovieCinemaV2.getLanguage();
            k.a((Object) language, "movieCinemaDetail.language");
            str = b(language);
        }
        CJRMovieHomeTranslation translated = cJRMovieCinemaV2.getTranslated();
        if (TextUtils.isEmpty(translated != null ? translated.getLanguage() : null)) {
            return str;
        }
        CJRMovieHomeTranslation translated2 = cJRMovieCinemaV2.getTranslated();
        k.a((Object) translated2, "movieCinemaDetail.translated");
        String language2 = translated2.getLanguage();
        k.a((Object) language2, "movieCinemaDetail.translated.language");
        return language2;
    }

    public static String b(CJRMovieCinemaV2 cJRMovieCinemaV2) {
        if (cJRMovieCinemaV2 == null) {
            return "";
        }
        String display = cJRMovieCinemaV2.getDisplay();
        k.a((Object) display, "movieCinemaDetail.display");
        CJRMovieHomeTranslation translated = cJRMovieCinemaV2.getTranslated();
        if (TextUtils.isEmpty(translated != null ? translated.getDisplay() : null)) {
            return display;
        }
        CJRMovieHomeTranslation translated2 = cJRMovieCinemaV2.getTranslated();
        k.a((Object) translated2, "movieCinemaDetail.translated");
        String display2 = translated2.getDisplay();
        k.a((Object) display2, "movieCinemaDetail.translated.display");
        return display2;
    }

    public static String a(CJRMoviesSession cJRMoviesSession) {
        k.c(cJRMoviesSession, "cinemaDetail");
        String cinemaName = cJRMoviesSession.getCinemaName();
        k.a((Object) cinemaName, "cinemaDetail.cinemaName");
        CJRCinemaTranslationModel2 translated = cJRMoviesSession.getTranslated();
        if (TextUtils.isEmpty(translated != null ? translated.getCinemaName() : null)) {
            return cinemaName;
        }
        CJRCinemaTranslationModel2 translated2 = cJRMoviesSession.getTranslated();
        k.a((Object) translated2, "cinemaDetail.translated");
        String cinemaName2 = translated2.getCinemaName();
        k.a((Object) cinemaName2, "cinemaDetail.translated.cinemaName");
        return cinemaName2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = r2.getTranslated();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaV2 r2) {
        /*
            if (r2 == 0) goto L_0x000d
            net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaTranslationModel r0 = r2.getTranslated()
            if (r0 == 0) goto L_0x000d
            java.lang.String r0 = r0.getCinemaName()
            goto L_0x000e
        L_0x000d:
            r0 = 0
        L_0x000e:
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x001c
            int r1 = r1.length()
            if (r1 != 0) goto L_0x001a
            goto L_0x001c
        L_0x001a:
            r1 = 0
            goto L_0x001d
        L_0x001c:
            r1 = 1
        L_0x001d:
            if (r1 == 0) goto L_0x002a
            if (r2 == 0) goto L_0x0027
            java.lang.String r2 = r2.getName()
            if (r2 != 0) goto L_0x0029
        L_0x0027:
            java.lang.String r2 = ""
        L_0x0029:
            r0 = r2
        L_0x002a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.utils.h.a(net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaV2):java.lang.String");
    }

    public static String b(CJRCinemaV2 cJRCinemaV2) {
        k.c(cJRCinemaV2, "cinemaDetail");
        String address = cJRCinemaV2.getAddress();
        k.a((Object) address, "cinemaDetail.address");
        CJRCinemaTranslationModel translated = cJRCinemaV2.getTranslated();
        if (TextUtils.isEmpty(translated != null ? translated.getAddress() : null)) {
            return address;
        }
        CJRCinemaTranslationModel translated2 = cJRCinemaV2.getTranslated();
        k.a((Object) translated2, "cinemaDetail.translated");
        String address2 = translated2.getAddress();
        k.a((Object) address2, "cinemaDetail.translated.address");
        return address2;
    }

    public static String a(CJRSelectCityModel cJRSelectCityModel) {
        k.c(cJRSelectCityModel, "cityModel");
        CJRCityTranslationModel translated = cJRSelectCityModel.getTranslated();
        if (!TextUtils.isEmpty(translated != null ? translated.getLabel() : null)) {
            CJRCityTranslationModel translated2 = cJRSelectCityModel.getTranslated();
            k.a((Object) translated2, "cityModel.translated");
            String label = translated2.getLabel();
            k.a((Object) label, "cityModel.translated.label");
            return label;
        }
        String label2 = !TextUtils.isEmpty(cJRSelectCityModel.getLabel()) ? cJRSelectCityModel.getLabel() : "";
        k.a((Object) label2, "if (!TextUtils.isEmpty(c…      else\n            \"\"");
        return label2;
    }

    private static String b(String str) {
        k.c(str, "inputString");
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String str2 = "" + Character.toUpperCase(str.charAt(0));
        int length = str.length();
        for (int i2 = 1; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (str.charAt(i2 - 1) == ' ') {
                str2 = str2 + Character.toUpperCase(charAt);
            } else {
                str2 = str2 + Character.toLowerCase(charAt);
            }
        }
        return str2;
    }

    public static List<CJRMoviesSession> a(CJRMovieCinemaV2 cJRMovieCinemaV2, CJRMoviesSession cJRMoviesSession) {
        k.c(cJRMovieCinemaV2, "movie");
        k.c(cJRMoviesSession, "movieSession");
        List<CJRMoviesSession> sessions = cJRMovieCinemaV2.getSessions();
        k.a((Object) sessions, "movie.sessions");
        Collection arrayList = new ArrayList();
        for (Object next : sessions) {
            CJRMoviesSession cJRMoviesSession2 = (CJRMoviesSession) next;
            String cinemaID = cJRMoviesSession.getCinemaID();
            k.a((Object) cJRMoviesSession2, "it");
            boolean z = true;
            if (!p.a(cinemaID, cJRMoviesSession2.getCinemaID(), true) || !p.a(cJRMoviesSession.getMovieCode(), cJRMoviesSession2.getMovieCode(), true)) {
                z = false;
            }
            if (z) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r7v3, types: [java.util.HashMap] */
    /* JADX WARNING: type inference failed for: r7v5 */
    /* JADX WARNING: type inference failed for: r7v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x02b4  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01fc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static net.one97.paytm.o2o.movies.common.movies.a a(com.paytm.network.model.IJRPaytmDataModel r11, net.one97.paytm.o2o.movies.common.movies.a r12) {
        /*
            java.lang.String r0 = "mFinalModel"
            kotlin.g.b.k.c(r12, r0)
            r0 = 0
            if (r11 == 0) goto L_0x03da
            java.lang.String r1 = r12.f75132c
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r2 = 1
            if (r1 == 0) goto L_0x0018
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0016
            goto L_0x0018
        L_0x0016:
            r1 = 0
            goto L_0x0019
        L_0x0018:
            r1 = 1
        L_0x0019:
            if (r1 != 0) goto L_0x03da
            java.lang.String r1 = r12.f75133d
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x002a
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0028
            goto L_0x002a
        L_0x0028:
            r1 = 0
            goto L_0x002b
        L_0x002a:
            r1 = 1
        L_0x002b:
            if (r1 == 0) goto L_0x002f
            goto L_0x03da
        L_0x002f:
            java.lang.String r1 = r12.f75132c
            if (r1 != 0) goto L_0x0036
            kotlin.g.b.k.a()
        L_0x0036:
            java.lang.String r3 = r12.f75133d
            if (r3 != 0) goto L_0x003d
            kotlin.g.b.k.a()
        L_0x003d:
            int r4 = r3.hashCode()
            r5 = -1360334095(0xffffffffaeeaf2f1, float:-1.0684243E-10)
            java.lang.String r6 = "null cannot be cast to non-null type net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaDetailV2"
            r7 = 0
            if (r4 == r5) goto L_0x0069
            r1 = 104087344(0x6343f30, float:3.390066E-35)
            if (r4 == r1) goto L_0x0050
            goto L_0x01f5
        L_0x0050:
            java.lang.String r1 = "movie"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x01f5
            if (r11 == 0) goto L_0x0063
            r1 = r11
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaDetailV2 r1 = (net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaDetailV2) r1
            java.util.Map r1 = a((net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaDetailV2) r1)
            goto L_0x01f6
        L_0x0063:
            kotlin.u r11 = new kotlin.u
            r11.<init>(r6)
            throw r11
        L_0x0069:
            java.lang.String r4 = "cinema"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x01f5
            if (r11 == 0) goto L_0x01ef
            r3 = r11
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaDetailV2 r3 = (net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaDetailV2) r3
            kotlin.g.b.k.c(r1, r4)
            if (r3 == 0) goto L_0x008e
            java.util.LinkedHashMap r4 = r3.getMovies()
            if (r4 == 0) goto L_0x008e
            java.util.Set r4 = r4.keySet()
            if (r4 == 0) goto L_0x008e
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.List r4 = kotlin.a.k.e(r4)
            goto L_0x008f
        L_0x008e:
            r4 = r7
        L_0x008f:
            if (r4 == 0) goto L_0x00dc
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.Iterator r4 = r4.iterator()
        L_0x0097:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x00dc
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            java.util.LinkedHashMap r6 = r3.getMovies()
            if (r6 == 0) goto L_0x0097
            java.lang.Object r6 = r6.get(r5)
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaV2 r6 = (net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaV2) r6
            if (r6 == 0) goto L_0x0097
            java.util.List r6 = r6.getSessions()
            if (r6 == 0) goto L_0x0097
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r8 = new java.util.ArrayList
            int r9 = kotlin.a.k.a(r6)
            r8.<init>(r9)
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r6 = r6.iterator()
        L_0x00c8:
            boolean r9 = r6.hasNext()
            if (r9 == 0) goto L_0x0097
            java.lang.Object r9 = r6.next()
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r9 = (net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession) r9
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r9 = r9.transform(r5)
            r8.add(r9)
            goto L_0x00c8
        L_0x00dc:
            if (r3 == 0) goto L_0x01f5
            java.util.LinkedHashMap r3 = r3.getMovies()
            if (r3 == 0) goto L_0x01f5
            java.util.Collection r3 = r3.values()
            if (r3 == 0) goto L_0x01f5
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.ArrayList r4 = new java.util.ArrayList
            int r5 = kotlin.a.k.a(r3)
            r4.<init>(r5)
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.Iterator r3 = r3.iterator()
        L_0x00fb:
            boolean r5 = r3.hasNext()
            java.lang.String r6 = "item"
            if (r5 == 0) goto L_0x0114
            java.lang.Object r5 = r3.next()
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaV2 r5 = (net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaV2) r5
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            java.util.List r5 = r5.getSessions()
            r4.add(r5)
            goto L_0x00fb
        L_0x0114:
            java.util.List r4 = (java.util.List) r4
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.List r3 = kotlin.a.k.b(r4)
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.Iterator r3 = r3.iterator()
        L_0x0129:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0147
            java.lang.Object r5 = r3.next()
            r8 = r5
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r8 = (net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession) r8
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r6)
            java.lang.String r8 = r8.getCinemaID()
            boolean r8 = kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.Object) r1)
            if (r8 == 0) goto L_0x0129
            r4.add(r5)
            goto L_0x0129
        L_0x0147:
            java.util.List r4 = (java.util.List) r4
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
            r1.<init>()
            java.util.Map r1 = (java.util.Map) r1
            java.util.Iterator r3 = r4.iterator()
        L_0x0156:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0182
            java.lang.Object r4 = r3.next()
            r5 = r4
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r5 = (net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession) r5
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            java.lang.String r5 = r5.getRealShowDateTime()
            java.lang.String r5 = a((java.lang.String) r5)
            java.lang.Object r8 = r1.get(r5)
            if (r8 != 0) goto L_0x017c
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            r1.put(r5, r8)
        L_0x017c:
            java.util.List r8 = (java.util.List) r8
            r8.add(r4)
            goto L_0x0156
        L_0x0182:
            java.util.LinkedHashMap r3 = new java.util.LinkedHashMap
            int r4 = r1.size()
            int r4 = kotlin.a.ae.a((int) r4)
            r3.<init>(r4)
            java.util.Map r3 = (java.util.Map) r3
            java.util.Set r1 = r1.entrySet()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x019b:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x01ea
            java.lang.Object r4 = r1.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            java.lang.Object r4 = r4.getValue()
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.LinkedHashMap r6 = new java.util.LinkedHashMap
            r6.<init>()
            java.util.Map r6 = (java.util.Map) r6
            java.util.Iterator r4 = r4.iterator()
        L_0x01bc:
            boolean r8 = r4.hasNext()
            if (r8 == 0) goto L_0x01e6
            java.lang.Object r8 = r4.next()
            r9 = r8
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r9 = (net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession) r9
            java.lang.String r10 = "data"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r10)
            java.lang.String r9 = r9.getFrmtId()
            java.lang.Object r10 = r6.get(r9)
            if (r10 != 0) goto L_0x01e0
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            r6.put(r9, r10)
        L_0x01e0:
            java.util.List r10 = (java.util.List) r10
            r10.add(r8)
            goto L_0x01bc
        L_0x01e6:
            r3.put(r5, r6)
            goto L_0x019b
        L_0x01ea:
            java.util.Map r1 = kotlin.a.ae.b(r3)
            goto L_0x01f6
        L_0x01ef:
            kotlin.u r11 = new kotlin.u
            r11.<init>(r6)
            throw r11
        L_0x01f5:
            r1 = r7
        L_0x01f6:
            java.util.Map<java.lang.String, ? extends java.util.Map<java.lang.String, ? extends java.util.List<? extends net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession>>> r3 = r12.f75130a
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x02b4
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaDetailV2 r11 = (net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaDetailV2) r11
            java.util.Map<java.lang.String, ? extends java.util.Map<java.lang.String, ? extends java.util.List<? extends net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession>>> r0 = r12.f75130a
            if (r0 != 0) goto L_0x0205
            kotlin.g.b.k.a()
        L_0x0205:
            java.lang.String r2 = r12.f75135f
            java.lang.Object r0 = r0.get(r2)
            java.util.Map r0 = (java.util.Map) r0
            if (r1 != 0) goto L_0x0212
            kotlin.g.b.k.a()
        L_0x0212:
            java.lang.String r2 = r12.f75135f
            java.lang.Object r2 = r1.get(r2)
            java.util.Map r2 = (java.util.Map) r2
            if (r0 == 0) goto L_0x022a
            if (r2 == 0) goto L_0x022a
            java.util.Map r0 = kotlin.a.ae.a(r0, r2)
            java.lang.String r2 = r12.f75135f
            if (r2 != 0) goto L_0x0227
            r2 = r4
        L_0x0227:
            r1.put(r2, r0)
        L_0x022a:
            java.util.HashMap<java.lang.String, net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaDetailV2> r0 = r12.f75131b
            if (r0 == 0) goto L_0x023b
            java.util.HashMap<java.lang.String, net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaDetailV2> r0 = r12.f75131b
            if (r0 == 0) goto L_0x024a
            java.lang.String r2 = r12.f75135f
            if (r2 != 0) goto L_0x0237
            r2 = r4
        L_0x0237:
            r0.put(r2, r11)
            goto L_0x024a
        L_0x023b:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r2 = r12.f75135f
            if (r2 != 0) goto L_0x0245
            r2 = r4
        L_0x0245:
            r0.put(r2, r11)
            r12.f75131b = r0
        L_0x024a:
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaDetailV2 r0 = r12.m
            if (r0 == 0) goto L_0x0253
            java.util.HashMap r0 = r0.getSearchFilters()
            goto L_0x0254
        L_0x0253:
            r0 = r7
        L_0x0254:
            r11.setSearchFilters(r0)
            java.util.Map<java.lang.String, ? extends java.util.Map<java.lang.String, ? extends java.util.List<? extends net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession>>> r0 = r12.f75130a
            if (r0 == 0) goto L_0x0260
            java.util.Map r0 = kotlin.a.ae.a(r0, r1)
            goto L_0x0261
        L_0x0260:
            r0 = r7
        L_0x0261:
            r12.f75130a = r0
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaDetailV2 r0 = r12.m
            if (r0 == 0) goto L_0x026c
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieShowTimeFilterDataStorage r0 = r0.getFilteredData()
            goto L_0x026d
        L_0x026c:
            r0 = r7
        L_0x026d:
            r11.setFilteredData(r0)
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaDetailV2 r0 = r12.m
            if (r0 == 0) goto L_0x0279
            java.util.List r0 = r0.getFilterList()
            goto L_0x027a
        L_0x0279:
            r0 = r7
        L_0x027a:
            r11.setFilterList(r0)
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaDetailV2 r0 = r12.m
            if (r0 == 0) goto L_0x0285
            java.util.HashMap r7 = r0.getOrderedCinemaList()
        L_0x0285:
            java.util.Set r0 = r1.keySet()
            if (r0 == 0) goto L_0x02b1
            java.util.Iterator r0 = r0.iterator()
        L_0x028f:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x02ae
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            if (r7 == 0) goto L_0x028f
            net.one97.paytm.o2o.movies.common.movies.search.OrderedMap r2 = r11.getOrderedMap()
            java.lang.String r3 = "newData.orderedMap"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            java.util.List r2 = r2.getCinemaIds()
            r7.put(r1, r2)
            goto L_0x028f
        L_0x02ae:
            r11.setOrderedCinemaList(r7)
        L_0x02b1:
            r12.m = r11
            return r12
        L_0x02b4:
            if (r1 != 0) goto L_0x02b7
            return r12
        L_0x02b7:
            r12.f75130a = r1
            r3 = r11
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaDetailV2 r3 = (net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaDetailV2) r3
            r12.m = r3
            java.util.LinkedHashMap r5 = new java.util.LinkedHashMap
            r5.<init>()
            java.util.Map r5 = (java.util.Map) r5
            java.util.Set r1 = r1.keySet()
            if (r1 == 0) goto L_0x02f6
            java.util.Iterator r1 = r1.iterator()
        L_0x02cf:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x02f1
            java.lang.Object r6 = r1.next()
            java.lang.String r6 = (java.lang.String) r6
            net.one97.paytm.o2o.movies.common.movies.search.OrderedMap r8 = r3.getOrderedMap()
            java.lang.String r9 = "mResponse.orderedMap"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)
            java.util.List r8 = r8.getCinemaIds()
            java.lang.String r9 = "mResponse.orderedMap.cinemaIds"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)
            r5.put(r6, r8)
            goto L_0x02cf
        L_0x02f1:
            java.util.HashMap r5 = (java.util.HashMap) r5
            r3.setOrderedCinemaList(r5)
        L_0x02f6:
            java.util.LinkedHashMap r1 = r3.getCinemas()
            if (r1 == 0) goto L_0x0309
            java.util.Collection r1 = r1.values()
            if (r1 == 0) goto L_0x0309
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.List r1 = kotlin.a.k.e(r1)
            goto L_0x030a
        L_0x0309:
            r1 = r7
        L_0x030a:
            r12.j = r1
            java.util.HashMap r1 = r3.getSearchFilters()
            if (r1 == 0) goto L_0x0314
            r1 = 1
            goto L_0x0315
        L_0x0314:
            r1 = 0
        L_0x0315:
            r12.f75138i = r1
            java.util.List r1 = r3.getMovieList()
            boolean r1 = net.one97.paytm.o2o.movies.common.a.b.a(r1)
            if (r1 == 0) goto L_0x0322
            return r12
        L_0x0322:
            java.util.List r1 = r3.getMovieList()
            java.lang.String r5 = "mResponse.movieList"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
            java.util.List r1 = b((java.util.List<? extends net.one97.paytm.o2o.movies.common.movies.search.CJRMovieDetailList>) r1)
            r12.f75134e = r1
            java.util.List<? extends net.one97.paytm.o2o.movies.common.movies.movieslot.CJRMovieDetailsTab> r1 = r12.f75134e
            if (r1 != 0) goto L_0x0338
            kotlin.g.b.k.a()
        L_0x0338:
            java.lang.Object r1 = kotlin.a.k.e(r1)
            net.one97.paytm.o2o.movies.common.movies.movieslot.CJRMovieDetailsTab r1 = (net.one97.paytm.o2o.movies.common.movies.movieslot.CJRMovieDetailsTab) r1
            if (r1 == 0) goto L_0x0344
            java.lang.String r7 = r1.getmDate()
        L_0x0344:
            r12.f75135f = r7
            java.util.HashMap<java.lang.String, net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaDetailV2> r1 = r12.f75131b
            if (r1 == 0) goto L_0x0358
            java.util.HashMap<java.lang.String, net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaDetailV2> r1 = r12.f75131b
            if (r1 == 0) goto L_0x0368
            java.lang.String r5 = r12.f75135f
            if (r5 != 0) goto L_0x0353
            goto L_0x0354
        L_0x0353:
            r4 = r5
        L_0x0354:
            r1.put(r4, r11)
            goto L_0x0368
        L_0x0358:
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.lang.String r5 = r12.f75135f
            if (r5 != 0) goto L_0x0362
            goto L_0x0363
        L_0x0362:
            r4 = r5
        L_0x0363:
            r1.put(r4, r11)
            r12.f75131b = r1
        L_0x0368:
            java.lang.String r11 = r12.f75136g
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            if (r11 == 0) goto L_0x0377
            int r11 = r11.length()
            if (r11 != 0) goto L_0x0375
            goto L_0x0377
        L_0x0375:
            r11 = 0
            goto L_0x0378
        L_0x0377:
            r11 = 1
        L_0x0378:
            if (r11 != 0) goto L_0x038e
            java.lang.String r11 = r12.f75136g
            if (r11 != 0) goto L_0x0381
            kotlin.g.b.k.a()
        L_0x0381:
            java.lang.String r1 = r12.f75132c
            if (r1 != 0) goto L_0x0388
            kotlin.g.b.k.a()
        L_0x0388:
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r11 = a((net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaDetailV2) r3, (java.lang.String) r11, (java.lang.String) r1)
            r12.f75137h = r11
        L_0x038e:
            java.util.LinkedHashMap r11 = r3.getMovies()
            java.lang.String r1 = r12.f75132c
            java.lang.Object r11 = r11.get(r1)
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaV2 r11 = (net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaV2) r11
            r12.k = r11
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaV2 r11 = r12.k
            if (r11 != 0) goto L_0x03c9
            java.util.List r11 = r3.getMovieList()
            int r11 = r11.size()
            if (r11 <= 0) goto L_0x03c9
            java.util.LinkedHashMap r11 = r3.getMovies()
            java.util.List r1 = r3.getMovieList()
            java.lang.Object r0 = r1.get(r0)
            java.lang.String r1 = "mResponse.movieList[0]"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieDetailList r0 = (net.one97.paytm.o2o.movies.common.movies.search.CJRMovieDetailList) r0
            java.lang.String r0 = r0.getCode()
            java.lang.Object r11 = r11.get(r0)
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaV2 r11 = (net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaV2) r11
            r12.k = r11
        L_0x03c9:
            java.util.LinkedHashMap r11 = r3.getCinemas()
            java.lang.String r0 = r12.f75132c
            java.lang.Object r11 = r11.get(r0)
            net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaV2 r11 = (net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaV2) r11
            r12.l = r11
            r12.n = r2
            return r12
        L_0x03da:
            r12.n = r0
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.utils.h.a(com.paytm.network.model.IJRPaytmDataModel, net.one97.paytm.o2o.movies.common.movies.a):net.one97.paytm.o2o.movies.common.movies.a");
    }

    private static List<String> a(List<? extends CJRMovieDetailList> list) {
        if (list == null) {
            return w.INSTANCE;
        }
        ArrayList arrayList = new ArrayList();
        Iterable<CJRMovieDetailList> iterable = list;
        Collection arrayList2 = new ArrayList(kotlin.a.k.a(iterable));
        for (CJRMovieDetailList sessionDates : iterable) {
            List<String> sessionDates2 = sessionDates.getSessionDates();
            if (sessionDates2 == null || sessionDates2 == null) {
                sessionDates2 = arrayList;
            }
            arrayList2.add(sessionDates2);
        }
        Iterable b2 = kotlin.a.k.b((List) arrayList2);
        k.d(b2, "$this$distinct");
        k.d(b2, "$this$toMutableSet");
        Iterable e2 = kotlin.a.k.e(new LinkedHashSet((Collection) b2));
        k.d(e2, "$this$sorted");
        if (e2 instanceof Collection) {
            Collection collection = (Collection) e2;
            if (collection.size() <= 1) {
                return kotlin.a.k.e(e2);
            }
            Object[] array = collection.toArray(new Comparable[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            } else if (array != null) {
                Comparable[] comparableArr = (Comparable[]) array;
                if (comparableArr != null) {
                    Object[] objArr = (Object[]) comparableArr;
                    k.d(objArr, "$this$sort");
                    if (objArr.length > 1) {
                        Arrays.sort(objArr);
                    }
                    return f.a(objArr);
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        } else {
            List<String> f2 = kotlin.a.k.f(e2);
            kotlin.a.k.c(f2);
            return f2;
        }
    }

    private static boolean a(CJRMoviesSession cJRMoviesSession, CJRMovieShowTimeFilterDataStorage cJRMovieShowTimeFilterDataStorage) {
        Integer num;
        String str = cJRMovieShowTimeFilterDataStorage.f75179a;
        k.a((Object) str, "filter.minPrice");
        int parseInt = Integer.parseInt(str);
        String str2 = cJRMovieShowTimeFilterDataStorage.f75180b;
        k.a((Object) str2, "filter.maxPrice");
        int parseInt2 = Integer.parseInt(str2);
        ArrayList<CJRMoviesSessionDetails> moviesSessionDetails = cJRMoviesSession.getMoviesSessionDetails();
        k.a((Object) moviesSessionDetails, "cjrMoviesSession.moviesSessionDetails");
        if (!(!moviesSessionDetails.isEmpty())) {
            return false;
        }
        ArrayList<CJRMoviesSessionDetails> moviesSessionDetails2 = cJRMoviesSession.getMoviesSessionDetails();
        k.a((Object) moviesSessionDetails2, "cjrMoviesSession.moviesSessionDetails");
        boolean z = false;
        for (CJRMoviesSessionDetails cJRMoviesSessionDetails : moviesSessionDetails2) {
            kotlin.j.a dVar = new d(parseInt, parseInt2);
            k.a((Object) cJRMoviesSessionDetails, "it");
            CJRMoviesPriceDetails moviesPriceDetails = cJRMoviesSessionDetails.getMoviesPriceDetails();
            k.a((Object) moviesPriceDetails, "it.moviesPriceDetails");
            double price = moviesPriceDetails.getPrice();
            k.d(dVar, "$this$contains");
            if (price < -2.147483648E9d || price > 2.147483647E9d) {
                num = null;
            } else {
                num = Integer.valueOf((int) price);
            }
            if (num != null ? dVar.a(num) : false) {
                z = true;
            }
        }
        return z;
    }
}
