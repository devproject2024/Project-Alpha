package net.one97.paytm.o2o.movies.common.widgets;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import com.squareup.picasso.ah;

public final class a implements ah {

    /* renamed from: a  reason: collision with root package name */
    private int f75226a;

    /* renamed from: b  reason: collision with root package name */
    private int f75227b;

    /* renamed from: c  reason: collision with root package name */
    private int f75228c;

    /* renamed from: d  reason: collision with root package name */
    private C1486a f75229d;

    /* renamed from: net.one97.paytm.o2o.movies.common.widgets.a$a  reason: collision with other inner class name */
    public enum C1486a {
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

    public a() {
        this(C1486a.ALL);
    }

    private a(C1486a aVar) {
        this.f75226a = 20;
        this.f75227b = 40;
        this.f75228c = 0;
        this.f75229d = aVar;
    }

    public final Bitmap transform(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        int i2 = this.f75228c;
        float f2 = ((float) width) - ((float) i2);
        float f3 = ((float) height) - ((float) i2);
        switch (this.f75229d) {
            case ALL:
                int i3 = this.f75228c;
                RectF rectF = new RectF((float) i3, (float) i3, f2, f3);
                int i4 = this.f75226a;
                canvas.drawRoundRect(rectF, (float) i4, (float) i4, paint);
                break;
            case TOP_LEFT:
                int i5 = this.f75228c;
                int i6 = this.f75227b;
                RectF rectF2 = new RectF((float) i5, (float) i5, (float) (i5 + i6), (float) (i5 + i6));
                int i7 = this.f75226a;
                canvas.drawRoundRect(rectF2, (float) i7, (float) i7, paint);
                int i8 = this.f75228c;
                int i9 = this.f75226a;
                canvas.drawRect(new RectF((float) i8, (float) (i8 + i9), (float) (i8 + i9), f3), paint);
                int i10 = this.f75228c;
                canvas.drawRect(new RectF((float) (this.f75226a + i10), (float) i10, f2, f3), paint);
                break;
            case TOP_RIGHT:
                int i11 = this.f75227b;
                int i12 = this.f75228c;
                RectF rectF3 = new RectF(f2 - ((float) i11), (float) i12, f2, (float) (i12 + i11));
                int i13 = this.f75226a;
                canvas.drawRoundRect(rectF3, (float) i13, (float) i13, paint);
                int i14 = this.f75228c;
                canvas.drawRect(new RectF((float) i14, (float) i14, f2 - ((float) this.f75226a), f3), paint);
                int i15 = this.f75226a;
                canvas.drawRect(new RectF(f2 - ((float) i15), (float) (this.f75228c + i15), f2, f3), paint);
                break;
            case BOTTOM_LEFT:
                int i16 = this.f75228c;
                int i17 = this.f75227b;
                RectF rectF4 = new RectF((float) i16, f3 - ((float) i17), (float) (i16 + i17), f3);
                int i18 = this.f75226a;
                canvas.drawRoundRect(rectF4, (float) i18, (float) i18, paint);
                int i19 = this.f75228c;
                canvas.drawRect(new RectF((float) i19, (float) i19, (float) (i19 + this.f75227b), f3 - ((float) this.f75226a)), paint);
                int i20 = this.f75228c;
                canvas.drawRect(new RectF((float) (this.f75226a + i20), (float) i20, f2, f3), paint);
                break;
            case BOTTOM_RIGHT:
                int i21 = this.f75227b;
                RectF rectF5 = new RectF(f2 - ((float) i21), f3 - ((float) i21), f2, f3);
                int i22 = this.f75226a;
                canvas.drawRoundRect(rectF5, (float) i22, (float) i22, paint);
                int i23 = this.f75228c;
                canvas.drawRect(new RectF((float) i23, (float) i23, f2 - ((float) this.f75226a), f3), paint);
                int i24 = this.f75226a;
                canvas.drawRect(new RectF(f2 - ((float) i24), (float) this.f75228c, f2, f3 - ((float) i24)), paint);
                break;
            case TOP:
                int i25 = this.f75228c;
                RectF rectF6 = new RectF((float) i25, (float) i25, f2, (float) (i25 + this.f75227b));
                int i26 = this.f75226a;
                canvas.drawRoundRect(rectF6, (float) i26, (float) i26, paint);
                int i27 = this.f75228c;
                canvas.drawRect(new RectF((float) i27, (float) (i27 + this.f75226a), f2, f3), paint);
                break;
            case BOTTOM:
                RectF rectF7 = new RectF((float) this.f75228c, f3 - ((float) this.f75227b), f2, f3);
                int i28 = this.f75226a;
                canvas.drawRoundRect(rectF7, (float) i28, (float) i28, paint);
                int i29 = this.f75228c;
                canvas.drawRect(new RectF((float) i29, (float) i29, f2, f3 - ((float) this.f75226a)), paint);
                break;
            case LEFT:
                int i30 = this.f75228c;
                RectF rectF8 = new RectF((float) i30, (float) i30, (float) (i30 + this.f75227b), f3);
                int i31 = this.f75226a;
                canvas.drawRoundRect(rectF8, (float) i31, (float) i31, paint);
                int i32 = this.f75228c;
                canvas.drawRect(new RectF((float) (this.f75226a + i32), (float) i32, f2, f3), paint);
                break;
            case RIGHT:
                RectF rectF9 = new RectF(f2 - ((float) this.f75227b), (float) this.f75228c, f2, f3);
                int i33 = this.f75226a;
                canvas.drawRoundRect(rectF9, (float) i33, (float) i33, paint);
                int i34 = this.f75228c;
                canvas.drawRect(new RectF((float) i34, (float) i34, f2 - ((float) this.f75226a), f3), paint);
                break;
            case OTHER_TOP_LEFT:
                RectF rectF10 = new RectF((float) this.f75228c, f3 - ((float) this.f75227b), f2, f3);
                int i35 = this.f75226a;
                canvas.drawRoundRect(rectF10, (float) i35, (float) i35, paint);
                RectF rectF11 = new RectF(f2 - ((float) this.f75227b), (float) this.f75228c, f2, f3);
                int i36 = this.f75226a;
                canvas.drawRoundRect(rectF11, (float) i36, (float) i36, paint);
                int i37 = this.f75228c;
                int i38 = this.f75226a;
                canvas.drawRect(new RectF((float) i37, (float) i37, f2 - ((float) i38), f3 - ((float) i38)), paint);
                break;
            case OTHER_TOP_RIGHT:
                int i39 = this.f75228c;
                RectF rectF12 = new RectF((float) i39, (float) i39, (float) (i39 + this.f75227b), f3);
                int i40 = this.f75226a;
                canvas.drawRoundRect(rectF12, (float) i40, (float) i40, paint);
                RectF rectF13 = new RectF((float) this.f75228c, f3 - ((float) this.f75227b), f2, f3);
                int i41 = this.f75226a;
                canvas.drawRoundRect(rectF13, (float) i41, (float) i41, paint);
                int i42 = this.f75228c;
                int i43 = this.f75226a;
                canvas.drawRect(new RectF((float) (i42 + i43), (float) i42, f2, f3 - ((float) i43)), paint);
                break;
            case OTHER_BOTTOM_LEFT:
                int i44 = this.f75228c;
                RectF rectF14 = new RectF((float) i44, (float) i44, f2, (float) (i44 + this.f75227b));
                int i45 = this.f75226a;
                canvas.drawRoundRect(rectF14, (float) i45, (float) i45, paint);
                RectF rectF15 = new RectF(f2 - ((float) this.f75227b), (float) this.f75228c, f2, f3);
                int i46 = this.f75226a;
                canvas.drawRoundRect(rectF15, (float) i46, (float) i46, paint);
                int i47 = this.f75228c;
                int i48 = this.f75226a;
                canvas.drawRect(new RectF((float) i47, (float) (i47 + i48), f2 - ((float) i48), f3), paint);
                break;
            case OTHER_BOTTOM_RIGHT:
                int i49 = this.f75228c;
                RectF rectF16 = new RectF((float) i49, (float) i49, f2, (float) (i49 + this.f75227b));
                int i50 = this.f75226a;
                canvas.drawRoundRect(rectF16, (float) i50, (float) i50, paint);
                int i51 = this.f75228c;
                RectF rectF17 = new RectF((float) i51, (float) i51, (float) (i51 + this.f75227b), f3);
                int i52 = this.f75226a;
                canvas.drawRoundRect(rectF17, (float) i52, (float) i52, paint);
                int i53 = this.f75228c;
                int i54 = this.f75226a;
                canvas.drawRect(new RectF((float) (i53 + i54), (float) (i53 + i54), f2, f3), paint);
                break;
            case DIAGONAL_FROM_TOP_LEFT:
                int i55 = this.f75228c;
                int i56 = this.f75227b;
                RectF rectF18 = new RectF((float) i55, (float) i55, (float) (i55 + i56), (float) (i55 + i56));
                int i57 = this.f75226a;
                canvas.drawRoundRect(rectF18, (float) i57, (float) i57, paint);
                int i58 = this.f75227b;
                RectF rectF19 = new RectF(f2 - ((float) i58), f3 - ((float) i58), f2, f3);
                int i59 = this.f75226a;
                canvas.drawRoundRect(rectF19, (float) i59, (float) i59, paint);
                int i60 = this.f75228c;
                canvas.drawRect(new RectF((float) i60, (float) (i60 + this.f75226a), f2 - ((float) this.f75227b), f3), paint);
                int i61 = this.f75228c;
                canvas.drawRect(new RectF((float) (this.f75227b + i61), (float) i61, f2, f3 - ((float) this.f75226a)), paint);
                break;
            case DIAGONAL_FROM_TOP_RIGHT:
                int i62 = this.f75227b;
                int i63 = this.f75228c;
                RectF rectF20 = new RectF(f2 - ((float) i62), (float) i63, f2, (float) (i63 + i62));
                int i64 = this.f75226a;
                canvas.drawRoundRect(rectF20, (float) i64, (float) i64, paint);
                int i65 = this.f75228c;
                int i66 = this.f75227b;
                RectF rectF21 = new RectF((float) i65, f3 - ((float) i66), (float) (i65 + i66), f3);
                int i67 = this.f75226a;
                canvas.drawRoundRect(rectF21, (float) i67, (float) i67, paint);
                int i68 = this.f75228c;
                int i69 = this.f75226a;
                canvas.drawRect(new RectF((float) i68, (float) i68, f2 - ((float) i69), f3 - ((float) i69)), paint);
                int i70 = this.f75228c;
                int i71 = this.f75226a;
                canvas.drawRect(new RectF((float) (i70 + i71), (float) (i70 + i71), f2, f3), paint);
                break;
            default:
                int i72 = this.f75228c;
                RectF rectF22 = new RectF((float) i72, (float) i72, f2, f3);
                int i73 = this.f75226a;
                canvas.drawRoundRect(rectF22, (float) i73, (float) i73, paint);
                break;
        }
        bitmap.recycle();
        return createBitmap;
    }

    public final String key() {
        return "RoundedTransformation(radius=" + this.f75226a + ", margin=" + this.f75228c + ", diameter=" + this.f75227b + ", cornerType=" + this.f75229d.name() + ")";
    }
}
