package net.one97.paytm.nativesdk.instruments.cod.view;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.f;
import net.one97.paytm.nativesdk.ConvenienceFeeController;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.databinding.CodLayoutBinding;
import net.one97.paytm.nativesdk.instruments.Instruments;
import net.one97.paytm.nativesdk.instruments.PaytmBaseView;
import net.one97.paytm.nativesdk.instruments.cod.listeners.CodClickListener;
import net.one97.paytm.nativesdk.instruments.cod.viewmodel.CodViewModel;

public class CodView extends PaytmBaseView implements CodClickListener {
    private CodLayoutBinding codLayoutBinding;
    private CodViewModel codViewModel;

    public void changeOfferTextBgColor(int i2, int i3, boolean z) {
    }

    public void startCheckingOfferAnimation() {
    }

    public void stopCheckingOfferAnimation() {
    }

    public CodView(Context context, Instruments instruments) {
        super(instruments);
        this.context = context;
    }

    public void refreshLayout() {
        this.codViewModel.refreshLayout();
    }

    public PaytmBaseView getCODView() {
        this.codLayoutBinding = (CodLayoutBinding) f.a((LayoutInflater) this.context.getSystemService("layout_inflater"), R.layout.cod_layout, (ViewGroup) null, false);
        this.codViewModel = new CodViewModel(this.context, this);
        this.codLayoutBinding.setCodViewModel(this.codViewModel);
        this.view = this.codLayoutBinding.getRoot();
        this.codLayoutBinding.paysecurely.setText(SDKUtility.getActualPaySecurelyText(this.context));
        return this;
    }

    public void openAutoInstrument() {
        this.codViewModel.codClicked((View) null);
        isOnceClicked = true;
    }

    public void closeView() {
        this.codViewModel.hideBhimUpi();
        this.codLayoutBinding.ivRightArrow.setImageResource(R.drawable.ic_right_chevron_dark);
        this.codLayoutBinding.tvCod.setTypeface((Typeface) null, 0);
        closeKeyboard();
    }

    public void changeArrowIcon(boolean z) {
        if (z) {
            this.codLayoutBinding.ivRightArrow.setImageResource(R.drawable.ic_down_chevron_dark);
            this.codLayoutBinding.tvCod.setTypeface((Typeface) null, 1);
            DirectPaymentBL.getInstance().closeOpnedView();
            DirectPaymentBL.getInstance().setPaytmBaseView(this);
            return;
        }
        this.codLayoutBinding.ivRightArrow.setImageResource(R.drawable.ic_right_chevron_dark);
        this.codLayoutBinding.tvCod.setTypeface((Typeface) null, 0);
        DirectPaymentBL.getInstance().setPaytmBaseView((PaytmBaseView) null);
        SDKUtility.collapse(this.codLayoutBinding.topLayout);
    }

    public void showAnimation(boolean z) {
        if (!z && isOnceClicked) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    ObjectAnimator.ofInt(CodView.this.instruments.getScrollView(), "scrollY", new int[]{(int) CodView.this.getView().getY()}).setDuration(500).start();
                }
            }, 1000);
            SDKUtility.expand(this.codLayoutBinding.topLayout, 500);
        }
    }

    public void changeRemainingAmt(String str) {
        if (TextUtils.isEmpty(str)) {
            this.codLayoutBinding.tvRemainingAmtTxt.setVisibility(8);
        } else if (ConvenienceFeeController.getInstance().hasOverflowConvenienceFee()) {
            String postConvenienceFeeDisplayAmount = ConvenienceFeeController.getInstance().getPostConvenienceFeeDisplayAmount();
            this.codLayoutBinding.tvRemainingAmtTxt.setText(this.context.getString(R.string.please_pay_txt, new Object[]{postConvenienceFeeDisplayAmount}));
            this.codLayoutBinding.paysecurely.setText(this.context.getString(R.string.nativesdk_amount_pay, new Object[]{postConvenienceFeeDisplayAmount}));
        } else {
            this.codLayoutBinding.tvRemainingAmtTxt.setText(this.context.getString(R.string.please_pay_txt, new Object[]{SDKUtility.priceWithoutDecimal(str)}));
            this.codLayoutBinding.paysecurely.setText(this.context.getString(R.string.nativesdk_amount_pay, new Object[]{SDKUtility.priceWithoutDecimal(str)}));
        }
    }

    public void closeKeyboard() {
        try {
            if (!SDKUtility.hideKeyboard((Activity) this.context)) {
                SDKUtility.hideKeyboard(this.codLayoutBinding.btnProceed, this.context);
            }
        } catch (Exception unused) {
        }
    }

    public void showBankOfferText() {
        this.codLayoutBinding.tvBankOfferError.setVisibility(0);
    }

    public void enableProceedButton() {
        this.codLayoutBinding.btnProceed.setEnabled(true);
        this.codLayoutBinding.btnProceed.setClickable(true);
    }

    public void disableProceedButton() {
        this.codLayoutBinding.btnProceed.setEnabled(false);
        this.codLayoutBinding.btnProceed.setClickable(false);
    }
}
