package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class c implements DynamiteModule.b {
    c() {
    }

    public final DynamiteModule.b.a a(Context context, String str, DynamiteModule.b.C0134b bVar) throws DynamiteModule.a {
        DynamiteModule.b.a aVar = new DynamiteModule.b.a();
        aVar.f9018b = bVar.a(context, str, false);
        if (aVar.f9018b == 0) {
            aVar.f9019c = 0;
        } else {
            aVar.f9019c = 1;
        }
        return aVar;
    }
}
