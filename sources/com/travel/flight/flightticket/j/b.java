package com.travel.flight.flightticket.j;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.flight.R;
import com.travel.flight.flightticket.a.p;
import kotlin.g.b.k;

public final class b extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    public ConstraintLayout f25112a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f25113b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f25114c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f25115d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f25116e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f25117f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f25118g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f25119h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f25120i;
    public LinearLayout j;
    public TextView k;
    public TextView l;
    public TextView m;
    private Context n = this.r;
    private TextView o;
    private RelativeLayout p;
    private View q;
    private Context r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(View view, Context context, final p pVar) {
        super(view);
        k.c(view, "view");
        k.c(context, "context");
        k.c(pVar, "ijrfrBundlePackageAdapter");
        this.q = view;
        this.r = context;
        View findViewById = this.q.findViewById(R.id.parent_lyt);
        k.a((Object) findViewById, "view.findViewById(R.id.parent_lyt)");
        this.f25112a = (ConstraintLayout) findViewById;
        View findViewById2 = this.q.findViewById(R.id.radio_button_image);
        k.a((Object) findViewById2, "view.findViewById(R.id.radio_button_image)");
        this.f25113b = (ImageView) findViewById2;
        View findViewById3 = this.q.findViewById(R.id.title);
        k.a((Object) findViewById3, "view.findViewById(R.id.title)");
        this.f25114c = (TextView) findViewById3;
        View findViewById4 = this.q.findViewById(R.id.title_2);
        k.a((Object) findViewById4, "view.findViewById(R.id.title_2)");
        this.f25115d = (TextView) findViewById4;
        View findViewById5 = this.q.findViewById(R.id.title_3);
        k.a((Object) findViewById5, "view.findViewById(R.id.title_3)");
        this.o = (TextView) findViewById5;
        View findViewById6 = this.q.findViewById(R.id.package_image);
        k.a((Object) findViewById6, "view.findViewById(R.id.package_image)");
        this.f25116e = (ImageView) findViewById6;
        View findViewById7 = this.q.findViewById(R.id.point_txt_1);
        k.a((Object) findViewById7, "view.findViewById(R.id.point_txt_1)");
        this.f25117f = (TextView) findViewById7;
        View findViewById8 = this.q.findViewById(R.id.point_txt_2);
        k.a((Object) findViewById8, "view.findViewById(R.id.point_txt_2)");
        this.f25118g = (TextView) findViewById8;
        View findViewById9 = this.q.findViewById(R.id.points_lyt);
        k.a((Object) findViewById9, "view.findViewById(R.id.points_lyt)");
        this.f25119h = (LinearLayout) findViewById9;
        View findViewById10 = this.q.findViewById(R.id.point_lyt_1);
        k.a((Object) findViewById10, "view.findViewById(R.id.point_lyt_1)");
        this.f25120i = (LinearLayout) findViewById10;
        View findViewById11 = this.q.findViewById(R.id.point_lyt_2);
        k.a((Object) findViewById11, "view.findViewById(R.id.point_lyt_2)");
        this.j = (LinearLayout) findViewById11;
        View findViewById12 = this.q.findViewById(R.id.save_lyt);
        k.a((Object) findViewById12, "view.findViewById(R.id.save_lyt)");
        this.p = (RelativeLayout) findViewById12;
        View findViewById13 = this.q.findViewById(R.id.save_lyt_txt);
        k.a((Object) findViewById13, "view.findViewById(R.id.save_lyt_txt)");
        this.k = (TextView) findViewById13;
        View findViewById14 = this.q.findViewById(R.id.package_sell_price);
        k.a((Object) findViewById14, "view.findViewById(R.id.package_sell_price)");
        this.l = (TextView) findViewById14;
        View findViewById15 = this.q.findViewById(R.id.package_mrp);
        k.a((Object) findViewById15, "view.findViewById(R.id.package_mrp)");
        this.m = (TextView) findViewById15;
        this.q.setOnClickListener(new View.OnClickListener(this) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f25121a;

            {
                this.f25121a = r1;
            }

            public final void onClick(View view) {
                pVar.a(this.f25121a.getAdapterPosition());
            }
        });
    }
}
