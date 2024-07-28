package com.google.firebase.crashlytics.a.c;

import com.google.firebase.crashlytics.a.e.v;
import java.util.Comparator;

final /* synthetic */ class ac implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    private static final ac f38160a = new ac();

    private ac() {
    }

    public static Comparator a() {
        return f38160a;
    }

    public final int compare(Object obj, Object obj2) {
        return ((v.b) obj).a().compareTo(((v.b) obj2).a());
    }
}
