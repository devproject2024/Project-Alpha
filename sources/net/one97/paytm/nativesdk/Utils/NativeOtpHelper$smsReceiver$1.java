package net.one97.paytm.nativesdk.Utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import kotlin.g.b.k;

public final class NativeOtpHelper$smsReceiver$1 extends BroadcastReceiver {
    final /* synthetic */ NativeOtpHelper this$0;

    NativeOtpHelper$smsReceiver$1(NativeOtpHelper nativeOtpHelper) {
        this.this$0 = nativeOtpHelper;
    }

    public final void onReceive(Context context, Intent intent) {
        k.c(context, "context");
        k.c(intent, "intent");
        try {
            if (k.a((Object) intent.getAction(), (Object) "android.provider.Telephony.SMS_RECEIVED")) {
                String str = "";
                if (Build.VERSION.SDK_INT >= 19) {
                    for (SmsMessage smsMessage : Telephony.Sms.Intents.getMessagesFromIntent(intent)) {
                        k.a((Object) smsMessage, "smsMessage");
                        String displayOriginatingAddress = smsMessage.getDisplayOriginatingAddress();
                        k.a((Object) displayOriginatingAddress, "smsMessage.displayOriginatingAddress");
                        str = str + smsMessage.getMessageBody();
                        this.this$0.checkSms(str, displayOriginatingAddress);
                    }
                    return;
                }
                this.this$0.getDataFromSmsBundle(intent);
            }
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
        }
    }
}
