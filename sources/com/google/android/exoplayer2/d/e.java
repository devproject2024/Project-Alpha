package com.google.android.exoplayer2.d;

import android.media.MediaFormat;
import java.nio.ByteBuffer;
import java.util.List;

public final class e {
    public static void a(MediaFormat mediaFormat, List<byte[]> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            mediaFormat.setByteBuffer("csd-".concat(String.valueOf(i2)), ByteBuffer.wrap(list.get(i2)));
        }
    }

    public static void a(MediaFormat mediaFormat, String str, int i2) {
        if (i2 != -1) {
            mediaFormat.setInteger(str, i2);
        }
    }
}
