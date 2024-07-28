package com.google.android.play.core.splitcompat;

import com.google.android.play.core.b.bg;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

final class i implements k {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Set f37512a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ s f37513b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ ZipFile f37514c;

    i(Set set, s sVar, ZipFile zipFile) {
        this.f37512a = set;
        this.f37513b = sVar;
        this.f37514c = zipFile;
    }

    public final void a(l lVar, File file, boolean z) throws IOException {
        FileOutputStream fileOutputStream;
        this.f37512a.add(file);
        if (!z) {
            String.format("NativeLibraryExtractor: split '%s' has native library '%s' that does not exist; extracting from '%s!%s' to '%s'", new Object[]{this.f37513b.b(), lVar.f37515a, this.f37513b.a().getAbsolutePath(), lVar.f37516b.getName(), file.getAbsolutePath()});
            ZipFile zipFile = this.f37514c;
            ZipEntry zipEntry = lVar.f37516b;
            int i2 = m.f37517a;
            byte[] bArr = new byte[4096];
            InputStream inputStream = zipFile.getInputStream(zipEntry);
            try {
                fileOutputStream = new FileOutputStream(file);
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.close();
                if (inputStream != null) {
                    inputStream.close();
                    return;
                }
                return;
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th2) {
                        bg.a(th, th2);
                    }
                }
                throw th;
            }
        } else {
            return;
        }
        throw th;
    }
}
