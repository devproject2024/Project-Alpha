package com.paytm.utility.b.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.m;
import java.security.MessageDigest;

public final class b implements m<Bitmap> {

    /* renamed from: b  reason: collision with root package name */
    private e f43722b;

    /* renamed from: c  reason: collision with root package name */
    private int f43723c;

    /* renamed from: d  reason: collision with root package name */
    private int f43724d;

    /* renamed from: e  reason: collision with root package name */
    private int f43725e;

    /* renamed from: f  reason: collision with root package name */
    private a f43726f;

    public enum a {
        ALL,
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        TOP,
        BOTTOM,
        LEFT,
        RIGHT,
        OTHER_TOP_LEFT,
        OTHER_TOP_RIGHT,
        OTHER_BOTTOM_LEFT,
        OTHER_BOTTOM_RIGHT,
        DIAGONAL_FROM_TOP_LEFT,
        DIAGONAL_FROM_TOP_RIGHT
    }

    public final void updateDiskCacheKey(MessageDigest messageDigest) {
    }

    public b(Context context, int i2, int i3, a aVar) {
        this(com.bumptech.glide.b.a(context).f6425a, i2, i3, aVar);
    }

    private b(e eVar, int i2, int i3, a aVar) {
        this.f43722b = eVar;
        this.f43723c = i2;
        this.f43724d = this.f43723c * 2;
        this.f43725e = i3;
        this.f43726f = aVar;
    }

    public final v<Bitmap> transform(Context context, v<Bitmap> vVar, int i2, int i3) {
        Bitmap b2 = vVar.b();
        int width = b2.getWidth();
        int height = b2.getHeight();
        Bitmap a2 = this.f43722b.a(width, height, Bitmap.Config.ARGB_8888);
        if (a2 == null) {
            a2 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(a2);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(b2, tileMode, tileMode));
        float f2 = (float) width;
        float f3 = (float) height;
        int i4 = this.f43725e;
        float f4 = f2 - ((float) i4);
        float f5 = f3 - ((float) i4);
        switch (this.f43726f) {
            case ALL:
                int i5 = this.f43725e;
                RectF rectF = new RectF((float) i5, (float) i5, f4, f5);
                int i6 = this.f43723c;
                canvas.drawRoundRect(rectF, (float) i6, (float) i6, paint);
                break;
            case TOP_LEFT:
                int i7 = this.f43725e;
                int i8 = this.f43724d;
                RectF rectF2 = new RectF((float) i7, (float) i7, (float) (i7 + i8), (float) (i7 + i8));
                int i9 = this.f43723c;
                canvas.drawRoundRect(rectF2, (float) i9, (float) i9, paint);
                int i10 = this.f43725e;
                int i11 = this.f43723c;
                canvas.drawRect(new RectF((float) i10, (float) (i10 + i11), (float) (i10 + i11), f5), paint);
                int i12 = this.f43725e;
                canvas.drawRect(new RectF((float) (this.f43723c + i12), (float) i12, f4, f5), paint);
                break;
            case TOP_RIGHT:
                int i13 = this.f43724d;
                int i14 = this.f43725e;
                RectF rectF3 = new RectF(f4 - ((float) i13), (float) i14, f4, (float) (i14 + i13));
                int i15 = this.f43723c;
                canvas.drawRoundRect(rectF3, (float) i15, (float) i15, paint);
                int i16 = this.f43725e;
                canvas.drawRect(new RectF((float) i16, (float) i16, f4 - ((float) this.f43723c), f5), paint);
                int i17 = this.f43723c;
                canvas.drawRect(new RectF(f4 - ((float) i17), (float) (this.f43725e + i17), f4, f5), paint);
                break;
            case BOTTOM_LEFT:
                int i18 = this.f43725e;
                int i19 = this.f43724d;
                RectF rectF4 = new RectF((float) i18, f5 - ((float) i19), (float) (i18 + i19), f5);
                int i20 = this.f43723c;
                canvas.drawRoundRect(rectF4, (float) i20, (float) i20, paint);
                int i21 = this.f43725e;
                canvas.drawRect(new RectF((float) i21, (float) i21, (float) (i21 + this.f43724d), f5 - ((float) this.f43723c)), paint);
                int i22 = this.f43725e;
                canvas.drawRect(new RectF((float) (this.f43723c + i22), (float) i22, f4, f5), paint);
                break;
            case BOTTOM_RIGHT:
                int i23 = this.f43724d;
                RectF rectF5 = new RectF(f4 - ((float) i23), f5 - ((float) i23), f4, f5);
                int i24 = this.f43723c;
                canvas.drawRoundRect(rectF5, (float) i24, (float) i24, paint);
                int i25 = this.f43725e;
                canvas.drawRect(new RectF((float) i25, (float) i25, f4 - ((float) this.f43723c), f5), paint);
                int i26 = this.f43723c;
                canvas.drawRect(new RectF(f4 - ((float) i26), (float) this.f43725e, f4, f5 - ((float) i26)), paint);
                break;
            case TOP:
                int i27 = this.f43725e;
                RectF rectF6 = new RectF((float) i27, (float) i27, f4, (float) (i27 + this.f43724d));
                int i28 = this.f43723c;
                canvas.drawRoundRect(rectF6, (float) i28, (float) i28, paint);
                int i29 = this.f43725e;
                canvas.drawRect(new RectF((float) i29, (float) (i29 + this.f43723c), f4, f5), paint);
                break;
            case BOTTOM:
                RectF rectF7 = new RectF((float) this.f43725e, f5 - ((float) this.f43724d), f4, f5);
                int i30 = this.f43723c;
                canvas.drawRoundRect(rectF7, (float) i30, (float) i30, paint);
                int i31 = this.f43725e;
                canvas.drawRect(new RectF((float) i31, (float) i31, f4, f5 - ((float) this.f43723c)), paint);
                break;
            case LEFT:
                int i32 = this.f43725e;
                RectF rectF8 = new RectF((float) i32, (float) i32, (float) (i32 + this.f43724d), f5);
                int i33 = this.f43723c;
                canvas.drawRoundRect(rectF8, (float) i33, (float) i33, paint);
                int i34 = this.f43725e;
                canvas.drawRect(new RectF((float) (this.f43723c + i34), (float) i34, f4, f5), paint);
                break;
            case RIGHT:
                RectF rectF9 = new RectF(f4 - ((float) this.f43724d), (float) this.f43725e, f4, f5);
                int i35 = this.f43723c;
                canvas.drawRoundRect(rectF9, (float) i35, (float) i35, paint);
                int i36 = this.f43725e;
                canvas.drawRect(new RectF((float) i36, (float) i36, f4 - ((float) this.f43723c), f5), paint);
                break;
            case OTHER_TOP_LEFT:
                RectF rectF10 = new RectF((float) this.f43725e, f5 - ((float) this.f43724d), f4, f5);
                int i37 = this.f43723c;
                canvas.drawRoundRect(rectF10, (float) i37, (float) i37, paint);
                RectF rectF11 = new RectF(f4 - ((float) this.f43724d), (float) this.f43725e, f4, f5);
                int i38 = this.f43723c;
                canvas.drawRoundRect(rectF11, (float) i38, (float) i38, paint);
                int i39 = this.f43725e;
                int i40 = this.f43723c;
                canvas.drawRect(new RectF((float) i39, (float) i39, f4 - ((float) i40), f5 - ((float) i40)), paint);
                break;
            case OTHER_TOP_RIGHT:
                int i41 = this.f43725e;
                RectF rectF12 = new RectF((float) i41, (float) i41, (float) (i41 + this.f43724d), f5);
                int i42 = this.f43723c;
                canvas.drawRoundRect(rectF12, (float) i42, (float) i42, paint);
                RectF rectF13 = new RectF((float) this.f43725e, f5 - ((float) this.f43724d), f4, f5);
                int i43 = this.f43723c;
                canvas.drawRoundRect(rectF13, (float) i43, (float) i43, paint);
                int i44 = this.f43725e;
                int i45 = this.f43723c;
                canvas.drawRect(new RectF((float) (i44 + i45), (float) i44, f4, f5 - ((float) i45)), paint);
                break;
            case OTHER_BOTTOM_LEFT:
                int i46 = this.f43725e;
                RectF rectF14 = new RectF((float) i46, (float) i46, f4, (float) (i46 + this.f43724d));
                int i47 = this.f43723c;
                canvas.drawRoundRect(rectF14, (float) i47, (float) i47, paint);
                RectF rectF15 = new RectF(f4 - ((float) this.f43724d), (float) this.f43725e, f4, f5);
                int i48 = this.f43723c;
                canvas.drawRoundRect(rectF15, (float) i48, (float) i48, paint);
                int i49 = this.f43725e;
                int i50 = this.f43723c;
                canvas.drawRect(new RectF((float) i49, (float) (i49 + i50), f4 - ((float) i50), f5), paint);
                break;
            case OTHER_BOTTOM_RIGHT:
                int i51 = this.f43725e;
                RectF rectF16 = new RectF((float) i51, (float) i51, f4, (float) (i51 + this.f43724d));
                int i52 = this.f43723c;
                canvas.drawRoundRect(rectF16, (float) i52, (float) i52, paint);
                int i53 = this.f43725e;
                RectF rectF17 = new RectF((float) i53, (float) i53, (float) (i53 + this.f43724d), f5);
                int i54 = this.f43723c;
                canvas.drawRoundRect(rectF17, (float) i54, (float) i54, paint);
                int i55 = this.f43725e;
                int i56 = this.f43723c;
                canvas.drawRect(new RectF((float) (i55 + i56), (float) (i55 + i56), f4, f5), paint);
                break;
            case DIAGONAL_FROM_TOP_LEFT:
                int i57 = this.f43725e;
                int i58 = this.f43724d;
                RectF rectF18 = new RectF((float) i57, (float) i57, (float) (i57 + i58), (float) (i57 + i58));
                int i59 = this.f43723c;
                canvas.drawRoundRect(rectF18, (float) i59, (float) i59, paint);
                int i60 = this.f43724d;
                RectF rectF19 = new RectF(f4 - ((float) i60), f5 - ((float) i60), f4, f5);
                int i61 = this.f43723c;
                canvas.drawRoundRect(rectF19, (float) i61, (float) i61, paint);
                int i62 = this.f43725e;
                canvas.drawRect(new RectF((float) i62, (float) (i62 + this.f43723c), f4 - ((float) this.f43724d), f5), paint);
                int i63 = this.f43725e;
                canvas.drawRect(new RectF((float) (this.f43724d + i63), (float) i63, f4, f5 - ((float) this.f43723c)), paint);
                break;
            case DIAGONAL_FROM_TOP_RIGHT:
                int i64 = this.f43724d;
                int i65 = this.f43725e;
                RectF rectF20 = new RectF(f4 - ((float) i64), (float) i65, f4, (float) (i65 + i64));
                int i66 = this.f43723c;
                canvas.drawRoundRect(rectF20, (float) i66, (float) i66, paint);
                int i67 = this.f43725e;
                int i68 = this.f43724d;
                RectF rectF21 = new RectF((float) i67, f5 - ((float) i68), (float) (i67 + i68), f5);
                int i69 = this.f43723c;
                canvas.drawRoundRect(rectF21, (float) i69, (float) i69, paint);
                int i70 = this.f43725e;
                int i71 = this.f43723c;
                canvas.drawRect(new RectF((float) i70, (float) i70, f4 - ((float) i71), f5 - ((float) i71)), paint);
                int i72 = this.f43725e;
                int i73 = this.f43723c;
                canvas.drawRect(new RectF((float) (i72 + i73), (float) (i72 + i73), f4, f5), paint);
                break;
            default:
                int i74 = this.f43725e;
                RectF rectF22 = new RectF((float) i74, (float) i74, f4, f5);
                int i75 = this.f43723c;
                canvas.drawRoundRect(rectF22, (float) i75, (float) i75, paint);
                break;
        }
        return com.bumptech.glide.load.d.a.e.a(a2, this.f43722b);
    }
}
