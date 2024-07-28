package net.one97.paytm.transport.iocl_v1.others;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import com.paytm.utility.b;

public class CJRSmsReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public a f14457a;

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
                if (this.f14457a != null) {
                    this.f14457a.a(str, str2);
                }
            }
        } catch (Exception e2) {
            if (b.v) {
                e2.printStackTrace();
            }
        }
    }
}
