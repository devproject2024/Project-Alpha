package com.paytm.signal.c;

import android.content.Context;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.format.Formatter;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.notification.b.e;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.upi.util.UpiContract;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f43630a = new c();

    private c() {
    }

    public static String a(Context context) {
        k.c(context, "context");
        Object systemService = context.getSystemService(ContactColumn.PHONE_NUMBER);
        if (systemService != null) {
            String networkOperatorName = ((TelephonyManager) systemService).getNetworkOperatorName();
            k.a((Object) networkOperatorName, "manager.networkOperatorName");
            return networkOperatorName;
        }
        throw new u("null cannot be cast to non-null type android.telephony.TelephonyManager");
    }

    public static String a() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            k.a((Object) networkInterfaces, "NetworkInterface.getNetworkInterfaces()");
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (nextElement != null) {
                    Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                    k.a((Object) inetAddresses, "intf.inetAddresses");
                    while (true) {
                        if (inetAddresses.hasMoreElements()) {
                            InetAddress nextElement2 = inetAddresses.nextElement();
                            if (nextElement2 != null) {
                                InetAddress inetAddress = nextElement2;
                                if (!inetAddress.isLoopbackAddress()) {
                                    String formatIpAddress = Formatter.formatIpAddress(inetAddress.hashCode());
                                    e.f43014a.b("ContentValues", "***** IP=".concat(String.valueOf(formatIpAddress)));
                                    return formatIpAddress;
                                }
                            } else {
                                throw new u("null cannot be cast to non-null type java.net.InetAddress");
                            }
                        }
                    }
                } else {
                    throw new u("null cannot be cast to non-null type java.net.NetworkInterface");
                }
            }
            return null;
        } catch (SocketException e2) {
            e.f43014a.c("ContentValues", e2.toString());
            return null;
        } catch (Exception e3) {
            e.f43014a.c("ContentValues", e3.toString());
            return null;
        }
    }

    public static String b(Context context) {
        k.c(context, "context");
        try {
            return Settings.Secure.getString(context.getContentResolver(), UpiContract.DeviceInfoColumns.ANDROID_ID);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
