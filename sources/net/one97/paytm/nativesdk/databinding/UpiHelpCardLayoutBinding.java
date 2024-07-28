package net.one97.paytm.nativesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.upiHelp.pojo.UpiHelpModel;
import net.one97.paytm.nativesdk.widget.RoboTextView;

public abstract class UpiHelpCardLayoutBinding extends ViewDataBinding {
    public final ImageView ivGif;
    protected UpiHelpModel mUpiHelpModel;
    public final RoboTextView tvUpiHelpTitle;

    public abstract void setUpiHelpModel(UpiHelpModel upiHelpModel);

    protected UpiHelpCardLayoutBinding(Object obj, View view, int i2, ImageView imageView, RoboTextView roboTextView) {
        super(obj, view, i2);
        this.ivGif = imageView;
        this.tvUpiHelpTitle = roboTextView;
    }

    public UpiHelpModel getUpiHelpModel() {
        return this.mUpiHelpModel;
    }

    public static UpiHelpCardLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static UpiHelpCardLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (UpiHelpCardLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.upi_help_card_layout, viewGroup, z, obj);
    }

    public static UpiHelpCardLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static UpiHelpCardLayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (UpiHelpCardLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.upi_help_card_layout, (ViewGroup) null, false, obj);
    }

    public static UpiHelpCardLayoutBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static UpiHelpCardLayoutBinding bind(View view, Object obj) {
        return (UpiHelpCardLayoutBinding) bind(obj, view, R.layout.upi_help_card_layout);
    }
}
