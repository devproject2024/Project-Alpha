package exfilepicker.a.a;

import java.io.File;

final class d extends a {
    d() {
    }

    /* access modifiers changed from: package-private */
    public final int b(File file, File file2) {
        return Long.valueOf(file2.lastModified()).compareTo(Long.valueOf(file.lastModified()));
    }
}
