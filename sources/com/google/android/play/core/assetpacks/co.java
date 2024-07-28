package com.google.android.play.core.assetpacks;

import com.google.android.play.core.b.bg;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

final class co {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f37156a = Pattern.compile("[0-9]+-(NAM|LFH)\\.dat");

    static List<File> a(File file, File file2) throws IOException {
        File[] fileArr;
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file2.listFiles(cn.f37155a);
        if (listFiles != null) {
            fileArr = new File[r2];
            for (File file3 : listFiles) {
                int parseInt = Integer.parseInt(file3.getName().split("-")[0]);
                if (parseInt > listFiles.length || fileArr[parseInt] != null) {
                    throw new ax("Metadata folder ordering corrupt.");
                }
                fileArr[parseInt] = file3;
            }
        } else {
            fileArr = new File[0];
        }
        for (File file4 : fileArr) {
            arrayList.add(file4);
            if (file4.getName().contains("LFH")) {
                FileInputStream fileInputStream = new FileInputStream(file4);
                try {
                    cs a2 = new ao(fileInputStream).a();
                    if (a2.a() != null) {
                        File file5 = new File(file, a2.a());
                        if (file5.exists()) {
                            arrayList.add(file5);
                            fileInputStream.close();
                        } else {
                            throw new ax(String.format("Missing asset file %s during slice reconstruction.", new Object[]{file5.getCanonicalPath()}));
                        }
                    } else {
                        throw new ax("Metadata files corrupt. Could not read local file header.");
                    }
                } catch (Throwable th) {
                    bg.a(th, th);
                }
            }
        }
        return arrayList;
        throw th;
    }
}
