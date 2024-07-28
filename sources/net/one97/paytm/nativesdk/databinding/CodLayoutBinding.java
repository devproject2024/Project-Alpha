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
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.instruments.cod.viewmodel.CodViewModel;
import net.one97.paytm.nativesdk.widget.RoboTextView;

public abstract class CodLayoutBinding extends ViewDataBinding {
    public final RelativeLayout btnProceed;
    public final RelativeLayout cardTextLayout;
    public final ImageView ivPaysecurely;
    public final ImageView ivRightArrow;
    public final LottieAnimationView ltvLoading;
    protected CodViewModel mCodViewModel;
    protected View mView;
    public final TextView paysecurely;
    public final RadioButton radioButton;
    public final RelativeLayout topLayout;
    public final TextView tvBankOfferError;
    public final RoboTextView tvCod;
    public final TextView tvRemainingAmtTxt;
    public final TextView txtamount;

    public abstract void setCodViewModel(CodViewModel codViewModel);

    public abstract void setView(View view);

    protected CodLayoutBinding(Object obj, View view, int i2, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, ImageView imageView, ImageView imageView2, LottieAnimationView lottieAnimationView, TextView textView, RadioButton radioButton2, RelativeLayout relativeLayout3, TextView textView2, RoboTextView roboTextView, TextView textView3, TextView textView4) {
        super(obj, view, i2);
        this.btnProceed = relativeLayout;
        this.cardTextLayout = relativeLayout2;
        this.ivPaysecurely = imageView;
        this.ivRightArrow = imageView2;
        this.ltvLoading = lottieAnimationView;
        this.paysecurely = textView;
        this.radioButton = radioButton2;
        this.topLayout = relativeLayout3;
        this.tvBankOfferError = textView2;
        this.tvCod = roboTextView;
        this.tvRemainingAmtTxt = textView3;
        this.txtamount = textView4;
    }

    public CodViewModel getCodViewModel() {
        return this.mCodViewModel;
    }

    public View getView() {
        return this.mView;
    }

    public static CodLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static CodLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CodLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.cod_layout, viewGroup, z, obj);
    }

    public static CodLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static CodLayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CodLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.cod_layout, (ViewGroup) null, false, obj);
    }

    public static CodLayoutBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static CodLayoutBinding bind(View view, Object obj) {
        return (CodLayoutBinding) bind(obj, view, R.layout.cod_layout);
    }
}
