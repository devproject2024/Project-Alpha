package com.travel.train.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.b.b;
import com.travel.train.R;
import com.travel.train.j.o;
import com.travel.train.model.metro.CJRMetroHomeCityBottomSheetModel;
import java.util.List;
import kotlin.g.b.k;

public final class f extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    final Context f26389a;

    /* renamed from: b  reason: collision with root package name */
    private final List<CJRMetroHomeCityBottomSheetModel> f26390b;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        CJRMetroHomeCityBottomSheetModel cJRMetroHomeCityBottomSheetModel = this.f26390b.get(i2);
        aVar.f26393c.setText(cJRMetroHomeCityBottomSheetModel.name);
        CharSequence charSequence = cJRMetroHomeCityBottomSheetModel.img_url;
        if (!(charSequence == null || charSequence.length() == 0)) {
            b.a aVar2 = com.paytm.utility.b.b.f43744a;
            b.a.C0750a a2 = b.a.a(this.f26389a);
            a2.f43753a = cJRMetroHomeCityBottomSheetModel.img_url;
            b.a.C0750a.a(a2.a((Object) Integer.valueOf(R.drawable.pre_t_delhi_metro_logo)).b(Integer.valueOf(R.drawable.pre_t_delhi_metro_logo)), aVar.f26391a, (com.paytm.utility.b.b.b) null, 2);
        }
        Boolean bool = cJRMetroHomeCityBottomSheetModel.is_enabled;
        k.a((Object) bool, "city.is_enabled");
        if (bool.booleanValue()) {
            aVar.f26392b.setVisibility(8);
        } else {
            aVar.f26392b.setText(cJRMetroHomeCityBottomSheetModel.tag);
            View view = aVar.itemView;
            k.a((Object) view, "holder.itemView");
            view.setEnabled(false);
            View view2 = aVar.itemView;
            k.a((Object) view2, "holder.itemView");
            view2.setClickable(false);
            aVar.f26393c.setAlpha(0.6f);
            aVar.f26391a.setAlpha(0.6f);
        }
        aVar.itemView.setOnClickListener(new b(this, cJRMetroHomeCityBottomSheetModel));
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f26389a).inflate(R.layout.pre_t_metro_model_layout_in_bottom_sheet, viewGroup, false);
        k.a((Object) inflate, "view");
        return new a(inflate);
    }

    public f(Context context, List<? extends CJRMetroHomeCityBottomSheetModel> list) {
        k.c(context, "context");
        k.c(list, "cityList");
        this.f26389a = context;
        this.f26390b = list;
    }

    public final int getItemCount() {
        return this.f26390b.size();
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f26394a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJRMetroHomeCityBottomSheetModel f26395b;

        b(f fVar, CJRMetroHomeCityBottomSheetModel cJRMetroHomeCityBottomSheetModel) {
            this.f26394a = fVar;
            this.f26395b = cJRMetroHomeCityBottomSheetModel;
        }

        public final void onClick(View view) {
            CJRMetroHomeCityBottomSheetModel cJRMetroHomeCityBottomSheetModel = new CJRMetroHomeCityBottomSheetModel(this.f26395b.name, this.f26395b.modeid, this.f26395b.img_url, this.f26395b.is_enabled, this.f26395b.tag, this.f26395b.pre_selected, this.f26395b.deeplinks);
            com.travel.train.g.a aVar = com.travel.train.g.a.f27250a;
            com.travel.train.g.a.a((Object) cJRMetroHomeCityBottomSheetModel);
            o.a("metro_home", this.f26395b.name, "city_changed", "/trains/metro", this.f26394a.f26389a);
        }
    }

    public static final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final ImageView f26391a;

        /* renamed from: b  reason: collision with root package name */
        final RoboTextView f26392b;

        /* renamed from: c  reason: collision with root package name */
        final RoboTextView f26393c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            k.c(view, "itemview");
            View findViewById = view.findViewById(R.id.metro_city_imageview);
            k.a((Object) findViewById, "itemview.findViewById(R.id.metro_city_imageview)");
            this.f26391a = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.tag_text);
            k.a((Object) findViewById2, "itemview.findViewById(R.id.tag_text)");
            this.f26392b = (RoboTextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.metro_city_name_textview);
            k.a((Object) findViewById3, "itemview.findViewById(R.…metro_city_name_textview)");
            this.f26393c = (RoboTextView) findViewById3;
        }
    }
}
