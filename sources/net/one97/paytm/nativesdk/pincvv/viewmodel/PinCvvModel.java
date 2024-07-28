package net.one97.paytm.nativesdk.pincvv.viewmodel;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ObservableInt;
import androidx.databinding.i;
import net.one97.paytm.nativesdk.common.listeners.BaseViewActions;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.nativesdk.pincvv.listeners.PinCvvListener;

public class PinCvvModel extends BaseViewModel {
    public i<String> cvvOrPinTitle;
    public ObservableInt cvvVisiblity = new ObservableInt();
    public i<String> forgetText;
    public ObservableInt forgetTextVisibility;
    public PinCvvListener listener;
    public ObservableInt loaderVisiblity = new ObservableInt();
    public ObservableInt pinSize;
    public i<String> subTitle;
    public i<String> title;

    public void completeTransaction(AppCompatActivity appCompatActivity) {
    }

    public void deselectView() {
    }

    public PinCvvModel(PinCvvListener pinCvvListener, String str, String str2, String str3, String str4, int i2) {
        super((Context) null, (BaseViewActions) null);
        this.listener = pinCvvListener;
        this.title = new i<>(str);
        this.subTitle = new i<>(str2);
        this.cvvOrPinTitle = new i<>(str3);
        this.forgetText = new i<>(str4);
        this.forgetTextVisibility = new ObservableInt(0);
        this.pinSize = new ObservableInt(i2);
        this.loaderVisiblity.set(8);
        this.cvvVisiblity.set(0);
    }

    public void pinWatcher(Editable editable) {
        if (editable.length() == this.pinSize.get()) {
            this.listener.finishPinCvvLayout(editable.toString());
        }
    }

    public void crossClicked(View view) {
        this.listener.finishPinCvvLayout((String) null);
    }
}
