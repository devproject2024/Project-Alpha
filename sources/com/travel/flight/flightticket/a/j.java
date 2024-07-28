package com.travel.flight.flightticket.a;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.flight.R;
import com.travel.flight.b.bk;
import com.travel.flight.flightticket.e.d;
import com.travel.flight.flightticket.e.g;
import com.travel.flight.flightticket.f.i;
import com.travel.flight.flightticket.f.k;
import com.travel.flight.flightticket.j.ac;
import com.travel.flight.flightticket.j.c;
import com.travel.flight.flightticket.j.l;
import com.travel.flight.flightticket.j.m;
import com.travel.flight.flightticket.j.o;
import com.travel.flight.flightticket.j.p;
import com.travel.flight.flightticket.j.u;
import com.travel.flight.flightticket.j.y;
import com.travel.flight.flightticket.j.z;
import com.travel.flight.pojo.flightticket.CJRFlightDetails;
import com.travel.flight.pojo.flightticket.CJRFlightOffer;
import com.travel.flight.pojo.flightticket.CJRFlightPromoResponse;
import com.travel.flight.pojo.flightticket.CJRFlightSearchInput;
import com.travel.flight.pojo.flightticket.FareRules.CJRMIniRules;
import com.travel.flight.pojo.flightticket.FlightSellingBundleResponseData;
import com.travel.flight.pojo.flightticket.insurance.CJRCancelProtectInsuranceItem;
import com.travel.flight.pojo.model.CJRTravellerSeatTransition;
import java.util.ArrayList;
import java.util.List;

public final class j extends RecyclerView.a<RecyclerView.v> {
    private String A;
    private i B;
    private com.travel.flight.flightticket.d.b C;

    /* renamed from: a  reason: collision with root package name */
    public CJRFlightOffer f24673a;

    /* renamed from: b  reason: collision with root package name */
    public CJRFlightDetails f24674b;

    /* renamed from: c  reason: collision with root package name */
    public z f24675c;

    /* renamed from: d  reason: collision with root package name */
    public String f24676d;

    /* renamed from: e  reason: collision with root package name */
    public p f24677e;

    /* renamed from: f  reason: collision with root package name */
    public CJRMIniRules f24678f;

    /* renamed from: g  reason: collision with root package name */
    public CJRCancelProtectInsuranceItem f24679g;

    /* renamed from: h  reason: collision with root package name */
    public List<FlightSellingBundleResponseData> f24680h;

    /* renamed from: i  reason: collision with root package name */
    private final CJRFlightSearchInput f24681i;
    private k j;
    private b k;
    private boolean l = false;
    private Activity m;
    private String n = "seller";
    private float o = 0.0f;
    private double p = 0.0d;
    private double q = 0.0d;
    private CJRFlightPromoResponse r;
    private y s;
    private c t;
    private ArrayList<a> u;
    private l v;
    private l w;
    private boolean x = false;
    private CJRTravellerSeatTransition y;
    private String z;

    public interface b {
    }

    public j(Activity activity, CJRFlightDetails cJRFlightDetails, CJRFlightSearchInput cJRFlightSearchInput, k kVar, String str, CJRMIniRules cJRMIniRules, List<FlightSellingBundleResponseData> list, i iVar, com.travel.flight.flightticket.d.b bVar) {
        this.f24674b = cJRFlightDetails;
        this.m = activity;
        this.f24681i = cJRFlightSearchInput;
        this.y = null;
        this.j = kVar;
        this.u = new ArrayList<>();
        this.z = str;
        this.f24678f = cJRMIniRules;
        this.f24680h = list;
        this.B = iVar;
        this.C = bVar;
        this.k = (b) activity;
        if (this.f24674b.getmReturnJourney() != null) {
            this.l = true;
            if (this.f24674b.getmReturnServiceProvider() != null && !TextUtils.isEmpty(this.f24674b.getmReturnServiceProvider())) {
                this.n = this.f24674b.getmReturnServiceProvider();
            }
        } else {
            this.l = false;
            if (this.f24674b.getmOnwardServiceProvider() != null && !TextUtils.isEmpty(this.f24674b.getmOnwardServiceProvider())) {
                this.n = this.f24674b.getmOnwardServiceProvider();
            }
        }
        a();
    }

    public final void a() {
        this.u = new ArrayList<>();
        a aVar = new a(this, (byte) 0);
        aVar.f24682a = "onWardFlight";
        this.u.add(aVar);
        if (this.l) {
            a aVar2 = new a(this, (byte) 0);
            aVar2.f24682a = "returnFlight";
            this.u.add(aVar2);
        }
        if (!TextUtils.isEmpty(this.f24674b.getmReviewInfoBoxHtml())) {
            a aVar3 = new a(this, (byte) 0);
            aVar3.f24682a = "htmlBox";
            this.u.add(aVar3);
        }
        CJRMIniRules cJRMIniRules = this.f24678f;
        if (!(cJRMIniRules == null || cJRMIniRules.getBaggagePolicy() == null)) {
            a aVar4 = new a(this, (byte) 0);
            aVar4.f24682a = "baggagePolicy";
            this.u.add(aVar4);
        }
        if (this.f24679g != null) {
            a aVar5 = new a(this, (byte) 0);
            aVar5.f24682a = "cancelProtectInsurance";
            this.u.add(aVar5);
        }
        a aVar6 = new a(this, (byte) 0);
        aVar6.f24682a = "cancellationPolicyBaggageAndNote";
        this.u.add(aVar6);
        a aVar7 = new a(this, (byte) 0);
        aVar7.f24682a = "bundlePackage";
        if (this.f24680h != null) {
            this.u.add(aVar7);
        }
        if (this.C != com.travel.flight.flightticket.d.b.Modify) {
            a aVar8 = new a(this, (byte) 0);
            aVar8.f24682a = "offerItem";
            this.u.add(aVar8);
        }
        if (this.C == com.travel.flight.flightticket.d.b.Modify && this.f24674b.getmPassengerInfo() != null) {
            a aVar9 = new a(this, (byte) 0);
            aVar9.f24682a = "travellerItem";
            this.u.add(aVar9);
        }
        b();
        c();
        if (!TextUtils.isEmpty(this.f24674b.getmReviewInfoBoxHtmlBottom())) {
            a aVar10 = new a(this, (byte) 0);
            aVar10.f24682a = "htmlBoxBottom";
            this.u.add(aVar10);
        }
        if (this.f24674b.getImportantInfoNotes() != null && this.f24674b.getImportantInfoNotes().size() > 0) {
            a aVar11 = new a(this, (byte) 0);
            aVar11.f24682a = "importantInfoItem";
            this.u.add(aVar11);
        }
    }

    private void b() {
        if (this.f24674b.getPaymentDetails() != null) {
            a aVar = new a(this, (byte) 0);
            aVar.f24682a = "VIEW_TYPE_REVIEW_PAYMENT_DETAILS";
            this.u.add(aVar);
        }
    }

    private void c() {
        if (this.f24674b.getImportantNotes() != null && this.f24674b.getImportantNotes().getNotes() != null && !this.f24674b.getImportantNotes().getNotes().isEmpty()) {
            a aVar = new a(this, (byte) 0);
            aVar.f24682a = "importantNewInfoItem";
            this.u.add(aVar);
        }
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == 0) {
            ac acVar = new ac(this.m, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_f_flights_review_details_item, viewGroup, false), this.j, this.B);
            acVar.f25064a = this.f24674b;
            acVar.l = this.f24681i;
            acVar.j = this.l;
            acVar.k = this.n;
            acVar.m = this.z;
            return acVar;
        } else if (i2 == 14) {
            return new l(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_f_item_html_box, viewGroup, false), this.m, "review_top");
        } else {
            if (i2 == 15) {
                return new l(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_f_item_html_box, viewGroup, false), this.m, "review_bottom");
            }
            if (i2 == 10) {
                return new u(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_f_item_flight_review_cp_note_item, viewGroup, false), this.m);
            }
            if (i2 == 3) {
                this.f24675c = new z(this.m, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_f_lyt_flight_review_offers, viewGroup, false), this.j);
                z zVar = this.f24675c;
                zVar.f25249c = this.f24674b;
                zVar.f25250d = this.f24673a;
                zVar.f25252f = this.f24681i;
                zVar.f25251e = this.n;
                zVar.f25248b = this.r;
                return zVar;
            } else if (i2 == 16) {
                CJRMIniRules cJRMIniRules = this.f24678f;
                if (cJRMIniRules == null || cJRMIniRules.getBaggagePolicy() == null) {
                    return null;
                }
                return new o(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_flight_review_bp, viewGroup, false), this.j, this.f24674b);
            } else if (i2 == 8) {
                if (this.f24679g == null) {
                    return null;
                }
                this.f24677e = new p(this.m, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_flight_review_cp, viewGroup, false), this.j, this.f24674b);
                return this.f24677e;
            } else if (i2 == 11) {
                this.t = new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_f_flight_bundle_package, viewGroup, false), this.m, this.f24680h, this.j, this.f24674b.getmRepriceFareDetails().getmTotalFare());
                return this.t;
            } else if (i2 == 2) {
                d dVar = d.f24900a;
                return d.a(g.Passengers, viewGroup);
            } else if (i2 == 12) {
                return new com.travel.flight.flightSRPV2.view.ui.a.j((bk) bk.bind(f.a(), LayoutInflater.from(this.m).inflate(R.layout.layout_review_payment_details, viewGroup, false), R.layout.layout_review_payment_details));
            } else if (i2 == 13) {
                d dVar2 = d.f24900a;
                return (m) d.a(g.Important, viewGroup);
            } else if (i2 != 4) {
                return null;
            } else {
                this.s = new y(this.m, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_f_flight_item_important_note, viewGroup, false), this.j);
                this.s.f25241a = (ArrayList) this.f24674b.getImportantInfoNotes();
                return this.s;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0550, code lost:
        if (com.travel.flight.b.b().A() != false) goto L_0x0552;
     */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0594 A[Catch:{ Exception -> 0x06a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0598 A[Catch:{ Exception -> 0x06a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x05b9 A[Catch:{ Exception -> 0x06a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x05bc A[Catch:{ Exception -> 0x06a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0603 A[Catch:{ Exception -> 0x06a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0606 A[Catch:{ Exception -> 0x06a4 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.v r19, int r20) {
        /*
            r18 = this;
            r1 = r18
            r0 = r19
            r2 = r20
            boolean r3 = r0 instanceof com.travel.flight.flightticket.j.y     // Catch:{ Exception -> 0x06a4 }
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L_0x002a
            com.travel.flight.flightticket.j.y r0 = (com.travel.flight.flightticket.j.y) r0     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.CJRFlightDetails r2 = r1.f24674b     // Catch:{ Exception -> 0x06a4 }
            java.util.List r2 = r2.getImportantInfoNotes()     // Catch:{ Exception -> 0x06a4 }
            if (r2 == 0) goto L_0x0026
            com.travel.flight.pojo.flightticket.CJRFlightDetails r2 = r1.f24674b     // Catch:{ Exception -> 0x06a4 }
            java.util.List r2 = r2.getImportantInfoNotes()     // Catch:{ Exception -> 0x06a4 }
            int r2 = r2.size()     // Catch:{ Exception -> 0x06a4 }
            if (r2 <= 0) goto L_0x0026
            r0.a(r4)     // Catch:{ Exception -> 0x06a4 }
            return
        L_0x0026:
            r0.a(r5)     // Catch:{ Exception -> 0x06a4 }
            return
        L_0x002a:
            boolean r3 = r0 instanceof com.travel.flight.flightticket.j.m     // Catch:{ Exception -> 0x06a4 }
            if (r3 == 0) goto L_0x0055
            com.travel.flight.flightticket.j.m r0 = (com.travel.flight.flightticket.j.m) r0     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.CJRFlightDetails r2 = r1.f24674b     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.modifyBooking.CJRFlightMBPassengerDetails r2 = r2.getmPassengerInfo()     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.CJRFlightDetails r3 = r1.f24674b     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.modifyBooking.CJRFlightMBImportant r3 = r3.getImportantNotes()     // Catch:{ Exception -> 0x06a4 }
            java.lang.String r4 = "passengerInfo"
            kotlin.g.b.k.c(r2, r4)     // Catch:{ Exception -> 0x06a4 }
            java.lang.String r4 = "important"
            kotlin.g.b.k.c(r3, r4)     // Catch:{ Exception -> 0x06a4 }
            androidx.databinding.ViewDataBinding r4 = r0.f25183a     // Catch:{ Exception -> 0x06a4 }
            int r5 = com.travel.flight.a.E     // Catch:{ Exception -> 0x06a4 }
            r4.setVariable(r5, r2)     // Catch:{ Exception -> 0x06a4 }
            androidx.databinding.ViewDataBinding r0 = r0.f25183a     // Catch:{ Exception -> 0x06a4 }
            int r2 = com.travel.flight.a.I     // Catch:{ Exception -> 0x06a4 }
            r0.setVariable(r2, r3)     // Catch:{ Exception -> 0x06a4 }
            return
        L_0x0055:
            boolean r3 = r0 instanceof com.travel.flight.flightticket.j.z     // Catch:{ Exception -> 0x06a4 }
            if (r3 == 0) goto L_0x0071
            com.travel.flight.flightticket.j.z r0 = (com.travel.flight.flightticket.j.z) r0     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.CJRFlightPromoResponse r2 = r1.r     // Catch:{ Exception -> 0x06a4 }
            r0.f25248b = r2     // Catch:{ Exception -> 0x06a4 }
            java.lang.String r2 = r1.A     // Catch:{ Exception -> 0x06a4 }
            r0.f25253g = r2     // Catch:{ Exception -> 0x06a4 }
            boolean r2 = r1.x     // Catch:{ Exception -> 0x06a4 }
            if (r2 == 0) goto L_0x006b
            r0.a()     // Catch:{ Exception -> 0x06a4 }
            return
        L_0x006b:
            r0.b()     // Catch:{ Exception -> 0x06a4 }
            r1.x = r5     // Catch:{ Exception -> 0x06a4 }
            return
        L_0x0071:
            boolean r3 = r0 instanceof com.travel.flight.flightticket.j.o     // Catch:{ Exception -> 0x06a4 }
            r7 = 8
            if (r3 == 0) goto L_0x030c
            com.travel.flight.flightticket.j.o r0 = (com.travel.flight.flightticket.j.o) r0     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.FareRules.CJRMIniRules r2 = r1.f24678f     // Catch:{ Exception -> 0x06a4 }
            if (r2 == 0) goto L_0x008c
            com.travel.flight.pojo.flightticket.FareRules.CJRMIniRules r2 = r1.f24678f     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.FareRules.CJRMiniRulePolicy r2 = r2.getBaggagePolicy()     // Catch:{ Exception -> 0x06a4 }
            if (r2 == 0) goto L_0x008c
            com.travel.flight.pojo.flightticket.FareRules.CJRMIniRules r2 = r1.f24678f     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.FareRules.CJRMiniRulePolicy r6 = r2.getBaggagePolicy()     // Catch:{ Exception -> 0x06a4 }
            goto L_0x008d
        L_0x008c:
            r6 = 0
        L_0x008d:
            if (r6 == 0) goto L_0x030b
            java.lang.String r2 = r6.getTitle()     // Catch:{ Exception -> 0x06a4 }
            if (r2 == 0) goto L_0x030b
            android.view.View r2 = r0.f25188c     // Catch:{ Exception -> 0x06a4 }
            int r3 = com.travel.flight.R.id.baggage_title_txt     // Catch:{ Exception -> 0x06a4 }
            android.view.View r2 = r2.findViewById(r3)     // Catch:{ Exception -> 0x06a4 }
            android.widget.TextView r2 = (android.widget.TextView) r2     // Catch:{ Exception -> 0x06a4 }
            java.lang.String r3 = r6.getTitle()     // Catch:{ Exception -> 0x06a4 }
            r2.setText(r3)     // Catch:{ Exception -> 0x06a4 }
            android.view.View r2 = r0.f25188c     // Catch:{ Exception -> 0x06a4 }
            int r3 = com.travel.flight.R.id.baggage_icon     // Catch:{ Exception -> 0x06a4 }
            android.view.View r2 = r2.findViewById(r3)     // Catch:{ Exception -> 0x06a4 }
            android.widget.ImageView r2 = (android.widget.ImageView) r2     // Catch:{ Exception -> 0x06a4 }
            java.lang.String r3 = "fare_policy_baggage.png"
            com.travel.utils.n$a r4 = com.travel.utils.n.a.V1     // Catch:{ Exception -> 0x06a4 }
            com.travel.cdn.ResourceUtils.loadFlightImagesFromCDN(r2, r3, r5, r5, r4)     // Catch:{ Exception -> 0x06a4 }
            android.view.View r2 = r0.f25188c     // Catch:{ Exception -> 0x06a4 }
            int r3 = com.travel.flight.R.id.onward_journey_info_lyt     // Catch:{ Exception -> 0x06a4 }
            android.view.View r2 = r2.findViewById(r3)     // Catch:{ Exception -> 0x06a4 }
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2     // Catch:{ Exception -> 0x06a4 }
            android.view.View r3 = r0.f25188c     // Catch:{ Exception -> 0x06a4 }
            int r4 = com.travel.flight.R.id.return_baggage_info     // Catch:{ Exception -> 0x06a4 }
            android.view.View r3 = r3.findViewById(r4)     // Catch:{ Exception -> 0x06a4 }
            android.widget.RelativeLayout r3 = (android.widget.RelativeLayout) r3     // Catch:{ Exception -> 0x06a4 }
            android.view.View r4 = r0.f25188c     // Catch:{ Exception -> 0x06a4 }
            int r8 = com.travel.flight.R.id.onward_baggage_info_txt     // Catch:{ Exception -> 0x06a4 }
            android.view.View r4 = r4.findViewById(r8)     // Catch:{ Exception -> 0x06a4 }
            android.widget.TextView r4 = (android.widget.TextView) r4     // Catch:{ Exception -> 0x06a4 }
            android.view.View r8 = r0.f25188c     // Catch:{ Exception -> 0x06a4 }
            int r9 = com.travel.flight.R.id.arrow_view     // Catch:{ Exception -> 0x06a4 }
            android.view.View r8 = r8.findViewById(r9)     // Catch:{ Exception -> 0x06a4 }
            r8.setOnClickListener(r0)     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.FareRules.CJRFareRulesJorneyDetails r8 = r6.getOnward()     // Catch:{ Exception -> 0x06a4 }
            if (r8 == 0) goto L_0x0136
            com.travel.flight.pojo.flightticket.FareRules.CJRFareRulesJorneyDetails r8 = r6.getReturn()     // Catch:{ Exception -> 0x06a4 }
            if (r8 != 0) goto L_0x0136
            com.travel.flight.pojo.flightticket.FareRules.CJRFareRulesJorneyDetails r8 = r6.getOnward()     // Catch:{ Exception -> 0x06a4 }
            java.util.ArrayList r8 = r8.getRoutes()     // Catch:{ Exception -> 0x06a4 }
            if (r8 == 0) goto L_0x0136
            com.travel.flight.pojo.flightticket.FareRules.CJRFareRulesJorneyDetails r8 = r6.getOnward()     // Catch:{ Exception -> 0x06a4 }
            java.util.ArrayList r8 = r8.getRoutes()     // Catch:{ Exception -> 0x06a4 }
            int r8 = r8.size()     // Catch:{ Exception -> 0x06a4 }
            if (r8 <= 0) goto L_0x0136
            com.travel.flight.pojo.flightticket.FareRules.CJRFareRulesJorneyDetails r8 = r6.getOnward()     // Catch:{ Exception -> 0x06a4 }
            java.util.ArrayList r8 = r8.getRoutes()     // Catch:{ Exception -> 0x06a4 }
            java.lang.Object r8 = r8.get(r5)     // Catch:{ Exception -> 0x06a4 }
            if (r8 == 0) goto L_0x0136
            r2.setVisibility(r7)     // Catch:{ Exception -> 0x06a4 }
            r3.setVisibility(r7)     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.FareRules.CJRFareRulesJorneyDetails r0 = r6.getOnward()     // Catch:{ Exception -> 0x06a4 }
            java.util.ArrayList r0 = r0.getRoutes()     // Catch:{ Exception -> 0x06a4 }
            java.lang.Object r0 = r0.get(r5)     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.FareRules.CJRRoutes r0 = (com.travel.flight.pojo.flightticket.FareRules.CJRRoutes) r0     // Catch:{ Exception -> 0x06a4 }
            java.util.List r0 = r0.getBaggage_policies()     // Catch:{ Exception -> 0x06a4 }
            java.lang.String r0 = com.travel.flight.flightticket.j.o.a(r0)     // Catch:{ Exception -> 0x06a4 }
            android.text.Spanned r0 = android.text.Html.fromHtml(r0)     // Catch:{ Exception -> 0x06a4 }
            r4.setText(r0)     // Catch:{ Exception -> 0x06a4 }
            return
        L_0x0136:
            com.travel.flight.pojo.flightticket.FareRules.CJRFareRulesJorneyDetails r8 = r6.getOnward()     // Catch:{ Exception -> 0x06a4 }
            if (r8 == 0) goto L_0x0300
            com.travel.flight.pojo.flightticket.FareRules.CJRFareRulesJorneyDetails r8 = r6.getReturn()     // Catch:{ Exception -> 0x06a4 }
            if (r8 == 0) goto L_0x0300
            com.travel.flight.pojo.flightticket.FareRules.CJRFareRulesJorneyDetails r8 = r6.getOnward()     // Catch:{ Exception -> 0x06a4 }
            java.util.ArrayList r8 = r8.getRoutes()     // Catch:{ Exception -> 0x06a4 }
            if (r8 == 0) goto L_0x0300
            com.travel.flight.pojo.flightticket.FareRules.CJRFareRulesJorneyDetails r8 = r6.getOnward()     // Catch:{ Exception -> 0x06a4 }
            java.util.ArrayList r8 = r8.getRoutes()     // Catch:{ Exception -> 0x06a4 }
            int r8 = r8.size()     // Catch:{ Exception -> 0x06a4 }
            if (r8 <= 0) goto L_0x0300
            com.travel.flight.pojo.flightticket.FareRules.CJRFareRulesJorneyDetails r8 = r6.getOnward()     // Catch:{ Exception -> 0x06a4 }
            java.util.ArrayList r8 = r8.getRoutes()     // Catch:{ Exception -> 0x06a4 }
            java.lang.Object r8 = r8.get(r5)     // Catch:{ Exception -> 0x06a4 }
            if (r8 == 0) goto L_0x0300
            com.travel.flight.pojo.flightticket.FareRules.CJRFareRulesJorneyDetails r8 = r6.getReturn()     // Catch:{ Exception -> 0x06a4 }
            java.util.ArrayList r8 = r8.getRoutes()     // Catch:{ Exception -> 0x06a4 }
            if (r8 == 0) goto L_0x0300
            com.travel.flight.pojo.flightticket.FareRules.CJRFareRulesJorneyDetails r8 = r6.getReturn()     // Catch:{ Exception -> 0x06a4 }
            java.util.ArrayList r8 = r8.getRoutes()     // Catch:{ Exception -> 0x06a4 }
            int r8 = r8.size()     // Catch:{ Exception -> 0x06a4 }
            if (r8 <= 0) goto L_0x0300
            com.travel.flight.pojo.flightticket.FareRules.CJRFareRulesJorneyDetails r8 = r6.getReturn()     // Catch:{ Exception -> 0x06a4 }
            java.util.ArrayList r8 = r8.getRoutes()     // Catch:{ Exception -> 0x06a4 }
            java.lang.Object r8 = r8.get(r5)     // Catch:{ Exception -> 0x06a4 }
            if (r8 == 0) goto L_0x0300
            r2.setVisibility(r5)     // Catch:{ Exception -> 0x06a4 }
            r3.setVisibility(r5)     // Catch:{ Exception -> 0x06a4 }
            android.view.View r2 = r0.f25188c     // Catch:{ Exception -> 0x06a4 }
            int r3 = com.travel.flight.R.id.onward_flight_icon     // Catch:{ Exception -> 0x06a4 }
            android.view.View r2 = r2.findViewById(r3)     // Catch:{ Exception -> 0x06a4 }
            android.widget.ImageView r2 = (android.widget.ImageView) r2     // Catch:{ Exception -> 0x06a4 }
            android.view.View r3 = r0.f25188c     // Catch:{ Exception -> 0x06a4 }
            int r7 = com.travel.flight.R.id.return_flight_icon     // Catch:{ Exception -> 0x06a4 }
            android.view.View r3 = r3.findViewById(r7)     // Catch:{ Exception -> 0x06a4 }
            android.widget.ImageView r3 = (android.widget.ImageView) r3     // Catch:{ Exception -> 0x06a4 }
            android.view.View r7 = r0.f25188c     // Catch:{ Exception -> 0x06a4 }
            int r8 = com.travel.flight.R.id.arrow_view     // Catch:{ Exception -> 0x06a4 }
            r7.findViewById(r8)     // Catch:{ Exception -> 0x06a4 }
            android.view.View r7 = r0.f25188c     // Catch:{ Exception -> 0x06a4 }
            int r8 = com.travel.flight.R.id.onward_journey_src_txt     // Catch:{ Exception -> 0x06a4 }
            android.view.View r7 = r7.findViewById(r8)     // Catch:{ Exception -> 0x06a4 }
            android.widget.TextView r7 = (android.widget.TextView) r7     // Catch:{ Exception -> 0x06a4 }
            android.view.View r8 = r0.f25188c     // Catch:{ Exception -> 0x06a4 }
            int r9 = com.travel.flight.R.id.onward_journey_dest_txt     // Catch:{ Exception -> 0x06a4 }
            android.view.View r8 = r8.findViewById(r9)     // Catch:{ Exception -> 0x06a4 }
            android.widget.TextView r8 = (android.widget.TextView) r8     // Catch:{ Exception -> 0x06a4 }
            android.view.View r9 = r0.f25188c     // Catch:{ Exception -> 0x06a4 }
            int r10 = com.travel.flight.R.id.return_journey_src_txt     // Catch:{ Exception -> 0x06a4 }
            android.view.View r9 = r9.findViewById(r10)     // Catch:{ Exception -> 0x06a4 }
            android.widget.TextView r9 = (android.widget.TextView) r9     // Catch:{ Exception -> 0x06a4 }
            android.view.View r10 = r0.f25188c     // Catch:{ Exception -> 0x06a4 }
            int r11 = com.travel.flight.R.id.return_journey_dest_txt     // Catch:{ Exception -> 0x06a4 }
            android.view.View r10 = r10.findViewById(r11)     // Catch:{ Exception -> 0x06a4 }
            android.widget.TextView r10 = (android.widget.TextView) r10     // Catch:{ Exception -> 0x06a4 }
            android.view.View r11 = r0.f25188c     // Catch:{ Exception -> 0x06a4 }
            int r12 = com.travel.flight.R.id.return_baggage_info_txt     // Catch:{ Exception -> 0x06a4 }
            android.view.View r11 = r11.findViewById(r12)     // Catch:{ Exception -> 0x06a4 }
            android.widget.TextView r11 = (android.widget.TextView) r11     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.CJRFlightDetails r12 = r0.f25187b     // Catch:{ Exception -> 0x06a4 }
            java.lang.String r12 = r12.getSource()     // Catch:{ Exception -> 0x06a4 }
            r7.setText(r12)     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.CJRFlightDetails r7 = r0.f25187b     // Catch:{ Exception -> 0x06a4 }
            java.lang.String r7 = r7.getDestination()     // Catch:{ Exception -> 0x06a4 }
            r8.setText(r7)     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.CJRFlightDetails r7 = r0.f25187b     // Catch:{ Exception -> 0x06a4 }
            java.lang.String r7 = r7.getDestination()     // Catch:{ Exception -> 0x06a4 }
            r9.setText(r7)     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.CJRFlightDetails r7 = r0.f25187b     // Catch:{ Exception -> 0x06a4 }
            java.lang.String r7 = r7.getSource()     // Catch:{ Exception -> 0x06a4 }
            r10.setText(r7)     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.FareRules.CJRFareRulesJorneyDetails r7 = r6.getOnward()     // Catch:{ Exception -> 0x06a4 }
            java.util.ArrayList r7 = r7.getRoutes()     // Catch:{ Exception -> 0x06a4 }
            java.lang.Object r7 = r7.get(r5)     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.FareRules.CJRRoutes r7 = (com.travel.flight.pojo.flightticket.FareRules.CJRRoutes) r7     // Catch:{ Exception -> 0x06a4 }
            java.util.List r7 = r7.getBaggage_policies()     // Catch:{ Exception -> 0x06a4 }
            java.lang.String r7 = com.travel.flight.flightticket.j.o.a(r7)     // Catch:{ Exception -> 0x06a4 }
            android.text.Spanned r7 = android.text.Html.fromHtml(r7)     // Catch:{ Exception -> 0x06a4 }
            r4.setText(r7)     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.FareRules.CJRFareRulesJorneyDetails r4 = r6.getReturn()     // Catch:{ Exception -> 0x06a4 }
            java.util.ArrayList r4 = r4.getRoutes()     // Catch:{ Exception -> 0x06a4 }
            java.lang.Object r4 = r4.get(r5)     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.FareRules.CJRRoutes r4 = (com.travel.flight.pojo.flightticket.FareRules.CJRRoutes) r4     // Catch:{ Exception -> 0x06a4 }
            java.util.List r4 = r4.getBaggage_policies()     // Catch:{ Exception -> 0x06a4 }
            java.lang.String r4 = com.travel.flight.flightticket.j.o.a(r4)     // Catch:{ Exception -> 0x06a4 }
            android.text.Spanned r4 = android.text.Html.fromHtml(r4)     // Catch:{ Exception -> 0x06a4 }
            r11.setText(r4)     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.CJRFlightDetails r4 = r0.f25187b     // Catch:{ Exception -> 0x02ff }
            java.lang.String r5 = ".png"
            if (r4 == 0) goto L_0x02a0
            com.travel.flight.pojo.flightticket.CJRFlightDetails r4 = r0.f25187b     // Catch:{ Exception -> 0x02ff }
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r4 = r4.getmOnwardJourney()     // Catch:{ Exception -> 0x02ff }
            if (r4 == 0) goto L_0x02a0
            com.travel.flight.pojo.flightticket.CJRFlightDetails r4 = r0.f25187b     // Catch:{ Exception -> 0x02ff }
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r4 = r4.getmOnwardJourney()     // Catch:{ Exception -> 0x02ff }
            java.lang.String r4 = r4.getmAirLineCode()     // Catch:{ Exception -> 0x02ff }
            if (r4 == 0) goto L_0x02a0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ff }
            r4.<init>()     // Catch:{ Exception -> 0x02ff }
            java.lang.String r6 = r0.f25186a     // Catch:{ Exception -> 0x02ff }
            r4.append(r6)     // Catch:{ Exception -> 0x02ff }
            com.travel.flight.pojo.flightticket.CJRFlightDetails r6 = r0.f25187b     // Catch:{ Exception -> 0x02ff }
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r6 = r6.getmOnwardJourney()     // Catch:{ Exception -> 0x02ff }
            java.lang.String r6 = r6.getmAirLineCode()     // Catch:{ Exception -> 0x02ff }
            r4.append(r6)     // Catch:{ Exception -> 0x02ff }
            r4.append(r5)     // Catch:{ Exception -> 0x02ff }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x02ff }
            boolean r6 = android.webkit.URLUtil.isValidUrl(r4)     // Catch:{ Exception -> 0x02ff }
            if (r6 == 0) goto L_0x02a0
            android.view.View r6 = r0.f25188c     // Catch:{ Exception -> 0x02ff }
            android.content.Context r6 = r6.getContext()     // Catch:{ Exception -> 0x02ff }
            com.paytm.utility.b.b$a$a r6 = com.paytm.utility.b.b.a(r6)     // Catch:{ Exception -> 0x02ff }
            r6.f43753a = r4     // Catch:{ Exception -> 0x02ff }
            int r4 = com.travel.flight.R.drawable.pre_f_defaultcarrier     // Catch:{ Exception -> 0x02ff }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x02ff }
            com.paytm.utility.b.b$a$a r4 = r6.a((java.lang.Object) r4)     // Catch:{ Exception -> 0x02ff }
            int r6 = com.travel.flight.R.drawable.pre_f_defaultcarrier     // Catch:{ Exception -> 0x02ff }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x02ff }
            com.paytm.utility.b.b$a$a r4 = r4.b(r6)     // Catch:{ Exception -> 0x02ff }
            r4.a((android.widget.ImageView) r2)     // Catch:{ Exception -> 0x02ff }
        L_0x02a0:
            com.travel.flight.pojo.flightticket.CJRFlightDetails r2 = r0.f25187b     // Catch:{ Exception -> 0x02ff }
            if (r2 == 0) goto L_0x02ff
            com.travel.flight.pojo.flightticket.CJRFlightDetails r2 = r0.f25187b     // Catch:{ Exception -> 0x02ff }
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r2 = r2.getmReturnJourney()     // Catch:{ Exception -> 0x02ff }
            if (r2 == 0) goto L_0x02ff
            com.travel.flight.pojo.flightticket.CJRFlightDetails r2 = r0.f25187b     // Catch:{ Exception -> 0x02ff }
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r2 = r2.getmReturnJourney()     // Catch:{ Exception -> 0x02ff }
            java.lang.String r2 = r2.getmAirLineCode()     // Catch:{ Exception -> 0x02ff }
            if (r2 == 0) goto L_0x02ff
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ff }
            r2.<init>()     // Catch:{ Exception -> 0x02ff }
            java.lang.String r4 = r0.f25186a     // Catch:{ Exception -> 0x02ff }
            r2.append(r4)     // Catch:{ Exception -> 0x02ff }
            com.travel.flight.pojo.flightticket.CJRFlightDetails r4 = r0.f25187b     // Catch:{ Exception -> 0x02ff }
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r4 = r4.getmReturnJourney()     // Catch:{ Exception -> 0x02ff }
            java.lang.String r4 = r4.getmAirLineCode()     // Catch:{ Exception -> 0x02ff }
            r2.append(r4)     // Catch:{ Exception -> 0x02ff }
            r2.append(r5)     // Catch:{ Exception -> 0x02ff }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x02ff }
            boolean r4 = android.webkit.URLUtil.isValidUrl(r2)     // Catch:{ Exception -> 0x02ff }
            if (r4 == 0) goto L_0x02ff
            android.view.View r0 = r0.f25188c     // Catch:{ Exception -> 0x02ff }
            android.content.Context r0 = r0.getContext()     // Catch:{ Exception -> 0x02ff }
            com.paytm.utility.b.b$a$a r0 = com.paytm.utility.b.b.a(r0)     // Catch:{ Exception -> 0x02ff }
            r0.f43753a = r2     // Catch:{ Exception -> 0x02ff }
            int r2 = com.travel.flight.R.drawable.pre_f_defaultcarrier     // Catch:{ Exception -> 0x02ff }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x02ff }
            com.paytm.utility.b.b$a$a r0 = r0.a((java.lang.Object) r2)     // Catch:{ Exception -> 0x02ff }
            int r2 = com.travel.flight.R.drawable.pre_f_defaultcarrier     // Catch:{ Exception -> 0x02ff }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x02ff }
            com.paytm.utility.b.b$a$a r0 = r0.b(r2)     // Catch:{ Exception -> 0x02ff }
            r0.a((android.widget.ImageView) r3)     // Catch:{ Exception -> 0x02ff }
        L_0x02ff:
            return
        L_0x0300:
            android.view.View r0 = r0.f25188c     // Catch:{ Exception -> 0x06a4 }
            int r2 = com.travel.flight.R.id.baggage_main_lyt     // Catch:{ Exception -> 0x06a4 }
            android.view.View r0 = r0.findViewById(r2)     // Catch:{ Exception -> 0x06a4 }
            r0.setVisibility(r7)     // Catch:{ Exception -> 0x06a4 }
        L_0x030b:
            return
        L_0x030c:
            boolean r3 = r0 instanceof com.travel.flight.flightticket.j.p     // Catch:{ Exception -> 0x06a4 }
            if (r3 == 0) goto L_0x0525
            com.travel.flight.flightticket.j.p r0 = (com.travel.flight.flightticket.j.p) r0     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.insurance.CJRCancelProtectInsuranceItem r2 = r1.f24679g     // Catch:{ Exception -> 0x06a4 }
            android.view.View r3 = r0.f25191b     // Catch:{ Exception -> 0x06a4 }
            int r8 = com.travel.flight.R.id.opt_out_radio_button     // Catch:{ Exception -> 0x06a4 }
            android.view.View r3 = r3.findViewById(r8)     // Catch:{ Exception -> 0x06a4 }
            android.widget.RadioButton r3 = (android.widget.RadioButton) r3     // Catch:{ Exception -> 0x06a4 }
            r0.f25192c = r3     // Catch:{ Exception -> 0x06a4 }
            android.view.View r3 = r0.f25191b     // Catch:{ Exception -> 0x06a4 }
            int r8 = com.travel.flight.R.id.opt_in_radio_button     // Catch:{ Exception -> 0x06a4 }
            android.view.View r3 = r3.findViewById(r8)     // Catch:{ Exception -> 0x06a4 }
            android.widget.RadioButton r3 = (android.widget.RadioButton) r3     // Catch:{ Exception -> 0x06a4 }
            r0.f25193d = r3     // Catch:{ Exception -> 0x06a4 }
            android.view.View r3 = r0.f25191b     // Catch:{ Exception -> 0x06a4 }
            int r8 = com.travel.flight.R.id.cancellation_lyt     // Catch:{ Exception -> 0x06a4 }
            android.view.View r3 = r3.findViewById(r8)     // Catch:{ Exception -> 0x06a4 }
            android.widget.RelativeLayout r3 = (android.widget.RelativeLayout) r3     // Catch:{ Exception -> 0x06a4 }
            android.view.View r8 = r0.f25191b     // Catch:{ Exception -> 0x06a4 }
            int r9 = com.travel.flight.R.id.opt_out_lyt     // Catch:{ Exception -> 0x06a4 }
            android.view.View r8 = r8.findViewById(r9)     // Catch:{ Exception -> 0x06a4 }
            android.widget.RelativeLayout r8 = (android.widget.RelativeLayout) r8     // Catch:{ Exception -> 0x06a4 }
            android.view.View r9 = r0.f25191b     // Catch:{ Exception -> 0x06a4 }
            int r10 = com.travel.flight.R.id.opt_in_lyt     // Catch:{ Exception -> 0x06a4 }
            android.view.View r9 = r9.findViewById(r10)     // Catch:{ Exception -> 0x06a4 }
            android.widget.RelativeLayout r9 = (android.widget.RelativeLayout) r9     // Catch:{ Exception -> 0x06a4 }
            android.view.View r10 = r0.f25191b     // Catch:{ Exception -> 0x06a4 }
            int r11 = com.travel.flight.R.id.cancellation_title_txt     // Catch:{ Exception -> 0x06a4 }
            android.view.View r10 = r10.findViewById(r11)     // Catch:{ Exception -> 0x06a4 }
            android.widget.TextView r10 = (android.widget.TextView) r10     // Catch:{ Exception -> 0x06a4 }
            android.view.View r11 = r0.f25191b     // Catch:{ Exception -> 0x06a4 }
            int r12 = com.travel.flight.R.id.cancellation_icon     // Catch:{ Exception -> 0x06a4 }
            android.view.View r11 = r11.findViewById(r12)     // Catch:{ Exception -> 0x06a4 }
            android.widget.ImageView r11 = (android.widget.ImageView) r11     // Catch:{ Exception -> 0x06a4 }
            android.view.View r12 = r0.f25191b     // Catch:{ Exception -> 0x06a4 }
            int r13 = com.travel.flight.R.id.opt_out_detail_txt     // Catch:{ Exception -> 0x06a4 }
            android.view.View r12 = r12.findViewById(r13)     // Catch:{ Exception -> 0x06a4 }
            android.widget.TextView r12 = (android.widget.TextView) r12     // Catch:{ Exception -> 0x06a4 }
            android.view.View r13 = r0.f25191b     // Catch:{ Exception -> 0x06a4 }
            int r14 = com.travel.flight.R.id.opt_in_detail_txt     // Catch:{ Exception -> 0x06a4 }
            android.view.View r13 = r13.findViewById(r14)     // Catch:{ Exception -> 0x06a4 }
            android.widget.TextView r13 = (android.widget.TextView) r13     // Catch:{ Exception -> 0x06a4 }
            android.view.View r14 = r0.f25191b     // Catch:{ Exception -> 0x06a4 }
            int r15 = com.travel.flight.R.id.opt_in_detail_sub_txt     // Catch:{ Exception -> 0x06a4 }
            android.view.View r14 = r14.findViewById(r15)     // Catch:{ Exception -> 0x06a4 }
            android.widget.TextView r14 = (android.widget.TextView) r14     // Catch:{ Exception -> 0x06a4 }
            android.widget.RadioButton r15 = r0.f25192c     // Catch:{ Exception -> 0x06a4 }
            r15.setOnClickListener(r0)     // Catch:{ Exception -> 0x06a4 }
            android.widget.RadioButton r15 = r0.f25193d     // Catch:{ Exception -> 0x06a4 }
            r15.setOnClickListener(r0)     // Catch:{ Exception -> 0x06a4 }
            r8.setOnClickListener(r0)     // Catch:{ Exception -> 0x06a4 }
            r9.setOnClickListener(r0)     // Catch:{ Exception -> 0x06a4 }
            if (r2 == 0) goto L_0x0521
            com.travel.flight.pojo.flightticket.insurance.CJRFlightInsuranceSelectOptionFlight r15 = r2.getSelectOption()     // Catch:{ Exception -> 0x06a4 }
            if (r15 == 0) goto L_0x0521
            com.travel.flight.pojo.flightticket.CJRFlightDetails r15 = r0.f25194e     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceModel r15 = r15.getInsuranceData()     // Catch:{ Exception -> 0x06a4 }
            if (r15 == 0) goto L_0x03ec
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceBody r16 = r15.getBody()     // Catch:{ Exception -> 0x06a4 }
            if (r16 == 0) goto L_0x03ec
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceBody r16 = r15.getBody()     // Catch:{ Exception -> 0x06a4 }
            java.util.List r16 = r16.getCancelProtectInsuranceDetail()     // Catch:{ Exception -> 0x06a4 }
            if (r16 == 0) goto L_0x03ec
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceBody r16 = r15.getBody()     // Catch:{ Exception -> 0x06a4 }
            java.util.List r16 = r16.getCancelProtectInsuranceDetail()     // Catch:{ Exception -> 0x06a4 }
            int r16 = r16.size()     // Catch:{ Exception -> 0x06a4 }
            if (r16 <= 0) goto L_0x03ec
            java.lang.Boolean r16 = com.travel.flight.flightticket.j.p.a()     // Catch:{ Exception -> 0x06a4 }
            if (r16 == 0) goto L_0x03d5
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceBody r17 = r15.getBody()     // Catch:{ Exception -> 0x06a4 }
            java.util.List r6 = r17.getCancelProtectInsuranceDetail()     // Catch:{ Exception -> 0x06a4 }
            java.lang.Object r6 = r6.get(r5)     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.insurance.CJRCancelProtectInsuranceItem r6 = (com.travel.flight.pojo.flightticket.insurance.CJRCancelProtectInsuranceItem) r6     // Catch:{ Exception -> 0x06a4 }
            boolean r4 = r16.booleanValue()     // Catch:{ Exception -> 0x06a4 }
            r6.setOptIn(r4)     // Catch:{ Exception -> 0x06a4 }
        L_0x03d5:
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceBody r4 = r15.getBody()     // Catch:{ Exception -> 0x06a4 }
            java.util.List r4 = r4.getCancelProtectInsuranceDetail()     // Catch:{ Exception -> 0x06a4 }
            java.lang.Object r4 = r4.get(r5)     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.insurance.CJRCancelProtectInsuranceItem r4 = (com.travel.flight.pojo.flightticket.insurance.CJRCancelProtectInsuranceItem) r4     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.CJRFlightDetails r6 = r0.f25194e     // Catch:{ Exception -> 0x06a4 }
            boolean r4 = r4.isOptIn()     // Catch:{ Exception -> 0x06a4 }
            r6.setInsuranceCancelProtectApplied(r4)     // Catch:{ Exception -> 0x06a4 }
        L_0x03ec:
            android.view.View r4 = r0.f25191b     // Catch:{ Exception -> 0x06a4 }
            int r6 = com.travel.flight.R.id.baggage_view     // Catch:{ Exception -> 0x06a4 }
            android.view.View r4 = r4.findViewById(r6)     // Catch:{ Exception -> 0x06a4 }
            r4.setVisibility(r5)     // Catch:{ Exception -> 0x06a4 }
            r3.setVisibility(r5)     // Catch:{ Exception -> 0x06a4 }
            java.lang.String r3 = "cancellation_revam.png"
            com.travel.utils.n$a r4 = com.travel.utils.n.a.V1     // Catch:{ Exception -> 0x06a4 }
            com.travel.cdn.ResourceUtils.loadFlightImagesFromCDN(r11, r3, r5, r5, r4)     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.insurance.CJRFlightInsuranceSelectOptionFlight r3 = r2.getSelectOption()     // Catch:{ Exception -> 0x06a4 }
            java.lang.String r3 = r3.getTitle()     // Catch:{ Exception -> 0x06a4 }
            if (r3 == 0) goto L_0x0416
            com.travel.flight.pojo.flightticket.insurance.CJRFlightInsuranceSelectOptionFlight r3 = r2.getSelectOption()     // Catch:{ Exception -> 0x06a4 }
            java.lang.String r3 = r3.getTitle()     // Catch:{ Exception -> 0x06a4 }
            r10.setText(r3)     // Catch:{ Exception -> 0x06a4 }
        L_0x0416:
            com.travel.flight.pojo.flightticket.insurance.CJRFlightInsuranceSelectOptionFlight r3 = r2.getSelectOption()     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.insurance.CJRFlightOptionSelectionFlight r3 = r3.getOptionOut()     // Catch:{ Exception -> 0x06a4 }
            if (r3 == 0) goto L_0x0450
            r8.setVisibility(r5)     // Catch:{ Exception -> 0x06a4 }
            android.widget.RadioButton r3 = r0.f25192c     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.insurance.CJRFlightInsuranceSelectOptionFlight r4 = r2.getSelectOption()     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.insurance.CJRFlightOptionSelectionFlight r4 = r4.getOptionOut()     // Catch:{ Exception -> 0x06a4 }
            java.lang.String r4 = r4.getTitle()     // Catch:{ Exception -> 0x06a4 }
            r3.setText(r4)     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.insurance.CJRFlightInsuranceSelectOptionFlight r3 = r2.getSelectOption()     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.insurance.CJRFlightOptionSelectionFlight r3 = r3.getOptionOut()     // Catch:{ Exception -> 0x06a4 }
            java.lang.String r3 = r3.getRefunadTitle()     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.insurance.CJRFlightInsuranceSelectOptionFlight r4 = r2.getSelectOption()     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.insurance.CJRFlightOptionSelectionFlight r4 = r4.getOptionOut()     // Catch:{ Exception -> 0x06a4 }
            java.lang.String r4 = r4.getRefundAmount()     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.flightticket.j.p.a(r12, r3, r4)     // Catch:{ Exception -> 0x06a4 }
            goto L_0x0453
        L_0x0450:
            r8.setVisibility(r7)     // Catch:{ Exception -> 0x06a4 }
        L_0x0453:
            com.travel.flight.pojo.flightticket.insurance.CJRFlightInsuranceSelectOptionFlight r3 = r2.getSelectOption()     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.insurance.CJRFlightOptionSelectionFlight r3 = r3.getOptionIn()     // Catch:{ Exception -> 0x06a4 }
            if (r3 == 0) goto L_0x04ec
            r9.setVisibility(r5)     // Catch:{ Exception -> 0x06a4 }
            android.widget.RadioButton r3 = r0.f25193d     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.insurance.CJRFlightInsuranceSelectOptionFlight r4 = r2.getSelectOption()     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.insurance.CJRFlightOptionSelectionFlight r4 = r4.getOptionIn()     // Catch:{ Exception -> 0x06a4 }
            java.lang.String r4 = r4.getDescription()     // Catch:{ Exception -> 0x06a4 }
            r3.setText(r4)     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.insurance.CJRFlightInsuranceSelectOptionFlight r3 = r2.getSelectOption()     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.insurance.CJRFlightOptionSelectionFlight r3 = r3.getOptionIn()     // Catch:{ Exception -> 0x06a4 }
            java.lang.String r3 = r3.getTitle()     // Catch:{ Exception -> 0x06a4 }
            java.lang.String r4 = r2.getTnc()     // Catch:{ Exception -> 0x06a4 }
            android.content.res.Resources r6 = r14.getResources()     // Catch:{ Exception -> 0x06a4 }
            int r7 = com.travel.flight.R.string.know_more     // Catch:{ Exception -> 0x06a4 }
            java.lang.String r6 = r6.getString(r7)     // Catch:{ Exception -> 0x06a4 }
            android.content.res.Resources r7 = r14.getResources()     // Catch:{ Exception -> 0x06a4 }
            int r8 = com.travel.flight.R.string.free_cancellation     // Catch:{ Exception -> 0x06a4 }
            java.lang.String r7 = r7.getString(r8)     // Catch:{ Exception -> 0x06a4 }
            android.content.res.Resources r8 = r14.getResources()     // Catch:{ Exception -> 0x06a4 }
            int r9 = com.travel.flight.R.string.free_cancellation_rawstring     // Catch:{ Exception -> 0x06a4 }
            java.lang.String r8 = r8.getString(r9)     // Catch:{ Exception -> 0x06a4 }
            r9 = 2
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x06a4 }
            r9[r5] = r3     // Catch:{ Exception -> 0x06a4 }
            r3 = 1
            r9[r3] = r6     // Catch:{ Exception -> 0x06a4 }
            java.lang.String r3 = java.lang.String.format(r8, r9)     // Catch:{ Exception -> 0x06a4 }
            android.text.SpannableString r8 = new android.text.SpannableString     // Catch:{ Exception -> 0x06a4 }
            r8.<init>(r3)     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.flightticket.j.p$1 r9 = new com.travel.flight.flightticket.j.p$1     // Catch:{ Exception -> 0x06a4 }
            r9.<init>(r4, r7)     // Catch:{ Exception -> 0x06a4 }
            int r4 = r3.indexOf(r6)     // Catch:{ Exception -> 0x06a4 }
            int r3 = r3.length()     // Catch:{ Exception -> 0x06a4 }
            r6 = 33
            r8.setSpan(r9, r4, r3, r6)     // Catch:{ Exception -> 0x06a4 }
            r14.setText(r8)     // Catch:{ Exception -> 0x06a4 }
            r3 = 1
            r14.setClickable(r3)     // Catch:{ Exception -> 0x06a4 }
            android.text.method.MovementMethod r3 = android.text.method.LinkMovementMethod.getInstance()     // Catch:{ Exception -> 0x06a4 }
            r14.setMovementMethod(r3)     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.insurance.CJRFlightInsuranceSelectOptionFlight r3 = r2.getSelectOption()     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.insurance.CJRFlightOptionSelectionFlight r3 = r3.getOptionIn()     // Catch:{ Exception -> 0x06a4 }
            java.lang.String r3 = r3.getRefunadTitle()     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.insurance.CJRFlightInsuranceSelectOptionFlight r4 = r2.getSelectOption()     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.insurance.CJRFlightOptionSelectionFlight r4 = r4.getOptionIn()     // Catch:{ Exception -> 0x06a4 }
            java.lang.String r4 = r4.getRefundAmount()     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.flightticket.j.p.a(r13, r3, r4)     // Catch:{ Exception -> 0x06a4 }
            goto L_0x04ef
        L_0x04ec:
            r9.setVisibility(r7)     // Catch:{ Exception -> 0x06a4 }
        L_0x04ef:
            boolean r2 = r2.isOptIn()     // Catch:{ Exception -> 0x06a4 }
            if (r2 == 0) goto L_0x0501
            android.widget.RadioButton r2 = r0.f25193d     // Catch:{ Exception -> 0x06a4 }
            r3 = 1
            r2.setChecked(r3)     // Catch:{ Exception -> 0x06a4 }
            android.widget.RadioButton r2 = r0.f25192c     // Catch:{ Exception -> 0x06a4 }
            r2.setChecked(r5)     // Catch:{ Exception -> 0x06a4 }
            goto L_0x050c
        L_0x0501:
            android.widget.RadioButton r2 = r0.f25193d     // Catch:{ Exception -> 0x06a4 }
            r2.setChecked(r5)     // Catch:{ Exception -> 0x06a4 }
            android.widget.RadioButton r2 = r0.f25192c     // Catch:{ Exception -> 0x06a4 }
            r3 = 1
            r2.setChecked(r3)     // Catch:{ Exception -> 0x06a4 }
        L_0x050c:
            com.travel.flight.flightticket.f.k r2 = r0.f25190a     // Catch:{ Exception -> 0x06a4 }
            java.lang.String r3 = ""
            android.widget.RadioButton r0 = r0.f25193d     // Catch:{ Exception -> 0x06a4 }
            boolean r0 = r0.isChecked()     // Catch:{ Exception -> 0x06a4 }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.flightticket.d.c r4 = com.travel.flight.flightticket.d.c.CANCEL_PROTECT_INSURANCE_CHECKBOX     // Catch:{ Exception -> 0x06a4 }
            r5 = 0
            r2.reviewIternaryActionClick(r3, r5, r0, r4)     // Catch:{ Exception -> 0x06a4 }
            return
        L_0x0521:
            r3.setVisibility(r7)     // Catch:{ Exception -> 0x06a4 }
            return
        L_0x0525:
            boolean r3 = r0 instanceof com.travel.flight.flightticket.j.u     // Catch:{ Exception -> 0x06a4 }
            if (r3 == 0) goto L_0x060b
            com.travel.flight.flightticket.j.u r0 = (com.travel.flight.flightticket.j.u) r0     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.CJRFlightDetails r2 = r1.f24674b     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.flightticket.f.k r3 = r1.j     // Catch:{ Exception -> 0x06a4 }
            boolean r4 = r1.l     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.insurance.CJRCancelProtectInsuranceItem r6 = r1.f24679g     // Catch:{ Exception -> 0x06a4 }
            r0.f25216e = r2     // Catch:{ Exception -> 0x06a4 }
            r0.f25217f = r3     // Catch:{ Exception -> 0x06a4 }
            r0.f25218g = r4     // Catch:{ Exception -> 0x06a4 }
            if (r2 == 0) goto L_0x0583
            java.lang.Boolean r3 = r2.getmIsInternational()     // Catch:{ Exception -> 0x06a4 }
            boolean r3 = r3.booleanValue()     // Catch:{ Exception -> 0x06a4 }
            if (r3 != 0) goto L_0x0552
            com.travel.flight.b.a()     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.c r3 = com.travel.flight.b.b()     // Catch:{ Exception -> 0x06a4 }
            boolean r3 = r3.A()     // Catch:{ Exception -> 0x06a4 }
            if (r3 == 0) goto L_0x0583
        L_0x0552:
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r2 = r2.getmOnwardJourney()     // Catch:{ Exception -> 0x06a4 }
            java.lang.String r3 = r2.getmOtherinfo()     // Catch:{ Exception -> 0x06a4 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x06a4 }
            if (r3 != 0) goto L_0x057d
            android.widget.TextView r3 = r0.f25213b     // Catch:{ Exception -> 0x06a4 }
            r3.setVisibility(r5)     // Catch:{ Exception -> 0x06a4 }
            android.widget.TextView r3 = r0.f25213b     // Catch:{ Exception -> 0x06a4 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x06a4 }
            java.lang.String r8 = "Note: "
            r4.<init>(r8)     // Catch:{ Exception -> 0x06a4 }
            java.lang.String r2 = r2.getmOtherinfo()     // Catch:{ Exception -> 0x06a4 }
            r4.append(r2)     // Catch:{ Exception -> 0x06a4 }
            java.lang.String r2 = r4.toString()     // Catch:{ Exception -> 0x06a4 }
            r3.setText(r2)     // Catch:{ Exception -> 0x06a4 }
            goto L_0x0588
        L_0x057d:
            android.widget.TextView r2 = r0.f25213b     // Catch:{ Exception -> 0x06a4 }
            r2.setVisibility(r7)     // Catch:{ Exception -> 0x06a4 }
            goto L_0x0588
        L_0x0583:
            android.widget.TextView r2 = r0.f25213b     // Catch:{ Exception -> 0x06a4 }
            r2.setVisibility(r7)     // Catch:{ Exception -> 0x06a4 }
        L_0x0588:
            com.travel.flight.pojo.flightticket.CJRFlightDetails r2 = r0.f25216e     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.CJRMetadetails r2 = r2.getmMetaDetails()     // Catch:{ Exception -> 0x06a4 }
            java.lang.Boolean r2 = r2.isDisplaySoldBy()     // Catch:{ Exception -> 0x06a4 }
            if (r2 != 0) goto L_0x0598
            r0.a()     // Catch:{ Exception -> 0x06a4 }
            goto L_0x05b1
        L_0x0598:
            com.travel.flight.pojo.flightticket.CJRFlightDetails r2 = r0.f25216e     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.CJRMetadetails r2 = r2.getmMetaDetails()     // Catch:{ Exception -> 0x06a4 }
            java.lang.Boolean r2 = r2.isDisplaySoldBy()     // Catch:{ Exception -> 0x06a4 }
            boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x06a4 }
            if (r2 == 0) goto L_0x05ac
            r0.a()     // Catch:{ Exception -> 0x06a4 }
            goto L_0x05b1
        L_0x05ac:
            android.widget.TextView r2 = r0.f25212a     // Catch:{ Exception -> 0x06a4 }
            r2.setVisibility(r7)     // Catch:{ Exception -> 0x06a4 }
        L_0x05b1:
            if (r6 == 0) goto L_0x05bc
            com.travel.flight.pojo.flightticket.insurance.CJRFlightInsuranceSelectOptionFlight r2 = r6.getSelectOption()     // Catch:{ Exception -> 0x06a4 }
            if (r2 == 0) goto L_0x05bc
            r17 = 1
            goto L_0x05be
        L_0x05bc:
            r17 = 0
        L_0x05be:
            android.content.Context r2 = r0.f25215d     // Catch:{ Exception -> 0x06a4 }
            android.content.res.Resources r2 = r2.getResources()     // Catch:{ Exception -> 0x06a4 }
            int r3 = com.travel.flight.R.dimen.dimen_13dp     // Catch:{ Exception -> 0x06a4 }
            float r2 = r2.getDimension(r3)     // Catch:{ Exception -> 0x06a4 }
            int r2 = (int) r2     // Catch:{ Exception -> 0x06a4 }
            android.content.Context r3 = r0.f25215d     // Catch:{ Exception -> 0x06a4 }
            android.content.res.Resources r3 = r3.getResources()     // Catch:{ Exception -> 0x06a4 }
            int r4 = com.travel.flight.R.dimen.flight_dimen_12dp     // Catch:{ Exception -> 0x06a4 }
            float r3 = r3.getDimension(r4)     // Catch:{ Exception -> 0x06a4 }
            int r3 = (int) r3     // Catch:{ Exception -> 0x06a4 }
            android.content.Context r4 = r0.f25215d     // Catch:{ Exception -> 0x06a4 }
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ Exception -> 0x06a4 }
            int r5 = com.travel.flight.R.dimen.flight_dimen_7dp     // Catch:{ Exception -> 0x06a4 }
            float r4 = r4.getDimension(r5)     // Catch:{ Exception -> 0x06a4 }
            int r4 = (int) r4     // Catch:{ Exception -> 0x06a4 }
            android.content.Context r5 = r0.f25215d     // Catch:{ Exception -> 0x06a4 }
            android.content.res.Resources r5 = r5.getResources()     // Catch:{ Exception -> 0x06a4 }
            int r6 = com.travel.flight.R.dimen.flight_dimen_66dp     // Catch:{ Exception -> 0x06a4 }
            float r5 = r5.getDimension(r6)     // Catch:{ Exception -> 0x06a4 }
            int r5 = (int) r5     // Catch:{ Exception -> 0x06a4 }
            android.content.Context r6 = r0.f25215d     // Catch:{ Exception -> 0x06a4 }
            android.content.res.Resources r6 = r6.getResources()     // Catch:{ Exception -> 0x06a4 }
            int r7 = com.travel.flight.R.dimen.dimen_4dp     // Catch:{ Exception -> 0x06a4 }
            float r6 = r6.getDimension(r7)     // Catch:{ Exception -> 0x06a4 }
            int r6 = (int) r6     // Catch:{ Exception -> 0x06a4 }
            android.view.ViewGroup r0 = r0.f25214c     // Catch:{ Exception -> 0x06a4 }
            if (r17 == 0) goto L_0x0604
            r2 = r5
        L_0x0604:
            if (r17 == 0) goto L_0x0607
            r4 = r6
        L_0x0607:
            r0.setPadding(r2, r4, r3, r6)     // Catch:{ Exception -> 0x06a4 }
            return
        L_0x060b:
            boolean r3 = r0 instanceof com.travel.flight.flightSRPV2.view.ui.a.j     // Catch:{ Exception -> 0x06a4 }
            if (r3 == 0) goto L_0x0622
            com.travel.flight.flightSRPV2.view.ui.a.j r0 = (com.travel.flight.flightSRPV2.view.ui.a.j) r0     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.CJRFlightDetails r2 = r1.f24674b     // Catch:{ Exception -> 0x06a4 }
            java.util.List r2 = r2.getPaymentDetails()     // Catch:{ Exception -> 0x06a4 }
            java.lang.String r3 = "paymentDetails"
            kotlin.g.b.k.c(r2, r3)     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.b.bk r0 = r0.f24203a     // Catch:{ Exception -> 0x06a4 }
            r0.a(r2)     // Catch:{ Exception -> 0x06a4 }
            return
        L_0x0622:
            boolean r3 = r0 instanceof com.travel.flight.flightticket.j.l     // Catch:{ Exception -> 0x06a4 }
            if (r3 == 0) goto L_0x065b
            r2 = r0
            com.travel.flight.flightticket.j.l r2 = (com.travel.flight.flightticket.j.l) r2     // Catch:{ Exception -> 0x06a4 }
            java.lang.String r2 = r2.f25178a     // Catch:{ Exception -> 0x06a4 }
            java.lang.String r3 = "review_top"
            boolean r2 = r2.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x06a4 }
            if (r2 == 0) goto L_0x0647
            com.travel.flight.flightticket.j.l r2 = r1.v     // Catch:{ Exception -> 0x06a4 }
            if (r2 != 0) goto L_0x06a3
            com.travel.flight.flightticket.j.l r0 = (com.travel.flight.flightticket.j.l) r0     // Catch:{ Exception -> 0x06a4 }
            r1.v = r0     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.flightticket.j.l r0 = r1.v     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.CJRFlightDetails r2 = r1.f24674b     // Catch:{ Exception -> 0x06a4 }
            java.lang.String r2 = r2.getmReviewInfoBoxHtml()     // Catch:{ Exception -> 0x06a4 }
            r0.a((java.lang.String) r2)     // Catch:{ Exception -> 0x06a4 }
            return
        L_0x0647:
            com.travel.flight.flightticket.j.l r2 = r1.w     // Catch:{ Exception -> 0x06a4 }
            if (r2 != 0) goto L_0x06a3
            com.travel.flight.flightticket.j.l r0 = (com.travel.flight.flightticket.j.l) r0     // Catch:{ Exception -> 0x06a4 }
            r1.w = r0     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.flightticket.j.l r0 = r1.w     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.CJRFlightDetails r2 = r1.f24674b     // Catch:{ Exception -> 0x06a4 }
            java.lang.String r2 = r2.getmReviewInfoBoxHtmlBottom()     // Catch:{ Exception -> 0x06a4 }
            r0.a((java.lang.String) r2)     // Catch:{ Exception -> 0x06a4 }
            return
        L_0x065b:
            com.travel.flight.flightticket.j.ac r0 = (com.travel.flight.flightticket.j.ac) r0     // Catch:{ Exception -> 0x06a4 }
            android.widget.LinearLayout r3 = r0.f25065b     // Catch:{ Exception -> 0x06a4 }
            if (r3 == 0) goto L_0x066e
            android.widget.LinearLayout r3 = r0.f25065b     // Catch:{ Exception -> 0x06a4 }
            int r3 = r3.getChildCount()     // Catch:{ Exception -> 0x06a4 }
            if (r3 <= 0) goto L_0x066e
            android.widget.LinearLayout r3 = r0.f25065b     // Catch:{ Exception -> 0x06a4 }
            r3.removeAllViews()     // Catch:{ Exception -> 0x06a4 }
        L_0x066e:
            if (r2 != 0) goto L_0x0687
            java.lang.String r2 = "one_way"
            r0.f25072i = r2     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.CJRFlightDetails r2 = r0.f25064a     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r2 = r2.getmOnwardJourney()     // Catch:{ Exception -> 0x06a4 }
            r0.f25071h = r2     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r2 = r0.f25071h     // Catch:{ Exception -> 0x06a4 }
            if (r2 == 0) goto L_0x06a3
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r2 = r0.f25071h     // Catch:{ Exception -> 0x06a4 }
            r3 = 1
            r0.a((com.travel.flight.pojo.flightticket.CJRFlightDetailsItem) r2, (boolean) r3)     // Catch:{ Exception -> 0x06a4 }
            return
        L_0x0687:
            boolean r3 = r0.j     // Catch:{ Exception -> 0x06a4 }
            if (r3 == 0) goto L_0x06a3
            r3 = 1
            if (r2 != r3) goto L_0x06a3
            java.lang.String r2 = "round_trip"
            r0.f25072i = r2     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.CJRFlightDetails r2 = r0.f25064a     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r2 = r2.getmReturnJourney()     // Catch:{ Exception -> 0x06a4 }
            r0.f25071h = r2     // Catch:{ Exception -> 0x06a4 }
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r2 = r0.f25071h     // Catch:{ Exception -> 0x06a4 }
            if (r2 == 0) goto L_0x06a3
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r2 = r0.f25071h     // Catch:{ Exception -> 0x06a4 }
            r0.a((com.travel.flight.pojo.flightticket.CJRFlightDetailsItem) r2, (boolean) r5)     // Catch:{ Exception -> 0x06a4 }
        L_0x06a3:
            return
        L_0x06a4:
            r0 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r0 = r0.getMessage()
            r2.append(r0)
            com.paytm.utility.b.j()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightticket.a.j.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$v, int):void");
    }

    public final int getItemCount() {
        return this.u.size();
    }

    public final int getItemViewType(int i2) {
        if (!this.u.get(i2).f24682a.equalsIgnoreCase("onWardFlight") && !this.u.get(i2).f24682a.equalsIgnoreCase("returnFlight")) {
            if (this.u.get(i2).f24682a.equalsIgnoreCase("htmlBox")) {
                return 14;
            }
            if (this.u.get(i2).f24682a.equalsIgnoreCase("htmlBoxBottom")) {
                return 15;
            }
            if (this.u.get(i2).f24682a.equalsIgnoreCase("offerItem")) {
                return 3;
            }
            if (this.u.get(i2).f24682a.equalsIgnoreCase("travellerItem")) {
                return 2;
            }
            if (this.u.get(i2).f24682a.equalsIgnoreCase("fareItem")) {
                return 1;
            }
            if (this.u.get(i2).f24682a.equalsIgnoreCase("importantInfoItem")) {
                return 4;
            }
            if (this.u.get(i2).f24682a.equalsIgnoreCase("importantNewInfoItem")) {
                return 13;
            }
            if (this.u.get(i2).f24682a.equalsIgnoreCase("payItem")) {
                return 5;
            }
            if (this.u.get(i2).f24682a.equalsIgnoreCase("paytmInsurance")) {
                return 7;
            }
            if (this.u.get(i2).f24682a.equalsIgnoreCase("cancelProtectInsurance")) {
                return 8;
            }
            if (this.u.get(i2).f24682a.equalsIgnoreCase("baggagePolicy")) {
                return 16;
            }
            if (this.u.get(i2).f24682a.equalsIgnoreCase("cancellationPolicyBaggageAndNote")) {
                return 10;
            }
            if (this.u.get(i2).f24682a.equalsIgnoreCase("bundlePackage")) {
                return 11;
            }
            if (this.u.get(i2).f24682a.equals("VIEW_TYPE_REVIEW_PAYMENT_DETAILS")) {
                return 12;
            }
        }
        return 0;
    }

    class a {

        /* renamed from: a  reason: collision with root package name */
        String f24682a;

        private a() {
        }

        /* synthetic */ a(j jVar, byte b2) {
            this();
        }
    }

    public final void a(CJRFlightPromoResponse cJRFlightPromoResponse) {
        this.x = true;
        this.r = cJRFlightPromoResponse;
        this.A = null;
        notifyDataSetChanged();
    }

    public final void a(String str) {
        this.r = null;
        this.A = str;
        notifyDataSetChanged();
    }
}
