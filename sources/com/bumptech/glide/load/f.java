package com.bumptech.glide.load;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.d.a.y;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public final class f {

    interface a {
        int a(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    interface b {
        ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    public static ImageHeaderParser.ImageType a(List<ImageHeaderParser> list, final InputStream inputStream, com.bumptech.glide.load.b.a.b bVar) throws IOException {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new y(inputStream, bVar);
        }
        inputStream.mark(5242880);
        return a(list, (b) new b() {
            public final ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws IOException {
                try {
                    return imageHeaderParser.a(inputStream);
                } finally {
                    inputStream.reset();
                }
            }
        });
    }

    public static ImageHeaderParser.ImageType a(List<ImageHeaderParser> list, b bVar) throws IOException {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            ImageHeaderParser.ImageType a2 = bVar.a(list.get(i2));
            if (a2 != ImageHeaderParser.ImageType.UNKNOWN) {
                return a2;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    public static int b(List<ImageHeaderParser> list, final InputStream inputStream, final com.bumptech.glide.load.b.a.b bVar) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new y(inputStream, bVar);
        }
        inputStream.mark(5242880);
        return a(list, (a) new a() {
            public final int a(ImageHeaderParser imageHeaderParser) throws IOException {
                try {
                    return imageHeaderParser.a(inputStream, bVar);
                } finally {
                    inputStream.reset();
                }
            }
        });
    }

    public static int a(List<ImageHeaderParser> list, a aVar) throws IOException {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            int a2 = aVar.a(list.get(i2));
            if (a2 != -1) {
                return a2;
            }
        }
        return -1;
    }
}
