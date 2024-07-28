package com.travel.c;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.travel.booking.datamodel.CJRTravelBookingData;

public abstract class m extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f22906a;

    /* renamed from: b  reason: collision with root package name */
    protected CJRTravelBookingData f22907b;

    public abstract void a(CJRTravelBookingData cJRTravelBookingData);

    protected m(Object obj, View view, TextView textView) {
        super(obj, view, 0);
        this.f22906a = textView;
    }
}
