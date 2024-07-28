package com.travel.train.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.R;
import com.travel.train.i.v;
import com.travel.train.model.trainticket.CJRBookings;
import com.travel.train.model.trainticket.h;
import com.travel.train.viewholder.bg;
import java.util.ArrayList;

public final class am<T> extends RecyclerView.a<bg> {

    /* renamed from: a  reason: collision with root package name */
    private Context f26243a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<T> f26244b;

    /* renamed from: c  reason: collision with root package name */
    private v f26245c;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        T t;
        bg bgVar = (bg) vVar;
        if (bgVar != null && (t = this.f26244b.get(i2)) != null) {
            if (t instanceof CJRBookings) {
                CJRBookings cJRBookings = (CJRBookings) t;
                if (!TextUtils.isEmpty(cJRBookings.getmPNRNumber())) {
                    bgVar.f27961a.setText(cJRBookings.getmPNRNumber());
                }
                if (!TextUtils.isEmpty(cJRBookings.getmBoardingDate())) {
                    bgVar.f27963c.setText(bg.a(cJRBookings.getmBoardingDate()));
                }
                if (!TextUtils.isEmpty(cJRBookings.getmBoardingStationName()) && !TextUtils.isEmpty(cJRBookings.getmReservationUpToStationName())) {
                    TextView textView = bgVar.f27962b;
                    textView.setText(cJRBookings.getmBoardingStationName() + " to " + cJRBookings.getmReservationUpToStationName());
                }
            } else {
                h hVar = (h) t;
                if (!TextUtils.isEmpty(hVar.getPNRNumber())) {
                    bgVar.f27961a.setText(hVar.getPNRNumber());
                }
                if (!TextUtils.isEmpty(hVar.getDate())) {
                    bgVar.f27963c.setText(bg.a(hVar.getDate()));
                }
                if (!TextUtils.isEmpty(hVar.getFrom()) && !TextUtils.isEmpty(hVar.getTo())) {
                    TextView textView2 = bgVar.f27962b;
                    textView2.setText(hVar.getFrom() + " to " + hVar.getTo());
                }
            }
            bgVar.f27964d.setOnClickListener(new View.OnClickListener(t) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ Object f27968a;

                {
                    this.f27968a = r2;
                }

                public final void onClick(View view) {
                    bg.this.f27965e.a(this.f27968a);
                }
            });
        }
    }

    public am(Context context, ArrayList<T> arrayList, v vVar) {
        this.f26243a = context;
        this.f26244b = arrayList;
        this.f26245c = vVar;
    }

    public final int getItemCount() {
        ArrayList<T> arrayList = this.f26244b;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public final long getItemId(int i2) {
        return super.getItemId(i2);
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new bg(this.f26243a, this.f26245c, View.inflate(this.f26243a, R.layout.pre_t_lyt_train_search_pnr_item, (ViewGroup) null));
    }
}
