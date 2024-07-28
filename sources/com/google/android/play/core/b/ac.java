package com.google.android.play.core.b;

import com.google.android.play.core.d.as;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class ac implements q {
    static v a() {
        return new y();
    }

    public static void a(ClassLoader classLoader, Set<File> set, aa aaVar) {
        if (!set.isEmpty()) {
            HashSet hashSet = new HashSet();
            for (File parentFile : set) {
                hashSet.add(parentFile.getParentFile());
            }
            Object a2 = w.a(classLoader);
            am<List> a3 = an.a(a2, "nativeLibraryDirectories", List.class);
            synchronized (as.class) {
                ArrayList arrayList = new ArrayList(a3.a());
                hashSet.removeAll(arrayList);
                arrayList.addAll(hashSet);
                a3.a(arrayList);
            }
            ArrayList arrayList2 = new ArrayList();
            Object[] a4 = aaVar.a(a2, new ArrayList(hashSet), arrayList2);
            if (!arrayList2.isEmpty()) {
                al alVar = new al("Error in makePathElements");
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    bg.a(alVar, (IOException) arrayList2.get(i2));
                }
                throw alVar;
            }
            synchronized (as.class) {
                an.b(a2, "nativeLibraryPathElements", Object.class).b(Arrays.asList(a4));
            }
        }
    }

    public static boolean a(ClassLoader classLoader, File file, File file2, boolean z, String str) {
        return w.a(classLoader, file, file2, z, a(), str, w.b());
    }

    static aa b() {
        return new z();
    }

    public final void a(ClassLoader classLoader, Set<File> set) {
        a(classLoader, set, b());
    }

    public final boolean a(ClassLoader classLoader, File file, File file2, boolean z) {
        return a(classLoader, file, file2, z, "zip");
    }
}
