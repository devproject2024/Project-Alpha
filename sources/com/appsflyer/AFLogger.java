package com.appsflyer;

import com.appsflyer.internal.ai;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import net.one97.paytm.upi.util.UpiConstants;

public class AFLogger {

    /* renamed from: ι  reason: contains not printable characters */
    private static long f36 = System.currentTimeMillis();

    public static void afInfoLog(String str, boolean z) {
        if (m23(LogLevel.INFO)) {
            m18(str, false);
        }
        if (z) {
            if (ai.f183 == null) {
                ai.f183 = new ai();
            }
            ai.f183.m144((String) null, AppConstants.IMAGE_SUBTYPE, m18(str, true));
        }
    }

    public static void resetDeltaTime() {
        f36 = System.currentTimeMillis();
    }

    /* renamed from: ǃ  reason: contains not printable characters */
    private static String m18(String str, boolean z) {
        if (!z && LogLevel.VERBOSE.getLevel() > AppsFlyerProperties.getInstance().getInt("logLevel", LogLevel.NONE.getLevel())) {
            return str;
        }
        StringBuilder sb = new StringBuilder("(");
        sb.append(m21(System.currentTimeMillis() - f36));
        sb.append(") [");
        sb.append(Thread.currentThread().getName());
        sb.append("] ");
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: ı  reason: contains not printable characters */
    private static void m17(String str, Throwable th, boolean z) {
        String[] strArr;
        if (m23(LogLevel.ERROR) && z) {
            m18(str, false);
        }
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai aiVar = ai.f183;
        Throwable cause = th.getCause();
        String simpleName = th.getClass().getSimpleName();
        String message = cause == null ? th.getMessage() : cause.getMessage();
        StackTraceElement[] stackTrace = cause == null ? th.getStackTrace() : cause.getStackTrace();
        if (stackTrace == null) {
            strArr = new String[]{message};
        } else {
            String[] strArr2 = new String[(stackTrace.length + 1)];
            strArr2[0] = message;
            for (int i2 = 1; i2 < stackTrace.length; i2++) {
                strArr2[i2] = stackTrace[i2].toString();
            }
            strArr = strArr2;
        }
        aiVar.m144("exception", simpleName, strArr);
    }

    /* renamed from: Ι  reason: contains not printable characters */
    static void m22(String str) {
        if (m23(LogLevel.WARNING)) {
            m18(str, false);
        }
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m144((String) null, AppConstants.CAROUSEL_SUB_TYPE, m18(str, true));
    }

    public static void afRDLog(String str) {
        if (m23(LogLevel.VERBOSE)) {
            m18(str, false);
        }
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m144((String) null, "V", m18(str, true));
    }

    /* renamed from: Ι  reason: contains not printable characters */
    private static boolean m23(LogLevel logLevel) {
        return logLevel.getLevel() <= AppsFlyerProperties.getInstance().getInt("logLevel", LogLevel.NONE.getLevel());
    }

    /* renamed from: ǃ  reason: contains not printable characters */
    static void m19(String str) {
        if (!m20()) {
            m18(str, false);
        }
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m144((String) null, AppConstants.FEED_SUB_TYPE, str);
    }

    /* renamed from: ɩ  reason: contains not printable characters */
    private static boolean m20() {
        return AppsFlyerProperties.getInstance().isLogsDisabledCompletely();
    }

    public static void afInfoLog(String str) {
        afInfoLog(str, true);
    }

    public static void afErrorLog(String str, Throwable th) {
        m17(str, th, true);
    }

    public static void afErrorLog(String str, Throwable th, boolean z) {
        m17(str, th, z);
    }

    public static void afWarnLog(String str) {
        m22(str);
    }

    /* renamed from: Ι  reason: contains not printable characters */
    private static String m21(long j) {
        long hours = TimeUnit.MILLISECONDS.toHours(j);
        long millis = j - TimeUnit.HOURS.toMillis(hours);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
        long millis2 = millis - TimeUnit.MINUTES.toMillis(minutes);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis2);
        long millis3 = TimeUnit.MILLISECONDS.toMillis(millis2 - TimeUnit.SECONDS.toMillis(seconds));
        return String.format(Locale.getDefault(), "%02d:%02d:%02d:%03d", new Object[]{Long.valueOf(hours), Long.valueOf(minutes), Long.valueOf(seconds), Long.valueOf(millis3)});
    }

    public enum LogLevel {
        NONE(0),
        ERROR(1),
        WARNING(2),
        INFO(3),
        DEBUG(4),
        VERBOSE(5);
        

        /* renamed from: ɩ  reason: contains not printable characters */
        private int f38;

        private LogLevel(int i2) {
            this.f38 = i2;
        }

        public final int getLevel() {
            return this.f38;
        }
    }

    public static void afDebugLog(String str) {
        if (m23(LogLevel.DEBUG)) {
            m18(str, false);
        }
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m144((String) null, UpiConstants.DEFAULT_ACCOUNT_CONSTANT, m18(str, true));
    }
}
