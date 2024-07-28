package com.google.android.play.core.b;

import java.io.File;

final class ag implements u {
    ag() {
    }

    public final boolean a(Object obj, File file, File file2) {
        try {
            return !((Boolean) an.a((Class) Class.forName("dalvik.system.DexFile"), "isDexOptNeeded", Boolean.class, String.class, file.getPath())).booleanValue();
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
