package com.travel.flight.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.paytm.utility.RoboTextView;
import com.travel.flight.R;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;
import com.travel.model.CalendarDatePriceInfo;

public abstract class ck extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f23814a;

    /* renamed from: b  reason: collision with root package name */
    public final View f23815b;

    /* renamed from: c  reason: collision with root package name */
    public final RoboTextView f23816c;

    /* renamed from: d  reason: collision with root package name */
    public final RoboTextView f23817d;

    /* renamed from: e  reason: collision with root package name */
    protected CalendarDatePriceInfo f23818e;

    /* renamed from: f  reason: collision with root package name */
    protected SRPSharedViewModel f23819f;

    public abstract void a(SRPSharedViewModel sRPSharedViewModel);

    public abstract void a(CalendarDatePriceInfo calendarDatePriceInfo);

    protected ck(Object obj, View view, TextView textView, View view2, RoboTextView roboTextView, RoboTextView roboTextView2) {
        super(obj, view, 1);
        this.f23814a = textView;
        this.f23815b = view2;
        this.f23816c = roboTextView;
        this.f23817d = roboTextView2;
    }

    public static ck a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (ck) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pre_f_flight_date_price_item_v2, viewGroup, false, f.a());
    }
}
