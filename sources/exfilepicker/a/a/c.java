package exfilepicker.a.a;

import java.io.File;

public final class c extends a {
    public final /* bridge */ /* synthetic */ int a(File file, File file2) {
        return super.compare(file, file2);
    }

    /* access modifiers changed from: package-private */
    public final int b(File file, File file2) {
        return Long.valueOf(file.lastModified()).compareTo(Long.valueOf(file2.lastModified()));
    }
}
