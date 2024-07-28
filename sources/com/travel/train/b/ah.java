package com.travel.train.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.travel.train.R;
import com.travel.train.i.v;
import com.travel.train.model.trainticket.CJRTrainLSSearchResult;
import com.travel.train.model.trainticket.CJRTrainRecentsItemModel;
import com.travel.train.viewholder.az;
import java.util.List;

public final class ah<T> extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Context f26211a;

    /* renamed from: b  reason: collision with root package name */
    private List<T> f26212b;

    /* renamed from: c  reason: collision with root package name */
    private v f26213c;

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public ah(Context context, List<T> list, v vVar) {
        this.f26211a = context;
        this.f26212b = list;
        this.f26213c = vVar;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        az azVar;
        T t;
        if (view == null) {
            view = LayoutInflater.from(this.f26211a).inflate(R.layout.pre_t_search_by_train_booking_bs_adapter_item, viewGroup, false);
            view.setPadding(0, (int) this.f26211a.getResources().getDimension(R.dimen.dimen_19dp), 0, 0);
            azVar = new az(this.f26213c, view);
            view.setTag(azVar);
        } else {
            azVar = (az) view.getTag();
        }
        List<T> list = this.f26212b;
        if (!(list == null || list.size() <= 0 || this.f26212b.get(i2) == null || (t = this.f26212b.get(i2)) == null)) {
            if (t instanceof CJRTrainLSSearchResult.Train) {
                CJRTrainLSSearchResult.Train train = (CJRTrainLSSearchResult.Train) t;
                if (!TextUtils.isEmpty(train.getTrainName())) {
                    azVar.f27901b.setText(train.getTrainName());
                }
                if (!TextUtils.isEmpty(train.getTrainNumber())) {
                    azVar.f27900a.setText(train.getTrainNumber());
                }
            } else {
                CJRTrainRecentsItemModel cJRTrainRecentsItemModel = (CJRTrainRecentsItemModel) t;
                if (!TextUtils.isEmpty(cJRTrainRecentsItemModel.getTrainName())) {
                    azVar.f27901b.setText(cJRTrainRecentsItemModel.getTrainName());
                }
                if (!TextUtils.isEmpty(cJRTrainRecentsItemModel.getTrainNumber())) {
                    azVar.f27900a.setText(cJRTrainRecentsItemModel.getTrainNumber());
                }
            }
            azVar.f27902c.setOnClickListener(new View.OnClickListener(t) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ Object f27904a;

                {
                    this.f27904a = r2;
                }

                public final void onClick(View view) {
                    az.this.f27903d.a(this.f27904a);
                }
            });
        }
        return view;
    }

    public final int getCount() {
        return this.f26212b.size();
    }

    public final Object getItem(int i2) {
        return this.f26212b.get(i2);
    }
}
