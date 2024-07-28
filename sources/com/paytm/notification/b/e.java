package com.paytm.notification.b;

import android.os.Build;
import android.util.Log;
import com.business.merchant_payments.utility.StringUtility;
import com.paytm.notification.g;
import com.paytm.notification.models.callback.ErrorReportCallback;
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

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final b f43014a = new b((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final ArrayList<c> f43015b = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static volatile c[] f43016c = new c[0];

    public static void a(String str, Object... objArr) {
        f43014a.a(str, objArr);
    }

    private e() {
        throw new AssertionError();
    }

    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        private final ThreadLocal<String> f43020a = new ThreadLocal<>();

        /* access modifiers changed from: protected */
        public abstract void a(int i2, String str, String str2, Throwable th);

        public /* synthetic */ String a() {
            String str = this.f43020a.get();
            if (str != null) {
                this.f43020a.remove();
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

        public void b(Throwable th, String str, Object... objArr) {
            k.c(objArr, "args");
            a(6, th, str, Arrays.copyOf(objArr, objArr.length));
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
        public static final C0719a f43017a = new C0719a((byte) 0);

        /* renamed from: c  reason: collision with root package name */
        private static final Pattern f43018c = Pattern.compile("(\\$\\d+)+$");

        /* renamed from: b  reason: collision with root package name */
        private final List<String> f43019b = kotlin.a.k.b((T[]) new String[]{e.class.getName(), b.class.getName(), c.class.getName(), a.class.getName()});

        public final String a() {
            String a2 = super.a();
            if (a2 != null) {
                return a2;
            }
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            k.a((Object) stackTrace, "Throwable().stackTrace");
            for (StackTraceElement stackTraceElement : stackTrace) {
                List<String> list = this.f43019b;
                k.a((Object) stackTraceElement, "it");
                if (!list.contains(stackTraceElement.getClassName())) {
                    k.c(stackTraceElement, "element");
                    String className = stackTraceElement.getClassName();
                    k.a((Object) className, "element.className");
                    String b2 = p.b(className, className);
                    Matcher matcher = f43018c.matcher(b2);
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

        /* renamed from: com.paytm.notification.b.e$a$a  reason: collision with other inner class name */
        public static final class C0719a {
            private C0719a() {
            }

            public /* synthetic */ C0719a(byte b2) {
                this();
            }
        }
    }

    public static final class b extends c {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }

        public final void a(String str, Object... objArr) {
            k.c(objArr, "args");
            for (c a2 : e.f43016c) {
                a2.a(str, Arrays.copyOf(objArr, objArr.length));
            }
        }

        public final void b(String str, Object... objArr) {
            k.c(objArr, "args");
            for (c b2 : e.f43016c) {
                b2.b(str, Arrays.copyOf(objArr, objArr.length));
            }
        }

        public final void c(String str, Object... objArr) {
            k.c(objArr, "args");
            for (c c2 : e.f43016c) {
                c2.c(str, Arrays.copyOf(objArr, objArr.length));
            }
        }

        public final void a(Throwable th, String str, Object... objArr) {
            k.c(objArr, "args");
            for (c a2 : e.f43016c) {
                a2.a(th, str, Arrays.copyOf(objArr, objArr.length));
            }
        }

        public final void a(Throwable th) {
            for (c a2 : e.f43016c) {
                a2.a(th);
            }
        }

        public final void d(String str, Object... objArr) {
            k.c(objArr, "args");
            for (c d2 : e.f43016c) {
                d2.d(str, Arrays.copyOf(objArr, objArr.length));
            }
        }

        public final void b(Throwable th, String str, Object... objArr) {
            k.c(objArr, "args");
            for (c b2 : e.f43016c) {
                b2.b(th, str, Arrays.copyOf(objArr, objArr.length));
            }
        }

        public final void b(Throwable th) {
            for (c b2 : e.f43016c) {
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
                synchronized (e.f43015b) {
                    e.f43015b.add(cVar);
                    Object[] array = e.f43015b.toArray(new c[0]);
                    if (array != null) {
                        e.f43016c = (c[]) array;
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
