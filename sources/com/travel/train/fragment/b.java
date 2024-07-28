package com.travel.train.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.airbnb.lottie.LottieAnimationView;
import com.travel.train.R;
import net.one97.paytm.common.widgets.a;

public class b extends am {

    /* renamed from: a  reason: collision with root package name */
    private View f26919a;

    /* renamed from: b  reason: collision with root package name */
    private LottieAnimationView f26920b;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f26919a = layoutInflater.inflate(R.layout.pre_t_fare_change_progress_lyt, viewGroup, false);
        this.f26920b = (LottieAnimationView) this.f26919a.findViewById(R.id.wallet_loader);
        a.a(this.f26920b);
        return this.f26919a;
    }
}
