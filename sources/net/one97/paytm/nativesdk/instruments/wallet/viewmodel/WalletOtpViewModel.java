package net.one97.paytm.nativesdk.instruments.wallet.viewmodel;

import android.app.Application;
import android.content.IntentFilter;
import android.text.Editable;
import android.text.TextWatcher;
import androidx.lifecycle.a;
import androidx.lifecycle.aa;
import androidx.lifecycle.k;
import androidx.lifecycle.y;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.g.b.k;

public final class WalletOtpViewModel extends a implements TextWatcher {
    private y<Boolean> isValidated = new y<>();
    private y<String> mOtpTextChanged = new y<>();
    private Application mcontext;
    private final WalletOtpViewModel$myReceiver$1 myReceiver = new WalletOtpViewModel$myReceiver$1(this);
    private y<String> otpText = new y<>();

    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletOtpViewModel(Application application) {
        super(application);
        k.c(application, "context");
        this.mcontext = application;
    }

    public final y<Boolean> isValidated() {
        return this.isValidated;
    }

    public final void setValidated(y<Boolean> yVar) {
        k.c(yVar, "<set-?>");
        this.isValidated = yVar;
    }

    public final y<String> getOtpText() {
        return this.otpText;
    }

    public final void setOtpText(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this.otpText = yVar;
    }

    public final y<String> getMOtpTextChanged() {
        return this.mOtpTextChanged;
    }

    public final void setMOtpTextChanged(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this.mOtpTextChanged = yVar;
    }

    public final void registerOtpBroadCast() {
        this.mcontext.registerReceiver(this.myReceiver, new IntentFilter("android.provider.Telephony.SMS_RECEIVED"));
    }

    /* access modifiers changed from: private */
    public final void checkSms(String str, String str2) {
        Matcher matcher = Pattern.compile("\\d{6}").matcher(str);
        if (matcher.find()) {
            Matcher matcher2 = Pattern.compile("\\d{6}").matcher(matcher.group(0));
            if (matcher2.find()) {
                this.otpText.postValue(matcher2.group(0));
            }
        }
    }

    public final void afterTextChanged(Editable editable) {
        this.mOtpTextChanged.postValue(String.valueOf(editable));
    }

    @aa(a = k.a.ON_STOP)
    public final void unRegisterOtpDetect() {
        this.mcontext.unregisterReceiver(this.myReceiver);
    }
}
