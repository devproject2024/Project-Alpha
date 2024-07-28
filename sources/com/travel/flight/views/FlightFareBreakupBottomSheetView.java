package com.travel.flight.views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.travel.cdn.ResourceUtils;
import com.travel.flight.R;
import com.travel.flight.flightticket.e.h;
import com.travel.flight.flightticket.f.k;
import com.travel.flight.flightticket.g.c;
import com.travel.flight.flightticket.i.b;
import com.travel.flight.pojo.flightticket.CJRConvenienceFee;
import com.travel.flight.pojo.flightticket.CJRFlightDetails;
import com.travel.flight.pojo.flightticket.CJRFlightPromoResponse;
import com.travel.flight.pojo.flightticket.FareRules.CJRFareRulesResponse;
import com.travel.flight.pojo.model.CJRTravellerSeatTransition;
import com.travel.utils.n;

public class FlightFareBreakupBottomSheetView extends LinearLayout implements k, b {

    /* renamed from: a  reason: collision with root package name */
    LinearLayout f25606a;

    /* renamed from: b  reason: collision with root package name */
    BottomSheetBehavior f25607b;

    /* renamed from: c  reason: collision with root package name */
    a f25608c;

    /* renamed from: d  reason: collision with root package name */
    com.travel.flight.flightticket.a.k f25609d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f25610e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f25611f;

    /* renamed from: g  reason: collision with root package name */
    private RecyclerView f25612g;

    /* renamed from: h  reason: collision with root package name */
    private com.travel.flight.flightticket.c.b f25613h = null;

    /* renamed from: i  reason: collision with root package name */
    private com.travel.flight.flightticket.c.a f25614i;
    private ScrollView j;
    private c k;
    private boolean l;
    private CJRTravellerSeatTransition m;
    private ImageView n;
    private String o;
    private Context p;
    private k q;
    private View r;
    private boolean s = true;
    private CJRFlightDetails t;

    public interface a {
    }

    public final void a() {
    }

    public void openPromoScreen() {
    }

    public void setCancellationData(CJRFareRulesResponse cJRFareRulesResponse, String str, CJRFlightDetails cJRFlightDetails) {
    }

    public void setFlightBaggageData(CJRFareRulesResponse cJRFareRulesResponse, String str, CJRFlightDetails cJRFlightDetails) {
    }

    public void setRescheduleData(CJRFareRulesResponse cJRFareRulesResponse, String str, CJRFlightDetails cJRFlightDetails) {
    }

    public void updateJourneyTypeForPrices(String str) {
    }

    public FlightFareBreakupBottomSheetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        addView(((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.fare_breakup_bottom_sheet_view, (ViewGroup) null));
        this.k = new c(getContext(), this);
        this.j = (ScrollView) findViewById(R.id.scrollview_container);
        this.f25611f = (ImageView) findViewById(R.id.expanded_imageview);
        this.f25610e = (TextView) findViewById(R.id.expanded_title_textview);
        this.f25612g = (RecyclerView) findViewById(R.id.recycler_view_fare_rules);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.f25612g.setLayoutManager(linearLayoutManager);
        String hVar = h.FareBreakUp.toString();
        this.o = hVar == null ? "FareBreakUp" : hVar;
        ResourceUtils.loadFlightImagesFromCDN(this.f25611f, "rupee_icon.png", false, true, n.a.V1);
    }

    public void setupBehavior() {
        this.f25606a = (LinearLayout) findViewById(R.id.bottom_sheet);
        this.r = findViewById(R.id.bottom_sheet_background);
        this.f25607b = BottomSheetBehavior.from(this.f25606a);
        this.r.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FlightFareBreakupBottomSheetView.this.f25607b.setState(4);
            }
        });
        this.n = (ImageView) findViewById(R.id.cancel_action);
        this.n.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FlightFareBreakupBottomSheetView.this.f25607b.setState(4);
            }
        });
        this.f25607b.setBottomSheetCallback(new BottomSheetBehavior.a() {
            public final void onSlide(View view, float f2) {
            }

            public final void onStateChanged(View view, int i2) {
            }
        });
    }

    public void setFlightDetails(CJRFlightDetails cJRFlightDetails) {
        this.t = cJRFlightDetails;
    }

    public void setSeatSelectionData(CJRTravellerSeatTransition cJRTravellerSeatTransition) {
        this.m = cJRTravellerSeatTransition;
    }

    public void setContext(Context context) {
        this.p = context;
    }

    public void setReviewIternaryActionListener(k kVar) {
        this.q = kVar;
    }

    public void setIsFromTravellerDetails(boolean z) {
        this.s = z;
    }

    public void setFlightFareBreakupData(CJRFareRulesResponse cJRFareRulesResponse, String str, CJRFlightDetails cJRFlightDetails, CJRFlightPromoResponse cJRFlightPromoResponse, boolean z) {
        this.f25610e.setText("Fare Breakup");
        ResourceUtils.loadFlightImagesFromCDN(this.f25611f, "rupee_icon.png", false, true, n.a.V1);
        this.f25609d = new com.travel.flight.flightticket.a.k((Activity) this.p, cJRFlightDetails, cJRFlightPromoResponse, this, z, this.l, this.m);
        this.f25612g.setAdapter(this.f25609d);
    }

    public final void b() {
        com.travel.flight.flightticket.a.k kVar = this.f25609d;
        if (kVar != null) {
            kVar.notifyDataSetChanged();
        }
    }

    public final void c() {
        BottomSheetBehavior bottomSheetBehavior = this.f25607b;
        if (bottomSheetBehavior == null) {
            return;
        }
        if (bottomSheetBehavior.getState() != 3) {
            this.f25607b.setState(3);
        } else {
            this.f25607b.setState(4);
        }
    }

    public void setBreakupBottomSheetEventListener(a aVar) {
        this.f25608c = aVar;
    }

    public void setData(CJRFareRulesResponse cJRFareRulesResponse, CJRFlightDetails cJRFlightDetails, CJRFlightPromoResponse cJRFlightPromoResponse, boolean z) {
        c cVar = this.k;
        cVar.f25014a.setFlightFareBreakupData(cJRFareRulesResponse, this.o, cJRFlightDetails, cJRFlightPromoResponse, z);
    }

    /* renamed from: com.travel.flight.views.FlightFareBreakupBottomSheetView$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f25618a = new int[com.travel.flight.flightticket.d.c.values().length];

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
                f25618a = r0
                int[] r0 = f25618a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.travel.flight.flightticket.d.c r1 = com.travel.flight.flightticket.d.c.CONVENIENCE_FEE_DETAILS     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f25618a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.travel.flight.flightticket.d.c r1 = com.travel.flight.flightticket.d.c.CONVENIENCE_FEE_DETAILS_CLOSE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f25618a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.travel.flight.flightticket.d.c r1 = com.travel.flight.flightticket.d.c.ANCILLARY_DETAILS     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f25618a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.travel.flight.flightticket.d.c r1 = com.travel.flight.flightticket.d.c.ANCILLARY_DETAILS_CLOSE     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.views.FlightFareBreakupBottomSheetView.AnonymousClass4.<clinit>():void");
        }
    }

    public void reviewIternaryActionClick(String str, Intent intent, Boolean bool, com.travel.flight.flightticket.d.c cVar) {
        com.travel.flight.flightticket.c.a aVar;
        if (cVar != null) {
            int i2 = AnonymousClass4.f25618a[cVar.ordinal()];
            if (i2 == 1) {
                com.travel.flight.flightticket.c.b bVar = this.f25613h;
                if (bVar == null) {
                    e();
                } else if (!bVar.isShowing()) {
                    e();
                }
            } else if (i2 == 2) {
                com.travel.flight.flightticket.c.b bVar2 = this.f25613h;
                if (bVar2 != null) {
                    bVar2.dismiss();
                }
            } else if (i2 == 3) {
                com.travel.flight.flightticket.c.a aVar2 = this.f25614i;
                if (aVar2 == null) {
                    f();
                } else if (!aVar2.isShowing()) {
                    f();
                }
            } else if (i2 == 4 && (aVar = this.f25614i) != null) {
                aVar.dismiss();
            }
        }
    }

    private void e() {
        CJRConvenienceFee cJRConvenienceFee;
        CJRFlightDetails cJRFlightDetails = this.t;
        if (cJRFlightDetails != null && (cJRConvenienceFee = cJRFlightDetails.getmConvenienceFee()) != null) {
            this.f25613h = new com.travel.flight.flightticket.c.b(this.p, this, cJRConvenienceFee);
            this.f25613h.show();
        }
    }

    private void f() {
        CJRFlightDetails cJRFlightDetails = this.t;
        if (cJRFlightDetails != null && cJRFlightDetails.getmConvenienceFee() != null) {
            this.f25614i = new com.travel.flight.flightticket.c.a(this.p, this);
            this.f25614i.show();
        }
    }

    public int getBottomSheetState() {
        BottomSheetBehavior bottomSheetBehavior = this.f25607b;
        if (bottomSheetBehavior != null) {
            return bottomSheetBehavior.getState();
        }
        return 4;
    }

    public final boolean d() {
        return getBottomSheetState() == 3;
    }
}
