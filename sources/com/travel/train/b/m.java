package com.travel.train.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.travel.train.R;
import com.travel.train.j.o;
import com.travel.train.model.metro.CJRMetroRouteModel;
import java.util.List;
import kotlin.g.b.k;

public final class m extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    Integer f26478a;

    /* renamed from: b  reason: collision with root package name */
    boolean f26479b;

    /* renamed from: c  reason: collision with root package name */
    final Context f26480c;

    /* renamed from: d  reason: collision with root package name */
    final String f26481d;

    /* renamed from: e  reason: collision with root package name */
    final String f26482e;

    /* renamed from: f  reason: collision with root package name */
    private final List<CJRMetroRouteModel> f26483f;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        CJRMetroRouteModel cJRMetroRouteModel = this.f26483f.get(i2);
        aVar.f26485b.setText(cJRMetroRouteModel.heading.title);
        aVar.f26486c.setText(cJRMetroRouteModel.heading.info);
        if (!this.f26479b) {
            if (i2 == 0) {
                aVar.f26484a.setImageDrawable(androidx.core.content.b.a(this.f26480c, R.drawable.tickmark_round_select));
                aVar.f26487d.setBackground(androidx.core.content.b.a(this.f26480c, R.drawable.pre_t_train_rounded_corner_metro_selected));
            } else {
                aVar.f26484a.setImageDrawable(androidx.core.content.b.a(this.f26480c, R.drawable.pre_t_train_circle_hollow_grey));
                aVar.f26487d.setBackground(androidx.core.content.b.a(this.f26480c, R.drawable.pre_t_train_rounded_corner_metro_unselected));
            }
        }
        String str = cJRMetroRouteModel.heading.tag;
        k.a((Object) str, "route.heading.tag");
        if (str.length() > 0) {
            aVar.f26488e.setVisibility(0);
            aVar.f26488e.setText(cJRMetroRouteModel.heading.tag);
        }
        aVar.itemView.setOnClickListener(new b(this, i2, cJRMetroRouteModel));
        Integer num = this.f26478a;
        if (num != null && num.intValue() == i2) {
            aVar.f26484a.setImageDrawable(androidx.core.content.b.a(this.f26480c, R.drawable.tickmark_round_select));
            aVar.f26487d.setBackground(androidx.core.content.b.a(this.f26480c, R.drawable.pre_t_train_rounded_corner_metro_selected));
            aVar.f26486c.setTextColor(androidx.core.content.b.c(this.f26480c, R.color.color_666666));
            return;
        }
        aVar.f26484a.setImageDrawable(androidx.core.content.b.a(this.f26480c, R.drawable.pre_t_train_circle_hollow_grey));
        aVar.f26487d.setBackground(androidx.core.content.b.a(this.f26480c, R.drawable.pre_t_train_rounded_corner_metro_unselected));
        aVar.f26486c.setTextColor(androidx.core.content.b.c(this.f26480c, R.color.color_999999));
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f26480c).inflate(R.layout.pre_t_metro_home_strip_model_layout, viewGroup, false);
        k.a((Object) inflate, "view");
        return new a(inflate);
    }

    public m(Context context, List<? extends CJRMetroRouteModel> list, String str, String str2) {
        k.c(context, "context");
        k.c(list, "routeList");
        k.c(str, "source");
        k.c(str2, "dest");
        this.f26480c = context;
        this.f26483f = list;
        this.f26481d = str;
        this.f26482e = str2;
    }

    public final int getItemCount() {
        return this.f26483f.size();
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m f26489a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f26490b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CJRMetroRouteModel f26491c;

        b(m mVar, int i2, CJRMetroRouteModel cJRMetroRouteModel) {
            this.f26489a = mVar;
            this.f26490b = i2;
            this.f26491c = cJRMetroRouteModel;
        }

        public final void onClick(View view) {
            m mVar = this.f26489a;
            mVar.f26479b = true;
            mVar.f26478a = Integer.valueOf(this.f26490b);
            this.f26489a.notifyDataSetChanged();
            com.travel.train.g.a aVar = com.travel.train.g.a.f27250a;
            com.travel.train.g.a.a((Object) this.f26491c);
            o.a("metro_home", this.f26489a.f26481d + "_to_" + this.f26489a.f26482e, "route_clicked", "/trains/metro", this.f26489a.f26480c);
        }
    }

    public static final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final ImageView f26484a;

        /* renamed from: b  reason: collision with root package name */
        final RoboTextView f26485b;

        /* renamed from: c  reason: collision with root package name */
        final RoboTextView f26486c;

        /* renamed from: d  reason: collision with root package name */
        final LinearLayout f26487d;

        /* renamed from: e  reason: collision with root package name */
        final RoboTextView f26488e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            k.c(view, "itemView");
            View findViewById = view.findViewById(R.id.selected_metro_strip_imageview);
            k.a((Object) findViewById, "itemView.findViewById(R.…ed_metro_strip_imageview)");
            this.f26484a = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.header_textview);
            k.a((Object) findViewById2, "itemView.findViewById(R.id.header_textview)");
            this.f26485b = (RoboTextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.travel_homestrip_extra_textview);
            k.a((Object) findViewById3, "itemView.findViewById(R.…homestrip_extra_textview)");
            this.f26486c = (RoboTextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.main_layout_metro_home_strip);
            k.a((Object) findViewById4, "itemView.findViewById(R.…_layout_metro_home_strip)");
            this.f26487d = (LinearLayout) findViewById4;
            View findViewById5 = view.findViewById(R.id.tag_text);
            k.a((Object) findViewById5, "itemView.findViewById(R.id.tag_text)");
            this.f26488e = (RoboTextView) findViewById5;
        }
    }
}
