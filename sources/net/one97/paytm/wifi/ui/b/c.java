package net.one97.paytm.wifi.ui.b;

import com.paytm.utility.q;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.wifi.models.WifiActivePlan;
import net.one97.paytm.wifi.models.WifiPlan;
import net.one97.paytm.wifi.models.WifiTimeData;

public final class c {
    public static final String a(WifiPlan wifiPlan) {
        k.c(wifiPlan, "receiver$0");
        CharSequence data = wifiPlan.getData();
        if (data == null || data.length() == 0) {
            return "";
        }
        if (p.a(wifiPlan.getData(), "0", false)) {
            return "Unlimited Data";
        }
        try {
            String data2 = wifiPlan.getData();
            if (data2 == null) {
                k.a();
            }
            double parseLong = (double) (Long.parseLong(data2) / 1048576);
            String str = "MB Data";
            if (parseLong >= 1024.0d) {
                parseLong /= 1024.0d;
                str = "GB Data";
            }
            return parseLong + ' ' + str;
        } catch (Exception unused) {
            return "";
        }
    }

    public static final String a(WifiActivePlan wifiActivePlan) {
        k.c(wifiActivePlan, "receiver$0");
        CharSequence data = wifiActivePlan.getData();
        if (data == null || data.length() == 0) {
            return "";
        }
        if (p.a(wifiActivePlan.getData(), "0", false)) {
            return "Unlimited Data";
        }
        try {
            String data2 = wifiActivePlan.getData();
            if (data2 == null) {
                k.a();
            }
            double parseLong = (double) (Long.parseLong(data2) / 1048576);
            String str = "MB Data";
            if (parseLong >= 1024.0d) {
                parseLong /= 1024.0d;
                str = "GB Data";
            }
            return parseLong + ' ' + str;
        } catch (Exception unused) {
            return "";
        }
    }

    public static final String b(WifiActivePlan wifiActivePlan) {
        k.c(wifiActivePlan, "receiver$0");
        CharSequence downloadRate = wifiActivePlan.getDownloadRate();
        if (downloadRate == null || downloadRate.length() == 0) {
            return "";
        }
        String downloadRate2 = wifiActivePlan.getDownloadRate();
        if (downloadRate2 == null) {
            k.a();
        }
        return (Long.parseLong(downloadRate2) / 1024) + ".00 Mb/s";
    }

    public static final WifiTimeData a(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            return new WifiTimeData(0, 0, 0);
        }
        try {
            q.d("duration : ".concat(String.valueOf(str)));
            if (str == null) {
                k.a();
            }
            long parseLong = Long.parseLong(str);
            if (parseLong >= 0) {
                return new WifiTimeData(parseLong / 86400, (parseLong % 86400) / 3600, (parseLong % 3600) / 60);
            }
        } catch (Exception unused) {
        }
        return new WifiTimeData(0, 0, 0);
    }

    public static final String b(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            return "0 MB";
        }
        if (str == null) {
            try {
                k.a();
            } catch (Exception unused) {
                return "0 MB";
            }
        }
        double parseLong = (double) (Long.parseLong(str) / 1048576);
        String str2 = "MB";
        if (parseLong >= 1024.0d) {
            parseLong /= 1024.0d;
            str2 = "GB";
        }
        String a2 = a(parseLong);
        return a2 + ' ' + str2;
    }

    private static String a(double d2) {
        try {
            NumberFormat numberInstance = NumberFormat.getNumberInstance(Locale.US);
            if (numberInstance != null) {
                DecimalFormat decimalFormat = (DecimalFormat) numberInstance;
                decimalFormat.setMaximumFractionDigits(2);
                decimalFormat.setMinimumFractionDigits(2);
                String format = decimalFormat.format(d2);
                k.a((Object) format, "formatter.format(price)");
                return format;
            }
            throw new u("null cannot be cast to non-null type java.text.DecimalFormat");
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static final WifiTimeData c(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            return new WifiTimeData(0, 0, 0);
        }
        try {
            q.d("expiry : ".concat(String.valueOf(str)));
            if (str == null) {
                k.a();
            }
            long parseLong = Long.parseLong(str);
            q.d("expiry in seconds: ".concat(String.valueOf(parseLong)));
            long currentTimeMillis = parseLong - (System.currentTimeMillis() / 1000);
            q.d("expiry diff: ".concat(String.valueOf(currentTimeMillis)));
            if (currentTimeMillis >= 0) {
                return new WifiTimeData(currentTimeMillis / 86400, (currentTimeMillis % 86400) / 3600, (currentTimeMillis % 3600) / 60);
            }
        } catch (Exception unused) {
        }
        return new WifiTimeData(0, 0, 0);
    }

    public static final int a(String str, String str2) {
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            return 100;
        }
        if (str == null) {
            try {
                k.a();
            } catch (Exception unused) {
            }
        }
        long parseLong = Long.parseLong(str);
        long parseLong2 = str2 != null ? Long.parseLong(str2) : 0;
        if (parseLong != 0) {
            return (int) ((((float) parseLong2) / ((float) parseLong)) * 100.0f);
        }
        return 100;
    }

    public static final String d(String str) {
        k.c(str, "id");
        if (str.equals("HO_PRIVATE") || str.equals("HO_KUMBH_PRIVATE")) {
            return "Open 24 Hours";
        }
        return (p.a(str, "ccd_work_cafe", true) || p.a(str, "shouut_test_wc", true)) ? "09:00 AM - 10:00 PM" : "";
    }
}
