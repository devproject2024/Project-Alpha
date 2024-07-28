package net.one97.paytm.nativesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.widget.RoboTextView;

public abstract class UpiHelpLayoutMainBinding extends ViewDataBinding {
    public final Button btnProceed;
    public final ImageView crossIcon;
    public final TextView tvInfo;
    public final TextView tvSeeHow;
    public final RoboTextView tvUpiHelpTitle;

    protected UpiHelpLayoutMainBinding(Object obj, View view, int i2, Button button, ImageView imageView, TextView textView, TextView textView2, RoboTextView roboTextView) {
        super(obj, view, i2);
        this.btnProceed = button;
        this.crossIcon = imageView;
        this.tvInfo = textView;
        this.tvSeeHow = textView2;
        this.tvUpiHelpTitle = roboTextView;
    }

    public static UpiHelpLayoutMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static UpiHelpLayoutMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (UpiHelpLayoutMainBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.upi_help_layout_main, viewGroup, z, obj);
    }

    public static UpiHelpLayoutMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static UpiHelpLayoutMainBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (UpiHelpLayoutMainBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.upi_help_layout_main, (ViewGroup) null, false, obj);
    }

    public static UpiHelpLayoutMainBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static UpiHelpLayoutMainBinding bind(View view, Object obj) {
        return (UpiHelpLayoutMainBinding) bind(obj, view, R.layout.upi_help_layout_main);
    }
}
