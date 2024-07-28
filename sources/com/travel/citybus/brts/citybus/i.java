package com.travel.citybus.brts.citybus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.t;
import com.travel.citybus.R;
import com.travel.citybus.brts.model.pojo.CJRCity;
import com.travel.citybus.brts.utils.e;
import java.util.List;
import kotlin.g.b.k;

public final class i extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f23293a;

    /* renamed from: b  reason: collision with root package name */
    private final List<CJRCity> f23294b;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        CJRCity cJRCity = this.f23294b.get(i2);
        aVar.f23296b.setText(cJRCity.getName());
        CharSequence imageURL = cJRCity.getImageURL();
        if (!(imageURL == null || imageURL.length() == 0)) {
            t.a(false);
            t.b(cJRCity.getImageURL(), aVar.f23295a);
        }
        aVar.itemView.setOnClickListener(new b(cJRCity));
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f23293a).inflate(R.layout.pre_t_citybus_model_layout_in_bottom_sheet, viewGroup, false);
        k.a((Object) inflate, "view");
        return new a(inflate);
    }

    public i(Context context, List<CJRCity> list) {
        k.c(context, "context");
        k.c(list, "cityList");
        this.f23293a = context;
        this.f23294b = list;
    }

    public final int getItemCount() {
        return this.f23294b.size();
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRCity f23297a;

        b(CJRCity cJRCity) {
            this.f23297a = cJRCity;
        }

        public final void onClick(View view) {
            e eVar = e.f23402a;
            e.a((Object) this.f23297a);
        }
    }

    public static final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final ImageView f23295a;

        /* renamed from: b  reason: collision with root package name */
        final RoboTextView f23296b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            k.c(view, "itemview");
            View findViewById = view.findViewById(R.id.metro_city_imageview);
            k.a((Object) findViewById, "itemview.findViewById(R.id.metro_city_imageview)");
            this.f23295a = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.metro_city_name_textview);
            k.a((Object) findViewById2, "itemview.findViewById(R.…metro_city_name_textview)");
            this.f23296b = (RoboTextView) findViewById2;
        }
    }
}
