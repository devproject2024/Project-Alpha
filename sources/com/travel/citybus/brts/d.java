package com.travel.citybus.brts;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.travel.citybus.R;
import kotlin.g.b.k;

public final class d extends RecyclerView.v {
    final TextView A;
    final ImageView B;
    final ImageView C;
    final TextView D;
    final CardView E;
    final CardView F;
    private final LinearLayout G;

    /* renamed from: a  reason: collision with root package name */
    final RoboTextView f23361a;

    /* renamed from: b  reason: collision with root package name */
    final ImageView f23362b;

    /* renamed from: c  reason: collision with root package name */
    final RoboTextView f23363c;

    /* renamed from: d  reason: collision with root package name */
    final RoboTextView f23364d;

    /* renamed from: e  reason: collision with root package name */
    final RoboTextView f23365e;

    /* renamed from: f  reason: collision with root package name */
    final LinearLayout f23366f;

    /* renamed from: g  reason: collision with root package name */
    final TextView f23367g;

    /* renamed from: h  reason: collision with root package name */
    final ImageView f23368h;

    /* renamed from: i  reason: collision with root package name */
    final ImageView f23369i;
    final TextView j;
    final LinearLayout k;
    final TextView l;
    final ImageView m;
    final ImageView n;
    final TextView o;
    final LinearLayout p;
    final TextView q;
    final ImageView r;
    final ImageView s;
    final TextView t;
    final LinearLayout u;
    final TextView v;
    final ImageView w;
    final ImageView x;
    final TextView y;
    final LinearLayout z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(View view) {
        super(view);
        k.c(view, "itemView");
        View findViewById = view.findViewById(R.id.bus_name_textview);
        k.a((Object) findViewById, "itemView.findViewById(R.id.bus_name_textview)");
        this.f23361a = (RoboTextView) findViewById;
        View findViewById2 = view.findViewById(R.id.bus_logo);
        k.a((Object) findViewById2, "itemView.findViewById(R.id.bus_logo)");
        this.f23362b = (ImageView) findViewById2;
        View findViewById3 = view.findViewById(R.id.bus_desc_textview);
        k.a((Object) findViewById3, "itemView.findViewById(R.id.bus_desc_textview)");
        this.f23363c = (RoboTextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.price_textview);
        k.a((Object) findViewById4, "itemView.findViewById(R.id.price_textview)");
        this.f23364d = (RoboTextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.stops_count_textview);
        k.a((Object) findViewById5, "itemView.findViewById(R.id.stops_count_textview)");
        this.f23365e = (RoboTextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.price_calculation_view);
        k.a((Object) findViewById6, "itemView.findViewById(R.id.price_calculation_view)");
        this.G = (LinearLayout) findViewById6;
        View findViewById7 = view.findViewById(R.id.adult_view);
        k.a((Object) findViewById7, "itemView.findViewById(R.id.adult_view)");
        this.f23366f = (LinearLayout) findViewById7;
        View findViewById8 = view.findViewById(R.id.adult_price);
        k.a((Object) findViewById8, "itemView.findViewById(R.id.adult_price)");
        this.f23367g = (TextView) findViewById8;
        View findViewById9 = view.findViewById(R.id.adult_minus);
        k.a((Object) findViewById9, "itemView.findViewById(R.id.adult_minus)");
        this.f23368h = (ImageView) findViewById9;
        View findViewById10 = view.findViewById(R.id.adult_plus);
        k.a((Object) findViewById10, "itemView.findViewById(R.id.adult_plus)");
        this.f23369i = (ImageView) findViewById10;
        View findViewById11 = view.findViewById(R.id.adult_no);
        k.a((Object) findViewById11, "itemView.findViewById(R.id.adult_no)");
        this.j = (TextView) findViewById11;
        View findViewById12 = view.findViewById(R.id.student_view);
        k.a((Object) findViewById12, "itemView.findViewById(R.id.student_view)");
        this.k = (LinearLayout) findViewById12;
        View findViewById13 = view.findViewById(R.id.student_price);
        k.a((Object) findViewById13, "itemView.findViewById(R.id.student_price)");
        this.l = (TextView) findViewById13;
        View findViewById14 = view.findViewById(R.id.student_minus);
        k.a((Object) findViewById14, "itemView.findViewById(R.id.student_minus)");
        this.m = (ImageView) findViewById14;
        View findViewById15 = view.findViewById(R.id.student_plus);
        k.a((Object) findViewById15, "itemView.findViewById(R.id.student_plus)");
        this.n = (ImageView) findViewById15;
        View findViewById16 = view.findViewById(R.id.student_no);
        k.a((Object) findViewById16, "itemView.findViewById(R.id.student_no)");
        this.o = (TextView) findViewById16;
        View findViewById17 = view.findViewById(R.id.senior_citizen_view);
        k.a((Object) findViewById17, "itemView.findViewById(R.id.senior_citizen_view)");
        this.p = (LinearLayout) findViewById17;
        View findViewById18 = view.findViewById(R.id.senior_citizen_price);
        k.a((Object) findViewById18, "itemView.findViewById(R.id.senior_citizen_price)");
        this.q = (TextView) findViewById18;
        View findViewById19 = view.findViewById(R.id.sc_minus);
        k.a((Object) findViewById19, "itemView.findViewById(R.id.sc_minus)");
        this.r = (ImageView) findViewById19;
        View findViewById20 = view.findViewById(R.id.sc_plus);
        k.a((Object) findViewById20, "itemView.findViewById(R.id.sc_plus)");
        this.s = (ImageView) findViewById20;
        View findViewById21 = view.findViewById(R.id.sc_no);
        k.a((Object) findViewById21, "itemView.findViewById(R.id.sc_no)");
        this.t = (TextView) findViewById21;
        View findViewById22 = view.findViewById(R.id.child_view);
        k.a((Object) findViewById22, "itemView.findViewById(R.id.child_view)");
        this.u = (LinearLayout) findViewById22;
        View findViewById23 = view.findViewById(R.id.child_price);
        k.a((Object) findViewById23, "itemView.findViewById(R.id.child_price)");
        this.v = (TextView) findViewById23;
        View findViewById24 = view.findViewById(R.id.child_minus);
        k.a((Object) findViewById24, "itemView.findViewById(R.id.child_minus)");
        this.w = (ImageView) findViewById24;
        View findViewById25 = view.findViewById(R.id.child_plus);
        k.a((Object) findViewById25, "itemView.findViewById(R.id.child_plus)");
        this.x = (ImageView) findViewById25;
        View findViewById26 = view.findViewById(R.id.child_no);
        k.a((Object) findViewById26, "itemView.findViewById(R.id.child_no)");
        this.y = (TextView) findViewById26;
        View findViewById27 = view.findViewById(R.id.differently_abled_view);
        k.a((Object) findViewById27, "itemView.findViewById(R.id.differently_abled_view)");
        this.z = (LinearLayout) findViewById27;
        View findViewById28 = view.findViewById(R.id.differently_abled_price);
        k.a((Object) findViewById28, "itemView.findViewById(R.….differently_abled_price)");
        this.A = (TextView) findViewById28;
        View findViewById29 = view.findViewById(R.id.differently_abled_minus);
        k.a((Object) findViewById29, "itemView.findViewById(R.….differently_abled_minus)");
        this.B = (ImageView) findViewById29;
        View findViewById30 = view.findViewById(R.id.differently_abled_plus);
        k.a((Object) findViewById30, "itemView.findViewById(R.id.differently_abled_plus)");
        this.C = (ImageView) findViewById30;
        View findViewById31 = view.findViewById(R.id.differently_abled_no);
        k.a((Object) findViewById31, "itemView.findViewById(R.id.differently_abled_no)");
        this.D = (TextView) findViewById31;
        View findViewById32 = view.findViewById(R.id.cvParent);
        k.a((Object) findViewById32, "itemView.findViewById(R.id.cvParent)");
        this.E = (CardView) findViewById32;
        View findViewById33 = view.findViewById(R.id.priceCardView);
        k.a((Object) findViewById33, "itemView.findViewById(R.id.priceCardView)");
        this.F = (CardView) findViewById33;
    }
}
