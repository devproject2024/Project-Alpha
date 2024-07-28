package com.google.android.play.core.assetpacks;

import com.google.android.play.core.b.b;
import java.io.File;

final class ca {

    /* renamed from: a  reason: collision with root package name */
    static final b f37114a = new b("MergeSliceTaskHandler");

    /* renamed from: b  reason: collision with root package name */
    final ad f37115b;

    ca(ad adVar) {
        this.f37115b = adVar;
    }

    static void a(File file, File file2) {
        if (file.isDirectory()) {
            file2.mkdirs();
            for (File file3 : file.listFiles()) {
                a(file3, new File(file2, file3.getName()));
            }
            if (!file.delete()) {
                String valueOf = String.valueOf(file);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 28);
                sb.append("Unable to delete directory: ");
                sb.append(valueOf);
                throw new ax(sb.toString());
            }
        } else if (file2.exists()) {
            String valueOf2 = String.valueOf(file2);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 51);
            sb2.append("File clashing with existing file from other slice: ");
            sb2.append(valueOf2);
            throw new ax(sb2.toString());
        } else if (!file.renameTo(file2)) {
            String valueOf3 = String.valueOf(file);
            StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf3).length() + 21);
            sb3.append("Unable to move file: ");
            sb3.append(valueOf3);
            throw new ax(sb3.toString());
        }
    }
}
