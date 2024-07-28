package net.one97.paytm.hotel4.view.ui.a;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.q;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.paytm.utility.n;
import com.travel.utils.l;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.o;
import kotlin.u;
import net.one97.paytm.hotel4.service.model.datamodel.search.AutoSearchDataItem;
import net.one97.paytm.hotel4.service.model.details.CJRRoom;
import net.one97.paytm.hotel4.viewmodel.DetailsViewModel;
import net.one97.paytm.hotel4.viewmodel.EditSearchViewModel;
import net.one97.paytm.hotel4.viewmodel.SharedViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.b.ew;
import net.one97.paytm.hotels2.entity.CJRHotelSearchInput;
import net.one97.paytm.hotels2.fragment.HotelCitySearchActivity;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class e extends ab {

    /* renamed from: a  reason: collision with root package name */
    public ew f28828a;

    /* renamed from: b  reason: collision with root package name */
    public SharedViewModel f28829b;

    /* renamed from: c  reason: collision with root package name */
    public DetailsViewModel f28830c;

    /* renamed from: d  reason: collision with root package name */
    private EditSearchViewModel f28831d;

    static final class a<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f28832a;

        a(e eVar) {
            this.f28832a = eVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            e eVar = this.f28832a;
            k.a((Object) bool, "flag");
            eVar.a(bool.booleanValue());
        }
    }

    static final class b<T> implements z<o<? extends Boolean, ? extends AutoSearchDataItem>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f28833a;

        b(e eVar) {
            this.f28833a = eVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            o oVar = (o) obj;
            e eVar = this.f28833a;
            k.a((Object) oVar, "data");
            e.a(eVar, oVar);
        }
    }

    static final class c<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f28834a;

        c(e eVar) {
            this.f28834a = eVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            e eVar = this.f28834a;
            k.a((Object) bool, "flag");
            e.b(eVar, bool.booleanValue());
        }
    }

    static final class d<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f28835a;

        d(e eVar) {
            this.f28835a = eVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            e eVar = this.f28835a;
            k.a((Object) bool, "data");
            e.c(eVar, bool.booleanValue());
        }
    }

    /* renamed from: net.one97.paytm.hotel4.view.ui.a.e$e  reason: collision with other inner class name */
    static final class C0507e<T> implements z<AutoSearchDataItem> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f28836a;

        C0507e(e eVar) {
            this.f28836a = eVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            AutoSearchDataItem autoSearchDataItem = (AutoSearchDataItem) obj;
            e eVar = this.f28836a;
            k.a((Object) autoSearchDataItem, "data");
            k.c(autoSearchDataItem, "data");
            new net.one97.paytm.hotel4.service.a.b();
            eVar.getContext();
            net.one97.paytm.hotel4.service.a.b.a(autoSearchDataItem);
        }
    }

    static final class f<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f28837a;

        f(e eVar) {
            this.f28837a = eVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            e eVar = this.f28837a;
            k.a((Object) bool, "data");
            e.d(eVar, bool.booleanValue());
        }
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Dialog dialog = getDialog();
        Window window = dialog != null ? dialog.getWindow() : null;
        if (window == null) {
            k.a();
        }
        k.a((Object) window, "dialog?.window!!");
        window.getAttributes().windowAnimations = R.style.H4BottomSheet;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        l<AutoSearchDataItem> updateRecentSearch;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        EditSearchViewModel editSearchViewModel = this.f28831d;
        y<Boolean> yVar = null;
        y<Boolean> closeButtonClickListener = editSearchViewModel != null ? editSearchViewModel.getCloseButtonClickListener() : null;
        if (closeButtonClickListener == null) {
            k.a();
        }
        q qVar = this;
        closeButtonClickListener.observe(qVar, new a(this));
        EditSearchViewModel editSearchViewModel2 = this.f28831d;
        y<o<Boolean, AutoSearchDataItem>> searchButtonClickListener = editSearchViewModel2 != null ? editSearchViewModel2.getSearchButtonClickListener() : null;
        if (searchButtonClickListener == null) {
            k.a();
        }
        searchButtonClickListener.observe(qVar, new b(this));
        EditSearchViewModel editSearchViewModel3 = this.f28831d;
        y<Boolean> updateSearchButtonClickListener = editSearchViewModel3 != null ? editSearchViewModel3.getUpdateSearchButtonClickListener() : null;
        if (updateSearchButtonClickListener == null) {
            k.a();
        }
        updateSearchButtonClickListener.observe(qVar, new c(this));
        EditSearchViewModel editSearchViewModel4 = this.f28831d;
        y<Boolean> dateClick = editSearchViewModel4 != null ? editSearchViewModel4.getDateClick() : null;
        if (dateClick == null) {
            k.a();
        }
        dateClick.observe(qVar, new d(this));
        EditSearchViewModel editSearchViewModel5 = this.f28831d;
        if (!(editSearchViewModel5 == null || (updateRecentSearch = editSearchViewModel5.getUpdateRecentSearch()) == null)) {
            updateRecentSearch.observe(qVar, new C0507e(this));
        }
        EditSearchViewModel editSearchViewModel6 = this.f28831d;
        if (editSearchViewModel6 != null) {
            yVar = editSearchViewModel6.getCityLocalityClick();
        }
        if (yVar == null) {
            k.a();
        }
        yVar.observe(qVar, new f(this));
    }

    private final void a() {
        int i2;
        int i3;
        SharedViewModel sharedViewModel = this.f28829b;
        if (sharedViewModel == null) {
            k.a("sharedViewModel");
        }
        if (sharedViewModel.getSearchInput() != null) {
            SharedViewModel sharedViewModel2 = this.f28829b;
            if (sharedViewModel2 == null) {
                k.a("sharedViewModel");
            }
            CJRHotelSearchInput searchInput = sharedViewModel2.getSearchInput();
            if (searchInput == null) {
                k.a();
            }
            ArrayList<CJRRoom> rooms = searchInput.getRooms();
            int i4 = 0;
            if (rooms == null || rooms.size() <= 0) {
                i3 = 0;
                i2 = 0;
            } else {
                i3 = rooms.size();
                Iterator<CJRRoom> it2 = rooms.iterator();
                i2 = 0;
                while (it2.hasNext()) {
                    CJRRoom next = it2.next();
                    i4 += next.getAdultCount();
                    i2 += next.getChildrenCount();
                }
            }
            Map hashMap = new HashMap();
            SharedViewModel sharedViewModel3 = this.f28829b;
            if (sharedViewModel3 == null) {
                k.a("sharedViewModel");
            }
            CJRHotelSearchInput searchInput2 = sharedViewModel3.getSearchInput();
            if (searchInput2 == null) {
                k.a();
            }
            String city = searchInput2.getCity();
            if (city != null) {
                hashMap.put("event_label", city);
                SharedViewModel sharedViewModel4 = this.f28829b;
                if (sharedViewModel4 == null) {
                    k.a("sharedViewModel");
                }
                CJRHotelSearchInput searchInput3 = sharedViewModel4.getSearchInput();
                if (searchInput3 == null) {
                    k.a();
                }
                String checkInDate = searchInput3.getCheckInDate();
                if (checkInDate != null) {
                    hashMap.put("event_label2", checkInDate);
                    SharedViewModel sharedViewModel5 = this.f28829b;
                    if (sharedViewModel5 == null) {
                        k.a("sharedViewModel");
                    }
                    CJRHotelSearchInput searchInput4 = sharedViewModel5.getSearchInput();
                    if (searchInput4 == null) {
                        k.a();
                    }
                    String checkOutDate = searchInput4.getCheckOutDate();
                    if (checkOutDate != null) {
                        hashMap.put("event_label3", checkOutDate);
                        hashMap.put(SDKConstants.EVENT_KEY_EVENT_LABEL4, Integer.valueOf(i4));
                        hashMap.put("event_label5", Integer.valueOf(i2));
                        hashMap.put("event_label6", Integer.valueOf(i3));
                        net.one97.paytm.hotels2.utils.c.b().a("customEvent", "HomePage", "hotels_home", "search_tapped", hashMap);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type kotlin.Any");
                }
                throw new u("null cannot be cast to non-null type kotlin.Any");
            }
            throw new u("null cannot be cast to non-null type kotlin.Any");
        }
    }

    /* access modifiers changed from: private */
    public final void a(boolean z) {
        if (z) {
            dismiss();
            EditSearchViewModel editSearchViewModel = this.f28831d;
            y<Boolean> yVar = null;
            y<Boolean> closeButtonClickListener = editSearchViewModel != null ? editSearchViewModel.getCloseButtonClickListener() : null;
            if (closeButtonClickListener == null) {
                k.a();
            }
            closeButtonClickListener.postValue(Boolean.FALSE);
            EditSearchViewModel editSearchViewModel2 = this.f28831d;
            if (editSearchViewModel2 != null) {
                yVar = editSearchViewModel2.getDateClick();
            }
            if (yVar == null) {
                k.a();
            }
            yVar.postValue(Boolean.FALSE);
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        EditSearchViewModel editSearchViewModel;
        if (i3 != -1) {
            return;
        }
        if (i2 != 6) {
            if (i2 == 99 && intent != null && intent.hasExtra("intent_extra_selected_depart_date") && intent.hasExtra("intent_extra_selected_return_date")) {
                String stringExtra = intent.getStringExtra("intent_extra_selected_depart_date");
                k.a((Object) stringExtra, "data.getStringExtra(CJRC…TRA_SELECTED_DEPART_DATE)");
                String stringExtra2 = intent.getStringExtra("intent_extra_selected_return_date");
                k.a((Object) stringExtra2, "data.getStringExtra(CJRC…TRA_SELECTED_RETURN_DATE)");
                Locale locale = new Locale(n.a());
                EditSearchViewModel editSearchViewModel2 = this.f28831d;
                if (editSearchViewModel2 != null) {
                    String format = new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(new SimpleDateFormat("dd MMM yy", locale).parse(stringExtra));
                    k.a((Object) format, "SimpleDateFormat(\"yyyy-M…Local).parse(stringDate))");
                    editSearchViewModel2.setStringDateCheckIn(format);
                }
                EditSearchViewModel editSearchViewModel3 = this.f28831d;
                if (editSearchViewModel3 != null) {
                    String format2 = new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(new SimpleDateFormat("dd MMM yy", locale).parse(stringExtra2));
                    k.a((Object) format2, "SimpleDateFormat(\"yyyy-M…arse(stringDateCheckout))");
                    editSearchViewModel3.setStringDateCheckout(format2);
                }
                EditSearchViewModel editSearchViewModel4 = this.f28831d;
                l<Integer> lVar = null;
                l<Integer> nightCount = editSearchViewModel4 != null ? editSearchViewModel4.getNightCount() : null;
                if (nightCount == null) {
                    k.a();
                }
                nightCount.setValue(Integer.valueOf(intent.getIntExtra("DAYS_SELECTED", 0)));
                EditSearchViewModel editSearchViewModel5 = this.f28831d;
                if (editSearchViewModel5 != null) {
                    if (editSearchViewModel5 != null) {
                        lVar = editSearchViewModel5.getNightCount();
                    }
                    if (lVar == null) {
                        k.a();
                    }
                    editSearchViewModel5.updateNightText(lVar.getValue());
                }
                EditSearchViewModel editSearchViewModel6 = this.f28831d;
                if (editSearchViewModel6 != null) {
                    editSearchViewModel6.setCheckInCheckOutInfo();
                }
            }
        } else if (intent != null && intent.hasExtra("localitySearchType") && (editSearchViewModel = this.f28831d) != null) {
            editSearchViewModel.setSelectedInput(intent);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004e, code lost:
        r4 = r4.getSearchInput();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View onCreateView(android.view.LayoutInflater r6, android.view.ViewGroup r7, android.os.Bundle r8) {
        /*
            r5 = this;
            java.lang.String r8 = "inflater"
            kotlin.g.b.k.c(r6, r8)
            androidx.fragment.app.FragmentActivity r8 = r5.getActivity()
            java.lang.String r0 = "sharedViewModel"
            r1 = 0
            if (r8 == 0) goto L_0x00cd
            androidx.lifecycle.al r2 = androidx.lifecycle.am.a((androidx.fragment.app.FragmentActivity) r8)
            java.lang.Class<net.one97.paytm.hotel4.viewmodel.SharedViewModel> r3 = net.one97.paytm.hotel4.viewmodel.SharedViewModel.class
            androidx.lifecycle.ai r2 = r2.a(r3)
            java.lang.String r3 = "ViewModelProviders.of(it…redViewModel::class.java)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r2 = (net.one97.paytm.hotel4.viewmodel.SharedViewModel) r2
            r5.f28829b = r2
            net.one97.paytm.hotel4.viewmodel.ViewModelFactory r2 = new net.one97.paytm.hotel4.viewmodel.ViewModelFactory
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r3 = r5.f28829b
            if (r3 != 0) goto L_0x002b
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x002b:
            r2.<init>(r3)
            r3 = r5
            androidx.fragment.app.Fragment r3 = (androidx.fragment.app.Fragment) r3
            androidx.lifecycle.al$b r2 = (androidx.lifecycle.al.b) r2
            androidx.lifecycle.al r3 = androidx.lifecycle.am.a((androidx.fragment.app.Fragment) r3, (androidx.lifecycle.al.b) r2)
            java.lang.Class<net.one97.paytm.hotel4.viewmodel.EditSearchViewModel> r4 = net.one97.paytm.hotel4.viewmodel.EditSearchViewModel.class
            androidx.lifecycle.ai r3 = r3.a(r4)
            net.one97.paytm.hotel4.viewmodel.EditSearchViewModel r3 = (net.one97.paytm.hotel4.viewmodel.EditSearchViewModel) r3
            r5.f28831d = r3
            net.one97.paytm.hotel4.viewmodel.EditSearchViewModel r3 = r5.f28831d
            if (r3 == 0) goto L_0x0062
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r4 = r5.f28829b
            if (r4 != 0) goto L_0x004c
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x004c:
            if (r4 == 0) goto L_0x0059
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r4 = r4.getSearchInput()
            if (r4 == 0) goto L_0x0059
            java.lang.String r4 = r4.getCheckInDate()
            goto L_0x005a
        L_0x0059:
            r4 = r1
        L_0x005a:
            if (r4 != 0) goto L_0x005f
            kotlin.g.b.k.a()
        L_0x005f:
            r3.setStringDateCheckIn(r4)
        L_0x0062:
            net.one97.paytm.hotel4.viewmodel.EditSearchViewModel r3 = r5.f28831d
            if (r3 == 0) goto L_0x0083
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r4 = r5.f28829b
            if (r4 != 0) goto L_0x006d
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x006d:
            if (r4 == 0) goto L_0x007a
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r4 = r4.getSearchInput()
            if (r4 == 0) goto L_0x007a
            java.lang.String r4 = r4.getCheckOutDate()
            goto L_0x007b
        L_0x007a:
            r4 = r1
        L_0x007b:
            if (r4 != 0) goto L_0x0080
            kotlin.g.b.k.a()
        L_0x0080:
            r3.setStringDateCheckout(r4)
        L_0x0083:
            net.one97.paytm.hotel4.viewmodel.EditSearchViewModel r3 = r5.f28831d
            if (r3 == 0) goto L_0x008c
            com.travel.utils.l r3 = r3.getNightCount()
            goto L_0x008d
        L_0x008c:
            r3 = r1
        L_0x008d:
            if (r3 != 0) goto L_0x0092
            kotlin.g.b.k.a()
        L_0x0092:
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r4 = r5.f28829b
            if (r4 != 0) goto L_0x0099
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x0099:
            if (r4 == 0) goto L_0x00aa
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r4 = r4.getSearchInput()
            if (r4 == 0) goto L_0x00aa
            int r4 = r4.getNumOfNights()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            goto L_0x00ab
        L_0x00aa:
            r4 = r1
        L_0x00ab:
            if (r4 != 0) goto L_0x00b0
            kotlin.g.b.k.a()
        L_0x00b0:
            r3.setValue(r4)
            net.one97.paytm.hotel4.viewmodel.EditSearchViewModel r3 = r5.f28831d
            if (r3 == 0) goto L_0x00ba
            r3.setAllData()
        L_0x00ba:
            androidx.lifecycle.al r8 = androidx.lifecycle.am.a((androidx.fragment.app.FragmentActivity) r8, (androidx.lifecycle.al.b) r2)
            java.lang.Class<net.one97.paytm.hotel4.viewmodel.DetailsViewModel> r2 = net.one97.paytm.hotel4.viewmodel.DetailsViewModel.class
            androidx.lifecycle.ai r8 = r8.a(r2)
            java.lang.String r2 = "ViewModelProviders.of(it…ilsViewModel::class.java)"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r2)
            net.one97.paytm.hotel4.viewmodel.DetailsViewModel r8 = (net.one97.paytm.hotel4.viewmodel.DetailsViewModel) r8
            r5.f28830c = r8
        L_0x00cd:
            net.one97.paytm.hotel4.viewmodel.EditSearchViewModel r8 = r5.f28831d
            java.lang.String r2 = ""
            if (r8 == 0) goto L_0x00e4
            android.content.Context r3 = r5.getContext()
            if (r3 == 0) goto L_0x00e0
            int r4 = net.one97.paytm.hotels2.R.string.h4_room_text
            java.lang.String r3 = r3.getString(r4)
            goto L_0x00e1
        L_0x00e0:
            r3 = r1
        L_0x00e1:
            r8.setRoomDetails(r3, r2)
        L_0x00e4:
            net.one97.paytm.hotel4.viewmodel.EditSearchViewModel r8 = r5.f28831d
            if (r8 == 0) goto L_0x00f9
            android.content.Context r3 = r5.getContext()
            if (r3 == 0) goto L_0x00f5
            int r4 = net.one97.paytm.hotels2.R.string.h4_adult_text
            java.lang.String r3 = r3.getString(r4)
            goto L_0x00f6
        L_0x00f5:
            r3 = r1
        L_0x00f6:
            r8.setAdultDetails(r3, r2)
        L_0x00f9:
            net.one97.paytm.hotel4.viewmodel.EditSearchViewModel r8 = r5.f28831d
            if (r8 == 0) goto L_0x011a
            android.content.Context r2 = r5.getContext()
            if (r2 == 0) goto L_0x010a
            int r3 = net.one97.paytm.hotels2.R.string.h4_child_text
            java.lang.String r2 = r2.getString(r3)
            goto L_0x010b
        L_0x010a:
            r2 = r1
        L_0x010b:
            android.content.Context r3 = r5.getContext()
            if (r3 == 0) goto L_0x0117
            int r1 = net.one97.paytm.hotels2.R.string.h4_child_subtext
            java.lang.String r1 = r3.getString(r1)
        L_0x0117:
            r8.setChildDetails(r2, r1)
        L_0x011a:
            net.one97.paytm.hotel4.viewmodel.EditSearchViewModel r8 = r5.f28831d
            if (r8 == 0) goto L_0x0121
            r8.setCounterDefaultBehaviour()
        L_0x0121:
            net.one97.paytm.hotels2.b.ew r6 = net.one97.paytm.hotels2.b.ew.a(r6, r7)
            java.lang.String r7 = "H4SrpInputeditBottomShee…flater, container, false)"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            r5.f28828a = r6
            net.one97.paytm.hotels2.b.ew r6 = r5.f28828a
            java.lang.String r7 = "dataBinding"
            if (r6 != 0) goto L_0x0135
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x0135:
            net.one97.paytm.hotel4.viewmodel.EditSearchViewModel r8 = r5.f28831d
            r6.a(r8)
            net.one97.paytm.hotels2.b.ew r6 = r5.f28828a
            if (r6 != 0) goto L_0x0141
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x0141:
            r8 = r5
            androidx.lifecycle.q r8 = (androidx.lifecycle.q) r8
            r6.setLifecycleOwner(r8)
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r6 = r5.f28829b
            if (r6 != 0) goto L_0x014e
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x014e:
            androidx.lifecycle.y r6 = r6.isFromRoomSelection()
            java.lang.Object r6 = r6.getValue()
            if (r6 != 0) goto L_0x015b
            kotlin.g.b.k.a()
        L_0x015b:
            java.lang.String r8 = "sharedViewModel.isFromRoomSelection.value!!"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r8)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x018c
            net.one97.paytm.hotel4.viewmodel.EditSearchViewModel r6 = r5.f28831d
            if (r6 == 0) goto L_0x018c
            net.one97.paytm.hotel4.viewmodel.DetailsViewModel r8 = r5.f28830c
            if (r8 != 0) goto L_0x0176
            java.lang.String r0 = "detailViewModel"
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x0176:
            androidx.lifecycle.y r8 = r8.getSelectedData()
            java.lang.Object r8 = r8.getValue()
            if (r8 != 0) goto L_0x0183
            kotlin.g.b.k.a()
        L_0x0183:
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem r8 = (net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem) r8
            java.lang.String r8 = r8.getName()
            r6.setHotelName((java.lang.String) r8)
        L_0x018c:
            net.one97.paytm.hotel4.viewmodel.EditSearchViewModel r6 = r5.f28831d
            if (r6 == 0) goto L_0x01a0
            net.one97.paytm.hotels2.utils.e r8 = net.one97.paytm.hotels2.utils.e.a()
            java.lang.String r0 = "HotelsGTMLoader.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r0)
            int r8 = net.one97.paytm.hotels2.utils.e.d()
            r6.setmaxRoomCount(r8)
        L_0x01a0:
            net.one97.paytm.hotels2.b.ew r6 = r5.f28828a
            if (r6 != 0) goto L_0x01a7
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x01a7:
            android.view.View r6 = r6.getRoot()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.view.ui.a.e.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0046, code lost:
        r2 = r2.getSearchInput();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.hotel4.view.ui.a.e r5, kotlin.o r6) {
        /*
            java.lang.Object r0 = r6.getFirst()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0084
            java.lang.Object r0 = r6.getFirst()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r5.a(r0)
            java.lang.Object r6 = r6.getSecond()
            net.one97.paytm.hotel4.service.model.datamodel.search.AutoSearchDataItem r6 = (net.one97.paytm.hotel4.service.model.datamodel.search.AutoSearchDataItem) r6
            java.lang.String r0 = "mAutoSearchDataItem"
            kotlin.g.b.k.c(r6, r0)
            net.one97.paytm.hotel4.service.model.datamodel.search.SearchParamsDataItem r0 = r6.getSearchParams()
            java.lang.String r1 = "sharedViewModel"
            if (r0 == 0) goto L_0x0073
            boolean r0 = r0.getNearBy()
            if (r0 != 0) goto L_0x0073
            net.one97.paytm.hotel4.service.a.b r0 = new net.one97.paytm.hotel4.service.a.b
            r0.<init>()
            android.content.Context r0 = r5.getContext()
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r2 = r5.f28829b
            if (r2 != 0) goto L_0x0043
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0043:
            r3 = 0
            if (r2 == 0) goto L_0x0051
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r2 = r2.getSearchInput()
            if (r2 == 0) goto L_0x0051
            java.lang.String r2 = r2.getCheckInDate()
            goto L_0x0052
        L_0x0051:
            r2 = r3
        L_0x0052:
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r4 = r5.f28829b
            if (r4 != 0) goto L_0x0059
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0059:
            if (r4 == 0) goto L_0x0065
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r4 = r4.getSearchInput()
            if (r4 == 0) goto L_0x0065
            java.lang.String r3 = r4.getCheckOutDate()
        L_0x0065:
            net.one97.paytm.hotel4.service.a.b.a(r0, r2, r3)
            net.one97.paytm.hotel4.service.a.b r0 = new net.one97.paytm.hotel4.service.a.b
            r0.<init>()
            r5.getContext()
            net.one97.paytm.hotel4.service.a.b.a(r6)
        L_0x0073:
            r5.a()
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r5 = r5.f28829b
            if (r5 != 0) goto L_0x007d
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x007d:
            java.lang.String r6 = "11"
            java.lang.String r0 = "3"
            r5.postScreenNavigationEvent(r6, r0)
        L_0x0084:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.view.ui.a.e.a(net.one97.paytm.hotel4.view.ui.a.e, kotlin.o):void");
    }

    public static final /* synthetic */ void b(e eVar, boolean z) {
        if (z) {
            eVar.a(z);
            eVar.a();
            EditSearchViewModel editSearchViewModel = eVar.f28831d;
            y<Boolean> updateSearchButtonClickListener = editSearchViewModel != null ? editSearchViewModel.getUpdateSearchButtonClickListener() : null;
            if (updateSearchButtonClickListener == null) {
                k.a();
            }
            updateSearchButtonClickListener.postValue(Boolean.FALSE);
            DetailsViewModel detailsViewModel = eVar.f28830c;
            if (detailsViewModel == null) {
                k.a("detailViewModel");
            }
            detailsViewModel.fetchDetailForRoomSelection();
        }
    }

    public static final /* synthetic */ void c(e eVar, boolean z) {
        EditSearchViewModel editSearchViewModel;
        if (z && (editSearchViewModel = eVar.f28831d) != null) {
            editSearchViewModel.openCalder(eVar);
        }
    }

    public static final /* synthetic */ void d(e eVar, boolean z) {
        if (z) {
            Intent intent = new Intent(eVar.getContext(), HotelCitySearchActivity.class);
            FragmentActivity activity = eVar.getActivity();
            if (activity != null) {
                activity.startActivityForResult(intent, 6);
            }
            EditSearchViewModel editSearchViewModel = eVar.f28831d;
            y<Boolean> cityLocalityClick = editSearchViewModel != null ? editSearchViewModel.getCityLocalityClick() : null;
            if (cityLocalityClick == null) {
                k.a();
            }
            cityLocalityClick.postValue(Boolean.FALSE);
        }
    }
}
