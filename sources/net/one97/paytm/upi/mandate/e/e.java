package net.one97.paytm.upi.mandate.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.f;
import net.one97.paytm.upi.mandate.data.model.MandateTimeLineItem;
import net.one97.paytm.upi.mandate.utils.c;
import net.one97.paytm.upi.util.UpiUtils;

public final class e extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    final ArrayList<MandateTimeLineItem> f67175a = new ArrayList<>();

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        MandateTimeLineItem mandateTimeLineItem = this.f67175a.get(i2);
        k.a((Object) mandateTimeLineItem, "itemList[position]");
        MandateTimeLineItem mandateTimeLineItem2 = mandateTimeLineItem;
        k.c(mandateTimeLineItem2, "item");
        aVar.f67176a.setText(mandateTimeLineItem2.getMessage());
        aVar.f67177b.setText(UpiUtils.getMandateFormattedDate(mandateTimeLineItem2.getDate()));
        if (aVar.getAdapterPosition() == aVar.f67182g.f67175a.size() - 1) {
            aVar.f67179d.setVisibility(8);
        } else {
            aVar.f67179d.setVisibility(0);
        }
        if (aVar.getAdapterPosition() == 0) {
            aVar.f67180e.setVisibility(8);
        } else {
            aVar.f67180e.setVisibility(0);
        }
        if (mandateTimeLineItem2.getSubtext() == null) {
            f.a((View) aVar.f67181f);
        } else {
            f.b((View) aVar.f67181f);
            aVar.f67181f.setText(mandateTimeLineItem2.getSubtext());
        }
        String status = mandateTimeLineItem2.getStatus();
        if (k.a((Object) status, (Object) c.PENDING.getType())) {
            aVar.f67176a.setTextColor(f.c("#f5a109"));
            aVar.f67178c.setImageResource(R.drawable.circle_filled_yellow);
        } else if (k.a((Object) status, (Object) c.SUCCESS.getType())) {
            aVar.f67176a.setTextColor(f.c("#222222"));
            aVar.f67178c.setImageResource(R.drawable.circle_filled_b8c2cb);
        } else if (k.a((Object) status, (Object) c.FAILURE.getType())) {
            aVar.f67178c.setImageResource(R.drawable.circle_filled_red);
            aVar.f67176a.setTextColor(f.c("#ff585d"));
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mandate_timeline_item, viewGroup, false);
        k.a((Object) inflate, "view");
        return new a(this, inflate);
    }

    public final int getItemCount() {
        return this.f67175a.size();
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f67176a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f67177b;

        /* renamed from: c  reason: collision with root package name */
        final ImageView f67178c;

        /* renamed from: d  reason: collision with root package name */
        final View f67179d;

        /* renamed from: e  reason: collision with root package name */
        final View f67180e;

        /* renamed from: f  reason: collision with root package name */
        final TextView f67181f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ e f67182g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(e eVar, View view) {
            super(view);
            k.c(view, "view");
            this.f67182g = eVar;
            View findViewById = view.findViewById(R.id.tvTitle);
            k.a((Object) findViewById, "view.findViewById(R.id.tvTitle)");
            this.f67176a = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.tvDate);
            k.a((Object) findViewById2, "view.findViewById(R.id.tvDate)");
            this.f67177b = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.ivStatusIcon);
            k.a((Object) findViewById3, "view.findViewById(R.id.ivStatusIcon)");
            this.f67178c = (ImageView) findViewById3;
            View findViewById4 = view.findViewById(R.id.ivBottomLine);
            k.a((Object) findViewById4, "view.findViewById(R.id.ivBottomLine)");
            this.f67179d = findViewById4;
            View findViewById5 = view.findViewById(R.id.ivTopLine);
            k.a((Object) findViewById5, "view.findViewById(R.id.ivTopLine)");
            this.f67180e = findViewById5;
            View findViewById6 = view.findViewById(R.id.subtext);
            k.a((Object) findViewById6, "view.findViewById(R.id.subtext)");
            this.f67181f = (TextView) findViewById6;
        }
    }
}
