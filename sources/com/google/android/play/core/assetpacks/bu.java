package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.FilenameFilter;

final /* synthetic */ class bu implements FilenameFilter {

    /* renamed from: a  reason: collision with root package name */
    private final String f37092a;

    bu(String str) {
        this.f37092a = str;
    }

    public final boolean accept(File file, String str) {
        return str.startsWith(String.valueOf(this.f37092a).concat("-")) && str.endsWith(".apk");
    }
}
