package net.one97.paytm.wifi.background.wifi;

import com.paytm.utility.q;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import kotlin.g.b.aa;
import kotlin.g.b.k;
import kotlin.m.p;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static String f21150a;

    public static final String a() {
        String str = f21150a;
        if (str != null) {
            if (str == null) {
                k.a();
            }
            return str;
        }
        try {
            Iterator<T> it2 = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it2.hasNext()) {
                NetworkInterface networkInterface = (NetworkInterface) it2.next();
                k.a((Object) networkInterface, "netInterface");
                if (p.a(networkInterface.getName(), "wlan0", true)) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    boolean z = false;
                    for (byte valueOf : hardwareAddress) {
                        aa aaVar = aa.f47921a;
                        String format = String.format("%02X:", Arrays.copyOf(new Object[]{Byte.valueOf(valueOf)}, 1));
                        k.a((Object) format, "java.lang.String.format(format, *args)");
                        sb.append(format);
                    }
                    if (sb.length() > 0) {
                        z = true;
                    }
                    if (z) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    String sb2 = sb.toString();
                    f21150a = sb2;
                    if (sb2 == null) {
                        k.a();
                    }
                    return sb2;
                }
            }
        } catch (Exception e2) {
            q.b(e2.toString());
        }
        return "";
    }

    public static final String a(String str) {
        k.c(str, "ssid");
        return p.b(p.a(str, (CharSequence) "\""), (CharSequence) "\"");
    }

    public static final String b(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || p.a(charSequence)) {
            return "";
        }
        if (str == null) {
            k.a();
        }
        int length = str.length() - 1;
        if (length < 0) {
            return str;
        }
        if (str.charAt(0) == '\"' && str.charAt(length) == '\"') {
            return str;
        }
        return "\"" + str + "\"";
    }

    public static final String c(String str) {
        if (str == null) {
            return str;
        }
        return !(str.length() == 0) ? p.b(p.a(str, (CharSequence) "\""), (CharSequence) "\"") : str;
    }

    public static final String a(int i2) {
        try {
            if (k.a((Object) ByteOrder.LITTLE_ENDIAN, (Object) ByteOrder.nativeOrder())) {
                i2 = Integer.reverseBytes(i2);
            }
            InetAddress byAddress = InetAddress.getByAddress(BigInteger.valueOf((long) i2).toByteArray());
            k.a((Object) byAddress, "InetAddress.getByAddress(ipBytes)");
            String hostAddress = byAddress.getHostAddress();
            k.a((Object) hostAddress, "InetAddress.getByAddress(ipBytes).hostAddress");
            return hostAddress;
        } catch (Exception unused) {
            return "";
        }
    }
}
