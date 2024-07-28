package com.travel.flight.flightSRPV2.viewModel;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.ai;
import com.travel.cdn.ResourceUtils;
import com.travel.common.R;
import com.travel.flight.flightSRPV2.a.y;
import com.travel.flight.flightSRPV2.b.a;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;
import com.travel.flight.flightticket.d.b;
import com.travel.flight.pojo.flightticket.CJRFlightSearchInput;
import com.travel.flight.utils.c;
import com.travel.flight.utils.j;
import com.travel.utils.m;
import com.travel.utils.n;
import java.io.Serializable;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;

public final class SRPModifyViewModel extends ai {
    public static final Companion Companion = new Companion((g) null);
    private final SRPSharedViewModel parentViewModel;

    public static final void setClassInfo(TextView textView, CJRFlightSearchInput cJRFlightSearchInput) {
        Companion.setClassInfo(textView, cJRFlightSearchInput);
    }

    public static final void setFlightJourneyDates(TextView textView, String str, int i2) {
        Companion.setFlightJourneyDates(textView, str, i2);
    }

    public static final void setPaxInfo(TextView textView, CJRFlightSearchInput cJRFlightSearchInput) {
        Companion.setPaxInfo(textView, cJRFlightSearchInput);
    }

    public static final void setRouteHeader(ImageView imageView, CJRFlightSearchInput cJRFlightSearchInput) {
        Companion.setRouteHeader(imageView, cJRFlightSearchInput);
    }

    public static final void setRouteSeparator(ImageView imageView, CJRFlightSearchInput cJRFlightSearchInput) {
        Companion.setRouteSeparator(imageView, cJRFlightSearchInput);
    }

    public SRPModifyViewModel(SRPSharedViewModel sRPSharedViewModel) {
        k.c(sRPSharedViewModel, "parentViewModel");
        this.parentViewModel = sRPSharedViewModel;
    }

    public final SRPSharedViewModel getParentViewModel() {
        return this.parentViewModel;
    }

    public final void onSourceCityClick() {
        CJRFlightSearchInput value = this.parentViewModel.getCopiedSearchInput().getValue();
        if ((value != null ? value.getBookingSegment() : null) != b.Modify) {
            this.parentViewModel.navigate(getActivityNavigationParamsForCityClick("source", 201));
        }
    }

    public final void onDestinationCityClick() {
        CJRFlightSearchInput value = this.parentViewModel.getCopiedSearchInput().getValue();
        if ((value != null ? value.getBookingSegment() : null) != b.Modify) {
            this.parentViewModel.navigate(getActivityNavigationParamsForCityClick("destination", 202));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0019, code lost:
        r4 = r4.getSource();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.travel.flight.flightSRPV2.b.a getActivityNavigationParamsForCityClick(java.lang.String r4, int r5) {
        /*
            r3 = this;
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r1 = "option"
            r0.putString(r1, r4)
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r4 = r3.parentViewModel
            androidx.lifecycle.y r4 = r4.getSearchInput()
            java.lang.Object r4 = r4.getValue()
            com.travel.flight.pojo.flightticket.CJRFlightSearchInput r4 = (com.travel.flight.pojo.flightticket.CJRFlightSearchInput) r4
            r1 = 0
            if (r4 == 0) goto L_0x0024
            com.travel.flight.pojo.flightticket.b r4 = r4.getSource()
            if (r4 == 0) goto L_0x0024
            java.lang.String r4 = r4.getCityName()
            goto L_0x0025
        L_0x0024:
            r4 = r1
        L_0x0025:
            java.lang.String r2 = "source"
            r0.putString(r2, r4)
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r4 = r3.parentViewModel
            androidx.lifecycle.y r4 = r4.getSearchInput()
            java.lang.Object r4 = r4.getValue()
            com.travel.flight.pojo.flightticket.CJRFlightSearchInput r4 = (com.travel.flight.pojo.flightticket.CJRFlightSearchInput) r4
            if (r4 == 0) goto L_0x0043
            com.travel.flight.pojo.flightticket.b r4 = r4.getDestination()
            if (r4 == 0) goto L_0x0043
            java.lang.String r1 = r4.getCityName()
        L_0x0043:
            java.lang.String r4 = "destination"
            r0.putString(r4, r1)
            r4 = 1
            java.lang.String r1 = "isd_from_search_modification"
            r0.putBoolean(r1, r4)
            com.travel.flight.flightSRPV2.b.a r1 = new com.travel.flight.flightSRPV2.b.a
            java.lang.String r2 = "PAGE_SELECT_AIRPORT"
            r1.<init>(r2, r0, r4, r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightSRPV2.viewModel.SRPModifyViewModel.getActivityNavigationParamsForCityClick(java.lang.String, int):com.travel.flight.flightSRPV2.b.a");
    }

    public final void onDepartureDateClick(Context context) {
        k.c(context, "context");
        this.parentViewModel.openCalendar(context, false);
    }

    public final void onReturnDateClick() {
        CJRFlightSearchInput value = this.parentViewModel.getCopiedSearchInput().getValue();
        Integer num = null;
        if ((value != null ? value.getBookingSegment() : null) != b.Modify) {
            CJRFlightSearchInput value2 = this.parentViewModel.getCopiedSearchInput().getValue();
            String h2 = com.paytm.utility.b.h(value2 != null ? value2.getReturnDate() : null, "yyyy-MM-dd", "dd MMMM yy");
            CJRFlightSearchInput value3 = this.parentViewModel.getCopiedSearchInput().getValue();
            String h3 = com.paytm.utility.b.h(value3 != null ? value3.getDate() : null, "yyyy-MM-dd", "dd MMMM yy");
            CJRFlightSearchInput value4 = this.parentViewModel.getCopiedSearchInput().getValue();
            boolean z = (value4 != null ? value4.getReturnDate() : null) != null;
            Bundle bundle = new Bundle();
            bundle.putString(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR, h2);
            bundle.putString("intent_type", "intent_extra_selected_return_date");
            bundle.putBoolean("intent_one_way_trip", !z);
            bundle.putString("flight_ticket_date_next_type", h3);
            if (!(h3 == null || h2 == null)) {
                bundle.putString("intent_extra_updated_depart_date", h3);
                bundle.putString("intent_extra_updated_return_date", h2);
            }
            CJRFlightSearchInput value5 = this.parentViewModel.getCopiedSearchInput().getValue();
            Integer valueOf = value5 != null ? Integer.valueOf(value5.getmCount_adults()) : null;
            if (valueOf == null) {
                k.a();
            }
            bundle.putInt("intent_extra_flight_search_no_of_adult_passengers", valueOf.intValue());
            CJRFlightSearchInput value6 = this.parentViewModel.getCopiedSearchInput().getValue();
            Integer valueOf2 = value6 != null ? Integer.valueOf(value6.getmCount_childerns()) : null;
            if (valueOf2 == null) {
                k.a();
            }
            bundle.putInt("intent_extra_flight_search_no_of_child_passengers", valueOf2.intValue());
            CJRFlightSearchInput value7 = this.parentViewModel.getCopiedSearchInput().getValue();
            Integer valueOf3 = value7 != null ? Integer.valueOf(value7.getmCount_infants()) : null;
            if (valueOf3 == null) {
                k.a();
            }
            bundle.putInt("intent_extra_flight_search_no_of_infants_passengers", valueOf3.intValue());
            bundle.putString("flight_depart_date", h3);
            bundle.putString(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR, h3);
            CJRFlightSearchInput value8 = this.parentViewModel.getCopiedSearchInput().getValue();
            bundle.putSerializable("flight_holiday_list", value8 != null ? value8.getmFlightHolidayList() : null);
            bundle.putBoolean("is_from_search_modification", true);
            CJRFlightSearchInput value9 = this.parentViewModel.getCopiedSearchInput().getValue();
            if ((value9 != null ? value9.getClassType() : null) != null) {
                CJRFlightSearchInput value10 = this.parentViewModel.getCopiedSearchInput().getValue();
                bundle.putString("intent_extra_flight_class_type", value10 != null ? value10.getClassType() : null);
            }
            bundle.putBoolean("flight-fare-api-called", true);
            SRPSharedViewModel sRPSharedViewModel = this.parentViewModel;
            CJRFlightSearchInput value11 = sRPSharedViewModel.getCopiedSearchInput().getValue();
            Integer valueOf4 = value11 != null ? Integer.valueOf(value11.getmCount_adults()) : null;
            if (valueOf4 == null) {
                k.a();
            }
            int intValue = valueOf4.intValue();
            CJRFlightSearchInput value12 = this.parentViewModel.getCopiedSearchInput().getValue();
            Integer valueOf5 = value12 != null ? Integer.valueOf(value12.getmCount_childerns()) : null;
            if (valueOf5 == null) {
                k.a();
            }
            int intValue2 = valueOf5.intValue();
            CJRFlightSearchInput value13 = this.parentViewModel.getCopiedSearchInput().getValue();
            if (value13 != null) {
                num = Integer.valueOf(value13.getmCount_infants());
            }
            if (num == null) {
                k.a();
            }
            String fareDisclaimer = sRPSharedViewModel.getFareDisclaimer(intValue, intValue2, num.intValue());
            com.travel.flight.flightSRPV2.c.b<SRPSharedViewModel.OpenCalendar> openCalendarEvent = this.parentViewModel.getOpenCalendarEvent();
            m mVar = m.RETURN;
            k.a((Object) h3, "checkInDateYear");
            k.a((Object) fareDisclaimer, "fareDisclaimer");
            openCalendarEvent.setValue(new SRPSharedViewModel.OpenCalendar.OpenTwoWayCalendar(mVar, h3, 0, h2, fareDisclaimer, 2));
            y.a aVar = y.f24137a;
            Application application = this.parentViewModel.getApplication();
            k.a((Object) application, "parentViewModel.getApplication()");
            Context context = application;
            CJRFlightSearchInput value14 = this.parentViewModel.getCopiedSearchInput().getValue();
            if (value14 == null) {
                k.a();
            }
            k.a((Object) value14, "parentViewModel.copiedSearchInput.value!!");
            y.a.a(context, value14, "searchpage", "searchpage", this.parentViewModel, true);
        }
    }

    public final void onPassengerInfoClick(Context context) {
        k.c(context, "context");
        CJRFlightSearchInput value = this.parentViewModel.getCopiedSearchInput().getValue();
        String str = null;
        if ((value != null ? value.getBookingSegment() : null) != b.Modify) {
            Bundle bundle = new Bundle();
            CJRFlightSearchInput value2 = this.parentViewModel.getCopiedSearchInput().getValue();
            Integer valueOf = value2 != null ? Integer.valueOf(value2.getmCount_adults()) : null;
            if (valueOf == null) {
                k.a();
            }
            bundle.putInt("intent_extra_flight_search_no_of_adult_passengers", valueOf.intValue());
            CJRFlightSearchInput value3 = this.parentViewModel.getCopiedSearchInput().getValue();
            Integer valueOf2 = value3 != null ? Integer.valueOf(value3.getmCount_childerns()) : null;
            if (valueOf2 == null) {
                k.a();
            }
            bundle.putInt("intent_extra_flight_search_no_of_child_passengers", valueOf2.intValue());
            CJRFlightSearchInput value4 = this.parentViewModel.getCopiedSearchInput().getValue();
            Integer valueOf3 = value4 != null ? Integer.valueOf(value4.getmCount_infants()) : null;
            if (valueOf3 == null) {
                k.a();
            }
            bundle.putInt("intent_extra_flight_search_no_of_infants_passengers", valueOf3.intValue());
            CJRFlightSearchInput value5 = this.parentViewModel.getCopiedSearchInput().getValue();
            if (value5 != null) {
                str = value5.getClassType();
            }
            if (str != null) {
                bundle.putString("intent_extra_trip_type", c.b(this.parentViewModel.getCopiedSearchInput().getValue(), context));
            }
            bundle.putBoolean("screen_type", true);
            this.parentViewModel.navigate(new a("PAGE_ADD_TRAVELLER", bundle, true, 205));
        }
    }

    public final void onSearchFlightClick(Context context) {
        k.c(context, "context");
        SRPSharedViewModel sRPSharedViewModel = this.parentViewModel;
        CJRFlightSearchInput value = sRPSharedViewModel.getCopiedSearchInput().getValue();
        if (value == null) {
            k.a();
        }
        k.a((Object) value, "parentViewModel.copiedSearchInput.value!!");
        sRPSharedViewModel.sendPulseEventModifySearchButtonClicked(value);
        this.parentViewModel.onBackPressed();
        SRPSharedViewModel sRPSharedViewModel2 = this.parentViewModel;
        CJRFlightSearchInput value2 = sRPSharedViewModel2.getCopiedSearchInput().getValue();
        if (value2 == null) {
            k.a();
        }
        k.a((Object) value2, "parentViewModel.copiedSearchInput.value!!");
        sRPSharedViewModel2.refresh(context, value2);
    }

    public final void setFromAndTo(Intent intent, int i2) {
        if (intent != null && intent.getBooleanExtra("is_recent_search_selected", false)) {
            Serializable serializableExtra = intent.getSerializableExtra("flight_source_recent_search_selected");
            if (serializableExtra != null) {
                com.travel.flight.pojo.flightticket.b bVar = (com.travel.flight.pojo.flightticket.b) serializableExtra;
                Serializable serializableExtra2 = intent.getSerializableExtra("flight_dest_recent_search_selected");
                if (serializableExtra2 != null) {
                    com.travel.flight.pojo.flightticket.b bVar2 = (com.travel.flight.pojo.flightticket.b) serializableExtra2;
                    CJRFlightSearchInput value = this.parentViewModel.getCopiedSearchInput().getValue();
                    if (value == null) {
                        k.a();
                    }
                    CJRFlightSearchInput cJRFlightSearchInput = value;
                    cJRFlightSearchInput.setDestination(bVar2);
                    cJRFlightSearchInput.setDestCityCode(bVar2.getShortCityName());
                    cJRFlightSearchInput.setSource(bVar);
                    cJRFlightSearchInput.setSourceCityCode(bVar.getShortCityName());
                    this.parentViewModel.getCopiedSearchInput().postValue(cJRFlightSearchInput);
                    return;
                }
                throw new u("null cannot be cast to non-null type com.travel.flight.pojo.flightticket.CJRAirportCityItem");
            }
            throw new u("null cannot be cast to non-null type com.travel.flight.pojo.flightticket.CJRAirportCityItem");
        } else if (intent != null && intent.hasExtra("intent_extra_selected_city_name")) {
            Serializable serializableExtra3 = intent.getSerializableExtra("intent_extra_selected_city_name");
            if (serializableExtra3 != null) {
                com.travel.flight.pojo.flightticket.b bVar3 = (com.travel.flight.pojo.flightticket.b) serializableExtra3;
                if (bVar3.getCityName() == null) {
                    return;
                }
                if (i2 == 202) {
                    CJRFlightSearchInput value2 = this.parentViewModel.getCopiedSearchInput().getValue();
                    if (value2 == null) {
                        k.a();
                    }
                    CJRFlightSearchInput cJRFlightSearchInput2 = value2;
                    cJRFlightSearchInput2.setDestination(bVar3);
                    cJRFlightSearchInput2.setDestCityCode(bVar3.getShortCityName());
                    this.parentViewModel.getCopiedSearchInput().postValue(cJRFlightSearchInput2);
                } else if (i2 == 201) {
                    CJRFlightSearchInput value3 = this.parentViewModel.getCopiedSearchInput().getValue();
                    if (value3 == null) {
                        k.a();
                    }
                    CJRFlightSearchInput cJRFlightSearchInput3 = value3;
                    cJRFlightSearchInput3.setSource(bVar3);
                    cJRFlightSearchInput3.setSourceCityCode(bVar3.getShortCityName());
                    this.parentViewModel.getCopiedSearchInput().postValue(cJRFlightSearchInput3);
                }
            } else {
                throw new u("null cannot be cast to non-null type com.travel.flight.pojo.flightticket.CJRAirportCityItem");
            }
        }
    }

    public final void setDateAndRefresh(Intent intent, Context context) {
        k.c(intent, "data");
        k.c(context, "context");
        setDate(intent, context);
        SRPSharedViewModel sRPSharedViewModel = this.parentViewModel;
        CJRFlightSearchInput value = sRPSharedViewModel.getCopiedSearchInput().getValue();
        if (value == null) {
            k.a();
        }
        k.a((Object) value, "parentViewModel.copiedSearchInput.value!!");
        sRPSharedViewModel.refresh(context, value);
    }

    public final void setDate(Intent intent, Context context) {
        k.c(intent, "data");
        k.c(context, "context");
        if (intent.hasExtra("intent_extra_selected_depart_date") && intent.hasExtra("intent_extra_selected_return_date")) {
            String stringExtra = intent.getStringExtra("intent_extra_selected_depart_date");
            String stringExtra2 = intent.getStringExtra("intent_extra_selected_return_date");
            CJRFlightSearchInput value = this.parentViewModel.getCopiedSearchInput().getValue();
            if (value == null) {
                k.a();
            }
            CJRFlightSearchInput cJRFlightSearchInput = value;
            cJRFlightSearchInput.setDate(com.paytm.utility.b.d(stringExtra, "dd MMM yy", "yyyy-MM-dd"));
            cJRFlightSearchInput.setReturnDate(com.paytm.utility.b.d(stringExtra2, "dd MMM yy", "yyyy-MM-dd"));
            this.parentViewModel.getCopiedSearchInput().postValue(cJRFlightSearchInput);
        } else if (intent.hasExtra("intent_extra_selected_depart_date")) {
            String stringExtra3 = intent.getStringExtra("intent_extra_selected_depart_date");
            CJRFlightSearchInput value2 = this.parentViewModel.getCopiedSearchInput().getValue();
            if (value2 == null) {
                k.a();
            }
            CJRFlightSearchInput cJRFlightSearchInput2 = value2;
            cJRFlightSearchInput2.setDate(com.paytm.utility.b.d(stringExtra3, "dd MMM yy", "yyyy-MM-dd"));
            this.parentViewModel.getCopiedSearchInput().postValue(cJRFlightSearchInput2);
        } else if (intent.hasExtra("intent_extra_selected_return_date")) {
            String stringExtra4 = intent.getStringExtra("intent_extra_selected_return_date");
            CJRFlightSearchInput value3 = this.parentViewModel.getCopiedSearchInput().getValue();
            if (value3 == null) {
                k.a();
            }
            CJRFlightSearchInput cJRFlightSearchInput3 = value3;
            cJRFlightSearchInput3.setReturnDate(com.paytm.utility.b.d(stringExtra4, "dd MMM yy", "yyyy-MM-dd"));
            this.parentViewModel.getCopiedSearchInput().postValue(cJRFlightSearchInput3);
        }
    }

    public final void setUpdatedTravellerInfo(Intent intent, Context context) {
        k.c(intent, "data");
        k.c(context, "context");
        int parseInt = Integer.parseInt(intent.getStringExtra("intent_extra_adult_passenger"));
        int parseInt2 = Integer.parseInt(intent.getStringExtra("intent_extra_infant_passenger"));
        int parseInt3 = Integer.parseInt(intent.getStringExtra("intent_extra_children_passenger"));
        String stringExtra = intent.getStringExtra("intent_extra_trip_type");
        k.a((Object) stringExtra, "data.getStringExtra(CJRC…T_EXTRA_FLIGHT_TRIP_TYPE)");
        CJRFlightSearchInput value = this.parentViewModel.getCopiedSearchInput().getValue();
        if (value == null) {
            k.a();
        }
        CJRFlightSearchInput cJRFlightSearchInput = value;
        cJRFlightSearchInput.setmCount_adults(parseInt);
        cJRFlightSearchInput.setmCount_childerns(parseInt3);
        cJRFlightSearchInput.setmCount_infants(parseInt2);
        j.a aVar = j.f25593a;
        cJRFlightSearchInput.setClassType(j.a.b(stringExtra, context));
        this.parentViewModel.getCopiedSearchInput().postValue(cJRFlightSearchInput);
    }

    public final void exchangeSourceAndDestination(String str, String str2) {
        k.c(str, "sourceCityCodeValue");
        k.c(str2, "destCityCodeValue");
        CJRFlightSearchInput value = this.parentViewModel.getCopiedSearchInput().getValue();
        com.travel.flight.pojo.flightticket.b bVar = null;
        com.travel.flight.pojo.flightticket.b source = value != null ? value.getSource() : null;
        CJRFlightSearchInput value2 = this.parentViewModel.getCopiedSearchInput().getValue();
        if (value2 != null) {
            bVar = value2.getDestination();
        }
        CJRFlightSearchInput value3 = this.parentViewModel.getCopiedSearchInput().getValue();
        if (value3 == null) {
            k.a();
        }
        CJRFlightSearchInput cJRFlightSearchInput = value3;
        cJRFlightSearchInput.setDestination(source);
        cJRFlightSearchInput.setDestCityCode(str);
        cJRFlightSearchInput.setSource(bVar);
        cJRFlightSearchInput.setSourceCityCode(str2);
        this.parentViewModel.getCopiedSearchInput().setValue(cJRFlightSearchInput);
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0068  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0072  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void setFlightJourneyDates(android.widget.TextView r5, java.lang.String r6, int r7) {
            /*
                r4 = this;
                java.lang.String r0 = "dateTextView"
                kotlin.g.b.k.c(r5, r0)
                if (r6 == 0) goto L_0x007a
                r5.getContext()
                java.lang.String r0 = "yyyy-MM-dd"
                java.lang.String r1 = "dd MMMM EEEE"
                java.lang.String r6 = com.paytm.utility.b.d((java.lang.String) r6, (java.lang.String) r0, (java.lang.String) r1)
                java.lang.String r0 = "date"
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r0)
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                kotlin.m.l r0 = new kotlin.m.l
                java.lang.String r1 = " "
                r0.<init>((java.lang.String) r1)
                r1 = 0
                java.util.List r6 = r0.split(r6, r1)
                boolean r0 = r6.isEmpty()
                if (r0 != 0) goto L_0x005a
                int r0 = r6.size()
                java.util.ListIterator r0 = r6.listIterator(r0)
            L_0x0034:
                boolean r2 = r0.hasPrevious()
                if (r2 == 0) goto L_0x005a
                java.lang.Object r2 = r0.previous()
                java.lang.String r2 = (java.lang.String) r2
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                int r2 = r2.length()
                r3 = 1
                if (r2 != 0) goto L_0x004b
                r2 = 1
                goto L_0x004c
            L_0x004b:
                r2 = 0
            L_0x004c:
                if (r2 != 0) goto L_0x0034
                java.lang.Iterable r6 = (java.lang.Iterable) r6
                int r0 = r0.nextIndex()
                int r0 = r0 + r3
                java.util.List r6 = kotlin.a.k.b(r6, (int) r0)
                goto L_0x005e
            L_0x005a:
                kotlin.a.w r6 = kotlin.a.w.INSTANCE
                java.util.List r6 = (java.util.List) r6
            L_0x005e:
                java.util.Collection r6 = (java.util.Collection) r6
                java.lang.String[] r0 = new java.lang.String[r1]
                java.lang.Object[] r6 = r6.toArray(r0)
                if (r6 == 0) goto L_0x0072
                java.lang.String[] r6 = (java.lang.String[]) r6
                r6 = r6[r7]
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                r5.setText(r6)
                goto L_0x007a
            L_0x0072:
                kotlin.u r5 = new kotlin.u
                java.lang.String r6 = "null cannot be cast to non-null type kotlin.Array<T>"
                r5.<init>(r6)
                throw r5
            L_0x007a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightSRPV2.viewModel.SRPModifyViewModel.Companion.setFlightJourneyDates(android.widget.TextView, java.lang.String, int):void");
        }

        public final void setPaxInfo(TextView textView, CJRFlightSearchInput cJRFlightSearchInput) {
            k.c(textView, "textView");
            if ((cJRFlightSearchInput == null || cJRFlightSearchInput.getmCount_adults() != 0) && ((cJRFlightSearchInput == null || cJRFlightSearchInput.getmCount_childerns() != 0) && (cJRFlightSearchInput == null || cJRFlightSearchInput.getmCount_infants() != 0))) {
                textView.setTextSize(2, 11.0f);
            } else {
                textView.setTextSize(2, 14.0f);
            }
            textView.setText(c.a(cJRFlightSearchInput, textView.getContext()));
        }

        public final void setClassInfo(TextView textView, CJRFlightSearchInput cJRFlightSearchInput) {
            k.c(textView, "textView");
            textView.setText(c.b(cJRFlightSearchInput, textView.getContext()));
        }

        public final void setRouteSeparator(ImageView imageView, CJRFlightSearchInput cJRFlightSearchInput) {
            k.c(imageView, "imageView");
            if ((cJRFlightSearchInput != null ? cJRFlightSearchInput.getReturnDate() : null) != null) {
                ResourceUtils.loadFlightImagesFromCDN(imageView, "rounded_trip_icon.png", false, false, n.a.V1);
            } else {
                imageView.setImageResource(R.drawable.travel_res_common_back_button);
            }
        }

        public final void setRouteHeader(ImageView imageView, CJRFlightSearchInput cJRFlightSearchInput) {
            k.c(imageView, "imageView");
            if ((cJRFlightSearchInput != null ? cJRFlightSearchInput.getReturnDate() : null) != null) {
                imageView.setImageResource(com.travel.flight.R.drawable.pre_f_actionbar_roundtrip_arrow);
            } else {
                imageView.setImageResource(com.travel.flight.R.drawable.pre_f_search_arrow_right);
            }
        }
    }
}
