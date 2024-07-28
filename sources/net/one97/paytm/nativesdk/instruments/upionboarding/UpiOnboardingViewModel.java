package net.one97.paytm.nativesdk.instruments.upionboarding;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ObservableInt;
import androidx.databinding.i;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.common.listeners.BaseViewActions;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;

public class UpiOnboardingViewModel extends BaseViewModel {
    private Context context;
    public i<String> paySecurelyText = new i<>();
    public ObservableInt proceedButtonVisibility = new ObservableInt(8);

    public void completeTransaction(AppCompatActivity appCompatActivity) {
    }

    public void deselectView() {
    }

    public UpiOnboardingViewModel(Context context2) {
        super(context2, (BaseViewActions) null);
        this.context = context2;
        setPaySecurelyText();
    }

    public void setPaySecurelyText() {
        this.paySecurelyText.set(this.context.getString(R.string.native_upi_option_pay));
    }
}
