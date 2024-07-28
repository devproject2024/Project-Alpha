package com.travel.flight.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.travel.flight.pojo.flightticket.CJRFlightDetailsItem;
import net.one97.paytm.common.widgets.CJRHorizontalListView;

public abstract class dm extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f23938a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f23939b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f23940c;

    /* renamed from: d  reason: collision with root package name */
    public final CJRHorizontalListView f23941d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f23942e;

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f23943f;

    /* renamed from: g  reason: collision with root package name */
    protected CJRFlightDetailsItem f23944g;

    protected dm(Object obj, View view, ImageView imageView, TextView textView, TextView textView2, CJRHorizontalListView cJRHorizontalListView, TextView textView3, LinearLayout linearLayout) {
        super(obj, view, 0);
        this.f23938a = imageView;
        this.f23939b = textView;
        this.f23940c = textView2;
        this.f23941d = cJRHorizontalListView;
        this.f23942e = textView3;
        this.f23943f = linearLayout;
    }
}
