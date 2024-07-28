package com.travel.flight.flightSRPV2.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ai;
import com.travel.flight.flightSRPV2.a.t;
import com.travel.flight.flightSRPV2.a.x;
import com.travel.flight.pojo.flightticket.CJRFlightSearchInput;
import com.travel.flight.pojo.flightticket.CJRFlightSearchResult;
import com.travel.flight.pojo.flightticket.CJROnwardReturnFlightInformation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.a.ak;
import kotlin.a.y;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.o;
import kotlin.u;
import net.one97.paytmflight.common.b.b;

public final class FlightFilterHomeViewModel extends ai {
    private static final Set<Integer> COMMON_FILTERS_DOW = y.INSTANCE;
    private static final Set<Integer> COMMON_FILTERS_DRT = ak.a(2);
    private static final Set<Integer> COMMON_FILTERS_IOW = y.INSTANCE;
    private static final Set<Integer> COMMON_FILTERS_IRT = ak.a(1, 2, 4);
    public static final Companion Companion = new Companion((g) null);
    public static final int EVENT_TYPE_APPLY_FILTERS = 3;
    public static final int EVENT_TYPE_CLOSE = 1;
    public static final int EVENT_TYPE_RESET_FILTERS = 2;
    private final androidx.lifecycle.y<Boolean> areFiltersChanged = new androidx.lifecycle.y<>();
    private boolean areOnwardFiltersChanged;
    private boolean areReturnFiltersChanged;
    private final androidx.lifecycle.y<Integer> event = new androidx.lifecycle.y<>();
    private boolean isDomestic = true;
    private boolean isRoundTrip;
    private FlightFilterViewModel onwardViewModel;
    private final SRPSharedViewModel parentViewModel;
    private List<? extends x> proposedOnwardFilters;
    private List<? extends x> proposedReturnFilters;
    private FlightFilterViewModel returnViewModel;
    private final androidx.lifecycle.y<List<String>> tabs = new androidx.lifecycle.y<>();

    public FlightFilterHomeViewModel(SRPSharedViewModel sRPSharedViewModel) {
        List list;
        k.c(sRPSharedViewModel, "parentViewModel");
        this.parentViewModel = sRPSharedViewModel;
        if (this.parentViewModel.getSrpResult().getValue() != null) {
            this.areFiltersChanged.setValue(Boolean.FALSE);
            CJRFlightSearchResult value = this.parentViewModel.getSrpResult().getValue();
            if (value == null) {
                k.a();
            }
            k.a((Object) value, "parentViewModel.srpResult.value!!");
            CJRFlightSearchResult cJRFlightSearchResult = value;
            CJROnwardReturnFlightInformation cJROnwardReturnFlightInformation = cJRFlightSearchResult.getmOnwardReturnFlights();
            k.a((Object) cJROnwardReturnFlightInformation, "flightInfo");
            this.isDomestic = !k.a((Object) cJROnwardReturnFlightInformation.getJourney_type(), (Object) b.f30019i);
            this.isRoundTrip = cJRFlightSearchResult.getmOnwardReturnFlights().getmReturnFlights() != null;
            CJRFlightSearchInput value2 = this.parentViewModel.getSearchInput().getValue();
            if (value2 == null) {
                k.a();
            }
            k.a((Object) value2, "this.parentViewModel.searchInput.value!!");
            CJRFlightSearchInput cJRFlightSearchInput = value2;
            com.travel.flight.pojo.flightticket.b source = cJRFlightSearchInput.getSource();
            k.a((Object) source, "searchInput.source");
            String shortCityName = source.getShortCityName();
            shortCityName = shortCityName == null ? "" : shortCityName;
            com.travel.flight.pojo.flightticket.b destination = cJRFlightSearchInput.getDestination();
            k.a((Object) destination, "searchInput.destination");
            String shortCityName2 = destination.getShortCityName();
            shortCityName2 = shortCityName2 == null ? "" : shortCityName2;
            androidx.lifecycle.y<List<String>> yVar = this.tabs;
            if (this.isRoundTrip) {
                list = kotlin.a.k.b((T[]) new String[]{shortCityName + " - " + shortCityName2, shortCityName2 + " - " + shortCityName});
            } else {
                list = kotlin.a.k.a(shortCityName + " - " + shortCityName2);
            }
            yVar.setValue(list);
        }
    }

    public final SRPSharedViewModel getParentViewModel() {
        return this.parentViewModel;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public final androidx.lifecycle.y<List<String>> getTabs() {
        return this.tabs;
    }

    public final androidx.lifecycle.y<Integer> getEvent() {
        return this.event;
    }

    public final LiveData<Boolean> areFiltersChanged() {
        androidx.lifecycle.y<Boolean> yVar = this.areFiltersChanged;
        if (yVar != null) {
            return yVar;
        }
        throw new u("null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Boolean>");
    }

    public final boolean isDomestic() {
        return this.isDomestic;
    }

    public final void setDomestic(boolean z) {
        this.isDomestic = z;
    }

    public final boolean isRoundTrip() {
        return this.isRoundTrip;
    }

    public final void setRoundTrip(boolean z) {
        this.isRoundTrip = z;
    }

    public final boolean getAreOnwardFiltersChanged() {
        return this.areOnwardFiltersChanged;
    }

    public final void setAreOnwardFiltersChanged(boolean z) {
        this.areOnwardFiltersChanged = z;
    }

    public final boolean getAreReturnFiltersChanged() {
        return this.areReturnFiltersChanged;
    }

    public final void setAreReturnFiltersChanged(boolean z) {
        this.areReturnFiltersChanged = z;
    }

    public final FlightFilterViewModel getOnwardViewModel() {
        return this.onwardViewModel;
    }

    public final void setOnwardViewModel(FlightFilterViewModel flightFilterViewModel) {
        this.onwardViewModel = flightFilterViewModel;
    }

    public final FlightFilterViewModel getReturnViewModel() {
        return this.returnViewModel;
    }

    public final void setReturnViewModel(FlightFilterViewModel flightFilterViewModel) {
        this.returnViewModel = flightFilterViewModel;
    }

    public final synchronized void setOnFiltersChanged(boolean z, boolean z2, List<? extends x> list) {
        k.c(list, "currFilters");
        StringBuilder sb = new StringBuilder("isOnward - ");
        sb.append(z);
        sb.append(", areFiltersChanged - ");
        sb.append(z2);
        if (z) {
            this.areOnwardFiltersChanged = z2;
            if (this.returnViewModel != null) {
                FlightFilterViewModel flightFilterViewModel = this.returnViewModel;
                if (flightFilterViewModel == null) {
                    k.a();
                }
                o<Boolean, List<x>> makeCommonFiltersConsistent = makeCommonFiltersConsistent(list, flightFilterViewModel.getFilters());
                if (makeCommonFiltersConsistent.getFirst().booleanValue()) {
                    FlightFilterViewModel flightFilterViewModel2 = this.returnViewModel;
                    if (flightFilterViewModel2 == null) {
                        k.a();
                    }
                    flightFilterViewModel2.populateFilterValues((List<? extends x>) makeCommonFiltersConsistent.getSecond());
                }
            }
        } else {
            this.areReturnFiltersChanged = z2;
            if (this.onwardViewModel != null) {
                FlightFilterViewModel flightFilterViewModel3 = this.onwardViewModel;
                if (flightFilterViewModel3 == null) {
                    k.a();
                }
                o<Boolean, List<x>> makeCommonFiltersConsistent2 = makeCommonFiltersConsistent(list, flightFilterViewModel3.getFilters());
                if (makeCommonFiltersConsistent2.getFirst().booleanValue()) {
                    FlightFilterViewModel flightFilterViewModel4 = this.onwardViewModel;
                    if (flightFilterViewModel4 == null) {
                        k.a();
                    }
                    flightFilterViewModel4.populateFilterValues((List<? extends x>) makeCommonFiltersConsistent2.getSecond());
                }
            }
        }
        this.areFiltersChanged.setValue(Boolean.valueOf(this.areOnwardFiltersChanged | this.areReturnFiltersChanged));
    }

    public final void applyFilters(List<? extends x> list, boolean z) {
        k.c(list, "list");
        if (z) {
            this.proposedOnwardFilters = list;
        } else {
            this.proposedReturnFilters = list;
        }
        if (!this.parentViewModel.isRoundTrip()) {
            if (this.proposedOnwardFilters != null) {
                onCloseClick();
                this.parentViewModel.applyFilters(this.proposedOnwardFilters, (List<? extends x>) null);
            }
        } else if (this.proposedOnwardFilters != null && this.proposedReturnFilters != null) {
            onCloseClick();
            this.parentViewModel.applyFilters(this.proposedOnwardFilters, this.proposedReturnFilters);
        }
    }

    public final void onCloseClick() {
        this.event.setValue(1);
    }

    public final void onResetClick() {
        this.parentViewModel.onFilterRemoved();
        this.event.setValue(2);
    }

    public final void onApplyFilterClick() {
        this.event.setValue(3);
    }

    private final o<Boolean, List<x>> makeCommonFiltersConsistent(List<? extends x> list, List<? extends x> list2) {
        Set<Integer> set;
        if (this.isDomestic && this.isRoundTrip) {
            set = COMMON_FILTERS_DRT;
        } else if (this.isDomestic && !this.isRoundTrip) {
            set = COMMON_FILTERS_DOW;
        } else if (this.isDomestic || !this.isRoundTrip) {
            set = COMMON_FILTERS_IOW;
        } else {
            set = COMMON_FILTERS_IRT;
        }
        Collection arrayList = new ArrayList();
        for (Object next : list) {
            if (set.contains(Integer.valueOf(((x) next).e()))) {
                arrayList.add(next);
            }
        }
        List list3 = (List) arrayList;
        Iterable iterable = list2;
        Collection arrayList2 = new ArrayList();
        for (Object next2 : iterable) {
            if (set.contains(Integer.valueOf(((x) next2).e()))) {
                arrayList2.add(next2);
            }
        }
        boolean a2 = t.a((List<? extends x>) list3, (List<? extends x>) (List) arrayList2, true);
        if (!a2) {
            return new o<>(Boolean.FALSE, list2);
        }
        Collection arrayList3 = new ArrayList();
        for (Object next3 : iterable) {
            if (!set.contains(Integer.valueOf(((x) next3).e()))) {
                arrayList3.add(next3);
            }
        }
        List list4 = (List) arrayList3;
        Iterable<x> iterable2 = list3;
        Collection arrayList4 = new ArrayList(kotlin.a.k.a(iterable2));
        for (x b2 : iterable2) {
            x xVar = (x) b2.b();
            xVar.f24136c = !xVar.f24136c;
            arrayList4.add(xVar);
        }
        return new o<>(Boolean.valueOf(a2), t.b(list4, (List) arrayList4));
    }
}
