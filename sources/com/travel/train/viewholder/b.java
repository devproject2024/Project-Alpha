package com.travel.train.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.R;
import com.travel.train.i.ad;
import com.travel.train.j.n;
import com.travel.train.model.trainticket.CJRTrainSearchResultsAlternateStationData;
import com.travel.train.model.trainticket.CJRTrainSearchResultsAvailibiltyObject;
import com.travel.train.model.trainticket.CJRTrainSearchResultsTrain;
import java.util.HashMap;
import java.util.Iterator;
import net.one97.paytm.common.entity.IJRDataModel;

public final class b extends RecyclerView.v implements com.travel.train.i.b {

    /* renamed from: a  reason: collision with root package name */
    CJRTrainSearchResultsAlternateStationData f27906a;

    /* renamed from: b  reason: collision with root package name */
    int f27907b;

    /* renamed from: c  reason: collision with root package name */
    ad f27908c;

    /* renamed from: d  reason: collision with root package name */
    CJRTrainSearchResultsTrain f27909d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f27910e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f27911f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f27912g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f27913h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f27914i;
    private TextView j;
    private FrameLayout k;
    private TextView l;
    private Context m;
    private HashMap<String, Object> n;

    public b(View view, CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain, HashMap hashMap, ad adVar) {
        super(view);
        this.f27910e = (TextView) view.findViewById(R.id.source_name_txt);
        this.f27911f = (TextView) view.findViewById(R.id.dest_name_txt);
        this.f27912g = (TextView) view.findViewById(R.id.fare_amount_txt);
        this.f27913h = (TextView) view.findViewById(R.id.alternate_coach_txt);
        this.f27914i = (TextView) view.findViewById(R.id.available_status_txt);
        this.k = (FrameLayout) view.findViewById(R.id.alternate_single_item_lyt_root);
        this.j = (TextView) view.findViewById(R.id.time_txt);
        this.l = (TextView) view.findViewById(R.id.alternative_num);
        this.n = hashMap;
        this.f27908c = adVar;
        this.f27909d = cJRTrainSearchResultsTrain;
    }

    public final void a(Context context, IJRDataModel iJRDataModel, int i2) {
        this.m = context;
        this.f27906a = (CJRTrainSearchResultsAlternateStationData) iJRDataModel;
        this.f27907b = i2;
        if (!TextUtils.isEmpty(this.f27906a.getNewSourceName()) && !TextUtils.isEmpty(this.f27906a.getNewDestinationName())) {
            TextView textView = this.f27910e;
            textView.setText(this.f27906a.getNewSourceName() + "-");
            this.f27911f.setText(this.f27906a.getNewDestinationName());
        }
        TextView textView2 = this.l;
        textView2.setText(this.m.getString(R.string.train_alternative) + " " + (this.f27907b + 1));
        if (this.f27906a.getMAvailability() != null && this.f27906a.getMAvailability().size() > 0) {
            Iterator<CJRTrainSearchResultsAvailibiltyObject> it2 = this.f27906a.getMAvailability().iterator();
            while (it2.hasNext()) {
                CJRTrainSearchResultsAvailibiltyObject next = it2.next();
                StringBuilder sb = new StringBuilder();
                sb.append(this.m.getString(R.string.rs_symbols));
                if (!TextUtils.isEmpty(next.getFare())) {
                    sb.append(" ");
                    sb.append(next.getFare());
                }
                this.f27912g.setText(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                if (!TextUtils.isEmpty(n.a(next.getClassType(), this.n))) {
                    sb2.append(n.a(next.getClassType(), this.n));
                    sb2.append(" (");
                    sb2.append(next.getClassType());
                    sb2.append(")");
                }
                this.f27913h.setText(sb2.toString());
                if (!TextUtils.isEmpty(next.getStatus())) {
                    this.f27914i.setText(next.getStatus());
                    this.f27914i.setTextColor(androidx.core.content.b.c(this.m, n.b(next.getColour())));
                }
                if (!TextUtils.isEmpty(next.getTimeOfAvailability())) {
                    this.j.setText(next.getTimeOfAvailability());
                }
            }
        }
        this.k.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.this.f27908c.a(b.this.f27907b, b.this.f27906a, b.this.f27909d);
            }
        });
    }
}
