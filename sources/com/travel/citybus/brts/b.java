package com.travel.citybus.brts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.citybus.R;
import com.travel.citybus.best.model.BestRecentTickets;
import java.util.List;
import kotlin.g.b.k;

public final class b extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f23182a;

    /* renamed from: b  reason: collision with root package name */
    private final List<BestRecentTickets> f23183b;

    public b(Context context, List<? extends BestRecentTickets> list) {
        k.c(context, "context");
        k.c(list, "recentTickets");
        this.f23182a = context;
        this.f23183b = list;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        BestRecentTickets bestRecentTickets = this.f23183b.get(i2);
        k.c(bestRecentTickets, "recentTicket");
        aVar.f23184a.setText(bestRecentTickets.getRouteName());
        aVar.f23185b.setText(com.paytm.utility.b.a("dd MMM yyyy", String.valueOf(bestRecentTickets.getTokenIssuanceDatetime().longValue())));
        aVar.f23186c.setVisibility(4);
        aVar.f23187d.setText(bestRecentTickets.getSourceName());
        aVar.f23188e.setText(bestRecentTickets.getDestinationName());
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f23182a).inflate(R.layout.best_recent_orders, viewGroup, false);
        if (inflate == null) {
            k.a();
        }
        return new a(this, inflate);
    }

    public final int getItemCount() {
        return this.f23183b.size();
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f23184a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f23185b;

        /* renamed from: c  reason: collision with root package name */
        final TextView f23186c;

        /* renamed from: d  reason: collision with root package name */
        final TextView f23187d;

        /* renamed from: e  reason: collision with root package name */
        final TextView f23188e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ b f23189f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(b bVar, View view) {
            super(view);
            k.c(view, "itemView");
            this.f23189f = bVar;
            View findViewById = view.findViewById(R.id.bus_name);
            k.a((Object) findViewById, "itemView.findViewById(R.id.bus_name)");
            this.f23184a = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.booking_date);
            k.a((Object) findViewById2, "itemView.findViewById(R.id.booking_date)");
            this.f23185b = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.txt_ac);
            k.a((Object) findViewById3, "itemView.findViewById(R.id.txt_ac)");
            this.f23186c = (TextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.txt_from);
            k.a((Object) findViewById4, "itemView.findViewById(R.id.txt_from)");
            this.f23187d = (TextView) findViewById4;
            View findViewById5 = view.findViewById(R.id.txt_to);
            k.a((Object) findViewById5, "itemView.findViewById(R.id.txt_to)");
            this.f23188e = (TextView) findViewById5;
        }
    }
}
