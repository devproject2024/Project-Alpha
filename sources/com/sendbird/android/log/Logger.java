package com.sendbird.android.log;

import android.util.Log;
import com.sendbird.android.log.a;
import java.util.HashSet;
import java.util.Locale;

public class Logger {
    public static final int DEBUG = 98765;
    public static final int INFO = 1;
    private static final int LOG_SEGMENT_SIZE = 2000;
    public static final int NONE = 0;
    private static a loggerConfig = initLogConfig();
    private static int sLevel;
    private static boolean withStack = true;

    private Logger() {
    }

    private static a initLogConfig() {
        withStack = true;
        int i2 = sLevel;
        int i3 = i2 == 0 ? 5 : i2 == 1 ? 4 : 2;
        a.C0755a aVar = new a.C0755a();
        aVar.f44835b = Tag.DEFAULT;
        aVar.f44836c = Tag.DEFAULT.tag();
        aVar.f44834a = i3;
        HashSet hashSet = new HashSet();
        hashSet.add(Logger.class.getName());
        aVar.f44837d = hashSet;
        a aVar2 = new a();
        aVar2.f44830b = aVar.f44835b;
        aVar2.f44829a = aVar.f44834a;
        aVar2.f44831c = aVar.f44836c;
        aVar2.f44832d = aVar.f44837d;
        return aVar2;
    }

    public static void setLoggerLevel(int i2) {
        sLevel = i2;
        loggerConfig = initLogConfig();
    }

    private static int printLog(Tag tag, int i2, String str) {
        int i3 = 0;
        if (str == null) {
            return 0;
        }
        String a2 = loggerConfig.a(withStack, str);
        if (!loggerConfig.a(i2)) {
            return 0;
        }
        if (a2 == null) {
            a2 = loggerConfig.a(withStack, str);
        }
        if (a2 == null) {
            return 0;
        }
        String tag2 = tag.tag();
        int length = a2.length();
        int i4 = 0;
        int i5 = 0;
        while (i3 < length) {
            int i6 = length - i3;
            if (i6 > 2000) {
                i6 = 2000;
            }
            int i7 = i6 + i3;
            i4 += printLogPartially(i2, tag2, a2.substring(i3, i7), i5);
            i3 = i7;
            i5++;
        }
        return i4;
    }

    private static int printLogPartially(int i2, String str, String str2, int i3) {
        String str3;
        int length = str2.length();
        if (i3 > 0) {
            str3 = String.format(Locale.US, "Cont(%d) ", new Object[]{Integer.valueOf(i3)});
        } else {
            str3 = "";
        }
        if (length > 2000) {
            str2 = str2.substring(0, 2000);
        }
        if (i2 != 0) {
            if (i2 == 2) {
                return Log.v(str, str3 + str2);
            } else if (i2 != 3) {
                if (i2 == 4) {
                    return Log.i(str, str3 + str2);
                } else if (i2 == 5) {
                    return Log.w(str, str3 + str2);
                } else if (i2 != 6) {
                    return 0;
                } else {
                    return Log.e(str, str3 + str2);
                }
            }
        }
        return Log.d(str, str3 + str2);
    }

    public static String getCallerTraceInfo(Class cls) {
        if (!loggerConfig.a(3)) {
            return "unknown caller";
        }
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = Thread.currentThread().getName();
        StackTraceElement stackTraceElement = null;
        String name2 = cls.getName();
        int length = stackTrace.length;
        int i2 = 0;
        boolean z = false;
        while (true) {
            if (i2 >= length) {
                break;
            }
            StackTraceElement stackTraceElement2 = stackTrace[i2];
            if (stackTraceElement2.getClassName().startsWith(name2)) {
                z = true;
            } else if (z) {
                stackTraceElement = stackTraceElement2;
                break;
            }
            i2++;
        }
        if (stackTraceElement == null) {
            return "";
        }
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        int lineNumber = stackTraceElement.getLineNumber();
        return String.format(Locale.US, "{%s}-[%s.%s():%d]", new Object[]{name, className, methodName, Integer.valueOf(lineNumber)});
    }

    private static String getStackTraceString(Throwable th) {
        return th == null ? "" : Log.getStackTraceString(th);
    }

    public static int vt(Tag tag, Throwable th) {
        return vt(tag, getStackTraceString(th));
    }

    public static int vt(Tag tag, String str, Throwable th) {
        return vt(tag, "%s\n%s", str, getStackTraceString(th));
    }

    private static int vt(Tag tag, String str, Object... objArr) {
        if (!loggerConfig.a(2)) {
            return 0;
        }
        if (objArr != null && objArr.length > 0) {
            str = String.format(str, objArr);
        }
        return printLog(tag, 2, str);
    }

    public static int vt(Tag tag, String str) {
        return printLog(tag, 2, str);
    }

    public static int v(String str, Object... objArr) {
        return vt(loggerConfig.f44830b, str, objArr);
    }

    public static int v(Throwable th) {
        return vt(loggerConfig.f44830b, th);
    }

    public static int v(String str, Throwable th) {
        return vt(loggerConfig.f44830b, str, th);
    }

    public static int dt(Tag tag, Throwable th) {
        return dt(tag, getStackTraceString(th));
    }

    public static int dt(Tag tag, String str, Throwable th) {
        return dt(tag, "%s\n%s", str, getStackTraceString(th));
    }

    public static int dt(Tag tag, String str, Object... objArr) {
        if (!loggerConfig.a(3)) {
            return 0;
        }
        if (objArr != null && objArr.length > 0) {
            str = String.format(str, objArr);
        }
        return printLog(tag, 3, str);
    }

    public static int dt(Tag tag, String str) {
        return printLog(tag, 3, str);
    }

    public static int d(String str, Object... objArr) {
        return dt(loggerConfig.f44830b, str, objArr);
    }

    public static int d(String str) {
        return dt(loggerConfig.f44830b, str);
    }

    public static int d(Throwable th) {
        return dt(loggerConfig.f44830b, th);
    }

    public static int d(String str, Throwable th) {
        return dt(loggerConfig.f44830b, str, th);
    }

    public static int it(Tag tag, Throwable th) {
        return it(tag, getStackTraceString(th));
    }

    public static int it(Tag tag, String str, Throwable th) {
        return it(tag, "%s\n%s", str, getStackTraceString(th));
    }

    public static int it(Tag tag, String str, Object... objArr) {
        if (!loggerConfig.a(4)) {
            return 0;
        }
        if (objArr != null && objArr.length > 0) {
            str = String.format(str, objArr);
        }
        return printLog(tag, 4, str);
    }

    public static int it(Tag tag, String str) {
        return printLog(tag, 4, str);
    }

    public static int i(String str, Object... objArr) {
        return it(loggerConfig.f44830b, str, objArr);
    }

    public static int i(Throwable th) {
        return it(loggerConfig.f44830b, th);
    }

    public static int i(String str, Throwable th) {
        return it(loggerConfig.f44830b, str, th);
    }

    public static int wt(Tag tag, Throwable th) {
        return wt(tag, getStackTraceString(th));
    }

    public static int wt(Tag tag, String str, Throwable th) {
        return wt(tag, "%s\n%s", str, getStackTraceString(th));
    }

    public static int wt(Tag tag, String str, Object... objArr) {
        if (loggerConfig.a(5)) {
            return printLog(tag, 5, String.format(str, objArr));
        }
        return 0;
    }

    public static int wt(Tag tag, String str) {
        return printLog(tag, 5, str);
    }

    public static int w(String str, Object... objArr) {
        return wt(loggerConfig.f44830b, str, objArr);
    }

    public static int w(String str) {
        return wt(loggerConfig.f44830b, str);
    }

    public static int w(Throwable th) {
        return wt(loggerConfig.f44830b, th);
    }

    public static int w(String str, Throwable th) {
        return wt(loggerConfig.f44830b, str, th);
    }

    public static int et(Tag tag, Throwable th) {
        return et(tag, getStackTraceString(th));
    }

    public static int et(Tag tag, String str, Throwable th) {
        return et(tag, "%s\n%s", str, getStackTraceString(th));
    }

    public static int et(Tag tag, String str, Object... objArr) {
        if (!loggerConfig.a(6)) {
            return 0;
        }
        if (objArr != null && objArr.length > 0) {
            str = String.format(str, objArr);
        }
        return printLog(tag, 6, str);
    }

    public static int et(Tag tag, String str) {
        return printLog(tag, 6, str);
    }

    public static int e(String str, Object... objArr) {
        return et(loggerConfig.f44830b, str, objArr);
    }

    public static int e(String str) {
        return et(loggerConfig.f44830b, str);
    }

    public static int e(Throwable th) {
        return et(loggerConfig.f44830b, th);
    }

    public static int e(String str, Throwable th) {
        return et(loggerConfig.f44830b, str, th);
    }

    public static int devt(Tag tag, Throwable th) {
        return devt(tag, getStackTraceString(th));
    }

    public static int devt(Tag tag, String str, Throwable th) {
        return devt(tag, "%s\n%s", str, getStackTraceString(th));
    }

    private static int devt(Tag tag, String str, Object... objArr) {
        if (!loggerConfig.a(0)) {
            return 0;
        }
        if (objArr != null && objArr.length > 0) {
            str = String.format(str, objArr);
        }
        return printLog(tag, 0, str);
    }

    public static int devt(Tag tag, String str) {
        return printLog(tag, 0, str);
    }

    public static int dev(String str, Object... objArr) {
        return devt(loggerConfig.f44830b, str, objArr);
    }

    public static int dev(String str) {
        return devt(loggerConfig.f44830b, str);
    }

    public static int dev(Throwable th) {
        return devt(loggerConfig.f44830b, th);
    }

    public static int dev(String str, Throwable th) {
        return devt(loggerConfig.f44830b, str, th);
    }
}
