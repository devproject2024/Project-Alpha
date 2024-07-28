package com.travel.bus.busticket.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.travel.bus.R;
import java.util.List;

public final class ai extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    private List<String> f21607a;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        ((a) vVar).f21608a.setText(this.f21607a.get(i2));
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        public RoboTextView f21608a;

        public a(View view) {
            super(view);
            this.f21608a = (RoboTextView) view.findViewById(R.id.tvTagLabel);
        }
    }

    public ai(List<String> list) {
        this.f21607a = list;
    }

    public final int getItemCount() {
        return this.f21607a.size();
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bus_review_operator_tag_item, viewGroup, false));
    }
}
