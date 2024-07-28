package com.travel.flight.b;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.flight.pojo.modifyBooking.CJRFlightMBCharge;
import com.travel.flight.pojo.modifyBooking.CJRFlightMBChargesBody;

public abstract class k extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f23990a;

    /* renamed from: b  reason: collision with root package name */
    public final View f23991b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f23992c;

    /* renamed from: d  reason: collision with root package name */
    public final Guideline f23993d;

    /* renamed from: e  reason: collision with root package name */
    public final RecyclerView f23994e;

    /* renamed from: f  reason: collision with root package name */
    public final Guideline f23995f;

    /* renamed from: g  reason: collision with root package name */
    public final RecyclerView f23996g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f23997h;

    /* renamed from: i  reason: collision with root package name */
    protected CJRFlightMBChargesBody f23998i;
    protected CJRFlightMBCharge j;

    protected k(Object obj, View view, TextView textView, View view2, TextView textView2, Guideline guideline, RecyclerView recyclerView, Guideline guideline2, RecyclerView recyclerView2, TextView textView3) {
        super(obj, view, 0);
        this.f23990a = textView;
        this.f23991b = view2;
        this.f23992c = textView2;
        this.f23993d = guideline;
        this.f23994e = recyclerView;
        this.f23995f = guideline2;
        this.f23996g = recyclerView2;
        this.f23997h = textView3;
    }
}
