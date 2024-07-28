package com.travel.flight.flightSRPV2.viewModel;

import androidx.databinding.i;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.travel.flight.flightSRPV2.a.aa;
import com.travel.flight.flightSRPV2.a.ab;
import com.travel.flight.flightSRPV2.a.af;
import com.travel.flight.flightSRPV2.a.d;
import com.travel.flight.flightSRPV2.a.r;
import com.travel.flight.flightSRPV2.a.s;
import com.travel.flight.flightSRPV2.a.u;
import com.travel.flight.flightSRPV2.a.v;
import io.reactivex.rxjava3.b.b;
import io.reactivex.rxjava3.i.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.a.ae;
import kotlin.a.w;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.j.e;
import kotlin.x;

public final class FlightFilterViewModel extends ai {
    private y<String> airlineFilterText;
    private y<List<d>> allAirlineList;
    /* access modifiers changed from: private */
    public boolean arePreviousFiltersEmpty;
    private final b disposables;
    private final io.reactivex.rxjava3.j.b<x> filterChangedPublisher;
    /* access modifiers changed from: private */
    public final FlightFilterHomeViewModel filterHomeViewModel;
    private y<List<d>> filteredAirlineList;
    private final y<Boolean> hideNonRefundableFlights;
    private final boolean isOnward;
    private final SRPSharedViewModel parentViewModel;
    /* access modifiers changed from: private */
    public List<? extends com.travel.flight.flightSRPV2.a.x> previouslySelectedFilters;
    private final y<Long> selectedArrivalMax;
    private final y<Long> selectedArrivalMin;
    private final y<String> selectedArrivalTimeZone;
    private final y<Long> selectedDepartureMax;
    private final y<Long> selectedDepartureMin;
    private final y<String> selectedDepartureTimeZone;
    private final y<Integer> selectedDuration;
    private final y<Integer> selectedFlightStopType;
    private final y<Integer> selectedPriceMax;
    private final y<Integer> selectedPriceMin;

    public FlightFilterViewModel(SRPSharedViewModel sRPSharedViewModel, FlightFilterHomeViewModel flightFilterHomeViewModel, boolean z) {
        k.c(sRPSharedViewModel, "parentViewModel");
        k.c(flightFilterHomeViewModel, "filterHomeViewModel");
        this.parentViewModel = sRPSharedViewModel;
        this.filterHomeViewModel = flightFilterHomeViewModel;
        this.isOnward = z;
        this.hideNonRefundableFlights = new y<>();
        this.selectedFlightStopType = new y<>();
        this.selectedDuration = new y<>();
        this.selectedPriceMin = new y<>();
        this.selectedPriceMax = new y<>();
        this.selectedDepartureMin = new y<>();
        this.selectedDepartureMax = new y<>();
        this.selectedDepartureTimeZone = new y<>();
        this.selectedArrivalMin = new y<>();
        this.selectedArrivalMax = new y<>();
        this.selectedArrivalTimeZone = new y<>();
        this.allAirlineList = new y<>();
        this.filteredAirlineList = new y<>();
        this.airlineFilterText = new y<>();
        this.disposables = new b();
        if (this.isOnward) {
            this.filterHomeViewModel.setOnwardViewModel(this);
        } else {
            this.filterHomeViewModel.setReturnViewModel(this);
        }
        List<com.travel.flight.flightSRPV2.a.x> value = (this.isOnward ? this.parentViewModel.getOnwardFilterList() : this.parentViewModel.getReturnFilterList()).getValue();
        if (value == null) {
            k.a();
        }
        this.previouslySelectedFilters = new ArrayList(value);
        this.arePreviousFiltersEmpty = this.previouslySelectedFilters.isEmpty();
        io.reactivex.rxjava3.j.b<x> a2 = io.reactivex.rxjava3.j.b.a();
        k.a((Object) a2, "PublishSubject.create<Unit>()");
        this.filterChangedPublisher = a2;
        this.disposables.a(this.filterChangedPublisher.debounce(300, TimeUnit.MILLISECONDS).subscribeOn(a.b()).observeOn(io.reactivex.rxjava3.android.b.a.a()).subscribe(new FlightFilterViewModel$disposable$1(this)));
        populateFilterValues$default(this, false, 1, (Object) null);
        this.airlineFilterText.observeForever(new z<String>(this) {
            final /* synthetic */ FlightFilterViewModel this$0;

            {
                this.this$0 = r1;
            }

            public final void onChanged(String str) {
                this.this$0.onAirlineFilterTextChange();
            }
        });
        this.hideNonRefundableFlights.observeForever(new z<Boolean>(this) {
            final /* synthetic */ FlightFilterViewModel this$0;

            {
                this.this$0 = r1;
            }

            public final void onChanged(Boolean bool) {
                this.this$0.onHideNonRefundableFlightsChange();
            }
        });
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FlightFilterViewModel(SRPSharedViewModel sRPSharedViewModel, FlightFilterHomeViewModel flightFilterHomeViewModel, boolean z, int i2, g gVar) {
        this(sRPSharedViewModel, flightFilterHomeViewModel, (i2 & 4) != 0 ? true : z);
    }

    public final SRPSharedViewModel getParentViewModel() {
        return this.parentViewModel;
    }

    public final boolean isOnward() {
        return this.isOnward;
    }

    public final y<Boolean> getHideNonRefundableFlights() {
        return this.hideNonRefundableFlights;
    }

    public final y<Integer> getSelectedFlightStopType() {
        return this.selectedFlightStopType;
    }

    public final y<Integer> getSelectedDuration() {
        return this.selectedDuration;
    }

    public final y<Integer> getSelectedPriceMin() {
        return this.selectedPriceMin;
    }

    public final y<Integer> getSelectedPriceMax() {
        return this.selectedPriceMax;
    }

    public final y<Long> getSelectedDepartureMin() {
        return this.selectedDepartureMin;
    }

    public final y<Long> getSelectedDepartureMax() {
        return this.selectedDepartureMax;
    }

    public final y<String> getSelectedDepartureTimeZone() {
        return this.selectedDepartureTimeZone;
    }

    public final y<Long> getSelectedArrivalMin() {
        return this.selectedArrivalMin;
    }

    public final y<Long> getSelectedArrivalMax() {
        return this.selectedArrivalMax;
    }

    public final y<String> getSelectedArrivalTimeZone() {
        return this.selectedArrivalTimeZone;
    }

    public final y<List<d>> getFilteredAirlineList() {
        return this.filteredAirlineList;
    }

    public final void setFilteredAirlineList(y<List<d>> yVar) {
        k.c(yVar, "<set-?>");
        this.filteredAirlineList = yVar;
    }

    public final y<String> getAirlineFilterText() {
        return this.airlineFilterText;
    }

    public final void setAirlineFilterText(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this.airlineFilterText = yVar;
    }

    public final void checkIfFiltersAreAltered() {
        this.filterChangedPublisher.onNext(x.f47997a);
    }

    public final void populateFilterValues(List<? extends com.travel.flight.flightSRPV2.a.x> list) {
        k.c(list, "updatedFilters");
        this.previouslySelectedFilters = list;
        this.arePreviousFiltersEmpty = this.previouslySelectedFilters.isEmpty();
        populateFilterValues$default(this, false, 1, (Object) null);
    }

    public static /* synthetic */ void populateFilterValues$default(FlightFilterViewModel flightFilterViewModel, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        flightFilterViewModel.populateFilterValues(z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ec, code lost:
        if (r2.intValue() != r3) goto L_0x00ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x015c, code lost:
        if (r2.longValue() != r3) goto L_0x015e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01cd, code lost:
        if (r2.longValue() != r3) goto L_0x01cf;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.travel.flight.flightSRPV2.a.x> getFilters() {
        /*
            r9 = this;
            boolean r0 = r9.isOnward
            if (r0 == 0) goto L_0x000b
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r0 = r9.parentViewModel
            androidx.lifecycle.y r0 = r0.getDefaultOnwardFilterInfo()
            goto L_0x0011
        L_0x000b:
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r0 = r9.parentViewModel
            androidx.lifecycle.y r0 = r0.getDefaultReturnFilterInfo()
        L_0x0011:
            java.lang.Object r0 = r0.getValue()
            if (r0 != 0) goto L_0x001a
            kotlin.g.b.k.a()
        L_0x001a:
            java.lang.String r1 = "(if (isOnward) this.pare…ReturnFilterInfo).value!!"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            com.travel.flight.flightSRPV2.a.u r0 = (com.travel.flight.flightSRPV2.a.u) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.List r1 = (java.util.List) r1
            androidx.lifecycle.y<java.lang.Boolean> r2 = r9.hideNonRefundableFlights
            java.lang.Object r2 = r2.getValue()
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x0042
            com.travel.flight.flightSRPV2.a.ab r2 = new com.travel.flight.flightSRPV2.a.ab
            boolean r3 = r9.isOnward
            r2.<init>(r3)
            r1.add(r2)
        L_0x0042:
            androidx.lifecycle.y<java.lang.Integer> r2 = r9.selectedFlightStopType
            java.lang.Object r2 = r2.getValue()
            if (r2 == 0) goto L_0x007d
            androidx.lifecycle.y<java.lang.Integer> r2 = r9.selectedFlightStopType
            java.lang.Object r2 = r2.getValue()
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r3 = r0.f24127b
            if (r2 != 0) goto L_0x0057
            goto L_0x005d
        L_0x0057:
            int r2 = r2.intValue()
            if (r2 == r3) goto L_0x007d
        L_0x005d:
            com.travel.flight.flightSRPV2.a.af r2 = new com.travel.flight.flightSRPV2.a.af
            boolean r3 = r9.isOnward
            androidx.lifecycle.y<java.lang.Integer> r4 = r9.selectedFlightStopType
            java.lang.Object r4 = r4.getValue()
            if (r4 != 0) goto L_0x006c
            kotlin.g.b.k.a()
        L_0x006c:
            java.lang.String r5 = "this.selectedFlightStopType.value!!"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            r2.<init>(r3, r4)
            r1.add(r2)
        L_0x007d:
            androidx.lifecycle.y<java.lang.Integer> r2 = r9.selectedDuration
            java.lang.Object r2 = r2.getValue()
            java.lang.Integer r2 = (java.lang.Integer) r2
            com.travel.flight.flightSRPV2.a.g<java.lang.Integer> r3 = r0.f24128c
            T r3 = r3.f24101b
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            if (r2 != 0) goto L_0x0092
            goto L_0x0098
        L_0x0092:
            int r2 = r2.intValue()
            if (r2 == r3) goto L_0x00b8
        L_0x0098:
            com.travel.flight.flightSRPV2.a.w r2 = new com.travel.flight.flightSRPV2.a.w
            boolean r3 = r9.isOnward
            androidx.lifecycle.y<java.lang.Integer> r4 = r9.selectedDuration
            java.lang.Object r4 = r4.getValue()
            if (r4 != 0) goto L_0x00a7
            kotlin.g.b.k.a()
        L_0x00a7:
            java.lang.String r5 = "this.selectedDuration.value!!"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            r2.<init>(r3, r4)
            r1.add(r2)
        L_0x00b8:
            androidx.lifecycle.y<java.lang.Integer> r2 = r9.selectedPriceMin
            java.lang.Object r2 = r2.getValue()
            java.lang.Integer r2 = (java.lang.Integer) r2
            com.travel.flight.flightSRPV2.a.g<java.lang.Integer> r3 = r0.f24129d
            T r3 = r3.f24100a
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            if (r2 != 0) goto L_0x00cd
            goto L_0x00ee
        L_0x00cd:
            int r2 = r2.intValue()
            if (r2 != r3) goto L_0x00ee
            androidx.lifecycle.y<java.lang.Integer> r2 = r9.selectedPriceMax
            java.lang.Object r2 = r2.getValue()
            java.lang.Integer r2 = (java.lang.Integer) r2
            com.travel.flight.flightSRPV2.a.g<java.lang.Integer> r3 = r0.f24129d
            T r3 = r3.f24101b
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            if (r2 != 0) goto L_0x00e8
            goto L_0x00ee
        L_0x00e8:
            int r2 = r2.intValue()
            if (r2 == r3) goto L_0x0124
        L_0x00ee:
            com.travel.flight.flightSRPV2.a.aa r2 = new com.travel.flight.flightSRPV2.a.aa
            boolean r3 = r9.isOnward
            androidx.lifecycle.y<java.lang.Integer> r4 = r9.selectedPriceMin
            java.lang.Object r4 = r4.getValue()
            if (r4 != 0) goto L_0x00fd
            kotlin.g.b.k.a()
        L_0x00fd:
            java.lang.String r5 = "this.selectedPriceMin.value!!"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            androidx.lifecycle.y<java.lang.Integer> r5 = r9.selectedPriceMax
            java.lang.Object r5 = r5.getValue()
            if (r5 != 0) goto L_0x0113
            kotlin.g.b.k.a()
        L_0x0113:
            java.lang.String r6 = "this.selectedPriceMax.value!!"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            java.lang.Number r5 = (java.lang.Number) r5
            int r5 = r5.intValue()
            r2.<init>(r3, r4, r5)
            r1.add(r2)
        L_0x0124:
            androidx.lifecycle.y<java.lang.Long> r2 = r9.selectedDepartureMin
            java.lang.Object r2 = r2.getValue()
            java.lang.Long r2 = (java.lang.Long) r2
            com.travel.flight.flightSRPV2.a.g<java.lang.Long> r3 = r0.f24130e
            T r3 = r3.f24100a
            java.lang.Number r3 = (java.lang.Number) r3
            long r3 = r3.longValue()
            if (r2 != 0) goto L_0x0139
            goto L_0x015e
        L_0x0139:
            long r5 = r2.longValue()
            int r2 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r2 != 0) goto L_0x015e
            androidx.lifecycle.y<java.lang.Long> r2 = r9.selectedDepartureMax
            java.lang.Object r2 = r2.getValue()
            java.lang.Long r2 = (java.lang.Long) r2
            com.travel.flight.flightSRPV2.a.g<java.lang.Long> r3 = r0.f24130e
            T r3 = r3.f24101b
            java.lang.Number r3 = (java.lang.Number) r3
            long r3 = r3.longValue()
            if (r2 != 0) goto L_0x0156
            goto L_0x015e
        L_0x0156:
            long r5 = r2.longValue()
            int r2 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x0195
        L_0x015e:
            com.travel.flight.flightSRPV2.a.v r2 = new com.travel.flight.flightSRPV2.a.v
            boolean r4 = r9.isOnward
            androidx.lifecycle.y<java.lang.Long> r3 = r9.selectedDepartureMin
            java.lang.Object r3 = r3.getValue()
            if (r3 != 0) goto L_0x016d
            kotlin.g.b.k.a()
        L_0x016d:
            java.lang.String r5 = "this.selectedDepartureMin.value!!"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
            java.lang.Number r3 = (java.lang.Number) r3
            long r5 = r3.longValue()
            androidx.lifecycle.y<java.lang.Long> r3 = r9.selectedDepartureMax
            java.lang.Object r3 = r3.getValue()
            if (r3 != 0) goto L_0x0183
            kotlin.g.b.k.a()
        L_0x0183:
            java.lang.String r7 = "this.selectedDepartureMax.value!!"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r7)
            java.lang.Number r3 = (java.lang.Number) r3
            long r7 = r3.longValue()
            r3 = r2
            r3.<init>(r4, r5, r7)
            r1.add(r2)
        L_0x0195:
            androidx.lifecycle.y<java.lang.Long> r2 = r9.selectedArrivalMin
            java.lang.Object r2 = r2.getValue()
            java.lang.Long r2 = (java.lang.Long) r2
            com.travel.flight.flightSRPV2.a.g<java.lang.Long> r3 = r0.f24131f
            T r3 = r3.f24100a
            java.lang.Number r3 = (java.lang.Number) r3
            long r3 = r3.longValue()
            if (r2 != 0) goto L_0x01aa
            goto L_0x01cf
        L_0x01aa:
            long r5 = r2.longValue()
            int r2 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r2 != 0) goto L_0x01cf
            androidx.lifecycle.y<java.lang.Long> r2 = r9.selectedArrivalMax
            java.lang.Object r2 = r2.getValue()
            java.lang.Long r2 = (java.lang.Long) r2
            com.travel.flight.flightSRPV2.a.g<java.lang.Long> r0 = r0.f24131f
            T r0 = r0.f24101b
            java.lang.Number r0 = (java.lang.Number) r0
            long r3 = r0.longValue()
            if (r2 != 0) goto L_0x01c7
            goto L_0x01cf
        L_0x01c7:
            long r5 = r2.longValue()
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 == 0) goto L_0x0206
        L_0x01cf:
            com.travel.flight.flightSRPV2.a.s r0 = new com.travel.flight.flightSRPV2.a.s
            boolean r3 = r9.isOnward
            androidx.lifecycle.y<java.lang.Long> r2 = r9.selectedArrivalMin
            java.lang.Object r2 = r2.getValue()
            if (r2 != 0) goto L_0x01de
            kotlin.g.b.k.a()
        L_0x01de:
            java.lang.String r4 = "this.selectedArrivalMin.value!!"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            java.lang.Number r2 = (java.lang.Number) r2
            long r4 = r2.longValue()
            androidx.lifecycle.y<java.lang.Long> r2 = r9.selectedArrivalMax
            java.lang.Object r2 = r2.getValue()
            if (r2 != 0) goto L_0x01f4
            kotlin.g.b.k.a()
        L_0x01f4:
            java.lang.String r6 = "this.selectedArrivalMax.value!!"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r6)
            java.lang.Number r2 = (java.lang.Number) r2
            long r6 = r2.longValue()
            r2 = r0
            r2.<init>(r3, r4, r6)
            r1.add(r0)
        L_0x0206:
            androidx.lifecycle.y<java.util.List<com.travel.flight.flightSRPV2.a.d>> r0 = r9.allAirlineList
            java.lang.Object r0 = r0.getValue()
            java.util.List r0 = (java.util.List) r0
            if (r0 == 0) goto L_0x0260
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r0 = r0.iterator()
        L_0x021d:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0241
            java.lang.Object r3 = r0.next()
            r4 = r3
            com.travel.flight.flightSRPV2.a.d r4 = (com.travel.flight.flightSRPV2.a.d) r4
            androidx.databinding.i<java.lang.Boolean> r4 = r4.f24099e
            java.lang.Object r4 = r4.get()
            if (r4 != 0) goto L_0x0235
            kotlin.g.b.k.a()
        L_0x0235:
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x021d
            r2.add(r3)
            goto L_0x021d
        L_0x0241:
            java.util.List r2 = (java.util.List) r2
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r0 = r2.iterator()
        L_0x0249:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0260
            java.lang.Object r2 = r0.next()
            com.travel.flight.flightSRPV2.a.d r2 = (com.travel.flight.flightSRPV2.a.d) r2
            com.travel.flight.flightSRPV2.a.r r3 = new com.travel.flight.flightSRPV2.a.r
            boolean r4 = r9.isOnward
            r3.<init>(r4, r2)
            r1.add(r3)
            goto L_0x0249
        L_0x0260:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightSRPV2.viewModel.FlightFilterViewModel.getFilters():java.util.List");
    }

    /* access modifiers changed from: private */
    public final void onHideNonRefundableFlightsChange() {
        checkIfFiltersAreAltered();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        if (r0 == null) goto L_0x0021;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onAirlineFilterTextChange() {
        /*
            r9 = this;
            androidx.lifecycle.y<java.lang.String> r0 = r9.airlineFilterText
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L_0x0021
            if (r0 == 0) goto L_0x0019
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.CharSequence r0 = kotlin.m.p.b(r0)
            java.lang.String r0 = r0.toString()
            if (r0 != 0) goto L_0x0023
            goto L_0x0021
        L_0x0019:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.CharSequence"
            r0.<init>(r1)
            throw r0
        L_0x0021:
            java.lang.String r0 = ""
        L_0x0023:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0032
            boolean r3 = kotlin.m.p.a(r0)
            if (r3 == 0) goto L_0x0030
            goto L_0x0032
        L_0x0030:
            r3 = 0
            goto L_0x0033
        L_0x0032:
            r3 = 1
        L_0x0033:
            java.lang.String r4 = "this.allAirlineList.value!!"
            if (r3 == 0) goto L_0x0051
            androidx.lifecycle.y<java.util.List<com.travel.flight.flightSRPV2.a.d>> r3 = r9.filteredAirlineList
            androidx.lifecycle.y<java.util.List<com.travel.flight.flightSRPV2.a.d>> r5 = r9.allAirlineList
            java.lang.Object r5 = r5.getValue()
            if (r5 != 0) goto L_0x0044
            kotlin.g.b.k.a()
        L_0x0044:
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r4)
            java.util.Collection r5 = (java.util.Collection) r5
            java.util.List r5 = kotlin.a.k.c(r5)
            r3.setValue(r5)
            goto L_0x0092
        L_0x0051:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.List r3 = (java.util.List) r3
            androidx.lifecycle.y<java.util.List<com.travel.flight.flightSRPV2.a.d>> r5 = r9.allAirlineList
            java.lang.Object r5 = r5.getValue()
            if (r5 != 0) goto L_0x0063
            kotlin.g.b.k.a()
        L_0x0063:
            java.util.List r5 = (java.util.List) r5
            java.util.Iterator r5 = r5.iterator()
        L_0x0069:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x008d
            java.lang.Object r6 = r5.next()
            com.travel.flight.flightSRPV2.a.d r6 = (com.travel.flight.flightSRPV2.a.d) r6
            java.lang.String r7 = r6.f24096b
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = kotlin.m.p.a((java.lang.CharSequence) r7, (java.lang.CharSequence) r0, (boolean) r2)
            if (r7 != 0) goto L_0x0089
            java.lang.String r7 = r6.f24095a
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = kotlin.m.p.a((java.lang.CharSequence) r7, (java.lang.CharSequence) r0, (boolean) r2)
            if (r7 == 0) goto L_0x0069
        L_0x0089:
            r3.add(r6)
            goto L_0x0069
        L_0x008d:
            androidx.lifecycle.y<java.util.List<com.travel.flight.flightSRPV2.a.d>> r5 = r9.filteredAirlineList
            r5.setValue(r3)
        L_0x0092:
            androidx.lifecycle.y<java.util.List<com.travel.flight.flightSRPV2.a.d>> r3 = r9.filteredAirlineList
            androidx.lifecycle.y<java.util.List<com.travel.flight.flightSRPV2.a.d>> r5 = r9.allAirlineList
            java.lang.Object r5 = r5.getValue()
            if (r5 != 0) goto L_0x009f
            kotlin.g.b.k.a()
        L_0x009f:
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r4)
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.Iterator r5 = r5.iterator()
        L_0x00af:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x00da
            java.lang.Object r6 = r5.next()
            r7 = r6
            com.travel.flight.flightSRPV2.a.d r7 = (com.travel.flight.flightSRPV2.a.d) r7
            java.lang.String r8 = r7.f24096b
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r8 = kotlin.m.p.a((java.lang.CharSequence) r8, (java.lang.CharSequence) r0, (boolean) r2)
            if (r8 != 0) goto L_0x00d3
            java.lang.String r7 = r7.f24095a
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = kotlin.m.p.a((java.lang.CharSequence) r7, (java.lang.CharSequence) r0, (boolean) r2)
            if (r7 == 0) goto L_0x00d1
            goto L_0x00d3
        L_0x00d1:
            r7 = 0
            goto L_0x00d4
        L_0x00d3:
            r7 = 1
        L_0x00d4:
            if (r7 == 0) goto L_0x00af
            r4.add(r6)
            goto L_0x00af
        L_0x00da:
            java.util.List r4 = (java.util.List) r4
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.List r0 = kotlin.a.k.c(r4)
            r3.setValue(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightSRPV2.viewModel.FlightFilterViewModel.onAirlineFilterTextChange():void");
    }

    public final void clearAirlineFilterText() {
        this.airlineFilterText.setValue("");
    }

    public final void onFlightStopsSelected(int i2) {
        this.selectedFlightStopType.setValue(Integer.valueOf(i2));
        checkIfFiltersAreAltered();
    }

    public final void toggleHideNonRefundableFlights() {
        Boolean value = this.hideNonRefundableFlights.getValue();
        if (value == null) {
            value = Boolean.FALSE;
        }
        k.a((Object) value, "this.hideNonRefundableFlights.value ?: false");
        this.hideNonRefundableFlights.setValue(Boolean.valueOf(!value.booleanValue()));
    }

    public final void onCleared() {
        this.disposables.dispose();
        super.onCleared();
    }

    public final void populateFilterValues(boolean z) {
        d dVar;
        i<Boolean> iVar;
        if (z) {
            this.previouslySelectedFilters = w.INSTANCE;
        }
        u value = (this.isOnward ? this.parentViewModel.getDefaultOnwardFilterInfo() : this.parentViewModel.getDefaultReturnFilterInfo()).getValue();
        if (value != null) {
            this.hideNonRefundableFlights.setValue(Boolean.valueOf(value.f24126a));
            this.selectedFlightStopType.setValue(Integer.valueOf(value.f24127b));
            this.selectedDuration.setValue(value.f24128c.f24101b);
            this.selectedPriceMin.setValue(value.f24129d.f24100a);
            this.selectedPriceMax.setValue(value.f24129d.f24101b);
            this.selectedDepartureMin.setValue(value.f24130e.f24100a);
            this.selectedDepartureMax.setValue(value.f24130e.f24101b);
            this.selectedDepartureTimeZone.setValue(value.f24130e.f24102c);
            this.selectedArrivalMin.setValue(value.f24131f.f24100a);
            this.selectedArrivalMax.setValue(value.f24131f.f24101b);
            this.selectedArrivalTimeZone.setValue(value.f24131f.f24102c);
            for (com.travel.flight.flightSRPV2.a.x xVar : this.previouslySelectedFilters) {
                if (xVar instanceof ab) {
                    this.hideNonRefundableFlights.setValue(Boolean.TRUE);
                } else if (xVar instanceof af) {
                    this.selectedFlightStopType.setValue(Integer.valueOf(((af) xVar).f24086a));
                } else if (xVar instanceof com.travel.flight.flightSRPV2.a.w) {
                    this.selectedDuration.setValue(Integer.valueOf(((com.travel.flight.flightSRPV2.a.w) xVar).f24135a));
                } else if (xVar instanceof aa) {
                    aa aaVar = (aa) xVar;
                    this.selectedPriceMin.setValue(Integer.valueOf(aaVar.f24074a));
                    this.selectedPriceMax.setValue(Integer.valueOf(aaVar.f24075b));
                } else if (xVar instanceof v) {
                    v vVar = (v) xVar;
                    this.selectedDepartureMin.setValue(Long.valueOf(vVar.f24133a));
                    this.selectedDepartureMax.setValue(Long.valueOf(vVar.f24134b));
                } else if (xVar instanceof s) {
                    s sVar = (s) xVar;
                    this.selectedArrivalMin.setValue(Long.valueOf(sVar.f24122a));
                    this.selectedArrivalMax.setValue(Long.valueOf(sVar.f24123b));
                }
            }
            u value2 = (this.isOnward ? this.parentViewModel.getDefaultOnwardFilterInfo() : this.parentViewModel.getDefaultReturnFilterInfo()).getValue();
            if (value2 == null) {
                k.a();
            }
            Iterable<d> iterable = value2.f24132g;
            Collection arrayList = new ArrayList(kotlin.a.k.a(iterable));
            for (d a2 : iterable) {
                d a3 = d.a(a2, (String) null, (String) null, 0, 0, (i) null, 31);
                i iVar2 = new i();
                iVar2.set(Boolean.FALSE);
                a3.a(iVar2);
                arrayList.add(a3);
            }
            Iterable iterable2 = (List) arrayList;
            Map linkedHashMap = new LinkedHashMap(e.b(ae.a(kotlin.a.k.a(iterable2)), 16));
            for (Object next : iterable2) {
                linkedHashMap.put(((d) next).f24095a, next);
            }
            Collection arrayList2 = new ArrayList();
            for (Object next2 : this.previouslySelectedFilters) {
                if (next2 instanceof r) {
                    arrayList2.add(next2);
                }
            }
            for (r rVar : (List) arrayList2) {
                String str = rVar.f24121a.f24095a;
                if (!(!linkedHashMap.containsKey(str) || (dVar = (d) linkedHashMap.get(str)) == null || (iVar = dVar.f24099e) == null)) {
                    iVar.set(Boolean.TRUE);
                }
            }
            this.allAirlineList.setValue(kotlin.a.k.a(linkedHashMap.values(), FlightFilterViewModel$populateFilterValues$1.INSTANCE));
            y<List<d>> yVar = this.filteredAirlineList;
            List<d> value3 = this.allAirlineList.getValue();
            if (value3 == null) {
                k.a();
            }
            k.a((Object) value3, "this.allAirlineList.value!!");
            yVar.setValue(kotlin.a.k.c(value3));
            checkIfFiltersAreAltered();
        }
    }

    public final void onAirlineSelectionChange(d dVar) {
        i<Boolean> iVar;
        if (!(dVar == null || (iVar = dVar.f24099e) == null)) {
            Boolean bool = dVar.f24099e.get();
            if (bool == null) {
                k.a();
            }
            iVar.set(Boolean.valueOf(!bool.booleanValue()));
        }
        checkIfFiltersAreAltered();
    }
}
