package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.FilenameFilter;

final /* synthetic */ class cn implements FilenameFilter {

    /* renamed from: a  reason: collision with root package name */
    static final FilenameFilter f37155a = new cn();

    private cn() {
    }

    public final boolean accept(File file, String str) {
        return co.f37156a.matcher(str).matches();
    }
}
