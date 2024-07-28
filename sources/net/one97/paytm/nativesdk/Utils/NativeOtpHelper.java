package net.one97.paytm.nativesdk.Utils;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsMessage;
import androidx.core.app.a;
import androidx.core.content.b;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.nativesdk.common.listeners.OtpListener;

public final class NativeOtpHelper {
    private final Activity mActivity;
    private final OtpListener mOtpListener;
    private final BroadcastReceiver smsReceiver = new NativeOtpHelper$smsReceiver$1(this);
    private String smsTrackingTime = "0";

    public NativeOtpHelper(Activity activity, OtpListener otpListener) {
        k.c(activity, "mActivity");
        this.mActivity = activity;
        this.mOtpListener = otpListener;
    }

    public final void onStartOtpHelper() {
        try {
            if (hasSmsPermission()) {
                IntentFilter intentFilter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
                requestReadSmsPermission();
                this.mActivity.registerReceiver(this.smsReceiver, intentFilter);
            }
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
        }
    }

    public final void requestReadSmsPermission() {
        try {
            if (!a.a(this.mActivity, "android.permission.RECEIVE_SMS")) {
                a.a(this.mActivity, new String[]{"android.permission.READ_SMS"}, 102);
            }
        } catch (Exception unused) {
        }
    }

    public final void onStopOtpHelper() {
        try {
            if (hasSmsPermission()) {
                this.mActivity.unregisterReceiver(this.smsReceiver);
            }
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
        }
    }

    public final boolean hasReadSmsPermission() {
        return b.a((Context) this.mActivity, "android.permission.READ_SMS") == 0;
    }

    public final boolean hasOnlyReceiveSmsPermission() {
        try {
            return b.a((Context) this.mActivity, "android.permission.RECEIVE_SMS") == 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean hasSmsPermission() {
        try {
            if (b.a((Context) this.mActivity, "android.permission.READ_SMS") == 0 && b.a((Context) this.mActivity, "android.permission.RECEIVE_SMS") == 0) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public final void requestReceiveSmsPermission() {
        try {
            if (!a.a(this.mActivity, "android.permission.READ_SMS")) {
                a.a(this.mActivity, new String[]{"android.permission.RECEIVE_SMS"}, 102);
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public final void checkSms(String str, String str2) {
        Matcher matcher = Pattern.compile("\\d{6}").matcher(str);
        if (matcher.find()) {
            Matcher matcher2 = Pattern.compile("\\d{6}").matcher(matcher.group(0));
            if (matcher2.find()) {
                String group = matcher2.group(0);
                OtpListener otpListener = this.mOtpListener;
                if (otpListener != null) {
                    k.a((Object) group, "receivedOtp");
                    otpListener.onOtpReceived(group);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void getDataFromSmsBundle(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            try {
                Object obj = extras.get("pdus");
                if (obj != null) {
                    Object[] objArr = (Object[]) obj;
                    SmsMessage[] smsMessageArr = new SmsMessage[objArr.length];
                    int i2 = 0;
                    int length = smsMessageArr.length;
                    while (i2 < length) {
                        Object obj2 = objArr[i2];
                        if (obj2 != null) {
                            smsMessageArr[i2] = SmsMessage.createFromPdu((byte[]) obj2);
                            SmsMessage smsMessage = smsMessageArr[i2];
                            if (smsMessage == null) {
                                k.a();
                            }
                            String originatingAddress = smsMessage.getOriginatingAddress();
                            SmsMessage smsMessage2 = smsMessageArr[i2];
                            if (smsMessage2 == null) {
                                k.a();
                            }
                            String messageBody = smsMessage2.getMessageBody();
                            k.a((Object) messageBody, "msgBody");
                            checkSms(messageBody, originatingAddress);
                            i2++;
                        } else {
                            throw new u("null cannot be cast to non-null type kotlin.ByteArray");
                        }
                    }
                    return;
                }
                throw new u("null cannot be cast to non-null type kotlin.Array<*>");
            } catch (Exception unused) {
            }
        }
    }

    private final void checkSMSAlreadyExist(Activity activity) {
        if (activity != null) {
            try {
                Activity activity2 = this.mActivity;
                Cursor cursor = null;
                ContentResolver contentResolver = activity2 != null ? activity2.getContentResolver() : null;
                if (contentResolver != null) {
                    cursor = contentResolver.query(Uri.parse("content://sms/inbox"), (String[]) null, "date>=?", new String[]{this.smsTrackingTime}, (String) null);
                }
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        int columnIndex = cursor.getColumnIndex("body");
                        int columnIndex2 = cursor.getColumnIndex(AddEditGstinViewModelKt.BODY_PARAM_ADDRESS);
                        String string = cursor.getString(columnIndex);
                        String string2 = cursor.getString(columnIndex2);
                        k.a((Object) string, "body");
                        checkSms(string, string2);
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (NullPointerException unused) {
            }
        }
    }
}
