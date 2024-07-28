package com.travel.flight.b;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.flight.pojo.modifyBooking.CJRFlightMBImportant;

public abstract class o extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final Guideline f24008a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f24009b;

    /* renamed from: c  reason: collision with root package name */
    public final Guideline f24010c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f24011d;

    /* renamed from: e  reason: collision with root package name */
    protected CJRFlightMBImportant f24012e;

    protected o(Object obj, View view, Guideline guideline, RecyclerView recyclerView, Guideline guideline2, TextView textView) {
        super(obj, view, 0);
        this.f24008a = guideline;
        this.f24009b = recyclerView;
        this.f24010c = guideline2;
        this.f24011d = textView;
    }
}
