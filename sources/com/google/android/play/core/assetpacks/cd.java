package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.IOException;
import java.util.List;

final /* synthetic */ class cd implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ad f37119a;

    cd(ad adVar) {
        this.f37119a = adVar;
    }

    public final void run() {
        ad adVar = this.f37119a;
        List<File> b2 = adVar.b();
        int size = b2.size();
        for (int i2 = 0; i2 < size; i2++) {
            File file = b2.get(i2);
            if (file.listFiles() != null) {
                ad.a(file);
                long b3 = ad.b(file);
                if (((long) adVar.f36954b.a()) != b3) {
                    try {
                        new File(new File(file, String.valueOf(b3)), "stale.tmp").createNewFile();
                    } catch (IOException unused) {
                        ad.f36951a.b("Could not write staleness marker.", new Object[0]);
                    }
                }
                for (File a2 : file.listFiles()) {
                    ad.a(a2);
                }
            }
        }
    }
}
