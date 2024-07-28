package com.travel.citybus.brts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.citybus.R;
import com.travel.citybus.best.model.BestEPurse;
import com.travel.citybus.brts.citybus.aa;
import com.travel.citybus.brts.citybus.ab;
import com.travel.citybus.brts.model.CJRBrtsPaxInfo;
import com.travel.citybus.brts.model.pojo.CJRBusStopFareModel;
import com.travel.citybus.brts.model.pojo.CJRCity;
import com.travel.citybus.brts.model.pojo.CJRRouteInfoModel;
import com.travel.citybus.brts.model.pojo.CJRRouteModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.x;
import kotlin.o;

public final class c extends RecyclerView.a<d> {

    /* renamed from: a  reason: collision with root package name */
    int f23191a = -1;

    /* renamed from: b  reason: collision with root package name */
    d f23192b;

    /* renamed from: c  reason: collision with root package name */
    final Context f23193c;

    /* renamed from: d  reason: collision with root package name */
    final aa f23194d;

    /* renamed from: e  reason: collision with root package name */
    final ab f23195e;

    /* renamed from: f  reason: collision with root package name */
    final CJRCity f23196f;

    /* renamed from: g  reason: collision with root package name */
    final BestEPurse f23197g;

    /* renamed from: h  reason: collision with root package name */
    final CJRRouteModel f23198h;

    /* renamed from: i  reason: collision with root package name */
    final ArrayList<CJRBrtsPaxInfo> f23199i;
    private List<CJRRouteInfoModel> j = new ArrayList();

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0207  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x023d  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x024b  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0281  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x028f  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x02c5  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x02d3  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0309  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0317  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x034d  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0366  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.v r18, int r19) {
        /*
            r17 = this;
            r6 = r17
            r0 = r19
            r7 = r18
            com.travel.citybus.brts.d r7 = (com.travel.citybus.brts.d) r7
            java.lang.String r1 = "holder"
            kotlin.g.b.k.c(r7, r1)
            java.util.List<com.travel.citybus.brts.model.pojo.CJRRouteInfoModel> r1 = r6.j
            java.lang.Object r1 = r1.get(r0)
            r8 = r1
            com.travel.citybus.brts.model.pojo.CJRRouteInfoModel r8 = (com.travel.citybus.brts.model.pojo.CJRRouteInfoModel) r8
            kotlin.g.b.x$e r9 = new kotlin.g.b.x$e
            r9.<init>()
            r1 = 0
            r9.element = r1
            com.travel.citybus.brts.model.pojo.CJRCity r1 = r6.f23196f
            boolean r1 = com.travel.citybus.best.a.a((com.travel.citybus.brts.model.pojo.CJRCity) r1)
            if (r1 == 0) goto L_0x003f
            kotlin.o r1 = new kotlin.o
            java.lang.String r2 = r8.getMerchantSourceId()
            if (r2 != 0) goto L_0x0031
            kotlin.g.b.k.a()
        L_0x0031:
            java.lang.String r3 = r8.getMerchantDestinationId()
            if (r3 != 0) goto L_0x003a
            kotlin.g.b.k.a()
        L_0x003a:
            r1.<init>(r2, r3)
            r9.element = r1
        L_0x003f:
            com.paytm.utility.RoboTextView r1 = r7.f23361a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Route "
            r2.<init>(r3)
            java.lang.String r3 = r8.getRouteName()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r2)
            r1 = 0
            com.paytm.utility.t.a(r1)
            com.travel.citybus.brts.model.pojo.CJRRouteModel r2 = r6.f23198h
            java.lang.String r2 = r2.getMerchantLogo()
            android.widget.ImageView r3 = r7.f23362b
            com.paytm.utility.t.b(r2, r3)
            com.paytm.utility.RoboTextView r2 = r7.f23363c
            java.lang.String r3 = r8.getBusType()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r2.setText(r3)
            java.lang.Integer r2 = r8.getNoOfStops()
            if (r2 == 0) goto L_0x00a0
            java.lang.Integer r2 = r8.getNoOfStops()
            if (r2 != 0) goto L_0x0081
            kotlin.g.b.k.a()
        L_0x0081:
            int r2 = r2.intValue()
            if (r2 <= 0) goto L_0x00a0
            com.paytm.utility.RoboTextView r2 = r7.f23365e
            java.lang.Integer r3 = r8.getNoOfStops()
            if (r3 != 0) goto L_0x0092
            kotlin.g.b.k.a()
        L_0x0092:
            int r3 = r3.intValue()
            java.lang.String r3 = com.travel.citybus.brts.utils.f.a(r3)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r2.setText(r3)
            goto L_0x00a6
        L_0x00a0:
            com.paytm.utility.RoboTextView r2 = r7.f23365e
            r3 = 4
            r2.setVisibility(r3)
        L_0x00a6:
            java.util.List r2 = r8.getFareDetailsList()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.Iterator r2 = r2.iterator()
        L_0x00b7:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x00d9
            java.lang.Object r4 = r2.next()
            r10 = r4
            com.travel.citybus.brts.model.pojo.CJRBusStopFareModel r10 = (com.travel.citybus.brts.model.pojo.CJRBusStopFareModel) r10
            int r10 = r10.getPaxId()
            com.travel.citybus.brts.citybus.h r11 = com.travel.citybus.brts.citybus.h.f23284a
            int r11 = com.travel.citybus.brts.citybus.h.n()
            if (r10 != r11) goto L_0x00d2
            r5 = 1
            goto L_0x00d3
        L_0x00d2:
            r5 = 0
        L_0x00d3:
            if (r5 == 0) goto L_0x00b7
            r3.add(r4)
            goto L_0x00b7
        L_0x00d9:
            r10 = r3
            java.util.List r10 = (java.util.List) r10
            r2 = r10
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r3 = r2.isEmpty()
            if (r3 != 0) goto L_0x00fe
            com.paytm.utility.RoboTextView r3 = r7.f23364d
            java.lang.Object r4 = r10.get(r1)
            com.travel.citybus.brts.model.pojo.CJRBusStopFareModel r4 = (com.travel.citybus.brts.model.pojo.CJRBusStopFareModel) r4
            double r11 = r4.getAmount()
            java.lang.Double r4 = java.lang.Double.valueOf(r11)
            java.lang.String r4 = com.travel.citybus.brts.utils.a.a((java.lang.Double) r4)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r3.setText(r4)
        L_0x00fe:
            android.widget.TextView r3 = r7.j
            java.lang.String r4 = "0"
            r11 = r4
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r3.setText(r11)
            android.widget.TextView r3 = r7.o
            r11 = r4
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r3.setText(r11)
            android.widget.TextView r3 = r7.t
            r11 = r4
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r3.setText(r11)
            android.widget.TextView r3 = r7.y
            r11 = r4
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r3.setText(r11)
            android.widget.TextView r3 = r7.D
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r3.setText(r4)
            java.util.List r3 = r8.getFareDetailsList()
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.Iterator r3 = r3.iterator()
        L_0x0138:
            boolean r11 = r3.hasNext()
            if (r11 == 0) goto L_0x015a
            java.lang.Object r11 = r3.next()
            r12 = r11
            com.travel.citybus.brts.model.pojo.CJRBusStopFareModel r12 = (com.travel.citybus.brts.model.pojo.CJRBusStopFareModel) r12
            int r12 = r12.getPaxId()
            com.travel.citybus.brts.citybus.h r13 = com.travel.citybus.brts.citybus.h.f23284a
            int r13 = com.travel.citybus.brts.citybus.h.o()
            if (r12 != r13) goto L_0x0153
            r12 = 1
            goto L_0x0154
        L_0x0153:
            r12 = 0
        L_0x0154:
            if (r12 == 0) goto L_0x0138
            r4.add(r11)
            goto L_0x0138
        L_0x015a:
            r11 = r4
            java.util.List r11 = (java.util.List) r11
            java.util.List r3 = r8.getFareDetailsList()
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.Iterator r3 = r3.iterator()
        L_0x016e:
            boolean r12 = r3.hasNext()
            if (r12 == 0) goto L_0x0190
            java.lang.Object r12 = r3.next()
            r13 = r12
            com.travel.citybus.brts.model.pojo.CJRBusStopFareModel r13 = (com.travel.citybus.brts.model.pojo.CJRBusStopFareModel) r13
            int r13 = r13.getPaxId()
            com.travel.citybus.brts.citybus.h r14 = com.travel.citybus.brts.citybus.h.f23284a
            int r14 = com.travel.citybus.brts.citybus.h.p()
            if (r13 != r14) goto L_0x0189
            r13 = 1
            goto L_0x018a
        L_0x0189:
            r13 = 0
        L_0x018a:
            if (r13 == 0) goto L_0x016e
            r4.add(r12)
            goto L_0x016e
        L_0x0190:
            r12 = r4
            java.util.List r12 = (java.util.List) r12
            java.util.List r3 = r8.getFareDetailsList()
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.Iterator r3 = r3.iterator()
        L_0x01a4:
            boolean r13 = r3.hasNext()
            if (r13 == 0) goto L_0x01c6
            java.lang.Object r13 = r3.next()
            r14 = r13
            com.travel.citybus.brts.model.pojo.CJRBusStopFareModel r14 = (com.travel.citybus.brts.model.pojo.CJRBusStopFareModel) r14
            int r14 = r14.getPaxId()
            com.travel.citybus.brts.citybus.h r15 = com.travel.citybus.brts.citybus.h.f23284a
            int r15 = com.travel.citybus.brts.citybus.h.m()
            if (r14 != r15) goto L_0x01bf
            r14 = 1
            goto L_0x01c0
        L_0x01bf:
            r14 = 0
        L_0x01c0:
            if (r14 == 0) goto L_0x01a4
            r4.add(r13)
            goto L_0x01a4
        L_0x01c6:
            r13 = r4
            java.util.List r13 = (java.util.List) r13
            java.util.List r3 = r8.getFareDetailsList()
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.Iterator r3 = r3.iterator()
        L_0x01da:
            boolean r14 = r3.hasNext()
            if (r14 == 0) goto L_0x01fc
            java.lang.Object r14 = r3.next()
            r15 = r14
            com.travel.citybus.brts.model.pojo.CJRBusStopFareModel r15 = (com.travel.citybus.brts.model.pojo.CJRBusStopFareModel) r15
            int r15 = r15.getPaxId()
            com.travel.citybus.brts.citybus.h r16 = com.travel.citybus.brts.citybus.h.f23284a
            int r5 = com.travel.citybus.brts.citybus.h.q()
            if (r15 != r5) goto L_0x01f5
            r5 = 1
            goto L_0x01f6
        L_0x01f5:
            r5 = 0
        L_0x01f6:
            if (r5 == 0) goto L_0x01da
            r4.add(r14)
            goto L_0x01da
        L_0x01fc:
            r14 = r4
            java.util.List r14 = (java.util.List) r14
            boolean r2 = r2.isEmpty()
            r3 = 8
            if (r2 != 0) goto L_0x023d
            android.widget.LinearLayout r2 = r7.f23366f
            r2.setVisibility(r1)
            android.widget.TextView r2 = r7.f23367g
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            android.content.Context r5 = r6.f23193c
            int r15 = com.travel.citybus.R.string.rupee_symbol
            java.lang.String r5 = r5.getString(r15)
            r4.append(r5)
            java.lang.Object r5 = r10.get(r1)
            com.travel.citybus.brts.model.pojo.CJRBusStopFareModel r5 = (com.travel.citybus.brts.model.pojo.CJRBusStopFareModel) r5
            double r15 = r5.getAmount()
            java.lang.Double r5 = java.lang.Double.valueOf(r15)
            java.lang.String r5 = com.travel.citybus.brts.utils.a.a((java.lang.Double) r5)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r2.setText(r4)
            goto L_0x0242
        L_0x023d:
            android.widget.LinearLayout r2 = r7.f23366f
            r2.setVisibility(r3)
        L_0x0242:
            r2 = r11
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x0281
            android.widget.LinearLayout r2 = r7.k
            r2.setVisibility(r1)
            android.widget.TextView r2 = r7.l
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            android.content.Context r5 = r6.f23193c
            int r15 = com.travel.citybus.R.string.rupee_symbol
            java.lang.String r5 = r5.getString(r15)
            r4.append(r5)
            java.lang.Object r5 = r11.get(r1)
            com.travel.citybus.brts.model.pojo.CJRBusStopFareModel r5 = (com.travel.citybus.brts.model.pojo.CJRBusStopFareModel) r5
            double r15 = r5.getAmount()
            java.lang.Double r5 = java.lang.Double.valueOf(r15)
            java.lang.String r5 = com.travel.citybus.brts.utils.a.a((java.lang.Double) r5)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r2.setText(r4)
            goto L_0x0286
        L_0x0281:
            android.widget.LinearLayout r2 = r7.k
            r2.setVisibility(r3)
        L_0x0286:
            r2 = r12
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x02c5
            android.widget.LinearLayout r2 = r7.p
            r2.setVisibility(r1)
            android.widget.TextView r2 = r7.q
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            android.content.Context r5 = r6.f23193c
            int r15 = com.travel.citybus.R.string.rupee_symbol
            java.lang.String r5 = r5.getString(r15)
            r4.append(r5)
            java.lang.Object r5 = r12.get(r1)
            com.travel.citybus.brts.model.pojo.CJRBusStopFareModel r5 = (com.travel.citybus.brts.model.pojo.CJRBusStopFareModel) r5
            double r15 = r5.getAmount()
            java.lang.Double r5 = java.lang.Double.valueOf(r15)
            java.lang.String r5 = com.travel.citybus.brts.utils.a.a((java.lang.Double) r5)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r2.setText(r4)
            goto L_0x02ca
        L_0x02c5:
            android.widget.LinearLayout r2 = r7.p
            r2.setVisibility(r3)
        L_0x02ca:
            r2 = r13
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x0309
            android.widget.LinearLayout r2 = r7.u
            r2.setVisibility(r1)
            android.widget.TextView r2 = r7.v
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            android.content.Context r5 = r6.f23193c
            int r15 = com.travel.citybus.R.string.rupee_symbol
            java.lang.String r5 = r5.getString(r15)
            r4.append(r5)
            java.lang.Object r5 = r13.get(r1)
            com.travel.citybus.brts.model.pojo.CJRBusStopFareModel r5 = (com.travel.citybus.brts.model.pojo.CJRBusStopFareModel) r5
            double r15 = r5.getAmount()
            java.lang.Double r5 = java.lang.Double.valueOf(r15)
            java.lang.String r5 = com.travel.citybus.brts.utils.a.a((java.lang.Double) r5)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r2.setText(r4)
            goto L_0x030e
        L_0x0309:
            android.widget.LinearLayout r2 = r7.u
            r2.setVisibility(r3)
        L_0x030e:
            r2 = r14
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x034d
            android.widget.LinearLayout r2 = r7.z
            r2.setVisibility(r1)
            android.widget.TextView r2 = r7.A
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            android.content.Context r5 = r6.f23193c
            int r15 = com.travel.citybus.R.string.rupee_symbol
            java.lang.String r5 = r5.getString(r15)
            r4.append(r5)
            java.lang.Object r1 = r14.get(r1)
            com.travel.citybus.brts.model.pojo.CJRBusStopFareModel r1 = (com.travel.citybus.brts.model.pojo.CJRBusStopFareModel) r1
            double r15 = r1.getAmount()
            java.lang.Double r1 = java.lang.Double.valueOf(r15)
            java.lang.String r1 = com.travel.citybus.brts.utils.a.a((java.lang.Double) r1)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r2.setText(r1)
            goto L_0x0352
        L_0x034d:
            android.widget.LinearLayout r1 = r7.z
            r1.setVisibility(r3)
        L_0x0352:
            com.paytm.utility.RoboTextView r1 = r7.f23365e
            com.travel.citybus.brts.c$a r2 = new com.travel.citybus.brts.c$a
            r2.<init>(r6, r8)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r1.setOnClickListener(r2)
            androidx.cardview.widget.CardView r1 = r7.F
            int r1 = r1.getVisibility()
            if (r1 != 0) goto L_0x036e
            r1 = -1
            r6.f23191a = r1
            androidx.cardview.widget.CardView r1 = r7.F
            r1.setVisibility(r3)
        L_0x036e:
            androidx.cardview.widget.CardView r1 = r7.E
            com.travel.citybus.brts.c$e r2 = new com.travel.citybus.brts.c$e
            r2.<init>(r6, r0, r7, r8)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r1.setOnClickListener(r2)
            android.widget.ImageView r15 = r7.f23369i
            com.travel.citybus.brts.c$f r16 = new com.travel.citybus.brts.c$f
            r0 = r16
            r1 = r17
            r2 = r10
            r3 = r7
            r4 = r8
            r5 = r9
            r0.<init>(r1, r2, r3, r4, r5)
            r0 = r16
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r15.setOnClickListener(r0)
            android.widget.ImageView r15 = r7.n
            com.travel.citybus.brts.c$g r16 = new com.travel.citybus.brts.c$g
            r0 = r16
            r2 = r11
            r0.<init>(r1, r2, r3, r4, r5)
            r0 = r16
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r15.setOnClickListener(r0)
            android.widget.ImageView r15 = r7.s
            com.travel.citybus.brts.c$h r16 = new com.travel.citybus.brts.c$h
            r0 = r16
            r2 = r12
            r0.<init>(r1, r2, r3, r4, r5)
            r0 = r16
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r15.setOnClickListener(r0)
            android.widget.ImageView r15 = r7.x
            com.travel.citybus.brts.c$i r16 = new com.travel.citybus.brts.c$i
            r0 = r16
            r2 = r13
            r0.<init>(r1, r2, r3, r4, r5)
            r0 = r16
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r15.setOnClickListener(r0)
            android.widget.ImageView r15 = r7.C
            com.travel.citybus.brts.c$j r16 = new com.travel.citybus.brts.c$j
            r0 = r16
            r2 = r14
            r0.<init>(r1, r2, r3, r4, r5)
            r0 = r16
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r15.setOnClickListener(r0)
            android.widget.ImageView r15 = r7.f23368h
            com.travel.citybus.brts.c$k r16 = new com.travel.citybus.brts.c$k
            r0 = r16
            r2 = r10
            r0.<init>(r1, r2, r3, r4, r5)
            r0 = r16
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r15.setOnClickListener(r0)
            android.widget.ImageView r10 = r7.m
            com.travel.citybus.brts.c$l r15 = new com.travel.citybus.brts.c$l
            r0 = r15
            r2 = r11
            r0.<init>(r1, r2, r3, r4, r5)
            android.view.View$OnClickListener r15 = (android.view.View.OnClickListener) r15
            r10.setOnClickListener(r15)
            android.widget.ImageView r10 = r7.r
            com.travel.citybus.brts.c$b r11 = new com.travel.citybus.brts.c$b
            r0 = r11
            r2 = r12
            r0.<init>(r1, r2, r3, r4, r5)
            android.view.View$OnClickListener r11 = (android.view.View.OnClickListener) r11
            r10.setOnClickListener(r11)
            android.widget.ImageView r10 = r7.w
            com.travel.citybus.brts.c$c r11 = new com.travel.citybus.brts.c$c
            r0 = r11
            r2 = r13
            r0.<init>(r1, r2, r3, r4, r5)
            android.view.View$OnClickListener r11 = (android.view.View.OnClickListener) r11
            r10.setOnClickListener(r11)
            android.widget.ImageView r10 = r7.B
            com.travel.citybus.brts.c$d r11 = new com.travel.citybus.brts.c$d
            r0 = r11
            r2 = r14
            r0.<init>(r1, r2, r3, r4, r5)
            android.view.View$OnClickListener r11 = (android.view.View.OnClickListener) r11
            r10.setOnClickListener(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.citybus.brts.c.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$v, int):void");
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        kotlin.g.b.k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f23193c).inflate(R.layout.citybus_srp_single_model_layout, viewGroup, false);
        kotlin.g.b.k.a((Object) inflate, "view");
        return new d(inflate);
    }

    public c(Context context, aa aaVar, ab abVar, CJRCity cJRCity, BestEPurse bestEPurse, CJRRouteModel cJRRouteModel, ArrayList<CJRBrtsPaxInfo> arrayList) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(aaVar, "onAdapterRouteClick");
        kotlin.g.b.k.c(abVar, "onSignClicked");
        kotlin.g.b.k.c(cJRRouteModel, "cjrRouteModel");
        kotlin.g.b.k.c(arrayList, "passengersList");
        this.f23193c = context;
        this.f23194d = aaVar;
        this.f23195e = abVar;
        this.f23196f = cJRCity;
        this.f23197g = bestEPurse;
        this.f23198h = cJRRouteModel;
        this.f23199i = arrayList;
        this.j.addAll(this.f23198h.getRouteInfoList());
    }

    public final int getItemCount() {
        return this.j.size();
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f23200a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJRRouteInfoModel f23201b;

        a(c cVar, CJRRouteInfoModel cJRRouteInfoModel) {
            this.f23200a = cVar;
            this.f23201b = cJRRouteInfoModel;
        }

        public final void onClick(View view) {
            if (this.f23201b.getNoOfStops() != null) {
                Integer noOfStops = this.f23201b.getNoOfStops();
                if (noOfStops == null) {
                    kotlin.g.b.k.a();
                }
                if (noOfStops.intValue() > 0) {
                    this.f23200a.f23194d.a(this.f23201b, this.f23200a.f23198h.getMerchantLogo());
                }
            }
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f23218a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f23219b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ d f23220c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ CJRRouteInfoModel f23221d;

        e(c cVar, int i2, d dVar, CJRRouteInfoModel cJRRouteInfoModel) {
            this.f23218a = cVar;
            this.f23219b = i2;
            this.f23220c = dVar;
            this.f23221d = cJRRouteInfoModel;
        }

        public final void onClick(View view) {
            if (this.f23218a.f23191a < 0 || this.f23218a.f23191a != this.f23219b) {
                if (this.f23218a.f23191a >= 0) {
                    c.a(this.f23218a);
                }
                c cVar = this.f23218a;
                int i2 = this.f23219b;
                d dVar = this.f23220c;
                CJRRouteInfoModel cJRRouteInfoModel = this.f23221d;
                dVar.j.setText("0");
                dVar.o.setText("0");
                dVar.t.setText("0");
                dVar.y.setText("0");
                dVar.D.setText("0");
                cVar.f23199i.clear();
                cVar.f23195e.e();
                List<CJRBusStopFareModel> fareDetailsList = cJRRouteInfoModel.getFareDetailsList();
                if (fareDetailsList != null && (!fareDetailsList.isEmpty())) {
                    for (CJRBusStopFareModel next : fareDetailsList) {
                        CJRBrtsPaxInfo cJRBrtsPaxInfo = new CJRBrtsPaxInfo();
                        cJRBrtsPaxInfo.setmPaxName(next.getPaxName());
                        cJRBrtsPaxInfo.setmFare(next.getAmount());
                        cVar.f23199i.add(cJRBrtsPaxInfo);
                    }
                }
                dVar.F.setVisibility(0);
                View view2 = dVar.itemView;
                kotlin.g.b.k.a((Object) view2, "holder.itemView");
                cVar.f23192b = new d(view2);
                cVar.f23191a = i2;
                return;
            }
            c.a(this.f23218a);
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f23222a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f23223b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ d f23224c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ CJRRouteInfoModel f23225d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ x.e f23226e;

        f(c cVar, List list, d dVar, CJRRouteInfoModel cJRRouteInfoModel, x.e eVar) {
            this.f23222a = cVar;
            this.f23223b = list;
            this.f23224c = dVar;
            this.f23225d = cJRRouteInfoModel;
            this.f23226e = eVar;
        }

        public final void onClick(View view) {
            int i2;
            Context context;
            Collection collection = this.f23223b;
            if (!(collection == null || collection.isEmpty())) {
                if (com.travel.citybus.best.a.a(this.f23222a.f23196f)) {
                    int parseInt = Integer.parseInt(this.f23224c.j.getText().toString());
                    BestEPurse bestEPurse = this.f23222a.f23197g;
                    Integer num = null;
                    Integer valueOf = bestEPurse != null ? Integer.valueOf(bestEPurse.getMaxPassengerCount()) : null;
                    if (valueOf == null) {
                        kotlin.g.b.k.a();
                    }
                    if (parseInt == valueOf.intValue()) {
                        Context context2 = this.f23222a.f23193c;
                        String string = this.f23222a.f23193c.getString(R.string.passenger_limit_exceed);
                        Context context3 = this.f23222a.f23193c;
                        int i3 = R.string.maximum_passengers;
                        Object[] objArr = new Object[2];
                        BestEPurse bestEPurse2 = this.f23222a.f23197g;
                        Integer valueOf2 = bestEPurse2 != null ? Integer.valueOf(bestEPurse2.getMaxPassengerCount()) : null;
                        if (valueOf2 == null) {
                            kotlin.g.b.k.a();
                        }
                        objArr[0] = String.valueOf(valueOf2.intValue());
                        BestEPurse bestEPurse3 = this.f23222a.f23197g;
                        if (bestEPurse3 != null) {
                            num = Integer.valueOf(bestEPurse3.getMaxPassengerCount());
                        }
                        if (num == null) {
                            kotlin.g.b.k.a();
                        }
                        if (num.intValue() > 1) {
                            context = this.f23222a.f23193c;
                            i2 = R.string.passengers;
                        } else {
                            context = this.f23222a.f23193c;
                            i2 = R.string.passenger;
                        }
                        objArr[1] = context.getString(i2);
                        com.paytm.utility.b.b(context2, string, context3.getString(i3, objArr));
                        return;
                    }
                }
                int parseInt2 = Integer.parseInt(this.f23224c.j.getText().toString()) + 1;
                Iterator<CJRBrtsPaxInfo> it2 = this.f23222a.f23199i.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    CJRBrtsPaxInfo next = it2.next();
                    kotlin.g.b.k.a((Object) next, "pax");
                    if (kotlin.g.b.k.a((Object) next.getPaxName(), (Object) "Adult")) {
                        next.setCount(parseInt2);
                        break;
                    }
                }
                this.f23224c.j.setText(String.valueOf(parseInt2));
                ab abVar = this.f23222a.f23195e;
                com.travel.citybus.brts.citybus.h hVar = com.travel.citybus.brts.citybus.h.f23284a;
                abVar.a(true, ((CJRBusStopFareModel) this.f23223b.get(0)).getAmount(), this.f23225d, this.f23222a.f23199i, (o) this.f23226e.element);
            }
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f23227a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f23228b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ d f23229c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ CJRRouteInfoModel f23230d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ x.e f23231e;

        g(c cVar, List list, d dVar, CJRRouteInfoModel cJRRouteInfoModel, x.e eVar) {
            this.f23227a = cVar;
            this.f23228b = list;
            this.f23229c = dVar;
            this.f23230d = cJRRouteInfoModel;
            this.f23231e = eVar;
        }

        public final void onClick(View view) {
            Collection collection = this.f23228b;
            if (!(collection == null || collection.isEmpty())) {
                int parseInt = Integer.parseInt(this.f23229c.o.getText().toString()) + 1;
                Iterator<CJRBrtsPaxInfo> it2 = this.f23227a.f23199i.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    CJRBrtsPaxInfo next = it2.next();
                    kotlin.g.b.k.a((Object) next, "pax");
                    if (next.getPaxName().equals("Student")) {
                        next.setCount(parseInt);
                        break;
                    }
                }
                this.f23229c.o.setText(String.valueOf(parseInt));
                ab abVar = this.f23227a.f23195e;
                com.travel.citybus.brts.citybus.h hVar = com.travel.citybus.brts.citybus.h.f23284a;
                abVar.a(true, ((CJRBusStopFareModel) this.f23228b.get(0)).getAmount(), this.f23230d, this.f23227a.f23199i, (o) this.f23231e.element);
            }
        }
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f23232a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f23233b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ d f23234c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ CJRRouteInfoModel f23235d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ x.e f23236e;

        h(c cVar, List list, d dVar, CJRRouteInfoModel cJRRouteInfoModel, x.e eVar) {
            this.f23232a = cVar;
            this.f23233b = list;
            this.f23234c = dVar;
            this.f23235d = cJRRouteInfoModel;
            this.f23236e = eVar;
        }

        public final void onClick(View view) {
            Collection collection = this.f23233b;
            if (!(collection == null || collection.isEmpty())) {
                int parseInt = Integer.parseInt(this.f23234c.t.getText().toString()) + 1;
                Iterator<CJRBrtsPaxInfo> it2 = this.f23232a.f23199i.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    CJRBrtsPaxInfo next = it2.next();
                    kotlin.g.b.k.a((Object) next, "pax");
                    if (next.getPaxName().equals("Senior")) {
                        next.setCount(parseInt);
                        break;
                    }
                }
                this.f23234c.t.setText(String.valueOf(parseInt));
                ab abVar = this.f23232a.f23195e;
                com.travel.citybus.brts.citybus.h hVar = com.travel.citybus.brts.citybus.h.f23284a;
                abVar.a(true, ((CJRBusStopFareModel) this.f23233b.get(0)).getAmount(), this.f23235d, this.f23232a.f23199i, (o) this.f23236e.element);
            }
        }
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f23237a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f23238b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ d f23239c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ CJRRouteInfoModel f23240d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ x.e f23241e;

        i(c cVar, List list, d dVar, CJRRouteInfoModel cJRRouteInfoModel, x.e eVar) {
            this.f23237a = cVar;
            this.f23238b = list;
            this.f23239c = dVar;
            this.f23240d = cJRRouteInfoModel;
            this.f23241e = eVar;
        }

        public final void onClick(View view) {
            Collection collection = this.f23238b;
            if (!(collection == null || collection.isEmpty())) {
                int parseInt = Integer.parseInt(this.f23239c.y.getText().toString()) + 1;
                Iterator<CJRBrtsPaxInfo> it2 = this.f23237a.f23199i.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    CJRBrtsPaxInfo next = it2.next();
                    kotlin.g.b.k.a((Object) next, "pax");
                    if (next.getPaxName().equals("Child")) {
                        next.setCount(parseInt);
                        break;
                    }
                }
                this.f23239c.y.setText(String.valueOf(parseInt));
                ab abVar = this.f23237a.f23195e;
                com.travel.citybus.brts.citybus.h hVar = com.travel.citybus.brts.citybus.h.f23284a;
                abVar.a(true, ((CJRBusStopFareModel) this.f23238b.get(0)).getAmount(), this.f23240d, this.f23237a.f23199i, (o) this.f23241e.element);
            }
        }
    }

    static final class j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f23242a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f23243b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ d f23244c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ CJRRouteInfoModel f23245d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ x.e f23246e;

        j(c cVar, List list, d dVar, CJRRouteInfoModel cJRRouteInfoModel, x.e eVar) {
            this.f23242a = cVar;
            this.f23243b = list;
            this.f23244c = dVar;
            this.f23245d = cJRRouteInfoModel;
            this.f23246e = eVar;
        }

        public final void onClick(View view) {
            Collection collection = this.f23243b;
            if (!(collection == null || collection.isEmpty())) {
                int parseInt = Integer.parseInt(this.f23244c.D.getText().toString()) + 1;
                Iterator<CJRBrtsPaxInfo> it2 = this.f23242a.f23199i.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    CJRBrtsPaxInfo next = it2.next();
                    kotlin.g.b.k.a((Object) next, "pax");
                    if (next.getPaxName().equals("PH")) {
                        next.setCount(parseInt);
                        break;
                    }
                }
                this.f23244c.D.setText(String.valueOf(parseInt));
                ab abVar = this.f23242a.f23195e;
                com.travel.citybus.brts.citybus.h hVar = com.travel.citybus.brts.citybus.h.f23284a;
                abVar.a(true, ((CJRBusStopFareModel) this.f23243b.get(0)).getAmount(), this.f23245d, this.f23242a.f23199i, (o) this.f23246e.element);
            }
        }
    }

    static final class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f23247a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f23248b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ d f23249c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ CJRRouteInfoModel f23250d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ x.e f23251e;

        k(c cVar, List list, d dVar, CJRRouteInfoModel cJRRouteInfoModel, x.e eVar) {
            this.f23247a = cVar;
            this.f23248b = list;
            this.f23249c = dVar;
            this.f23250d = cJRRouteInfoModel;
            this.f23251e = eVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0033  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0053 A[EDGE_INSN: B:17:0x0053->B:15:0x0053 ?: BREAK  , SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r9) {
            /*
                r8 = this;
                java.util.List r9 = r8.f23248b
                java.util.Collection r9 = (java.util.Collection) r9
                r0 = 0
                r1 = 1
                if (r9 == 0) goto L_0x0011
                boolean r9 = r9.isEmpty()
                if (r9 == 0) goto L_0x000f
                goto L_0x0011
            L_0x000f:
                r9 = 0
                goto L_0x0012
            L_0x0011:
                r9 = 1
            L_0x0012:
                if (r9 != 0) goto L_0x0085
                com.travel.citybus.brts.d r9 = r8.f23249c
                android.widget.TextView r9 = r9.j
                java.lang.CharSequence r9 = r9.getText()
                java.lang.String r9 = r9.toString()
                int r9 = java.lang.Integer.parseInt(r9)
                int r9 = r9 - r1
                com.travel.citybus.brts.c r1 = r8.f23247a
                java.util.ArrayList<com.travel.citybus.brts.model.CJRBrtsPaxInfo> r1 = r1.f23199i
                java.util.Iterator r1 = r1.iterator()
            L_0x002d:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto L_0x0053
                java.lang.Object r2 = r1.next()
                com.travel.citybus.brts.model.CJRBrtsPaxInfo r2 = (com.travel.citybus.brts.model.CJRBrtsPaxInfo) r2
                java.lang.String r3 = "pax"
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
                java.lang.String r3 = r2.getPaxName()
                java.lang.String r4 = "Adult"
                boolean r3 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r4)
                if (r3 != 0) goto L_0x0050
                java.lang.String r3 = r2.getPaxName()
                if (r3 != 0) goto L_0x002d
            L_0x0050:
                r2.setCount(r9)
            L_0x0053:
                if (r9 < 0) goto L_0x0085
                com.travel.citybus.brts.d r1 = r8.f23249c
                android.widget.TextView r1 = r1.j
                java.lang.String r9 = java.lang.String.valueOf(r9)
                java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                r1.setText(r9)
                com.travel.citybus.brts.c r9 = r8.f23247a
                com.travel.citybus.brts.citybus.ab r1 = r9.f23195e
                com.travel.citybus.brts.citybus.h r9 = com.travel.citybus.brts.citybus.h.f23284a
                r2 = 0
                java.util.List r9 = r8.f23248b
                java.lang.Object r9 = r9.get(r0)
                com.travel.citybus.brts.model.pojo.CJRBusStopFareModel r9 = (com.travel.citybus.brts.model.pojo.CJRBusStopFareModel) r9
                double r3 = r9.getAmount()
                com.travel.citybus.brts.model.pojo.CJRRouteInfoModel r5 = r8.f23250d
                com.travel.citybus.brts.c r9 = r8.f23247a
                java.util.ArrayList<com.travel.citybus.brts.model.CJRBrtsPaxInfo> r6 = r9.f23199i
                kotlin.g.b.x$e r9 = r8.f23251e
                T r9 = r9.element
                r7 = r9
                kotlin.o r7 = (kotlin.o) r7
                r1.a(r2, r3, r5, r6, r7)
            L_0x0085:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.citybus.brts.c.k.onClick(android.view.View):void");
        }
    }

    static final class l implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f23252a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f23253b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ d f23254c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ CJRRouteInfoModel f23255d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ x.e f23256e;

        l(c cVar, List list, d dVar, CJRRouteInfoModel cJRRouteInfoModel, x.e eVar) {
            this.f23252a = cVar;
            this.f23253b = list;
            this.f23254c = dVar;
            this.f23255d = cJRRouteInfoModel;
            this.f23256e = eVar;
        }

        public final void onClick(View view) {
            Collection collection = this.f23253b;
            if (!(collection == null || collection.isEmpty())) {
                int parseInt = Integer.parseInt(this.f23254c.o.getText().toString()) - 1;
                Iterator<CJRBrtsPaxInfo> it2 = this.f23252a.f23199i.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    CJRBrtsPaxInfo next = it2.next();
                    kotlin.g.b.k.a((Object) next, "pax");
                    if (next.getPaxName().equals("Student")) {
                        next.setCount(parseInt);
                        break;
                    }
                }
                if (parseInt >= 0) {
                    this.f23254c.o.setText(String.valueOf(parseInt));
                    ab abVar = this.f23252a.f23195e;
                    com.travel.citybus.brts.citybus.h hVar = com.travel.citybus.brts.citybus.h.f23284a;
                    abVar.a(false, ((CJRBusStopFareModel) this.f23253b.get(0)).getAmount(), this.f23255d, this.f23252a.f23199i, (o) this.f23256e.element);
                }
            }
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f23203a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f23204b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ d f23205c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ CJRRouteInfoModel f23206d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ x.e f23207e;

        b(c cVar, List list, d dVar, CJRRouteInfoModel cJRRouteInfoModel, x.e eVar) {
            this.f23203a = cVar;
            this.f23204b = list;
            this.f23205c = dVar;
            this.f23206d = cJRRouteInfoModel;
            this.f23207e = eVar;
        }

        public final void onClick(View view) {
            Collection collection = this.f23204b;
            if (!(collection == null || collection.isEmpty())) {
                int parseInt = Integer.parseInt(this.f23205c.t.getText().toString()) - 1;
                Iterator<CJRBrtsPaxInfo> it2 = this.f23203a.f23199i.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    CJRBrtsPaxInfo next = it2.next();
                    kotlin.g.b.k.a((Object) next, "pax");
                    if (next.getPaxName().equals("Senior")) {
                        next.setCount(parseInt);
                        break;
                    }
                }
                if (parseInt >= 0) {
                    this.f23205c.t.setText(String.valueOf(parseInt));
                    ab abVar = this.f23203a.f23195e;
                    com.travel.citybus.brts.citybus.h hVar = com.travel.citybus.brts.citybus.h.f23284a;
                    abVar.a(false, ((CJRBusStopFareModel) this.f23204b.get(0)).getAmount(), this.f23206d, this.f23203a.f23199i, (o) this.f23207e.element);
                }
            }
        }
    }

    /* renamed from: com.travel.citybus.brts.c$c  reason: collision with other inner class name */
    static final class C0451c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f23208a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f23209b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ d f23210c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ CJRRouteInfoModel f23211d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ x.e f23212e;

        C0451c(c cVar, List list, d dVar, CJRRouteInfoModel cJRRouteInfoModel, x.e eVar) {
            this.f23208a = cVar;
            this.f23209b = list;
            this.f23210c = dVar;
            this.f23211d = cJRRouteInfoModel;
            this.f23212e = eVar;
        }

        public final void onClick(View view) {
            Collection collection = this.f23209b;
            if (!(collection == null || collection.isEmpty())) {
                int parseInt = Integer.parseInt(this.f23210c.y.getText().toString()) - 1;
                Iterator<CJRBrtsPaxInfo> it2 = this.f23208a.f23199i.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    CJRBrtsPaxInfo next = it2.next();
                    kotlin.g.b.k.a((Object) next, "pax");
                    if (next.getPaxName().equals("Child")) {
                        next.setCount(parseInt);
                        break;
                    }
                }
                if (parseInt >= 0) {
                    this.f23210c.y.setText(String.valueOf(parseInt));
                    ab abVar = this.f23208a.f23195e;
                    com.travel.citybus.brts.citybus.h hVar = com.travel.citybus.brts.citybus.h.f23284a;
                    abVar.a(false, ((CJRBusStopFareModel) this.f23209b.get(0)).getAmount(), this.f23211d, this.f23208a.f23199i, (o) this.f23212e.element);
                }
            }
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f23213a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f23214b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ d f23215c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ CJRRouteInfoModel f23216d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ x.e f23217e;

        d(c cVar, List list, d dVar, CJRRouteInfoModel cJRRouteInfoModel, x.e eVar) {
            this.f23213a = cVar;
            this.f23214b = list;
            this.f23215c = dVar;
            this.f23216d = cJRRouteInfoModel;
            this.f23217e = eVar;
        }

        public final void onClick(View view) {
            Collection collection = this.f23214b;
            if (!(collection == null || collection.isEmpty())) {
                int parseInt = Integer.parseInt(this.f23215c.D.getText().toString()) - 1;
                Iterator<CJRBrtsPaxInfo> it2 = this.f23213a.f23199i.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    CJRBrtsPaxInfo next = it2.next();
                    kotlin.g.b.k.a((Object) next, "pax");
                    if (next.getPaxName().equals("PH")) {
                        next.setCount(parseInt);
                        break;
                    }
                }
                if (parseInt >= 0) {
                    this.f23215c.D.setText(String.valueOf(parseInt));
                    ab abVar = this.f23213a.f23195e;
                    com.travel.citybus.brts.citybus.h hVar = com.travel.citybus.brts.citybus.h.f23284a;
                    abVar.a(false, ((CJRBusStopFareModel) this.f23214b.get(0)).getAmount(), this.f23216d, this.f23213a.f23199i, (o) this.f23217e.element);
                }
            }
        }
    }

    public final void a(List<CJRRouteInfoModel> list) {
        kotlin.g.b.k.c(list, "newList");
        this.f23191a = -1;
        this.j.clear();
        this.j.addAll(list);
        notifyDataSetChanged();
    }

    public static final /* synthetic */ void a(c cVar) {
        d dVar = cVar.f23192b;
        if (dVar == null) {
            kotlin.g.b.k.a("openedCardHolder");
        }
        dVar.F.setVisibility(8);
        cVar.f23191a = -1;
    }
}
