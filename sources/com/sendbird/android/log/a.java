package com.sendbird.android.log;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

final class a {

    /* renamed from: a  reason: collision with root package name */
    int f44829a;

    /* renamed from: b  reason: collision with root package name */
    Tag f44830b;

    /* renamed from: c  reason: collision with root package name */
    String f44831c;

    /* renamed from: d  reason: collision with root package name */
    Set<String> f44832d;

    /* renamed from: e  reason: collision with root package name */
    private final SimpleDateFormat f44833e = new SimpleDateFormat("HH:mm:ss.SSS", Locale.US);

    a() {
    }

    /* access modifiers changed from: package-private */
    public final boolean a(int i2) {
        return i2 >= this.f44829a;
    }

    /* renamed from: com.sendbird.android.log.a$a  reason: collision with other inner class name */
    static class C0755a {

        /* renamed from: a  reason: collision with root package name */
        int f44834a = 0;

        /* renamed from: b  reason: collision with root package name */
        Tag f44835b = Tag.DEFAULT;

        /* renamed from: c  reason: collision with root package name */
        String f44836c;

        /* renamed from: d  reason: collision with root package name */
        Set<String> f44837d = new HashSet();

        C0755a() {
        }
    }

    /* access modifiers changed from: package-private */
    public final String a(boolean z, String str) {
        return z ? a(str) : str;
    }

    private String a(String str) {
        String str2;
        StackTraceElement stackTraceElement;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String canonicalName = getClass().getCanonicalName();
        int length = stackTrace.length;
        int i2 = 0;
        boolean z = false;
        while (true) {
            str2 = null;
            if (i2 >= length) {
                stackTraceElement = null;
                break;
            }
            stackTraceElement = stackTrace[i2];
            String className = stackTraceElement.getClassName();
            if (className.equalsIgnoreCase(canonicalName)) {
                z = true;
            }
            if (z && !className.startsWith(canonicalName) && !this.f44832d.contains(className)) {
                break;
            }
            i2++;
        }
        if (stackTraceElement != null) {
            String[] split = stackTraceElement.getClassName().split("\\.");
            str2 = String.format(Locale.US, "[%s %s:%s():%d]", new Object[]{this.f44833e.format(Long.valueOf(System.currentTimeMillis())), split[split.length - 1], stackTraceElement.getMethodName(), Integer.valueOf(stackTraceElement.getLineNumber())});
        }
        Object[] objArr = new Object[2];
        if (str2 == null) {
            str2 = "";
        }
        objArr[0] = str2;
        objArr[1] = str;
        return String.format("%s %s", objArr);
    }
}
