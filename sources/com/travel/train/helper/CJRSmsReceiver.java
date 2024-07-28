package com.travel.train.helper;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.travel.train.i.j;

public class CJRSmsReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public j f27253a;

    /* renamed from: b  reason: collision with root package name */
    private String f27254b = "CJRSmsReceiver";

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
                if (this.f27253a != null) {
                    this.f27253a.a(str, str2);
                }
            }
        } catch (Exception e2) {
            if (b.v) {
                q.c(e2.getMessage());
            }
        }
    }
}
