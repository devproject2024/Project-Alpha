package exfilepicker.a.a;

import java.io.File;
import java.util.Comparator;

abstract class a implements Comparator<File> {
    /* access modifiers changed from: package-private */
    public abstract int b(File file, File file2);

    a() {
    }

    /* renamed from: a */
    public int compare(File file, File file2) {
        if (file.isDirectory() && !file2.isDirectory()) {
            return -1;
        }
        if (file.isDirectory() || !file2.isDirectory()) {
            return b(file, file2);
        }
        return 1;
    }
}
