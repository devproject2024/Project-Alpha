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
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.instruments.aoa_wallet.viewmodel.AOAWalletViewModel;
import net.one97.paytm.nativesdk.widget.RoboTextView;

public abstract class AoaWalletLayoutBinding extends ViewDataBinding {
    public final RelativeLayout btnProceed;
    public final RelativeLayout cardTextLayout;
    public final ImageView ivRightArrow;
    protected AOAWalletViewModel mAoaWalletViewModel;
    protected View mView;
    public final TextView paysecurely;
    public final RadioButton radioButton;
    public final RelativeLayout topLayout;
    public final TextView tvBankOfferError;
    public final RoboTextView tvCod;
    public final TextView txtamount;

    public abstract void setAoaWalletViewModel(AOAWalletViewModel aOAWalletViewModel);

    public abstract void setView(View view);

    protected AoaWalletLayoutBinding(Object obj, View view, int i2, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, ImageView imageView, TextView textView, RadioButton radioButton2, RelativeLayout relativeLayout3, TextView textView2, RoboTextView roboTextView, TextView textView3) {
        super(obj, view, i2);
        this.btnProceed = relativeLayout;
        this.cardTextLayout = relativeLayout2;
        this.ivRightArrow = imageView;
        this.paysecurely = textView;
        this.radioButton = radioButton2;
        this.topLayout = relativeLayout3;
        this.tvBankOfferError = textView2;
        this.tvCod = roboTextView;
        this.txtamount = textView3;
    }

    public AOAWalletViewModel getAoaWalletViewModel() {
        return this.mAoaWalletViewModel;
    }

    public View getView() {
        return this.mView;
    }

    public static AoaWalletLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static AoaWalletLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AoaWalletLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.aoa_wallet_layout, viewGroup, z, obj);
    }

    public static AoaWalletLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static AoaWalletLayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AoaWalletLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.aoa_wallet_layout, (ViewGroup) null, false, obj);
    }

    public static AoaWalletLayoutBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static AoaWalletLayoutBinding bind(View view, Object obj) {
        return (AoaWalletLayoutBinding) bind(obj, view, R.layout.aoa_wallet_layout);
    }
}
