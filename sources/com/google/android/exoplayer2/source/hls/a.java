package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.f.ad;
import com.google.android.exoplayer2.f.i;
import com.google.android.exoplayer2.f.k;
import com.google.android.exoplayer2.f.l;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

final class a implements i {

    /* renamed from: a  reason: collision with root package name */
    private final i f33070a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f33071b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f33072c;

    /* renamed from: d  reason: collision with root package name */
    private CipherInputStream f33073d;

    public a(i iVar, byte[] bArr, byte[] bArr2) {
        this.f33070a = iVar;
        this.f33071b = bArr;
        this.f33072c = bArr2;
    }

    public final void a(ad adVar) {
        this.f33070a.a(adVar);
    }

    public final int a(byte[] bArr, int i2, int i3) throws IOException {
        com.google.android.exoplayer2.g.a.a(this.f33073d);
        int read = this.f33073d.read(bArr, i2, i3);
        if (read < 0) {
            return -1;
        }
        return read;
    }

    public final Uri a() {
        return this.f33070a.a();
    }

    public final Map<String, List<String>> b() {
        return this.f33070a.b();
    }

    public final void c() throws IOException {
        if (this.f33073d != null) {
            this.f33073d = null;
            this.f33070a.c();
        }
    }

    public final long a(l lVar) throws IOException {
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
            try {
                instance.init(2, new SecretKeySpec(this.f33071b, "AES"), new IvParameterSpec(this.f33072c));
                k kVar = new k(this.f33070a, lVar);
                this.f33073d = new CipherInputStream(kVar, instance);
                kVar.a();
                return -1;
            } catch (InvalidAlgorithmParameterException | InvalidKeyException e2) {
                throw new RuntimeException(e2);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e3) {
            throw new RuntimeException(e3);
        }
    }
}
