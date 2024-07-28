package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils;

import android.util.Log;

public class Bamboo {
    static final Level LOG_LEVEL = Level.VERBOSE;

    public static boolean isLoggingEnabled() {
        return false;
    }

    public enum Level {
        VERBOSE(2),
        DEBUG(3),
        INFO(4),
        WARN(5),
        ERROR(6),
        ASSERT(7),
        WTF(8);
        
        /* access modifiers changed from: private */
        public int level;

        private Level(int i2) {
            this.level = i2;
        }
    }

    public static int d(String str, String str2) {
        if (!isLoggingEnabled() || !shouldLog(Level.DEBUG.level)) {
            return -1;
        }
        return Log.d(str, str2);
    }

    public static int d(String str, String str2, Throwable th) {
        if (!isLoggingEnabled() || !shouldLog(Level.DEBUG.level)) {
            return -1;
        }
        return Log.d(str, str2, th);
    }

    public static int e(String str, String str2) {
        if (!isLoggingEnabled() || !shouldLog(Level.ERROR.level)) {
            return -1;
        }
        return Log.e(str, str2);
    }

    public static int e(String str, String str2, Throwable th) {
        if (!isLoggingEnabled() || !shouldLog(Level.ERROR.level)) {
            return -1;
        }
        return Log.e(str, str2, th);
    }

    public static String getStackTraceString(Throwable th) {
        return Log.getStackTraceString(th);
    }

    public static int i(String str, String str2) {
        if (!isLoggingEnabled() || !shouldLog(Level.INFO.level)) {
            return -1;
        }
        return Log.i(str, str2);
    }

    public static int i(String str, String str2, Throwable th) {
        if (!isLoggingEnabled() || !shouldLog(Level.INFO.level)) {
            return -1;
        }
        return Log.i(str, str2, th);
    }

    public static boolean isLoggable(String str, Level level) {
        return isLoggable(str, level.level);
    }

    public static boolean isLoggable(String str, int i2) {
        return isLoggingEnabled() && shouldLog(Level.VERBOSE.level) && Log.isLoggable(str, i2);
    }

    public static int println(int i2, String str, String str2) {
        if (!isLoggingEnabled() || !shouldLog(Level.ASSERT.level)) {
            return -1;
        }
        return Log.println(i2, str, str2);
    }

    public static int v(String str, String str2, Throwable th) {
        if (!isLoggingEnabled() || !shouldLog(Level.VERBOSE.level)) {
            return -1;
        }
        return Log.v(str, str2, th);
    }

    public static int v(String str, String str2) {
        if (!isLoggingEnabled() || !shouldLog(Level.VERBOSE.level)) {
            return -1;
        }
        return Log.v(str, str2);
    }

    public static int w(String str, Throwable th) {
        if (!isLoggingEnabled() || !shouldLog(Level.WARN.level)) {
            return -1;
        }
        return Log.w(str, th);
    }

    public static int w(String str, String str2, Throwable th) {
        if (!isLoggingEnabled() || !shouldLog(Level.WARN.level)) {
            return -1;
        }
        return Log.w(str, str2, th);
    }

    public static int w(String str, String str2) {
        if (!isLoggingEnabled() || !shouldLog(Level.WARN.level)) {
            return -1;
        }
        return Log.w(str, str2);
    }

    public static int wtf(String str, Throwable th) {
        if (!isLoggingEnabled() || !shouldLog(Level.WTF.level)) {
            return -1;
        }
        return Log.wtf(str, th);
    }

    public static int wtf(String str, String str2, Throwable th) {
        if (!isLoggingEnabled() || !shouldLog(Level.WTF.level)) {
            return -1;
        }
        return Log.wtf(str, str2, th);
    }

    public static int wtf(String str, String str2) {
        if (!isLoggingEnabled() || !shouldLog(Level.WTF.level)) {
            return -1;
        }
        return Log.wtf(str, str2);
    }

    private static boolean shouldLog(int i2) {
        return LOG_LEVEL.level <= i2;
    }
}
