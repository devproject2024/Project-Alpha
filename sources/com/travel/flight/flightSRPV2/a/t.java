package com.travel.flight.flightSRPV2.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.h;
import com.business.merchant_payments.common.utility.AppConstants;
import com.sendbird.android.constant.StringSet;
import com.travel.flight.R;
import com.travel.flight.pojo.flightticket.CJRFlightDetailsItem;
import com.travel.flight.pojo.flightticket.CJRFlightFilterMinMaxDetails;
import com.travel.flight.pojo.flightticket.CJRFlightSRPMetaArrivalDeparture;
import com.travel.flight.pojo.flightticket.CJRFlightSearchResult;
import com.travel.flight.pojo.flightticket.CJRFlightStops;
import com.travel.flight.pojo.flightticket.CJRIntlFlightMapping;
import com.travel.flight.pojo.flightticket.CJRMetadetails;
import com.travel.flight.pojo.flightticket.CJROnwardFlights;
import com.travel.flight.pojo.flightticket.CJROnwardReturnFlightInformation;
import com.travel.flight.pojo.flightticket.FlightSearchResultMetaQuery;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.a.w;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.m.p;
import kotlin.u;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

public final class t {

    /* renamed from: a  reason: collision with root package name */
    private static final kotlin.g f24124a = kotlin.h.a(b.INSTANCE);

    static final class d extends l implements m<CJRIntlFlightMapping, CJRIntlFlightMapping, Boolean> {
        public static final d INSTANCE = new d();

        d() {
            super(2);
        }

        public final /* synthetic */ Object invoke(Object obj, Object obj2) {
            return Boolean.valueOf(invoke((CJRIntlFlightMapping) obj, (CJRIntlFlightMapping) obj2));
        }

        public final boolean invoke(CJRIntlFlightMapping cJRIntlFlightMapping, CJRIntlFlightMapping cJRIntlFlightMapping2) {
            k.c(cJRIntlFlightMapping, "<anonymous parameter 0>");
            k.c(cJRIntlFlightMapping2, "<anonymous parameter 1>");
            return true;
        }
    }

    static final class h extends l implements m<CJRFlightDetailsItem, CJRFlightDetailsItem, Boolean> {
        public static final h INSTANCE = new h();

        h() {
            super(2);
        }

        public final /* synthetic */ Object invoke(Object obj, Object obj2) {
            return Boolean.valueOf(invoke((CJRFlightDetailsItem) obj, (CJRFlightDetailsItem) obj2));
        }

        public final boolean invoke(CJRFlightDetailsItem cJRFlightDetailsItem, CJRFlightDetailsItem cJRFlightDetailsItem2) {
            k.c(cJRFlightDetailsItem, "<anonymous parameter 0>");
            k.c(cJRFlightDetailsItem2, "<anonymous parameter 1>");
            return true;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: java.util.List<? extends com.travel.flight.pojo.flightticket.CJRFlightDetailsItem>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00c4 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x011c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<com.travel.flight.pojo.flightticket.CJRFlightDetailsItem> c(java.util.List<? extends com.travel.flight.pojo.flightticket.CJRFlightDetailsItem> r8, java.util.List<? extends com.travel.flight.flightSRPV2.a.x> r9) {
        /*
            java.lang.String r0 = "flights"
            kotlin.g.b.k.c(r8, r0)
            java.lang.String r0 = "filters"
            kotlin.g.b.k.c(r9, r0)
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r1 = r9.iterator()
        L_0x0017:
            boolean r2 = r1.hasNext()
            r3 = 7
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L_0x0034
            java.lang.Object r2 = r1.next()
            r6 = r2
            com.travel.flight.flightSRPV2.a.x r6 = (com.travel.flight.flightSRPV2.a.x) r6
            int r6 = r6.e()
            if (r6 == r3) goto L_0x002e
            r4 = 1
        L_0x002e:
            if (r4 == 0) goto L_0x0017
            r0.add(r2)
            goto L_0x0017
        L_0x0034:
            java.util.List r0 = (java.util.List) r0
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = kotlin.a.k.a(r0)
            r1.<init>(r2)
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r0 = r0.iterator()
        L_0x0047:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x005b
            java.lang.Object r2 = r0.next()
            com.travel.flight.flightSRPV2.a.x r2 = (com.travel.flight.flightSRPV2.a.x) r2
            kotlin.g.a.b r2 = r2.f()
            r1.add(r2)
            goto L_0x0047
        L_0x005b:
            java.util.List r1 = (java.util.List) r1
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r9 = r9.iterator()
        L_0x0068:
            boolean r2 = r9.hasNext()
            if (r2 == 0) goto L_0x0084
            java.lang.Object r2 = r9.next()
            r6 = r2
            com.travel.flight.flightSRPV2.a.x r6 = (com.travel.flight.flightSRPV2.a.x) r6
            int r6 = r6.e()
            if (r6 != r3) goto L_0x007d
            r6 = 1
            goto L_0x007e
        L_0x007d:
            r6 = 0
        L_0x007e:
            if (r6 == 0) goto L_0x0068
            r0.add(r2)
            goto L_0x0068
        L_0x0084:
            java.util.List r0 = (java.util.List) r0
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r9 = new java.util.ArrayList
            int r2 = kotlin.a.k.a(r0)
            r9.<init>(r2)
            java.util.Collection r9 = (java.util.Collection) r9
            java.util.Iterator r0 = r0.iterator()
        L_0x0097:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x00ab
            java.lang.Object r2 = r0.next()
            com.travel.flight.flightSRPV2.a.x r2 = (com.travel.flight.flightSRPV2.a.x) r2
            kotlin.g.a.b r2 = r2.f()
            r9.add(r2)
            goto L_0x0097
        L_0x00ab:
            java.util.List r9 = (java.util.List) r9
            r0 = r9
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r5
            if (r0 == 0) goto L_0x0105
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r8 = r8.iterator()
        L_0x00c4:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto L_0x0102
            java.lang.Object r2 = r8.next()
            r3 = r2
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r3 = (com.travel.flight.pojo.flightticket.CJRFlightDetailsItem) r3
            r6 = r9
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            r7 = r6
            java.util.Collection r7 = (java.util.Collection) r7
            boolean r7 = r7.isEmpty()
            if (r7 != 0) goto L_0x00fb
            java.util.Iterator r6 = r6.iterator()
        L_0x00e1:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x00fb
            java.lang.Object r7 = r6.next()
            kotlin.g.a.b r7 = (kotlin.g.a.b) r7
            java.lang.Object r7 = r7.invoke(r3)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x00e1
            r3 = 1
            goto L_0x00fc
        L_0x00fb:
            r3 = 0
        L_0x00fc:
            if (r3 == 0) goto L_0x00c4
            r0.add(r2)
            goto L_0x00c4
        L_0x0102:
            r8 = r0
            java.util.List r8 = (java.util.List) r8
        L_0x0105:
            r9 = r1
            java.util.Collection r9 = (java.util.Collection) r9
            boolean r9 = r9.isEmpty()
            r9 = r9 ^ r5
            if (r9 == 0) goto L_0x015d
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.Collection r9 = (java.util.Collection) r9
            java.util.Iterator r8 = r8.iterator()
        L_0x011c:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x015a
            java.lang.Object r0 = r8.next()
            r2 = r0
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r2 = (com.travel.flight.pojo.flightticket.CJRFlightDetailsItem) r2
            r3 = r1
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            r6 = r3
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r6 = r6.isEmpty()
            if (r6 != 0) goto L_0x0153
            java.util.Iterator r3 = r3.iterator()
        L_0x0139:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x0153
            java.lang.Object r6 = r3.next()
            kotlin.g.a.b r6 = (kotlin.g.a.b) r6
            java.lang.Object r6 = r6.invoke(r2)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 != 0) goto L_0x0139
            r2 = 0
            goto L_0x0154
        L_0x0153:
            r2 = 1
        L_0x0154:
            if (r2 == 0) goto L_0x011c
            r9.add(r0)
            goto L_0x011c
        L_0x015a:
            r8 = r9
            java.util.List r8 = (java.util.List) r8
        L_0x015d:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightSRPV2.a.t.c(java.util.List, java.util.List):java.util.List");
    }

    static final class g extends l implements m<CJRFlightDetailsItem, CJRFlightDetailsItem, Boolean> {
        final /* synthetic */ ae $sortOption;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(ae aeVar) {
            super(2);
            this.$sortOption = aeVar;
        }

        public final /* synthetic */ Object invoke(Object obj, Object obj2) {
            return Boolean.valueOf(invoke((CJRFlightDetailsItem) obj, (CJRFlightDetailsItem) obj2));
        }

        public final boolean invoke(CJRFlightDetailsItem cJRFlightDetailsItem, CJRFlightDetailsItem cJRFlightDetailsItem2) {
            k.c(cJRFlightDetailsItem, "lhs");
            k.c(cJRFlightDetailsItem2, "rhs");
            return this.$sortOption.a(cJRFlightDetailsItem).compareTo(this.$sortOption.a(cJRFlightDetailsItem2)) == 0;
        }
    }

    public static final class a<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            return kotlin.b.a.a(Integer.valueOf(((d) t).f24098d), Integer.valueOf(((d) t2).f24098d));
        }
    }

    public static final List<CJRFlightDetailsItem> a(CJRFlightSearchResult cJRFlightSearchResult, List<? extends x> list, ae aeVar) {
        List<CJRFlightDetailsItem> list2;
        List list3;
        m mVar;
        k.c(cJRFlightSearchResult, "srpResult");
        k.c(list, "filters");
        CJROnwardReturnFlightInformation cJROnwardReturnFlightInformation = cJRFlightSearchResult.getmOnwardReturnFlights();
        k.a((Object) cJROnwardReturnFlightInformation, "flightInfo");
        boolean a2 = k.a((Object) cJROnwardReturnFlightInformation.getJourney_type(), (Object) net.one97.paytmflight.common.b.b.f30019i);
        ArrayList<CJRFlightDetailsItem> arrayList = cJRFlightSearchResult.getmOnwardReturnFlights().getmOnwardFlights().getmFlightDetails();
        k.a((Object) arrayList, "srpResult.getmOnwardRetu…hts().getmFlightDetails()");
        List list4 = arrayList;
        Collection collection = list4;
        if (collection == null || collection.isEmpty()) {
            return w.INSTANCE;
        }
        List<CJRFlightDetailsItem> c2 = c(g(list4), list);
        int size = c2.size();
        if (a2) {
            k.c(c2, "inputList");
            if (aeVar != null) {
                c2 = kotlin.a.k.a(c2, aeVar.c());
                mVar = new g(aeVar);
            } else {
                mVar = h.INSTANCE;
            }
            list2 = new ArrayList<>();
            for (CJRFlightDetailsItem next : c2) {
                CharSequence charSequence = next.getmParentId();
                if (charSequence == null || p.a(charSequence)) {
                    next.setmParentId(next.getmFlightId());
                }
                if (list2.isEmpty()) {
                    next.setmIsParent(true);
                    next.setChildItems(new ArrayList());
                    list2.add(next);
                } else {
                    CJRFlightDetailsItem cJRFlightDetailsItem = (CJRFlightDetailsItem) kotlin.a.k.f(list2);
                    if (!((Boolean) mVar.invoke(cJRFlightDetailsItem, next)).booleanValue() || (!k.a((Object) cJRFlightDetailsItem.getmParentId(), (Object) next.getmParentId()) && !k.a((Object) cJRFlightDetailsItem.getmFlightId(), (Object) next.getmParentId()) && !k.a((Object) cJRFlightDetailsItem.getmParentId(), (Object) next.getmFlightId()))) {
                        next.setmIsParent(true);
                        next.setChildItems(new ArrayList());
                        list2.add(next);
                    } else {
                        next.setmIsParent(false);
                        next.setmParentId(cJRFlightDetailsItem.getmParentId());
                        cJRFlightDetailsItem.getChildItems().add(next);
                    }
                }
            }
        } else {
            if (aeVar != null) {
                c2 = kotlin.a.k.a(c2, aeVar.c());
            }
            list2 = c2;
        }
        if ((aeVar == null || aeVar.a() == 1) && list.isEmpty()) {
            CJRFlightFilterMinMaxDetails cJRFlightFilterMinMaxDetails = cJRFlightSearchResult.getmOnwardReturnFlights().getmOnwardFlights().getmMeta();
            k.a((Object) cJRFlightFilterMinMaxDetails, "srpResult.getmOnwardRetu…nwardFlights().getmMeta()");
            list3 = cJRFlightFilterMinMaxDetails.getCardInfo();
        } else {
            list3 = w.INSTANCE;
        }
        List list5 = list3;
        k.a((Object) list5, "cards");
        List<CJRFlightDetailsItem> a3 = a(list2, list5, cJRFlightSearchResult, aeVar, list, size);
        if (a2) {
            a3 = d(a3);
        } else {
            for (CJRFlightDetailsItem next2 : a3) {
                next2.setmIsParent(true);
                next2.setmParentId((String) null);
            }
        }
        f(a3);
        e(a3);
        return a3;
    }

    private static final List<CJRFlightDetailsItem> d(List<? extends CJRFlightDetailsItem> list) {
        for (CJRFlightDetailsItem cJRFlightDetailsItem : list) {
            if (cJRFlightDetailsItem.ismIsParent()) {
                Collection childItems = cJRFlightDetailsItem.getChildItems();
                int i2 = 0;
                if (!(childItems == null || childItems.isEmpty())) {
                    List<CJRFlightDetailsItem> childItems2 = cJRFlightDetailsItem.getChildItems();
                    k.a((Object) childItems2, "parent.childItems");
                    int size = childItems2.size();
                    while (i2 < size) {
                        CJRFlightDetailsItem cJRFlightDetailsItem2 = cJRFlightDetailsItem.getChildItems().get(i2);
                        k.a((Object) cJRFlightDetailsItem2, "child");
                        cJRFlightDetailsItem2.setViewType(a(cJRFlightDetailsItem2));
                        cJRFlightDetailsItem2.setPosState(i2 == cJRFlightDetailsItem.getChildItems().size() - 1 ? 3 : 1);
                        i2++;
                    }
                }
            }
        }
        return list;
    }

    public static final List<CJRFlightDetailsItem> a(List<? extends CJRFlightDetailsItem> list, List<? extends x> list2, ae aeVar) {
        k.c(list, "srpResult");
        k.c(list2, "filters");
        List<CJRFlightDetailsItem> c2 = c(list, list2);
        if (aeVar != null) {
            c2 = kotlin.a.k.a(c2, aeVar.c());
        }
        for (CJRFlightDetailsItem cJRFlightDetailsItem : c2) {
            cJRFlightDetailsItem.setmIsParent(true);
        }
        return c2;
    }

    static final class c extends l implements m<CJRIntlFlightMapping, CJRIntlFlightMapping, Boolean> {
        final /* synthetic */ ae $sortOption;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(ae aeVar) {
            super(2);
            this.$sortOption = aeVar;
        }

        public final /* synthetic */ Object invoke(Object obj, Object obj2) {
            return Boolean.valueOf(invoke((CJRIntlFlightMapping) obj, (CJRIntlFlightMapping) obj2));
        }

        public final boolean invoke(CJRIntlFlightMapping cJRIntlFlightMapping, CJRIntlFlightMapping cJRIntlFlightMapping2) {
            k.c(cJRIntlFlightMapping, "lhs");
            k.c(cJRIntlFlightMapping2, "rhs");
            return this.$sortOption.a(cJRIntlFlightMapping).compareTo(this.$sortOption.a(cJRIntlFlightMapping2)) == 0;
        }
    }

    public static final boolean a(ae aeVar, CJRIntlFlightMapping cJRIntlFlightMapping, CJRIntlFlightMapping cJRIntlFlightMapping2) {
        m mVar;
        k.c(cJRIntlFlightMapping, "lhsMapping");
        k.c(cJRIntlFlightMapping2, "rhsMapping");
        if (aeVar != null) {
            mVar = new c(aeVar);
        } else {
            mVar = d.INSTANCE;
        }
        return ((Boolean) mVar.invoke(cJRIntlFlightMapping, cJRIntlFlightMapping2)).booleanValue();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: java.util.List<T>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v19, resolved type: java.util.List<T>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v24, resolved type: java.util.List<T>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v28, resolved type: java.util.List<T>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v32, resolved type: java.util.List<T>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v36, resolved type: java.util.List<T>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v40, resolved type: java.util.List<T>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v44, resolved type: java.util.List<T>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0313  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x036b  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x03c3  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x041b  */
    /* JADX WARNING: Removed duplicated region for block: B:294:0x02d9 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:300:0x0331 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:306:0x0389 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:312:0x03e1 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.List<com.travel.flight.pojo.flightticket.CJRIntlFlightMapping> a(java.util.List<? extends com.travel.flight.pojo.flightticket.CJRIntlFlightMapping> r16, java.util.List<? extends com.travel.flight.flightSRPV2.a.x> r17, java.util.List<? extends com.travel.flight.flightSRPV2.a.x> r18, com.travel.flight.flightSRPV2.a.ae r19) {
        /*
            r0 = r17
            r1 = r18
            java.lang.String r2 = "flightMappings"
            r3 = r16
            kotlin.g.b.k.c(r3, r2)
            java.lang.String r2 = "onwardFilters"
            kotlin.g.b.k.c(r0, r2)
            java.lang.String r4 = "returnFilters"
            kotlin.g.b.k.c(r1, r4)
            java.util.List r3 = g(r16)
            java.lang.String r5 = "flights"
            kotlin.g.b.k.c(r3, r5)
            kotlin.g.b.k.c(r0, r2)
            kotlin.g.b.k.c(r1, r4)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r4 = r0.iterator()
        L_0x0031:
            boolean r5 = r4.hasNext()
            r6 = 4
            r7 = 7
            r8 = 0
            r9 = 1
            if (r5 == 0) goto L_0x005b
            java.lang.Object r5 = r4.next()
            r10 = r5
            com.travel.flight.flightSRPV2.a.x r10 = (com.travel.flight.flightSRPV2.a.x) r10
            int r11 = r10.e()
            if (r11 == r7) goto L_0x0055
            int r7 = r10.e()
            if (r7 == r6) goto L_0x0055
            int r6 = r10.e()
            if (r6 == r9) goto L_0x0055
            r8 = 1
        L_0x0055:
            if (r8 == 0) goto L_0x0031
            r2.add(r5)
            goto L_0x0031
        L_0x005b:
            java.util.List r2 = (java.util.List) r2
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r4 = new java.util.ArrayList
            int r5 = kotlin.a.k.a(r2)
            r4.<init>(r5)
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.Iterator r2 = r2.iterator()
        L_0x006e:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x0082
            java.lang.Object r5 = r2.next()
            com.travel.flight.flightSRPV2.a.x r5 = (com.travel.flight.flightSRPV2.a.x) r5
            kotlin.g.a.b r5 = r5.f()
            r4.add(r5)
            goto L_0x006e
        L_0x0082:
            java.util.List r4 = (java.util.List) r4
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r5 = r1.iterator()
        L_0x0091:
            boolean r10 = r5.hasNext()
            if (r10 == 0) goto L_0x00b9
            java.lang.Object r10 = r5.next()
            r11 = r10
            com.travel.flight.flightSRPV2.a.x r11 = (com.travel.flight.flightSRPV2.a.x) r11
            int r12 = r11.e()
            if (r12 == r7) goto L_0x00b2
            int r12 = r11.e()
            if (r12 == r6) goto L_0x00b2
            int r11 = r11.e()
            if (r11 == r9) goto L_0x00b2
            r11 = 1
            goto L_0x00b3
        L_0x00b2:
            r11 = 0
        L_0x00b3:
            if (r11 == 0) goto L_0x0091
            r2.add(r10)
            goto L_0x0091
        L_0x00b9:
            java.util.List r2 = (java.util.List) r2
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r5 = new java.util.ArrayList
            int r10 = kotlin.a.k.a(r2)
            r5.<init>(r10)
            java.util.Collection r5 = (java.util.Collection) r5
            java.util.Iterator r2 = r2.iterator()
        L_0x00cc:
            boolean r10 = r2.hasNext()
            if (r10 == 0) goto L_0x00e0
            java.lang.Object r10 = r2.next()
            com.travel.flight.flightSRPV2.a.x r10 = (com.travel.flight.flightSRPV2.a.x) r10
            kotlin.g.a.b r10 = r10.f()
            r5.add(r10)
            goto L_0x00cc
        L_0x00e0:
            java.util.List r5 = (java.util.List) r5
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r10 = r0.iterator()
        L_0x00ed:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x0109
            java.lang.Object r11 = r10.next()
            r12 = r11
            com.travel.flight.flightSRPV2.a.x r12 = (com.travel.flight.flightSRPV2.a.x) r12
            int r12 = r12.e()
            if (r12 != r6) goto L_0x0102
            r12 = 1
            goto L_0x0103
        L_0x0102:
            r12 = 0
        L_0x0103:
            if (r12 == 0) goto L_0x00ed
            r2.add(r11)
            goto L_0x00ed
        L_0x0109:
            java.util.List r2 = (java.util.List) r2
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r10 = new java.util.ArrayList
            int r11 = kotlin.a.k.a(r2)
            r10.<init>(r11)
            java.util.Collection r10 = (java.util.Collection) r10
            java.util.Iterator r2 = r2.iterator()
        L_0x011c:
            boolean r11 = r2.hasNext()
            if (r11 == 0) goto L_0x0130
            java.lang.Object r11 = r2.next()
            com.travel.flight.flightSRPV2.a.x r11 = (com.travel.flight.flightSRPV2.a.x) r11
            kotlin.g.a.b r11 = r11.j()
            r10.add(r11)
            goto L_0x011c
        L_0x0130:
            java.util.List r10 = (java.util.List) r10
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r11 = r1.iterator()
        L_0x013d:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x0159
            java.lang.Object r12 = r11.next()
            r13 = r12
            com.travel.flight.flightSRPV2.a.x r13 = (com.travel.flight.flightSRPV2.a.x) r13
            int r13 = r13.e()
            if (r13 != r6) goto L_0x0152
            r13 = 1
            goto L_0x0153
        L_0x0152:
            r13 = 0
        L_0x0153:
            if (r13 == 0) goto L_0x013d
            r2.add(r12)
            goto L_0x013d
        L_0x0159:
            java.util.List r2 = (java.util.List) r2
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r6 = new java.util.ArrayList
            int r11 = kotlin.a.k.a(r2)
            r6.<init>(r11)
            java.util.Collection r6 = (java.util.Collection) r6
            java.util.Iterator r2 = r2.iterator()
        L_0x016c:
            boolean r11 = r2.hasNext()
            if (r11 == 0) goto L_0x0180
            java.lang.Object r11 = r2.next()
            com.travel.flight.flightSRPV2.a.x r11 = (com.travel.flight.flightSRPV2.a.x) r11
            kotlin.g.a.b r11 = r11.j()
            r6.add(r11)
            goto L_0x016c
        L_0x0180:
            java.util.List r6 = (java.util.List) r6
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r11 = r0.iterator()
        L_0x018d:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x01a9
            java.lang.Object r12 = r11.next()
            r13 = r12
            com.travel.flight.flightSRPV2.a.x r13 = (com.travel.flight.flightSRPV2.a.x) r13
            int r13 = r13.e()
            if (r13 != r9) goto L_0x01a2
            r13 = 1
            goto L_0x01a3
        L_0x01a2:
            r13 = 0
        L_0x01a3:
            if (r13 == 0) goto L_0x018d
            r2.add(r12)
            goto L_0x018d
        L_0x01a9:
            java.util.List r2 = (java.util.List) r2
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r11 = new java.util.ArrayList
            int r12 = kotlin.a.k.a(r2)
            r11.<init>(r12)
            java.util.Collection r11 = (java.util.Collection) r11
            java.util.Iterator r2 = r2.iterator()
        L_0x01bc:
            boolean r12 = r2.hasNext()
            if (r12 == 0) goto L_0x01d0
            java.lang.Object r12 = r2.next()
            com.travel.flight.flightSRPV2.a.x r12 = (com.travel.flight.flightSRPV2.a.x) r12
            kotlin.g.a.b r12 = r12.j()
            r11.add(r12)
            goto L_0x01bc
        L_0x01d0:
            java.util.List r11 = (java.util.List) r11
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r12 = r1.iterator()
        L_0x01dd:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x01f9
            java.lang.Object r13 = r12.next()
            r14 = r13
            com.travel.flight.flightSRPV2.a.x r14 = (com.travel.flight.flightSRPV2.a.x) r14
            int r14 = r14.e()
            if (r14 != r9) goto L_0x01f2
            r14 = 1
            goto L_0x01f3
        L_0x01f2:
            r14 = 0
        L_0x01f3:
            if (r14 == 0) goto L_0x01dd
            r2.add(r13)
            goto L_0x01dd
        L_0x01f9:
            java.util.List r2 = (java.util.List) r2
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r12 = new java.util.ArrayList
            int r13 = kotlin.a.k.a(r2)
            r12.<init>(r13)
            java.util.Collection r12 = (java.util.Collection) r12
            java.util.Iterator r2 = r2.iterator()
        L_0x020c:
            boolean r13 = r2.hasNext()
            if (r13 == 0) goto L_0x0220
            java.lang.Object r13 = r2.next()
            com.travel.flight.flightSRPV2.a.x r13 = (com.travel.flight.flightSRPV2.a.x) r13
            kotlin.g.a.b r13 = r13.j()
            r12.add(r13)
            goto L_0x020c
        L_0x0220:
            java.util.List r12 = (java.util.List) r12
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r0 = r0.iterator()
        L_0x022d:
            boolean r13 = r0.hasNext()
            if (r13 == 0) goto L_0x0249
            java.lang.Object r13 = r0.next()
            r14 = r13
            com.travel.flight.flightSRPV2.a.x r14 = (com.travel.flight.flightSRPV2.a.x) r14
            int r14 = r14.e()
            if (r14 != r7) goto L_0x0242
            r14 = 1
            goto L_0x0243
        L_0x0242:
            r14 = 0
        L_0x0243:
            if (r14 == 0) goto L_0x022d
            r2.add(r13)
            goto L_0x022d
        L_0x0249:
            java.util.List r2 = (java.util.List) r2
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r0 = new java.util.ArrayList
            int r13 = kotlin.a.k.a(r2)
            r0.<init>(r13)
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r2 = r2.iterator()
        L_0x025c:
            boolean r13 = r2.hasNext()
            if (r13 == 0) goto L_0x0270
            java.lang.Object r13 = r2.next()
            com.travel.flight.flightSRPV2.a.x r13 = (com.travel.flight.flightSRPV2.a.x) r13
            kotlin.g.a.b r13 = r13.f()
            r0.add(r13)
            goto L_0x025c
        L_0x0270:
            java.util.List r0 = (java.util.List) r0
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r1 = r1.iterator()
        L_0x027d:
            boolean r13 = r1.hasNext()
            if (r13 == 0) goto L_0x0299
            java.lang.Object r13 = r1.next()
            r14 = r13
            com.travel.flight.flightSRPV2.a.x r14 = (com.travel.flight.flightSRPV2.a.x) r14
            int r14 = r14.e()
            if (r14 != r7) goto L_0x0292
            r14 = 1
            goto L_0x0293
        L_0x0292:
            r14 = 0
        L_0x0293:
            if (r14 == 0) goto L_0x027d
            r2.add(r13)
            goto L_0x027d
        L_0x0299:
            java.util.List r2 = (java.util.List) r2
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r1 = new java.util.ArrayList
            int r7 = kotlin.a.k.a(r2)
            r1.<init>(r7)
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r2 = r2.iterator()
        L_0x02ac:
            boolean r7 = r2.hasNext()
            if (r7 == 0) goto L_0x02c0
            java.lang.Object r7 = r2.next()
            com.travel.flight.flightSRPV2.a.x r7 = (com.travel.flight.flightSRPV2.a.x) r7
            kotlin.g.a.b r7 = r7.f()
            r1.add(r7)
            goto L_0x02ac
        L_0x02c0:
            java.util.List r1 = (java.util.List) r1
            r2 = r10
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            r2 = r2 ^ r9
            if (r2 == 0) goto L_0x031a
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r3 = r3.iterator()
        L_0x02d9:
            boolean r7 = r3.hasNext()
            if (r7 == 0) goto L_0x0317
            java.lang.Object r7 = r3.next()
            r13 = r7
            com.travel.flight.pojo.flightticket.CJRIntlFlightMapping r13 = (com.travel.flight.pojo.flightticket.CJRIntlFlightMapping) r13
            r14 = r10
            java.lang.Iterable r14 = (java.lang.Iterable) r14
            r15 = r14
            java.util.Collection r15 = (java.util.Collection) r15
            boolean r15 = r15.isEmpty()
            if (r15 != 0) goto L_0x0310
            java.util.Iterator r14 = r14.iterator()
        L_0x02f6:
            boolean r15 = r14.hasNext()
            if (r15 == 0) goto L_0x0310
            java.lang.Object r15 = r14.next()
            kotlin.g.a.b r15 = (kotlin.g.a.b) r15
            java.lang.Object r15 = r15.invoke(r13)
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            if (r15 == 0) goto L_0x02f6
            r13 = 1
            goto L_0x0311
        L_0x0310:
            r13 = 0
        L_0x0311:
            if (r13 == 0) goto L_0x02d9
            r2.add(r7)
            goto L_0x02d9
        L_0x0317:
            r3 = r2
            java.util.List r3 = (java.util.List) r3
        L_0x031a:
            r2 = r6
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            r2 = r2 ^ r9
            if (r2 == 0) goto L_0x0372
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r3 = r3.iterator()
        L_0x0331:
            boolean r7 = r3.hasNext()
            if (r7 == 0) goto L_0x036f
            java.lang.Object r7 = r3.next()
            r10 = r7
            com.travel.flight.pojo.flightticket.CJRIntlFlightMapping r10 = (com.travel.flight.pojo.flightticket.CJRIntlFlightMapping) r10
            r13 = r6
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            r14 = r13
            java.util.Collection r14 = (java.util.Collection) r14
            boolean r14 = r14.isEmpty()
            if (r14 != 0) goto L_0x0368
            java.util.Iterator r13 = r13.iterator()
        L_0x034e:
            boolean r14 = r13.hasNext()
            if (r14 == 0) goto L_0x0368
            java.lang.Object r14 = r13.next()
            kotlin.g.a.b r14 = (kotlin.g.a.b) r14
            java.lang.Object r14 = r14.invoke(r10)
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            boolean r14 = r14.booleanValue()
            if (r14 == 0) goto L_0x034e
            r10 = 1
            goto L_0x0369
        L_0x0368:
            r10 = 0
        L_0x0369:
            if (r10 == 0) goto L_0x0331
            r2.add(r7)
            goto L_0x0331
        L_0x036f:
            r3 = r2
            java.util.List r3 = (java.util.List) r3
        L_0x0372:
            r2 = r11
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            r2 = r2 ^ r9
            if (r2 == 0) goto L_0x03ca
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r3 = r3.iterator()
        L_0x0389:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x03c7
            java.lang.Object r6 = r3.next()
            r7 = r6
            com.travel.flight.pojo.flightticket.CJRIntlFlightMapping r7 = (com.travel.flight.pojo.flightticket.CJRIntlFlightMapping) r7
            r10 = r11
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            r13 = r10
            java.util.Collection r13 = (java.util.Collection) r13
            boolean r13 = r13.isEmpty()
            if (r13 != 0) goto L_0x03c0
            java.util.Iterator r10 = r10.iterator()
        L_0x03a6:
            boolean r13 = r10.hasNext()
            if (r13 == 0) goto L_0x03c0
            java.lang.Object r13 = r10.next()
            kotlin.g.a.b r13 = (kotlin.g.a.b) r13
            java.lang.Object r13 = r13.invoke(r7)
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 == 0) goto L_0x03a6
            r7 = 1
            goto L_0x03c1
        L_0x03c0:
            r7 = 0
        L_0x03c1:
            if (r7 == 0) goto L_0x0389
            r2.add(r6)
            goto L_0x0389
        L_0x03c7:
            r3 = r2
            java.util.List r3 = (java.util.List) r3
        L_0x03ca:
            r2 = r12
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            r2 = r2 ^ r9
            if (r2 == 0) goto L_0x0422
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r3 = r3.iterator()
        L_0x03e1:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x041f
            java.lang.Object r6 = r3.next()
            r7 = r6
            com.travel.flight.pojo.flightticket.CJRIntlFlightMapping r7 = (com.travel.flight.pojo.flightticket.CJRIntlFlightMapping) r7
            r10 = r12
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            r11 = r10
            java.util.Collection r11 = (java.util.Collection) r11
            boolean r11 = r11.isEmpty()
            if (r11 != 0) goto L_0x0418
            java.util.Iterator r10 = r10.iterator()
        L_0x03fe:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x0418
            java.lang.Object r11 = r10.next()
            kotlin.g.a.b r11 = (kotlin.g.a.b) r11
            java.lang.Object r11 = r11.invoke(r7)
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L_0x03fe
            r7 = 1
            goto L_0x0419
        L_0x0418:
            r7 = 0
        L_0x0419:
            if (r7 == 0) goto L_0x03e1
            r2.add(r6)
            goto L_0x03e1
        L_0x041f:
            r3 = r2
            java.util.List r3 = (java.util.List) r3
        L_0x0422:
            r2 = r0
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            r2 = r2 ^ r9
            java.lang.String r6 = "flight.onwardItem"
            if (r2 == 0) goto L_0x0483
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r3 = r3.iterator()
        L_0x043b:
            boolean r7 = r3.hasNext()
            if (r7 == 0) goto L_0x0480
            java.lang.Object r7 = r3.next()
            r10 = r7
            com.travel.flight.pojo.flightticket.CJRIntlFlightMapping r10 = (com.travel.flight.pojo.flightticket.CJRIntlFlightMapping) r10
            r11 = r0
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            r12 = r11
            java.util.Collection r12 = (java.util.Collection) r12
            boolean r12 = r12.isEmpty()
            if (r12 != 0) goto L_0x0479
            java.util.Iterator r11 = r11.iterator()
        L_0x0458:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x0479
            java.lang.Object r12 = r11.next()
            kotlin.g.a.b r12 = (kotlin.g.a.b) r12
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r13 = r10.getOnwardItem()
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r6)
            java.lang.Object r12 = r12.invoke(r13)
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L_0x0458
            r10 = 1
            goto L_0x047a
        L_0x0479:
            r10 = 0
        L_0x047a:
            if (r10 == 0) goto L_0x043b
            r2.add(r7)
            goto L_0x043b
        L_0x0480:
            r3 = r2
            java.util.List r3 = (java.util.List) r3
        L_0x0483:
            r0 = r1
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r9
            java.lang.String r2 = "flight.returnItem"
            if (r0 == 0) goto L_0x04e4
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r3 = r3.iterator()
        L_0x049c:
            boolean r7 = r3.hasNext()
            if (r7 == 0) goto L_0x04e1
            java.lang.Object r7 = r3.next()
            r10 = r7
            com.travel.flight.pojo.flightticket.CJRIntlFlightMapping r10 = (com.travel.flight.pojo.flightticket.CJRIntlFlightMapping) r10
            r11 = r1
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            r12 = r11
            java.util.Collection r12 = (java.util.Collection) r12
            boolean r12 = r12.isEmpty()
            if (r12 != 0) goto L_0x04da
            java.util.Iterator r11 = r11.iterator()
        L_0x04b9:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x04da
            java.lang.Object r12 = r11.next()
            kotlin.g.a.b r12 = (kotlin.g.a.b) r12
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r13 = r10.getReturnItem()
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r2)
            java.lang.Object r12 = r12.invoke(r13)
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L_0x04b9
            r10 = 1
            goto L_0x04db
        L_0x04da:
            r10 = 0
        L_0x04db:
            if (r10 == 0) goto L_0x049c
            r0.add(r7)
            goto L_0x049c
        L_0x04e1:
            r3 = r0
            java.util.List r3 = (java.util.List) r3
        L_0x04e4:
            r0 = r4
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r9
            if (r0 == 0) goto L_0x0543
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r1 = r3.iterator()
        L_0x04fb:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0540
            java.lang.Object r3 = r1.next()
            r7 = r3
            com.travel.flight.pojo.flightticket.CJRIntlFlightMapping r7 = (com.travel.flight.pojo.flightticket.CJRIntlFlightMapping) r7
            r10 = r4
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            r11 = r10
            java.util.Collection r11 = (java.util.Collection) r11
            boolean r11 = r11.isEmpty()
            if (r11 != 0) goto L_0x0539
            java.util.Iterator r10 = r10.iterator()
        L_0x0518:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x0539
            java.lang.Object r11 = r10.next()
            kotlin.g.a.b r11 = (kotlin.g.a.b) r11
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r12 = r7.getOnwardItem()
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r6)
            java.lang.Object r11 = r11.invoke(r12)
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 != 0) goto L_0x0518
            r7 = 0
            goto L_0x053a
        L_0x0539:
            r7 = 1
        L_0x053a:
            if (r7 == 0) goto L_0x04fb
            r0.add(r3)
            goto L_0x04fb
        L_0x0540:
            r3 = r0
            java.util.List r3 = (java.util.List) r3
        L_0x0543:
            r0 = r5
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r9
            if (r0 == 0) goto L_0x05a2
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r1 = r3.iterator()
        L_0x055a:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x059f
            java.lang.Object r3 = r1.next()
            r4 = r3
            com.travel.flight.pojo.flightticket.CJRIntlFlightMapping r4 = (com.travel.flight.pojo.flightticket.CJRIntlFlightMapping) r4
            r6 = r5
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            r7 = r6
            java.util.Collection r7 = (java.util.Collection) r7
            boolean r7 = r7.isEmpty()
            if (r7 != 0) goto L_0x0598
            java.util.Iterator r6 = r6.iterator()
        L_0x0577:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0598
            java.lang.Object r7 = r6.next()
            kotlin.g.a.b r7 = (kotlin.g.a.b) r7
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r10 = r4.getReturnItem()
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r2)
            java.lang.Object r7 = r7.invoke(r10)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L_0x0577
            r4 = 0
            goto L_0x0599
        L_0x0598:
            r4 = 1
        L_0x0599:
            if (r4 == 0) goto L_0x055a
            r0.add(r3)
            goto L_0x055a
        L_0x059f:
            r3 = r0
            java.util.List r3 = (java.util.List) r3
        L_0x05a2:
            if (r19 == 0) goto L_0x05af
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Comparator r0 = r19.d()
            java.util.List r0 = kotlin.a.k.a(r3, r0)
            return r0
        L_0x05af:
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            com.travel.flight.flightSRPV2.a.q r0 = new com.travel.flight.flightSRPV2.a.q
            r0.<init>(r8)
            java.util.Comparator r0 = r0.d()
            java.util.List r0 = kotlin.a.k.a(r3, r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightSRPV2.a.t.a(java.util.List, java.util.List, java.util.List, com.travel.flight.flightSRPV2.a.ae):java.util.List");
    }

    private static final void e(List<? extends CJRFlightDetailsItem> list) {
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            CJRFlightDetailsItem cJRFlightDetailsItem = (CJRFlightDetailsItem) list.get(i2);
            CharSequence charSequence = cJRFlightDetailsItem.getmFlightId();
            int i3 = 1;
            if ((charSequence == null || charSequence.length() == 0) || cJRFlightDetailsItem.ismIsParent()) {
                boolean z = i2 <= 0 || ((CJRFlightDetailsItem) list.get(i2 + -1)).getViewType() == 1;
                boolean z2 = i2 >= list.size() - 1 || ((CJRFlightDetailsItem) list.get(i2 + 1)).getViewType() == 1;
                if (!z || !z2) {
                    if (z) {
                        i3 = 2;
                    } else if (!z2) {
                    }
                    cJRFlightDetailsItem.setPosState(i3);
                    i2++;
                } else {
                    i3 = 4;
                    cJRFlightDetailsItem.setPosState(i3);
                    i2++;
                }
            } else {
                if (!(i2 >= list.size() - 1 || ((CJRFlightDetailsItem) list.get(i2 + 1)).getViewType() == 2)) {
                    cJRFlightDetailsItem.setPosState(i3);
                    i2++;
                }
            }
            i3 = 3;
            cJRFlightDetailsItem.setPosState(i3);
            i2++;
        }
    }

    private static final int a(CJRFlightDetailsItem cJRFlightDetailsItem) {
        if (!TextUtils.isEmpty(cJRFlightDetailsItem.getmFlightId())) {
            if (!cJRFlightDetailsItem.ismIsParent()) {
                return 3;
            }
        } else if (k.a((Object) cJRFlightDetailsItem.getFilterStripItem(), (Object) Boolean.TRUE)) {
            return 12;
        } else {
            if (!TextUtils.isEmpty(cJRFlightDetailsItem.getHeaderType())) {
                return 1;
            }
            if (k.a((Object) cJRFlightDetailsItem.getmListItemType(), (Object) "filter_list_type")) {
                if (k.a((Object) cJRFlightDetailsItem.getmListItemData().getmType(), (Object) "banner")) {
                    return 4;
                }
                if (k.a((Object) cJRFlightDetailsItem.getmListItemData().getmType(), (Object) StringSet.filter)) {
                    String str = cJRFlightDetailsItem.getmListItemData().getmFilterName();
                    if (str != null) {
                        switch (str.hashCode()) {
                            case -1992012396:
                                if (str.equals(AppConstants.DURATION)) {
                                    return 7;
                                }
                                break;
                            case -1219557132:
                                if (str.equals("departure")) {
                                    return 5;
                                }
                                break;
                            case -734206983:
                                if (str.equals("arrival")) {
                                    return 6;
                                }
                                break;
                            case -680782859:
                                if (str.equals("airlines")) {
                                    return 8;
                                }
                                break;
                            case 106934601:
                                if (str.equals("price")) {
                                    return 9;
                                }
                                break;
                        }
                    }
                    return 4;
                }
            }
        }
        return 2;
    }

    private static void f(List<? extends CJRFlightDetailsItem> list) {
        k.c(list, "flights");
        for (CJRFlightDetailsItem cJRFlightDetailsItem : list) {
            cJRFlightDetailsItem.setViewType(a(cJRFlightDetailsItem));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00cd A[LOOP:0: B:24:0x00cb->B:25:0x00cd, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0158  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<com.travel.flight.pojo.flightticket.CJRFlightDetailsItem> a(java.util.List<? extends com.travel.flight.pojo.flightticket.CJRFlightDetailsItem> r18, java.util.List<? extends com.travel.flight.pojo.flightticket.CJRFlightCardInfo> r19, com.travel.flight.pojo.flightticket.CJRFlightSearchResult r20, com.travel.flight.flightSRPV2.a.ae r21, java.util.List<? extends com.travel.flight.flightSRPV2.a.x> r22, int r23) {
        /*
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r22
            java.lang.String r5 = "flights"
            kotlin.g.b.k.c(r0, r5)
            java.lang.String r5 = "cards"
            kotlin.g.b.k.c(r1, r5)
            java.lang.String r5 = "srpResult"
            kotlin.g.b.k.c(r2, r5)
            java.lang.String r5 = "existingFilters"
            kotlin.g.b.k.c(r4, r5)
            r5 = 1
            com.travel.flight.flightSRPV2.a.u r6 = a((com.travel.flight.pojo.flightticket.CJRFlightSearchResult) r2, (boolean) r5)
            kotlin.a.w r7 = kotlin.a.w.INSTANCE
            java.util.List r7 = (java.util.List) r7
            com.travel.flight.pojo.flightticket.CJROnwardReturnFlightInformation r8 = r20.getmOnwardReturnFlights()
            com.travel.flight.pojo.flightticket.CJRMeta r8 = r8.getmCJRMeta()
            if (r8 == 0) goto L_0x00bb
            com.travel.flight.pojo.flightticket.CJROnwardReturnFlightInformation r8 = r20.getmOnwardReturnFlights()
            com.travel.flight.pojo.flightticket.CJRMeta r8 = r8.getmCJRMeta()
            java.lang.String r9 = "srpResult.getmOnwardReturnFlights().getmCJRMeta()"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)
            com.travel.flight.pojo.flightticket.CJRFBI r8 = r8.getFilterAndBannerInfo()
            if (r8 == 0) goto L_0x00bb
            com.travel.flight.pojo.flightticket.CJROnwardReturnFlightInformation r7 = r20.getmOnwardReturnFlights()
            com.travel.flight.pojo.flightticket.CJRMeta r7 = r7.getmCJRMeta()
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r9)
            com.travel.flight.pojo.flightticket.CJRFBI r7 = r7.getFilterAndBannerInfo()
            java.lang.String r8 = "filterBannerList"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r8)
            com.travel.flight.pojo.flightticket.CJRDisplayInfo r8 = r7.getDisplayInfo()
            java.lang.String r9 = "it"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)
            com.travel.flight.pojo.flightticket.CJRFilterAndBannerOrder r8 = r8.getOnwardInfo()
            boolean r9 = r3 instanceof com.travel.flight.flightSRPV2.a.j
            java.lang.String r10 = "order"
            if (r9 == 0) goto L_0x007a
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r10)
            java.util.List r3 = r8.getDuration()
            java.lang.String r8 = "order.duration"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r8)
            goto L_0x00c1
        L_0x007a:
            boolean r9 = r3 instanceof com.travel.flight.flightSRPV2.a.h
            if (r9 == 0) goto L_0x0094
            boolean r3 = r3.f24082a
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r10)
            if (r3 == 0) goto L_0x008a
            java.util.List r3 = r8.getEarly_departure()
            goto L_0x008e
        L_0x008a:
            java.util.List r3 = r8.getLate_departure()
        L_0x008e:
            java.lang.String r8 = "if (sortOption.asc) orde…else order.late_departure"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r8)
            goto L_0x00c1
        L_0x0094:
            boolean r9 = r3 instanceof com.travel.flight.flightSRPV2.a.e
            if (r9 == 0) goto L_0x00ae
            boolean r3 = r3.f24082a
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r10)
            if (r3 == 0) goto L_0x00a4
            java.util.List r3 = r8.getEarly_arrival()
            goto L_0x00a8
        L_0x00a4:
            java.util.List r3 = r8.getLate_arrival()
        L_0x00a8:
            java.lang.String r8 = "if (sortOption.asc) orde…l else order.late_arrival"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r8)
            goto L_0x00c1
        L_0x00ae:
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r10)
            java.util.List r3 = r8.getCheapest()
            java.lang.String r8 = "order.cheapest"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r8)
            goto L_0x00c1
        L_0x00bb:
            r3 = 0
            r17 = r7
            r7 = r3
            r3 = r17
        L_0x00c1:
            r8 = r1
            java.util.Collection r8 = (java.util.Collection) r8
            int r8 = r8.size()
            r9 = 0
            r10 = 0
            r11 = 0
        L_0x00cb:
            if (r10 >= r8) goto L_0x00e5
            java.lang.Object r12 = r1.get(r10)
            com.travel.flight.pojo.flightticket.CJRFlightCardInfo r12 = (com.travel.flight.pojo.flightticket.CJRFlightCardInfo) r12
            r12.setListItemPos(r11)
            java.lang.Object r12 = r1.get(r10)
            com.travel.flight.pojo.flightticket.CJRFlightCardInfo r12 = (com.travel.flight.pojo.flightticket.CJRFlightCardInfo) r12
            int r12 = r12.getFlightLength()
            int r11 = r11 + r12
            int r11 = r11 + r10
            int r10 = r10 + 1
            goto L_0x00cb
        L_0x00e5:
            java.util.ArrayList r8 = new java.util.ArrayList
            int r10 = r18.size()
            int r11 = r19.size()
            int r10 = r10 + r11
            int r11 = r3.size()
            int r10 = r10 + r11
            int r10 = r10 + r5
            r8.<init>(r10)
            com.google.gsonhtcfix.f r10 = new com.google.gsonhtcfix.f
            r10.<init>()
            java.util.List r11 = a((java.util.List<? extends com.travel.flight.flightSRPV2.a.x>) r22)
            java.util.Collection r11 = (java.util.Collection) r11
            boolean r11 = r11.isEmpty()
            if (r11 != 0) goto L_0x0117
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r11 = new com.travel.flight.pojo.flightticket.CJRFlightDetailsItem
            r11.<init>()
            java.lang.Boolean r12 = java.lang.Boolean.TRUE
            r11.setFilterStripItem(r12)
            r8.add(r11)
        L_0x0117:
            boolean r11 = r19.isEmpty()
            java.lang.String r12 = "HeaderType"
            if (r11 == 0) goto L_0x014d
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r11 = new com.travel.flight.pojo.flightticket.CJRFlightDetailsItem
            r11.<init>()
            r11.setHeaderType(r12)
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r14 = "Showing "
            r13.<init>(r14)
            r14 = r23
            r13.append(r14)
            java.lang.String r14 = " flight(s)"
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            r11.setHeaderText(r13)
            boolean r13 = b((com.travel.flight.pojo.flightticket.CJRFlightSearchResult) r20)
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r13)
            r11.setShowIsFarePerAdult(r13)
            r8.add(r11)
        L_0x014d:
            r11 = r0
            java.util.Collection r11 = (java.util.Collection) r11
            int r11 = r11.size()
            r13 = 0
            r14 = 0
        L_0x0156:
            if (r9 >= r11) goto L_0x01cb
            int r15 = r19.size()
            if (r13 >= r15) goto L_0x018f
            java.lang.Object r15 = r1.get(r13)
            com.travel.flight.pojo.flightticket.CJRFlightCardInfo r15 = (com.travel.flight.pojo.flightticket.CJRFlightCardInfo) r15
            int r15 = r15.getListItemPos()
            if (r9 != r15) goto L_0x018f
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r15 = new com.travel.flight.pojo.flightticket.CJRFlightDetailsItem
            r15.<init>()
            r15.setHeaderType(r12)
            java.lang.Object r16 = r1.get(r13)
            com.travel.flight.pojo.flightticket.CJRFlightCardInfo r16 = (com.travel.flight.pojo.flightticket.CJRFlightCardInfo) r16
            java.lang.String r5 = r16.getText()
            r15.setHeaderText(r5)
            boolean r5 = b((com.travel.flight.pojo.flightticket.CJRFlightSearchResult) r20)
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            r15.setShowIsFarePerAdult(r5)
            r8.add(r15)
            int r13 = r13 + 1
        L_0x018f:
            if (r7 == 0) goto L_0x01b6
            if (r9 == 0) goto L_0x01b6
            int r5 = r7.getInterval()
            r15 = 1
            int r5 = r5 - r15
            int r5 = r9 % r5
            if (r5 != 0) goto L_0x01b7
            int r5 = r3.size()
            if (r14 >= r5) goto L_0x01b7
            int r5 = r14 + 1
            java.lang.Object r14 = r3.get(r14)
            java.lang.String r14 = (java.lang.String) r14
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r14 = a((com.travel.flight.pojo.flightticket.CJRFBI) r7, (java.lang.String) r14, (com.travel.flight.flightSRPV2.a.u) r6, (java.util.List<? extends com.travel.flight.flightSRPV2.a.x>) r4)
            if (r14 == 0) goto L_0x01b4
            r8.add(r14)
        L_0x01b4:
            r14 = r5
            goto L_0x01b7
        L_0x01b6:
            r15 = 1
        L_0x01b7:
            java.lang.Object r5 = r0.get(r9)
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r5 = (com.travel.flight.pojo.flightticket.CJRFlightDetailsItem) r5
            a((com.travel.flight.pojo.flightticket.CJRFlightDetailsItem) r5, (com.google.gsonhtcfix.f) r10)
            java.lang.Object r5 = r0.get(r9)
            r8.add(r5)
            int r9 = r9 + 1
            r5 = 1
            goto L_0x0156
        L_0x01cb:
            java.util.List r8 = (java.util.List) r8
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightSRPV2.a.t.a(java.util.List, java.util.List, com.travel.flight.pojo.flightticket.CJRFlightSearchResult, com.travel.flight.flightSRPV2.a.ae, java.util.List, int):java.util.List");
    }

    private static final void a(CJRFlightDetailsItem cJRFlightDetailsItem, com.google.gsonhtcfix.f fVar) {
        c(cJRFlightDetailsItem);
        androidx.databinding.i iVar = new androidx.databinding.i();
        iVar.set(Boolean.FALSE);
        cJRFlightDetailsItem.setIsExpanded(iVar);
        if (cJRFlightDetailsItem.ismIsParent()) {
            Collection childItems = cJRFlightDetailsItem.getChildItems();
            if (!(childItems == null || childItems.isEmpty())) {
                List<CJRFlightDetailsItem> childItems2 = cJRFlightDetailsItem.getChildItems();
                if (childItems2 == null) {
                    k.a();
                }
                CJRFlightDetailsItem cJRFlightDetailsItem2 = (CJRFlightDetailsItem) fVar.a(fVar.a((Object) cJRFlightDetailsItem), CJRFlightDetailsItem.class);
                cJRFlightDetailsItem2.setmParentId(cJRFlightDetailsItem.getmFlightId());
                cJRFlightDetailsItem2.setmIsParent(false);
                androidx.databinding.i iVar2 = new androidx.databinding.i();
                iVar2.set(Boolean.FALSE);
                cJRFlightDetailsItem2.setIsExpanded(iVar2);
                childItems2.add(0, cJRFlightDetailsItem2);
                for (CJRFlightDetailsItem next : childItems2) {
                    k.a((Object) next, "child");
                    c(next);
                    androidx.databinding.i iVar3 = new androidx.databinding.i();
                    iVar3.set(Boolean.FALSE);
                    next.setIsExpanded(iVar3);
                }
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x02ee, code lost:
        r8 = r1;
        r1 = r10;
        r10 = r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final com.travel.flight.pojo.flightticket.CJRFlightDetailsItem a(com.travel.flight.pojo.flightticket.CJRFBI r9, java.lang.String r10, com.travel.flight.flightSRPV2.a.u r11, java.util.List<? extends com.travel.flight.flightSRPV2.a.x> r12) {
        /*
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r0 = 1
            char[] r1 = new char[r0]
            r2 = 0
            r3 = 95
            r1[r2] = r3
            java.lang.String r3 = "$this$split"
            kotlin.g.b.k.d(r10, r3)
            java.lang.String r3 = "delimiters"
            kotlin.g.b.k.d(r1, r3)
            char r1 = r1[r2]
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.util.List r10 = kotlin.m.z.b((java.lang.CharSequence) r10, (java.lang.String) r1)
            java.lang.Object r1 = r10.get(r2)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r10 = r10.get(r0)
            java.lang.String r10 = (java.lang.String) r10
            int r10 = java.lang.Integer.parseInt(r10)
            java.lang.String r3 = "b"
            boolean r3 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r3, (boolean) r0)
            java.lang.String r4 = "filter"
            r5 = 0
            if (r3 == 0) goto L_0x007c
            java.util.List r1 = r9.getBanners()
            java.lang.Object r1 = r1.get(r10)
            java.lang.String r1 = (java.lang.String) r1
            com.travel.flight.pojo.flightticket.CJRFilterAndBannerInfoItem r3 = new com.travel.flight.pojo.flightticket.CJRFilterAndBannerInfoItem
            r3.<init>()
            java.lang.String r6 = "banner"
            r3.setmType(r6)
            r3.setmBannerUrl(r1)
            java.util.Map r1 = r9.getBannersNew()
            if (r1 == 0) goto L_0x0092
            java.util.Map r1 = r9.getBannersNew()
            java.lang.String r6 = java.lang.String.valueOf(r10)
            boolean r1 = r1.containsKey(r6)
            if (r1 == 0) goto L_0x0092
            java.util.Map r9 = r9.getBannersNew()
            java.lang.String r10 = java.lang.String.valueOf(r10)
            java.lang.Object r9 = r9.get(r10)
            com.travel.flight.pojo.g r9 = (com.travel.flight.pojo.g) r9
            if (r9 == 0) goto L_0x0077
            java.lang.String r9 = r9.f25441a
            goto L_0x0078
        L_0x0077:
            r9 = r5
        L_0x0078:
            r3.setmBannerUrlInfo(r9)
            goto L_0x0092
        L_0x007c:
            java.lang.String r3 = "f"
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r3, (boolean) r0)
            if (r1 == 0) goto L_0x0432
            java.util.List r9 = r9.getFilters()
            java.lang.Object r9 = r9.get(r10)
            r3 = r9
            com.travel.flight.pojo.flightticket.CJRFilterAndBannerInfoItem r3 = (com.travel.flight.pojo.flightticket.CJRFilterAndBannerInfoItem) r3
            r3.setmType(r4)
        L_0x0092:
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r9 = new com.travel.flight.pojo.flightticket.CJRFlightDetailsItem
            r9.<init>()
            java.lang.String r10 = "filter_list_type"
            r9.setmListItemType(r10)
            r9.setmListItemData(r3)
            if (r3 != 0) goto L_0x00a4
            kotlin.g.b.k.a()
        L_0x00a4:
            java.lang.String r10 = r3.getmType()
            boolean r10 = kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.Object) r4)
            if (r10 == 0) goto L_0x0431
            java.util.Calendar r10 = java.util.Calendar.getInstance()
            java.lang.String r1 = "Calendar.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r1)
            java.util.TimeZone r10 = r10.getTimeZone()
            java.lang.String r1 = "Calendar.getInstance().timeZone"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r1)
            java.lang.String r10 = r10.getID()
            java.lang.String r1 = r3.getmFilterName()
            if (r1 != 0) goto L_0x00cc
            goto L_0x02f2
        L_0x00cc:
            int r4 = r1.hashCode()
            switch(r4) {
                case -1992012396: goto L_0x0273;
                case -1219557132: goto L_0x01e8;
                case -734206983: goto L_0x015d;
                case 106934601: goto L_0x00d5;
                default: goto L_0x00d3;
            }
        L_0x00d3:
            goto L_0x02f2
        L_0x00d5:
            java.lang.String r4 = "price"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x02f2
            r1 = r12
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.Iterator r1 = r1.iterator()
        L_0x00eb:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x0108
            java.lang.Object r5 = r1.next()
            r6 = r5
            com.travel.flight.flightSRPV2.a.x r6 = (com.travel.flight.flightSRPV2.a.x) r6
            int r6 = r6.e()
            r7 = 4
            if (r6 != r7) goto L_0x0101
            r6 = 1
            goto L_0x0102
        L_0x0101:
            r6 = 0
        L_0x0102:
            if (r6 == 0) goto L_0x00eb
            r4.add(r5)
            goto L_0x00eb
        L_0x0108:
            java.util.List r4 = (java.util.List) r4
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r1 = new java.util.ArrayList
            int r5 = kotlin.a.k.a(r4)
            r1.<init>(r5)
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r4 = r4.iterator()
        L_0x011b:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0137
            java.lang.Object r5 = r4.next()
            com.travel.flight.flightSRPV2.a.x r5 = (com.travel.flight.flightSRPV2.a.x) r5
            if (r5 == 0) goto L_0x012f
            com.travel.flight.flightSRPV2.a.aa r5 = (com.travel.flight.flightSRPV2.a.aa) r5
            r1.add(r5)
            goto L_0x011b
        L_0x012f:
            kotlin.u r9 = new kotlin.u
            java.lang.String r10 = "null cannot be cast to non-null type com.travel.flight.flightSRPV2.datalayer.SRPPriceFilter"
            r9.<init>(r10)
            throw r9
        L_0x0137:
            java.util.List r1 = (java.util.List) r1
            java.lang.Object r1 = kotlin.a.k.e(r1)
            com.travel.flight.flightSRPV2.a.aa r1 = (com.travel.flight.flightSRPV2.a.aa) r1
            if (r1 == 0) goto L_0x0148
            int r4 = r1.f24074a
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            goto L_0x014c
        L_0x0148:
            com.travel.flight.flightSRPV2.a.g<java.lang.Integer> r4 = r11.f24129d
            T r4 = r4.f24100a
        L_0x014c:
            r5 = r4
            if (r1 == 0) goto L_0x0157
            int r1 = r1.f24075b
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x02ee
        L_0x0157:
            com.travel.flight.flightSRPV2.a.g<java.lang.Integer> r1 = r11.f24129d
            T r1 = r1.f24101b
            goto L_0x02ee
        L_0x015d:
            java.lang.String r4 = "arrival"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x02f2
            r10 = r12
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r10 = r10.iterator()
        L_0x0173:
            boolean r4 = r10.hasNext()
            if (r4 == 0) goto L_0x0190
            java.lang.Object r4 = r10.next()
            r5 = r4
            com.travel.flight.flightSRPV2.a.x r5 = (com.travel.flight.flightSRPV2.a.x) r5
            int r5 = r5.e()
            r6 = 6
            if (r5 != r6) goto L_0x0189
            r5 = 1
            goto L_0x018a
        L_0x0189:
            r5 = 0
        L_0x018a:
            if (r5 == 0) goto L_0x0173
            r1.add(r4)
            goto L_0x0173
        L_0x0190:
            java.util.List r1 = (java.util.List) r1
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r10 = new java.util.ArrayList
            int r4 = kotlin.a.k.a(r1)
            r10.<init>(r4)
            java.util.Collection r10 = (java.util.Collection) r10
            java.util.Iterator r1 = r1.iterator()
        L_0x01a3:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x01bf
            java.lang.Object r4 = r1.next()
            com.travel.flight.flightSRPV2.a.x r4 = (com.travel.flight.flightSRPV2.a.x) r4
            if (r4 == 0) goto L_0x01b7
            com.travel.flight.flightSRPV2.a.s r4 = (com.travel.flight.flightSRPV2.a.s) r4
            r10.add(r4)
            goto L_0x01a3
        L_0x01b7:
            kotlin.u r9 = new kotlin.u
            java.lang.String r10 = "null cannot be cast to non-null type com.travel.flight.flightSRPV2.datalayer.SRPArrivalFilter"
            r9.<init>(r10)
            throw r9
        L_0x01bf:
            java.util.List r10 = (java.util.List) r10
            java.lang.Object r10 = kotlin.a.k.e(r10)
            com.travel.flight.flightSRPV2.a.s r10 = (com.travel.flight.flightSRPV2.a.s) r10
            if (r10 == 0) goto L_0x01d0
            long r4 = r10.f24122a
            java.lang.Long r1 = java.lang.Long.valueOf(r4)
            goto L_0x01d4
        L_0x01d0:
            com.travel.flight.flightSRPV2.a.g<java.lang.Long> r1 = r11.f24131f
            T r1 = r1.f24100a
        L_0x01d4:
            r5 = r1
            if (r10 == 0) goto L_0x01de
            long r6 = r10.f24123b
            java.lang.Long r10 = java.lang.Long.valueOf(r6)
            goto L_0x01e2
        L_0x01de:
            com.travel.flight.flightSRPV2.a.g<java.lang.Long> r10 = r11.f24131f
            T r10 = r10.f24101b
        L_0x01e2:
            com.travel.flight.flightSRPV2.a.g<java.lang.Long> r1 = r11.f24131f
            java.lang.String r1 = r1.f24102c
            goto L_0x02f4
        L_0x01e8:
            java.lang.String r4 = "departure"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x02f2
            r10 = r12
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r10 = r10.iterator()
        L_0x01fe:
            boolean r4 = r10.hasNext()
            if (r4 == 0) goto L_0x021b
            java.lang.Object r4 = r10.next()
            r5 = r4
            com.travel.flight.flightSRPV2.a.x r5 = (com.travel.flight.flightSRPV2.a.x) r5
            int r5 = r5.e()
            r6 = 5
            if (r5 != r6) goto L_0x0214
            r5 = 1
            goto L_0x0215
        L_0x0214:
            r5 = 0
        L_0x0215:
            if (r5 == 0) goto L_0x01fe
            r1.add(r4)
            goto L_0x01fe
        L_0x021b:
            java.util.List r1 = (java.util.List) r1
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r10 = new java.util.ArrayList
            int r4 = kotlin.a.k.a(r1)
            r10.<init>(r4)
            java.util.Collection r10 = (java.util.Collection) r10
            java.util.Iterator r1 = r1.iterator()
        L_0x022e:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x024a
            java.lang.Object r4 = r1.next()
            com.travel.flight.flightSRPV2.a.x r4 = (com.travel.flight.flightSRPV2.a.x) r4
            if (r4 == 0) goto L_0x0242
            com.travel.flight.flightSRPV2.a.v r4 = (com.travel.flight.flightSRPV2.a.v) r4
            r10.add(r4)
            goto L_0x022e
        L_0x0242:
            kotlin.u r9 = new kotlin.u
            java.lang.String r10 = "null cannot be cast to non-null type com.travel.flight.flightSRPV2.datalayer.SRPDepartureFilter"
            r9.<init>(r10)
            throw r9
        L_0x024a:
            java.util.List r10 = (java.util.List) r10
            java.lang.Object r10 = kotlin.a.k.e(r10)
            com.travel.flight.flightSRPV2.a.v r10 = (com.travel.flight.flightSRPV2.a.v) r10
            if (r10 == 0) goto L_0x025b
            long r4 = r10.f24133a
            java.lang.Long r1 = java.lang.Long.valueOf(r4)
            goto L_0x025f
        L_0x025b:
            com.travel.flight.flightSRPV2.a.g<java.lang.Long> r1 = r11.f24130e
            T r1 = r1.f24100a
        L_0x025f:
            r5 = r1
            if (r10 == 0) goto L_0x0269
            long r6 = r10.f24134b
            java.lang.Long r10 = java.lang.Long.valueOf(r6)
            goto L_0x026d
        L_0x0269:
            com.travel.flight.flightSRPV2.a.g<java.lang.Long> r10 = r11.f24130e
            T r10 = r10.f24101b
        L_0x026d:
            com.travel.flight.flightSRPV2.a.g<java.lang.Long> r1 = r11.f24130e
            java.lang.String r1 = r1.f24102c
            goto L_0x02f4
        L_0x0273:
            java.lang.String r4 = "duration"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x02f2
            r1 = r12
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.Iterator r1 = r1.iterator()
        L_0x0289:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x02a6
            java.lang.Object r5 = r1.next()
            r6 = r5
            com.travel.flight.flightSRPV2.a.x r6 = (com.travel.flight.flightSRPV2.a.x) r6
            int r6 = r6.e()
            r7 = 3
            if (r6 != r7) goto L_0x029f
            r6 = 1
            goto L_0x02a0
        L_0x029f:
            r6 = 0
        L_0x02a0:
            if (r6 == 0) goto L_0x0289
            r4.add(r5)
            goto L_0x0289
        L_0x02a6:
            java.util.List r4 = (java.util.List) r4
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r1 = new java.util.ArrayList
            int r5 = kotlin.a.k.a(r4)
            r1.<init>(r5)
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r4 = r4.iterator()
        L_0x02b9:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x02d5
            java.lang.Object r5 = r4.next()
            com.travel.flight.flightSRPV2.a.x r5 = (com.travel.flight.flightSRPV2.a.x) r5
            if (r5 == 0) goto L_0x02cd
            com.travel.flight.flightSRPV2.a.w r5 = (com.travel.flight.flightSRPV2.a.w) r5
            r1.add(r5)
            goto L_0x02b9
        L_0x02cd:
            kotlin.u r9 = new kotlin.u
            java.lang.String r10 = "null cannot be cast to non-null type com.travel.flight.flightSRPV2.datalayer.SRPDurationFilter"
            r9.<init>(r10)
            throw r9
        L_0x02d5:
            java.util.List r1 = (java.util.List) r1
            java.lang.Object r1 = kotlin.a.k.e(r1)
            com.travel.flight.flightSRPV2.a.w r1 = (com.travel.flight.flightSRPV2.a.w) r1
            com.travel.flight.flightSRPV2.a.g<java.lang.Integer> r4 = r11.f24128c
            T r5 = r4.f24100a
            if (r1 == 0) goto L_0x02ea
            int r1 = r1.f24135a
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x02ee
        L_0x02ea:
            com.travel.flight.flightSRPV2.a.g<java.lang.Integer> r1 = r11.f24128c
            T r1 = r1.f24101b
        L_0x02ee:
            r8 = r1
            r1 = r10
            r10 = r8
            goto L_0x02f4
        L_0x02f2:
            r1 = r10
            r10 = r5
        L_0x02f4:
            java.lang.String r3 = r3.getmFilterName()
            java.lang.String r4 = "airlines"
            boolean r3 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r3, (boolean) r0)
            if (r3 == 0) goto L_0x0404
            java.util.List<com.travel.flight.flightSRPV2.a.d> r10 = r11.f24132g
            java.util.List r10 = g(r10)
            java.util.Iterator r1 = r10.iterator()
        L_0x030a:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0326
            java.lang.Object r3 = r1.next()
            com.travel.flight.flightSRPV2.a.d r3 = (com.travel.flight.flightSRPV2.a.d) r3
            androidx.databinding.i r4 = new androidx.databinding.i
            r4.<init>()
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            r4.set(r5)
            kotlin.x r5 = kotlin.x.f47997a
            r3.a(r4)
            goto L_0x030a
        L_0x0326:
            kotlin.x r1 = kotlin.x.f47997a
            java.util.List<com.travel.flight.flightSRPV2.a.d> r11 = r11.f24132g
            java.util.List r11 = g(r11)
            java.util.Iterator r1 = r11.iterator()
        L_0x0332:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x034e
            java.lang.Object r3 = r1.next()
            com.travel.flight.flightSRPV2.a.d r3 = (com.travel.flight.flightSRPV2.a.d) r3
            androidx.databinding.i r4 = new androidx.databinding.i
            r4.<init>()
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            r4.set(r5)
            kotlin.x r5 = kotlin.x.f47997a
            r3.a(r4)
            goto L_0x0332
        L_0x034e:
            kotlin.x r1 = kotlin.x.f47997a
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r12 = r12.iterator()
        L_0x035d:
            boolean r3 = r12.hasNext()
            if (r3 == 0) goto L_0x037a
            java.lang.Object r3 = r12.next()
            r4 = r3
            com.travel.flight.flightSRPV2.a.x r4 = (com.travel.flight.flightSRPV2.a.x) r4
            int r4 = r4.e()
            r5 = 7
            if (r4 != r5) goto L_0x0373
            r4 = 1
            goto L_0x0374
        L_0x0373:
            r4 = 0
        L_0x0374:
            if (r4 == 0) goto L_0x035d
            r1.add(r3)
            goto L_0x035d
        L_0x037a:
            java.util.List r1 = (java.util.List) r1
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r12 = new java.util.ArrayList
            int r3 = kotlin.a.k.a(r1)
            r12.<init>(r3)
            java.util.Collection r12 = (java.util.Collection) r12
            java.util.Iterator r1 = r1.iterator()
        L_0x038d:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x03ad
            java.lang.Object r3 = r1.next()
            com.travel.flight.flightSRPV2.a.x r3 = (com.travel.flight.flightSRPV2.a.x) r3
            if (r3 == 0) goto L_0x03a5
            com.travel.flight.flightSRPV2.a.r r3 = (com.travel.flight.flightSRPV2.a.r) r3
            com.travel.flight.flightSRPV2.a.d r3 = r3.f24121a
            java.lang.String r3 = r3.f24095a
            r12.add(r3)
            goto L_0x038d
        L_0x03a5:
            kotlin.u r9 = new kotlin.u
            java.lang.String r10 = "null cannot be cast to non-null type com.travel.flight.flightSRPV2.datalayer.SRPAirlineFilter"
            r9.<init>(r10)
            throw r9
        L_0x03ad:
            java.util.List r12 = (java.util.List) r12
            java.util.Iterator r12 = r12.iterator()
        L_0x03b3:
            boolean r1 = r12.hasNext()
            if (r1 == 0) goto L_0x03fa
            java.lang.Object r1 = r12.next()
            java.lang.String r1 = (java.lang.String) r1
            java.util.Iterator r3 = r10.iterator()
            r4 = 0
        L_0x03c4:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x03dc
            java.lang.Object r5 = r3.next()
            com.travel.flight.flightSRPV2.a.d r5 = (com.travel.flight.flightSRPV2.a.d) r5
            java.lang.String r5 = r5.f24095a
            boolean r5 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r1, (boolean) r0)
            if (r5 == 0) goto L_0x03d9
            goto L_0x03dd
        L_0x03d9:
            int r4 = r4 + 1
            goto L_0x03c4
        L_0x03dc:
            r4 = -1
        L_0x03dd:
            if (r4 < 0) goto L_0x03b3
            java.lang.Object r1 = r10.get(r4)
            com.travel.flight.flightSRPV2.a.d r1 = (com.travel.flight.flightSRPV2.a.d) r1
            androidx.databinding.i<java.lang.Boolean> r1 = r1.f24099e
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            r1.set(r3)
            java.lang.Object r1 = r11.get(r4)
            com.travel.flight.flightSRPV2.a.d r1 = (com.travel.flight.flightSRPV2.a.d) r1
            androidx.databinding.i<java.lang.Boolean> r1 = r1.f24099e
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            r1.set(r3)
            goto L_0x03b3
        L_0x03fa:
            r9.setFilterAirlinePriceList(r10)
            r9.setFilterPrevSelectedAirlinePriceList(r11)
            b((com.travel.flight.pojo.flightticket.CJRFlightDetailsItem) r9)
            goto L_0x0427
        L_0x0404:
            androidx.databinding.i r11 = new androidx.databinding.i
            r11.<init>(r5)
            r9.setFilterSelectedMinValue(r11)
            androidx.databinding.i r11 = new androidx.databinding.i
            r11.<init>(r10)
            r9.setFilterSelectedMaxValue(r11)
            androidx.databinding.i r11 = new androidx.databinding.i
            r11.<init>(r5)
            r9.setFilterPrevSelectedMinValue(r11)
            androidx.databinding.i r11 = new androidx.databinding.i
            r11.<init>(r10)
            r9.setFilterPrevSelectedMaxValue(r11)
            r9.setTimezone(r1)
        L_0x0427:
            androidx.databinding.i r10 = new androidx.databinding.i
            java.lang.Boolean r11 = java.lang.Boolean.FALSE
            r10.<init>(r11)
            r9.setIsFilterRangeChanged(r10)
        L_0x0431:
            return r9
        L_0x0432:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightSRPV2.a.t.a(com.travel.flight.pojo.flightticket.CJRFBI, java.lang.String, com.travel.flight.flightSRPV2.a.u, java.util.List):com.travel.flight.pojo.flightticket.CJRFlightDetailsItem");
    }

    public static final u a(CJRFlightSearchResult cJRFlightSearchResult, boolean z) {
        String str;
        String str2;
        double d2;
        double d3;
        Iterator<CJRFlightDetailsItem> it2;
        int i2;
        long j2;
        k.c(cJRFlightSearchResult, "srpResult");
        CJROnwardReturnFlightInformation cJROnwardReturnFlightInformation = cJRFlightSearchResult.getmOnwardReturnFlights();
        if (cJROnwardReturnFlightInformation == null) {
            k.a();
        }
        CJRFlightFilterMinMaxDetails cJRFlightFilterMinMaxDetails = (z ? cJROnwardReturnFlightInformation.getmOnwardFlights() : cJROnwardReturnFlightInformation.getmReturnFlights()).getmMeta();
        Collection collection = cJROnwardReturnFlightInformation.getmMapping();
        boolean z2 = !(collection == null || collection.isEmpty());
        Object obj = cJRFlightFilterMinMaxDetails.getmDuration().getmMin();
        if (obj != null) {
            int j3 = com.travel.flight.utils.c.j((String) obj);
            Object obj2 = cJRFlightFilterMinMaxDetails.getmDuration().getmMax();
            if (obj2 != null) {
                int j4 = com.travel.flight.utils.c.j((String) obj2);
                k.a((Object) cJRFlightFilterMinMaxDetails, "filterMeta");
                CJRFlightSRPMetaArrivalDeparture departure = cJRFlightFilterMinMaxDetails.getDeparture();
                k.a((Object) departure, "filterMeta.departure");
                long min_timestamp = departure.getMin_timestamp();
                CJRFlightSRPMetaArrivalDeparture departure2 = cJRFlightFilterMinMaxDetails.getDeparture();
                k.a((Object) departure2, "filterMeta.departure");
                long max_timestamp = departure2.getMax_timestamp();
                CJRFlightSRPMetaArrivalDeparture departure3 = cJRFlightFilterMinMaxDetails.getDeparture();
                k.a((Object) departure3, "filterMeta.departure");
                String timezone = departure3.getTimezone();
                CJRFlightSRPMetaArrivalDeparture arrival = cJRFlightFilterMinMaxDetails.getArrival();
                k.a((Object) arrival, "filterMeta.arrival");
                long min_timestamp2 = arrival.getMin_timestamp();
                CJRFlightSRPMetaArrivalDeparture arrival2 = cJRFlightFilterMinMaxDetails.getArrival();
                k.a((Object) arrival2, "filterMeta.arrival");
                long max_timestamp2 = arrival2.getMax_timestamp();
                CJRFlightSRPMetaArrivalDeparture arrival3 = cJRFlightFilterMinMaxDetails.getArrival();
                k.a((Object) arrival3, "filterMeta.arrival");
                String timezone2 = arrival3.getTimezone();
                if (z2) {
                    CJROnwardReturnFlightInformation cJROnwardReturnFlightInformation2 = cJRFlightSearchResult.getmOnwardReturnFlights();
                    k.a((Object) cJROnwardReturnFlightInformation2, "srpResult.getmOnwardReturnFlights()");
                    if (cJROnwardReturnFlightInformation2.getMappingMeta() != null) {
                        CJROnwardReturnFlightInformation cJROnwardReturnFlightInformation3 = cJRFlightSearchResult.getmOnwardReturnFlights();
                        k.a((Object) cJROnwardReturnFlightInformation3, "srpResult.getmOnwardReturnFlights()");
                        if (cJROnwardReturnFlightInformation3.getMappingMeta().getmPrice() != null) {
                            CJROnwardReturnFlightInformation cJROnwardReturnFlightInformation4 = cJRFlightSearchResult.getmOnwardReturnFlights();
                            k.a((Object) cJROnwardReturnFlightInformation4, "srpResult.getmOnwardReturnFlights()");
                            Object obj3 = cJROnwardReturnFlightInformation4.getMappingMeta().getmPrice().getmMin();
                            if (obj3 != null) {
                                str2 = timezone;
                                str = timezone2;
                                d2 = ((Double) obj3).doubleValue();
                            } else {
                                throw new u("null cannot be cast to non-null type kotlin.Double");
                            }
                        }
                    }
                    str2 = timezone;
                    str = timezone2;
                    Object obj4 = cJRFlightFilterMinMaxDetails.getmPrice().getmMin();
                    if (obj4 != null) {
                        d2 = ((Double) obj4).doubleValue();
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.Double");
                    }
                } else {
                    str2 = timezone;
                    str = timezone2;
                    Object obj5 = cJRFlightFilterMinMaxDetails.getmPrice().getmMin();
                    if (obj5 != null) {
                        d2 = ((Double) obj5).doubleValue();
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.Double");
                    }
                }
                int i3 = (int) d2;
                if (z2) {
                    CJROnwardReturnFlightInformation cJROnwardReturnFlightInformation5 = cJRFlightSearchResult.getmOnwardReturnFlights();
                    k.a((Object) cJROnwardReturnFlightInformation5, "srpResult.getmOnwardReturnFlights()");
                    if (cJROnwardReturnFlightInformation5.getMappingMeta() != null) {
                        CJROnwardReturnFlightInformation cJROnwardReturnFlightInformation6 = cJRFlightSearchResult.getmOnwardReturnFlights();
                        k.a((Object) cJROnwardReturnFlightInformation6, "srpResult.getmOnwardReturnFlights()");
                        if (cJROnwardReturnFlightInformation6.getMappingMeta().getmPrice() != null) {
                            CJROnwardReturnFlightInformation cJROnwardReturnFlightInformation7 = cJRFlightSearchResult.getmOnwardReturnFlights();
                            k.a((Object) cJROnwardReturnFlightInformation7, "srpResult.getmOnwardReturnFlights()");
                            Object obj6 = cJROnwardReturnFlightInformation7.getMappingMeta().getmPrice().getmMax();
                            if (obj6 != null) {
                                d3 = ((Double) obj6).doubleValue();
                            } else {
                                throw new u("null cannot be cast to non-null type kotlin.Double");
                            }
                        }
                    }
                    Object obj7 = cJRFlightFilterMinMaxDetails.getmPrice().getmMax();
                    if (obj7 != null) {
                        d3 = ((Double) obj7).doubleValue();
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.Double");
                    }
                } else {
                    Object obj8 = cJRFlightFilterMinMaxDetails.getmPrice().getmMax();
                    if (obj8 != null) {
                        d3 = ((Double) obj8).doubleValue();
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.Double");
                    }
                }
                int i4 = (int) d3;
                ArrayList<CJRFlightDetailsItem> arrayList = (z ? cJROnwardReturnFlightInformation.getmOnwardFlights() : cJROnwardReturnFlightInformation.getmReturnFlights()).getmFlightDetails();
                Map linkedHashMap = new LinkedHashMap();
                e eVar = new e(linkedHashMap);
                Set linkedHashSet = new LinkedHashSet();
                Iterator<CJRFlightDetailsItem> it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    CJRFlightDetailsItem next = it3.next();
                    if (z2) {
                        it2 = it3;
                        i2 = 0;
                    } else {
                        it2 = it3;
                        String str3 = next.getmPrice().get(0).getmDisplayPrice();
                        k.a((Object) str3, "flight.getmPrice()[0].getmDisplayPrice()");
                        i2 = Integer.parseInt(str3);
                    }
                    String str4 = next.getmAirLine();
                    boolean z3 = z2;
                    k.a((Object) str4, "flight.getmAirLine()");
                    if (p.a((CharSequence) str4, '|', false)) {
                        ArrayList<CJRFlightStops> arrayList2 = next.getmFlights();
                        Collection collection2 = arrayList2;
                        if (!(collection2 == null || collection2.isEmpty())) {
                            Iterator<CJRFlightStops> it4 = arrayList2.iterator();
                            while (it4.hasNext()) {
                                CJRFlightStops next2 = it4.next();
                                String str5 = next2.getmAirLineCode();
                                Iterator<CJRFlightStops> it5 = it4;
                                if (!linkedHashSet.contains(str5)) {
                                    k.a((Object) str5, "airlineCode");
                                    linkedHashSet.add(str5);
                                    String str6 = next2.getmAirLine();
                                    k.a((Object) str6, "stopFlight.getmAirLine()");
                                    eVar.invoke(str5, str6, i2);
                                }
                                it4 = it5;
                            }
                            j2 = min_timestamp2;
                        } else {
                            j2 = min_timestamp2;
                            it3 = it2;
                            z2 = z3;
                            min_timestamp2 = j2;
                        }
                    } else {
                        String str7 = next.getmAirLineCode();
                        j2 = min_timestamp2;
                        k.a((Object) str7, "flight.getmAirLineCode()");
                        String str8 = next.getmAirLine();
                        k.a((Object) str8, "flight.getmAirLine()");
                        eVar.invoke(str7, str8, i2);
                    }
                    linkedHashSet.clear();
                    it3 = it2;
                    z2 = z3;
                    min_timestamp2 = j2;
                }
                List c2 = kotlin.a.k.c(linkedHashMap.values());
                kotlin.a.k.a(c2, new a());
                return new u(new g(Integer.valueOf(j3), Integer.valueOf(j4)), new g(Integer.valueOf(i3), Integer.valueOf(i4)), new g(Long.valueOf(min_timestamp), Long.valueOf(max_timestamp), str2), new g(Long.valueOf(min_timestamp2), Long.valueOf(max_timestamp2), str), c2);
            }
            throw new u("null cannot be cast to non-null type kotlin.String");
        }
        throw new u("null cannot be cast to non-null type kotlin.String");
    }

    static final class e extends l implements q<String, String, Integer, x> {
        final /* synthetic */ Map $airlineToInfoMap;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(Map map) {
            super(3);
            this.$airlineToInfoMap = map;
        }

        public final /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((String) obj, (String) obj2, ((Number) obj3).intValue());
            return x.f47997a;
        }

        public final void invoke(String str, String str2, int i2) {
            k.c(str, "airlineCode");
            k.c(str2, "airlineName");
            if (this.$airlineToInfoMap.containsKey(str)) {
                Object obj = this.$airlineToInfoMap.get(str);
                if (obj == null) {
                    k.a();
                }
                d dVar = (d) obj;
                dVar.f24098d = Math.min(dVar.f24098d, i2);
                dVar.f24097c++;
                return;
            }
            Map map = this.$airlineToInfoMap;
            androidx.databinding.i iVar = new androidx.databinding.i();
            iVar.set(Boolean.FALSE);
            map.put(str, new d(str, str2, 1, i2, iVar));
        }
    }

    private static <T> List<T> g(List<? extends T> list) {
        k.c(list, "sourceList");
        com.google.gsonhtcfix.f fVar = new com.google.gsonhtcfix.f();
        ArrayList arrayList = new ArrayList(list.size());
        if (!list.isEmpty()) {
            Object obj = list.get(0);
            if (obj == null) {
                k.a();
            }
            if (obj != null) {
                Class<?> cls = obj.getClass();
                for (Object a2 : list) {
                    arrayList.add(fVar.a(fVar.a((Object) a2), cls));
                }
            } else {
                throw new u("null cannot be cast to non-null type kotlin.Any");
            }
        }
        return arrayList;
    }

    private static void b(CJRFlightDetailsItem cJRFlightDetailsItem) {
        k.c(cJRFlightDetailsItem, "flightInfo");
        Collection filterAirlinePriceList = cJRFlightDetailsItem.getFilterAirlinePriceList();
        if (!(filterAirlinePriceList == null || filterAirlinePriceList.isEmpty())) {
            j jVar = new j(cJRFlightDetailsItem);
            for (d dVar : cJRFlightDetailsItem.getFilterAirlinePriceList()) {
                dVar.f24099e.addOnPropertyChangedCallback(jVar);
            }
        }
    }

    public static final class j extends h.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRFlightDetailsItem f24125a;

        j(CJRFlightDetailsItem cJRFlightDetailsItem) {
            this.f24125a = cJRFlightDetailsItem;
        }

        public final void onPropertyChanged(androidx.databinding.h hVar, int i2) {
            k.c(hVar, "sender");
            List<d> filterAirlinePriceList = this.f24125a.getFilterAirlinePriceList();
            k.a((Object) filterAirlinePriceList, "flightInfo.filterAirlinePriceList");
            int size = filterAirlinePriceList.size();
            boolean z = false;
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    break;
                } else if (!k.a((Object) this.f24125a.getFilterAirlinePriceList().get(i3).f24099e.get(), (Object) this.f24125a.getFilterPrevSelectedAirlinePriceList().get(i3).f24099e.get())) {
                    z = true;
                    break;
                } else {
                    i3++;
                }
            }
            this.f24125a.getIsFilterRangeChanged().set(Boolean.valueOf(z));
        }
    }

    private static void c(CJRFlightDetailsItem cJRFlightDetailsItem) {
        String str;
        k.c(cJRFlightDetailsItem, "flight");
        boolean z = false;
        cJRFlightDetailsItem.setStitchedAndMoreThanOneHop((cJRFlightDetailsItem.isStitched() || cJRFlightDetailsItem.isProviderStitch()) && cJRFlightDetailsItem.getmFlights() != null && cJRFlightDetailsItem.getmFlights().size() >= 2);
        if (cJRFlightDetailsItem.isStitchedAndMoreThanOneHop()) {
            ArrayList<CJRFlightStops> arrayList = cJRFlightDetailsItem.getmFlights();
            StringBuilder sb = new StringBuilder();
            k.a((Object) arrayList, "hopFlights");
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                CJRFlightStops cJRFlightStops = arrayList.get(i2);
                if (i2 == 0) {
                    cJRFlightDetailsItem.setFormattedFirstHopInfo(cJRFlightStops.getmAirLine());
                } else {
                    sb.append(" ");
                    sb.append(cJRFlightStops.getmAirLine());
                    k.a((Object) sb, "builder.append(hopFlight.getmAirLine())");
                }
                sb.append(" ");
                sb.append(cJRFlightStops.getmAirLineCode());
                sb.append(" ");
                sb.append(cJRFlightStops.getmFlightNumber());
                sb.append(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COMMA);
            }
            if (sb.length() > 0) {
                z = true;
            }
            if (z) {
                sb.deleteCharAt(sb.length() - 1);
            }
            cJRFlightDetailsItem.setFormattedSecondHopInfo(sb.toString());
            return;
        }
        String str2 = "";
        if (cJRFlightDetailsItem.getmFlights() == null || cJRFlightDetailsItem.getmFlights().size() <= 0) {
            str = str2;
        } else {
            str2 = cJRFlightDetailsItem.getmFlights().get(0).getmAirLine();
            k.a((Object) str2, "flight.getmFlights()[0].getmAirLine()");
            str = cJRFlightDetailsItem.getmFlights().get(0).getmFlightNumber();
            k.a((Object) str, "flight.getmFlights()[0].getmFlightNumber()");
        }
        cJRFlightDetailsItem.setFormattedFirstHopInfo(str2);
        cJRFlightDetailsItem.setFormattedSecondHopInfo(cJRFlightDetailsItem.getmAirLineCode() + ' ' + str);
    }

    public static final String a(CJRFlightSearchResult cJRFlightSearchResult, CJRFlightSearchResult cJRFlightSearchResult2) {
        ac a2 = a(cJRFlightSearchResult);
        ac a3 = a(cJRFlightSearchResult2);
        if (!(a2 == null || a3 == null || a2.f24076a != a3.f24076a)) {
            int i2 = a3.f24078c - a2.f24078c;
            int i3 = a3.f24079d - a2.f24079d;
            if (a3.f24076a) {
                if (a3.f24077b) {
                    if (i2 <= 0) {
                        return "";
                    }
                    return "We've found " + i2 + " more flights for you";
                } else if (i2 > 0 && i3 > 0) {
                    return "We found " + i2 + " more onward flight and " + i3 + " more return flight option(s)";
                } else if (i2 > 0) {
                    return "We found " + i2 + " more onward flight option(s)";
                } else if (i3 <= 0) {
                    return "";
                } else {
                    return "We found " + i3 + " more return flight option(s)";
                }
            } else if (i2 > 0) {
                return "We found " + i2 + " more flight option(s)";
            }
        }
        return "";
    }

    private static ac a(CJRFlightSearchResult cJRFlightSearchResult) {
        CJROnwardReturnFlightInformation cJROnwardReturnFlightInformation;
        CJROnwardFlights cJROnwardFlights;
        ArrayList<CJRFlightDetailsItem> arrayList;
        ArrayList<CJRFlightDetailsItem> arrayList2;
        ArrayList<CJRFlightDetailsItem> arrayList3 = null;
        if (cJRFlightSearchResult == null || (cJROnwardReturnFlightInformation = cJRFlightSearchResult.getmOnwardReturnFlights()) == null || (cJROnwardFlights = cJROnwardReturnFlightInformation.getmOnwardFlights()) == null || (arrayList = cJROnwardFlights.getmFlightDetails()) == null) {
            return null;
        }
        CJROnwardFlights cJROnwardFlights2 = cJROnwardReturnFlightInformation.getmReturnFlights();
        if (cJROnwardFlights2 != null) {
            arrayList3 = cJROnwardFlights2.getmFlightDetails();
        }
        Collection collection = arrayList3;
        int i2 = 0;
        boolean z = !(collection == null || collection.isEmpty());
        CJROnwardReturnFlightInformation cJROnwardReturnFlightInformation2 = cJRFlightSearchResult.getmOnwardReturnFlights();
        k.a((Object) cJROnwardReturnFlightInformation2, "flightsInfo");
        boolean a2 = k.a((Object) cJROnwardReturnFlightInformation2.getJourney_type(), (Object) net.one97.paytmflight.common.b.b.f30019i);
        if (!z) {
            return new ac(false, a2, arrayList.size());
        }
        if (a2) {
            List<CJRIntlFlightMapping> list = cJROnwardReturnFlightInformation.getmMapping();
            if (list != null) {
                i2 = list.size();
            }
            return new ac(true, a2, i2);
        }
        int size = arrayList.size();
        if (!(cJROnwardFlights2 == null || (arrayList2 = cJROnwardFlights2.getmFlightDetails()) == null)) {
            i2 = arrayList2.size();
        }
        return new ac(true, a2, size, i2);
    }

    public static final boolean a(List<? extends x> list, List<? extends x> list2, boolean z) {
        boolean z2;
        k.c(list, "lhs");
        k.c(list2, "rhs");
        if (list.size() != list2.size()) {
            return true;
        }
        Iterator<? extends x> it2 = list.iterator();
        do {
            z2 = false;
            if (!it2.hasNext()) {
                return false;
            }
            x xVar = (x) it2.next();
            Iterable iterable = list2;
            if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                Iterator it3 = iterable.iterator();
                while (true) {
                    if (it3.hasNext()) {
                        if (xVar.a((x) it3.next(), z)) {
                            z2 = true;
                            continue;
                            break;
                        }
                    } else {
                        continue;
                        break;
                    }
                }
            }
        } while (z2);
        return true;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x007e, code lost:
        if (r2.f24134b == ((java.lang.Number) r11.f24130e.f24101b).longValue()) goto L_0x00e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00a8, code lost:
        if (r2.f24075b == ((java.lang.Number) r11.f24129d.f24101b).intValue()) goto L_0x00e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00c4, code lost:
        if (((com.travel.flight.flightSRPV2.a.w) r1).f24135a != ((java.lang.Number) r11.f24128c.f24101b).intValue()) goto L_0x00e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00d8, code lost:
        if (((com.travel.flight.flightSRPV2.a.af) r1).f24086a != r11.f24127b) goto L_0x00e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x004f, code lost:
        if (r2.f24123b == ((java.lang.Number) r11.f24131f.f24101b).longValue()) goto L_0x00e4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.List<com.travel.flight.flightSRPV2.a.x> a(java.util.List<? extends com.travel.flight.flightSRPV2.a.x> r10, com.travel.flight.flightSRPV2.a.u r11) {
        /*
            java.lang.String r0 = "filters"
            kotlin.g.b.k.c(r10, r0)
            java.lang.String r0 = "defaultFilterInfo"
            kotlin.g.b.k.c(r11, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r0 = (java.util.List) r0
            java.util.Iterator r10 = r10.iterator()
        L_0x0015:
            boolean r1 = r10.hasNext()
            if (r1 == 0) goto L_0x00eb
            java.lang.Object r1 = r10.next()
            com.travel.flight.flightSRPV2.a.x r1 = (com.travel.flight.flightSRPV2.a.x) r1
            int r2 = r1.e()
            r3 = 0
            r4 = 1
            switch(r2) {
                case 1: goto L_0x00e3;
                case 2: goto L_0x00cf;
                case 3: goto L_0x00b3;
                case 4: goto L_0x0089;
                case 5: goto L_0x005b;
                case 6: goto L_0x002c;
                case 7: goto L_0x00e3;
                default: goto L_0x002a;
            }
        L_0x002a:
            goto L_0x00e4
        L_0x002c:
            if (r1 == 0) goto L_0x0053
            r2 = r1
            com.travel.flight.flightSRPV2.a.s r2 = (com.travel.flight.flightSRPV2.a.s) r2
            long r5 = r2.f24122a
            com.travel.flight.flightSRPV2.a.g<java.lang.Long> r7 = r11.f24131f
            T r7 = r7.f24100a
            java.lang.Number r7 = (java.lang.Number) r7
            long r7 = r7.longValue()
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x00e3
            long r5 = r2.f24123b
            com.travel.flight.flightSRPV2.a.g<java.lang.Long> r2 = r11.f24131f
            T r2 = r2.f24101b
            java.lang.Number r2 = (java.lang.Number) r2
            long r7 = r2.longValue()
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 == 0) goto L_0x00e4
            goto L_0x00e3
        L_0x0053:
            kotlin.u r10 = new kotlin.u
            java.lang.String r11 = "null cannot be cast to non-null type com.travel.flight.flightSRPV2.datalayer.SRPArrivalFilter"
            r10.<init>(r11)
            throw r10
        L_0x005b:
            if (r1 == 0) goto L_0x0081
            r2 = r1
            com.travel.flight.flightSRPV2.a.v r2 = (com.travel.flight.flightSRPV2.a.v) r2
            long r5 = r2.f24133a
            com.travel.flight.flightSRPV2.a.g<java.lang.Long> r7 = r11.f24130e
            T r7 = r7.f24100a
            java.lang.Number r7 = (java.lang.Number) r7
            long r7 = r7.longValue()
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x00e3
            long r5 = r2.f24134b
            com.travel.flight.flightSRPV2.a.g<java.lang.Long> r2 = r11.f24130e
            T r2 = r2.f24101b
            java.lang.Number r2 = (java.lang.Number) r2
            long r7 = r2.longValue()
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 == 0) goto L_0x00e4
            goto L_0x00e3
        L_0x0081:
            kotlin.u r10 = new kotlin.u
            java.lang.String r11 = "null cannot be cast to non-null type com.travel.flight.flightSRPV2.datalayer.SRPDepartureFilter"
            r10.<init>(r11)
            throw r10
        L_0x0089:
            if (r1 == 0) goto L_0x00ab
            r2 = r1
            com.travel.flight.flightSRPV2.a.aa r2 = (com.travel.flight.flightSRPV2.a.aa) r2
            int r5 = r2.f24074a
            com.travel.flight.flightSRPV2.a.g<java.lang.Integer> r6 = r11.f24129d
            T r6 = r6.f24100a
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            if (r5 != r6) goto L_0x00e3
            int r2 = r2.f24075b
            com.travel.flight.flightSRPV2.a.g<java.lang.Integer> r5 = r11.f24129d
            T r5 = r5.f24101b
            java.lang.Number r5 = (java.lang.Number) r5
            int r5 = r5.intValue()
            if (r2 == r5) goto L_0x00e4
            goto L_0x00e3
        L_0x00ab:
            kotlin.u r10 = new kotlin.u
            java.lang.String r11 = "null cannot be cast to non-null type com.travel.flight.flightSRPV2.datalayer.SRPPriceFilter"
            r10.<init>(r11)
            throw r10
        L_0x00b3:
            if (r1 == 0) goto L_0x00c7
            r2 = r1
            com.travel.flight.flightSRPV2.a.w r2 = (com.travel.flight.flightSRPV2.a.w) r2
            int r2 = r2.f24135a
            com.travel.flight.flightSRPV2.a.g<java.lang.Integer> r5 = r11.f24128c
            T r5 = r5.f24101b
            java.lang.Number r5 = (java.lang.Number) r5
            int r5 = r5.intValue()
            if (r2 == r5) goto L_0x00e4
            goto L_0x00e3
        L_0x00c7:
            kotlin.u r10 = new kotlin.u
            java.lang.String r11 = "null cannot be cast to non-null type com.travel.flight.flightSRPV2.datalayer.SRPDurationFilter"
            r10.<init>(r11)
            throw r10
        L_0x00cf:
            if (r1 == 0) goto L_0x00db
            r2 = r1
            com.travel.flight.flightSRPV2.a.af r2 = (com.travel.flight.flightSRPV2.a.af) r2
            int r2 = r2.f24086a
            int r5 = r11.f24127b
            if (r2 == r5) goto L_0x00e4
            goto L_0x00e3
        L_0x00db:
            kotlin.u r10 = new kotlin.u
            java.lang.String r11 = "null cannot be cast to non-null type com.travel.flight.flightSRPV2.datalayer.SRPStopsFilter"
            r10.<init>(r11)
            throw r10
        L_0x00e3:
            r3 = 1
        L_0x00e4:
            if (r3 == 0) goto L_0x0015
            r0.add(r1)
            goto L_0x0015
        L_0x00eb:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightSRPV2.a.t.a(java.util.List, com.travel.flight.flightSRPV2.a.u):java.util.List");
    }

    private static boolean b(CJRFlightSearchResult cJRFlightSearchResult) {
        k.c(cJRFlightSearchResult, "srpResult");
        CJRMetadetails cJRMetadetails = cJRFlightSearchResult.getmMetaDetails();
        k.a((Object) cJRMetadetails, "srpResult.getmMetaDetails()");
        FlightSearchResultMetaQuery query = cJRMetadetails.getQuery();
        k.a((Object) query, "query");
        return (b(query.getAdults()) + b(query.getChildren())) + b(query.getInfants()) > 1;
    }

    private static int b(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || p.a(charSequence)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static final List<x> a(List<? extends x> list) {
        k.c(list, "filters");
        Collection arrayList = new ArrayList();
        for (Object next : list) {
            x xVar = (x) next;
            if (xVar.e() != 2 || (xVar.e() == 2 && xVar.k() == 2)) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    public static final List<String> b(List<? extends x> list) {
        ArrayList arrayList = new ArrayList();
        Collection collection = list;
        if (!(collection == null || collection.isEmpty())) {
            for (x a2 : list) {
                arrayList.add(a2.a());
            }
        }
        return arrayList;
    }

    public static final b a(ae aeVar) {
        k.c(aeVar, "sortOption");
        if (aeVar.a() == 1 || aeVar.a() == 2) {
            return new b(aeVar.b(), (String) null);
        }
        if (aeVar.f24083b) {
            return new b(aeVar.b(), (String) null);
        }
        return new b((String) null, aeVar.b());
    }

    public static final String b(ae aeVar) {
        k.c(aeVar, "sortOption");
        if (aeVar.a() == 1 || aeVar.a() == 2) {
            return "ONWARD_RETURN";
        }
        return aeVar.f24083b ? "ONWARD" : "RETURN";
    }

    public static final <T> List<T> b(List<? extends T> list, List<? extends T> list2) {
        ArrayList arrayList = new ArrayList(list.size() + 0 + list2.size());
        arrayList.addAll(list);
        arrayList.addAll(list2);
        return arrayList;
    }

    public static final boolean c(List<? extends x> list) {
        Collection collection = list;
        if (collection == null || collection.isEmpty()) {
            return false;
        }
        for (x xVar : list) {
            if (xVar.e() == 2 && (xVar instanceof af) && ((af) xVar).f24086a == 1) {
                return true;
            }
        }
        return false;
    }

    @kotlin.d.b.a.f(b = "SRPDataProcessingUtil.kt", c = {33}, d = "invokeSuspend", e = "com.travel.flight.flightSRPV2.datalayer.SRPDataProcessingUtilKt$getDelayTask$1")
    static final class f extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
        final /* synthetic */ long $delay;
        Object L$0;
        int label;
        private CoroutineScope p$;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(long j, kotlin.d.d dVar) {
            super(2, dVar);
            this.$delay = j;
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            k.c(dVar, "completion");
            f fVar = new f(this.$delay, dVar);
            fVar.p$ = (CoroutineScope) obj;
            return fVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((f) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.a(obj);
                CoroutineScope coroutineScope = this.p$;
                long j = this.$delay;
                this.L$0 = coroutineScope;
                this.label = 1;
                if (DelayKt.delay(j, this) == aVar) {
                    return aVar;
                }
            } else if (i2 == 1) {
                ResultKt.a(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return x.f47997a;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000f, code lost:
        r3 = r7.getSource();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void a(android.content.Context r6, com.travel.flight.pojo.flightticket.CJRFlightSearchInput r7) {
        /*
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r6, r0)
            com.travel.flight.flightSRPV2.a.t$i r0 = com.travel.flight.flightSRPV2.a.t.i.INSTANCE
            com.travel.flight.pojo.f r1 = new com.travel.flight.pojo.f
            r1.<init>()
            r2 = 0
            if (r7 == 0) goto L_0x001a
            com.travel.flight.pojo.flightticket.b r3 = r7.getSource()
            if (r3 == 0) goto L_0x001a
            java.lang.String r3 = r3.getCityName()
            goto L_0x001b
        L_0x001a:
            r3 = r2
        L_0x001b:
            r1.setSourceCityName(r3)
            if (r7 == 0) goto L_0x002b
            com.travel.flight.pojo.flightticket.b r3 = r7.getSource()
            if (r3 == 0) goto L_0x002b
            java.lang.String r3 = r3.getShortCityName()
            goto L_0x002c
        L_0x002b:
            r3 = r2
        L_0x002c:
            r1.setSourceShortCityName(r3)
            if (r7 == 0) goto L_0x003c
            com.travel.flight.pojo.flightticket.b r3 = r7.getSource()
            if (r3 == 0) goto L_0x003c
            java.lang.String r3 = r3.getCountryName()
            goto L_0x003d
        L_0x003c:
            r3 = r2
        L_0x003d:
            r1.setSourceCountryName(r3)
            if (r7 == 0) goto L_0x004d
            com.travel.flight.pojo.flightticket.b r3 = r7.getSource()
            if (r3 == 0) goto L_0x004d
            java.lang.String r3 = r3.getAirPortName()
            goto L_0x004e
        L_0x004d:
            r3 = r2
        L_0x004e:
            r1.setSourceAirportName(r3)
            if (r7 == 0) goto L_0x005e
            com.travel.flight.pojo.flightticket.b r3 = r7.getSource()
            if (r3 == 0) goto L_0x005e
            java.lang.String r3 = r3.getCountryCode()
            goto L_0x005f
        L_0x005e:
            r3 = r2
        L_0x005f:
            r1.setSourceCountryCode(r3)
            if (r7 == 0) goto L_0x006f
            com.travel.flight.pojo.flightticket.b r3 = r7.getDestination()
            if (r3 == 0) goto L_0x006f
            java.lang.String r3 = r3.getCityName()
            goto L_0x0070
        L_0x006f:
            r3 = r2
        L_0x0070:
            r1.setDestCityName(r3)
            if (r7 == 0) goto L_0x0080
            com.travel.flight.pojo.flightticket.b r3 = r7.getDestination()
            if (r3 == 0) goto L_0x0080
            java.lang.String r3 = r3.getShortCityName()
            goto L_0x0081
        L_0x0080:
            r3 = r2
        L_0x0081:
            r1.setDestShortCityName(r3)
            if (r7 == 0) goto L_0x0091
            com.travel.flight.pojo.flightticket.b r3 = r7.getDestination()
            if (r3 == 0) goto L_0x0091
            java.lang.String r3 = r3.getCountryName()
            goto L_0x0092
        L_0x0091:
            r3 = r2
        L_0x0092:
            r1.setDestCountryName(r3)
            if (r7 == 0) goto L_0x00a2
            com.travel.flight.pojo.flightticket.b r3 = r7.getDestination()
            if (r3 == 0) goto L_0x00a2
            java.lang.String r3 = r3.getCountryCode()
            goto L_0x00a3
        L_0x00a2:
            r3 = r2
        L_0x00a3:
            r1.setDestCountryCode(r3)
            if (r7 == 0) goto L_0x00b3
            com.travel.flight.pojo.flightticket.b r3 = r7.getDestination()
            if (r3 == 0) goto L_0x00b3
            java.lang.String r3 = r3.getAirPortName()
            goto L_0x00b4
        L_0x00b3:
            r3 = r2
        L_0x00b4:
            r1.setDestAirportName(r3)
            if (r7 == 0) goto L_0x00c2
            int r3 = r7.getmCount_adults()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x00c3
        L_0x00c2:
            r3 = r2
        L_0x00c3:
            if (r3 != 0) goto L_0x00c8
            kotlin.g.b.k.a()
        L_0x00c8:
            int r3 = r3.intValue()
            r1.setAdult(r3)
            if (r7 == 0) goto L_0x00da
            int r3 = r7.getmCount_childerns()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x00db
        L_0x00da:
            r3 = r2
        L_0x00db:
            if (r3 != 0) goto L_0x00e0
            kotlin.g.b.k.a()
        L_0x00e0:
            int r3 = r3.intValue()
            r1.setChild(r3)
            if (r7 == 0) goto L_0x00f2
            int r3 = r7.getmCount_infants()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x00f3
        L_0x00f2:
            r3 = r2
        L_0x00f3:
            if (r3 != 0) goto L_0x00f8
            kotlin.g.b.k.a()
        L_0x00f8:
            int r3 = r3.intValue()
            r1.setInfant(r3)
            if (r7 == 0) goto L_0x0106
            java.lang.String r3 = r7.getClassType()
            goto L_0x0107
        L_0x0106:
            r3 = r2
        L_0x0107:
            if (r3 != 0) goto L_0x010c
            kotlin.g.b.k.a()
        L_0x010c:
            java.lang.String r0 = r0.invoke((java.lang.String) r3, (android.content.Context) r6)
            r1.setTravellerclass(r0)
            if (r7 == 0) goto L_0x011e
            boolean r0 = r7.getNonStopSelected()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x011f
        L_0x011e:
            r0 = r2
        L_0x011f:
            if (r0 != 0) goto L_0x0124
            kotlin.g.b.k.a()
        L_0x0124:
            boolean r0 = r0.booleanValue()
            r1.setNonstopSelected(r0)
            if (r7 == 0) goto L_0x0132
            java.lang.String r0 = r7.getReturnDate()
            goto L_0x0133
        L_0x0132:
            r0 = r2
        L_0x0133:
            java.lang.String r3 = "E, dd MMM yy"
            java.lang.String r4 = "yyyy-MM-dd"
            if (r0 == 0) goto L_0x0170
            r0 = 1
            r1.setRoundTrip(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            if (r7 == 0) goto L_0x014a
            java.lang.String r5 = r7.getDate()
            goto L_0x014b
        L_0x014a:
            r5 = r2
        L_0x014b:
            java.lang.String r3 = com.paytm.utility.b.d((java.lang.String) r5, (java.lang.String) r4, (java.lang.String) r3)
            r0.append(r3)
            java.lang.String r3 = " - "
            r0.append(r3)
            if (r7 == 0) goto L_0x015e
            java.lang.String r3 = r7.getReturnDate()
            goto L_0x015f
        L_0x015e:
            r3 = r2
        L_0x015f:
            java.lang.String r5 = "EEE, dd MMM yy"
            java.lang.String r3 = com.paytm.utility.b.d((java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            r1.setDateDetail(r0)
            goto L_0x0183
        L_0x0170:
            r0 = 0
            r1.setRoundTrip(r0)
            if (r7 == 0) goto L_0x017b
            java.lang.String r0 = r7.getDate()
            goto L_0x017c
        L_0x017b:
            r0 = r2
        L_0x017c:
            java.lang.String r0 = com.paytm.utility.b.d((java.lang.String) r0, (java.lang.String) r4, (java.lang.String) r3)
            r1.setDateDetail(r0)
        L_0x0183:
            com.travel.flight.utils.c.a((android.content.Context) r6, (com.travel.flight.pojo.f) r1)
            if (r7 == 0) goto L_0x018d
            com.travel.flight.pojo.flightticket.b r0 = r7.getSource()
            goto L_0x018e
        L_0x018d:
            r0 = r2
        L_0x018e:
            if (r7 == 0) goto L_0x0194
            com.travel.flight.pojo.flightticket.b r2 = r7.getDestination()
        L_0x0194:
            com.travel.flight.utils.c.a((android.content.Context) r6, (com.travel.flight.pojo.flightticket.b) r0, (com.travel.flight.pojo.flightticket.b) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightSRPV2.a.t.a(android.content.Context, com.travel.flight.pojo.flightticket.CJRFlightSearchInput):void");
    }

    static final class i extends l implements m<String, Context, String> {
        public static final i INSTANCE = new i();

        i() {
            super(2);
        }

        public final String invoke(String str, Context context) {
            k.c(str, "classType");
            k.c(context, "mContext");
            try {
                if (p.a("E", str, true)) {
                    String string = context.getString(R.string.economy_flight);
                    k.a((Object) string, "mContext.getString(R.string.economy_flight)");
                    return string;
                } else if (p.a("B", str, true)) {
                    String string2 = context.getString(R.string.business);
                    k.a((Object) string2, "mContext.getString(R.string.business)");
                    return string2;
                } else if (!p.a(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.FEED_COMMUNITY_POST, str, true)) {
                    return "";
                } else {
                    String string3 = context.getString(R.string.premium_economy);
                    k.a((Object) string3, "mContext.getString(R.string.premium_economy)");
                    return string3;
                }
            } catch (Exception unused) {
                if (p.a("E", str, true)) {
                    return "Economy";
                }
                if (p.a("B", str, true)) {
                    return "Business";
                }
                if (p.a(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.FEED_COMMUNITY_POST, str, true)) {
                    return "Premium Economy";
                }
                return "";
            }
        }
    }

    static final class b extends l implements kotlin.g.a.a<SimpleDateFormat> {
        public static final b INSTANCE = new b();

        b() {
            super(0);
        }

        public final SimpleDateFormat invoke() {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        }
    }

    public static final synchronized Date a(String str) {
        Date parse;
        synchronized (t.class) {
            k.c(str, "input");
            parse = ((SimpleDateFormat) f24124a.getValue()).parse(str);
            k.a((Object) parse, "departureArrivalDateFormat.parse(input)");
        }
        return parse;
    }
}
