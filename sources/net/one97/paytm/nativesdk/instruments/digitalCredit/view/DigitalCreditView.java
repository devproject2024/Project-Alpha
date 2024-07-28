package net.one97.paytm.nativesdk.instruments.digitalCredit.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.f;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.common.model.PaymentModes;
import net.one97.paytm.nativesdk.databinding.DigitalCreditInfoLytBinding;
import net.one97.paytm.nativesdk.instruments.Instruments;
import net.one97.paytm.nativesdk.instruments.PaytmBaseView;
import net.one97.paytm.nativesdk.instruments.digitalCredit.listeners.DigitalCreditLisnter;
import net.one97.paytm.nativesdk.instruments.digitalCredit.viewmodel.DigitalCreditViewModel;

public class DigitalCreditView extends PaytmBaseView implements DigitalCreditLisnter {
    private DigitalCreditInfoLytBinding digitalCreditInfoLytBinding;
    private DigitalCreditViewModel digitalCreditViewModel;
    private boolean isValid;
    private PaymentModes wallet;

    public void closeView() {
    }

    public void openAutoInstrument() {
    }

    public DigitalCreditView(Context context, Instruments instruments, boolean z) {
        super(instruments);
        this.context = context;
        this.isValid = z;
    }

    public PaytmBaseView getDigitalCreditView(PaymentModes paymentModes) {
        this.digitalCreditInfoLytBinding = (DigitalCreditInfoLytBinding) f.a((LayoutInflater) this.context.getSystemService("layout_inflater"), R.layout.digital_credit_info_lyt, (ViewGroup) null, false);
        this.wallet = paymentModes;
        enableDisableView(this.isValid);
        this.digitalCreditViewModel = new DigitalCreditViewModel(this.context, paymentModes, this, this.isValid);
        this.digitalCreditInfoLytBinding.setDigitalCreditModel(this.digitalCreditViewModel);
        setSelectedViewBold();
        setTSecondaryTextColor();
        this.view = this.digitalCreditInfoLytBinding.getRoot();
        return this;
    }

    private void setSelectedViewBold() {
        if (!this.isValid || DirectPaymentBL.getInstance().getSelectedInstrument() == null || !DirectPaymentBL.getInstance().getSelectedInstrument().getPrimaryName().equalsIgnoreCase(this.wallet.getDisplayName())) {
            this.digitalCreditInfoLytBinding.txtPrimaryInfo.setTypeface((Typeface) null, 0);
            this.digitalCreditInfoLytBinding.rbCardNumber.setButtonDrawable(R.drawable.native_ic_radio_inactive);
            return;
        }
        this.digitalCreditInfoLytBinding.txtPrimaryInfo.setTypeface((Typeface) null, 1);
        this.digitalCreditInfoLytBinding.rbCardNumber.setButtonDrawable(R.drawable.native_ic_radio_active_btn);
        DirectPaymentBL.getInstance().getSelectedInstrument().setBaseViewModel(this.digitalCreditViewModel);
    }

    public void closeCachierSheet() {
        this.instruments.closeCashierSheet();
    }

    private void enableDisableView(boolean z) {
        if (z) {
            this.digitalCreditInfoLytBinding.txtPrimaryInfo.setAlpha(1.0f);
            this.digitalCreditInfoLytBinding.txtPrimaryInfo.setAlpha(1.0f);
            this.digitalCreditInfoLytBinding.txtSecondaryInfo.setAlpha(1.0f);
            this.digitalCreditInfoLytBinding.rbCardNumber.setAlpha(1.0f);
            return;
        }
        this.digitalCreditInfoLytBinding.txtPrimaryInfo.setAlpha(0.4f);
        this.digitalCreditInfoLytBinding.txtPrimaryInfo.setAlpha(0.4f);
        this.digitalCreditInfoLytBinding.txtSecondaryInfo.setAlpha(0.4f);
        this.digitalCreditInfoLytBinding.rbCardNumber.setAlpha(0.4f);
    }

    private void setTSecondaryTextColor() {
        if (this.digitalCreditViewModel.mSecondaryInformation.get().equalsIgnoreCase(this.context.getString(R.string.check_balance))) {
            this.digitalCreditInfoLytBinding.txtSecondaryInfo.setTextColor(this.context.getResources().getColor(R.color.color_00b9f5));
        } else {
            this.digitalCreditInfoLytBinding.txtSecondaryInfo.setTextColor(this.context.getResources().getColor(R.color.color_222222));
        }
    }

    public void onFetchBalance() {
        setTSecondaryTextColor();
    }

    public void disableView(boolean z) {
        enableDisableView(!z);
    }

    public void deselectView() {
        this.digitalCreditInfoLytBinding.txtPrimaryInfo.setTypeface((Typeface) null, 0);
        this.digitalCreditInfoLytBinding.rbCardNumber.setButtonDrawable(R.drawable.native_ic_radio_inactive);
    }

    public void showAnimation(boolean z) {
        if (!z) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    ObjectAnimator.ofInt(DigitalCreditView.this.instruments.getScrollView(), "scrollY", new int[]{(int) DigitalCreditView.this.getView().getY()}).setDuration(1000).start();
                }
            }, 200);
        }
    }
}
