package com.travel.train.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.b.a.b;
import com.paytm.utility.b.b;
import com.travel.train.R;
import com.travel.train.model.metro.CJRMetroRouteAdditionalInfoModel;
import java.util.List;
import kotlin.g.b.k;

public final class n extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f26492a;

    /* renamed from: b  reason: collision with root package name */
    private final List<CJRMetroRouteAdditionalInfoModel> f26493b;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        CJRMetroRouteAdditionalInfoModel cJRMetroRouteAdditionalInfoModel = this.f26493b.get(i2);
        aVar.f26494a.setText(cJRMetroRouteAdditionalInfoModel.title);
        aVar.f26495b.setText(cJRMetroRouteAdditionalInfoModel.type);
        CharSequence charSequence = cJRMetroRouteAdditionalInfoModel.img_url;
        if (!(charSequence == null || charSequence.length() == 0)) {
            b.a aVar2 = b.f43744a;
            b.a.C0750a a2 = b.a.a(this.f26492a);
            a2.f43753a = cJRMetroRouteAdditionalInfoModel.img_url;
            b.a.C0750a.a(a2.a((Object) Integer.valueOf(R.drawable.pre_t_rupee_icon)).b(Integer.valueOf(R.drawable.pre_t_rupee_icon)).a(0, b.a.ALL), aVar.f26496c, (com.paytm.utility.b.b.b) null, 2);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f26492a).inflate(R.layout.pre_t_route_info_model_layout, viewGroup, false);
        k.a((Object) inflate, "view");
        return new a(inflate);
    }

    public n(Context context, List<? extends CJRMetroRouteAdditionalInfoModel> list) {
        k.c(context, "context");
        k.c(list, "routeInfoList");
        this.f26492a = context;
        this.f26493b = list;
    }

    public final int getItemCount() {
        return this.f26493b.size();
    }

    public static final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final RoboTextView f26494a;

        /* renamed from: b  reason: collision with root package name */
        final RoboTextView f26495b;

        /* renamed from: c  reason: collision with root package name */
        final ImageView f26496c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            k.c(view, "itemView");
            View findViewById = view.findViewById(R.id.route_info_title);
            k.a((Object) findViewById, "itemView.findViewById(R.id.route_info_title)");
            this.f26494a = (RoboTextView) findViewById;
            View findViewById2 = view.findViewById(R.id.route_info_type);
            k.a((Object) findViewById2, "itemView.findViewById(R.id.route_info_type)");
            this.f26495b = (RoboTextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.route_info_imageview);
            k.a((Object) findViewById3, "itemView.findViewById(R.id.route_info_imageview)");
            this.f26496c = (ImageView) findViewById3;
        }
    }
}
