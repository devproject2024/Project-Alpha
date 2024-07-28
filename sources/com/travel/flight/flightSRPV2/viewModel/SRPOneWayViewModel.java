package com.travel.flight.flightSRPV2.viewModel;

import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.travel.flight.flightSRPV2.a.af;
import com.travel.flight.flightSRPV2.a.c;
import com.travel.flight.flightSRPV2.a.x;
import com.travel.flight.flightSRPV2.c.a;
import com.travel.flight.flightSRPV2.c.b;
import com.travel.flight.pojo.flightticket.CJRFlightDetails;
import com.travel.flight.pojo.flightticket.CJRFlightDetailsItem;
import com.travel.flight.pojo.flightticket.CJRFlightSearchInput;
import com.travel.flight.pojo.flightticket.CJRFlightSearchResult;
import com.travel.flight.pojo.flightticket.CJRFlightStops;
import com.travel.flight.pojo.flightticket.CJRMetadetails;
import com.travel.flight.pojo.flightticket.CJROnwardReturnFlightInformation;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.b.k;
import kotlin.j.e;
import kotlin.m.p;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;

public final class SRPOneWayViewModel extends ai {
    private final z<Object> filterSortChangeObserver = new SRPOneWayViewModel$filterSortChangeObserver$1(this);
    private final b<c> itemRangeAlteredEvent = new b<>();
    private final y<a<CJRFlightDetailsItem>> onwardFlightList = new y<>();
    private final SRPSharedViewModel parentViewModel;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[com.travel.flight.flightticket.d.b.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[com.travel.flight.flightticket.d.b.Regular.ordinal()] = 1;
            $EnumSwitchMapping$0[com.travel.flight.flightticket.d.b.Modify.ordinal()] = 2;
            $EnumSwitchMapping$0[com.travel.flight.flightticket.d.b.Corporate.ordinal()] = 3;
        }
    }

    public SRPOneWayViewModel(SRPSharedViewModel sRPSharedViewModel) {
        k.c(sRPSharedViewModel, "parentViewModel");
        this.parentViewModel = sRPSharedViewModel;
        if (this.parentViewModel.isSortFilterEnable()) {
            wireDataChangeListeners();
        } else {
            updateFlightList();
        }
    }

    public final SRPSharedViewModel getParentViewModel() {
        return this.parentViewModel;
    }

    public final y<a<CJRFlightDetailsItem>> getOnwardFlightList() {
        return this.onwardFlightList;
    }

    public final b<c> getItemRangeAlteredEvent() {
        return this.itemRangeAlteredEvent;
    }

    /* access modifiers changed from: private */
    public final void updateFlightList() {
        Calendar instance = Calendar.getInstance();
        k.a((Object) instance, "Calendar.getInstance()");
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (f) null, (CoroutineStart) null, new SRPOneWayViewModel$updateFlightList$1(this, instance.getTimeInMillis(), (d) null), 3, (Object) null);
    }

    public final void onCleared() {
        this.parentViewModel.getOnwardFilterList().removeObserver(this.filterSortChangeObserver);
        this.parentViewModel.getOneWaySortOption().removeObserver(this.filterSortChangeObserver);
        super.onCleared();
    }

    private final void wireDataChangeListeners() {
        this.parentViewModel.getOnwardFilterList().observeForever(this.filterSortChangeObserver);
        this.parentViewModel.getOneWaySortOption().observeForever(this.filterSortChangeObserver);
    }

    public final void metaBannerClicked(String str) {
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0)) {
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            bundle.putString(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX, "Flights");
            this.parentViewModel.navigate(new com.travel.flight.flightSRPV2.b.a("PAGE_EMBED_WEB_VIEW", bundle));
        }
    }

    public final void onFlightItemClick(CJRFlightDetailsItem cJRFlightDetailsItem) {
        k.c(cJRFlightDetailsItem, "flight");
        CharSequence charSequence = cJRFlightDetailsItem.getmFlightId();
        boolean z = false;
        int i2 = 1;
        if (!(charSequence == null || p.a(charSequence))) {
            if (cJRFlightDetailsItem.ismIsParent()) {
                Collection childItems = cJRFlightDetailsItem.getChildItems();
                if (childItems == null || childItems.isEmpty()) {
                    z = true;
                }
                if (!z) {
                    Boolean bool = cJRFlightDetailsItem.getIsExpanded().get();
                    if (bool == null) {
                        k.a();
                    }
                    boolean z2 = !bool.booleanValue();
                    cJRFlightDetailsItem.getIsExpanded().set(Boolean.valueOf(z2));
                    List<CJRFlightDetailsItem> childItems2 = cJRFlightDetailsItem.getChildItems();
                    if (childItems2 == null) {
                        k.a();
                    }
                    for (CJRFlightDetailsItem next : childItems2) {
                        k.a((Object) next, "child");
                        next.getIsExpanded().set(Boolean.valueOf(z2));
                    }
                    a<CJRFlightDetailsItem> value = this.onwardFlightList.getValue();
                    if (value == null) {
                        k.a();
                    }
                    k.a((Object) value, "onwardFlightList.value!!");
                    a aVar = value;
                    int indexOf = aVar.indexOf(cJRFlightDetailsItem) + 1;
                    if (indexOf > 0) {
                        if (!z2) {
                            i2 = 2;
                        }
                        c cVar = new c(i2, e.a(indexOf, cJRFlightDetailsItem.getChildItems().size() + indexOf));
                        if (z2) {
                            aVar.addAll(indexOf, cJRFlightDetailsItem.getChildItems());
                        } else {
                            aVar.deleteRange(indexOf, cJRFlightDetailsItem.getChildItems().size() + indexOf);
                        }
                        this.itemRangeAlteredEvent.postValue(cVar);
                        return;
                    }
                    return;
                }
            }
            if (this.parentViewModel.getSrpResult().getValue() != null) {
                this.parentViewModel.navigate(getNavParamsForReviewPage(cJRFlightDetailsItem));
            }
        }
    }

    public final void onNonStopFlightsFilterToggled() {
        Object obj;
        boolean z;
        List<x> value = this.parentViewModel.getOnwardFilterList().getValue();
        if (value == null) {
            k.a();
        }
        ArrayList arrayList = new ArrayList(value);
        Iterator it2 = arrayList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            if (((x) obj).e() == 2) {
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
        if (!(obj instanceof af)) {
            obj = null;
        }
        af afVar = (af) obj;
        if (afVar == null) {
            arrayList.add(new af(true, 1));
            this.parentViewModel.sendPulseEventNonStopSelected(true);
        } else if (afVar.f24086a != 1) {
            arrayList.remove(afVar);
            arrayList.add(new af(true, 1));
        } else {
            arrayList.remove(afVar);
            this.parentViewModel.sendPulseEventNonStopSelected(false);
        }
        if (this.parentViewModel.getDefaultOnwardFilterInfo().getValue() != null) {
            this.parentViewModel.applyFilters(arrayList, (List<? extends x>) null);
        }
    }

    private final com.travel.flight.flightSRPV2.b.d getNavParamsForReviewPage(CJRFlightDetailsItem cJRFlightDetailsItem) {
        CJRFlightStops cJRFlightStops;
        CJRMetadetails cJRMetadetails;
        Bundle bundle = new Bundle();
        CJRFlightSearchInput value = this.parentViewModel.getSearchInput().getValue();
        if (value == null) {
            k.a();
        }
        k.a((Object) value, "this.parentViewModel.searchInput.value!!");
        CJRFlightSearchInput cJRFlightSearchInput = value;
        CJRFlightSearchResult value2 = this.parentViewModel.getSrpResult().getValue();
        if (value2 == null) {
            k.a();
        }
        CJROnwardReturnFlightInformation cJROnwardReturnFlightInformation = value2.getmOnwardReturnFlights();
        k.a((Object) cJROnwardReturnFlightInformation, "this.parentViewModel.srp…getmOnwardReturnFlights()");
        String journey_type = cJROnwardReturnFlightInformation.getJourney_type();
        if (journey_type == null) {
            k.a();
        }
        boolean a2 = k.a((Object) journey_type, (Object) net.one97.paytmflight.common.b.b.f30019i);
        CJRFlightDetails cJRFlightDetails = new CJRFlightDetails();
        cJRFlightDetails.setmOnwardJourney(cJRFlightDetailsItem);
        cJRFlightDetails.setOnwardMealsAvailable(cJRFlightDetailsItem.getMealsAvaialable());
        if (cJRFlightDetailsItem.getmServiceProviderSelected() == null) {
            cJRFlightDetailsItem.setmServiceProviderSelected(cJRFlightDetailsItem.getmPrice().get(0));
        }
        cJRFlightDetails.setmOnwardServiceProvider(cJRFlightDetailsItem.getmServiceProviderSelected().getmServiceProvider());
        cJRFlightDetails.setmFareDetails(cJRFlightDetailsItem.getmServiceProviderSelected());
        cJRFlightDetails.setmIsInternational(Boolean.valueOf(a2));
        CJRFlightSearchResult value3 = this.parentViewModel.getSrpResult().getValue();
        String str = null;
        if ((value3 != null ? value3.getmMetaDetails() : null) != null) {
            CJRFlightSearchResult value4 = this.parentViewModel.getSrpResult().getValue();
            if (value4 == null) {
                k.a();
            }
            cJRFlightDetails.setmMetaDetails(value4.getmMetaDetails());
        } else {
            String str2 = a2 ? "IOW" : "DOW";
            SRPSharedViewModel sRPSharedViewModel = this.parentViewModel;
            CJRFlightSearchResult value5 = sRPSharedViewModel.getSrpResult().getValue();
            sRPSharedViewModel.sendHawkeyeErrorEvent(str2, "meta key is null in srp-response", (value5 == null || (cJRMetadetails = value5.getmMetaDetails()) == null) ? null : cJRMetadetails.getmRequestId());
        }
        bundle.putSerializable("intent_extra_review_data", cJRFlightDetails);
        bundle.putSerializable("intent_extra_search_input_data", cJRFlightSearchInput);
        bundle.putString("intent_extra_trip_type", "one_way");
        bundle.putString("acceptType", "regular");
        if (cJRFlightDetailsItem.getmFlights().size() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(cJRFlightDetailsItem.getmAirLineCode());
            sb.append(' ');
            ArrayList<CJRFlightStops> arrayList = cJRFlightDetailsItem.getmFlights();
            if (!(arrayList == null || (cJRFlightStops = arrayList.get(0)) == null)) {
                str = cJRFlightStops.getmFlightNumber();
            }
            sb.append(str);
            this.parentViewModel.sendPulseEventFlightSelected(sb.toString());
        }
        CJRFlightSearchInput value6 = this.parentViewModel.getSearchInput().getValue();
        if (value6 != null) {
            k.a((Object) value6, "it");
            com.travel.flight.flightticket.d.b bookingSegment = value6.getBookingSegment();
            if (bookingSegment != null) {
                int i2 = WhenMappings.$EnumSwitchMapping$0[bookingSegment.ordinal()];
                if (i2 == 1) {
                    bundle.putInt("INTENT_EXTRA_REVIEW_TYPE", 1);
                } else if (i2 == 2) {
                    bundle.putInt("INTENT_EXTRA_REVIEW_TYPE", 0);
                } else if (i2 == 3) {
                    bundle.putInt("INTENT_EXTRA_REVIEW_TYPE", 2);
                }
            }
        }
        return new com.travel.flight.flightSRPV2.b.a("PAGE_REVIEW_ITINERARY", bundle);
    }

    public final void fetchDataForNextOrPreviousDay(Context context, boolean z) {
        k.c(context, "context");
        CJRFlightSearchInput value = this.parentViewModel.getSearchInput().getValue();
        if (value == null) {
            k.a();
        }
        k.a((Object) value, "this.parentViewModel.searchInput.value!!");
        CJRFlightSearchInput cJRFlightSearchInput = value;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar instance = Calendar.getInstance();
        instance.setTime(simpleDateFormat.parse(cJRFlightSearchInput.getDate()));
        instance.add(5, z ? 1 : -1);
        k.a((Object) instance, "calendar");
        Date time = instance.getTime();
        if (!com.travel.flight.utils.c.a(time)) {
            cJRFlightSearchInput.setDate(simpleDateFormat.format(time));
            this.parentViewModel.refresh(context, cJRFlightSearchInput);
        }
    }
}
