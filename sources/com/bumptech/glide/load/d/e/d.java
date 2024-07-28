package com.bumptech.glide.load.d.e;

import android.util.Log;
import com.bumptech.glide.g.a;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.l;
import java.io.File;
import java.io.IOException;

public final class d implements l<c> {
    public final /* bridge */ /* synthetic */ boolean a(Object obj, File file, i iVar) {
        return a((v) obj, file);
    }

    public final c a(i iVar) {
        return c.SOURCE;
    }

    private static boolean a(v<c> vVar, File file) {
        try {
            a.a(vVar.b().b(), file);
            return true;
        } catch (IOException unused) {
            Log.isLoggable("GifEncoder", 5);
            return false;
        }
    }
}
