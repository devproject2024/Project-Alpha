package net.one97.paytm.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import com.paytm.utility.b;
import com.paytm.utility.q;

public class CJRSmsReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public ah f69560a;

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
                if (this.f69560a != null) {
                    this.f69560a.b(str, str2);
                }
            }
        } catch (Exception e2) {
            if (b.v) {
                q.d(String.valueOf(e2));
            }
        }
    }
}
