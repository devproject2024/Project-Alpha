package com.google.android.play.core.appupdate;

import android.content.Context;
import java.io.File;

final class p {

    /* renamed from: a  reason: collision with root package name */
    final Context f36923a;

    p(Context context) {
        this.f36923a = context;
    }

    static long a(File file) {
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] listFiles = file.listFiles();
        long j = 0;
        if (listFiles != null) {
            for (File a2 : listFiles) {
                j += a(a2);
            }
        }
        return j;
    }
}
