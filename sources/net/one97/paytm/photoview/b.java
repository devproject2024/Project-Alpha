package net.one97.paytm.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import java.lang.ref.WeakReference;
import net.one97.paytm.photoview.a.f;
import net.one97.paytm.photoview.b.a;
import net.one97.paytm.photoview.b.c;
import net.one97.paytm.photoview.b.d;

public final class b implements GestureDetector.OnDoubleTapListener, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener, net.one97.paytm.photoview.a.e {

    /* renamed from: a  reason: collision with root package name */
    static final Interpolator f59674a = new AccelerateDecelerateInterpolator();
    private boolean A;

    /* renamed from: b  reason: collision with root package name */
    float f59675b = 1.0f;

    /* renamed from: c  reason: collision with root package name */
    float f59676c = 1.75f;

    /* renamed from: d  reason: collision with root package name */
    float f59677d = 3.0f;

    /* renamed from: e  reason: collision with root package name */
    boolean f59678e = true;
    /* access modifiers changed from: package-private */

    /* renamed from: f  reason: collision with root package name */
    public final Matrix f59679f = new Matrix();

    /* renamed from: g  reason: collision with root package name */
    c f59680g;

    /* renamed from: h  reason: collision with root package name */
    d f59681h;

    /* renamed from: i  reason: collision with root package name */
    e f59682i;
    /* access modifiers changed from: package-private */
    public View.OnLongClickListener j;
    f k;
    ImageView.ScaleType l = ImageView.ScaleType.FIT_CENTER;
    float m = 0.0f;
    private WeakReference<ImageView> n;
    private GestureDetector o;
    private net.one97.paytm.photoview.a.d p;
    private final Matrix q = new Matrix();
    private final Matrix r = new Matrix();
    private final RectF s = new RectF();
    private final float[] t = new float[9];
    private int u;
    private int v;
    private int w;
    private int x;
    private C1152b y;
    private int z = 2;

    public interface c {
    }

    public interface d {
        void a();
    }

    public interface e {
    }

    public final boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    static void a(float f2, float f3, float f4) {
        if (f2 >= f3) {
            throw new IllegalArgumentException("MinZoom has to be less than MidZoom");
        } else if (f3 >= f4) {
            throw new IllegalArgumentException("MidZoom has to be less than MaxZoom");
        }
    }

    /* renamed from: net.one97.paytm.photoview.b$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f59684a = new int[ImageView.ScaleType.values().length];

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
                f59684a = r0
                int[] r0 = f59684a     // Catch:{ NoSuchFieldError -> 0x0014 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.MATRIX     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f59684a     // Catch:{ NoSuchFieldError -> 0x001f }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_START     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f59684a     // Catch:{ NoSuchFieldError -> 0x002a }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_END     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f59684a     // Catch:{ NoSuchFieldError -> 0x0035 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = f59684a     // Catch:{ NoSuchFieldError -> 0x0040 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.photoview.b.AnonymousClass2.<clinit>():void");
        }
    }

    static boolean a(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            return false;
        }
        if (AnonymousClass2.f59684a[scaleType.ordinal()] != 1) {
            return true;
        }
        throw new IllegalArgumentException(scaleType.name() + " is not supported in PhotoView");
    }

    private static void a(ImageView imageView) {
        if (imageView != null && !(imageView instanceof PhotoView) && !ImageView.ScaleType.MATRIX.equals(imageView.getScaleType())) {
            imageView.setScaleType(ImageView.ScaleType.MATRIX);
        }
    }

    public b(ImageView imageView) {
        net.one97.paytm.photoview.a.d dVar;
        this.n = new WeakReference<>(imageView);
        imageView.setOnTouchListener(this);
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        a(imageView);
        if (!imageView.isInEditMode()) {
            Context context = imageView.getContext();
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 5) {
                dVar = new net.one97.paytm.photoview.a.a(context);
            } else if (i2 < 8) {
                dVar = new net.one97.paytm.photoview.a.b(context);
            } else {
                dVar = new net.one97.paytm.photoview.a.c(context);
            }
            dVar.a(this);
            this.p = dVar;
            this.o = new GestureDetector(imageView.getContext(), new GestureDetector.SimpleOnGestureListener() {
                public final void onLongPress(MotionEvent motionEvent) {
                    if (b.this.j != null) {
                        b.this.j.onLongClick(b.this.c());
                    }
                }
            });
            this.o.setOnDoubleTapListener(this);
            a(true);
        }
    }

    public final void a() {
        WeakReference<ImageView> weakReference = this.n;
        if (weakReference != null) {
            ImageView imageView = (ImageView) weakReference.get();
            if (imageView != null) {
                ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                imageView.setOnTouchListener((View.OnTouchListener) null);
                h();
            }
            GestureDetector gestureDetector = this.o;
            if (gestureDetector != null) {
                gestureDetector.setOnDoubleTapListener((GestureDetector.OnDoubleTapListener) null);
            }
            this.f59680g = null;
            this.f59681h = null;
            this.f59682i = null;
            this.n = null;
        }
    }

    public final RectF b() {
        j();
        return a(f());
    }

    public final ImageView c() {
        WeakReference<ImageView> weakReference = this.n;
        ImageView imageView = weakReference != null ? (ImageView) weakReference.get() : null;
        if (imageView == null) {
            a();
        }
        return imageView;
    }

    public final float d() {
        return (float) Math.sqrt((double) (((float) Math.pow((double) a(this.f59679f, 0), 2.0d)) + ((float) Math.pow((double) a(this.f59679f, 3), 2.0d))));
    }

    public final boolean onDoubleTap(MotionEvent motionEvent) {
        try {
            float d2 = d();
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            if (d2 < this.f59676c) {
                a(this.f59676c, x2, y2, true);
            } else if (d2 < this.f59676c || d2 >= this.f59677d) {
                a(this.f59675b, x2, y2, true);
            } else {
                a(this.f59677d, x2, y2, true);
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
        }
        return true;
    }

    public final void a(float f2, float f3) {
        ViewParent parent;
        ImageView c2 = c();
        this.f59679f.postTranslate(f2, f3);
        g();
        if (this.f59678e && !this.p.a()) {
            int i2 = this.z;
            if ((i2 == 2 || ((i2 == 0 && f2 >= 1.0f) || (this.z == 1 && f2 <= -1.0f))) && (parent = c2.getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(false);
            }
        }
    }

    public final void b(float f2, float f3) {
        int i2;
        int i3;
        int i4;
        int i5;
        ImageView c2 = c();
        this.y = new C1152b(c2.getContext());
        C1152b bVar = this.y;
        int b2 = b(c2);
        int c3 = c(c2);
        int i6 = (int) f2;
        int i7 = (int) f3;
        RectF b3 = b.this.b();
        if (b3 != null) {
            int round = Math.round(-b3.left);
            float f4 = (float) b2;
            if (f4 < b3.width()) {
                i2 = Math.round(b3.width() - f4);
                i3 = 0;
            } else {
                i3 = round;
                i2 = i3;
            }
            int round2 = Math.round(-b3.top);
            float f5 = (float) c3;
            if (f5 < b3.height()) {
                i4 = Math.round(b3.height() - f5);
                i5 = 0;
            } else {
                i5 = round2;
                i4 = i5;
            }
            bVar.f59694b = round;
            bVar.f59695c = round2;
            if (!(round == i2 && round2 == i4)) {
                bVar.f59693a.a(round, round2, i6, i7, i3, i2, i5, i4);
            }
        }
        c2.post(this.y);
    }

    public final void onGlobalLayout() {
        ImageView c2 = c();
        if (c2 != null && this.A) {
            int top = c2.getTop();
            int right = c2.getRight();
            int bottom = c2.getBottom();
            int left = c2.getLeft();
            if (top != this.u || bottom != this.w || left != this.x || right != this.v) {
                a(c2.getDrawable());
                this.u = top;
                this.v = right;
                this.w = bottom;
                this.x = left;
            }
        }
    }

    public final void b(float f2, float f3, float f4) {
        if (d() < this.f59677d || f2 < 1.0f) {
            f fVar = this.k;
            if (fVar != null) {
                fVar.a(f2);
            }
            this.f59679f.postScale(f2, f2, f3, f4);
            g();
        }
    }

    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        RectF b2;
        c();
        if (this.f59681h != null && (b2 = b()) != null && b2.contains(motionEvent.getX(), motionEvent.getY())) {
            float f2 = b2.left;
            b2.width();
            float f3 = b2.top;
            b2.height();
            this.f59681h.a();
            return true;
        } else if (this.f59682i == null) {
            return false;
        } else {
            motionEvent.getX();
            motionEvent.getY();
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0075 A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouch(android.view.View r12, android.view.MotionEvent r13) {
        /*
            r11 = this;
            boolean r0 = r11.A
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0077
            r0 = r12
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            if (r0 == 0) goto L_0x0013
            android.graphics.drawable.Drawable r0 = r0.getDrawable()
            if (r0 == 0) goto L_0x0013
            r0 = 1
            goto L_0x0014
        L_0x0013:
            r0 = 0
        L_0x0014:
            if (r0 == 0) goto L_0x0077
            android.view.ViewParent r0 = r12.getParent()
            int r3 = r13.getAction()
            if (r3 == 0) goto L_0x0050
            if (r3 == r2) goto L_0x0026
            r4 = 3
            if (r3 == r4) goto L_0x0026
            goto L_0x0058
        L_0x0026:
            float r3 = r11.d()
            float r4 = r11.f59675b
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 >= 0) goto L_0x0058
            android.graphics.RectF r3 = r11.b()
            if (r3 == 0) goto L_0x0058
            net.one97.paytm.photoview.b$a r10 = new net.one97.paytm.photoview.b$a
            float r6 = r11.d()
            float r7 = r11.f59675b
            float r8 = r3.centerX()
            float r9 = r3.centerY()
            r4 = r10
            r5 = r11
            r4.<init>(r6, r7, r8, r9)
            r12.post(r10)
            r12 = 1
            goto L_0x0059
        L_0x0050:
            if (r0 == 0) goto L_0x0055
            r0.requestDisallowInterceptTouchEvent(r2)
        L_0x0055:
            r11.h()
        L_0x0058:
            r12 = 0
        L_0x0059:
            android.view.GestureDetector r3 = r11.o
            if (r3 == 0) goto L_0x0064
            boolean r3 = r3.onTouchEvent(r13)
            if (r3 == 0) goto L_0x0064
            r12 = 1
        L_0x0064:
            if (r12 != 0) goto L_0x006b
            if (r0 == 0) goto L_0x006b
            r0.requestDisallowInterceptTouchEvent(r1)
        L_0x006b:
            net.one97.paytm.photoview.a.d r0 = r11.p
            if (r0 == 0) goto L_0x0078
            boolean r13 = r0.c(r13)
            if (r13 == 0) goto L_0x0078
            r12 = 1
            goto L_0x0078
        L_0x0077:
            r12 = 0
        L_0x0078:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.photoview.b.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public final void a(float f2, boolean z2) {
        ImageView c2 = c();
        if (c2 != null) {
            a(f2, (float) (c2.getRight() / 2), (float) (c2.getBottom() / 2), z2);
        }
    }

    public final void a(float f2, float f3, float f4, boolean z2) {
        ImageView c2 = c();
        if (c2 != null && f2 >= this.f59675b && f2 <= this.f59677d) {
            if (z2) {
                c2.post(new a(d(), f2, f3, f4));
            } else {
                this.f59679f.setScale(f2, f2, f3, f4);
                g();
            }
            f fVar = this.k;
            if (fVar != null) {
                fVar.a(f2);
            }
        }
    }

    public final void a(boolean z2) {
        this.A = z2;
        e();
    }

    public final void e() {
        ImageView c2 = c();
        if (c2 == null) {
            return;
        }
        if (this.A) {
            a(c2);
            a(c2.getDrawable());
            return;
        }
        k();
    }

    /* access modifiers changed from: protected */
    public final Matrix f() {
        this.r.set(this.q);
        this.r.postConcat(this.f59679f);
        return this.r;
    }

    private void h() {
        C1152b bVar = this.y;
        if (bVar != null) {
            bVar.f59693a.b();
            this.y = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void g() {
        if (j()) {
            b(f());
        }
    }

    private void i() {
        ImageView c2 = c();
        if (c2 != null && !(c2 instanceof PhotoView) && !ImageView.ScaleType.MATRIX.equals(c2.getScaleType())) {
            throw new IllegalStateException("The ImageView's ScaleType has been changed since attaching a PhotoViewAttacher");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0083  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean j() {
        /*
            r12 = this;
            android.widget.ImageView r0 = r12.c()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            android.graphics.Matrix r2 = r12.f()
            android.graphics.RectF r2 = r12.a((android.graphics.Matrix) r2)
            if (r2 != 0) goto L_0x0013
            return r1
        L_0x0013:
            float r3 = r2.height()
            float r4 = r2.width()
            int r5 = c((android.widget.ImageView) r0)
            float r5 = (float) r5
            r6 = 1073741824(0x40000000, float:2.0)
            r7 = 3
            r8 = 2
            r9 = 0
            int r10 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r10 > 0) goto L_0x0045
            int[] r10 = net.one97.paytm.photoview.b.AnonymousClass2.f59684a
            android.widget.ImageView$ScaleType r11 = r12.l
            int r11 = r11.ordinal()
            r10 = r10[r11]
            if (r10 == r8) goto L_0x0042
            if (r10 == r7) goto L_0x003e
            float r5 = r5 - r3
            float r5 = r5 / r6
            float r3 = r2.top
        L_0x003b:
            float r3 = r5 - r3
            goto L_0x0059
        L_0x003e:
            float r5 = r5 - r3
            float r3 = r2.top
            goto L_0x003b
        L_0x0042:
            float r3 = r2.top
            goto L_0x004d
        L_0x0045:
            float r3 = r2.top
            int r3 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r3 <= 0) goto L_0x004f
            float r3 = r2.top
        L_0x004d:
            float r3 = -r3
            goto L_0x0059
        L_0x004f:
            float r3 = r2.bottom
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 >= 0) goto L_0x0058
            float r3 = r2.bottom
            goto L_0x003b
        L_0x0058:
            r3 = 0
        L_0x0059:
            int r0 = b((android.widget.ImageView) r0)
            float r0 = (float) r0
            r5 = 1
            int r10 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r10 > 0) goto L_0x0083
            int[] r1 = net.one97.paytm.photoview.b.AnonymousClass2.f59684a
            android.widget.ImageView$ScaleType r9 = r12.l
            int r9 = r9.ordinal()
            r1 = r1[r9]
            if (r1 == r8) goto L_0x007c
            if (r1 == r7) goto L_0x0078
            float r0 = r0 - r4
            float r0 = r0 / r6
            float r1 = r2.left
        L_0x0075:
            float r0 = r0 - r1
        L_0x0076:
            r9 = r0
            goto L_0x0080
        L_0x0078:
            float r0 = r0 - r4
            float r1 = r2.left
            goto L_0x0075
        L_0x007c:
            float r0 = r2.left
            float r0 = -r0
            goto L_0x0076
        L_0x0080:
            r12.z = r8
            goto L_0x009f
        L_0x0083:
            float r4 = r2.left
            int r4 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r4 <= 0) goto L_0x008f
            r12.z = r1
            float r0 = r2.left
            float r9 = -r0
            goto L_0x009f
        L_0x008f:
            float r1 = r2.right
            int r1 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r1 >= 0) goto L_0x009c
            float r1 = r2.right
            float r9 = r0 - r1
            r12.z = r5
            goto L_0x009f
        L_0x009c:
            r0 = -1
            r12.z = r0
        L_0x009f:
            android.graphics.Matrix r0 = r12.f59679f
            r0.postTranslate(r9, r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.photoview.b.j():boolean");
    }

    private RectF a(Matrix matrix) {
        Drawable drawable;
        ImageView c2 = c();
        if (c2 == null || (drawable = c2.getDrawable()) == null) {
            return null;
        }
        this.s.set(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
        matrix.mapRect(this.s);
        return this.s;
    }

    private float a(Matrix matrix, int i2) {
        matrix.getValues(this.t);
        return this.t[i2];
    }

    private void k() {
        this.f59679f.reset();
        b(f());
        j();
    }

    /* access modifiers changed from: private */
    public void b(Matrix matrix) {
        ImageView c2 = c();
        if (c2 != null) {
            i();
            c2.setImageMatrix(matrix);
            if (this.f59680g != null) {
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
            this.q.reset();
            float f2 = (float) intrinsicWidth;
            float f3 = b2 / f2;
            float f4 = (float) intrinsicHeight;
            float f5 = c3 / f4;
            if (this.l == ImageView.ScaleType.CENTER) {
                this.q.postTranslate((b2 - f2) / 2.0f, (c3 - f4) / 2.0f);
            } else if (this.l == ImageView.ScaleType.CENTER_CROP) {
                float max = Math.max(f3, f5);
                this.q.postScale(max, max);
                this.q.postTranslate((b2 - (f2 * max)) / 2.0f, (c3 - (f4 * max)) / 2.0f);
            } else if (this.l == ImageView.ScaleType.CENTER_INSIDE) {
                float min = Math.min(1.0f, Math.min(f3, f5));
                this.q.postScale(min, min);
                this.q.postTranslate((b2 - (f2 * min)) / 2.0f, (c3 - (f4 * min)) / 2.0f);
            } else {
                RectF rectF = new RectF(0.0f, 0.0f, f2, f4);
                RectF rectF2 = new RectF(0.0f, 0.0f, b2, c3);
                int i2 = AnonymousClass2.f59684a[this.l.ordinal()];
                if (i2 == 2) {
                    this.q.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                } else if (i2 == 3) {
                    this.q.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                } else if (i2 == 4) {
                    this.q.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
                } else if (i2 == 5) {
                    this.q.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
                }
            }
            k();
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
        private final float f59686b;

        /* renamed from: c  reason: collision with root package name */
        private final float f59687c;

        /* renamed from: d  reason: collision with root package name */
        private final long f59688d = System.currentTimeMillis();

        /* renamed from: e  reason: collision with root package name */
        private final float f59689e;

        /* renamed from: f  reason: collision with root package name */
        private final float f59690f;

        public a(float f2, float f3, float f4, float f5) {
            this.f59686b = f4;
            this.f59687c = f5;
            this.f59689e = f2;
            this.f59690f = f3;
        }

        public final void run() {
            ImageView c2 = b.this.c();
            if (c2 != null) {
                float interpolation = b.f59674a.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.f59688d)) * 1.0f) / 200.0f));
                float f2 = this.f59689e;
                float d2 = (f2 + ((this.f59690f - f2) * interpolation)) / b.this.d();
                b.this.f59679f.postScale(d2, d2, this.f59686b, this.f59687c);
                b.this.g();
                if (interpolation < 1.0f) {
                    a.a(c2, this);
                }
            }
        }
    }

    /* renamed from: net.one97.paytm.photoview.b$b  reason: collision with other inner class name */
    class C1152b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final d f59693a;

        /* renamed from: b  reason: collision with root package name */
        int f59694b;

        /* renamed from: c  reason: collision with root package name */
        int f59695c;

        public C1152b(Context context) {
            d dVar;
            if (Build.VERSION.SDK_INT < 9) {
                dVar = new c(context);
            } else if (Build.VERSION.SDK_INT < 14) {
                dVar = new a(context);
            } else {
                dVar = new net.one97.paytm.photoview.b.b(context);
            }
            this.f59693a = dVar;
        }

        public final void run() {
            ImageView c2;
            if (!this.f59693a.c() && (c2 = b.this.c()) != null && this.f59693a.a()) {
                int d2 = this.f59693a.d();
                int e2 = this.f59693a.e();
                b.this.f59679f.postTranslate((float) (this.f59694b - d2), (float) (this.f59695c - e2));
                b bVar = b.this;
                bVar.b(bVar.f());
                this.f59694b = d2;
                this.f59695c = e2;
                a.a(c2, this);
            }
        }
    }
}
