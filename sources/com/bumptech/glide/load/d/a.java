package com.bumptech.glide.load.d;

import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import com.bumptech.glide.load.b;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.d.a.n;
import com.bumptech.glide.load.d.a.o;
import com.bumptech.glide.load.d.a.t;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.k;
import java.io.IOException;

public abstract class a<T> implements k<ImageDecoder.Source, T> {

    /* renamed from: a  reason: collision with root package name */
    final t f7096a = t.a();

    /* access modifiers changed from: protected */
    public abstract v<T> a(ImageDecoder.Source source, int i2, int i3, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) throws IOException;

    public final /* bridge */ /* synthetic */ boolean a(Object obj, i iVar) throws IOException {
        return true;
    }

    public final v<T> a(ImageDecoder.Source source, int i2, int i3, i iVar) throws IOException {
        final b bVar = (b) iVar.a(o.f7159a);
        final n nVar = (n) iVar.a(n.f7157h);
        final boolean z = iVar.a(o.f7163e) != null && ((Boolean) iVar.a(o.f7163e)).booleanValue();
        final j jVar = (j) iVar.a(o.f7160b);
        final int i4 = i2;
        final int i5 = i3;
        return a(source, i2, i3, (ImageDecoder.OnHeaderDecodedListener) new ImageDecoder.OnHeaderDecodedListener() {
            public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
                boolean z = true;
                if (a.this.f7096a.a(i4, i5, z, false)) {
                    imageDecoder.setAllocator(3);
                } else {
                    imageDecoder.setAllocator(1);
                }
                if (bVar == b.PREFER_RGB_565) {
                    imageDecoder.setMemorySizePolicy(0);
                }
                imageDecoder.setOnPartialImageListener(new ImageDecoder.OnPartialImageListener() {
                    public final boolean onPartialImage(ImageDecoder.DecodeException decodeException) {
                        return false;
                    }
                });
                Size size = imageInfo.getSize();
                int i2 = i4;
                if (i2 == Integer.MIN_VALUE) {
                    i2 = size.getWidth();
                }
                int i3 = i5;
                if (i3 == Integer.MIN_VALUE) {
                    i3 = size.getHeight();
                }
                float a2 = nVar.a(size.getWidth(), size.getHeight(), i2, i3);
                int round = Math.round(((float) size.getWidth()) * a2);
                int round2 = Math.round(((float) size.getHeight()) * a2);
                if (Log.isLoggable("ImageDecoder", 2)) {
                    StringBuilder sb = new StringBuilder("Resizing from [");
                    sb.append(size.getWidth());
                    sb.append("x");
                    sb.append(size.getHeight());
                    sb.append("] to [");
                    sb.append(round);
                    sb.append("x");
                    sb.append(round2);
                    sb.append("] scaleFactor: ");
                    sb.append(a2);
                }
                imageDecoder.setTargetSize(round, round2);
                if (Build.VERSION.SDK_INT >= 28) {
                    if (jVar != j.DISPLAY_P3 || imageInfo.getColorSpace() == null || !imageInfo.getColorSpace().isWideGamut()) {
                        z = false;
                    }
                    imageDecoder.setTargetColorSpace(ColorSpace.get(z ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB));
                } else if (Build.VERSION.SDK_INT >= 26) {
                    imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
                }
            }
        });
    }
}
