package com.travel.flight.flightticket.j;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.flight.R;
import com.travel.flight.flightticket.d.c;
import com.travel.flight.flightticket.f.k;
import com.travel.flight.pojo.flightticket.CJRFlightDetails;

public final class u extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    public TextView f25212a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f25213b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f25214c;

    /* renamed from: d  reason: collision with root package name */
    public Context f25215d;

    /* renamed from: e  reason: collision with root package name */
    public CJRFlightDetails f25216e;

    /* renamed from: f  reason: collision with root package name */
    public k f25217f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f25218g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f25219h;

    /* renamed from: i  reason: collision with root package name */
    private ViewGroup f25220i;

    public u(View view, Context context) {
        super(view);
        this.f25215d = context;
        this.f25219h = (TextView) view.findViewById(R.id.fare_rules);
        this.f25212a = (TextView) view.findViewById(R.id.txt_more_sellers);
        this.f25213b = (TextView) view.findViewById(R.id.txt_traveller_note);
        this.f25220i = (ViewGroup) view.findViewById(R.id.layout_cancellation_and_more_sellers);
        this.f25214c = (ViewGroup) view.findViewById(R.id.layout_parent_view);
        this.f25219h.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                u.this.f25217f.reviewIternaryActionClick("", (Intent) null, Boolean.FALSE, c.NAVIGATE_TO_CANCELLATION_RULES);
            }
        });
        this.f25212a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (u.this.f25217f != null) {
                    u.this.f25217f.updateJourneyTypeForPrices(u.this.f25218g ? "round_trip" : "one_way");
                    u.this.f25217f.reviewIternaryActionClick("", (Intent) null, Boolean.FALSE, c.NAVIGATE_TO_MORE_SELLER);
                }
            }
        });
    }

    public final void a() {
        if (this.f25216e.getmOnwardJourney() == null || this.f25216e.getmOnwardJourney().getmPrice() == null || this.f25216e.getmOnwardJourney().getmPrice().size() <= 1) {
            this.f25212a.setVisibility(8);
        } else {
            this.f25212a.setVisibility(0);
        }
    }
}
