package com.travel.flight.flightSRPV2.view.ui.b;

import androidx.lifecycle.z;
import com.travel.flight.b.ae;
import com.travel.flight.flightSRPV2.viewModel.FlightFilterHomeViewModel;
import com.travel.flight.flightSRPV2.viewModel.FlightFilterViewModel;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;
import com.travel.flight.flightticket.widget.DiscreteRangeSeekBarFlight;
import com.travel.flight.flightticket.widget.RangeSeekBarFlight;
import java.util.HashMap;

public final class a extends net.one97.paytm.i.h {

    /* renamed from: a  reason: collision with root package name */
    public static final C0459a f24232a = new C0459a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private ae f24233b;

    /* renamed from: c  reason: collision with root package name */
    private FlightFilterViewModel f24234c;

    /* renamed from: d  reason: collision with root package name */
    private FlightFilterHomeViewModel f24235d;

    /* renamed from: e  reason: collision with root package name */
    private SRPSharedViewModel f24236e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f24237f = true;

    /* renamed from: g  reason: collision with root package name */
    private HashMap f24238g;

    static final class f<T> implements z<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f24263a;

        f(a aVar) {
            this.f24263a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Integer num = (Integer) obj;
            if (num != null && num.intValue() == 3) {
                a.b(this.f24263a).applyFilters(a.a(this.f24263a).getFilters(), this.f24263a.f24237f);
            } else if (num != null && num.intValue() == 2) {
                a.a(this.f24263a).populateFilterValues(true);
            }
        }
    }

    static final class g<T> implements z<Long> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DiscreteRangeSeekBarFlight f24264a;

        g(DiscreteRangeSeekBarFlight discreteRangeSeekBarFlight) {
            this.f24264a = discreteRangeSeekBarFlight;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f24264a.setSelectedMinValue((Long) obj);
        }
    }

    static final class h<T> implements z<Long> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DiscreteRangeSeekBarFlight f24265a;

        h(DiscreteRangeSeekBarFlight discreteRangeSeekBarFlight) {
            this.f24265a = discreteRangeSeekBarFlight;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f24265a.setSelectedMaxValue((Long) obj);
        }
    }

    static final class i<T> implements z<Long> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DiscreteRangeSeekBarFlight f24266a;

        i(DiscreteRangeSeekBarFlight discreteRangeSeekBarFlight) {
            this.f24266a = discreteRangeSeekBarFlight;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f24266a.setSelectedMinValue((Long) obj);
        }
    }

    static final class j<T> implements z<Long> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DiscreteRangeSeekBarFlight f24267a;

        j(DiscreteRangeSeekBarFlight discreteRangeSeekBarFlight) {
            this.f24267a = discreteRangeSeekBarFlight;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f24267a.setSelectedMaxValue((Long) obj);
        }
    }

    static final class k<T> implements z<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DiscreteRangeSeekBarFlight f24268a;

        k(DiscreteRangeSeekBarFlight discreteRangeSeekBarFlight) {
            this.f24268a = discreteRangeSeekBarFlight;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f24268a.setSelectedMaxValue((Integer) obj);
        }
    }

    static final class l<T> implements z<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DiscreteRangeSeekBarFlight f24269a;

        l(DiscreteRangeSeekBarFlight discreteRangeSeekBarFlight) {
            this.f24269a = discreteRangeSeekBarFlight;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f24269a.setSelectedMinValue((Integer) obj);
        }
    }

    static final class m<T> implements z<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DiscreteRangeSeekBarFlight f24270a;

        m(DiscreteRangeSeekBarFlight discreteRangeSeekBarFlight) {
            this.f24270a = discreteRangeSeekBarFlight;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f24270a.setSelectedMaxValue((Integer) obj);
        }
    }

    public static final /* synthetic */ FlightFilterViewModel a(a aVar) {
        FlightFilterViewModel flightFilterViewModel = aVar.f24234c;
        if (flightFilterViewModel == null) {
            kotlin.g.b.k.a("filterViewModel");
        }
        return flightFilterViewModel;
    }

    public static final /* synthetic */ FlightFilterHomeViewModel b(a aVar) {
        FlightFilterHomeViewModel flightFilterHomeViewModel = aVar.f24235d;
        if (flightFilterHomeViewModel == null) {
            kotlin.g.b.k.a("filterHomeViewModel");
        }
        return flightFilterHomeViewModel;
    }

    /* renamed from: com.travel.flight.flightSRPV2.view.ui.b.a$a  reason: collision with other inner class name */
    public static final class C0459a {
        private C0459a() {
        }

        public /* synthetic */ C0459a(byte b2) {
            this();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:121:0x0315  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0034  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View onCreateView(android.view.LayoutInflater r11, android.view.ViewGroup r12, android.os.Bundle r13) {
        /*
            r10 = this;
            java.lang.String r13 = "inflater"
            kotlin.g.b.k.c(r11, r13)
            android.os.Bundle r13 = r10.getArguments()
            r0 = 1
            java.lang.String r1 = "ARG_IS_ONWARD"
            r2 = 0
            if (r13 == 0) goto L_0x0031
            android.os.Bundle r13 = r10.getArguments()
            if (r13 != 0) goto L_0x0018
            kotlin.g.b.k.a()
        L_0x0018:
            boolean r13 = r13.containsKey(r1)
            if (r13 == 0) goto L_0x0031
            android.os.Bundle r13 = r10.getArguments()
            if (r13 != 0) goto L_0x0027
            kotlin.g.b.k.a()
        L_0x0027:
            java.lang.Object r13 = r13.get(r1)
            boolean r13 = r13 instanceof java.lang.Boolean
            if (r13 == 0) goto L_0x0031
            r13 = 1
            goto L_0x0032
        L_0x0031:
            r13 = 0
        L_0x0032:
            if (r13 == 0) goto L_0x0315
            android.os.Bundle r13 = r10.getArguments()
            if (r13 != 0) goto L_0x003d
            kotlin.g.b.k.a()
        L_0x003d:
            java.lang.Object r13 = r13.get(r1)
            if (r13 == 0) goto L_0x030d
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            r10.f24237f = r13
            androidx.fragment.app.FragmentActivity r13 = r10.getActivity()
            if (r13 != 0) goto L_0x0054
            kotlin.g.b.k.a()
        L_0x0054:
            androidx.lifecycle.al r13 = androidx.lifecycle.am.a((androidx.fragment.app.FragmentActivity) r13)
            java.lang.Class<com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel> r1 = com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel.class
            androidx.lifecycle.ai r13 = r13.a(r1)
            java.lang.String r1 = "ViewModelProviders.of(ac…redViewModel::class.java)"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r1)
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r13 = (com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel) r13
            r10.f24236e = r13
            androidx.fragment.app.Fragment r13 = r10.getParentFragment()
            if (r13 != 0) goto L_0x0070
            kotlin.g.b.k.a()
        L_0x0070:
            androidx.lifecycle.al r13 = androidx.lifecycle.am.a((androidx.fragment.app.Fragment) r13)
            java.lang.Class<com.travel.flight.flightSRPV2.viewModel.FlightFilterHomeViewModel> r1 = com.travel.flight.flightSRPV2.viewModel.FlightFilterHomeViewModel.class
            androidx.lifecycle.ai r13 = r13.a(r1)
            java.lang.String r1 = "ViewModelProviders.of(th…omeViewModel::class.java)"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r1)
            com.travel.flight.flightSRPV2.viewModel.FlightFilterHomeViewModel r13 = (com.travel.flight.flightSRPV2.viewModel.FlightFilterHomeViewModel) r13
            r10.f24235d = r13
            r13 = r10
            androidx.fragment.app.Fragment r13 = (androidx.fragment.app.Fragment) r13
            com.travel.flight.flightSRPV2.viewModel.factory.SRPViewModelFactory r1 = new com.travel.flight.flightSRPV2.viewModel.factory.SRPViewModelFactory
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r3 = r10.f24236e
            java.lang.String r4 = "parentViewModel"
            if (r3 != 0) goto L_0x0091
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0091:
            boolean r5 = r10.f24237f
            com.travel.flight.flightSRPV2.viewModel.FlightFilterHomeViewModel r6 = r10.f24235d
            java.lang.String r7 = "filterHomeViewModel"
            if (r6 != 0) goto L_0x009c
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x009c:
            r1.<init>(r3, r5, r6)
            androidx.lifecycle.al$b r1 = (androidx.lifecycle.al.b) r1
            androidx.lifecycle.al r13 = androidx.lifecycle.am.a((androidx.fragment.app.Fragment) r13, (androidx.lifecycle.al.b) r1)
            java.lang.Class<com.travel.flight.flightSRPV2.viewModel.FlightFilterViewModel> r1 = com.travel.flight.flightSRPV2.viewModel.FlightFilterViewModel.class
            androidx.lifecycle.ai r13 = r13.a(r1)
            java.lang.String r1 = "ViewModelProviders.of(th…terViewModel::class.java)"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r1)
            com.travel.flight.flightSRPV2.viewModel.FlightFilterViewModel r13 = (com.travel.flight.flightSRPV2.viewModel.FlightFilterViewModel) r13
            r10.f24234c = r13
            com.travel.flight.b.ae r11 = com.travel.flight.b.ae.a(r11, r12)
            java.lang.String r12 = "FragmentFlightFilterPage…flater, container, false)"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r12)
            r10.f24233b = r11
            com.travel.flight.b.ae r11 = r10.f24233b
            java.lang.String r12 = "binding"
            if (r11 != 0) goto L_0x00c8
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x00c8:
            com.travel.flight.flightSRPV2.viewModel.FlightFilterViewModel r13 = r10.f24234c
            java.lang.String r1 = "filterViewModel"
            if (r13 != 0) goto L_0x00d1
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00d1:
            r11.a((com.travel.flight.flightSRPV2.viewModel.FlightFilterViewModel) r13)
            com.travel.flight.b.ae r11 = r10.f24233b
            if (r11 != 0) goto L_0x00db
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x00db:
            com.travel.flight.flightSRPV2.viewModel.FlightFilterHomeViewModel r13 = r10.f24235d
            if (r13 != 0) goto L_0x00e2
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x00e2:
            r11.a((com.travel.flight.flightSRPV2.viewModel.FlightFilterHomeViewModel) r13)
            com.travel.flight.b.ae r11 = r10.f24233b
            if (r11 != 0) goto L_0x00ec
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x00ec:
            androidx.lifecycle.q r13 = r10.getViewLifecycleOwner()
            r11.setLifecycleOwner(r13)
            boolean r11 = r10.f24237f
            if (r11 == 0) goto L_0x0103
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r11 = r10.f24236e
            if (r11 != 0) goto L_0x00fe
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x00fe:
            androidx.lifecycle.y r11 = r11.getDefaultOnwardFilterInfo()
            goto L_0x010e
        L_0x0103:
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r11 = r10.f24236e
            if (r11 != 0) goto L_0x010a
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x010a:
            androidx.lifecycle.y r11 = r11.getDefaultReturnFilterInfo()
        L_0x010e:
            java.lang.Object r11 = r11.getValue()
            if (r11 != 0) goto L_0x0117
            kotlin.g.b.k.a()
        L_0x0117:
            java.lang.String r13 = "(if (isOnward) this.pare…ReturnFilterInfo).value!!"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r13)
            com.travel.flight.flightSRPV2.a.u r11 = (com.travel.flight.flightSRPV2.a.u) r11
            com.travel.flight.flightSRPV2.a.g<java.lang.Integer> r13 = r11.f24128c
            T r13 = r13.f24100a
            java.lang.Number r13 = (java.lang.Number) r13
            com.travel.flight.flightSRPV2.a.g<java.lang.Integer> r3 = r11.f24128c
            T r3 = r3.f24101b
            java.lang.Number r3 = (java.lang.Number) r3
            r4 = 10
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.Number r4 = (java.lang.Number) r4
            androidx.fragment.app.FragmentActivity r5 = r10.getActivity()
            if (r5 != 0) goto L_0x013b
            kotlin.g.b.k.a()
        L_0x013b:
            java.lang.String r6 = "activity!!"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            android.content.Context r5 = (android.content.Context) r5
            com.travel.flight.flightticket.widget.DiscreteRangeSeekBarFlight r13 = com.travel.flight.flightSRPV2.c.d.a(r13, r3, r4, r5)
            com.travel.flight.flightSRPV2.view.ui.b.a$b r3 = new com.travel.flight.flightSRPV2.view.ui.b.a$b
            r3.<init>(r10)
            com.travel.flight.flightticket.widget.RangeSeekBarFlight$b r3 = (com.travel.flight.flightticket.widget.RangeSeekBarFlight.b) r3
            r13.setOnRangeSeekBarChangeListener(r3)
            r13.setMinThumbEnable(r2)
            com.travel.flight.flightSRPV2.viewModel.FlightFilterViewModel r3 = r10.f24234c
            if (r3 != 0) goto L_0x015a
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x015a:
            androidx.lifecycle.y r3 = r3.getSelectedDuration()
            androidx.lifecycle.q r4 = r10.getViewLifecycleOwner()
            com.travel.flight.flightSRPV2.view.ui.b.a$k r5 = new com.travel.flight.flightSRPV2.view.ui.b.a$k
            r5.<init>(r13)
            androidx.lifecycle.z r5 = (androidx.lifecycle.z) r5
            r3.observe(r4, r5)
            com.travel.flight.b.ae r3 = r10.f24233b
            if (r3 != 0) goto L_0x0173
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x0173:
            android.widget.FrameLayout r3 = r3.f23570h
            android.view.View r13 = (android.view.View) r13
            r3.addView(r13)
            com.travel.flight.flightSRPV2.a.g<java.lang.Integer> r13 = r11.f24129d
            T r13 = r13.f24100a
            java.lang.Number r13 = (java.lang.Number) r13
            com.travel.flight.flightSRPV2.a.g<java.lang.Integer> r3 = r11.f24129d
            T r3 = r3.f24101b
            java.lang.Number r3 = (java.lang.Number) r3
            r4 = 100
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.Number r4 = (java.lang.Number) r4
            androidx.fragment.app.FragmentActivity r5 = r10.getActivity()
            if (r5 != 0) goto L_0x0197
            kotlin.g.b.k.a()
        L_0x0197:
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            android.content.Context r5 = (android.content.Context) r5
            com.travel.flight.flightticket.widget.DiscreteRangeSeekBarFlight r13 = com.travel.flight.flightSRPV2.c.d.a(r13, r3, r4, r5)
            com.travel.flight.flightSRPV2.view.ui.b.a$c r3 = new com.travel.flight.flightSRPV2.view.ui.b.a$c
            r3.<init>(r10)
            com.travel.flight.flightticket.widget.RangeSeekBarFlight$b r3 = (com.travel.flight.flightticket.widget.RangeSeekBarFlight.b) r3
            r13.setOnRangeSeekBarChangeListener(r3)
            com.travel.flight.flightSRPV2.viewModel.FlightFilterViewModel r3 = r10.f24234c
            if (r3 != 0) goto L_0x01b1
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x01b1:
            androidx.lifecycle.y r3 = r3.getSelectedPriceMin()
            androidx.lifecycle.q r4 = r10.getViewLifecycleOwner()
            com.travel.flight.flightSRPV2.view.ui.b.a$l r5 = new com.travel.flight.flightSRPV2.view.ui.b.a$l
            r5.<init>(r13)
            androidx.lifecycle.z r5 = (androidx.lifecycle.z) r5
            r3.observe(r4, r5)
            com.travel.flight.flightSRPV2.viewModel.FlightFilterViewModel r3 = r10.f24234c
            if (r3 != 0) goto L_0x01ca
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x01ca:
            androidx.lifecycle.y r3 = r3.getSelectedPriceMax()
            androidx.lifecycle.q r4 = r10.getViewLifecycleOwner()
            com.travel.flight.flightSRPV2.view.ui.b.a$m r5 = new com.travel.flight.flightSRPV2.view.ui.b.a$m
            r5.<init>(r13)
            androidx.lifecycle.z r5 = (androidx.lifecycle.z) r5
            r3.observe(r4, r5)
            com.travel.flight.b.ae r3 = r10.f24233b
            if (r3 != 0) goto L_0x01e3
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x01e3:
            android.widget.FrameLayout r3 = r3.l
            android.view.View r13 = (android.view.View) r13
            r3.addView(r13)
            com.travel.flight.flightSRPV2.a.g<java.lang.Long> r13 = r11.f24130e
            T r13 = r13.f24100a
            java.lang.Number r13 = (java.lang.Number) r13
            com.travel.flight.flightSRPV2.a.g<java.lang.Long> r3 = r11.f24130e
            T r3 = r3.f24101b
            java.lang.Number r3 = (java.lang.Number) r3
            r4 = 600000(0x927c0, double:2.964394E-318)
            java.lang.Long r8 = java.lang.Long.valueOf(r4)
            java.lang.Number r8 = (java.lang.Number) r8
            androidx.fragment.app.FragmentActivity r9 = r10.getActivity()
            if (r9 != 0) goto L_0x0208
            kotlin.g.b.k.a()
        L_0x0208:
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r6)
            android.content.Context r9 = (android.content.Context) r9
            com.travel.flight.flightticket.widget.DiscreteRangeSeekBarFlight r13 = com.travel.flight.flightSRPV2.c.d.a(r13, r3, r8, r9)
            com.travel.flight.flightSRPV2.view.ui.b.a$d r3 = new com.travel.flight.flightSRPV2.view.ui.b.a$d
            r3.<init>(r10)
            com.travel.flight.flightticket.widget.RangeSeekBarFlight$b r3 = (com.travel.flight.flightticket.widget.RangeSeekBarFlight.b) r3
            r13.setOnRangeSeekBarChangeListener(r3)
            com.travel.flight.flightSRPV2.viewModel.FlightFilterViewModel r3 = r10.f24234c
            if (r3 != 0) goto L_0x0222
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0222:
            androidx.lifecycle.y r3 = r3.getSelectedDepartureMin()
            androidx.lifecycle.q r8 = r10.getViewLifecycleOwner()
            com.travel.flight.flightSRPV2.view.ui.b.a$i r9 = new com.travel.flight.flightSRPV2.view.ui.b.a$i
            r9.<init>(r13)
            androidx.lifecycle.z r9 = (androidx.lifecycle.z) r9
            r3.observe(r8, r9)
            com.travel.flight.flightSRPV2.viewModel.FlightFilterViewModel r3 = r10.f24234c
            if (r3 != 0) goto L_0x023b
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x023b:
            androidx.lifecycle.y r3 = r3.getSelectedDepartureMax()
            androidx.lifecycle.q r8 = r10.getViewLifecycleOwner()
            com.travel.flight.flightSRPV2.view.ui.b.a$j r9 = new com.travel.flight.flightSRPV2.view.ui.b.a$j
            r9.<init>(r13)
            androidx.lifecycle.z r9 = (androidx.lifecycle.z) r9
            r3.observe(r8, r9)
            com.travel.flight.b.ae r3 = r10.f24233b
            if (r3 != 0) goto L_0x0254
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x0254:
            android.widget.FrameLayout r3 = r3.f23569g
            android.view.View r13 = (android.view.View) r13
            r3.addView(r13)
            com.travel.flight.flightSRPV2.a.g<java.lang.Long> r13 = r11.f24131f
            T r13 = r13.f24100a
            java.lang.Number r13 = (java.lang.Number) r13
            com.travel.flight.flightSRPV2.a.g<java.lang.Long> r11 = r11.f24131f
            T r11 = r11.f24101b
            java.lang.Number r11 = (java.lang.Number) r11
            java.lang.Long r3 = java.lang.Long.valueOf(r4)
            java.lang.Number r3 = (java.lang.Number) r3
            androidx.fragment.app.FragmentActivity r4 = r10.getActivity()
            if (r4 != 0) goto L_0x0276
            kotlin.g.b.k.a()
        L_0x0276:
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)
            android.content.Context r4 = (android.content.Context) r4
            com.travel.flight.flightticket.widget.DiscreteRangeSeekBarFlight r11 = com.travel.flight.flightSRPV2.c.d.a(r13, r11, r3, r4)
            com.travel.flight.flightSRPV2.view.ui.b.a$e r13 = new com.travel.flight.flightSRPV2.view.ui.b.a$e
            r13.<init>(r10)
            com.travel.flight.flightticket.widget.RangeSeekBarFlight$b r13 = (com.travel.flight.flightticket.widget.RangeSeekBarFlight.b) r13
            r11.setOnRangeSeekBarChangeListener(r13)
            com.travel.flight.flightSRPV2.viewModel.FlightFilterViewModel r13 = r10.f24234c
            if (r13 != 0) goto L_0x0290
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0290:
            androidx.lifecycle.y r13 = r13.getSelectedArrivalMin()
            androidx.lifecycle.q r3 = r10.getViewLifecycleOwner()
            com.travel.flight.flightSRPV2.view.ui.b.a$g r4 = new com.travel.flight.flightSRPV2.view.ui.b.a$g
            r4.<init>(r11)
            androidx.lifecycle.z r4 = (androidx.lifecycle.z) r4
            r13.observe(r3, r4)
            com.travel.flight.flightSRPV2.viewModel.FlightFilterViewModel r13 = r10.f24234c
            if (r13 != 0) goto L_0x02a9
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x02a9:
            androidx.lifecycle.y r13 = r13.getSelectedArrivalMax()
            androidx.lifecycle.q r1 = r10.getViewLifecycleOwner()
            com.travel.flight.flightSRPV2.view.ui.b.a$h r3 = new com.travel.flight.flightSRPV2.view.ui.b.a$h
            r3.<init>(r11)
            androidx.lifecycle.z r3 = (androidx.lifecycle.z) r3
            r13.observe(r1, r3)
            com.travel.flight.b.ae r13 = r10.f24233b
            if (r13 != 0) goto L_0x02c2
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x02c2:
            android.widget.FrameLayout r13 = r13.f23568f
            android.view.View r11 = (android.view.View) r11
            r13.addView(r11)
            com.travel.flight.flightSRPV2.viewModel.FlightFilterHomeViewModel r11 = r10.f24235d
            if (r11 != 0) goto L_0x02d0
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x02d0:
            androidx.lifecycle.y r11 = r11.getEvent()
            androidx.lifecycle.q r13 = r10.getViewLifecycleOwner()
            com.travel.flight.flightSRPV2.view.ui.b.a$f r1 = new com.travel.flight.flightSRPV2.view.ui.b.a$f
            r1.<init>(r10)
            androidx.lifecycle.z r1 = (androidx.lifecycle.z) r1
            r11.observe(r13, r1)
            com.travel.flight.b.ae r11 = r10.f24233b
            if (r11 != 0) goto L_0x02e9
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x02e9:
            android.widget.ImageView r11 = r11.f23566d
            int r13 = com.travel.common.R.drawable.travel_res_common_close
            r11.setImageResource(r13)
            com.travel.flight.b.ae r11 = r10.f24233b
            if (r11 != 0) goto L_0x02f7
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x02f7:
            android.widget.ImageView r11 = r11.f23565c
            com.travel.utils.n$a r13 = com.travel.utils.n.a.V1
            java.lang.String r1 = "search.png"
            com.travel.cdn.ResourceUtils.loadFlightImagesFromCDN(r11, r1, r2, r0, r13)
            com.travel.flight.b.ae r11 = r10.f24233b
            if (r11 != 0) goto L_0x0308
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x0308:
            android.view.View r11 = r11.getRoot()
            return r11
        L_0x030d:
            kotlin.u r11 = new kotlin.u
            java.lang.String r12 = "null cannot be cast to non-null type kotlin.Boolean"
            r11.<init>(r12)
            throw r11
        L_0x0315:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r12 = "ARG_IS_ONWARD param is not provided"
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            java.lang.Throwable r11 = (java.lang.Throwable) r11
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightSRPV2.view.ui.b.a.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    public static final class b implements RangeSeekBarFlight.b<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f24248a;

        b(a aVar) {
            this.f24248a = aVar;
        }

        public final /* synthetic */ void a(Object obj, Object obj2) {
            a.a(this.f24248a).getSelectedDuration().setValue((Integer) obj2);
            a.a(this.f24248a).checkIfFiltersAreAltered();
        }
    }

    public static final class c implements RangeSeekBarFlight.b<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f24260a;

        c(a aVar) {
            this.f24260a = aVar;
        }

        public final /* synthetic */ void a(Object obj, Object obj2) {
            a.a(this.f24260a).getSelectedPriceMin().setValue((Integer) obj);
            a.a(this.f24260a).getSelectedPriceMax().setValue((Integer) obj2);
            a.a(this.f24260a).checkIfFiltersAreAltered();
        }
    }

    public static final class d implements RangeSeekBarFlight.b<Long> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f24261a;

        d(a aVar) {
            this.f24261a = aVar;
        }

        public final /* synthetic */ void a(Object obj, Object obj2) {
            Long l = (Long) obj;
            Long l2 = (Long) obj2;
            if (l == null) {
                kotlin.g.b.k.a();
            }
            a.a(this.f24261a).getSelectedDepartureMin().setValue(Long.valueOf(60000 * (l.longValue() / 60000)));
            a.a(this.f24261a).getSelectedDepartureMax().setValue(l2);
            a.a(this.f24261a).checkIfFiltersAreAltered();
        }
    }

    public static final class e implements RangeSeekBarFlight.b<Long> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f24262a;

        e(a aVar) {
            this.f24262a = aVar;
        }

        public final /* synthetic */ void a(Object obj, Object obj2) {
            Long l = (Long) obj;
            Long l2 = (Long) obj2;
            if (l == null) {
                kotlin.g.b.k.a();
            }
            a.a(this.f24262a).getSelectedArrivalMin().setValue(Long.valueOf(60000 * (l.longValue() / 60000)));
            a.a(this.f24262a).getSelectedArrivalMax().setValue(l2);
            a.a(this.f24262a).checkIfFiltersAreAltered();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f24238g;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
