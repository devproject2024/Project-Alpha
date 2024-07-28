package com.travel.train.b;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.travel.train.R;
import com.travel.train.model.metro.CJRSearchedMetroLineModel;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;

public final class p extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f26515a;

    /* renamed from: b  reason: collision with root package name */
    private final List<CJRSearchedMetroLineModel> f26516b;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        CJRSearchedMetroLineModel cJRSearchedMetroLineModel = this.f26516b.get(i2);
        aVar.f26517a.setText(cJRSearchedMetroLineModel.linename);
        Drawable background = aVar.f26518b.getBackground();
        if (background != null) {
            ((StateListDrawable) background).setColorFilter(Color.parseColor(cJRSearchedMetroLineModel.color), PorterDuff.Mode.SRC_OVER);
            return;
        }
        throw new u("null cannot be cast to non-null type android.graphics.drawable.StateListDrawable");
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f26515a).inflate(R.layout.pre_t_single_line_model_layout_searched_stations, viewGroup, false);
        k.a((Object) inflate, "view");
        return new a(inflate);
    }

    public p(Context context, List<? extends CJRSearchedMetroLineModel> list) {
        k.c(context, "context");
        k.c(list, "lineList");
        this.f26515a = context;
        this.f26516b = list;
    }

    public final int getItemCount() {
        return this.f26516b.size();
    }

    public static final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final RoboTextView f26517a;

        /* renamed from: b  reason: collision with root package name */
        final FrameLayout f26518b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            k.c(view, "itemView");
            View findViewById = view.findViewById(R.id.station_name_in_searched_station);
            k.a((Object) findViewById, "itemView.findViewById(R.…name_in_searched_station)");
            this.f26517a = (RoboTextView) findViewById;
            View findViewById2 = view.findViewById(R.id.color_shape_layout);
            k.a((Object) findViewById2, "itemView.findViewById(R.id.color_shape_layout)");
            this.f26518b = (FrameLayout) findViewById2;
        }
    }
}
