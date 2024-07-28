package com.travel.bus.busticket.a;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.b;
import com.paytm.utility.n;
import com.paytm.utility.q;
import com.travel.bus.R;
import com.travel.bus.pojo.busticket.CJRBusSearchCancellationPolicy;
import java.util.ArrayList;

public final class g extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    private Context f21650a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<CJRBusSearchCancellationPolicy> f21651b;

    /* renamed from: c  reason: collision with root package name */
    private String f21652c;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        CJRBusSearchCancellationPolicy cJRBusSearchCancellationPolicy = this.f21651b.get(i2);
        if (cJRBusSearchCancellationPolicy != null) {
            aVar.f21653a.setText("");
            aVar.f21655c.setText("");
            if (cJRBusSearchCancellationPolicy.getDeparture_heading() != null) {
                String departure_heading = cJRBusSearchCancellationPolicy.getDeparture_heading();
                if (i2 == 0) {
                    aVar.f21653a.setText(Html.fromHtml("<b>" + departure_heading + "</b>"));
                } else {
                    aVar.f21653a.setText(Html.fromHtml(departure_heading));
                    aVar.f21653a.setTextColor(this.f21650a.getResources().getColor(R.color.color_666666));
                }
            }
            if (cJRBusSearchCancellationPolicy.getPolicy_heading() != null) {
                String policy_heading = cJRBusSearchCancellationPolicy.getPolicy_heading();
                if (i2 == 0) {
                    aVar.f21655c.setText(Html.fromHtml("<b>" + this.f21650a.getString(R.string.refund_percentage_symbol) + "</b>"));
                    if (n.a().equalsIgnoreCase("ml")) {
                        aVar.f21655c.setTextSize(10.0f);
                    }
                } else {
                    aVar.f21655c.setText(Html.fromHtml(policy_heading));
                    aVar.f21655c.setTextColor(this.f21650a.getResources().getColor(R.color.color_666666));
                }
            }
            if (!this.f21652c.equalsIgnoreCase("")) {
                aVar.f21654b.setVisibility(0);
                aVar.f21654b.setText("");
                if (i2 == 0) {
                    aVar.f21654b.setText(Html.fromHtml("<b>" + ("Refund " + this.f21650a.getResources().getString(R.string.rs_symbol)) + "</b>"));
                } else if (cJRBusSearchCancellationPolicy.getPolicy_heading() != null) {
                    aVar.f21654b.setText(a(cJRBusSearchCancellationPolicy.getPolicy_heading()));
                    aVar.f21654b.setTextColor(this.f21650a.getResources().getColor(R.color.color_666666));
                }
            }
        }
    }

    public g(Context context, ArrayList<CJRBusSearchCancellationPolicy> arrayList, double d2) {
        this.f21650a = context;
        this.f21651b = arrayList;
        this.f21652c = b.a((double) ((int) d2), "###,###,###.##");
    }

    public final int getItemCount() {
        ArrayList<CJRBusSearchCancellationPolicy> arrayList = this.f21651b;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final RoboTextView f21653a;

        /* renamed from: b  reason: collision with root package name */
        final RoboTextView f21654b;

        /* renamed from: c  reason: collision with root package name */
        final RoboTextView f21655c;

        public a(View view) {
            super(view);
            this.f21653a = (RoboTextView) view.findViewById(R.id.hours_before_departure);
            this.f21654b = (RoboTextView) view.findViewById(R.id.refund_amnt);
            this.f21655c = (RoboTextView) view.findViewById(R.id.refund_percentage);
        }
    }

    private String a(String str) {
        float f2;
        String str2;
        if (!"Refund Percentage".equalsIgnoreCase(str) && (str2 = this.f21652c) != null && !str2.equalsIgnoreCase("")) {
            this.f21652c = this.f21652c.replaceAll("[\\-\\+\\.\\^:,]", "");
            if (str.matches(".*\\d+.*")) {
                if (str.contains("%")) {
                    str = str.replace("%", "");
                }
                try {
                    f2 = (Float.parseFloat(this.f21652c) * Float.parseFloat(str)) / 100.0f;
                } catch (Exception e2) {
                    q.c(e2.getMessage());
                }
                return String.valueOf(f2);
            }
        }
        f2 = 0.0f;
        return String.valueOf(f2);
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_b_bus_cancellation_item, viewGroup, false));
    }
}
