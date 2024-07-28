package com.google.firebase.crashlytics.a.c;

import java.io.File;
import java.io.FilenameFilter;

final /* synthetic */ class j implements FilenameFilter {

    /* renamed from: a  reason: collision with root package name */
    private static final j f38276a = new j();

    private j() {
    }

    public static FilenameFilter a() {
        return f38276a;
    }

    public final boolean accept(File file, String str) {
        return str.startsWith(".ae");
    }
}
