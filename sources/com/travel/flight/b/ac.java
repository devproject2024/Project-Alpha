package com.travel.flight.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.google.android.material.tabs.TabLayout;
import com.travel.flight.R;
import com.travel.flight.flightSRPV2.view.ui.widget.LockableViewPager;
import com.travel.flight.flightSRPV2.viewModel.FlightFilterHomeViewModel;

public abstract class ac extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final Button f23554a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f23555b;

    /* renamed from: c  reason: collision with root package name */
    public final TabLayout f23556c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f23557d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f23558e;

    /* renamed from: f  reason: collision with root package name */
    public final View f23559f;

    /* renamed from: g  reason: collision with root package name */
    public final LockableViewPager f23560g;

    /* renamed from: h  reason: collision with root package name */
    protected FlightFilterHomeViewModel f23561h;

    public abstract void a(FlightFilterHomeViewModel flightFilterHomeViewModel);

    protected ac(Object obj, View view, Button button, ImageView imageView, TabLayout tabLayout, TextView textView, TextView textView2, View view2, LockableViewPager lockableViewPager) {
        super(obj, view, 1);
        this.f23554a = button;
        this.f23555b = imageView;
        this.f23556c = tabLayout;
        this.f23557d = textView;
        this.f23558e = textView2;
        this.f23559f = view2;
        this.f23560g = lockableViewPager;
    }

    public static ac a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (ac) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_flight_filter_home_page, viewGroup, false, f.a());
    }
}
