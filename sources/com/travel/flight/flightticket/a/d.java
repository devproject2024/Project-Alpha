package com.travel.flight.flightticket.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.cdn.ResourceUtils;
import com.travel.flight.R;
import com.travel.flight.pojo.flightticket.CJRFareAlertHomeAnalyticsModel;
import com.travel.utils.n;
import java.util.List;

public final class d extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    b f24621a;

    /* renamed from: b  reason: collision with root package name */
    private List<CJRFareAlertHomeAnalyticsModel.a> f24622b;

    /* renamed from: c  reason: collision with root package name */
    private Context f24623c;

    public interface b {
        void a(View view, int i2);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        String str;
        a aVar = (a) vVar;
        CJRFareAlertHomeAnalyticsModel.a aVar2 = this.f24622b.get(i2);
        String d2 = com.paytm.utility.b.d(aVar2.f25429e, "dd MMM yyyy", "E, dd MMM yy");
        aVar.f24624a.setText(aVar2.f25426b);
        aVar.f24625b.setText(aVar2.f25430f);
        aVar.f24626c.setText(d2);
        if (aVar2.f25425a != null) {
            aVar.l.setVisibility(0);
            aVar.f24627d.setText(aVar2.f25425a.f25436d);
            aVar.f24628e.setText(aVar2.f25425a.f25435c);
            TextView textView = aVar.f24629f;
            String str2 = aVar2.f25425a.f25434b;
            if (str2.equals("1")) {
                str = String.format(this.f24623c.getString(R.string.in_last_day), new Object[]{str2});
            } else {
                str = String.format(this.f24623c.getString(R.string.in_last_days), new Object[]{str2});
            }
            textView.setText(str);
            if (aVar2.f25425a.f25433a.equals("increased")) {
                aVar.f24631h.setImageResource(R.drawable.pre_f_arrow_up_trend);
                aVar.f24628e.setTextColor(androidx.core.content.b.c(this.f24623c, R.color.color_fd5c5c));
                aVar.f24630g.setTextColor(androidx.core.content.b.c(this.f24623c, R.color.color_fd5c5c));
            } else {
                aVar.f24631h.setImageResource(R.drawable.pre_f_arrow_down_trend);
                aVar.f24628e.setTextColor(androidx.core.content.b.c(this.f24623c, R.color.green_fare_alert));
                aVar.f24630g.setTextColor(androidx.core.content.b.c(this.f24623c, R.color.green_fare_alert));
            }
        } else {
            aVar.l.setVisibility(4);
        }
        if (aVar2.f25431g) {
            ResourceUtils.loadFlightImagesFromCDN(aVar.f24632i, "bell_blue_border.png", false, false, n.a.V1);
        } else {
            ResourceUtils.loadFlightImagesFromCDN(aVar.f24632i, "blue_bell.png", false, false, n.a.V1);
        }
        ResourceUtils.loadFlightImagesFromCDN(aVar.j, "dustbin.png", false, false, n.a.V1);
        ResourceUtils.loadFlightImagesFromCDN(aVar.k, "dustbin.png", false, false, n.a.V1);
    }

    public d(Context context, b bVar, List<CJRFareAlertHomeAnalyticsModel.a> list) {
        this.f24622b = list;
        this.f24623c = context;
        this.f24621a = bVar;
    }

    public final int getItemCount() {
        return this.f24622b.size();
    }

    public class a extends RecyclerView.v implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        TextView f24624a;

        /* renamed from: b  reason: collision with root package name */
        TextView f24625b;

        /* renamed from: c  reason: collision with root package name */
        TextView f24626c;

        /* renamed from: d  reason: collision with root package name */
        TextView f24627d;

        /* renamed from: e  reason: collision with root package name */
        TextView f24628e;

        /* renamed from: f  reason: collision with root package name */
        TextView f24629f;

        /* renamed from: g  reason: collision with root package name */
        TextView f24630g;

        /* renamed from: h  reason: collision with root package name */
        ImageView f24631h;

        /* renamed from: i  reason: collision with root package name */
        ImageView f24632i;
        ImageView j;
        ImageView k;
        LinearLayout l;
        public RelativeLayout m;
        public RelativeLayout n;

        public a(View view) {
            super(view);
            this.f24624a = (TextView) view.findViewById(R.id.flight_recent_tab_source_city_name);
            this.f24625b = (TextView) view.findViewById(R.id.flight_recent_tab_destination_city_name);
            this.f24626c = (TextView) view.findViewById(R.id.flight_recent_tab_date_of_travel);
            this.f24627d = (TextView) view.findViewById(R.id.txt_fare_alert_item_price);
            this.f24628e = (TextView) view.findViewById(R.id.txt_fare_alert_item_trend_price);
            this.f24629f = (TextView) view.findViewById(R.id.txt_fare_alert_item_duration);
            this.f24631h = (ImageView) view.findViewById(R.id.img_fare_alert_item_trend);
            this.f24632i = (ImageView) view.findViewById(R.id.img_blue_bell);
            this.l = (LinearLayout) view.findViewById(R.id.lyt_price_trend_item);
            this.f24630g = (TextView) view.findViewById(R.id.txt_fare_alert_item_rupee);
            this.m = (RelativeLayout) view.findViewById(R.id.lyt_delete_background);
            this.j = (ImageView) view.findViewById(R.id.delete_icon_left);
            this.k = (ImageView) view.findViewById(R.id.delete_icon_right);
            this.n = (RelativeLayout) view.findViewById(R.id.whole_item_container);
            view.findViewById(R.id.whole_item_container).setOnClickListener(this);
        }

        public final void onClick(View view) {
            d.this.f24621a.a(view, getAdapterPosition());
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_f_flight_fare_alert_home_item, viewGroup, false));
    }
}
