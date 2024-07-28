package com.travel.travelPreferences;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.q;
import com.travel.R;
import com.travel.cdn.ResourceUtils;
import com.travel.travelPreferences.CJRViewFareAlerts;
import com.travel.utils.n;
import com.travel.utils.p;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public final class d extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    private static String f28407a = "CJRFareAlertListAdapter";

    /* renamed from: b  reason: collision with root package name */
    private List<CJRViewFareAlerts.a> f28408b;

    /* renamed from: c  reason: collision with root package name */
    private Context f28409c;

    /* renamed from: d  reason: collision with root package name */
    private b f28410d;

    public interface b {
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        String str;
        a aVar = (a) vVar;
        CJRViewFareAlerts.a aVar2 = this.f28408b.get(i2);
        String a2 = a(aVar2.getDoj(), "dd MMM yyyy", "E, dd MMM yy");
        aVar.f28411a.setText(aVar2.getSource());
        aVar.f28412b.setText(aVar2.getDestination());
        aVar.f28413c.setText(a2);
        if (aVar2.getTrend() != null) {
            aVar.k.setVisibility(0);
            aVar.f28414d.setText(p.j(aVar2.getTrend().getCurrent_fare()));
            aVar.f28415e.setText(p.j(aVar2.getTrend().getDelta().replace("-", "")));
            TextView textView = aVar.f28416f;
            String days = aVar2.getTrend().getDays();
            if (days.equals("1")) {
                str = String.format(this.f28409c.getString(R.string.in_last_day), new Object[]{days});
            } else {
                str = String.format(this.f28409c.getString(R.string.in_last_days), new Object[]{days});
            }
            textView.setText(str);
            if (aVar2.getTrend().getTrend().equals("increased")) {
                aVar.f28418h.setImageResource(R.drawable.arrow_up_trend);
                aVar.f28415e.setTextColor(androidx.core.content.b.c(this.f28409c, R.color.color_fd5c5c));
                aVar.f28417g.setTextColor(androidx.core.content.b.c(this.f28409c, R.color.color_fd5c5c));
                return;
            }
            aVar.f28418h.setImageResource(R.drawable.arrow_down_trend);
            aVar.f28415e.setTextColor(androidx.core.content.b.c(this.f28409c, R.color.green_fare_alert));
            aVar.f28417g.setTextColor(androidx.core.content.b.c(this.f28409c, R.color.green_fare_alert));
            return;
        }
        aVar.k.setVisibility(4);
    }

    public d(Context context, b bVar, List<CJRViewFareAlerts.a> list) {
        this.f28408b = list;
        this.f28409c = context;
        this.f28410d = bVar;
    }

    public final int getItemCount() {
        return this.f28408b.size();
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f28411a;

        /* renamed from: b  reason: collision with root package name */
        TextView f28412b;

        /* renamed from: c  reason: collision with root package name */
        TextView f28413c;

        /* renamed from: d  reason: collision with root package name */
        TextView f28414d;

        /* renamed from: e  reason: collision with root package name */
        TextView f28415e;

        /* renamed from: f  reason: collision with root package name */
        TextView f28416f;

        /* renamed from: g  reason: collision with root package name */
        TextView f28417g;

        /* renamed from: h  reason: collision with root package name */
        ImageView f28418h;

        /* renamed from: i  reason: collision with root package name */
        ImageView f28419i;
        RelativeLayout j;
        LinearLayout k;
        public RelativeLayout l;
        public RelativeLayout m;

        public a(View view) {
            super(view);
            this.f28411a = (TextView) view.findViewById(R.id.flight_recent_tab_source_city_name);
            this.f28412b = (TextView) view.findViewById(R.id.flight_recent_tab_destination_city_name);
            this.f28413c = (TextView) view.findViewById(R.id.flight_recent_tab_date_of_travel);
            this.f28414d = (TextView) view.findViewById(R.id.txt_fare_alert_item_price);
            this.f28419i = (ImageView) view.findViewById(R.id.flight_recent_tab_image_view_junry_type);
            ResourceUtils.loadTCoreImagesFromCDN(this.f28419i, "flight_one_way_right_arrow.png", false, true, n.a.V1);
            this.f28415e = (TextView) view.findViewById(R.id.txt_fare_alert_item_trend_price);
            this.f28416f = (TextView) view.findViewById(R.id.txt_fare_alert_item_duration);
            this.f28418h = (ImageView) view.findViewById(R.id.img_fare_alert_item_trend);
            this.j = (RelativeLayout) view.findViewById(R.id.whole_item_container);
            this.k = (LinearLayout) view.findViewById(R.id.lyt_price_trend_item);
            this.f28417g = (TextView) view.findViewById(R.id.txt_fare_alert_item_rupee);
            this.l = (RelativeLayout) view.findViewById(R.id.lyt_delete_background);
            this.m = (RelativeLayout) view.findViewById(R.id.whole_item_container);
        }
    }

    private static String a(String str, String str2, String str3) {
        try {
            return new SimpleDateFormat(str3).format(new SimpleDateFormat(str2, Locale.ENGLISH).parse(str));
        } catch (ParseException e2) {
            if (com.paytm.utility.b.v) {
                q.c(e2.getMessage());
            }
            return "";
        } catch (Exception e3) {
            if (com.paytm.utility.b.v) {
                q.c(e3.getMessage());
            }
            return "";
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.flight_fare_alert_list_item, viewGroup, false));
    }
}
