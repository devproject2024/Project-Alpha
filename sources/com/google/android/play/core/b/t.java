package com.google.android.play.core.b;

import java.io.File;

final class t implements u {
    t() {
    }

    public final boolean a(Object obj, File file, File file2) {
        return new File((String) an.a(obj.getClass(), "optimizedPathFor", String.class, File.class, file, File.class, file2)).exists();
    }
}
