package com.travel.flight.flightticket.j;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b;
import com.paytm.utility.b.b;
import com.travel.cdn.ResourceUtils;
import com.travel.flight.R;
import com.travel.flight.flightticket.f.i;
import com.travel.flight.flightticket.f.k;
import com.travel.flight.pojo.flightticket.CJRFlightDetails;
import com.travel.flight.pojo.flightticket.CJRFlightDetailsItem;
import com.travel.flight.pojo.flightticket.CJRFlightSearchInput;
import com.travel.flight.pojo.flightticket.f;
import com.travel.utils.n;

public final class ac extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    public CJRFlightDetails f25064a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f25065b;

    /* renamed from: c  reason: collision with root package name */
    protected TextView f25066c;

    /* renamed from: d  reason: collision with root package name */
    protected TextView f25067d;

    /* renamed from: e  reason: collision with root package name */
    protected RelativeLayout f25068e;

    /* renamed from: f  reason: collision with root package name */
    protected TextView f25069f;

    /* renamed from: g  reason: collision with root package name */
    protected TextView f25070g;

    /* renamed from: h  reason: collision with root package name */
    public CJRFlightDetailsItem f25071h;

    /* renamed from: i  reason: collision with root package name */
    public String f25072i = "one_way";
    public boolean j = false;
    public String k;
    public CJRFlightSearchInput l;
    public String m;
    i n;
    private Context o;
    private int p;
    private String q;
    private k r;
    private LinearLayout s;
    private RelativeLayout t;
    private TextView u;
    private TextView v;
    private TextView w;
    private CardView x;
    private CardView y;

    public ac(Context context, View view, k kVar, i iVar) {
        super(view);
        this.o = context;
        this.f25066c = (TextView) view.findViewById(R.id.flight_name_from);
        this.f25067d = (TextView) view.findViewById(R.id.flight_name_to);
        this.f25065b = (LinearLayout) view.findViewById(R.id.lyt_journey_details);
        this.f25068e = (RelativeLayout) view.findViewById(R.id.lyt_flight_place);
        this.f25069f = (TextView) view.findViewById(R.id.txt_seller_name);
        this.f25070g = (TextView) view.findViewById(R.id.txt_refundable);
        this.p = b.g(this.o);
        com.travel.flight.b.a();
        this.q = com.travel.flight.b.b().r();
        this.r = kVar;
        this.s = (LinearLayout) view.findViewById(R.id.provider_container);
        this.t = (RelativeLayout) view.findViewById(R.id.journey_lyt);
        this.u = (TextView) view.findViewById(R.id.journey_type_txt);
        this.v = (TextView) view.findViewById(R.id.journey_type_date);
        this.x = (CardView) view.findViewById(R.id.card_lyt);
        this.y = (CardView) view.findViewById(R.id.additional_info_lyt);
        this.w = (TextView) view.findViewById(R.id.additional_info_txt);
        this.n = iVar;
        ((ImageView) view.findViewById(R.id.image_arrow)).setImageResource(com.travel.common.R.drawable.travel_res_common_back_button);
        ResourceUtils.loadFlightImagesFromCDN((ImageView) view.findViewById(R.id.iv_flight_additional_revamp), "additional_info_revamp.png", false, false, n.a.V1);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v22, resolved type: com.travel.flight.flightticket.j.ac} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v23, resolved type: com.travel.flight.flightticket.j.ac} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v33, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v64, resolved type: com.travel.flight.flightticket.j.ac} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x044d A[Catch:{ Exception -> 0x078f }] */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0462 A[Catch:{ Exception -> 0x078f }] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x048c A[Catch:{ Exception -> 0x078f }] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x049b A[Catch:{ Exception -> 0x078f }] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x04c9 A[Catch:{ Exception -> 0x078f }] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x04da A[Catch:{ Exception -> 0x078f }] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x04ed A[Catch:{ Exception -> 0x078f }] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0500 A[Catch:{ Exception -> 0x078f }] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x052d A[SYNTHETIC, Splitter:B:127:0x052d] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0559 A[Catch:{ Exception -> 0x078d }] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0565 A[Catch:{ Exception -> 0x078d }] */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x057b A[Catch:{ Exception -> 0x078d }] */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x058e A[Catch:{ Exception -> 0x078d }] */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x05b7 A[Catch:{ Exception -> 0x078d }] */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x05e5 A[Catch:{ Exception -> 0x078d }] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x05f0 A[SYNTHETIC, Splitter:B:152:0x05f0] */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x062a  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x0668 A[Catch:{ Exception -> 0x078b }] */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0699 A[Catch:{ Exception -> 0x078b }] */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x06c8 A[Catch:{ Exception -> 0x078b }] */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x071f A[Catch:{ Exception -> 0x078b }] */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x077e A[Catch:{ Exception -> 0x0787 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0174 A[SYNTHETIC, Splitter:B:44:0x0174] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0312 A[SYNTHETIC, Splitter:B:79:0x0312] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r35, boolean r36) {
        /*
            r34 = this;
            r1 = r34
            java.lang.String r2 = "note_icon.png"
            java.lang.String r0 = r1.m
            r3 = 8
            r4 = 0
            if (r0 == 0) goto L_0x001a
            if (r36 == 0) goto L_0x001a
            androidx.cardview.widget.CardView r0 = r1.y
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.w
            java.lang.String r5 = r1.m
            r0.setText(r5)
            goto L_0x001f
        L_0x001a:
            androidx.cardview.widget.CardView r0 = r1.y
            r0.setVisibility(r3)
        L_0x001f:
            android.widget.TextView r0 = r1.f25069f
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = " : "
            r5.<init>(r6)
            java.lang.String r6 = r1.k
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r0.setText(r5)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r1.f25064a
            java.lang.Boolean r0 = r0.getmIsInternational()
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x0054
            com.travel.flight.b.a()
            com.travel.flight.c r0 = com.travel.flight.b.b()
            boolean r0 = r0.z()
            if (r0 == 0) goto L_0x004e
            goto L_0x0054
        L_0x004e:
            android.widget.TextView r0 = r1.f25070g
            r0.setVisibility(r3)
            goto L_0x0075
        L_0x0054:
            boolean r0 = r35.ismIsRefundable()
            if (r0 == 0) goto L_0x0068
            android.widget.TextView r0 = r1.f25070g
            android.content.Context r5 = r1.o
            int r6 = com.travel.flight.R.string.flight_refundable
            java.lang.String r5 = r5.getString(r6)
            r0.setText(r5)
            goto L_0x0075
        L_0x0068:
            android.widget.TextView r0 = r1.f25070g
            android.content.Context r5 = r1.o
            int r6 = com.travel.flight.R.string.flight_non_refundable
            java.lang.String r5 = r5.getString(r6)
            r0.setText(r5)
        L_0x0075:
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r1.f25064a
            com.travel.flight.pojo.flightticket.CJRMetadetails r0 = r0.getmMetaDetails()
            java.lang.Boolean r0 = r0.isDisplaySoldBy()
            if (r0 != 0) goto L_0x0085
            r34.a()
            goto L_0x009e
        L_0x0085:
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r1.f25064a
            com.travel.flight.pojo.flightticket.CJRMetadetails r0 = r0.getmMetaDetails()
            java.lang.Boolean r0 = r0.isDisplaySoldBy()
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0099
            r34.a()
            goto L_0x009e
        L_0x0099:
            android.widget.LinearLayout r0 = r1.s
            r0.setVisibility(r3)
        L_0x009e:
            java.util.ArrayList r0 = r35.getmFlights()
            int r5 = r0.size()
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r1.f25064a
            if (r0 == 0) goto L_0x00d2
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = r0.getmOnwardJourney()
            if (r0 == 0) goto L_0x00d2
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r1.f25064a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = r0.getmReturnJourney()
            if (r0 == 0) goto L_0x00d2
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r1.f25064a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = r0.getmOnwardJourney()
            java.util.ArrayList r0 = r0.getmFlights()
            r0.size()
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r1.f25064a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = r0.getmReturnJourney()
            java.util.ArrayList r0 = r0.getmFlights()
            r0.size()
        L_0x00d2:
            android.widget.RelativeLayout r0 = r1.f25068e
            if (r0 == 0) goto L_0x00d9
            r0.setVisibility(r3)
        L_0x00d9:
            boolean r0 = r1.j
            r6 = 20
            r7 = 10
            if (r0 == 0) goto L_0x014c
            if (r35 == 0) goto L_0x014c
            java.util.ArrayList r0 = r35.getmFlights()
            if (r0 == 0) goto L_0x014c
            java.util.ArrayList r0 = r35.getmFlights()
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x014c
            if (r36 == 0) goto L_0x011d
            android.widget.RelativeLayout r0 = r1.t
            r0.setVisibility(r3)
            androidx.cardview.widget.CardView r0 = r1.x
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r0 = (android.view.ViewGroup.MarginLayoutParams) r0
            int r6 = com.paytm.utility.b.c((int) r3)
            int r7 = com.paytm.utility.b.c((int) r7)
            int r8 = com.paytm.utility.b.c((int) r3)
            r9 = 13
            int r9 = com.paytm.utility.b.c((int) r9)
            r0.setMargins(r6, r7, r8, r9)
            androidx.cardview.widget.CardView r0 = r1.x
            r0.requestLayout()
            goto L_0x0171
        L_0x011d:
            android.widget.RelativeLayout r0 = r1.t
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.u
            android.content.Context r7 = r1.o
            int r8 = com.travel.flight.R.string.retunr_type
            java.lang.String r7 = r7.getString(r8)
            r0.setText(r7)
            androidx.cardview.widget.CardView r0 = r1.x
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r0 = (android.view.ViewGroup.MarginLayoutParams) r0
            int r7 = com.paytm.utility.b.c((int) r3)
            int r8 = com.paytm.utility.b.c((int) r3)
            int r6 = com.paytm.utility.b.c((int) r6)
            r0.setMargins(r7, r4, r8, r6)
            androidx.cardview.widget.CardView r0 = r1.x
            r0.requestLayout()
            goto L_0x0171
        L_0x014c:
            android.widget.RelativeLayout r0 = r1.t
            r0.setVisibility(r3)
            androidx.cardview.widget.CardView r0 = r1.x
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r0 = (android.view.ViewGroup.MarginLayoutParams) r0
            int r8 = com.paytm.utility.b.c((int) r3)
            int r7 = com.paytm.utility.b.c((int) r7)
            int r9 = com.paytm.utility.b.c((int) r3)
            int r6 = com.paytm.utility.b.c((int) r6)
            r0.setMargins(r8, r7, r9, r6)
            androidx.cardview.widget.CardView r0 = r1.x
            r0.requestLayout()
        L_0x0171:
            r6 = 0
        L_0x0172:
            if (r6 >= r5) goto L_0x07cf
            java.util.ArrayList r0 = r35.getmFlights()     // Catch:{ Exception -> 0x07a9 }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ Exception -> 0x07a9 }
            com.travel.flight.pojo.flightticket.CJRFlightStops r0 = (com.travel.flight.pojo.flightticket.CJRFlightStops) r0     // Catch:{ Exception -> 0x07a9 }
            android.content.Context r7 = r1.o     // Catch:{ Exception -> 0x07a9 }
            java.lang.String r8 = "layout_inflater"
            java.lang.Object r7 = r7.getSystemService(r8)     // Catch:{ Exception -> 0x07a9 }
            android.view.LayoutInflater r7 = (android.view.LayoutInflater) r7     // Catch:{ Exception -> 0x07a9 }
            int r8 = com.travel.flight.R.layout.pre_f_lyt_flight_review_list     // Catch:{ Exception -> 0x07a9 }
            r9 = 0
            android.view.View r7 = r7.inflate(r8, r9)     // Catch:{ Exception -> 0x07a9 }
            android.widget.LinearLayout r7 = (android.widget.LinearLayout) r7     // Catch:{ Exception -> 0x07a9 }
            int r8 = com.travel.flight.R.id.flight_name_     // Catch:{ Exception -> 0x07a9 }
            android.view.View r8 = r7.findViewById(r8)     // Catch:{ Exception -> 0x07a9 }
            android.widget.TextView r8 = (android.widget.TextView) r8     // Catch:{ Exception -> 0x07a9 }
            int r10 = com.travel.flight.R.id.flight_code_     // Catch:{ Exception -> 0x07a9 }
            android.view.View r10 = r7.findViewById(r10)     // Catch:{ Exception -> 0x07a9 }
            android.widget.TextView r10 = (android.widget.TextView) r10     // Catch:{ Exception -> 0x07a9 }
            int r11 = com.travel.flight.R.id.flight_name_code     // Catch:{ Exception -> 0x07a9 }
            android.view.View r11 = r7.findViewById(r11)     // Catch:{ Exception -> 0x07a9 }
            android.widget.TextView r11 = (android.widget.TextView) r11     // Catch:{ Exception -> 0x07a9 }
            int r12 = com.travel.flight.R.id.flight_dep_time     // Catch:{ Exception -> 0x07a9 }
            android.view.View r12 = r7.findViewById(r12)     // Catch:{ Exception -> 0x07a9 }
            android.widget.TextView r12 = (android.widget.TextView) r12     // Catch:{ Exception -> 0x07a9 }
            int r13 = com.travel.flight.R.id.flight_dep_date     // Catch:{ Exception -> 0x07a9 }
            android.view.View r13 = r7.findViewById(r13)     // Catch:{ Exception -> 0x07a9 }
            android.widget.TextView r13 = (android.widget.TextView) r13     // Catch:{ Exception -> 0x07a9 }
            int r14 = com.travel.flight.R.id.flight_airpot_name     // Catch:{ Exception -> 0x07a9 }
            android.view.View r14 = r7.findViewById(r14)     // Catch:{ Exception -> 0x07a9 }
            android.widget.TextView r14 = (android.widget.TextView) r14     // Catch:{ Exception -> 0x07a9 }
            int r15 = com.travel.flight.R.id.notesRootView     // Catch:{ Exception -> 0x07a9 }
            android.view.View r15 = r7.findViewById(r15)     // Catch:{ Exception -> 0x07a9 }
            android.widget.LinearLayout r15 = (android.widget.LinearLayout) r15     // Catch:{ Exception -> 0x07a9 }
            int r9 = com.travel.flight.R.id.txt_traveller_condition     // Catch:{ Exception -> 0x07a9 }
            android.view.View r9 = r7.findViewById(r9)     // Catch:{ Exception -> 0x07a9 }
            android.widget.TextView r9 = (android.widget.TextView) r9     // Catch:{ Exception -> 0x07a9 }
            int r3 = com.travel.flight.R.id.txt_traveller_inclusions     // Catch:{ Exception -> 0x07a2 }
            android.view.View r3 = r7.findViewById(r3)     // Catch:{ Exception -> 0x07a2 }
            android.widget.TextView r3 = (android.widget.TextView) r3     // Catch:{ Exception -> 0x07a2 }
            int r4 = com.travel.flight.R.id.flight_name_code_to     // Catch:{ Exception -> 0x07a2 }
            android.view.View r4 = r7.findViewById(r4)     // Catch:{ Exception -> 0x07a2 }
            android.widget.TextView r4 = (android.widget.TextView) r4     // Catch:{ Exception -> 0x07a2 }
            r17 = r5
            int r5 = com.travel.flight.R.id.flight_time_to     // Catch:{ Exception -> 0x07a0 }
            android.view.View r5 = r7.findViewById(r5)     // Catch:{ Exception -> 0x07a0 }
            android.widget.TextView r5 = (android.widget.TextView) r5     // Catch:{ Exception -> 0x07a0 }
            r18 = r5
            int r5 = com.travel.flight.R.id.flight_dep_date_to     // Catch:{ Exception -> 0x07a0 }
            android.view.View r5 = r7.findViewById(r5)     // Catch:{ Exception -> 0x07a0 }
            android.widget.TextView r5 = (android.widget.TextView) r5     // Catch:{ Exception -> 0x07a0 }
            r19 = r5
            int r5 = com.travel.flight.R.id.flight_airpot_name_to     // Catch:{ Exception -> 0x07a0 }
            android.view.View r5 = r7.findViewById(r5)     // Catch:{ Exception -> 0x07a0 }
            android.widget.TextView r5 = (android.widget.TextView) r5     // Catch:{ Exception -> 0x07a0 }
            r20 = r5
            int r5 = com.travel.flight.R.id.text_elapsedtime     // Catch:{ Exception -> 0x07a0 }
            android.view.View r5 = r7.findViewById(r5)     // Catch:{ Exception -> 0x07a0 }
            android.widget.TextView r5 = (android.widget.TextView) r5     // Catch:{ Exception -> 0x07a0 }
            r21 = r5
            int r5 = com.travel.flight.R.id.text_layover_time     // Catch:{ Exception -> 0x07a0 }
            android.view.View r5 = r7.findViewById(r5)     // Catch:{ Exception -> 0x07a0 }
            android.widget.TextView r5 = (android.widget.TextView) r5     // Catch:{ Exception -> 0x07a0 }
            r22 = r5
            int r5 = com.travel.flight.R.id.late_night_flight_lyt     // Catch:{ Exception -> 0x07a0 }
            r7.findViewById(r5)     // Catch:{ Exception -> 0x07a0 }
            int r5 = com.travel.flight.R.id.next_day_arrival_lyt     // Catch:{ Exception -> 0x07a0 }
            r7.findViewById(r5)     // Catch:{ Exception -> 0x07a0 }
            int r5 = com.travel.flight.R.id.late_night_flight_text     // Catch:{ Exception -> 0x07a0 }
            r7.findViewById(r5)     // Catch:{ Exception -> 0x07a0 }
            int r5 = com.travel.flight.R.id.next_day_arrival_text     // Catch:{ Exception -> 0x07a0 }
            r7.findViewById(r5)     // Catch:{ Exception -> 0x07a0 }
            int r5 = com.travel.flight.R.id.flight_meal_lyt     // Catch:{ Exception -> 0x07a0 }
            android.view.View r5 = r7.findViewById(r5)     // Catch:{ Exception -> 0x07a0 }
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5     // Catch:{ Exception -> 0x07a0 }
            r23 = r5
            int r5 = com.travel.flight.R.id.meals_info_imageview     // Catch:{ Exception -> 0x07a0 }
            android.view.View r5 = r7.findViewById(r5)     // Catch:{ Exception -> 0x07a0 }
            android.widget.ImageView r5 = (android.widget.ImageView) r5     // Catch:{ Exception -> 0x07a0 }
            r24 = r5
            int r5 = com.travel.flight.R.id.meals_info_textview     // Catch:{ Exception -> 0x07a0 }
            android.view.View r5 = r7.findViewById(r5)     // Catch:{ Exception -> 0x07a0 }
            android.widget.TextView r5 = (android.widget.TextView) r5     // Catch:{ Exception -> 0x07a0 }
            if (r6 != 0) goto L_0x0290
            r25 = r5
            int r5 = com.travel.flight.R.id.layout_multi_airline_messages     // Catch:{ Exception -> 0x07a0 }
            android.view.View r5 = r7.findViewById(r5)     // Catch:{ Exception -> 0x07a0 }
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5     // Catch:{ Exception -> 0x07a0 }
            r26 = r6
            com.travel.flight.pojo.flightticket.CJRFlightDetails r6 = r1.f25064a     // Catch:{ Exception -> 0x0798 }
            if (r6 == 0) goto L_0x028b
            com.travel.flight.pojo.flightticket.CJRFlightDetails r6 = r1.f25064a     // Catch:{ Exception -> 0x0798 }
            com.travel.flight.pojo.flightticket.CJRMetadetails r6 = r6.getmMetaDetails()     // Catch:{ Exception -> 0x0798 }
            if (r6 == 0) goto L_0x028b
            com.travel.flight.pojo.flightticket.CJRFlightDetails r6 = r1.f25064a     // Catch:{ Exception -> 0x0798 }
            com.travel.flight.pojo.flightticket.CJRMetadetails r6 = r6.getmMetaDetails()     // Catch:{ Exception -> 0x0798 }
            com.travel.flight.pojo.flightticket.g r6 = r6.getMultiAirlineMessages()     // Catch:{ Exception -> 0x0798 }
            if (r6 == 0) goto L_0x028b
            if (r36 == 0) goto L_0x027c
            com.travel.flight.pojo.flightticket.CJRFlightDetails r6 = r1.f25064a     // Catch:{ Exception -> 0x0798 }
            com.travel.flight.pojo.flightticket.CJRMetadetails r6 = r6.getmMetaDetails()     // Catch:{ Exception -> 0x0798 }
            com.travel.flight.pojo.flightticket.g r6 = r6.getMultiAirlineMessages()     // Catch:{ Exception -> 0x0798 }
            com.travel.flight.pojo.flightticket.f[] r6 = r6.getOnwardLeg()     // Catch:{ Exception -> 0x0798 }
            goto L_0x028c
        L_0x027c:
            com.travel.flight.pojo.flightticket.CJRFlightDetails r6 = r1.f25064a     // Catch:{ Exception -> 0x0798 }
            com.travel.flight.pojo.flightticket.CJRMetadetails r6 = r6.getmMetaDetails()     // Catch:{ Exception -> 0x0798 }
            com.travel.flight.pojo.flightticket.g r6 = r6.getMultiAirlineMessages()     // Catch:{ Exception -> 0x0798 }
            com.travel.flight.pojo.flightticket.f[] r6 = r6.getReturnLeg()     // Catch:{ Exception -> 0x0798 }
            goto L_0x028c
        L_0x028b:
            r6 = 0
        L_0x028c:
            r1.a((com.travel.flight.pojo.flightticket.f[]) r6, (android.view.ViewGroup) r5)     // Catch:{ Exception -> 0x0798 }
            goto L_0x0294
        L_0x0290:
            r25 = r5
            r26 = r6
        L_0x0294:
            int r5 = com.travel.flight.R.id.provider_image_flight     // Catch:{ Exception -> 0x0798 }
            android.view.View r5 = r7.findViewById(r5)     // Catch:{ Exception -> 0x0798 }
            android.widget.ImageView r5 = (android.widget.ImageView) r5     // Catch:{ Exception -> 0x0798 }
            int r6 = com.travel.flight.R.id.divider_end     // Catch:{ Exception -> 0x0798 }
            android.view.View r6 = r7.findViewById(r6)     // Catch:{ Exception -> 0x0798 }
            r16 = r6
            int r6 = com.travel.flight.R.id.flight_operated_by_text     // Catch:{ Exception -> 0x0798 }
            android.view.View r6 = r7.findViewById(r6)     // Catch:{ Exception -> 0x0798 }
            android.widget.TextView r6 = (android.widget.TextView) r6     // Catch:{ Exception -> 0x0798 }
            com.travel.flight.pojo.flightticket.CJRFlightsAdditionalInfo r27 = r0.getAdditionalInfo()     // Catch:{ Exception -> 0x0798 }
            if (r27 == 0) goto L_0x02e6
            com.travel.flight.pojo.flightticket.CJRFlightsAdditionalInfo r27 = r0.getAdditionalInfo()     // Catch:{ Exception -> 0x078f }
            java.lang.String r27 = r27.getOperatingAirline()     // Catch:{ Exception -> 0x078f }
            if (r27 == 0) goto L_0x02e6
            com.travel.flight.pojo.flightticket.CJRFlightsAdditionalInfo r27 = r0.getAdditionalInfo()     // Catch:{ Exception -> 0x078f }
            java.lang.String r27 = r27.getOperatingAirline()     // Catch:{ Exception -> 0x078f }
            boolean r27 = android.text.TextUtils.isEmpty(r27)     // Catch:{ Exception -> 0x078f }
            if (r27 != 0) goto L_0x02e6
            r27 = r5
            r5 = 0
            r6.setVisibility(r5)     // Catch:{ Exception -> 0x078f }
            com.travel.flight.pojo.flightticket.CJRFlightsAdditionalInfo r5 = r0.getAdditionalInfo()     // Catch:{ Exception -> 0x078f }
            java.lang.String r5 = r5.getOperatingAirline()     // Catch:{ Exception -> 0x078f }
            r28 = r14
            java.lang.String r14 = ":"
            java.lang.String r1 = ""
            java.lang.String r1 = r5.replace(r14, r1)     // Catch:{ Exception -> 0x078f }
            r6.setText(r1)     // Catch:{ Exception -> 0x078f }
            goto L_0x02ea
        L_0x02e6:
            r27 = r5
            r28 = r14
        L_0x02ea:
            int r1 = com.travel.flight.R.id.change_airport_note_lyt     // Catch:{ Exception -> 0x078f }
            android.view.View r1 = r7.findViewById(r1)     // Catch:{ Exception -> 0x078f }
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1     // Catch:{ Exception -> 0x078f }
            int r5 = com.travel.flight.R.id.change_airport_icon     // Catch:{ Exception -> 0x078f }
            android.view.View r5 = r7.findViewById(r5)     // Catch:{ Exception -> 0x078f }
            android.widget.ImageView r5 = (android.widget.ImageView) r5     // Catch:{ Exception -> 0x078f }
            com.travel.utils.n$a r6 = com.travel.utils.n.a.V1     // Catch:{ Exception -> 0x078f }
            r14 = 0
            com.travel.cdn.ResourceUtils.loadFlightImagesFromCDN(r5, r2, r14, r14, r6)     // Catch:{ Exception -> 0x078f }
            int r5 = com.travel.flight.R.id.change_airport_note     // Catch:{ Exception -> 0x078f }
            android.view.View r5 = r7.findViewById(r5)     // Catch:{ Exception -> 0x078f }
            android.widget.TextView r5 = (android.widget.TextView) r5     // Catch:{ Exception -> 0x078f }
            com.travel.flight.pojo.flightticket.CJRFlightsAdditionalInfo r6 = r0.getAdditionalInfo()     // Catch:{ Exception -> 0x078f }
            java.lang.String r14 = "Note: "
            r29 = r13
            if (r6 == 0) goto L_0x0378
            com.travel.flight.pojo.flightticket.CJRFlightsAdditionalInfo r6 = r0.getAdditionalInfo()     // Catch:{ Exception -> 0x078f }
            java.lang.String r6 = r6.getChangeAirport()     // Catch:{ Exception -> 0x078f }
            if (r6 == 0) goto L_0x0378
            com.travel.flight.pojo.flightticket.CJRFlightsAdditionalInfo r6 = r0.getAdditionalInfo()     // Catch:{ Exception -> 0x078f }
            java.lang.String r6 = r6.getChangeAirport()     // Catch:{ Exception -> 0x078f }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x078f }
            if (r6 != 0) goto L_0x0378
            r6 = 0
            r1.setVisibility(r6)     // Catch:{ Exception -> 0x078f }
            android.text.SpannableStringBuilder r1 = new android.text.SpannableStringBuilder     // Catch:{ Exception -> 0x078f }
            r1.<init>()     // Catch:{ Exception -> 0x078f }
            android.text.SpannableString r6 = new android.text.SpannableString     // Catch:{ Exception -> 0x078f }
            r6.<init>(r14)     // Catch:{ Exception -> 0x078f }
            android.text.style.ForegroundColorSpan r13 = new android.text.style.ForegroundColorSpan     // Catch:{ Exception -> 0x078f }
            r33 = r3
            r31 = r4
            r32 = r11
            r30 = r12
            r4 = 99
            r11 = 48
            r12 = 173(0xad, float:2.42E-43)
            int r3 = android.graphics.Color.rgb(r11, r4, r12)     // Catch:{ Exception -> 0x078f }
            r13.<init>(r3)     // Catch:{ Exception -> 0x078f }
            int r3 = r6.length()     // Catch:{ Exception -> 0x078f }
            r4 = 0
            r6.setSpan(r13, r4, r3, r4)     // Catch:{ Exception -> 0x078f }
            android.text.style.StyleSpan r3 = new android.text.style.StyleSpan     // Catch:{ Exception -> 0x078f }
            r11 = 1
            r3.<init>(r11)     // Catch:{ Exception -> 0x078f }
            int r11 = r6.length()     // Catch:{ Exception -> 0x078f }
            r6.setSpan(r3, r4, r11, r4)     // Catch:{ Exception -> 0x078f }
            r1.append(r6)     // Catch:{ Exception -> 0x078f }
            com.travel.flight.pojo.flightticket.CJRFlightsAdditionalInfo r3 = r0.getAdditionalInfo()     // Catch:{ Exception -> 0x078f }
            java.lang.String r3 = r3.getChangeAirport()     // Catch:{ Exception -> 0x078f }
            r1.append(r3)     // Catch:{ Exception -> 0x078f }
            android.widget.TextView$BufferType r3 = android.widget.TextView.BufferType.SPANNABLE     // Catch:{ Exception -> 0x078f }
            r5.setText(r1, r3)     // Catch:{ Exception -> 0x078f }
            goto L_0x0380
        L_0x0378:
            r33 = r3
            r31 = r4
            r32 = r11
            r30 = r12
        L_0x0380:
            java.lang.String r1 = r0.getmAirLine()     // Catch:{ Exception -> 0x078f }
            r8.setText(r1)     // Catch:{ Exception -> 0x078f }
            int r1 = com.travel.flight.R.id.layover_note_lyt     // Catch:{ Exception -> 0x078f }
            android.view.View r1 = r7.findViewById(r1)     // Catch:{ Exception -> 0x078f }
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1     // Catch:{ Exception -> 0x078f }
            int r3 = com.travel.flight.R.id.long_layover_icon     // Catch:{ Exception -> 0x078f }
            android.view.View r3 = r7.findViewById(r3)     // Catch:{ Exception -> 0x078f }
            android.widget.ImageView r3 = (android.widget.ImageView) r3     // Catch:{ Exception -> 0x078f }
            int r4 = com.travel.flight.R.id.long_layover_text     // Catch:{ Exception -> 0x078f }
            android.view.View r4 = r7.findViewById(r4)     // Catch:{ Exception -> 0x078f }
            android.widget.TextView r4 = (android.widget.TextView) r4     // Catch:{ Exception -> 0x078f }
            com.travel.utils.n$a r5 = com.travel.utils.n.a.V1     // Catch:{ Exception -> 0x078f }
            r6 = 0
            com.travel.cdn.ResourceUtils.loadFlightImagesFromCDN(r3, r2, r6, r6, r5)     // Catch:{ Exception -> 0x078f }
            com.travel.flight.pojo.flightticket.CJRFlightsAdditionalInfo r3 = r0.getAdditionalInfo()     // Catch:{ Exception -> 0x078f }
            if (r3 == 0) goto L_0x0408
            com.travel.flight.pojo.flightticket.CJRFlightsAdditionalInfo r3 = r0.getAdditionalInfo()     // Catch:{ Exception -> 0x078f }
            java.lang.String r3 = r3.getChangeFlight()     // Catch:{ Exception -> 0x078f }
            if (r3 == 0) goto L_0x0408
            com.travel.flight.pojo.flightticket.CJRFlightsAdditionalInfo r3 = r0.getAdditionalInfo()     // Catch:{ Exception -> 0x078f }
            java.lang.String r3 = r3.getChangeFlight()     // Catch:{ Exception -> 0x078f }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x078f }
            if (r3 != 0) goto L_0x0408
            r3 = 0
            r1.setVisibility(r3)     // Catch:{ Exception -> 0x078f }
            android.text.SpannableStringBuilder r1 = new android.text.SpannableStringBuilder     // Catch:{ Exception -> 0x078f }
            r1.<init>()     // Catch:{ Exception -> 0x078f }
            android.text.SpannableString r3 = new android.text.SpannableString     // Catch:{ Exception -> 0x078f }
            r3.<init>(r14)     // Catch:{ Exception -> 0x078f }
            android.text.style.ForegroundColorSpan r5 = new android.text.style.ForegroundColorSpan     // Catch:{ Exception -> 0x078f }
            r6 = 173(0xad, float:2.42E-43)
            r8 = 99
            r11 = 48
            int r6 = android.graphics.Color.rgb(r11, r8, r6)     // Catch:{ Exception -> 0x078f }
            r5.<init>(r6)     // Catch:{ Exception -> 0x078f }
            int r6 = r3.length()     // Catch:{ Exception -> 0x078f }
            r8 = 0
            r3.setSpan(r5, r8, r6, r8)     // Catch:{ Exception -> 0x078f }
            android.text.style.StyleSpan r5 = new android.text.style.StyleSpan     // Catch:{ Exception -> 0x078f }
            r6 = 1
            r5.<init>(r6)     // Catch:{ Exception -> 0x078f }
            int r6 = r3.length()     // Catch:{ Exception -> 0x078f }
            r3.setSpan(r5, r8, r6, r8)     // Catch:{ Exception -> 0x078f }
            r1.append(r3)     // Catch:{ Exception -> 0x078f }
            com.travel.flight.pojo.flightticket.CJRFlightsAdditionalInfo r3 = r0.getAdditionalInfo()     // Catch:{ Exception -> 0x078f }
            java.lang.String r3 = r3.getChangeFlight()     // Catch:{ Exception -> 0x078f }
            r1.append(r3)     // Catch:{ Exception -> 0x078f }
            android.widget.TextView$BufferType r3 = android.widget.TextView.BufferType.SPANNABLE     // Catch:{ Exception -> 0x078f }
            r4.setText(r1, r3)     // Catch:{ Exception -> 0x078f }
        L_0x0408:
            java.lang.String r1 = r0.getmAirLineCode()     // Catch:{ Exception -> 0x078f }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x078f }
            if (r1 != 0) goto L_0x043b
            java.lang.String r1 = r0.getmFlightNumber()     // Catch:{ Exception -> 0x078f }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x078f }
            if (r1 != 0) goto L_0x043b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x078f }
            r1.<init>()     // Catch:{ Exception -> 0x078f }
            java.lang.String r3 = r0.getmAirLineCode()     // Catch:{ Exception -> 0x078f }
            r1.append(r3)     // Catch:{ Exception -> 0x078f }
            java.lang.String r3 = "-"
            r1.append(r3)     // Catch:{ Exception -> 0x078f }
            java.lang.String r3 = r0.getmFlightNumber()     // Catch:{ Exception -> 0x078f }
            r1.append(r3)     // Catch:{ Exception -> 0x078f }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x078f }
            r10.setText(r1)     // Catch:{ Exception -> 0x078f }
        L_0x043b:
            int r1 = com.travel.flight.R.id.flight_model_id     // Catch:{ Exception -> 0x078f }
            android.view.View r1 = r7.findViewById(r1)     // Catch:{ Exception -> 0x078f }
            android.widget.TextView r1 = (android.widget.TextView) r1     // Catch:{ Exception -> 0x078f }
            java.lang.String r3 = r0.getmAircraftTypeDisplayName()     // Catch:{ Exception -> 0x078f }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x078f }
            if (r3 != 0) goto L_0x0458
            r3 = 0
            r1.setVisibility(r3)     // Catch:{ Exception -> 0x078f }
            java.lang.String r3 = r0.getmAircraftTypeDisplayName()     // Catch:{ Exception -> 0x078f }
            r1.setText(r3)     // Catch:{ Exception -> 0x078f }
        L_0x0458:
            java.lang.String r1 = r0.getmNotes()     // Catch:{ Exception -> 0x078f }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x078f }
            if (r1 != 0) goto L_0x048c
            java.lang.String r1 = r0.getmNotes()     // Catch:{ Exception -> 0x078f }
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x078f }
            if (r3 != 0) goto L_0x0486
            r3 = 0
            r15.setVisibility(r3)     // Catch:{ Exception -> 0x078f }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x078f }
            java.lang.String r4 = "Important: "
            r3.<init>(r4)     // Catch:{ Exception -> 0x078f }
            java.lang.String r1 = r1.trim()     // Catch:{ Exception -> 0x078f }
            r3.append(r1)     // Catch:{ Exception -> 0x078f }
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x078f }
            r9.setText(r1)     // Catch:{ Exception -> 0x078f }
            goto L_0x0491
        L_0x0486:
            r1 = 8
            r15.setVisibility(r1)     // Catch:{ Exception -> 0x078f }
            goto L_0x0491
        L_0x048c:
            r1 = 8
            r15.setVisibility(r1)     // Catch:{ Exception -> 0x078f }
        L_0x0491:
            java.lang.String r1 = r0.getmInclusions()     // Catch:{ Exception -> 0x078f }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x078f }
            if (r1 != 0) goto L_0x04c9
            java.lang.String r1 = r0.getmInclusions()     // Catch:{ Exception -> 0x078f }
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x078f }
            if (r3 != 0) goto L_0x04c1
            r3 = r33
            r4 = 0
            r3.setVisibility(r4)     // Catch:{ Exception -> 0x078f }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x078f }
            java.lang.String r5 = "- "
            r4.<init>(r5)     // Catch:{ Exception -> 0x078f }
            java.lang.String r1 = r1.trim()     // Catch:{ Exception -> 0x078f }
            r4.append(r1)     // Catch:{ Exception -> 0x078f }
            java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x078f }
            r3.setText(r1)     // Catch:{ Exception -> 0x078f }
            goto L_0x04d0
        L_0x04c1:
            r3 = r33
            r1 = 8
            r3.setVisibility(r1)     // Catch:{ Exception -> 0x078f }
            goto L_0x04d0
        L_0x04c9:
            r3 = r33
            r1 = 8
            r3.setVisibility(r1)     // Catch:{ Exception -> 0x078f }
        L_0x04d0:
            java.lang.String r1 = r0.getOriginCity()     // Catch:{ Exception -> 0x078f }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x078f }
            if (r1 != 0) goto L_0x04e3
            java.lang.String r1 = r0.getOriginCity()     // Catch:{ Exception -> 0x078f }
            r11 = r32
            r11.setText(r1)     // Catch:{ Exception -> 0x078f }
        L_0x04e3:
            java.lang.String r1 = r0.getDestinationCity()     // Catch:{ Exception -> 0x078f }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x078f }
            if (r1 != 0) goto L_0x04f6
            java.lang.String r1 = r0.getDestinationCity()     // Catch:{ Exception -> 0x078f }
            r4 = r31
            r4.setText(r1)     // Catch:{ Exception -> 0x078f }
        L_0x04f6:
            java.lang.String r1 = r0.getmDepartureTime()     // Catch:{ Exception -> 0x078f }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x078f }
            if (r1 != 0) goto L_0x051a
            java.lang.String r1 = r0.getmDepartureTime()     // Catch:{ Exception -> 0x078f }
            java.lang.String r1 = com.travel.flight.utils.c.a((java.lang.String) r1)     // Catch:{ Exception -> 0x078f }
            r12 = r30
            r12.setText(r1)     // Catch:{ Exception -> 0x078f }
            java.lang.String r1 = r0.getmDepartureTime()     // Catch:{ Exception -> 0x078f }
            java.lang.String r1 = com.travel.flight.utils.c.c(r1)     // Catch:{ Exception -> 0x078f }
            r13 = r29
            r13.setText(r1)     // Catch:{ Exception -> 0x078f }
        L_0x051a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x078f }
            r1.<init>()     // Catch:{ Exception -> 0x078f }
            java.lang.String r3 = r0.getDepartureTerminal()     // Catch:{ Exception -> 0x078f }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x078f }
            java.lang.String r4 = ", "
            java.lang.String r5 = " "
            if (r3 != 0) goto L_0x0559
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0554 }
            r3.<init>()     // Catch:{ Exception -> 0x0554 }
            r6 = r34
            android.content.Context r8 = r6.o     // Catch:{ Exception -> 0x078d }
            int r9 = com.travel.flight.R.string.terminal_text     // Catch:{ Exception -> 0x078d }
            java.lang.String r8 = r8.getString(r9)     // Catch:{ Exception -> 0x078d }
            r3.append(r8)     // Catch:{ Exception -> 0x078d }
            r3.append(r5)     // Catch:{ Exception -> 0x078d }
            java.lang.String r8 = r0.getDepartureTerminal()     // Catch:{ Exception -> 0x078d }
            r3.append(r8)     // Catch:{ Exception -> 0x078d }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x078d }
            r1.append(r3)     // Catch:{ Exception -> 0x078d }
            r1.append(r4)     // Catch:{ Exception -> 0x078d }
            goto L_0x055b
        L_0x0554:
            r0 = move-exception
            r6 = r34
            goto L_0x079a
        L_0x0559:
            r6 = r34
        L_0x055b:
            java.lang.String r3 = r0.getOriginAirport()     // Catch:{ Exception -> 0x078d }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x078d }
            if (r3 != 0) goto L_0x056c
            java.lang.String r3 = r0.getOriginAirport()     // Catch:{ Exception -> 0x078d }
            r1.append(r3)     // Catch:{ Exception -> 0x078d }
        L_0x056c:
            r14 = r28
            r14.setText(r1)     // Catch:{ Exception -> 0x078d }
            java.lang.String r1 = r0.getmDuration()     // Catch:{ Exception -> 0x078d }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x078d }
            if (r1 != 0) goto L_0x0584
            java.lang.String r1 = r0.getmDuration()     // Catch:{ Exception -> 0x078d }
            r3 = r21
            r3.setText(r1)     // Catch:{ Exception -> 0x078d }
        L_0x0584:
            java.lang.String r1 = r0.getmArrivalTime()     // Catch:{ Exception -> 0x078d }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x078d }
            if (r1 != 0) goto L_0x05a8
            java.lang.String r1 = r0.getmArrivalTime()     // Catch:{ Exception -> 0x078d }
            java.lang.String r1 = com.travel.flight.utils.c.a((java.lang.String) r1)     // Catch:{ Exception -> 0x078d }
            r3 = r18
            r3.setText(r1)     // Catch:{ Exception -> 0x078d }
            java.lang.String r1 = r0.getmArrivalTime()     // Catch:{ Exception -> 0x078d }
            java.lang.String r1 = com.travel.flight.utils.c.c(r1)     // Catch:{ Exception -> 0x078d }
            r3 = r19
            r3.setText(r1)     // Catch:{ Exception -> 0x078d }
        L_0x05a8:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x078d }
            r1.<init>()     // Catch:{ Exception -> 0x078d }
            java.lang.String r3 = r0.getArrivalTerminal()     // Catch:{ Exception -> 0x078d }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x078d }
            if (r3 != 0) goto L_0x05db
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x078d }
            r3.<init>()     // Catch:{ Exception -> 0x078d }
            android.content.Context r8 = r6.o     // Catch:{ Exception -> 0x078d }
            int r9 = com.travel.flight.R.string.terminal_text     // Catch:{ Exception -> 0x078d }
            java.lang.String r8 = r8.getString(r9)     // Catch:{ Exception -> 0x078d }
            r3.append(r8)     // Catch:{ Exception -> 0x078d }
            r3.append(r5)     // Catch:{ Exception -> 0x078d }
            java.lang.String r8 = r0.getArrivalTerminal()     // Catch:{ Exception -> 0x078d }
            r3.append(r8)     // Catch:{ Exception -> 0x078d }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x078d }
            r1.append(r3)     // Catch:{ Exception -> 0x078d }
            r1.append(r4)     // Catch:{ Exception -> 0x078d }
        L_0x05db:
            java.lang.String r3 = r0.getDestinationAirport()     // Catch:{ Exception -> 0x078d }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x078d }
            if (r3 != 0) goto L_0x05ec
            java.lang.String r3 = r0.getDestinationAirport()     // Catch:{ Exception -> 0x078d }
            r1.append(r3)     // Catch:{ Exception -> 0x078d }
        L_0x05ec:
            java.lang.String r3 = "no_free_meal_review.png"
            if (r36 == 0) goto L_0x062a
            com.travel.flight.pojo.flightticket.CJRFlightDetails r4 = r6.f25064a     // Catch:{ Exception -> 0x078d }
            if (r4 == 0) goto L_0x0620
            com.travel.flight.pojo.flightticket.CJRFlightDetails r4 = r6.f25064a     // Catch:{ Exception -> 0x078d }
            boolean r4 = r4.getOnwardMealsAvailable()     // Catch:{ Exception -> 0x078d }
            if (r4 != 0) goto L_0x0620
            int r4 = r17 + -1
            r8 = r26
            if (r8 != r4) goto L_0x061d
            r4 = r23
            r9 = 0
            r4.setVisibility(r9)     // Catch:{ Exception -> 0x078b }
            com.travel.utils.n$a r4 = com.travel.utils.n.a.V1     // Catch:{ Exception -> 0x078b }
            r10 = r24
            com.travel.cdn.ResourceUtils.loadFlightImagesFromCDN(r10, r3, r9, r9, r4)     // Catch:{ Exception -> 0x078b }
            android.content.Context r3 = r6.o     // Catch:{ Exception -> 0x078b }
            int r4 = com.travel.flight.R.string.flight_no_free_meal     // Catch:{ Exception -> 0x078b }
            java.lang.String r3 = r3.getString(r4)     // Catch:{ Exception -> 0x078b }
            r9 = r25
            r9.setText(r3)     // Catch:{ Exception -> 0x078b }
            goto L_0x065c
        L_0x061d:
            r4 = r23
            goto L_0x0624
        L_0x0620:
            r4 = r23
            r8 = r26
        L_0x0624:
            r3 = 8
            r4.setVisibility(r3)     // Catch:{ Exception -> 0x0789 }
            goto L_0x065c
        L_0x062a:
            r4 = r23
            r10 = r24
            r9 = r25
            r8 = r26
            com.travel.flight.pojo.flightticket.CJRFlightDetails r11 = r6.f25064a     // Catch:{ Exception -> 0x078b }
            if (r11 == 0) goto L_0x0657
            com.travel.flight.pojo.flightticket.CJRFlightDetails r11 = r6.f25064a     // Catch:{ Exception -> 0x078b }
            boolean r11 = r11.getReturnMealsAvailable()     // Catch:{ Exception -> 0x078b }
            if (r11 != 0) goto L_0x0657
            int r11 = r17 + -1
            if (r8 != r11) goto L_0x0657
            r11 = 0
            r4.setVisibility(r11)     // Catch:{ Exception -> 0x078b }
            com.travel.utils.n$a r4 = com.travel.utils.n.a.V1     // Catch:{ Exception -> 0x078b }
            com.travel.cdn.ResourceUtils.loadFlightImagesFromCDN(r10, r3, r11, r11, r4)     // Catch:{ Exception -> 0x078b }
            android.content.Context r3 = r6.o     // Catch:{ Exception -> 0x078b }
            int r4 = com.travel.flight.R.string.flight_no_free_meal     // Catch:{ Exception -> 0x078b }
            java.lang.String r3 = r3.getString(r4)     // Catch:{ Exception -> 0x078b }
            r9.setText(r3)     // Catch:{ Exception -> 0x078b }
            goto L_0x065c
        L_0x0657:
            r3 = 8
            r4.setVisibility(r3)     // Catch:{ Exception -> 0x0789 }
        L_0x065c:
            r3 = r20
            r3.setText(r1)     // Catch:{ Exception -> 0x078b }
            android.widget.LinearLayout r1 = r6.f25065b     // Catch:{ Exception -> 0x078b }
            r1.addView(r7)     // Catch:{ Exception -> 0x078b }
            if (r8 != 0) goto L_0x068d
            java.lang.String r1 = r0.getOriginCity()     // Catch:{ Exception -> 0x078b }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x078b }
            if (r1 != 0) goto L_0x0680
            android.widget.TextView r1 = r6.f25066c     // Catch:{ Exception -> 0x078b }
            java.lang.String r3 = r0.getOriginCity()     // Catch:{ Exception -> 0x078b }
            java.lang.String r3 = com.travel.flight.utils.c.f(r3)     // Catch:{ Exception -> 0x078b }
            r1.setText(r3)     // Catch:{ Exception -> 0x078b }
            goto L_0x068d
        L_0x0680:
            android.widget.TextView r1 = r6.f25066c     // Catch:{ Exception -> 0x078b }
            java.lang.String r3 = r0.getmOrigin()     // Catch:{ Exception -> 0x078b }
            java.lang.String r3 = com.travel.flight.utils.c.f(r3)     // Catch:{ Exception -> 0x078b }
            r1.setText(r3)     // Catch:{ Exception -> 0x078b }
        L_0x068d:
            java.util.ArrayList r1 = r35.getmFlights()     // Catch:{ Exception -> 0x078b }
            int r1 = r1.size()     // Catch:{ Exception -> 0x078b }
            r3 = 1
            int r1 = r1 - r3
            if (r8 != r1) goto L_0x06be
            java.lang.String r1 = r0.getDestinationCity()     // Catch:{ Exception -> 0x078b }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x078b }
            if (r1 != 0) goto L_0x06b1
            android.widget.TextView r1 = r6.f25067d     // Catch:{ Exception -> 0x078b }
            java.lang.String r3 = r0.getDestinationCity()     // Catch:{ Exception -> 0x078b }
            java.lang.String r3 = com.travel.flight.utils.c.f(r3)     // Catch:{ Exception -> 0x078b }
            r1.setText(r3)     // Catch:{ Exception -> 0x078b }
            goto L_0x06be
        L_0x06b1:
            android.widget.TextView r1 = r6.f25067d     // Catch:{ Exception -> 0x078b }
            java.lang.String r3 = r0.getmDestination()     // Catch:{ Exception -> 0x078b }
            java.lang.String r3 = com.travel.flight.utils.c.f(r3)     // Catch:{ Exception -> 0x078b }
            r1.setText(r3)     // Catch:{ Exception -> 0x078b }
        L_0x06be:
            java.util.ArrayList r1 = r35.getmFlights()     // Catch:{ Exception -> 0x078b }
            java.lang.Object r1 = r1.get(r8)     // Catch:{ Exception -> 0x078b }
            if (r1 == 0) goto L_0x0709
            java.util.ArrayList r1 = r35.getmFlights()     // Catch:{ Exception -> 0x078b }
            java.lang.Object r1 = r1.get(r8)     // Catch:{ Exception -> 0x078b }
            com.travel.flight.pojo.flightticket.CJRFlightStops r1 = (com.travel.flight.pojo.flightticket.CJRFlightStops) r1     // Catch:{ Exception -> 0x078b }
            java.lang.String r3 = r1.getmAirLineCode()     // Catch:{ Exception -> 0x078b }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x078b }
            if (r3 != 0) goto L_0x0709
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x078b }
            r3.<init>()     // Catch:{ Exception -> 0x078b }
            java.lang.String r4 = r6.q     // Catch:{ Exception -> 0x078b }
            r3.append(r4)     // Catch:{ Exception -> 0x078b }
            java.lang.String r1 = r1.getmAirLineCode()     // Catch:{ Exception -> 0x078b }
            r3.append(r1)     // Catch:{ Exception -> 0x078b }
            java.lang.String r1 = ".png"
            r3.append(r1)     // Catch:{ Exception -> 0x078b }
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x078b }
            boolean r3 = android.webkit.URLUtil.isValidUrl(r1)     // Catch:{ Exception -> 0x078b }
            if (r3 == 0) goto L_0x0709
            android.content.Context r3 = r6.o     // Catch:{ Exception -> 0x078b }
            com.paytm.utility.b.b$a$a r3 = com.paytm.utility.b.b.a(r3)     // Catch:{ Exception -> 0x078b }
            r3.f43753a = r1     // Catch:{ Exception -> 0x078b }
            r1 = r27
            r3.a((android.widget.ImageView) r1)     // Catch:{ Exception -> 0x078b }
        L_0x0709:
            java.util.ArrayList r1 = r35.getmFlights()     // Catch:{ Exception -> 0x078b }
            int r1 = r1.size()     // Catch:{ Exception -> 0x078b }
            r3 = 1
            if (r1 <= r3) goto L_0x077e
            java.util.ArrayList r1 = r35.getmFlights()     // Catch:{ Exception -> 0x078b }
            int r1 = r1.size()     // Catch:{ Exception -> 0x078b }
            int r1 = r1 - r3
            if (r8 >= r1) goto L_0x077e
            java.util.ArrayList r1 = r35.getmFlights()     // Catch:{ Exception -> 0x078b }
            int r3 = r8 + 1
            java.lang.Object r1 = r1.get(r3)     // Catch:{ Exception -> 0x078b }
            com.travel.flight.pojo.flightticket.CJRFlightStops r1 = (com.travel.flight.pojo.flightticket.CJRFlightStops) r1     // Catch:{ Exception -> 0x078b }
            java.lang.String r1 = r1.getmLayover()     // Catch:{ Exception -> 0x078b }
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x078b }
            if (r3 != 0) goto L_0x077a
            android.text.SpannableStringBuilder r3 = new android.text.SpannableStringBuilder     // Catch:{ Exception -> 0x078b }
            r3.<init>()     // Catch:{ Exception -> 0x078b }
            android.text.SpannableString r4 = new android.text.SpannableString     // Catch:{ Exception -> 0x078b }
            r4.<init>(r1)     // Catch:{ Exception -> 0x078b }
            r3.append(r4)     // Catch:{ Exception -> 0x078b }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x078b }
            r1.<init>(r5)     // Catch:{ Exception -> 0x078b }
            android.content.Context r4 = r6.o     // Catch:{ Exception -> 0x078b }
            int r7 = com.travel.flight.R.string.layover_text     // Catch:{ Exception -> 0x078b }
            java.lang.String r4 = r4.getString(r7)     // Catch:{ Exception -> 0x078b }
            r1.append(r4)     // Catch:{ Exception -> 0x078b }
            r1.append(r5)     // Catch:{ Exception -> 0x078b }
            java.lang.String r0 = r0.getDestinationCity()     // Catch:{ Exception -> 0x078b }
            r1.append(r0)     // Catch:{ Exception -> 0x078b }
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x078b }
            r3.append(r0)     // Catch:{ Exception -> 0x078b }
            android.widget.TextView$BufferType r0 = android.widget.TextView.BufferType.SPANNABLE     // Catch:{ Exception -> 0x078b }
            r5 = r22
            r5.setText(r3, r0)     // Catch:{ Exception -> 0x078b }
            r1 = 0
            r5.setVisibility(r1)     // Catch:{ Exception -> 0x0778 }
            if (r16 == 0) goto L_0x077b
            r0 = r16
            r3 = 8
            r0.setVisibility(r3)     // Catch:{ Exception -> 0x0787 }
            goto L_0x077b
        L_0x0778:
            r0 = move-exception
            goto L_0x079d
        L_0x077a:
            r1 = 0
        L_0x077b:
            r3 = 8
            goto L_0x07c6
        L_0x077e:
            r5 = r22
            r1 = 0
            r3 = 8
            r5.setVisibility(r3)     // Catch:{ Exception -> 0x0787 }
            goto L_0x07c6
        L_0x0787:
            r0 = move-exception
            goto L_0x07af
        L_0x0789:
            r0 = move-exception
            goto L_0x07ae
        L_0x078b:
            r0 = move-exception
            goto L_0x079c
        L_0x078d:
            r0 = move-exception
            goto L_0x079a
        L_0x078f:
            r0 = move-exception
            r1 = 0
            r3 = 8
            r6 = r34
            r8 = r26
            goto L_0x07af
        L_0x0798:
            r0 = move-exception
            r6 = r1
        L_0x079a:
            r8 = r26
        L_0x079c:
            r1 = 0
        L_0x079d:
            r3 = 8
            goto L_0x07af
        L_0x07a0:
            r0 = move-exception
            goto L_0x07a5
        L_0x07a2:
            r0 = move-exception
            r17 = r5
        L_0x07a5:
            r8 = r6
            r3 = 8
            goto L_0x07ad
        L_0x07a9:
            r0 = move-exception
            r17 = r5
            r8 = r6
        L_0x07ad:
            r6 = r1
        L_0x07ae:
            r1 = 0
        L_0x07af:
            java.io.PrintStream r4 = java.lang.System.out
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r7 = "error "
            r5.<init>(r7)
            java.lang.String r0 = r0.getMessage()
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            r4.println(r0)
        L_0x07c6:
            int r0 = r8 + 1
            r1 = r6
            r5 = r17
            r4 = 0
            r6 = r0
            goto L_0x0172
        L_0x07cf:
            r6 = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightticket.j.ac.a(com.travel.flight.pojo.flightticket.CJRFlightDetailsItem, boolean):void");
    }

    private void a(f[] fVarArr, ViewGroup viewGroup) {
        boolean z;
        viewGroup.removeAllViews();
        if (fVarArr != null && fVarArr.length > 0) {
            LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
            for (final f fVar : fVarArr) {
                if (!TextUtils.isEmpty(fVar.getImg()) && !TextUtils.isEmpty(fVar.getText()) && (fVar.getLink() == null || !fVar.getLink().booleanValue() || (!TextUtils.isEmpty(fVar.getLinkText()) && fVar.getDistance() != null))) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    View inflate = from.inflate(R.layout.pre_f_lyt_flight_multi_airline_message, viewGroup, false);
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.img_view_multi_airline_msg_logo);
                    b.a.C0750a a2 = com.paytm.utility.b.b.a(imageView.getContext());
                    a2.f43753a = fVar.getImg();
                    b.a.C0750a.a(a2.a((Object) Integer.valueOf(R.color.gray)).b(Integer.valueOf(R.color.gray)), imageView, (com.paytm.utility.b.b.b) null, 2);
                    final TextView textView = (TextView) inflate.findViewById(R.id.text_view_message);
                    if (fVar.getLink() == null || !fVar.getLink().booleanValue()) {
                        textView.setText(fVar.getText());
                    } else {
                        SpannableString spannableString = new SpannableString(fVar.getText() + " " + fVar.getLinkText());
                        spannableString.setSpan(new ClickableSpan() {
                            public final void onClick(View view) {
                                ac.this.n.showAdditionalInfo(fVar);
                            }

                            public final void updateDrawState(TextPaint textPaint) {
                                textPaint.setColor(androidx.core.content.b.c(textView.getContext(), R.color.color_00b9f5));
                                textPaint.setUnderlineText(false);
                            }
                        }, fVar.getText().length() + 1, fVar.getText().length() + fVar.getLinkText().length() + 1, 17);
                        textView.setMovementMethod(LinkMovementMethod.getInstance());
                        textView.setText(spannableString);
                    }
                    viewGroup.addView(inflate);
                }
            }
        }
    }

    private void a() {
        this.s.setVisibility(0);
    }
}
