package com.travel.bus.busticket.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.bus.R;
import com.travel.bus.pojo.busticket.ReferResultItem;
import java.util.ArrayList;

public final class ae extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    private Context f21581a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<ReferResultItem> f21582b;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        ReferResultItem referResultItem = this.f21582b.get(i2);
        if (!TextUtils.isEmpty(referResultItem.getName())) {
            aVar.f21583a.setText(referResultItem.getName());
        }
        if (!TextUtils.isEmpty(referResultItem.getDate()) && !TextUtils.isEmpty(referResultItem.getVertical()) && referResultItem.getVertical().toString().length() > 2) {
            TextView textView = aVar.f21584b;
            textView.setText(referResultItem.getDate() + " (" + referResultItem.getVertical().substring(0, 1).toUpperCase() + referResultItem.getVertical().substring(1) + ")");
        }
        if (referResultItem != null && referResultItem.getAmount() != 0) {
            TextView textView2 = aVar.f21585c;
            textView2.setText(this.f21581a.getResources().getString(R.string.rs) + " " + String.valueOf(referResultItem.getAmount()));
        }
    }

    public ae(Context context, ArrayList<ReferResultItem> arrayList) {
        this.f21581a = context;
        this.f21582b = arrayList;
    }

    public final int getItemCount() {
        return this.f21582b.size();
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f21583a;

        /* renamed from: b  reason: collision with root package name */
        TextView f21584b;

        /* renamed from: c  reason: collision with root package name */
        TextView f21585c;

        public a(View view) {
            super(view);
            this.f21583a = (TextView) view.findViewById(R.id.name);
            this.f21584b = (TextView) view.findViewById(R.id.date);
            this.f21585c = (TextView) view.findViewById(R.id.amount);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_b_view_earnings_item, viewGroup, false));
    }
}
