package com.travel.flight.flightticket.j;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.flight.R;
import com.travel.flight.flightticket.d.c;
import com.travel.flight.flightticket.f.h;

public final class aa extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    public final Context f25050a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f25051b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f25052c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f25053d;

    /* renamed from: e  reason: collision with root package name */
    public CheckBox f25054e;

    /* renamed from: f  reason: collision with root package name */
    h f25055f;

    /* renamed from: g  reason: collision with root package name */
    public int f25056g = 0;

    public aa(Activity activity, View view, h hVar) {
        super(view);
        this.f25050a = activity;
        this.f25052c = (TextView) view.findViewById(R.id.flight_insurance_title);
        this.f25054e = (CheckBox) view.findViewById(R.id.flight_insurance_checkbox);
        this.f25054e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                aa.this.f25055f.a(Boolean.valueOf(z), c.INSURANCE_CHECKBOX);
            }
        });
        this.f25053d = (TextView) view.findViewById(R.id.flight_insurance_text);
        this.f25051b = (TextView) view.findViewById(R.id.flight_insurance_sold_by);
        this.f25055f = hVar;
    }
}
