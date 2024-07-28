package net.one97.paytm.nativesdk.instruments.aoa_wallet.view;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.f;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.databinding.AoaWalletLayoutBinding;
import net.one97.paytm.nativesdk.instruments.Instruments;
import net.one97.paytm.nativesdk.instruments.PaytmBaseView;
import net.one97.paytm.nativesdk.instruments.aoa_wallet.listeners.AOAWalletClickListeners;
import net.one97.paytm.nativesdk.instruments.aoa_wallet.viewmodel.AOAWalletViewModel;

public class AOAWalletView extends PaytmBaseView implements AOAWalletClickListeners {
    private AOAWalletViewModel AOAWalletViewModel;
    private AoaWalletLayoutBinding aoaWalletLayoutBinding;

    public AOAWalletView(Context context, Instruments instruments) {
        super(instruments);
        this.context = context;
    }

    public void refreshLayout() {
        this.AOAWalletViewModel.refreshLayout();
    }

    public PaytmBaseView getAoaWalletView() {
        this.aoaWalletLayoutBinding = (AoaWalletLayoutBinding) f.a((LayoutInflater) this.context.getSystemService("layout_inflater"), R.layout.aoa_wallet_layout, (ViewGroup) null, false);
        this.AOAWalletViewModel = new AOAWalletViewModel(this.context, this);
        this.aoaWalletLayoutBinding.setAoaWalletViewModel(this.AOAWalletViewModel);
        this.view = this.aoaWalletLayoutBinding.getRoot();
        this.aoaWalletLayoutBinding.paysecurely.setText(SDKUtility.getActualPaySecurelyText(this.context));
        return this;
    }

    public void openAutoInstrument() {
        this.AOAWalletViewModel.aoaWalletClicked((View) null);
        isOnceClicked = true;
    }

    public void closeView() {
        this.AOAWalletViewModel.hideBhimUpi();
        this.aoaWalletLayoutBinding.ivRightArrow.setImageResource(R.drawable.ic_right_chevron_dark);
        this.aoaWalletLayoutBinding.tvCod.setTypeface((Typeface) null, 0);
        closeKeyboard();
    }

    public void changeArrowIcon(boolean z) {
        if (z) {
            this.aoaWalletLayoutBinding.ivRightArrow.setImageResource(R.drawable.ic_down_chevron_dark);
            this.aoaWalletLayoutBinding.tvCod.setTypeface((Typeface) null, 1);
            DirectPaymentBL.getInstance().closeOpnedView();
            DirectPaymentBL.getInstance().setPaytmBaseView(this);
            return;
        }
        this.aoaWalletLayoutBinding.ivRightArrow.setImageResource(R.drawable.ic_right_chevron_dark);
        this.aoaWalletLayoutBinding.tvCod.setTypeface((Typeface) null, 0);
        DirectPaymentBL.getInstance().setPaytmBaseView((PaytmBaseView) null);
        SDKUtility.collapse(this.aoaWalletLayoutBinding.topLayout);
    }

    public void showAnimation(boolean z) {
        if (!z && isOnceClicked) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    ObjectAnimator.ofInt(AOAWalletView.this.instruments.getScrollView(), "scrollY", new int[]{(int) AOAWalletView.this.getView().getY()}).setDuration(500).start();
                }
            }, 1000);
            SDKUtility.expand(this.aoaWalletLayoutBinding.topLayout, 500);
        }
    }

    public void closeKeyboard() {
        try {
            if (!SDKUtility.hideKeyboard((Activity) this.context)) {
                SDKUtility.hideKeyboard(this.aoaWalletLayoutBinding.btnProceed, this.context);
            }
        } catch (Exception unused) {
        }
    }

    public void showBankOfferErrorText() {
        this.aoaWalletLayoutBinding.tvBankOfferError.setVisibility(0);
    }
}
