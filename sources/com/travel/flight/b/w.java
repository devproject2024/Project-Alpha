package com.travel.flight.b;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.flight.pojo.modifyBooking.CJRFlightMBPassengerDetails;

public abstract class w extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final View f24037a;

    /* renamed from: b  reason: collision with root package name */
    public final Guideline f24038b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f24039c;

    /* renamed from: d  reason: collision with root package name */
    public final Guideline f24040d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f24041e;

    /* renamed from: f  reason: collision with root package name */
    public final RecyclerView f24042f;

    /* renamed from: g  reason: collision with root package name */
    protected CJRFlightMBPassengerDetails f24043g;

    protected w(Object obj, View view, View view2, Guideline guideline, RecyclerView recyclerView, Guideline guideline2, TextView textView, RecyclerView recyclerView2) {
        super(obj, view, 0);
        this.f24037a = view2;
        this.f24038b = guideline;
        this.f24039c = recyclerView;
        this.f24040d = guideline2;
        this.f24041e = textView;
        this.f24042f = recyclerView2;
    }
}
