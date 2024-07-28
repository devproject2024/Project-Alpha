package net.one97.paytm.feed.ui.feed.o;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.f.a.e;

public final class c extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    private final List<e> f35167a;

    public c(List<e> list) {
        k.c(list, "paxList");
        this.f35167a = list;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        CharSequence charSequence;
        CharSequence charSequence2;
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        if (i2 != -1) {
            e eVar = this.f35167a.get(i2);
            k.c(eVar, "paxInfo");
            aVar.f35168a.setText(eVar.getPassengerName());
            TextView textView = aVar.f35169b;
            if (TextUtils.isEmpty(eVar.getCurrentBerthNo())) {
                charSequence = "NA";
            } else {
                charSequence = eVar.getCurrentBerthNo();
            }
            textView.setText(charSequence);
            TextView textView2 = aVar.f35170c;
            if (!TextUtils.isEmpty(eVar.getCurrentCoachId())) {
                charSequence2 = eVar.getCurrentCoachId();
            }
            textView2.setText(charSequence2);
            aVar.f35171d.setText(eVar.getCurrentStatus());
            String currentStatus = eVar.getCurrentStatus();
            if (currentStatus == null || !p.a((CharSequence) currentStatus, (CharSequence) "CAN", true)) {
                String currentStatus2 = eVar.getCurrentStatus();
                if (currentStatus2 == null || !p.a((CharSequence) currentStatus2, (CharSequence) "WL", true)) {
                    String currentStatus3 = eVar.getCurrentStatus();
                    if (currentStatus3 == null || !p.a((CharSequence) currentStatus3, (CharSequence) "RAC", true)) {
                        aVar.f35171d.setBackgroundResource(R.drawable.feed_rectangle_green);
                    } else {
                        aVar.f35171d.setBackgroundResource(R.drawable.feed_rectangle_orange);
                    }
                } else {
                    aVar.f35171d.setBackgroundResource(R.drawable.feed_rectangle_orange);
                }
            } else {
                aVar.f35171d.setBackgroundResource(R.drawable.feed_rectangle_red);
            }
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        com.google.android.play.core.splitcompat.a.a(viewGroup.getContext());
        com.google.android.play.core.splitcompat.a.b(viewGroup.getContext());
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.feed_item_train_passenger_detail, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(pare…, false\n                )");
        return new a(inflate);
    }

    public final int getItemCount() {
        return this.f35167a.size();
    }

    public static final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f35168a;

        /* renamed from: b  reason: collision with root package name */
        TextView f35169b;

        /* renamed from: c  reason: collision with root package name */
        TextView f35170c;

        /* renamed from: d  reason: collision with root package name */
        TextView f35171d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            k.c(view, "view");
            View findViewById = view.findViewById(R.id.travellerName);
            if (findViewById == null) {
                k.a();
            }
            this.f35168a = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.berth);
            if (findViewById2 == null) {
                k.a();
            }
            this.f35169b = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.coach);
            if (findViewById3 == null) {
                k.a();
            }
            this.f35170c = (TextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.status);
            if (findViewById4 == null) {
                k.a();
            }
            this.f35171d = (TextView) findViewById4;
        }
    }
}
