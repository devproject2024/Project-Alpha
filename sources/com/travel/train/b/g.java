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
import com.travel.train.model.metro.CJRDeepLinksModel;
import java.util.List;
import kotlin.g.b.k;

public final class g extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    Integer f26396a;

    /* renamed from: b  reason: collision with root package name */
    boolean f26397b;

    /* renamed from: c  reason: collision with root package name */
    final Context f26398c;

    /* renamed from: d  reason: collision with root package name */
    private final List<CJRDeepLinksModel> f26399d;

    public g(Context context, List<? extends CJRDeepLinksModel> list) {
        k.c(context, "context");
        k.c(list, "CJRMetroStripModelList");
        this.f26398c = context;
        this.f26399d = list;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        CJRDeepLinksModel cJRDeepLinksModel = this.f26399d.get(i2);
        aVar.f26401b.setText(cJRDeepLinksModel.title);
        aVar.f26402c.setText(cJRDeepLinksModel.info);
        if (!this.f26397b) {
            if (i2 == 0) {
                aVar.f26400a.setImageDrawable(androidx.core.content.b.a(this.f26398c, R.drawable.tickmark_round_select));
                aVar.f26403d.setBackground(androidx.core.content.b.a(this.f26398c, R.drawable.pre_t_train_rounded_corner_metro_selected));
                aVar.f26402c.setTextColor(androidx.core.content.b.c(this.f26398c, R.color.color_666666));
            } else {
                aVar.f26400a.setImageDrawable(androidx.core.content.b.a(this.f26398c, R.drawable.pre_t_train_circle_hollow_grey));
                aVar.f26403d.setBackground(androidx.core.content.b.a(this.f26398c, R.drawable.pre_t_train_rounded_corner_metro_unselected));
                aVar.f26402c.setTextColor(androidx.core.content.b.c(this.f26398c, R.color.color_999999));
            }
        }
        aVar.itemView.setOnClickListener(new b(this, i2, cJRDeepLinksModel));
        Integer num = this.f26396a;
        if (num != null && num.intValue() == i2) {
            aVar.f26400a.setImageDrawable(androidx.core.content.b.a(this.f26398c, R.drawable.tickmark_round_select));
            aVar.f26403d.setBackground(androidx.core.content.b.a(this.f26398c, R.drawable.pre_t_train_rounded_corner_metro_selected));
            return;
        }
        aVar.f26400a.setImageDrawable(androidx.core.content.b.a(this.f26398c, R.drawable.pre_t_train_circle_hollow_grey));
        aVar.f26403d.setBackground(androidx.core.content.b.a(this.f26398c, R.drawable.pre_t_train_rounded_corner_metro_unselected));
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_t_metro_home_strip_model_layout, viewGroup, false);
        k.a((Object) inflate, "view");
        return new a(inflate);
    }

    public final int getItemCount() {
        return this.f26399d.size();
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f26404a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f26405b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CJRDeepLinksModel f26406c;

        b(g gVar, int i2, CJRDeepLinksModel cJRDeepLinksModel) {
            this.f26404a = gVar;
            this.f26405b = i2;
            this.f26406c = cJRDeepLinksModel;
        }

        public final void onClick(View view) {
            g gVar = this.f26404a;
            gVar.f26397b = true;
            gVar.f26396a = Integer.valueOf(this.f26405b);
            this.f26404a.notifyDataSetChanged();
            com.travel.train.g.a aVar = com.travel.train.g.a.f27250a;
            com.travel.train.g.a.a((Object) this.f26406c);
            o.a("metro_home", "", "card_recharge_clicked", "/trains/metro", this.f26404a.f26398c);
        }
    }

    public static final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final ImageView f26400a;

        /* renamed from: b  reason: collision with root package name */
        final RoboTextView f26401b;

        /* renamed from: c  reason: collision with root package name */
        final RoboTextView f26402c;

        /* renamed from: d  reason: collision with root package name */
        final LinearLayout f26403d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            k.c(view, "itemView");
            View findViewById = view.findViewById(R.id.selected_metro_strip_imageview);
            k.a((Object) findViewById, "itemView.findViewById(R.…ed_metro_strip_imageview)");
            this.f26400a = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.header_textview);
            k.a((Object) findViewById2, "itemView.findViewById(R.id.header_textview)");
            this.f26401b = (RoboTextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.travel_homestrip_extra_textview);
            k.a((Object) findViewById3, "itemView.findViewById(R.…homestrip_extra_textview)");
            this.f26402c = (RoboTextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.main_layout_metro_home_strip);
            k.a((Object) findViewById4, "itemView.findViewById(R.…_layout_metro_home_strip)");
            this.f26403d = (LinearLayout) findViewById4;
        }
    }
}
