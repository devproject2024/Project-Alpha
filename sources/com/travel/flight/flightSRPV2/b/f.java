package com.travel.flight.flightSRPV2.b;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import com.travel.flight.activity.AJREmbedWebView;
import com.travel.flight.flightSRPV2.view.ui.b.a.a;
import com.travel.flight.flightSRPV2.view.ui.b.b.c;
import com.travel.flight.flightSRPV2.view.ui.b.c.b;
import com.travel.flight.flightSRPV2.view.ui.b.e;
import com.travel.flight.flightSRPV2.view.ui.b.g;
import com.travel.flight.flightSRPV2.view.ui.b.h;
import com.travel.flight.flightticket.activity.AJRAddTravellerActivity;
import com.travel.flight.flightticket.activity.AJRFlightReviewItenarary;
import com.travel.flight.flightticket.activity.AJRSelectAirportActivity;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.g.b.k;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final f f24150a = new f();

    /* renamed from: b  reason: collision with root package name */
    private static final Map<String, String> f24151b;

    static {
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        f24151b = linkedHashMap;
        String name = g.class.getName();
        k.a((Object) name, "SRPLoadingFragment::class.java.name");
        linkedHashMap.put("PAGE_SRP_LOADING", name);
        Map<String, String> map = f24151b;
        String name2 = com.travel.flight.flightSRPV2.view.ui.b.f.class.getName();
        k.a((Object) name2, "NoInternetV2Fragment::class.java.name");
        map.put("PAGE_NO_INTERNET", name2);
        Map<String, String> map2 = f24151b;
        String name3 = e.class.getName();
        k.a((Object) name3, "NoFlightsFoundFragment::class.java.name");
        map2.put("PAGE_NO_FLIGHTS_FOUND", name3);
        Map<String, String> map3 = f24151b;
        String name4 = b.class.getName();
        k.a((Object) name4, "SRPOneWayFragment::class.java.name");
        map3.put("PAGE_SRP_ONE_WAY_TRIP", name4);
        Map<String, String> map4 = f24151b;
        String name5 = AJRFlightReviewItenarary.class.getName();
        k.a((Object) name5, "AJRFlightReviewItenarary::class.java.name");
        map4.put("PAGE_REVIEW_ITINERARY", name5);
        Map<String, String> map5 = f24151b;
        String name6 = com.travel.flight.flightSRPV2.view.ui.b.a.b.class.getName();
        k.a((Object) name6, "DomesticRoundTripFragment::class.java.name");
        map5.put("PAGE_SRP_DOMESTIC_ROUND_TRIP", name6);
        Map<String, String> map6 = f24151b;
        String name7 = com.travel.flight.flightSRPV2.view.ui.b.b.b.class.getName();
        k.a((Object) name7, "IRTSplitViewFragment::class.java.name");
        map6.put("PAGE_INTERNATIONAL_FLIGHT_LIST", name7);
        Map<String, String> map7 = f24151b;
        String name8 = c.class.getName();
        k.a((Object) name8, "InternationalRoundTripFragment::class.java.name");
        map7.put("PAGE_SRP_INTERNATIONAL_ROUND_TRIP", name8);
        Map<String, String> map8 = f24151b;
        String name9 = com.travel.flight.flightSRPV2.view.ui.b.b.class.getName();
        k.a((Object) name9, "FlightFilterHomeFragment::class.java.name");
        map8.put("PAGE_FILTER_HOME", name9);
        Map<String, String> map9 = f24151b;
        String name10 = a.class.getName();
        k.a((Object) name10, "DRTSortPopupFragment::class.java.name");
        map9.put("PAGE_SORT_HOME", name10);
        Map<String, String> map10 = f24151b;
        String name11 = com.travel.flight.flightSRPV2.view.ui.b.b.a.class.getName();
        k.a((Object) name11, "IRTSortPopupFragment::class.java.name");
        map10.put("PAGE_IRT_SORT_POPUP", name11);
        Map<String, String> map11 = f24151b;
        String name12 = h.class.getName();
        k.a((Object) name12, "SRPModifyFragment::class.java.name");
        map11.put("PAGE_SRP_MODIFY", name12);
        Map<String, String> map12 = f24151b;
        String name13 = AJRSelectAirportActivity.class.getName();
        k.a((Object) name13, "AJRSelectAirportActivity::class.java.name");
        map12.put("PAGE_SELECT_AIRPORT", name13);
        Map<String, String> map13 = f24151b;
        String name14 = AJRAddTravellerActivity.class.getName();
        k.a((Object) name14, "AJRAddTravellerActivity::class.java.name");
        map13.put("PAGE_ADD_TRAVELLER", name14);
        Map<String, String> map14 = f24151b;
        String name15 = com.travel.flight.flightSRPV2.view.ui.b.c.a.class.getName();
        k.a((Object) name15, "FlightOneWaySortPopupFragment::class.java.name");
        map14.put("PAGE_ONE_WAY_SORT_POPUP", name15);
        Map<String, String> map15 = f24151b;
        String name16 = com.travel.flight.flightSRPV2.view.ui.b.c.class.getName();
        k.a((Object) name16, "FlightSRPShimmerFragment::class.java.name");
        map15.put("PAGE_SRP_SHIMMER", name16);
        Map<String, String> map16 = f24151b;
        String name17 = AJREmbedWebView.class.getName();
        k.a((Object) name17, "AJREmbedWebView::class.java.name");
        map16.put("PAGE_EMBED_WEB_VIEW", name17);
    }

    private f() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:72:0x012b, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean a(androidx.fragment.app.FragmentActivity r7, com.travel.flight.flightSRPV2.b.d r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            java.lang.String r0 = "activity"
            kotlin.g.b.k.c(r7, r0)     // Catch:{ all -> 0x012e }
            java.lang.String r0 = "params"
            kotlin.g.b.k.c(r8, r0)     // Catch:{ all -> 0x012e }
            java.util.Map<java.lang.String, java.lang.String> r0 = f24151b     // Catch:{ all -> 0x012e }
            java.lang.String r1 = r8.f24145d     // Catch:{ all -> 0x012e }
            boolean r0 = r0.containsKey(r1)     // Catch:{ all -> 0x012e }
            r1 = 0
            if (r0 != 0) goto L_0x0018
            monitor-exit(r6)
            return r1
        L_0x0018:
            java.util.Map<java.lang.String, java.lang.String> r0 = f24151b     // Catch:{ all -> 0x012e }
            java.lang.String r2 = r8.f24145d     // Catch:{ all -> 0x012e }
            java.lang.Object r0 = r0.get(r2)     // Catch:{ all -> 0x012e }
            if (r0 != 0) goto L_0x0025
            kotlin.g.b.k.a()     // Catch:{ all -> 0x012e }
        L_0x0025:
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x012e }
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ all -> 0x012e }
            int r2 = r2.length()     // Catch:{ all -> 0x012e }
            r3 = 1
            if (r2 != 0) goto L_0x0033
            r2 = 1
            goto L_0x0034
        L_0x0033:
            r2 = 0
        L_0x0034:
            if (r2 == 0) goto L_0x0038
            monitor-exit(r6)
            return r1
        L_0x0038:
            androidx.fragment.app.j r2 = r7.getSupportFragmentManager()     // Catch:{ all -> 0x012e }
            int r4 = com.travel.flight.R.id.container_full_overlay     // Catch:{ all -> 0x012e }
            androidx.fragment.app.Fragment r2 = r2.c((int) r4)     // Catch:{ all -> 0x012e }
            java.util.Map<java.lang.String, java.lang.String> r4 = f24151b     // Catch:{ all -> 0x012e }
            java.lang.String r5 = "PAGE_SORT_HOME"
            java.lang.Object r4 = r4.get(r5)     // Catch:{ all -> 0x012e }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x012e }
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r4)     // Catch:{ all -> 0x012e }
            if (r4 == 0) goto L_0x0058
            boolean r4 = r2 instanceof com.travel.flight.flightSRPV2.view.ui.b.a.a     // Catch:{ all -> 0x012e }
            if (r4 == 0) goto L_0x0058
            monitor-exit(r6)
            return r1
        L_0x0058:
            java.util.Map<java.lang.String, java.lang.String> r4 = f24151b     // Catch:{ all -> 0x012e }
            java.lang.String r5 = "PAGE_IRT_SORT_POPUP"
            java.lang.Object r4 = r4.get(r5)     // Catch:{ all -> 0x012e }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x012e }
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r4)     // Catch:{ all -> 0x012e }
            if (r4 == 0) goto L_0x006e
            boolean r4 = r2 instanceof com.travel.flight.flightSRPV2.view.ui.b.b.a     // Catch:{ all -> 0x012e }
            if (r4 == 0) goto L_0x006e
            monitor-exit(r6)
            return r1
        L_0x006e:
            java.util.Map<java.lang.String, java.lang.String> r4 = f24151b     // Catch:{ all -> 0x012e }
            java.lang.String r5 = "PAGE_ONE_WAY_SORT_POPUP"
            java.lang.Object r4 = r4.get(r5)     // Catch:{ all -> 0x012e }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x012e }
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r4)     // Catch:{ all -> 0x012e }
            if (r4 == 0) goto L_0x0084
            boolean r2 = r2 instanceof com.travel.flight.flightSRPV2.view.ui.b.c.a     // Catch:{ all -> 0x012e }
            if (r2 == 0) goto L_0x0084
            monitor-exit(r6)
            return r1
        L_0x0084:
            boolean r2 = r8 instanceof com.travel.flight.flightSRPV2.b.c     // Catch:{ all -> 0x012e }
            if (r2 == 0) goto L_0x00f0
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ all -> 0x012e }
            java.lang.String r2 = "Class.forName(targetClassName)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)     // Catch:{ all -> 0x012e }
            java.lang.Object r0 = r0.newInstance()     // Catch:{ all -> 0x012e }
            if (r0 == 0) goto L_0x00e8
            androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0     // Catch:{ all -> 0x012e }
            android.os.Bundle r2 = r8.f24146e     // Catch:{ all -> 0x012e }
            if (r2 == 0) goto L_0x00a2
            android.os.Bundle r2 = r8.f24146e     // Catch:{ all -> 0x012e }
            r0.setArguments(r2)     // Catch:{ all -> 0x012e }
        L_0x00a2:
            r0.setRetainInstance(r3)     // Catch:{ all -> 0x012e }
            androidx.fragment.app.j r7 = r7.getSupportFragmentManager()     // Catch:{ all -> 0x012e }
            androidx.fragment.app.q r7 = r7.a()     // Catch:{ all -> 0x012e }
            java.lang.String r2 = "activity.supportFragmentManager.beginTransaction()"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r2)     // Catch:{ all -> 0x012e }
            com.travel.flight.flightSRPV2.b.e r2 = r8.f24147f     // Catch:{ all -> 0x012e }
            if (r2 == 0) goto L_0x00c1
            com.travel.flight.flightSRPV2.b.e r2 = r8.f24147f     // Catch:{ all -> 0x012e }
            int r2 = r2.f24148a     // Catch:{ all -> 0x012e }
            com.travel.flight.flightSRPV2.b.e r4 = r8.f24147f     // Catch:{ all -> 0x012e }
            int r4 = r4.f24149b     // Catch:{ all -> 0x012e }
            r7.a((int) r2, (int) r1, (int) r1, (int) r4)     // Catch:{ all -> 0x012e }
        L_0x00c1:
            r1 = r8
            com.travel.flight.flightSRPV2.b.c r1 = (com.travel.flight.flightSRPV2.b.c) r1     // Catch:{ all -> 0x012e }
            boolean r1 = r1.f24143b     // Catch:{ all -> 0x012e }
            if (r1 == 0) goto L_0x00dd
            r1 = r8
            com.travel.flight.flightSRPV2.b.c r1 = (com.travel.flight.flightSRPV2.b.c) r1     // Catch:{ all -> 0x012e }
            int r1 = r1.f24142a     // Catch:{ all -> 0x012e }
            r2 = r8
            com.travel.flight.flightSRPV2.b.c r2 = (com.travel.flight.flightSRPV2.b.c) r2     // Catch:{ all -> 0x012e }
            java.lang.String r2 = r2.f24144c     // Catch:{ all -> 0x012e }
            r7.a(r1, r0, r2)     // Catch:{ all -> 0x012e }
            com.travel.flight.flightSRPV2.b.c r8 = (com.travel.flight.flightSRPV2.b.c) r8     // Catch:{ all -> 0x012e }
            java.lang.String r8 = r8.f24144c     // Catch:{ all -> 0x012e }
            r7.a((java.lang.String) r8)     // Catch:{ all -> 0x012e }
            goto L_0x00e4
        L_0x00dd:
            com.travel.flight.flightSRPV2.b.c r8 = (com.travel.flight.flightSRPV2.b.c) r8     // Catch:{ all -> 0x012e }
            int r8 = r8.f24142a     // Catch:{ all -> 0x012e }
            r7.b(r8, r0)     // Catch:{ all -> 0x012e }
        L_0x00e4:
            r7.c()     // Catch:{ all -> 0x012e }
            goto L_0x012a
        L_0x00e8:
            kotlin.u r7 = new kotlin.u     // Catch:{ all -> 0x012e }
            java.lang.String r8 = "null cannot be cast to non-null type androidx.fragment.app.Fragment"
            r7.<init>(r8)     // Catch:{ all -> 0x012e }
            throw r7     // Catch:{ all -> 0x012e }
        L_0x00f0:
            boolean r2 = r8 instanceof com.travel.flight.flightSRPV2.b.a     // Catch:{ all -> 0x012e }
            if (r2 == 0) goto L_0x012c
            android.content.Intent r1 = new android.content.Intent     // Catch:{ all -> 0x012e }
            r1.<init>()     // Catch:{ all -> 0x012e }
            r2 = r7
            android.content.Context r2 = (android.content.Context) r2     // Catch:{ all -> 0x012e }
            r1.setClassName(r2, r0)     // Catch:{ all -> 0x012e }
            android.os.Bundle r0 = r8.f24146e     // Catch:{ all -> 0x012e }
            if (r0 == 0) goto L_0x0108
            android.os.Bundle r0 = r8.f24146e     // Catch:{ all -> 0x012e }
            r1.putExtras(r0)     // Catch:{ all -> 0x012e }
        L_0x0108:
            r0 = r8
            com.travel.flight.flightSRPV2.b.a r0 = (com.travel.flight.flightSRPV2.b.a) r0     // Catch:{ all -> 0x012e }
            boolean r0 = r0.f24138a     // Catch:{ all -> 0x012e }
            if (r0 == 0) goto L_0x0118
            r0 = r8
            com.travel.flight.flightSRPV2.b.a r0 = (com.travel.flight.flightSRPV2.b.a) r0     // Catch:{ all -> 0x012e }
            int r0 = r0.f24139b     // Catch:{ all -> 0x012e }
            r7.startActivityForResult(r1, r0)     // Catch:{ all -> 0x012e }
            goto L_0x011b
        L_0x0118:
            r7.startActivity(r1)     // Catch:{ all -> 0x012e }
        L_0x011b:
            com.travel.flight.flightSRPV2.b.e r0 = r8.f24147f     // Catch:{ all -> 0x012e }
            if (r0 == 0) goto L_0x012a
            com.travel.flight.flightSRPV2.b.e r0 = r8.f24147f     // Catch:{ all -> 0x012e }
            int r0 = r0.f24148a     // Catch:{ all -> 0x012e }
            com.travel.flight.flightSRPV2.b.e r8 = r8.f24147f     // Catch:{ all -> 0x012e }
            int r8 = r8.f24149b     // Catch:{ all -> 0x012e }
            r7.overridePendingTransition(r0, r8)     // Catch:{ all -> 0x012e }
        L_0x012a:
            monitor-exit(r6)
            return r3
        L_0x012c:
            monitor-exit(r6)
            return r1
        L_0x012e:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightSRPV2.b.f.a(androidx.fragment.app.FragmentActivity, com.travel.flight.flightSRPV2.b.d):boolean");
    }

    public final synchronized void a(FragmentActivity fragmentActivity) {
        k.c(fragmentActivity, "activity");
        j supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        k.a((Object) supportFragmentManager, "activity.supportFragmentManager");
        supportFragmentManager.d();
    }
}
