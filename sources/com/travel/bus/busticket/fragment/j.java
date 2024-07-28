package com.travel.bus.busticket.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.bus.R;
import com.travel.bus.pojo.busticket.TripBusDetailsItem;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;
import net.one97.paytm.i.h;

public class j extends h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<TripBusDetailsItem> f22285a;

    /* renamed from: b  reason: collision with root package name */
    private View f22286b;

    /* renamed from: c  reason: collision with root package name */
    private long f22287c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f22288d = false;

    /* renamed from: e  reason: collision with root package name */
    private a f22289e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f22290f;

    public interface a {
        void a(TripBusDetailsItem tripBusDetailsItem, View view);

        ArrayList<TripBusDetailsItem> h();

        void i();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey("intent_extra_select_seat_trip_list")) {
            this.f22285a = (ArrayList) arguments.getSerializable("intent_extra_select_seat_trip_list");
        }
        if (arguments != null && arguments.containsKey("intent_extra_select_seat_row_count")) {
            this.f22287c = arguments.getLong("intent_extra_select_seat_row_count");
        }
        if (arguments != null && arguments.containsKey("intent_extra_select_seat_is_upper")) {
            this.f22288d = arguments.getBoolean("intent_extra_select_seat_is_upper");
        }
        if (arguments != null && arguments.containsKey("bus_is_social_distancing_intent")) {
            this.f22290f = arguments.getBoolean("bus_is_social_distancing_intent");
        }
        com.travel.bus.a.a();
        com.travel.bus.a.b().a("/bus-tickets-seatlayout", "BusTicket", (Context) getActivity());
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        com.google.android.play.core.splitcompat.a.b((Context) activity);
        if (activity instanceof a) {
            this.f22289e = (a) activity;
        }
    }

    public void onResume() {
        super.onResume();
        com.google.android.play.core.splitcompat.a.b((Context) getActivity());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f22286b = layoutInflater.inflate(R.layout.pre_b_fragment_select_seats, (ViewGroup) null);
        b("");
        if (this.f22290f) {
            this.f22286b.findViewById(R.id.iv_covid_seat_icon).setVisibility(0);
        }
        return this.f22286b;
    }

    public final void a(String str) {
        if (str.equalsIgnoreCase(AppConstants.FOR_ALL)) {
            str = "";
        }
        b(str);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: android.widget.ImageView} */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x006f, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0071, code lost:
        return;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(com.travel.bus.pojo.busticket.TripBusDetailsItem r6, android.view.View r7, java.lang.String r8) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.util.ArrayList<com.travel.bus.pojo.busticket.TripBusDetailsItem> r0 = r5.f22285a     // Catch:{ all -> 0x0072 }
            if (r0 == 0) goto L_0x0070
            java.util.ArrayList<com.travel.bus.pojo.busticket.TripBusDetailsItem> r0 = r5.f22285a     // Catch:{ all -> 0x0072 }
            int r0 = r0.size()     // Catch:{ all -> 0x0072 }
            if (r0 == 0) goto L_0x0070
            long r0 = r5.f22287c     // Catch:{ all -> 0x0072 }
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0070
            if (r7 == 0) goto L_0x0070
            boolean r0 = r7 instanceof android.view.ViewGroup     // Catch:{ all -> 0x0072 }
            if (r0 == 0) goto L_0x0070
            if (r6 == 0) goto L_0x0070
            com.travel.bus.busticket.fragment.j$a r0 = r5.f22289e     // Catch:{ all -> 0x0072 }
            if (r0 != 0) goto L_0x0022
            goto L_0x0070
        L_0x0022:
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7     // Catch:{ all -> 0x0072 }
            r0 = 0
            r1 = 0
        L_0x0026:
            int r2 = r7.getChildCount()     // Catch:{ all -> 0x0072 }
            if (r1 >= r2) goto L_0x0053
            android.view.View r2 = r7.getChildAt(r1)     // Catch:{ all -> 0x0072 }
            java.lang.Object r3 = r2.getTag()     // Catch:{ all -> 0x0072 }
            if (r3 == 0) goto L_0x0050
            java.lang.Object r3 = r2.getTag()     // Catch:{ all -> 0x0072 }
            boolean r3 = r3 instanceof java.lang.String     // Catch:{ all -> 0x0072 }
            if (r3 == 0) goto L_0x0050
            java.lang.Object r3 = r2.getTag()     // Catch:{ all -> 0x0072 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0072 }
            java.lang.String r4 = "img"
            boolean r3 = r3.equalsIgnoreCase(r4)     // Catch:{ all -> 0x0072 }
            if (r3 == 0) goto L_0x0050
            r0 = r2
            android.widget.ImageView r0 = (android.widget.ImageView) r0     // Catch:{ all -> 0x0072 }
            goto L_0x0053
        L_0x0050:
            int r1 = r1 + 1
            goto L_0x0026
        L_0x0053:
            if (r0 != 0) goto L_0x0057
            monitor-exit(r5)
            return
        L_0x0057:
            com.travel.bus.busticket.fragment.j$a r7 = r5.f22289e     // Catch:{ all -> 0x0072 }
            java.util.ArrayList r7 = r7.h()     // Catch:{ all -> 0x0072 }
            if (r7 != 0) goto L_0x0061
            monitor-exit(r5)
            return
        L_0x0061:
            boolean r7 = r7.contains(r6)     // Catch:{ all -> 0x0072 }
            int r6 = com.travel.bus.busticket.i.o.a((com.travel.bus.pojo.busticket.TripBusDetailsItem) r6, (boolean) r7, (java.lang.String) r8)     // Catch:{ all -> 0x0072 }
            if (r6 == 0) goto L_0x006e
            r0.setImageResource(r6)     // Catch:{ all -> 0x0072 }
        L_0x006e:
            monitor-exit(r5)
            return
        L_0x0070:
            monitor-exit(r5)
            return
        L_0x0072:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.busticket.fragment.j.a(com.travel.bus.pojo.busticket.TripBusDetailsItem, android.view.View, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0269, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01da  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01e1 A[Catch:{ all -> 0x0249, all -> 0x026a }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01ec A[Catch:{ all -> 0x0249, all -> 0x026a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void b(java.lang.String r25) {
        /*
            r24 = this;
            r1 = r24
            monitor-enter(r24)
            java.util.ArrayList<com.travel.bus.pojo.busticket.TripBusDetailsItem> r0 = r1.f22285a     // Catch:{ all -> 0x026f }
            if (r0 == 0) goto L_0x026c
            java.util.ArrayList<com.travel.bus.pojo.busticket.TripBusDetailsItem> r0 = r1.f22285a     // Catch:{ all -> 0x026f }
            int r0 = r0.size()     // Catch:{ all -> 0x026f }
            if (r0 == 0) goto L_0x026c
            long r2 = r1.f22287c     // Catch:{ all -> 0x026f }
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x0019
            goto L_0x026c
        L_0x0019:
            r0 = 0
            com.travel.bus.busticket.fragment.j$a r2 = r1.f22289e     // Catch:{ all -> 0x026f }
            if (r2 == 0) goto L_0x0024
            com.travel.bus.busticket.fragment.j$a r0 = r1.f22289e     // Catch:{ all -> 0x026f }
            java.util.ArrayList r0 = r0.h()     // Catch:{ all -> 0x026f }
        L_0x0024:
            android.content.Context r2 = r24.getContext()     // Catch:{ all -> 0x026f }
            int r2 = com.paytm.utility.b.f((android.content.Context) r2)     // Catch:{ all -> 0x026f }
            android.util.DisplayMetrics r3 = new android.util.DisplayMetrics     // Catch:{ all -> 0x026f }
            r3.<init>()     // Catch:{ all -> 0x026f }
            androidx.fragment.app.FragmentActivity r4 = r24.getActivity()     // Catch:{ all -> 0x026f }
            android.view.WindowManager r4 = r4.getWindowManager()     // Catch:{ all -> 0x026f }
            android.view.Display r4 = r4.getDefaultDisplay()     // Catch:{ all -> 0x026f }
            r4.getMetrics(r3)     // Catch:{ all -> 0x026f }
            float r4 = r3.density     // Catch:{ all -> 0x026f }
            int r3 = r3.widthPixels     // Catch:{ all -> 0x026f }
            r5 = 2
            int r2 = r2 * 2
            int r6 = r3 - r2
            long r6 = (long) r6     // Catch:{ all -> 0x026f }
            long r8 = r1.f22287c     // Catch:{ all -> 0x026f }
            long r6 = r6 / r8
            int r7 = (int) r6     // Catch:{ all -> 0x026f }
            java.lang.String r6 = "Cell size is "
            java.lang.String r8 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x026f }
            r6.concat(r8)     // Catch:{ all -> 0x026f }
            com.paytm.utility.b.j()     // Catch:{ all -> 0x026f }
            android.view.View r6 = r1.f22286b     // Catch:{ all -> 0x026f }
            int r8 = com.travel.bus.R.id.img_driver     // Catch:{ all -> 0x026f }
            android.view.View r6 = r6.findViewById(r8)     // Catch:{ all -> 0x026f }
            android.widget.ImageView r6 = (android.widget.ImageView) r6     // Catch:{ all -> 0x026f }
            boolean r8 = r1.f22288d     // Catch:{ all -> 0x026f }
            r9 = 0
            if (r8 == 0) goto L_0x0071
            r8 = 4
            r6.setVisibility(r8)     // Catch:{ all -> 0x026f }
            com.paytm.utility.b.j()     // Catch:{ all -> 0x026f }
            goto L_0x0077
        L_0x0071:
            r6.setVisibility(r9)     // Catch:{ all -> 0x026f }
            com.paytm.utility.b.j()     // Catch:{ all -> 0x026f }
        L_0x0077:
            android.view.View r8 = r1.f22286b     // Catch:{ all -> 0x026f }
            int r10 = com.travel.bus.R.id.lyt_seats_container     // Catch:{ all -> 0x026f }
            android.view.View r8 = r8.findViewById(r10)     // Catch:{ all -> 0x026f }
            android.widget.RelativeLayout r8 = (android.widget.RelativeLayout) r8     // Catch:{ all -> 0x026f }
            r8.removeAllViews()     // Catch:{ all -> 0x026f }
            java.util.ArrayList<com.travel.bus.pojo.busticket.TripBusDetailsItem> r10 = r1.f22285a     // Catch:{ all -> 0x026f }
            java.util.ArrayList r10 = a((java.util.ArrayList<com.travel.bus.pojo.busticket.TripBusDetailsItem>) r10)     // Catch:{ all -> 0x026f }
            java.lang.Object r11 = r10.get(r9)     // Catch:{ all -> 0x026f }
            com.travel.bus.pojo.busticket.TripBusDetailsItem r11 = (com.travel.bus.pojo.busticket.TripBusDetailsItem) r11     // Catch:{ all -> 0x026f }
            long r11 = r11.getRow()     // Catch:{ all -> 0x026f }
            java.lang.Object r13 = r10.get(r9)     // Catch:{ all -> 0x026f }
            com.travel.bus.pojo.busticket.TripBusDetailsItem r13 = (com.travel.bus.pojo.busticket.TripBusDetailsItem) r13     // Catch:{ all -> 0x026f }
            long r13 = r13.getColumn()     // Catch:{ all -> 0x026f }
            java.util.Iterator r15 = r10.iterator()     // Catch:{ all -> 0x026f }
            r16 = 0
            r17 = 0
        L_0x00a6:
            boolean r18 = r15.hasNext()     // Catch:{ all -> 0x026f }
            if (r18 == 0) goto L_0x00c8
            java.lang.Object r18 = r15.next()     // Catch:{ all -> 0x026f }
            com.travel.bus.pojo.busticket.TripBusDetailsItem r18 = (com.travel.bus.pojo.busticket.TripBusDetailsItem) r18     // Catch:{ all -> 0x026f }
            long r19 = r18.getRow()     // Catch:{ all -> 0x026f }
            int r21 = (r19 > r11 ? 1 : (r19 == r11 ? 0 : -1))
            if (r21 == 0) goto L_0x00bc
            r16 = 1
        L_0x00bc:
            long r19 = r18.getColumn()     // Catch:{ all -> 0x026f }
            int r18 = (r19 > r13 ? 1 : (r19 == r13 ? 0 : -1))
            if (r18 == 0) goto L_0x00c6
            r17 = 1
        L_0x00c6:
            r5 = 2
            goto L_0x00a6
        L_0x00c8:
            r11 = 0
        L_0x00c9:
            int r12 = r10.size()     // Catch:{ all -> 0x026f }
            if (r11 >= r12) goto L_0x025e
            java.lang.Object r12 = r10.get(r11)     // Catch:{ all -> 0x026f }
            com.travel.bus.pojo.busticket.TripBusDetailsItem r12 = (com.travel.bus.pojo.busticket.TripBusDetailsItem) r12     // Catch:{ all -> 0x026f }
            if (r12 == 0) goto L_0x024d
            android.widget.RelativeLayout r13 = new android.widget.RelativeLayout     // Catch:{ all -> 0x026f }
            androidx.fragment.app.FragmentActivity r14 = r24.getActivity()     // Catch:{ all -> 0x026f }
            r13.<init>(r14)     // Catch:{ all -> 0x026f }
            android.widget.RelativeLayout$LayoutParams r14 = new android.widget.RelativeLayout$LayoutParams     // Catch:{ all -> 0x026f }
            r18 = r10
            long r9 = (long) r7     // Catch:{ all -> 0x026f }
            long r19 = r12.getWidth()     // Catch:{ all -> 0x026f }
            r21 = r6
            long r5 = r9 * r19
            int r6 = (int) r5
            r5 = 1110704128(0x42340000, float:45.0)
            float r5 = r5 * r4
            r19 = r0
            long r0 = r12.getLength()     // Catch:{ all -> 0x0249 }
            float r0 = (float) r0     // Catch:{ all -> 0x0249 }
            float r0 = r0 * r5
            int r0 = (int) r0     // Catch:{ all -> 0x0249 }
            r14.<init>(r6, r0)     // Catch:{ all -> 0x0249 }
            long r0 = r12.getColumn()     // Catch:{ all -> 0x0249 }
            float r0 = (float) r0     // Catch:{ all -> 0x0249 }
            float r0 = r0 * r5
            int r0 = (int) r0     // Catch:{ all -> 0x0249 }
            r14.topMargin = r0     // Catch:{ all -> 0x0249 }
            if (r16 == 0) goto L_0x014a
            if (r17 == 0) goto L_0x014a
            long r0 = r12.getWidth()     // Catch:{ all -> 0x0249 }
            r5 = 1
            int r20 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r20 <= 0) goto L_0x0134
            double r0 = (double) r3     // Catch:{ all -> 0x0249 }
            long r5 = r12.getRow()     // Catch:{ all -> 0x0249 }
            double r5 = (double) r5     // Catch:{ all -> 0x0249 }
            long r9 = r12.getWidth()     // Catch:{ all -> 0x0249 }
            double r9 = (double) r9     // Catch:{ all -> 0x0249 }
            r22 = 4608758678669597082(0x3ff599999999999a, double:1.35)
            double r9 = r9 / r22
            double r5 = r5 + r9
            double r9 = (double) r7     // Catch:{ all -> 0x0249 }
            double r5 = r5 * r9
            double r0 = r0 - r5
            double r5 = (double) r2     // Catch:{ all -> 0x0249 }
            double r0 = r0 - r5
            int r0 = (int) r0     // Catch:{ all -> 0x0249 }
            r14.leftMargin = r0     // Catch:{ all -> 0x0249 }
            goto L_0x0147
        L_0x0134:
            long r0 = (long) r3     // Catch:{ all -> 0x0249 }
            long r5 = r12.getRow()     // Catch:{ all -> 0x0249 }
            long r22 = r12.getWidth()     // Catch:{ all -> 0x0249 }
            long r5 = r5 + r22
            long r5 = r5 * r9
            long r0 = r0 - r5
            long r5 = (long) r2     // Catch:{ all -> 0x0249 }
            long r0 = r0 - r5
            int r1 = (int) r0     // Catch:{ all -> 0x0249 }
            r14.leftMargin = r1     // Catch:{ all -> 0x0249 }
        L_0x0147:
            r6 = r21
            goto L_0x016c
        L_0x014a:
            android.widget.RelativeLayout$LayoutParams r0 = new android.widget.RelativeLayout$LayoutParams     // Catch:{ all -> 0x0249 }
            r1 = 70
            r0.<init>(r1, r1)     // Catch:{ all -> 0x0249 }
            r1 = 20
            r0.bottomMargin = r1     // Catch:{ all -> 0x0249 }
            r1 = 14
            r0.addRule(r1)     // Catch:{ all -> 0x0249 }
            r14.addRule(r1)     // Catch:{ all -> 0x0249 }
            r6 = r21
            r6.setLayoutParams(r0)     // Catch:{ all -> 0x0249 }
            long r0 = r12.getColumn()     // Catch:{ all -> 0x0249 }
            float r0 = (float) r0     // Catch:{ all -> 0x0249 }
            float r5 = r5 * r0
            int r0 = (int) r5     // Catch:{ all -> 0x0249 }
            r14.topMargin = r0     // Catch:{ all -> 0x0249 }
        L_0x016c:
            r13.setLayoutParams(r14)     // Catch:{ all -> 0x0249 }
            android.widget.ImageView r0 = new android.widget.ImageView     // Catch:{ all -> 0x0249 }
            androidx.fragment.app.FragmentActivity r1 = r24.getActivity()     // Catch:{ all -> 0x0249 }
            r0.<init>(r1)     // Catch:{ all -> 0x0249 }
            android.widget.RelativeLayout$LayoutParams r1 = new android.widget.RelativeLayout$LayoutParams     // Catch:{ all -> 0x0249 }
            r5 = -1
            r1.<init>(r5, r5)     // Catch:{ all -> 0x0249 }
            r5 = 13
            r1.addRule(r5)     // Catch:{ all -> 0x0249 }
            r0.setLayoutParams(r1)     // Catch:{ all -> 0x0249 }
            r1 = 1086324736(0x40c00000, float:6.0)
            float r1 = r1 * r4
            int r1 = (int) r1     // Catch:{ all -> 0x0249 }
            r0.setPadding(r1, r1, r1, r1)     // Catch:{ all -> 0x0249 }
            java.lang.String r1 = "img"
            r0.setTag(r1)     // Catch:{ all -> 0x0249 }
            if (r19 == 0) goto L_0x01cb
            r1 = 0
        L_0x0196:
            int r9 = r19.size()     // Catch:{ all -> 0x0249 }
            if (r1 >= r9) goto L_0x01cb
            if (r12 == 0) goto L_0x01c4
            r9 = r19
            java.lang.Object r10 = r9.get(r1)     // Catch:{ all -> 0x0249 }
            com.travel.bus.pojo.busticket.TripBusDetailsItem r10 = (com.travel.bus.pojo.busticket.TripBusDetailsItem) r10     // Catch:{ all -> 0x0249 }
            java.lang.String r10 = r10.getSeatName()     // Catch:{ all -> 0x0249 }
            if (r10 == 0) goto L_0x01c6
            java.lang.String r10 = r12.getSeatName()     // Catch:{ all -> 0x0249 }
            java.lang.Object r14 = r9.get(r1)     // Catch:{ all -> 0x0249 }
            com.travel.bus.pojo.busticket.TripBusDetailsItem r14 = (com.travel.bus.pojo.busticket.TripBusDetailsItem) r14     // Catch:{ all -> 0x0249 }
            java.lang.String r14 = r14.getSeatName()     // Catch:{ all -> 0x0249 }
            boolean r10 = r10.equalsIgnoreCase(r14)     // Catch:{ all -> 0x0249 }
            if (r10 == 0) goto L_0x01c6
            r1 = r25
            r10 = 1
            goto L_0x01d0
        L_0x01c4:
            r9 = r19
        L_0x01c6:
            int r1 = r1 + 1
            r19 = r9
            goto L_0x0196
        L_0x01cb:
            r9 = r19
            r1 = r25
            r10 = 0
        L_0x01d0:
            int r10 = com.travel.bus.busticket.i.o.a((com.travel.bus.pojo.busticket.TripBusDetailsItem) r12, (boolean) r10, (java.lang.String) r1)     // Catch:{ all -> 0x0249 }
            boolean r14 = r12.getAvailable()     // Catch:{ all -> 0x0249 }
            if (r14 == 0) goto L_0x01e1
            r14 = r24
            r13.setOnClickListener(r14)     // Catch:{ all -> 0x026a }
            r15 = 0
            goto L_0x01ea
        L_0x01e1:
            r15 = 0
            r14 = r24
            r13.setEnabled(r15)     // Catch:{ all -> 0x026a }
            r13.setClickable(r15)     // Catch:{ all -> 0x026a }
        L_0x01ea:
            if (r10 == 0) goto L_0x01ef
            r0.setImageResource(r10)     // Catch:{ all -> 0x026a }
        L_0x01ef:
            r13.addView(r0)     // Catch:{ all -> 0x026a }
            android.widget.TextView r0 = new android.widget.TextView     // Catch:{ all -> 0x026a }
            androidx.fragment.app.FragmentActivity r15 = r24.getActivity()     // Catch:{ all -> 0x026a }
            r0.<init>(r15)     // Catch:{ all -> 0x026a }
            android.content.res.Resources r15 = r24.getResources()     // Catch:{ all -> 0x026a }
            android.graphics.drawable.Drawable r10 = r15.getDrawable(r10)     // Catch:{ all -> 0x026a }
            int r10 = r10.getIntrinsicWidth()     // Catch:{ all -> 0x026a }
            android.widget.RelativeLayout$LayoutParams r15 = new android.widget.RelativeLayout$LayoutParams     // Catch:{ all -> 0x026a }
            r5 = -2
            r15.<init>(r10, r5)     // Catch:{ all -> 0x026a }
            r5 = 13
            r15.addRule(r5)     // Catch:{ all -> 0x026a }
            r0.setLayoutParams(r15)     // Catch:{ all -> 0x026a }
            r5 = 1
            r0.setSingleLine(r5)     // Catch:{ all -> 0x026a }
            r10 = 17
            r0.setGravity(r10)     // Catch:{ all -> 0x026a }
            android.text.TextUtils$TruncateAt r10 = android.text.TextUtils.TruncateAt.END     // Catch:{ all -> 0x026a }
            r0.setEllipsize(r10)     // Catch:{ all -> 0x026a }
            r10 = 1094713344(0x41400000, float:12.0)
            r15 = 2
            r0.setTextSize(r15, r10)     // Catch:{ all -> 0x026a }
            java.lang.String r10 = r12.getSeatName()     // Catch:{ all -> 0x026a }
            if (r10 == 0) goto L_0x023c
            boolean r10 = r12.isBlockedForSocialDistancing()     // Catch:{ all -> 0x026a }
            if (r10 != 0) goto L_0x023c
            java.lang.String r10 = r12.getSeatName()     // Catch:{ all -> 0x026a }
            r0.setText(r10)     // Catch:{ all -> 0x026a }
        L_0x023c:
            r13.addView(r0)     // Catch:{ all -> 0x026a }
            r13.setTag(r12)     // Catch:{ all -> 0x026a }
            r13.setId(r11)     // Catch:{ all -> 0x026a }
            r8.addView(r13)     // Catch:{ all -> 0x026a }
            goto L_0x0255
        L_0x0249:
            r0 = move-exception
            r14 = r24
            goto L_0x0271
        L_0x024d:
            r9 = r0
            r14 = r1
            r18 = r10
            r5 = 1
            r15 = 2
            r1 = r25
        L_0x0255:
            int r11 = r11 + 1
            r0 = r9
            r1 = r14
            r10 = r18
            r9 = 0
            goto L_0x00c9
        L_0x025e:
            r14 = r1
            com.travel.bus.busticket.fragment.j$a r0 = r14.f22289e     // Catch:{ all -> 0x026a }
            if (r0 == 0) goto L_0x0268
            com.travel.bus.busticket.fragment.j$a r0 = r14.f22289e     // Catch:{ all -> 0x026a }
            r0.i()     // Catch:{ all -> 0x026a }
        L_0x0268:
            monitor-exit(r24)
            return
        L_0x026a:
            r0 = move-exception
            goto L_0x0271
        L_0x026c:
            r14 = r1
            monitor-exit(r24)
            return
        L_0x026f:
            r0 = move-exception
            r14 = r1
        L_0x0271:
            monitor-exit(r24)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.busticket.fragment.j.b(java.lang.String):void");
    }

    private static ArrayList<TripBusDetailsItem> a(ArrayList<TripBusDetailsItem> arrayList) {
        HashSet hashSet = new HashSet();
        Iterator<TripBusDetailsItem> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            hashSet.add(Long.valueOf(it2.next().getColumn()));
        }
        long longValue = ((Long) new TreeSet(hashSet).first()).longValue();
        if (longValue > 0) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                arrayList.get(i2).setColumn(arrayList.get(i2).getColumn() - longValue);
            }
        }
        Iterator<TripBusDetailsItem> it3 = arrayList.iterator();
        while (it3.hasNext()) {
            TripBusDetailsItem next = it3.next();
            if (next.getLength() == 2) {
                long row = next.getRow();
                long column = next.getColumn();
                Iterator<TripBusDetailsItem> it4 = arrayList.iterator();
                while (it4.hasNext()) {
                    TripBusDetailsItem next2 = it4.next();
                    if (next2.getRow() == row && next2.getColumn() == column + 1) {
                        for (int i3 = 0; i3 < arrayList.size(); i3++) {
                            if (arrayList.get(i3).getRow() == row && arrayList.get(i3).getColumn() > column) {
                                arrayList.get(i3).setColumn(arrayList.get(i3).getColumn() + 1);
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public void onClick(View view) {
        if (view.getTag() != null) {
            TripBusDetailsItem tripBusDetailsItem = (TripBusDetailsItem) view.getTag();
            a aVar = this.f22289e;
            if (aVar != null) {
                aVar.a(tripBusDetailsItem, view);
            }
        }
    }

    public void onDestroyView() {
        try {
            if (this.f22285a != null) {
                this.f22285a.clear();
            }
            RelativeLayout relativeLayout = (RelativeLayout) this.f22286b.findViewById(R.id.lyt_seats_container);
            if (relativeLayout != null) {
                relativeLayout.removeAllViews();
            }
            this.f22286b = null;
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
        super.onDestroyView();
    }
}
