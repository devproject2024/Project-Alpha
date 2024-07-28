package com.travel.flight.flightSRPV2.viewModel;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.travel.flight.R;
import com.travel.flight.flightSRPV2.a.af;
import com.travel.flight.flightSRPV2.a.q;
import com.travel.flight.flightSRPV2.a.t;
import com.travel.flight.flightSRPV2.a.x;
import com.travel.flight.flightSRPV2.b.a;
import com.travel.flight.flightSRPV2.b.b;
import com.travel.flight.flightSRPV2.b.c;
import com.travel.flight.flightSRPV2.b.e;
import com.travel.flight.pojo.flightticket.CJRFlightDetails;
import com.travel.flight.pojo.flightticket.CJRFlightDetailsItem;
import com.travel.flight.pojo.flightticket.CJRFlightPrice;
import com.travel.flight.pojo.flightticket.CJRFlightSearchInput;
import com.travel.flight.pojo.flightticket.CJRFlightSearchResult;
import com.travel.flight.pojo.flightticket.CJRFlightStops;
import com.travel.flight.pojo.flightticket.CJRIntlFlightList;
import com.travel.flight.pojo.flightticket.CJRIntlFlightMapping;
import com.travel.flight.pojo.flightticket.CJRIntlFlightPricing;
import com.travel.flight.pojo.flightticket.CJROnwardFlights;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

public final class IRTViewModel extends ai {
    public static final Companion Companion = new Companion((g) null);
    private final String INT_SEARCH_LIST_BACK_STACK_TAG = "int_flight_search_tag";
    private final y<List<CJRIntlFlightList>> intlFlightList = new y<>();
    private final z<Object> irtSortOptionChangeObserver = new IRTViewModel$irtSortOptionChangeObserver$1(this);
    private final z<Object> onwardReturnFilterSortChangeObserver = new IRTViewModel$onwardReturnFilterSortChangeObserver$1(this);
    private final SRPSharedViewModel parentViewModel;

    public static final void setAirlineCode(TextView textView, CJRFlightDetailsItem cJRFlightDetailsItem) {
        Companion.setAirlineCode(textView, cJRFlightDetailsItem);
    }

    public static final void setAirlineLogo(ImageView imageView, CJRFlightDetailsItem cJRFlightDetailsItem) {
        Companion.setAirlineLogo(imageView, cJRFlightDetailsItem);
    }

    public static final void setArrivalCityName(TextView textView, CJRFlightDetailsItem cJRFlightDetailsItem) {
        Companion.setArrivalCityName(textView, cJRFlightDetailsItem);
    }

    public static final void setDepartureCityName(TextView textView, CJRFlightDetailsItem cJRFlightDetailsItem) {
        Companion.setDepartureCityName(textView, cJRFlightDetailsItem);
    }

    public static final void setFlightFare(TextView textView, CJRIntlFlightList cJRIntlFlightList) {
        Companion.setFlightFare(textView, cJRIntlFlightList);
    }

    public static final void setFlightName(TextView textView, CJRIntlFlightList cJRIntlFlightList) {
        Companion.setFlightName(textView, cJRIntlFlightList);
    }

    public static final void setHopText(TextView textView, CJRFlightDetailsItem cJRFlightDetailsItem) {
        Companion.setHopText(textView, cJRFlightDetailsItem);
    }

    public static final void setMoreOptionView(CardView cardView, CJRIntlFlightList cJRIntlFlightList, CJRFlightSearchResult cJRFlightSearchResult) {
        Companion.setMoreOptionView(cardView, cJRIntlFlightList, cJRFlightSearchResult);
    }

    public static final void setMoreOptionViewText(TextView textView, CJRIntlFlightList cJRIntlFlightList, CJRFlightSearchResult cJRFlightSearchResult) {
        Companion.setMoreOptionViewText(textView, cJRIntlFlightList, cJRFlightSearchResult);
    }

    public static final void setOneStopView(View view, CJRFlightDetailsItem cJRFlightDetailsItem) {
        Companion.setOneStopView(view, cJRFlightDetailsItem);
    }

    public static final void setRefundableText(TextView textView, CJRIntlFlightList cJRIntlFlightList) {
        Companion.setRefundableText(textView, cJRIntlFlightList);
    }

    public static final void setTwoStopView(View view, CJRFlightDetailsItem cJRFlightDetailsItem) {
        Companion.setTwoStopView(view, cJRFlightDetailsItem);
    }

    public IRTViewModel(SRPSharedViewModel sRPSharedViewModel) {
        k.c(sRPSharedViewModel, "parentViewModel");
        this.parentViewModel = sRPSharedViewModel;
        if (!this.parentViewModel.isDeeplinkFilterApplied()) {
            this.parentViewModel.getIrtSortOption().setValue(new q((byte) 0));
        }
        wireDataChangeListeners();
    }

    public final SRPSharedViewModel getParentViewModel() {
        return this.parentViewModel;
    }

    public final y<List<CJRIntlFlightList>> getIntlFlightList() {
        return this.intlFlightList;
    }

    public final void onCleared() {
        this.parentViewModel.getIrtFilterList().removeObserver(this.onwardReturnFilterSortChangeObserver);
        this.parentViewModel.getIrtSortOption().removeObserver(this.irtSortOptionChangeObserver);
        super.onCleared();
    }

    private final void wireDataChangeListeners() {
        this.parentViewModel.getIrtFilterList().observeForever(this.onwardReturnFilterSortChangeObserver);
        this.parentViewModel.getIrtSortOption().observeForever(this.irtSortOptionChangeObserver);
    }

    /* access modifiers changed from: private */
    public final void updateSRPCopy() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (f) null, (CoroutineStart) null, new IRTViewModel$updateSRPCopy$1(this, BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (f) null, (CoroutineStart) null, new IRTViewModel$updateSRPCopy$delayTask$1((d) null), 3, (Object) null), (d) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void updateFlightList() {
        Job a2 = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (f) null, (CoroutineStart) null, new t.f(500, (d) null), 3, (Object) null);
        Calendar instance = Calendar.getInstance();
        k.a((Object) instance, "Calendar.getInstance()");
        long timeInMillis = instance.getTimeInMillis();
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (f) null, (CoroutineStart) null, new IRTViewModel$updateFlightList$1(this, a2, timeInMillis, (d) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void sortFlightList() {
        Job a2 = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (f) null, (CoroutineStart) null, new t.f(500, (d) null), 3, (Object) null);
        Calendar instance = Calendar.getInstance();
        k.a((Object) instance, "Calendar.getInstance()");
        long timeInMillis = instance.getTimeInMillis();
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (f) null, (CoroutineStart) null, new IRTViewModel$sortFlightList$1(this, a2, timeInMillis, (d) null), 3, (Object) null);
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

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005d, code lost:
        if (r2.size() <= 1) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0074, code lost:
        if (r1.size() > 1) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0076, code lost:
        r5.parentViewModel.getIrtSplitViewFlightItem().setValue(r0);
        attachIntSearchListFragment();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0082, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onFlightItemClick(com.travel.flight.pojo.flightticket.CJRIntlFlightList r6) {
        /*
            r5 = this;
            java.lang.String r0 = "flightInfo"
            kotlin.g.b.k.c(r6, r0)
            com.travel.flight.pojo.flightticket.CJRIntlFlightMapping r0 = r6.getmFlightMapping()
            r1 = 0
            if (r0 == 0) goto L_0x0044
            com.travel.flight.pojo.flightticket.CJRIntlFlightMapping r0 = r6.getmFlightMapping()
            java.lang.String r2 = "flightInfo.getmFlightMapping()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            boolean r0 = r0.isParent()
            if (r0 == 0) goto L_0x0044
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r0 = r5.parentViewModel
            androidx.lifecycle.y r0 = r0.getCopiedSrpResult()
            java.lang.Object r0 = r0.getValue()
            if (r0 != 0) goto L_0x002a
            kotlin.g.b.k.a()
        L_0x002a:
            com.travel.flight.pojo.flightticket.CJRFlightSearchResult r0 = (com.travel.flight.pojo.flightticket.CJRFlightSearchResult) r0
            com.travel.flight.pojo.flightticket.CJRIntlFlightMapping r3 = r6.getmFlightMapping()
            com.travel.flight.pojo.flightticket.CJRIntlFlightMapping r4 = r6.getmFlightMapping()
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r2)
            com.travel.flight.pojo.flightticket.CJRIntlFlightPricing r2 = r4.getPricing()
            com.travel.flight.pojo.flightticket.CJRIntlFlightMapping r4 = r6.getmFlightMapping()
            com.travel.flight.pojo.flightticket.CJRIntlFlightList r0 = r0.getChildForParentInternationalList(r3, r2, r4)
            goto L_0x0045
        L_0x0044:
            r0 = r1
        L_0x0045:
            if (r0 == 0) goto L_0x004c
            java.util.ArrayList r2 = r0.getmIntOnwardFlightList()
            goto L_0x004d
        L_0x004c:
            r2 = r1
        L_0x004d:
            r3 = 1
            if (r2 == 0) goto L_0x005f
            java.util.ArrayList r2 = r0.getmIntOnwardFlightList()
            if (r2 != 0) goto L_0x0059
            kotlin.g.b.k.a()
        L_0x0059:
            int r2 = r2.size()
            if (r2 > r3) goto L_0x0076
        L_0x005f:
            if (r0 == 0) goto L_0x0065
            java.util.ArrayList r1 = r0.getmIntReturnFlightList()
        L_0x0065:
            if (r1 == 0) goto L_0x0083
            java.util.ArrayList r1 = r0.getmIntReturnFlightList()
            if (r1 != 0) goto L_0x0070
            kotlin.g.b.k.a()
        L_0x0070:
            int r1 = r1.size()
            if (r1 <= r3) goto L_0x0083
        L_0x0076:
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r6 = r5.parentViewModel
            androidx.lifecycle.y r6 = r6.getIrtSplitViewFlightItem()
            r6.setValue(r0)
            r5.attachIntSearchListFragment()
            return
        L_0x0083:
            boolean r0 = r5.checkForOverlapFourHourDiff(r6)
            if (r0 == 0) goto L_0x008c
            r5.proceedToBook(r6)
        L_0x008c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightSRPV2.viewModel.IRTViewModel.onFlightItemClick(com.travel.flight.pojo.flightticket.CJRIntlFlightList):void");
    }

    private final boolean checkForOverlapFourHourDiff(CJRIntlFlightList cJRIntlFlightList) {
        boolean checkFlightOverlaps = checkFlightOverlaps(cJRIntlFlightList.getmOnwardFlights(), cJRIntlFlightList.getmReturnFlights(), false);
        boolean checkFlightOverFourHourDifference = checkFlightOverFourHourDifference(cJRIntlFlightList.getmOnwardFlights(), cJRIntlFlightList.getmReturnFlights());
        if (checkFlightOverlaps) {
            this.parentViewModel.getDialogEvent().setValue(new b(Integer.valueOf(R.string.flight_overlap_info_title), Integer.valueOf(R.string.flight_overlap_info)));
            return false;
        } else if (!checkFlightOverFourHourDifference) {
            return true;
        } else {
            this.parentViewModel.getDialogEvent().setValue(new b(Integer.valueOf(R.string.flight_overlap_info_title), Integer.valueOf(R.string.flight_four_hour_diff)));
            return false;
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
            com.paytm.utility.q.b(e2.getMessage());
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
            com.paytm.utility.q.b(e2.getMessage());
            return false;
        }
    }

    private final void proceedToBook(CJRIntlFlightList cJRIntlFlightList) {
        ArrayList<CJRFlightStops> arrayList;
        ArrayList<CJRFlightStops> arrayList2;
        CJRFlightPrice cJRFlightPrice;
        CJRFlightPrice cJRFlightPrice2;
        CJRIntlFlightMapping cJRIntlFlightMapping = cJRIntlFlightList.getmFlightMapping();
        k.a((Object) cJRIntlFlightMapping, "flightInfo.getmFlightMapping()");
        boolean isStitched = cJRIntlFlightMapping.isStitched();
        CJRFlightDetails cJRFlightDetails = new CJRFlightDetails();
        CJRFlightSearchResult value = this.parentViewModel.getSrpResult().getValue();
        if (value == null) {
            k.a();
        }
        cJRFlightDetails.setmMetaDetails(value.getmMetaDetails());
        cJRFlightDetails.setPaytmStiched(isStitched);
        cJRFlightDetails.setmOnwardJourney(cJRIntlFlightList.getmOnwardFlights());
        CJRFlightDetailsItem cJRFlightDetailsItem = cJRIntlFlightList.getmOnwardFlights();
        k.a((Object) cJRFlightDetailsItem, "flightInfo.getmOnwardFlights()");
        cJRFlightDetails.setOnwardMealsAvailable(cJRFlightDetailsItem.getMealsAvaialable());
        cJRFlightDetails.setmReturnJourney(cJRIntlFlightList.getmReturnFlights());
        CJRFlightDetailsItem cJRFlightDetailsItem2 = cJRIntlFlightList.getmReturnFlights();
        k.a((Object) cJRFlightDetailsItem2, "flightInfo.getmReturnFlights()");
        cJRFlightDetails.setReturnMealsAvailable(cJRFlightDetailsItem2.getMealsAvaialable());
        if (!(cJRIntlFlightList.getmOnwardFlights() == null || cJRIntlFlightList.getmOnwardFlights().getmPrice() == null)) {
            if (cJRIntlFlightList.getmOnwardFlights().getmServiceProviderSelected() != null) {
                cJRFlightPrice2 = cJRIntlFlightList.getmOnwardFlights().getmServiceProviderSelected();
            } else {
                cJRFlightPrice2 = cJRIntlFlightList.getmOnwardFlights().getmPrice().get(0);
            }
            cJRFlightDetails.setmOnwardServiceProvider(cJRFlightPrice2.getmServiceProvider());
        }
        if (!(cJRIntlFlightList.getmReturnFlights() == null || cJRIntlFlightList.getmReturnFlights().getmPrice() == null)) {
            if (cJRIntlFlightList.getmReturnFlights().getmServiceProviderSelected() != null) {
                cJRFlightPrice = cJRIntlFlightList.getmReturnFlights().getmServiceProviderSelected();
            } else {
                cJRFlightPrice = cJRIntlFlightList.getmReturnFlights().getmPrice().get(0);
            }
            cJRFlightDetails.setmReturnServiceProvider(cJRFlightPrice.getmServiceProvider());
        }
        CJRFlightSearchResult value2 = this.parentViewModel.getCopiedSrpResult().getValue();
        if (value2 == null) {
            k.a();
        }
        sendServiceProviderList(value2.getmOnwardReturnFlights().getmOnwardFlights());
        CJRFlightSearchResult value3 = this.parentViewModel.getCopiedSrpResult().getValue();
        if (value3 == null) {
            k.a();
        }
        sendServiceProviderList(value3.getmOnwardReturnFlights().getmReturnFlights());
        String str = cJRFlightDetails.isPaytmStiched() ? "regular" : "combination";
        Bundle bundle = new Bundle();
        bundle.putSerializable("acceptType", str);
        bundle.putSerializable("intent_extra_review_data", cJRFlightDetails);
        CJRFlightSearchInput value4 = this.parentViewModel.getSearchInput().getValue();
        if (value4 == null) {
            k.a();
        }
        bundle.putSerializable("intent_extra_search_input_data", value4);
        bundle.putSerializable("intent_extra_trip_type", "round_trip");
        CJRFlightDetailsItem cJRFlightDetailsItem3 = cJRIntlFlightList.getmOnwardFlights();
        Integer num = null;
        Integer valueOf = (cJRFlightDetailsItem3 == null || (arrayList2 = cJRFlightDetailsItem3.getmFlights()) == null) ? null : Integer.valueOf(arrayList2.size());
        if (valueOf == null) {
            k.a();
        }
        if (valueOf.intValue() > 0) {
            CJRFlightDetailsItem cJRFlightDetailsItem4 = cJRIntlFlightList.getmReturnFlights();
            if (!(cJRFlightDetailsItem4 == null || (arrayList = cJRFlightDetailsItem4.getmFlights()) == null)) {
                num = Integer.valueOf(arrayList.size());
            }
            if (num == null) {
                k.a();
            }
            if (num.intValue() > 0) {
                this.parentViewModel.sendPulseEventFlightSelected("Onward{" + cJRIntlFlightList.getmOnwardFlights().getmAirLineCode() + ' ' + cJRIntlFlightList.getmOnwardFlights().getmFlights().get(0).getmFlightNumber() + "}, Return{" + cJRIntlFlightList.getmReturnFlights().getmAirLineCode() + ' ' + cJRIntlFlightList.getmReturnFlights().getmFlights().get(0).getmFlightNumber() + '}');
            }
        }
        this.parentViewModel.navigate(new a("PAGE_REVIEW_ITINERARY", bundle));
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

    private final void attachIntSearchListFragment() {
        this.parentViewModel.navigate(new c("PAGE_INTERNATIONAL_FLIGHT_LIST", (e) null, R.id.container_child, true, this.INT_SEARCH_LIST_BACK_STACK_TAG));
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final void setFlightName(TextView textView, CJRIntlFlightList cJRIntlFlightList) {
            k.c(textView, "textView");
            if ((cJRIntlFlightList != null ? cJRIntlFlightList.getmOnwardFlights() : null) != null && cJRIntlFlightList.getmReturnFlights() != null) {
                if (p.a(cJRIntlFlightList.getmOnwardFlights().getmAirLine(), cJRIntlFlightList.getmReturnFlights().getmAirLine(), true)) {
                    textView.setText(cJRIntlFlightList.getmOnwardFlights().getmAirLine());
                    return;
                }
                textView.setText(cJRIntlFlightList.getmOnwardFlights().getmAirLine() + ", " + cJRIntlFlightList.getmReturnFlights().getmAirLine());
            }
        }

        public final void setFlightFare(TextView textView, CJRIntlFlightList cJRIntlFlightList) {
            k.c(textView, "textView");
            if ((cJRIntlFlightList != null ? cJRIntlFlightList.getmDisplayPrice() : null) != null) {
                textView.setText(com.travel.flight.utils.c.h(cJRIntlFlightList.getmDisplayPrice()));
            } else {
                textView.setText("");
            }
        }

        public final void setRefundableText(TextView textView, CJRIntlFlightList cJRIntlFlightList) {
            k.c(textView, "textView");
            if (!(cJRIntlFlightList == null || cJRIntlFlightList.getMappedPrice() == null)) {
                CJRIntlFlightPricing mappedPrice = cJRIntlFlightList.getMappedPrice();
                k.a((Object) mappedPrice, "flightInfo.mappedPrice");
                if (mappedPrice.isRefundable()) {
                    CJRIntlFlightPricing mappedPrice2 = cJRIntlFlightList.getMappedPrice();
                    k.a((Object) mappedPrice2, "flightInfo.mappedPrice");
                    if (mappedPrice2.getRefundable_text() != null) {
                        textView.setVisibility(0);
                        CJRIntlFlightPricing mappedPrice3 = cJRIntlFlightList.getMappedPrice();
                        k.a((Object) mappedPrice3, "flightInfo.mappedPrice");
                        textView.setText(mappedPrice3.getRefundable_text());
                        return;
                    }
                }
            }
            textView.setVisibility(8);
        }

        public final void setAirlineCode(TextView textView, CJRFlightDetailsItem cJRFlightDetailsItem) {
            String str;
            k.c(textView, "textView");
            if (cJRFlightDetailsItem != null) {
                if (cJRFlightDetailsItem.getmFlights() == null || cJRFlightDetailsItem.getmFlights().size() <= 0) {
                    str = "";
                } else {
                    str = " - " + cJRFlightDetailsItem.getmFlights().get(0).getmFlightNumber();
                }
                textView.setText(cJRFlightDetailsItem.getmAirLineCode() + str);
            }
        }

        public final void setDepartureCityName(TextView textView, CJRFlightDetailsItem cJRFlightDetailsItem) {
            k.c(textView, "textView");
            if (cJRFlightDetailsItem != null) {
                CJRFlightStops cJRFlightStops = cJRFlightDetailsItem.getmFlights().get(0);
                k.a((Object) cJRFlightStops, "flightInfo.getmFlights()…stants.FLIGHT_CONSTANT_0]");
                textView.setText(cJRFlightStops.getOriginCity());
            }
        }

        public final void setArrivalCityName(TextView textView, CJRFlightDetailsItem cJRFlightDetailsItem) {
            k.c(textView, "textView");
            if (cJRFlightDetailsItem != null) {
                CJRFlightStops cJRFlightStops = cJRFlightDetailsItem.getmFlights().get(cJRFlightDetailsItem.getmFlights().size() - 1);
                k.a((Object) cJRFlightStops, "flightInfo.getmFlights()…stants.FLIGHT_CONSTANT_1]");
                textView.setText(cJRFlightStops.getDestinationCity());
            }
        }

        public final void setHopText(TextView textView, CJRFlightDetailsItem cJRFlightDetailsItem) {
            k.c(textView, "textView");
            if (cJRFlightDetailsItem != null && cJRFlightDetailsItem.getmFlights().size() > 0) {
                int size = cJRFlightDetailsItem.getmFlights().size();
                if (size == 1) {
                    textView.setText(textView.getContext().getString(R.string.internation_non_stop_flight));
                } else if (size != 2) {
                    textView.setText(textView.getContext().getString(R.string.international_multi_hop, new Object[]{Integer.valueOf(cJRFlightDetailsItem.getmFlights().size() - 1)}));
                } else {
                    textView.setText(com.travel.flight.c.d.a.a(cJRFlightDetailsItem));
                }
            }
        }

        public final void setOneStopView(View view, CJRFlightDetailsItem cJRFlightDetailsItem) {
            k.c(view, "view");
            if (cJRFlightDetailsItem != null && cJRFlightDetailsItem.getmFlights().size() > 0) {
                int size = cJRFlightDetailsItem.getmFlights().size();
                if (size == 2) {
                    view.setVisibility(0);
                } else if (size != 3) {
                    view.setVisibility(8);
                } else {
                    view.setVisibility(4);
                }
            }
        }

        public final void setTwoStopView(View view, CJRFlightDetailsItem cJRFlightDetailsItem) {
            k.c(view, "view");
            if (cJRFlightDetailsItem != null && cJRFlightDetailsItem.getmFlights().size() > 0) {
                int size = cJRFlightDetailsItem.getmFlights().size();
                if (size == 2) {
                    view.setVisibility(8);
                } else if (size != 3) {
                    view.setVisibility(8);
                } else {
                    view.setVisibility(0);
                }
            }
        }

        public final void setAirlineLogo(ImageView imageView, CJRFlightDetailsItem cJRFlightDetailsItem) {
            k.c(imageView, "imageView");
            if ((cJRFlightDetailsItem != null ? cJRFlightDetailsItem.getmAirLineCode() : null) != null) {
                imageView.setVisibility(0);
                com.travel.flight.utils.c.a(cJRFlightDetailsItem.getmAirLineCode(), imageView);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0054, code lost:
            if (r7.size() <= 1) goto L_0x0056;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x006b, code lost:
            if (r7.size() > 1) goto L_0x006d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x006d, code lost:
            r6 = (r6.getmIntOnwardFlightList().size() * r6.getmIntReturnFlightList().size()) - 1;
         */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x003d  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0042  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0047  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0058  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x005e  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x0085  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x0089  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void setMoreOptionView(androidx.cardview.widget.CardView r5, com.travel.flight.pojo.flightticket.CJRIntlFlightList r6, com.travel.flight.pojo.flightticket.CJRFlightSearchResult r7) {
            /*
                r4 = this;
                java.lang.String r0 = "cardView"
                kotlin.g.b.k.c(r5, r0)
                r0 = 0
                if (r6 == 0) goto L_0x003a
                com.travel.flight.pojo.flightticket.CJRIntlFlightMapping r1 = r6.getmFlightMapping()
                if (r1 == 0) goto L_0x003a
                com.travel.flight.pojo.flightticket.CJRIntlFlightMapping r1 = r6.getmFlightMapping()
                java.lang.String r2 = "flightInfo.getmFlightMapping()"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
                boolean r1 = r1.isParent()
                if (r1 == 0) goto L_0x003a
                if (r7 != 0) goto L_0x0022
                kotlin.g.b.k.a()     // Catch:{ Exception -> 0x003a }
            L_0x0022:
                com.travel.flight.pojo.flightticket.CJRIntlFlightMapping r1 = r6.getmFlightMapping()     // Catch:{ Exception -> 0x003a }
                com.travel.flight.pojo.flightticket.CJRIntlFlightMapping r3 = r6.getmFlightMapping()     // Catch:{ Exception -> 0x003a }
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r2)     // Catch:{ Exception -> 0x003a }
                com.travel.flight.pojo.flightticket.CJRIntlFlightPricing r2 = r3.getPricing()     // Catch:{ Exception -> 0x003a }
                com.travel.flight.pojo.flightticket.CJRIntlFlightMapping r6 = r6.getmFlightMapping()     // Catch:{ Exception -> 0x003a }
                com.travel.flight.pojo.flightticket.CJRIntlFlightList r6 = r7.getChildForParentInternationalList(r1, r2, r6)     // Catch:{ Exception -> 0x003a }
                goto L_0x003b
            L_0x003a:
                r6 = r0
            L_0x003b:
                if (r6 == 0) goto L_0x0042
                java.util.ArrayList r7 = r6.getmIntOnwardFlightList()
                goto L_0x0043
            L_0x0042:
                r7 = r0
            L_0x0043:
                r1 = 0
                r2 = 1
                if (r7 == 0) goto L_0x0056
                java.util.ArrayList r7 = r6.getmIntOnwardFlightList()
                if (r7 != 0) goto L_0x0050
                kotlin.g.b.k.a()
            L_0x0050:
                int r7 = r7.size()
                if (r7 > r2) goto L_0x006d
            L_0x0056:
                if (r6 == 0) goto L_0x005c
                java.util.ArrayList r0 = r6.getmIntReturnFlightList()
            L_0x005c:
                if (r0 == 0) goto L_0x0082
                java.util.ArrayList r7 = r6.getmIntReturnFlightList()
                if (r7 != 0) goto L_0x0067
                kotlin.g.b.k.a()
            L_0x0067:
                int r7 = r7.size()
                if (r7 <= r2) goto L_0x0082
            L_0x006d:
                java.util.ArrayList r7 = r6.getmIntOnwardFlightList()
                int r7 = r7.size()
                java.util.ArrayList r6 = r6.getmIntReturnFlightList()
                int r6 = r6.size()
                int r7 = r7 * r6
                int r6 = r7 + -1
                goto L_0x0083
            L_0x0082:
                r6 = 0
            L_0x0083:
                if (r6 <= 0) goto L_0x0089
                r5.setVisibility(r1)
                return
            L_0x0089:
                r6 = 8
                r5.setVisibility(r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightSRPV2.viewModel.IRTViewModel.Companion.setMoreOptionView(androidx.cardview.widget.CardView, com.travel.flight.pojo.flightticket.CJRIntlFlightList, com.travel.flight.pojo.flightticket.CJRFlightSearchResult):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0055, code lost:
            if (r7.size() <= 1) goto L_0x0057;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x006c, code lost:
            if (r7.size() > 1) goto L_0x006e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x006e, code lost:
            r6 = (r6.getmIntOnwardFlightList().size() * r6.getmIntReturnFlightList().size()) - 1;
         */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x003e  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0043  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0048  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0059  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x005f  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x0086  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x00b0  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void setMoreOptionViewText(android.widget.TextView r5, com.travel.flight.pojo.flightticket.CJRIntlFlightList r6, com.travel.flight.pojo.flightticket.CJRFlightSearchResult r7) {
            /*
                r4 = this;
                java.lang.String r0 = "textView"
                kotlin.g.b.k.c(r5, r0)
                r0 = 0
                if (r6 == 0) goto L_0x003b
                com.travel.flight.pojo.flightticket.CJRIntlFlightMapping r1 = r6.getmFlightMapping()
                if (r1 == 0) goto L_0x003b
                com.travel.flight.pojo.flightticket.CJRIntlFlightMapping r1 = r6.getmFlightMapping()
                java.lang.String r2 = "flightInfo.getmFlightMapping()"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
                boolean r1 = r1.isParent()
                if (r1 == 0) goto L_0x003b
                if (r7 != 0) goto L_0x0023
                kotlin.g.b.k.a()     // Catch:{ Exception -> 0x003b }
            L_0x0023:
                com.travel.flight.pojo.flightticket.CJRIntlFlightMapping r1 = r6.getmFlightMapping()     // Catch:{ Exception -> 0x003b }
                com.travel.flight.pojo.flightticket.CJRIntlFlightMapping r3 = r6.getmFlightMapping()     // Catch:{ Exception -> 0x003b }
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r2)     // Catch:{ Exception -> 0x003b }
                com.travel.flight.pojo.flightticket.CJRIntlFlightPricing r2 = r3.getPricing()     // Catch:{ Exception -> 0x003b }
                com.travel.flight.pojo.flightticket.CJRIntlFlightMapping r6 = r6.getmFlightMapping()     // Catch:{ Exception -> 0x003b }
                com.travel.flight.pojo.flightticket.CJRIntlFlightList r6 = r7.getChildForParentInternationalList(r1, r2, r6)     // Catch:{ Exception -> 0x003b }
                goto L_0x003c
            L_0x003b:
                r6 = r0
            L_0x003c:
                if (r6 == 0) goto L_0x0043
                java.util.ArrayList r7 = r6.getmIntOnwardFlightList()
                goto L_0x0044
            L_0x0043:
                r7 = r0
            L_0x0044:
                r1 = 0
                r2 = 1
                if (r7 == 0) goto L_0x0057
                java.util.ArrayList r7 = r6.getmIntOnwardFlightList()
                if (r7 != 0) goto L_0x0051
                kotlin.g.b.k.a()
            L_0x0051:
                int r7 = r7.size()
                if (r7 > r2) goto L_0x006e
            L_0x0057:
                if (r6 == 0) goto L_0x005d
                java.util.ArrayList r0 = r6.getmIntReturnFlightList()
            L_0x005d:
                if (r0 == 0) goto L_0x0083
                java.util.ArrayList r7 = r6.getmIntReturnFlightList()
                if (r7 != 0) goto L_0x0068
                kotlin.g.b.k.a()
            L_0x0068:
                int r7 = r7.size()
                if (r7 <= r2) goto L_0x0083
            L_0x006e:
                java.util.ArrayList r7 = r6.getmIntOnwardFlightList()
                int r7 = r7.size()
                java.util.ArrayList r6 = r6.getmIntReturnFlightList()
                int r6 = r6.size()
                int r7 = r7 * r6
                int r6 = r7 + -1
                goto L_0x0084
            L_0x0083:
                r6 = 0
            L_0x0084:
                if (r6 <= 0) goto L_0x00b0
                r5.setVisibility(r1)
                if (r6 <= r2) goto L_0x00a0
                android.content.Context r7 = r5.getContext()
                int r0 = com.travel.flight.R.string.internation_flight_options
                java.lang.Object[] r2 = new java.lang.Object[r2]
                java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
                r2[r1] = r6
                java.lang.String r6 = r7.getString(r0, r2)
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                goto L_0x00ac
            L_0x00a0:
                android.content.Context r6 = r5.getContext()
                int r7 = com.travel.flight.R.string.internation_flight_option
                java.lang.String r6 = r6.getString(r7)
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            L_0x00ac:
                r5.setText(r6)
                return
            L_0x00b0:
                r6 = 8
                r5.setVisibility(r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightSRPV2.viewModel.IRTViewModel.Companion.setMoreOptionViewText(android.widget.TextView, com.travel.flight.pojo.flightticket.CJRIntlFlightList, com.travel.flight.pojo.flightticket.CJRFlightSearchResult):void");
        }
    }
}
