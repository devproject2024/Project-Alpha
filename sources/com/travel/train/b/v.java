package com.travel.train.b;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.i.ae;
import com.travel.train.i.b;
import com.travel.train.model.trainticket.CJRTrainCancellationItem;
import com.travel.train.viewholder.bp;
import java.util.ArrayList;

public final class v extends RecyclerView.a {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<CJRTrainCancellationItem> f26568a;

    /* renamed from: b  reason: collision with root package name */
    private Context f26569b;

    public v(Context context, ArrayList<CJRTrainCancellationItem> arrayList) {
        this.f26569b = context;
        this.f26568a = arrayList;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return bp.a(viewGroup, ae.fromIndex(i2));
    }

    public final int getItemViewType(int i2) {
        return ae.fromName(this.f26568a.get(i2).getLayoutType()).getIndex();
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        ((b) vVar).a(this.f26569b, this.f26568a.get(i2), i2);
    }

    public final int getItemCount() {
        ArrayList<CJRTrainCancellationItem> arrayList = this.f26568a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }
}
