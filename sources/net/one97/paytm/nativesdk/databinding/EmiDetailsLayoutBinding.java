package net.one97.paytm.nativesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.widget.RoboTextView;

public abstract class EmiDetailsLayoutBinding extends ViewDataBinding {
    public final LottieAnimationView dotProgressBar;
    public final ImageView imgCross;
    public final View listEmptyLayoutContainer;
    public final RelativeLayout minHeightLayout;
    public final RadioButton rbEmi;
    public final RecyclerView rvEmi;
    public final RoboTextView title;
    public final TextView tnc;

    protected EmiDetailsLayoutBinding(Object obj, View view, int i2, LottieAnimationView lottieAnimationView, ImageView imageView, View view2, RelativeLayout relativeLayout, RadioButton radioButton, RecyclerView recyclerView, RoboTextView roboTextView, TextView textView) {
        super(obj, view, i2);
        this.dotProgressBar = lottieAnimationView;
        this.imgCross = imageView;
        this.listEmptyLayoutContainer = view2;
        this.minHeightLayout = relativeLayout;
        this.rbEmi = radioButton;
        this.rvEmi = recyclerView;
        this.title = roboTextView;
        this.tnc = textView;
    }

    public static EmiDetailsLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static EmiDetailsLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (EmiDetailsLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.emi_details_layout, viewGroup, z, obj);
    }

    public static EmiDetailsLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static EmiDetailsLayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (EmiDetailsLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.emi_details_layout, (ViewGroup) null, false, obj);
    }

    public static EmiDetailsLayoutBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static EmiDetailsLayoutBinding bind(View view, Object obj) {
        return (EmiDetailsLayoutBinding) bind(obj, view, R.layout.emi_details_layout);
    }
}
