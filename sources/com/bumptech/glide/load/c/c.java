package com.bumptech.glide.load.c;

import android.util.Log;
import com.bumptech.glide.g.a;
import com.bumptech.glide.load.d;
import com.bumptech.glide.load.i;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class c implements d<ByteBuffer> {
    public final /* bridge */ /* synthetic */ boolean a(Object obj, File file, i iVar) {
        return a((ByteBuffer) obj, file);
    }

    private static boolean a(ByteBuffer byteBuffer, File file) {
        try {
            a.a(byteBuffer, file);
            return true;
        } catch (IOException unused) {
            Log.isLoggable("ByteBufferEncoder", 3);
            return false;
        }
    }
}
