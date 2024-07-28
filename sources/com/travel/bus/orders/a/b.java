package com.travel.bus.orders.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b.b;
import com.travel.bus.R;
import com.travel.bus.pojo.hotel.CJRHotelDataModel;
import java.util.List;

public final class b extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    private Context f22552a;

    /* renamed from: b  reason: collision with root package name */
    private List<CJRHotelDataModel> f22553b;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        CJRHotelDataModel cJRHotelDataModel = this.f22553b.get(i2);
        if (cJRHotelDataModel != null) {
            if (cJRHotelDataModel.getPaytmImages() != null && cJRHotelDataModel.getPaytmImages().getThumb() != null && !cJRHotelDataModel.getPaytmImages().getThumb().isEmpty() && cJRHotelDataModel.getPaytmImages().getThumb().size() > 0 && !TextUtils.isEmpty(cJRHotelDataModel.getPaytmImages().getThumb().get(0))) {
                b.a.C0750a a2 = com.paytm.utility.b.b.a(this.f22552a);
                a2.f43753a = cJRHotelDataModel.getPaytmImages().getThumb().get(0);
                b.a.C0750a.a(a2, aVar.f22554a, (com.paytm.utility.b.b.b) null, 2);
            }
            aVar.f22556c.setText(cJRHotelDataModel.getName());
            aVar.f22555b.setText(String.valueOf(cJRHotelDataModel.getPriceData().getOriginalPrice()));
            aVar.f22557d.setText(String.valueOf(cJRHotelDataModel.getStarRating()));
            aVar.f22560g.setVisibility(0);
            aVar.f22561h.setVisibility(0);
            if (cJRHotelDataModel.getFacilities() == null || cJRHotelDataModel.getFacilities().isEmpty()) {
                aVar.f22560g.setVisibility(8);
                aVar.f22561h.setVisibility(8);
            } else if (cJRHotelDataModel.getFacilities().size() >= 2) {
                aVar.f22558e.setText(cJRHotelDataModel.getFacilities().get(0));
                aVar.f22559f.setText(cJRHotelDataModel.getFacilities().get(1));
            } else {
                aVar.f22558e.setText(cJRHotelDataModel.getFacilities().get(0));
                aVar.f22561h.setVisibility(8);
            }
        }
        aVar.itemView.setOnClickListener(new View.OnClickListener(cJRHotelDataModel) {
            private final /* synthetic */ CJRHotelDataModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                b.this.a(this.f$1, view);
            }
        });
    }

    public b(Context context, List<CJRHotelDataModel> list) {
        this.f22552a = context;
        this.f22553b = list;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CJRHotelDataModel cJRHotelDataModel, View view) {
        if (cJRHotelDataModel.getDeepLink() != null && !cJRHotelDataModel.getDeepLink().isEmpty()) {
            com.travel.bus.a.a();
            com.travel.bus.a.b().b(cJRHotelDataModel.getDeepLink(), this.f22552a);
        }
    }

    public final int getItemCount() {
        return this.f22553b.size();
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ImageView f22554a;

        /* renamed from: b  reason: collision with root package name */
        TextView f22555b;

        /* renamed from: c  reason: collision with root package name */
        TextView f22556c;

        /* renamed from: d  reason: collision with root package name */
        TextView f22557d;

        /* renamed from: e  reason: collision with root package name */
        TextView f22558e;

        /* renamed from: f  reason: collision with root package name */
        TextView f22559f;

        /* renamed from: g  reason: collision with root package name */
        LinearLayout f22560g;

        /* renamed from: h  reason: collision with root package name */
        LinearLayout f22561h;
        private TextView j;

        public a(View view) {
            super(view);
            this.f22554a = (ImageView) view.findViewById(R.id.hotel_imageview_in_card);
            this.f22555b = (TextView) view.findViewById(R.id.hotel_price);
            this.f22556c = (TextView) view.findViewById(R.id.hotel_name);
            this.f22557d = (TextView) view.findViewById(R.id.hotel_rating_in_card);
            this.j = (TextView) view.findViewById(R.id.review_count_in_hotel_card);
            this.f22558e = (TextView) view.findViewById(R.id.first_facility_textview);
            this.f22559f = (TextView) view.findViewById(R.id.second_facility_textview);
            this.f22560g = (LinearLayout) view.findViewById(R.id.first_facility_layout);
            this.f22561h = (LinearLayout) view.findViewById(R.id.second_facility_layout);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(this.f22552a).inflate(R.layout.pre_b_bus_single_hotel_model_layout, viewGroup, false));
    }
}
