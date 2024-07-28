package com.google.android.play.core.assetpacks;

import com.google.android.play.core.e.c;
import java.io.File;
import java.util.List;

final /* synthetic */ class cu implements c {

    /* renamed from: a  reason: collision with root package name */
    private final ad f37165a;

    private cu(ad adVar) {
        this.f37165a = adVar;
    }

    static c a(ad adVar) {
        return new cu(adVar);
    }

    public final void onSuccess(Object obj) {
        ad adVar = this.f37165a;
        List list = (List) obj;
        int a2 = adVar.f36954b.a();
        List<File> b2 = adVar.b();
        int size = b2.size();
        for (int i2 = 0; i2 < size; i2++) {
            File file = b2.get(i2);
            if (!list.contains(file.getName()) && ad.b(file) != ((long) a2)) {
                ad.c(file);
            }
        }
    }
}
