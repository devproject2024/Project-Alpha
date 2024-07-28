package exfilepicker.a.a;

import java.io.File;

final class g extends a {
    g() {
    }

    /* access modifiers changed from: package-private */
    public final int b(File file, File file2) {
        return Long.valueOf(file.length()).compareTo(Long.valueOf(file2.length()));
    }
}
