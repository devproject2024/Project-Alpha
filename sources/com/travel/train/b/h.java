package com.travel.train.b;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.b.b;
import com.travel.cdn.ResourceUtils;
import com.travel.train.R;
import com.travel.train.model.metro.CJRChangeLineModel;
import com.travel.train.model.metro.CJRRoute;
import com.travel.train.model.metro.CJRStationModel;
import com.travel.utils.n;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;

public final class h extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    final Context f26407a;

    /* renamed from: b  reason: collision with root package name */
    private final int f26408b = 27;

    /* renamed from: c  reason: collision with root package name */
    private final int f26409c = 3;

    /* renamed from: d  reason: collision with root package name */
    private final int f26410d = 100;

    /* renamed from: e  reason: collision with root package name */
    private List<? extends CJRRoute> f26411e;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        String str;
        i iVar;
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        CJRRoute cJRRoute = (CJRRoute) this.f26411e.get(i2);
        aVar.f26412a.setText(cJRRoute.stations.get(0).name);
        aVar.l.setText(cJRRoute.stations.get(cJRRoute.stations.size() - 1).name);
        aVar.j.setText(cJRRoute.time);
        int size = cJRRoute.stations.size() - 2;
        if (size > 0) {
            str = String.valueOf(size) + " " + this.f26407a.getString(R.string.stations_metro);
        } else {
            str = this.f26407a.getString(R.string.next_station_text);
            aVar.f26418g.setClickable(false);
            aVar.f26418g.setEnabled(false);
            aVar.f26420i.setVisibility(8);
        }
        if (str != null) {
            aVar.f26418g.setText(str);
        }
        if (cJRRoute.lineinfo.color != null) {
            aVar.f26413b.setBackgroundColor(Color.parseColor(cJRRoute.lineinfo.color));
            aVar.f26413b.setBackgroundResource(R.drawable.pre_t_train_tags_rounded_corner_metro_line);
            Drawable background = aVar.f26413b.getBackground();
            if (background != null) {
                ((GradientDrawable) background).setColor(Color.parseColor(cJRRoute.lineinfo.color));
                aVar.m.setBackgroundColor(Color.parseColor(cJRRoute.lineinfo.color));
                aVar.m.setBackgroundResource(R.drawable.pre_t_train_tags_rounded_corner_metro_line);
                aVar.f26415d.setBackgroundColor(Color.parseColor(cJRRoute.lineinfo.color));
                aVar.f26416e.setBackgroundColor(Color.parseColor(cJRRoute.lineinfo.color));
                aVar.f26416e.setBackgroundResource(R.drawable.pre_t_train_corner_view_round);
                aVar.f26417f.setBackgroundColor(Color.parseColor(cJRRoute.lineinfo.color));
                Drawable background2 = aVar.f26416e.getBackground();
                if (background2 != null) {
                    ((StateListDrawable) background2).setColorFilter(Color.parseColor(cJRRoute.lineinfo.color), PorterDuff.Mode.SRC_ATOP);
                    aVar.f26414c.setBackgroundColor(Color.parseColor(cJRRoute.lineinfo.color));
                    CharSequence charSequence = cJRRoute.stations.get(0).img_url;
                    if (!(charSequence == null || charSequence.length() == 0)) {
                        b.a aVar2 = com.paytm.utility.b.b.f43744a;
                        b.a.C0750a a2 = b.a.a(this.f26407a);
                        a2.f43753a = cJRRoute.stations.get(0).img_url;
                        b.a.C0750a.a(a2, aVar.r, (com.paytm.utility.b.b.b) null, 2);
                    }
                } else {
                    throw new u("null cannot be cast to non-null type android.graphics.drawable.StateListDrawable");
                }
            } else {
                throw new u("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            }
        }
        if (aVar.f26412a.getText().length() > this.f26408b) {
            ViewGroup.LayoutParams layoutParams = aVar.f26417f.getLayoutParams();
            if (layoutParams != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (layoutParams2 != null) {
                    layoutParams2.height = this.f26410d;
                    layoutParams2.addRule(14);
                    aVar.f26417f.setLayoutParams(layoutParams2);
                    aVar.f26412a.setMaxLines(this.f26409c);
                } else {
                    aVar.f26412a.setEllipsize(TextUtils.TruncateAt.END);
                }
            } else {
                throw new u("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            }
        }
        if (aVar.l.getText().length() > this.f26408b) {
            aVar.l.setMaxLines(this.f26409c);
        }
        if (cJRRoute.lineinfo.text_color != null) {
            aVar.f26413b.setTextColor(Color.parseColor(cJRRoute.lineinfo.text_color));
            aVar.m.setTextColor(Color.parseColor(cJRRoute.lineinfo.text_color));
        }
        aVar.f26413b.setText(cJRRoute.lineinfo.linename);
        aVar.m.setText(cJRRoute.lineinfo.linename);
        aVar.n.setText(cJRRoute.towards);
        if (cJRRoute.change_line != null) {
            aVar.o.setVisibility(0);
            RoboTextView roboTextView = aVar.p;
            CJRChangeLineModel cJRChangeLineModel = cJRRoute.change_line;
            if (cJRChangeLineModel == null) {
                k.a();
            }
            roboTextView.setText(cJRChangeLineModel.title);
            RoboTextView roboTextView2 = aVar.q;
            CJRChangeLineModel cJRChangeLineModel2 = cJRRoute.change_line;
            if (cJRChangeLineModel2 == null) {
                k.a();
            }
            roboTextView2.setText(cJRChangeLineModel2.message);
            ResourceUtils.loadTrainImagesFromCDN(aVar.s, "change_metro.png", false, false, n.a.V1);
        }
        if (cJRRoute.lineinfo.color != null) {
            Context context = this.f26407a;
            List<CJRStationModel> subList = cJRRoute.stations.subList(1, cJRRoute.stations.size() - 1);
            String str2 = cJRRoute.lineinfo.color;
            if (str2 == null) {
                k.a();
            }
            iVar = new i(context, subList, str2);
        } else {
            iVar = new i(this.f26407a, cJRRoute.stations.subList(1, cJRRoute.stations.size() - 1), "#ffffff");
        }
        aVar.k.setAdapter(iVar);
        aVar.k.setNestedScrollingEnabled(false);
        aVar.k.setLayoutManager(new LinearLayoutManager(this.f26407a, 1, false));
        aVar.k.setHasFixedSize(true);
        aVar.f26419h.setOnClickListener(new b(this, aVar));
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f26407a).inflate(R.layout.pre_t_metro_lines_model_layout_for_search_route_recyclerview, viewGroup, false);
        k.a((Object) inflate, "view");
        return new a(inflate);
    }

    public h(Context context, List<? extends CJRRoute> list) {
        k.c(context, "context");
        k.c(list, "routeStationList");
        this.f26407a = context;
        this.f26411e = list;
    }

    public final int getItemCount() {
        return this.f26411e.size();
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f26421a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f26422b;

        b(h hVar, a aVar) {
            this.f26421a = hVar;
            this.f26422b = aVar;
        }

        public final void onClick(View view) {
            if (this.f26422b.k.getVisibility() == 8) {
                this.f26422b.f26420i.setImageDrawable(androidx.core.content.b.a(this.f26421a.f26407a, R.drawable.pre_t_drop_up));
                this.f26422b.k.setVisibility(0);
                return;
            }
            this.f26422b.f26420i.setImageDrawable(androidx.core.content.b.a(this.f26421a.f26407a, R.drawable.pre_t_drop));
            this.f26422b.k.setVisibility(8);
        }
    }

    public static final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final RoboTextView f26412a;

        /* renamed from: b  reason: collision with root package name */
        final RoboTextView f26413b;

        /* renamed from: c  reason: collision with root package name */
        final View f26414c;

        /* renamed from: d  reason: collision with root package name */
        final View f26415d;

        /* renamed from: e  reason: collision with root package name */
        final View f26416e;

        /* renamed from: f  reason: collision with root package name */
        final View f26417f;

        /* renamed from: g  reason: collision with root package name */
        final RoboTextView f26418g;

        /* renamed from: h  reason: collision with root package name */
        final LinearLayout f26419h;

        /* renamed from: i  reason: collision with root package name */
        final ImageView f26420i;
        final RoboTextView j;
        final RecyclerView k;
        final RoboTextView l;
        final RoboTextView m;
        final RoboTextView n;
        final LinearLayout o;
        final RoboTextView p;
        final RoboTextView q;
        final ImageView r;
        final ImageView s;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            k.c(view, "itemView");
            View findViewById = view.findViewById(R.id.source_station_in_metro_lines_model_layout);
            k.a((Object) findViewById, "itemView.findViewById(R.…metro_lines_model_layout)");
            this.f26412a = (RoboTextView) findViewById;
            View findViewById2 = view.findViewById(R.id.line_color_source_station_in_metro_lines_model_layout);
            k.a((Object) findViewById2, "itemView.findViewById(R.…metro_lines_model_layout)");
            this.f26413b = (RoboTextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.metro_rail);
            k.a((Object) findViewById3, "itemView.findViewById(R.id.metro_rail)");
            this.f26414c = findViewById3;
            View findViewById4 = view.findViewById(R.id.initial_side_view);
            k.a((Object) findViewById4, "itemView.findViewById(R.id.initial_side_view)");
            this.f26415d = findViewById4;
            View findViewById5 = view.findViewById(R.id.end_side_view);
            k.a((Object) findViewById5, "itemView.findViewById(R.id.end_side_view)");
            this.f26416e = findViewById5;
            View findViewById6 = view.findViewById(R.id.middle_side_view);
            k.a((Object) findViewById6, "itemView.findViewById(R.id.middle_side_view)");
            this.f26417f = findViewById6;
            View findViewById7 = view.findViewById(R.id.intermediate_station_count_in_metro_lines_model_layout);
            k.a((Object) findViewById7, "itemView.findViewById(R.…metro_lines_model_layout)");
            this.f26418g = (RoboTextView) findViewById7;
            View findViewById8 = view.findViewById(R.id.station_arrow);
            k.a((Object) findViewById8, "itemView.findViewById(R.id.station_arrow)");
            this.f26419h = (LinearLayout) findViewById8;
            View findViewById9 = view.findViewById(R.id.arrow_imageview);
            k.a((Object) findViewById9, "itemView.findViewById(R.id.arrow_imageview)");
            this.f26420i = (ImageView) findViewById9;
            View findViewById10 = view.findViewById(R.id.duration_in_metro_lines_model_layout);
            k.a((Object) findViewById10, "itemView.findViewById(R.…metro_lines_model_layout)");
            this.j = (RoboTextView) findViewById10;
            View findViewById11 = view.findViewById(R.id.internal_stations_recyclerview);
            k.a((Object) findViewById11, "itemView.findViewById(R.…al_stations_recyclerview)");
            this.k = (RecyclerView) findViewById11;
            View findViewById12 = view.findViewById(R.id.destination_station_in_metro_lines_model_layout);
            k.a((Object) findViewById12, "itemView.findViewById(R.…metro_lines_model_layout)");
            this.l = (RoboTextView) findViewById12;
            View findViewById13 = view.findViewById(R.id.line_color_destination_station_in_metro_lines_model_layout);
            k.a((Object) findViewById13, "itemView.findViewById(R.…metro_lines_model_layout)");
            this.m = (RoboTextView) findViewById13;
            View findViewById14 = view.findViewById(R.id.towards_textview_in_metro_lines_model_layout);
            k.a((Object) findViewById14, "itemView.findViewById(R.…metro_lines_model_layout)");
            this.n = (RoboTextView) findViewById14;
            View findViewById15 = view.findViewById(R.id.metro_change_linear_layout);
            k.a((Object) findViewById15, "itemView.findViewById(R.…tro_change_linear_layout)");
            this.o = (LinearLayout) findViewById15;
            View findViewById16 = view.findViewById(R.id.change_here_textview);
            k.a((Object) findViewById16, "itemView.findViewById(R.id.change_here_textview)");
            this.p = (RoboTextView) findViewById16;
            View findViewById17 = view.findViewById(R.id.line_change_text);
            k.a((Object) findViewById17, "itemView.findViewById(R.id.line_change_text)");
            this.q = (RoboTextView) findViewById17;
            View findViewById18 = view.findViewById(R.id.metro_rail_icon_first_element);
            k.a((Object) findViewById18, "itemView.findViewById(R.…_rail_icon_first_element)");
            this.r = (ImageView) findViewById18;
            View findViewById19 = view.findViewById(R.id.change_metro_icon);
            k.a((Object) findViewById19, "itemView.findViewById(R.id.change_metro_icon)");
            this.s = (ImageView) findViewById19;
        }
    }
}
