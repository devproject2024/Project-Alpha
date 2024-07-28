package net.one97.paytm.nativesdk.instruments.wallet.viewmodel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import kotlin.g.b.k;

public final class WalletOtpViewModel$myReceiver$1 extends BroadcastReceiver {
    final /* synthetic */ WalletOtpViewModel this$0;

    WalletOtpViewModel$myReceiver$1(WalletOtpViewModel walletOtpViewModel) {
        this.this$0 = walletOtpViewModel;
    }

    public final void onReceive(Context context, Intent intent) {
        k.c(context, "context");
        if (intent != null) {
            try {
                if (intent.getAction() != null && k.a((Object) intent.getAction(), (Object) "android.provider.Telephony.SMS_RECEIVED")) {
                    String str = "";
                    if (Build.VERSION.SDK_INT >= 19) {
                        for (SmsMessage smsMessage : Telephony.Sms.Intents.getMessagesFromIntent(intent)) {
                            k.a((Object) smsMessage, "smsMessage");
                            String displayOriginatingAddress = smsMessage.getDisplayOriginatingAddress();
                            k.a((Object) displayOriginatingAddress, "smsMessage.displayOriginatingAddress");
                            str = str + smsMessage.getMessageBody();
                            this.this$0.checkSms(str, displayOriginatingAddress);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }
}
