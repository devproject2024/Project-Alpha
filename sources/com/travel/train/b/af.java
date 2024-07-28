package com.travel.train.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.travel.train.R;
import com.travel.train.i.n;
import com.travel.train.model.trainticket.CJRTrainLSSearchResult;
import com.travel.train.viewholder.ax;
import java.util.List;

public final class af extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Context f26203a;

    /* renamed from: b  reason: collision with root package name */
    private List<CJRTrainLSSearchResult.Schedule> f26204b;

    /* renamed from: c  reason: collision with root package name */
    private n f26205c;

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public af(Context context, List<CJRTrainLSSearchResult.Schedule> list, n nVar) {
        this.f26203a = context;
        this.f26204b = list;
        this.f26205c = nVar;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        ax axVar;
        if (view == null) {
            view = LayoutInflater.from(this.f26203a).inflate(R.layout.pre_t_search_by_train_booking_bs_adapter_item, viewGroup, false);
            view.setPadding(0, (int) this.f26203a.getResources().getDimension(R.dimen.dimen_25dp), 0, 0);
            axVar = new ax(this.f26203a, this.f26205c, view);
            view.setTag(axVar);
        } else {
            axVar = (ax) view.getTag();
        }
        List<CJRTrainLSSearchResult.Schedule> list = this.f26204b;
        if (!(list == null || list.size() <= 0 || this.f26204b.get(i2) == null)) {
            CJRTrainLSSearchResult.Schedule schedule = this.f26204b.get(i2);
            if (!TextUtils.isEmpty(schedule.getStationCode())) {
                axVar.f27886a.setText(schedule.getStationCode());
            }
            if (!TextUtils.isEmpty(schedule.getStationName())) {
                axVar.f27887b.setText(schedule.getStationName());
            }
            axVar.f27888c.setOnClickListener(new View.OnClickListener(schedule) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ CJRTrainLSSearchResult.Schedule f27891a;

                {
                    this.f27891a = r2;
                }

                public final void onClick(View view) {
                    ax.this.f27889d.a(this.f27891a);
                }
            });
        }
        return view;
    }

    public final int getCount() {
        return this.f26204b.size();
    }

    public final Object getItem(int i2) {
        return this.f26204b.get(i2);
    }
}
