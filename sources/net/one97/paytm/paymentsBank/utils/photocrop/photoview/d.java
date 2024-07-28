package net.one97.paytm.paymentsBank.utils.photocrop.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

public final class d implements View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener, net.one97.paytm.paymentsBank.utils.photocrop.photoview.a.e, c {

    /* renamed from: a  reason: collision with root package name */
    static final Interpolator f19560a = new AccelerateDecelerateInterpolator();
    /* access modifiers changed from: private */
    public static final boolean o = Log.isLoggable("PhotoViewAttacher", 3);
    private int A = 2;
    private boolean B;
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public final Matrix f19561b = new Matrix();

    /* renamed from: c  reason: collision with root package name */
    int f19562c = 200;

    /* renamed from: d  reason: collision with root package name */
    c f19563d;

    /* renamed from: e  reason: collision with root package name */
    float f19564e = 1.0f;

    /* renamed from: f  reason: collision with root package name */
    float f19565f = 1.75f;

    /* renamed from: g  reason: collision with root package name */
    float f19566g = 3.0f;

    /* renamed from: h  reason: collision with root package name */
    boolean f19567h = true;

    /* renamed from: i  reason: collision with root package name */
    GestureDetector f19568i;
    C0348d j;
    e k;
    f l;
    /* access modifiers changed from: package-private */
    public View.OnLongClickListener m;
    ImageView.ScaleType n = ImageView.ScaleType.FIT_CENTER;
    private final Matrix p = new Matrix();
    private final Matrix q = new Matrix();
    private final RectF r = new RectF();
    private final float[] s = new float[9];
    private WeakReference<ImageView> t;
    private net.one97.paytm.paymentsBank.utils.photocrop.photoview.a.d u;
    private int v;
    private int w;
    private int x;
    private int y;
    private b z;

    public interface c {
        Rect getImageBounds();
    }

    /* renamed from: net.one97.paytm.paymentsBank.utils.photocrop.photoview.d$d  reason: collision with other inner class name */
    public interface C0348d {
    }

    public interface e {
    }

    public interface f {
    }

    public d(ImageView imageView) {
        net.one97.paytm.paymentsBank.utils.photocrop.photoview.a.d dVar;
        this.t = new WeakReference<>(imageView);
        imageView.setDrawingCacheEnabled(true);
        imageView.setOnTouchListener(this);
        imageView.getViewTreeObserver();
        a(imageView);
        if (!imageView.isInEditMode()) {
            Context context = imageView.getContext();
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 5) {
                dVar = new net.one97.paytm.paymentsBank.utils.photocrop.photoview.a.a(context);
            } else if (i2 < 8) {
                dVar = new net.one97.paytm.paymentsBank.utils.photocrop.photoview.a.b(context);
            } else {
                dVar = new net.one97.paytm.paymentsBank.utils.photocrop.photoview.a.c(context);
            }
            dVar.a(this);
            this.u = dVar;
            this.f19568i = new GestureDetector(imageView.getContext(), new GestureDetector.SimpleOnGestureListener() {
                public final void onLongPress(MotionEvent motionEvent) {
                    if (d.this.m != null) {
                        d.this.m.onLongClick(d.this.c());
                    }
                }
            });
            this.f19568i.setOnDoubleTapListener(new b(this));
            a(true);
        }
    }

    /* renamed from: net.one97.paytm.paymentsBank.utils.photocrop.photoview.d$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f19570a = new int[ImageView.ScaleType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                android.widget.ImageView$ScaleType[] r0 = android.widget.ImageView.ScaleType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f19570a = r0
                int[] r0 = f19570a     // Catch:{ NoSuchFieldError -> 0x0014 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.MATRIX     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f19570a     // Catch:{ NoSuchFieldError -> 0x001f }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_START     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f19570a     // Catch:{ NoSuchFieldError -> 0x002a }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_END     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f19570a     // Catch:{ NoSuchFieldError -> 0x0035 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = f19570a     // Catch:{ NoSuchFieldError -> 0x0040 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.utils.photocrop.photoview.d.AnonymousClass2.<clinit>():void");
        }
    }

    static boolean a(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            return false;
        }
        if (AnonymousClass2.f19570a[scaleType.ordinal()] != 1) {
            return true;
        }
        throw new IllegalArgumentException(scaleType.name() + " is not supported in PhotoView");
    }

    private static void a(ImageView imageView) {
        if (imageView != null && !(imageView instanceof c) && !ImageView.ScaleType.MATRIX.equals(imageView.getScaleType())) {
            imageView.setScaleType(ImageView.ScaleType.MATRIX);
        }
    }

    public final void a() {
        WeakReference<ImageView> weakReference = this.t;
        if (weakReference != null) {
            ImageView imageView = (ImageView) weakReference.get();
            if (imageView != null) {
                ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                imageView.setOnTouchListener((View.OnTouchListener) null);
                j();
            }
            GestureDetector gestureDetector = this.f19568i;
            if (gestureDetector != null) {
                gestureDetector.setOnDoubleTapListener((GestureDetector.OnDoubleTapListener) null);
            }
            this.j = null;
            this.k = null;
            this.l = null;
            this.t = null;
        }
    }

    public final RectF b() {
        m();
        return a(g());
    }

    public final void a(float f2) {
        this.f19561b.setRotate(f2 % 360.0f);
        h();
    }

    public final ImageView c() {
        WeakReference<ImageView> weakReference = this.t;
        ImageView imageView = weakReference != null ? (ImageView) weakReference.get() : null;
        if (imageView == null) {
            a();
        }
        return imageView;
    }

    public final float d() {
        return (float) Math.sqrt((double) (((float) Math.pow((double) a(this.f19561b, 0), 2.0d)) + ((float) Math.pow((double) a(this.f19561b, 3), 2.0d))));
    }

    public final void a(float f2, float f3) {
        if (!this.u.a()) {
            ImageView c2 = c();
            this.f19561b.postTranslate(f2, f3);
            h();
            ViewParent parent = c2.getParent();
            if (this.f19567h && !this.u.a()) {
                int i2 = this.A;
                if ((i2 == 2 || ((i2 == 0 && f2 >= 1.0f) || (this.A == 1 && f2 <= -1.0f))) && parent != null) {
                    parent.requestDisallowInterceptTouchEvent(false);
                }
            } else if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    public final void e() {
        ImageView c2 = c();
        this.z = new b(c2.getContext());
        b bVar = this.z;
        b(c2);
        c(c2);
        RectF b2 = d.this.b();
        if (b2 != null) {
            int round = Math.round(-b2.left);
            int round2 = Math.round(-b2.top);
            bVar.f19577a = round;
            bVar.f19578b = round2;
        }
        c2.post(this.z);
    }

    public final void onGlobalLayout() {
        ImageView c2 = c();
        if (c2 == null) {
            return;
        }
        if (this.B) {
            int top = c2.getTop();
            int right = c2.getRight();
            int bottom = c2.getBottom();
            int left = c2.getLeft();
            if (top != this.v || bottom != this.x || left != this.y || right != this.w) {
                a(c2.getDrawable());
                this.v = top;
                this.w = right;
                this.x = bottom;
                this.y = left;
                return;
            }
            return;
        }
        a(c2.getDrawable());
    }

    public final void a(float f2, float f3, float f4) {
        if (d() < this.f19566g || f2 < 1.0f) {
            this.f19561b.postScale(f2, f2, f3, f4);
            h();
        }
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        RectF b2;
        boolean z2 = false;
        if (!this.B) {
            return false;
        }
        ImageView imageView = (ImageView) view;
        if (!((imageView == null || imageView.getDrawable() == null) ? false : true)) {
            return false;
        }
        ViewParent parent = view.getParent();
        int action = motionEvent.getAction();
        if (action == 0) {
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            j();
        } else if ((action == 1 || action == 3) && d() < this.f19564e && (b2 = b()) != null) {
            view.post(new a(d(), this.f19564e, b2.centerX(), b2.centerY()));
            z2 = true;
        }
        net.one97.paytm.paymentsBank.utils.photocrop.photoview.a.d dVar = this.u;
        if (dVar != null && dVar.c(motionEvent)) {
            z2 = true;
        }
        GestureDetector gestureDetector = this.f19568i;
        if (gestureDetector == null || !gestureDetector.onTouchEvent(motionEvent)) {
            return z2;
        }
        return true;
    }

    public final void a(float f2, boolean z2) {
        ImageView c2 = c();
        if (c2 != null) {
            a(f2, (float) (c2.getRight() / 2), (float) (c2.getBottom() / 2), z2);
        }
    }

    public final void a(float f2, float f3, float f4, boolean z2) {
        ImageView c2 = c();
        if (c2 != null && f2 >= this.f19564e && f2 <= this.f19566g) {
            if (z2) {
                c2.post(new a(d(), f2, f3, f4));
                return;
            }
            this.f19561b.setScale(f2, f2, f3, f4);
            h();
        }
    }

    public final void a(boolean z2) {
        this.B = z2;
        f();
    }

    public final void f() {
        ImageView c2 = c();
        if (c2 == null) {
            return;
        }
        if (this.B) {
            a(c2);
            a(c2.getDrawable());
            return;
        }
        n();
    }

    public final Matrix g() {
        this.q.set(this.p);
        this.q.postConcat(this.f19561b);
        return this.q;
    }

    private void j() {
        b bVar = this.z;
        if (bVar != null) {
            bVar.a();
            this.z = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void h() {
        if (m()) {
            b(g());
        }
    }

    private void k() {
        ImageView c2 = c();
        if (c2 != null && !(c2 instanceof c) && !ImageView.ScaleType.MATRIX.equals(c2.getScaleType())) {
            throw new IllegalStateException("The ImageView's ScaleType has been changed since attaching a PhotoViewAttacher");
        }
    }

    private Rect l() {
        if (c() == null) {
            return null;
        }
        c cVar = this.f19563d;
        if (cVar != null) {
            return cVar.getImageBounds();
        }
        return new Rect(b(c()), 0, 0, c(c()));
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0092  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m() {
        /*
            r11 = this;
            android.widget.ImageView r0 = r11.c()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            android.graphics.Matrix r2 = r11.g()
            android.graphics.RectF r2 = r11.a((android.graphics.Matrix) r2)
            if (r2 != 0) goto L_0x0013
            return r1
        L_0x0013:
            float r3 = r2.height()
            float r4 = r2.width()
            android.graphics.Rect r5 = r11.l()
            int r6 = r5.height()
            c((android.widget.ImageView) r0)
            float r0 = (float) r6
            r6 = 3
            r7 = 2
            r8 = 0
            int r9 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r9 > 0) goto L_0x0045
            int[] r9 = net.one97.paytm.paymentsBank.utils.photocrop.photoview.d.AnonymousClass2.f19570a
            android.widget.ImageView$ScaleType r10 = r11.n
            int r10 = r10.ordinal()
            r9 = r9[r10]
            if (r9 == r7) goto L_0x0042
            if (r9 == r6) goto L_0x003d
            goto L_0x0065
        L_0x003d:
            float r0 = r0 - r3
            float r3 = r2.top
        L_0x0040:
            float r0 = r0 - r3
            goto L_0x0066
        L_0x0042:
            float r0 = r2.top
            goto L_0x0054
        L_0x0045:
            float r0 = r2.top
            int r3 = r5.top
            float r3 = (float) r3
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x0056
            float r0 = r2.top
            int r3 = r5.top
            float r3 = (float) r3
            float r0 = r0 - r3
        L_0x0054:
            float r0 = -r0
            goto L_0x0066
        L_0x0056:
            float r0 = r2.bottom
            int r3 = r5.bottom
            float r3 = (float) r3
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0065
            int r0 = r5.bottom
            float r0 = (float) r0
            float r3 = r2.bottom
            goto L_0x0040
        L_0x0065:
            r0 = 0
        L_0x0066:
            int r3 = r5.width()
            float r3 = (float) r3
            r9 = 1
            int r10 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r10 > 0) goto L_0x0092
            int[] r1 = net.one97.paytm.paymentsBank.utils.photocrop.photoview.d.AnonymousClass2.f19570a
            android.widget.ImageView$ScaleType r5 = r11.n
            int r5 = r5.ordinal()
            r1 = r1[r5]
            if (r1 == r7) goto L_0x008b
            if (r1 == r6) goto L_0x0087
            float r3 = r3 - r4
            r1 = 1073741824(0x40000000, float:2.0)
            float r3 = r3 / r1
            float r1 = r2.left
        L_0x0084:
            float r3 = r3 - r1
            r8 = r3
            goto L_0x008f
        L_0x0087:
            float r3 = r3 - r4
            float r1 = r2.left
            goto L_0x0084
        L_0x008b:
            float r1 = r2.left
            float r1 = -r1
            r8 = r1
        L_0x008f:
            r11.A = r7
            goto L_0x00bb
        L_0x0092:
            float r3 = r2.left
            int r4 = r5.left
            float r4 = (float) r4
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 <= 0) goto L_0x00a5
            r11.A = r1
            float r1 = r2.left
            int r2 = r5.left
            float r2 = (float) r2
            float r1 = r1 - r2
            float r8 = -r1
            goto L_0x00bb
        L_0x00a5:
            float r1 = r2.right
            int r3 = r5.right
            float r3 = (float) r3
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x00b8
            int r1 = r5.right
            float r1 = (float) r1
            float r2 = r2.right
            float r8 = r1 - r2
            r11.A = r9
            goto L_0x00bb
        L_0x00b8:
            r1 = -1
            r11.A = r1
        L_0x00bb:
            android.graphics.Matrix r1 = r11.f19561b
            r1.postTranslate(r8, r0)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.utils.photocrop.photoview.d.m():boolean");
    }

    private RectF a(Matrix matrix) {
        Drawable drawable;
        ImageView c2 = c();
        if (c2 == null || (drawable = c2.getDrawable()) == null) {
            return null;
        }
        this.r.set(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
        matrix.mapRect(this.r);
        return this.r;
    }

    private float a(Matrix matrix, int i2) {
        matrix.getValues(this.s);
        return this.s[i2];
    }

    private void n() {
        this.f19561b.reset();
        b(g());
        m();
    }

    /* access modifiers changed from: private */
    public void b(Matrix matrix) {
        ImageView c2 = c();
        if (c2 != null) {
            k();
            c2.setImageMatrix(matrix);
            if (this.j != null) {
                a(matrix);
            }
        }
    }

    private void a(Drawable drawable) {
        ImageView c2 = c();
        if (c2 != null && drawable != null) {
            float b2 = (float) b(c2);
            float c3 = (float) c(c2);
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.p.reset();
            float f2 = (float) intrinsicWidth;
            float f3 = b2 / f2;
            float f4 = (float) intrinsicHeight;
            float f5 = c3 / f4;
            if (this.n == ImageView.ScaleType.CENTER) {
                this.p.postTranslate((b2 - f2) / 2.0f, (c3 - f4) / 2.0f);
            } else if (this.n == ImageView.ScaleType.CENTER_CROP) {
                float max = Math.max(f3, f5);
                this.p.postScale(max, max);
                this.p.postTranslate((b2 - (f2 * max)) / 2.0f, (c3 - (f4 * max)) / 2.0f);
            } else if (this.n == ImageView.ScaleType.CENTER_INSIDE) {
                float min = Math.min(1.0f, Math.min(f3, f5));
                this.p.postScale(min, min);
                this.p.postTranslate((b2 - (f2 * min)) / 2.0f, (c3 - (f4 * min)) / 2.0f);
            } else {
                RectF rectF = new RectF(0.0f, 0.0f, f2, f4);
                RectF rectF2 = new RectF(0.0f, 0.0f, b2, c3);
                int i2 = AnonymousClass2.f19570a[this.n.ordinal()];
                if (i2 == 2) {
                    this.p.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                } else if (i2 == 3) {
                    this.p.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                } else if (i2 == 4) {
                    this.p.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
                } else if (i2 == 5) {
                    this.p.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
                }
            }
            n();
        }
    }

    private static int b(ImageView imageView) {
        if (imageView == null) {
            return 0;
        }
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    private static int c(ImageView imageView) {
        if (imageView == null) {
            return 0;
        }
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final float f19572b;

        /* renamed from: c  reason: collision with root package name */
        private final float f19573c;

        /* renamed from: d  reason: collision with root package name */
        private final long f19574d = System.currentTimeMillis();

        /* renamed from: e  reason: collision with root package name */
        private final float f19575e;

        /* renamed from: f  reason: collision with root package name */
        private final float f19576f;

        public a(float f2, float f3, float f4, float f5) {
            this.f19572b = f4;
            this.f19573c = f5;
            this.f19575e = f2;
            this.f19576f = f3;
        }

        public final void run() {
            ImageView c2 = d.this.c();
            if (c2 != null) {
                float interpolation = d.f19560a.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.f19574d)) * 1.0f) / ((float) d.this.f19562c)));
                float f2 = this.f19575e;
                float d2 = (f2 + ((this.f19576f - f2) * interpolation)) / d.this.d();
                d.this.f19561b.postScale(d2, d2, this.f19572b, this.f19573c);
                d.this.h();
                if (interpolation < 1.0f) {
                    a.a(c2, this);
                }
            }
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        int f19577a;

        /* renamed from: b  reason: collision with root package name */
        int f19578b;

        /* renamed from: d  reason: collision with root package name */
        private final net.one97.paytm.paymentsBank.utils.photocrop.photoview.b.d f19580d;

        public b(Context context) {
            net.one97.paytm.paymentsBank.utils.photocrop.photoview.b.d dVar;
            if (Build.VERSION.SDK_INT < 9) {
                dVar = new net.one97.paytm.paymentsBank.utils.photocrop.photoview.b.c(context);
            } else if (Build.VERSION.SDK_INT < 14) {
                dVar = new net.one97.paytm.paymentsBank.utils.photocrop.photoview.b.a(context);
            } else {
                dVar = new net.one97.paytm.paymentsBank.utils.photocrop.photoview.b.b(context);
            }
            this.f19580d = dVar;
        }

        public final void a() {
            boolean unused = d.o;
            this.f19580d.b();
        }

        public final void run() {
            ImageView c2;
            if (!this.f19580d.c() && (c2 = d.this.c()) != null && this.f19580d.a()) {
                int d2 = this.f19580d.d();
                int e2 = this.f19580d.e();
                boolean unused = d.o;
                d.this.f19561b.postTranslate((float) (this.f19577a - d2), (float) (this.f19578b - e2));
                d dVar = d.this;
                dVar.b(dVar.g());
                this.f19577a = d2;
                this.f19578b = e2;
                a.a(c2, this);
            }
        }
    }
}
