package com.google.a.a.c;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class l {
    public static void a(InputStream inputStream, OutputStream outputStream) throws IOException {
        try {
            d.a(inputStream, outputStream);
        } finally {
            inputStream.close();
        }
    }

    /* JADX INFO: finally extract failed */
    public static long a(t tVar) throws IOException {
        c cVar = new c();
        try {
            tVar.a(cVar);
            cVar.close();
            return cVar.f7563a;
        } catch (Throwable th) {
            cVar.close();
            throw th;
        }
    }
}
