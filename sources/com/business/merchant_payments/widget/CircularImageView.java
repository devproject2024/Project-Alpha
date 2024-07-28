package com.business.merchant_payments.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.business.merchant_payments.R;
import java.util.HashMap;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.h.a;
import kotlin.j.e;

public final class CircularImageView extends AppCompatImageView {
    public static final Companion Companion = new Companion((g) null);
    public static final float DEFAULT_BORDER_WIDTH = 0.0f;
    public static final float DEFAULT_SHADOW_RADIUS = 8.0f;
    public HashMap _$_findViewCache;
    public int borderColor;
    public GradientDirection borderColorDirection;
    public Integer borderColorEnd;
    public Integer borderColorStart;
    public float borderWidth;
    public int circleCenter;
    public int circleColor;
    public GradientDirection circleColorDirection;
    public Integer circleColorEnd;
    public Integer circleColorStart;
    public ColorFilter civColorFilter;
    public Drawable civDrawable;
    public Bitmap civImage;
    public int heightCircle;
    public final Paint paint;
    public final Paint paintBackground;
    public final Paint paintBorder;
    public final Paint paintShadow;
    public int shadowColor;
    public boolean shadowEnable;
    public ShadowGravity shadowGravity;
    public float shadowRadius;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[GradientDirection.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[GradientDirection.LEFT_TO_RIGHT.ordinal()] = 1;
            $EnumSwitchMapping$0[GradientDirection.RIGHT_TO_LEFT.ordinal()] = 2;
            $EnumSwitchMapping$0[GradientDirection.TOP_TO_BOTTOM.ordinal()] = 3;
            $EnumSwitchMapping$0[GradientDirection.BOTTOM_TO_TOP.ordinal()] = 4;
            int[] iArr2 = new int[ShadowGravity.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[ShadowGravity.CENTER.ordinal()] = 1;
            $EnumSwitchMapping$1[ShadowGravity.TOP.ordinal()] = 2;
            $EnumSwitchMapping$1[ShadowGravity.BOTTOM.ordinal()] = 3;
            $EnumSwitchMapping$1[ShadowGravity.START.ordinal()] = 4;
            $EnumSwitchMapping$1[ShadowGravity.END.ordinal()] = 5;
            int[] iArr3 = new int[ImageView.ScaleType.values().length];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            $EnumSwitchMapping$2[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            $EnumSwitchMapping$2[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
        }
    }

    public CircularImageView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
    }

    public CircularImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (g) null);
    }

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CircularImageView(Context context, AttributeSet attributeSet, int i2, int i3, g gVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CircularImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        k.d(context, "context");
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        this.paint = paint2;
        Paint paint3 = new Paint();
        paint3.setAntiAlias(true);
        this.paintBorder = paint3;
        Paint paint4 = new Paint();
        paint4.setAntiAlias(true);
        this.paintShadow = paint4;
        Paint paint5 = new Paint();
        paint5.setAntiAlias(true);
        this.paintBackground = paint5;
        this.circleColor = -1;
        GradientDirection gradientDirection = GradientDirection.LEFT_TO_RIGHT;
        this.circleColorDirection = gradientDirection;
        this.borderColor = -16777216;
        this.borderColorDirection = gradientDirection;
        this.shadowColor = -16777216;
        this.shadowGravity = ShadowGravity.BOTTOM;
        init(context, attributeSet, i2);
    }

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public final int getCircleColor() {
        return this.circleColor;
    }

    public final void setCircleColor(int i2) {
        this.circleColor = i2;
        manageCircleColor();
        invalidate();
    }

    public final Integer getCircleColorStart() {
        return this.circleColorStart;
    }

    public final void setCircleColorStart(Integer num) {
        this.circleColorStart = num;
        manageCircleColor();
        invalidate();
    }

    public final Integer getCircleColorEnd() {
        return this.circleColorEnd;
    }

    public final void setCircleColorEnd(Integer num) {
        this.circleColorEnd = num;
        manageCircleColor();
        invalidate();
    }

    public final GradientDirection getCircleColorDirection() {
        return this.circleColorDirection;
    }

    public final void setCircleColorDirection(GradientDirection gradientDirection) {
        k.d(gradientDirection, "value");
        this.circleColorDirection = gradientDirection;
        manageCircleColor();
        invalidate();
    }

    public final float getBorderWidth() {
        return this.borderWidth;
    }

    public final void setBorderWidth(float f2) {
        this.borderWidth = f2;
        update();
    }

    public final int getBorderColor() {
        return this.borderColor;
    }

    public final void setBorderColor(int i2) {
        this.borderColor = i2;
        manageBorderColor();
        invalidate();
    }

    public final Integer getBorderColorStart() {
        return this.borderColorStart;
    }

    public final void setBorderColorStart(Integer num) {
        this.borderColorStart = num;
        manageBorderColor();
        invalidate();
    }

    public final Integer getBorderColorEnd() {
        return this.borderColorEnd;
    }

    public final void setBorderColorEnd(Integer num) {
        this.borderColorEnd = num;
        manageBorderColor();
        invalidate();
    }

    public final GradientDirection getBorderColorDirection() {
        return this.borderColorDirection;
    }

    public final void setBorderColorDirection(GradientDirection gradientDirection) {
        k.d(gradientDirection, "value");
        this.borderColorDirection = gradientDirection;
        manageBorderColor();
        invalidate();
    }

    public final float getShadowRadius() {
        return this.shadowRadius;
    }

    public final void setShadowRadius(float f2) {
        this.shadowRadius = f2;
        setShadowEnable(f2 > 0.0f);
    }

    public final int getShadowColor() {
        return this.shadowColor;
    }

    public final void setShadowColor(int i2) {
        this.shadowColor = i2;
        this.paintShadow.setColor(i2);
        invalidate();
    }

    public final ShadowGravity getShadowGravity() {
        return this.shadowGravity;
    }

    public final void setShadowGravity(ShadowGravity shadowGravity2) {
        k.d(shadowGravity2, "value");
        this.shadowGravity = shadowGravity2;
        invalidate();
    }

    public final boolean getShadowEnable() {
        return this.shadowEnable;
    }

    public final void setShadowEnable(boolean z) {
        this.shadowEnable = z;
        if (z && this.shadowRadius == 0.0f) {
            Resources resources = getResources();
            k.b(resources, "resources");
            setShadowRadius(resources.getDisplayMetrics().density * 8.0f);
        }
        update();
    }

    private final void setCivColorFilter(ColorFilter colorFilter) {
        if (!k.a((Object) this.civColorFilter, (Object) colorFilter)) {
            this.civColorFilter = colorFilter;
            if (colorFilter != null) {
                this.civDrawable = null;
                invalidate();
            }
        }
    }

    private final void init(Context context, AttributeSet attributeSet, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CircularImageView, i2, 0);
        setCircleColor(obtainStyledAttributes.getColor(R.styleable.CircularImageView_civ_circle_color, -1));
        int color = obtainStyledAttributes.getColor(R.styleable.CircularImageView_civ_circle_color_start, 0);
        if (color != 0) {
            setCircleColorStart(Integer.valueOf(color));
        }
        int color2 = obtainStyledAttributes.getColor(R.styleable.CircularImageView_civ_circle_color_end, 0);
        if (color2 != 0) {
            setCircleColorEnd(Integer.valueOf(color2));
        }
        setCircleColorDirection(toGradientDirection(obtainStyledAttributes.getInteger(R.styleable.CircularImageView_civ_circle_color_direction, this.circleColorDirection.getValue())));
        if (obtainStyledAttributes.getBoolean(R.styleable.CircularImageView_civ_border, true)) {
            Resources resources = getResources();
            k.b(resources, "resources");
            setBorderWidth(obtainStyledAttributes.getDimension(R.styleable.CircularImageView_civ_border_width, resources.getDisplayMetrics().density * 0.0f));
            setBorderColor(obtainStyledAttributes.getColor(R.styleable.CircularImageView_civ_border_color, -1));
            int color3 = obtainStyledAttributes.getColor(R.styleable.CircularImageView_civ_border_color_start, 0);
            if (color3 != 0) {
                setBorderColorStart(Integer.valueOf(color3));
            }
            int color4 = obtainStyledAttributes.getColor(R.styleable.CircularImageView_civ_border_color_end, 0);
            if (color4 != 0) {
                setBorderColorEnd(Integer.valueOf(color4));
            }
            setBorderColorDirection(toGradientDirection(obtainStyledAttributes.getInteger(R.styleable.CircularImageView_civ_border_color_direction, this.borderColorDirection.getValue())));
        }
        setShadowEnable(obtainStyledAttributes.getBoolean(R.styleable.CircularImageView_civ_shadow, this.shadowEnable));
        if (this.shadowEnable) {
            setShadowGravity(toShadowGravity(obtainStyledAttributes.getInteger(R.styleable.CircularImageView_civ_shadow_gravity, this.shadowGravity.getValue())));
            Resources resources2 = getResources();
            k.b(resources2, "resources");
            setShadowRadius(obtainStyledAttributes.getDimension(R.styleable.CircularImageView_civ_shadow_radius, resources2.getDisplayMetrics().density * 8.0f));
            setShadowColor(obtainStyledAttributes.getColor(R.styleable.CircularImageView_civ_shadow_color, this.shadowColor));
        }
        obtainStyledAttributes.recycle();
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        setCivColorFilter(colorFilter);
    }

    public final ImageView.ScaleType getScaleType() {
        ImageView.ScaleType scaleType = super.getScaleType();
        return scaleType == null ? ImageView.ScaleType.CENTER_CROP : scaleType;
    }

    public final void setScaleType(ImageView.ScaleType scaleType) {
        k.d(scaleType, "scaleType");
        if (kotlin.a.k.b((T[]) new ImageView.ScaleType[]{ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE, ImageView.ScaleType.FIT_CENTER}).contains(scaleType)) {
            super.setScaleType(scaleType);
            return;
        }
        throw new IllegalArgumentException(("ScaleType " + scaleType + " not supported. Just ScaleType.CENTER_CROP, ScaleType.CENTER_INSIDE & ScaleType.FIT_CENTER are available for this library.").toString());
    }

    public final void onDraw(Canvas canvas) {
        k.d(canvas, "canvas");
        loadBitmap();
        if (this.civImage != null) {
            float f2 = ((float) this.circleCenter) + this.borderWidth;
            float f3 = this.shadowEnable ? this.shadowRadius * 2.0f : 0.0f;
            if (this.shadowEnable) {
                drawShadow();
                canvas.drawCircle(f2, f2, f2 - f3, this.paintShadow);
            }
            canvas.drawCircle(f2, f2, f2 - f3, this.paintBorder);
            canvas.drawCircle(f2, f2, ((float) this.circleCenter) - f3, this.paintBackground);
            canvas.drawCircle(f2, f2, ((float) this.circleCenter) - f3, this.paint);
        }
    }

    private final void update() {
        if (this.civImage != null) {
            updateShader();
        }
        int min = Math.min(getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
        this.heightCircle = min;
        this.circleCenter = ((int) (((float) min) - (this.borderWidth * 2.0f))) / 2;
        manageCircleColor();
        manageBorderColor();
        manageElevation();
        invalidate();
    }

    private final void manageCircleColor() {
        Paint paint2 = this.paintBackground;
        Integer num = this.circleColorStart;
        int intValue = num != null ? num.intValue() : this.circleColor;
        Integer num2 = this.circleColorEnd;
        paint2.setShader(createLinearGradient(intValue, num2 != null ? num2.intValue() : this.circleColor, this.circleColorDirection));
    }

    private final void manageBorderColor() {
        int i2 = this.borderWidth == 0.0f ? this.circleColor : this.borderColor;
        Paint paint2 = this.paintBorder;
        Integer num = this.borderColorStart;
        int intValue = num != null ? num.intValue() : i2;
        Integer num2 = this.borderColorEnd;
        if (num2 != null) {
            i2 = num2.intValue();
        }
        paint2.setShader(createLinearGradient(intValue, i2, this.borderColorDirection));
    }

    private final LinearGradient createLinearGradient(int i2, int i3, GradientDirection gradientDirection) {
        float f2;
        float f3;
        float f4;
        float f5;
        int i4 = WhenMappings.$EnumSwitchMapping$0[gradientDirection.ordinal()];
        if (i4 != 1) {
            if (i4 == 2) {
                f5 = (float) getWidth();
            } else if (i4 == 3) {
                f2 = (float) getHeight();
                f5 = 0.0f;
                f4 = 0.0f;
                f3 = 0.0f;
                return new LinearGradient(f5, f4, f3, f2, i2, i3, Shader.TileMode.CLAMP);
            } else if (i4 != 4) {
                f5 = 0.0f;
            } else {
                f4 = (float) getHeight();
                f5 = 0.0f;
                f3 = 0.0f;
            }
            f4 = 0.0f;
            f3 = 0.0f;
        } else {
            f3 = (float) getWidth();
            f5 = 0.0f;
            f4 = 0.0f;
        }
        f2 = 0.0f;
        return new LinearGradient(f5, f4, f3, f2, i2, i3, Shader.TileMode.CLAMP);
    }

    private final void manageElevation() {
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(!this.shadowEnable ? new CircularImageView$manageElevation$1(this) : null);
        }
    }

    private final void loadBitmap() {
        if (!k.a((Object) this.civDrawable, (Object) getDrawable())) {
            Drawable drawable = getDrawable();
            this.civDrawable = drawable;
            this.civImage = drawableToBitmap(drawable);
            updateShader();
        }
    }

    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        update();
    }

    private final void drawShadow() {
        float f2;
        float f3;
        float f4;
        if (Build.VERSION.SDK_INT < 28) {
            setLayerType(1, this.paintShadow);
        }
        int i2 = WhenMappings.$EnumSwitchMapping$1[this.shadowGravity.ordinal()];
        float f5 = 0.0f;
        if (i2 == 2) {
            f3 = -this.shadowRadius;
        } else if (i2 != 3) {
            if (i2 == 4) {
                f4 = -this.shadowRadius;
                f5 = f4 / 2.0f;
            } else if (i2 == 5) {
                f4 = this.shadowRadius;
                f5 = f4 / 2.0f;
            }
            f2 = 0.0f;
            this.paintShadow.setShadowLayer(this.shadowRadius, f5, f2, this.shadowColor);
        } else {
            f3 = this.shadowRadius;
        }
        f2 = f3 / 2.0f;
        this.paintShadow.setShadowLayer(this.shadowRadius, f5, f2, this.shadowColor);
    }

    private final void updateShader() {
        Matrix matrix;
        Bitmap bitmap = this.civImage;
        if (bitmap != null) {
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            int i2 = WhenMappings.$EnumSwitchMapping$2[getScaleType().ordinal()];
            if (i2 == 1) {
                matrix = centerCrop(bitmap, this.heightCircle);
            } else if (i2 == 2) {
                matrix = centerInside(bitmap, this.heightCircle);
            } else if (i2 != 3) {
                matrix = new Matrix();
            } else {
                matrix = fitCenter(bitmap, this.heightCircle);
            }
            bitmapShader.setLocalMatrix(matrix);
            this.paint.setShader(bitmapShader);
            this.paint.setColorFilter(this.civColorFilter);
        }
    }

    private final Matrix centerCrop(Bitmap bitmap, int i2) {
        float f2;
        float f3;
        Matrix matrix = new Matrix();
        float f4 = 0.0f;
        if (bitmap.getWidth() * i2 > bitmap.getHeight() * i2) {
            float f5 = (float) i2;
            f3 = f5 / ((float) bitmap.getHeight());
            f2 = (f5 - (((float) bitmap.getWidth()) * f3)) * 0.5f;
        } else {
            float f6 = (float) i2;
            f3 = f6 / ((float) bitmap.getWidth());
            f4 = (f6 - (((float) bitmap.getHeight()) * f3)) * 0.5f;
            f2 = 0.0f;
        }
        matrix.setScale(f3, f3);
        matrix.postTranslate(f2, f4);
        return matrix;
    }

    private final Matrix centerInside(Bitmap bitmap, int i2) {
        float f2;
        Matrix matrix = new Matrix();
        if (bitmap.getWidth() > i2 || bitmap.getHeight() > i2) {
            float f3 = (float) i2;
            f2 = e.a(f3 / ((float) bitmap.getWidth()), f3 / ((float) bitmap.getHeight()));
        } else {
            f2 = 1.0f;
        }
        float f4 = (float) i2;
        matrix.setScale(f2, f2);
        matrix.postTranslate((float) a.a((f4 - (((float) bitmap.getWidth()) * f2)) * 0.5f), (float) a.a((f4 - (((float) bitmap.getHeight()) * f2)) * 0.5f));
        return matrix;
    }

    private final Matrix fitCenter(Bitmap bitmap, int i2) {
        Matrix matrix = new Matrix();
        RectF rectF = new RectF();
        rectF.set(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight());
        RectF rectF2 = new RectF();
        float f2 = (float) i2;
        rectF2.set(0.0f, 0.0f, f2, f2);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        return matrix;
    }

    private final Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 21 && (drawable instanceof VectorDrawable)) {
            return vectorDrawableToBitmap((VectorDrawable) drawable);
        }
        if (drawable instanceof BitmapDrawable) {
            return bitmapDrawableToBitmap((BitmapDrawable) drawable);
        }
        return toBitmap(drawable);
    }

    private final Bitmap vectorDrawableToBitmap(VectorDrawable vectorDrawable) {
        Bitmap createBitmap = Bitmap.createBitmap(getScaleType() == ImageView.ScaleType.CENTER_INSIDE ? vectorDrawable.getIntrinsicWidth() : getWidth(), getScaleType() == ImageView.ScaleType.CENTER_INSIDE ? vectorDrawable.getIntrinsicHeight() : getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        vectorDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        vectorDrawable.draw(canvas);
        k.b(createBitmap, "bitmap");
        return createBitmap;
    }

    private final Bitmap bitmapDrawableToBitmap(BitmapDrawable bitmapDrawable) {
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmapDrawable.getBitmap(), bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight(), false);
        k.b(createScaledBitmap, "bitmap.let {\n           …          )\n            }");
        return createScaledBitmap;
    }

    private final Bitmap toBitmap(Drawable drawable) {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final void onMeasure(int i2, int i3) {
        int min = Math.min(measure(i2) - (getPaddingLeft() + getPaddingRight()), measure(i3) - (getPaddingTop() + getPaddingBottom()));
        this.heightCircle = min;
        setMeasuredDimension(min, min);
    }

    private final int measure(int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : this.heightCircle;
    }

    private final ShadowGravity toShadowGravity(int i2) {
        if (i2 == 1) {
            return ShadowGravity.CENTER;
        }
        if (i2 == 2) {
            return ShadowGravity.TOP;
        }
        if (i2 == 3) {
            return ShadowGravity.BOTTOM;
        }
        if (i2 == 4) {
            return ShadowGravity.START;
        }
        if (i2 == 5) {
            return ShadowGravity.END;
        }
        throw new IllegalArgumentException("This value is not supported for ShadowGravity: ".concat(String.valueOf(i2)));
    }

    private final GradientDirection toGradientDirection(int i2) {
        if (i2 == 1) {
            return GradientDirection.LEFT_TO_RIGHT;
        }
        if (i2 == 2) {
            return GradientDirection.RIGHT_TO_LEFT;
        }
        if (i2 == 3) {
            return GradientDirection.TOP_TO_BOTTOM;
        }
        if (i2 == 4) {
            return GradientDirection.BOTTOM_TO_TOP;
        }
        throw new IllegalArgumentException("This value is not supported for GradientDirection: ".concat(String.valueOf(i2)));
    }

    public enum ShadowGravity {
        CENTER(1),
        TOP(2),
        BOTTOM(3),
        START(4),
        END(5);
        
        public final int value;

        /* access modifiers changed from: public */
        ShadowGravity(int i2) {
            this.value = i2;
        }

        public final int getValue() {
            return this.value;
        }
    }

    public enum GradientDirection {
        LEFT_TO_RIGHT(1),
        RIGHT_TO_LEFT(2),
        TOP_TO_BOTTOM(3),
        BOTTOM_TO_TOP(4);
        
        public final int value;

        /* access modifiers changed from: public */
        GradientDirection(int i2) {
            this.value = i2;
        }

        public final int getValue() {
            return this.value;
        }
    }
}
