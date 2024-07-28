package com.travel.flight.flightticket.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.travel.flight.R;
import net.one97.paytm.i.h;

public class f extends h {

    /* renamed from: a  reason: collision with root package name */
    private LinearLayout f24978a;

    /* renamed from: b  reason: collision with root package name */
    private ProgressBar f24979b;

    /* renamed from: c  reason: collision with root package name */
    private View f24980c;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f24980c = layoutInflater.inflate(R.layout.pre_f_flight_pager_layout, viewGroup, false);
        this.f24978a = (LinearLayout) this.f24980c.findViewById(R.id.linear_flight_recent_list);
        this.f24979b = (ProgressBar) this.f24980c.findViewById(R.id.progress_bar);
        this.f24979b.setVisibility(8);
        return this.f24980c;
    }
}
