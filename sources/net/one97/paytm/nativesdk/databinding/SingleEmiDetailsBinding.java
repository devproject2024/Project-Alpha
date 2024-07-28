package net.one97.paytm.nativesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.widget.RoboTextView;

public abstract class SingleEmiDetailsBinding extends ViewDataBinding {
    public final RadioButton rbEmi;
    public final RelativeLayout toplayout;
    public final RoboTextView txtEmi;
    public final RoboTextView txtMonths;
    public final RoboTextView txtPercentage;
    public final RoboTextView txtTotal;

    protected SingleEmiDetailsBinding(Object obj, View view, int i2, RadioButton radioButton, RelativeLayout relativeLayout, RoboTextView roboTextView, RoboTextView roboTextView2, RoboTextView roboTextView3, RoboTextView roboTextView4) {
        super(obj, view, i2);
        this.rbEmi = radioButton;
        this.toplayout = relativeLayout;
        this.txtEmi = roboTextView;
        this.txtMonths = roboTextView2;
        this.txtPercentage = roboTextView3;
        this.txtTotal = roboTextView4;
    }

    public static SingleEmiDetailsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static SingleEmiDetailsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SingleEmiDetailsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.single_emi_details, viewGroup, z, obj);
    }

    public static SingleEmiDetailsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static SingleEmiDetailsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SingleEmiDetailsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.single_emi_details, (ViewGroup) null, false, obj);
    }

    public static SingleEmiDetailsBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static SingleEmiDetailsBinding bind(View view, Object obj) {
        return (SingleEmiDetailsBinding) bind(obj, view, R.layout.single_emi_details);
    }
}
