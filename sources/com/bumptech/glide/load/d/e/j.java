package com.bumptech.glide.load.d.e;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.b.a.b;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.k;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class j implements k<InputStream, c> {

    /* renamed from: a  reason: collision with root package name */
    private final List<ImageHeaderParser> f7242a;

    /* renamed from: b  reason: collision with root package name */
    private final k<ByteBuffer, c> f7243b;

    /* renamed from: c  reason: collision with root package name */
    private final b f7244c;

    public final /* synthetic */ v a(Object obj, int i2, int i3, i iVar) throws IOException {
        byte[] a2 = a((InputStream) obj);
        if (a2 == null) {
            return null;
        }
        return this.f7243b.a(ByteBuffer.wrap(a2), i2, i3, iVar);
    }

    public final /* synthetic */ boolean a(Object obj, i iVar) throws IOException {
        return !((Boolean) iVar.a(i.f7241b)).booleanValue() && f.a(this.f7242a, (InputStream) obj, this.f7244c) == ImageHeaderParser.ImageType.GIF;
    }

    public j(List<ImageHeaderParser> list, k<ByteBuffer, c> kVar, b bVar) {
        this.f7242a = list;
        this.f7243b = kVar;
        this.f7244c = bVar;
    }

    private static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException unused) {
            Log.isLoggable("StreamGifDecoder", 5);
            return null;
        }
    }
}
