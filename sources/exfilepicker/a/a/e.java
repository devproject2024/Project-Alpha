package exfilepicker.a.a;

import java.io.File;
import java.util.Locale;

final class e extends a {
    e() {
    }

    /* access modifiers changed from: package-private */
    public final int b(File file, File file2) {
        return file.getName().toLowerCase(Locale.getDefault()).compareTo(file2.getName().toLowerCase(Locale.getDefault()));
    }
}
