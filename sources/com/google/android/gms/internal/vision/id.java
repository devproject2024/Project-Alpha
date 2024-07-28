package com.google.android.gms.internal.vision;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.vision.c;

public final class id {
    public static DynamiteModule a(Context context, String str, boolean z) {
        DynamiteModule.b bVar;
        String format = String.format("%s.%s", new Object[]{"com.google.android.gms.vision", str});
        if (!z) {
            format = "com.google.android.gms.vision.dynamite";
        }
        try {
            Object[] objArr = {format};
            if (Log.isLoggable("Vision", 3)) {
                String.format("Loading module %s", objArr);
            }
            if (z) {
                bVar = DynamiteModule.f9008a;
            } else {
                bVar = DynamiteModule.f9013f;
            }
            return DynamiteModule.a(context, bVar, format);
        } catch (DynamiteModule.a e2) {
            c.a(e2, "Error loading module %s optional module %b", format, Boolean.valueOf(z));
            return null;
        }
    }
}
