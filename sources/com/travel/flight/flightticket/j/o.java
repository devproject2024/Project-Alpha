package com.travel.flight.flightticket.j;

import android.content.Intent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.flight.R;
import com.travel.flight.b;
import com.travel.flight.flightticket.d.c;
import com.travel.flight.flightticket.f.k;
import com.travel.flight.pojo.flightticket.CJRFlightDetails;
import com.travel.flight.pojo.flightticket.FareRules.CJRPolicyDetailsBaggage;
import java.util.List;

public final class o extends RecyclerView.v implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public String f25186a = b.b().r();

    /* renamed from: b  reason: collision with root package name */
    public CJRFlightDetails f25187b;

    /* renamed from: c  reason: collision with root package name */
    public View f25188c;

    /* renamed from: d  reason: collision with root package name */
    private k f25189d;

    public o(View view, k kVar, CJRFlightDetails cJRFlightDetails) {
        super(view);
        this.f25189d = kVar;
        this.f25187b = cJRFlightDetails;
        b.a();
        this.f25188c = view;
    }

    public final void onClick(View view) {
        k kVar;
        if (view.getId() == R.id.arrow_view && (kVar = this.f25189d) != null) {
            kVar.reviewIternaryActionClick("", (Intent) null, Boolean.FALSE, c.NAVIGATE_TO_FARE_RULES);
        }
    }

    public static String a(List<CJRPolicyDetailsBaggage> list) {
        String str = "";
        if (list != null) {
            for (CJRPolicyDetailsBaggage next : list) {
                if (next != null) {
                    if (!str.isEmpty()) {
                        str = str + "   •  ";
                    }
                    str = (str + next.getTitle()) + " " + next.getMessages().get(0).getValue();
                }
            }
        }
        return str;
    }
}
