package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.util.Base64;
import com.google.android.play.core.b.bg;
import com.google.android.play.core.d.as;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;

public final class by {

    /* renamed from: a  reason: collision with root package name */
    private static e f37110a;

    static long a(byte[] bArr, int i2) {
        return ((long) ((b(bArr, i2 + 2) << 16) | b(bArr, i2))) & 4294967295L;
    }

    static String a(List<File> list) throws NoSuchAlgorithmException, IOException {
        int read;
        MessageDigest instance = MessageDigest.getInstance("SHA256");
        byte[] bArr = new byte[FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE];
        for (File fileInputStream : list) {
            FileInputStream fileInputStream2 = new FileInputStream(fileInputStream);
            do {
                try {
                    read = fileInputStream2.read(bArr);
                    if (read > 0) {
                        instance.update(bArr, 0, read);
                    }
                } catch (Throwable th) {
                    bg.a(th, th);
                }
            } while (read != -1);
            fileInputStream2.close();
        }
        return Base64.encodeToString(instance.digest(), 11);
        throw th;
    }

    public static boolean a(int i2) {
        return i2 == 5 || i2 == 6 || i2 == 4;
    }

    static boolean a(int i2, int i3) {
        if (i2 == 5 && i3 != 5) {
            return true;
        }
        if (i2 == 6 && i3 != 6 && i3 != 5) {
            return true;
        }
        if (i2 == 4 && i3 != 4) {
            return true;
        }
        if (i2 == 3 && (i3 == 2 || i3 == 7 || i3 == 1 || i3 == 8)) {
            return true;
        }
        if (i2 == 2) {
            return i3 == 1 || i3 == 8;
        }
        return false;
    }

    static int b(byte[] bArr, int i2) {
        return ((bArr[i2 + 1] & 255) << 8) | (bArr[i2] & 255);
    }

    public static boolean b(int i2) {
        return i2 == 2 || i2 == 7 || i2 == 3;
    }

    static synchronized e a(Context context) {
        e eVar;
        synchronized (by.class) {
            if (f37110a == null) {
                as asVar = new as((byte) 0);
                asVar.f36992a = new da(as.a(context));
                da daVar = asVar.f36992a;
                if (daVar != null) {
                    f37110a = new at(daVar);
                } else {
                    throw new IllegalStateException(String.valueOf(da.class.getCanonicalName()).concat(" must be set"));
                }
            }
            eVar = f37110a;
        }
        return eVar;
    }
}
