package com.google.a.a.c;

import com.google.a.a.b.a.a.a.a.c;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class d {
    public static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        c.a(inputStream);
        c.a(outputStream);
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }
}
