package com.google.firebase.crashlytics.a.g;

import java.io.File;
import java.util.Comparator;

final /* synthetic */ class f implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    private static final f f38596a = new f();

    private f() {
    }

    public static Comparator a() {
        return f38596a;
    }

    public final int compare(Object obj, Object obj2) {
        return ((File) obj2).getName().compareTo(((File) obj).getName());
    }
}
