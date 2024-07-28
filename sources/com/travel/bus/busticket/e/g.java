package com.travel.bus.busticket.e;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.travel.bus.R;

public final class g extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    public Context f22155a;

    /* renamed from: b  reason: collision with root package name */
    public int f22156b;

    /* renamed from: c  reason: collision with root package name */
    public RoboTextView f22157c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f22158d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f22159e;

    public g(View view, Context context) {
        super(view);
        this.f22155a = context;
        this.f22158d = (LinearLayout) view.findViewById(R.id.review_lyt);
        this.f22157c = (RoboTextView) view.findViewById(R.id.bus_review_heading);
        this.f22159e = (LinearLayout) view.findViewById(R.id.no_reviews_lyt);
    }
}
