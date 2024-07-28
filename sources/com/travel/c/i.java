package com.travel.c;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.squareup.timessquare.v3.CalendarPickerView;

public abstract class i extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RelativeLayout f22889a;

    /* renamed from: b  reason: collision with root package name */
    public final CalendarPickerView f22890b;

    /* renamed from: c  reason: collision with root package name */
    public final View f22891c;

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f22892d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f22893e;

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f22894f;

    protected i(Object obj, View view, RelativeLayout relativeLayout, CalendarPickerView calendarPickerView, View view2, LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2) {
        super(obj, view, 0);
        this.f22889a = relativeLayout;
        this.f22890b = calendarPickerView;
        this.f22891c = view2;
        this.f22892d = linearLayout;
        this.f22893e = textView;
        this.f22894f = linearLayout2;
    }
}
