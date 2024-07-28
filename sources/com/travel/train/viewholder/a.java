package com.travel.train.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.R;
import com.travel.train.i.ad;
import com.travel.train.i.b;
import com.travel.train.j.n;
import com.travel.train.model.trainticket.CJRTrainSearchResultsAlternateStationData;
import com.travel.train.model.trainticket.CJRTrainSearchResultsAvailibiltyObject;
import com.travel.train.model.trainticket.CJRTrainSearchResultsTrain;
import java.util.HashMap;
import java.util.Iterator;
import net.one97.paytm.common.entity.IJRDataModel;

public final class a extends RecyclerView.v implements b {

    /* renamed from: a  reason: collision with root package name */
    private ConstraintLayout f27740a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f27741b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f27742c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f27743d;

    /* renamed from: e  reason: collision with root package name */
    private ConstraintLayout f27744e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f27745f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f27746g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f27747h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f27748i;
    private ConstraintLayout j;
    private TextView k;
    private TextView l;
    private TextView m;
    private CJRTrainSearchResultsAlternateStationData n;
    private int o;
    private Context p;
    private HashMap<String, Object> q;
    private ad r;
    private CJRTrainSearchResultsTrain s;

    public a(View view, CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain, HashMap hashMap, ad adVar) {
        super(view);
        this.f27740a = (ConstraintLayout) view.findViewById(R.id.parent_container);
        this.f27741b = (TextView) view.findViewById(R.id.source_name_txt);
        this.f27742c = (TextView) view.findViewById(R.id.dest_name_txt);
        this.f27743d = (TextView) view.findViewById(R.id.alternative_num);
        this.f27744e = (ConstraintLayout) view.findViewById(R.id.expand_container);
        this.f27745f = (TextView) view.findViewById(R.id.expand_coach_txt);
        this.f27746g = (TextView) view.findViewById(R.id.expand_fare_amount);
        this.f27747h = (TextView) view.findViewById(R.id.expand_available_status);
        this.f27748i = (ImageView) view.findViewById(R.id.iv_triangle_down);
        this.j = (ConstraintLayout) view.findViewById(R.id.simple_container);
        this.k = (TextView) view.findViewById(R.id.simple_alternate_coach);
        this.l = (TextView) view.findViewById(R.id.simple_fare_amount);
        this.m = (TextView) view.findViewById(R.id.simple_available_status);
        this.q = hashMap;
        this.r = adVar;
        this.s = cJRTrainSearchResultsTrain;
    }

    public final void a(Context context, IJRDataModel iJRDataModel, int i2) {
        this.p = context;
        this.n = (CJRTrainSearchResultsAlternateStationData) iJRDataModel;
        this.o = i2;
        if (!TextUtils.isEmpty(this.n.getNewSourceName()) && !TextUtils.isEmpty(this.n.getNewDestinationName())) {
            TextView textView = this.f27741b;
            textView.setText(this.n.getNewSourceName() + "-");
            this.f27742c.setText(this.n.getNewDestinationName());
        }
        TextView textView2 = this.f27743d;
        textView2.setText(this.p.getString(R.string.train_alternative) + " " + (this.o + 1));
        if (this.n.getMAvailability() != null && this.n.getMAvailability().size() > 0) {
            Iterator<CJRTrainSearchResultsAvailibiltyObject> it2 = this.n.getMAvailability().iterator();
            while (it2.hasNext()) {
                CJRTrainSearchResultsAvailibiltyObject next = it2.next();
                StringBuilder sb = new StringBuilder();
                sb.append(this.p.getString(R.string.rs_symbols));
                if (!TextUtils.isEmpty(next.getFare())) {
                    sb.append(" ");
                    sb.append(next.getFare());
                }
                this.l.setText(sb.toString());
                this.f27746g.setText(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                if (!TextUtils.isEmpty(n.a(next.getClassType(), this.q))) {
                    sb2.append(n.a(next.getClassType(), this.q));
                    sb2.append(" (");
                    sb2.append(next.getClassType());
                    sb2.append(")");
                }
                this.k.setText(sb2.toString());
                this.f27745f.setText(sb2.toString());
                if (!TextUtils.isEmpty(next.getStatus())) {
                    this.m.setText(next.getStatus());
                    this.f27747h.setText(next.getStatus());
                    this.m.setTextColor(androidx.core.content.b.c(this.p, n.b(next.getColour())));
                    this.f27747h.setTextColor(androidx.core.content.b.c(this.p, n.b(next.getColour())));
                }
            }
        }
        if (this.n.isSelected()) {
            this.j.setVisibility(8);
            this.f27744e.setVisibility(0);
            this.f27748i.setVisibility(0);
            this.f27747h.setVisibility(0);
            this.f27740a.setBackgroundResource(R.drawable.pre_t_train_alternate_option_selected_bg);
        } else {
            this.j.setVisibility(0);
            this.f27744e.setVisibility(8);
            this.f27747h.setVisibility(8);
            this.f27748i.setVisibility(8);
            this.f27740a.setBackgroundResource(R.drawable.pre_t_train_grey_border_white_filled_with_corner_radius_4dp);
        }
        this.f27740a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        this.n.setSelected(true);
        this.f27740a.setBackgroundResource(R.drawable.pre_t_train_alternate_option_selected_bg);
        this.r.a(this.o, this.n, this.s);
    }
}
