package net.one97.paytm.upgradeKyc.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

public class KycSmsReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public a f66314a;

    public interface a {
        void a(String str, String str2);
    }

    public void onReceive(Context context, Intent intent) {
        try {
            if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {
                Bundle extras = intent.getExtras();
                String str = "";
                StringBuilder sb = new StringBuilder();
                if (extras != null) {
                    Object[] objArr = (Object[]) extras.get("pdus");
                    SmsMessage[] smsMessageArr = new SmsMessage[objArr.length];
                    for (int i2 = 0; i2 < smsMessageArr.length; i2++) {
                        smsMessageArr[i2] = SmsMessage.createFromPdu((byte[]) objArr[i2]);
                        str = smsMessageArr[i2].getOriginatingAddress();
                        sb.append(smsMessageArr[i2].getMessageBody());
                    }
                    if (this.f66314a != null) {
                        this.f66314a.a(str, sb.toString());
                    }
                }
            }
        } catch (Exception unused) {
        }
    }
}
