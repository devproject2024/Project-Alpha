package com.travel.train.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.R;
import com.travel.train.i.ad;
import com.travel.train.model.trainticket.CJRTrainSearchResultsAlternateStationData;
import com.travel.train.model.trainticket.CJRTrainSearchResultsTrain;
import com.travel.train.viewholder.b;
import java.util.HashMap;

public final class s extends RecyclerView.a implements ad {

    /* renamed from: a  reason: collision with root package name */
    private Context f26548a;

    /* renamed from: b  reason: collision with root package name */
    private ad f26549b;

    /* renamed from: c  reason: collision with root package name */
    private CJRTrainSearchResultsTrain f26550c;

    /* renamed from: d  reason: collision with root package name */
    private LayoutInflater f26551d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap<String, Object> f26552e;

    /* renamed from: f  reason: collision with root package name */
    private a f26553f = a.SIMPLE_VIEW;

    public enum a {
        SIMPLE_VIEW,
        EXPANDED_VIEW
    }

    public final void b(int i2, CJRTrainSearchResultsAlternateStationData cJRTrainSearchResultsAlternateStationData, CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain) {
    }

    public s(Context context, ad adVar, CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain, HashMap<String, Object> hashMap, a aVar) {
        this.f26548a = context;
        this.f26549b = adVar;
        this.f26550c = cJRTrainSearchResultsTrain;
        Context context2 = this.f26548a;
        if (context2 != null) {
            this.f26551d = (LayoutInflater) context2.getSystemService("layout_inflater");
        }
        this.f26552e = hashMap;
        this.f26553f = aVar;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (this.f26553f.equals(a.EXPANDED_VIEW)) {
            return new com.travel.train.viewholder.a(this.f26551d.inflate(R.layout.pre_t_train_alternate_expand_item, viewGroup, false), this.f26550c, this.f26552e, this);
        }
        return new b(this.f26551d.inflate(R.layout.pre_t_train_alternate_list_item, viewGroup, false), this.f26550c, this.f26552e, this);
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        ((com.travel.train.i.b) vVar).a(this.f26548a, this.f26550c.getAlternateStationsData().get(i2), i2);
    }

    public final int getItemCount() {
        return this.f26550c.getAlternateStationsData().size();
    }

    public final void a(int i2, CJRTrainSearchResultsAlternateStationData cJRTrainSearchResultsAlternateStationData, CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain) {
        if (this.f26553f.equals(a.EXPANDED_VIEW) && cJRTrainSearchResultsTrain != null && cJRTrainSearchResultsTrain.getAlternateStationsData() != null && cJRTrainSearchResultsTrain.getAlternateStationsData().size() > 0) {
            for (int i3 = 0; i3 < cJRTrainSearchResultsTrain.getAlternateStationsData().size(); i3++) {
                if (i3 != i2) {
                    cJRTrainSearchResultsTrain.getAlternateStationsData().get(i3).setSelected(false);
                }
            }
            notifyDataSetChanged();
        }
        this.f26549b.a(i2, cJRTrainSearchResultsAlternateStationData, cJRTrainSearchResultsTrain);
    }
}
