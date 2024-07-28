package com.paytm.notification.b;

import android.os.Build;
import android.util.Log;
import com.paytm.notification.b.e;
import com.paytm.notification.g;
import com.paytm.notification.models.callback.ErrorReportCallback;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.a.k;
import kotlin.m.p;
import kotlin.u;

public final class d extends e.c {

    /* renamed from: a  reason: collision with root package name */
    public static final a f43011a = new a((byte) 0);

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f43012c = Pattern.compile("(\\$\\d+)+$");

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f43013b = k.b((T[]) new String[]{e.class.getName(), e.class.getName(), e.c.class.getName(), d.class.getName()});

    public final String a() {
        String a2 = super.a();
        if (a2 != null) {
            return a2;
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        kotlin.g.b.k.a((Object) stackTrace, "Throwable().stackTrace");
        for (StackTraceElement stackTraceElement : stackTrace) {
            List<String> list = this.f43013b;
            kotlin.g.b.k.a((Object) stackTraceElement, "it");
            if (!list.contains(stackTraceElement.getClassName())) {
                kotlin.g.b.k.c(stackTraceElement, "element");
                String className = stackTraceElement.getClassName();
                kotlin.g.b.k.a((Object) className, "element.className");
                String b2 = p.b(className, className);
                Matcher matcher = f43012c.matcher(b2);
                if (matcher.find()) {
                    b2 = matcher.replaceAll("");
                    kotlin.g.b.k.a((Object) b2, "m.replaceAll(\"\")");
                }
                if (b2.length() <= 23 || Build.VERSION.SDK_INT >= 24) {
                    return b2;
                }
                if (b2 != null) {
                    String substring = b2.substring(0, 23);
                    kotlin.g.b.k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    return substring;
                }
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    /* access modifiers changed from: protected */
    public final void a(int i2, String str, String str2, Throwable th) {
        int min;
        kotlin.g.b.k.c(str2, "message");
        if (i2 >= 6) {
            if (th != null) {
                g.c cVar = g.f43191a;
                ErrorReportCallback f2 = g.l;
                if (f2 != null) {
                    f2.onError(new Throwable("[" + str + "] " + str2, th));
                }
            } else {
                g.c cVar2 = g.f43191a;
                ErrorReportCallback f3 = g.l;
                if (f3 != null) {
                    f3.onError(new Throwable("[" + str + "] " + str2));
                }
            }
            if (str2.length() >= 4000) {
                int length = str2.length();
                int i3 = 0;
                while (i3 < length) {
                    int a2 = p.a((CharSequence) str2, 10, i3, false, 4);
                    if (a2 == -1) {
                        a2 = length;
                    }
                    while (true) {
                        min = Math.min(a2, i3 + 4000);
                        String substring = str2.substring(i3, min);
                        kotlin.g.b.k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        if (i2 == 7) {
                            Log.wtf(str, substring);
                        } else {
                            Log.println(i2, str, substring);
                        }
                        if (min >= a2) {
                            break;
                        }
                        i3 = min;
                    }
                    i3 = min + 1;
                }
            } else if (i2 == 7) {
                Log.wtf(str, str2);
            } else {
                Log.println(i2, str, str2);
            }
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
