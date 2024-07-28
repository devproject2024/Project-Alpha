package com.travel.flight.flightticket.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;
import com.travel.cdn.ResourceUtils;
import com.travel.flight.R;
import com.travel.flight.flightticket.a.g;
import com.travel.flight.flightticket.c.a;
import com.travel.flight.flightticket.f.k;
import com.travel.flight.flightticket.g.c;
import com.travel.flight.flightticket.i.b;
import com.travel.flight.pojo.flightticket.CJRConvenienceFee;
import com.travel.flight.pojo.flightticket.CJRFlightDetails;
import com.travel.flight.pojo.flightticket.CJRFlightPromoResponse;
import com.travel.flight.pojo.flightticket.FareRules.CJRFareRulesJorneyDetails;
import com.travel.flight.pojo.flightticket.FareRules.CJRFareRulesResponse;
import com.travel.flight.pojo.flightticket.FareRules.CJRMessageKeyValue;
import com.travel.flight.pojo.flightticket.FareRules.CJRMiniRulesLayoutItem;
import com.travel.flight.pojo.flightticket.FareRules.CJRPolicyDetailsCancellationNModification;
import com.travel.flight.pojo.flightticket.FareRules.CJRRoutes;
import com.travel.flight.pojo.flightticket.FareRules.CJRValueKeyValue;
import com.travel.flight.pojo.model.CJRTravellerSeatTransition;
import com.travel.utils.n;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.i.h;

public class d extends h implements View.OnClickListener, k, b {

    /* renamed from: a  reason: collision with root package name */
    private CJRFlightDetails f24956a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f24957b = false;

    /* renamed from: c  reason: collision with root package name */
    private CJRFlightPromoResponse f24958c;

    /* renamed from: d  reason: collision with root package name */
    private CJRFareRulesResponse f24959d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f24960e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f24961f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f24962g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f24963h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f24964i;
    private ImageView j;
    private ImageView k;
    private ImageView l;
    private RelativeLayout m;
    private RelativeLayout n;
    private RelativeLayout o;
    private RecyclerView p;
    private com.travel.flight.flightticket.c.b q = null;
    private a r;
    private String s;
    /* access modifiers changed from: private */
    public ScrollView t;
    private c u;
    private boolean v;
    private CJRTravellerSeatTransition w;

    public void openPromoScreen() {
    }

    public void updateJourneyTypeForPrices(String str) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pre_f_fragment_flight_new_fare_rules, viewGroup, false);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f24956a = (CJRFlightDetails) arguments.getSerializable("flightDetail");
            this.f24957b = arguments.getBoolean("isFromTravellerDetail", false);
            this.f24958c = this.f24956a.getPromoResponse();
            this.f24959d = (CJRFareRulesResponse) arguments.getSerializable("fareRules");
            if (arguments.containsKey("is_show_convenience_fee")) {
                this.v = arguments.getBoolean("is_show_convenience_fee", false);
            }
            this.w = (CJRTravellerSeatTransition) arguments.getParcelable("selectedSeatInfoIntentData");
        }
        if (inflate != null) {
            this.t = (ScrollView) inflate.findViewById(R.id.scrollview_container);
            this.f24964i = (ImageView) inflate.findViewById(R.id.expanded_imageview);
            this.f24960e = (TextView) inflate.findViewById(R.id.expanded_title_textview);
            this.p = (RecyclerView) inflate.findViewById(R.id.recycler_view_fare_rules);
            this.j = (ImageView) inflate.findViewById(R.id.second_minirule_imageview);
            this.f24961f = (TextView) inflate.findViewById(R.id.second_minirule_textview);
            this.k = (ImageView) inflate.findViewById(R.id.third_minirule_imageview);
            this.f24962g = (TextView) inflate.findViewById(R.id.third_minirule_textview);
            this.l = (ImageView) inflate.findViewById(R.id.fourth_minirule_imageview);
            this.f24963h = (TextView) inflate.findViewById(R.id.fourth_minirule_textview);
            this.m = (RelativeLayout) inflate.findViewById(R.id.second_minirule_lyt);
            this.n = (RelativeLayout) inflate.findViewById(R.id.third_minirule_lyt);
            this.o = (RelativeLayout) inflate.findViewById(R.id.fourth_minirule_lyt);
            inflate.findViewById(R.id.second_minirule_lyt).setOnClickListener(this);
            inflate.findViewById(R.id.third_minirule_lyt).setOnClickListener(this);
            inflate.findViewById(R.id.fourth_minirule_lyt).setOnClickListener(this);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
            linearLayoutManager.setOrientation(1);
            this.p.setLayoutManager(linearLayoutManager);
            String string = getArguments().getString("reviewItenaryPagetoOpen");
            if (string == null) {
                string = "FareBreakUp";
            }
            this.s = string;
        }
        return inflate;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.u = new c(getContext(), this);
        this.u.a((com.travel.flight.flightticket.e.h) Enum.valueOf(com.travel.flight.flightticket.e.h.class, this.s), this.f24959d, this.s, this.f24956a, this.f24958c, this.f24957b);
    }

    private void a(RecyclerView recyclerView, String str) {
        ArrayList<CJRMiniRulesLayoutItem> arrayList;
        if (this.u != null && recyclerView != null) {
            Context context = getContext();
            c cVar = this.u;
            if (cVar.f25015b != null) {
                arrayList = cVar.f25015b;
            } else {
                arrayList = null;
            }
            recyclerView.setAdapter(new g(context, arrayList, c.b(str), this.f24956a.getmOnwardJourney().isStitched() || this.f24956a.getmOnwardJourney().isProviderStitch(), this.f24956a.getmOnwardJourney().getmFlights()));
        }
    }

    public void setFlightFareBreakupData(CJRFareRulesResponse cJRFareRulesResponse, String str, CJRFlightDetails cJRFlightDetails, CJRFlightPromoResponse cJRFlightPromoResponse, boolean z) {
        this.f24960e.setText("Fare Breakup");
        ResourceUtils.loadFlightImagesFromCDN(this.f24964i, "rupee_icon.png", false, true, n.a.V1);
        if (c.a(com.travel.flight.flightticket.e.h.Baggage, cJRFareRulesResponse, cJRFlightDetails)) {
            this.m.setVisibility(0);
            this.f24961f.setText(cJRFareRulesResponse.getBody().getMinirules().getBaggagePolicy().getTitle());
            this.f24961f.setTag("Baggage");
            ResourceUtils.loadFlightImagesFromCDN(this.j, "fare_rule_baggage.png", false, false, n.a.V1);
        } else {
            this.m.setVisibility(8);
        }
        if (c.a(com.travel.flight.flightticket.e.h.Cancellation, cJRFareRulesResponse, cJRFlightDetails)) {
            this.n.setVisibility(0);
            this.f24962g.setText(cJRFareRulesResponse.getBody().getMinirules().getCancellationPolicy().getTitle());
            this.f24962g.setTag("Cancellation");
            ResourceUtils.loadFlightImagesFromCDN(this.k, "cancellation_icon.png", false, false, n.a.V1);
        } else {
            this.n.setVisibility(8);
        }
        if (c.a(com.travel.flight.flightticket.e.h.Modification, cJRFareRulesResponse, cJRFlightDetails)) {
            this.o.setVisibility(0);
            this.f24963h.setText(cJRFareRulesResponse.getBody().getMinirules().getModificationPolicy().getTitle());
            this.f24963h.setTag("reschedule_policy");
            ResourceUtils.loadFlightImagesFromCDN(this.l, "fare_rule_reschedule.png", false, false, n.a.V1);
        } else {
            this.o.setVisibility(8);
        }
        this.p.setAdapter(new com.travel.flight.flightticket.a.k(getActivity(), cJRFlightDetails, cJRFlightPromoResponse, this, z, this.v, this.w));
    }

    public void setFlightBaggageData(CJRFareRulesResponse cJRFareRulesResponse, String str, CJRFlightDetails cJRFlightDetails) {
        this.f24960e.setText(cJRFareRulesResponse.getBody().getMinirules().getBaggagePolicy().getTitle());
        ResourceUtils.loadFlightImagesFromCDN(this.f24964i, "fare_rule_baggage.png", false, false, n.a.V1);
        if (c.a(com.travel.flight.flightticket.e.h.FareBreakUp, cJRFareRulesResponse, cJRFlightDetails)) {
            this.m.setVisibility(0);
            this.f24961f.setText("Fare Breakup");
            this.f24961f.setTag("FareBreakUp");
            ResourceUtils.loadFlightImagesFromCDN(this.j, "rupee_icon.png", false, true, n.a.V1);
        } else {
            this.m.setVisibility(8);
        }
        if (c.a(com.travel.flight.flightticket.e.h.Cancellation, cJRFareRulesResponse, cJRFlightDetails)) {
            this.n.setVisibility(0);
            this.f24962g.setText(cJRFareRulesResponse.getBody().getMinirules().getCancellationPolicy().getTitle());
            this.f24962g.setTag("Cancellation");
            ResourceUtils.loadFlightImagesFromCDN(this.k, "cancellation_icon.png", false, false, n.a.V1);
        } else {
            this.n.setVisibility(8);
        }
        if (c.a(com.travel.flight.flightticket.e.h.Modification, cJRFareRulesResponse, cJRFlightDetails)) {
            this.o.setVisibility(0);
            this.f24963h.setText(cJRFareRulesResponse.getBody().getMinirules().getModificationPolicy().getTitle());
            this.f24963h.setTag("reschedule_policy");
            ResourceUtils.loadFlightImagesFromCDN(this.l, "fare_rule_reschedule.png", false, false, n.a.V1);
        } else {
            this.o.setVisibility(8);
        }
        a(this.p, str);
    }

    public void setCancellationData(CJRFareRulesResponse cJRFareRulesResponse, String str, CJRFlightDetails cJRFlightDetails) {
        this.f24960e.setText(cJRFareRulesResponse.getBody().getMinirules().getCancellationPolicy().getTitle());
        ResourceUtils.loadFlightImagesFromCDN(this.f24964i, "cancellation_icon.png", false, false, n.a.V1);
        if (c.a(com.travel.flight.flightticket.e.h.FareBreakUp, cJRFareRulesResponse, cJRFlightDetails)) {
            this.m.setVisibility(0);
            this.f24961f.setText("Fare Breakup");
            this.f24961f.setTag("FareBreakUp");
            ResourceUtils.loadFlightImagesFromCDN(this.j, "rupee_icon.png", false, true, n.a.V1);
        } else {
            this.m.setVisibility(8);
        }
        if (c.a(com.travel.flight.flightticket.e.h.Baggage, cJRFareRulesResponse, cJRFlightDetails)) {
            this.n.setVisibility(0);
            this.f24962g.setText(cJRFareRulesResponse.getBody().getMinirules().getBaggagePolicy().getTitle());
            this.f24962g.setTag("Baggage");
            ResourceUtils.loadFlightImagesFromCDN(this.k, "fare_rule_baggage.png", false, false, n.a.V1);
        } else {
            this.n.setVisibility(8);
        }
        if (c.a(com.travel.flight.flightticket.e.h.Modification, cJRFareRulesResponse, cJRFlightDetails)) {
            this.o.setVisibility(0);
            this.f24963h.setText(cJRFareRulesResponse.getBody().getMinirules().getModificationPolicy().getTitle());
            this.f24963h.setTag("reschedule_policy");
            ResourceUtils.loadFlightImagesFromCDN(this.l, "fare_rule_reschedule.png", false, false, n.a.V1);
        } else {
            this.o.setVisibility(8);
        }
        a(this.p, str);
    }

    public void setRescheduleData(CJRFareRulesResponse cJRFareRulesResponse, String str, CJRFlightDetails cJRFlightDetails) {
        this.f24960e.setText(cJRFareRulesResponse.getBody().getMinirules().getModificationPolicy().getTitle());
        ResourceUtils.loadFlightImagesFromCDN(this.f24964i, "fare_rule_reschedule.png", false, false, n.a.V1);
        if (c.a(com.travel.flight.flightticket.e.h.FareBreakUp, cJRFareRulesResponse, cJRFlightDetails)) {
            this.m.setVisibility(0);
            this.f24961f.setText("Fare Breakup");
            this.f24961f.setTag("FareBreakUp");
            ResourceUtils.loadFlightImagesFromCDN(this.j, "rupee_icon.png", false, true, n.a.V1);
        } else {
            this.m.setVisibility(8);
        }
        if (c.a(com.travel.flight.flightticket.e.h.Baggage, cJRFareRulesResponse, cJRFlightDetails)) {
            this.n.setVisibility(0);
            this.f24962g.setText(cJRFareRulesResponse.getBody().getMinirules().getBaggagePolicy().getTitle());
            this.f24962g.setTag("Baggage");
            ResourceUtils.loadFlightImagesFromCDN(this.k, "fare_rule_baggage.png", false, false, n.a.V1);
        } else {
            this.n.setVisibility(8);
        }
        if (c.a(com.travel.flight.flightticket.e.h.Cancellation, cJRFareRulesResponse, cJRFlightDetails)) {
            this.o.setVisibility(0);
            this.f24963h.setText(cJRFareRulesResponse.getBody().getMinirules().getCancellationPolicy().getTitle());
            this.f24963h.setTag("Cancellation");
            ResourceUtils.loadFlightImagesFromCDN(this.l, "cancellation_icon.png", false, false, n.a.V1);
        } else {
            this.o.setVisibility(8);
        }
        a(this.p, str);
    }

    public final void a() {
        ScrollView scrollView = this.t;
        if (scrollView != null) {
            scrollView.post(new Runnable() {
                public final void run() {
                    d.this.t.fullScroll(33);
                }
            });
        }
    }

    public void onClick(View view) {
        CJRFlightDetails cJRFlightDetails;
        int id = view.getId();
        if (id == R.id.second_minirule_lyt) {
            this.s = this.f24961f.getTag().toString();
        } else if (id == R.id.third_minirule_lyt) {
            this.s = this.f24962g.getTag().toString();
        } else if (id == R.id.fourth_minirule_lyt) {
            this.s = this.f24963h.getTag().toString();
        }
        if (!TextUtils.isEmpty(this.s) && this.s.equalsIgnoreCase("Cancellation") && (cJRFlightDetails = this.f24956a) != null) {
            if (cJRFlightDetails.getmReturnJourney() != null) {
                this.f24956a.getmReturnJourney().getmFlights();
            }
            CJRFareRulesResponse cJRFareRulesResponse = this.f24959d;
            if (!(cJRFareRulesResponse == null || cJRFareRulesResponse.getBody() == null || this.f24959d.getBody().getMinirules() == null || this.f24959d.getBody().getMinirules().getCancellationPolicy() == null)) {
                CJRFareRulesJorneyDetails onward = this.f24959d.getBody().getMinirules().getCancellationPolicy().getOnward();
                CJRFareRulesJorneyDetails cJRFareRulesJorneyDetails = this.f24959d.getBody().getMinirules().getCancellationPolicy().getReturn();
                if (!a(onward)) {
                    a(cJRFareRulesJorneyDetails);
                }
            }
        }
        this.u.a(c.a(this.s), this.f24959d, this.s, this.f24956a, this.f24958c, this.f24957b);
    }

    private static boolean a(CJRFareRulesJorneyDetails cJRFareRulesJorneyDetails) {
        if (cJRFareRulesJorneyDetails == null || cJRFareRulesJorneyDetails.getRoutes() == null || cJRFareRulesJorneyDetails.getRoutes().size() <= 0) {
            return false;
        }
        Iterator<CJRRoutes> it2 = cJRFareRulesJorneyDetails.getRoutes().iterator();
        while (it2.hasNext()) {
            CJRRoutes next = it2.next();
            if (next.getCancellation_policies() != null && next.getCancellation_policies().size() > 0) {
                for (CJRPolicyDetailsCancellationNModification next2 : next.getCancellation_policies()) {
                    if (next2.getMessages() != null && next2.getMessages().size() > 0 && !TextUtils.isEmpty(next2.getTitle()) && next2.getTitle().equalsIgnoreCase("airline fee") && next2.getMessages() != null && next2.getMessages().size() > 0) {
                        Iterator<CJRMessageKeyValue> it3 = next2.getMessages().iterator();
                        while (it3.hasNext()) {
                            CJRMessageKeyValue next3 = it3.next();
                            if (next3.getValue() != null && next3.getValue().size() > 0) {
                                Iterator<CJRValueKeyValue> it4 = next3.getValue().iterator();
                                while (it4.hasNext()) {
                                    String value = it4.next().getValue();
                                    if (!TextUtils.isEmpty(value) && (value.contains("<br>") || value.contains(FilterPriceSliderFragment.RUPEE_SYMBOL))) {
                                        return true;
                                    }
                                }
                                continue;
                            }
                        }
                        continue;
                    }
                }
                continue;
            }
        }
        return false;
    }

    /* renamed from: com.travel.flight.flightticket.fragment.d$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f24966a = new int[com.travel.flight.flightticket.d.c.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                com.travel.flight.flightticket.d.c[] r0 = com.travel.flight.flightticket.d.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f24966a = r0
                int[] r0 = f24966a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.travel.flight.flightticket.d.c r1 = com.travel.flight.flightticket.d.c.CONVENIENCE_FEE_DETAILS     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f24966a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.travel.flight.flightticket.d.c r1 = com.travel.flight.flightticket.d.c.CONVENIENCE_FEE_DETAILS_CLOSE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f24966a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.travel.flight.flightticket.d.c r1 = com.travel.flight.flightticket.d.c.ANCILLARY_DETAILS     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f24966a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.travel.flight.flightticket.d.c r1 = com.travel.flight.flightticket.d.c.ANCILLARY_DETAILS_CLOSE     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightticket.fragment.d.AnonymousClass2.<clinit>():void");
        }
    }

    public void reviewIternaryActionClick(String str, Intent intent, Boolean bool, com.travel.flight.flightticket.d.c cVar) {
        a aVar;
        if (cVar != null) {
            int i2 = AnonymousClass2.f24966a[cVar.ordinal()];
            if (i2 == 1) {
                com.travel.flight.flightticket.c.b bVar = this.q;
                if (bVar == null) {
                    b();
                } else if (!bVar.isShowing()) {
                    b();
                }
            } else if (i2 == 2) {
                com.travel.flight.flightticket.c.b bVar2 = this.q;
                if (bVar2 != null) {
                    bVar2.dismiss();
                }
            } else if (i2 == 3) {
                a aVar2 = this.r;
                if (aVar2 == null) {
                    c();
                } else if (!aVar2.isShowing()) {
                    c();
                }
            } else if (i2 == 4 && (aVar = this.r) != null) {
                aVar.dismiss();
            }
        }
    }

    private void b() {
        CJRConvenienceFee cJRConvenienceFee = this.f24956a.getmConvenienceFee();
        if (cJRConvenienceFee != null) {
            this.q = new com.travel.flight.flightticket.c.b(getActivity(), this, cJRConvenienceFee);
            this.q.show();
        }
    }

    private void c() {
        if (this.f24956a.getmConvenienceFee() != null) {
            this.r = new a(getActivity(), this);
            this.r.show();
        }
    }
}
