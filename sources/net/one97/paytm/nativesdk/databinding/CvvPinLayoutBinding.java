package net.one97.paytm.nativesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.otp.view.PinEntryEditText;
import net.one97.paytm.nativesdk.pincvv.viewmodel.PinCvvModel;
import net.one97.paytm.nativesdk.widget.RoboTextView;

public abstract class CvvPinLayoutBinding extends ViewDataBinding {
    public final LottieAnimationView dotProgressBar;
    public final PinEntryEditText etPincvv;
    public final ImageView ivSelectedInstrumentImage;
    public final LinearLayout lytValidatingOtp;
    protected PinCvvModel mPincvvmodel;
    public final RelativeLayout rlDownArrow;
    public final RelativeLayout rlSelectedInstrument;
    public final RelativeLayout rlSelectedInstrumentImage;
    public final RoboTextView titleTxt;
    public final TextView tvInstrumentBalance;
    public final RoboTextView tvInstrumentName;
    public final RoboTextView tvPayUsing;

    public abstract void setPincvvmodel(PinCvvModel pinCvvModel);

    protected CvvPinLayoutBinding(Object obj, View view, int i2, LottieAnimationView lottieAnimationView, PinEntryEditText pinEntryEditText, ImageView imageView, LinearLayout linearLayout, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RoboTextView roboTextView, TextView textView, RoboTextView roboTextView2, RoboTextView roboTextView3) {
        super(obj, view, i2);
        this.dotProgressBar = lottieAnimationView;
        this.etPincvv = pinEntryEditText;
        this.ivSelectedInstrumentImage = imageView;
        this.lytValidatingOtp = linearLayout;
        this.rlDownArrow = relativeLayout;
        this.rlSelectedInstrument = relativeLayout2;
        this.rlSelectedInstrumentImage = relativeLayout3;
        this.titleTxt = roboTextView;
        this.tvInstrumentBalance = textView;
        this.tvInstrumentName = roboTextView2;
        this.tvPayUsing = roboTextView3;
    }

    public PinCvvModel getPincvvmodel() {
        return this.mPincvvmodel;
    }

    public static CvvPinLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static CvvPinLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CvvPinLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.cvv_pin_layout, viewGroup, z, obj);
    }

    public static CvvPinLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static CvvPinLayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CvvPinLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.cvv_pin_layout, (ViewGroup) null, false, obj);
    }

    public static CvvPinLayoutBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static CvvPinLayoutBinding bind(View view, Object obj) {
        return (CvvPinLayoutBinding) bind(obj, view, R.layout.cvv_pin_layout);
    }
}
