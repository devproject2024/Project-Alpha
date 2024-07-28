package exfilepicker.a.a;

import java.io.File;
import java.util.Locale;

final class f extends a {
    f() {
    }

    /* access modifiers changed from: package-private */
    public final int b(File file, File file2) {
        return file2.getName().toLowerCase(Locale.getDefault()).compareTo(file.getName().toLowerCase(Locale.getDefault()));
    }
}
