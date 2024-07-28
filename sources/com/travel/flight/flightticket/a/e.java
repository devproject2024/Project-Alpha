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
import com.travel.flight.pojo.flightticket.CJRViewFareAlerts;
import com.travel.utils.n;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public final class e extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    private List<CJRViewFareAlerts.a> f24633a;

    /* renamed from: b  reason: collision with root package name */
    private Context f24634b;

    /* renamed from: c  reason: collision with root package name */
    private b f24635c;

    public interface b {
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        String str;
        a aVar = (a) vVar;
        CJRViewFareAlerts.a aVar2 = this.f24633a.get(i2);
        String a2 = a(aVar2.getDoj(), "dd MMM yyyy", "E, dd MMM yy");
        aVar.f24636a.setText(aVar2.getSource());
        aVar.f24637b.setText(aVar2.getDestination());
        aVar.f24638c.setText(a2);
        if (aVar2.getTrend() != null) {
            aVar.k.setVisibility(0);
            aVar.f24639d.setText(net.one97.paytmflight.common.b.a.a(aVar2.getTrend().getCurrent_fare()));
            aVar.f24640e.setText(net.one97.paytmflight.common.b.a.a(aVar2.getTrend().getDelta().replace("-", "")));
            TextView textView = aVar.f24641f;
            String days = aVar2.getTrend().getDays();
            if (days.equals("1")) {
                str = String.format(this.f24634b.getString(R.string.in_last_day), new Object[]{days});
            } else {
                str = String.format(this.f24634b.getString(R.string.in_last_days), new Object[]{days});
            }
            textView.setText(str);
            if (aVar2.getTrend().getTrend().equals("increased")) {
                aVar.f24643h.setImageResource(R.drawable.pre_f_arrow_up_trend);
                aVar.f24640e.setTextColor(androidx.core.content.b.c(this.f24634b, R.color.color_fd5c5c));
                aVar.f24642g.setTextColor(androidx.core.content.b.c(this.f24634b, R.color.color_fd5c5c));
            } else {
                aVar.f24643h.setImageResource(R.drawable.pre_f_arrow_down_trend);
                aVar.f24640e.setTextColor(androidx.core.content.b.c(this.f24634b, R.color.green_fare_alert));
                aVar.f24642g.setTextColor(androidx.core.content.b.c(this.f24634b, R.color.green_fare_alert));
            }
        } else {
            aVar.k.setVisibility(4);
        }
        ResourceUtils.loadFlightImagesFromCDN(aVar.f24644i, "dustbin.png", false, false, n.a.V1);
    }

    public e(Context context, b bVar, List<CJRViewFareAlerts.a> list) {
        this.f24633a = list;
        this.f24634b = context;
        this.f24635c = bVar;
    }

    public final int getItemCount() {
        return this.f24633a.size();
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f24636a;

        /* renamed from: b  reason: collision with root package name */
        TextView f24637b;

        /* renamed from: c  reason: collision with root package name */
        TextView f24638c;

        /* renamed from: d  reason: collision with root package name */
        TextView f24639d;

        /* renamed from: e  reason: collision with root package name */
        TextView f24640e;

        /* renamed from: f  reason: collision with root package name */
        TextView f24641f;

        /* renamed from: g  reason: collision with root package name */
        TextView f24642g;

        /* renamed from: h  reason: collision with root package name */
        ImageView f24643h;

        /* renamed from: i  reason: collision with root package name */
        ImageView f24644i;
        RelativeLayout j;
        LinearLayout k;
        public RelativeLayout l;
        public RelativeLayout m;

        public a(View view) {
            super(view);
            this.f24636a = (TextView) view.findViewById(R.id.flight_recent_tab_source_city_name);
            this.f24637b = (TextView) view.findViewById(R.id.flight_recent_tab_destination_city_name);
            this.f24638c = (TextView) view.findViewById(R.id.flight_recent_tab_date_of_travel);
            this.f24639d = (TextView) view.findViewById(R.id.txt_fare_alert_item_price);
            this.f24640e = (TextView) view.findViewById(R.id.txt_fare_alert_item_trend_price);
            this.f24641f = (TextView) view.findViewById(R.id.txt_fare_alert_item_duration);
            this.f24643h = (ImageView) view.findViewById(R.id.img_fare_alert_item_trend);
            this.j = (RelativeLayout) view.findViewById(R.id.whole_item_container);
            this.k = (LinearLayout) view.findViewById(R.id.lyt_price_trend_item);
            this.f24642g = (TextView) view.findViewById(R.id.txt_fare_alert_item_rupee);
            this.l = (RelativeLayout) view.findViewById(R.id.lyt_delete_background);
            this.m = (RelativeLayout) view.findViewById(R.id.whole_item_container);
            this.f24644i = (ImageView) view.findViewById(R.id.delete_icon);
        }
    }

    private static String a(String str, String str2, String str3) {
        try {
            return new SimpleDateFormat(str3).format(new SimpleDateFormat(str2, Locale.ENGLISH).parse(str));
        } catch (ParseException unused) {
            boolean z = com.paytm.utility.b.v;
            return "";
        } catch (Exception unused2) {
            boolean z2 = com.paytm.utility.b.v;
            return "";
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_f_flight_fare_alert_list_item, viewGroup, false));
    }
}
