package com.travel.bus.busticket.a;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.bus.R;
import com.travel.bus.busticket.a.q;
import com.travel.bus.busticket.b.c;
import com.travel.bus.model.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;

public final class q extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    Context f21738a;

    /* renamed from: b  reason: collision with root package name */
    c f21739b;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<b> f21740c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private Activity f21741d;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        ArrayList<b> arrayList = this.f21740c;
        if (arrayList != null && arrayList.size() > 0) {
            aVar.a(this.f21740c.get(i2), i2);
        }
    }

    public q(Activity activity, List<b> list) {
        if (activity != null) {
            this.f21741d = activity;
            this.f21738a = activity;
            this.f21740c.add(new b(AppConstants.FOR_ALL, "", false, true));
            this.f21740c.addAll(list);
            this.f21739b = (c) this.f21741d;
        }
    }

    public final void a(boolean z, String str) {
        if (z && this.f21740c != null) {
            for (int i2 = 0; i2 < this.f21740c.size(); i2++) {
                b bVar = this.f21740c.get(i2);
                if (bVar.f22545c) {
                    if (bVar.f22544b.equals(str)) {
                        bVar.f22546d = true;
                    } else {
                        bVar.f22546d = false;
                    }
                } else if (bVar.f22543a.equals(str)) {
                    bVar.f22546d = true;
                } else {
                    bVar.f22546d = false;
                }
            }
        } else if (this.f21740c != null) {
            for (int i3 = 0; i3 < this.f21740c.size(); i3++) {
                if (i3 == 0) {
                    this.f21740c.get(0).f22546d = true;
                } else {
                    this.f21740c.get(i3).f22546d = false;
                }
            }
        }
        notifyDataSetChanged();
    }

    public final int getItemCount() {
        return this.f21740c.size();
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f21742a;

        /* renamed from: b  reason: collision with root package name */
        String f21743b;

        /* renamed from: c  reason: collision with root package name */
        LinearLayout f21744c;

        public a(View view) {
            super(view);
            this.f21742a = (TextView) view.findViewById(R.id.bus_ticket_price);
            this.f21744c = (LinearLayout) view.findViewById(R.id.bus_ticket_price_layout);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(int i2, View view) {
            for (int i3 = 0; i3 < q.this.f21740c.size(); i3++) {
                q.this.f21740c.get(i3).f22546d = false;
            }
            q.this.f21740c.get(i2).f22546d = true;
            q qVar = q.this;
            String str = this.f21743b;
            HashMap hashMap = new HashMap();
            hashMap.put("price_range", str);
            hashMap.put("user_id", com.paytm.utility.b.n(qVar.f21738a));
            com.travel.bus.a.a();
            com.travel.bus.a.b().a("bus_seat_price_range_clicked", (Map<String, Object>) hashMap, qVar.f21738a);
            q.this.notifyDataSetChanged();
            if (q.this.f21739b != null && !TextUtils.isEmpty(this.f21743b)) {
                q.this.f21739b.a(this.f21743b);
            }
        }

        public final void a(b bVar, int i2) {
            Spanned spanned;
            this.f21743b = bVar.f22543a;
            TextView textView = this.f21742a;
            if (k.a((Object) bVar.f22543a, (Object) AppConstants.FOR_ALL)) {
                spanned = Html.fromHtml(bVar.f22543a);
                k.a((Object) spanned, "Html.fromHtml(price)");
            } else if (k.a((Object) bVar.f22544b, (Object) "") || k.a((Object) bVar.f22544b, (Object) "0")) {
                StringBuilder sb = new StringBuilder("₹ ");
                String str = bVar.f22543a;
                if (str == null) {
                    k.a();
                }
                sb.append(b.a(str));
                spanned = Html.fromHtml(sb.toString());
                k.a((Object) spanned, "Html.fromHtml(\"₹ \" + formatDecimal(price!!))");
            } else {
                StringBuilder sb2 = new StringBuilder("₹ ");
                String str2 = bVar.f22544b;
                if (str2 == null) {
                    k.a();
                }
                sb2.append(b.a(str2));
                String sb3 = sb2.toString();
                StringBuilder sb4 = new StringBuilder("  ₹ ");
                String str3 = bVar.f22543a;
                if (str3 == null) {
                    k.a();
                }
                sb4.append(b.a(str3));
                spanned = b.a(sb3, sb4.toString());
            }
            textView.setText(spanned);
            if (q.this.f21740c.get(i2).f22546d) {
                this.f21742a.setTextColor(q.this.f21738a.getResources().getColor(R.color.color_00b9f5));
                this.f21744c.setBackgroundResource(R.drawable.travel_res_bus_price_filter_selected);
            } else {
                this.f21742a.setTextColor(q.this.f21738a.getResources().getColor(R.color.color_8c8c8c));
                this.f21744c.setBackgroundResource(R.drawable.travel_res_bus_price_filter_unselected_background);
            }
            this.f21744c.setOnClickListener(new View.OnClickListener(i2) {
                private final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    q.a.this.a(this.f$1, view);
                }
            });
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(this.f21738a).inflate(R.layout.pre_b_bus_filter_seat_layout, (ViewGroup) null));
    }
}
