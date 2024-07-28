package com.airbnb.lottie.d;

import android.content.Context;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f5983a;

    public b(Context context) {
        this.f5983a = context.getApplicationContext();
    }

    /* access modifiers changed from: package-private */
    public final File a(String str, InputStream inputStream, a aVar) throws IOException {
        FileOutputStream fileOutputStream;
        File file = new File(a(), a(str, aVar, true));
        try {
            fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[TarConstants.EOF_BLOCK];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    inputStream.close();
                    return file;
                }
            }
        } catch (Throwable th) {
            inputStream.close();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public final File a() {
        File file = new File(this.f5983a.getCacheDir(), "lottie_network_cache");
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    static String a(String str, a aVar, boolean z) {
        StringBuilder sb = new StringBuilder("lottie_cache_");
        sb.append(str.replaceAll("\\W+", ""));
        sb.append(z ? aVar.tempExtension() : aVar.extension);
        return sb.toString();
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.core.g.d<com.airbnb.lottie.d.a, java.io.InputStream> a(java.lang.String r6) {
        /*
            r5 = this;
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0067 }
            java.io.File r2 = r5.a()     // Catch:{ FileNotFoundException -> 0x0067 }
            com.airbnb.lottie.d.a r3 = com.airbnb.lottie.d.a.JSON     // Catch:{ FileNotFoundException -> 0x0067 }
            r4 = 0
            java.lang.String r3 = a((java.lang.String) r6, (com.airbnb.lottie.d.a) r3, (boolean) r4)     // Catch:{ FileNotFoundException -> 0x0067 }
            r1.<init>(r2, r3)     // Catch:{ FileNotFoundException -> 0x0067 }
            boolean r2 = r1.exists()     // Catch:{ FileNotFoundException -> 0x0067 }
            if (r2 == 0) goto L_0x0018
            goto L_0x002f
        L_0x0018:
            java.io.File r1 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0067 }
            java.io.File r2 = r5.a()     // Catch:{ FileNotFoundException -> 0x0067 }
            com.airbnb.lottie.d.a r3 = com.airbnb.lottie.d.a.ZIP     // Catch:{ FileNotFoundException -> 0x0067 }
            java.lang.String r3 = a((java.lang.String) r6, (com.airbnb.lottie.d.a) r3, (boolean) r4)     // Catch:{ FileNotFoundException -> 0x0067 }
            r1.<init>(r2, r3)     // Catch:{ FileNotFoundException -> 0x0067 }
            boolean r2 = r1.exists()     // Catch:{ FileNotFoundException -> 0x0067 }
            if (r2 == 0) goto L_0x002e
            goto L_0x002f
        L_0x002e:
            r1 = r0
        L_0x002f:
            if (r1 != 0) goto L_0x0032
            return r0
        L_0x0032:
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{  }
            r2.<init>(r1)     // Catch:{  }
            java.lang.String r0 = r1.getAbsolutePath()
            java.lang.String r3 = ".zip"
            boolean r0 = r0.endsWith(r3)
            if (r0 == 0) goto L_0x0046
            com.airbnb.lottie.d.a r0 = com.airbnb.lottie.d.a.ZIP
            goto L_0x0048
        L_0x0046:
            com.airbnb.lottie.d.a r0 = com.airbnb.lottie.d.a.JSON
        L_0x0048:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Cache hit for "
            r3.<init>(r4)
            r3.append(r6)
            java.lang.String r6 = " at "
            r3.append(r6)
            java.lang.String r6 = r1.getAbsolutePath()
            r3.append(r6)
            com.airbnb.lottie.f.d.a()
            androidx.core.g.d r6 = new androidx.core.g.d
            r6.<init>(r0, r2)
            return r6
        L_0x0067:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.d.b.a(java.lang.String):androidx.core.g.d");
    }
}
