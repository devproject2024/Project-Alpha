package net.one97.paytm.nativesdk.otp.Receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import net.one97.paytm.nativesdk.Utils.LogUtility;
import net.one97.paytm.nativesdk.otp.Listner.OTPListner;

public class SmsReceiver extends BroadcastReceiver {
    private static final String TAG = SmsReceiver.class.getCanonicalName();
    private OTPListner mSmsListener;

    public void setSmsListener(OTPListner oTPListner) {
        this.mSmsListener = oTPListner;
    }

    public void onReceive(Context context, Intent intent) {
        Bundle extras;
        try {
            if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED") && (extras = intent.getExtras()) != null) {
                Object[] objArr = (Object[]) extras.get("pdus");
                SmsMessage[] smsMessageArr = new SmsMessage[objArr.length];
                String str = "";
                String str2 = str;
                for (int i2 = 0; i2 < smsMessageArr.length; i2++) {
                    smsMessageArr[i2] = SmsMessage.createFromPdu((byte[]) objArr[i2]);
                    str = smsMessageArr[i2].getOriginatingAddress();
                    str2 = str2 + smsMessageArr[i2].getMessageBody();
                }
                LogUtility.d(TAG, "======otp received=======");
                LogUtility.d("====from======", str);
                LogUtility.d(TAG, "=====body=====".concat(String.valueOf(str2)));
                if (this.mSmsListener != null) {
                    this.mSmsListener.onSmsReceived(str, str2);
                }
            }
        } catch (Exception e2) {
            e2.getMessage();
        }
    }
}
