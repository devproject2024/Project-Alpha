package com.travel.flight.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.paytm.utility.RoboTextView;
import com.travel.flight.R;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;

public abstract class cm extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RoboTextView f23823a;

    /* renamed from: b  reason: collision with root package name */
    public final LinearLayout f23824b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f23825c;

    /* renamed from: d  reason: collision with root package name */
    public final CardView f23826d;

    /* renamed from: e  reason: collision with root package name */
    protected SRPSharedViewModel f23827e;

    public abstract void a(SRPSharedViewModel sRPSharedViewModel);

    protected cm(Object obj, View view, RoboTextView roboTextView, LinearLayout linearLayout, ImageView imageView, CardView cardView) {
        super(obj, view, 2);
        this.f23823a = roboTextView;
        this.f23824b = linearLayout;
        this.f23825c = imageView;
        this.f23826d = cardView;
    }

    public static cm a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (cm) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pre_f_flight_fare_alert_message_lyt, viewGroup, false, f.a());
    }
}
