package com.travel.flight.flightSRPV2.viewModel;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.cdn.ResourceUtils;
import com.travel.flight.R;
import com.travel.flight.flightSRPV2.b.a;
import com.travel.flight.flightSRPV2.b.b;
import com.travel.flight.pojo.flightticket.CJRFlightDetails;
import com.travel.flight.pojo.flightticket.CJRFlightDetailsItem;
import com.travel.flight.pojo.flightticket.CJRFlightPrice;
import com.travel.flight.pojo.flightticket.CJRFlightSearchInput;
import com.travel.flight.pojo.flightticket.CJRFlightSearchResult;
import com.travel.flight.pojo.flightticket.CJRFlightStops;
import com.travel.flight.pojo.flightticket.CJRIntlFlightList;
import com.travel.flight.pojo.flightticket.CJRIntlFlightMapping;
import com.travel.flight.pojo.flightticket.CJROnwardFlights;
import com.travel.flight.utils.c;
import com.travel.utils.n;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class IRTSplitViewModel extends ai {
    public static final Companion Companion = new Companion((g) null);
    private final SRPSharedViewModel parentViewModel;
    private int prevPositionLeft;
    private int prevPositionRight;
    private CJRFlightDetailsItem selectedOnwardFlight;
    private CJRFlightDetailsItem selectedReturnFlight;
    private final y<Boolean> showPriceLayout = new y<>();

    public static final void setFlightImage(ImageView imageView, String str) {
        Companion.setFlightImage(imageView, str);
    }

    public static final void setFlightTime(TextView textView, CJRFlightDetailsItem cJRFlightDetailsItem) {
        Companion.setFlightTime(textView, cJRFlightDetailsItem);
    }

    public static final void setOnwardFlightCountText(TextView textView, CJRIntlFlightList cJRIntlFlightList) {
        Companion.setOnwardFlightCountText(textView, cJRIntlFlightList);
    }

    public static final void setOriginAndDestination(TextView textView, CJRFlightDetailsItem cJRFlightDetailsItem) {
        Companion.setOriginAndDestination(textView, cJRFlightDetailsItem);
    }

    public static final void setReturnFlightCountText(TextView textView, CJRIntlFlightList cJRIntlFlightList) {
        Companion.setReturnFlightCountText(textView, cJRIntlFlightList);
    }

    public IRTSplitViewModel(SRPSharedViewModel sRPSharedViewModel) {
        k.c(sRPSharedViewModel, "parentViewModel");
        this.parentViewModel = sRPSharedViewModel;
        this.showPriceLayout.setValue(Boolean.FALSE);
        setupInitialAdapterView();
    }

    public final SRPSharedViewModel getParentViewModel() {
        return this.parentViewModel;
    }

    public final y<Boolean> getShowPriceLayout() {
        return this.showPriceLayout;
    }

    public final void onUnSelectableOverlayClick(Context context) {
        k.c(context, "context");
        Toast makeText = Toast.makeText(context, context.getResources().getString(R.string.flight_we_are_sorry) + " " + context.getResources().getString(R.string.flight_combination_criteria_not_matched), 0);
        makeText.setGravity(81, 0, 0);
        makeText.show();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0010, code lost:
        r0 = r0.getmIntOnwardFlightList();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setupInitialAdapterView() {
        /*
            r9 = this;
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r0 = r9.parentViewModel
            androidx.lifecycle.y r0 = r0.getIrtSplitViewFlightItem()
            java.lang.Object r0 = r0.getValue()
            com.travel.flight.pojo.flightticket.CJRIntlFlightList r0 = (com.travel.flight.pojo.flightticket.CJRIntlFlightList) r0
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L_0x001d
            java.util.ArrayList r0 = r0.getmIntOnwardFlightList()
            if (r0 == 0) goto L_0x001d
            java.lang.Object r0 = r0.get(r2)
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = (com.travel.flight.pojo.flightticket.CJRFlightDetailsItem) r0
            goto L_0x001e
        L_0x001d:
            r0 = r1
        L_0x001e:
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r3 = r9.parentViewModel
            androidx.lifecycle.y r3 = r3.getIrtSplitViewFlightItem()
            java.lang.Object r3 = r3.getValue()
            com.travel.flight.pojo.flightticket.CJRIntlFlightList r3 = (com.travel.flight.pojo.flightticket.CJRIntlFlightList) r3
            if (r3 == 0) goto L_0x0030
            java.util.ArrayList r1 = r3.getmIntReturnFlightList()
        L_0x0030:
            if (r0 == 0) goto L_0x007c
            if (r1 == 0) goto L_0x007c
            int r3 = r1.size()
            if (r3 <= 0) goto L_0x007c
            r3 = 1
            r9.onParentItemClick(r0, r2, r3, r2)
            r4 = r1
            java.util.Collection r4 = (java.util.Collection) r4
            int r4 = r4.size()
            r5 = 0
        L_0x0046:
            if (r5 >= r4) goto L_0x007c
            java.lang.Object r6 = r1.get(r5)
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r6 = (com.travel.flight.pojo.flightticket.CJRFlightDetailsItem) r6
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = r0.getmFlightId()
            r7.append(r8)
            java.lang.String r8 = ":"
            r7.append(r8)
            java.lang.String r8 = r6.getmFlightId()
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            boolean r7 = r9.combinationCriteriaMatched(r7)
            if (r7 == 0) goto L_0x0079
            java.lang.String r0 = "returnFlight"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r0)
            r9.onParentItemClick(r6, r5, r2, r3)
            return
        L_0x0079:
            int r5 = r5 + 1
            goto L_0x0046
        L_0x007c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightSRPV2.viewModel.IRTSplitViewModel.setupInitialAdapterView():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000f, code lost:
        r0 = r0.getChildItems();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean combinationCriteriaMatched(java.lang.String r6) {
        /*
            r5 = this;
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r0 = r5.parentViewModel
            androidx.lifecycle.y r0 = r0.getIrtSplitViewFlightItem()
            java.lang.Object r0 = r0.getValue()
            com.travel.flight.pojo.flightticket.CJRIntlFlightList r0 = (com.travel.flight.pojo.flightticket.CJRIntlFlightList) r0
            r1 = 0
            if (r0 == 0) goto L_0x001c
            java.util.ArrayList r0 = r0.getChildItems()
            if (r0 == 0) goto L_0x001c
            java.util.Collection r0 = (java.util.Collection) r0
            kotlin.j.d r0 = kotlin.a.k.a((java.util.Collection<?>) r0)
            goto L_0x001d
        L_0x001c:
            r0 = r1
        L_0x001d:
            if (r0 != 0) goto L_0x0022
            kotlin.g.b.k.a()
        L_0x0022:
            int r2 = r0.f47939a
            int r0 = r0.f47940b
            if (r2 > r0) goto L_0x007c
        L_0x0028:
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r3 = r5.parentViewModel
            androidx.lifecycle.y r3 = r3.getIrtSplitViewFlightItem()
            java.lang.Object r3 = r3.getValue()
            com.travel.flight.pojo.flightticket.CJRIntlFlightList r3 = (com.travel.flight.pojo.flightticket.CJRIntlFlightList) r3
            if (r3 == 0) goto L_0x003b
            java.util.ArrayList r3 = r3.getChildItems()
            goto L_0x003c
        L_0x003b:
            r3 = r1
        L_0x003c:
            if (r3 != 0) goto L_0x0041
            kotlin.g.b.k.a()
        L_0x0041:
            java.lang.Object r3 = r3.get(r2)
            if (r3 == 0) goto L_0x0077
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r3 = r5.parentViewModel
            androidx.lifecycle.y r3 = r3.getIrtSplitViewFlightItem()
            java.lang.Object r3 = r3.getValue()
            com.travel.flight.pojo.flightticket.CJRIntlFlightList r3 = (com.travel.flight.pojo.flightticket.CJRIntlFlightList) r3
            if (r3 == 0) goto L_0x005a
            java.util.ArrayList r3 = r3.getChildItems()
            goto L_0x005b
        L_0x005a:
            r3 = r1
        L_0x005b:
            if (r3 != 0) goto L_0x0060
            kotlin.g.b.k.a()
        L_0x0060:
            java.lang.Object r3 = r3.get(r2)
            java.lang.String r4 = "parentViewModel.irtSplit…em.value?.childItems!![i]"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            com.travel.flight.pojo.flightticket.CJRIntlFlightMapping r3 = (com.travel.flight.pojo.flightticket.CJRIntlFlightMapping) r3
            java.lang.String r3 = r3.getFlightId()
            r4 = 1
            boolean r3 = kotlin.m.p.a((java.lang.String) r6, (java.lang.String) r3, (boolean) r4)
            if (r3 == 0) goto L_0x0077
            return r4
        L_0x0077:
            if (r2 == r0) goto L_0x007c
            int r2 = r2 + 1
            goto L_0x0028
        L_0x007c:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightSRPV2.viewModel.IRTSplitViewModel.combinationCriteriaMatched(java.lang.String):boolean");
    }

    private final void updateSelectableItemsForCurrentItem(boolean z) {
        CJRIntlFlightList value = this.parentViewModel.getIrtSplitViewFlightItem().getValue();
        if (value == null) {
            k.a();
        }
        int size = value.getmIntReturnFlightList().size();
        for (int i2 = 0; i2 < size; i2++) {
            CJRIntlFlightList value2 = this.parentViewModel.getIrtSplitViewFlightItem().getValue();
            if (value2 == null) {
                k.a();
            }
            CJRFlightDetailsItem cJRFlightDetailsItem = value2.getmIntReturnFlightList().get(i2);
            StringBuilder sb = new StringBuilder();
            CJRFlightDetailsItem cJRFlightDetailsItem2 = this.selectedOnwardFlight;
            if (cJRFlightDetailsItem2 == null) {
                k.a("selectedOnwardFlight");
            }
            sb.append(cJRFlightDetailsItem2.getmFlightId());
            sb.append(AppConstants.COLON);
            sb.append(cJRFlightDetailsItem.getmFlightId());
            String sb2 = sb.toString();
            k.a((Object) cJRFlightDetailsItem, "item");
            cJRFlightDetailsItem.setUnSelectable(!combinationCriteriaMatched(sb2));
            if (!combinationCriteriaMatched(sb2)) {
                cJRFlightDetailsItem.setSelected(false);
                if (z) {
                    CJRFlightDetailsItem cJRFlightDetailsItem3 = this.selectedReturnFlight;
                    if (cJRFlightDetailsItem3 == null) {
                        k.a("selectedReturnFlight");
                    }
                    if (k.a((Object) cJRFlightDetailsItem3.getmFlightId(), (Object) cJRFlightDetailsItem.getmFlightId())) {
                        this.showPriceLayout.setValue(Boolean.FALSE);
                    }
                }
            }
        }
    }

    public final void onParentItemClick(CJRFlightDetailsItem cJRFlightDetailsItem, int i2, boolean z, boolean z2) {
        k.c(cJRFlightDetailsItem, "flightItem");
        if (z) {
            CJRIntlFlightList value = this.parentViewModel.getIrtSplitViewFlightItem().getValue();
            if (value == null) {
                k.a();
            }
            k.a((Object) value, "parentViewModel.irtSplitViewFlightItem.value!!");
            CJRIntlFlightList cJRIntlFlightList = value;
            CJRFlightDetailsItem cJRFlightDetailsItem2 = cJRIntlFlightList.getmIntOnwardFlightList().get(this.prevPositionLeft);
            k.a((Object) cJRFlightDetailsItem2, "item.getmIntOnwardFlightList()[prevPositionLeft]");
            cJRFlightDetailsItem2.setSelected(false);
            this.parentViewModel.getIrtSplitViewFlightItem().setValue(cJRIntlFlightList);
            CJRFlightDetailsItem cJRFlightDetailsItem3 = cJRIntlFlightList.getmIntOnwardFlightList().get(i2);
            k.a((Object) cJRFlightDetailsItem3, "item.getmIntOnwardFlightList()[position]");
            cJRFlightDetailsItem3.setSelected(true);
            this.parentViewModel.getIrtSplitViewFlightItem().setValue(cJRIntlFlightList);
            this.prevPositionLeft = i2;
            this.selectedOnwardFlight = cJRFlightDetailsItem;
            if (z2) {
                CJRFlightDetailsItem cJRFlightDetailsItem4 = this.selectedOnwardFlight;
                if (cJRFlightDetailsItem4 == null) {
                    k.a("selectedOnwardFlight");
                }
                CJRFlightDetailsItem cJRFlightDetailsItem5 = this.selectedReturnFlight;
                if (cJRFlightDetailsItem5 == null) {
                    k.a("selectedReturnFlight");
                }
                checkForOverlapFourHourDiff(cJRFlightDetailsItem4, cJRFlightDetailsItem5);
            }
            updateSelectableItemsForCurrentItem(z2);
            return;
        }
        CJRIntlFlightList value2 = this.parentViewModel.getIrtSplitViewFlightItem().getValue();
        if (value2 == null) {
            k.a();
        }
        k.a((Object) value2, "parentViewModel.irtSplitViewFlightItem.value!!");
        CJRIntlFlightList cJRIntlFlightList2 = value2;
        CJRFlightDetailsItem cJRFlightDetailsItem6 = cJRIntlFlightList2.getmIntReturnFlightList().get(this.prevPositionRight);
        k.a((Object) cJRFlightDetailsItem6, "item.getmIntReturnFlightList()[prevPositionRight]");
        cJRFlightDetailsItem6.setSelected(false);
        this.parentViewModel.getIrtSplitViewFlightItem().setValue(cJRIntlFlightList2);
        CJRFlightDetailsItem cJRFlightDetailsItem7 = cJRIntlFlightList2.getmIntReturnFlightList().get(i2);
        k.a((Object) cJRFlightDetailsItem7, "item.getmIntReturnFlightList()[position]");
        cJRFlightDetailsItem7.setSelected(true);
        this.parentViewModel.getIrtSplitViewFlightItem().setValue(cJRIntlFlightList2);
        this.prevPositionRight = i2;
        this.selectedReturnFlight = cJRFlightDetailsItem;
        if (z2) {
            CJRFlightDetailsItem cJRFlightDetailsItem8 = this.selectedOnwardFlight;
            if (cJRFlightDetailsItem8 == null) {
                k.a("selectedOnwardFlight");
            }
            CJRFlightDetailsItem cJRFlightDetailsItem9 = this.selectedReturnFlight;
            if (cJRFlightDetailsItem9 == null) {
                k.a("selectedReturnFlight");
            }
            checkForOverlapFourHourDiff(cJRFlightDetailsItem8, cJRFlightDetailsItem9);
        }
    }

    public final void proceedToBook(CJRIntlFlightList cJRIntlFlightList) {
        ArrayList<CJRFlightStops> arrayList;
        ArrayList<CJRFlightStops> arrayList2;
        CJRFlightPrice cJRFlightPrice;
        CJRFlightPrice cJRFlightPrice2;
        k.c(cJRIntlFlightList, "flightInfo");
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
        CJRFlightDetailsItem cJRFlightDetailsItem = this.selectedOnwardFlight;
        if (cJRFlightDetailsItem == null) {
            k.a("selectedOnwardFlight");
        }
        cJRFlightDetails.setmOnwardJourney(cJRFlightDetailsItem);
        CJRFlightDetailsItem cJRFlightDetailsItem2 = this.selectedOnwardFlight;
        if (cJRFlightDetailsItem2 == null) {
            k.a("selectedOnwardFlight");
        }
        cJRFlightDetails.setOnwardMealsAvailable(cJRFlightDetailsItem2.getMealsAvaialable());
        CJRFlightDetailsItem cJRFlightDetailsItem3 = this.selectedReturnFlight;
        if (cJRFlightDetailsItem3 == null) {
            k.a("selectedReturnFlight");
        }
        cJRFlightDetails.setmReturnJourney(cJRFlightDetailsItem3);
        CJRFlightDetailsItem cJRFlightDetailsItem4 = this.selectedReturnFlight;
        if (cJRFlightDetailsItem4 == null) {
            k.a("selectedReturnFlight");
        }
        cJRFlightDetails.setReturnMealsAvailable(cJRFlightDetailsItem4.getMealsAvaialable());
        CJRFlightDetailsItem cJRFlightDetailsItem5 = this.selectedOnwardFlight;
        if (cJRFlightDetailsItem5 == null) {
            k.a("selectedOnwardFlight");
        }
        if (cJRFlightDetailsItem5.getmPrice() != null) {
            CJRFlightDetailsItem cJRFlightDetailsItem6 = this.selectedOnwardFlight;
            if (cJRFlightDetailsItem6 == null) {
                k.a("selectedOnwardFlight");
            }
            if (cJRFlightDetailsItem6.getmServiceProviderSelected() != null) {
                CJRFlightDetailsItem cJRFlightDetailsItem7 = this.selectedOnwardFlight;
                if (cJRFlightDetailsItem7 == null) {
                    k.a("selectedOnwardFlight");
                }
                cJRFlightPrice2 = cJRFlightDetailsItem7.getmServiceProviderSelected();
            } else {
                CJRFlightDetailsItem cJRFlightDetailsItem8 = this.selectedOnwardFlight;
                if (cJRFlightDetailsItem8 == null) {
                    k.a("selectedOnwardFlight");
                }
                cJRFlightPrice2 = cJRFlightDetailsItem8.getmPrice().get(0);
            }
            cJRFlightDetails.setmOnwardServiceProvider(cJRFlightPrice2.getmServiceProvider());
        }
        CJRFlightDetailsItem cJRFlightDetailsItem9 = this.selectedReturnFlight;
        if (cJRFlightDetailsItem9 == null) {
            k.a("selectedReturnFlight");
        }
        if (cJRFlightDetailsItem9.getmPrice() != null) {
            CJRFlightDetailsItem cJRFlightDetailsItem10 = this.selectedReturnFlight;
            if (cJRFlightDetailsItem10 == null) {
                k.a("selectedReturnFlight");
            }
            if (cJRFlightDetailsItem10.getmServiceProviderSelected() != null) {
                CJRFlightDetailsItem cJRFlightDetailsItem11 = this.selectedReturnFlight;
                if (cJRFlightDetailsItem11 == null) {
                    k.a("selectedReturnFlight");
                }
                cJRFlightPrice = cJRFlightDetailsItem11.getmServiceProviderSelected();
            } else {
                CJRFlightDetailsItem cJRFlightDetailsItem12 = this.selectedReturnFlight;
                if (cJRFlightDetailsItem12 == null) {
                    k.a("selectedReturnFlight");
                }
                cJRFlightPrice = cJRFlightDetailsItem12.getmPrice().get(0);
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
        CJRFlightDetailsItem cJRFlightDetailsItem13 = cJRIntlFlightList.getmOnwardFlights();
        Integer num = null;
        Integer valueOf = (cJRFlightDetailsItem13 == null || (arrayList2 = cJRFlightDetailsItem13.getmFlights()) == null) ? null : Integer.valueOf(arrayList2.size());
        if (valueOf == null) {
            k.a();
        }
        if (valueOf.intValue() > 0) {
            CJRFlightDetailsItem cJRFlightDetailsItem14 = cJRIntlFlightList.getmReturnFlights();
            if (!(cJRFlightDetailsItem14 == null || (arrayList = cJRFlightDetailsItem14.getmFlights()) == null)) {
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

    private final boolean checkForOverlapFourHourDiff(CJRFlightDetailsItem cJRFlightDetailsItem, CJRFlightDetailsItem cJRFlightDetailsItem2) {
        boolean checkFlightOverlaps = checkFlightOverlaps(cJRFlightDetailsItem, cJRFlightDetailsItem2, false);
        boolean checkFlightOverFourHourDifference = checkFlightOverFourHourDifference(cJRFlightDetailsItem, cJRFlightDetailsItem2);
        this.showPriceLayout.setValue(Boolean.valueOf(!checkFlightOverlaps && !checkFlightOverFourHourDifference));
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

        public final void setOnwardFlightCountText(TextView textView, CJRIntlFlightList cJRIntlFlightList) {
            k.c(textView, "textView");
            if ((cJRIntlFlightList != null ? cJRIntlFlightList.getmIntOnwardFlightList() : null) != null && cJRIntlFlightList.getmIntOnwardFlightList().size() > 0) {
                if (cJRIntlFlightList.getmIntOnwardFlightList().size() > 1) {
                    textView.setText(textView.getContext().getString(R.string.internation_onward_flight_details_options, new Object[]{Integer.valueOf(cJRIntlFlightList.getmIntOnwardFlightList().size())}));
                } else {
                    textView.setText(textView.getContext().getString(R.string.internation_onward_flight_details__option, new Object[]{Integer.valueOf(cJRIntlFlightList.getmIntOnwardFlightList().size())}));
                }
            }
        }

        public final void setReturnFlightCountText(TextView textView, CJRIntlFlightList cJRIntlFlightList) {
            CharSequence charSequence;
            k.c(textView, "textView");
            if ((cJRIntlFlightList != null ? cJRIntlFlightList.getmIntReturnFlightList() : null) != null && cJRIntlFlightList.getmIntReturnFlightList().size() > 0) {
                if (cJRIntlFlightList.getmIntReturnFlightList().size() > 1) {
                    charSequence = textView.getContext().getString(R.string.internation_return_flight_details_options, new Object[]{Integer.valueOf(cJRIntlFlightList.getmIntReturnFlightList().size())});
                } else {
                    charSequence = textView.getContext().getString(R.string.internation_return_flight_details__option, new Object[]{Integer.valueOf(cJRIntlFlightList.getmIntReturnFlightList().size())});
                }
                textView.setText(charSequence);
            }
        }

        public final void setOriginAndDestination(TextView textView, CJRFlightDetailsItem cJRFlightDetailsItem) {
            k.c(textView, "textView");
            if ((cJRFlightDetailsItem != null ? cJRFlightDetailsItem.getmOrigin() : null) != null && cJRFlightDetailsItem.getmDestination() != null) {
                textView.setText(cJRFlightDetailsItem.getmOrigin() + "-" + cJRFlightDetailsItem.getmDestination());
            }
        }

        public final void setFlightTime(TextView textView, CJRFlightDetailsItem cJRFlightDetailsItem) {
            k.c(textView, "textView");
            if ((cJRFlightDetailsItem != null ? cJRFlightDetailsItem.getmDepartureTime() : null) != null && cJRFlightDetailsItem.getmArrivalTime() != null) {
                textView.setText(c.a(cJRFlightDetailsItem.getmDepartureTime()) + " - " + c.a(cJRFlightDetailsItem.getmArrivalTime()));
            }
        }

        public final void setFlightImage(ImageView imageView, String str) {
            k.c(imageView, "imageView");
            k.c(str, "loadSvg");
            ResourceUtils.loadFlightImagesFromCDN(imageView, str, false, false, n.a.V1);
        }
    }
}
