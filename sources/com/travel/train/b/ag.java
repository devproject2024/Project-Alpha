package com.travel.train.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.b;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.R;
import com.travel.train.i.s;
import com.travel.train.model.trainticket.CJRTrainLsDateModel;
import com.travel.train.viewholder.ay;
import java.util.ArrayList;

public final class ag extends RecyclerView.a<ay> {

    /* renamed from: a  reason: collision with root package name */
    public Context f26206a;

    /* renamed from: b  reason: collision with root package name */
    public ay f26207b;

    /* renamed from: c  reason: collision with root package name */
    private s f26208c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<CJRTrainLsDateModel> f26209d;

    /* renamed from: e  reason: collision with root package name */
    private int f26210e;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        ay ayVar = (ay) vVar;
        boolean z = i2 == this.f26210e;
        CJRTrainLsDateModel cJRTrainLsDateModel = this.f26209d.get(i2);
        if (cJRTrainLsDateModel != null) {
            if (z) {
                ayVar.f27895c.a(cJRTrainLsDateModel, ayVar);
                ayVar.f27893a.setBackground(b.a(ayVar.f27894b, R.drawable.pre_t_train_blue_border_with_corner_radius));
                ayVar.f27896d.setTextColor(ayVar.f27894b.getResources().getColor(R.color.black));
                ayVar.f27897e.setTextColor(ayVar.f27894b.getResources().getColor(R.color.black));
            }
            if (!TextUtils.isEmpty(cJRTrainLsDateModel.getValue1())) {
                ayVar.f27896d.setText(cJRTrainLsDateModel.getValue1());
            }
            if (!TextUtils.isEmpty(cJRTrainLsDateModel.getValue2())) {
                if (cJRTrainLsDateModel.isToday()) {
                    ayVar.f27897e.setText("Today");
                } else if (cJRTrainLsDateModel.isTomorrow()) {
                    ayVar.f27897e.setText("Tomorrow");
                } else {
                    ayVar.f27897e.setText(cJRTrainLsDateModel.getValue2());
                }
            }
            ayVar.f27893a.setOnClickListener(new View.OnClickListener(cJRTrainLsDateModel) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ CJRTrainLsDateModel f27898a;

                {
                    this.f27898a = r2;
                }

                public final void onClick(View view) {
                    ay.this.f27895c.a(this.f27898a, ay.this);
                    ay.this.f27893a.setBackground(b.a(ay.this.f27894b, R.drawable.pre_t_train_blue_border_with_corner_radius));
                    ay.this.f27896d.setTextColor(ay.this.f27894b.getResources().getColor(R.color.black));
                    ay.this.f27897e.setTextColor(ay.this.f27894b.getResources().getColor(R.color.black));
                }
            });
        }
    }

    public ag(Context context, ArrayList<CJRTrainLsDateModel> arrayList, int i2, s sVar) {
        this.f26206a = context;
        this.f26208c = sVar;
        this.f26209d = arrayList;
        this.f26210e = i2;
    }

    public final int getItemCount() {
        return this.f26209d.size();
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_t_lyt_train_ls_dates_item, viewGroup, false);
        int a2 = com.paytm.utility.b.a((Activity) this.f26206a) - ((int) this.f26206a.getResources().getDimension(R.dimen.dimen_30dp));
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        layoutParams.width = a2 / 4;
        inflate.setLayoutParams(layoutParams);
        return new ay(inflate, this.f26206a, this.f26208c);
    }
}
