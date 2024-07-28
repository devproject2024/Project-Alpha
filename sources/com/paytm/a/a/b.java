package com.paytm.a.a;

import android.os.Build;
import android.util.Log;
import com.business.merchant_payments.utility.StringUtility;
import com.paytm.analytics.b;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.upi.util.UpiConstants;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final C0678b f40832a = new C0678b((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final ArrayList<c> f40833b = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static volatile c[] f40834c = new c[0];

    public static void a(String str, Object... objArr) {
        f40832a.a(str, objArr);
    }

    private b() {
        throw new AssertionError();
    }

    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        private final ThreadLocal<String> f40838a = new ThreadLocal<>();

        /* access modifiers changed from: protected */
        public abstract void a(int i2, String str, String str2, Throwable th);

        public /* synthetic */ String a() {
            String str = this.f40838a.get();
            if (str != null) {
                this.f40838a.remove();
            }
            return str;
        }

        public void a(String str, Object... objArr) {
            k.c(objArr, "args");
            a(3, (Throwable) null, str, Arrays.copyOf(objArr, objArr.length));
        }

        public void b(String str, Object... objArr) {
            k.c(objArr, "args");
            a(4, (Throwable) null, str, Arrays.copyOf(objArr, objArr.length));
        }

        public void c(String str, Object... objArr) {
            k.c(objArr, "args");
            a(5, (Throwable) null, str, Arrays.copyOf(objArr, objArr.length));
        }

        public void a(Throwable th, String str, Object... objArr) {
            k.c(objArr, "args");
            a(5, th, str, Arrays.copyOf(objArr, objArr.length));
        }

        public void a(Throwable th) {
            a(5, th, (String) null, new Object[0]);
        }

        public void d(String str, Object... objArr) {
            k.c(objArr, "args");
            a(6, (Throwable) null, str, Arrays.copyOf(objArr, objArr.length));
        }

        public void b(Throwable th) {
            a(6, th, (String) null, new Object[0]);
        }

        private final void a(int i2, Throwable th, String str, Object... objArr) {
            String a2 = a();
            CharSequence charSequence = str;
            boolean z = false;
            if (!(charSequence == null || charSequence.length() == 0)) {
                if (objArr.length == 0) {
                    z = true;
                }
                if (!z) {
                    str = e(str, objArr);
                }
                if (th != null) {
                    str = str + StringUtility.NEW_LINE + c(th);
                }
            } else if (th != null) {
                str = c(th);
            } else {
                return;
            }
            a(i2, a2, str, th);
        }

        private static String e(String str, Object[] objArr) {
            k.c(str, "message");
            k.c(objArr, "args");
            Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
            String format = String.format(str, Arrays.copyOf(copyOf, copyOf.length));
            k.a((Object) format, "java.lang.String.format(this, *args)");
            return format;
        }

        private static String c(Throwable th) {
            StringWriter stringWriter = new StringWriter(UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS);
            PrintWriter printWriter = new PrintWriter(stringWriter, false);
            th.printStackTrace(printWriter);
            printWriter.flush();
            String stringWriter2 = stringWriter.toString();
            k.a((Object) stringWriter2, "sw.toString()");
            return stringWriter2;
        }
    }

    public static class a extends c {

        /* renamed from: a  reason: collision with root package name */
        public static final C0677a f40835a = new C0677a((byte) 0);

        /* renamed from: c  reason: collision with root package name */
        private static final Pattern f40836c = Pattern.compile("(\\$\\d+)+$");

        /* renamed from: b  reason: collision with root package name */
        private final List<String> f40837b = kotlin.a.k.b((T[]) new String[]{b.class.getName(), C0678b.class.getName(), c.class.getName(), a.class.getName()});

        public final String a() {
            String a2 = super.a();
            if (a2 != null) {
                return a2;
            }
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            k.a((Object) stackTrace, "Throwable().stackTrace");
            for (StackTraceElement stackTraceElement : stackTrace) {
                List<String> list = this.f40837b;
                k.a((Object) stackTraceElement, "it");
                if (!list.contains(stackTraceElement.getClassName())) {
                    k.c(stackTraceElement, "element");
                    String className = stackTraceElement.getClassName();
                    k.a((Object) className, "element.className");
                    String b2 = p.b(className, className);
                    Matcher matcher = f40836c.matcher(b2);
                    if (matcher.find()) {
                        b2 = matcher.replaceAll("");
                        k.a((Object) b2, "m.replaceAll(\"\")");
                    }
                    if (b2.length() <= 23 || Build.VERSION.SDK_INT >= 24) {
                        return b2;
                    }
                    if (b2 != null) {
                        String substring = b2.substring(0, 23);
                        k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
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
            k.c(str2, "message");
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
                        k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
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

        /* renamed from: com.paytm.a.a.b$a$a  reason: collision with other inner class name */
        public static final class C0677a {
            private C0677a() {
            }

            public /* synthetic */ C0677a(byte b2) {
                this();
            }
        }
    }

    /* renamed from: com.paytm.a.a.b$b  reason: collision with other inner class name */
    public static final class C0678b extends c {
        private C0678b() {
        }

        public /* synthetic */ C0678b(byte b2) {
            this();
        }

        public final void a(String str, Object... objArr) {
            k.c(objArr, "args");
            for (c a2 : b.f40834c) {
                a2.a(str, Arrays.copyOf(objArr, objArr.length));
            }
        }

        public final void b(String str, Object... objArr) {
            k.c(objArr, "args");
            for (c b2 : b.f40834c) {
                b2.b(str, Arrays.copyOf(objArr, objArr.length));
            }
        }

        public final void c(String str, Object... objArr) {
            k.c(objArr, "args");
            for (c c2 : b.f40834c) {
                c2.c(str, Arrays.copyOf(objArr, objArr.length));
            }
        }

        public final void a(Throwable th, String str, Object... objArr) {
            k.c(objArr, "args");
            for (c a2 : b.f40834c) {
                a2.a(th, str, Arrays.copyOf(objArr, objArr.length));
            }
        }

        public final void a(Throwable th) {
            for (c a2 : b.f40834c) {
                a2.a(th);
            }
        }

        public final void d(String str, Object... objArr) {
            k.c(objArr, "args");
            for (c d2 : b.f40834c) {
                d2.d(str, Arrays.copyOf(objArr, objArr.length));
            }
        }

        public final void b(Throwable th) {
            for (c b2 : b.f40834c) {
                b2.b(th);
            }
        }

        /* access modifiers changed from: protected */
        public final void a(int i2, String str, String str2, Throwable th) {
            k.c(str2, "message");
            throw new AssertionError();
        }

        public final void a(c cVar) {
            k.c(cVar, CLPConstants.FILTER_TREE);
            if (cVar != this) {
                synchronized (b.f40833b) {
                    b.f40833b.add(cVar);
                    Object[] array = b.f40833b.toArray(new c[0]);
                    if (array != null) {
                        b.f40834c = (c[]) array;
                        x xVar = x.f47997a;
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Cannot plant Timber into itself.".toString());
        }
    }
}
