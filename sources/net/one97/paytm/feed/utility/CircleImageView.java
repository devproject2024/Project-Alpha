package net.one97.paytm.feed.utility;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import net.one97.paytm.feed.R;

public class CircleImageView extends AppCompatImageView {

    /* renamed from: a  reason: collision with root package name */
    private float f35347a;

    /* renamed from: b  reason: collision with root package name */
    private int f35348b;

    /* renamed from: c  reason: collision with root package name */
    private float f35349c;

    /* renamed from: d  reason: collision with root package name */
    private int f35350d;

    /* renamed from: e  reason: collision with root package name */
    private a f35351e;

    /* renamed from: f  reason: collision with root package name */
    private ColorFilter f35352f;

    /* renamed from: g  reason: collision with root package name */
    private Bitmap f35353g;

    /* renamed from: h  reason: collision with root package name */
    private Drawable f35354h;

    /* renamed from: i  reason: collision with root package name */
    private Paint f35355i;
    private Paint j;
    private Paint k;

    public CircleImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f35350d = -16777216;
        this.f35351e = a.BOTTOM;
        this.f35355i = new Paint();
        this.f35355i.setAntiAlias(true);
        this.j = new Paint();
        this.j.setAntiAlias(true);
        this.k = new Paint();
        this.k.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FeedCircleImageView, i2, 0);
        if (obtainStyledAttributes.getBoolean(R.styleable.FeedCircleImageView_feed_civ_border, true)) {
            setBorderWidth(obtainStyledAttributes.getDimension(R.styleable.FeedCircleImageView_feed_civ_border_width, getContext().getResources().getDisplayMetrics().density * 1.0f));
            setBorderColor(obtainStyledAttributes.getColor(R.styleable.FeedCircleImageView_feed_civ_border_color, -1));
        }
        setBackgroundColor(obtainStyledAttributes.getColor(R.styleable.FeedCircleImageView_feed_civ_background_color, -1));
        if (obtainStyledAttributes.getBoolean(R.styleable.FeedCircleImageView_feed_civ_shadow, false)) {
            this.f35349c = 1.0f;
            a(obtainStyledAttributes.getFloat(R.styleable.FeedCircleImageView_feed_civ_shadow_radius, this.f35349c), obtainStyledAttributes.getColor(R.styleable.FeedCircleImageView_feed_civ_shadow_color, this.f35350d));
            this.f35351e = a.fromValue(obtainStyledAttributes.getInteger(R.styleable.FeedCircleImageView_feed_civ_shadow_gravity, a.BOTTOM.getValue()));
        }
        obtainStyledAttributes.recycle();
    }

    public void setBorderWidth(float f2) {
        this.f35347a = f2;
        requestLayout();
        invalidate();
    }

    public void setBorderColor(int i2) {
        Paint paint = this.j;
        if (paint != null) {
            paint.setColor(i2);
        }
        invalidate();
    }

    public void setBackgroundColor(int i2) {
        Paint paint = this.k;
        if (paint != null) {
            paint.setColor(i2);
        }
        invalidate();
    }

    public void setShadowRadius(float f2) {
        a(f2, this.f35350d);
        invalidate();
    }

    public void setShadowColor(int i2) {
        a(this.f35349c, i2);
        invalidate();
    }

    public void setShadowGravity(a aVar) {
        this.f35351e = aVar;
        invalidate();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f35352f != colorFilter) {
            this.f35352f = colorFilter;
            this.f35354h = null;
            invalidate();
        }
    }

    public ImageView.ScaleType getScaleType() {
        ImageView.ScaleType scaleType = super.getScaleType();
        return (scaleType == null || scaleType != ImageView.ScaleType.CENTER_INSIDE) ? ImageView.ScaleType.CENTER_CROP : scaleType;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == ImageView.ScaleType.CENTER_CROP || scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            super.setScaleType(scaleType);
        } else {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported. Just ScaleType.CENTER_CROP & ScaleType.CENTER_INSIDE are available .", new Object[]{scaleType}));
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f35348b = Math.min(i2, i3);
        if (this.f35353g != null) {
            a();
        }
    }

    private void a(float f2, int i2) {
        float f3;
        float f4;
        this.f35349c = f2;
        this.f35350d = i2;
        setLayerType(1, this.j);
        int i3 = AnonymousClass1.f35356a[this.f35351e.ordinal()];
        float f5 = 0.0f;
        if (i3 != 1) {
            if (i3 == 2) {
                f3 = (-f2) / 2.0f;
            } else if (i3 != 3) {
                if (i3 == 4) {
                    f4 = (-f2) / 2.0f;
                } else if (i3 == 5) {
                    f4 = f2 / 2.0f;
                }
                f5 = f4;
            } else {
                f3 = f2 / 2.0f;
            }
            this.j.setShadowLayer(f2, f5, f3, i2);
        }
        f3 = 0.0f;
        this.j.setShadowLayer(f2, f5, f3, i2);
    }

    private void a() {
        float f2;
        float f3;
        int i2;
        float f4;
        int i3;
        float f5;
        float width;
        Bitmap bitmap = this.f35353g;
        if (bitmap != null) {
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            int i4 = AnonymousClass1.f35357b[getScaleType().ordinal()];
            float f6 = 0.0f;
            if (i4 != 1) {
                if (i4 != 2) {
                    f3 = 0.0f;
                } else if (this.f35353g.getWidth() * getHeight() < getWidth() * this.f35353g.getHeight()) {
                    f3 = ((float) getHeight()) / ((float) this.f35353g.getHeight());
                    f5 = (float) getWidth();
                    i3 = this.f35353g.getWidth();
                    f6 = (f5 - (((float) i3) * f3)) * 0.5f;
                } else {
                    width = ((float) getWidth()) / ((float) this.f35353g.getWidth());
                    f4 = (float) getHeight();
                    i2 = this.f35353g.getHeight();
                    f2 = (f4 - (((float) i2) * f3)) * 0.5f;
                    Matrix matrix = new Matrix();
                    matrix.setScale(f3, f3);
                    matrix.postTranslate(f6, f2);
                    bitmapShader.setLocalMatrix(matrix);
                    this.f35355i.setShader(bitmapShader);
                    this.f35355i.setColorFilter(this.f35352f);
                }
            } else if (this.f35353g.getWidth() * getHeight() > getWidth() * this.f35353g.getHeight()) {
                f3 = ((float) getHeight()) / ((float) this.f35353g.getHeight());
                f5 = (float) getWidth();
                i3 = this.f35353g.getWidth();
                f6 = (f5 - (((float) i3) * f3)) * 0.5f;
            } else {
                width = ((float) getWidth()) / ((float) this.f35353g.getWidth());
                f4 = (float) getHeight();
                i2 = this.f35353g.getHeight();
                f2 = (f4 - (((float) i2) * f3)) * 0.5f;
                Matrix matrix2 = new Matrix();
                matrix2.setScale(f3, f3);
                matrix2.postTranslate(f6, f2);
                bitmapShader.setLocalMatrix(matrix2);
                this.f35355i.setShader(bitmapShader);
                this.f35355i.setColorFilter(this.f35352f);
            }
            f2 = 0.0f;
            Matrix matrix22 = new Matrix();
            matrix22.setScale(f3, f3);
            matrix22.postTranslate(f6, f2);
            bitmapShader.setLocalMatrix(matrix22);
            this.f35355i.setShader(bitmapShader);
            this.f35355i.setColorFilter(this.f35352f);
        }
    }

    /* renamed from: net.one97.paytm.feed.utility.CircleImageView$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f35356a = new int[a.values().length];

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f35357b = new int[ImageView.ScaleType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|20) */
        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|5|6|7|9|10|11|12|13|14|15|16|17|18|20) */
        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|5|6|7|9|10|11|12|13|14|15|16|17|18|20) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0032 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0047 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0052 */
        static {
            /*
                android.widget.ImageView$ScaleType[] r0 = android.widget.ImageView.ScaleType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f35357b = r0
                r0 = 1
                int[] r1 = f35357b     // Catch:{ NoSuchFieldError -> 0x0014 }
                android.widget.ImageView$ScaleType r2 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f35357b     // Catch:{ NoSuchFieldError -> 0x001f }
                android.widget.ImageView$ScaleType r3 = android.widget.ImageView.ScaleType.CENTER_INSIDE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                net.one97.paytm.feed.utility.CircleImageView$a[] r2 = net.one97.paytm.feed.utility.CircleImageView.a.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f35356a = r2
                int[] r2 = f35356a     // Catch:{ NoSuchFieldError -> 0x0032 }
                net.one97.paytm.feed.utility.CircleImageView$a r3 = net.one97.paytm.feed.utility.CircleImageView.a.CENTER     // Catch:{ NoSuchFieldError -> 0x0032 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0032 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                int[] r0 = f35356a     // Catch:{ NoSuchFieldError -> 0x003c }
                net.one97.paytm.feed.utility.CircleImageView$a r2 = net.one97.paytm.feed.utility.CircleImageView.a.TOP     // Catch:{ NoSuchFieldError -> 0x003c }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x003c }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x003c }
            L_0x003c:
                int[] r0 = f35356a     // Catch:{ NoSuchFieldError -> 0x0047 }
                net.one97.paytm.feed.utility.CircleImageView$a r1 = net.one97.paytm.feed.utility.CircleImageView.a.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0047 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0047 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0047 }
            L_0x0047:
                int[] r0 = f35356a     // Catch:{ NoSuchFieldError -> 0x0052 }
                net.one97.paytm.feed.utility.CircleImageView$a r1 = net.one97.paytm.feed.utility.CircleImageView.a.START     // Catch:{ NoSuchFieldError -> 0x0052 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0052 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0052 }
            L_0x0052:
                int[] r0 = f35356a     // Catch:{ NoSuchFieldError -> 0x005d }
                net.one97.paytm.feed.utility.CircleImageView$a r1 = net.one97.paytm.feed.utility.CircleImageView.a.END     // Catch:{ NoSuchFieldError -> 0x005d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005d }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005d }
            L_0x005d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.utility.CircleImageView.AnonymousClass1.<clinit>():void");
        }
    }

    private static Bitmap a(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Exception unused) {
            return null;
        }
    }

    public enum a {
        CENTER,
        TOP,
        BOTTOM,
        START,
        END;

        public final int getValue() {
            int i2 = AnonymousClass1.f35356a[ordinal()];
            int i3 = 1;
            if (i2 != 1) {
                i3 = 2;
                if (i2 != 2) {
                    i3 = 3;
                    if (i2 != 3) {
                        i3 = 4;
                        if (i2 != 4) {
                            if (i2 == 5) {
                                return 5;
                            }
                            throw new IllegalArgumentException("Not value available for this ShadowGravity: ".concat(String.valueOf(this)));
                        }
                    }
                }
            }
            return i3;
        }

        public static a fromValue(int i2) {
            if (i2 == 1) {
                return CENTER;
            }
            if (i2 == 2) {
                return TOP;
            }
            if (i2 == 3) {
                return BOTTOM;
            }
            if (i2 == 4) {
                return START;
            }
            if (i2 == 5) {
                return END;
            }
            throw new IllegalArgumentException("This value is not supported for ShadowGravity: ".concat(String.valueOf(i2)));
        }
    }

    public void onDraw(Canvas canvas) {
        if (this.f35354h != getDrawable()) {
            this.f35354h = getDrawable();
            this.f35353g = a(this.f35354h);
            a();
        }
        if (this.f35353g != null) {
            if (!isInEditMode()) {
                this.f35348b = Math.min(canvas.getWidth(), canvas.getHeight());
            }
            float f2 = this.f35347a;
            float f3 = this.f35349c * 2.0f;
            float f4 = (float) (((int) (((float) this.f35348b) - (f2 * 2.0f))) / 2);
            canvas.drawCircle(f4 + f2, f4 + f2, (f2 + f4) - f3, this.j);
            float f5 = this.f35347a;
            float f6 = f4 - f3;
            canvas.drawCircle(f4 + f5, f5 + f4, f6, this.k);
            float f7 = this.f35347a;
            canvas.drawCircle(f4 + f7, f4 + f7, f6, this.f35355i);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (!(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            size = this.f35348b;
        }
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (!(mode2 == 1073741824 || mode2 == Integer.MIN_VALUE)) {
            size2 = this.f35348b;
        }
        setMeasuredDimension(size, size2 + 2);
    }
}
