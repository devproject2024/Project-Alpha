package com.google.android.play.core.b;

import com.alipay.mobile.nebula.util.H5TabbarUtils;
import java.io.File;
import java.util.Set;

public final class ak implements q {
    public final void a(ClassLoader classLoader, Set<File> set) {
        ah.b(classLoader, set);
    }

    public final boolean a(ClassLoader classLoader, File file, File file2, boolean z) {
        return w.a(classLoader, file, file2, z, ac.a(), H5TabbarUtils.MATCH_TYPE_PATH, new aj());
    }
}
