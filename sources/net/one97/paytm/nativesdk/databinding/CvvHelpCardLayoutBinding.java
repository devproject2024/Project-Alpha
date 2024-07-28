package net.one97.paytm.nativesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.cvvHelp.viewmodel.CvvHelpFragmentViewModel;

public abstract class CvvHelpCardLayoutBinding extends ViewDataBinding {
    public final ImageView ivCardLogo;
    protected CvvHelpFragmentViewModel mCvvHelpModel;
    public final TextView tvCvvHelpTitle;
    public final TextView tvDesc;

    public abstract void setCvvHelpModel(CvvHelpFragmentViewModel cvvHelpFragmentViewModel);

    protected CvvHelpCardLayoutBinding(Object obj, View view, int i2, ImageView imageView, TextView textView, TextView textView2) {
        super(obj, view, i2);
        this.ivCardLogo = imageView;
        this.tvCvvHelpTitle = textView;
        this.tvDesc = textView2;
    }

    public CvvHelpFragmentViewModel getCvvHelpModel() {
        return this.mCvvHelpModel;
    }

    public static CvvHelpCardLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static CvvHelpCardLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CvvHelpCardLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.cvv_help_card_layout, viewGroup, z, obj);
    }

    public static CvvHelpCardLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static CvvHelpCardLayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CvvHelpCardLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.cvv_help_card_layout, (ViewGroup) null, false, obj);
    }

    public static CvvHelpCardLayoutBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static CvvHelpCardLayoutBinding bind(View view, Object obj) {
        return (CvvHelpCardLayoutBinding) bind(obj, view, R.layout.cvv_help_card_layout);
    }
}
