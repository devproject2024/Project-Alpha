package net.one97.paytm.hotels2.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import net.one97.paytm.hotel4.viewmodel.filter.SRPFilterItemViewModel;
import net.one97.paytm.hotels2.R;

public abstract class eu extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    protected SRPFilterItemViewModel f29653a;

    public abstract void a(SRPFilterItemViewModel sRPFilterItemViewModel);

    protected eu(Object obj, View view) {
        super(obj, view, 2);
    }

    public static eu a(LayoutInflater layoutInflater) {
        return (eu) ViewDataBinding.inflateInternal(layoutInflater, R.layout.h4_srp_filter_price_range_list_item, (ViewGroup) null, false, f.a());
    }
}
