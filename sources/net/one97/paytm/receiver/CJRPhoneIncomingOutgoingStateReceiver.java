package net.one97.paytm.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.ArrayList;
import net.one97.paytm.f.a;
import net.one97.paytm.utils.l;

public class CJRPhoneIncomingOutgoingStateReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static int f60172a;

    /* renamed from: b  reason: collision with root package name */
    private int f60173b;

    public void onReceive(final Context context, Intent intent) {
        if (intent != null) {
            this.f60173b = 0;
            String stringExtra = intent.getStringExtra("state");
            final String stringExtra2 = intent.getStringExtra("incoming_number");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                if (stringExtra.equals(TelephonyManager.EXTRA_STATE_IDLE)) {
                    this.f60173b = 0;
                } else if (stringExtra.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)) {
                    this.f60173b = 2;
                } else if (stringExtra.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
                    this.f60173b = 1;
                }
                int i2 = this.f60173b;
                int i3 = f60172a;
                if (i3 != i2) {
                    if (i2 != 1 && i2 == 2) {
                        if (i3 == 1) {
                            new Thread(new Runnable() {

                                /* renamed from: a  reason: collision with root package name */
                                String f60174a = stringExtra2;

                                public final void run() {
                                    String str = stringExtra2;
                                    if (str != null) {
                                        if (str.startsWith("0", 0)) {
                                            this.f60174a = stringExtra2.substring(1);
                                        } else if (stringExtra2.startsWith("91") && stringExtra2.length() > 10) {
                                            this.f60174a = stringExtra2.substring(2);
                                        } else if (stringExtra2.startsWith("+91")) {
                                            this.f60174a = stringExtra2.substring(3);
                                        }
                                    }
                                    a.a().a(this.f60174a, l.b(context, this.f60174a).isContactExits(), false);
                                    a.a().b();
                                }
                            }).start();
                        } else {
                            a a2 = a.a();
                            if (a2.f50395b == null) {
                                a2.f50395b = new ArrayList<>();
                            }
                            if (!a2.f50395b.contains(stringExtra2)) {
                                if (a2.f50395b.size() >= 3) {
                                    a2.f50395b.remove(a2.f50395b.size() - 1);
                                }
                                a2.f50395b.add(0, stringExtra2);
                            }
                        }
                    }
                    f60172a = i2;
                }
            }
        }
    }
}
