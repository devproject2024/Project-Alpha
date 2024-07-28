package com.travel.train.b;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.i.ae;
import com.travel.train.i.b;
import com.travel.train.model.trainticket.CJRTrainCancellationTemplate;
import com.travel.train.viewholder.bp;
import java.util.ArrayList;

public final class w extends RecyclerView.a {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<CJRTrainCancellationTemplate> f26570a;

    /* renamed from: b  reason: collision with root package name */
    private Context f26571b;

    public w(Context context, ArrayList<CJRTrainCancellationTemplate> arrayList) {
        this.f26571b = context;
        this.f26570a = arrayList;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return bp.a(viewGroup, ae.fromIndex(i2));
    }

    public final int getItemViewType(int i2) {
        return ae.CANCELLATION_TYPE.getIndex();
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        ((b) vVar).a(this.f26571b, this.f26570a.get(i2), i2);
    }

    public final int getItemCount() {
        ArrayList<CJRTrainCancellationTemplate> arrayList = this.f26570a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }
}
