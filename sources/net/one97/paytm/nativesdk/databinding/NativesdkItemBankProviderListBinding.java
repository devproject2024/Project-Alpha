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
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.instruments.netbanking.modal.SectionWrapper;
import net.one97.paytm.nativesdk.instruments.netbanking.viewmodel.NBAdapterViewModel;
import net.one97.paytm.nativesdk.widget.RoboTextView;

public abstract class NativesdkItemBankProviderListBinding extends ViewDataBinding {
    public final RelativeLayout bankLogoLayout;
    public final ImageView imgGreenTick;
    public final ImageView ivBankIcon;
    protected NBAdapterViewModel mA;
    protected SectionWrapper mNetbanking;
    protected View mView;
    public final LinearLayout procced;
    public final RelativeLayout rlBankInfo;
    public final RoboTextView tvBankName;
    public final TextView tvDisableErrorMessage;
    public final TextView txtSuccessrate;

    public abstract void setA(NBAdapterViewModel nBAdapterViewModel);

    public abstract void setNetbanking(SectionWrapper sectionWrapper);

    public abstract void setView(View view);

    protected NativesdkItemBankProviderListBinding(Object obj, View view, int i2, RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, RelativeLayout relativeLayout2, RoboTextView roboTextView, TextView textView, TextView textView2) {
        super(obj, view, i2);
        this.bankLogoLayout = relativeLayout;
        this.imgGreenTick = imageView;
        this.ivBankIcon = imageView2;
        this.procced = linearLayout;
        this.rlBankInfo = relativeLayout2;
        this.tvBankName = roboTextView;
        this.tvDisableErrorMessage = textView;
        this.txtSuccessrate = textView2;
    }

    public SectionWrapper getNetbanking() {
        return this.mNetbanking;
    }

    public NBAdapterViewModel getA() {
        return this.mA;
    }

    public View getView() {
        return this.mView;
    }

    public static NativesdkItemBankProviderListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static NativesdkItemBankProviderListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (NativesdkItemBankProviderListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.nativesdk_item_bank_provider_list, viewGroup, z, obj);
    }

    public static NativesdkItemBankProviderListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static NativesdkItemBankProviderListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (NativesdkItemBankProviderListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.nativesdk_item_bank_provider_list, (ViewGroup) null, false, obj);
    }

    public static NativesdkItemBankProviderListBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static NativesdkItemBankProviderListBinding bind(View view, Object obj) {
        return (NativesdkItemBankProviderListBinding) bind(obj, view, R.layout.nativesdk_item_bank_provider_list);
    }
}
