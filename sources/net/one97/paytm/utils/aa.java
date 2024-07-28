package net.one97.paytm.utils;

import com.google.firebase.perf.a;
import com.google.firebase.perf.metrics.Trace;
import kotlin.g.b.k;

public final class aa {

    /* renamed from: a  reason: collision with root package name */
    public static final aa f69597a = new aa();

    /* renamed from: b  reason: collision with root package name */
    private static Trace f69598b;

    /* renamed from: c  reason: collision with root package name */
    private static Trace f69599c;

    /* renamed from: d  reason: collision with root package name */
    private static Trace f69600d;

    private aa() {
    }

    public static void a() {
        a.a();
        Trace b2 = a.b("deepLinkEngine_handleDeepLink_trace");
        f69600d = b2;
        if (b2 != null) {
            b2.start();
        }
    }

    public static void a(String str, String str2) {
        Trace trace;
        CharSequence charSequence = str;
        boolean z = false;
        if (!(charSequence == null || charSequence.length() == 0)) {
            String c2 = c(str);
            Trace trace2 = f69600d;
            if (trace2 != null) {
                trace2.putAttribute("webLink", c2);
            }
        }
        CharSequence charSequence2 = str2;
        if (charSequence2 == null || charSequence2.length() == 0) {
            z = true;
        }
        if (!z && (trace = f69600d) != null) {
            trace.putAttribute("urlType", str2);
        }
        Trace trace3 = f69600d;
        if (trace3 != null) {
            trace3.stop();
        }
        f69600d = null;
    }

    public static void b() {
        f69600d = null;
    }

    public static void c() {
        f69598b = null;
    }

    public static void a(String str) {
        Trace trace;
        if (f69598b == null) {
            a.a();
            Trace b2 = a.b("phoenix_start_activity_webPageStart_trace");
            f69598b = b2;
            if (b2 != null) {
                b2.start();
            }
        }
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0) && (trace = f69598b) != null) {
            trace.putAttribute("aId", str);
        }
    }

    public static void d() {
        Trace trace = f69598b;
        if (trace != null) {
            trace.stop();
        }
        f69598b = null;
    }

    private static String c(String str) {
        if (str.length() <= 100) {
            return str;
        }
        if (str != null) {
            String substring = str.substring(0, 100);
            k.b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public static void b(String str) {
        a.a();
        f69599c = a.b("phoenix_webPageLoadStart_finish_trace");
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0)) {
            String c2 = c(str);
            Trace trace = f69599c;
            if (trace != null) {
                trace.putAttribute("webLink", c2);
            }
        }
        Trace trace2 = f69599c;
        if (trace2 != null) {
            trace2.start();
        }
    }

    public static void e() {
        Trace trace = f69599c;
        if (trace != null) {
            trace.stop();
        }
        f69599c = null;
    }
}
