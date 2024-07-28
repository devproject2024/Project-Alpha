package com.travel.citybus.brts.citybus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.travel.citybus.R;
import com.travel.citybus.brts.model.pojo.CJRCityAutoSuggest;
import java.util.List;
import kotlin.g.b.k;

public final class o extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    final z f23310a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f23311b;

    /* renamed from: c  reason: collision with root package name */
    private final List<CJRCityAutoSuggest> f23312c;

    public o(Context context, List<CJRCityAutoSuggest> list, z zVar) {
        k.c(context, "context");
        k.c(list, "busStopList");
        k.c(zVar, "iJRSelectedBusStopListener");
        this.f23311b = context;
        this.f23312c = list;
        this.f23310a = zVar;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f23311b).inflate(R.layout.pre_t_search_busstop_model_layout, viewGroup, false);
        if (inflate == null) {
            k.a();
        }
        return new a(inflate);
    }

    public final int getItemCount() {
        return this.f23312c.size();
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        k.c(vVar, "holder");
        CJRCityAutoSuggest cJRCityAutoSuggest = this.f23312c.get(i2);
        a aVar = (a) vVar;
        aVar.f23313a.setText(cJRCityAutoSuggest.getName());
        aVar.f23314b.setText(cJRCityAutoSuggest.getId());
        vVar.itemView.setOnClickListener(new b(this, cJRCityAutoSuggest));
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f23315a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJRCityAutoSuggest f23316b;

        b(o oVar, CJRCityAutoSuggest cJRCityAutoSuggest) {
            this.f23315a = oVar;
            this.f23316b = cJRCityAutoSuggest;
        }

        public final void onClick(View view) {
            this.f23315a.f23310a.a(this.f23316b);
        }
    }

    public static final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final RoboTextView f23313a;

        /* renamed from: b  reason: collision with root package name */
        final RoboTextView f23314b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            k.c(view, "itemView");
            View findViewById = view.findViewById(R.id.station_name_in_searched_station);
            k.a((Object) findViewById, "itemView.findViewById(R.…name_in_searched_station)");
            this.f23313a = (RoboTextView) findViewById;
            View findViewById2 = view.findViewById(R.id.station_id_in_searched_station);
            k.a((Object) findViewById2, "itemView.findViewById(R.…n_id_in_searched_station)");
            this.f23314b = (RoboTextView) findViewById2;
        }
    }
}
