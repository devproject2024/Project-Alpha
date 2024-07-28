package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import androidx.core.content.b.c;
import androidx.core.e.b;
import java.io.IOException;
import java.io.InputStream;

public final class i extends j {
    /* access modifiers changed from: protected */
    public final b.C0041b a(b.C0041b[] bVarArr, int i2) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    /* access modifiers changed from: protected */
    public final Typeface a(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    public final Typeface a(Context context, b.C0041b[] bVarArr, int i2) {
        ParcelFileDescriptor openFileDescriptor;
        ContentResolver contentResolver = context.getContentResolver();
        int length = bVarArr.length;
        int i3 = 0;
        FontFamily.Builder builder = null;
        int i4 = 0;
        while (true) {
            int i5 = 1;
            if (i4 < length) {
                b.C0041b bVar = bVarArr[i4];
                try {
                    openFileDescriptor = contentResolver.openFileDescriptor(bVar.f2888a, "r", (CancellationSignal) null);
                    if (openFileDescriptor != null) {
                        Font.Builder weight = new Font.Builder(openFileDescriptor).setWeight(bVar.f2890c);
                        if (!bVar.f2891d) {
                            i5 = 0;
                        }
                        Font build = weight.setSlant(i5).setTtcIndex(bVar.f2889b).build();
                        if (builder == null) {
                            builder = new FontFamily.Builder(build);
                        } else {
                            builder.addFont(build);
                        }
                        if (openFileDescriptor == null) {
                            i4++;
                        }
                    } else if (openFileDescriptor == null) {
                        i4++;
                    }
                    openFileDescriptor.close();
                } catch (IOException unused) {
                } catch (Throwable th) {
                    th.addSuppressed(th);
                    break;
                }
                i4++;
            } else if (builder == null) {
                return null;
            } else {
                int i6 = (i2 & 1) != 0 ? 700 : 400;
                if ((i2 & 2) != 0) {
                    i3 = 1;
                }
                return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle(i6, i3)).build();
            }
        }
        throw th;
    }

    public final Typeface a(Context context, Resources resources, int i2, String str, int i3) {
        try {
            Font build = new Font.Builder(resources, i2).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(build).build()).setStyle(build.getStyle()).build();
        } catch (IOException unused) {
            return null;
        }
    }

    public final Typeface a(Context context, c.b bVar, Resources resources, int i2) {
        c.C0040c[] cVarArr = bVar.f2830a;
        int length = cVarArr.length;
        int i3 = 0;
        FontFamily.Builder builder = null;
        int i4 = 0;
        while (true) {
            int i5 = 1;
            if (i4 >= length) {
                break;
            }
            c.C0040c cVar = cVarArr[i4];
            try {
                Font.Builder weight = new Font.Builder(resources, cVar.f2836f).setWeight(cVar.f2832b);
                if (!cVar.f2833c) {
                    i5 = 0;
                }
                Font build = weight.setSlant(i5).setTtcIndex(cVar.f2835e).setFontVariationSettings(cVar.f2834d).build();
                if (builder == null) {
                    builder = new FontFamily.Builder(build);
                } else {
                    builder.addFont(build);
                }
            } catch (IOException unused) {
            }
            i4++;
        }
        if (builder == null) {
            return null;
        }
        int i6 = (i2 & 1) != 0 ? 700 : 400;
        if ((i2 & 2) != 0) {
            i3 = 1;
        }
        return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle(i6, i3)).build();
    }
}
