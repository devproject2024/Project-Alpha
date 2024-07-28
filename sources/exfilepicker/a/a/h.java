package exfilepicker.a.a;

import java.io.File;

final class h extends a {
    h() {
    }

    /* access modifiers changed from: package-private */
    public final int b(File file, File file2) {
        return Long.valueOf(file2.length()).compareTo(Long.valueOf(file.length()));
    }
}
