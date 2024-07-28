package com.uninstallationtracking;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.paytm.contactsSdk.database.ContactColumn;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import net.one97.paytm.upi.util.UpiContract;

public class a {

    /* renamed from: a  reason: collision with root package name */
    protected static volatile UUID f45708a;

    public a(Context context) {
        UUID uuid;
        if (f45708a == null) {
            synchronized (a.class) {
                if (f45708a == null) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("device_id.xml", 0);
                    String string = sharedPreferences.getString("device_id", (String) null);
                    if (string != null) {
                        f45708a = UUID.fromString(string);
                    } else {
                        String string2 = Settings.Secure.getString(context.getContentResolver(), UpiContract.DeviceInfoColumns.ANDROID_ID);
                        try {
                            if (!"9774d56d682e549c".equals(string2)) {
                                f45708a = UUID.nameUUIDFromBytes(string2.getBytes("utf8"));
                            } else {
                                String deviceId = ((TelephonyManager) context.getSystemService(ContactColumn.PHONE_NUMBER)).getDeviceId();
                                if (deviceId != null) {
                                    uuid = UUID.nameUUIDFromBytes(deviceId.getBytes("utf8"));
                                } else {
                                    uuid = UUID.randomUUID();
                                }
                                f45708a = uuid;
                            }
                            sharedPreferences.edit().putString("device_id", f45708a.toString()).commit();
                        } catch (UnsupportedEncodingException e2) {
                            throw new RuntimeException(e2);
                        }
                    }
                }
            }
        }
    }

    public static UUID a() {
        return f45708a;
    }

    public static boolean a(Context context) {
        return (f45708a == null && context.getSharedPreferences("device_id.xml", 0).getString("device_id", (String) null) == null) ? false : true;
    }
}
