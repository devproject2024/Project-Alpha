package org.apache.http.c;

import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import org.apache.http.e.a;

@Deprecated
public final class c {
    public static void a(d dVar, int i2) {
        a.a(dVar, "HTTP parameters");
        dVar.a("http.socket.timeout", i2);
    }

    public static void a(d dVar) {
        a.a(dVar, "HTTP parameters");
        dVar.a("http.socket.buffer-size", (int) FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
    }

    public static void b(d dVar, int i2) {
        a.a(dVar, "HTTP parameters");
        dVar.a("http.connection.timeout", i2);
    }

    public static void b(d dVar) {
        a.a(dVar, "HTTP parameters");
        dVar.a("http.connection.stalecheck");
    }
}
