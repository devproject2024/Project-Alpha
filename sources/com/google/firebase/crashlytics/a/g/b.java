package com.google.firebase.crashlytics.a.g;

import java.io.File;
import java.io.FilenameFilter;

final /* synthetic */ class b implements FilenameFilter {

    /* renamed from: a  reason: collision with root package name */
    private final String f38592a;

    private b(String str) {
        this.f38592a = str;
    }

    public static FilenameFilter a(String str) {
        return new b(str);
    }

    public final boolean accept(File file, String str) {
        return str.startsWith(this.f38592a);
    }
}
