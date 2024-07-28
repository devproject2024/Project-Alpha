package org.npci.upi.security.pinactivitycomponent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import java.util.Date;

class u extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GetCredential f73004a;

    private u(GetCredential getCredential) {
        this.f73004a = getCredential;
    }

    /* synthetic */ u(GetCredential getCredential, m mVar) {
        this(getCredential);
    }

    private void a(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            Object[] objArr = (Object[]) extras.get("pdus");
            SmsMessage[] smsMessageArr = new SmsMessage[objArr.length];
            for (int i2 = 0; i2 < smsMessageArr.length; i2++) {
                smsMessageArr[i2] = SmsMessage.createFromPdu((byte[]) objArr[i2]);
                String upperCase = smsMessageArr[i2].getOriginatingAddress().toUpperCase();
                String upperCase2 = smsMessageArr[i2].getMessageBody().toUpperCase();
                new Date(smsMessageArr[i2].getTimestampMillis());
                am a2 = new an(this.f73004a.context).a(this.f73004a.numDigitsOfOTP, upperCase, upperCase2);
                if (a2 != null) {
                    this.f73004a.currentFragment.b(a2);
                }
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        try {
            if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {
                a(intent);
            }
        } catch (Exception e2) {
            ad.a(GetCredential.TAG, e2);
        }
    }
}
