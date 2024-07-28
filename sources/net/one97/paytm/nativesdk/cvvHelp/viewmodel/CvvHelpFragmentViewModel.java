package net.one97.paytm.nativesdk.cvvHelp.viewmodel;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.i;
import net.one97.paytm.nativesdk.common.listeners.BaseViewActions;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;

public class CvvHelpFragmentViewModel extends BaseViewModel {
    public ObservableBoolean amexCard;
    public i<String> description;
    public i<String> title;

    public void completeTransaction(AppCompatActivity appCompatActivity) {
    }

    public void deselectView() {
    }

    public CvvHelpFragmentViewModel(String str, String str2, Boolean bool) {
        super((Context) null, (BaseViewActions) null);
        this.title = new i<>(str);
        this.description = new i<>(str2);
        this.amexCard = new ObservableBoolean(bool.booleanValue());
    }
}
