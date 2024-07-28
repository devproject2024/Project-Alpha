package com.google.firebase.crashlytics.a.g;

import java.io.File;
import java.io.FileFilter;

final /* synthetic */ class c implements FileFilter {

    /* renamed from: a  reason: collision with root package name */
    private final String f38593a;

    private c(String str) {
        this.f38593a = str;
    }

    public static FileFilter a(String str) {
        return new c(str);
    }

    public final boolean accept(File file) {
        return a.a(this.f38593a, file);
    }
}
