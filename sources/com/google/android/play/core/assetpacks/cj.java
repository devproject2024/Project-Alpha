package com.google.android.play.core.assetpacks;

import com.google.android.play.core.b.b;
import com.google.android.play.core.b.bg;
import com.google.android.play.core.b.bh;
import com.google.android.play.core.b.r;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;

final class cj {

    /* renamed from: a  reason: collision with root package name */
    private static final b f37142a = new b("PatchSliceTaskHandler");

    /* renamed from: b  reason: collision with root package name */
    private final ad f37143b;

    /* renamed from: c  reason: collision with root package name */
    private final bh<dk> f37144c;

    cj(ad adVar, bh<dk> bhVar) {
        this.f37143b = adVar;
        this.f37144c = bhVar;
    }

    public final void a(ci ciVar) {
        InputStream inputStream;
        Throwable th;
        ci ciVar2 = ciVar;
        File a2 = this.f37143b.a(ciVar2.k, ciVar2.f37134a, ciVar2.f37135b);
        ad adVar = this.f37143b;
        String str = ciVar2.k;
        int i2 = ciVar2.f37134a;
        long j = ciVar2.f37135b;
        File file = new File(adVar.b(str, i2, j), ciVar2.f37139f);
        try {
            inputStream = ciVar2.f37141h;
            if (ciVar2.f37138e == 2) {
                inputStream = new GZIPInputStream(inputStream, FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
            }
            ag agVar = new ag(a2, file);
            File file2 = new File(this.f37143b.f(ciVar2.k, ciVar2.f37136c, ciVar2.f37137d, ciVar2.f37139f), "slice.zip.tmp");
            if (file2.getParentFile() != null) {
                if (!file2.getParentFile().exists()) {
                    file2.getParentFile().mkdirs();
                }
            }
            r.a(agVar, inputStream, new FileOutputStream(file2), ciVar2.f37140g);
            if (file2.renameTo(this.f37143b.e(ciVar2.k, ciVar2.f37136c, ciVar2.f37137d, ciVar2.f37139f))) {
                inputStream.close();
                f37142a.d("Patching finished for slice %s of pack %s.", ciVar2.f37139f, ciVar2.k);
                this.f37144c.a().a(ciVar2.j, ciVar2.k, ciVar2.f37139f, 0);
                try {
                    ciVar2.f37141h.close();
                    return;
                } catch (IOException unused) {
                    f37142a.e("Could not close file for slice %s of pack %s.", ciVar2.f37139f, ciVar2.k);
                    return;
                }
            } else {
                throw new ax(String.format("Error moving patch for slice %s of pack %s.", new Object[]{ciVar2.f37139f, ciVar2.k}), ciVar2.j);
            }
        } catch (IOException e2) {
            f37142a.b("IOException during patching %s.", e2.getMessage());
            throw new ax(String.format("Error patching slice %s of pack %s.", new Object[]{ciVar2.f37139f, ciVar2.k}), e2, ciVar2.j);
        } catch (Throwable th2) {
            bg.a(th, th2);
        }
        throw th;
    }
}
