package com.google.android.gms.vision.clearcut;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.clearcut.a;
import com.google.android.gms.internal.vision.bl;
import com.google.android.gms.internal.vision.bt;
import com.google.android.gms.internal.vision.du;
import com.google.android.gms.vision.c;

public class VisionClearcutLogger {
    private final a zzbw;
    private boolean zzbx = true;

    public VisionClearcutLogger(Context context) {
        this.zzbw = new a(context, "VISION");
    }

    public final void zzb(int i2, bt.o oVar) {
        byte[] d2 = oVar.d();
        if (i2 < 0 || i2 > 3) {
            Object[] objArr = {Integer.valueOf(i2)};
            if (Log.isLoggable("Vision", 4)) {
                String.format("Illegal event code: %d", objArr);
                return;
            }
            return;
        }
        try {
            if (this.zzbx) {
                a.C0123a a2 = this.zzbw.a(d2);
                a2.f8307a.f9386e = i2;
                a2.a();
                return;
            }
            bt.o.a a3 = bt.o.a();
            try {
                a3.a(d2, d2.length, du.b());
                Object[] objArr2 = {a3.toString()};
                if (Log.isLoggable("Vision", 6)) {
                    String.format("Would have logged:\n%s", objArr2);
                }
            } catch (Exception e2) {
                c.a(e2, "Parsing error", new Object[0]);
            }
        } catch (Exception e3) {
            bl.a(e3);
            c.a(e3, "Failed to log", new Object[0]);
        }
    }
}
