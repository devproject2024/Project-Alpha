package com.google.firebase.crashlytics.a.g;

import java.io.File;
import java.util.Comparator;

final /* synthetic */ class e implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    private static final e f38595a = new e();

    private e() {
    }

    public static Comparator a() {
        return f38595a;
    }

    public final int compare(Object obj, Object obj2) {
        return a.g(((File) obj).getName()).compareTo(a.g(((File) obj2).getName()));
    }
}
