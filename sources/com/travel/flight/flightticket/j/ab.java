package com.travel.flight.flightticket.j;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.flight.R;
import com.travel.flight.flightticket.d.c;
import com.travel.flight.flightticket.f.h;

public final class ab extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    h f25060a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f25061b;

    /* renamed from: c  reason: collision with root package name */
    private Context f25062c;

    public ab(Activity activity, View view, h hVar) {
        super(view);
        this.f25062c = activity;
        this.f25060a = hVar;
        this.f25061b = (TextView) view.findViewById(R.id.tv_paytm_tc);
        TextView textView = this.f25061b;
        textView.setText(Html.fromHtml("<font color=\"#979797\">" + this.f25062c.getString(R.string.flight_t_and_c) + " </font><u><font color=\"#666666\">" + this.f25062c.getString(R.string.terms_and_conditions_title) + "</font></u>"));
        this.f25061b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ab.this.f25060a.a(Boolean.FALSE, c.NAVIGATE_TO_TC);
            }
        });
    }
}
