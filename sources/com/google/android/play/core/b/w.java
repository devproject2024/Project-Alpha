package com.google.android.play.core.b;

import com.google.android.play.core.d.as;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class w implements q {
    static v a() {
        return new s();
    }

    static Object a(ClassLoader classLoader) {
        return an.a((Object) classLoader, "pathList", Object.class).a();
    }

    static boolean a(ClassLoader classLoader, File file, File file2, boolean z, v vVar, String str, u uVar) {
        ArrayList arrayList = new ArrayList();
        Object a2 = a(classLoader);
        am b2 = an.b(a2, "dexElements", Object.class);
        List<Object> asList = Arrays.asList((Object[]) b2.a());
        ArrayList arrayList2 = new ArrayList();
        for (Object a3 : asList) {
            arrayList2.add(an.a(a3, str, File.class).a());
        }
        if (!arrayList2.contains(file2)) {
            if (!z && !uVar.a(a2, file2, file)) {
                String valueOf = String.valueOf(file2.getPath());
                if (valueOf.length() == 0) {
                    new String("Should be optimized ");
                } else {
                    "Should be optimized ".concat(valueOf);
                }
                return false;
            }
            b2.a((Collection) Arrays.asList(vVar.a(a2, new ArrayList(Collections.singleton(file2)), file, arrayList)));
            if (!arrayList.isEmpty()) {
                al alVar = new al("DexPathList.makeDexElement failed");
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    bg.a(alVar, (IOException) arrayList.get(i2));
                }
                an.b(a2, "dexElementsSuppressedExceptions", IOException.class).a((Collection) arrayList);
                throw alVar;
            }
        }
        return true;
    }

    static u b() {
        return new t();
    }

    static void b(ClassLoader classLoader, Set<File> set) {
        if (!set.isEmpty()) {
            HashSet hashSet = new HashSet();
            for (File next : set) {
                String valueOf = String.valueOf(next.getParentFile().getAbsolutePath());
                if (valueOf.length() == 0) {
                    new String("Adding native library parent directory: ");
                } else {
                    "Adding native library parent directory: ".concat(valueOf);
                }
                hashSet.add(next.getParentFile());
            }
            am b2 = an.b(a(classLoader), "nativeLibraryDirectories", File.class);
            hashSet.removeAll(Arrays.asList((File[]) b2.a()));
            synchronized (as.class) {
                int size = hashSet.size();
                StringBuilder sb = new StringBuilder(30);
                sb.append("Adding directories ");
                sb.append(size);
                b2.b(hashSet);
            }
        }
    }

    public final void a(ClassLoader classLoader, Set<File> set) {
        b(classLoader, set);
    }

    public final boolean a(ClassLoader classLoader, File file, File file2, boolean z) {
        return a(classLoader, file, file2, z, a(), "zip", b());
    }
}
