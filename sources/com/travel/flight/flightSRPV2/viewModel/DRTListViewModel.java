package com.travel.flight.flightSRPV2.viewModel;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.flight.R;
import com.travel.flight.flightSRPV2.a.af;
import com.travel.flight.flightSRPV2.a.ah;
import com.travel.flight.flightSRPV2.a.t;
import com.travel.flight.flightSRPV2.a.x;
import com.travel.flight.flightSRPV2.b.a;
import com.travel.flight.flightSRPV2.b.b;
import com.travel.flight.flightSRPV2.b.c;
import com.travel.flight.flightSRPV2.b.e;
import com.travel.flight.pojo.flightticket.CJRDiscountedStrip;
import com.travel.flight.pojo.flightticket.CJRFlightDetails;
import com.travel.flight.pojo.flightticket.CJRFlightDetailsItem;
import com.travel.flight.pojo.flightticket.CJRFlightPrice;
import com.travel.flight.pojo.flightticket.CJRFlightSearchInput;
import com.travel.flight.pojo.flightticket.CJRFlightSearchResult;
import com.travel.flight.pojo.flightticket.CJRFlightStops;
import com.travel.flight.pojo.flightticket.CJROnwardFlights;
import com.travel.flight.pojo.flightticket.CJROnwardReturnFlightInformation;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import kotlin.a.w;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.l;
import kotlin.m.p;
import kotlin.u;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

public final class DRTListViewModel extends ai {
    public static final Companion Companion = new Companion((g) null);
    private final y<List<CJRDiscountedStrip>> discountStripList;
    private final y<String> discountedFlightPrice = new y<>();
    /* access modifiers changed from: private */
    public boolean discountedStripClicked;
    private final y<String> flightPrice = new y<>();
    private String mAcceptType;
    private final y<ArrayList<String>> mSelectedAirline = new y<>();
    private final ArrayList<CJRDiscountedStrip> mSelectedAirlineStrip;
    private double onwardCost;
    private final z<Object> onwardFilterSortChangeObserver;
    private final y<List<CJRFlightDetailsItem>> onwardFlightList;
    private final z<Object> onwardSortChangeObserver;
    private final SRPSharedViewModel parentViewModel;
    private final y<Integer> prevPositionLeft;
    private final y<Integer> prevPositionRight;
    private double returnCost;
    private final z<Object> returnFilterSortChangeObserver;
    private final y<List<CJRFlightDetailsItem>> returnFlightList;
    private final z<Object> returnSortChangeObserver;
    private final y<ah> scrollUpdate;
    private final y<CJRFlightDetailsItem> selectedOnwardFlight = new y<>();
    private final y<CJRFlightDetailsItem> selectedReturnFlight = new y<>();

    public static final void setBackgroundOfItemLayout(ConstraintLayout constraintLayout, CJRDiscountedStrip cJRDiscountedStrip, ArrayList<String> arrayList) {
        Companion.setBackgroundOfItemLayout(constraintLayout, cJRDiscountedStrip, arrayList);
    }

    public static final void setJourneyDate(TextView textView, String str) {
        Companion.setJourneyDate(textView, str);
    }

    /* JADX WARNING: type inference failed for: r1v7, types: [java.util.ArrayList] */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x00bc, code lost:
        r4 = r4.getmOnwardReturnFlights();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DRTListViewModel(com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r4) {
        /*
            r3 = this;
            java.lang.String r0 = "parentViewModel"
            kotlin.g.b.k.c(r4, r0)
            r3.<init>()
            r3.parentViewModel = r4
            androidx.lifecycle.y r4 = new androidx.lifecycle.y
            r4.<init>()
            r3.flightPrice = r4
            androidx.lifecycle.y r4 = new androidx.lifecycle.y
            r4.<init>()
            r3.discountedFlightPrice = r4
            androidx.lifecycle.y r4 = new androidx.lifecycle.y
            r4.<init>()
            r3.mSelectedAirline = r4
            androidx.lifecycle.y r4 = new androidx.lifecycle.y
            r4.<init>()
            r3.selectedOnwardFlight = r4
            androidx.lifecycle.y r4 = new androidx.lifecycle.y
            r4.<init>()
            r3.selectedReturnFlight = r4
            androidx.lifecycle.y r4 = new androidx.lifecycle.y
            r4.<init>()
            r0 = 0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            r4.setValue(r1)
            r3.prevPositionLeft = r4
            androidx.lifecycle.y r4 = new androidx.lifecycle.y
            r4.<init>()
            r4.setValue(r1)
            r3.prevPositionRight = r4
            androidx.lifecycle.y r4 = new androidx.lifecycle.y
            r4.<init>()
            r3.onwardFlightList = r4
            androidx.lifecycle.y r4 = new androidx.lifecycle.y
            r4.<init>()
            r3.returnFlightList = r4
            androidx.lifecycle.y r4 = new androidx.lifecycle.y
            r4.<init>()
            r3.discountStripList = r4
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r3.mSelectedAirlineStrip = r4
            java.lang.String r4 = "regular"
            r3.mAcceptType = r4
            androidx.lifecycle.y r4 = new androidx.lifecycle.y
            r4.<init>()
            r3.scrollUpdate = r4
            com.travel.flight.flightSRPV2.viewModel.DRTListViewModel$onwardFilterSortChangeObserver$1 r4 = new com.travel.flight.flightSRPV2.viewModel.DRTListViewModel$onwardFilterSortChangeObserver$1
            r4.<init>(r3)
            androidx.lifecycle.z r4 = (androidx.lifecycle.z) r4
            r3.onwardFilterSortChangeObserver = r4
            com.travel.flight.flightSRPV2.viewModel.DRTListViewModel$returnFilterSortChangeObserver$1 r4 = new com.travel.flight.flightSRPV2.viewModel.DRTListViewModel$returnFilterSortChangeObserver$1
            r4.<init>(r3)
            androidx.lifecycle.z r4 = (androidx.lifecycle.z) r4
            r3.returnFilterSortChangeObserver = r4
            com.travel.flight.flightSRPV2.viewModel.DRTListViewModel$onwardSortChangeObserver$1 r4 = new com.travel.flight.flightSRPV2.viewModel.DRTListViewModel$onwardSortChangeObserver$1
            r4.<init>(r3)
            androidx.lifecycle.z r4 = (androidx.lifecycle.z) r4
            r3.onwardSortChangeObserver = r4
            com.travel.flight.flightSRPV2.viewModel.DRTListViewModel$returnSortChangeObserver$1 r4 = new com.travel.flight.flightSRPV2.viewModel.DRTListViewModel$returnSortChangeObserver$1
            r4.<init>(r3)
            androidx.lifecycle.z r4 = (androidx.lifecycle.z) r4
            r3.returnSortChangeObserver = r4
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r4 = r3.parentViewModel
            androidx.lifecycle.y r4 = r4.getRoundTripOnwardSortOption()
            com.travel.flight.flightSRPV2.a.p r1 = new com.travel.flight.flightSRPV2.a.p
            r1.<init>(r0)
            r4.setValue(r1)
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r4 = r3.parentViewModel
            androidx.lifecycle.y r4 = r4.getRoundTripReturnSortOption()
            com.travel.flight.flightSRPV2.a.p r1 = new com.travel.flight.flightSRPV2.a.p
            r1.<init>(r0)
            r4.setValue(r1)
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r4 = r3.parentViewModel
            androidx.lifecycle.y r4 = r4.getSrpResult()
            java.lang.Object r4 = r4.getValue()
            com.travel.flight.pojo.flightticket.CJRFlightSearchResult r4 = (com.travel.flight.pojo.flightticket.CJRFlightSearchResult) r4
            r1 = 0
            if (r4 == 0) goto L_0x00c7
            com.travel.flight.pojo.flightticket.CJROnwardReturnFlightInformation r4 = r4.getmOnwardReturnFlights()
            if (r4 == 0) goto L_0x00c7
            java.util.ArrayList r4 = r4.getDiscountedStrip()
            goto L_0x00c8
        L_0x00c7:
            r4 = r1
        L_0x00c8:
            java.util.Collection r4 = (java.util.Collection) r4
            if (r4 == 0) goto L_0x00d2
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x00d3
        L_0x00d2:
            r0 = 1
        L_0x00d3:
            if (r0 != 0) goto L_0x00f8
            androidx.lifecycle.y<java.util.List<com.travel.flight.pojo.flightticket.CJRDiscountedStrip>> r4 = r3.discountStripList
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r0 = r3.parentViewModel
            androidx.lifecycle.y r0 = r0.getSrpResult()
            java.lang.Object r0 = r0.getValue()
            com.travel.flight.pojo.flightticket.CJRFlightSearchResult r0 = (com.travel.flight.pojo.flightticket.CJRFlightSearchResult) r0
            if (r0 == 0) goto L_0x00ef
            com.travel.flight.pojo.flightticket.CJROnwardReturnFlightInformation r0 = r0.getmOnwardReturnFlights()
            if (r0 == 0) goto L_0x00ef
            java.util.ArrayList r1 = r0.getDiscountedStrip()
        L_0x00ef:
            if (r1 != 0) goto L_0x00f4
            kotlin.g.b.k.a()
        L_0x00f4:
            r4.setValue(r1)
            goto L_0x0117
        L_0x00f8:
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r4 = r3.parentViewModel
            androidx.lifecycle.y r0 = r4.getSrpResult()
            java.lang.Object r0 = r0.getValue()
            com.travel.flight.pojo.flightticket.CJRFlightSearchResult r0 = (com.travel.flight.pojo.flightticket.CJRFlightSearchResult) r0
            if (r0 == 0) goto L_0x0110
            com.travel.flight.pojo.flightticket.CJRMetadetails r0 = r0.getmMetaDetails()
            if (r0 == 0) goto L_0x0110
            java.lang.String r1 = r0.getmRequestId()
        L_0x0110:
            java.lang.String r0 = "DRT"
            java.lang.String r2 = "discounted_strip key is null/empty in srp-response"
            r4.sendHawkeyeErrorEvent(r0, r2, r1)
        L_0x0117:
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r4 = r3.parentViewModel
            androidx.lifecycle.y r4 = r4.getShowSortFilterIcon()
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r4.postValue(r0)
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r4 = r3.parentViewModel
            androidx.lifecycle.y r4 = r4.isSortFragmentAttached()
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r4.postValue(r0)
            r3.wireDataChangeListeners()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightSRPV2.viewModel.DRTListViewModel.<init>(com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel):void");
    }

    public final SRPSharedViewModel getParentViewModel() {
        return this.parentViewModel;
    }

    public final y<String> getFlightPrice() {
        return this.flightPrice;
    }

    public final y<String> getDiscountedFlightPrice() {
        return this.discountedFlightPrice;
    }

    public final y<ArrayList<String>> getMSelectedAirline() {
        return this.mSelectedAirline;
    }

    public final y<CJRFlightDetailsItem> getSelectedOnwardFlight() {
        return this.selectedOnwardFlight;
    }

    public final y<CJRFlightDetailsItem> getSelectedReturnFlight() {
        return this.selectedReturnFlight;
    }

    public final y<List<CJRFlightDetailsItem>> getOnwardFlightList() {
        return this.onwardFlightList;
    }

    public final y<List<CJRFlightDetailsItem>> getReturnFlightList() {
        return this.returnFlightList;
    }

    public final y<List<CJRDiscountedStrip>> getDiscountStripList() {
        return this.discountStripList;
    }

    public final y<ah> getScrollUpdate() {
        return this.scrollUpdate;
    }

    public final void onCleared() {
        this.parentViewModel.getOnwardFilterList().removeObserver(this.onwardFilterSortChangeObserver);
        this.parentViewModel.getReturnFilterList().removeObserver(this.returnFilterSortChangeObserver);
        this.parentViewModel.getRoundTripOnwardSortOption().removeObserver(this.onwardSortChangeObserver);
        this.parentViewModel.getRoundTripReturnSortOption().removeObserver(this.returnSortChangeObserver);
        super.onCleared();
    }

    private final void wireDataChangeListeners() {
        this.parentViewModel.getOnwardFilterList().observeForever(this.onwardFilterSortChangeObserver);
        this.parentViewModel.getReturnFilterList().observeForever(this.returnFilterSortChangeObserver);
        this.parentViewModel.getRoundTripOnwardSortOption().observeForever(this.onwardSortChangeObserver);
        this.parentViewModel.getRoundTripReturnSortOption().observeForever(this.returnSortChangeObserver);
    }

    /* access modifiers changed from: private */
    public final void updateFlightList(boolean z) {
        this.parentViewModel.getShowSortFilterIcon().setValue(Boolean.FALSE);
        clearOnwardAndReturnSelection();
        this.mSelectedAirline.setValue(null);
        Calendar instance = Calendar.getInstance();
        k.a((Object) instance, "Calendar.getInstance()");
        long timeInMillis = instance.getTimeInMillis();
        Job a2 = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (f) null, (CoroutineStart) null, new t.f(500, (d) null), 3, (Object) null);
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (f) null, (CoroutineStart) null, new DRTListViewModel$updateFlightList$1(this, z, a2, timeInMillis, (d) null), 3, (Object) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v21, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v25, resolved type: java.util.List} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0135 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void checkForAirlineFilter(java.util.List<? extends com.travel.flight.flightSRPV2.a.x> r8, java.util.List<? extends com.travel.flight.flightSRPV2.a.x> r9, boolean r10) {
        /*
            r7 = this;
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.Collection r10 = (java.util.Collection) r10
            java.util.Iterator r8 = r8.iterator()
        L_0x000d:
            boolean r0 = r8.hasNext()
            r1 = 7
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x002a
            java.lang.Object r0 = r8.next()
            r4 = r0
            com.travel.flight.flightSRPV2.a.x r4 = (com.travel.flight.flightSRPV2.a.x) r4
            int r4 = r4.e()
            if (r4 != r1) goto L_0x0024
            r2 = 1
        L_0x0024:
            if (r2 == 0) goto L_0x000d
            r10.add(r0)
            goto L_0x000d
        L_0x002a:
            java.util.List r10 = (java.util.List) r10
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r8 = new java.util.ArrayList
            int r0 = kotlin.a.k.a(r10)
            r8.<init>(r0)
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r10 = r10.iterator()
        L_0x003d:
            boolean r0 = r10.hasNext()
            if (r0 == 0) goto L_0x0051
            java.lang.Object r0 = r10.next()
            com.travel.flight.flightSRPV2.a.x r0 = (com.travel.flight.flightSRPV2.a.x) r0
            kotlin.g.a.b r0 = r0.h()
            r8.add(r0)
            goto L_0x003d
        L_0x0051:
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.Collection r10 = (java.util.Collection) r10
            java.util.Iterator r9 = r9.iterator()
        L_0x0060:
            boolean r0 = r9.hasNext()
            if (r0 == 0) goto L_0x007c
            java.lang.Object r0 = r9.next()
            r4 = r0
            com.travel.flight.flightSRPV2.a.x r4 = (com.travel.flight.flightSRPV2.a.x) r4
            int r4 = r4.e()
            if (r4 != r1) goto L_0x0075
            r4 = 1
            goto L_0x0076
        L_0x0075:
            r4 = 0
        L_0x0076:
            if (r4 == 0) goto L_0x0060
            r10.add(r0)
            goto L_0x0060
        L_0x007c:
            java.util.List r10 = (java.util.List) r10
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r9 = new java.util.ArrayList
            int r0 = kotlin.a.k.a(r10)
            r9.<init>(r0)
            java.util.Collection r9 = (java.util.Collection) r9
            java.util.Iterator r10 = r10.iterator()
        L_0x008f:
            boolean r0 = r10.hasNext()
            if (r0 == 0) goto L_0x00a3
            java.lang.Object r0 = r10.next()
            com.travel.flight.flightSRPV2.a.x r0 = (com.travel.flight.flightSRPV2.a.x) r0
            kotlin.g.a.b r0 = r0.h()
            r9.add(r0)
            goto L_0x008f
        L_0x00a3:
            java.util.List r9 = (java.util.List) r9
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r10 = r7.parentViewModel
            androidx.lifecycle.y r10 = r10.getSrpResult()
            java.lang.Object r10 = r10.getValue()
            com.travel.flight.pojo.flightticket.CJRFlightSearchResult r10 = (com.travel.flight.pojo.flightticket.CJRFlightSearchResult) r10
            if (r10 == 0) goto L_0x00be
            com.travel.flight.pojo.flightticket.CJROnwardReturnFlightInformation r10 = r10.getmOnwardReturnFlights()
            if (r10 == 0) goto L_0x00be
            java.util.ArrayList r10 = r10.getDiscountedStrip()
            goto L_0x00bf
        L_0x00be:
            r10 = 0
        L_0x00bf:
            if (r10 != 0) goto L_0x00c4
            kotlin.g.b.k.a()
        L_0x00c4:
            java.util.List r10 = (java.util.List) r10
            r0 = r8
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r3
            if (r0 == 0) goto L_0x011e
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r10 = r10.iterator()
        L_0x00dd:
            boolean r1 = r10.hasNext()
            if (r1 == 0) goto L_0x011b
            java.lang.Object r1 = r10.next()
            r4 = r1
            com.travel.flight.pojo.flightticket.CJRDiscountedStrip r4 = (com.travel.flight.pojo.flightticket.CJRDiscountedStrip) r4
            r5 = r8
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            r6 = r5
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r6 = r6.isEmpty()
            if (r6 != 0) goto L_0x0114
            java.util.Iterator r5 = r5.iterator()
        L_0x00fa:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0114
            java.lang.Object r6 = r5.next()
            kotlin.g.a.b r6 = (kotlin.g.a.b) r6
            java.lang.Object r6 = r6.invoke(r4)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x00fa
            r4 = 1
            goto L_0x0115
        L_0x0114:
            r4 = 0
        L_0x0115:
            if (r4 == 0) goto L_0x00dd
            r0.add(r1)
            goto L_0x00dd
        L_0x011b:
            r10 = r0
            java.util.List r10 = (java.util.List) r10
        L_0x011e:
            r8 = r9
            java.util.Collection r8 = (java.util.Collection) r8
            boolean r8 = r8.isEmpty()
            r8 = r8 ^ r3
            if (r8 == 0) goto L_0x0176
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r10 = r10.iterator()
        L_0x0135:
            boolean r0 = r10.hasNext()
            if (r0 == 0) goto L_0x0173
            java.lang.Object r0 = r10.next()
            r1 = r0
            com.travel.flight.pojo.flightticket.CJRDiscountedStrip r1 = (com.travel.flight.pojo.flightticket.CJRDiscountedStrip) r1
            r4 = r9
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            r5 = r4
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x016c
            java.util.Iterator r4 = r4.iterator()
        L_0x0152:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x016c
            java.lang.Object r5 = r4.next()
            kotlin.g.a.b r5 = (kotlin.g.a.b) r5
            java.lang.Object r5 = r5.invoke(r1)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x0152
            r1 = 1
            goto L_0x016d
        L_0x016c:
            r1 = 0
        L_0x016d:
            if (r1 == 0) goto L_0x0135
            r8.add(r0)
            goto L_0x0135
        L_0x0173:
            r10 = r8
            java.util.List r10 = (java.util.List) r10
        L_0x0176:
            androidx.lifecycle.y<java.util.List<com.travel.flight.pojo.flightticket.CJRDiscountedStrip>> r8 = r7.discountStripList
            r8.postValue(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightSRPV2.viewModel.DRTListViewModel.checkForAirlineFilter(java.util.List, java.util.List, boolean):void");
    }

    private final void updateFlightList(List<? extends CJRFlightDetailsItem> list, List<? extends CJRFlightDetailsItem> list2) {
        boolean z;
        List value = this.parentViewModel.getOnwardFilterList().getValue();
        if (value == null) {
            value = w.INSTANCE;
        }
        List<CJRFlightDetailsItem> a2 = t.a(list, (List<? extends x>) value, this.parentViewModel.getRoundTripOnwardSortOption().getValue());
        Iterable iterable = a2;
        boolean z2 = false;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            Iterator it2 = iterable.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                CharSequence charSequence = ((CJRFlightDetailsItem) it2.next()).getmFlightId();
                if (!(charSequence == null || p.a(charSequence))) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        boolean z3 = !z;
        this.onwardFlightList.setValue(a2);
        if (z3) {
            this.parentViewModel.navigate(new c("PAGE_NO_FLIGHTS_FOUND", (e) null, R.id.container_child, true, "PAGE_NO_FLIGHTS_FOUND"));
        }
        List value2 = this.parentViewModel.getReturnFilterList().getValue();
        if (value2 == null) {
            value2 = w.INSTANCE;
        }
        List<CJRFlightDetailsItem> a3 = t.a(list2, (List<? extends x>) value2, this.parentViewModel.getRoundTripReturnSortOption().getValue());
        Iterable iterable2 = a3;
        if (!(iterable2 instanceof Collection) || !((Collection) iterable2).isEmpty()) {
            Iterator it3 = iterable2.iterator();
            while (true) {
                if (it3.hasNext()) {
                    CharSequence charSequence2 = ((CJRFlightDetailsItem) it3.next()).getmFlightId();
                    if (!(charSequence2 == null || p.a(charSequence2))) {
                        z2 = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        boolean z4 = !z2;
        this.returnFlightList.setValue(a3);
        if (z4) {
            this.parentViewModel.navigate(new c("PAGE_NO_FLIGHTS_FOUND", (e) null, R.id.container_child, true, "PAGE_NO_FLIGHTS_FOUND"));
        }
    }

    /* access modifiers changed from: private */
    public final void updateFlightSorting(boolean z) {
        clearOnwardAndReturnSelection();
        Job a2 = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (f) null, (CoroutineStart) null, new t.f(500, (d) null), 3, (Object) null);
        Calendar instance = Calendar.getInstance();
        k.a((Object) instance, "Calendar.getInstance()");
        long timeInMillis = instance.getTimeInMillis();
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (f) null, (CoroutineStart) null, new DRTListViewModel$updateFlightSorting$1(this, z, a2, timeInMillis, (d) null), 3, (Object) null);
    }

    private final void clearOnwardAndReturnSelection() {
        this.selectedOnwardFlight.setValue(null);
        this.selectedReturnFlight.setValue(null);
        this.parentViewModel.getShowSortFilterIcon().setValue(Boolean.FALSE);
        List<CJRFlightDetailsItem> value = this.onwardFlightList.getValue();
        List<CJRFlightDetailsItem> value2 = this.returnFlightList.getValue();
        if (!(value == null || !(!value.isEmpty()) || value2 == null || !(!value2.isEmpty()) || this.prevPositionLeft.getValue() == null || this.prevPositionRight.getValue() == null)) {
            ArrayList arrayList = new ArrayList();
            for (CJRFlightDetailsItem cJRFlightDetailsItem : value) {
                cJRFlightDetailsItem.setSelected(false);
                arrayList.add(cJRFlightDetailsItem);
            }
            ArrayList arrayList2 = new ArrayList();
            for (CJRFlightDetailsItem cJRFlightDetailsItem2 : value2) {
                cJRFlightDetailsItem2.setSelected(false);
                arrayList2.add(cJRFlightDetailsItem2);
            }
            this.onwardFlightList.setValue(arrayList);
            this.returnFlightList.setValue(arrayList2);
        }
        this.prevPositionRight.setValue(0);
        this.prevPositionLeft.setValue(0);
    }

    public final void onNonStopFlightsFilterToggled() {
        af afVar;
        Object obj;
        Object obj2;
        boolean z;
        boolean z2;
        List<x> value = this.parentViewModel.getOnwardFilterList().getValue();
        if (value == null) {
            k.a();
        }
        ArrayList arrayList = new ArrayList(value);
        Iterator it2 = arrayList.iterator();
        while (true) {
            afVar = null;
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            if (((x) obj).e() == 2) {
                z2 = true;
                continue;
            } else {
                z2 = false;
                continue;
            }
            if (z2) {
                break;
            }
        }
        if (!(obj instanceof af)) {
            obj = null;
        }
        af afVar2 = (af) obj;
        if (afVar2 == null) {
            arrayList.add(new af(true, 1));
            this.parentViewModel.sendPulseEventNonStopSelected(true);
        } else if (afVar2.f24086a != 1) {
            arrayList.remove(afVar2);
            arrayList.add(new af(true, 1));
        } else {
            arrayList.remove(afVar2);
            this.parentViewModel.sendPulseEventNonStopSelected(false);
        }
        List<x> value2 = this.parentViewModel.getReturnFilterList().getValue();
        if (value2 == null) {
            k.a();
        }
        ArrayList arrayList2 = new ArrayList(value2);
        Iterator it3 = arrayList2.iterator();
        while (true) {
            if (!it3.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it3.next();
            if (((x) obj2).e() == 2) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        if (obj2 instanceof af) {
            afVar = obj2;
        }
        af afVar3 = afVar;
        if (afVar3 == null) {
            arrayList2.add(new af(false, 1));
        } else if (afVar3.f24086a != 1) {
            arrayList2.remove(afVar3);
            arrayList2.add(new af(false, 1));
        } else {
            arrayList2.remove(afVar3);
        }
        this.parentViewModel.applyFilters(arrayList, arrayList2);
    }

    public final void onArrowClick(Context context, CJRFlightSearchInput cJRFlightSearchInput, boolean z, boolean z2) {
        String str;
        boolean z3;
        String str2;
        k.c(context, "context");
        if ((cJRFlightSearchInput != null ? cJRFlightSearchInput.getDate() : null) != null && cJRFlightSearchInput.getReturnDate() != null) {
            if (z) {
                try {
                    str = cJRFlightSearchInput.getDate();
                    k.a((Object) str, "searchInput.date");
                } catch (Exception unused) {
                    return;
                }
            } else {
                str = cJRFlightSearchInput.getReturnDate();
                k.a((Object) str, "searchInput.returnDate");
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Calendar instance = Calendar.getInstance();
            k.a((Object) instance, "calendar");
            instance.setTime(simpleDateFormat.parse(str));
            if (z) {
                z3 = z2 ? com.travel.flight.flightSRPV2.c.d.a(cJRFlightSearchInput.getDate()) : com.travel.flight.flightSRPV2.c.d.a(cJRFlightSearchInput.getDate(), cJRFlightSearchInput.getReturnDate());
            } else {
                z3 = z2 ? com.travel.flight.flightSRPV2.c.d.a(cJRFlightSearchInput.getDate(), cJRFlightSearchInput.getReturnDate()) : true;
            }
            if (z2) {
                instance.add(5, -1);
                str2 = simpleDateFormat.format(instance.getTime());
            } else {
                instance.add(5, 1);
                str2 = simpleDateFormat.format(instance.getTime());
            }
            if (z3 && str2 != null) {
                if (z) {
                    cJRFlightSearchInput.setDate(str2);
                } else {
                    cJRFlightSearchInput.setReturnDate(str2);
                }
                this.parentViewModel.getCopiedSearchInput().setValue(cJRFlightSearchInput);
                SRPSharedViewModel sRPSharedViewModel = this.parentViewModel;
                CJRFlightSearchInput value = this.parentViewModel.getCopiedSearchInput().getValue();
                if (value == null) {
                    k.a();
                }
                k.a((Object) value, "parentViewModel.copiedSearchInput.value!!");
                sRPSharedViewModel.refresh(context, value);
            }
        }
    }

    public final void serDRTPrice(CJRFlightDetailsItem cJRFlightDetailsItem, boolean z) {
        if (cJRFlightDetailsItem != null) {
            if (z) {
                this.onwardCost = Double.parseDouble(cJRFlightDetailsItem.getmPrice().get(0).getmDisplayPrice());
            } else {
                this.returnCost = Double.parseDouble(cJRFlightDetailsItem.getmPrice().get(0).getmDisplayPrice());
            }
            this.flightPrice.setValue(com.travel.flight.utils.c.a(this.onwardCost + this.returnCost));
        }
        if (getSpecialFare() != null) {
            Double specialFare = getSpecialFare();
            if (specialFare == null) {
                k.a();
            }
            if (specialFare.doubleValue() < this.onwardCost + this.returnCost) {
                y<String> yVar = this.discountedFlightPrice;
                Double specialFare2 = getSpecialFare();
                if (specialFare2 == null) {
                    k.a();
                }
                yVar.setValue(com.travel.flight.utils.c.a(specialFare2.doubleValue()));
                this.mAcceptType = "combination";
                return;
            }
            this.discountedFlightPrice.setValue(null);
            return;
        }
        this.discountedFlightPrice.setValue(null);
    }

    private final List<CJRFlightDetailsItem> sortFlightListByAirLine(List<String> list, List<? extends CJRFlightDetailsItem> list2) {
        ArrayList arrayList = new ArrayList();
        if (list2 == null || !(!list2.isEmpty()) || list == null || !(!list.isEmpty())) {
            return list2;
        }
        for (CJRFlightDetailsItem cJRFlightDetailsItem : list2) {
            if (list.contains(cJRFlightDetailsItem.getmAirLineCode())) {
                arrayList.add(cJRFlightDetailsItem);
            }
        }
        return arrayList;
    }

    public final void onDiscountStripItemClick(CJRDiscountedStrip cJRDiscountedStrip) {
        ArrayList value;
        CJRFlightDetailsItem cJRFlightDetailsItem;
        ArrayList value2;
        int i2;
        CJRFlightDetailsItem cJRFlightDetailsItem2;
        CJROnwardReturnFlightInformation cJROnwardReturnFlightInformation;
        CJROnwardFlights cJROnwardFlights;
        CJROnwardReturnFlightInformation cJROnwardReturnFlightInformation2;
        CJROnwardFlights cJROnwardFlights2;
        List list;
        boolean z;
        k.c(cJRDiscountedStrip, "discountedStripItem");
        this.discountedStripClicked = true;
        ArrayList arrayList = new ArrayList();
        if (this.mSelectedAirline.getValue() != null) {
            ArrayList<String> value3 = this.mSelectedAirline.getValue();
            if (value3 == null) {
                k.a();
            }
            arrayList = value3;
        }
        clearOnwardAndReturnSelection();
        if (cJRDiscountedStrip.getAirlineCode() == null || arrayList.contains(cJRDiscountedStrip.getAirlineCode())) {
            this.mSelectedAirlineStrip.remove(cJRDiscountedStrip);
            arrayList.remove(cJRDiscountedStrip.getAirlineCode());
            this.mSelectedAirline.setValue(arrayList);
        } else {
            this.mSelectedAirlineStrip.add(cJRDiscountedStrip);
            arrayList.add(cJRDiscountedStrip.getAirlineCode());
            this.mSelectedAirline.setValue(arrayList);
        }
        CJRFlightSearchInput value4 = this.parentViewModel.getSearchInput().getValue();
        if (value4 != null) {
            value4.setmSelectedAirLine(this.mSelectedAirline.getValue());
        }
        String[] strArr = new String[2];
        ArrayList value5 = this.mSelectedAirline.getValue();
        if (value5 != null && value5.size() == 1) {
            ArrayList value6 = this.mSelectedAirline.getValue();
            List<String> split = new l(AppConstants.COLON).split(com.travel.flight.flightSRPV2.c.d.a(value6 != null ? (String) value6.get(0) : null, this.mSelectedAirlineStrip), 0);
            if (!split.isEmpty()) {
                ListIterator<String> listIterator = split.listIterator(split.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        break;
                    }
                    if (listIterator.previous().length() == 0) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (!z) {
                        list = kotlin.a.k.b(split, listIterator.nextIndex() + 1);
                        break;
                    }
                }
            }
            list = w.INSTANCE;
            Object[] array = list.toArray(new String[0]);
            if (array != null) {
                strArr = (String[]) array;
            } else {
                throw new u("null cannot be cast to non-null type kotlin.Array<T>");
            }
        }
        String[] strArr2 = strArr;
        if (this.mSelectedAirline.getValue() != null) {
            List value7 = this.mSelectedAirline.getValue();
            CJRFlightSearchResult value8 = this.parentViewModel.getSrpResult().getValue();
            ArrayList<CJRFlightDetailsItem> arrayList2 = (value8 == null || (cJROnwardReturnFlightInformation2 = value8.getmOnwardReturnFlights()) == null || (cJROnwardFlights2 = cJROnwardReturnFlightInformation2.getmOnwardFlights()) == null) ? null : cJROnwardFlights2.getmFlightDetails();
            if (arrayList2 == null) {
                k.a();
            }
            List<CJRFlightDetailsItem> sortFlightListByAirLine = sortFlightListByAirLine(value7, arrayList2);
            List value9 = this.mSelectedAirline.getValue();
            CJRFlightSearchResult value10 = this.parentViewModel.getSrpResult().getValue();
            ArrayList<CJRFlightDetailsItem> arrayList3 = (value10 == null || (cJROnwardReturnFlightInformation = value10.getmOnwardReturnFlights()) == null || (cJROnwardFlights = cJROnwardReturnFlightInformation.getmReturnFlights()) == null) ? null : cJROnwardFlights.getmFlightDetails();
            if (arrayList3 == null) {
                k.a();
            }
            List<CJRFlightDetailsItem> sortFlightListByAirLine2 = sortFlightListByAirLine(value9, arrayList3);
            if (sortFlightListByAirLine == null) {
                k.a();
            }
            if (sortFlightListByAirLine2 == null) {
                k.a();
            }
            updateFlightList(sortFlightListByAirLine, sortFlightListByAirLine2);
        }
        int i3 = -1;
        if (this.mSelectedAirline.getValue() == null || (value2 = this.mSelectedAirline.getValue()) == null || value2.size() != 1 || strArr2.length != 2 || strArr2[0] == null) {
            this.parentViewModel.getShowSortFilterIcon().setValue(Boolean.FALSE);
        } else {
            List<CJRFlightDetailsItem> value11 = this.onwardFlightList.getValue();
            if (value11 == null) {
                k.a();
            }
            Iterator it2 = value11.iterator();
            int i4 = -1;
            while (true) {
                if (!it2.hasNext()) {
                    i2 = i4;
                    cJRFlightDetailsItem2 = null;
                    break;
                }
                CJRFlightDetailsItem cJRFlightDetailsItem3 = (CJRFlightDetailsItem) it2.next();
                i4++;
                if (cJRFlightDetailsItem3.getmFlightId() != null && k.a((Object) cJRFlightDetailsItem3.getmFlightId(), (Object) strArr2[0])) {
                    i2 = i4;
                    cJRFlightDetailsItem2 = cJRFlightDetailsItem3;
                    break;
                }
            }
            if (cJRFlightDetailsItem2 != null) {
                this.parentViewModel.getShowSortFilterIcon().setValue(Boolean.TRUE);
                onParentItemClick(cJRFlightDetailsItem2, i2, true, true, false);
            } else {
                this.parentViewModel.getShowSortFilterIcon().setValue(Boolean.FALSE);
            }
        }
        if (this.mSelectedAirline.getValue() == null || (value = this.mSelectedAirline.getValue()) == null || value.size() != 1 || strArr2.length != 2 || strArr2[1] == null) {
            this.parentViewModel.getShowSortFilterIcon().setValue(Boolean.FALSE);
            return;
        }
        List<CJRFlightDetailsItem> value12 = this.returnFlightList.getValue();
        if (value12 == null) {
            k.a();
        }
        Iterator it3 = value12.iterator();
        while (true) {
            if (!it3.hasNext()) {
                cJRFlightDetailsItem = null;
                break;
            }
            cJRFlightDetailsItem = (CJRFlightDetailsItem) it3.next();
            i3++;
            if (cJRFlightDetailsItem.getmFlightId() != null && k.a((Object) cJRFlightDetailsItem.getmFlightId(), (Object) strArr2[1])) {
                break;
            }
        }
        int i5 = i3;
        if (cJRFlightDetailsItem != null) {
            this.parentViewModel.getShowSortFilterIcon().setValue(Boolean.TRUE);
            onParentItemClick(cJRFlightDetailsItem, i5, false, true, false);
            return;
        }
        this.parentViewModel.getShowSortFilterIcon().setValue(Boolean.FALSE);
    }

    public final void onParentItemClick(CJRFlightDetailsItem cJRFlightDetailsItem, int i2, boolean z, boolean z2, boolean z3) {
        k.c(cJRFlightDetailsItem, "flightItem");
        if (z) {
            if (cJRFlightDetailsItem.getmPrice() != null) {
                CJRFlightPrice cJRFlightPrice = cJRFlightDetailsItem.getmPrice().get(0);
                if (cJRFlightDetailsItem.getmServiceProviderSelected() == null) {
                    cJRFlightDetailsItem.setmServiceProviderSelected(cJRFlightPrice);
                }
            }
            this.selectedOnwardFlight.setValue(cJRFlightDetailsItem);
            this.parentViewModel.getShowSortFilterIcon().setValue(Boolean.valueOf(this.selectedReturnFlight.getValue() != null));
            List<CJRFlightDetailsItem> value = this.onwardFlightList.getValue();
            if (value == null) {
                k.a();
            }
            k.a((Object) value, "onwardFlightList.value!!");
            List list = value;
            Integer value2 = this.prevPositionLeft.getValue();
            if (value2 == null) {
                k.a();
            }
            k.a((Object) value2, "prevPositionLeft.value!!");
            ((CJRFlightDetailsItem) list.get(value2.intValue())).setSelected(false);
            this.onwardFlightList.setValue(list);
            ((CJRFlightDetailsItem) list.get(i2)).setSelected(true);
            this.onwardFlightList.setValue(list);
            if (!z3) {
                this.scrollUpdate.setValue(new ah(i2, z));
            }
            this.prevPositionLeft.setValue(Integer.valueOf(i2));
            if (z2) {
                checkForOverlapFourHourDiff(cJRFlightDetailsItem, this.selectedReturnFlight.getValue());
                return;
            }
            return;
        }
        if (cJRFlightDetailsItem.getmPrice() != null) {
            CJRFlightPrice cJRFlightPrice2 = cJRFlightDetailsItem.getmPrice().get(0);
            if (cJRFlightDetailsItem.getmServiceProviderSelected() == null) {
                cJRFlightDetailsItem.setmServiceProviderSelected(cJRFlightPrice2);
            }
        }
        this.selectedReturnFlight.setValue(cJRFlightDetailsItem);
        this.parentViewModel.getShowSortFilterIcon().setValue(Boolean.valueOf(this.selectedOnwardFlight.getValue() != null));
        List<CJRFlightDetailsItem> value3 = this.returnFlightList.getValue();
        if (value3 == null) {
            k.a();
        }
        k.a((Object) value3, "returnFlightList.value!!");
        List list2 = value3;
        Integer value4 = this.prevPositionRight.getValue();
        if (value4 == null) {
            k.a();
        }
        k.a((Object) value4, "prevPositionRight.value!!");
        ((CJRFlightDetailsItem) list2.get(value4.intValue())).setSelected(false);
        this.returnFlightList.setValue(list2);
        ((CJRFlightDetailsItem) list2.get(i2)).setSelected(true);
        this.returnFlightList.setValue(list2);
        if (!z3) {
            this.scrollUpdate.setValue(new ah(i2, z));
        }
        this.prevPositionRight.setValue(Integer.valueOf(i2));
        if (z2) {
            checkForOverlapFourHourDiff(this.selectedOnwardFlight.getValue(), cJRFlightDetailsItem);
        }
    }

    private final Double getSpecialFare() {
        com.google.gsonhtcfix.b.g gVar;
        CJROnwardReturnFlightInformation cJROnwardReturnFlightInformation;
        CJROnwardReturnFlightInformation cJROnwardReturnFlightInformation2;
        if (this.parentViewModel.getSrpResult().getValue() != null) {
            CJRFlightSearchResult value = this.parentViewModel.getSrpResult().getValue();
            if ((value != null ? value.getmOnwardReturnFlights() : null) != null) {
                CJRFlightSearchResult value2 = this.parentViewModel.getSrpResult().getValue();
                if (((value2 == null || (cJROnwardReturnFlightInformation2 = value2.getmOnwardReturnFlights()) == null) ? null : cJROnwardReturnFlightInformation2.getDiscountObject()) != null) {
                    try {
                        CJRFlightSearchResult value3 = this.parentViewModel.getSrpResult().getValue();
                        Object discountObject = (value3 == null || (cJROnwardReturnFlightInformation = value3.getmOnwardReturnFlights()) == null) ? null : cJROnwardReturnFlightInformation.getDiscountObject();
                        if (discountObject != null) {
                            com.google.gsonhtcfix.b.g gVar2 = (com.google.gsonhtcfix.b.g) discountObject;
                            if (this.selectedOnwardFlight.getValue() == null || this.selectedReturnFlight.getValue() == null) {
                                return null;
                            }
                            CJRFlightDetailsItem value4 = this.selectedOnwardFlight.getValue();
                            if (value4 == null) {
                                k.a();
                            }
                            String str = value4.getmFlightId();
                            CJRFlightDetailsItem value5 = this.selectedReturnFlight.getValue();
                            if (value5 == null) {
                                k.a();
                            }
                            String str2 = str + ':' + value5.getmFlightId();
                            Map map = gVar2;
                            if (map != null) {
                                if (map.containsKey(str2)) {
                                    ArrayList arrayList = (ArrayList) gVar2.get(str2);
                                    if (arrayList == null || arrayList.size() <= 0) {
                                        gVar = (com.google.gsonhtcfix.b.g) gVar2.get(str2);
                                    } else {
                                        Object obj = arrayList.get(0);
                                        if (obj != null) {
                                            gVar = (com.google.gsonhtcfix.b.g) obj;
                                        } else {
                                            throw new u("null cannot be cast to non-null type com.google.gsonhtcfix.internal.LinkedTreeMap<*, *>");
                                        }
                                    }
                                    if (gVar != null) {
                                        StringBuilder sb = new StringBuilder();
                                        Object obj2 = gVar.get("display_price");
                                        if (obj2 == null) {
                                            k.a();
                                        }
                                        sb.append(obj2.toString());
                                        return Double.valueOf(Double.parseDouble(sb.toString()));
                                    }
                                }
                                return null;
                            }
                            throw new u("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
                        }
                        throw new u("null cannot be cast to non-null type com.google.gsonhtcfix.internal.LinkedTreeMap<*, *>");
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            }
        }
        return null;
    }

    private final void sendServiceProviderList(CJROnwardFlights cJROnwardFlights) {
        if ((cJROnwardFlights != null ? cJROnwardFlights.getmMeta() : null) != null) {
            initializeServiceProviderTop(cJROnwardFlights.getmMeta().getmServiceProviderName());
        }
    }

    private final void initializeServiceProviderTop(ArrayList<String> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                CJRFlightPrice cJRFlightPrice = new CJRFlightPrice();
                cJRFlightPrice.setmServiceProvider(arrayList.get(i2));
                arrayList2.add(cJRFlightPrice);
            }
        }
        if (this.parentViewModel.getSearchInput().getValue() != null) {
            CJRFlightSearchInput value = this.parentViewModel.getSearchInput().getValue();
            if (value == null) {
                k.a();
            }
            value.setmServiceProviserSelectedOnTop(((CJRFlightPrice) arrayList2.get(0)).getmServiceProvider());
        }
    }

    public final void proceedToBook() {
        ArrayList<CJRFlightStops> arrayList;
        CJRFlightStops cJRFlightStops;
        ArrayList<CJRFlightStops> arrayList2;
        CJRFlightStops cJRFlightStops2;
        ArrayList<CJRFlightStops> arrayList3;
        ArrayList<CJRFlightStops> arrayList4;
        CJRFlightPrice cJRFlightPrice;
        CJRFlightPrice cJRFlightPrice2;
        CJRFlightDetails cJRFlightDetails = new CJRFlightDetails();
        CJRFlightSearchResult value = this.parentViewModel.getSrpResult().getValue();
        if (value == null) {
            k.a();
        }
        cJRFlightDetails.setmMetaDetails(value.getmMetaDetails());
        cJRFlightDetails.setPaytmStiched(false);
        cJRFlightDetails.setmOnwardJourney(this.selectedOnwardFlight.getValue());
        CJRFlightDetailsItem value2 = this.selectedOnwardFlight.getValue();
        String str = null;
        Boolean valueOf = value2 != null ? Boolean.valueOf(value2.getMealsAvaialable()) : null;
        if (valueOf == null) {
            k.a();
        }
        cJRFlightDetails.setOnwardMealsAvailable(valueOf.booleanValue());
        cJRFlightDetails.setmReturnJourney(this.selectedReturnFlight.getValue());
        CJRFlightDetailsItem value3 = this.selectedReturnFlight.getValue();
        Boolean valueOf2 = value3 != null ? Boolean.valueOf(value3.getMealsAvaialable()) : null;
        if (valueOf2 == null) {
            k.a();
        }
        cJRFlightDetails.setReturnMealsAvailable(valueOf2.booleanValue());
        if (this.selectedOnwardFlight.getValue() != null) {
            CJRFlightDetailsItem value4 = this.selectedOnwardFlight.getValue();
            if ((value4 != null ? value4.getmPrice() : null) != null) {
                CJRFlightDetailsItem value5 = this.selectedOnwardFlight.getValue();
                if ((value5 != null ? value5.getmServiceProviderSelected() : null) != null) {
                    CJRFlightDetailsItem value6 = this.selectedOnwardFlight.getValue();
                    cJRFlightPrice2 = value6 != null ? value6.getmServiceProviderSelected() : null;
                } else {
                    CJRFlightDetailsItem value7 = this.selectedOnwardFlight.getValue();
                    ArrayList<CJRFlightPrice> arrayList5 = value7 != null ? value7.getmPrice() : null;
                    if (arrayList5 == null) {
                        k.a();
                    }
                    cJRFlightPrice2 = arrayList5.get(0);
                }
                cJRFlightDetails.setmOnwardServiceProvider(cJRFlightPrice2 != null ? cJRFlightPrice2.getmServiceProvider() : null);
            }
        }
        if (this.selectedReturnFlight.getValue() != null) {
            CJRFlightDetailsItem value8 = this.selectedReturnFlight.getValue();
            if ((value8 != null ? value8.getmPrice() : null) != null) {
                CJRFlightDetailsItem value9 = this.selectedReturnFlight.getValue();
                if ((value9 != null ? value9.getmServiceProviderSelected() : null) != null) {
                    CJRFlightDetailsItem value10 = this.selectedReturnFlight.getValue();
                    cJRFlightPrice = value10 != null ? value10.getmServiceProviderSelected() : null;
                } else {
                    CJRFlightDetailsItem value11 = this.selectedReturnFlight.getValue();
                    ArrayList<CJRFlightPrice> arrayList6 = value11 != null ? value11.getmPrice() : null;
                    if (arrayList6 == null) {
                        k.a();
                    }
                    cJRFlightPrice = arrayList6.get(0);
                }
                cJRFlightDetails.setmReturnServiceProvider(cJRFlightPrice != null ? cJRFlightPrice.getmServiceProvider() : null);
            }
        }
        CJRFlightSearchResult value12 = this.parentViewModel.getSrpResult().getValue();
        if (value12 == null) {
            k.a();
        }
        sendServiceProviderList(value12.getmOnwardReturnFlights().getmOnwardFlights());
        CJRFlightSearchResult value13 = this.parentViewModel.getSrpResult().getValue();
        if (value13 == null) {
            k.a();
        }
        sendServiceProviderList(value13.getmOnwardReturnFlights().getmReturnFlights());
        Boolean bool = cJRFlightDetails.getmIsInternational();
        if (bool == null) {
            k.a();
        }
        if (bool.booleanValue()) {
            this.mAcceptType = cJRFlightDetails.isPaytmStiched() ? "regular" : "combination";
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("acceptType", this.mAcceptType);
        bundle.putSerializable("intent_extra_review_data", cJRFlightDetails);
        CJRFlightSearchInput value14 = this.parentViewModel.getSearchInput().getValue();
        if (value14 == null) {
            k.a();
        }
        bundle.putSerializable("intent_extra_search_input_data", value14);
        bundle.putSerializable("intent_extra_trip_type", "round_trip");
        CJRFlightDetailsItem value15 = this.selectedOnwardFlight.getValue();
        Integer valueOf3 = (value15 == null || (arrayList4 = value15.getmFlights()) == null) ? null : Integer.valueOf(arrayList4.size());
        if (valueOf3 == null) {
            k.a();
        }
        if (valueOf3.intValue() > 0) {
            CJRFlightDetailsItem value16 = this.selectedReturnFlight.getValue();
            Integer valueOf4 = (value16 == null || (arrayList3 = value16.getmFlights()) == null) ? null : Integer.valueOf(arrayList3.size());
            if (valueOf4 == null) {
                k.a();
            }
            if (valueOf4.intValue() > 0) {
                StringBuilder sb = new StringBuilder("Onward{");
                CJRFlightDetailsItem value17 = this.selectedOnwardFlight.getValue();
                sb.append(value17 != null ? value17.getmAirLineCode() : null);
                sb.append(' ');
                CJRFlightDetailsItem value18 = this.selectedOnwardFlight.getValue();
                sb.append((value18 == null || (arrayList2 = value18.getmFlights()) == null || (cJRFlightStops2 = arrayList2.get(0)) == null) ? null : cJRFlightStops2.getmFlightNumber());
                sb.append("}, Return{");
                CJRFlightDetailsItem value19 = this.selectedReturnFlight.getValue();
                sb.append(value19 != null ? value19.getmAirLineCode() : null);
                sb.append(' ');
                CJRFlightDetailsItem value20 = this.selectedReturnFlight.getValue();
                if (!(value20 == null || (arrayList = value20.getmFlights()) == null || (cJRFlightStops = arrayList.get(0)) == null)) {
                    str = cJRFlightStops.getmFlightNumber();
                }
                sb.append(str);
                sb.append('}');
                this.parentViewModel.sendPulseEventFlightSelected(sb.toString());
            }
        }
        this.parentViewModel.navigate(new a("PAGE_REVIEW_ITINERARY", bundle));
    }

    private final void checkForOverlapFourHourDiff(CJRFlightDetailsItem cJRFlightDetailsItem, CJRFlightDetailsItem cJRFlightDetailsItem2) {
        if (cJRFlightDetailsItem != null && cJRFlightDetailsItem2 != null) {
            boolean checkFlightOverlaps = checkFlightOverlaps(cJRFlightDetailsItem, cJRFlightDetailsItem2, false);
            boolean checkFlightOverFourHourDifference = checkFlightOverFourHourDifference(cJRFlightDetailsItem, cJRFlightDetailsItem2);
            if (checkFlightOverlaps) {
                this.parentViewModel.getDialogEvent().setValue(new b(Integer.valueOf(R.string.flight_overlap_info_title), Integer.valueOf(R.string.flight_overlap_info)));
                clearOnwardAndReturnSelection();
            } else if (checkFlightOverFourHourDifference) {
                this.parentViewModel.getDialogEvent().setValue(new b(Integer.valueOf(R.string.flight_overlap_info_title), Integer.valueOf(R.string.flight_four_hour_diff)));
                clearOnwardAndReturnSelection();
            }
        }
    }

    private final boolean checkFlightOverlaps(CJRFlightDetailsItem cJRFlightDetailsItem, CJRFlightDetailsItem cJRFlightDetailsItem2, boolean z) {
        if (cJRFlightDetailsItem == null || cJRFlightDetailsItem2 == null) {
            return false;
        }
        try {
            long z2 = com.paytm.utility.b.z(cJRFlightDetailsItem.getmDepartureTime());
            long z3 = com.paytm.utility.b.z(cJRFlightDetailsItem.getmArrivalTime());
            long z4 = com.paytm.utility.b.z(cJRFlightDetailsItem2.getmDepartureTime());
            long z5 = com.paytm.utility.b.z(cJRFlightDetailsItem2.getmArrivalTime());
            if (z) {
                return z2 >= z4;
            }
            int i2 = (z2 > z4 ? 1 : (z2 == z4 ? 0 : -1));
            return i2 >= 0 || (z4 <= z2 && z5 >= z2) || (i2 <= 0 && z3 >= z4);
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return false;
        }
    }

    private final boolean checkFlightOverFourHourDifference(CJRFlightDetailsItem cJRFlightDetailsItem, CJRFlightDetailsItem cJRFlightDetailsItem2) {
        if (cJRFlightDetailsItem == null || cJRFlightDetailsItem2 == null) {
            return false;
        }
        try {
            long z = com.paytm.utility.b.z(cJRFlightDetailsItem.getmArrivalTime());
            long z2 = com.paytm.utility.b.z(cJRFlightDetailsItem2.getmDepartureTime());
            return ((z > z2 ? 1 : (z == z2 ? 0 : -1)) > 0 ? z - z2 : z2 - z) < 14400000;
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return false;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final void setBackgroundOfItemLayout(ConstraintLayout constraintLayout, CJRDiscountedStrip cJRDiscountedStrip, ArrayList<String> arrayList) {
            k.c(constraintLayout, "constraintLayout");
            if (arrayList != null) {
                if (kotlin.a.k.a(arrayList, cJRDiscountedStrip != null ? cJRDiscountedStrip.getAirlineCode() : null)) {
                    constraintLayout.setBackground(androidx.core.content.b.a(constraintLayout.getContext(), R.drawable.pre_f_flight_rounded_rect_with_4dp_radius_00b9f5_stroke));
                    return;
                }
            }
            constraintLayout.setBackground(androidx.core.content.b.a(constraintLayout.getContext(), R.drawable.pre_f_flight_rounded_rect_with_4dp_radius_grey_stroke));
        }

        public final void setJourneyDate(TextView textView, String str) {
            k.c(textView, "textView");
            if (str != null) {
                textView.getContext();
                String d2 = com.paytm.utility.b.d(str, "yyyy-MM-dd", "EEE, dd MMM");
                if (d2 != null) {
                    textView.setText(d2);
                }
            }
        }
    }
}
