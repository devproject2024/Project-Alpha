package com.travel.flight.flightticket.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.travel.flight.R;
import com.travel.flight.d.b;

public class c extends b {

    /* renamed from: a  reason: collision with root package name */
    private com.travel.flight.flightticket.e.c f24955a;

    public void onEditViewClick(View view) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pre_f_calendar_view_flights, viewGroup, false);
        this.f24955a.a(inflate);
        int g2 = com.paytm.utility.b.g((Context) getActivity());
        inflate.setPadding(g2, 0, g2, 0);
        return inflate;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (this.f24955a == null) {
            this.f24955a = new com.travel.flight.flightticket.e.c();
        }
        this.f24955a.a(activity);
    }

    public void onDetach() {
        super.onDetach();
        com.travel.flight.flightticket.e.c cVar = this.f24955a;
        if (cVar != null) {
            cVar.a();
        }
    }
}
