package com.travel.train.b;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.b.a.b;
import com.paytm.utility.b.b;
import com.travel.train.R;
import com.travel.train.model.metro.CJRStationModel;
import java.util.List;
import kotlin.g.b.k;

public final class i extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f26423a;

    /* renamed from: b  reason: collision with root package name */
    private final List<CJRStationModel> f26424b;

    /* renamed from: c  reason: collision with root package name */
    private final String f26425c;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        CJRStationModel cJRStationModel = this.f26424b.get(i2);
        aVar.f26426a.setBackgroundColor(Color.parseColor(this.f26425c));
        aVar.f26427b.setText(cJRStationModel.name);
        b.a aVar2 = b.f43744a;
        b.a.C0750a a2 = b.a.a(this.f26423a);
        a2.f43753a = cJRStationModel.img_url;
        b.a.C0750a.a(a2.a((Object) Integer.valueOf(R.drawable.pre_t_metro_rail_white)).b(Integer.valueOf(R.drawable.pre_t_metro_rail_white)).a(0, b.a.ALL), aVar.f26428c, (com.paytm.utility.b.b.b) null, 2);
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f26423a).inflate(R.layout.pre_t_single_station_layout_in_search_model_recyclerview, viewGroup, false);
        k.a((Object) inflate, "view");
        return new a(inflate);
    }

    public i(Context context, List<? extends CJRStationModel> list, String str) {
        k.c(context, "context");
        k.c(list, "stationList");
        k.c(str, "lineColor");
        this.f26423a = context;
        this.f26424b = list;
        this.f26425c = str;
    }

    public final int getItemCount() {
        return this.f26424b.size();
    }

    public static final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final View f26426a;

        /* renamed from: b  reason: collision with root package name */
        final RoboTextView f26427b;

        /* renamed from: c  reason: collision with root package name */
        final ImageView f26428c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            k.c(view, "itemView");
            View findViewById = view.findViewById(R.id.side_view);
            k.a((Object) findViewById, "itemView.findViewById(R.id.side_view)");
            this.f26426a = findViewById;
            View findViewById2 = view.findViewById(R.id.station_name_in_station_model_layout);
            k.a((Object) findViewById2, "itemView.findViewById(R.…_in_station_model_layout)");
            this.f26427b = (RoboTextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.metro_icon_imageview);
            k.a((Object) findViewById3, "itemView.findViewById(R.id.metro_icon_imageview)");
            this.f26428c = (ImageView) findViewById3;
        }
    }
}
