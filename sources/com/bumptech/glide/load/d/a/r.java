package com.bumptech.glide.load.d.a;

import androidx.exifinterface.a.a;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.b.a.b;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class r implements ImageHeaderParser {
    public final ImageHeaderParser.ImageType a(InputStream inputStream) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    public final ImageHeaderParser.ImageType a(ByteBuffer byteBuffer) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    public final int a(InputStream inputStream, b bVar) throws IOException {
        int a2 = new a(inputStream).a("Orientation");
        if (a2 == 0) {
            return -1;
        }
        return a2;
    }
}
