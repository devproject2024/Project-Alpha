package com.paytm.a.a;

import android.os.Build;
import android.util.Log;
import com.paytm.a.a.b;
import com.paytm.analytics.b;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.a.k;
import kotlin.m.p;
import kotlin.u;

public final class a extends b.c {

    /* renamed from: a  reason: collision with root package name */
    public static final C0676a f40829a = new C0676a((byte) 0);

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f40830c = Pattern.compile("(\\$\\d+)+$");

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f40831b = k.b((T[]) new String[]{b.class.getName(), b.class.getName(), b.c.class.getName(), a.class.getName()});

    public final String a() {
        String a2 = super.a();
        if (a2 != null) {
            return a2;
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        kotlin.g.b.k.a((Object) stackTrace, "Throwable().stackTrace");
        for (StackTraceElement stackTraceElement : stackTrace) {
            List<String> list = this.f40831b;
            kotlin.g.b.k.a((Object) stackTraceElement, "it");
            if (!list.contains(stackTraceElement.getClassName())) {
                kotlin.g.b.k.c(stackTraceElement, "element");
                String className = stackTraceElement.getClassName();
                kotlin.g.b.k.a((Object) className, "element.className");
                String b2 = p.b(className, className);
                Matcher matcher = f40830c.matcher(b2);
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
                b.C0683b bVar = com.paytm.analytics.b.f40911e;
                com.paytm.analytics.a c2 = com.paytm.analytics.b.l;
                if (c2 != null) {
                    c2.a(new Throwable("[" + str + "] " + str2, th));
                }
            } else {
                b.C0683b bVar2 = com.paytm.analytics.b.f40911e;
                com.paytm.analytics.a c3 = com.paytm.analytics.b.l;
                if (c3 != null) {
                    c3.a(new Throwable("[" + str + "] " + str2));
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

    /* renamed from: com.paytm.a.a.a$a  reason: collision with other inner class name */
    public static final class C0676a {
        private C0676a() {
        }

        public /* synthetic */ C0676a(byte b2) {
            this();
        }
    }
}
