package com.travel.train.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.R;
import com.travel.train.i.t;
import com.travel.train.model.trainticket.CJRBookings;
import com.travel.train.viewholder.ba;
import java.util.List;

public final class aj extends RecyclerView.a<ba> {

    /* renamed from: a  reason: collision with root package name */
    private Context f26223a;

    /* renamed from: b  reason: collision with root package name */
    private t f26224b;

    /* renamed from: c  reason: collision with root package name */
    private List<CJRBookings> f26225c;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        ba baVar = (ba) vVar;
        if (baVar != null) {
            baVar.setIsRecyclable(false);
            if (i2 == 0) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) baVar.f27916a.getLayoutParams();
                layoutParams.setMargins((int) this.f26223a.getResources().getDimension(R.dimen.dimen_15dp), 0, (int) this.f26223a.getResources().getDimension(R.dimen.dimen_15dp), 0);
                baVar.f27916a.setLayoutParams(layoutParams);
            }
            CJRBookings cJRBookings = this.f26225c.get(i2);
            if (cJRBookings != null) {
                if (!TextUtils.isEmpty(cJRBookings.getmBoardingStationCode()) && !TextUtils.isEmpty(cJRBookings.getmBoardingStationName())) {
                    TextView textView = baVar.f27918c;
                    textView.setText(cJRBookings.getmBoardingStationCode() + " - " + cJRBookings.getmBoardingStationName());
                }
                if (!TextUtils.isEmpty(cJRBookings.getmReservationUpToStationCode()) && !TextUtils.isEmpty(cJRBookings.getmReservationUpToStationName())) {
                    TextView textView2 = baVar.f27919d;
                    textView2.setText(cJRBookings.getmReservationUpToStationCode() + " - " + cJRBookings.getmReservationUpToStationName());
                }
                if (!TextUtils.isEmpty(cJRBookings.getTrainName()) && !TextUtils.isEmpty(cJRBookings.getTrainNumber())) {
                    TextView textView3 = baVar.f27920e;
                    textView3.setText(cJRBookings.getTrainName() + " (" + cJRBookings.getTrainNumber() + ")");
                }
                if (!TextUtils.isEmpty(cJRBookings.getmBoardingDate())) {
                    baVar.f27921f.setText(ba.a(cJRBookings.getmBoardingDate()));
                }
                baVar.f27916a.setOnClickListener(new View.OnClickListener(cJRBookings) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ CJRBookings f27924a;

                    {
                        this.f27924a = r2;
                    }

                    public final void onClick(View view) {
                        ba.this.f27917b.a(this.f27924a);
                    }
                });
            }
        }
    }

    public aj(Context context, List<CJRBookings> list, t tVar) {
        this.f26223a = context;
        this.f26224b = tVar;
        this.f26225c = list;
    }

    public final int getItemCount() {
        List<CJRBookings> list = this.f26225c;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final long getItemId(int i2) {
        return super.getItemId(i2);
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new ba(View.inflate(this.f26223a, R.layout.pre_t_lyt_train_ls_upcoming_trip_item, (ViewGroup) null), this.f26223a, this.f26224b);
    }
}
