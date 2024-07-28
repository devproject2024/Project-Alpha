package net.one97.paytm.o2o.movies.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.AttributeSet;
import android.view.View;
import net.one97.paytm.o2o.movies.R;

public class CJRTicketView extends View {

    /* renamed from: a  reason: collision with root package name */
    public static final String f75886a = CJRTicketView.class.getSimpleName();
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private Bitmap F;
    private final Paint G = new Paint(1);
    private float H = 0.0f;

    /* renamed from: b  reason: collision with root package name */
    private Paint f75887b = new Paint();

    /* renamed from: c  reason: collision with root package name */
    private Paint f75888c = new Paint();

    /* renamed from: d  reason: collision with root package name */
    private Paint f75889d = new Paint();

    /* renamed from: e  reason: collision with root package name */
    private int f75890e;

    /* renamed from: f  reason: collision with root package name */
    private Path f75891f = new Path();

    /* renamed from: g  reason: collision with root package name */
    private boolean f75892g = true;

    /* renamed from: h  reason: collision with root package name */
    private float f75893h;

    /* renamed from: i  reason: collision with root package name */
    private float f75894i;
    private float j;
    private float k;
    private RectF l = new RectF();
    private RectF m = new RectF();
    private RectF n = new RectF();
    private int o;
    private float p;
    private float q;
    private int r;
    private boolean s;
    private int t;
    private int u;
    private boolean v;
    private int w;
    private int x;
    private int y;
    private int z;

    public CJRTicketView(Context context) {
        super(context);
        a((AttributeSet) null);
    }

    public CJRTicketView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public CJRTicketView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f2;
        Canvas canvas2 = canvas;
        super.onDraw(canvas);
        if (this.f75892g) {
            float paddingLeft = ((float) getPaddingLeft()) + this.H;
            float width = ((float) (getWidth() - getPaddingRight())) - this.H;
            float paddingTop = ((float) getPaddingTop()) + (this.H / 2.0f);
            float f3 = this.H;
            float height = (((float) (getHeight() - getPaddingBottom())) - f3) - (f3 / 2.0f);
            this.f75891f.reset();
            if (this.f75890e == 0) {
                f2 = ((paddingTop + height) / this.p) - ((float) this.w);
                int i2 = this.C;
                if (i2 == 1) {
                    this.f75891f.arcTo(a(paddingTop, paddingLeft), 180.0f, 90.0f, false);
                    this.f75891f.lineTo(((float) this.D) + paddingLeft, paddingTop);
                    this.f75891f.lineTo(width - ((float) this.D), paddingTop);
                    this.f75891f.arcTo(b(paddingTop, width), -90.0f, 90.0f, false);
                } else if (i2 == 2) {
                    this.f75891f.arcTo(e(paddingTop, paddingLeft), 90.0f, -90.0f, false);
                    this.f75891f.lineTo(((float) this.D) + paddingLeft, paddingTop);
                    this.f75891f.lineTo(width - ((float) this.D), paddingTop);
                    this.f75891f.arcTo(f(paddingTop, width), 180.0f, -90.0f, false);
                } else {
                    this.f75891f.moveTo(paddingLeft, paddingTop);
                    this.f75891f.lineTo(width, paddingTop);
                }
                RectF rectF = this.l;
                int i3 = this.w;
                float f4 = paddingTop + f2;
                rectF.set(width - ((float) i3), f4, ((float) i3) + width, ((float) this.o) + f2 + paddingTop);
                this.f75891f.arcTo(this.l, 270.0f, -180.0f, false);
                int i4 = this.C;
                if (i4 == 1) {
                    this.f75891f.arcTo(d(height, width), 0.0f, 90.0f, false);
                    this.f75891f.lineTo(width - ((float) this.D), height);
                    this.f75891f.lineTo(((float) this.D) + paddingLeft, height);
                    this.f75891f.arcTo(c(paddingLeft, height), 90.0f, 90.0f, false);
                } else if (i4 == 2) {
                    this.f75891f.arcTo(h(height, width), 270.0f, -90.0f, false);
                    this.f75891f.lineTo(width - ((float) this.D), height);
                    this.f75891f.lineTo(((float) this.D) + paddingLeft, height);
                    this.f75891f.arcTo(g(paddingLeft, height), 0.0f, -90.0f, false);
                } else {
                    this.f75891f.lineTo(width, height);
                    this.f75891f.lineTo(paddingLeft, height);
                }
                RectF rectF2 = this.l;
                int i5 = this.w;
                rectF2.set(paddingLeft - ((float) i5), f4, ((float) i5) + paddingLeft, ((float) this.o) + f2 + paddingTop);
                this.f75891f.arcTo(this.l, 90.0f, -180.0f, false);
            } else {
                f2 = ((width + paddingLeft) / this.p) - ((float) this.w);
                int i6 = this.C;
                if (i6 == 1) {
                    this.f75891f.arcTo(a(paddingTop, paddingLeft), 180.0f, 90.0f, false);
                    this.f75891f.lineTo(((float) this.D) + paddingLeft, paddingTop);
                } else if (i6 == 2) {
                    this.f75891f.arcTo(e(paddingTop, paddingLeft), 90.0f, -90.0f, false);
                    this.f75891f.lineTo(((float) this.D) + paddingLeft, paddingTop);
                } else {
                    this.f75891f.moveTo(paddingLeft, paddingTop);
                }
                RectF rectF3 = this.l;
                float f5 = paddingLeft + f2;
                int i7 = this.w;
                rectF3.set(f5, paddingTop - ((float) i7), ((float) this.o) + f2 + paddingLeft, ((float) i7) + paddingTop);
                this.f75891f.arcTo(this.l, 180.0f, -180.0f, false);
                int i8 = this.C;
                if (i8 == 1) {
                    this.f75891f.lineTo(width - ((float) this.D), paddingTop);
                    this.f75891f.arcTo(b(paddingTop, width), -90.0f, 90.0f, false);
                    this.f75891f.arcTo(d(height, width), 0.0f, 90.0f, false);
                    this.f75891f.lineTo(width - ((float) this.D), height);
                } else if (i8 == 2) {
                    this.f75891f.lineTo(width - ((float) this.D), paddingTop);
                    this.f75891f.arcTo(f(paddingTop, width), 180.0f, -90.0f, false);
                    this.f75891f.arcTo(h(height, width), 270.0f, -90.0f, false);
                    this.f75891f.lineTo(width - ((float) this.D), height);
                } else {
                    this.f75891f.lineTo(width, paddingTop);
                    this.f75891f.lineTo(width, height);
                }
                RectF rectF4 = this.l;
                int i9 = this.w;
                rectF4.set(f5, height - ((float) i9), ((float) this.o) + f2 + paddingLeft, ((float) i9) + height);
                this.f75891f.arcTo(this.l, 0.0f, -180.0f, false);
                int i10 = this.C;
                if (i10 == 1) {
                    this.f75891f.arcTo(c(paddingLeft, height), 90.0f, 90.0f, false);
                    this.f75891f.lineTo(paddingLeft, height - ((float) this.D));
                } else if (i10 == 2) {
                    this.f75891f.arcTo(g(paddingLeft, height), 0.0f, -90.0f, false);
                    this.f75891f.lineTo(paddingLeft, height - ((float) this.D));
                } else {
                    this.f75891f.lineTo(paddingLeft, height);
                }
            }
            this.f75891f.close();
            if (this.f75890e == 0) {
                int i11 = this.w;
                int i12 = this.E;
                this.f75893h = paddingLeft + ((float) i11) + ((float) i12);
                this.f75894i = ((float) i11) + paddingTop + f2;
                this.j = (width - ((float) i11)) - ((float) i12);
                this.k = ((float) i11) + paddingTop + f2;
            } else {
                int i13 = this.w;
                this.f75893h = ((float) i13) + paddingLeft + f2;
                int i14 = this.E;
                this.f75894i = paddingTop + ((float) i13) + ((float) i14);
                this.j = ((float) i13) + paddingLeft + f2;
                this.k = (height - ((float) i13)) - ((float) i14);
            }
            if (e() && !isInEditMode() && this.H != 0.0f) {
                Bitmap bitmap = this.F;
                if (bitmap == null) {
                    this.F = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ALPHA_8);
                } else {
                    bitmap.eraseColor(0);
                }
                Canvas canvas3 = new Canvas(this.F);
                canvas3.drawPath(this.f75891f, this.G);
                if (this.s) {
                    canvas3.drawPath(this.f75891f, this.G);
                }
                RenderScript create = RenderScript.create(getContext());
                ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8(create));
                Allocation createFromBitmap = Allocation.createFromBitmap(create, this.F);
                Allocation createTyped = Allocation.createTyped(create, createFromBitmap.getType());
                create2.setRadius(this.H);
                create2.setInput(createFromBitmap);
                create2.forEach(createTyped);
                createTyped.copyTo(this.F);
                createFromBitmap.destroy();
                createTyped.destroy();
                create2.destroy();
            }
            this.f75892g = false;
        }
        if (this.H > 0.0f && !isInEditMode()) {
            canvas2.drawBitmap(this.F, 0.0f, this.H / 2.0f, (Paint) null);
        }
        canvas2.drawPath(this.f75891f, this.f75887b);
        if (this.s) {
            canvas2.drawPath(this.f75891f, this.f75888c);
        }
        if (this.v) {
            canvas.drawLine(this.f75893h, this.f75894i, this.j, this.k, this.f75889d);
        }
    }

    private void a(AttributeSet attributeSet) {
        float f2;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.TicketView);
            this.f75890e = obtainStyledAttributes.getInt(R.styleable.TicketView_ticketOrientation, 0);
            this.r = obtainStyledAttributes.getColor(R.styleable.TicketView_ticketBackgroundColor, getResources().getColor(17170443));
            this.w = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TicketView_ticketScallopRadius, n.a(20, getContext()));
            this.q = obtainStyledAttributes.getFloat(R.styleable.TicketView_ticketScallopPositionPercent, 50.0f);
            this.s = obtainStyledAttributes.getBoolean(R.styleable.TicketView_ticketShowBorder, false);
            this.t = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TicketView_ticketBorderWidth, n.a(2, getContext()));
            this.u = obtainStyledAttributes.getColor(R.styleable.TicketView_ticketBorderColor, getResources().getColor(17170444));
            this.v = obtainStyledAttributes.getBoolean(R.styleable.TicketView_ticketShowDivider, false);
            this.z = obtainStyledAttributes.getInt(R.styleable.TicketView_ticketDividerType, 0);
            this.A = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TicketView_ticketDividerWidth, n.a(2, getContext()));
            this.B = obtainStyledAttributes.getColor(R.styleable.TicketView_ticketDividerColor, getResources().getColor(17170432));
            this.x = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TicketView_ticketDividerDashLength, n.a(8, getContext()));
            this.y = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TicketView_ticketDividerDashGap, n.a(4, getContext()));
            this.C = obtainStyledAttributes.getInt(R.styleable.TicketView_ticketCornerType, 0);
            this.D = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TicketView_ticketCornerRadius, n.a(4, getContext()));
            this.E = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TicketView_ticketDividerPadding, n.a(10, getContext()));
            if (obtainStyledAttributes.hasValue(R.styleable.TicketView_ticketElevation)) {
                f2 = obtainStyledAttributes.getDimension(R.styleable.TicketView_ticketElevation, 0.0f);
            } else {
                f2 = obtainStyledAttributes.hasValue(R.styleable.TicketView_android_elevation) ? obtainStyledAttributes.getDimension(R.styleable.TicketView_android_elevation, 0.0f) : 0.0f;
            }
            if (f2 > 0.0f) {
                setShadowBlurRadius(f2);
            }
            obtainStyledAttributes.recycle();
        }
        this.G.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.SRC_IN));
        this.G.setAlpha(51);
        a();
        setLayerType(1, (Paint) null);
    }

    private void a() {
        int i2 = this.A;
        int i3 = this.w;
        if (i2 > i3) {
            this.A = i3;
        }
        this.p = 100.0f / this.q;
        this.o = this.w * 2;
        b();
        c();
        d();
        this.f75892g = true;
        invalidate();
    }

    private void b() {
        this.f75887b.setAlpha(0);
        this.f75887b.setAntiAlias(true);
        this.f75887b.setColor(this.r);
        this.f75887b.setStyle(Paint.Style.FILL);
    }

    private void c() {
        this.f75888c.setAlpha(0);
        this.f75888c.setAntiAlias(true);
        this.f75888c.setColor(this.u);
        this.f75888c.setStrokeWidth((float) this.t);
        this.f75888c.setStyle(Paint.Style.STROKE);
    }

    private void d() {
        this.f75889d.setAlpha(0);
        this.f75889d.setAntiAlias(true);
        this.f75889d.setColor(this.B);
        this.f75889d.setStrokeWidth((float) this.A);
        if (this.z == 1) {
            this.f75889d.setPathEffect(new DashPathEffect(new float[]{(float) this.x, (float) this.y}, 0.0f));
            return;
        }
        this.f75889d.setPathEffect(new PathEffect());
    }

    private RectF a(float f2, float f3) {
        RectF rectF = this.m;
        int i2 = this.D;
        rectF.set(f3, f2, ((float) (i2 * 2)) + f3, ((float) (i2 * 2)) + f2);
        return this.m;
    }

    private RectF b(float f2, float f3) {
        RectF rectF = this.m;
        int i2 = this.D;
        rectF.set(f3 - ((float) (i2 * 2)), f2, f3, ((float) (i2 * 2)) + f2);
        return this.m;
    }

    private RectF c(float f2, float f3) {
        RectF rectF = this.m;
        int i2 = this.D;
        rectF.set(f2, f3 - ((float) (i2 * 2)), ((float) (i2 * 2)) + f2, f3);
        return this.m;
    }

    private RectF d(float f2, float f3) {
        RectF rectF = this.m;
        int i2 = this.D;
        rectF.set(f3 - ((float) (i2 * 2)), f2 - ((float) (i2 * 2)), f3, f2);
        return this.m;
    }

    private RectF e(float f2, float f3) {
        RectF rectF = this.n;
        int i2 = this.D;
        rectF.set(f3 - ((float) i2), f2 - ((float) i2), f3 + ((float) i2), f2 + ((float) i2));
        return this.n;
    }

    private RectF f(float f2, float f3) {
        RectF rectF = this.n;
        int i2 = this.D;
        rectF.set(f3 - ((float) i2), f2 - ((float) i2), f3 + ((float) i2), f2 + ((float) i2));
        return this.n;
    }

    private RectF g(float f2, float f3) {
        RectF rectF = this.n;
        int i2 = this.D;
        rectF.set(f2 - ((float) i2), f3 - ((float) i2), f2 + ((float) i2), f3 + ((float) i2));
        return this.n;
    }

    private RectF h(float f2, float f3) {
        RectF rectF = this.n;
        int i2 = this.D;
        rectF.set(f3 - ((float) i2), f2 - ((float) i2), f3 + ((float) i2), f2 + ((float) i2));
        return this.n;
    }

    public int getOrientation() {
        return this.f75890e;
    }

    public void setOrientation(int i2) {
        this.f75890e = i2;
        a();
    }

    public float getScallopPositionPercent() {
        return this.q;
    }

    public void setScallopPositionPercent(float f2) {
        this.q = f2;
        a();
    }

    public int getBackgroundColor() {
        return this.r;
    }

    public void setBackgroundColor(int i2) {
        this.r = i2;
        a();
    }

    public void setShowBorder(boolean z2) {
        this.s = z2;
        a();
    }

    public int getBorderWidth() {
        return this.t;
    }

    public void setBorderWidth(int i2) {
        this.t = i2;
        a();
    }

    public int getBorderColor() {
        return this.u;
    }

    public void setBorderColor(int i2) {
        this.u = i2;
        a();
    }

    public void setShowDivider(boolean z2) {
        this.v = z2;
        a();
    }

    public int getScallopRadius() {
        return this.w;
    }

    public void setScallopRadius(int i2) {
        this.w = i2;
        a();
    }

    public int getDividerDashLength() {
        return this.x;
    }

    public void setDividerDashLength(int i2) {
        this.x = i2;
        a();
    }

    public int getDividerDashGap() {
        return this.y;
    }

    public void setDividerDashGap(int i2) {
        this.y = i2;
        a();
    }

    public int getDividerType() {
        return this.z;
    }

    public void setDividerType(int i2) {
        this.z = i2;
        a();
    }

    public int getDividerWidth() {
        return this.A;
    }

    public void setDividerWidth(int i2) {
        this.A = i2;
        a();
    }

    public int getDividerPadding() {
        return this.E;
    }

    public void setDividerPadding(int i2) {
        this.E = i2;
        a();
    }

    public int getDividerColor() {
        return this.B;
    }

    public void setDividerColor(int i2) {
        this.B = i2;
        a();
    }

    public int getCornerType() {
        return this.C;
    }

    public void setCornerType(int i2) {
        this.C = i2;
        a();
    }

    public int getCornerRadius() {
        return this.D;
    }

    public void setCornerRadius(int i2) {
        this.D = i2;
        a();
    }

    public void setTicketElevation(float f2) {
        if (e()) {
            setShadowBlurRadius(f2);
            a();
        }
    }

    private void setShadowBlurRadius(float f2) {
        if (e()) {
            this.H = Math.min((f2 / ((float) n.a(24, getContext()))) * 25.0f, 25.0f);
        }
    }

    private static boolean e() {
        return Build.VERSION.SDK_INT >= 17;
    }
}
