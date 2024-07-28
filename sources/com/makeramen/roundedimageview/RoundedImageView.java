package com.makeramen.roundedimageview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;

public class RoundedImageView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    public static final Shader.TileMode f33731a = Shader.TileMode.CLAMP;

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ boolean f33732b = (!RoundedImageView.class.desiredAssertionStatus());

    /* renamed from: c  reason: collision with root package name */
    private static final ImageView.ScaleType[] f33733c = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* renamed from: d  reason: collision with root package name */
    private final float[] f33734d;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f33735e;

    /* renamed from: f  reason: collision with root package name */
    private ColorStateList f33736f;

    /* renamed from: g  reason: collision with root package name */
    private float f33737g;

    /* renamed from: h  reason: collision with root package name */
    private ColorFilter f33738h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f33739i;
    private Drawable j;
    private boolean k;
    private boolean l;
    private boolean m;
    private int n;
    private int o;
    private ImageView.ScaleType p;
    private Shader.TileMode q;
    private Shader.TileMode r;

    public RoundedImageView(Context context) {
        super(context);
        this.f33734d = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.f33736f = ColorStateList.valueOf(-16777216);
        this.f33737g = 0.0f;
        this.f33738h = null;
        this.f33739i = false;
        this.k = false;
        this.l = false;
        this.m = false;
        Shader.TileMode tileMode = f33731a;
        this.q = tileMode;
        this.r = tileMode;
    }

    public RoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundedImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f33734d = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.f33736f = ColorStateList.valueOf(-16777216);
        this.f33737g = 0.0f;
        this.f33738h = null;
        this.f33739i = false;
        this.k = false;
        this.l = false;
        this.m = false;
        Shader.TileMode tileMode = f33731a;
        this.q = tileMode;
        this.r = tileMode;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundedImageView, i2, 0);
        int i3 = obtainStyledAttributes.getInt(R.styleable.RoundedImageView_android_scaleType, -1);
        if (i3 >= 0) {
            setScaleType(f33733c[i3]);
        } else {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        float dimensionPixelSize = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundedImageView_riv_corner_radius, -1);
        this.f33734d[0] = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundedImageView_riv_corner_radius_top_left, -1);
        this.f33734d[1] = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundedImageView_riv_corner_radius_top_right, -1);
        this.f33734d[2] = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundedImageView_riv_corner_radius_bottom_right, -1);
        this.f33734d[3] = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundedImageView_riv_corner_radius_bottom_left, -1);
        int length = this.f33734d.length;
        boolean z = false;
        for (int i4 = 0; i4 < length; i4++) {
            float[] fArr = this.f33734d;
            if (fArr[i4] < 0.0f) {
                fArr[i4] = 0.0f;
            } else {
                z = true;
            }
        }
        if (!z) {
            dimensionPixelSize = dimensionPixelSize < 0.0f ? 0.0f : dimensionPixelSize;
            int length2 = this.f33734d.length;
            for (int i5 = 0; i5 < length2; i5++) {
                this.f33734d[i5] = dimensionPixelSize;
            }
        }
        this.f33737g = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundedImageView_riv_border_width, -1);
        if (this.f33737g < 0.0f) {
            this.f33737g = 0.0f;
        }
        this.f33736f = obtainStyledAttributes.getColorStateList(R.styleable.RoundedImageView_riv_border_color);
        if (this.f33736f == null) {
            this.f33736f = ColorStateList.valueOf(-16777216);
        }
        this.m = obtainStyledAttributes.getBoolean(R.styleable.RoundedImageView_riv_mutate_background, false);
        this.l = obtainStyledAttributes.getBoolean(R.styleable.RoundedImageView_riv_oval, false);
        int i6 = obtainStyledAttributes.getInt(R.styleable.RoundedImageView_riv_tile_mode, -2);
        if (i6 != -2) {
            setTileModeX(a(i6));
            setTileModeY(a(i6));
        }
        int i7 = obtainStyledAttributes.getInt(R.styleable.RoundedImageView_riv_tile_mode_x, -2);
        if (i7 != -2) {
            setTileModeX(a(i7));
        }
        int i8 = obtainStyledAttributes.getInt(R.styleable.RoundedImageView_riv_tile_mode_y, -2);
        if (i8 != -2) {
            setTileModeY(a(i8));
        }
        c();
        a(true);
        if (this.m) {
            super.setBackgroundDrawable(this.f33735e);
        }
        obtainStyledAttributes.recycle();
    }

    private static Shader.TileMode a(int i2) {
        if (i2 == 0) {
            return Shader.TileMode.CLAMP;
        }
        if (i2 == 1) {
            return Shader.TileMode.REPEAT;
        }
        if (i2 != 2) {
            return null;
        }
        return Shader.TileMode.MIRROR;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    public ImageView.ScaleType getScaleType() {
        return this.p;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (!f33732b && scaleType == null) {
            throw new AssertionError();
        } else if (this.p != scaleType) {
            this.p = scaleType;
            switch (AnonymousClass1.f33740a[scaleType.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    super.setScaleType(ImageView.ScaleType.FIT_XY);
                    break;
                default:
                    super.setScaleType(scaleType);
                    break;
            }
            c();
            a(false);
            invalidate();
        }
    }

    /* renamed from: com.makeramen.roundedimageview.RoundedImageView$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f33740a = new int[ImageView.ScaleType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                android.widget.ImageView$ScaleType[] r0 = android.widget.ImageView.ScaleType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f33740a = r0
                int[] r0 = f33740a     // Catch:{ NoSuchFieldError -> 0x0014 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f33740a     // Catch:{ NoSuchFieldError -> 0x001f }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f33740a     // Catch:{ NoSuchFieldError -> 0x002a }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER_INSIDE     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f33740a     // Catch:{ NoSuchFieldError -> 0x0035 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = f33740a     // Catch:{ NoSuchFieldError -> 0x0040 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_START     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                int[] r0 = f33740a     // Catch:{ NoSuchFieldError -> 0x004b }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_END     // Catch:{ NoSuchFieldError -> 0x004b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004b }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004b }
            L_0x004b:
                int[] r0 = f33740a     // Catch:{ NoSuchFieldError -> 0x0056 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ NoSuchFieldError -> 0x0056 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0056 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0056 }
            L_0x0056:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.makeramen.roundedimageview.RoundedImageView.AnonymousClass1.<clinit>():void");
        }
    }

    public void setImageDrawable(Drawable drawable) {
        this.n = 0;
        this.j = a.a(drawable);
        c();
        super.setImageDrawable(this.j);
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.n = 0;
        this.j = a.a(bitmap);
        c();
        super.setImageDrawable(this.j);
    }

    public void setImageResource(int i2) {
        if (this.n != i2) {
            this.n = i2;
            this.j = a();
            c();
            super.setImageDrawable(this.j);
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        setImageDrawable(getDrawable());
    }

    private Drawable a() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i2 = this.n;
        if (i2 != 0) {
            try {
                drawable = resources.getDrawable(i2);
            } catch (Exception unused) {
                new StringBuilder("Unable to find resource: ").append(this.n);
                this.n = 0;
            }
        }
        return a.a(drawable);
    }

    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundResource(int i2) {
        if (this.o != i2) {
            this.o = i2;
            this.f33735e = b();
            setBackgroundDrawable(this.f33735e);
        }
    }

    public void setBackgroundColor(int i2) {
        this.f33735e = new ColorDrawable(i2);
        setBackgroundDrawable(this.f33735e);
    }

    private Drawable b() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i2 = this.o;
        if (i2 != 0) {
            try {
                drawable = resources.getDrawable(i2);
            } catch (Exception unused) {
                new StringBuilder("Unable to find resource: ").append(this.o);
                this.o = 0;
            }
        }
        return a.a(drawable);
    }

    private void c() {
        a(this.j, this.p);
    }

    private void a(boolean z) {
        if (this.m) {
            if (z) {
                this.f33735e = a.a(this.f33735e);
            }
            a(this.f33735e, ImageView.ScaleType.FIT_XY);
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f33738h != colorFilter) {
            this.f33738h = colorFilter;
            this.k = true;
            this.f33739i = true;
            d();
            invalidate();
        }
    }

    private void d() {
        Drawable drawable = this.j;
        if (drawable != null && this.f33739i) {
            this.j = drawable.mutate();
            if (this.k) {
                this.j.setColorFilter(this.f33738h);
            }
        }
    }

    private void a(Drawable drawable, ImageView.ScaleType scaleType) {
        if (drawable != null) {
            if (drawable instanceof a) {
                a aVar = (a) drawable;
                a a2 = aVar.a(scaleType).a(this.f33737g).a(this.f33736f);
                a2.f33741a = this.l;
                a2.a(this.q).b(this.r);
                float[] fArr = this.f33734d;
                if (fArr != null) {
                    aVar.a(fArr[0], fArr[1], fArr[2], fArr[3]);
                }
                d();
            } else if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                for (int i2 = 0; i2 < numberOfLayers; i2++) {
                    a(layerDrawable.getDrawable(i2), scaleType);
                }
            }
        }
    }

    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        this.f33735e = drawable;
        a(true);
        super.setBackgroundDrawable(this.f33735e);
    }

    public float getCornerRadius() {
        return getMaxCornerRadius();
    }

    public float getMaxCornerRadius() {
        float f2 = 0.0f;
        for (float max : this.f33734d) {
            f2 = Math.max(max, f2);
        }
        return f2;
    }

    public void setCornerRadiusDimen(int i2) {
        float dimension = getResources().getDimension(i2);
        setCornerRadius(dimension, dimension, dimension, dimension);
    }

    public void setCornerRadiusDimen(int i2, int i3) {
        setCornerRadius(i2, (float) getResources().getDimensionPixelSize(i3));
    }

    public void setCornerRadius(float f2) {
        setCornerRadius(f2, f2, f2, f2);
    }

    public void setCornerRadius(int i2, float f2) {
        float[] fArr = this.f33734d;
        if (fArr[i2] != f2) {
            fArr[i2] = f2;
            c();
            a(false);
            invalidate();
        }
    }

    public void setCornerRadius(float f2, float f3, float f4, float f5) {
        float[] fArr = this.f33734d;
        if (fArr[0] != f2 || fArr[1] != f3 || fArr[2] != f5 || fArr[3] != f4) {
            float[] fArr2 = this.f33734d;
            fArr2[0] = f2;
            fArr2[1] = f3;
            fArr2[3] = f4;
            fArr2[2] = f5;
            c();
            a(false);
            invalidate();
        }
    }

    public float getBorderWidth() {
        return this.f33737g;
    }

    public void setBorderWidth(int i2) {
        setBorderWidth(getResources().getDimension(i2));
    }

    public void setBorderWidth(float f2) {
        if (this.f33737g != f2) {
            this.f33737g = f2;
            c();
            a(false);
            invalidate();
        }
    }

    public int getBorderColor() {
        return this.f33736f.getDefaultColor();
    }

    public void setBorderColor(int i2) {
        setBorderColor(ColorStateList.valueOf(i2));
    }

    public ColorStateList getBorderColors() {
        return this.f33736f;
    }

    public void setBorderColor(ColorStateList colorStateList) {
        if (!this.f33736f.equals(colorStateList)) {
            if (colorStateList == null) {
                colorStateList = ColorStateList.valueOf(-16777216);
            }
            this.f33736f = colorStateList;
            c();
            a(false);
            if (this.f33737g > 0.0f) {
                invalidate();
            }
        }
    }

    public void setOval(boolean z) {
        this.l = z;
        c();
        a(false);
        invalidate();
    }

    public Shader.TileMode getTileModeX() {
        return this.q;
    }

    public void setTileModeX(Shader.TileMode tileMode) {
        if (this.q != tileMode) {
            this.q = tileMode;
            c();
            a(false);
            invalidate();
        }
    }

    public Shader.TileMode getTileModeY() {
        return this.r;
    }

    public void setTileModeY(Shader.TileMode tileMode) {
        if (this.r != tileMode) {
            this.r = tileMode;
            c();
            a(false);
            invalidate();
        }
    }
}
