package com.travel.train.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.R;
import com.travel.train.i.e;
import com.travel.train.j.o;
import com.travel.train.model.trainticket.CJRTrainSearchResultsTrain;
import java.util.Map;

public final class j extends RecyclerView.v implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public e f28137a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f28138b;

    /* renamed from: c  reason: collision with root package name */
    public Button f28139c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f28140d;

    /* renamed from: e  reason: collision with root package name */
    private Context f28141e;

    /* renamed from: f  reason: collision with root package name */
    private CJRTrainSearchResultsTrain f28142f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f28143g;

    /* renamed from: h  reason: collision with root package name */
    private Button f28144h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f28145i;
    private ImageView j;

    public j(View view, e eVar, CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain) {
        super(view);
        this.f28141e = view.getContext();
        this.f28137a = eVar;
        this.f28142f = cJRTrainSearchResultsTrain;
        this.f28140d = (RelativeLayout) view.findViewById(R.id.fare_change_lyt);
        this.f28138b = (RelativeLayout) view.findViewById(R.id.checkout_lyt);
        this.f28144h = (Button) view.findViewById(R.id.change_proceed_btn);
        this.f28144h.setOnClickListener(this);
        this.j = (ImageView) view.findViewById(R.id.view_fare_arrow);
        this.f28143g = (RelativeLayout) view.findViewById(R.id.review_iteneray_train_proceed_lyt);
        this.f28145i = (TextView) view.findViewById(R.id.fare_amount_total);
        this.f28139c = (Button) view.findViewById(R.id.proceed_to_book_btn_review);
        this.f28139c.setText(this.f28141e.getResources().getString(R.string.train_itinerary_proceed_btn));
        this.f28139c.setOnClickListener(this);
        view.findViewById(R.id.lv_fare_amount_container).setOnClickListener(this);
        this.f28143g.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                j.this.f28137a.b(j.this.f28143g.getHeight());
                j.this.f28143g.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }

    public final void a(String str) {
        this.f28145i.setText(str);
    }

    public final void a() {
        if (this.f28138b.getVisibility() == 0) {
            this.f28138b.setVisibility(8);
            this.f28140d.setVisibility(0);
        }
    }

    public final void a(boolean z) {
        if (z) {
            this.j.setImageDrawable(this.f28141e.getResources().getDrawable(R.drawable.pre_t_imge_down));
        } else {
            this.j.setImageDrawable(this.f28141e.getResources().getDrawable(R.drawable.pre_t_flight_review_see_details));
        }
    }

    public final void onClick(View view) {
        int id = view.getId();
        if (id == R.id.lv_fare_amount_container) {
            this.f28137a.p();
            o.a("train_review_itinerary", (String) null, "view_fare_breakup", "/trains/review-itinerary", this.f28141e);
        } else if (id == R.id.change_proceed_btn) {
            this.f28137a.i();
        } else if (id == R.id.proceed_to_book_btn_review) {
            o.a("train_review_itinerary", this.f28142f.getSourceName(), this.f28142f.getDestinationName(), this.f28142f.getDeparture(), (String) null, (String) null, (String) null, "proceed_to_pay", "/trains/review-itinerary", this.f28141e, (Map<String, Object>) null);
            this.f28137a.h();
        }
    }
}
