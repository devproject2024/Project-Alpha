package com.travel.flight.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.flight.pojo.FlightBookingRefundDetails;

public abstract class be extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f23681a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f23682b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f23683c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f23684d;

    /* renamed from: e  reason: collision with root package name */
    protected FlightBookingRefundDetails f23685e;

    public abstract void a(FlightBookingRefundDetails flightBookingRefundDetails);

    protected be(Object obj, View view, ImageView imageView, TextView textView, RecyclerView recyclerView, ImageView imageView2) {
        super(obj, view, 0);
        this.f23681a = imageView;
        this.f23682b = textView;
        this.f23683c = recyclerView;
        this.f23684d = imageView2;
    }
}
