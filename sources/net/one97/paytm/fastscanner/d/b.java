package net.one97.paytm.fastscanner.d;

import android.graphics.Bitmap;
import android.net.Uri;
import java.util.List;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    a f50459a;

    /* renamed from: b  reason: collision with root package name */
    byte[] f50460b;

    /* renamed from: c  reason: collision with root package name */
    int f50461c;

    /* renamed from: d  reason: collision with root package name */
    int f50462d;

    /* renamed from: e  reason: collision with root package name */
    int f50463e;

    /* renamed from: f  reason: collision with root package name */
    Bitmap f50464f;

    /* renamed from: g  reason: collision with root package name */
    Uri f50465g;

    public interface a {
        void a();

        void a(List<com.google.firebase.ml.vision.barcode.a> list);
    }

    b(byte[] bArr, int i2, int i3, a aVar) {
        this.f50460b = bArr;
        this.f50461c = i2;
        this.f50462d = i3;
        this.f50463e = 0;
        this.f50459a = aVar;
    }

    b(Bitmap bitmap, a aVar) {
        this.f50464f = bitmap;
        this.f50459a = aVar;
    }

    b(Uri uri, a aVar) {
        this.f50465g = uri;
        this.f50459a = aVar;
    }
}
