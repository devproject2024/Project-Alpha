package com.google.android.gms.internal.firebase_ml;

import android.os.Build;
import com.google.android.gms.internal.firebase_ml.bg;

public final class ej {
    public static bg.f a(en enVar) {
        int i2;
        bg.f.b bVar;
        if (enVar.f9869b.f12544c != null) {
            bVar = bg.f.b.BITMAP;
            if (Build.VERSION.SDK_INT >= 19) {
                i2 = enVar.f9869b.f12544c.getAllocationByteCount();
            } else {
                i2 = enVar.f9869b.f12544c.getByteCount();
            }
        } else {
            int i3 = enVar.f9869b.f12542a.f12551f;
            if (i3 == 16) {
                bVar = bg.f.b.NV16;
            } else if (i3 == 17) {
                bVar = bg.f.b.NV21;
            } else if (i3 != 842094169) {
                bVar = bg.f.b.UNKNOWN_FORMAT;
            } else {
                bVar = bg.f.b.YV12;
            }
            i2 = enVar.f9869b.a().capacity();
        }
        return (bg.f) bg.f.a().a(bVar).a(i2).i();
    }
}
