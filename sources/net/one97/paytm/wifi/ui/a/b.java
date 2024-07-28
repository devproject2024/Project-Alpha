package net.one97.paytm.wifi.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.g.b.k;
import kotlin.x;
import net.one97.paytm.wifi.R;
import net.one97.paytm.wifi.models.WifiPlan;
import net.one97.paytm.wifi.models.WifiTimeData;
import net.one97.paytm.wifi.ui.b.c;

public final class b extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    final Context f21263a;

    /* renamed from: b  reason: collision with root package name */
    final List<WifiPlan> f21264b;

    /* renamed from: c  reason: collision with root package name */
    final kotlin.g.a.b<WifiPlan, x> f21265c;

    /* renamed from: d  reason: collision with root package name */
    private final LayoutInflater f21266d = LayoutInflater.from(this.f21263a);

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        String str;
        String str2;
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        WifiPlan wifiPlan = this.f21264b.get(i2);
        k.c(wifiPlan, "plan");
        TextView textView = aVar.f21267a;
        Context context = aVar.f21271e.f21263a;
        k.c(wifiPlan, "receiver$0");
        k.c(context, "context");
        if (k.a((Object) "free", (Object) wifiPlan.getType())) {
            str = "Free";
        } else {
            str = context.getString(R.string.rs_symbols) + ' ' + wifiPlan.getPrice();
        }
        textView.setText(str);
        String a2 = c.a(wifiPlan);
        WifiTimeData a3 = c.a(wifiPlan.getDuration());
        String str3 = a3.getDay() > 1 ? "days" : "day";
        String str4 = a3.getHour() > 1 ? "hours" : "hour";
        String str5 = a3.getMinute() > 1 ? "minutes" : "minute";
        if (a3.getDay() > 0) {
            if (a3.getHour() > 0) {
                aVar.f21268b.setText(a2 + " for " + a3.getDay() + ' ' + str3 + ' ' + a3.getHour() + ' ' + str4);
            } else {
                aVar.f21268b.setText(a2 + " for " + a3.getDay() + ' ' + str3);
            }
        } else if (a3.getHour() <= 0) {
            aVar.f21268b.setText(a2 + " for " + a3.getMinute() + ' ' + str5);
        } else if (a3.getMinute() > 0) {
            aVar.f21268b.setText(a2 + " for " + a3.getHour() + ' ' + str4 + ' ' + a3.getMinute() + ' ' + str5);
        } else {
            aVar.f21268b.setText(a2 + " for " + a3.getHour() + ' ' + str4);
        }
        TextView textView2 = aVar.f21269c;
        k.c(wifiPlan, "receiver$0");
        if (wifiPlan.getDownloadRate() == 0) {
            str2 = "";
        } else {
            str2 = (wifiPlan.getDownloadRate() / 1024) + ".00 Mb/s";
        }
        textView2.setText(str2);
        aVar.f21270d.setText("Max 2 device allowed");
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = this.f21266d.inflate(R.layout.item_wifi_plan, (ViewGroup) null, false);
        k.a((Object) inflate, "inflater.inflate(R.layou…m_wifi_plan, null, false)");
        return new a(this, inflate);
    }

    public b(Context context, List<WifiPlan> list, kotlin.g.a.b<? super WifiPlan, x> bVar) {
        k.c(context, "context");
        k.c(list, "planList");
        k.c(bVar, "onPlanSelectListener");
        this.f21263a = context;
        this.f21264b = list;
        this.f21265c = bVar;
    }

    public final int getItemCount() {
        return this.f21264b.size();
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f21267a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f21268b;

        /* renamed from: c  reason: collision with root package name */
        final TextView f21269c;

        /* renamed from: d  reason: collision with root package name */
        final TextView f21270d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ b f21271e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(b bVar, View view) {
            super(view);
            k.c(view, "itemView");
            this.f21271e = bVar;
            View findViewById = view.findViewById(R.id.priceTv);
            k.a((Object) findViewById, "itemView.findViewById(R.id.priceTv)");
            this.f21267a = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.tvTitle);
            k.a((Object) findViewById2, "itemView.findViewById(R.id.tvTitle)");
            this.f21268b = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.speedTv);
            k.a((Object) findViewById3, "itemView.findViewById(R.id.speedTv)");
            this.f21269c = (TextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.connectedDeviceTv);
            k.a((Object) findViewById4, "itemView.findViewById(R.id.connectedDeviceTv)");
            this.f21270d = (TextView) findViewById4;
            this.f21267a.setOnClickListener(new View.OnClickListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ a f21272a;

                {
                    this.f21272a = r1;
                }

                public final void onClick(View view) {
                    this.f21272a.f21271e.f21265c.invoke(this.f21272a.f21271e.f21264b.get(this.f21272a.getAdapterPosition()));
                }
            });
        }
    }
}
