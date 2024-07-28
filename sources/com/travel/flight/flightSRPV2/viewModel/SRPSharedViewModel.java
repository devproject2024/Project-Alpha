package com.travel.flight.flightSRPV2.viewModel;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.a;
import androidx.lifecycle.y;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.sendbird.android.constant.StringSet;
import com.travel.flight.R;
import com.travel.flight.flightSRPV2.a.ad;
import com.travel.flight.flightSRPV2.a.ae;
import com.travel.flight.flightSRPV2.a.ag;
import com.travel.flight.flightSRPV2.a.h;
import com.travel.flight.flightSRPV2.a.l;
import com.travel.flight.flightSRPV2.a.n;
import com.travel.flight.flightSRPV2.a.p;
import com.travel.flight.flightSRPV2.a.r;
import com.travel.flight.flightSRPV2.a.t;
import com.travel.flight.flightSRPV2.a.u;
import com.travel.flight.flightSRPV2.a.x;
import com.travel.flight.flightSRPV2.a.y;
import com.travel.flight.flightSRPV2.a.z;
import com.travel.flight.flightSRPV2.b.d;
import com.travel.flight.flightSRPV2.b.e;
import com.travel.flight.flightSRPV2.view.ui.activity.FlightSRPV2Activity;
import com.travel.flight.pojo.flightticket.CJRAirlinesSrpAnalytics;
import com.travel.flight.pojo.flightticket.CJRFareAlertsSubscribeResponse;
import com.travel.flight.pojo.flightticket.CJRFlightCalendarPriceModel;
import com.travel.flight.pojo.flightticket.CJRFlightDetailsItem;
import com.travel.flight.pojo.flightticket.CJRFlightPromoCodeErrorStatus;
import com.travel.flight.pojo.flightticket.CJRFlightPromocodeErrorMessage;
import com.travel.flight.pojo.flightticket.CJRFlightSRPBody;
import com.travel.flight.pojo.flightticket.CJRFlightSearchInput;
import com.travel.flight.pojo.flightticket.CJRFlightSearchResult;
import com.travel.flight.pojo.flightticket.CJRIntlFlightList;
import com.travel.flight.pojo.flightticket.CJRMetadetails;
import com.travel.flight.pojo.flightticket.CJROnwardFlights;
import com.travel.flight.pojo.flightticket.CJROnwardReturnFlightInformation;
import com.travel.flight.pojo.flightticket.CJRPromocodeErrorResponse;
import com.travel.flight.utils.c;
import com.travel.flight.utils.j;
import com.travel.model.CalendarDatePriceInfo;
import com.travel.model.CalendarPriceModel;
import com.travel.utils.m;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.d.f;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.upi.common.upi.CommonPayParams;

public final class SRPSharedViewModel extends a implements b, z {
    private final y<CalendarPriceModel> calendarPriceInfo = new y<>();
    private final y<CJRFlightSearchInput> copiedSearchInput = new y<>();
    private final y<CJRFlightSearchResult> copiedSrpResult = new y<>();
    private final y<String> dataDisplayErrorEvent = new y<>();
    private final y<u> defaultOnwardFilterInfo = new y<>();
    private final y<u> defaultReturnFilterInfo = new y<>();
    private final y<com.travel.flight.flightSRPV2.b.b<Object, Object>> dialogEvent = new y<>();
    private final com.travel.flight.flightSRPV2.c.b<l> fareAlertEvent = new com.travel.flight.flightSRPV2.c.b<>();
    private final y<List<x>> irtFilterList = new y<>();
    private final y<ae> irtSortOption = new y<>();
    private final y<CJRIntlFlightList> irtSplitViewFlightItem = new y<>();
    private boolean isDeeplinkFilterApplied;
    private final y<Boolean> isFareAlertSelectable = new y<>();
    private final y<Boolean> isFareAlertSelected = new y<>();
    private boolean isSecondaryRefreshAPIRequest;
    private final y<Boolean> isSortFragmentAttached = new y<>();
    private final y<Boolean> isToolTipHidden = new y<>();
    private final y<d> navigator = new y<>();
    private final com.travel.flight.flightSRPV2.c.b<kotlin.x> onBackPressedEvent;
    private final y<ae> oneWaySortOption = new y<>();
    private final y<List<x>> onwardFilterList = new y<>();
    private boolean onwardSortApplied;
    private final com.travel.flight.flightSRPV2.c.b<OpenCalendar> openCalendarEvent = new com.travel.flight.flightSRPV2.c.b<>();
    private final y<Integer> progressState = new y<>();
    private final y<List<x>> returnFilterList = new y<>();
    private boolean returnSortApplied;
    private final y<ae> roundTripOnwardSortOption = new y<>();
    private final y<ae> roundTripReturnSortOption = new y<>();
    private final y<CJRFlightSearchInput> searchInput = new y<>();
    private Job secondaryRefreshAPITask;
    private final y<ad> secondarySrpResult = new y<>();
    private final y<String> selectedOnwardDate = new y<>();
    private final com.travel.flight.flightSRPV2.c.b<kotlin.x> setResultListener = new com.travel.flight.flightSRPV2.c.b<>();
    private final y<Boolean> showFareCalenderIcon = new y<>();
    private final y<Boolean> showSortFilterIcon = new y<>();
    private final y<CJRFlightSearchResult> srpResult = new y<>();
    private final com.travel.flight.flightSRPV2.c.b<String> toastMessageEvent = new com.travel.flight.flightSRPV2.c.b<>();
    private final com.travel.flight.flightSRPV2.c.b<List<ag>> toolTipMessagesEvent = new com.travel.flight.flightSRPV2.c.b<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SRPSharedViewModel(Application application) {
        super(application);
        k.c(application, AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        setProgressState(0);
        this.searchInput.observeForever(new androidx.lifecycle.z<CJRFlightSearchInput>(this) {
            final /* synthetic */ SRPSharedViewModel this$0;

            {
                this.this$0 = r1;
            }

            public final void onChanged(CJRFlightSearchInput cJRFlightSearchInput) {
                this.this$0.getSelectedOnwardDate().setValue(cJRFlightSearchInput != null ? cJRFlightSearchInput.getDate() : null);
            }
        });
        this.onwardFilterList.setValue(new ArrayList());
        this.returnFilterList.setValue(new ArrayList());
        this.irtFilterList.setValue(new ArrayList());
        this.roundTripOnwardSortOption.setValue(new p((byte) 0));
        this.roundTripReturnSortOption.setValue(new p((byte) 0));
        this.onBackPressedEvent = new com.travel.flight.flightSRPV2.c.b<>();
    }

    public final com.travel.flight.flightSRPV2.c.b<OpenCalendar> getOpenCalendarEvent() {
        return this.openCalendarEvent;
    }

    public final y<com.travel.flight.flightSRPV2.b.b<Object, Object>> getDialogEvent() {
        return this.dialogEvent;
    }

    public final y<String> getDataDisplayErrorEvent() {
        return this.dataDisplayErrorEvent;
    }

    public final com.travel.flight.flightSRPV2.c.b<String> getToastMessageEvent() {
        return this.toastMessageEvent;
    }

    public final com.travel.flight.flightSRPV2.c.b<List<ag>> getToolTipMessagesEvent() {
        return this.toolTipMessagesEvent;
    }

    public final y<Boolean> isToolTipHidden() {
        return this.isToolTipHidden;
    }

    public final y<CJRFlightSearchInput> getSearchInput() {
        return this.searchInput;
    }

    public final y<CJRFlightSearchInput> getCopiedSearchInput() {
        return this.copiedSearchInput;
    }

    public final y<CJRIntlFlightList> getIrtSplitViewFlightItem() {
        return this.irtSplitViewFlightItem;
    }

    public final y<CJRFlightSearchResult> getCopiedSrpResult() {
        return this.copiedSrpResult;
    }

    public final y<CJRFlightSearchResult> getSrpResult() {
        return this.srpResult;
    }

    public final y<ad> getSecondarySrpResult() {
        return this.secondarySrpResult;
    }

    public final y<List<x>> getOnwardFilterList() {
        return this.onwardFilterList;
    }

    public final y<List<x>> getReturnFilterList() {
        return this.returnFilterList;
    }

    public final y<List<x>> getIrtFilterList() {
        return this.irtFilterList;
    }

    public final y<u> getDefaultOnwardFilterInfo() {
        return this.defaultOnwardFilterInfo;
    }

    public final y<u> getDefaultReturnFilterInfo() {
        return this.defaultReturnFilterInfo;
    }

    public final y<ae> getRoundTripOnwardSortOption() {
        return this.roundTripOnwardSortOption;
    }

    public final y<ae> getRoundTripReturnSortOption() {
        return this.roundTripReturnSortOption;
    }

    public final y<ae> getIrtSortOption() {
        return this.irtSortOption;
    }

    public final y<ae> getOneWaySortOption() {
        return this.oneWaySortOption;
    }

    public final y<CalendarPriceModel> getCalendarPriceInfo() {
        return this.calendarPriceInfo;
    }

    public final y<String> getSelectedOnwardDate() {
        return this.selectedOnwardDate;
    }

    public final y<Boolean> getShowSortFilterIcon() {
        return this.showSortFilterIcon;
    }

    public final y<Boolean> getShowFareCalenderIcon() {
        return this.showFareCalenderIcon;
    }

    public final y<Boolean> isSortFragmentAttached() {
        return this.isSortFragmentAttached;
    }

    public final y<Boolean> isFareAlertSelectable() {
        return this.isFareAlertSelectable;
    }

    public final y<Boolean> isFareAlertSelected() {
        return this.isFareAlertSelected;
    }

    public final com.travel.flight.flightSRPV2.c.b<l> getFareAlertEvent() {
        return this.fareAlertEvent;
    }

    public final LiveData<kotlin.x> getSetResultListener() {
        com.travel.flight.flightSRPV2.c.b<kotlin.x> bVar = this.setResultListener;
        if (bVar != null) {
            return bVar;
        }
        throw new kotlin.u("null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Unit>");
    }

    public final LiveData<Integer> getProgressState() {
        y<Integer> yVar = this.progressState;
        if (yVar != null) {
            return yVar;
        }
        throw new kotlin.u("null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Int>");
    }

    public final boolean isDeeplinkFilterApplied() {
        return this.isDeeplinkFilterApplied;
    }

    public final void setDeeplinkFilterApplied(boolean z) {
        this.isDeeplinkFilterApplied = z;
    }

    public final LiveData<kotlin.x> getOnBackPressedEvent() {
        com.travel.flight.flightSRPV2.c.b<kotlin.x> bVar = this.onBackPressedEvent;
        if (bVar != null) {
            return bVar;
        }
        throw new kotlin.u("null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Unit>");
    }

    public final void initData(Intent intent) {
        k.c(intent, "intent");
        y<CJRFlightSearchInput> yVar = this.searchInput;
        j.a aVar = j.f25593a;
        yVar.setValue(j.a.a(intent));
        y<CJRFlightSearchInput> yVar2 = this.copiedSearchInput;
        j.a aVar2 = j.f25593a;
        yVar2.setValue(j.a.a(intent));
    }

    public final LiveData<d> getNavigator() {
        y<d> yVar = this.navigator;
        if (yVar != null) {
            return yVar;
        }
        throw new kotlin.u("null cannot be cast to non-null type androidx.lifecycle.LiveData<com.travel.flight.flightSRPV2.navigation.NavigationParams>");
    }

    public final String getFareDisclaimer(int i2, int i3, int i4) {
        return c.a((Context) getApplication());
    }

    public final synchronized void setProgressState(int i2) {
        Integer value = this.progressState.getValue();
        if (value != null) {
            if (value.intValue() == i2) {
                return;
            }
        }
        if (value != null) {
            if (!(value.intValue() == 0 || i2 == 0 || value.intValue() == i2)) {
                this.progressState.postValue(0);
            }
        }
        this.progressState.postValue(Integer.valueOf(i2));
    }

    public final void navigate(d dVar) {
        k.c(dVar, "params");
        this.navigator.postValue(dVar);
    }

    public final boolean isRoundTrip() {
        CJRFlightSearchInput value = this.searchInput.getValue();
        if (value == null) {
            k.a();
        }
        k.a((Object) value, "this.searchInput.value!!");
        return value.getReturnDate() != null;
    }

    public final boolean isSortFilterEnable() {
        CJRFlightSearchInput value = this.searchInput.getValue();
        if (value == null) {
            k.a();
        }
        k.a((Object) value, "searchInput.value!!");
        if (value.getBookingSegment() == null) {
            return true;
        }
        CJRFlightSearchInput value2 = this.searchInput.getValue();
        if (value2 == null) {
            k.a();
        }
        k.a((Object) value2, "searchInput.value!!");
        return value2.getBookingSegment() != com.travel.flight.flightticket.d.b.Modify;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0171  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void applyFilters(java.util.List<? extends com.travel.flight.flightSRPV2.a.x> r12, java.util.List<? extends com.travel.flight.flightSRPV2.a.x> r13) {
        /*
            r11 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r0 = (java.util.List) r0
            r1 = 0
            r2 = 1
            if (r12 == 0) goto L_0x0046
            androidx.lifecycle.y<com.travel.flight.flightSRPV2.a.u> r3 = r11.defaultOnwardFilterInfo
            java.lang.Object r3 = r3.getValue()
            if (r3 != 0) goto L_0x0016
            kotlin.g.b.k.a()
        L_0x0016:
            java.lang.String r4 = "defaultOnwardFilterInfo.value!!"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            com.travel.flight.flightSRPV2.a.u r3 = (com.travel.flight.flightSRPV2.a.u) r3
            java.util.List r3 = com.travel.flight.flightSRPV2.a.t.a((java.util.List<? extends com.travel.flight.flightSRPV2.a.x>) r12, (com.travel.flight.flightSRPV2.a.u) r3)
            androidx.lifecycle.y<java.util.List<com.travel.flight.flightSRPV2.a.x>> r4 = r11.onwardFilterList
            java.lang.Object r4 = r4.getValue()
            java.util.List r4 = (java.util.List) r4
            if (r4 == 0) goto L_0x0031
            boolean r4 = com.travel.flight.flightSRPV2.a.t.a((java.util.List<? extends com.travel.flight.flightSRPV2.a.x>) r4, (java.util.List<? extends com.travel.flight.flightSRPV2.a.x>) r3, false)
            if (r4 == 0) goto L_0x0046
        L_0x0031:
            androidx.lifecycle.y<java.util.List<com.travel.flight.flightSRPV2.a.x>> r0 = r11.onwardFilterList
            java.util.ArrayList r4 = new java.util.ArrayList
            java.util.Collection r3 = (java.util.Collection) r3
            r4.<init>(r3)
            r0.setValue(r4)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r3)
            java.util.List r0 = (java.util.List) r0
            r3 = 1
            goto L_0x0047
        L_0x0046:
            r3 = 0
        L_0x0047:
            if (r13 == 0) goto L_0x0094
            boolean r4 = r13.isEmpty()
            if (r4 != 0) goto L_0x006f
            androidx.lifecycle.y<com.travel.flight.flightSRPV2.a.u> r4 = r11.defaultReturnFilterInfo
            java.lang.Object r4 = r4.getValue()
            if (r4 != 0) goto L_0x0058
            goto L_0x006f
        L_0x0058:
            androidx.lifecycle.y<com.travel.flight.flightSRPV2.a.u> r4 = r11.defaultReturnFilterInfo
            java.lang.Object r4 = r4.getValue()
            if (r4 != 0) goto L_0x0063
            kotlin.g.b.k.a()
        L_0x0063:
            java.lang.String r5 = "defaultReturnFilterInfo.value!!"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            com.travel.flight.flightSRPV2.a.u r4 = (com.travel.flight.flightSRPV2.a.u) r4
            java.util.List r4 = com.travel.flight.flightSRPV2.a.t.a((java.util.List<? extends com.travel.flight.flightSRPV2.a.x>) r13, (com.travel.flight.flightSRPV2.a.u) r4)
            goto L_0x0070
        L_0x006f:
            r4 = r13
        L_0x0070:
            androidx.lifecycle.y<java.util.List<com.travel.flight.flightSRPV2.a.x>> r5 = r11.returnFilterList
            java.lang.Object r5 = r5.getValue()
            java.util.List r5 = (java.util.List) r5
            if (r5 == 0) goto L_0x0080
            boolean r5 = com.travel.flight.flightSRPV2.a.t.a((java.util.List<? extends com.travel.flight.flightSRPV2.a.x>) r5, (java.util.List<? extends com.travel.flight.flightSRPV2.a.x>) r4, false)
            if (r5 == 0) goto L_0x0094
        L_0x0080:
            androidx.lifecycle.y<java.util.List<com.travel.flight.flightSRPV2.a.x>> r0 = r11.returnFilterList
            java.util.ArrayList r3 = new java.util.ArrayList
            java.util.Collection r4 = (java.util.Collection) r4
            r3.<init>(r4)
            r0.setValue(r3)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r4)
            java.util.List r0 = (java.util.List) r0
            r3 = 1
        L_0x0094:
            if (r3 == 0) goto L_0x00a2
            androidx.lifecycle.y<java.util.List<com.travel.flight.flightSRPV2.a.x>> r3 = r11.irtFilterList
            java.util.ArrayList r4 = new java.util.ArrayList
            java.util.Collection r0 = (java.util.Collection) r0
            r4.<init>(r0)
            r3.setValue(r4)
        L_0x00a2:
            boolean r0 = r11.isRoundTrip()
            if (r0 == 0) goto L_0x00d3
            androidx.lifecycle.y<java.util.List<com.travel.flight.flightSRPV2.a.x>> r0 = r11.onwardFilterList
            java.lang.Object r0 = r0.getValue()
            if (r0 != 0) goto L_0x00b3
            kotlin.g.b.k.a()
        L_0x00b3:
            java.util.List r0 = (java.util.List) r0
            boolean r0 = com.travel.flight.flightSRPV2.a.t.c((java.util.List<? extends com.travel.flight.flightSRPV2.a.x>) r0)
            if (r0 != 0) goto L_0x00d1
            androidx.lifecycle.y<java.util.List<com.travel.flight.flightSRPV2.a.x>> r0 = r11.returnFilterList
            java.lang.Object r0 = r0.getValue()
            if (r0 != 0) goto L_0x00c6
            kotlin.g.b.k.a()
        L_0x00c6:
            java.util.List r0 = (java.util.List) r0
            boolean r0 = com.travel.flight.flightSRPV2.a.t.c((java.util.List<? extends com.travel.flight.flightSRPV2.a.x>) r0)
            if (r0 == 0) goto L_0x00cf
            goto L_0x00d1
        L_0x00cf:
            r0 = 0
            goto L_0x00e4
        L_0x00d1:
            r0 = 1
            goto L_0x00e4
        L_0x00d3:
            androidx.lifecycle.y<java.util.List<com.travel.flight.flightSRPV2.a.x>> r0 = r11.onwardFilterList
            java.lang.Object r0 = r0.getValue()
            if (r0 != 0) goto L_0x00de
            kotlin.g.b.k.a()
        L_0x00de:
            java.util.List r0 = (java.util.List) r0
            boolean r0 = com.travel.flight.flightSRPV2.a.t.c((java.util.List<? extends com.travel.flight.flightSRPV2.a.x>) r0)
        L_0x00e4:
            if (r0 != 0) goto L_0x00fc
            androidx.lifecycle.y<com.travel.flight.pojo.flightticket.CJRFlightSearchInput> r0 = r11.searchInput
            java.lang.Object r0 = r0.getValue()
            if (r0 != 0) goto L_0x00f1
            kotlin.g.b.k.a()
        L_0x00f1:
            java.lang.String r3 = "this.searchInput.value!!"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            com.travel.flight.pojo.flightticket.CJRFlightSearchInput r0 = (com.travel.flight.pojo.flightticket.CJRFlightSearchInput) r0
            r0.setNonStopSelected(r1)
        L_0x00fc:
            r0 = r12
            java.util.Collection r0 = (java.util.Collection) r0
            if (r0 == 0) goto L_0x010a
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0108
            goto L_0x010a
        L_0x0108:
            r0 = 0
            goto L_0x010b
        L_0x010a:
            r0 = 1
        L_0x010b:
            r0 = r0 ^ r2
            r3 = r13
            java.util.Collection r3 = (java.util.Collection) r3
            if (r3 == 0) goto L_0x011a
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x0118
            goto L_0x011a
        L_0x0118:
            r3 = 0
            goto L_0x011b
        L_0x011a:
            r3 = 1
        L_0x011b:
            r3 = r3 ^ r2
            r0 = r0 | r3
            java.lang.String r3 = "searchInput.value!!.journeyDetailType"
            java.lang.String r4 = "searchInput.value!!"
            if (r0 == 0) goto L_0x0171
            com.travel.flight.utils.j$a r0 = com.travel.flight.utils.j.f25593a
            com.travel.flight.utils.j$a r0 = com.travel.flight.utils.j.f25593a
            androidx.lifecycle.y<com.travel.flight.pojo.flightticket.CJRFlightSearchInput> r0 = r11.searchInput
            java.lang.Object r0 = r0.getValue()
            if (r0 != 0) goto L_0x0134
            kotlin.g.b.k.a()
        L_0x0134:
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            r5 = r0
            com.travel.flight.pojo.flightticket.CJRFlightSearchInput r5 = (com.travel.flight.pojo.flightticket.CJRFlightSearchInput) r5
            com.travel.flight.utils.j$a r0 = com.travel.flight.utils.j.f25593a
            androidx.lifecycle.y<com.travel.flight.pojo.flightticket.CJRFlightSearchInput> r0 = r11.searchInput
            java.lang.Object r0 = r0.getValue()
            if (r0 != 0) goto L_0x0147
            kotlin.g.b.k.a()
        L_0x0147:
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            com.travel.flight.pojo.flightticket.CJRFlightSearchInput r0 = (com.travel.flight.pojo.flightticket.CJRFlightSearchInput) r0
            java.lang.String r0 = r0.getJourneyDetailType()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            java.lang.String r6 = com.travel.flight.utils.j.a.a(r0, r12, r13)
            r7 = 0
            r8 = 0
            r9 = 0
            android.app.Application r12 = r11.getApplication()
            java.lang.String r13 = "this@SRPSharedViewModel.getApplication()"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r13)
            r10 = r12
            android.content.Context r10 = (android.content.Context) r10
            java.util.HashMap r12 = com.travel.flight.utils.j.a.a(r5, r6, r7, r8, r9, r10)
            java.lang.String r13 = "filters_option_selected"
            com.travel.flight.utils.j.a.a((java.lang.String) r13, (java.util.HashMap<java.lang.String, java.lang.Object>) r12)
            return
        L_0x0171:
            androidx.lifecycle.y<com.travel.flight.pojo.flightticket.CJRFlightSearchInput> r12 = r11.searchInput
            java.lang.Object r12 = r12.getValue()
            if (r12 != 0) goto L_0x017c
            kotlin.g.b.k.a()
        L_0x017c:
            com.travel.flight.pojo.flightticket.CJRFlightSearchInput r12 = (com.travel.flight.pojo.flightticket.CJRFlightSearchInput) r12
            java.lang.String r12 = r12.getmDeeplinkFilterAirlineCodes()
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            if (r12 == 0) goto L_0x018c
            int r12 = r12.length()
            if (r12 != 0) goto L_0x018d
        L_0x018c:
            r1 = 1
        L_0x018d:
            if (r1 != 0) goto L_0x01ae
            com.travel.flight.utils.j$a r12 = com.travel.flight.utils.j.f25593a
            androidx.lifecycle.y<com.travel.flight.pojo.flightticket.CJRFlightSearchInput> r12 = r11.searchInput
            java.lang.Object r12 = r12.getValue()
            if (r12 != 0) goto L_0x019c
            kotlin.g.b.k.a()
        L_0x019c:
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r4)
            com.travel.flight.pojo.flightticket.CJRFlightSearchInput r12 = (com.travel.flight.pojo.flightticket.CJRFlightSearchInput) r12
            java.lang.String r12 = r12.getJourneyDetailType()
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r3)
            com.travel.flight.utils.j.a.b(r12)
            r11.clearDeeplinkAirlineFilters()
        L_0x01ae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel.applyFilters(java.util.List, java.util.List):void");
    }

    public final void onFilterRemoved() {
        j.a aVar = j.f25593a;
        CJRFlightSearchInput value = this.searchInput.getValue();
        if (value == null) {
            k.a();
        }
        k.a((Object) value, "searchInput.value!!");
        String journeyDetailType = value.getJourneyDetailType();
        k.a((Object) journeyDetailType, "searchInput.value!!.journeyDetailType");
        j.a.b(journeyDetailType);
    }

    private final void clearDeeplinkAirlineFilters() {
        CJRFlightSearchInput value = this.searchInput.getValue();
        if (value == null) {
            k.a();
        }
        value.setmDeeplinkFilterAirlineCodes((String) null);
        this.setResultListener.setValue(null);
    }

    public final void onSRPModifyRequested() {
        j.a aVar = j.f25593a;
        j.a.a("edit_journey", (HashMap<String, Object>) null);
        e eVar = new e(R.anim.enter_anim_slide_from_top_to_bottom, R.anim.exit_anim_slide_from_bottom_to_top);
        int i2 = R.id.container_full_overlay;
        String simpleName = FlightSRPV2Activity.class.getSimpleName();
        k.a((Object) simpleName, "FlightSRPV2Activity::class.java.simpleName");
        navigate(new com.travel.flight.flightSRPV2.b.c("PAGE_SRP_MODIFY", eVar, i2, true, simpleName));
    }

    public final void onBackPressedMain() {
        j.a aVar = j.f25593a;
        j.a.a("srp_back_arrow_button_clicked", (HashMap<String, Object>) null);
        onBackPressed();
    }

    public final void onBackPressed() {
        com.paytm.network.a.a((Context) getApplication(), (Object) "NETWORK_TAG_FLIGHT_SRP_V2");
        this.onBackPressedEvent.setValue(null);
    }

    public final void onBackPressedLoaderFragment() {
        k.a((Object) com.travel.flight.b.a(), "FlightController.getInstance()");
        com.travel.flight.b.b().a(GAUtil.CUSTOM_EVENT, "/flights/search-loader", "flights_loader_screen", "loader_back_button_clicked", (Map<String, Object>) null);
        onBackPressed();
    }

    private final void resetData() {
        this.srpResult.setValue(null);
        this.secondarySrpResult.setValue(null);
        this.defaultOnwardFilterInfo.setValue(null);
        this.defaultReturnFilterInfo.setValue(null);
        this.onwardFilterList.setValue(new ArrayList());
        this.returnFilterList.setValue(new ArrayList());
        this.irtFilterList.setValue(new ArrayList());
        resetFareAlertInfo();
        cancelSecondaryAPITask();
    }

    public final void refresh(Context context) {
        k.c(context, "context");
        cancelSecondaryAPITask();
        CJRFlightSearchInput value = this.searchInput.getValue();
        if (value == null) {
            k.a();
        }
        k.a((Object) value, "this.searchInput.value!!");
        this.searchInput.setValue(value.clone());
        t.a(context, this.searchInput.getValue());
        resetFareAlertInfo();
        y.a aVar = com.travel.flight.flightSRPV2.a.y.f24137a;
        Application application = getApplication();
        k.a((Object) application, "getApplication()");
        Context context2 = application;
        CJRFlightSearchInput value2 = this.searchInput.getValue();
        if (value2 == null) {
            k.a();
        }
        k.a((Object) value2, "searchInput.value!!");
        b bVar = this;
        if (y.a.a(context2, value2, (String) null, bVar)) {
            resetData();
            setProgressState(1);
            y.a aVar2 = com.travel.flight.flightSRPV2.a.y.f24137a;
            Application application2 = getApplication();
            k.a((Object) application2, "getApplication()");
            Context context3 = application2;
            CJRFlightSearchInput value3 = this.searchInput.getValue();
            if (value3 == null) {
                k.a();
            }
            k.a((Object) value3, "searchInput.value!!");
            y.a.a(context3, value3, "searchpage", "searchpage", bVar, isRoundTrip());
            CJRFlightSearchInput value4 = this.searchInput.getValue();
            if (value4 == null) {
                k.a();
            }
            k.a((Object) value4, "searchInput.value!!");
            if (value4.getBookingSegment() != null) {
                CJRFlightSearchInput value5 = this.searchInput.getValue();
                if (value5 == null) {
                    k.a();
                }
                k.a((Object) value5, "searchInput.value!!");
                if (value5.getBookingSegment() != com.travel.flight.flightticket.d.b.Modify) {
                    y.a aVar3 = com.travel.flight.flightSRPV2.a.y.f24137a;
                    Application application3 = getApplication();
                    k.a((Object) application3, "getApplication()");
                    Context context4 = application3;
                    CJRFlightSearchInput value6 = this.searchInput.getValue();
                    if (value6 == null) {
                        k.a();
                    }
                    k.a((Object) value6, "searchInput.value!!");
                    CJRFlightSearchInput cJRFlightSearchInput = value6;
                    k.c(context4, "context");
                    k.c(cJRFlightSearchInput, "searchInput");
                    k.c(bVar, "responseListener");
                    String sourceCityCode = cJRFlightSearchInput.getSourceCityCode();
                    String destCityCode = cJRFlightSearchInput.getDestCityCode();
                    String classType = cJRFlightSearchInput.getClassType();
                    context4.getApplicationContext();
                    com.travel.flight.flightticket.e.b.a(context4, sourceCityCode, destCityCode, classType, com.paytm.utility.b.d(cJRFlightSearchInput.getDate(), "yyyy-MM-dd", "yyyyMMdd"), new CJRAirlinesSrpAnalytics(), bVar);
                    return;
                }
                return;
            }
            return;
        }
        navigate(new com.travel.flight.flightSRPV2.b.c("PAGE_NO_INTERNET", R.id.container_child, (String) null, 32));
    }

    public final void refresh(Context context, CJRFlightSearchInput cJRFlightSearchInput) {
        k.c(context, "context");
        k.c(cJRFlightSearchInput, "searchInput");
        this.searchInput.setValue(cJRFlightSearchInput);
        this.copiedSearchInput.setValue(cJRFlightSearchInput);
        refresh(context);
    }

    /* access modifiers changed from: private */
    public final void callSecondaryAPI() {
        String str;
        CJRMetadetails cJRMetadetails;
        CJRFlightSearchResult value = this.srpResult.getValue();
        if (value == null || (cJRMetadetails = value.getmMetaDetails()) == null || (str = cJRMetadetails.getmRequestId()) == null) {
            str = null;
        }
        y.a aVar = com.travel.flight.flightSRPV2.a.y.f24137a;
        Application application = getApplication();
        k.a((Object) application, "getApplication()");
        Context context = application;
        CJRFlightSearchInput value2 = this.searchInput.getValue();
        if (value2 == null) {
            k.a();
        }
        k.a((Object) value2, "searchInput.value!!");
        b bVar = this;
        y.a.a(context, value2, str, bVar);
        y.a aVar2 = com.travel.flight.flightSRPV2.a.y.f24137a;
        Application application2 = getApplication();
        k.a((Object) application2, "getApplication()");
        Context context2 = application2;
        CJRFlightSearchInput value3 = this.searchInput.getValue();
        if (value3 == null) {
            k.a();
        }
        k.a((Object) value3, "searchInput.value!!");
        y.a.a(context2, value3, "searchpage", "searchpage", bVar, isRoundTrip());
    }

    /* access modifiers changed from: private */
    public final void triggerSecondaryAPITask() {
        cancelSecondaryAPITask();
        this.isSecondaryRefreshAPIRequest = true;
        this.secondaryRefreshAPITask = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (f) null, (CoroutineStart) null, new SRPSharedViewModel$triggerSecondaryAPITask$1(this, (kotlin.d.d) null), 3, (Object) null);
    }

    private final void cancelSecondaryAPITask() {
        if (this.secondaryRefreshAPITask != null) {
            try {
                if (Build.VERSION.SDK_INT >= 21) {
                    Job job = this.secondaryRefreshAPITask;
                    if (job == null) {
                        k.a();
                    }
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
            } catch (Exception unused) {
            }
        }
        this.isSecondaryRefreshAPIRequest = false;
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        Integer num = null;
        if (iJRPaytmDataModel instanceof CJRFlightSearchResult) {
            j.a aVar = j.f25593a;
            j.a aVar2 = j.f25593a;
            CJRFlightSearchInput value = this.searchInput.getValue();
            if (value == null) {
                k.a();
            }
            k.a((Object) value, "searchInput.value!!");
            CJRFlightSearchInput cJRFlightSearchInput = value;
            String valueOf = String.valueOf(networkCustomError != null ? networkCustomError.getMessage() : null);
            Application application = getApplication();
            k.a((Object) application, "this@SRPSharedViewModel.getApplication()");
            j.a.a("flights_search_page_load", j.a.a(cJRFlightSearchInput, CommonPayParams.Builder.NO, valueOf, (String) null, false, application));
            if (this.isSecondaryRefreshAPIRequest) {
                cancelSecondaryAPITask();
                return;
            }
            setProgressState(0);
            if (networkCustomError == null) {
                this.dialogEvent.setValue(new com.travel.flight.flightSRPV2.b.b(Integer.valueOf(R.string.network_error_heading), Integer.valueOf(R.string.flight_network_error_message)));
            } else if (i2 / 100 == 5) {
                this.dialogEvent.setValue(new com.travel.flight.flightSRPV2.b.b(Integer.valueOf(R.string.bus_maintenance_error_title), Integer.valueOf(R.string.bus_maintenance_error_description)));
            } else if (networkCustomError.getErrorType() == NetworkCustomError.ErrorType.ParsingError) {
                this.dataDisplayErrorEvent.setValue(networkCustomError.getUrl());
            } else if (networkCustomError.getAlertTitle() == null || networkCustomError.getAlertMessage() == null) {
                this.dialogEvent.setValue(new com.travel.flight.flightSRPV2.b.b(Integer.valueOf(R.string.network_error_heading), Integer.valueOf(R.string.flight_network_error_message)));
            } else {
                androidx.lifecycle.y<com.travel.flight.flightSRPV2.b.b<Object, Object>> yVar = this.dialogEvent;
                String alertTitle = networkCustomError.getAlertTitle();
                k.a((Object) alertTitle, "error.alertTitle");
                String alertMessage = networkCustomError.getAlertMessage();
                k.a((Object) alertMessage, "error.alertMessage");
                yVar.setValue(new com.travel.flight.flightSRPV2.b.b(alertTitle, alertMessage));
            }
        }
        if (iJRPaytmDataModel instanceof CJRAirlinesSrpAnalytics) {
            resetFareAlertInfo();
        }
        if (iJRPaytmDataModel instanceof CJRFareAlertsSubscribeResponse) {
            handleFareAlertActionError(networkCustomError);
        }
        if (iJRPaytmDataModel instanceof CalendarPriceModel) {
            j.a aVar3 = j.f25593a;
            j.a.a(CommonPayParams.Builder.NO);
            if (this.calendarPriceInfo.getValue() != null) {
                CalendarPriceModel value2 = this.calendarPriceInfo.getValue();
                if (value2 == null) {
                    k.a();
                }
                ArrayList<CalendarDatePriceInfo> onwardDatePriceInfo = value2.getOnwardDatePriceInfo();
                if (onwardDatePriceInfo != null) {
                    num = Integer.valueOf(onwardDatePriceInfo.size());
                }
                if (num == null) {
                    k.a();
                }
                if (num.intValue() > 0) {
                    return;
                }
            }
            this.showFareCalenderIcon.postValue(Boolean.FALSE);
        }
    }

    private final void handleFareAlertActionError(NetworkCustomError networkCustomError) {
        if (networkCustomError != null) {
            CJRPromocodeErrorResponse cJRPromocodeErrorResponse = new CJRPromocodeErrorResponse();
            if (networkCustomError.networkResponse != null && networkCustomError.networkResponse.data != null) {
                try {
                    byte[] bArr = networkCustomError.networkResponse.data;
                    k.a((Object) bArr, "customError.networkResponse.data");
                    CJRPromocodeErrorResponse cJRPromocodeErrorResponse2 = (CJRPromocodeErrorResponse) new com.google.gsonhtcfix.f().a(new String(bArr, kotlin.m.d.f47971a), cJRPromocodeErrorResponse.getClass());
                    if (cJRPromocodeErrorResponse2 != null && cJRPromocodeErrorResponse2.getStatus() != null) {
                        CJRFlightPromoCodeErrorStatus status = cJRPromocodeErrorResponse2.getStatus();
                        k.a((Object) status, "promoCodeErrorResponse.status");
                        if (status.getMessage() != null) {
                            CJRFlightPromoCodeErrorStatus status2 = cJRPromocodeErrorResponse2.getStatus();
                            k.a((Object) status2, "promoCodeErrorResponse.status");
                            CJRFlightPromocodeErrorMessage message = status2.getMessage();
                            k.a((Object) message, "promoCodeErrorResponse.status.message");
                            if (message.getMessage() != null) {
                                com.travel.flight.flightSRPV2.c.b<l> bVar = this.fareAlertEvent;
                                CJRFlightPromoCodeErrorStatus status3 = cJRPromocodeErrorResponse2.getStatus();
                                k.a((Object) status3, "promoCodeErrorResponse.status");
                                CJRFlightPromocodeErrorMessage message2 = status3.getMessage();
                                k.a((Object) message2, "promoCodeErrorResponse.status.message");
                                bVar.setValue(new l(3, message2.getMessage()));
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof CJRFlightSearchResult) {
            if (this.isSecondaryRefreshAPIRequest) {
                handleSecondarySRPResult((CJRFlightSearchResult) iJRPaytmDataModel);
            } else {
                handleSRPResult$default(this, (CJRFlightSearchResult) iJRPaytmDataModel, false, 2, (Object) null);
            }
        } else if (iJRPaytmDataModel instanceof CalendarPriceModel) {
            new CJRFlightCalendarPriceModel();
            this.calendarPriceInfo.setValue(iJRPaytmDataModel);
            com.travel.f.b bVar = com.travel.f.b.f23450a;
            com.travel.f.c a2 = com.travel.f.b.a();
            if (a2 != null) {
                a2.a((CalendarPriceModel) iJRPaytmDataModel);
            }
        } else if (iJRPaytmDataModel instanceof CJRAirlinesSrpAnalytics) {
            handleFareAlertResponse((CJRAirlinesSrpAnalytics) iJRPaytmDataModel);
        } else if (iJRPaytmDataModel instanceof CJRFareAlertsSubscribeResponse) {
            handleFareAlertActionSuccess((CJRFareAlertsSubscribeResponse) iJRPaytmDataModel);
        }
    }

    private final void resetFareAlertInfo() {
        this.isFareAlertSelectable.setValue(Boolean.FALSE);
        this.isFareAlertSelected.setValue(Boolean.FALSE);
    }

    private final void handleFareAlertResponse(CJRAirlinesSrpAnalytics cJRAirlinesSrpAnalytics) {
        resetFareAlertInfo();
        if (cJRAirlinesSrpAnalytics.getBody() != null) {
            CJRFlightSRPBody body = cJRAirlinesSrpAnalytics.getBody();
            k.a((Object) body, "response.body");
            if (body.getRegisterable()) {
                this.isFareAlertSelectable.setValue(Boolean.TRUE);
                androidx.lifecycle.y<Boolean> yVar = this.isFareAlertSelected;
                CJRFlightSRPBody body2 = cJRAirlinesSrpAnalytics.getBody();
                k.a((Object) body2, "response.body");
                yVar.setValue(Boolean.valueOf(body2.getIsRegistered()));
                return;
            }
            this.isFareAlertSelectable.setValue(Boolean.FALSE);
        }
    }

    public final void onFilterOptionsRequested() {
        j.a aVar = j.f25593a;
        CJRFlightSearchInput value = this.searchInput.getValue();
        if (value == null) {
            k.a();
        }
        k.a((Object) value, "searchInput.value!!");
        String journeyDetailType = value.getJourneyDetailType();
        k.a((Object) journeyDetailType, "searchInput.value!!.journeyDetailType");
        k.c(journeyDetailType, "journeyDetailType");
        HashMap hashMap = new HashMap();
        hashMap.put("event_label2", journeyDetailType);
        j.a.a("filters_button_clicked", (HashMap<String, Object>) hashMap);
        navigate(new com.travel.flight.flightSRPV2.b.c("PAGE_FILTER_HOME", new e(R.anim.flight_anim_slide_in_from_bottom_250_ms, R.anim.flight_anim_slide_out_from_top_250_ms), R.id.container_full_overlay, true, "PAGE_FILTER_HOME"));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0049, code lost:
        r9 = r9.getmOnwardReturnFlights();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSortOptionsRequested(boolean r9) {
        /*
            r8 = this;
            com.travel.flight.utils.j$a r0 = com.travel.flight.utils.j.f25593a
            androidx.lifecycle.y<com.travel.flight.pojo.flightticket.CJRFlightSearchInput> r0 = r8.searchInput
            java.lang.Object r0 = r0.getValue()
            if (r0 != 0) goto L_0x000d
            kotlin.g.b.k.a()
        L_0x000d:
            java.lang.String r1 = "searchInput.value!!"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            com.travel.flight.pojo.flightticket.CJRFlightSearchInput r0 = (com.travel.flight.pojo.flightticket.CJRFlightSearchInput) r0
            java.lang.String r0 = r0.getJourneyDetailType()
            java.lang.String r1 = "searchInput.value!!.journeyDetailType"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.String r1 = "journeyDetailType"
            kotlin.g.b.k.c(r0, r1)
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r2 = r1
            java.util.Map r2 = (java.util.Map) r2
            java.lang.String r3 = "event_label2"
            r2.put(r3, r0)
            java.lang.String r0 = "sort_selected"
            com.travel.flight.utils.j.a.a((java.lang.String) r0, (java.util.HashMap<java.lang.String, java.lang.Object>) r1)
            com.travel.flight.flightSRPV2.b.c r0 = new com.travel.flight.flightSRPV2.b.c
            if (r9 == 0) goto L_0x003f
            java.lang.String r9 = "PAGE_ONE_WAY_SORT_POPUP"
        L_0x003d:
            r3 = r9
            goto L_0x0064
        L_0x003f:
            androidx.lifecycle.y<com.travel.flight.pojo.flightticket.CJRFlightSearchResult> r9 = r8.srpResult
            java.lang.Object r9 = r9.getValue()
            com.travel.flight.pojo.flightticket.CJRFlightSearchResult r9 = (com.travel.flight.pojo.flightticket.CJRFlightSearchResult) r9
            if (r9 == 0) goto L_0x0054
            com.travel.flight.pojo.flightticket.CJROnwardReturnFlightInformation r9 = r9.getmOnwardReturnFlights()
            if (r9 == 0) goto L_0x0054
            java.lang.String r9 = r9.getJourney_type()
            goto L_0x0055
        L_0x0054:
            r9 = 0
        L_0x0055:
            java.lang.String r1 = net.one97.paytmflight.common.b.b.f30019i
            r2 = 1
            boolean r9 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r1, (boolean) r2)
            if (r9 == 0) goto L_0x0061
            java.lang.String r9 = "PAGE_IRT_SORT_POPUP"
            goto L_0x003d
        L_0x0061:
            java.lang.String r9 = "PAGE_SORT_HOME"
            goto L_0x003d
        L_0x0064:
            com.travel.flight.flightSRPV2.b.e r4 = new com.travel.flight.flightSRPV2.b.e
            int r9 = com.travel.flight.R.anim.enter_anim_slide_from_bottom_to_top
            int r1 = com.travel.flight.R.anim.exit_anim_slide_from_top_to_bottom
            r4.<init>(r9, r1)
            int r5 = com.travel.flight.R.id.container_full_overlay
            r6 = 1
            java.lang.String r7 = "PAGE_SORT_HOME"
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            com.travel.flight.flightSRPV2.b.d r0 = (com.travel.flight.flightSRPV2.b.d) r0
            r8.navigate(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel.onSortOptionsRequested(boolean):void");
    }

    public final void logProcessingEvent(String str, String str2, String str3, com.travel.flight.flightSRPV2.a.a aVar, com.travel.flight.flightSRPV2.a.b bVar, long j, int i2) {
        k.c(str, "trip");
        k.c(str2, "action");
        k.c(str3, "actionJourney");
        k.c(bVar, "actionDetailSort");
        Calendar instance = Calendar.getInstance();
        k.a((Object) instance, "Calendar.getInstance()");
        long timeInMillis = instance.getTimeInMillis();
        j.a aVar2 = j.f25593a;
        long abs = Math.abs(timeInMillis - j);
        CJRFlightSearchInput value = this.searchInput.getValue();
        if (value == null) {
            k.a();
        }
        k.a((Object) value, "searchInput.value!!");
        com.travel.flight.pojo.flightticket.b source = value.getSource();
        k.a((Object) source, "searchInput.value!!.source");
        String cityName = source.getCityName();
        k.a((Object) cityName, "searchInput.value!!.source.cityName");
        CJRFlightSearchInput value2 = this.searchInput.getValue();
        if (value2 == null) {
            k.a();
        }
        k.a((Object) value2, "searchInput.value!!");
        com.travel.flight.pojo.flightticket.b destination = value2.getDestination();
        k.a((Object) destination, "searchInput.value!!.destination");
        String cityName2 = destination.getCityName();
        k.a((Object) cityName2, "searchInput.value!!.destination.cityName");
        n nVar = new n(str, str2, str3, aVar, bVar, j, timeInMillis, abs, i2, cityName, cityName2);
        j.a aVar3 = j.f25593a;
        k.c(nVar, "processingEvent");
        k.a((Object) com.travel.flight.b.a(), "FlightController.getInstance()");
        com.travel.flight.b.b().a(nVar);
    }

    public final void onOneWaySortOptionSelected(int i2) {
        ae aeVar;
        String str;
        onBackPressed();
        switch (i2) {
            case 1:
                aeVar = new p((byte) 0);
                str = "Cheapest";
                break;
            case 2:
                aeVar = new com.travel.flight.flightSRPV2.a.j((byte) 0);
                str = "Fastest";
                break;
            case 3:
                aeVar = new h(true);
                str = "Early Take Off";
                break;
            case 4:
                aeVar = new h(false);
                str = "Late Take Off";
                break;
            case 5:
                aeVar = new com.travel.flight.flightSRPV2.a.e(true);
                str = "Landing Early";
                break;
            case 6:
                aeVar = new com.travel.flight.flightSRPV2.a.e(false);
                str = "Landing Late";
                break;
            default:
                throw new IllegalArgumentException("Unknown sort type provided for one way trip");
        }
        String str2 = str;
        j.a aVar = j.f25593a;
        j.a aVar2 = j.f25593a;
        CJRFlightSearchInput value = this.searchInput.getValue();
        if (value == null) {
            k.a();
        }
        k.a((Object) value, "searchInput.value!!");
        Application application = getApplication();
        k.a((Object) application, "this@SRPSharedViewModel.getApplication()");
        j.a.a("sort_option_selected", j.a.a(value, str2, (String) null, (String) null, false, application));
        this.oneWaySortOption.postValue(aeVar);
    }

    public final boolean getOnwardSortApplied() {
        return this.onwardSortApplied;
    }

    public final void setOnwardSortApplied(boolean z) {
        this.onwardSortApplied = z;
    }

    public final boolean getReturnSortApplied() {
        return this.returnSortApplied;
    }

    public final void setReturnSortApplied(boolean z) {
        this.returnSortApplied = z;
    }

    public final void onRoundTripSortOptionSelected(int i2, boolean z) {
        ae aeVar;
        String str;
        String str2;
        if (z) {
            this.onwardSortApplied = true;
        } else {
            this.returnSortApplied = true;
        }
        if (this.onwardSortApplied && this.returnSortApplied) {
            onBackPressed();
        }
        switch (i2) {
            case 1:
                aeVar = new p((byte) 0);
                str = "Cheapest";
                break;
            case 2:
                aeVar = new com.travel.flight.flightSRPV2.a.j((byte) 0);
                str = "Fastest";
                break;
            case 3:
                aeVar = new h(true);
                str = "Early Take Off";
                break;
            case 4:
                aeVar = new h(false);
                str = "Late Take Off";
                break;
            case 5:
                aeVar = new com.travel.flight.flightSRPV2.a.e(true);
                str = "Landing Early";
                break;
            case 6:
                aeVar = new com.travel.flight.flightSRPV2.a.e(false);
                str = "Landing Late";
                break;
            default:
                throw new IllegalArgumentException("Unknown sort type provided for drt trip");
        }
        if (z) {
            str2 = "Onward{" + str + '}';
        } else {
            str2 = "Return{" + str + '}';
        }
        String str3 = str2;
        j.a aVar = j.f25593a;
        j.a aVar2 = j.f25593a;
        CJRFlightSearchInput value = this.searchInput.getValue();
        if (value == null) {
            k.a();
        }
        k.a((Object) value, "searchInput.value!!");
        Application application = getApplication();
        k.a((Object) application, "this@SRPSharedViewModel.getApplication()");
        j.a.a("sort_option_selected", j.a.a(value, str3, (String) null, (String) null, false, application));
        if (z) {
            this.roundTripOnwardSortOption.postValue(aeVar);
        } else {
            this.roundTripReturnSortOption.postValue(aeVar);
        }
    }

    public static /* synthetic */ void onIRTSortOptionSelected$default(SRPSharedViewModel sRPSharedViewModel, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = true;
        }
        sRPSharedViewModel.onIRTSortOptionSelected(i2, z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0049, code lost:
        r1 = "Landing Early";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005a, code lost:
        r1 = "Early Take Off";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x006f, code lost:
        r1 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0070, code lost:
        r8 = com.travel.flight.utils.j.f25593a;
        r8 = com.travel.flight.utils.j.f25593a;
        r8 = r6.searchInput.getValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007a, code lost:
        if (r8 != null) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x007c, code lost:
        kotlin.g.b.k.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x007f, code lost:
        kotlin.g.b.k.a((java.lang.Object) r8, "searchInput.value!!");
        r8 = getApplication();
        kotlin.g.b.k.a((java.lang.Object) r8, "this@SRPSharedViewModel.getApplication()");
        com.travel.flight.utils.j.a.a("sort_option_selected", com.travel.flight.utils.j.a.a(r8, r1, (java.lang.String) null, (java.lang.String) null, false, r8));
        r6.irtSortOption.postValue(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a7, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onIRTSortOptionSelected(int r7, boolean r8) {
        /*
            r6 = this;
            r6.onBackPressed()
            java.lang.String r8 = "Landing Late"
            java.lang.String r0 = "Landing Early"
            java.lang.String r1 = "Late Take Off"
            java.lang.String r2 = "Early Take Off"
            r3 = 1
            r4 = 0
            switch(r7) {
                case 1: goto L_0x0066;
                case 2: goto L_0x005c;
                case 3: goto L_0x0053;
                case 4: goto L_0x004b;
                case 5: goto L_0x0042;
                case 6: goto L_0x003a;
                case 7: goto L_0x0032;
                case 8: goto L_0x002a;
                case 9: goto L_0x0022;
                case 10: goto L_0x001a;
                default: goto L_0x0010;
            }
        L_0x0010:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = "Unknown sort type provided for irt trip"
            r7.<init>(r8)
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            throw r7
        L_0x001a:
            com.travel.flight.flightSRPV2.a.f r7 = new com.travel.flight.flightSRPV2.a.f
            r7.<init>(r4, r4)
            com.travel.flight.flightSRPV2.a.ae r7 = (com.travel.flight.flightSRPV2.a.ae) r7
            goto L_0x006f
        L_0x0022:
            com.travel.flight.flightSRPV2.a.f r7 = new com.travel.flight.flightSRPV2.a.f
            r7.<init>(r3, r4)
            com.travel.flight.flightSRPV2.a.ae r7 = (com.travel.flight.flightSRPV2.a.ae) r7
            goto L_0x0049
        L_0x002a:
            com.travel.flight.flightSRPV2.a.i r7 = new com.travel.flight.flightSRPV2.a.i
            r7.<init>(r4, r4)
            com.travel.flight.flightSRPV2.a.ae r7 = (com.travel.flight.flightSRPV2.a.ae) r7
            goto L_0x0070
        L_0x0032:
            com.travel.flight.flightSRPV2.a.i r7 = new com.travel.flight.flightSRPV2.a.i
            r7.<init>(r3, r4)
            com.travel.flight.flightSRPV2.a.ae r7 = (com.travel.flight.flightSRPV2.a.ae) r7
            goto L_0x005a
        L_0x003a:
            com.travel.flight.flightSRPV2.a.f r7 = new com.travel.flight.flightSRPV2.a.f
            r7.<init>(r4, r3)
            com.travel.flight.flightSRPV2.a.ae r7 = (com.travel.flight.flightSRPV2.a.ae) r7
            goto L_0x006f
        L_0x0042:
            com.travel.flight.flightSRPV2.a.f r7 = new com.travel.flight.flightSRPV2.a.f
            r7.<init>(r3, r3)
            com.travel.flight.flightSRPV2.a.ae r7 = (com.travel.flight.flightSRPV2.a.ae) r7
        L_0x0049:
            r1 = r0
            goto L_0x0070
        L_0x004b:
            com.travel.flight.flightSRPV2.a.i r7 = new com.travel.flight.flightSRPV2.a.i
            r7.<init>(r4, r3)
            com.travel.flight.flightSRPV2.a.ae r7 = (com.travel.flight.flightSRPV2.a.ae) r7
            goto L_0x0070
        L_0x0053:
            com.travel.flight.flightSRPV2.a.i r7 = new com.travel.flight.flightSRPV2.a.i
            r7.<init>(r3, r3)
            com.travel.flight.flightSRPV2.a.ae r7 = (com.travel.flight.flightSRPV2.a.ae) r7
        L_0x005a:
            r1 = r2
            goto L_0x0070
        L_0x005c:
            com.travel.flight.flightSRPV2.a.k r7 = new com.travel.flight.flightSRPV2.a.k
            r7.<init>(r4)
            com.travel.flight.flightSRPV2.a.ae r7 = (com.travel.flight.flightSRPV2.a.ae) r7
            java.lang.String r8 = "Fastest"
            goto L_0x006f
        L_0x0066:
            com.travel.flight.flightSRPV2.a.q r7 = new com.travel.flight.flightSRPV2.a.q
            r7.<init>(r4)
            com.travel.flight.flightSRPV2.a.ae r7 = (com.travel.flight.flightSRPV2.a.ae) r7
            java.lang.String r8 = "Cheapest"
        L_0x006f:
            r1 = r8
        L_0x0070:
            com.travel.flight.utils.j$a r8 = com.travel.flight.utils.j.f25593a
            com.travel.flight.utils.j$a r8 = com.travel.flight.utils.j.f25593a
            androidx.lifecycle.y<com.travel.flight.pojo.flightticket.CJRFlightSearchInput> r8 = r6.searchInput
            java.lang.Object r8 = r8.getValue()
            if (r8 != 0) goto L_0x007f
            kotlin.g.b.k.a()
        L_0x007f:
            java.lang.String r0 = "searchInput.value!!"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r0)
            r0 = r8
            com.travel.flight.pojo.flightticket.CJRFlightSearchInput r0 = (com.travel.flight.pojo.flightticket.CJRFlightSearchInput) r0
            r2 = 0
            r3 = 0
            r4 = 0
            android.app.Application r8 = r6.getApplication()
            java.lang.String r5 = "this@SRPSharedViewModel.getApplication()"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r5)
            r5 = r8
            android.content.Context r5 = (android.content.Context) r5
            java.util.HashMap r8 = com.travel.flight.utils.j.a.a(r0, r1, r2, r3, r4, r5)
            java.lang.String r0 = "sort_option_selected"
            com.travel.flight.utils.j.a.a((java.lang.String) r0, (java.util.HashMap<java.lang.String, java.lang.Object>) r8)
            androidx.lifecycle.y<com.travel.flight.flightSRPV2.a.ae> r8 = r6.irtSortOption
            r8.postValue(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel.onIRTSortOptionSelected(int, boolean):void");
    }

    private final void handleSecondarySRPResult(CJRFlightSearchResult cJRFlightSearchResult) {
        cancelSecondaryAPITask();
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (f) null, (CoroutineStart) null, new SRPSharedViewModel$handleSecondarySRPResult$1(this, cJRFlightSearchResult, (kotlin.d.d) null), 3, (Object) null);
    }

    public final void updateWithSecondarySrpResult() {
        ad value = this.secondarySrpResult.getValue();
        this.secondarySrpResult.setValue(null);
        if (value != null) {
            setProgressState(2);
            handleSRPResult(value.f24081b, true);
        }
    }

    /* access modifiers changed from: private */
    public final boolean isEmptyResponseFromResult(CJROnwardFlights cJROnwardFlights, String str, String str2, String str3) {
        if (cJROnwardFlights.getmFlightDetails() != null) {
            ArrayList<CJRFlightDetailsItem> arrayList = cJROnwardFlights.getmFlightDetails();
            k.a((Object) arrayList, "flights.getmFlightDetails()");
            if (!(!arrayList.isEmpty())) {
                sendHawkeyeErrorEvent(str, str2 + " flights are empty", str3);
                return true;
            } else if (!isSortFilterEnable() || (cJROnwardFlights.getmMeta() != null && cJROnwardFlights.getmMeta().getmDuration() != null)) {
                return false;
            } else {
                sendHawkeyeErrorEvent(str, "filter-meta is missing", str3);
                return true;
            }
        } else {
            sendHawkeyeErrorEvent(str, str2 + " flights are null", str3);
            return true;
        }
    }

    /* access modifiers changed from: private */
    public final boolean isEmptyResponseForIRT(CJRFlightSearchResult cJRFlightSearchResult) {
        String str;
        CJROnwardReturnFlightInformation cJROnwardReturnFlightInformation = cJRFlightSearchResult.getmOnwardReturnFlights();
        CJROnwardFlights cJROnwardFlights = cJRFlightSearchResult.getmOnwardReturnFlights().getmOnwardFlights();
        k.a((Object) cJROnwardFlights, "srpResult.getmOnwardRetu…hts().getmOnwardFlights()");
        CJRMetadetails cJRMetadetails = cJRFlightSearchResult.getmMetaDetails();
        String str2 = null;
        boolean isEmptyResponseFromResult = isEmptyResponseFromResult(cJROnwardFlights, "IRT", "ONWARD", cJRMetadetails != null ? cJRMetadetails.getmRequestId() : null);
        CJROnwardFlights cJROnwardFlights2 = cJRFlightSearchResult.getmOnwardReturnFlights().getmReturnFlights();
        k.a((Object) cJROnwardFlights2, "srpResult.getmOnwardRetu…hts().getmReturnFlights()");
        CJRMetadetails cJRMetadetails2 = cJRFlightSearchResult.getmMetaDetails();
        boolean isEmptyResponseFromResult2 = isEmptyResponseFromResult(cJROnwardFlights2, "IRT", "RETURN", cJRMetadetails2 != null ? cJRMetadetails2.getmRequestId() : null);
        boolean z = true;
        if (!isEmptyResponseFromResult && !isEmptyResponseFromResult2) {
            if (cJROnwardReturnFlightInformation.getmMapping() == null) {
                str = "Mappings are null but flights are present";
            } else if (cJROnwardReturnFlightInformation.getmMapping().isEmpty()) {
                str = "Mappings are Empty but flights are present";
            } else {
                z = false;
                str = "Mappings are present - All Good";
            }
            CJRMetadetails cJRMetadetails3 = cJRFlightSearchResult.getmMetaDetails();
            if (cJRMetadetails3 != null) {
                str2 = cJRMetadetails3.getmRequestId();
            }
            sendHawkeyeErrorEvent("IRT", str, str2);
        }
        return z;
    }

    static /* synthetic */ void handleSRPResult$default(SRPSharedViewModel sRPSharedViewModel, CJRFlightSearchResult cJRFlightSearchResult, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        sRPSharedViewModel.handleSRPResult(cJRFlightSearchResult, z);
    }

    private final void handleSRPResult(CJRFlightSearchResult cJRFlightSearchResult, boolean z) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (f) null, (CoroutineStart) null, new SRPSharedViewModel$handleSRPResult$1(this, cJRFlightSearchResult, z, (kotlin.d.d) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void logSrpLoadingPulseEvents(String str) {
        j.a aVar = j.f25593a;
        j.a aVar2 = j.f25593a;
        CJRFlightSearchInput value = this.searchInput.getValue();
        if (value == null) {
            k.a();
        }
        k.a((Object) value, "searchInput.value!!");
        Application application = getApplication();
        k.a((Object) application, "this@SRPSharedViewModel.getApplication()");
        j.a.a("flights_search_page_load", j.a.a(value, str, (String) null, (String) null, false, application));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0018, code lost:
        r1 = r1.getSource();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void sendHawkeyeErrorEvent(java.lang.String r10, java.lang.String r11, java.lang.String r12) {
        /*
            r9 = this;
            java.lang.String r0 = "tripType"
            kotlin.g.b.k.c(r10, r0)
            java.lang.String r0 = "errorDescription"
            kotlin.g.b.k.c(r11, r0)
            com.travel.flight.flightSRPV2.a.m r0 = new com.travel.flight.flightSRPV2.a.m
            androidx.lifecycle.y<com.travel.flight.pojo.flightticket.CJRFlightSearchInput> r1 = r9.searchInput
            java.lang.Object r1 = r1.getValue()
            com.travel.flight.pojo.flightticket.CJRFlightSearchInput r1 = (com.travel.flight.pojo.flightticket.CJRFlightSearchInput) r1
            r2 = 0
            if (r1 == 0) goto L_0x0024
            com.travel.flight.pojo.flightticket.b r1 = r1.getSource()
            if (r1 == 0) goto L_0x0024
            java.lang.String r1 = r1.getCityName()
            r4 = r1
            goto L_0x0025
        L_0x0024:
            r4 = r2
        L_0x0025:
            androidx.lifecycle.y<com.travel.flight.pojo.flightticket.CJRFlightSearchInput> r1 = r9.searchInput
            java.lang.Object r1 = r1.getValue()
            com.travel.flight.pojo.flightticket.CJRFlightSearchInput r1 = (com.travel.flight.pojo.flightticket.CJRFlightSearchInput) r1
            if (r1 == 0) goto L_0x003b
            com.travel.flight.pojo.flightticket.b r1 = r1.getDestination()
            if (r1 == 0) goto L_0x003b
            java.lang.String r1 = r1.getCityName()
            r5 = r1
            goto L_0x003c
        L_0x003b:
            r5 = r2
        L_0x003c:
            androidx.lifecycle.y<com.travel.flight.pojo.flightticket.CJRFlightSearchInput> r1 = r9.searchInput
            java.lang.Object r1 = r1.getValue()
            com.travel.flight.pojo.flightticket.CJRFlightSearchInput r1 = (com.travel.flight.pojo.flightticket.CJRFlightSearchInput) r1
            if (r1 == 0) goto L_0x004c
            java.lang.String r1 = r1.getDate()
            r6 = r1
            goto L_0x004d
        L_0x004c:
            r6 = r2
        L_0x004d:
            androidx.lifecycle.y<com.travel.flight.pojo.flightticket.CJRFlightSearchInput> r1 = r9.searchInput
            java.lang.Object r1 = r1.getValue()
            com.travel.flight.pojo.flightticket.CJRFlightSearchInput r1 = (com.travel.flight.pojo.flightticket.CJRFlightSearchInput) r1
            if (r1 == 0) goto L_0x005d
            java.lang.String r1 = r1.getReturnDate()
            r7 = r1
            goto L_0x005e
        L_0x005d:
            r7 = r2
        L_0x005e:
            r1 = r0
            r2 = r10
            r3 = r11
            r8 = r12
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            com.travel.flight.utils.j$a r10 = com.travel.flight.utils.j.f25593a
            com.travel.flight.utils.j.a.a((com.travel.flight.flightSRPV2.a.m) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel.sendHawkeyeErrorEvent(java.lang.String, java.lang.String, java.lang.String):void");
    }

    public final void addOneWayFilter(x xVar) {
        Object obj;
        k.c(xVar, StringSet.filter);
        List<x> value = this.onwardFilterList.getValue();
        if (value == null) {
            k.a();
        }
        ArrayList arrayList = new ArrayList(value);
        Collection arrayList2 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (true) {
            boolean z = true;
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            if (((x) next).e() != xVar.e()) {
                z = false;
            }
            if (z) {
                arrayList2.add(next);
            }
        }
        List list = (List) arrayList2;
        if (xVar instanceof r) {
            Iterator it3 = list.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it3.next();
                x xVar2 = (x) obj;
                if (xVar2 != null) {
                    if (kotlin.m.p.a(((r) xVar2).f24121a.f24095a, ((r) xVar).f24121a.f24095a, true)) {
                        break;
                    }
                } else {
                    throw new kotlin.u("null cannot be cast to non-null type com.travel.flight.flightSRPV2.datalayer.SRPAirlineFilter");
                }
            }
            if (((x) obj) == null) {
                arrayList.add(xVar);
            }
        } else {
            x xVar3 = (x) kotlin.a.k.e(list);
            if (xVar3 != null) {
                arrayList.remove(xVar3);
            }
            arrayList.add(xVar);
        }
        applyFilters(arrayList, (List<? extends x>) null);
    }

    public final void removeOneWayFilter(x xVar) {
        kotlin.g.a.b bVar;
        k.c(xVar, StringSet.filter);
        CJRFlightSearchInput value = this.searchInput.getValue();
        if (value == null) {
            k.a();
        }
        CharSequence charSequence = value.getmDeeplinkFilterAirlineCodes();
        if (!(charSequence == null || charSequence.length() == 0) && (xVar instanceof r)) {
            clearDeeplinkAirlineFilters();
        }
        List<x> value2 = this.onwardFilterList.getValue();
        if (value2 == null) {
            k.a();
        }
        List arrayList = new ArrayList(value2);
        if (xVar instanceof r) {
            bVar = new SRPSharedViewModel$removeOneWayFilter$filterPredicate$1(xVar);
        } else {
            bVar = new SRPSharedViewModel$removeOneWayFilter$filterPredicate$2(xVar);
        }
        Collection arrayList2 = new ArrayList();
        for (Object next : arrayList) {
            if (((Boolean) bVar.invoke((x) next)).booleanValue()) {
                arrayList2.add(next);
            }
        }
        applyFilters((List) arrayList2, (List<? extends x>) null);
    }

    public final void addOneWayAirlineFilters(List<r> list) {
        k.c(list, "filters");
        List<x> value = this.onwardFilterList.getValue();
        if (value == null) {
            k.a();
        }
        Collection arrayList = new ArrayList();
        for (Object next : new ArrayList(value)) {
            if (((x) next).e() != 7) {
                arrayList.add(next);
            }
        }
        List list2 = (List) arrayList;
        ArrayList arrayList2 = new ArrayList(list2.size() + list.size());
        arrayList2.addAll(list2);
        arrayList2.addAll(list);
        applyFilters(arrayList2, (List<? extends x>) null);
    }

    public final void onOnwardDateChange(Context context, String str) {
        k.c(context, "context");
        CharSequence charSequence = str;
        if (!(charSequence == null || kotlin.m.p.a(charSequence))) {
            j.a aVar = j.f25593a;
            CJRFlightSearchInput value = this.searchInput.getValue();
            if (value == null) {
                k.a();
            }
            k.a((Object) value, "searchInput.value!!");
            String journeyType = value.getJourneyType();
            k.a((Object) journeyType, "searchInput.value!!.journeyType");
            k.c(str, CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
            k.c(journeyType, "journeyDetailType");
            HashMap hashMap = new HashMap();
            Map map = hashMap;
            map.put("event_label", str);
            map.put("event_label2", journeyType);
            map.put("event_label3", "fare strip");
            j.a.a("fare_calendar_date_picked", (HashMap<String, Object>) hashMap);
            CJRFlightSearchInput value2 = this.searchInput.getValue();
            if (value2 == null) {
                k.a();
            }
            k.a((Object) value2, "this.searchInput.value!!");
            value2.setDate(str);
            CJRFlightSearchInput value3 = this.searchInput.getValue();
            if (value3 == null) {
                k.a();
            }
            k.a((Object) value3, "this.searchInput.value!!");
            refresh(context, value3);
        }
    }

    public static /* synthetic */ void openCalendar$default(SRPSharedViewModel sRPSharedViewModel, Context context, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        sRPSharedViewModel.openCalendar(context, z);
    }

    public final void openCalendar(Context context, boolean z) {
        OpenCalendar openCalendar;
        Context context2 = context;
        k.c(context2, "context");
        j.a aVar = j.f25593a;
        CJRFlightSearchInput value = this.searchInput.getValue();
        if (value == null) {
            k.a();
        }
        k.a((Object) value, "searchInput.value!!");
        String journeyType = value.getJourneyType();
        k.a((Object) journeyType, "searchInput.value!!.journeyType");
        k.c(journeyType, "journeyDetailType");
        HashMap hashMap = new HashMap();
        hashMap.put("event_label2", journeyType);
        j.a.a("fare_calendar_clicked", (HashMap<String, Object>) hashMap);
        CJRFlightSearchInput value2 = this.searchInput.getValue();
        Integer num = null;
        String h2 = com.paytm.utility.b.h(value2 != null ? value2.getDate() : null, "yyyy-MM-dd", "E, dd MMM yy");
        CJRFlightSearchInput value3 = this.searchInput.getValue();
        String h3 = com.paytm.utility.b.h(value3 != null ? value3.getReturnDate() : null, "yyyy-MM-dd", "E, dd MMM yy");
        String string = context.getResources().getString(R.string.flight_select_return_date);
        k.a((Object) string, "context.resources.getStr…light_select_return_date)");
        CJRFlightSearchInput value4 = this.searchInput.getValue();
        boolean z2 = (value4 != null ? value4.getReturnDate() : null) != null;
        if (h3 != null) {
            string = com.paytm.utility.b.d(h3, "E, dd MMM yy", "dd MMMM yy");
            k.a((Object) string, "CJRAppCommonUtility.form…S_HOMESCREEN_DATE_FORMAT)");
        }
        String d2 = com.paytm.utility.b.d(h2, "E, dd MMM yy", "dd MMMM yy");
        Bundle bundle = new Bundle();
        bundle.putString(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR, d2);
        bundle.putString("intent_type", "intent_extra_selected_depart_date");
        bundle.putBoolean("intent_one_way_trip", !z2);
        CJRFlightSearchInput value5 = this.searchInput.getValue();
        bundle.putSerializable("flight_holiday_list", value5 != null ? value5.getmFlightHolidayList() : null);
        if (z2) {
            bundle.putString("flight_ticket_date_next_type", string);
            if (d2 != null && !kotlin.m.p.a(string, context2.getString(R.string.flight_select_return_date), true)) {
                bundle.putString("intent_extra_updated_depart_date", d2);
                bundle.putString("intent_extra_updated_return_date", string);
            }
            if (d2 != null && kotlin.m.p.a(string, context2.getString(R.string.flight_select_return_date), true)) {
                bundle.putString("intent_extra_reseted_depart_date", d2);
            }
        } else if (!kotlin.m.p.a(d2, "Depart Date", true)) {
            bundle.putString("intent_extra_updated_depart_date", d2);
        }
        bundle.putString(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR, string);
        bundle.putString("flight_return_date", h3);
        CJRFlightSearchInput value6 = this.searchInput.getValue();
        Integer valueOf = value6 != null ? Integer.valueOf(value6.getmCount_adults()) : null;
        if (valueOf == null) {
            k.a();
        }
        bundle.putInt("intent_extra_flight_search_no_of_adult_passengers", valueOf.intValue());
        CJRFlightSearchInput value7 = this.searchInput.getValue();
        Integer valueOf2 = value7 != null ? Integer.valueOf(value7.getmCount_childerns()) : null;
        if (valueOf2 == null) {
            k.a();
        }
        bundle.putInt("intent_extra_flight_search_no_of_child_passengers", valueOf2.intValue());
        CJRFlightSearchInput value8 = this.searchInput.getValue();
        Integer valueOf3 = value8 != null ? Integer.valueOf(value8.getmCount_infants()) : null;
        if (valueOf3 == null) {
            k.a();
        }
        bundle.putInt("intent_extra_flight_search_no_of_infants_passengers", valueOf3.intValue());
        CJRFlightSearchInput value9 = this.searchInput.getValue();
        bundle.putString("intent_extra_flight_destination_city_code", value9 != null ? value9.getDestCityCode() : null);
        CJRFlightSearchInput value10 = this.searchInput.getValue();
        bundle.putString("intent_extra_flight_source_city_code", value10 != null ? value10.getSourceCityCode() : null);
        CJRFlightSearchInput value11 = this.searchInput.getValue();
        if ((value11 != null ? value11.getClassType() : null) != null) {
            CJRFlightSearchInput value12 = this.searchInput.getValue();
            bundle.putString("intent_extra_flight_class_type", value12 != null ? value12.getClassType() : null);
        }
        bundle.putBoolean("flight-fare-api-called", true);
        bundle.putBoolean("is_from_search_modification", true);
        CJRFlightSearchInput value13 = this.searchInput.getValue();
        Integer valueOf4 = value13 != null ? Integer.valueOf(value13.getmCount_adults()) : null;
        if (valueOf4 == null) {
            k.a();
        }
        valueOf4.intValue();
        CJRFlightSearchInput value14 = this.searchInput.getValue();
        Integer valueOf5 = value14 != null ? Integer.valueOf(value14.getmCount_childerns()) : null;
        if (valueOf5 == null) {
            k.a();
        }
        valueOf5.intValue();
        CJRFlightSearchInput value15 = this.searchInput.getValue();
        if (value15 != null) {
            num = Integer.valueOf(value15.getmCount_infants());
        }
        if (num == null) {
            k.a();
        }
        num.intValue();
        String a2 = c.a(context);
        if (z2) {
            int i2 = z ? 3 : 2;
            m mVar = m.DEPART;
            k.a((Object) d2, "checkInDateYear");
            k.a((Object) a2, "fareDisclaimer");
            openCalendar = new OpenCalendar.OpenTwoWayCalendar(mVar, d2, 0, string, a2, i2);
        } else {
            int i3 = z ? 4 : 1;
            k.a((Object) d2, "checkInDateYear");
            k.a((Object) a2, "fareDisclaimer");
            openCalendar = new OpenCalendar.OpenOneWayCalendar(d2, 0, a2, i3);
        }
        this.openCalendarEvent.setValue(openCalendar);
        y.a aVar2 = com.travel.flight.flightSRPV2.a.y.f24137a;
        Application application = getApplication();
        k.a((Object) application, "getApplication()");
        Context context3 = application;
        CJRFlightSearchInput value16 = this.searchInput.getValue();
        if (value16 == null) {
            k.a();
        }
        k.a((Object) value16, "searchInput.value!!");
        y.a.a(context3, value16, "searchpage", "searchpage", this, z2);
    }

    private final void handleFareAlertActionSuccess(CJRFareAlertsSubscribeResponse cJRFareAlertsSubscribeResponse) {
        if (kotlin.m.p.a(cJRFareAlertsSubscribeResponse.message, "success", true)) {
            androidx.lifecycle.y<Boolean> yVar = this.isFareAlertSelected;
            Boolean value = yVar.getValue();
            if (value == null) {
                k.a();
            }
            yVar.setValue(Boolean.valueOf(!value.booleanValue()));
            Boolean value2 = this.isFareAlertSelected.getValue();
            if (value2 == null) {
                k.a();
            }
            k.a((Object) value2, "isFareAlertSelected.value!!");
            if (value2.booleanValue()) {
                this.fareAlertEvent.setValue(new l(1, cJRFareAlertsSubscribeResponse.body));
            } else {
                this.fareAlertEvent.setValue(new l(2, cJRFareAlertsSubscribeResponse.body));
            }
        } else {
            this.fareAlertEvent.setValue(new l(3, cJRFareAlertsSubscribeResponse.body));
        }
    }

    public final void toggleFareAlert() {
        if (!com.paytm.utility.b.c((Context) getApplication())) {
            this.dialogEvent.postValue(new com.travel.flight.flightSRPV2.b.b(Integer.valueOf(R.string.no_connection), Integer.valueOf(R.string.no_internet)));
        } else if (k.a((Object) this.isFareAlertSelected.getValue(), (Object) Boolean.TRUE)) {
            y.a aVar = com.travel.flight.flightSRPV2.a.y.f24137a;
            Application application = getApplication();
            k.a((Object) application, "getApplication()");
            Context context = application;
            CJRFlightSearchInput value = this.searchInput.getValue();
            if (value == null) {
                k.a();
            }
            k.a((Object) value, "this.searchInput.value!!");
            CJRFlightSearchInput cJRFlightSearchInput = value;
            b bVar = this;
            k.c(context, "context");
            k.c(cJRFlightSearchInput, "mFlightSearchInput");
            k.c(bVar, "responseListener");
            String sourceCityCode = cJRFlightSearchInput.getSourceCityCode();
            String destCityCode = cJRFlightSearchInput.getDestCityCode();
            context.getApplicationContext();
            com.travel.flight.flightticket.e.b.b(context, sourceCityCode, destCityCode, com.paytm.utility.b.d(cJRFlightSearchInput.getDate(), "yyyy-MM-dd", "yyyyMMdd"), new CJRFareAlertsSubscribeResponse(), bVar);
        } else {
            y.a aVar2 = com.travel.flight.flightSRPV2.a.y.f24137a;
            Application application2 = getApplication();
            k.a((Object) application2, "getApplication()");
            Context context2 = application2;
            CJRFlightSearchInput value2 = this.searchInput.getValue();
            if (value2 == null) {
                k.a();
            }
            k.a((Object) value2, "this.searchInput.value!!");
            CJRFlightSearchInput cJRFlightSearchInput2 = value2;
            b bVar2 = this;
            k.c(context2, "context");
            k.c(cJRFlightSearchInput2, "flightSearchInput");
            k.c(bVar2, "responseListener");
            if (com.paytm.utility.b.c(context2)) {
                String sourceCityCode2 = cJRFlightSearchInput2.getSourceCityCode();
                String destCityCode2 = cJRFlightSearchInput2.getDestCityCode();
                context2.getApplicationContext();
                com.travel.flight.flightticket.e.b.a(context2, com.paytm.utility.b.d(cJRFlightSearchInput2.getDate(), "yyyy-MM-dd", "yyyyMMdd"), sourceCityCode2, destCityCode2, new CJRFareAlertsSubscribeResponse(), bVar2);
            }
        }
    }

    public final void onCleared() {
        cancelSecondaryAPITask();
        super.onCleared();
    }

    public final void sendPulseEventNonStopSelected(boolean z) {
        String str = z ? "On" : "Off";
        j.a aVar = j.f25593a;
        j.a aVar2 = j.f25593a;
        CJRFlightSearchInput value = this.searchInput.getValue();
        if (value == null) {
            k.a();
        }
        k.a((Object) value, "searchInput.value!!");
        Application application = getApplication();
        k.a((Object) application, "this@SRPSharedViewModel.getApplication()");
        j.a.a("non_stop_only_selected", j.a.a(value, str, (String) null, (String) null, false, application));
    }

    public final void sendPulseEventModifySearchButtonClicked(CJRFlightSearchInput cJRFlightSearchInput) {
        k.c(cJRFlightSearchInput, "searchInput");
        this.searchInput.setValue(cJRFlightSearchInput);
        CJRFlightSearchInput value = this.searchInput.getValue();
        if (value == null) {
            k.a();
        }
        k.a((Object) value, "this.searchInput.value!!");
        value.setJourneyDetailType("");
        CJRFlightSearchInput value2 = this.searchInput.getValue();
        if (value2 == null) {
            k.a();
        }
        k.a((Object) value2, "this.searchInput.value!!");
        value2.setJourneyType("");
        j.a aVar = j.f25593a;
        j.a aVar2 = j.f25593a;
        Application application = getApplication();
        k.a((Object) application, "this@SRPSharedViewModel.getApplication()");
        j.a.a("srp_search_flights_clicked", j.a.a(cJRFlightSearchInput, (String) null, (String) null, (String) null, false, application));
    }

    public final void sendPulseEventFlightSelected(String str) {
        k.c(str, "airline");
        j.a aVar = j.f25593a;
        j.a aVar2 = j.f25593a;
        CJRFlightSearchInput value = this.searchInput.getValue();
        if (value == null) {
            k.a();
        }
        k.a((Object) value, "searchInput.value!!");
        Application application = getApplication();
        k.a((Object) application, "this@SRPSharedViewModel.getApplication()");
        j.a.a("flight_selected", j.a.a(value, (String) null, (String) null, str, true, application));
    }

    public static abstract class OpenCalendar {
        private final String fareDisclaimer;
        private final int requestCode;

        public static final class OpenOneWayCalendar extends OpenCalendar {
            private final String fareDisc;
            private final long previouslySelectedDate;
            private final int reqCode;
            private final String selectedDate;

            private final String component3() {
                return this.fareDisc;
            }

            private final int component4() {
                return this.reqCode;
            }

            public static /* synthetic */ OpenOneWayCalendar copy$default(OpenOneWayCalendar openOneWayCalendar, String str, long j, String str2, int i2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    str = openOneWayCalendar.selectedDate;
                }
                if ((i3 & 2) != 0) {
                    j = openOneWayCalendar.previouslySelectedDate;
                }
                long j2 = j;
                if ((i3 & 4) != 0) {
                    str2 = openOneWayCalendar.fareDisc;
                }
                String str3 = str2;
                if ((i3 & 8) != 0) {
                    i2 = openOneWayCalendar.reqCode;
                }
                return openOneWayCalendar.copy(str, j2, str3, i2);
            }

            public final String component1() {
                return this.selectedDate;
            }

            public final long component2() {
                return this.previouslySelectedDate;
            }

            public final OpenOneWayCalendar copy(String str, long j, String str2, int i2) {
                k.c(str, "selectedDate");
                k.c(str2, "fareDisc");
                return new OpenOneWayCalendar(str, j, str2, i2);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof OpenOneWayCalendar)) {
                    return false;
                }
                OpenOneWayCalendar openOneWayCalendar = (OpenOneWayCalendar) obj;
                return k.a((Object) this.selectedDate, (Object) openOneWayCalendar.selectedDate) && this.previouslySelectedDate == openOneWayCalendar.previouslySelectedDate && k.a((Object) this.fareDisc, (Object) openOneWayCalendar.fareDisc) && this.reqCode == openOneWayCalendar.reqCode;
            }

            public final int hashCode() {
                String str = this.selectedDate;
                int i2 = 0;
                int hashCode = str != null ? str.hashCode() : 0;
                long j = this.previouslySelectedDate;
                int i3 = ((hashCode * 31) + ((int) (j ^ (j >>> 32)))) * 31;
                String str2 = this.fareDisc;
                if (str2 != null) {
                    i2 = str2.hashCode();
                }
                return ((i3 + i2) * 31) + this.reqCode;
            }

            public final String toString() {
                return "OpenOneWayCalendar(selectedDate=" + this.selectedDate + ", previouslySelectedDate=" + this.previouslySelectedDate + ", fareDisc=" + this.fareDisc + ", reqCode=" + this.reqCode + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public OpenOneWayCalendar(String str, long j, String str2, int i2) {
                super(str2, i2, (g) null);
                k.c(str, "selectedDate");
                k.c(str2, "fareDisc");
                this.selectedDate = str;
                this.previouslySelectedDate = j;
                this.fareDisc = str2;
                this.reqCode = i2;
            }

            public final long getPreviouslySelectedDate() {
                return this.previouslySelectedDate;
            }

            public final String getSelectedDate() {
                return this.selectedDate;
            }
        }

        private OpenCalendar(String str, int i2) {
            this.fareDisclaimer = str;
            this.requestCode = i2;
        }

        public /* synthetic */ OpenCalendar(String str, int i2, g gVar) {
            this(str, i2);
        }

        public final String getFareDisclaimer() {
            return this.fareDisclaimer;
        }

        public final int getRequestCode() {
            return this.requestCode;
        }

        public static final class OpenTwoWayCalendar extends OpenCalendar {
            private final String departDateWIthYear;
            private final String fareDisc;
            private final long previouslySelectedDate;
            private final int reqCode;
            private final String returnDateWithYear;
            private final m tabTypeToOpenInitially;

            private final String component5() {
                return this.fareDisc;
            }

            private final int component6() {
                return this.reqCode;
            }

            public static /* synthetic */ OpenTwoWayCalendar copy$default(OpenTwoWayCalendar openTwoWayCalendar, m mVar, String str, long j, String str2, String str3, int i2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    mVar = openTwoWayCalendar.tabTypeToOpenInitially;
                }
                if ((i3 & 2) != 0) {
                    str = openTwoWayCalendar.departDateWIthYear;
                }
                String str4 = str;
                if ((i3 & 4) != 0) {
                    j = openTwoWayCalendar.previouslySelectedDate;
                }
                long j2 = j;
                if ((i3 & 8) != 0) {
                    str2 = openTwoWayCalendar.returnDateWithYear;
                }
                String str5 = str2;
                if ((i3 & 16) != 0) {
                    str3 = openTwoWayCalendar.fareDisc;
                }
                String str6 = str3;
                if ((i3 & 32) != 0) {
                    i2 = openTwoWayCalendar.reqCode;
                }
                return openTwoWayCalendar.copy(mVar, str4, j2, str5, str6, i2);
            }

            public final m component1() {
                return this.tabTypeToOpenInitially;
            }

            public final String component2() {
                return this.departDateWIthYear;
            }

            public final long component3() {
                return this.previouslySelectedDate;
            }

            public final String component4() {
                return this.returnDateWithYear;
            }

            public final OpenTwoWayCalendar copy(m mVar, String str, long j, String str2, String str3, int i2) {
                k.c(mVar, "tabTypeToOpenInitially");
                k.c(str, "departDateWIthYear");
                k.c(str3, "fareDisc");
                return new OpenTwoWayCalendar(mVar, str, j, str2, str3, i2);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof OpenTwoWayCalendar)) {
                    return false;
                }
                OpenTwoWayCalendar openTwoWayCalendar = (OpenTwoWayCalendar) obj;
                return k.a((Object) this.tabTypeToOpenInitially, (Object) openTwoWayCalendar.tabTypeToOpenInitially) && k.a((Object) this.departDateWIthYear, (Object) openTwoWayCalendar.departDateWIthYear) && this.previouslySelectedDate == openTwoWayCalendar.previouslySelectedDate && k.a((Object) this.returnDateWithYear, (Object) openTwoWayCalendar.returnDateWithYear) && k.a((Object) this.fareDisc, (Object) openTwoWayCalendar.fareDisc) && this.reqCode == openTwoWayCalendar.reqCode;
            }

            public final int hashCode() {
                m mVar = this.tabTypeToOpenInitially;
                int i2 = 0;
                int hashCode = (mVar != null ? mVar.hashCode() : 0) * 31;
                String str = this.departDateWIthYear;
                int hashCode2 = str != null ? str.hashCode() : 0;
                long j = this.previouslySelectedDate;
                int i3 = (((hashCode + hashCode2) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
                String str2 = this.returnDateWithYear;
                int hashCode3 = (i3 + (str2 != null ? str2.hashCode() : 0)) * 31;
                String str3 = this.fareDisc;
                if (str3 != null) {
                    i2 = str3.hashCode();
                }
                return ((hashCode3 + i2) * 31) + this.reqCode;
            }

            public final String toString() {
                return "OpenTwoWayCalendar(tabTypeToOpenInitially=" + this.tabTypeToOpenInitially + ", departDateWIthYear=" + this.departDateWIthYear + ", previouslySelectedDate=" + this.previouslySelectedDate + ", returnDateWithYear=" + this.returnDateWithYear + ", fareDisc=" + this.fareDisc + ", reqCode=" + this.reqCode + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public OpenTwoWayCalendar(m mVar, String str, long j, String str2, String str3, int i2) {
                super(str3, i2, (g) null);
                k.c(mVar, "tabTypeToOpenInitially");
                k.c(str, "departDateWIthYear");
                k.c(str3, "fareDisc");
                this.tabTypeToOpenInitially = mVar;
                this.departDateWIthYear = str;
                this.previouslySelectedDate = j;
                this.returnDateWithYear = str2;
                this.fareDisc = str3;
                this.reqCode = i2;
            }

            public final String getDepartDateWIthYear() {
                return this.departDateWIthYear;
            }

            public final long getPreviouslySelectedDate() {
                return this.previouslySelectedDate;
            }

            public final String getReturnDateWithYear() {
                return this.returnDateWithYear;
            }

            public final m getTabTypeToOpenInitially() {
                return this.tabTypeToOpenInitially;
            }
        }
    }
}
