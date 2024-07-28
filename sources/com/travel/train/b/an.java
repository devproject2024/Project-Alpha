package com.travel.train.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.R;
import com.travel.train.i.t;
import com.travel.train.model.trainticket.CJRBookings;
import com.travel.train.viewholder.bh;
import java.util.List;

public final class an extends RecyclerView.a<bh> {

    /* renamed from: a  reason: collision with root package name */
    private Context f26246a;

    /* renamed from: b  reason: collision with root package name */
    private t f26247b;

    /* renamed from: c  reason: collision with root package name */
    private List<CJRBookings> f26248c;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        bh bhVar = (bh) vVar;
        if (bhVar != null) {
            bhVar.setIsRecyclable(false);
            CJRBookings cJRBookings = this.f26248c.get(i2);
            if (cJRBookings != null) {
                if (!TextUtils.isEmpty(cJRBookings.getmBoardingStationCode()) && !TextUtils.isEmpty(cJRBookings.getmReservationUpToStationName())) {
                    TextView textView = bhVar.f27972c;
                    textView.setText(cJRBookings.getmBoardingStationName() + " to " + cJRBookings.getmReservationUpToStationName());
                }
                if (!TextUtils.isEmpty(cJRBookings.getmBoardingDate())) {
                    bhVar.f27973d.setText(bh.a(cJRBookings.getmBoardingDate()));
                }
                bhVar.f27970a.setOnClickListener(new View.OnClickListener(cJRBookings) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ CJRBookings f27976a;

                    {
                        this.f27976a = r2;
                    }

                    public final void onClick(View view) {
                        bh.this.f27971b.a(this.f27976a);
                    }
                });
            }
        }
    }

    public an(Context context, List<CJRBookings> list, t tVar) {
        this.f26246a = context;
        this.f26247b = tVar;
        this.f26248c = list;
    }

    public final int getItemCount() {
        List<CJRBookings> list = this.f26248c;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final long getItemId(int i2) {
        return super.getItemId(i2);
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new bh(View.inflate(this.f26246a, R.layout.pre_t_lyt_train_pnr_upcoming_trip_item, (ViewGroup) null), this.f26246a, this.f26247b);
    }
}
