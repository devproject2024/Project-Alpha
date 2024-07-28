package com.travel.flight.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.travel.flight.R;
import com.travel.flight.pojo.modifyBooking.CJRFlightMBPassenger;

public abstract class bu extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f23747a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f23748b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f23749c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f23750d;

    /* renamed from: e  reason: collision with root package name */
    protected CJRFlightMBPassenger f23751e;

    public abstract void a(CJRFlightMBPassenger cJRFlightMBPassenger);

    protected bu(Object obj, View view, ImageView imageView, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, 0);
        this.f23747a = imageView;
        this.f23748b = textView;
        this.f23749c = textView2;
        this.f23750d = textView3;
    }

    public static bu a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (bu) ViewDataBinding.inflateInternal(layoutInflater, R.layout.list_item_modify_ticket_traveller, viewGroup, false, f.a());
    }
}
