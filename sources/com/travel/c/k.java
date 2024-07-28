package com.travel.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.R;
import com.travel.booking.datamodel.CJRTravelBookingData;
import com.travel.booking.e.a;

public abstract class k extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final m f22898a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f22899b;

    /* renamed from: c  reason: collision with root package name */
    protected CJRTravelBookingData f22900c;

    /* renamed from: d  reason: collision with root package name */
    protected a f22901d;

    public abstract void a(CJRTravelBookingData cJRTravelBookingData);

    public abstract void a(a aVar);

    protected k(Object obj, View view, m mVar, RecyclerView recyclerView) {
        super(obj, view, 1);
        this.f22898a = mVar;
        setContainedBinding(this.f22898a);
        this.f22899b = recyclerView;
    }

    public static k a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (k) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_travel_booking_list, viewGroup, false, f.a());
    }
}
