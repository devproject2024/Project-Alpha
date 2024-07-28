package com.alipay.imobile.network.quake.h.b;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;

public final class c extends BufferedInputStream {

    /* renamed from: a  reason: collision with root package name */
    protected int f14887a = 0;

    public c(InputStream inputStream) {
        super(inputStream, FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
    }

    public final synchronized int read(byte[] bArr, int i2, int i3) throws IOException {
        int read;
        read = super.read(bArr, i2, i3);
        if (read > 0) {
            this.f14887a += read;
        }
        return read;
    }
}
