package net.one97.paytm.paymentsBank.widget.croptool;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import java.util.Arrays;
import net.one97.paytm.paymentsBank.widget.croptool.PBCropImageView;
import net.one97.paytm.paymentsBank.widget.croptool.f;

public class CropOverlayView extends View {
    private final Rect A;
    private boolean B;
    private Integer C;

    /* renamed from: a  reason: collision with root package name */
    boolean f19663a;

    /* renamed from: b  reason: collision with root package name */
    private ScaleGestureDetector f19664b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f19665c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final e f19666d;

    /* renamed from: e  reason: collision with root package name */
    private a f19667e;

    /* renamed from: f  reason: collision with root package name */
    private final RectF f19668f;

    /* renamed from: g  reason: collision with root package name */
    private Paint f19669g;

    /* renamed from: h  reason: collision with root package name */
    private Paint f19670h;

    /* renamed from: i  reason: collision with root package name */
    private Paint f19671i;
    private Paint j;
    private Path k;
    private final float[] l;
    private final RectF m;
    private int n;
    private int o;
    private float p;
    private float q;
    private float r;
    private float s;
    private float t;
    private f u;
    private int v;
    private int w;
    private float x;
    private PBCropImageView.c y;
    private PBCropImageView.b z;

    public interface a {
        void onCropWindowChanged(boolean z);
    }

    public CropOverlayView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CropOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19666d = new e();
        this.f19668f = new RectF();
        this.k = new Path();
        this.l = new float[8];
        this.m = new RectF();
        this.x = ((float) this.v) / ((float) this.w);
        this.A = new Rect();
    }

    public void setCropWindowChangeListener(a aVar) {
        this.f19667e = aVar;
    }

    public RectF getCropWindowRect() {
        return this.f19666d.a();
    }

    public void setCropWindowRect(RectF rectF) {
        this.f19666d.a(rectF);
    }

    public final void a() {
        RectF cropWindowRect = getCropWindowRect();
        a(cropWindowRect);
        this.f19666d.a(cropWindowRect);
    }

    public void setBounds(float[] fArr, int i2, int i3) {
        if (fArr == null || !Arrays.equals(this.l, fArr)) {
            if (fArr == null) {
                Arrays.fill(this.l, 0.0f);
            } else {
                System.arraycopy(fArr, 0, this.l, 0, fArr.length);
            }
            this.n = i2;
            this.o = i3;
            RectF a2 = this.f19666d.a();
            if (a2.width() == 0.0f || a2.height() == 0.0f) {
                c();
            }
        }
    }

    public final void b() {
        if (this.B) {
            setCropWindowRect(c.f19716b);
            c();
            invalidate();
        }
    }

    public PBCropImageView.b getCropShape() {
        return this.z;
    }

    public void setCropShape(PBCropImageView.b bVar) {
        if (this.z != bVar) {
            this.z = bVar;
            if (Build.VERSION.SDK_INT <= 17) {
                if (this.z == PBCropImageView.b.OVAL) {
                    this.C = Integer.valueOf(getLayerType());
                    if (this.C.intValue() != 1) {
                        setLayerType(1, (Paint) null);
                    } else {
                        this.C = null;
                    }
                } else {
                    Integer num = this.C;
                    if (num != null) {
                        setLayerType(num.intValue(), (Paint) null);
                        this.C = null;
                    }
                }
            }
            invalidate();
        }
    }

    public PBCropImageView.c getGuidelines() {
        return this.y;
    }

    public void setGuidelines(PBCropImageView.c cVar) {
        if (this.y != cVar) {
            this.y = cVar;
            if (this.B) {
                invalidate();
            }
        }
    }

    public void setFixedAspectRatio(boolean z2) {
        if (this.f19663a != z2) {
            this.f19663a = z2;
            if (this.B) {
                c();
                invalidate();
            }
        }
    }

    public int getAspectRatioX() {
        return this.v;
    }

    public void setAspectRatioX(int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        } else if (this.v != i2) {
            this.v = i2;
            this.x = ((float) this.v) / ((float) this.w);
            if (this.B) {
                c();
                invalidate();
            }
        }
    }

    public int getAspectRatioY() {
        return this.w;
    }

    public void setAspectRatioY(int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        } else if (this.w != i2) {
            this.w = i2;
            this.x = ((float) this.v) / ((float) this.w);
            if (this.B) {
                c();
                invalidate();
            }
        }
    }

    public void setSnapRadius(float f2) {
        this.t = f2;
    }

    public final boolean a(boolean z2) {
        if (this.f19665c == z2) {
            return false;
        }
        this.f19665c = z2;
        if (!this.f19665c || this.f19664b != null) {
            return true;
        }
        this.f19664b = new ScaleGestureDetector(getContext(), new b(this, (byte) 0));
        return true;
    }

    public void setMinCropResultSize(int i2, int i3) {
        e eVar = this.f19666d;
        eVar.f19740f = (float) i2;
        eVar.f19741g = (float) i3;
    }

    public void setMaxCropResultSize(int i2, int i3) {
        e eVar = this.f19666d;
        eVar.f19742h = (float) i2;
        eVar.f19743i = (float) i3;
    }

    public void setCropWindowLimits(float f2, float f3, float f4, float f5) {
        e eVar = this.f19666d;
        eVar.f19738d = f2;
        eVar.f19739e = f3;
        eVar.j = f4;
        eVar.k = f5;
    }

    public Rect getInitialCropWindowRect() {
        return this.A;
    }

    public void setInitialCropWindowRect(Rect rect) {
        Rect rect2 = this.A;
        if (rect == null) {
            rect = c.f19715a;
        }
        rect2.set(rect);
        if (this.B) {
            c();
            invalidate();
            b(false);
        }
    }

    public void setInitialAttributeValues(CropImageOptions cropImageOptions) {
        e eVar = this.f19666d;
        eVar.f19736b = (float) cropImageOptions.x;
        eVar.f19737c = (float) cropImageOptions.y;
        eVar.f19740f = (float) cropImageOptions.z;
        eVar.f19741g = (float) cropImageOptions.A;
        eVar.f19742h = (float) cropImageOptions.B;
        eVar.f19743i = (float) cropImageOptions.C;
        setCropShape(cropImageOptions.f19654a);
        setSnapRadius(cropImageOptions.f19655b);
        setGuidelines(cropImageOptions.f19657d);
        setFixedAspectRatio(cropImageOptions.l);
        setAspectRatioX(cropImageOptions.m);
        setAspectRatioY(cropImageOptions.n);
        a(cropImageOptions.f19662i);
        this.s = cropImageOptions.f19656c;
        this.r = cropImageOptions.k;
        this.f19669g = a(cropImageOptions.o, cropImageOptions.p);
        this.p = cropImageOptions.r;
        this.q = cropImageOptions.s;
        this.f19670h = a(cropImageOptions.q, cropImageOptions.t);
        this.f19671i = a(cropImageOptions.u, cropImageOptions.v);
        int i2 = cropImageOptions.w;
        Paint paint = new Paint();
        paint.setColor(i2);
        this.j = paint;
    }

    private void c() {
        float max = Math.max(c.a(this.l), 0.0f);
        float max2 = Math.max(c.b(this.l), 0.0f);
        float min = Math.min(c.c(this.l), (float) getWidth());
        float min2 = Math.min(c.d(this.l), (float) getHeight());
        if (min > max && min2 > max2) {
            RectF rectF = new RectF();
            this.B = true;
            float f2 = this.r;
            float f3 = min - max;
            float f4 = f2 * f3;
            float f5 = min2 - max2;
            float f6 = f2 * f5;
            if (this.A.width() > 0 && this.A.height() > 0) {
                rectF.left = (((float) this.A.left) / this.f19666d.j) + max;
                rectF.top = (((float) this.A.top) / this.f19666d.k) + max2;
                rectF.right = rectF.left + (((float) this.A.width()) / this.f19666d.j);
                rectF.bottom = rectF.top + (((float) this.A.height()) / this.f19666d.k);
                rectF.left = Math.max(max, rectF.left);
                rectF.top = Math.max(max2, rectF.top);
                rectF.right = Math.min(min, rectF.right);
                rectF.bottom = Math.min(min2, rectF.bottom);
            } else if (!this.f19663a || min <= max || min2 <= max2) {
                rectF.left = max + f4;
                rectF.top = max2 + f6;
                rectF.right = min - f4;
                rectF.bottom = min2 - f6;
            } else if (f3 / f5 > this.x) {
                rectF.top = max2 + f6;
                rectF.bottom = min2 - f6;
                float width = ((float) getWidth()) / 2.0f;
                this.x = ((float) this.v) / ((float) this.w);
                float max3 = Math.max(this.f19666d.b(), rectF.height() * this.x) / 2.0f;
                rectF.left = width - max3;
                rectF.right = width + max3;
            } else {
                rectF.left = max + f4;
                rectF.right = min - f4;
                float height = ((float) getHeight()) / 2.0f;
                float max4 = Math.max(this.f19666d.c(), rectF.width() / this.x) / 2.0f;
                rectF.top = height - max4;
                rectF.bottom = height + max4;
            }
            a(rectF);
            this.f19666d.a(rectF);
        }
    }

    private void a(RectF rectF) {
        if (rectF.width() < this.f19666d.b()) {
            float b2 = (this.f19666d.b() - rectF.width()) / 2.0f;
            rectF.left -= b2;
            rectF.right += b2;
        }
        if (rectF.height() < this.f19666d.c()) {
            float c2 = (this.f19666d.c() - rectF.height()) / 2.0f;
            rectF.top -= c2;
            rectF.bottom += c2;
        }
        if (rectF.width() > this.f19666d.d()) {
            float width = (rectF.width() - this.f19666d.d()) / 2.0f;
            rectF.left += width;
            rectF.right -= width;
        }
        if (rectF.height() > this.f19666d.e()) {
            float height = (rectF.height() - this.f19666d.e()) / 2.0f;
            rectF.top += height;
            rectF.bottom -= height;
        }
        b(rectF);
        if (this.m.width() > 0.0f && this.m.height() > 0.0f) {
            float max = Math.max(this.m.left, 0.0f);
            float max2 = Math.max(this.m.top, 0.0f);
            float min = Math.min(this.m.right, (float) getWidth());
            float min2 = Math.min(this.m.bottom, (float) getHeight());
            if (rectF.left < max) {
                rectF.left = max;
            }
            if (rectF.top < max2) {
                rectF.top = max2;
            }
            if (rectF.right > min) {
                rectF.right = min;
            }
            if (rectF.bottom > min2) {
                rectF.bottom = min2;
            }
        }
        if (this.f19663a && ((double) Math.abs(rectF.width() - (rectF.height() * this.x))) > 0.1d) {
            if (rectF.width() > rectF.height() * this.x) {
                float abs = Math.abs((rectF.height() * this.x) - rectF.width()) / 2.0f;
                rectF.left += abs;
                rectF.right -= abs;
                return;
            }
            float abs2 = Math.abs((rectF.width() / this.x) - rectF.height()) / 2.0f;
            rectF.top += abs2;
            rectF.bottom -= abs2;
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF a2 = this.f19666d.a();
        float f2 = 0.0f;
        float max = Math.max(c.a(this.l), 0.0f);
        float max2 = Math.max(c.b(this.l), 0.0f);
        float min = Math.min(c.c(this.l), (float) getWidth());
        float min2 = Math.min(c.d(this.l), (float) getHeight());
        if (this.z != PBCropImageView.b.RECTANGLE) {
            this.k.reset();
            if (Build.VERSION.SDK_INT > 17 || this.z != PBCropImageView.b.OVAL) {
                this.f19668f.set(a2.left, a2.top, a2.right, a2.bottom);
            } else {
                this.f19668f.set(a2.left + 2.0f, a2.top + 2.0f, a2.right - 2.0f, a2.bottom - 2.0f);
            }
            this.k.addOval(this.f19668f, Path.Direction.CW);
            canvas.save();
            canvas.clipPath(this.k, Region.Op.XOR);
            canvas.drawRect(max, max2, min, min2, this.j);
            canvas.restore();
        } else if (!d() || Build.VERSION.SDK_INT <= 17) {
            Canvas canvas2 = canvas;
            float f3 = max;
            float f4 = min;
            canvas2.drawRect(f3, max2, f4, a2.top, this.j);
            canvas2.drawRect(f3, a2.bottom, f4, min2, this.j);
            canvas2.drawRect(f3, a2.top, a2.left, a2.bottom, this.j);
            canvas.drawRect(a2.right, a2.top, min, a2.bottom, this.j);
        } else {
            this.k.reset();
            Path path = this.k;
            float[] fArr = this.l;
            path.moveTo(fArr[0], fArr[1]);
            Path path2 = this.k;
            float[] fArr2 = this.l;
            path2.lineTo(fArr2[2], fArr2[3]);
            Path path3 = this.k;
            float[] fArr3 = this.l;
            path3.lineTo(fArr3[4], fArr3[5]);
            Path path4 = this.k;
            float[] fArr4 = this.l;
            path4.lineTo(fArr4[6], fArr4[7]);
            this.k.close();
            canvas.save();
            canvas.clipPath(this.k, Region.Op.INTERSECT);
            canvas.clipRect(a2, Region.Op.XOR);
            canvas.drawRect(max, max2, min, min2, this.j);
            canvas.restore();
        }
        if (this.f19666d.f()) {
            if (this.y == PBCropImageView.c.ON) {
                a(canvas);
            } else if (this.y == PBCropImageView.c.ON_TOUCH && this.u != null) {
                a(canvas);
            }
        }
        Paint paint = this.f19669g;
        if (paint != null) {
            float strokeWidth = paint.getStrokeWidth();
            RectF a3 = this.f19666d.a();
            float f5 = strokeWidth / 2.0f;
            a3.inset(f5, f5);
            if (this.z == PBCropImageView.b.RECTANGLE) {
                canvas.drawRect(a3, this.f19669g);
            } else {
                canvas.drawOval(a3, this.f19669g);
            }
        }
        if (this.f19670h != null) {
            Paint paint2 = this.f19669g;
            float strokeWidth2 = paint2 != null ? paint2.getStrokeWidth() : 0.0f;
            float strokeWidth3 = this.f19670h.getStrokeWidth();
            float f6 = strokeWidth3 / 2.0f;
            if (this.z == PBCropImageView.b.RECTANGLE) {
                f2 = this.p;
            }
            float f7 = f2 + f6;
            RectF a4 = this.f19666d.a();
            a4.inset(f7, f7);
            float f8 = (strokeWidth3 - strokeWidth2) / 2.0f;
            float f9 = f6 + f8;
            Canvas canvas3 = canvas;
            canvas3.drawLine(a4.left - f8, a4.top - f9, a4.left - f8, a4.top + this.q, this.f19670h);
            canvas3.drawLine(a4.left - f9, a4.top - f8, a4.left + this.q, a4.top - f8, this.f19670h);
            canvas3.drawLine(a4.right + f8, a4.top - f9, a4.right + f8, a4.top + this.q, this.f19670h);
            canvas3.drawLine(a4.right + f9, a4.top - f8, a4.right - this.q, a4.top - f8, this.f19670h);
            canvas3.drawLine(a4.left - f8, a4.bottom + f9, a4.left - f8, a4.bottom - this.q, this.f19670h);
            canvas3.drawLine(a4.left - f9, a4.bottom + f8, a4.left + this.q, a4.bottom + f8, this.f19670h);
            canvas3.drawLine(a4.right + f8, a4.bottom + f9, a4.right + f8, a4.bottom - this.q, this.f19670h);
            canvas3.drawLine(a4.right + f9, a4.bottom + f8, a4.right - this.q, a4.bottom + f8, this.f19670h);
        }
    }

    private void a(Canvas canvas) {
        if (this.f19671i != null) {
            Paint paint = this.f19669g;
            float strokeWidth = paint != null ? paint.getStrokeWidth() : 0.0f;
            RectF a2 = this.f19666d.a();
            a2.inset(strokeWidth, strokeWidth);
            float width = a2.width() / 3.0f;
            float height = a2.height() / 3.0f;
            if (this.z == PBCropImageView.b.OVAL) {
                float width2 = (a2.width() / 2.0f) - strokeWidth;
                float height2 = (a2.height() / 2.0f) - strokeWidth;
                float f2 = a2.left + width;
                float f3 = a2.right - width;
                float sin = (float) (((double) height2) * Math.sin(Math.acos((double) ((width2 - width) / width2))));
                canvas.drawLine(f2, (a2.top + height2) - sin, f2, (a2.bottom - height2) + sin, this.f19671i);
                canvas.drawLine(f3, (a2.top + height2) - sin, f3, (a2.bottom - height2) + sin, this.f19671i);
                float f4 = a2.top + height;
                float f5 = a2.bottom - height;
                float cos = (float) (((double) width2) * Math.cos(Math.asin((double) ((height2 - height) / height2))));
                canvas.drawLine((a2.left + width2) - cos, f4, (a2.right - width2) + cos, f4, this.f19671i);
                canvas.drawLine((a2.left + width2) - cos, f5, (a2.right - width2) + cos, f5, this.f19671i);
                return;
            }
            float f6 = a2.left + width;
            float f7 = a2.right - width;
            Canvas canvas2 = canvas;
            canvas2.drawLine(f6, a2.top, f6, a2.bottom, this.f19671i);
            canvas.drawLine(f7, a2.top, f7, a2.bottom, this.f19671i);
            float f8 = a2.top + height;
            float f9 = a2.bottom - height;
            canvas2.drawLine(a2.left, f8, a2.right, f8, this.f19671i);
            canvas.drawLine(a2.left, f9, a2.right, f9, this.f19671i);
        }
    }

    private static Paint a(float f2, int i2) {
        if (f2 <= 0.0f) {
            return null;
        }
        Paint paint = new Paint();
        paint.setColor(i2);
        paint.setStrokeWidth(f2);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        return paint;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        f.a aVar;
        if (!isEnabled()) {
            return false;
        }
        if (this.f19665c) {
            this.f19664b.onTouchEvent(motionEvent);
        } else {
            MotionEvent motionEvent2 = motionEvent;
        }
        int action = motionEvent.getAction();
        f fVar = null;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float x2 = motionEvent.getX();
                    float y2 = motionEvent.getY();
                    if (this.u != null) {
                        float f2 = this.t;
                        RectF a2 = this.f19666d.a();
                        if (b(a2)) {
                            f2 = 0.0f;
                        }
                        f fVar2 = this.u;
                        RectF rectF = this.m;
                        int i2 = this.n;
                        int i3 = this.o;
                        boolean z2 = this.f19663a;
                        float f3 = this.x;
                        float f4 = x2 + fVar2.f19746b.x;
                        float f5 = fVar2.f19746b.y + y2;
                        if (fVar2.f19745a != f.a.CENTER) {
                            if (!z2) {
                                switch (f.AnonymousClass1.f19751a[fVar2.f19745a.ordinal()]) {
                                    case 1:
                                        f fVar3 = fVar2;
                                        RectF rectF2 = a2;
                                        RectF rectF3 = rectF;
                                        float f6 = f2;
                                        fVar3.b(rectF2, f5, rectF3, f6, 0.0f, false, false);
                                        fVar3.a(rectF2, f4, rectF3, f6, 0.0f, false, false);
                                        break;
                                    case 2:
                                        f fVar4 = fVar2;
                                        RectF rectF4 = a2;
                                        RectF rectF5 = rectF;
                                        fVar4.b(rectF4, f5, rectF5, f2, 0.0f, false, false);
                                        fVar4.a(rectF4, f4, rectF5, i2, f2, 0.0f, false, false);
                                        break;
                                    case 3:
                                        f fVar5 = fVar2;
                                        RectF rectF6 = a2;
                                        RectF rectF7 = rectF;
                                        fVar5.b(rectF6, f5, rectF7, i3, f2, 0.0f, false, false);
                                        fVar5.a(rectF6, f4, rectF7, f2, 0.0f, false, false);
                                        break;
                                    case 4:
                                        f fVar6 = fVar2;
                                        RectF rectF8 = a2;
                                        float f7 = f2;
                                        fVar6.b(rectF8, f5, rectF, i3, f7, 0.0f, false, false);
                                        fVar6.a(rectF8, f4, rectF, i2, f7, 0.0f, false, false);
                                        break;
                                    case 5:
                                        fVar2.a(a2, f4, rectF, f2, 0.0f, false, false);
                                        break;
                                    case 6:
                                        fVar2.b(a2, f5, rectF, f2, 0.0f, false, false);
                                        break;
                                    case 7:
                                        fVar2.a(a2, f4, rectF, i2, f2, 0.0f, false, false);
                                        break;
                                    case 8:
                                        fVar2.b(a2, f5, rectF, i3, f2, 0.0f, false, false);
                                        break;
                                }
                            } else {
                                switch (f.AnonymousClass1.f19751a[fVar2.f19745a.ordinal()]) {
                                    case 1:
                                        float f8 = f3;
                                        if (f.a(f4, f5, a2.right, a2.bottom) >= f8) {
                                            fVar2.a(a2, f4, rectF, f2, f8, true, false);
                                            f.b(a2, f8);
                                            break;
                                        } else {
                                            fVar2.b(a2, f5, rectF, f2, f8, true, false);
                                            f.a(a2, f8);
                                            break;
                                        }
                                    case 2:
                                        float f9 = f3;
                                        if (f.a(a2.left, f5, f4, a2.bottom) >= f9) {
                                            fVar2.a(a2, f4, rectF, i2, f2, f9, true, false);
                                            f.b(a2, f9);
                                            break;
                                        } else {
                                            fVar2.b(a2, f5, rectF, f2, f9, false, true);
                                            f.c(a2, f9);
                                            break;
                                        }
                                    case 3:
                                        float f10 = f3;
                                        if (f.a(f4, a2.top, a2.right, f5) >= f10) {
                                            fVar2.a(a2, f4, rectF, f2, f10, false, true);
                                            f.d(a2, f10);
                                            break;
                                        } else {
                                            fVar2.b(a2, f5, rectF, i3, f2, f10, true, false);
                                            f.a(a2, f10);
                                            break;
                                        }
                                    case 4:
                                        float f11 = f3;
                                        if (f.a(a2.left, a2.top, f4, f5) >= f11) {
                                            fVar2.a(a2, f4, rectF, i2, f2, f11, false, true);
                                            f.d(a2, f11);
                                            break;
                                        } else {
                                            fVar2.b(a2, f5, rectF, i3, f2, f11, false, true);
                                            f.c(a2, f11);
                                            break;
                                        }
                                    case 5:
                                        float f12 = f3;
                                        fVar2.a(a2, f4, rectF, f2, f12, true, true);
                                        f.c(a2, rectF, f12);
                                        break;
                                    case 6:
                                        float f13 = f3;
                                        RectF rectF9 = rectF;
                                        fVar2.b(a2, f5, rectF9, f2, f13, true, true);
                                        f.b(a2, rectF9, f13);
                                        break;
                                    case 7:
                                        fVar2.a(a2, f4, rectF, i2, f2, f3, true, true);
                                        f.c(a2, rectF, f3);
                                        break;
                                    case 8:
                                        fVar2.b(a2, f5, rectF, i3, f2, f3, true, true);
                                        f.b(a2, rectF, f3);
                                        break;
                                }
                            }
                        } else {
                            float centerX = f4 - a2.centerX();
                            float centerY = f5 - a2.centerY();
                            if (a2.left + centerX < 0.0f || a2.right + centerX > ((float) i2) || a2.left + centerX < rectF.left || a2.right + centerX > rectF.right) {
                                centerX /= 1.05f;
                                fVar2.f19746b.x -= centerX / 2.0f;
                            }
                            if (a2.top + centerY < 0.0f || a2.bottom + centerY > ((float) i3) || a2.top + centerY < rectF.top || a2.bottom + centerY > rectF.bottom) {
                                centerY /= 1.05f;
                                fVar2.f19746b.y -= centerY / 2.0f;
                            }
                            a2.offset(centerX, centerY);
                            f.a(a2, rectF, f2);
                        }
                        this.f19666d.a(a2);
                        b(true);
                        invalidate();
                    }
                    getParent().requestDisallowInterceptTouchEvent(true);
                    return true;
                } else if (action != 3) {
                    return false;
                }
            }
            getParent().requestDisallowInterceptTouchEvent(false);
            if (this.u != null) {
                this.u = null;
                b(false);
                invalidate();
            }
            return true;
        }
        float x3 = motionEvent.getX();
        float y3 = motionEvent.getY();
        e eVar = this.f19666d;
        float f14 = this.s;
        if (this.z == PBCropImageView.b.OVAL) {
            float width = eVar.f19735a.width() / 6.0f;
            float f15 = eVar.f19735a.left + width;
            float f16 = eVar.f19735a.left + (width * 5.0f);
            float height = eVar.f19735a.height() / 6.0f;
            float f17 = eVar.f19735a.top + height;
            float f18 = eVar.f19735a.top + (height * 5.0f);
            if (x3 < f15) {
                if (y3 < f17) {
                    aVar = f.a.TOP_LEFT;
                } else if (y3 < f18) {
                    aVar = f.a.LEFT;
                } else {
                    aVar = f.a.BOTTOM_LEFT;
                }
            } else if (x3 < f16) {
                if (y3 < f17) {
                    aVar = f.a.TOP;
                } else if (y3 < f18) {
                    aVar = f.a.CENTER;
                } else {
                    aVar = f.a.BOTTOM;
                }
            } else if (y3 < f17) {
                aVar = f.a.TOP_RIGHT;
            } else if (y3 < f18) {
                aVar = f.a.RIGHT;
            } else {
                aVar = f.a.BOTTOM_RIGHT;
            }
        } else if (e.a(x3, y3, eVar.f19735a.left, eVar.f19735a.top, f14)) {
            aVar = f.a.TOP_LEFT;
        } else if (e.a(x3, y3, eVar.f19735a.right, eVar.f19735a.top, f14)) {
            aVar = f.a.TOP_RIGHT;
        } else if (e.a(x3, y3, eVar.f19735a.left, eVar.f19735a.bottom, f14)) {
            aVar = f.a.BOTTOM_LEFT;
        } else if (e.a(x3, y3, eVar.f19735a.right, eVar.f19735a.bottom, f14)) {
            aVar = f.a.BOTTOM_RIGHT;
        } else {
            if (!e.c(x3, y3, eVar.f19735a.left, eVar.f19735a.top, eVar.f19735a.right, eVar.f19735a.bottom) || !eVar.g()) {
                if (e.a(x3, y3, eVar.f19735a.left, eVar.f19735a.right, eVar.f19735a.top, f14)) {
                    aVar = f.a.TOP;
                } else {
                    if (e.a(x3, y3, eVar.f19735a.left, eVar.f19735a.right, eVar.f19735a.bottom, f14)) {
                        aVar = f.a.BOTTOM;
                    } else {
                        if (e.b(x3, y3, eVar.f19735a.left, eVar.f19735a.top, eVar.f19735a.bottom, f14)) {
                            aVar = f.a.LEFT;
                        } else {
                            if (e.b(x3, y3, eVar.f19735a.right, eVar.f19735a.top, eVar.f19735a.bottom, f14)) {
                                aVar = f.a.RIGHT;
                            } else {
                                if (!e.c(x3, y3, eVar.f19735a.left, eVar.f19735a.top, eVar.f19735a.right, eVar.f19735a.bottom) || eVar.g()) {
                                    aVar = null;
                                } else {
                                    aVar = f.a.CENTER;
                                }
                            }
                        }
                    }
                }
            } else {
                aVar = f.a.CENTER;
            }
        }
        if (aVar != null) {
            fVar = new f(aVar, eVar, x3, y3);
        }
        this.u = fVar;
        if (this.u != null) {
            invalidate();
        }
        return true;
    }

    private boolean b(RectF rectF) {
        RectF rectF2 = rectF;
        float a2 = c.a(this.l);
        float b2 = c.b(this.l);
        float c2 = c.c(this.l);
        float d2 = c.d(this.l);
        if (!d()) {
            this.m.set(a2, b2, c2, d2);
            return false;
        }
        float[] fArr = this.l;
        float f2 = fArr[0];
        float f3 = fArr[1];
        float f4 = fArr[4];
        float f5 = fArr[5];
        float f6 = fArr[6];
        float f7 = fArr[7];
        if (fArr[7] < fArr[1]) {
            if (fArr[1] < fArr[3]) {
                f2 = fArr[6];
                f3 = fArr[7];
                f4 = fArr[2];
                f5 = fArr[3];
                f6 = fArr[4];
                f7 = fArr[5];
            } else {
                f2 = fArr[4];
                f3 = fArr[5];
                f4 = fArr[0];
                f5 = fArr[1];
                f6 = fArr[2];
                f7 = fArr[3];
            }
        } else if (fArr[1] > fArr[3]) {
            f2 = fArr[2];
            f3 = fArr[3];
            f4 = fArr[6];
            f5 = fArr[7];
            f6 = fArr[0];
            f7 = fArr[1];
        }
        float f8 = (f7 - f3) / (f6 - f2);
        float f9 = -1.0f / f8;
        float f10 = f3 - (f8 * f2);
        float f11 = f3 - (f2 * f9);
        float f12 = f5 - (f8 * f4);
        float f13 = f5 - (f4 * f9);
        float centerY = (rectF.centerY() - rectF2.top) / (rectF.centerX() - rectF2.left);
        float f14 = -centerY;
        float f15 = rectF2.top - (rectF2.left * centerY);
        float f16 = rectF2.top - (rectF2.right * f14);
        float f17 = f8 - centerY;
        float f18 = (f15 - f10) / f17;
        if (f18 >= rectF2.right) {
            f18 = a2;
        }
        float max = Math.max(a2, f18);
        float f19 = (f15 - f11) / (f9 - centerY);
        if (f19 >= rectF2.right) {
            f19 = max;
        }
        float max2 = Math.max(max, f19);
        float f20 = f9 - f14;
        float f21 = (f16 - f13) / f20;
        if (f21 >= rectF2.right) {
            f21 = max2;
        }
        float max3 = Math.max(max2, f21);
        float f22 = (f16 - f11) / f20;
        if (f22 <= rectF2.left) {
            f22 = c2;
        }
        float min = Math.min(c2, f22);
        float f23 = (f16 - f12) / (f8 - f14);
        if (f23 <= rectF2.left) {
            f23 = min;
        }
        float min2 = Math.min(min, f23);
        float f24 = (f15 - f12) / f17;
        if (f24 <= rectF2.left) {
            f24 = min2;
        }
        float min3 = Math.min(min2, f24);
        float max4 = Math.max(b2, Math.max((f8 * max3) + f10, (f9 * min3) + f11));
        float min4 = Math.min(d2, Math.min((f9 * max3) + f13, (f8 * min3) + f12));
        RectF rectF3 = this.m;
        rectF3.left = max3;
        rectF3.top = max4;
        rectF3.right = min3;
        rectF3.bottom = min4;
        return true;
    }

    private boolean d() {
        float[] fArr = this.l;
        return (fArr[0] == fArr[6] || fArr[1] == fArr[7]) ? false : true;
    }

    private void b(boolean z2) {
        try {
            if (this.f19667e != null) {
                this.f19667e.onCropWindowChanged(z2);
            }
        } catch (Exception unused) {
        }
    }

    class b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private b() {
        }

        /* synthetic */ b(CropOverlayView cropOverlayView, byte b2) {
            this();
        }

        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            RectF a2 = CropOverlayView.this.f19666d.a();
            float focusX = scaleGestureDetector.getFocusX();
            float focusY = scaleGestureDetector.getFocusY();
            float currentSpanY = scaleGestureDetector.getCurrentSpanY() / 2.0f;
            float currentSpanX = scaleGestureDetector.getCurrentSpanX() / 2.0f;
            float f2 = focusY - currentSpanY;
            float f3 = focusX - currentSpanX;
            float f4 = focusX + currentSpanX;
            float f5 = focusY + currentSpanY;
            if (f3 >= f4 || f2 > f5 || f3 < 0.0f || f4 > CropOverlayView.this.f19666d.d() || f2 < 0.0f || f5 > CropOverlayView.this.f19666d.e()) {
                return true;
            }
            a2.set(f3, f2, f4, f5);
            CropOverlayView.this.f19666d.a(a2);
            CropOverlayView.this.invalidate();
            return true;
        }
    }
}
