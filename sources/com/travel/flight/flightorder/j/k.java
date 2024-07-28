package com.travel.flight.flightorder.j;

import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.travel.flight.R;
import com.travel.flight.flightorder.activity.FlightOrderSummary;
import com.travel.flight.flightorder.d.b;
import com.travel.flight.flightorder.e.b;
import com.travel.flight.flightorder.f.a;
import com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse;
import net.one97.paytm.m;

public final class k extends a {

    /* renamed from: a  reason: collision with root package name */
    CJRFlightOrderSummaryResponse f24527a;

    /* renamed from: b  reason: collision with root package name */
    b f24528b;

    /* renamed from: c  reason: collision with root package name */
    FlightOrderSummary.a f24529c;

    /* renamed from: d  reason: collision with root package name */
    b.C0467b f24530d;

    /* renamed from: e  reason: collision with root package name */
    m f24531e;

    /* renamed from: f  reason: collision with root package name */
    private com.travel.flight.flightorder.g.a f24532f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f24533g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f24534h;

    /* renamed from: i  reason: collision with root package name */
    private RelativeLayout f24535i;
    private String j = this.f24527a.getBody().getFooter_card().getMessage();
    private String k = this.f24527a.getBody().getFooter_card().getLink_string();

    public k(View view, CJRFlightOrderSummaryResponse cJRFlightOrderSummaryResponse, com.travel.flight.flightorder.g.a aVar, FlightOrderSummary.a aVar2, m mVar) {
        super(view);
        this.f24529c = aVar2;
        this.f24533g = (TextView) view.findViewById(R.id.paytm_trust_text);
        this.f24534h = (TextView) view.findViewById(R.id.paytm_contact_us);
        this.f24527a = cJRFlightOrderSummaryResponse;
        this.f24532f = aVar;
        this.f24531e = mVar;
        this.f24535i = (RelativeLayout) view.findViewById(R.id.contact_us_layout);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f24535i.getLayoutParams();
        int applyDimension = (int) TypedValue.applyDimension(1, 5.0f, this.f24532f.b().getResources().getDisplayMetrics());
        layoutParams.setMarginStart(applyDimension);
        layoutParams.setMarginEnd(applyDimension);
        this.f24535i.setLayoutParams(layoutParams);
    }

    public final void a(b.C0467b bVar) {
        if (this.f24527a != null) {
            this.f24530d = bVar;
            try {
                TextView textView = this.f24533g;
                String str = this.j;
                textView.setText(str.replace(SimpleComparison.LESS_THAN_OPERATION + this.k + SimpleComparison.GREATER_THAN_OPERATION, " "));
                this.f24534h.setText(this.k);
                this.f24534h.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        k kVar = k.this;
                        kVar.f24528b = new com.travel.flight.flightorder.e.b(kVar.itemView.getContext(), k.this.f24527a, k.this.f24530d, k.this.f24531e);
                        k.this.f24528b.a();
                    }
                });
            } catch (Exception unused) {
            }
        }
    }
}
